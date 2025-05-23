package com.tencent.mobileqq.listentogether.predownload;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.c;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ListenTogetherResDownloader implements com.tencent.mobileqq.listentogether.predownload.a {

    /* renamed from: f, reason: collision with root package name */
    private static File f241123f;

    /* renamed from: g, reason: collision with root package name */
    private static Comparator<File> f241124g = new a();

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f241125a;

    /* renamed from: b, reason: collision with root package name */
    private IHttpEngineService f241126b;

    /* renamed from: e, reason: collision with root package name */
    private INetEngineListener f241129e = new INetEngineListener() { // from class: com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2
        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(final NetResp netResp) {
            final boolean z16 = netResp.mResult == 0;
            HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
            File file = new File(httpNetReq.mOutPath);
            int i3 = netResp.mErrCode;
            String str = netResp.mErrDesc;
            if (str == null) {
                str = "0";
            }
            Object[] objArr = (Object[]) httpNetReq.getUserData();
            final MusicInfo musicInfo = (MusicInfo) objArr[0];
            b bVar = (b) objArr[1];
            if (z16) {
                bVar.f241138d = 2;
                ListenTogetherResDownloader.this.d(musicInfo.f240910d);
            } else {
                if (file.exists()) {
                    file.delete();
                }
                bVar.f241138d = 3;
                ListenTogetherResDownloader.this.h(musicInfo);
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("errCode", String.valueOf(netResp.mErrCode));
                    hashMap.put("result", String.valueOf(netResp.mResult));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_download_quality", z16, 0L, 0L, hashMap, "", false);
                    ((ListenTogetherManager) ListenTogetherResDownloader.this.f241125a.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).t1(musicInfo);
                }
            });
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", Integer.valueOf(i3), str, bVar));
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, List<b>> f241127c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, HttpNetReq> f241128d = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            if (file.lastModified() < file2.lastModified()) {
                return -1;
            }
            return file.lastModified() > file2.lastModified() ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f241135a;

        /* renamed from: b, reason: collision with root package name */
        public String f241136b;

        /* renamed from: c, reason: collision with root package name */
        public String f241137c;

        /* renamed from: d, reason: collision with root package name */
        public int f241138d;

        /* renamed from: e, reason: collision with root package name */
        public String f241139e;

        public b(String str, String str2) {
            this.f241135a = str;
            this.f241136b = str2;
            this.f241137c = MD5Utils.toMD5(str2);
            this.f241139e = ListenTogetherResDownloader.i(str);
        }

        public String toString() {
            return "MusicReqInfo{id='" + this.f241135a + "', url='" + this.f241136b + "', md5='" + this.f241137c + "', status=" + this.f241138d + ", cachePath='" + this.f241139e + "'}";
        }
    }

    public ListenTogetherResDownloader(QQAppInterface qQAppInterface) {
        this.f241125a = qQAppInterface;
        this.f241126b = (IHttpEngineService) qQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    }

    private synchronized void e() {
        this.f241127c.clear();
        Iterator<Map.Entry<String, HttpNetReq>> it = this.f241128d.entrySet().iterator();
        while (it.hasNext()) {
            HttpNetReq value = it.next().getValue();
            this.f241126b.cancelReq(value);
            if (value instanceof HttpNetReq) {
                HttpNetReq httpNetReq = value;
                if (QLog.isColorLevel()) {
                    QLog.d("ListenTogether.downloader", 2, String.format("cancelAllRequests, cancel req url: %s", httpNetReq.mReqUrl));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.downloader", 2, "cancelAllRequests...");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean f(int i3) {
        int i16;
        String i17 = i(QQMusicPlayService.G());
        File file = new File(com.tencent.mobileqq.listentogether.b.f240893a);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length < i3) {
                return true;
            }
            List asList = Arrays.asList(listFiles);
            Collections.sort(asList, f241124g);
            int size = (asList.size() - i3) + 1;
            if (size > asList.size()) {
                size = asList.size();
            }
            for (int i18 = 0; i18 < size; i18++) {
                File file2 = (File) asList.get(i18);
                if (!TextUtils.isEmpty(i17) && i17.equals(file2.getAbsolutePath())) {
                    QLog.d("ListenTogether.downloader", 1, "checkCacheStorage, " + i17 + " is playing...");
                } else {
                    file2.delete();
                    QLog.d("ListenTogether.downloader", 1, String.format("checkCacheStorage, del index: %s, file: %s", Integer.valueOf(i18), file2.getAbsolutePath()));
                }
            }
            if (file.listFiles() != null) {
                i16 = file.listFiles().length;
                if (QLog.isColorLevel()) {
                    QLog.d("ListenTogether.downloader", 2, String.format("checkCacheCount, %s / %s", Integer.valueOf(i16), Integer.valueOf(i3)));
                }
                return i16 >= i3;
            }
        }
        i16 = 0;
        if (QLog.isColorLevel()) {
        }
        if (i16 >= i3) {
        }
    }

    public static boolean g(String str) {
        return new File(i(str)).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(MusicInfo musicInfo) {
        boolean z16;
        if (musicInfo != null) {
            if (!TextUtils.isEmpty(musicInfo.f240910d)) {
                if (j(c.b().f240897b)) {
                    int i3 = c.b().f240896a;
                    if (i3 <= 0) {
                        QLog.d("ListenTogether.downloader", 2, String.format("download, maxCacheCount <= 0: %s", Integer.valueOf(i3)));
                        e();
                        k();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ListenTogether.downloader", 2, String.format("download, musicId: %s", musicInfo.f240910d));
                    }
                    if (g(musicInfo.f240910d)) {
                        QLog.d("ListenTogether.downloader", 1, "download, cache file is exist");
                        return;
                    }
                    List<b> list = this.f241127c.get(musicInfo.f240910d);
                    if (list == null) {
                        List<String> list2 = musicInfo.f240914i;
                        if (list2 != null && list2.size() > 0) {
                            list = new ArrayList<>();
                            for (String str : musicInfo.f240914i) {
                                if (!TextUtils.isEmpty(str)) {
                                    list.add(new b(musicInfo.f240910d, str));
                                }
                            }
                        }
                        if (list != null && list.size() != 0) {
                            this.f241127c.put(musicInfo.f240910d, list);
                        }
                        QLog.d("ListenTogether.downloader", 1, "musicReqInfoList is empty!, " + musicInfo);
                        return;
                    }
                    b bVar = null;
                    if (list.size() > 0) {
                        for (b bVar2 : list) {
                            int i16 = bVar2.f241138d;
                            if (i16 == 1) {
                                z16 = true;
                                break;
                            } else if (i16 == 0 && bVar == null) {
                                bVar = bVar2;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16 && bVar != null) {
                        if (!f(i3)) {
                            QLog.d("ListenTogether.downloader", 1, "download, over cache count");
                            return;
                        }
                        HttpNetReq httpNetReq = new HttpNetReq();
                        httpNetReq.mCallback = this.f241129e;
                        httpNetReq.mReqUrl = bVar.f241136b;
                        httpNetReq.mHttpMethod = 0;
                        httpNetReq.mOutPath = bVar.f241139e;
                        httpNetReq.mPrioty = 1;
                        httpNetReq.setUserData(new Object[]{musicInfo, bVar});
                        httpNetReq.mSupportBreakResume = true;
                        this.f241126b.sendReq(httpNetReq);
                        bVar.f241138d = 1;
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ListenTogether.downloader", 2, String.format("musicReqInfo not found, isDownloading: %s", Boolean.valueOf(z16)));
                    }
                    return;
                }
                return;
            }
        }
        QLog.d("ListenTogether.downloader", 1, "musicInfo or id is empty");
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (f241123f == null) {
            File file = new File(com.tencent.mobileqq.listentogether.b.f240893a);
            f241123f = file;
            QLog.d("ListenTogether.downloader", 1, "init getCacheFilePath=", file);
        }
        if (!f241123f.exists()) {
            QLog.d("ListenTogether.downloader", 1, "mkdir cache dir, result: " + f241123f.mkdir());
        }
        return new File(com.tencent.mobileqq.listentogether.b.f240893a, MD5Utils.toMD5(str)).getAbsolutePath();
    }

    private boolean j(int i3) {
        int b16 = com.tencent.mqpsdk.util.a.b(BaseApplication.getContext());
        boolean z16 = i3 == 0 || (i3 != 1 ? !(i3 != 2 ? i3 != 3 ? !(i3 == 4 && (b16 == 1 || b16 == 4 || b16 == 3 || b16 == 2)) : !(b16 == 1 || b16 == 4 || b16 == 3) : !(b16 == 1 || b16 == 4)) : b16 == 1);
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.downloader", 2, String.format("netTypeNeedDownload, requestNetType: %s, netType: %s, needDownload: %s", Integer.valueOf(i3), Integer.valueOf(b16), Boolean.valueOf(z16)));
        }
        return z16;
    }

    public static void k() {
        File[] listFiles;
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(com.tencent.mobileqq.listentogether.b.f240893a);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    String i3 = i(QQMusicPlayService.G());
                    String absolutePath = file2.getAbsolutePath();
                    if (!TextUtils.isEmpty(i3) && i3.equals(absolutePath)) {
                        QLog.d("ListenTogether.downloader", 1, String.format("removeAllCacheFiles, %s is playing", absolutePath));
                    } else {
                        file2.delete();
                    }
                }
            }
        }
        QLog.d("ListenTogether.downloader", 1, "removeAllCacheFiles, costTime: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public synchronized void d(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("ListenTogether.downloader", 1, "musicId is empty");
            return;
        }
        HttpNetReq remove = this.f241128d.remove(str);
        if (remove != null) {
            this.f241126b.cancelReq(remove);
        }
        this.f241127c.remove(str);
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.downloader", 2, "cancel music id: " + str);
        }
    }

    @Override // com.tencent.mobileqq.listentogether.predownload.a
    public void destroy() {
        e();
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.downloader", 2, "destroy");
        }
    }

    @Override // com.tencent.mobileqq.listentogether.predownload.a
    public void a(List<MusicInfo> list) {
        if (list != null && list.size() != 0) {
            Iterator<MusicInfo> it = list.iterator();
            while (it.hasNext()) {
                h(it.next());
            }
            return;
        }
        QLog.d("ListenTogether.downloader", 1, "downloadMusicRes, musicList is empty!");
    }
}
