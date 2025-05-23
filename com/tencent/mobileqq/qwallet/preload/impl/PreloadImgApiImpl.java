package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadImgApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.utils.j;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes16.dex */
public class PreloadImgApiImpl implements IPreloadImgApi {
    private static final int MIN_LIMIT_FREE_SIZE = 20;
    private static final String PRELOAD_DIR_NAME = "/preload/";
    private static final String TAG = "PreloadImgApi";
    private static final String URL_LIST_CONFIG = "urlList.cfg";
    h mDownloaderInterface;
    private f mDownloadListener = new f() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.1
        @Override // com.tencent.mobileqq.vip.f
        public void onDone(final g gVar) {
            super.onDone(gVar);
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.1.1
                @Override // java.lang.Runnable
                public void run() {
                    int size = gVar.f313009g.size();
                    Bundle h16 = gVar.h();
                    for (int i3 = 0; i3 < size; i3++) {
                        String str = gVar.f313009g.get(i3);
                        PreloadImgApiImpl.this.loadBitmap(BaseApplication.getContext(), h16.getString(str), str);
                    }
                }
            });
        }
    };
    private Map<String, List<IPreloadImgApi.a>> mDownloadingCallbackMap = Collections.synchronizedMap(new HashMap(6));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements IPreloadService.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppInterface f279024a;

        a(AppInterface appInterface) {
            this.f279024a = appInterface;
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int i3, IPreloadService.PathResult pathResult) {
            List list = (List) PreloadImgApiImpl.this.mDownloadingCallbackMap.get(pathResult.url);
            if (pathResult.url.endsWith(".zip")) {
                PreloadImgApiImpl.this.imageZipDownBack(this.f279024a, pathResult.url, pathResult.folderPath, list);
            } else if (pathResult.url.endsWith(".png")) {
                PreloadImgApiImpl.this.imageDownBack(this.f279024a, pathResult.url, list);
            }
        }
    }

    private String getExternalSavePath(AppInterface appInterface) {
        return j.f279282a + appInterface.getCurrentAccountUin() + "/preload/";
    }

    private String getInternalSavePath(AppInterface appInterface) {
        return ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletInternalPath() + appInterface.getCurrentAccountUin() + "/preload/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imageDownBack(AppInterface appInterface, String str, List<IPreloadImgApi.a> list) {
        if (list != null && !list.isEmpty() && appInterface != null) {
            Drawable drawableForWallet = ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).getDrawableForWallet(com.tencent.mobileqq.qwallet.preload.a.n(str), BaseApplication.getContext().getApplicationContext().getResources().getDrawable(R.drawable.dzs), null);
            for (int i3 = 0; i3 < list.size(); i3++) {
                IPreloadImgApi.a aVar = list.get(i3);
                if (aVar != null) {
                    if (drawableForWallet != null) {
                        aVar.b(drawableForWallet);
                    } else {
                        aVar.a();
                    }
                }
            }
            this.mDownloadingCallbackMap.remove(str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "imageDownBack callback error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imageZipDownBack(AppInterface appInterface, String str, String str2, List<IPreloadImgApi.a> list) {
        boolean z16;
        if (list != null && !list.isEmpty()) {
            if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                z16 = true;
            } else {
                z16 = false;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                IPreloadImgApi.a aVar = list.get(i3);
                if (aVar != null) {
                    if (z16) {
                        aVar.b(str2);
                    } else {
                        aVar.a();
                    }
                }
            }
            this.mDownloadingCallbackMap.remove(str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "imageZipDownBack callback error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0088: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:137), block:B:47:0x0088 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a A[Catch: IOException -> 0x007d, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x007d, blocks: (B:20:0x0057, B:32:0x007a), top: B:6:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap loadBitmap(Context context, String str, String str2) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        BufferedInputStream bufferedInputStream3 = null;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                try {
                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    bufferedInputStream.close();
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int i3 = options.outWidth / displayMetrics.widthPixels;
                    int i16 = options.outHeight / displayMetrics.heightPixels;
                    if (i3 < i16) {
                        options.inSampleSize = i3;
                    } else {
                        options.inSampleSize = i16;
                    }
                    if (options.inSampleSize <= 0) {
                        options.inSampleSize = 1;
                    }
                    options.inJustDecodeBounds = false;
                    BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(str));
                    try {
                        bitmap = BitmapFactory.decodeStream(bufferedInputStream4, null, options);
                        bufferedInputStream4.close();
                    } catch (IOException e16) {
                        e = e16;
                        bufferedInputStream = bufferedInputStream4;
                        e = e;
                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (bitmap != null) {
                        }
                        return bitmap;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        bufferedInputStream = bufferedInputStream4;
                        e = e;
                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e);
                        if (bufferedInputStream != null) {
                        }
                        if (bitmap != null) {
                        }
                        return bitmap;
                    } catch (Throwable th5) {
                        bufferedInputStream3 = bufferedInputStream4;
                        th = th5;
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e18) {
                    e = e18;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                }
            } catch (IOException e26) {
                e = e26;
                bufferedInputStream = null;
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e);
                if (bufferedInputStream != null) {
                }
                if (bitmap != null) {
                }
                return bitmap;
            } catch (OutOfMemoryError e27) {
                e = e27;
                bufferedInputStream = null;
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e);
                if (bufferedInputStream != null) {
                }
                if (bitmap != null) {
                }
                return bitmap;
            } catch (Throwable th6) {
                th = th6;
            }
            if (bitmap != null) {
                ImageCacheHelper.f98636a.i(str2, bitmap, Business.AIO);
            }
            return bitmap;
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream3 = bufferedInputStream2;
        }
    }

    public void cancelAllDownload() {
        h hVar = this.mDownloaderInterface;
        if (hVar != null) {
            hVar.cancelTask(true, null);
        }
    }

    public void delete(AppInterface appInterface, String str, String str2) {
        if (str2 == null) {
            str2 = ".png";
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "delete url is empty return!!!");
                return;
            }
            return;
        }
        String externalSavePath = getExternalSavePath(appInterface);
        String internalSavePath = getInternalSavePath(appInterface);
        if (TextUtils.isEmpty(externalSavePath)) {
            externalSavePath = internalSavePath;
        }
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "\u5220\u9664\u6ca1\u7528\u7684\u56fe\u7247\u53ca\u7f13\u5b58url=" + str + " ,\u7f13\u5b58\u8def\u5f84: " + externalSavePath);
        }
        ImageCacheHelper.f98636a.m(str);
        File file = new File(externalSavePath, MD5.toMD5(str));
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
    public void download(AppInterface appInterface, String str, IPreloadImgApi.a aVar) {
        downloadWithSuffix(appInterface, str, ".png", aVar);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
    public void downloadWithSuffix(AppInterface appInterface, String str, String str2, IPreloadImgApi.a aVar) {
        if (str2 == null) {
            str2 = ".png";
        }
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            if (this.mDownloadingCallbackMap.containsKey(str)) {
                this.mDownloadingCallbackMap.get(str).add(aVar);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "url is already in download set return! ");
                    return;
                }
                return;
            }
            this.mDownloadingCallbackMap.put(str, new ArrayList(6));
            this.mDownloadingCallbackMap.get(str).add(aVar);
            ((IPreloadService) appInterface.getRuntimeService(IPreloadService.class, "")).getResPath(str, new a(appInterface));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "download AppInterface is null or url is emprty ");
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
    public Bitmap getBitmap(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.endsWith(".png")) {
            str = str + ".png";
        }
        Bitmap f16 = ImageCacheHelper.f98636a.f(str);
        if (f16 == null) {
            String md5 = MD5.toMD5(str);
            File file = new File(getExternalSavePath(appInterface), md5);
            if (!file.exists()) {
                file = new File(getInternalSavePath(appInterface), md5);
            }
            if (file.exists()) {
                appInterface.getApplication();
                return loadBitmap(BaseApplication.getContext(), file.getPath(), str);
            }
            return f16;
        }
        return f16;
    }

    public Bitmap getBitmapByTheme(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.endsWith(".png")) {
            str = str + ".png";
        }
        return ImageCacheHelper.f98636a.f(str);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
    public Drawable getDrawableByTheme(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.endsWith(".png")) {
            str = str + ".png";
        }
        Bitmap f16 = ImageCacheHelper.f98636a.f(str);
        if (f16 == null) {
            return null;
        }
        return new BitmapDrawable(appInterface.getApplicationContext().getResources(), f16);
    }

    public String getStorePath(AppInterface appInterface) {
        String externalSavePath = getExternalSavePath(appInterface);
        String internalSavePath = getInternalSavePath(appInterface);
        if (TextUtils.isEmpty(externalSavePath)) {
            return internalSavePath;
        }
        return externalSavePath;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
    public String getZipFolderPath(AppInterface appInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.endsWith(".zip")) {
            str = str + ".zip";
        }
        String p16 = com.tencent.mobileqq.qwallet.preload.a.p(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getZipBitmap zipName = " + p16);
        }
        return p16;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
    public void onDestory() {
        cancelAllDownload();
        Map<String, List<IPreloadImgApi.a>> map = this.mDownloadingCallbackMap;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadImgApi
    public void startDownload(AppInterface appInterface, Set<String> set) {
        if (set != null && !set.isEmpty()) {
            HashSet hashSet = new HashSet(set.size());
            for (String str : set) {
                if (!TextUtils.isEmpty(str) && !str.endsWith(".png") && !str.endsWith(".zip")) {
                    hashSet.add(str + ".png");
                }
            }
            if (hashSet.size() > 0) {
                startDownloadWithSurffix(appInterface, hashSet);
            }
        }
    }

    public void startDownloadWithSurffix(final AppInterface appInterface, final Set<String> set) {
        final String str;
        if (set != null && !set.isEmpty()) {
            this.mDownloaderInterface = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
            final HashMap hashMap = new HashMap();
            final ArrayList arrayList = new ArrayList();
            final String externalSavePath = getExternalSavePath(appInterface);
            final String internalSavePath = getInternalSavePath(appInterface);
            if (TextUtils.isEmpty(externalSavePath)) {
                str = internalSavePath;
            } else {
                str = externalSavePath;
            }
            final Bundle bundle = new Bundle();
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    for (String str2 : set) {
                        if (!TextUtils.isEmpty(str2)) {
                            String md5 = MD5.toMD5(str2);
                            File file = new File(externalSavePath, md5);
                            if (!file.exists()) {
                                file = new File(internalSavePath, md5);
                            }
                            if (!file.exists() || PreloadImgApiImpl.this.loadBitmap(appInterface.getApplication(), file.getPath(), str2) == null) {
                                arrayList.add(str2);
                                File file2 = new File(str, md5);
                                hashMap.put(str2, file2);
                                bundle.putString(str2, file2.getPath());
                            }
                        }
                    }
                }
            }, 8, new b(arrayList, hashMap, bundle), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements ThreadExcutor.IThreadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f279026d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f279027e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f279028f;

        b(List list, Map map, Bundle bundle) {
            this.f279026d = list;
            this.f279027e = map;
            this.f279028f = bundle;
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            if (!this.f279026d.isEmpty()) {
                g gVar = new g(this.f279026d, this.f279027e, UUID.randomUUID().toString());
                gVar.w(this.f279028f);
                PreloadImgApiImpl preloadImgApiImpl = PreloadImgApiImpl.this;
                h hVar = preloadImgApiImpl.mDownloaderInterface;
                if (hVar != null) {
                    hVar.startDownload(gVar, preloadImgApiImpl.mDownloadListener, null);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
        }
    }
}
