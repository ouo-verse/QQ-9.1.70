package com.qzone.personalize.music.business;

import NS_BG_VOICE_LOGIC_APP.BGFM;
import NS_BG_VOICE_LOGIC_APP.BGMusic;
import NS_BG_VOICE_LOGIC_APP.BGVoice;
import NS_BG_VOICE_LOGIC_APP.tGetBGVoiceWebappRsp;
import NS_MOBILE_MUSIC.GetMusicListRsp;
import NS_NEXTRADIO_QZONEBGMUSIC.BGMusicForQzone;
import NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone;
import NS_QZONE_BG_MUSIC.MusicInfo;
import NS_QZONE_BG_MUSIC.tGetMusicInfoRsp;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.music.request.GetBGVoiceUrlWithMidRequest;
import com.qzone.personalize.music.request.GetBGVoiceWebappRequest;
import com.qzone.personalize.music.request.QzoneGetMusicListRequest;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.qzone.personalize.music.ui.HomepageMusicPlayerBar;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.open.base.MD5Utils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.music.IQzoneMusicHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.BaseHandler;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import e8.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QusicService {

    /* renamed from: o, reason: collision with root package name */
    private static long f49322o = -1;

    /* renamed from: p, reason: collision with root package name */
    private static Object f49323p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static QusicService f49324q;

    /* renamed from: f, reason: collision with root package name */
    private j f49330f;

    /* renamed from: m, reason: collision with root package name */
    public SongInfo[] f49337m;

    /* renamed from: n, reason: collision with root package name */
    private BaseHandler f49338n;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f49325a = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    private Object f49332h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private SongInfo f49333i = null;

    /* renamed from: j, reason: collision with root package name */
    private boolean f49334j = false;

    /* renamed from: k, reason: collision with root package name */
    public HashMap<String, String> f49335k = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    public HashMap<String, Long> f49336l = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private LinkedHashMap<Long, SongInfo> f49326b = new LinkedHashMap<>(150);

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<WeakReference<e8.e>> f49327c = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private j f49329e = new j();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<WeakReference<e8.a>> f49328d = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private QQMusicWrap f49331g = new QQMusicWrap(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements IQZoneServiceListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f49350d;

        b(long j3) {
            this.f49350d = j3;
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            if (qZoneTask.mResultCode != 0) {
                QZLog.w("QusicService", "pullBackgroundMusicList ret:" + qZoneTask.mResultCode + ",msg=" + qZoneTask.f45835msg);
                return;
            }
            JceStruct jceStruct = qZoneTask.mRequest.rsp;
            if (jceStruct != null && (jceStruct instanceof tGetBGVoiceWebappRsp)) {
                tGetBGVoiceWebappRsp tgetbgvoicewebapprsp = (tGetBGVoiceWebappRsp) jceStruct;
                if (tgetbgvoicewebapprsp.iRet != 0) {
                    QZLog.w("QusicService", "pullBackgroundMusicList rsp ret=" + tgetbgvoicewebapprsp.iRet + ",msg=" + tgetbgvoicewebapprsp.strErrMsg);
                    return;
                }
                QZLog.i("QusicService", "pullBackgroundMusicList rsp succ");
                if (QusicService.this.z0(tgetbgvoicewebapprsp, this.f49350d)) {
                    QusicService.this.c0(QusicService.this.M(), true);
                }
                QusicService.this.b0(this.f49350d, tgetbgvoicewebapprsp);
                return;
            }
            QZLog.w("QusicService", "pullBackgroundMusicList rsp is not tGetBGVoiceWebappRsp object.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements IQZoneServiceListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f49352d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f49353e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f49354f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ SongInfo[] f49355h;

        c(boolean z16, int i3, boolean z17, SongInfo[] songInfoArr) {
            this.f49352d = z16;
            this.f49353e = i3;
            this.f49354f = z17;
            this.f49355h = songInfoArr;
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            QZoneRequest qZoneRequest;
            MusicInfo musicInfo;
            if (qZoneTask == null || qZoneTask.mResultCode != 0 || (qZoneRequest = qZoneTask.mRequest) == null) {
                if (qZoneTask != null) {
                    QZLog.w("QusicService", "pullSongUrlWithIdFromBackGround Failed , resuleCode:" + qZoneTask.mResultCode + " errorMsg:" + qZoneTask.f45835msg);
                    return;
                }
                return;
            }
            JceStruct jceStruct = qZoneRequest.rsp;
            if (jceStruct != null && (jceStruct instanceof tGetMusicInfoRsp)) {
                tGetMusicInfoRsp tgetmusicinforsp = (tGetMusicInfoRsp) jceStruct;
                Map<String, MusicInfo> map = tgetmusicinforsp.mapMusic;
                if (map == null || map.isEmpty()) {
                    return;
                }
                QZLog.i("QusicService", "pullSongUrlWithIdFromBackGround rsp succ");
                QusicService qusicService = QusicService.this;
                if (qusicService.f49335k == null) {
                    qusicService.f49335k = new HashMap<>();
                }
                QusicService qusicService2 = QusicService.this;
                if (qusicService2.f49336l == null) {
                    qusicService2.f49336l = new HashMap<>();
                }
                for (String str : tgetmusicinforsp.mapMusic.keySet()) {
                    if (tgetmusicinforsp.mapMusic.containsKey(str) && (musicInfo = tgetmusicinforsp.mapMusic.get(str)) != null) {
                        String str2 = musicInfo.strUrl;
                        if (!TextUtils.isEmpty(str2)) {
                            QusicService.this.f49335k.put("qzonevipmusic://" + str, str2);
                            QusicService.this.f49336l.put(str, Long.valueOf(System.currentTimeMillis()));
                        }
                    }
                }
                Bundle j3 = QusicService.this.f49331g.j();
                j3.putSerializable("cacheForRealUrl", QusicService.this.f49335k);
                QusicService.this.f49331g.x(j3);
                if (this.f49352d) {
                    QusicService.this.I(this.f49353e, this.f49354f, this.f49355h);
                    return;
                }
                return;
            }
            QZLog.w("QusicService", "pullSongUrlWithIdFromBackGround rsp is not tGetMusicInfoRsp object.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements IQZoneServiceListener {
        d() {
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            if (qZoneTask.mResultCode != 0) {
                return;
            }
            JceStruct jceStruct = qZoneTask.mRequest.rsp;
            if (QZLog.isColorLevel()) {
                QZLog.i("QusicService", 2, "pullFeedMusicInfo ret:" + qZoneTask.mResultCode + ",data" + jceStruct);
            }
            if ((jceStruct instanceof GetMusicListRsp) && QusicService.this.C0((GetMusicListRsp) jceStruct)) {
                QusicService.this.c0(QusicService.this.M(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f49358d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SongInfo[] f49359e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f49360f;

        e(int i3, SongInfo[] songInfoArr, boolean z16) {
            this.f49358d = i3;
            this.f49359e = songInfoArr;
            this.f49360f = z16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LocalMultiProcConfig.putBool(QzoneWebMusicJsPlugin.CONFIG_MOBINET_TIPS, true);
            QusicService.this.f49331g.v(this.f49358d, this.f49359e);
            if (this.f49360f) {
                QusicService.this.y0(this.f49359e);
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements IQZoneServiceListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x6.a f49363d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f49364e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f49365f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f49366h;

        g(x6.a aVar, int i3, int i16, long j3) {
            this.f49363d = aVar;
            this.f49364e = i3;
            this.f49365f = i16;
            this.f49366h = j3;
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            if (qZoneTask.mResultCode == 0) {
                QusicService.this.d0(this.f49363d, this.f49364e, this.f49365f);
                if (QZLog.isColorLevel()) {
                    QZLog.d("QusicService", 2, "uin=" + this.f49366h + ",\u8bbe\u7f6e\u97f3\u4e50\u5f00\u5173 playMode new value=" + this.f49364e + ",\u8bbe\u7f6e\u6210\u529f.");
                    return;
                }
                return;
            }
            QZLog.e("QusicService", "uin=" + this.f49366h + ",\u8bbe\u7f6e\u97f3\u4e50\u5f00\u5173 playMode new value=" + this.f49364e + ",\u8bbe\u7f6e\u5931\u8d25." + qZoneTask.mResultCode + "," + qZoneTask.f45835msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements IQZoneServiceListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x6.a f49368d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f49369e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f49370f;

        h(x6.a aVar, int i3, long j3) {
            this.f49368d = aVar;
            this.f49369e = i3;
            this.f49370f = j3;
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            if (qZoneTask.mResultCode == 0) {
                this.f49368d.wifiAutoPlayFlag = Integer.valueOf(this.f49369e).byteValue();
                z5.a.f().t(this.f49368d);
                if (QZLog.isColorLevel()) {
                    QZLog.d("QusicService", 2, "uin=" + this.f49370f + ",\u8bbe\u7f6e\u97f3\u4e50\u5f00\u5173 wifiAutoPlayFlag new value=" + this.f49369e + ",\u8bbe\u7f6e\u6210\u529f.");
                    return;
                }
                return;
            }
            QZLog.e("QusicService", "uin=" + this.f49370f + ",\u8bbe\u7f6e\u97f3\u4e50\u5f00\u5173 wifiAutoPlayFlag new value=" + this.f49369e + ",\u8bbe\u7f6e\u5931\u8d25." + qZoneTask.mResultCode + "," + qZoneTask.f45835msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements IQZoneServiceListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x6.a f49372d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f49373e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f49374f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f49375h;

        i(x6.a aVar, int i3, int i16, long j3) {
            this.f49372d = aVar;
            this.f49373e = i3;
            this.f49374f = i16;
            this.f49375h = j3;
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
            if (qZoneTask.mResultCode == 0) {
                QusicService.this.d0(this.f49372d, this.f49373e, this.f49374f);
                if (QZLog.isColorLevel()) {
                    QZLog.d("QusicService", 2, "uin=" + this.f49375h + ",\u8bbe\u7f6e\u97f3\u4e50\u5faa\u73af\u5f00\u5173 loopPlay new value=" + this.f49374f + ",\u8bbe\u7f6e\u6210\u529f.");
                    return;
                }
                return;
            }
            QZLog.e("QusicService", "uin=" + this.f49375h + ",\u8bbe\u7f6e\u97f3\u4e50\u5faa\u73af\u5f00\u5173 loopPlay new value=" + this.f49374f + ",\u8bbe\u7f6e\u5931\u8d25 mResultCode=" + qZoneTask.mResultCode + "," + qZoneTask.f45835msg);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        public int f49377a;

        /* renamed from: b, reason: collision with root package name */
        public long f49378b;

        /* renamed from: d, reason: collision with root package name */
        public int f49380d;

        /* renamed from: e, reason: collision with root package name */
        public long f49381e;

        /* renamed from: f, reason: collision with root package name */
        public int f49382f;

        /* renamed from: j, reason: collision with root package name */
        public int f49386j;

        /* renamed from: k, reason: collision with root package name */
        public Intent f49387k;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<Long> f49379c = new ArrayList<>();

        /* renamed from: g, reason: collision with root package name */
        public boolean f49383g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f49384h = false;

        /* renamed from: i, reason: collision with root package name */
        public volatile boolean f49385i = false;

        /* renamed from: l, reason: collision with root package name */
        public String f49388l = "";
    }

    QusicService() {
    }

    private void G() {
        j jVar = new j();
        this.f49329e = jVar;
        this.f49330f = null;
        t0(jVar);
    }

    private void H(SongInfo songInfo, String str, long j3, boolean z16, int i3, Intent intent, String str2, String str3) {
        j Y = Y();
        Y.f49381e = j3;
        SongInfo J = J(songInfo.f251867d);
        if (TextUtils.isEmpty(J.f251871i)) {
            J.f251871i = str;
        }
        J.C = str3;
        J.f251872m = str2;
        if (!TextUtils.isEmpty(songInfo.f251870h)) {
            J.f251870h = songInfo.f251870h;
        } else {
            F(J);
        }
        if (!z16) {
            if (i3 == 1 || i3 == 2) {
                this.f49331g.u();
                return;
            }
            if (i3 == 3) {
                this.f49331g.w();
                com.qzone.component.sound.a.a();
                return;
            } else if (i3 != 4) {
                x0();
                return;
            } else {
                I(0, true, J);
                com.qzone.component.sound.a.a();
                return;
            }
        }
        Y.f49380d = 1;
        Y.f49378b = songInfo.f251867d;
        Y.f49377a = 0;
        ArrayList<Long> arrayList = Y.f49379c;
        if (arrayList == null) {
            Y.f49379c = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        Y.f49379c.add(Long.valueOf(songInfo.f251867d));
        Y.f49386j = 100;
        Y.f49387k = intent;
        Y.f49388l = "";
        this.f49331g.z(100);
        this.f49331g.y(Y.f49387k);
        t0(Y);
        I(0, true, J);
        com.qzone.component.sound.a.a();
    }

    private final SongInfo J(long j3) {
        SongInfo songInfo = this.f49326b.get(Long.valueOf(j3));
        if (songInfo != null) {
            return songInfo;
        }
        SongInfo songInfo2 = new SongInfo();
        songInfo2.f251867d = j3;
        this.f49326b.put(Long.valueOf(j3), songInfo2);
        return songInfo2;
    }

    public static String K(String str) {
        String str2 = "&uin=" + LoginData.getInstance().getUinString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&key=");
        sb5.append(MD5Utils.toMD5("&qqmusic_fromtag=2" + str2));
        return str + str2 + sb5.toString();
    }

    public static final QusicService O() {
        if (f49324q == null) {
            synchronized (f49323p) {
                if (f49324q == null) {
                    f49324q = new QusicService();
                }
            }
        }
        return f49324q;
    }

    private final int Q(ArrayList<Long> arrayList, long j3) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).longValue() == j3) {
                return size;
            }
        }
        return -1;
    }

    private void S(j jVar) {
        Bundle j3 = this.f49331g.j();
        if (j3 != null) {
            jVar.f49380d = j3.getInt(TtmlNode.ATTR_TTS_ORIGIN);
            ArrayList<Long> arrayList = (ArrayList) j3.getSerializable("ids");
            if (arrayList != null) {
                jVar.f49379c = arrayList;
            } else {
                jVar.f49379c = new ArrayList<>();
            }
            jVar.f49381e = j3.getLong("uin");
            jVar.f49382f = j3.getInt("fakeTotal");
            jVar.f49388l = j3.getString("musicurl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        j jVar = this.f49329e;
        e.a M = M();
        if (jVar == null || M == null) {
            return;
        }
        if (jVar.f49380d == 2 && !jVar.f49383g) {
            int i3 = M.f395854d;
            jVar.f49383g = i3 == 1 || i3 == 2;
        }
        int i16 = M.f395854d;
        if (i16 == 2) {
            T().removeMessages(0);
            T().sendMessageDelayed(T().obtainMessage(0, 1, 0), 1000L);
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QusicService", 4, "handleFullyQusicStateChanged");
            }
            AccManager.reportMusicSDKPlay(0, "");
            l0();
        } else {
            SongInfo songInfo = M.f395852b;
            if (songInfo != null && i16 == 10) {
                String str = songInfo.E;
                if (!TextUtils.isEmpty(str) && !this.f49336l.containsKey(str)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(str);
                    n0(jVar.f49381e, arrayList, true, M.f395855e, false, this.f49337m);
                    return;
                }
            }
        }
        c0(M, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i3) {
        String str;
        e.a M = M();
        c0(M, true);
        String N = N(i3);
        if (QZLog.isColorLevel()) {
            QZLog.d("QusicService", 2, "handleQusicPlayError errorCode:" + i3 + " msg:" + N);
        }
        SongInfo songInfo = M.f395852b;
        if (songInfo != null) {
            str = songInfo.f251870h;
        } else {
            str = "info==null";
        }
        AccManager.reportMusicSDKPlay(i3, str);
        if (TextUtils.isEmpty(N)) {
            return;
        }
        ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastMusicPlaying", "\u97f3\u4e50\u64ad\u653e:") + N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        int i3;
        ArrayList<Long> arrayList;
        j jVar = this.f49329e;
        e.a M = M();
        M.f395854d = 4;
        c0(M, true);
        QZLog.w("QusicService", "handleQusicStoped: origin:" + jVar.f49380d);
        int i16 = jVar.f49380d;
        if (i16 == 3) {
            return;
        }
        if (i16 == 2) {
            jVar.f49383g = false;
        }
        if (i16 == 1 && !jVar.f49384h) {
            j jVar2 = this.f49330f;
            if (jVar2 != null && (i3 = jVar2.f49377a) >= 0 && (arrayList = jVar2.f49379c) != null && i3 + 1 <= arrayList.size()) {
                j jVar3 = this.f49330f;
                this.f49329e = jVar3;
                this.f49330f = null;
                this.f49331g.z(jVar3.f49386j);
                this.f49331g.y(jVar3.f49387k);
                t0(jVar3);
                k0(jVar3.f49379c, jVar3.f49377a);
                return;
            }
        }
        G();
    }

    private final j Y() {
        j jVar = this.f49329e;
        if (jVar.f49379c == null) {
            jVar.f49379c = new ArrayList<>();
        }
        if (jVar.f49380d != 2 || !jVar.f49383g || jVar.f49379c.size() <= 0) {
            return jVar;
        }
        this.f49330f = jVar;
        j jVar2 = new j();
        this.f49329e = jVar2;
        return jVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a0(String str) {
        return NetworkState.isMobile() && !QQPlayerService.r0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(long j3, Object obj) {
        Iterator<WeakReference<e8.a>> it = this.f49328d.iterator();
        while (it.hasNext()) {
            e8.a aVar = it.next().get();
            if (aVar != null) {
                try {
                    aVar.a(j3, obj);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(x6.a aVar, int i3, int i16) {
        byte J = HomepageMusicPlayerBar.J(aVar.bgVoiceType, i3, i16);
        if (this.f49329e.f49381e == LoginData.getInstance().getUin() && this.f49329e.f49380d == 2) {
            this.f49331g.z(J);
        }
        aVar.playMode = Integer.valueOf(i3).byteValue();
        aVar.loopPlaybackType = Integer.valueOf(i16).byteValue();
        z5.a.f().t(aVar);
    }

    private void l0() {
        int i3;
        SongInfo k3;
        QQMusicWrap qQMusicWrap = this.f49331g;
        if (qQMusicWrap == null || 100 == (i3 = this.f49329e.f49386j) || 101 == i3 || (k3 = qQMusicWrap.k()) == null || TextUtils.isEmpty(k3.E) || k3.I != 11) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(k3.E);
        B(arrayList);
        if (arrayList.isEmpty()) {
            return;
        }
        n0(this.f49329e.f49381e, arrayList, false, 0, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q0() {
        SongInfo songInfo = this.f49333i;
        if (songInfo != null && songInfo.I == 9 && songInfo.K != null) {
            if (f49322o != -1) {
                ClickReport.r("", "", "", true, "642", "1", "1", "", this.f49333i.K.f251823d, (((float) (System.currentTimeMillis() - f49322o)) / 1000.0f) + "");
            }
            f49322o = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(j jVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(TtmlNode.ATTR_TTS_ORIGIN, jVar.f49380d);
        bundle.putSerializable("ids", jVar.f49379c);
        bundle.putLong("uin", jVar.f49381e);
        bundle.putInt("fakeTotal", jVar.f49382f);
        bundle.putString("musicurl", jVar.f49388l);
        bundle.putSerializable("cacheForRealUrl", this.f49335k);
        this.f49331g.x(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        DialogUtil.createCustomDialog(context, 230, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficTips", "\u6d41\u91cf\u63d0\u793a"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficMessage", "\u4f60\u6b63\u5904\u4e8e\u975eWiFi\u73af\u5883\uff0c\u7ee7\u7eed\u64ad\u653e\u5c06\u4f1a\u6d88\u8017\u6d41\u91cf\uff0c\u8fd0\u8425\u5546\u53ef\u80fd\u4f1a\u6536\u53d6\u8d39\u7528\uff0c\u662f\u5426\u7ee7\u7eed"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficContinue", "\u7ee7\u7eed"), l.a(R.string.j6l), onClickListener2, onClickListener).show();
    }

    private final void w0(List<Long> list, List<Long> list2) {
        LinkedList linkedList = new LinkedList();
        if (list2 != null) {
            Iterator<Long> it = list2.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next());
            }
        }
        if (list != null) {
            Iterator<Long> it5 = list.iterator();
            while (it5.hasNext()) {
                linkedList.remove(it5.next());
            }
        }
        Iterator it6 = linkedList.iterator();
        while (it6.hasNext()) {
            this.f49326b.remove((Long) it6.next());
        }
    }

    public void C() {
        T().removeCallbacksAndMessages(null);
        x0();
        G();
        this.f49326b = new LinkedHashMap<>(150);
    }

    public void E(String str, String str2, long j3, Intent intent, String str3, String str4) {
        j Y = Y();
        SongInfo songInfo = new SongInfo();
        songInfo.f251870h = str;
        songInfo.f251871i = str2;
        songInfo.I = 7;
        songInfo.f251872m = str3;
        songInfo.C = str4;
        if (Y.f49380d == 5 && str.equals(Y.f49388l)) {
            int i3 = this.f49331g.i();
            if (i3 == 1 || i3 == 2) {
                this.f49331g.u();
                return;
            }
            if (i3 == 3) {
                this.f49331g.w();
                com.qzone.component.sound.a.a();
                return;
            } else if (i3 != 4) {
                x0();
                return;
            } else {
                I(0, true, songInfo);
                com.qzone.component.sound.a.a();
                return;
            }
        }
        Y.f49381e = j3;
        Y.f49380d = 5;
        Y.f49386j = 100;
        Y.f49387k = intent;
        Y.f49388l = str;
        Y.f49378b = -1L;
        this.f49331g.z(100);
        this.f49331g.y(Y.f49387k);
        t0(Y);
        I(0, true, songInfo);
        com.qzone.component.sound.a.a();
    }

    public e.a L() {
        j jVar = this.f49330f;
        if (jVar == null) {
            return null;
        }
        e.a aVar = new e.a();
        aVar.f395855e = jVar.f49377a;
        aVar.f395853c = jVar.f49381e;
        aVar.f395856f = jVar.f49379c.size();
        aVar.f395852b = J(jVar.f49378b);
        aVar.f395857g = jVar.f49382f;
        return aVar;
    }

    public final e.a M() {
        int i3;
        long j3;
        SongInfo songInfo;
        int i16;
        j jVar = this.f49329e;
        e.a aVar = new e.a();
        if (!this.f49331g.t()) {
            return aVar;
        }
        aVar.f395854d = this.f49331g.i();
        aVar.f395855e = this.f49331g.h();
        aVar.f395852b = this.f49331g.g();
        aVar.f395861k = this.f49331g.n();
        if (this.f49331g.D()) {
            jVar.f49386j = aVar.f395861k;
            SongInfo songInfo2 = aVar.f395852b;
            if (songInfo2 != null) {
                j3 = songInfo2.f251867d;
            } else {
                j3 = jVar.f49378b;
            }
            jVar.f49378b = j3;
            if (jVar.f49379c.isEmpty() && ((i16 = jVar.f49380d) == 0 || i16 == 3)) {
                S(jVar);
            }
            if (!jVar.f49385i) {
                jVar.f49377a = aVar.f395855e;
            } else {
                aVar.f395855e = jVar.f49377a;
            }
            if (!TextUtils.isEmpty(jVar.f49388l)) {
                jVar.f49380d = 5;
            }
            if (jVar.f49380d == 5) {
                aVar.f395856f = 1;
            } else {
                aVar.f395856f = jVar.f49379c.size();
            }
            SongInfo songInfo3 = aVar.f395852b;
            if (songInfo3 == null || TextUtils.isEmpty(songInfo3.f251871i)) {
                SongInfo J = J(jVar.f49378b);
                aVar.f395852b = J;
                if (TextUtils.isEmpty(J.f251871i)) {
                    y0(aVar.f395852b);
                }
            }
            if (aVar.f395856f == 0 && (songInfo = aVar.f395852b) != null && songInfo.I == 9) {
                aVar.f395856f = 1;
            }
            aVar.f395857g = jVar.f49382f;
            aVar.f395851a = jVar.f49380d;
            aVar.f395853c = jVar.f49381e;
        } else {
            int m3 = this.f49331g.m();
            aVar.f395856f = m3;
            jVar.f49380d = 3;
            aVar.f395851a = 3;
            aVar.f395857g = m3;
        }
        SongInfo songInfo4 = aVar.f395852b;
        if (songInfo4 != null && ((i3 = songInfo4.I) == 6 || i3 == 8)) {
            aVar.f395859i = (int) (this.f49331g.r() / 1000);
        } else {
            aVar.f395859i = (int) (this.f49331g.q() / 1000);
        }
        aVar.f395858h = (int) (this.f49331g.s() / 1000);
        int i17 = aVar.f395854d;
        if (i17 != 2 && i17 != 1) {
            e8.f.f395866f = -1L;
            e8.f.f395867g = "";
        } else {
            e8.f.f395866f = jVar.f49378b;
            e8.f.f395867g = jVar.f49388l;
        }
        return aVar;
    }

    public Intent R() {
        return this.f49331g.l();
    }

    public BaseHandler T() {
        if (this.f49338n == null) {
            this.f49338n = new a(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper());
        }
        return this.f49338n;
    }

    public void X() {
        this.f49331g.A();
    }

    public boolean Z(long j3) {
        j jVar = this.f49329e;
        if (jVar.f49380d != 1 || jVar.f49379c.size() == 0 || jVar.f49378b != j3) {
            return false;
        }
        int i3 = this.f49331g.i();
        return i3 == 2 || i3 == 1;
    }

    public void e0() {
        this.f49331g.u();
    }

    public void f0(List<SongInfo> list, int i3, int i16, long j3, int i17, Intent intent, int i18) {
        QZLog.w("QusicService", "playAudioMusic: uin:" + j3);
        if (list == null || list.size() == 0) {
            return;
        }
        if (i3 < 0 || i3 + 1 > list.size()) {
            i3 = 0;
        }
        this.f49330f = null;
        j jVar = this.f49329e;
        jVar.f49381e = j3;
        jVar.f49382f = i16;
        jVar.f49386j = i17;
        jVar.f49387k = intent;
        jVar.f49388l = "";
        ArrayList<Long> arrayList = jVar.f49379c;
        if (arrayList == null) {
            jVar.f49379c = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        int size = list.size();
        SongInfo[] songInfoArr = new SongInfo[size];
        for (int i19 = 0; i19 < size; i19++) {
            SongInfo songInfo = list.get(i19);
            String str = songInfo.f251872m;
            long j16 = songInfo.f251867d;
            SongInfo J = J(j16);
            D0(J, songInfo);
            jVar.f49379c.add(Long.valueOf(j16));
            songInfoArr[i19] = J;
        }
        jVar.f49377a = i3;
        jVar.f49378b = list.get(i3).f251867d;
        jVar.f49380d = i18;
        jVar.f49385i = false;
        this.f49331g.z(jVar.f49386j);
        this.f49331g.y(jVar.f49387k);
        t0(jVar);
        I(i3, true, songInfoArr);
    }

    public void i0(List<SongInfo> list, int i3, int i16, long j3, int i17, Intent intent) {
        QZLog.w("QusicService", "playHomePageMusic: uin:" + j3);
        if (list == null || list.size() == 0) {
            return;
        }
        if (i3 < 0 || i3 + 1 > list.size()) {
            i3 = 0;
        }
        this.f49330f = null;
        j jVar = this.f49329e;
        jVar.f49381e = j3;
        jVar.f49382f = i16;
        jVar.f49386j = i17;
        jVar.f49387k = intent;
        jVar.f49388l = "";
        ArrayList<Long> arrayList = jVar.f49379c;
        if (arrayList == null) {
            jVar.f49379c = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        int size = list.size();
        SongInfo[] songInfoArr = new SongInfo[size];
        for (int i18 = 0; i18 < size; i18++) {
            SongInfo songInfo = list.get(i18);
            long j16 = songInfo.f251867d;
            SongInfo J = J(j16);
            D0(J, songInfo);
            F(J);
            jVar.f49379c.add(Long.valueOf(j16));
            songInfoArr[i18] = J;
        }
        jVar.f49377a = i3;
        jVar.f49378b = list.get(i3).f251867d;
        jVar.f49380d = 2;
        jVar.f49385i = false;
        this.f49331g.z(jVar.f49386j);
        this.f49331g.y(jVar.f49387k);
        t0(jVar);
        I(i3, true, songInfoArr);
    }

    public void m0(long j3) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetBGVoiceWebappRequest(j3), null, new b(j3), 10));
    }

    public void o0() {
        this.f49331g.C();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.personalize.music.business.QusicService.3
            @Override // java.lang.Runnable
            public void run() {
                LocalMultiProcConfig.putBool(QzoneWebMusicJsPlugin.CONFIG_MOBINET_TIPS, false);
            }
        });
    }

    public synchronized void p0(e8.e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.f49332h) {
            Iterator<WeakReference<e8.e>> it = this.f49327c.iterator();
            while (it.hasNext()) {
                e8.e eVar2 = it.next().get();
                if (eVar2 == null) {
                    it.remove();
                } else if (eVar2 == eVar) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void r0() {
        this.f49331g.w();
    }

    public void u0(int i3) {
        this.f49331g.z(i3);
    }

    public void x0() {
        this.f49329e.f49384h = true;
        T().removeMessages(0);
        this.f49331g.B();
    }

    public void D(SongInfo songInfo, String str, long j3, Intent intent, String str2, String str3) {
        boolean z16;
        j jVar = this.f49329e;
        if (jVar.f49380d == 2 && jVar.f49383g) {
            jVar = new j();
        }
        if (jVar.f49380d == 1 && jVar.f49379c.size() != 0) {
            if (jVar.f49378b == songInfo.f251867d) {
                z16 = false;
                H(songInfo, str, j3, z16, this.f49331g.i(), intent, str2, str3);
            }
        }
        z16 = true;
        H(songInfo, str, j3, z16, this.f49331g.i(), intent, str2, str3);
    }

    public void j0(SongInfo songInfo) {
        y0(songInfo);
        SongInfo J = J(songInfo.f251867d);
        F(J);
        I(0, true, J);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends BaseHandler {

        /* compiled from: P */
        /* renamed from: com.qzone.personalize.music.business.QusicService$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class DialogInterfaceOnClickListenerC0419a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0419a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                LocalMultiProcConfig.putBool(QzoneWebMusicJsPlugin.CONFIG_MOBINET_TIPS, true);
                QusicService.this.f49331g.w();
                dialogInterface.dismiss();
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                QusicService.this.x0();
                dialogInterface.dismiss();
            }
        }

        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SongInfo songInfo;
            if (message == null) {
                return;
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    return;
                }
                int i16 = message.arg1;
                if (i16 != 10) {
                    switch (i16) {
                        case 1:
                        case 3:
                            break;
                        case 2:
                            QusicService.f49322o = System.currentTimeMillis();
                            break;
                        case 4:
                            QusicService.this.q0();
                            QusicService.this.W();
                            ListenTogetherIPCModuleWebClient.b(new JSONObject(), "pauseFloatView", null);
                            return;
                        case 5:
                        case 6:
                        case 7:
                            QusicService.this.q0();
                            QusicService.this.V(message.arg1);
                            return;
                        default:
                            return;
                    }
                }
                QusicService.this.U();
                return;
            }
            e.a M = QusicService.this.M();
            if (M == null) {
                return;
            }
            boolean z16 = message.arg1 == 1;
            M.f395860j = z16;
            if (!z16) {
                int i17 = M.f395851a;
                if (i17 == 3) {
                    QusicService.this.f49330f = null;
                    if (!QusicService.this.f49329e.f49379c.isEmpty()) {
                        QusicService.this.f49329e = new j();
                    }
                } else if (i17 == 2) {
                    j jVar = QusicService.this.f49329e;
                    if (jVar.f49385i) {
                        j jVar2 = QusicService.this.f49329e;
                        QusicService.this.f49330f = null;
                        QusicService.this.f49331g.z(jVar2.f49386j);
                        QusicService.this.f49331g.y(jVar2.f49387k);
                        QusicService.this.t0(jVar2);
                        QusicService.this.k0(jVar2.f49379c, jVar2.f49377a + 1);
                        jVar.f49385i = false;
                        return;
                    }
                    Activity topActivity = BaseActivity.getTopActivity();
                    if (!LocalMultiProcConfig.getBool(QzoneWebMusicJsPlugin.CONFIG_MOBINET_TIPS, false) && (songInfo = M.f395852b) != null && QusicService.a0(songInfo.f251870h)) {
                        if (topActivity != null) {
                            QusicService.this.f49331g.u();
                            QusicService.v0(topActivity, new DialogInterfaceOnClickListenerC0419a(), new b());
                        } else {
                            M.f395862l = true;
                        }
                    }
                } else if (i17 == 6 && M.f395852b != null) {
                    QusicService.this.f49331g.y(e8.f.a().c().b(LoginData.getInstance().getUin(), ""));
                }
            }
            if (QusicService.this.f49333i != null && M.f395852b != null && (QusicService.this.f49333i.K == null || M.f395852b.K == null || !QusicService.this.f49333i.K.f251823d.equals(M.f395852b.K.f251823d))) {
                QusicService.this.q0();
            }
            QusicService.this.f49333i = M.f395852b;
            QusicService.this.c0(M, true);
            if (M.f395854d == 2) {
                QusicService.this.f49338n.removeMessages(0);
                QusicService.this.f49338n.sendMessageDelayed(QusicService.this.f49338n.obtainMessage(0, 1, 0), 15000L);
            }
        }
    }

    private void B(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || this.f49336l == null || this.f49335k == null) {
            return;
        }
        try {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String str = "qzonevipmusic://" + next;
                if (this.f49336l.containsKey(next)) {
                    if (System.currentTimeMillis() < this.f49336l.get(next).longValue() + 480000) {
                        it.remove();
                    } else {
                        this.f49336l.remove(next);
                        if (this.f49335k.containsKey(str)) {
                            this.f49335k.remove(str);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QZLog.e("QusicService", "checkInvalidyOfCachedUrl exception: " + e16);
        }
    }

    private static void F(SongInfo songInfo) {
        if (songInfo == null || !TextUtils.isEmpty(songInfo.f251870h)) {
            return;
        }
        int i3 = songInfo.I;
        if ((i3 == 11 || i3 == 10) && !TextUtils.isEmpty(songInfo.E)) {
            songInfo.f251870h = "qzonevipmusic://" + songInfo.E;
            return;
        }
        if (songInfo.I == 5) {
            String str = songInfo.f251870h + "&stdfrom=3";
            songInfo.f251870h = str;
            songInfo.f251870h = K(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i3, boolean z16, SongInfo... songInfoArr) {
        j jVar;
        if (songInfoArr != null && (jVar = this.f49329e) != null && jVar.f49379c != null) {
            this.f49337m = songInfoArr;
            ArrayList<String> arrayList = new ArrayList<>();
            int i16 = i3 + 2;
            if (i16 > songInfoArr.length - 1) {
                i16 = songInfoArr.length - 1;
            }
            for (int i17 = i3; i17 <= i16; i17++) {
                String str = songInfoArr[i17].E;
                String str2 = "qzonevipmusic://" + str;
                if (!TextUtils.isEmpty(str) && !this.f49335k.containsKey(str2)) {
                    SongInfo songInfo = songInfoArr[i17];
                    if (songInfo.I == 11) {
                        arrayList.add(songInfo.E);
                    }
                }
            }
            if (songInfoArr.length > 0 && !arrayList.isEmpty()) {
                B(arrayList);
                if (!arrayList.isEmpty()) {
                    n0(this.f49329e.f49381e, arrayList, true, i3, z16, songInfoArr);
                    return;
                }
            }
        }
        Activity topActivity = BaseActivity.getTopActivity();
        if (topActivity != null && a0(songInfoArr[i3].f251870h) && !LocalMultiProcConfig.getBool(QzoneWebMusicJsPlugin.CONFIG_MOBINET_TIPS, false)) {
            v0(topActivity, new e(i3, songInfoArr, z16), new f());
            return;
        }
        this.f49331g.v(i3, songInfoArr);
        if (z16) {
            y0(songInfoArr);
        }
    }

    private void P(SongInfo songInfo) {
        if (songInfo != null && !TextUtils.isEmpty(songInfo.E) && songInfo.I == 11) {
            F(songInfo);
            return;
        }
        if (songInfo == null || !TextUtils.isEmpty(songInfo.f251870h)) {
            return;
        }
        if (songInfo.I == 5) {
            String str = songInfo.f251870h + "&stdfrom=3";
            songInfo.f251870h = str;
            songInfo.f251870h = K(str);
            return;
        }
        this.f49334j = true;
        y0(songInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(ArrayList<Long> arrayList, int i3) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = size - 1;
        if (i3 > i16) {
            i3 = i16;
        }
        SongInfo[] songInfoArr = new SongInfo[size];
        for (int i17 = 0; i17 < size; i17++) {
            SongInfo J = J(arrayList.get(i17).longValue());
            F(J);
            songInfoArr[i17] = J;
        }
        I(i3, true, songInfoArr);
    }

    public void h0(List<SongInfo> list, int i3, int i16, long j3, int i17, Intent intent, int i18) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (i3 < 0 || i3 + 1 > list.size()) {
            i3 = 0;
        }
        this.f49330f = null;
        j jVar = this.f49329e;
        jVar.f49381e = j3;
        jVar.f49382f = i16;
        jVar.f49386j = i17;
        jVar.f49387k = intent;
        jVar.f49388l = "";
        ArrayList<Long> arrayList = jVar.f49379c;
        if (arrayList == null) {
            jVar.f49379c = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        int size = list.size();
        SongInfo[] songInfoArr = new SongInfo[size];
        for (int i19 = 0; i19 < size; i19++) {
            SongInfo songInfo = list.get(i19);
            long j16 = songInfo.f251867d;
            SongInfo J = J(j16);
            D0(J, songInfo);
            F(J);
            jVar.f49379c.add(Long.valueOf(j16));
            songInfoArr[i19] = J;
        }
        jVar.f49377a = i3;
        jVar.f49378b = list.get(i3).f251867d;
        jVar.f49380d = i18;
        jVar.f49385i = false;
        this.f49331g.z(jVar.f49386j);
        this.f49331g.y(jVar.f49387k);
        t0(jVar);
        I(i3, false, songInfoArr);
    }

    public void n0(long j3, ArrayList<String> arrayList, boolean z16, int i3, boolean z17, SongInfo... songInfoArr) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        try {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetBGVoiceUrlWithMidRequest(j3, arrayList, 1), null, new c(z16, i3, z17, songInfoArr), 40));
        } catch (Exception e16) {
            QZLog.e("QusicService", "pullSongUrlWithMId exception: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C0(GetMusicListRsp getMusicListRsp) {
        ArrayList<NS_MOBILE_MUSIC.MusicInfo> arrayList;
        boolean z16 = false;
        if (getMusicListRsp != null && (arrayList = getMusicListRsp.music_list) != null && arrayList.size() != 0) {
            Iterator<NS_MOBILE_MUSIC.MusicInfo> it = getMusicListRsp.music_list.iterator();
            while (it.hasNext()) {
                if (A0(it.next()) && !z16) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(SongInfo... songInfoArr) {
        if (songInfoArr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SongInfo songInfo : songInfoArr) {
            if (TextUtils.isEmpty(songInfo.f251870h)) {
                arrayList.add(songInfo);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetMusicListRequest(arrayList), null, new d(), 20));
    }

    public void A(final e8.e eVar, final boolean z16) {
        if (eVar == null) {
            return;
        }
        T().post(new Runnable() { // from class: com.qzone.personalize.music.business.QusicService.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (QusicService.this.f49332h) {
                    Iterator it = QusicService.this.f49327c.iterator();
                    while (it.hasNext()) {
                        e8.e eVar2 = (e8.e) ((WeakReference) it.next()).get();
                        if (eVar2 == null) {
                            it.remove();
                        } else if (eVar2 == eVar) {
                            final e.a M = QusicService.this.M();
                            QusicService.this.f49325a.post(new Runnable() { // from class: com.qzone.personalize.music.business.QusicService.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        eVar.a(M);
                                    } catch (Exception e16) {
                                        QZLog.w(e16);
                                    }
                                }
                            });
                            return;
                        }
                    }
                    QusicService.this.f49327c.add(new WeakReference(eVar));
                    if (z16) {
                        final e.a M2 = QusicService.this.M();
                        QusicService.this.f49325a.post(new Runnable() { // from class: com.qzone.personalize.music.business.QusicService.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    eVar.a(M2);
                                } catch (Exception e16) {
                                    QZLog.w(e16);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    public void g0(SongInfo songInfo, long j3, Intent intent) {
        if (songInfo == null) {
            return;
        }
        long j16 = songInfo.f251867d;
        j Y = Y();
        Y.f49381e = j3;
        int i3 = songInfo.I;
        if (i3 != 6) {
            Y.f49380d = 1;
        } else {
            Y.f49380d = i3;
        }
        Y.f49378b = j16;
        Y.f49377a = 0;
        Y.f49386j = 100;
        ArrayList<Long> arrayList = Y.f49379c;
        if (arrayList == null) {
            Y.f49379c = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        Y.f49379c.add(Long.valueOf(j16));
        this.f49331g.z(Y.f49386j);
        this.f49331g.y(intent);
        t0(Y);
        SongInfo J = J(j16);
        D0(J, songInfo);
        P(J);
        I(0, true, J);
    }

    private boolean A0(NS_MOBILE_MUSIC.MusicInfo musicInfo) {
        if (musicInfo == null) {
            return false;
        }
        SongInfo songInfo = new SongInfo();
        long j3 = musicInfo.xqusic_id;
        songInfo.f251867d = j3;
        songInfo.f251871i = musicInfo.xsong_name;
        songInfo.F = musicInfo.xsinger_name;
        songInfo.I = musicInfo.type;
        songInfo.G = musicInfo.xsinger_id;
        songInfo.E = musicInfo.xqusic_mid;
        songInfo.f251870h = musicInfo.xsong_url;
        SongInfo J = J(j3);
        if (this.f49334j) {
            I(0, true, songInfo);
            this.f49334j = false;
        }
        return D0(J, songInfo);
    }

    private boolean B0(BroadcastMusicInfo broadcastMusicInfo) {
        if (broadcastMusicInfo == null) {
            return false;
        }
        SongInfo songInfo = new SongInfo();
        try {
            long parseLong = Long.parseLong(broadcastMusicInfo.f251823d);
            songInfo.f251867d = parseLong;
            songInfo.f251871i = broadcastMusicInfo.f251824e;
            songInfo.I = 9;
            songInfo.E = "";
            songInfo.K = broadcastMusicInfo;
            return D0(J(parseLong), songInfo);
        } catch (Exception unused) {
            return false;
        }
    }

    private static final String N(int i3) {
        if (i3 == 5) {
            return "";
        }
        if (i3 == 6) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5");
        }
        if (i3 != 7) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkUnknowError", WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN);
        }
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkServerError", "\u670d\u52a1\u5668\u5f02\u5e38");
    }

    public static boolean D0(SongInfo songInfo, SongInfo songInfo2) {
        boolean z16 = false;
        if (songInfo2 == null || songInfo == null || songInfo.f251867d != songInfo2.f251867d) {
            return false;
        }
        songInfo.I = songInfo2.I;
        songInfo.K = songInfo2.K;
        songInfo.f251869f = songInfo2.f251869f;
        if (!TextUtils.isEmpty(songInfo2.f251871i) && !songInfo2.f251871i.equals(songInfo.f251871i)) {
            songInfo.f251871i = songInfo2.f251871i;
            z16 = true;
        }
        if (!TextUtils.isEmpty(songInfo2.F) && !songInfo2.F.equals(songInfo.F)) {
            songInfo.F = songInfo2.F;
            z16 = true;
        }
        if (!TextUtils.isEmpty(songInfo2.f251870h) && !songInfo2.f251870h.equals(songInfo.f251870h)) {
            songInfo.f251870h = songInfo2.f251870h;
            z16 = true;
        }
        if (!TextUtils.isEmpty(songInfo2.f251872m) && !songInfo2.f251872m.equals(songInfo.f251872m)) {
            songInfo.f251872m = songInfo2.f251872m;
            z16 = true;
        }
        if (!TextUtils.isEmpty(songInfo2.C) && !songInfo2.C.equals(songInfo.C)) {
            songInfo.C = songInfo2.C;
            z16 = true;
        }
        if (!TextUtils.isEmpty(songInfo2.D) && !songInfo2.D.equals(songInfo.D)) {
            songInfo.D = songInfo2.D;
            z16 = true;
        }
        if (TextUtils.isEmpty(songInfo2.E) || songInfo2.E.equals(songInfo.E)) {
            return z16;
        }
        songInfo.E = songInfo2.E;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(final e.a aVar, boolean z16) {
        if (aVar == null) {
            return;
        }
        if (z16 && QZLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("notifyChanged origin:");
            sb5.append(aVar.f395851a);
            sb5.append(" count:");
            sb5.append(aVar.f395856f);
            sb5.append(" index:");
            sb5.append(aVar.f395855e);
            sb5.append(" state:");
            sb5.append(aVar.f395854d);
            sb5.append(" id:");
            SongInfo songInfo = aVar.f395852b;
            sb5.append(songInfo == null ? 0L : songInfo.f251867d);
            sb5.append(" uin:");
            sb5.append(aVar.f395853c);
            QZLog.d("QusicService", 2, sb5.toString());
        }
        try {
            Iterator<WeakReference<e8.e>> it = this.f49327c.iterator();
            while (it.hasNext()) {
                final e8.e eVar = it.next().get();
                if (eVar != null) {
                    this.f49325a.post(new Runnable() { // from class: com.qzone.personalize.music.business.QusicService.4
                        @Override // java.lang.Runnable
                        public void run() {
                            eVar.a(aVar);
                        }
                    });
                }
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public void s0(int i3, int i16, int i17) {
        long uin = LoginData.getInstance().getUin();
        x6.a g16 = z5.a.f().g(uin);
        if (g16 == null) {
            return;
        }
        if (g16.playMode != i3) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetBackgroundMusicPlayModeRequest(uin, QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, i3), null, new g(g16, i3, i17, uin), 30));
        }
        if (g16.wifiAutoPlayFlag != i16) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetBackgroundMusicPlayModeRequest(uin, "wifi", i16), null, new h(g16, i16, uin), 30));
        }
        if ((i17 == 0 || i17 == 1) && g16.loopPlaybackType != i17) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetBackgroundMusicPlayModeRequest(uin, "loop", i17), null, new i(g16, i3, i17, uin), 30));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z0(tGetBGVoiceWebappRsp tgetbgvoicewebapprsp, long j3) {
        ArrayList<NS_MOBILE_MUSIC.MusicInfo> arrayList;
        int i3;
        ArrayList<BroadcastForQzone> arrayList2;
        long j16;
        ArrayList<BGMusicForQzone> arrayList3;
        ArrayList<NS_MOBILE_MUSIC.MusicInfo> arrayList4;
        if (tgetbgvoicewebapprsp != null && tgetbgvoicewebapprsp.stBGVoice != null) {
            j jVar = this.f49329e;
            j jVar2 = this.f49330f;
            ArrayList<Long> arrayList5 = new ArrayList<>();
            BGVoice bGVoice = tgetbgvoicewebapprsp.stBGVoice;
            int i16 = bGVoice.iTypeValue;
            if (i16 == 0) {
                BGMusic bGMusic = bGVoice.bgMusicLists;
                if (bGMusic != null && (arrayList4 = bGMusic.all_music_list) != null) {
                    Iterator<NS_MOBILE_MUSIC.MusicInfo> it = arrayList4.iterator();
                    while (it.hasNext()) {
                        NS_MOBILE_MUSIC.MusicInfo next = it.next();
                        A0(next);
                        arrayList5.add(Long.valueOf(next.xqusic_id));
                    }
                    i3 = tgetbgvoicewebapprsp.stBGVoice.bgMusicLists.all_music_nums;
                }
                i3 = 0;
            } else if (1 == i16) {
                BGFM bgfm = bGVoice.bgFmLists;
                if (bgfm != null && (arrayList3 = bgfm.stFmLists) != null) {
                    Iterator<BGMusicForQzone> it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        BGMusicForQzone next2 = it5.next();
                        NS_MOBILE_MUSIC.MusicInfo musicInfo = new NS_MOBILE_MUSIC.MusicInfo();
                        musicInfo.type = 8;
                        musicInfo.xqusic_id = ((IQzoneMusicHelper) QRoute.api(IQzoneMusicHelper.class)).getFMID(next2.showID);
                        musicInfo.xexpire = false;
                        musicInfo.xsong_name = next2.showName;
                        musicInfo.xsong_url = next2.showAudioUrl;
                        A0(musicInfo);
                        arrayList5.add(Long.valueOf(musicInfo.xqusic_id));
                    }
                    i3 = tgetbgvoicewebapprsp.stBGVoice.bgFmLists.stFmLists.size();
                }
                i3 = 0;
            } else if (2 == i16) {
                BGFM bgfm2 = bGVoice.bgFmLists;
                if (bgfm2 != null && (arrayList2 = bgfm2.stFmBroadcast) != null) {
                    Iterator<BroadcastForQzone> it6 = arrayList2.iterator();
                    while (it6.hasNext()) {
                        BroadcastMusicInfo a16 = BroadcastMusicInfo.a(it6.next());
                        B0(a16);
                        try {
                            j16 = Long.parseLong(a16.f251823d);
                        } catch (Exception unused) {
                            j16 = -1;
                        }
                        arrayList5.add(Long.valueOf(j16));
                    }
                    i3 = tgetbgvoicewebapprsp.stBGVoice.bgFmLists.stFmBroadcast.size();
                }
                i3 = 0;
            } else if (3 == i16) {
                BGMusic bGMusic2 = bGVoice.bgMusicLists;
                if (bGMusic2 != null && (arrayList = bGMusic2.all_music_list) != null) {
                    Iterator<NS_MOBILE_MUSIC.MusicInfo> it7 = arrayList.iterator();
                    while (it7.hasNext()) {
                        NS_MOBILE_MUSIC.MusicInfo next3 = it7.next();
                        if (next3.xqusic_id == 0 && !TextUtils.isEmpty(next3.xqusic_mid)) {
                            next3.xqusic_id = ((IQzoneMusicHelper) QRoute.api(IQzoneMusicHelper.class)).getSongIDWithMid(next3.xqusic_mid);
                            next3.type = 11;
                            A0(next3);
                            arrayList5.add(Long.valueOf(next3.xqusic_id));
                        }
                    }
                    i3 = tgetbgvoicewebapprsp.stBGVoice.bgMusicLists.all_music_nums;
                }
                i3 = 0;
            }
            int size = arrayList5.size();
            if (j3 == jVar.f49381e && jVar.f49380d == 2) {
                w0(arrayList5, jVar.f49379c);
                int Q = Q(arrayList5, jVar.f49378b);
                jVar.f49382f = i3;
                jVar.f49379c = arrayList5;
                if (size != 0 && Q != -1) {
                    jVar.f49385i = true;
                    jVar.f49377a = Q;
                    t0(jVar);
                    return true;
                }
                jVar.f49378b = 0L;
                jVar.f49377a = 0;
                x0();
                G();
                return false;
            }
            if (jVar2 != null && jVar2.f49381e == j3 && jVar2.f49380d == 2) {
                w0(arrayList5, jVar2.f49379c);
                int Q2 = Q(arrayList5, jVar2.f49378b);
                jVar2.f49382f = i3;
                jVar2.f49379c = arrayList5;
                if (size != 0 && Q2 != -1) {
                    jVar2.f49377a = Q2;
                    jVar2.f49378b = arrayList5.get(Q2).longValue();
                } else {
                    jVar2.f49377a = 0;
                    jVar2.f49378b = 0L;
                }
            }
            return true;
        }
        return false;
    }
}
