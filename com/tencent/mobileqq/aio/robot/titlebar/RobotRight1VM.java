package com.tencent.mobileqq.aio.robot.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.ScaleAIOEvent;
import com.tencent.mobileqq.aio.event.ZPlanMsgEvent;
import com.tencent.mobileqq.aio.robot.titlebar.RobotRight1UIState;
import com.tencent.mobileqq.aio.robot.titlebar.i;
import com.tencent.mobileqq.aio.title.af;
import com.tencent.mobileqq.aio.title.al;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.aio.adapter.api.ITitleRight1IvApi;
import com.tencent.qqnt.aio.utils.AIOExpandFullScreenSwitch;
import com.tencent.qqnt.aio.utils.o;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendResponse;
import com.tencent.qqnt.robot.api.IRobotBuddyApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00019B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\f\u0010\u001e\u001a\u00020\u0006*\u00020\u0000H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotRight1VM;", "Lcom/tencent/mobileqq/aio/title/al;", "Lcom/tencent/mobileqq/aio/robot/titlebar/i;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotRight1UIState;", "", "isSelectMode", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight1IvEvent;", "intent", "D", "", "type", "", "data", "G", "Lcom/tencent/mobileqq/aio/event/ZPlanMsgEvent$ShowBubbleTipEvent;", "y", "v", "M", "w", "J", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "N", "O", "H", "P", UserInfo.SEX_FEMALE, "K", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "L", "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "B", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Z", "mIsSelectedMode", tl.h.F, "mShowFullScreenBtn", "Lcom/tencent/mobileqq/aio/title/af;", "i", "Lcom/tencent/mobileqq/aio/title/af;", "mLastData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Z", "mIsRobotAio", "", "mRobotListenerId", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "mAnimationJob", "<init>", "()V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotRight1VM extends al<i, RobotRight1UIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private long mRobotListenerId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Job mAnimationJob;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectedMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mShowFullScreenBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private af mLastData = new af(false, false, null, null, 0);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mIsRobotAio;

    public RobotRight1VM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotRight1VM$mIsRobotAio$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) QRoute.api(IRobotServiceApi.class);
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) RobotRight1VM.this.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                return Boolean.valueOf(iRobotServiceApi.isRobotAIO(String.valueOf(su3.c.a(g16)), Integer.valueOf(((com.tencent.aio.api.runtime.a) RobotRight1VM.this.getMContext()).g().r().c().e())));
            }
        });
        this.mIsRobotAio = lazy;
        this.mRobotListenerId = Long.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A(RobotRight1VM this_handleClickAddFriend, int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
        Intrinsics.checkNotNullParameter(this_handleClickAddFriend, "$this_handleClickAddFriend");
        boolean z16 = true;
        QLog.d(FrameworkVM.TAG, 1, "addFriend result: " + i3 + ", errMsg: " + str);
        if (i3 == 0) {
            this_handleClickAddFriend.updateUI(new RobotRight1UIState.ShowSuccessToast("\u5df2\u6dfb\u52a0\u5230\u5bf9\u8bdd"));
            return;
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            str = ((com.tencent.aio.api.runtime.a) this_handleClickAddFriend.getMContext()).c().getString(R.string.ci7);
        }
        Intrinsics.checkNotNullExpressionValue(str, "errMsg.ifEmpty {\n       \u2026      )\n                }");
        this_handleClickAddFriend.updateUI(new RobotRight1UIState.ShowErrorToast(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(boolean isSelectMode) {
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context == null) {
            return;
        }
        this.mIsSelectedMode = isSelectMode;
        AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
        boolean z16 = true;
        if ((c16.e() != 2 && c16.e() != 1) || x()) {
            z16 = false;
        }
        if (!isSelectMode) {
            updateUI(new RobotRight1UIState.UpdateDataUIState(this.mLastData));
        } else if (z16) {
            updateUI(new RobotRight1UIState.UpdateDataUIState(new af(false, true, ResourcesCompat.getDrawable(context.getResources(), R.drawable.qui_search_icon_navigation_02, context.getTheme()), "\u641c\u7d22", 7)));
        } else {
            updateUI(new RobotRight1UIState.UpdateDataUIState(new af(false, false, null, "", 7)));
        }
    }

    private final void D(AIOTitleEvent.UpdateRight1IvEvent intent) {
        String a16;
        if (intent.a() == null) {
            a16 = HardCodeUtil.qqStr(R.string.f170301yu2);
        } else {
            a16 = intent.a();
        }
        af afVar = new af(intent.c(), intent.e(), intent.d(), a16, intent.b());
        if (intent.b() != 8 && intent.b() != 9) {
            this.mLastData = afVar;
        }
        if (this.mIsSelectedMode) {
            return;
        }
        if (intent.b() == 9) {
            updateUI(new RobotRight1UIState.UpdateDataUIState(this.mLastData));
        } else {
            updateUI(new RobotRight1UIState.UpdateDataUIState(afVar));
        }
    }

    private final void F() {
        Q();
        this.mShowFullScreenBtn = false;
    }

    private final void G(int type, Object data) {
        if (type == 5 && !this.mShowFullScreenBtn) {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.Boolean");
            updateUI(new RobotRight1UIState.UpdateRedPointUIState(((Boolean) data).booleanValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean H() {
        Boolean isBuddy;
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null && (isBuddy = b16.isBuddy(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j())) != null) {
            return isBuddy.booleanValue();
        }
        return false;
    }

    private final void J() {
        M();
        this.mRobotListenerId = ((IRobotBuddyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotBuddyApi.class)).addRobotFriendShipChangedListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotRight1VM$listenRobotFriendListChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                boolean z17;
                af afVar;
                boolean H;
                z16 = RobotRight1VM.this.mShowFullScreenBtn;
                if (z16) {
                    return;
                }
                z17 = RobotRight1VM.this.mIsSelectedMode;
                if (z17) {
                    return;
                }
                afVar = RobotRight1VM.this.mLastData;
                if (Intrinsics.areEqual(afVar.c(), HardCodeUtil.qqStr(R.string.yog))) {
                    H = RobotRight1VM.this.H();
                    if (H) {
                        RobotRight1VM.this.L();
                    } else {
                        RobotRight1VM.this.N();
                    }
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        boolean z16;
        Boolean isBuddy;
        Unit unit;
        if (com.tencent.mobileqq.aio.panel.c.f193019a.a((com.tencent.aio.api.runtime.a) getMContext())) {
            QLog.i(FrameworkVM.TAG, 1, "[onRight1IvClick]: hideKeyboard");
            FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
            if (activity != null) {
                o.f352309a.a(activity);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.i(FrameworkVM.TAG, 1, "[onRight1IvClick]: hideKeyboard fail");
            }
        }
        if (this.mIsSelectedMode || Intrinsics.areEqual(this.mLastData.c(), "\u6dfb\u52a0\u6210\u529f")) {
            return;
        }
        if (this.mShowFullScreenBtn) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("expand_full_screen", new Bundle()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.ExpandFullScreenClickEvent.f188485d);
            QLog.d(FrameworkVM.TAG, 1, "onExpandFullScreenClick");
            return;
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null && (isBuddy = b16.isBuddy(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j())) != null) {
            z16 = isBuddy.booleanValue();
        } else {
            z16 = false;
        }
        if (z16) {
            ((ITitleRight1IvApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ITitleRight1IvApi.class)).onRight1IvClick((com.tencent.aio.api.runtime.a) getMContext(), AIOUtil.f194084a.n(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.Right1IvClickEvent.f188499d);
        } else {
            z(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void L() {
        Job launch$default;
        Job job = this.mAnimationJob;
        boolean z16 = false;
        if (job != null && job.isActive()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) getMContext()).d();
        Intrinsics.checkNotNullExpressionValue(d16, "mContext.lifecycleOwner");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), null, null, new RobotRight1VM$playAddFriendSuccessAni$1(this, null), 3, null);
        this.mAnimationJob = launch$default;
    }

    private final void M() {
        ((IRobotBuddyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotBuddyApi.class)).removeRobotFriendShipChangedListener(this.mRobotListenerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void N() {
        Resources.Theme theme;
        Resources resources = ((com.tencent.aio.api.runtime.a) getMContext()).c().getResources();
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context != null) {
            theme = context.getTheme();
        } else {
            theme = null;
        }
        Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.qui_add_friend, theme);
        if (drawable != null) {
            drawable.setColorFilter(((com.tencent.aio.api.runtime.a) getMContext()).c().getResources().getColor(R.color.qui_common_icon_nav_primary), PorterDuff.Mode.SRC_IN);
        }
        af b16 = af.b(this.mLastData, false, true, drawable, HardCodeUtil.qqStr(R.string.yog), 1, 1, null);
        this.mLastData = b16;
        updateUI(new RobotRight1UIState.UpdateDataUIState(b16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void O() {
        Resources.Theme theme;
        Resources resources = ((com.tencent.aio.api.runtime.a) getMContext()).c().getResources();
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context != null) {
            theme = context.getTheme();
        } else {
            theme = null;
        }
        Drawable drawable = ResourcesCompat.getDrawable(resources, R.drawable.qui_tick, theme);
        if (drawable != null) {
            drawable.setColorFilter(((com.tencent.aio.api.runtime.a) getMContext()).c().getResources().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN);
        }
        af b16 = af.b(this.mLastData, false, true, drawable, "\u6dfb\u52a0\u6210\u529f", 1, 1, null);
        this.mLastData = b16;
        updateUI(new RobotRight1UIState.UpdateDataUIState(b16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P() {
        af afVar = new af(false, true, ((com.tencent.aio.api.runtime.a) getMContext()).c().getResources().getDrawable(R.drawable.qui_zoom_out_nav_secondary), HardCodeUtil.qqStr(R.string.f170300yu1), 1);
        this.mLastData = afVar;
        updateUI(new RobotRight1UIState.UpdateDataUIState(afVar));
    }

    private final void Q() {
        if (H()) {
            R();
        } else {
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void R() {
        af b16 = af.b(this.mLastData, false, true, ((IAIOTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleApi.class)).getRight1Bg((com.tencent.aio.api.runtime.a) getMContext()), HardCodeUtil.qqStr(R.string.f170301yu2), 1, 1, null);
        this.mLastData = b16;
        updateUI(new RobotRight1UIState.UpdateDataUIState(b16));
    }

    private final void v() {
        Job job = this.mAnimationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mAnimationJob = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        J();
        boolean z16 = false;
        this.mIsSelectedMode = false;
        if (com.tencent.mobileqq.aio.a.d((com.tencent.aio.api.runtime.a) getMContext()) && AIOExpandFullScreenSwitch.f352242a.a()) {
            z16 = true;
        }
        this.mShowFullScreenBtn = z16;
        if (z16) {
            P();
        } else {
            Q();
        }
    }

    private final boolean x() {
        return ((Boolean) this.mIsRobotAio.getValue()).booleanValue();
    }

    private final void y(ZPlanMsgEvent.ShowBubbleTipEvent intent) {
        updateUI(new RobotRight1UIState.ShowBubbleTipUIState(intent.a()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z(final RobotRight1VM robotRight1VM) {
        if (!AppNetConnInfo.isNetSupport()) {
            String string = ((com.tencent.aio.api.runtime.a) robotRight1VM.getMContext()).c().getString(R.string.ci7);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.fragment.getString(R.string.net_error)");
            robotRight1VM.updateUI(new RobotRight1UIState.ShowErrorToast(string));
        } else {
            IRobotBuddyApi iRobotBuddyApi = (IRobotBuddyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotBuddyApi.class);
            String j3 = ((com.tencent.aio.api.runtime.a) robotRight1VM.getMContext()).g().r().c().j();
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) robotRight1VM.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            iRobotBuddyApi.addFriend(j3, su3.c.a(g16), new IAddFriendCallback() { // from class: com.tencent.mobileqq.aio.robot.titlebar.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback
                public final void onResult(int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
                    RobotRight1VM.A(RobotRight1VM.this, i3, str, robotAddFriendResponse);
                }
            });
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull i intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof i.b) {
            w();
        } else if (intent instanceof i.a) {
            K();
        }
    }

    @Override // com.tencent.mobileqq.aio.title.al
    public void E(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            C(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
            return;
        }
        if (intent instanceof AIOTitleEvent.UpdateRight1IvEvent) {
            D((AIOTitleEvent.UpdateRight1IvEvent) intent);
            return;
        }
        if (intent instanceof AIOTitleEvent.TitleResponseEvent) {
            AIOTitleEvent.TitleResponseEvent titleResponseEvent = (AIOTitleEvent.TitleResponseEvent) intent;
            G(titleResponseEvent.b(), titleResponseEvent.a());
        } else if (intent instanceof ZPlanMsgEvent.ShowBubbleTipEvent) {
            y((ZPlanMsgEvent.ShowBubbleTipEvent) intent);
        } else if (intent instanceof ScaleAIOEvent.SwitchToFullScreen) {
            F();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateRight1IvEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.TitleResponseEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ZPlanMsgEvent.ShowBubbleTipEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ScaleAIOEvent.SwitchToFullScreen");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.aio.title.al, com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        M();
        v();
    }
}
