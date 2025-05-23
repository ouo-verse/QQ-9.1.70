package com.qzone.feed.business.service;

import NS_MOBILE_USERLOGO_TIMESTAMP.mobile_get_rc_tab_rsp;
import NS_MOBILE_USERLOGO_TIMESTAMP.s_rc_tab_list;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.feed.business.model.e;
import com.qzone.feed.business.protocol.QZoneRapidCommentRequest;
import com.qzone.misc.network.downloader.FileDownloaderManager;
import com.qzone.util.al;
import com.qzone.widget.u;
import com.qzone.widget.v;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneRapidCommentService implements IQZoneServiceListener {
    private static final String L = QZoneRapidCommentService.class.toString();
    public static final int M = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.NEED_TO_CHANGE_FOR_RAPID_COMMENT, 1);
    public static final int N = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.DOWNLOAD_TO_DEFAULT_TAB, 6);
    private static final al<QZoneRapidCommentService, Void> P = new a();
    private Downloader C;
    private v D;
    private int E;
    private int H;
    private int I;

    /* renamed from: f, reason: collision with root package name */
    private Set<String> f47199f;

    /* renamed from: m, reason: collision with root package name */
    private String f47202m;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Long, Boolean> f47197d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, u> f47198e = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final d f47200h = new d("rapid_comment_summary", v.class);

    /* renamed from: i, reason: collision with root package name */
    private final d f47201i = new d("rapid_comment_info", u.class);
    private String[] F = {u.COLUMN_OLD_MD5, u.COLUMN_NEW_MD5};
    private String[] G = new String[2];
    NetworkState.NetworkStateListener J = new b();
    Downloader.DownloadListener K = new c();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QZoneRapidCommentService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneRapidCommentService a(Void r16) {
            return new QZoneRapidCommentService();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements NetworkState.NetworkStateListener {
        b() {
        }

        @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
        public void onNetworkConnect(boolean z16) {
            if (NetworkState.isWifiConn()) {
                return;
            }
            QZoneRapidCommentService.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        long f47209a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f47210b;

        /* renamed from: c, reason: collision with root package name */
        String f47211c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f47212d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f47213e = new a();

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                d dVar = d.this;
                dVar.f47209a = 0L;
                dVar.f47210b = null;
                QZoneRapidCommentService.this.o();
            }
        }

        public d(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f47211c = str;
            this.f47212d = cls;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(u uVar) {
        File file;
        long j3 = uVar.rcTabId;
        String s16 = s(j3);
        try {
            try {
                ZipUtils.unZipFolder(s16, r());
                this.f47197d.put(Long.valueOf(j3), Boolean.TRUE);
                uVar.oldMd5 = uVar.newMd5;
                M(uVar);
                file = new File(s16);
            } catch (Exception e16) {
                QZLog.w(L, "unzipTofolder", e16);
                file = new File(s16);
            }
            file.delete();
        } catch (Throwable th5) {
            new File(s16).delete();
            throw th5;
        }
    }

    private String r() {
        if (!TextUtils.isEmpty(this.f47202m)) {
            return this.f47202m + File.separator;
        }
        this.f47202m = CacheManager.getRapidCommentDir();
        File file = new File(this.f47202m);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return this.f47202m + File.separator;
    }

    private String s(long j3) {
        return r() + j3 + ".zip";
    }

    public static QZoneRapidCommentService v() {
        return P.get(null);
    }

    private String y(long j3) {
        v vVar = this.D;
        if (vVar == null || vVar.rapidCommentUrl == null || vVar.rcZipName == null) {
            return null;
        }
        return String.format(this.D.rapidCommentUrl + "%d/%d.zip", Long.valueOf(j3), Long.valueOf(j3));
    }

    private String z(long j3) {
        return "sp_key_tab_md5_pre_" + j3;
    }

    public boolean A(long j3) {
        Boolean bool = this.f47197d.get(Long.valueOf(j3));
        if (bool == null) {
            bool = Boolean.valueOf(new File(t(j3) + "48.png").exists());
            this.f47197d.put(Long.valueOf(j3), bool);
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(L, 2, "isTabMayDownloaded, tabId=" + j3 + ", isDownloaded=" + bool);
        }
        return bool.booleanValue();
    }

    public long E(int i3) {
        DbCacheManager dbCacheManager;
        this.E = i3;
        q(this.f47200h, true);
        q(this.f47201i, true);
        d dVar = this.f47200h;
        if (dVar != null && (dbCacheManager = dVar.f47210b) != null && dbCacheManager.e0() != 0) {
            return u5.b.I("rc_last_request_timestamp", 0L);
        }
        u5.b.s0("rc_last_request_timestamp", 0L);
        return 0L;
    }

    public void H(int i3) {
        this.E = i3;
    }

    public void I() {
        Set<String> set = this.f47199f;
        if (set == null || this.C == null || this.K == null) {
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            this.C.abort(it.next(), this.K);
        }
        this.f47199f.clear();
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 1000) {
            return;
        }
        C(qZoneTask);
    }

    public String t(long j3) {
        return r() + j3 + File.separator;
    }

    public String u(long j3) {
        return t(j3) + "48.png";
    }

    public void w(final Handler handler, int i3) {
        this.E = i3;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.feed.business.service.QZoneRapidCommentService.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneRapidCommentService qZoneRapidCommentService = QZoneRapidCommentService.this;
                qZoneRapidCommentService.q(qZoneRapidCommentService.f47200h, true);
                QZoneRapidCommentService qZoneRapidCommentService2 = QZoneRapidCommentService.this;
                qZoneRapidCommentService2.q(qZoneRapidCommentService2.f47201i, true);
                long j3 = 0;
                if (QZoneRapidCommentService.this.f47200h != null && QZoneRapidCommentService.this.f47200h.f47210b != null && QZoneRapidCommentService.this.f47200h.f47210b.e0() != 0) {
                    j3 = u5.b.I("rc_last_request_timestamp", 0L);
                } else {
                    u5.b.s0("rc_last_request_timestamp", 0L);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QZoneRapidCommentService.L, 2, "getRapidComment");
                }
                QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneRapidCommentRequest(j3), handler, QZoneRapidCommentService.this, 1000));
            }
        });
    }

    public v x() {
        v vVar = this.D;
        if (vVar != null) {
            return vVar;
        }
        synchronized (this.f47200h) {
            q(this.f47200h, true);
            q(this.f47201i, true);
            v vVar2 = (v) this.f47200h.f47210b.k0("1==1", null);
            if (vVar2 == null) {
                return null;
            }
            ArrayList g06 = this.f47201i.f47210b.g0();
            if (vVar2.rcTabNum != g06.size()) {
                QZLog.w(L, "rc tab num mismatch");
                return null;
            }
            vVar2.rapidCommentTabInfoList = g06;
            return vVar2;
        }
    }

    private void F(v vVar) {
        if (vVar != null) {
            synchronized (this.f47200h) {
                q(this.f47200h, true);
                q(this.f47201i, true);
                this.f47200h.f47210b.o0(vVar, 2);
                this.f47201i.f47210b.W();
                Iterator<u> it = vVar.rapidCommentTabInfoList.iterator();
                while (it.hasNext()) {
                    this.f47201i.f47210b.o0(it.next(), 1);
                }
            }
        }
    }

    private void M(u uVar) {
        if (uVar == null || this.F == null || this.G == null) {
            return;
        }
        synchronized (this.f47201i) {
            q(this.f47201i, true);
            String[] strArr = this.G;
            strArr[0] = uVar.oldMd5;
            strArr[1] = uVar.newMd5;
            this.f47201i.f47210b.w0(this.F, strArr, "tab_id=" + uVar.rcTabId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(v vVar, boolean z16) {
        ArrayList<u> arrayList;
        if (vVar == null || (arrayList = vVar.rapidCommentTabInfoList) == null) {
            return;
        }
        Iterator<u> it = arrayList.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (B(next, z16)) {
                p(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ArrayList<u> arrayList, boolean z16) {
        if (arrayList != null) {
            int size = arrayList.size();
            this.H = 0;
            this.I = size;
            for (int i3 = 0; i3 < size; i3++) {
                u uVar = arrayList.get(i3);
                if (B(uVar, z16)) {
                    this.H++;
                    p(uVar);
                } else {
                    int i16 = this.I - 1;
                    this.I = i16;
                    if (this.H == i16) {
                        e.c().d();
                    }
                }
            }
        }
    }

    public void J(v vVar, final boolean z16) {
        ArrayList<u> arrayList;
        if (vVar != null && vVar.rapidCommentTabInfoList != null) {
            v x16 = x();
            this.D = x16;
            if (x16 != null && (arrayList = x16.rapidCommentTabInfoList) != null) {
                Iterator<u> it = arrayList.iterator();
                while (it.hasNext()) {
                    u next = it.next();
                    Iterator<u> it5 = vVar.rapidCommentTabInfoList.iterator();
                    while (it5.hasNext()) {
                        u next2 = it5.next();
                        if (next.rcTabId == next2.rcTabId) {
                            next2.oldMd5 = next.oldMd5;
                        }
                    }
                }
            } else {
                Iterator<u> it6 = vVar.rapidCommentTabInfoList.iterator();
                while (it6.hasNext()) {
                    u next3 = it6.next();
                    String h06 = u5.b.h0(z(next3.rcTabId), "");
                    if (QZLog.isColorLevel()) {
                        QZLog.d(L, 2, "get key from sp, key=" + h06);
                    }
                    next3.oldMd5 = h06;
                }
            }
            HashMap hashMap = new HashMap();
            Iterator<u> it7 = vVar.rapidCommentTabInfoList.iterator();
            while (it7.hasNext()) {
                u next4 = it7.next();
                if (QZLog.isColorLevel()) {
                    QZLog.d(L, 2, "put key to sp, key=" + next4.newMd5);
                }
                hashMap.put(z(next4.rcTabId), next4.newMd5);
            }
            u5.b.y0(hashMap);
            this.D = vVar;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.feed.business.service.QZoneRapidCommentService.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneRapidCommentService qZoneRapidCommentService = QZoneRapidCommentService.this;
                    qZoneRapidCommentService.m(qZoneRapidCommentService.D, z16);
                }
            });
            return;
        }
        QZLog.w(L, "rapid comment data is null");
    }

    private void p(u uVar) {
        if (uVar == null) {
            return;
        }
        long j3 = uVar.rcTabId;
        if (this.C == null) {
            this.C = FileDownloaderManager.g().getDownloader();
            NetworkState.addListener(this.J);
        }
        String y16 = y(j3);
        if (y16 == null) {
            return;
        }
        this.f47198e.put(y16, uVar);
        this.C.download(y16, s(j3), this.K);
        if (this.f47199f == null) {
            this.f47199f = new CopyOnWriteArraySet();
        }
        this.f47199f.add(y16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(d dVar, boolean z16) {
        DbCacheManager dbCacheManager;
        if (dVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (z16) {
            uin = 0;
        }
        if (uin != dVar.f47209a || (dbCacheManager = dVar.f47210b) == null || dbCacheManager.isClosed()) {
            dVar.f47209a = uin;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(dVar.f47212d, uin, dVar.f47211c);
            dVar.f47210b = e16;
            e16.U(dVar.f47213e);
        }
    }

    public void D(s_rc_tab_list s_rc_tab_listVar) {
        ArrayList<u> arrayList;
        if (s_rc_tab_listVar == null) {
            return;
        }
        v createFromResponse = v.createFromResponse(s_rc_tab_listVar);
        if (M == 1 && createFromResponse != null && (arrayList = createFromResponse.rapidCommentTabInfoList) != null) {
            Iterator<u> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3++;
                if (s_rc_tab_listVar.start_id == it.next().rcTabId) {
                    break;
                }
            }
            e.c().f47156a = false;
            e c16 = e.c();
            Objects.requireNonNull(c16);
            e.c().b(new e.a(createFromResponse, true, true, i3 - 1));
            e.c().g();
        } else {
            J(createFromResponse, false);
        }
        F(createFromResponse);
        if (createFromResponse != null) {
            SharedPreferences.Editor O = u5.b.O();
            O.putLong("rc_last_request_timestamp", System.currentTimeMillis());
            long j3 = s_rc_tab_listVar.start_id;
            if (j3 != 0 && u5.b.I("recom_tab_id", 0L) != j3) {
                O.putLong("recom_tab_id", j3);
            }
            O.commit();
        }
    }

    private void C(QZoneTask qZoneTask) {
        mobile_get_rc_tab_rsp mobile_get_rc_tab_rspVar;
        if (QLog.isColorLevel()) {
            QLog.d(L, 2, "onGetRapidComment");
        }
        QZoneResult result = qZoneTask.getResult(1000093);
        if (qZoneTask.succeeded()) {
            mobile_get_rc_tab_rsp mobile_get_rc_tab_rspVar2 = (mobile_get_rc_tab_rsp) qZoneTask.mRequest.rsp;
            if (mobile_get_rc_tab_rspVar2 != null) {
                v createFromResponse = v.createFromResponse(mobile_get_rc_tab_rspVar2.rc_data);
                if (M == 1) {
                    if (createFromResponse != null && mobile_get_rc_tab_rspVar2.rc_data != null) {
                        Iterator<u> it = createFromResponse.rapidCommentTabInfoList.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                mobile_get_rc_tab_rspVar = mobile_get_rc_tab_rspVar2;
                                break;
                            }
                            i3++;
                            mobile_get_rc_tab_rspVar = mobile_get_rc_tab_rspVar2;
                            if (mobile_get_rc_tab_rspVar2.rc_data.start_id == it.next().rcTabId) {
                                break;
                            } else {
                                mobile_get_rc_tab_rspVar2 = mobile_get_rc_tab_rspVar;
                            }
                        }
                        int i16 = N;
                        if (i3 > i16) {
                            i16 = i3;
                        }
                        e.c().f47156a = false;
                        e c16 = e.c();
                        Objects.requireNonNull(c16);
                        e.c().b(new e.a(createFromResponse, true, false, i16));
                        e.c().g();
                        result.setData(createFromResponse);
                        F(createFromResponse);
                        u5.b.s0("rc_last_request_timestamp", System.currentTimeMillis());
                        mobile_get_rc_tab_rsp mobile_get_rc_tab_rspVar3 = mobile_get_rc_tab_rspVar;
                        G(mobile_get_rc_tab_rspVar3.rc_data.start_id);
                        u5.b.q0("hasLoadRapidCommentNum", i16);
                        QZLog.i(L, "the recomment tab is " + mobile_get_rc_tab_rspVar3.rc_data.start_id);
                    }
                } else {
                    J(createFromResponse, true);
                    result.setData(createFromResponse);
                    F(createFromResponse);
                    if (createFromResponse != null) {
                        u5.b.s0("rc_last_request_timestamp", System.currentTimeMillis());
                        G(mobile_get_rc_tab_rspVar2.rc_data.start_id);
                    }
                }
            }
            result.setSucceed(true);
            if (QLog.isColorLevel()) {
                QLog.d(L, 2, "onGetRapidComment success");
            }
        } else {
            result.setSucceed(false);
            QZLog.e(QZLog.TO_DEVICE_TAG, L + ", onGetRapidComment failed: " + qZoneTask.mResultCode);
        }
        qZoneTask.sendResultMsg(result);
    }

    public boolean B(u uVar, boolean z16) {
        if (uVar == null) {
            return false;
        }
        boolean isWifiConn = NetworkState.isWifiConn();
        boolean A = A(uVar.rcTabId);
        boolean equals = uVar.oldMd5.equals(uVar.newMd5);
        boolean z17 = isWifiConn || this.E == 1;
        if (QZLog.isColorLevel()) {
            QZLog.d(L, 2, "tabId=" + uVar.rcTabId + ", isWifi=" + isWifiConn + ", isTabDownloaded=" + A + ", isMD5Match=" + equals + ", pre=" + z17 + ", forceDownload=" + z16);
        }
        if (z17) {
            return !A || (!equals && z16);
        }
        return false;
    }

    private void G(long j3) {
        if (j3 == 0 || u5.b.I("recom_tab_id", 0L) == j3) {
            return;
        }
        u5.b.s0("recom_tab_id", j3);
    }

    public void K(v vVar, final ArrayList<u> arrayList, final boolean z16) {
        ArrayList<u> arrayList2;
        if (vVar != null && arrayList != null) {
            v x16 = x();
            this.D = x16;
            if (x16 != null && (arrayList2 = x16.rapidCommentTabInfoList) != null) {
                Iterator<u> it = arrayList2.iterator();
                while (it.hasNext()) {
                    u next = it.next();
                    Iterator<u> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        u next2 = it5.next();
                        if (next.rcTabId == next2.rcTabId) {
                            next2.oldMd5 = next.oldMd5;
                        }
                    }
                }
            } else {
                Iterator<u> it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    u next3 = it6.next();
                    String h06 = u5.b.h0(z(next3.rcTabId), "");
                    if (QZLog.isColorLevel()) {
                        QZLog.d(L, 2, "get key from sp, key=" + h06);
                    }
                    next3.oldMd5 = h06;
                }
            }
            HashMap hashMap = new HashMap();
            Iterator<u> it7 = arrayList.iterator();
            while (it7.hasNext()) {
                u next4 = it7.next();
                if (QZLog.isColorLevel()) {
                    QZLog.d(L, 2, "put key to sp, key=" + next4.newMd5);
                }
                hashMap.put(z(next4.rcTabId), next4.newMd5);
            }
            u5.b.y0(hashMap);
            this.D = vVar;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.feed.business.service.QZoneRapidCommentService.4
                @Override // java.lang.Runnable
                public void run() {
                    QZoneRapidCommentService.this.n(arrayList, z16);
                }
            });
            return;
        }
        QZLog.w(L, "rapid comment data is null");
        e.c().d();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements Downloader.DownloadListener {
        c() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            if (QZoneRapidCommentService.this.H == QZoneRapidCommentService.this.I) {
                e.c().d();
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            if (QZoneRapidCommentService.this.H == QZoneRapidCommentService.this.I) {
                e.c().d();
            }
            u uVar = (u) QZoneRapidCommentService.this.f47198e.get(str);
            if (uVar != null) {
                QZoneRapidCommentService.this.L(uVar);
            }
            if (QZoneRapidCommentService.this.f47199f != null) {
                QZoneRapidCommentService.this.f47199f.remove(str);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }

    public void o() {
    }
}
