package com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ep;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.event.GuildSpeakManageGuideShowEvent;
import com.tencent.mobileqq.guild.event.GuildUserCardDismissEvent;
import com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildProfileCardDismissEvent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.main.GuildProfileHeaderComponent;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* loaded from: classes14.dex */
public class GuildProfileCard extends BottomSheetDialogFragment implements SimpleEventReceiver<SimpleBaseEvent> {
    private static volatile boolean Q = false;
    private static WeakReference<e> R = new WeakReference<>(null);
    private GuildProfileData D;
    private View E;
    private ViewGroup F;
    private PersonalProfileBottomPanel G;
    private ScanningLightView H;
    private l I;
    private IGuildComponentController K;
    private Context L;
    private Context M;
    private final Runnable C = new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.1
        @Override // java.lang.Runnable
        public void run() {
            GuildProfileCard.this.H.setVisibility(8);
            if (GuildProfileCard.this.K != null) {
                GuildProfileCard.this.K.onLoadFinish();
            }
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(GuildProfileCard.this.C);
        }
    };
    private Rect J = new Rect();
    private final Application.ActivityLifecycleCallbacks N = new b();
    private i.a P = new c();

    /* loaded from: classes14.dex */
    class a extends BottomSheetBehavior.e {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            GuildProfileCard.this.Ch();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            QLog.d("Guild.profile.GuildProfileCard", 4, "onStateChanged\uff1anewState=" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class d implements IGuildComponentController.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController.a
        public View getRootView() {
            return GuildProfileCard.this.E;
        }
    }

    /* loaded from: classes14.dex */
    public interface e {
        void a();

        void b();

        void c();
    }

    private void Ah() {
        if (getDialog().getWindow() == null) {
            QLog.w("Guild.profile.GuildProfileCard", 1, "getWindow is null");
            return;
        }
        this.G = new PersonalProfileBottomPanel(getContext());
        ViewGroup viewGroup = (ViewGroup) ((CoordinatorLayout) getDialog().getWindow().getDecorView().findViewById(R.id.u9g)).getParent();
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(this.G);
        viewGroup.addView(frameLayout);
        this.G.setLogicParent(this.E);
    }

    private void Bh() {
        Sh(this.G.getHeight());
        this.G.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.f
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildProfileCard.this.Fh(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch() {
        int width = this.G.getWidth();
        int height = this.G.getHeight();
        if (width > 0 && height > 0) {
            int[] iArr = new int[2];
            this.F.getLocationOnScreen(iArr);
            int dimensionPixelSize = iArr[1] + BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.cdf);
            int[] iArr2 = new int[2];
            this.G.getLocationOnScreen(iArr2);
            int i3 = iArr2[1];
            if (dimensionPixelSize <= i3) {
                this.J.set(0, 0, width, height);
            } else {
                this.J.set(0, Math.min(dimensionPixelSize - i3, height), width, height);
            }
            this.G.setClipBounds(this.J);
            return;
        }
        QLog.w("Guild.profile.GuildProfileCard", 1, "clipBottomPanel: " + width + "," + height);
    }

    private void Dh(Fragment fragment, AppInterface appInterface) {
        com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.a aVar = new com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.a(wv1.a.d(this.D));
        this.K = aVar;
        aVar.init(fragment, this.D, new d());
        this.K.setContentViewContainer(this.F);
        this.K.onCreate(fragment, appInterface, null);
        this.K.onInitData(this.D);
        this.K.setDismissAction(new xv1.b() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.g
            @Override // xv1.b
            public final void onDismiss() {
                GuildProfileCard.this.dismissAllowingStateLoss();
            }
        });
    }

    private static boolean Eh(Activity activity, String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            aa.d(R.string.f148380zf);
            return false;
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.w("Guild.profile.GuildProfileCard", 2, "openCard app is null!");
                return false;
            }
            if (!FastClickUtils.isFastDoubleClick("Guild.profile.GuildProfileCard") && !Q) {
                if (TextUtils.isEmpty(((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId())) {
                    QLog.e("Guild.profile.GuildProfileCard", 1, "selfTinyId is empty");
                    return false;
                }
                if (!TextUtils.isEmpty(str) && !str.equals("0")) {
                    return true;
                }
                QLog.e("Guild.profile.GuildProfileCard", 1, "dstTinyId is " + str);
                return false;
            }
            QLog.w("Guild.profile.GuildProfileCard", 1, "openCard dialog is showing, sShownDialog: " + Q);
            return false;
        }
        QLog.d("Guild.profile.GuildProfileCard", 1, "activity is null or finish or destroy");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29 = i18 - i16;
        if (i29 != i28 - i26) {
            Sh(i29);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(Boolean bool) {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        GuildProfileHeaderComponent guildProfileHeaderComponent = (GuildProfileHeaderComponent) this.K.getComponent(1000);
        if (guildProfileHeaderComponent != null) {
            guildProfileHeaderComponent.onDirectMsgCreateInfoChange(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(Long l3) {
        if (l3 != null && getActivity() != null) {
            Nh(l3);
        }
    }

    public static boolean Lh(Activity activity, GuildProfileData guildProfileData) {
        QLog.d("Guild.profile.GuildProfileCard", 1, "openCard, params:" + guildProfileData.toString());
        if (!Eh(activity, guildProfileData.getGuildBaseProfileData().b())) {
            return false;
        }
        Ph(true);
        Oh(guildProfileData);
        Qh(activity, guildProfileData);
        return true;
    }

    public static boolean Mh(Activity activity, GuildProfileData guildProfileData, e eVar) {
        R = new WeakReference<>(eVar);
        return Lh(activity, guildProfileData);
    }

    private void Nh(Long l3) {
        if (StringUtil.isEmpty(this.D.getGuildBaseProfileData().a())) {
            QLog.e("Guild.profile.GuildProfileCard", 1, "openGiftPanel error, channel id is null");
            return;
        }
        int type = ch.B(this.D.getGuildBaseProfileData().a()).getType();
        if (type == 2) {
            Bundle c06 = com.tencent.mobileqq.guild.media.core.j.a().c0();
            if (c06 != null) {
                c06.putBoolean("open_gift_panel", true);
                c06.putLong("gift_receiver", l3.longValue());
            }
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(BaseApplication.context, com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo(), com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo(), c06);
            return;
        }
        if (type == 5) {
            GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
            s16.getBundle().putBoolean("open_gift_panel", true);
            s16.getBundle().putLong("gift_receiver", l3.longValue());
            gq1.c.e(s16);
            return;
        }
        QLog.e("Guild.profile.GuildProfileCard", 1, "openGiftPanel error, curSceneType is " + type);
    }

    private static void Oh(GuildProfileData guildProfileData) {
        String e16 = guildProfileData.getGuildBaseProfileData().e();
        if (TextUtils.isEmpty(e16)) {
            e16 = ((IGPSService) ch.R0(IGPSService.class)).getGuildIdOf(guildProfileData.getGuildBaseProfileData().l());
            guildProfileData.getGuildBaseProfileData().u(e16);
        }
        String selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
        if (TextUtils.equals(selfTinyId, guildProfileData.getGuildBaseProfileData().b())) {
            guildProfileData.getGuildBaseProfileData().C(selfTinyId);
            IGProGuildInfo guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(e16);
            if (guildInfo != null) {
                guildProfileData.getGuildBaseProfileData().D(guildInfo.getUserType());
                guildProfileData.getGuildBaseProfileData().t(guildInfo.getUserType());
            }
        }
        if (guildProfileData.isDirectMessage()) {
            GuildBaseProfileData guildBaseProfileData = guildProfileData.getGuildBaseProfileData();
            guildBaseProfileData.D(0);
            guildBaseProfileData.t(0);
        }
    }

    private static void Ph(boolean z16) {
        Q = z16;
    }

    private static void Qh(Activity activity, GuildProfileData guildProfileData) {
        String str;
        if (guildProfileData.getGuildBaseProfileData().q()) {
            GuildBaseProfileData guildBaseProfileData = guildProfileData.getGuildBaseProfileData();
            if (guildProfileData.isDirectMessage()) {
                str = "6";
            } else {
                str = "0";
            }
            RobotInfoFragment.wh((FragmentActivity) activity, guildBaseProfileData.a(), guildBaseProfileData.e(), guildBaseProfileData.b(), "", str, guildProfileData.isDirectMessage(), guildProfileData.getExtras().getInt("key_source_from", 0));
            Ph(false);
            return;
        }
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        GuildProfileCard guildProfileCard = new GuildProfileCard();
        guildProfileCard.D = guildProfileData;
        supportFragmentManager.beginTransaction().add(guildProfileCard, "Guild.profile.GuildProfileCard").commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Rh, reason: merged with bridge method [inline-methods] */
    public void Hh(com.tencent.mobileqq.guild.profile.profilecard.main.l lVar) {
        String string;
        int a16 = lVar.a();
        String c16 = lVar.c();
        if (a16 == -93) {
            aa.d(R.string.f148380zf);
            return;
        }
        Resources resources = getResources();
        if (a16 != 24000 && a16 != 36001) {
            if (a16 == 23000) {
                string = resources.getString(R.string.f1521719o);
            } else if (TextUtils.isEmpty(c16)) {
                return;
            } else {
                string = c16;
            }
        } else {
            string = resources.getString(R.string.f1521819p);
        }
        com.tencent.mobileqq.guild.util.security.b.c(getContext(), a16, c16, string);
    }

    private void Sh(int i3) {
        QLog.i("Guild.profile.GuildProfileCard", 1, "updateContainerPaddingBottom:" + i3);
        ViewGroup viewGroup = this.F;
        viewGroup.setPadding(viewGroup.getPaddingLeft(), this.F.getPaddingTop(), this.F.getPaddingRight(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Th, reason: merged with bridge method [inline-methods] */
    public void Ih(GuildProfileData guildProfileData) {
        if (this.K != null) {
            this.H.setVisibility(8);
            this.K.onUpdateData(guildProfileData);
            this.K.onLoadFinish();
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.C);
        } else {
            this.H.setVisibility(0);
            Dh(this, (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
            this.K.onResume();
            this.K.onLoadStart();
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.C, 700L);
        }
        PersonalProfileBottomPanel personalProfileBottomPanel = this.G;
        if (personalProfileBottomPanel != null) {
            personalProfileBottomPanel.z(guildProfileData.getUserProfileInfo().k());
        }
        if (R.get() != null) {
            R.get().c();
        }
    }

    private void Uh() {
        QLog.i("Guild.profile.GuildProfileCard", 1, "updateDialogMaxHeight");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        float instantScreenHeight = ScreenUtil.getInstantScreenHeight(requireContext());
        behavior.setPeekHeight((int) (0.6f * instantScreenHeight));
        behavior.setMaxHeight((int) (instantScreenHeight * 0.8f));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>(Arrays.asList(GuildSpeakManageGuideShowEvent.class, GuildProfileCardDismissEvent.class));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IGuildComponentController iGuildComponentController = this.K;
        if (iGuildComponentController == null) {
            return;
        }
        iGuildComponentController.onConfigurationChanged();
        Uh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        BaseApplication.getContext().registerActivityLifecycleCallbacks(this.N);
        com.tencent.mobileqq.pad.i.a(this.P);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        QLog.i("Guild.profile.GuildProfileCard", 1, "onCreateDialog");
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        float instantScreenHeight = ScreenUtil.getInstantScreenHeight(requireContext());
        behavior.setPeekHeight((int) (0.6f * instantScreenHeight));
        behavior.setMaxHeight((int) (instantScreenHeight * 0.9f));
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        FragmentActivity activity = getActivity();
        GuildProfileData guildProfileData = this.D;
        if (guildProfileData != null && activity != null) {
            if (guildProfileData.getGuildBaseProfileData().f() == 1) {
                getDialog().getWindow().clearFlags(2);
            }
            View inflate = layoutInflater.inflate(R.layout.f1y, viewGroup, false);
            this.E = inflate;
            this.F = (ViewGroup) inflate.findViewById(R.id.woi);
            ScanningLightView scanningLightView = (ScanningLightView) this.E.findViewById(R.id.f85764pu);
            this.H = scanningLightView;
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            this.H.setLightColorRes(R.color.qui_common_fill_light_secondary);
            view = this.E;
        } else {
            QLog.e("Guild.profile.GuildProfileCard", 1, "mGuildProfileData is null");
            dismissAllowingStateLoss();
            view = this.E;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.i("Guild.profile.GuildProfileCard", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        Ph(false);
        BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this.N);
        com.tencent.mobileqq.pad.i.d(this.P);
        IGuildComponentController iGuildComponentController = this.K;
        if (iGuildComponentController != null) {
            iGuildComponentController.onDestroy();
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.C);
        this.E = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        QLog.i("Guild.profile.GuildProfileCard", 1, "onDismiss");
        super.onDismiss(dialogInterface);
        Ph(false);
        if (R.get() != null) {
            R.get().b();
        }
        R = new WeakReference<>(null);
        SimpleEventBus.getInstance().dispatchEvent(new GuildUserCardDismissEvent());
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("Guild.profile.GuildProfileCard", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        IGuildComponentController iGuildComponentController = this.K;
        if (iGuildComponentController == null) {
            return;
        }
        iGuildComponentController.onPause();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildSpeakManageGuideShowEvent) {
            GuildSpeakManageGuideShowEvent guildSpeakManageGuideShowEvent = (GuildSpeakManageGuideShowEvent) simpleBaseEvent;
            GuildSpeakManageGuide.f224623a.i(guildSpeakManageGuideShowEvent.getReportInfo().getGuildId(), guildSpeakManageGuideShowEvent.getHintText(), guildSpeakManageGuideShowEvent.getReportInfo());
        } else if (simpleBaseEvent instanceof GuildProfileCardDismissEvent) {
            dismissAllowingStateLoss();
            QLog.i("Guild.profile.GuildProfileCard", 1, "onReceive GuildProfileCardDismissEvent");
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.i("Guild.profile.GuildProfileCard", 1, "onResume");
        super.onResume();
        ((ViewGroup) this.E.getParent()).setBackgroundColor(0);
        this.I.f2(this.D);
        if (R.get() != null) {
            R.get().a();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QLog.i("Guild.profile.GuildProfileCard", 1, "onStart");
        Context context = getContext();
        this.L = context;
        this.M = ep.b(context);
        l lVar = (l) l.I.create(l.class);
        this.I = lVar;
        lVar.g2(getActivity());
        this.I.U1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileCard.this.Gh((Boolean) obj);
            }
        });
        this.I.Z1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileCard.this.Hh((com.tencent.mobileqq.guild.profile.profilecard.main.l) obj);
            }
        });
        this.I.a2().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileCard.this.Ih((GuildProfileData) obj);
            }
        });
        this.I.W1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileCard.this.Jh((com.tencent.mobileqq.qqguildsdk.data.k) obj);
            }
        });
        this.I.X1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileCard.this.Kh((Long) obj);
            }
        });
        this.G.setParams(this.D, this.I);
        ((com.google.android.material.bottomsheet.a) getDialog()).getBehavior().addBottomSheetCallback(new a());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.i("Guild.profile.GuildProfileCard", 1, DKHippyEvent.EVENT_STOP);
        super.onStop();
        getContext();
        l lVar = this.I;
        if (lVar != null) {
            lVar.h2(getActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Ah();
        Bh();
    }

    /* loaded from: classes14.dex */
    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            GuildProfileCard.this.dismissAllowingStateLoss();
            BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }

    /* loaded from: classes14.dex */
    class c implements i.a {
        c() {
        }

        @Override // com.tencent.mobileqq.pad.i.a
        public void onStart() {
            GuildProfileCard.this.dismissAllowingStateLoss();
        }

        @Override // com.tencent.mobileqq.pad.i.a
        public void a(boolean z16) {
        }
    }
}
