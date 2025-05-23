package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.oidb.ac.ArticleComment$GetPhotoCollectionInfoResponse;

/* loaded from: classes32.dex */
public class PublicAccountImageCollectionPreloadManagerImpl implements IPublicAccountImageCollectionPreloadManager {
    public static final int DELETETIME = 172800000;
    private static final int MAX_CACHE_SIZE = 30;
    private static String TAG = "PublicAccountImageCollectionPreloadManager";
    volatile boolean isProtoDoingWork;
    private IPublicAccountArticleObserver mObserver;
    private IPublicAccountArticleObserver mPublicAccountArticleObserver;
    Object lock = new Object();
    private List<String> workingList = new CopyOnWriteArrayList();
    private List<String> waitingList = new CopyOnWriteArrayList();
    private Object downloadTaskLock = new Object();
    public MQLruCache<String, IPublicAccountImageCollectionUtils.a> photoCollectionInfoCache = new MQLruCache<>(30);
    public HashMap<String, String> imgMap = new HashMap<>();
    int imageCollectionPreload = 0;
    int imageCollectionPreloadCover = 0;
    int imageCollectionPreloadImage = 0;
    Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class PreloadProtoThread implements Runnable {
        PreloadProtoThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = PublicAccountImageCollectionPreloadManagerImpl.this.workingList.iterator();
            while (it.hasNext()) {
                PublicAccountImageCollectionPreloadManagerImpl.this.loadPhotoCollectionInfo((String) it.next());
            }
            synchronized (PublicAccountImageCollectionPreloadManagerImpl.this.lock) {
                PublicAccountImageCollectionPreloadManagerImpl.this.workingList.clear();
                if (PublicAccountImageCollectionPreloadManagerImpl.this.waitingList.size() > 0) {
                    PublicAccountImageCollectionPreloadManagerImpl.this.startWork();
                } else {
                    PublicAccountImageCollectionPreloadManagerImpl.this.isProtoDoingWork = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class ReadFileThread implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f79796d;

        public ReadFileThread(String str) {
            this.f79796d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            try {
                FileInputStream fileInputStream = new FileInputStream(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD + this.f79796d);
                byte[] bArr = null;
                try {
                    bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    z16 = true;
                } catch (Exception unused) {
                    z16 = false;
                }
                fileInputStream.close();
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "preloadFileToCache");
                    }
                    ArticleComment$GetPhotoCollectionInfoResponse articleComment$GetPhotoCollectionInfoResponse = new ArticleComment$GetPhotoCollectionInfoResponse();
                    articleComment$GetPhotoCollectionInfoResponse.mergeFrom(bArr);
                    IPublicAccountImageCollectionUtils.a convertDataToPhotoCollectionInfo = PublicAccountImageCollectionPreloadManagerImpl.this.convertDataToPhotoCollectionInfo(articleComment$GetPhotoCollectionInfoResponse, this.f79796d);
                    PublicAccountImageCollectionPreloadManagerImpl.this.photoCollectionInfoCache.put((MQLruCache<String, IPublicAccountImageCollectionUtils.a>) this.f79796d, (String) convertDataToPhotoCollectionInfo);
                    PublicAccountImageCollectionPreloadManagerImpl.this.notifyUIToRefresh(convertDataToPhotoCollectionInfo);
                    PublicAccountImageCollectionPreloadManagerImpl.this.preloadImage(convertDataToPhotoCollectionInfo);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "read Exception " + e16);
                }
            }
        }
    }

    private boolean canPreloadImaga() {
        int networkType = NetworkState.getNetworkType();
        int i3 = this.imageCollectionPreloadCover;
        boolean z16 = true;
        if (i3 != 1 ? i3 != 2 || networkType != 1 : networkType != 1 && networkType != 4) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "canPreloadImage is " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPublicAccountImageCollectionUtils.a convertDataToPhotoCollectionInfo(ArticleComment$GetPhotoCollectionInfoResponse articleComment$GetPhotoCollectionInfoResponse, String str) {
        IPublicAccountImageCollectionUtils.a aVar = new IPublicAccountImageCollectionUtils.a();
        if (articleComment$GetPhotoCollectionInfoResponse.ret.has()) {
            if (articleComment$GetPhotoCollectionInfoResponse.article_share_url.has()) {
                aVar.f79734b = articleComment$GetPhotoCollectionInfoResponse.article_share_url.get().toStringUtf8();
            }
            if (articleComment$GetPhotoCollectionInfoResponse.puin.has()) {
                aVar.f79735c = articleComment$GetPhotoCollectionInfoResponse.puin.get() + "";
            }
            if (articleComment$GetPhotoCollectionInfoResponse.article_img_url.has()) {
                aVar.f79736d = articleComment$GetPhotoCollectionInfoResponse.article_img_url.get().toStringUtf8();
            }
            if (articleComment$GetPhotoCollectionInfoResponse.article_title.has()) {
                aVar.f79737e = articleComment$GetPhotoCollectionInfoResponse.article_title.get().toStringUtf8();
            }
            if (articleComment$GetPhotoCollectionInfoResponse.enable_comment.has()) {
                aVar.f79738f = articleComment$GetPhotoCollectionInfoResponse.enable_comment.get();
            }
            if (articleComment$GetPhotoCollectionInfoResponse.comment_url.has()) {
                aVar.f79739g = articleComment$GetPhotoCollectionInfoResponse.comment_url.get().toStringUtf8();
            }
            if (articleComment$GetPhotoCollectionInfoResponse.firstItem.has()) {
                IPublicAccountImageCollectionUtils.b bVar = new IPublicAccountImageCollectionUtils.b();
                aVar.f79740h = bVar;
                bVar.f79742a = articleComment$GetPhotoCollectionInfoResponse.firstItem.url.get().toStringUtf8();
                aVar.f79740h.f79745d = articleComment$GetPhotoCollectionInfoResponse.firstItem.photo_author_name.get().toStringUtf8();
                aVar.f79740h.f79744c = articleComment$GetPhotoCollectionInfoResponse.firstItem.photo_time.get().toStringUtf8();
                aVar.f79740h.f79743b = articleComment$GetPhotoCollectionInfoResponse.firstItem.publicaccount_name.get().toStringUtf8();
            }
            if (articleComment$GetPhotoCollectionInfoResponse.item.has() && articleComment$GetPhotoCollectionInfoResponse.item.get().size() > 0) {
                aVar.f79741i = new ArrayList<>();
                int size = articleComment$GetPhotoCollectionInfoResponse.item.get().size();
                for (int i3 = 0; i3 < size; i3++) {
                    IPublicAccountImageCollectionUtils.c cVar = new IPublicAccountImageCollectionUtils.c();
                    cVar.f79746a = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).url.get().toStringUtf8();
                    cVar.f79747b = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).content.get().toStringUtf8();
                    cVar.f79748c = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).static_url.get().toStringUtf8();
                    cVar.f79749d = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).width.get();
                    cVar.f79750e = articleComment$GetPhotoCollectionInfoResponse.item.get(i3).height.get();
                    aVar.f79741i.add(cVar);
                }
            }
            aVar.f79733a = str;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearAllCache$0() {
        MQLruCache<String, IPublicAccountImageCollectionUtils.a> mQLruCache = this.photoCollectionInfoCache;
        if (mQLruCache != null) {
            mQLruCache.releaseLargeCache();
        }
        FileUtils.delete(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD, false);
    }

    private void loadPhotoCollectionInfoFromServer(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadPhotoCollectionInfoFromServer articleId = " + str);
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        final IPublicAccountArticleHandler iPublicAccountArticleHandler = (IPublicAccountArticleHandler) ((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER);
        if (this.mPublicAccountArticleObserver == null) {
            IPublicAccountArticleObserver iPublicAccountArticleObserver = (IPublicAccountArticleObserver) QRoute.api(IPublicAccountArticleObserver.class);
            this.mPublicAccountArticleObserver = iPublicAccountArticleObserver;
            iPublicAccountArticleObserver.setOnCallback(new a(serverTimeMillis));
            iPublicAccountArticleHandler.setPublicAccountArticleObserver(this.mPublicAccountArticleObserver);
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                iPublicAccountArticleHandler.getPhotoCollectionInfo(str, "", 0, 1);
            }
        });
    }

    private void preloadFileToCache(String str) {
        ThreadManagerV2.executeOnFileThread(new ReadFileThread(str));
    }

    private void saveImageCollectionInfoToFile(final String str, final byte[] bArr) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    String str2 = AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD;
                    sb5.append(str2);
                    sb5.append(str);
                    String sb6 = sb5.toString();
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "saveImageCollectionInfoToFile fileName =" + sb6);
                    }
                    File file = new File(str2);
                    if (file.exists() || file.mkdirs()) {
                        File file2 = new File(sb6);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        boolean z16 = false;
                        FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
                        try {
                            fileOutputStream.write(bArr);
                            z16 = true;
                        } catch (Exception unused) {
                        }
                        if (z16 && QLog.isColorLevel()) {
                            QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "save ImageCollectionInfo write succ");
                        }
                        fileOutputStream.close();
                    }
                } catch (FileNotFoundException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "write file not found " + e16);
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "write Exception " + e17);
                    }
                }
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWork() {
        this.workingList.addAll(this.waitingList);
        this.waitingList.clear();
        this.isProtoDoingWork = true;
        preloadProto();
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void addTask(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "add Task articleID:" + str);
        }
        IPublicAccountImageCollectionUtils.a photoCollectionInfoFromCache = getPhotoCollectionInfoFromCache(str);
        if (photoCollectionInfoFromCache != null) {
            preloadImage(photoCollectionInfoFromCache);
            return;
        }
        synchronized (this.lock) {
            if (!this.waitingList.contains(str)) {
                this.waitingList.add(str);
                if (!this.isProtoDoingWork) {
                    startWork();
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public boolean canPreload() {
        boolean z16 = false;
        if (NetworkState.isNetSupport()) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + qQAppInterface.getCurrentAccountUin(), 0);
            this.imageCollectionPreload = sharedPreferences.getInt("album_predown_enable", 0);
            this.imageCollectionPreloadCover = sharedPreferences.getInt("album_predown_photo_rule", 0);
            this.imageCollectionPreloadImage = sharedPreferences.getInt("album_predown_slide_photocounts", 0);
            if (this.imageCollectionPreload == 1) {
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "canPreload is " + z16);
        }
        return z16;
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void cancelNotDownloadTask() {
        synchronized (this.downloadTaskLock) {
            this.waitingList.clear();
            this.workingList.clear();
            this.imgMap.clear();
        }
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void checkDelDir() {
        ThreadManagerV2.post(new BaseThread() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.6
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                MQLruCache<String, IPublicAccountImageCollectionUtils.a> mQLruCache = PublicAccountImageCollectionPreloadManagerImpl.this.photoCollectionInfoCache;
                if (mQLruCache != null) {
                    mQLruCache.releaseLargeCache();
                }
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD);
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (currentTimeMillis - file2.lastModified() > 172800000) {
                            file2.delete();
                        }
                    }
                }
            }
        }, 5, null, false);
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void clearAllCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                PublicAccountImageCollectionPreloadManagerImpl.this.lambda$clearAllCache$0();
            }
        }, 64, null, true);
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void doStatisticReportForImageHit(boolean z16, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("photo_index", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.PA_IIMAGE_COLLECTION_IMAGE_HIT, z16, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "\ndoStatisticReportForImageHit-->success = " + z16 + " ,photoIndex = " + i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void doStatisticReportForImageTime(boolean z16, long j3) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - j3;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.PA_IIMAGE_COLLECTION_IMAGE_TIME, z16, serverTimeMillis, 0L, null, "");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("\n");
            sb5.append("doStatisticReportForImageTime-->success = ");
            sb5.append(z16);
            sb5.append(" ,costTime = " + serverTimeMillis);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void doStatisticReportForProtoHit(boolean z16) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.PA_IIMAGE_COLLECTION_PROTO_HIT, z16, 0L, 0L, null, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "\ndoStatisticReportForProtoHit-->success = " + z16);
        }
    }

    public void doStatisticReportForProtoTime(boolean z16, long j3) {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - j3;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.PA_IIMAGE_COLLECTION_PROTO_TIME, z16, serverTimeMillis, 0L, null, "");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("\n");
            sb5.append("doStatisticReportForProtoTime-->success = ");
            sb5.append(z16);
            sb5.append(" ,costTime = " + serverTimeMillis);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public IPublicAccountImageCollectionUtils.a getPhotoCollectionInfoFromCache(String str) {
        IPublicAccountImageCollectionUtils.a aVar = this.photoCollectionInfoCache.get(str);
        if (aVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getPhotoCollectionInfoFromCache articleId =" + aVar.f79733a);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getPhotoCollectionInfoFromCache info is null");
        }
        return aVar;
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void getPhotoCollectionInfoFromFile(String str, IPublicAccountArticleObserver iPublicAccountArticleObserver) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getPhotoCollectionInfoFromFile");
        }
        this.mObserver = iPublicAccountArticleObserver;
        preloadFileToCache(str);
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public int getPreloadImageCount() {
        return this.imageCollectionPreloadImage;
    }

    void notifyUIToRefresh(final IPublicAccountImageCollectionUtils.a aVar) {
        this.mMainThreadHandler.post(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "notifyUIToRefresh articleId=" + aVar.f79733a);
                }
                if (PublicAccountImageCollectionPreloadManagerImpl.this.mObserver != null) {
                    PublicAccountImageCollectionPreloadManagerImpl.this.mObserver.onGetPhotoCollectionInfoRespond(aVar);
                }
                PublicAccountImageCollectionPreloadManagerImpl.this.mObserver = null;
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void preloadImage(IPublicAccountImageCollectionUtils.a aVar) {
        String str;
        if (canPreloadImaga()) {
            LinkedList linkedList = new LinkedList();
            if (this.imgMap.get(aVar.f79733a) == null) {
                synchronized (this.downloadTaskLock) {
                    IPublicAccountImageCollectionUtils.b bVar = aVar.f79740h;
                    if (bVar != null && (str = bVar.f79742a) != null && !TextUtils.isEmpty(str)) {
                        this.imgMap.put(aVar.f79733a, bVar.f79742a);
                        linkedList.add(bVar.f79742a);
                    }
                }
            }
            preloadImage(linkedList);
        }
    }

    public void preloadProto() {
        ThreadManagerV2.executeOnSubThread(new PreloadProtoThread());
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void saveImageCollectionInfo(IPublicAccountImageCollectionUtils.a aVar, byte[] bArr) {
        this.photoCollectionInfoCache.put((MQLruCache<String, IPublicAccountImageCollectionUtils.a>) aVar.f79733a, (String) aVar);
        saveImageCollectionInfoToFile(aVar.f79733a, bArr);
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void setObserver(IPublicAccountArticleObserver iPublicAccountArticleObserver) {
        this.mPublicAccountArticleObserver = iPublicAccountArticleObserver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends IPublicAccountArticleObserver.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f79797a;

        a(long j3) {
            this.f79797a = j3;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
        public void f(boolean z16, IPublicAccountImageCollectionUtils.a aVar, byte[] bArr, String str) {
            if (z16) {
                PublicAccountImageCollectionPreloadManagerImpl.this.doStatisticReportForProtoTime(true, this.f79797a);
                if (aVar != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "onGetPhotoCollectionInfoRespond isSuccess=" + z16 + " ;articleID = " + aVar.f79733a);
                    }
                    PublicAccountImageCollectionPreloadManagerImpl.this.saveImageCollectionInfo(aVar, bArr);
                    PublicAccountImageCollectionPreloadManagerImpl.this.preloadImage(aVar);
                    return;
                }
                return;
            }
            PublicAccountImageCollectionPreloadManagerImpl.this.doStatisticReportForProtoTime(false, this.f79797a);
        }
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager
    public void removeObserver() {
        this.mPublicAccountArticleObserver = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPhotoCollectionInfo(String str) {
        if (str == null) {
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD + str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadPhotoCollectionInfo file exist");
            }
            preloadFileToCache(str);
            return;
        }
        loadPhotoCollectionInfoFromServer(str);
    }

    private void preloadImage(final List<String> list) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                URL url;
                for (String str : list) {
                    if (str != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "preloadImage url= " + str);
                        }
                        try {
                            url = new URL(str);
                        } catch (MalformedURLException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(PublicAccountImageCollectionPreloadManagerImpl.TAG, 2, "getURLPath ERROR e = " + e16.getMessage());
                            }
                            url = null;
                        }
                        if (url != null) {
                            b bVar = new b();
                            bVar.f239004a = url;
                            ((IImageManager) QRoute.api(IImageManager.class)).loadImage(bVar, null);
                        }
                    }
                }
            }
        }, 5, null, true);
    }
}
