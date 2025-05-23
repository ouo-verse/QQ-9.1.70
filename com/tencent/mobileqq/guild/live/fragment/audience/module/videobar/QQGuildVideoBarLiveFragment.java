package com.tencent.mobileqq.guild.live.fragment.audience.module.videobar;

import android.content.res.Configuration;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.module.videobar.QQGuildLiveBaseVideoBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.m;
import com.tencent.mobileqq.guild.live.widget.GuildLiveNetLoadingView;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.UiThreadUtil;
import java.util.HashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildVideoBarLiveFragment extends QQGuildLiveBaseVideoBarFragment implements View.OnClickListener {
    private static WeakReference<Object> M;
    private ImageView C;
    private ImageView D;
    private View E;
    private View F;
    private FrameLayout G;
    private GuildLiveNetLoadingView H;
    private FrameLayout I;
    private tq1.b J = GLiveChannelCore.f226698a.t();
    private final Observer<View> K = new a();
    private View L;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer<View> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(View view) {
            QQGuildVideoBarLiveFragment.this.Lh(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            boolean z16;
            QQGuildVideoBarLiveFragment qQGuildVideoBarLiveFragment = QQGuildVideoBarLiveFragment.this;
            if (bool != Boolean.TRUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            qQGuildVideoBarLiveFragment.Jh(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            boolean z16;
            QQGuildVideoBarLiveFragment qQGuildVideoBarLiveFragment = QQGuildVideoBarLiveFragment.this;
            if (bool == Boolean.TRUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            qQGuildVideoBarLiveFragment.Jh(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            boolean z16;
            QQGuildVideoBarLiveFragment qQGuildVideoBarLiveFragment = QQGuildVideoBarLiveFragment.this;
            Boolean bool2 = Boolean.TRUE;
            if (bool == bool2) {
                z16 = true;
            } else {
                z16 = false;
            }
            qQGuildVideoBarLiveFragment.zh(z16);
            if (bool == bool2 && QQGuildVideoBarLiveFragment.this.getShowHideAnimHelper() != null) {
                QQGuildVideoBarLiveFragment.this.getShowHideAnimHelper().I();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (!bool.booleanValue()) {
                QQGuildVideoBarLiveFragment.this.C.setImageDrawable(QQGuildVideoBarLiveFragment.this.getResources().getDrawable(R.drawable.guild_live_video_full_icon));
            } else {
                QQGuildVideoBarLiveFragment.this.C.setImageDrawable(QQGuildVideoBarLiveFragment.this.getResources().getDrawable(R.drawable.guild_vertical_to_horizontal));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(Boolean bool) {
        if (bool.booleanValue()) {
            this.D.setImageResource(R.drawable.guild_live_danmu_enable);
        } else {
            this.D.setImageResource(R.drawable.guild_live_danmu_disable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(Integer num) {
        if (num.intValue() == 1) {
            this.D.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(View view) {
        xh(this.G, view);
    }

    public static QQGuildLiveModuleBaseFragment Dh() {
        return new QQGuildVideoBarLiveFragment();
    }

    private void Eh() {
        if (!((Boolean) e12.d.b(this.J.n(), Boolean.FALSE)).booleanValue()) {
            QLog.w("QGL.QQGuildVideoBarLiveFragment", 1, "onClickVideoFullScreenView, did not enter the room.");
        } else {
            this.J.V(Boolean.valueOf(!((Boolean) e12.d.b(this.J.g(), r1)).booleanValue()));
        }
    }

    private void Fh() {
        QLog.d("QGL.QQGuildVideoBarLiveFragment", 1, "[onClickRootView] ");
        if (getShowHideAnimHelper() != null) {
            getShowHideAnimHelper().H();
        }
    }

    private void Gh() {
        if (!((Boolean) e12.d.b(this.J.n(), Boolean.FALSE)).booleanValue()) {
            QLog.w("QGL.QQGuildVideoBarLiveFragment", 1, "onClickVideoFullScreenView, did not enter the room.");
            return;
        }
        this.E.setVisibility(8);
        boolean booleanValue = ((Boolean) e12.d.b(this.J.J(), Boolean.TRUE)).booleanValue();
        if (booleanValue) {
            l.b(2, 0);
            if (AppSetting.t(getContext())) {
                this.J.b0(2);
            } else {
                this.J.T(0);
            }
        } else {
            this.J.b0(1);
        }
        l.d("live_room_float_window", "is_video_land", String.valueOf(booleanValue));
    }

    private void Hh() {
        QLog.i("QGL.QQGuildVideoBarLiveFragment", 1, "removeVideoPlayerView ");
        this.G.removeAllViews();
    }

    private void Ih(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgroup_stream_aio_zoom", 1);
        ch.f235509b.setElementExposureAndClickParams(this.C, "em_stream_aio_zoom", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(boolean z16) {
        FrameLayout frameLayout = this.I;
        if (frameLayout == null) {
            return;
        }
        if (z16) {
            this.H.setGravity(17);
            if (this.H.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.H.getParent()).removeView(this.H);
            }
            this.I.addView(this.H);
            return;
        }
        frameLayout.removeView(this.H);
    }

    private void Kh(FrameLayout frameLayout) {
        View value = GLiveChannelCore.f226698a.t().z().getValue();
        if (value != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildVideoBarLiveFragment", 2, "tryAddVideoViewIfHad.");
            }
            xh(frameLayout, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(final View view) {
        if (view == null) {
            Hh();
        } else if ((view instanceof ViewGroup) && (((ViewGroup) view).getChildAt(0) instanceof TextureView)) {
            xh(this.G, view);
        } else {
            this.G.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQGuildVideoBarLiveFragment.this.Ch(view);
                }
            }, 200L);
        }
    }

    private void xh(FrameLayout frameLayout, View view) {
        WeakReference<Object> weakReference = M;
        if (weakReference != null && weakReference.get() == this) {
            if (frameLayout.indexOfChild(view) >= 0) {
                return;
            }
            m K = this.J.K();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.QQGuildVideoBarLiveFragment", 2, "videoView.parent remove.");
                }
                if (K != null) {
                    K.disableViewCallback();
                }
                ((ViewGroup) parent).removeView(view);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            QLog.i("QGL.QQGuildVideoBarLiveFragment", 1, "containerView add videoView suc." + view);
            frameLayout.addView(view, 0, layoutParams);
            if (K != null) {
                K.enableViewCallback();
                return;
            }
            return;
        }
        QLog.i("QGL.QQGuildVideoBarLiveFragment", 1, "addVideoPlayerView ignore. cur frag is invalid. ");
    }

    private void yh(View view) {
        this.D = (ImageView) view.findViewById(R.id.wo7);
        if (!com.tencent.mobileqq.guild.live.viewmodel.d.P1()) {
            this.D.setVisibility(8);
            return;
        }
        this.D.setOnClickListener(this);
        this.J.g().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildVideoBarLiveFragment.this.Ah((Boolean) obj);
            }
        });
        this.J.l().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildVideoBarLiveFragment.this.Bh((Integer) obj);
            }
        });
        if (getShowHideAnimHelper() != null) {
            getShowHideAnimHelper().h(this.D, "mVideoDanmu");
            getShowHideAnimHelper().j(this.D, "mVideoDanmu");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(boolean z16) {
        this.G.setKeepScreenOn(z16);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        this.J.z().removeObserver(this.K);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ewr;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.QQGuildVideoBarLiveFragment.2
            @Override // java.lang.Runnable
            public void run() {
                QQGuildVideoBarLiveFragment.this.Jh(!Boolean.TRUE.equals(QQGuildVideoBarLiveFragment.this.J.y().getValue()));
            }
        }, 350L);
        this.J.y().observe(getViewLifecycleOwner(), new b());
        this.J.z().observeForever(this.K);
        this.J.x().observe(getViewLifecycleOwner(), new c());
        this.J.n().observe(getViewLifecycleOwner(), new d());
        this.J.J().observe(getViewLifecycleOwner(), new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NonNull View view) {
        M = new WeakReference<>(this);
        this.I = (FrameLayout) view.findViewById(R.id.wo9);
        this.F = view;
        this.C = (ImageView) view.findViewById(R.id.wo8);
        yh(view);
        this.E = view.findViewById(R.id.f912654p);
        if (getShowHideAnimHelper() != null) {
            getShowHideAnimHelper().h(this.C, "mVideo2FullView");
            getShowHideAnimHelper().j(this.C, "mVideo2FullView");
            getShowHideAnimHelper().m(this.E, "mSwitchContainer");
        }
        this.C.setOnClickListener(this);
        this.H = new GuildLiveNetLoadingView(getContext());
        View findViewById = view.findViewById(R.id.wo5);
        this.L = findViewById;
        findViewById.setOnClickListener(this);
        view.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.wo_);
        this.G = frameLayout;
        Kh(frameLayout);
        Ih(view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.wo8) {
            Gh();
        } else if (view.getId() == R.id.wo5) {
            Fh();
        } else if (view.getId() == R.id.wo7) {
            Eh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        if (QLog.isColorLevel()) {
            QLog.d("QGL.QQGuildVideoBarLiveFragment", 2, "onConfigurationChanged");
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.J.z().removeObserver(this.K);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        FrameLayout frameLayout = this.G;
        if (frameLayout != null) {
            Kh(frameLayout);
        }
        super.onResume();
    }
}
