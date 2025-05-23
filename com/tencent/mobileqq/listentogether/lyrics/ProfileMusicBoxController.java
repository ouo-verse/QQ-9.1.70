package com.tencent.mobileqq.listentogether.lyrics;

import VIP.GetMusicListReq;
import VIP.GetMusicListRsp;
import VIP.GetQzoneMusicInfoReq;
import VIP.GetQzoneMusicInfoRsp;
import VIP.SourceInfo;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qzone.personalize.music.request.QzoneGetMusicListRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.k;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.g;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class ProfileMusicBoxController extends LyricsController implements g, BusinessObserver {

    /* renamed from: o0, reason: collision with root package name */
    public static int f241033o0 = 3;

    /* renamed from: h0, reason: collision with root package name */
    private long f241034h0;

    /* renamed from: i0, reason: collision with root package name */
    private SongInfo[] f241035i0;

    /* renamed from: j0, reason: collision with root package name */
    private SongInfo f241036j0;

    /* renamed from: k0, reason: collision with root package name */
    private k f241037k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f241038l0;

    /* renamed from: m0, reason: collision with root package name */
    private long f241039m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f241040n0;

    public ProfileMusicBoxController(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f241036j0 = new SongInfo();
        this.f241040n0 = false;
        this.f241009h.f241054f = true;
        qQAppInterface.removeObserver(this.T);
    }

    public static boolean j0(long j3) {
        SongInfo b06 = QQPlayerService.b0();
        if (b06 != null && QQPlayerService.b0().I == 10 && b06.f251869f == j3) {
            return QQPlayerService.s0();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.LyricsController
    public void R(int i3, String str) {
        super.R(f241033o0, str);
        FloatViewSkin.o().n(this.E, str, f241033o0);
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface != null && qQAppInterface.getAccount().equalsIgnoreCase(str)) {
            this.f241040n0 = true;
        } else {
            this.f241040n0 = false;
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.LyricsController, com.tencent.mobileqq.listentogether.lyrics.a
    public void f() {
        String valueOf;
        QQPlayerService.m1(BaseApplication.getContext());
        q0();
        if (this.f241040n0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(this.f241034h0);
        }
        ReportController.o(null, "dc00898", "", valueOf, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7E0", this.f241040n0 ? 1 : 2, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.LyricsController, com.tencent.mobileqq.listentogether.lyrics.a
    public void g() {
        String valueOf;
        com.tencent.mobileqq.profile.musicbox.a.i(this.E.getContext(), this.f241009h.f241063o);
        if (this.f241040n0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(this.f241034h0);
        }
        ReportController.o(null, "dc00898", "", valueOf, QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A7DF", this.f241040n0 ? 1 : 2, 0, "", "", "", "");
    }

    public void g0() {
        super.x(f241033o0, this.f241009h.f241063o);
        b bVar = this.f241009h;
        bVar.f241062n = 0;
        P(f241033o0, bVar.f241063o, true);
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface != null) {
            LyricsController T = ListenTogetherManager.J(qQAppInterface).T();
            if (T != null) {
                T.v().f241049a = this.f241009h.f241049a;
                T.v().f241050b = this.f241009h.f241050b;
                T.v().f241053e = this.f241009h.f241053e;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileMusicBoxController", 2, "hideLyrics");
            }
        }
    }

    public boolean h0() {
        return QQPlayerService.m0() == 3 && QQPlayerService.b0() != null && QQPlayerService.b0().I == 10 && z();
    }

    public boolean i0() {
        return this.f241038l0;
    }

    public void k0(SongInfo songInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("ProfileMusicBoxController", 2, "onPlayMusicChange song.id:" + songInfo.C);
        }
        this.f241009h.f241055g = songInfo.C;
        if (z()) {
            this.E.C(this.f241009h);
        }
    }

    public void l0() {
        QQPlayerService.K0(BaseApplication.getContext());
        r0(false);
    }

    public void m0(Context context, SongInfo songInfo) {
        if (QQPlayerService.m0() == 3) {
            QQPlayerService.V0(context, false);
            r0(true);
            return;
        }
        new Intent(context, (Class<?>) QQBrowserActivity.class).putExtra("url", URLUtil.addParameter(QVipProfileMusicBoxProcessor.getConfig().playerUrl, "uin", String.valueOf(this.f241034h0)));
        QQPlayerService.R(this);
        QQPlayerService.c1(103);
        QQPlayerService.k1(context, getToken(), new SongInfo[]{songInfo}, 0, false);
        n0(this.f241034h0);
        u0(String.valueOf(this.f241034h0));
        k0(songInfo);
        if (QLog.isColorLevel()) {
            QLog.d("ProfileMusicBoxController", 2, "playMusic mid:" + songInfo.E + " url:" + songInfo.f251870h);
        }
    }

    public void n0(long j3) {
        VasUtil.getService().getJceRequset().build("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getMusicList").request(QzoneGetMusicListRequest.CMD_STRING, new GetMusicListReq(j3, "", 100L, new SourceInfo(3, AppSetting.f99551k), 0), new GetMusicListRsp(), this, false);
    }

    public void o0(long j3, ArrayList<String> arrayList) {
        VasUtil.getService().getJceRequset().build("VIP.ProfileMusicBoxServer.ProfileMusicBoxObj", "ProfileMusicBox.getQzoneMusicInfo").request("getQzoneMusicInfo", new GetQzoneMusicInfoReq(j3, arrayList, new SourceInfo(3, AppSetting.f99551k)), new GetQzoneMusicInfoRsp(), new a(), false);
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlaySongChanged(SongInfo songInfo) {
        this.f241036j0 = songInfo;
        if (songInfo.I == 10) {
            k kVar = this.f241037k0;
            if (kVar != null) {
                kVar.a(songInfo, this.f241038l0);
            }
            p0();
            if (QLog.isColorLevel()) {
                QLog.d("ProfileMusicBoxController", 2, "onPlaySongChanged newSong:" + songInfo.f251871i);
            }
        }
    }

    public void p0() {
        SongInfo g06 = QQPlayerService.g0();
        SongInfo b06 = QQPlayerService.b0();
        if (g06 == null || b06 == null || g06.I != 10 || TextUtils.isEmpty(g06.E) || g06.E.equals(b06.E)) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(g06.E);
        o0(this.f241034h0, arrayList);
    }

    public void q0() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.ProfileMusicBoxController.2
            @Override // java.lang.Runnable
            public void run() {
                if (ProfileMusicBoxController.this.f241037k0 != null) {
                    ProfileMusicBoxController.this.f241037k0.b(2);
                }
                ProfileMusicBoxController.this.g0();
            }
        });
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface == null) {
            QLog.e("ProfileMusicBoxController", 1, "resetState fail, app is null");
            return;
        }
        LyricsController T = ListenTogetherManager.J(qQAppInterface).T();
        if (T != null && !ListenTogetherManager.J(this.f241002d).k0()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "musicboxResume");
                jSONObject.put("uin", T.v().f241063o);
                jSONObject.put("uinType", T.v().f241062n);
                ListenTogetherManager.J(this.f241002d).m1(jSONObject);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileMusicBoxController", 2, "resetState");
        }
    }

    public void r0(final boolean z16) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.ProfileMusicBoxController.1
            @Override // java.lang.Runnable
            public void run() {
                FloatIconLayout floatIconLayout = ProfileMusicBoxController.this.E;
                if (floatIconLayout != null) {
                    floatIconLayout.setPlayState(z16);
                }
            }
        });
    }

    public void s0(k kVar) {
        this.f241037k0 = kVar;
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.LyricsController
    public void t() {
        QQPlayerService.S0(this);
        this.f241037k0 = null;
        super.t();
        FloatViewSkin.o().q();
    }

    public void t0(long j3, SongInfo songInfo) {
        this.f241034h0 = j3;
        this.f241036j0 = songInfo;
        this.f241038l0 = j0(j3);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(songInfo.E);
        o0(j3, arrayList);
    }

    public void u0(String str) {
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface == null) {
            QLog.e("ProfileMusicBoxController", 1, "showLyrics fail, app is null");
            return;
        }
        if (qQAppInterface.getAccount().equalsIgnoreCase(str)) {
            this.f241040n0 = true;
        } else {
            this.f241040n0 = false;
        }
        if (h0()) {
            QQPlayerService.V0(BaseApplication.getContext(), false);
            r0(true);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LyricsController T = ListenTogetherManager.J(this.f241002d).T();
        if (T != null) {
            this.f241009h.f241049a = T.v().f241049a;
            this.f241009h.f241050b = T.v().f241050b;
            this.f241009h.f241053e = T.v().f241053e;
            if (T.z()) {
                T.x(T.v().f241062n, T.v().f241063o);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileMusicBoxController", 2, "showLyrics");
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f241009h.f241063o)) {
            super.R(f241033o0, this.f241009h.f241063o);
            return;
        }
        this.f241004e.add(f241033o0 + "_" + str);
        if (!z()) {
            super.R(f241033o0, str);
            FloatTextLayout floatTextLayout = this.F;
            if (floatTextLayout != null) {
                floatTextLayout.l();
            }
        }
        FloatViewSkin.o().n(this.E, str, f241033o0);
    }

    public void v0() {
        QQPlayerService.m1(BaseApplication.getContext());
        q0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements BusinessObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && (obj instanceof GetQzoneMusicInfoRsp)) {
                GetQzoneMusicInfoRsp getQzoneMusicInfoRsp = (GetQzoneMusicInfoRsp) obj;
                if (!ProfileMusicBoxController.this.f241038l0 && getQzoneMusicInfoRsp.mMusicList.containsKey(ProfileMusicBoxController.this.f241036j0.E)) {
                    ProfileMusicBoxController.this.f241036j0.f251870h = getQzoneMusicInfoRsp.mMusicList.get(ProfileMusicBoxController.this.f241036j0.E).sSongUrl;
                    ProfileMusicBoxController.this.m0(BaseApplication.getContext(), ProfileMusicBoxController.this.f241036j0);
                    return;
                }
                SongInfo[] j06 = QQPlayerService.j0();
                if (j06 != null) {
                    for (int i16 = 0; i16 < j06.length; i16++) {
                        if (getQzoneMusicInfoRsp.mMusicList.containsKey(j06[i16].E)) {
                            SongInfo songInfo = j06[i16];
                            songInfo.f251870h = getQzoneMusicInfoRsp.mMusicList.get(songInfo.E).sSongUrl;
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileMusicBoxController", 2, "requestMusicSongUrl mid:" + j06[i16].E + " url:" + j06[i16].f251870h);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.music.g
    public String getToken() {
        return QQPlayerService.Y(4, "QQMusicWrap");
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (z16 && (obj instanceof GetMusicListRsp)) {
            GetMusicListRsp getMusicListRsp = (GetMusicListRsp) obj;
            ArrayList arrayList = new ArrayList();
            this.f241035i0 = new SongInfo[getMusicListRsp.stMusicList.vMusicList.size()];
            for (int i16 = 0; i16 < getMusicListRsp.stMusicList.vMusicList.size(); i16++) {
                this.f241035i0[i16] = new SongInfo();
                this.f241035i0[i16].E = getMusicListRsp.stMusicList.vMusicList.get(i16).sSongId;
                this.f241035i0[i16].f251872m = getMusicListRsp.stMusicList.vMusicList.get(i16).sAlbumName;
                this.f241035i0[i16].C = getMusicListRsp.stMusicList.vMusicList.get(i16).sPic;
                this.f241035i0[i16].f251871i = getMusicListRsp.stMusicList.vMusicList.get(i16).sSongName;
                this.f241035i0[i16].L = getMusicListRsp.stMusicList.vMusicList.get(i16).iDuration;
                SongInfo songInfo = this.f241035i0[i16];
                songInfo.I = 10;
                songInfo.f251869f = this.f241034h0;
                if (songInfo.E.equals(this.f241036j0.E)) {
                    this.f241035i0[i16].f251870h = this.f241036j0.f251870h;
                }
                StringBuilder sb5 = new StringBuilder();
                for (int i17 = 0; i17 < getMusicListRsp.stMusicList.vMusicList.get(i16).vSingerList.size(); i17++) {
                    if (i17 != 0) {
                        sb5.append("/");
                    }
                    sb5.append(getMusicListRsp.stMusicList.vMusicList.get(i16).vSingerList.get(i17).sSingerName);
                }
                this.f241035i0[i16].F = sb5.toString();
                arrayList.add(getMusicListRsp.stMusicList.vMusicList.get(i16).sSongId);
            }
            QQPlayerService.d1(this.f241035i0);
            p0();
        }
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlayStateChanged(int i3) {
        String str;
        SongInfo b06;
        if (i3 == 1 || i3 == 2) {
            SongInfo b07 = QQPlayerService.b0();
            if (b07.I == 10) {
                k kVar = this.f241037k0;
                if (kVar != null) {
                    kVar.a(b07, true);
                }
                k0(b07);
                if (!z()) {
                    u0(String.valueOf(this.f241034h0));
                }
                FloatIconLayout floatIconLayout = this.E;
                if (floatIconLayout != null) {
                    floatIconLayout.setPlayState(true);
                }
                this.f241038l0 = true;
                this.f241039m0 = System.currentTimeMillis();
            } else {
                g0();
            }
        } else if (i3 == 3) {
            k kVar2 = this.f241037k0;
            if (kVar2 != null) {
                kVar2.b(2);
            }
            r0(false);
            this.f241038l0 = false;
            String valueOf = String.valueOf(this.f241034h0);
            if (this.f241040n0) {
                str = "0X800A7D9";
            } else {
                str = "0X800A7DE";
            }
            ReportController.o(null, "dc00898", "", valueOf, QQPermissionConstants.Business.SCENE.QQ_VIP, str, FloatViewSkin.o().p() ? 1 : 2, 0, String.valueOf((System.currentTimeMillis() - this.f241039m0) / 1000), "", "", "");
        } else if (i3 == 4) {
            q0();
            this.f241038l0 = false;
        } else if (i3 != 7) {
            if (i3 == 8 && (b06 = QQPlayerService.b0()) != null && TextUtils.isEmpty(b06.f251870h) && b06.I == 10) {
                this.f241038l0 = false;
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(b06.E);
                o0(this.f241034h0, arrayList);
            }
        } else {
            this.f241038l0 = false;
            SongInfo b08 = QQPlayerService.b0();
            if (b08 != null && b08.I == 10) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(b08.E);
                o0(this.f241034h0, arrayList2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileMusicBoxController", 2, "onPlayStateChanged playState:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.LyricsController
    protected void Q() {
    }
}
