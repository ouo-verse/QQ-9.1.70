package com.tencent.mobileqq.nearbypro.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.part.MainTitlePart;
import com.tencent.mobileqq.nearbypro.utils.api.INearbyProToolApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.x;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUnreadInfo;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import cooperation.qzone.PlatformInfor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u001b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/MainTitlePart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "", "O9", "I9", "J9", "L9", "M9", "", "unreadCnt", "P9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", PlatformInfor.SIMPLE_MODE, "C9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "f", "Landroid/view/View;", "titleRootView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "mAllContactsUnreadCntView", "com/tencent/mobileqq/nearbypro/part/MainTitlePart$b", "i", "Lcom/tencent/mobileqq/nearbypro/part/MainTitlePart$b;", "mNearbyProListener", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MainTitlePart extends e {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View titleRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAllContactsUnreadCntView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mNearbyProListener = new b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/part/MainTitlePart$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUnreadInfo;", "unreadCnt", "", "onNearbyAllContactsUnreadCntChanged", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements IKernelNearbyProListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MainTitlePart this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.P9(j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener
        public void onNearbyAllContactsUnreadCntChanged(@Nullable NearbyProUnreadInfo unreadCnt) {
            if (unreadCnt != null) {
                final long j3 = unreadCnt.unreadCnt;
                final MainTitlePart mainTitlePart = MainTitlePart.this;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainTitlePart.b.b(MainTitlePart.this, j3);
                    }
                });
            }
        }
    }

    private final void I9() {
        final View findViewById;
        View view = this.titleRootView;
        if (view != null && (findViewById = view.findViewById(R.id.t2r)) != null) {
            final long j3 = 200;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$initBackIv$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.getActivity().finish();
                    final View view2 = findViewById;
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$initBackIv$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
    }

    private final void J9() {
        TextView textView;
        AppInterface appInterface;
        x nearbyProService;
        final View findViewById;
        View view = this.titleRootView;
        if (view != null && (findViewById = view.findViewById(R.id.f164775tt1)) != null) {
            final long j3 = 200;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$initChatEntrance$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Intent intent = new Intent();
                    intent.putExtra("open_chats_list_source", 0);
                    INearbyProPageRouter iNearbyProPageRouter = (INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class);
                    Context context = it.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "it.context");
                    iNearbyProPageRouter.launchNearbyChatsListFragment(context, intent);
                    final View view2 = findViewById;
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$initChatEntrance$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
        View view2 = this.titleRootView;
        IRuntimeService iRuntimeService = null;
        if (view2 != null) {
            textView = (TextView) view2.findViewById(R.id.f114356t4);
        } else {
            textView = null;
        }
        this.mAllContactsUnreadCntView = textView;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (nearbyProService = iKernelService.getNearbyProService()) != null) {
            nearbyProService.addKernelNearbyProListener(this.mNearbyProListener);
            nearbyProService.Y(new IOperateCallback() { // from class: com.tencent.mobileqq.nearbypro.part.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    MainTitlePart.K9(MainTitlePart.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(MainTitlePart this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ga2.a c16 = j.c();
        String logTag = this$0.getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.e(logTag, "getNearByAllContactsUnreadCnt result = " + i3 + " errMsg = " + str);
    }

    private final void L9() {
        final View findViewById;
        View view = this.titleRootView;
        if (view != null && (findViewById = view.findViewById(R.id.zwk)) != null) {
            final long j3 = 200;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$initOldVersionIv$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    final View view2 = findViewById;
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$initOldVersionIv$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
    }

    private final void M9() {
        ViewGroup.LayoutParams layoutParams;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            j.c().e("MainTitlePart", "onInitView statusBarHeight=" + statusBarHeight);
            View view = this.titleRootView;
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams == null) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            }
            marginLayoutParams.topMargin = statusBarHeight;
            View view2 = this.titleRootView;
            if (view2 != null) {
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N9(MainTitlePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("MSG_SHOW_FPS_ACTION", null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("nearby_pro_beta_version_dsc", "");
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        commonUtils.showDialog((Context) activity, loadAsString, "\u6211\u77e5\u9053\u4e86", "\u5b89\u5168\u58f0\u660e", true, (Function0<Unit>) new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$openSafeStatement$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(long unreadCnt) {
        j.c().e("MainTitlePart", "updateAllContactsUnreadCnt unreadCnt = " + unreadCnt);
        TextView textView = this.mAllContactsUnreadCntView;
        if (textView != null) {
            if (unreadCnt <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                ((INearbyProToolApi) QRoute.api(INearbyProToolApi.class)).updateCustomNoteText(textView, (int) unreadCnt, R.drawable.n3l, 99);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e
    public void C9(boolean concise) {
        j.c().e("NBP.LocationPart", "onStyleModeChange concise=" + concise);
        View findViewById = getPartRootView().findViewById(R.id.uc9);
        if (findViewById != null) {
            Boolean valueOf = Boolean.valueOf(concise);
            findViewById.setVisibility(8);
            if (((View) au.a(valueOf, findViewById)) == null) {
                findViewById.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        View findViewById;
        final View findViewById2;
        final View findViewById3;
        final View findViewById4;
        ViewStub viewStub;
        super.onInitView(rootView);
        if (rootView != null && (viewStub = (ViewStub) rootView.findViewById(R.id.ywc)) != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        this.titleRootView = view;
        I9();
        J9();
        L9();
        M9();
        View view3 = this.titleRootView;
        final long j3 = 200;
        if (view3 != null && (findViewById4 = view3.findViewById(R.id.zwk)) != null) {
            findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$onInitView$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById4.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    final View view4 = findViewById4;
                    view4.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$onInitView$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view4.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
        View view4 = this.titleRootView;
        if (view4 != null && (findViewById3 = view4.findViewById(R.id.ugz)) != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$onInitView$$inlined$setSingleClickListener$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById3.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.O9();
                    final View view5 = findViewById3;
                    view5.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$onInitView$$inlined$setSingleClickListener$2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view5.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
        View view5 = this.titleRootView;
        if (view5 != null && (findViewById2 = view5.findViewById(R.id.uon)) != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$onInitView$$inlined$setSingleClickListener$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById2.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.O9();
                    final View view6 = findViewById2;
                    view6.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.MainTitlePart$onInitView$$inlined$setSingleClickListener$3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view6.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
        if (!ab2.a.f25767a.s() && (view2 = this.titleRootView) != null && (findViewById = view2.findViewById(R.id.jp6)) != null) {
            findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view6) {
                    boolean N9;
                    N9 = MainTitlePart.N9(MainTitlePart.this, view6);
                    return N9;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        AppInterface appInterface;
        x nearbyProService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        ga2.a c16 = j.c();
        String logTag = getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
        c16.e(logTag, "onPartDestroy removeKernelNearbyProListener");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (nearbyProService = iKernelService.getNearbyProService()) != null) {
            nearbyProService.removeKernelNearbyProListener(this.mNearbyProListener);
        }
    }
}
