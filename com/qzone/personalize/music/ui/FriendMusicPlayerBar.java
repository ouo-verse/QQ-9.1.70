package com.qzone.personalize.music.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.model.CustomPlayerData;
import com.qzone.personalize.music.business.QusicService;
import com.qzone.reborn.configx.g;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.music.QzoneMusicConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import e8.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class FriendMusicPlayerBar extends BaseMusicPlayerBar {
    private WeakReference<e8.b> M;
    private ImageView N;
    private long P;
    private CustomPlayerData Q;
    private Drawable R;
    private AnimationDrawable S;
    private com.tencent.mobileqq.vas.ui.c T;
    private ActionSheet U;
    private f V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private QzoneZipCacheHelperCallBack f49398a0;

    /* renamed from: b0, reason: collision with root package name */
    private AnimationDrawableLoadedListener f49399b0;

    /* renamed from: c0, reason: collision with root package name */
    private Handler f49400c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ClickReport.r("", "", "", true, "427", "2", "1", "", FriendMusicPlayerBar.this.O());
            if (FriendMusicPlayerBar.this.V != null) {
                FriendMusicPlayerBar.this.V.a(FriendMusicPlayerBar.this.f49391f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class b implements ActionSheet.OnButtonClickListener {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            Intent e16;
            int i16;
            Context context;
            if (FriendMusicPlayerBar.this.U == null || FriendMusicPlayerBar.this.U.getActionMenuItem(i3) != null) {
                if (FriendMusicPlayerBar.this.U != null) {
                    FriendMusicPlayerBar.this.U.dismiss();
                }
                int i17 = FriendMusicPlayerBar.this.U != null ? FriendMusicPlayerBar.this.U.getActionMenuItem(i3).action : -1;
                if (i17 != 0) {
                    if (i17 != 1) {
                        return;
                    }
                    if (FriendMusicPlayerBar.this.P != LoginData.getInstance().getUin() && FriendMusicPlayerBar.this.Q != null && FriendMusicPlayerBar.this.Q.iItemId != -1) {
                        vo.c.r(FriendMusicPlayerBar.this.getContext(), FriendMusicPlayerBar.this.Q.iItemId);
                        return;
                    } else {
                        vo.c.h(FriendMusicPlayerBar.this.getContext());
                        return;
                    }
                }
                String str = "2";
                if (FriendMusicPlayerBar.this.W != 5) {
                    if (FriendMusicPlayerBar.this.W != 3) {
                        if (FriendMusicPlayerBar.this.W != 6) {
                            if (FriendMusicPlayerBar.this.W == 1) {
                                SongInfo songInfo = FriendMusicPlayerBar.this.f49391f;
                                if (songInfo != null && songInfo.I == 9) {
                                    e16 = e8.f.a().c().b(FriendMusicPlayerBar.this.P, QzoneMusicConst.QusicFrom.MINI_BAR);
                                } else if (songInfo != null && songInfo.I == 6) {
                                    e16 = e8.f.a().c().b(FriendMusicPlayerBar.this.P, QzoneMusicConst.QusicFrom.MINI_BAR);
                                } else if (songInfo != null && songInfo.I == 11) {
                                    e16 = e8.f.a().c().f(FriendMusicPlayerBar.this.P, FriendMusicPlayerBar.this.f49391f.E, QzoneMusicConst.QusicFrom.MINI_BAR);
                                } else {
                                    e16 = songInfo != null ? e8.f.a().c().i(FriendMusicPlayerBar.this.f49391f.f251867d) : null;
                                }
                            } else {
                                SongInfo songInfo2 = FriendMusicPlayerBar.this.f49391f;
                                if (songInfo2 != null && songInfo2.I == 9) {
                                    e16 = e8.f.a().c().b(FriendMusicPlayerBar.this.P, QzoneMusicConst.QusicFrom.MINI_BAR);
                                    str = "4";
                                } else if (songInfo2 != null && ((i16 = songInfo2.I) == 8 || i16 == 6)) {
                                    e16 = e8.f.a().c().b(FriendMusicPlayerBar.this.L, QzoneMusicConst.QusicFrom.MINI_BAR);
                                    str = "3";
                                } else if (songInfo2 != null && songInfo2.I == 11) {
                                    e16 = e8.f.a().c().k(FriendMusicPlayerBar.this.P, QzoneMusicConst.QusicFrom.MINI_BAR);
                                } else {
                                    e16 = e8.f.a().c().e(FriendMusicPlayerBar.this.L, QzoneMusicConst.QusicFrom.MINI_BAR);
                                }
                            }
                        } else {
                            e16 = e8.f.a().c().b(FriendMusicPlayerBar.this.P, QzoneMusicConst.QusicFrom.MINI_BAR);
                        }
                    } else {
                        e16 = QusicService.O().R();
                    }
                } else {
                    e16 = QusicService.O().R();
                }
                ClickReport.r("", "", "", true, "427", "3", str);
                if (e16 == null || (context = FriendMusicPlayerBar.this.getContext()) == null) {
                    return;
                }
                context.startActivity(e16);
            }
        }
    }

    /* loaded from: classes39.dex */
    class d extends AnimationDrawableLoadedListener {
        d() {
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedFailed() {
            QZLog.e("FriendMusicPlayerBar", "on loaded sub zip animation error");
            super.onLoadedFailed();
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            FriendMusicPlayerBar.this.S = animationDrawable;
            FriendMusicPlayerBar.this.S.setOneShot(false);
            FriendMusicPlayerBar.this.Y();
            super.onLoadedSuccess(animationDrawable);
        }
    }

    /* loaded from: classes39.dex */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                FriendMusicPlayerBar.this.k(message.arg1, message.arg2);
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes39.dex */
    public interface f {
        void a(SongInfo songInfo);

        void onClose();
    }

    public FriendMusicPlayerBar(Context context, e8.b bVar) {
        super(context);
        this.U = null;
        this.f49398a0 = new c();
        this.f49399b0 = new d();
        this.f49400c0 = new e(Looper.getMainLooper());
        Q(context, bVar);
    }

    private void Q(Context context, e8.b bVar) {
        this.M = new WeakReference<>(bVar);
        this.C.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.gu7);
        this.N = imageView;
        imageView.setOnClickListener(new a());
        try {
            setBackgroundResource(R.drawable.qzone_selector_feed_music_bar);
        } catch (OutOfMemoryError e16) {
            QZLog.e("FriendMusicPlayerBar", "OutOfMemoryError " + e16);
        }
        setPadding(0, 0, 0, 0);
    }

    private static boolean R(int i3) {
        if (i3 != 5 && i3 != 6 && i3 != 8 && i3 != 9 && i3 != 11) {
            return true;
        }
        return false;
    }

    private static boolean S(int i3, long j3) {
        if (i3 == 8 || i3 == 6 || j3 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        QusicService.O().p0(this);
    }

    private void U(int i3) {
        ClickReport.r("", "", "", true, "427", "4", String.valueOf(i3), "", O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.f49400c0.post(new Runnable() { // from class: com.qzone.personalize.music.ui.FriendMusicPlayerBar.5
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                final CustomPlayerData customPlayerData = FriendMusicPlayerBar.this.Q;
                if (customPlayerData != null && customPlayerData.iItemId > 0) {
                    FriendMusicPlayerBar friendMusicPlayerBar = FriendMusicPlayerBar.this;
                    friendMusicPlayerBar.X(friendMusicPlayerBar.D, "button_close.png", ViewUtils.dpToPx(26.0f), ViewUtils.dpToPx(26.0f));
                    FriendMusicPlayerBar friendMusicPlayerBar2 = FriendMusicPlayerBar.this;
                    friendMusicPlayerBar2.X(friendMusicPlayerBar2.N, "button_download.png", ViewUtils.dpToPx(26.0f), ViewUtils.dpToPx(26.0f));
                    try {
                        i3 = Color.parseColor("#" + Long.toHexString(customPlayerData.lTextColor));
                    } catch (Exception unused) {
                        QZLog.e("FriendMusicPlayerBar", "parse color error " + customPlayerData.lTextColor);
                        i3 = -1;
                    }
                    FriendMusicPlayerBar.this.f49393i.setTextColor(i3);
                    FriendMusicPlayerBar.this.C.setTextColor(i3);
                    QzoneZipAnimateUtil.c(FriendMusicPlayerBar.this, "business_music_player", customPlayerData.iItemId + "", "music_bg.9.png");
                    QzoneZipAnimateUtil.c(FriendMusicPlayerBar.this.F, "business_music_player", customPlayerData.iItemId + "", "music_progress.9.png");
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.personalize.music.ui.FriendMusicPlayerBar.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (customPlayerData != null) {
                                FriendMusicPlayerBar.this.R = QzoneZipAnimateUtil.k("business_music_player", customPlayerData.iItemId + "", "button_stop.png", ViewUtils.dpToPx(36.0f), ViewUtils.dpToPx(36.0f));
                                if (QzoneZipAnimateUtil.f60590a) {
                                    FriendMusicPlayerBar.this.T = QzoneZipAnimateUtil.f("business_music_player", customPlayerData.iItemId + "", "button_playing", ViewUtils.dpToPx(36.0f), ViewUtils.dpToPx(36.0f));
                                } else {
                                    QzoneZipAnimateUtil.h("business_music_player", customPlayerData.iItemId + "", "button_playing", ViewUtils.dpToPx(36.0f), ViewUtils.dpToPx(36.0f), 100, FriendMusicPlayerBar.this.f49399b0);
                                }
                                FriendMusicPlayerBar.this.Y();
                            }
                        }
                    });
                    return;
                }
                FriendMusicPlayerBar friendMusicPlayerBar3 = FriendMusicPlayerBar.this;
                friendMusicPlayerBar3.f49393i.setTextColor(friendMusicPlayerBar3.getResources().getColor(R.color.f157904a80));
                FriendMusicPlayerBar friendMusicPlayerBar4 = FriendMusicPlayerBar.this;
                friendMusicPlayerBar4.C.setTextColor(friendMusicPlayerBar4.getResources().getColor(R.color.f157904a80));
                try {
                    FriendMusicPlayerBar.this.setBackgroundResource(R.drawable.qzone_selector_feed_music_bar);
                } catch (Throwable th5) {
                    QZLog.e("FriendMusicPlayerBar", "exception " + th5.getMessage());
                }
                FriendMusicPlayerBar.this.setPadding(0, 0, 0, 0);
                FriendMusicPlayerBar.this.N.setImageResource(R.drawable.gdf);
                FriendMusicPlayerBar.this.D.setImageResource(R.drawable.g19);
                FriendMusicPlayerBar.this.F.setBackgroundResource(R.drawable.g2n);
                FriendMusicPlayerBar.this.Y();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(final ImageView imageView, final String str, final int i3, final int i16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.personalize.music.ui.FriendMusicPlayerBar.7
            @Override // java.lang.Runnable
            public void run() {
                if (FriendMusicPlayerBar.this.Q != null) {
                    final Drawable k3 = QzoneZipAnimateUtil.k("business_music_player", FriendMusicPlayerBar.this.Q.iItemId + "", str, i3, i16);
                    if (imageView == null || FriendMusicPlayerBar.this.f49400c0 == null) {
                        return;
                    }
                    FriendMusicPlayerBar.this.f49400c0.post(new Runnable() { // from class: com.qzone.personalize.music.ui.FriendMusicPlayerBar.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageView imageView2 = imageView;
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(k3);
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        this.f49400c0.post(new Runnable() { // from class: com.qzone.personalize.music.ui.FriendMusicPlayerBar.6
            @Override // java.lang.Runnable
            public void run() {
                FriendMusicPlayerBar friendMusicPlayerBar = FriendMusicPlayerBar.this;
                if (friendMusicPlayerBar.f49389d != 2) {
                    if (friendMusicPlayerBar.Q != null && FriendMusicPlayerBar.this.Q.iItemId > 0 && FriendMusicPlayerBar.this.R != null) {
                        FriendMusicPlayerBar friendMusicPlayerBar2 = FriendMusicPlayerBar.this;
                        friendMusicPlayerBar2.f49394m.setImageDrawable(friendMusicPlayerBar2.R);
                        return;
                    } else {
                        FriendMusicPlayerBar.this.f49394m.setImageResource(R.drawable.fyi);
                        return;
                    }
                }
                if (QzoneZipAnimateUtil.f60590a) {
                    if (friendMusicPlayerBar.Q != null && FriendMusicPlayerBar.this.Q.iItemId > 0 && FriendMusicPlayerBar.this.T != null) {
                        FriendMusicPlayerBar friendMusicPlayerBar3 = FriendMusicPlayerBar.this;
                        friendMusicPlayerBar3.f49394m.setImageDrawable(friendMusicPlayerBar3.T.getDrawable());
                        return;
                    } else {
                        FriendMusicPlayerBar.this.f49394m.setImageResource(R.drawable.fym);
                        return;
                    }
                }
                if (friendMusicPlayerBar.Q != null && FriendMusicPlayerBar.this.Q.iItemId > 0 && FriendMusicPlayerBar.this.S != null) {
                    FriendMusicPlayerBar friendMusicPlayerBar4 = FriendMusicPlayerBar.this;
                    friendMusicPlayerBar4.f49394m.setImageDrawable(friendMusicPlayerBar4.S);
                    FriendMusicPlayerBar.this.S.start();
                    return;
                }
                FriendMusicPlayerBar.this.f49394m.setImageResource(R.drawable.fym);
            }
        });
    }

    public void M() {
        this.f49400c0.removeCallbacksAndMessages(null);
        if (g.f53821a.b().G()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.personalize.music.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    FriendMusicPlayerBar.this.T();
                }
            });
        } else {
            QusicService.O().p0(this);
        }
    }

    protected int N() {
        return R.layout.bh8;
    }

    public String O() {
        SongInfo songInfo = this.f49391f;
        if (songInfo == null) {
            return "music";
        }
        int i3 = songInfo.I;
        if (i3 == 9) {
            return "livefm";
        }
        if (i3 != 8 && i3 != 6) {
            return "music";
        }
        return "radio";
    }

    public void P() {
        this.f49400c0.removeMessages(0);
        e8.f.a().b().a();
        setVisibility(8);
        p(8);
        f fVar = this.V;
        if (fVar != null) {
            fVar.onClose();
        }
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void b() {
        int i3;
        int i16 = this.W;
        if (i16 == 1 || i16 == 5 || i16 == 3) {
            i3 = R.string.ggf;
        } else if (i16 == 6) {
            i3 = R.string.gge;
        } else {
            SongInfo songInfo = this.f49391f;
            if (songInfo == null || songInfo.I != 8) {
                i3 = (songInfo == null || songInfo.I != 9) ? R.string.ggi : R.string.ggg;
            } else {
                i3 = R.string.ggh;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(getContext(), i3), 0, 0));
        arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(getContext(), R.string.f173044go0), 1, 0));
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getContext(), arrayList, new b());
        this.U = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
        this.U.show();
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void c() {
        P();
        ClickReport.r("", "", "", true, "427", "5");
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void d() {
        switch (this.f49389d) {
            case 1:
            case 2:
                SongInfo songInfo = this.f49391f;
                if (songInfo != null && songInfo.I == 9) {
                    e8.f.a().b().a();
                    U(2);
                    return;
                } else {
                    e8.f.a().b().pauseMusic();
                    return;
                }
            case 3:
                this.f49400c0.removeMessages(0);
                e8.f.a().b().b();
                return;
            case 4:
            case 5:
            case 6:
                e8.f.a().b().m(this.f49391f);
                U(1);
                return;
            default:
                this.f49400c0.removeMessages(0);
                e8.f.a().b().a();
                U(2);
                return;
        }
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void f() {
        LayoutInflater.from(getContext()).inflate(N(), this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, ar.e(58.0f));
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void h() {
        this.f49400c0.removeMessages(0);
        this.C.setVisibility(4);
        this.F.setVisibility(4);
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void j() {
        this.f49400c0.removeMessages(0);
        Object parent = getParent();
        boolean isShown = parent instanceof View ? ((View) parent).isShown() : false;
        if (!isShown()) {
            setVisibility(0);
        }
        if (!isShown) {
            p(0);
        }
        this.C.setVisibility(4);
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void k(int i3, int i16) {
        int i17;
        ImageView imageView = this.N;
        if (imageView != null && (((i17 = this.f49391f.I) == 5 || i17 == 7) && imageView.isShown())) {
            this.N.setVisibility(4);
        }
        int i18 = i16 - i3;
        this.f49400c0.removeMessages(0);
        if (this.f49389d == 2 && i18 > 0) {
            this.f49400c0.sendMessageDelayed(this.f49400c0.obtainMessage(0, i3 + 1, i16), 1000L);
        }
        Object parent = getParent();
        boolean isShown = parent instanceof View ? ((View) parent).isShown() : false;
        if (!isShown()) {
            setVisibility(0);
        }
        if (!isShown) {
            p(0);
        }
        int width = getWidth() - ViewUtils.dpToPx(18.0f);
        if (i16 == 0 || width == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.width = ((width * i3) / i16) + ViewUtils.dpToPx(18.0f);
        this.F.setLayoutParams(layoutParams);
        this.F.setVisibility(0);
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void l() {
        this.f49400c0.removeMessages(0);
        SongInfo songInfo = this.f49391f;
        if (songInfo == null || songInfo.I == 9) {
            return;
        }
        setVisibility(8);
        p(8);
        f fVar = this.V;
        if (fVar != null) {
            fVar.onClose();
        }
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected boolean m(int i3, long j3) {
        this.W = i3;
        this.L = j3;
        return true;
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void n(e.a aVar) {
        if (this.f49391f != null) {
            s();
        }
        SongInfo songInfo = this.f49391f;
        if (songInfo == null || !S(songInfo.I, songInfo.f251867d) || this.N == null) {
            return;
        }
        if (R(this.f49391f.I)) {
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    public void p(int i3) {
        e8.b bVar = this.M.get();
        if (bVar != null) {
            bVar.a(i3 == 0);
        } else {
            super.p(i3);
        }
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void q(int i3) {
        AnimationDrawable animationDrawable;
        com.tencent.mobileqq.vas.ui.c cVar;
        Drawable drawable;
        if (this.f49389d == i3) {
            return;
        }
        this.f49389d = i3;
        if (i3 == 1) {
            ProgressBar progressBar = this.G;
            if (progressBar != null) {
                progressBar.setVisibility(0);
                this.G.setIndeterminate(true);
                this.G.setContentDescription(l.a(R.string.msb));
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
            this.f49394m.setContentDescription(l.a(R.string.ms_));
            CustomPlayerData customPlayerData = this.Q;
            if (customPlayerData != null && customPlayerData.iItemId > 0 && (drawable = this.R) != null) {
                this.f49394m.setImageDrawable(drawable);
                return;
            } else {
                this.f49394m.setImageResource(R.drawable.fyi);
                return;
            }
        }
        ProgressBar progressBar3 = this.G;
        if (progressBar3 != null) {
            progressBar3.setVisibility(4);
            this.G.setIndeterminate(false);
            this.f49394m.setVisibility(0);
        }
        this.f49394m.setImportantForAccessibility(1);
        this.f49394m.setContentDescription(l.a(R.string.msa));
        if (QzoneZipAnimateUtil.f60590a) {
            CustomPlayerData customPlayerData2 = this.Q;
            if (customPlayerData2 != null && customPlayerData2.iItemId > 0 && (cVar = this.T) != null) {
                this.f49394m.setImageDrawable(cVar.getDrawable());
                return;
            } else {
                this.f49394m.setImageResource(R.drawable.fym);
                return;
            }
        }
        CustomPlayerData customPlayerData3 = this.Q;
        if (customPlayerData3 != null && customPlayerData3.iItemId > 0 && (animationDrawable = this.S) != null) {
            this.f49394m.setImageDrawable(animationDrawable);
            this.S.start();
        } else {
            this.f49394m.setImageResource(R.drawable.fym);
        }
    }

    public void setOnMusicBarClickListener(f fVar) {
        this.V = fVar;
    }

    public void setPageUin(long j3) {
        this.P = j3;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.personalize.music.ui.FriendMusicPlayerBar.8
            @Override // java.lang.Runnable
            public void run() {
                FriendMusicPlayerBar.this.V(com.qzone.personalize.business.b.n().f(FriendMusicPlayerBar.this.P));
            }
        }, 1000L);
    }

    /* loaded from: classes39.dex */
    class c implements QzoneZipCacheHelperCallBack {
        c() {
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResult(boolean z16) {
            if (z16) {
                FriendMusicPlayerBar.this.W();
            } else {
                FriendMusicPlayerBar.this.Q = null;
                QZLog.e("FriendMusicPlayerBar", "download url fail");
            }
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResultOfNativeRequest(boolean z16, String str, String str2) {
        }
    }

    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void i() {
        setVisibility(0);
        p(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.width = 0;
        this.F.setLayoutParams(layoutParams);
    }

    public void V(CustomPlayerData customPlayerData) {
        if (customPlayerData == null || customPlayerData.uin != this.P) {
            return;
        }
        CustomPlayerData customPlayerData2 = this.Q;
        if (customPlayerData2 != null && customPlayerData2.iItemId == customPlayerData.iItemId) {
            W();
            return;
        }
        this.Q = customPlayerData;
        if (customPlayerData.iItemId == -1) {
            W();
            return;
        }
        QzoneZipAnimateUtil.d(customPlayerData.strPlayerDecoUrl, "business_music_player", this.Q.iItemId + "", this.f49398a0);
    }
}
