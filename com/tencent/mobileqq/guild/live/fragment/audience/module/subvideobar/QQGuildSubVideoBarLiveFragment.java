package com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyPanelFragment;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildSubVideoBarVM;
import com.tencent.mobileqq.guild.live.widget.GuildLiveBlurURLImageView;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.h;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildSubVideoBarLiveFragment extends QQGuildLiveModuleBaseFragment implements View.OnClickListener, nq1.e {
    private View D;
    private TextView E;
    private TextView F;
    private TextView G;
    private GuildLiveBlurURLImageView H;
    private RelativeLayout I;
    private View J;
    private FrameLayout K;
    private View L;
    private View M;
    private QQProgressDialog N;
    private QQGuildSubVideoBarVM P;
    private TipsBar Q;
    private ImageView R;
    private boolean S;
    private final Handler C = new Handler(Looper.getMainLooper());
    private float T = 1.0f;
    private e12.e<Float> U = new e12.e<>();
    private final Runnable V = new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment.1
        @Override // java.lang.Runnable
        public void run() {
            QQGuildSubVideoBarLiveFragment.this.J.setVisibility(8);
            QQGuildSubVideoBarLiveFragment.this.Vh();
        }
    };
    private final INetworkStateApi.a W = new INetworkStateApi.a() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment.2
        @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
        public void onNetworkConnect(final boolean z16) {
            QQGuildSubVideoBarLiveFragment.this.Q.post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment.2.1
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    TipsBar tipsBar = QQGuildSubVideoBarLiveFragment.this.Q;
                    if (z16) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    tipsBar.setVisibility(i3);
                }
            });
        }
    };
    private final Observer<View> X = new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.c
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            QQGuildSubVideoBarLiveFragment.this.Lh((View) obj);
        }
    };

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (QQGuildSubVideoBarLiveFragment.this.J.getVisibility() != 8 && bool == Boolean.TRUE) {
                QQGuildSubVideoBarLiveFragment.this.C.removeCallbacksAndMessages(null);
                QQGuildSubVideoBarLiveFragment.this.J.setVisibility(8);
            }
            QQGuildSubVideoBarLiveFragment.this.Vh();
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
            boolean z16 = true;
            QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "getSelfAllowStartLive:" + bool);
            if (!QQGuildSubVideoBarLiveFragment.this.S && bool == Boolean.TRUE) {
                QQGuildSubVideoBarLiveFragment.this.P.X1();
            }
            QQGuildSubVideoBarLiveFragment qQGuildSubVideoBarLiveFragment = QQGuildSubVideoBarLiveFragment.this;
            if (bool != Boolean.TRUE) {
                z16 = false;
            }
            qQGuildSubVideoBarLiveFragment.S = z16;
            QQGuildSubVideoBarLiveFragment.this.Wh();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements Observer<String> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            QLog.d("QGL.QQGuildSubVideoBarLiveFragment", 1, "getLiveRoomPosterUrl onChanged " + str);
            if (!TextUtils.isEmpty(str)) {
                QQGuildSubVideoBarLiveFragment.this.H.p(str, null, 10);
                QQGuildSubVideoBarLiveFragment.this.I.setBackgroundColor(Color.parseColor("#BF121216"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements Observer<String> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            QLog.d("QGL.QQGuildSubVideoBarLiveFragment", 4, "getShowErrToastEvent" + str);
            aa.e(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements Observer<Long> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            QQGuildSubVideoBarLiveFragment.this.Wh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            QQGuildSubVideoBarLiveFragment.this.Fh();
            if (bool.booleanValue()) {
                QQGuildSubVideoBarLiveFragment.this.Gh();
            } else {
                h.b(Constants.Business.QQ_GUILD_LIVE_AUTHOR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        QQProgressDialog qQProgressDialog = this.N;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.N.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        if (AppSetting.t(getContext()) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity(getActivity())) {
            i.e(getContext(), intent.getExtras(), LiveReadyPanelFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).b(R.anim.f154637p9, R.anim.f154634p6).h(LaunchMode.standard).a());
        } else {
            QPublicFragmentActivity.b.b(getContext(), intent, QPublicTransFragmentActivity.class, LiveReadyPanelFragment.class);
        }
    }

    private void Hh() {
        if (getActivity() != null) {
            getActivity().startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    private void Ih() {
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        guildDTReportApiImpl.setElementExposureAndClickParams(this.L, "em_stream_star_type", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(this.M, "em_stream_star_type", null);
    }

    private boolean Jh(Context context) {
        boolean z16;
        try {
            if (context.getResources().getConfiguration().orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "[isLandScreen] landScreen:" + z16);
            return z16;
        } catch (NullPointerException e16) {
            QLog.e("QGL.QQGuildSubVideoBarLiveFragment", 1, e16, new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(Integer num) {
        Th();
        Ph();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(View view) {
        boolean z16;
        if (view != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Qh(z16);
    }

    public static QQGuildLiveModuleBaseFragment Nh() {
        return new QQGuildSubVideoBarLiveFragment();
    }

    private void Oh() {
        QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "onClickStartLive");
        if (o.c("QGL.start_live_click")) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildSubVideoBarLiveFragment", 2, "click too fast return");
            }
        } else {
            if (com.tencent.mobileqq.guild.setting.mute.c.l(getGuildId())) {
                Sh();
                return;
            }
            showLoadingDialog();
            GuildTimeRecHelper.g(GuildLiveTimeEvent.CLICK_START_BETWEEN_PREPARE_PAGE_SHOW);
            l.c("live_room_start_live_clicked");
            this.P.R1(getActivity()).observe(getViewLifecycleOwner(), new f());
        }
    }

    private void Ph() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!Jh(activity) && !TransitionHelper.isFolderScreenOpenMode(activity)) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cgo);
            float u16 = GLiveChannelCore.f226698a.t().u(activity);
            float f16 = dimensionPixelSize;
            if (u16 >= f16) {
                u16 = 1.0f;
                f16 = this.T;
            }
            float f17 = u16 / f16;
            if (f17 == this.T) {
                QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "[setLayoutSize] skip by same ratio");
                return;
            }
            this.T = f17;
            QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "[setLayoutSize] ratio = " + f17);
            this.U.postValue(Float.valueOf(f17));
            return;
        }
        QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "[setLayoutSize] skip by land screen or folder screen open mode");
    }

    private void Qh(boolean z16) {
        int i3;
        View view = this.D;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
    }

    private void Rh(boolean z16) {
        int i3;
        int i16;
        QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "setStartEnterViewVisible: " + z16);
        View view = this.L;
        int i17 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.M;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        view2.setVisibility(i16);
        TextView textView = this.G;
        if (z16) {
            i17 = 8;
        }
        textView.setVisibility(i17);
    }

    private void Sh() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            String v3 = com.tencent.mobileqq.guild.setting.mute.c.v(getGuildId());
            if (v3.isEmpty()) {
                return;
            }
            com.tencent.mobileqq.guild.util.qqui.c.b(activity, 230, null, v3, null, activity.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQGuildSubVideoBarLiveFragment.Mh(dialogInterface, i3);
                }
            }, null).show();
        }
    }

    private void Th() {
        if (getActivity() == null) {
            return;
        }
        int a16 = (int) (gq1.b.a(r0) * 0.048f);
        this.D.setPadding(a16, (int) (GLiveChannelCore.f226698a.t().u(r0) * 0.24204703f), a16, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh(Float f16) {
        QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "[updateUIWithRatio] ratio:" + f16);
        if (f16 != null && f16.floatValue() != 1.0f) {
            for (int i3 = 0; i3 < this.K.getChildCount(); i3++) {
                QQGuildUIUtil.B(this.K.getChildAt(i3), f16.floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        if (!GLiveChannelCore.f226698a.s().isLiving()) {
            this.R.setImageResource(R.drawable.guild_live_start_pic);
        } else {
            this.R.setImageDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
        if (!((Boolean) e12.d.b(GLiveChannelCore.f226698a.t().C(), Boolean.FALSE)).booleanValue()) {
            Rh(false);
        } else {
            Rh(true);
        }
    }

    private String getGuildId() {
        return GLiveChannelCore.f226698a.s().getGuildId();
    }

    private void showLoadingDialog() {
        if (this.N == null) {
            this.N = new QQProgressDialog(getActivity());
        }
        this.N.show();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        GLiveChannelCore.f226698a.t().z().removeObserver(this.X);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ex_;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        gLiveChannelCore.t().z().observe(getViewLifecycleOwner(), this.X);
        gLiveChannelCore.t().n().observe(getViewLifecycleOwner(), new a());
        LiveData<Boolean> C = gLiveChannelCore.t().C();
        this.S = ((Boolean) e12.d.b(C, Boolean.FALSE)).booleanValue();
        C.observe(getViewLifecycleOwner(), new b());
        gLiveChannelCore.t().r().observe(getViewLifecycleOwner(), new c());
        this.P.S1().observe(getViewLifecycleOwner(), new d());
        com.tencent.mobileqq.guild.setting.mute.c.C(getGuildId()).observe(this, new e());
        gLiveChannelCore.t().t().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubVideoBarLiveFragment.this.Kh((Integer) obj);
            }
        });
        this.U.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubVideoBarLiveFragment.this.Uh((Float) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NonNull View view) {
        int i3;
        this.K = (FrameLayout) view.findViewById(R.id.if5);
        this.D = view.findViewById(R.id.wnl);
        this.L = view.findViewById(R.id.wnc);
        this.M = view.findViewById(R.id.wnd);
        this.G = (TextView) view.findViewById(R.id.swq);
        this.R = (ImageView) view.findViewById(R.id.wnq);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.J = view.findViewById(R.id.wni);
        this.E = (TextView) view.findViewById(R.id.wnm);
        this.F = (TextView) view.findViewById(R.id.wnj);
        this.H = (GuildLiveBlurURLImageView) view.findViewById(R.id.wmf);
        this.I = (RelativeLayout) view.findViewById(R.id.wme);
        TipsBar tipsBar = (TipsBar) view.findViewById(R.id.wnh);
        this.Q = tipsBar;
        tipsBar.setBarType(2);
        this.Q.setTipsText(getString(R.string.f1510816q));
        this.Q.setTipsIcon(getResources().getDrawable(R.drawable.common_banner_tips_warning));
        this.Q.setOnClickListener(this);
        TipsBar tipsBar2 = this.Q;
        boolean z16 = false;
        if (((INetworkStateApi) QRoute.api(INetworkStateApi.class)).isNetworkAvailable()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        tipsBar2.setVisibility(i3);
        Th();
        if (GLiveChannelCore.f226698a.t().z().getValue() != null) {
            z16 = true;
        }
        Qh(z16);
        Ih();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initViewModel() {
        this.P = (QQGuildSubVideoBarVM) com.tencent.mobileqq.guild.live.viewmodel.i.a(this).get(QQGuildSubVideoBarVM.class);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mLiveModuleControl.g(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.wnc && view.getId() != R.id.wnd) {
            if (view.getId() == R.id.wnh) {
                Hh();
            }
        } else {
            Oh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.C.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mLiveModuleControl.g(null);
    }

    @Override // nq1.e
    public void onEndLiveEvent(@NonNull sq1.b bVar) {
        String format;
        this.P.X1();
        QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, "onEndLiveEvent allowStartLive:" + GLiveChannelCore.f226698a.t().C().getValue());
        this.J.setVisibility(0);
        String valueOf = String.valueOf(bVar.g());
        this.F.setText(valueOf);
        long h16 = bVar.h();
        if (h16 < 3600) {
            format = String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(h16 / 60), Long.valueOf(h16 % 60));
        } else {
            long j3 = h16 / 60;
            format = String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf(j3 / 60), Long.valueOf(j3 % 60), Long.valueOf(h16 % 60));
        }
        this.E.setText(format);
        this.C.removeCallbacksAndMessages(null);
        this.C.postDelayed(this.V, 180000L);
        HashMap hashMap = new HashMap();
        hashMap.put("live_room_end_num", valueOf);
        hashMap.put("live_room_end_time", format);
        l.f("end_live_event_detail", hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(this.W);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.P.X1();
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(this.W);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        boolean z16;
        super.onViewCreated(view, bundle);
        if (GLiveChannelCore.f226698a.t().z().getValue() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Qh(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Mh(DialogInterface dialogInterface, int i3) {
    }
}
