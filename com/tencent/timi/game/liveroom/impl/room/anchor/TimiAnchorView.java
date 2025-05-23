package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback;
import com.tencent.mobileqq.qqlive.callback.luckybag.ReceiveLuckyBagMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataConfigInfo;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qqlive.room.floatview.QQLiveGameRoomService;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.chat.ChatMessagePageData;
import com.tencent.mobileqq.qqlive.sail.ui.chat.QQLiveChatMessageViewPagerAdapter;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetTeamBuildConfigRequest;
import com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.CustomTabLayout;
import com.tencent.mobileqq.qqlive.widget.chat.giftmsg.GiftMessageLayout;
import com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.timi.game.ad.ui.event.RefreshBatteryOperationEvent;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.component.qqlive.impl.anchor.QQLiveEndLiveEventByAdmin;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.timi.game.liveroom.impl.room.anchor.RtmpAnchorVideoOperateView;
import com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorView;
import com.tencent.timi.game.liveroom.impl.room.dynamicbg.RoomDynamicBgView;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.luckybag.view.ECommerceLuckyBagView;
import com.tencent.timi.game.liveroom.impl.room.floating.FloatViewConfig;
import com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager;
import com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout;
import com.tencent.timi.game.liveroom.impl.room.inscription.LivingInscriptionInterEntranceView;
import com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.liveroom.impl.room.live.widget.LiveTipsView;
import com.tencent.timi.game.liveroom.impl.room.manager.LiveBarrageMessageMgr;
import com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier;
import com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager;
import com.tencent.timi.game.liveroom.impl.room.message.stack.NormalFloatingBannerLogic;
import com.tencent.timi.game.liveroom.impl.room.more.AnchorMoreDialog;
import com.tencent.timi.game.liveroom.impl.room.notice.NoticeCommitEvent;
import com.tencent.timi.game.liveroom.impl.room.paylevel.bubble.view.PayLevelEnterRoomBubbleView;
import com.tencent.timi.game.liveroom.impl.room.playtogether.AnchorPlayTogetherDialog;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter;
import com.tencent.timi.game.liveroom.impl.room.report.AnchorQualityHelper;
import com.tencent.timi.game.liveroom.impl.room.util.TimiAnchorLiveInfoHelper;
import com.tencent.timi.game.liveroom.impl.room.view.AnchorCountDownView;
import com.tencent.timi.game.liveroom.impl.room.view.AnchorPrivateGuideView;
import com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.liveroom.impl.room.view.operation.TimiLiveOperationContainer;
import com.tencent.timi.game.liveroom.impl.room.widget.AnchorOperationBarView;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import ek4.PayLevelEnterRoomInfo;
import hn3.LinkScreenEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;
import trpc.yes.common.LiveActivityServerOuterClass$GetRoomPendantRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiAnchorView extends FrameLayout implements SimpleEventReceiver {
    private int A0;
    private String B0;
    private FrameLayout C;
    private AnchorPlayTogetherPresenter C0;
    private LiveTipsView D;
    private pj4.a D0;
    private TextView E;
    private TimiLiveOperationContainer E0;
    private AnchorTopAreaView F;
    private RtmpAnchorVideoOperateView F0;
    private FrameLayout G;
    private RoomDynamicBgView G0;
    private AnchorCountDownView H;
    private LiveBarrageMessageMgr H0;
    private AnchorPrivateGuideView I;
    private int I0;
    private View J;
    private BusConfigHelper.a J0;
    private FrameLayout K;
    private IQQLiveHideLotteryCallback K0;
    private NormalFloatingBannerLogic L;
    private bf4.b L0;
    private AnchorInputLayout M;
    private ViewPager2.OnPageChangeCallback M0;
    private AnchorOperationBarView N;
    private final Observer<PayLevelEnterRoomInfo> N0;
    private final Observer<QQLiveAnchorDataConfigInfo> O0;
    private LivingInscriptionInterEntranceView P;
    private final IQQCmdPushCallback P0;
    private TimiAnchorLiveInfoHelper Q;
    private final pj4.j R;
    private AnchorQualityHelper S;
    private LinearLayout T;
    private FrameLayout U;
    private boolean V;
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.b W;

    /* renamed from: a0, reason: collision with root package name */
    private jj4.d f377379a0;

    /* renamed from: b0, reason: collision with root package name */
    private ECommerceLuckyBagView f377380b0;

    /* renamed from: c0, reason: collision with root package name */
    private gk4.c f377381c0;

    /* renamed from: d, reason: collision with root package name */
    private IAegisLogApi f377382d;

    /* renamed from: d0, reason: collision with root package name */
    private int f377383d0;

    /* renamed from: e, reason: collision with root package name */
    private final qh2.h f377384e;

    /* renamed from: e0, reason: collision with root package name */
    private PayLevelEnterRoomBubbleView f377385e0;

    /* renamed from: f, reason: collision with root package name */
    private LifecycleOwner f377386f;

    /* renamed from: f0, reason: collision with root package name */
    private dk4.a f377387f0;

    /* renamed from: g0, reason: collision with root package name */
    private Eventor f377388g0;

    /* renamed from: h, reason: collision with root package name */
    private jg4.b f377389h;

    /* renamed from: h0, reason: collision with root package name */
    private int f377390h0;

    /* renamed from: i, reason: collision with root package name */
    private IQQLiveAnchorRoom f377391i;

    /* renamed from: i0, reason: collision with root package name */
    private ViewPager2 f377392i0;

    /* renamed from: j0, reason: collision with root package name */
    private QQLiveChatMessageViewPagerAdapter f377393j0;

    /* renamed from: k0, reason: collision with root package name */
    private CustomTabLayout f377394k0;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.sail.ui.chat.a f377395l0;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f377396m;

    /* renamed from: m0, reason: collision with root package name */
    private ChatMessageLayoutManager f377397m0;

    /* renamed from: n0, reason: collision with root package name */
    private RelativeLayout f377398n0;

    /* renamed from: o0, reason: collision with root package name */
    private TimiGamePAGView f377399o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.sail.ui.danmu.l f377400p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f377401q0;

    /* renamed from: r0, reason: collision with root package name */
    private OnEvent<LinkScreenEvent> f377402r0;

    /* renamed from: s0, reason: collision with root package name */
    private final ReceiveLuckyBagMessageListener f377403s0;

    /* renamed from: t0, reason: collision with root package name */
    private final ej4.a f377404t0;

    /* renamed from: u0, reason: collision with root package name */
    private final ReceiveGiftMessageListener f377405u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f377406v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f377407w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f377408x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f377409y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f377410z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class aa implements bf4.b {
        aa() {
        }

        @Override // bf4.b
        public void a(@NonNull LiveActivityServerOuterClass$GetRoomPendantRsp liveActivityServerOuterClass$GetRoomPendantRsp) {
            if (TimiAnchorView.this.E0 != null) {
                TimiAnchorView.this.E0.a(liveActivityServerOuterClass$GetRoomPendantRsp);
            }
        }

        @Override // bf4.b
        public void b(int i3, @Nullable String str) {
            if (TimiAnchorView.this.E0 != null) {
                TimiAnchorView.this.E0.b(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class ab extends ViewPager2.OnPageChangeCallback {
        ab() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            TimiAnchorView.this.f377394k0.setSelectedPosition(i3);
            TimiAnchorView.this.f377393j0.q0(i3);
            ChatMessagePageData chatMessagePageData = TimiAnchorView.this.f377393j0.m0().get(i3);
            if (chatMessagePageData != null && chatMessagePageData.a() == ChatMessagePageData.Page.GIFT_MSG) {
                TimiAnchorView.this.g1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements RtmpAnchorVideoOperateView.b {
        b() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.anchor.RtmpAnchorVideoOperateView.b
        public void a(int i3, int i16) {
            TimiAnchorView.this.G0.C0(TimiAnchorView.this.o0(), i3, i16);
            TimiAnchorView.this.b0(i16, true);
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.anchor.RtmpAnchorVideoOperateView.b
        public void b() {
            TimiAnchorView.this.G0.C0(TimiAnchorView.this.o0(), -1, ViewUtils.dip2px(210.0f));
            TimiAnchorView.this.b0(wi2.c.b(210), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements LiveInputLayout.c {

        /* renamed from: a, reason: collision with root package name */
        final GradientDrawable f377419a = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#00111129"), Color.parseColor("#E6111129")});

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f377420b;

        e(View view) {
            this.f377420b = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            TimiAnchorView.this.f377395l0.h(true);
        }

        @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout.c
        public void onStateChanged(int i3) {
            if (TimiAnchorView.this.f377398n0 == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TimiAnchorView.this.f377398n0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) TimiAnchorView.this.J.getLayoutParams();
            layoutParams.height = TimiAnchorView.this.f377398n0.getHeight();
            layoutParams2.height = TimiAnchorView.this.J.getHeight();
            int i16 = 0;
            layoutParams.addRule(3, 0);
            layoutParams.addRule(2, R.id.sn5);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(2, R.id.tto);
            TimiAnchorView.this.f377398n0.setLayoutParams(layoutParams);
            TimiAnchorView.this.J.setLayoutParams(layoutParams2);
            if (i3 != 1) {
                TimiAnchorView.this.f377398n0.setBackgroundColor(Color.parseColor("#E6111129"));
                TimiAnchorView.this.J.setBackground(this.f377419a);
                TimiAnchorView.this.f377398n0.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        TimiAnchorView.e.this.b();
                    }
                });
            } else {
                TimiAnchorView.this.f377398n0.setBackgroundColor(0);
                TimiAnchorView.this.J.setBackground(null);
            }
            View view = this.f377420b;
            if (view != null) {
                if (i3 == 1) {
                    i16 = 8;
                }
                view.setVisibility(i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements OnEvent<LinkScreenEvent> {
        f() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(LinkScreenEvent linkScreenEvent) {
            if (linkScreenEvent.getType() == 1) {
                if (TimiAnchorView.this.f377398n0 == null) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TimiAnchorView.this.f377398n0.getLayoutParams();
                layoutParams.height = TimiAnchorView.this.f377398n0.getHeight();
                layoutParams.addRule(3, 0);
                layoutParams.addRule(2, R.id.sn5);
                TimiAnchorView.this.f377398n0.setLayoutParams(layoutParams);
                TimiAnchorView.this.q1(((ViewUtils.getScreenHeight() - com.tencent.now.linkscreengame.model.d.f338503a.b().bottom) - wi2.c.b(64)) - wi2.c.a(32.0f));
                return;
            }
            if (linkScreenEvent.getType() == 2) {
                TimiAnchorView.this.f0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements AnchorOperationBarView.a {

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements Function1<GetAnchorRoomInfoRequest.a, Unit> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorView$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public class C9931a implements AnchorMoreDialog.e {
                C9931a() {
                }

                @Override // com.tencent.timi.game.liveroom.impl.room.more.AnchorMoreDialog.e
                public void a() {
                    if (TimiAnchorView.this.C0 == null) {
                        return;
                    }
                    AnchorPlayTogetherDialog.INSTANCE.a(TimiAnchorView.this.getContext(), TimiAnchorView.this.C0);
                }
            }

            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(GetAnchorRoomInfoRequest.a aVar) {
                if (aVar != null && TimiAnchorView.this.C0 != null && aVar.getRsp() != null) {
                    TimiAnchorView.this.C0.R(aVar.getRsp());
                }
                AnchorMoreDialog A0 = AnchorMoreDialog.A0(TimiAnchorView.this.k0(), TimiAnchorView.this.o0(), TimiAnchorView.this.Z(), null, TimiAnchorView.this.P.getSettingEntranceShowFlag(), TimiAnchorView.this.R, TimiAnchorView.this.C0, TimiAnchorView.this.D0);
                if (A0 == null) {
                    return null;
                }
                A0.D0(new C9931a());
                return null;
            }
        }

        g() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.widget.AnchorOperationBarView.a
        public void a(boolean z16) {
            TimiAnchorView.this.f377382d.i("Open_Live|TimiAnchorView", "onPrivacyClick: " + z16);
            if (TimiAnchorView.this.f377391i instanceof IQQLiveAnchorTRTCRoom) {
                if (z16) {
                    ((IQQLiveAnchorTRTCRoom) TimiAnchorView.this.f377391i).resumePublishStream(false);
                    TimiAnchorView.this.E.setText("\u76f4\u64ad\u5f00\u59cb\u5566\uff0c\u624b\u673a\u753b\u9762\u5df2\u540c\u6b65\u5230\u76f4\u64ad\u95f4");
                } else {
                    TimiAnchorView.this.E.setText("\u4e3b\u64ad\u6682\u65f6\u79bb\u5f00\uff0c\u5343\u4e07\u522b\u8d70\u5f00\u9a6c\u4e0a\u56de\u6765");
                    ((IQQLiveAnchorTRTCRoom) TimiAnchorView.this.f377391i).pausePublishStream(TimiAnchorView.this.L0(), 10, false);
                    TimiAnchorView.this.E.setText("\u76f4\u64ad\u753b\u9762\u5df2\u6682\u505c\n\u5c3d\u5feb\u6062\u590d\u522b\u8ba9\u89c2\u4f17\u7b49\u592a\u4e45\u54e6");
                }
                TimiAnchorView.this.N.setPrivacyOn(!z16);
                rj4.a.f431587a.b(!z16);
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.widget.AnchorOperationBarView.a
        public void b(boolean z16) {
            if (TimiAnchorView.this.f377391i instanceof IQQLiveAnchorMediaControl) {
                TimiAnchorView.this.N.setMicOn(!z16);
                ((IQQLiveAnchorMediaControl) TimiAnchorView.this.f377391i).muteLocalAudio(z16);
            }
            TimiAnchorView.this.f377389h.v1(!z16);
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.widget.AnchorOperationBarView.a
        public void c() {
            TimiAnchorView.this.M.Y();
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.widget.AnchorOperationBarView.a
        public void onMoreClick() {
            if (((jg4.b) mm4.b.b(jg4.b.class)).n(TimiAnchorView.this.o0()) == null) {
                return;
            }
            com.tencent.timi.game.liveroom.impl.room.playtogether.util.a.a(TimiAnchorView.this.Z(), TimiAnchorView.this.o0(), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements rh2.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nh2.c f377426d;

        h(nh2.c cVar) {
            this.f377426d = cVar;
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            TimiAnchorView.this.f377382d.e("Open_Live|TimiAnchorView", "errCode: " + i3 + " errMsg: " + str);
        }

        @Override // rh2.e
        public void onReceive(List<com.tencent.mobileqq.qqgift.data.service.d> list) {
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    com.tencent.mobileqq.qqgift.data.service.d dVar = list.get(i3);
                    arrayList.add(new com.tencent.mobileqq.qqgift.data.service.g(dVar.C, dVar.f264874d, dVar.f264883i));
                }
                this.f377426d.b().S(arrayList, TimiAnchorView.this.f377384e);
                return;
            }
            TimiAnchorView.this.f377382d.e("Open_Live|TimiAnchorView", "getGiftList#onReceive empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements DialogInterface.OnClickListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            TimiAnchorView.this.r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class j implements IResultListener<EndPageRealTimeInfo> {
        j() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EndPageRealTimeInfo endPageRealTimeInfo) {
            TimiAnchorView.this.f377382d.i("Open_Live|TimiAnchorView", "stopLive success");
            QQLiveGameRoomService.f();
            TimiAnchorView.this.Q0(endPageRealTimeInfo);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            String str2;
            TimiAnchorView.this.f377382d.i("Open_Live|TimiAnchorView", "stopLive failed");
            if (TextUtils.isEmpty(str)) {
                str2 = "\u4e0b\u64ad\u5931\u8d25";
            } else {
                str2 = str;
            }
            com.tencent.timi.game.ui.widget.f.c(str2);
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID).n()).eventId(QQLiveReportConstants.Event.E_ANCHOR_EXIT_ROOM_RESULT).retCode(String.valueOf(i3)).desc(str));
            Activity k06 = TimiAnchorView.this.k0();
            if (k06 != null) {
                k06.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class k implements qh2.h {
        k() {
        }

        @Override // qh2.h
        public void a(int i3, int i16) {
            TimiAnchorView.this.f377382d.e("Open_Live|TimiAnchorView", "onAllFinished: " + i3 + " " + i16);
        }

        @Override // qh2.h
        public void b(boolean z16, int i3, String str) {
            TimiAnchorView.this.f377382d.e("Open_Live|TimiAnchorView", "onSingleFinished: " + z16 + " " + i3 + " " + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class l implements Observer<PayLevelEnterRoomInfo> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(PayLevelEnterRoomInfo payLevelEnterRoomInfo) {
            TimiAnchorView.this.f377385e0.n(payLevelEnterRoomInfo);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class m implements ChatMessageLayout.d {
        m() {
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout.d
        public void a() {
            if (TimiAnchorView.this.Q != null) {
                TimiAnchorView.this.Q.i();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class n implements TimiAnchorLiveInfoHelper.b {
        n() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.util.TimiAnchorLiveInfoHelper.b
        public void a(@Nullable GetAnchorRoomInfoRequest.a aVar) {
            if (TimiAnchorView.this.C0 != null) {
                TimiAnchorView.this.C0.I(aVar);
            }
            TimiAnchorView.this.P.o(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class o implements Observer<QQLiveAnchorDataConfigInfo> {
        o() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QQLiveAnchorDataConfigInfo qQLiveAnchorDataConfigInfo) {
            com.tencent.timi.game.liveroom.impl.room.anchor.n.f377492a.d(qQLiveAnchorDataConfigInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class q implements DialogInterface.OnClickListener {
        q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.timi.game.utils.g.g(TimiAnchorView.this.getContext());
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class s implements pj4.j {
        s() {
        }

        @Override // pj4.j
        public void a() {
            if (TimiAnchorView.this.Q != null) {
                TimiAnchorView.this.Q.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class t implements Function1<GetAnchorRoomInfoRequest.a, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f377439d;

        t(String str) {
            this.f377439d = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(GetAnchorRoomInfoRequest.a aVar) {
            if (aVar != null && aVar.getRsp() != null) {
                boolean z16 = aVar.getRsp().floating_ball_flag.get();
                TimiAnchorView.this.f377382d.i("Open_Live|TimiAnchorView", "requestYesAnchorRoomInfo, floating_ball_flag = " + z16);
                rm4.a.h(this.f377439d, z16);
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class v implements ReceiveLuckyBagMessageListener {
        v() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.luckybag.ReceiveLuckyBagMessageListener
        public void onError(int i3, String str) {
            QLog.e("Open_Live|TimiAnchorView", 1, "onFail errCode=" + i3 + ", errMsg=" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.luckybag.ReceiveLuckyBagMessageListener
        public void onLuckyBagMessageReceive() {
            if (QLog.isColorLevel()) {
                QLog.i("Open_Live|TimiAnchorView", 2, "onLuckyBagMessageReceive");
            }
            TimiAnchorView.this.f377380b0.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class w implements Function2<Integer, String, Unit> {
        w() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num, String str) {
            TimiAnchorView.this.f377380b0.d(num.intValue(), str);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class y implements BusConfigHelper.a {
        y() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper.a
        public void a(long j3, @org.jetbrains.annotations.Nullable uq4.c cVar) {
            if (j3 == TimiAnchorView.this.o0()) {
                if (TimiAnchorView.this.E0 != null) {
                    TimiAnchorView.this.E0.H(j3);
                }
                if (TimiAnchorView.this.F != null) {
                    TimiAnchorView.this.F.b0(j3);
                }
                TimiAnchorView.this.P0(j3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class z implements IQQLiveHideLotteryCallback {
        z() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback
        public void onHide(String str, String str2, String str3) {
            AegisLogger.i("Open_Live|TimiAnchorView", "IQQLiveHideLotteryCallback.onHide", "lotteryId == " + str + ",roomId == " + str2 + ",programId == " + str3);
            if (!TextUtils.isEmpty(str2) && String.valueOf(TimiAnchorView.this.o0()).equals(str2)) {
                TimiAnchorView.this.E0.v(9999);
            }
        }
    }

    public TimiAnchorView(@NonNull @NotNull Context context) {
        super(context);
        this.f377382d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f377384e = new k();
        this.L = new NormalFloatingBannerLogic();
        this.R = new s();
        this.V = false;
        this.f377381c0 = new gk4.c();
        this.f377388g0 = new Eventor();
        this.f377390h0 = 0;
        this.f377395l0 = new com.tencent.mobileqq.qqlive.sail.ui.chat.a();
        this.f377400p0 = new com.tencent.mobileqq.qqlive.sail.ui.danmu.l();
        this.f377401q0 = false;
        this.f377402r0 = null;
        this.f377403s0 = new v();
        this.f377404t0 = new ej4.a(new w());
        this.f377405u0 = new x();
        this.f377406v0 = false;
        this.f377407w0 = false;
        this.f377408x0 = false;
        this.f377409y0 = false;
        this.f377410z0 = false;
        this.J0 = new y();
        this.K0 = new z();
        this.L0 = new aa();
        this.M0 = new ab();
        this.N0 = new l();
        this.O0 = new o();
        this.P0 = new u();
        r0();
    }

    private void A0() {
        TextView textView = (TextView) findViewById(R.id.f166982jn3);
        this.E = textView;
        ((RelativeLayout.LayoutParams) textView.getLayoutParams()).topMargin = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoTopMargin(true);
        if (this.f377391i instanceof IQQLiveAnchorTRTCRoom) {
            this.N.setPrivacyVisibility(true);
            this.N.setMicVisibility(true);
            this.N.setPrivacyOn(rj4.a.f431587a.a());
            this.N.setMicOn(!((IQQLiveAnchorTRTCRoom) this.f377391i).isMicMuteEnable());
        } else {
            this.N.setPrivacyVisibility(false);
            this.N.setMicVisibility(false);
        }
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom == null || iQQLiveAnchorRoom.getRoomConfig() == null) {
            return;
        }
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = this.f377391i.getRoomConfig().streamRecordType;
        if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.SCREEN) {
            if (rj4.a.f431587a.a()) {
                this.E.setText("\u76f4\u64ad\u753b\u9762\u5df2\u6682\u505c\n\u5c3d\u5feb\u6062\u590d\u522b\u8ba9\u89c2\u4f17\u7b49\u592a\u4e45\u54e6");
                return;
            } else {
                this.E.setText("\u76f4\u64ad\u5f00\u59cb\u5566\uff0c\u624b\u673a\u753b\u9762\u5df2\u540c\u6b65\u5230\u76f4\u64ad\u95f4");
                return;
            }
        }
        if (qQLiveAnchorStreamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
            this.E.setText("\u76f4\u64ad\u5f00\u59cb\u5566\uff0c\u63a8\u6d41\u6b63\u5e38");
        }
    }

    private boolean B0() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getAnchorRoomInfo() != null && this.f377391i.getAnchorRoomInfo().roomAttr.isECGoodsLive) {
            return true;
        }
        return false;
    }

    private boolean C0() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        String str = QQLiveConfigConst.APP_ID;
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null) {
            str = f16.getAppId();
        }
        if (((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getExistAnchorRecord(str, account) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(boolean z16, int i3) {
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.d().r() == 2) {
            if (z16) {
                if (i3 == -1) {
                    this.I0 = wi2.c.b(270);
                } else {
                    this.I0 = q0(findViewById(R.id.sn5)) - (q0(findViewById(R.id.ykd)) + i3);
                }
            } else {
                this.I0 = q0(findViewById(R.id.sn5)) - (q0(findViewById(R.id.f785647e)) + wi2.c.b(220));
            }
        } else {
            this.I0 = q0(findViewById(R.id.sn5)) - (q0(findViewById(R.id.f166982jn3)) + wi2.c.b(210));
        }
        AegisLogger.i("Open_Live|TimiAnchorView", "giftBannerGuideLineBottomMargin:" + this.I0);
        u1();
        t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        int i3 = this.f377390h0;
        if (i3 > 0) {
            this.f377395l0.j(i3);
            this.f377390h0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Uri.Builder buildUpon = Uri.parse("mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_live_opened=1&is_trans_activity=1&is_appcompat_style=1").buildUpon();
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getAnchorRoomInfo() != null) {
            buildUpon.appendQueryParameter("live_user_id", String.valueOf(this.f377391i.getAnchorRoomInfo().uid));
        }
        buildUpon.appendQueryParameter("live_room_id", String.valueOf(o0()));
        Bundle bundle = new Bundle();
        bundle.putString("KEY_URL", buildUpon.build().toString());
        cj4.c.f31003a.c("ACTION_JUMP_WITH_SCHEME", bundle, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.M.setState(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit H0(QQLiveResponse qQLiveResponse) {
        gr4.x xVar;
        gr4.f fVar;
        boolean z16 = false;
        if (qQLiveResponse != null && !qQLiveResponse.isFailed()) {
            gr4.j jVar = (gr4.j) qQLiveResponse.component5();
            if (jVar == null) {
                this.f377401q0 = false;
                return null;
            }
            if (jVar.f403134a && (xVar = jVar.f403135b) != null && (fVar = xVar.f403241e) != null && !TextUtils.isEmpty(fVar.f403119a)) {
                z16 = true;
            }
            this.f377401q0 = z16;
            return null;
        }
        this.f377401q0 = false;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(int i3) {
        ChatMessageLayout g06;
        if (this.f377390h0 != i3 && (g06 = g0()) != null && g06.F() > i3) {
            this.f377390h0 = g06.F();
            this.f377395l0.j(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        this.f377395l0.j(this.I0 - com.tencent.timi.game.liveroom.impl.room.message.stack.b.f378084a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f165361vo2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.bottomMargin = this.I0 - com.tencent.timi.game.liveroom.impl.room.message.stack.b.f378084a.f();
        linearLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap L0() {
        int screenHeight = ViewUtils.getScreenHeight();
        Bitmap createBitmap = Bitmap.createBitmap(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(0.0f, (screenHeight - this.E.getHeight()) / 2.0f);
        this.E.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M0() {
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType;
        if (!this.f377407w0) {
            return false;
        }
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getRoomConfig() != null) {
            qQLiveAnchorStreamRecordType = this.f377391i.getRoomConfig().streamRecordType;
        } else {
            qQLiveAnchorStreamRecordType = null;
        }
        if (QQLiveAnchorStreamRecordType.SCREEN != qQLiveAnchorStreamRecordType || !TextUtils.isEmpty(cl.d(getContext(), "TIMI_ANCHOR_PRIVACY_GUIDE_SHOW_FLAG"))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(long j3) {
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        this.f377409y0 = !busConfigHelper.f(12, j3);
        AegisLogger.i("Open_Live|TimiAnchorView", "onDynamicConfigReady", "configVerDamuOpen:" + this.f377409y0);
        this.f377395l0.k(l1(), false);
        this.f377410z0 = busConfigHelper.f(10, j3) ^ true;
        AegisLogger.i("Open_Live|TimiAnchorView", "onDynamicConfigReady", "showInput:" + this.f377410z0);
        n1(k1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(EndPageRealTimeInfo endPageRealTimeInfo) {
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo;
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null) {
            qQLiveAnchorRoomInfo = iQQLiveAnchorRoom.getAnchorRoomInfo();
        } else {
            qQLiveAnchorRoomInfo = null;
        }
        o1(qQLiveAnchorRoomInfo, endPageRealTimeInfo);
        rj4.a.f431587a.b(false);
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID).n()).eventId(QQLiveReportConstants.Event.E_ANCHOR_EXIT_ROOM_RESULT).retCode(String.valueOf(0)).roomId(String.valueOf(endPageRealTimeInfo.roomID)));
    }

    private void S0(long j3) {
        this.f377387f0.g(j3, false);
        this.f377387f0.d().observeForever(this.N0);
    }

    private void T0() {
        this.f377387f0.h();
        this.f377387f0.d().removeObserver(this.N0);
        this.f377385e0.v();
    }

    private void U0() {
        lg4.b.E().F().observeForever(this.O0);
    }

    private void V0() {
        ((jg4.a) mm4.b.b(jg4.a.class)).L0(0L, 285, this.P0);
    }

    private void W0() {
        ((jg4.a) mm4.b.b(jg4.a.class)).j3(0L, this.P0);
    }

    private void X0(long j3) {
        String str;
        int i3;
        ILiveRoom z16 = ((jg4.b) mm4.b.b(jg4.b.class)).z(j3);
        if (z16 != null) {
            z16.registerReceiveLuckyBagMessageListener(this.f377403s0);
            z16.registerHighPriorityListener(52, this.f377404t0);
        }
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getAnchorRoomInfo() != null) {
            str = String.valueOf(this.f377391i.getAnchorRoomInfo().roomData.programId);
            i3 = this.f377391i.getAnchorRoomInfo().roomAttr.liveRoomType;
        } else {
            str = "-1";
            i3 = 0;
        }
        this.f377380b0.b(j3, true, str, i3, 0);
    }

    private void Y0() {
        ILiveRoom z16 = ((jg4.b) mm4.b.b(jg4.b.class)).z(o0());
        if (z16 != null) {
            z16.unRegisterReceiveLuckyBagMessageListener(this.f377403s0);
            z16.unRegisterHighPriorityListener(52, this.f377404t0);
        }
        this.f377380b0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getAnchorRoomInfo() != null && this.f377391i.getAnchorRoomInfo().roomData != null && this.f377391i.getAnchorRoomInfo().roomData.gameInfo != null) {
            return this.f377391i.getAnchorRoomInfo().roomData.gameInfo.f271211id;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a0(String str) {
        return com.tencent.timi.game.liveroom.impl.room.manager.d.INSTANCE.a().b(o0(), str);
    }

    private void a1() {
        RtmpAnchorVideoOperateView rtmpAnchorVideoOperateView = this.F0;
        if (rtmpAnchorVideoOperateView != null) {
            rtmpAnchorVideoOperateView.T0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(final int i3, final boolean z16) {
        AegisLogger.i("Open_Live|TimiAnchorView", "calculateGiftBannerBottomMargin liveDisplayViewHeight:" + i3 + ", videoIsPreview:" + z16);
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.u
            @Override // java.lang.Runnable
            public final void run() {
                TimiAnchorView.this.D0(z16, i3);
            }
        });
    }

    private void b1(nh2.c cVar) {
        long j3;
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getAnchorRoomInfo() != null) {
            j3 = this.f377391i.getAnchorRoomInfo().uid;
        } else {
            this.f377382d.e("Open_Live|TimiAnchorView", "anchorRoomInfo is null");
            j3 = -1;
        }
        cVar.a().P(new com.tencent.mobileqq.qqgift.data.service.a(2, String.valueOf(1037), String.valueOf(Z()), String.valueOf(j3)), new h(cVar));
    }

    private void c0() {
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null) {
            f16.getLotteryService().unRegisterHideLottery(this.K0);
        }
        f1();
        this.E0.k();
    }

    private void c1(Bundle bundle) {
        boolean z16;
        if (bundle != null) {
            boolean z17 = true;
            this.A0 = bundle.getInt("fromSource", 1);
            this.B0 = bundle.getString("actionCmd", "");
            int i3 = this.A0;
            if (2 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f377407w0 = z16;
            if (5 != i3) {
                z17 = false;
            }
            this.f377408x0 = z17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        Activity k06 = k0();
        if (k06 == null) {
            r1();
        } else {
            new kl4.k(k06).b0("\u786e\u5b9a\u8981\u7ed3\u675f\u76f4\u64ad\u5417\uff1f").e0(new i()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (!TextUtils.isEmpty(this.B0)) {
            this.f377382d.i("Open_Live|TimiAnchorView", "doJumpActionCmd -- " + this.B0 + ", from = " + this.A0);
            String str = this.B0;
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -743759232:
                    if (str.equals("share_qq")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -166170746:
                    if (str.equals("share_wechat")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 1629885193:
                    if (str.equals("stop_live")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                case 1:
                    wk4.a.h(getContext(), o0(), null);
                    return;
                case 2:
                    r1();
                    return;
                default:
                    return;
            }
        }
    }

    private void e1() {
        f fVar = new f();
        this.f377402r0 = fVar;
        this.f377388g0.addOnEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        AegisLogger.i("Open_Live|TimiAnchorView", "rev LINK_SCREEN_END, diffHeight:" + this.f377390h0);
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.t
            @Override // java.lang.Runnable
            public final void run() {
                TimiAnchorView.this.E0();
            }
        });
    }

    private ChatMessageLayout g0() {
        return (ChatMessageLayout) this.f377393j0.l0(ChatMessagePageData.Page.ALL_MSG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1() {
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        QQLiveDaTongParams f16 = aVar.f(o0());
        f16.d("em_qqlive_gift_barrage_module");
        aVar.i("dt_imp", f16.a());
    }

    private void h0(long j3, long j16) {
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null) {
            jj4.d dVar = new jj4.d();
            this.f377379a0 = dVar;
            dVar.m(f16.getProxySsoService());
            this.f377379a0.d(j16, 1, j3, new p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        QBaseActivity b16 = vf4.a.b();
        if (b16 != null) {
            kl4.k d06 = new kl4.k(b16).b0("\u6536\u8d77\u76f4\u64ad\u9700\u5f00\u542f\u60ac\u6d6e\u7403\u6743\u9650").f0("\u53bb\u5f00\u542f").e0(new q()).d0("\u53d6\u6d88");
            d06.setCanceledOnTouchOutside(true);
            d06.show();
        }
    }

    public static String i0(long j3) {
        return "TIMI_ANCHOR_FLOATING_BALL_FLAG" + j3;
    }

    private void i1(long j3, long j16) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetTeamBuildConfigRequest(r0.f271211id, j3, j16, this.f377391i.getAnchorRoomInfo().roomAttr.gameInfo.secondTagId, ""), new Function1() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H0;
                H0 = TimiAnchorView.this.H0((QQLiveResponse) obj);
                return H0;
            }
        });
    }

    private GiftMessageLayout j0() {
        return (GiftMessageLayout) this.f377393j0.l0(ChatMessagePageData.Page.GIFT_MSG);
    }

    private void j1() {
        com.tencent.timi.game.liveroom.impl.room.playtogether.util.a.a(Z(), o0(), new t(i0(o0())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Activity k0() {
        return com.tencent.timi.game.utils.b.d(this);
    }

    private boolean k1() {
        return this.f377410z0;
    }

    private boolean l1() {
        return this.f377409y0;
    }

    private void m1() {
        if (this.f377407w0 && !C0()) {
            post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorView.27
                @Override // java.lang.Runnable
                public void run() {
                    TimiAnchorView.this.H.setVisibility(0);
                    TimiAnchorView.this.H.g();
                }
            });
        }
    }

    private String n0() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getRoomInfo() != null) {
            return this.f377391i.getRoomInfo().getProgramId();
        }
        return "";
    }

    private void n1(boolean z16) {
        int i3;
        AnchorOperationBarView anchorOperationBarView = this.N;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        anchorOperationBarView.setInputVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long o0() {
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getRoomInfo() != null) {
            return this.f377391i.getRoomInfo().getRoomId();
        }
        return 0L;
    }

    private void o1(QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo, EndPageRealTimeInfo endPageRealTimeInfo) {
        this.f377382d.i("Open_Live|TimiAnchorView", "showLiveEndView");
        if (qQLiveAnchorRoomInfo != null && endPageRealTimeInfo != null) {
            IQQLiveEndView a16 = rj4.b.f431589a.a(k0(), this.f377389h.f(), qQLiveAnchorRoomInfo, endPageRealTimeInfo, new r());
            if (a16 != null && a16.getView() != null) {
                this.G.removeAllViews();
                this.G.addView(a16.getView(), new FrameLayout.LayoutParams(-1, -1));
                this.G.setVisibility(0);
                return;
            } else {
                this.f377382d.i("Open_Live|TimiAnchorView", "showLiveEndView: illegal params");
                Activity k06 = k0();
                if (k06 != null) {
                    k06.finish();
                    return;
                }
                return;
            }
        }
        this.f377382d.i("Open_Live|TimiAnchorView", "showLiveEndView: illegal params");
        Activity k07 = k0();
        if (k07 != null) {
            k07.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(final AnchorPrivateGuideView.a aVar) {
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorView.26

            /* compiled from: P */
            /* renamed from: com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorView$26$a */
            /* loaded from: classes26.dex */
            class a implements Function1<Rect, Unit> {
                a() {
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unit invoke(Rect rect) {
                    TimiAnchorView.this.I.setVisibility(0);
                    TimiAnchorView.this.I.setGuideViewFinishListener(aVar);
                    TimiAnchorView.this.I.setPrivateBtnRect(rect);
                    cl.j(TimiAnchorView.this.getContext(), "TIMI_ANCHOR_PRIVACY_GUIDE_SHOW_FLAG", System.currentTimeMillis() + "");
                    return null;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                TimiAnchorView.this.N.q(new a());
            }
        });
    }

    private int q0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(final int i3) {
        AegisLogger.i("Open_Live|TimiAnchorView", "rev LINK_SCREEN_START, tempMaxHeight:" + i3);
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.w
            @Override // java.lang.Runnable
            public final void run() {
                TimiAnchorView.this.I0(i3);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void r0() {
        jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
        this.f377389h = bVar;
        this.f377391i = bVar.J3(0L);
        LayoutInflater.from(getContext()).inflate(R.layout.hue, this);
        this.C = (FrameLayout) findViewById(R.id.ykd);
        this.f377396m = (FrameLayout) findViewById(R.id.yke);
        this.f377398n0 = (RelativeLayout) findViewById(R.id.tto);
        this.f377392i0 = (ViewPager2) findViewById(R.id.f60442vf);
        this.f377394k0 = (CustomTabLayout) findViewById(R.id.f60452vg);
        QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter = new QQLiveChatMessageViewPagerAdapter(getContext(), true);
        this.f377393j0 = qQLiveChatMessageViewPagerAdapter;
        this.f377392i0.setAdapter(qQLiveChatMessageViewPagerAdapter);
        this.f377392i0.setOffscreenPageLimit(this.f377393j0.m0().size());
        this.f377394k0.b(this.f377393j0.m0().size());
        this.f377394k0.setSelectedPosition(0);
        this.f377392i0.registerOnPageChangeCallback(this.M0);
        this.f377395l0.e(true, g0(), j0());
        this.f377395l0.a(getContext(), 1);
        this.f377395l0.j(wi2.c.b(240));
        this.f377395l0.k(l1(), false);
        this.f377397m0 = this.f377395l0.d();
        com.tencent.timi.game.liveroom.impl.util.c.f378976a.i("https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf");
        TimiGamePAGView timiGamePAGView = (TimiGamePAGView) findViewById(R.id.f60412vc);
        this.f377399o0 = timiGamePAGView;
        this.f377400p0.d(timiGamePAGView);
        this.D = (LiveTipsView) findViewById(R.id.ykl);
        this.K = (FrameLayout) findViewById(R.id.zs8);
        this.L.h(getContext(), this.K);
        this.f377397m0.J0(this.L);
        LivingInscriptionInterEntranceView livingInscriptionInterEntranceView = (LivingInscriptionInterEntranceView) findViewById(R.id.xp5);
        this.P = livingInscriptionInterEntranceView;
        livingInscriptionInterEntranceView.setInAnchorState(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ykg);
        this.G = frameLayout;
        frameLayout.setOnTouchListener(new a());
        this.N = (AnchorOperationBarView) findViewById(R.id.snk);
        n1(k1());
        this.T = (LinearLayout) findViewById(R.id.f165361vo2);
        this.U = (FrameLayout) findViewById(R.id.vo8);
        RtmpAnchorVideoOperateView rtmpAnchorVideoOperateView = (RtmpAnchorVideoOperateView) findViewById(R.id.f785647e);
        this.F0 = rtmpAnchorVideoOperateView;
        rtmpAnchorVideoOperateView.Q0(this.C, this.D, new b());
        this.G0 = (RoomDynamicBgView) findViewById(R.id.f7806462);
        s0();
        x0();
        A0();
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.d().r() == 2) {
            this.E.setVisibility(4);
        } else {
            this.F0.setVisibility(4);
        }
        AnchorTopAreaView anchorTopAreaView = (AnchorTopAreaView) findViewById(R.id.f99475pw);
        this.F = anchorTopAreaView;
        LifecycleOwner lifecycleOwner = this.f377386f;
        if (lifecycleOwner != null) {
            anchorTopAreaView.setLifecycleOwner(lifecycleOwner);
        }
        this.F.setAnchorTopHeadViewModel();
        this.F.setListener(new c());
        AnchorCountDownView anchorCountDownView = (AnchorCountDownView) findViewById(R.id.ykf);
        this.H = anchorCountDownView;
        anchorCountDownView.setCountDownTimerListener(new d());
        this.I = (AnchorPrivateGuideView) findViewById(R.id.vvb);
        this.J = findViewById(R.id.f165360vo1);
        v0();
        u0();
        ((ug4.a) mm4.b.b(ug4.a.class)).a(this.E, false, null, "em_qqlive_livingpic", new HashMap());
        VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_NONE);
        TimiLiveOperationContainer timiLiveOperationContainer = (TimiLiveOperationContainer) findViewById(R.id.snj);
        this.E0 = timiLiveOperationContainer;
        timiLiveOperationContainer.setInAnchorState(true);
        this.E0.setChatMessageLayout(g0());
        y0();
        z0();
        w0();
        t0();
        e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo;
        this.f377382d.i("Open_Live|TimiAnchorView", "stopLive");
        this.f377388g0.removeAll();
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null) {
            qQLiveAnchorRoomInfo = iQQLiveAnchorRoom.getAnchorRoomInfo();
        } else {
            qQLiveAnchorRoomInfo = null;
        }
        long o06 = o0();
        TGLiveFloatManager.f377649d.g(o06, false);
        this.f377395l0.i(true);
        this.f377381c0.c();
        ((jg4.b) mm4.b.b(jg4.b.class)).x3(o06, new j());
        tk4.d.f436481a.B(0L);
        if (qQLiveAnchorRoomInfo != null) {
            cj4.c.f31003a.j(o06, B0());
        }
        this.S.e();
        this.F0.T0();
    }

    private void s0() {
        if (B0()) {
            ImageView imageView = (ImageView) this.N.findViewById(R.id.up_);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimiAnchorView.this.F0(view);
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("qqlive_buttom_area_button", "4");
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(imageView, true, null, IMultiAvChatReporter.ELEMENT_BOTTOM_FUNCTION, hashMap);
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", imageView, hashMap);
            Bundle bundle = new Bundle();
            IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
            if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getAnchorRoomInfo() != null) {
                bundle.putString("qqlive_user_id", String.valueOf(this.f377391i.getAnchorRoomInfo().uid));
                bundle.putString("qqlive_anchor_id", String.valueOf(this.f377391i.getAnchorRoomInfo().uid));
                bundle.putString("qqlive_room_id", String.valueOf(this.f377391i.getAnchorRoomInfo().roomData.f271212id));
                bundle.putString("qqlive_zhibo_type", String.valueOf(this.f377391i.getAnchorRoomInfo().roomAttr.liveRoomType));
                bundle.putString("qqlive_program_id", String.valueOf(this.f377391i.getAnchorRoomInfo().roomData.programId));
                QIPCClientHelper.getInstance().callServer("EcommerceIPCModule", "ACTION_SETUP_LIVE_REPORT_INFO", bundle);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bus_id", "2");
            hashMap2.put("live_type", "2");
            IQQLiveAnchorRoom iQQLiveAnchorRoom2 = this.f377391i;
            if (iQQLiveAnchorRoom2 != null && iQQLiveAnchorRoom2.getAnchorRoomInfo() != null) {
                hashMap2.put("author_uin", String.valueOf(this.f377391i.getAnchorRoomInfo().uid));
                hashMap2.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f377391i.getAnchorRoomInfo().roomData.f271212id));
                hashMap2.put("program_id", String.valueOf(this.f377391i.getAnchorRoomInfo().roomData.programId));
                hashMap2.put("room_title", this.f377391i.getAnchorRoomInfo().roomData.name);
                hashMap2.put("room_cover", this.f377391i.getAnchorRoomInfo().roomData.coverUrl16v9);
            }
            cj4.c.f31003a.n("ds_live_goods_info", hashMap2);
        }
    }

    private void s1() {
        this.f377388g0.removeAll();
        this.f377402r0 = null;
    }

    private void t0() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f228304s);
        PayLevelEnterRoomBubbleView payLevelEnterRoomBubbleView = new PayLevelEnterRoomBubbleView(getContext(), null);
        this.f377385e0 = payLevelEnterRoomBubbleView;
        viewGroup.addView(payLevelEnterRoomBubbleView);
        this.f377387f0 = new dk4.a();
    }

    private void t1() {
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.x
            @Override // java.lang.Runnable
            public final void run() {
                TimiAnchorView.this.J0();
            }
        });
    }

    private void u0() {
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b A = sDKImpl.d().A(getContext(), 1);
            this.W = A;
            A.prepare();
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.bottomMargin = lk4.e.b(getContext(), 8.0f);
            this.T.addView(this.W.i(), marginLayoutParams);
            this.T.addView(this.W.b(), new ViewGroup.MarginLayoutParams(-2, -2));
            this.U.addView(this.W.k(), new RelativeLayout.LayoutParams(-1, -2));
            b1(sDKImpl);
        }
    }

    private void u1() {
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.y
            @Override // java.lang.Runnable
            public final void run() {
                TimiAnchorView.this.K0();
            }
        });
    }

    private void v0() {
        View findViewById = findViewById(R.id.txw);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimiAnchorView.this.G0(view);
            }
        });
        AnchorInputLayout anchorInputLayout = (AnchorInputLayout) findViewById(R.id.snc);
        this.M = anchorInputLayout;
        anchorInputLayout.k(new e(findViewById));
    }

    private void w0() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.upf);
        ECommerceLuckyBagView eCommerceLuckyBagView = new ECommerceLuckyBagView(getContext(), null);
        this.f377380b0 = eCommerceLuckyBagView;
        relativeLayout.addView(eCommerceLuckyBagView);
    }

    private void x0() {
        this.N.setAnchorOperationBarViewListener(new g());
    }

    private void y0() {
        this.E0.setJumpInterceptor(new ui4.b(null, null, o0()).e(new ArrayList()));
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        busConfigHelper.h(o0(), this.J0);
        long o06 = o0();
        if (o06 > 0) {
            busConfigHelper.i(o06, n0());
        } else {
            AegisLogger.e("Open_Live|TimiAnchorView", "initOperationView", "invalid room id");
        }
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 != null) {
            f16.getLotteryService().registerHideLottery(this.K0);
        }
    }

    private void z0() {
        QQLiveAnchorRoomInfo qQLiveAnchorRoomInfo;
        AnchorQualityHelper anchorQualityHelper = new AnchorQualityHelper();
        this.S = anchorQualityHelper;
        anchorQualityHelper.b(getContext());
        AnchorQualityHelper anchorQualityHelper2 = this.S;
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null) {
            qQLiveAnchorRoomInfo = iQQLiveAnchorRoom.getAnchorRoomInfo();
        } else {
            qQLiveAnchorRoomInfo = null;
        }
        anchorQualityHelper2.i(qQLiveAnchorRoomInfo, null);
    }

    public boolean N0() {
        boolean z16;
        this.f377382d.i("Open_Live|TimiAnchorView", "onBackPress ");
        if (findViewById(R.id.vvb).getVisibility() == 0) {
            findViewById(R.id.vvb).setVisibility(8);
            return true;
        }
        jg4.c s16 = this.f377389h.s();
        if (s16 != null && s16.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.f377406v0 && !com.tencent.timi.game.utils.g.c(getContext()) && z16) {
            this.f377406v0 = true;
            h1();
            return true;
        }
        if (com.tencent.timi.game.utils.g.c(getContext()) || !z16) {
            return false;
        }
        d0();
        return true;
    }

    public void O0() {
        long j3;
        try {
            j3 = this.f377391i.getAnchorRoomInfo().roomData.f271212id;
        } catch (Exception unused) {
            this.f377382d.w("TimiAnchorView", "onDestroyView get roomid failed!");
            j3 = 0;
        }
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.C0;
        if (anchorPlayTogetherPresenter != null) {
            anchorPlayTogetherPresenter.L();
        }
        this.f377381c0.c();
        this.F.onExitRoom(j3);
        TimiLiveOperationContainer timiLiveOperationContainer = this.E0;
        if (timiLiveOperationContainer != null) {
            timiLiveOperationContainer.G(j3);
        }
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(j3);
        if (k3 != null) {
            k3.unRegisterReceiveGiftMessageListener(this.f377405u0);
        }
        jj4.d dVar = this.f377379a0;
        if (dVar != null) {
            dVar.l();
        }
        this.L.k();
        lg4.b.E().F().removeObserver(this.O0);
        c0();
        Y0();
        W0();
        T0();
        a1();
        this.G0.E0();
        this.f377400p0.g();
        BusConfigHelper.f378723a.p();
        ViewPager2 viewPager2 = this.f377392i0;
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(this.M0);
        }
        TGLiveClientQIPCModule.INSTANCE.c().unregister();
    }

    public void R0(long j3, long j16) {
        this.f377382d.i("Open_Live|TimiAnchorView", 1, "onEnterRoom " + j3);
        af4.f.f26028a.b(1, j3, this.L0);
        this.E0.F(j3, Z());
        this.f377381c0.b(this);
        this.F0.S0(j3);
        TGLiveClientQIPCModule.INSTANCE.c().registerModule();
        uj4.b.f439096a.b(j3, 1);
        jg4.h n3 = ((jg4.b) mm4.b.b(jg4.b.class)).n(j3);
        if (n3 != null) {
            this.D0 = com.tencent.timi.game.liveroom.impl.room.anchor.o.b(j3, Z(), n3);
        }
        this.C0 = com.tencent.timi.game.liveroom.impl.room.anchor.o.a(k0(), j3, Z(), j16);
        this.F.setGameId(Z());
        this.F.onEnterRoom(j3, true);
        IQQLiveAnchorRoom iQQLiveAnchorRoom = this.f377391i;
        if (iQQLiveAnchorRoom != null && iQQLiveAnchorRoom.getAnchorInfo() != null) {
            this.F.setLiveRoomInfo(this.f377391i.getAnchorInfo().getAnchorUid());
        }
        ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies();
        com.tencent.timi.game.liveroom.impl.room.anchor.n.f377492a.a(j3, null);
        this.f377383d0 = 1;
        this.f377395l0.b(j3, "", j16, 1, false);
        this.L.j(j3, j16);
        this.P.setLiveRoomInfo(j16, j3, Z());
        this.N.p(j3);
        this.M.setRoomId(j3);
        this.M.d0(j3);
        m1();
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(j3);
        if (k3 != null) {
            k3.registerReceiveGiftMessageListener(this.f377405u0);
        }
        if (this.f377407w0) {
            tk4.d.f436481a.y(true, j3, null);
            TGLiveFloatManager.f377649d.q();
        }
        this.f377397m0.G0(new m());
        if (n3 != null) {
            ((lo4.a) mm4.b.b(lo4.a.class)).C2().d(new LivingRoomInfo(String.valueOf(j16), String.valueOf(j3), Z(), false));
        }
        j1();
        i1(j16, j3);
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorView.22
            @Override // java.lang.Runnable
            public void run() {
                TimiAnchorView.this.e0();
            }
        });
        h0(j3, j16);
        U0();
        TimiAnchorLiveInfoHelper timiAnchorLiveInfoHelper = new TimiAnchorLiveInfoHelper(this, j16 + "", j3, Z(), new n());
        this.Q = timiAnchorLiveInfoHelper;
        timiAnchorLiveInfoHelper.i();
        cj4.c.f31003a.k(true, j3, B0());
        this.S.d();
        X0(j3);
        V0();
        S0(j3);
        if (this.f377391i != null) {
            LiveBarrageMessageMgr liveBarrageMessageMgr = new LiveBarrageMessageMgr(this.f377391i, (GradientBarrageLayout) findViewById(R.id.t4n));
            this.H0 = liveBarrageMessageMgr;
            liveBarrageMessageMgr.l();
        }
        this.G0.C0(j3, -1, ViewUtils.dip2px(210.0f));
        this.G0.D0(j3, com.tencent.mobileqq.qqlive.sail.c.f272176a.d().g());
        b0(wi2.c.b(210), false);
    }

    public void Z0(Bundle bundle) {
        if (bundle != null) {
            c1(bundle);
            this.f377382d.i("Open_Live|TimiAnchorView", "onNewIntent fromSource: " + this.A0 + ", jumpActionCmd: " + this.B0);
            if (!TextUtils.isEmpty(this.B0)) {
                e0();
            }
        }
    }

    public void d1(boolean z16) {
        if (!z16) {
            this.E.setText("\u76f4\u64ad\u5f00\u59cb\u5566\uff0c\u624b\u673a\u753b\u9762\u5df2\u540c\u6b65\u5230\u76f4\u64ad\u95f4");
        } else {
            this.E.setText("\u76f4\u64ad\u753b\u9762\u5df2\u6682\u505c\n\u5c3d\u5feb\u6062\u590d\u522b\u8ba9\u89c2\u4f17\u7b49\u592a\u4e45\u54e6");
        }
    }

    public void f1() {
        BusConfigHelper.f378723a.q(o0());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(NoticeCommitEvent.class);
        arrayList.add(AppBecomeForegroundEvent.class);
        arrayList.add(AppBecomeBackgroundEvent.class);
        arrayList.add(RefreshBatteryOperationEvent.class);
        arrayList.add(QQLiveEndLiveEventByAdmin.class);
        return arrayList;
    }

    public FrameLayout l0() {
        return this.C;
    }

    public FrameLayout m0() {
        return this.f377396m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f377382d.i("TGLiveAnchorFloatingView", "TGLiveFloatManager  onAttachedToWindow hideFloatView");
        TGLiveFloatManager.f377649d.l();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        boolean z16;
        this.f377382d.i("Open_Live|TimiAnchorView", "onDetachedFromWindow ");
        super.onDetachedFromWindow();
        this.V = true;
        jg4.c s16 = this.f377389h.s();
        if (this.f377401q0 && !s16.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (s16.a() && !z16) {
            TGLiveFloatManager.f377649d.p(new FloatViewConfig(true, null));
        } else {
            TGLiveFloatManager.f377649d.f(o0());
        }
        this.P.onExitRoom(o0());
        TimiAnchorLiveInfoHelper timiAnchorLiveInfoHelper = this.Q;
        if (timiAnchorLiveInfoHelper != null) {
            timiAnchorLiveInfoHelper.j();
        }
        com.tencent.timi.game.liveroom.impl.room.notice.a.INSTANCE.a().d();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QQLiveMedalServiceSupplier.f377955a.a().destroy();
        LiveBarrageMessageMgr liveBarrageMessageMgr = this.H0;
        if (liveBarrageMessageMgr != null) {
            liveBarrageMessageMgr.m();
        }
        s1();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        boolean z16;
        if (simpleBaseEvent instanceof NoticeCommitEvent) {
            ChatMessageLayoutManager chatMessageLayoutManager = this.f377397m0;
            if (chatMessageLayoutManager != null) {
                chatMessageLayoutManager.s(((NoticeCommitEvent) simpleBaseEvent).getAnnouncePushMessage());
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof AppBecomeBackgroundEvent) {
            this.f377382d.i("Open_Live|TimiAnchorView", "AppBecomeBackgroundEvent");
            RtmpAnchorVideoOperateView rtmpAnchorVideoOperateView = this.F0;
            if (rtmpAnchorVideoOperateView != null) {
                rtmpAnchorVideoOperateView.W0();
            }
            jg4.c s16 = this.f377389h.s();
            if (this.f377401q0 && !s16.c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (s16.a() && !z16) {
                com.tencent.mobileqq.qqlive.sail.ui.chat.a aVar = this.f377395l0;
                if (aVar != null) {
                    aVar.g();
                }
                TGLiveFloatManager.f377649d.p(new FloatViewConfig(true, null));
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof AppBecomeForegroundEvent) {
            this.f377382d.i("Open_Live|TimiAnchorView", "AppBecomeForegroundEvent");
            TGLiveFloatManager.f377649d.l();
            RtmpAnchorVideoOperateView rtmpAnchorVideoOperateView2 = this.F0;
            if (rtmpAnchorVideoOperateView2 != null) {
                rtmpAnchorVideoOperateView2.X0();
            }
            AnchorOperationBarView anchorOperationBarView = this.N;
            if (anchorOperationBarView != null) {
                rj4.a aVar2 = rj4.a.f431587a;
                anchorOperationBarView.setPrivacyOn(aVar2.a());
                d1(aVar2.a());
                if (this.f377391i instanceof IQQLiveAnchorMediaControl) {
                    this.N.setMicOn(!((IQQLiveAnchorMediaControl) r7).isMicMuteEnable());
                    return;
                }
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof RefreshBatteryOperationEvent) {
            this.f377382d.i("Open_Live|TimiAnchorView", 1, "handleRefreshBatteryOperationEvent, event:" + simpleBaseEvent + ", curRoom:" + o0());
            af4.f.f26028a.b(1, o0(), this.L0);
            return;
        }
        if (simpleBaseEvent instanceof QQLiveEndLiveEventByAdmin) {
            AegisLogger.i("Open_Live|TimiAnchorView", "QQLiveEndLiveEvent");
            QQLiveEndLiveEventByAdmin qQLiveEndLiveEventByAdmin = (QQLiveEndLiveEventByAdmin) simpleBaseEvent;
            EndPageRealTimeInfo result = qQLiveEndLiveEventByAdmin.getResult();
            String closeReason = qQLiveEndLiveEventByAdmin.getCloseReason();
            Q0(result);
            if (!TextUtils.isEmpty(closeReason)) {
                qg4.e.a(closeReason, null);
            }
        }
    }

    public void onResume() {
        this.f377380b0.e();
    }

    public void onStop() {
        this.f377380b0.f();
    }

    public RtmpAnchorVideoOperateView p0() {
        return this.F0;
    }

    public void setArgument(Bundle bundle) {
        c1(bundle);
    }

    public void setLifecycle(LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner) {
        this.f377386f = lifecycleOwner;
        AnchorTopAreaView anchorTopAreaView = this.F;
        if (anchorTopAreaView != null) {
            anchorTopAreaView.setLifecycleOwner(lifecycleOwner);
        }
        RoomDynamicBgView roomDynamicBgView = this.G0;
        if (roomDynamicBgView != null) {
            roomDynamicBgView.setLifeCycleOwner(lifecycleOwner, viewModelStoreOwner);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements AnchorCountDownView.a {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            TimiAnchorView.this.f377400p0.i();
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorCountDownView.a
        public void b() {
            TimiAnchorView.this.H.setVisibility(8);
            if (TimiAnchorView.this.M0()) {
                TimiAnchorView.this.p1(new AnchorPrivateGuideView.a() { // from class: com.tencent.timi.game.liveroom.impl.room.anchor.z
                    @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorPrivateGuideView.a
                    public final void onFinish() {
                        TimiAnchorView.d.this.d();
                    }
                });
            } else {
                TimiAnchorView.this.f377400p0.i();
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorCountDownView.a
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements AnchorTopAreaView.d {
        c() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void a(long j3) {
            TimiAnchorView.this.d0();
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void c(long j3) {
            if (com.tencent.timi.game.utils.g.c(TimiAnchorView.this.getContext())) {
                Activity k06 = TimiAnchorView.this.k0();
                if (k06 != null) {
                    k06.finish();
                    return;
                }
                return;
            }
            TimiAnchorView.this.h1();
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public boolean onMoreClick() {
            return false;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void b(long j3) {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void d(long j3) {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView.d
        public void e(long j3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class p implements zi4.a<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> {
        p() {
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp trpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp) {
        }

        @Override // zi4.a
        public void fail(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class r implements EndLiveClickCallback {
        r() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onCloseClick(View view) {
            Activity k06 = TimiAnchorView.this.k0();
            if (k06 != null) {
                k06.finish();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onFollowClick(View view) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onHeadIconClick(View view) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onNickClick(View view) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onPopularityClick(View view) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onTimeClick(View view) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onRecommendClick(int i3, QQLiveEndRecommendInfo qQLiveEndRecommendInfo, View view) {
        }
    }

    public TimiAnchorView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f377382d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f377384e = new k();
        this.L = new NormalFloatingBannerLogic();
        this.R = new s();
        this.V = false;
        this.f377381c0 = new gk4.c();
        this.f377388g0 = new Eventor();
        this.f377390h0 = 0;
        this.f377395l0 = new com.tencent.mobileqq.qqlive.sail.ui.chat.a();
        this.f377400p0 = new com.tencent.mobileqq.qqlive.sail.ui.danmu.l();
        this.f377401q0 = false;
        this.f377402r0 = null;
        this.f377403s0 = new v();
        this.f377404t0 = new ej4.a(new w());
        this.f377405u0 = new x();
        this.f377406v0 = false;
        this.f377407w0 = false;
        this.f377408x0 = false;
        this.f377409y0 = false;
        this.f377410z0 = false;
        this.J0 = new y();
        this.K0 = new z();
        this.L0 = new aa();
        this.M0 = new ab();
        this.N0 = new l();
        this.O0 = new o();
        this.P0 = new u();
        r0();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class u implements IQQCmdPushCallback {
        u() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(byte[] bArr) {
            try {
                bl4.a c16 = bl4.a.c(bArr);
                if (102 == c16.f28641a) {
                    mr4.a c17 = mr4.a.c(c16.f28643c);
                    AegisLogger.i("Open_Live|TimiAnchorView", "onReceive", "cmd=285, subCmd=$SUB_POPUP_DIALOG, name=" + c17.f417463b + ", type=" + c17.f417462a + ", reason=" + c17.f417464c);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(c17.f417463b);
                    sb5.append("\n");
                    sb5.append(c17.f417464c);
                    qg4.e.a(sb5.toString(), null);
                }
            } catch (Exception e16) {
                AegisLogger.e("Open_Live|TimiAnchorView", "liveAlertPushReceived", "receive biz=285 data parse exception=" + e16.getMessage());
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int i3, String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class x implements ReceiveGiftMessageListener {
        x() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onGiftMessageReceive(GiftMessage giftMessage) {
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, String.valueOf(QQLiveSDKConfigHelper.getSceneId()));
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a a16 = oj4.a.a(giftMessage);
            if (a16 != null && TimiAnchorView.this.W != null) {
                a16.f264919j = TimiAnchorView.this.a0(a16.f264919j);
                TimiAnchorView.this.W.d(a16);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onError(int i3, String str) {
        }
    }

    public TimiAnchorView(@NonNull @NotNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f377382d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.f377384e = new k();
        this.L = new NormalFloatingBannerLogic();
        this.R = new s();
        this.V = false;
        this.f377381c0 = new gk4.c();
        this.f377388g0 = new Eventor();
        this.f377390h0 = 0;
        this.f377395l0 = new com.tencent.mobileqq.qqlive.sail.ui.chat.a();
        this.f377400p0 = new com.tencent.mobileqq.qqlive.sail.ui.danmu.l();
        this.f377401q0 = false;
        this.f377402r0 = null;
        this.f377403s0 = new v();
        this.f377404t0 = new ej4.a(new w());
        this.f377405u0 = new x();
        this.f377406v0 = false;
        this.f377407w0 = false;
        this.f377408x0 = false;
        this.f377409y0 = false;
        this.f377410z0 = false;
        this.J0 = new y();
        this.K0 = new z();
        this.L0 = new aa();
        this.M0 = new ab();
        this.N0 = new l();
        this.O0 = new o();
        this.P0 = new u();
        r0();
    }
}
