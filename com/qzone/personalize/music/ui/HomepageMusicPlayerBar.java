package com.qzone.personalize.music.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.b;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.music.model.UserMusicInfo;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.music.QzoneMusicConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import e8.e;
import e8.f;
import java.util.List;

/* loaded from: classes39.dex */
public class HomepageMusicPlayerBar extends BaseMusicPlayerBar {
    private List<UserMusicInfo> M;
    private List<BroadcastMusicInfo> N;
    protected Context P;
    private boolean Q;
    private boolean R;
    private int S;
    private byte T;
    private byte U;
    protected View V;
    protected View W;

    /* renamed from: a0, reason: collision with root package name */
    private e.a f49414a0;

    /* renamed from: b0, reason: collision with root package name */
    protected Handler f49415b0;

    public HomepageMusicPlayerBar(Context context, long j3) {
        super(context);
        this.Q = false;
        this.R = false;
        this.f49415b0 = new Handler(Looper.getMainLooper());
        L(context, j3);
    }

    private String H() {
        int i3 = this.f49390e;
        if (2 == i3) {
            return "livefm";
        }
        if (1 == i3) {
            return "radio";
        }
        return "music";
    }

    public static byte J(int i3, int i16, int i17) {
        if (1 == i16) {
            return (byte) 105;
        }
        if (i17 == 0) {
            return (byte) 103;
        }
        return (byte) 102;
    }

    private boolean M() {
        String str;
        CoverCacheData coverFromCache = CoverComponentProxy.f50099g.getServiceInterface().getCoverFromCache(this.L);
        return (coverFromCache == null || (str = coverFromCache.type) == null || !str.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_MUSIC_COVER)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i3) {
        final long j3;
        int i16;
        e.a aVar;
        e.a currentState = f.a().b().getCurrentState();
        this.f49414a0 = currentState;
        if (currentState != null) {
            j3 = currentState.f395853c;
            i16 = currentState.f395851a;
        } else {
            j3 = 0;
            i16 = 1;
        }
        if (this.T == 1 && NetworkState.isWifiConn() && this.Q && i3 == 2 && ((i16 == 1 || j3 != this.L) && getWindowVisibility() == 0 && !M() && (j3 != this.L || (aVar = this.f49414a0) == null || aVar.f395854d != 2))) {
            d();
        }
        e.a aVar2 = this.f49414a0;
        if (aVar2 != null && aVar2.f395854d == 2 && aVar2.f395851a != 2) {
            QZLog.i("HomepageMusicPlayerBar", "\u6b63\u5728\u8bd5\u542c\u8282\u76ee\uff0c\u4e0d\u4fee\u6539\u64ad\u653e\u6a21\u5f0f");
        } else {
            f.a().b().setPlayMode(Byte.valueOf(this.U).intValue());
        }
        this.f49415b0.post(new Runnable() { // from class: com.qzone.personalize.music.ui.HomepageMusicPlayerBar.4
            @Override // java.lang.Runnable
            public void run() {
                if (!HomepageMusicPlayerBar.this.Q) {
                    HomepageMusicPlayerBar.this.V.setVisibility(0);
                    HomepageMusicPlayerBar.this.f49394m.setVisibility(8);
                } else {
                    HomepageMusicPlayerBar.this.V.setVisibility(8);
                    HomepageMusicPlayerBar.this.f49394m.setVisibility(0);
                }
                HomepageMusicPlayerBar.this.f49394m.setVisibility(0);
                HomepageMusicPlayerBar.this.C.setVisibility(0);
                HomepageMusicPlayerBar.this.setVisibility(0);
                HomepageMusicPlayerBar.this.p(0);
                if (HomepageMusicPlayerBar.this.f49414a0 != null) {
                    HomepageMusicPlayerBar.this.f49394m.setClickable(true);
                    HomepageMusicPlayerBar.this.f49394m.setFocusable(true);
                    if (HomepageMusicPlayerBar.this.f49414a0.f395854d != 2) {
                        HomepageMusicPlayerBar.this.f49394m.setContentDescription(l.a(R.string.n8o));
                        HomepageMusicPlayerBar homepageMusicPlayerBar = HomepageMusicPlayerBar.this;
                        homepageMusicPlayerBar.f49394m.setImageDrawable(homepageMusicPlayerBar.I());
                    } else {
                        if (HomepageMusicPlayerBar.this.f49414a0.f395852b != null) {
                            long j16 = j3;
                            HomepageMusicPlayerBar homepageMusicPlayerBar2 = HomepageMusicPlayerBar.this;
                            if (j16 == homepageMusicPlayerBar2.L && homepageMusicPlayerBar2.f49414a0.f395851a == 2) {
                                HomepageMusicPlayerBar homepageMusicPlayerBar3 = HomepageMusicPlayerBar.this;
                                homepageMusicPlayerBar3.f49394m.setImageDrawable(homepageMusicPlayerBar3.K());
                                if (!TextUtils.isEmpty(HomepageMusicPlayerBar.this.f49414a0.f395852b.f251871i)) {
                                    HomepageMusicPlayerBar homepageMusicPlayerBar4 = HomepageMusicPlayerBar.this;
                                    homepageMusicPlayerBar4.f49393i.setText(homepageMusicPlayerBar4.f49414a0.f395852b.f251871i);
                                }
                            }
                        }
                        HomepageMusicPlayerBar.this.f49394m.setContentDescription(l.a(R.string.n8r));
                    }
                }
                HomepageMusicPlayerBar homepageMusicPlayerBar5 = HomepageMusicPlayerBar.this;
                if (homepageMusicPlayerBar5.f49390e == 2) {
                    if (homepageMusicPlayerBar5.N != null && HomepageMusicPlayerBar.this.N.size() > 0) {
                        int size = HomepageMusicPlayerBar.this.N.size();
                        BroadcastMusicInfo broadcastMusicInfo = (BroadcastMusicInfo) HomepageMusicPlayerBar.this.N.get(0);
                        HomepageMusicPlayerBar homepageMusicPlayerBar6 = HomepageMusicPlayerBar.this;
                        int i17 = homepageMusicPlayerBar6.I;
                        if (-1 < i17 && i17 < size) {
                            broadcastMusicInfo = (BroadcastMusicInfo) homepageMusicPlayerBar6.N.get(HomepageMusicPlayerBar.this.I);
                        }
                        HomepageMusicPlayerBar.this.f49391f = broadcastMusicInfo.f(NetworkState.isWifiConn());
                        HomepageMusicPlayerBar.this.s();
                    }
                    HomepageMusicPlayerBar.this.C.setText((CharSequence) null);
                    return;
                }
                if (!homepageMusicPlayerBar5.R) {
                    if (HomepageMusicPlayerBar.this.M == null || HomepageMusicPlayerBar.this.M.size() <= 0) {
                        return;
                    }
                    int size2 = HomepageMusicPlayerBar.this.M.size();
                    UserMusicInfo userMusicInfo = (UserMusicInfo) HomepageMusicPlayerBar.this.M.get(0);
                    HomepageMusicPlayerBar homepageMusicPlayerBar7 = HomepageMusicPlayerBar.this;
                    int i18 = homepageMusicPlayerBar7.I;
                    if (-1 < i18 && i18 < size2) {
                        userMusicInfo = (UserMusicInfo) homepageMusicPlayerBar7.M.get(HomepageMusicPlayerBar.this.I);
                    }
                    HomepageMusicPlayerBar.this.f49391f = userMusicInfo.toQusicInfo();
                    HomepageMusicPlayerBar.this.s();
                    if (HomepageMusicPlayerBar.this.S >= 0) {
                        HomepageMusicPlayerBar.this.C.setText(Integer.toString(HomepageMusicPlayerBar.this.S) + l.a(R.string.n8q));
                        return;
                    }
                    return;
                }
                HomepageMusicPlayerBar.this.C.setText(Integer.toString(HomepageMusicPlayerBar.this.S) + l.a(R.string.n8v));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.f49415b0.post(new Runnable() { // from class: com.qzone.personalize.music.ui.HomepageMusicPlayerBar.3
            @Override // java.lang.Runnable
            public void run() {
                if (HomepageMusicPlayerBar.this.L == LoginData.getInstance().getUin()) {
                    HomepageMusicPlayerBar.this.Q();
                } else if (QZoneConfigHelper.H0() != 0) {
                    HomepageMusicPlayerBar.this.Q();
                } else {
                    HomepageMusicPlayerBar.this.setVisibility(8);
                    HomepageMusicPlayerBar.this.p(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.V.setVisibility(8);
        this.f49394m.setImportantForAccessibility(2);
        this.f49394m.setImageResource(R.drawable.fyg);
        this.C.setVisibility(4);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewBackgroundMusic", "\u80cc\u666f\u97f3\u4e50");
        int i3 = this.f49390e;
        if (i3 == 2) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewBackGroundFM", "\u80cc\u666f\u7535\u53f0");
        } else if (i3 == 1) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewBackGroundVoice", "\u80cc\u666f\u97f3\u9891");
        }
        this.f49393i.setText(config);
        setVisibility(0);
        p(0);
    }

    protected int G() {
        return R.layout.bh9;
    }

    protected Drawable I() {
        return getResources().getDrawable(R.drawable.fyh);
    }

    protected Drawable K() {
        return getResources().getDrawable(R.drawable.fyl);
    }

    protected void L(Context context, long j3) {
        this.L = j3;
        this.P = context;
        this.V = findViewById(R.id.f166645gu4);
        this.W = findViewById(R.id.klo);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f49393i.getLayoutParams();
        layoutParams.addRule(0, R.id.gu6);
        setMinimumHeight(ViewUtils.dip2px(48.0f));
        this.f49393i.setLayoutParams(layoutParams);
        this.D.setVisibility(8);
        this.F.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    public void b() {
        Intent b16;
        int i3 = this.f49390e;
        if (2 == i3 || 1 == i3) {
            b16 = f.a().c().b(this.L, QzoneMusicConst.QusicFrom.HOME_PAGE);
        } else if (3 == i3) {
            b16 = f.a().c().k(this.L, QzoneMusicConst.QusicFrom.HOME_PAGE);
        } else {
            b16 = f.a().c().e(this.L, QzoneMusicConst.QusicFrom.HOME_PAGE);
        }
        if (b16 != null) {
            b.d(getContext(), b16);
        }
        long uin = LoginData.getInstance().getUin();
        ClickReport.r("", "", "getMainPage", true, String.valueOf(308), String.valueOf(14), String.valueOf(this.L == uin ? 8 : 10), "", "", "", "", (this.f49389d == 2 ? 1 : 2) + "", H());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    public void d() {
        if (!this.Q) {
            Intent e16 = f.a().c().e(this.L, QzoneMusicConst.QusicFrom.HOME_PAGE);
            if (this.f49390e == 3 && this.f49414a0 != null) {
                e16 = f.a().c().k(this.f49414a0.f395853c, QzoneMusicConst.QusicFrom.HOME_PAGE);
            }
            if (e16 != null) {
                b.d(getContext(), e16);
                return;
            }
            return;
        }
        if (this.f49390e == 2) {
            List<BroadcastMusicInfo> list = this.N;
            if (list == null || list.size() == 0) {
                return;
            }
        } else {
            List<UserMusicInfo> list2 = this.M;
            if (list2 == null || list2.size() == 0) {
                return;
            }
        }
        int i3 = this.f49389d;
        if (i3 == 1 || i3 == 2) {
            SongInfo songInfo = this.f49391f;
            if (songInfo != null && songInfo.I == 9) {
                f.a().b().a();
            } else {
                f.a().b().pauseMusic();
            }
            O(2);
            return;
        }
        if (i3 != 3) {
            if (this.f49390e == 2) {
                f.a().b().d(BroadcastMusicInfo.g(this.N, NetworkState.isWifiConn()), this.I, this.S, this.L, 102, 2);
            } else {
                f.a().b().n(UserMusicInfo.toQusicInfoList(this.M), this.I, this.S, this.L, this.U);
            }
            O(1);
            return;
        }
        SongInfo songInfo2 = this.f49391f;
        if (songInfo2 != null && songInfo2.I == 9) {
            f.a().b().m(this.f49391f);
        } else {
            f.a().b().b();
        }
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void f() {
        LayoutInflater.from(getContext()).inflate(G(), this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, ar.e(48.0f));
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected boolean g() {
        return false;
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void n(e.a aVar) {
        List<BroadcastMusicInfo> list;
        if (TextUtils.isEmpty(this.f49393i.getText())) {
            s();
        } else {
            List<UserMusicInfo> list2 = this.M;
            if (list2 != null && list2.isEmpty() && (list = this.N) != null && list.isEmpty()) {
                Q();
            }
        }
        if (aVar != null && aVar.f395851a == 2 && aVar.f395853c == this.L) {
            s();
            SongInfo songInfo = aVar.f395852b;
            if (songInfo != null && songInfo.I == 9) {
                this.C.setText((CharSequence) null);
                return;
            }
            if (aVar.f395857g >= 0) {
                this.C.setText(Integer.toString(aVar.f395857g) + l.a(R.string.n8n));
                return;
            }
            this.C.setText(Integer.toString(this.S) + l.a(R.string.n8p));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    public void p(int i3) {
        Object parent;
        ViewParent parent2 = getParent();
        if (parent2 != null && (parent = parent2.getParent()) != null && (parent instanceof View) && ((View) parent).getVisibility() == 0) {
            super.p(i3);
        }
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void q(int i3) {
        if (this.f49389d == i3) {
            return;
        }
        this.f49389d = i3;
        if (i3 == 1) {
            ProgressBar progressBar = this.G;
            if (progressBar != null) {
                progressBar.setVisibility(0);
                this.G.setIndeterminate(true);
                this.G.setContentDescription(l.a(R.string.n8m));
                this.f49394m.setVisibility(4);
                return;
            }
            return;
        }
        if (i3 != 2) {
            ProgressBar progressBar2 = this.G;
            if (progressBar2 != null) {
                progressBar2.setVisibility(4);
                this.G.setIndeterminate(false);
                this.f49394m.setVisibility(0);
            }
            this.f49394m.setImportantForAccessibility(1);
            this.f49394m.setContentDescription(l.a(R.string.n8t));
            this.f49394m.setImageDrawable(I());
            return;
        }
        ProgressBar progressBar3 = this.G;
        if (progressBar3 != null) {
            progressBar3.setVisibility(4);
            this.G.setIndeterminate(false);
            this.f49394m.setVisibility(0);
        }
        this.f49394m.setImportantForAccessibility(1);
        this.f49394m.setContentDescription(l.a(R.string.n8u));
        this.f49394m.setImageDrawable(K());
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void l() {
        this.R = false;
    }

    private void O(int i3) {
        long uin = LoginData.getInstance().getUin();
        String H = H();
        if (this.L == uin) {
            ClickReport.r("", "", "", true, String.valueOf(308), String.valueOf(14), String.valueOf(9), "", "", "", "", i3 + "", H);
            return;
        }
        ClickReport.r("", "", "", true, String.valueOf(308), String.valueOf(14), String.valueOf(11), "", "", "", "", i3 + "", H);
    }

    public void R(final List<BroadcastMusicInfo> list, boolean z16, int i3, final byte b16, final byte b17, final int i16, final int i17, final byte b18) {
        this.Q = z16;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.personalize.music.ui.HomepageMusicPlayerBar.1
            @Override // java.lang.Runnable
            public void run() {
                x6.a g16 = z5.a.f().g(LoginData.getInstance().getUin());
                if (g16 != null) {
                    HomepageMusicPlayerBar.this.T = g16.wifiAutoPlayFlag;
                } else {
                    HomepageMusicPlayerBar.this.T = b16;
                }
                HomepageMusicPlayerBar.this.U = HomepageMusicPlayerBar.J(i17, b17, b18);
                HomepageMusicPlayerBar homepageMusicPlayerBar = HomepageMusicPlayerBar.this;
                homepageMusicPlayerBar.f49390e = i17;
                homepageMusicPlayerBar.N = list;
                if (HomepageMusicPlayerBar.this.N == null || HomepageMusicPlayerBar.this.N.size() == 0) {
                    HomepageMusicPlayerBar.this.P();
                } else {
                    HomepageMusicPlayerBar.this.N(i16);
                }
            }
        });
    }

    public void S(final List<UserMusicInfo> list, boolean z16, int i3, final byte b16, final byte b17, final int i16, final int i17, final byte b18) {
        this.S = i3;
        this.Q = z16;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.personalize.music.ui.HomepageMusicPlayerBar.2
            @Override // java.lang.Runnable
            public void run() {
                x6.a g16 = z5.a.f().g(LoginData.getInstance().getUin());
                if (g16 != null) {
                    HomepageMusicPlayerBar.this.T = g16.wifiAutoPlayFlag;
                } else {
                    HomepageMusicPlayerBar.this.T = b16;
                }
                HomepageMusicPlayerBar.this.U = HomepageMusicPlayerBar.J(i17, b17, b18);
                HomepageMusicPlayerBar homepageMusicPlayerBar = HomepageMusicPlayerBar.this;
                homepageMusicPlayerBar.f49390e = i17;
                homepageMusicPlayerBar.M = list;
                if (HomepageMusicPlayerBar.this.M == null || HomepageMusicPlayerBar.this.M.size() == 0) {
                    HomepageMusicPlayerBar.this.P();
                } else {
                    HomepageMusicPlayerBar.this.N(i16);
                }
            }
        });
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected boolean m(int i3, long j3) {
        e.a f16;
        boolean z16 = i3 == 2 && j3 == this.L;
        this.R = z16;
        if (!z16 && (f16 = f.a().b().f()) != null) {
            long j16 = f16.f395853c;
            long j17 = this.L;
            if (j16 == j17) {
                this.f49391f = f16.f395852b;
                this.I = f16.f395855e;
                int i16 = f16.f395856f;
                this.J = i16;
                if (i16 != 0) {
                    s();
                    if (this.f49391f.I == 9) {
                        this.C.setText((CharSequence) null);
                    } else if (f16.f395857g >= 0) {
                        this.C.setText(Integer.toString(f16.f395857g) + l.a(R.string.n8w));
                    }
                    setVisibility(0);
                    p(0);
                    this.R = true;
                } else if (j17 != LoginData.getInstance().getUin()) {
                    setVisibility(8);
                    p(8);
                }
            }
        }
        return z16;
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void c() {
    }
}
