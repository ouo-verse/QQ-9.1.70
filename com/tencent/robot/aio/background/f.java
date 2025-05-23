package com.tencent.robot.aio.background;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.inject.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOImmersiveApi;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.aio.background.a;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.aio.background.RobotAIOBackgroundContainer;
import com.tencent.robot.aio.background.RobotBackgroundMviIntent;
import com.tencent.robot.aio.background.RobotBackgroundUIState;
import com.tencent.robot.aio.story.RobotStoryMsgIntent;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.profile.RobotProfileMsgIntent;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\b\t*\u000204\b\u0007\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/robot/aio/background/f;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/robot/aio/background/RobotBackgroundMviIntent;", "Lcom/tencent/robot/aio/background/RobotBackgroundUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/robot/aio/background/RobotBackgroundMviIntent$InitBackground;", "intent", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Lcom/tencent/mvi/base/route/k;", "I", "Landroid/view/ViewGroup;", "background", "r", "", "uin", "", "bgType", "", "success", "errMsg", "", QCircleWeakNetReporter.KEY_COST, "v", "u", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "t", "d", "Ljava/lang/String;", "mRobotUin", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "e", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "mBackground", "f", "J", "mLoadStartTime", h.F, "Z", "mBackgroundLoaded", "i", "mIsStoryAIO", "com/tencent/robot/aio/background/f$d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/aio/background/f$d;", "mAction", "com/tencent/robot/aio/background/f$e", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/aio/background/f$e;", "mActionR", "<init>", "()V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f extends com.tencent.aio.base.mvvm.b<RobotBackgroundMviIntent, RobotBackgroundUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotAIOBackgroundContainer mBackground;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mLoadStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mBackgroundLoaded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsStoryAIO;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mRobotUin = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction = new d();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final e mActionR = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/robot/aio/background/f$b", "Lcom/tencent/mvi/base/route/k;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements k {
        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/aio/background/f$c", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer$a;", "", "success", "", "errMsg", "", "b", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements RobotAIOBackgroundContainer.a {
        c() {
        }

        @Override // com.tencent.robot.aio.background.RobotAIOBackgroundContainer.a
        public void a(boolean success, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            f fVar = f.this;
            fVar.v(fVar.mRobotUin, 2, success, errMsg, System.currentTimeMillis() - f.this.mLoadStartTime);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.robot.aio.background.RobotAIOBackgroundContainer.a
        public void b(boolean success, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            f.this.mBackgroundLoaded = true;
            ((com.tencent.aio.api.runtime.a) f.this.getMContext()).e().h(new AIOBackgroundMsgIntent.OnBackgroundLoadCompleted(success));
            RobotAIOBackgroundContainer robotAIOBackgroundContainer = f.this.mBackground;
            int i3 = 0;
            if (robotAIOBackgroundContainer != null && robotAIOBackgroundContainer.o()) {
                i3 = 1;
            }
            f fVar = f.this;
            fVar.v(fVar.mRobotUin, i3 ^ 1, success, errMsg, System.currentTimeMillis() - f.this.mLoadStartTime);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/background/f$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            f.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/aio/background/f$e", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements com.tencent.mvi.base.route.b {
        e() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return f.this.I(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.OnFirstScreenShow) {
            if (!this.mIsStoryAIO) {
                updateUI(RobotBackgroundUIState.EnterAIOAnimationEnd.f366845d);
            }
        } else if (intent instanceof RobotStoryMsgIntent.RobotStoryAnimEnd) {
            updateUI(RobotBackgroundUIState.EnterAIOAnimationEnd.f366845d);
        } else if (intent instanceof RobotProfileMsgIntent.OnRobotProfileUpdate) {
            updateUI(new RobotBackgroundUIState.OnBackgroundInfoUpdate(((RobotProfileMsgIntent.OnRobotProfileUpdate) intent).getRobotProfile(), this.mIsStoryAIO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k I(MsgIntent intent) {
        Drawable drawable;
        if (intent instanceof AIOBackgroundMsgIntent.GetBackgroundDrawable) {
            RobotAIOBackgroundContainer robotAIOBackgroundContainer = this.mBackground;
            if (robotAIOBackgroundContainer != null) {
                drawable = robotAIOBackgroundContainer.i();
            } else {
                drawable = null;
            }
            return new a.C9469a(drawable);
        }
        if (intent instanceof AIOBackgroundMsgIntent.GetBackgroundView) {
            return new a.c(this.mBackground);
        }
        if (intent instanceof AIOBackgroundMsgIntent.GetBackgroundLoadCompleted) {
            return new a.b(this.mBackgroundLoaded);
        }
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(ViewGroup background) {
        Activity activity;
        int i3;
        Context context = background.getContext();
        boolean enableImmersive = ((IAIOImmersiveApi) QRoute.api(IAIOImmersiveApi.class)).enableImmersive((com.tencent.aio.api.runtime.a) getMContext());
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            com.tencent.mobileqq.qui.b.f276860a.l(activity.getWindow());
        }
        if (enableImmersive) {
            i3 = R.drawable.qui_common_bg_nav_bottom_aio_bg_robot;
        } else {
            i3 = R.drawable.qui_common_bg_nav_bottom_aio_bg;
        }
        com.tencent.mobileqq.qui.b.f276860a.g(background, ContextCompat.getDrawable(context, i3));
    }

    private final void s(RobotBackgroundMviIntent.InitBackground intent) {
        this.mLoadStartTime = System.currentTimeMillis();
        RobotAIOBackgroundContainer background = intent.getBackground();
        this.mBackground = background;
        if (background != null) {
            background.setBackgroundListener(new c());
        }
        RobotAIOBackgroundContainer.setInfo$default(intent.getBackground(), this.mRobotUin, ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotCoreInfoFromFriendsCache(this.mRobotUin), false, this.mIsStoryAIO, false, 20, null);
        r(intent.getBackground());
    }

    private final boolean u() {
        if (Random.INSTANCE.nextInt(0, 10) != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String uin, int bgType, boolean success, String errMsg, long cost) {
        String str;
        if (!u()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("bot_uin", uin);
        hashMap.put("bg_type", String.valueOf(bgType));
        if (success) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("result", str);
        hashMap.put("error_msg", errMsg);
        hashMap.put("load_cost_ms", String.valueOf(cost));
        v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "robot_aio_bg_load", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("RobotBackgroundVM", 4, "reportBgLoadEvent uin=" + uin + " bgType=" + bgType + " cost=" + cost + " result=" + success + " msg=" + errMsg);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.OnFirstScreenShow");
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotProfileUpdate");
        hashSet.add("com.tencent.robot.aio.story.RobotStoryMsgIntent.RobotStoryAnimEnd");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.GetBackgroundDrawable");
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.GetBackgroundView");
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.GetBackgroundLoadCompleted");
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        String friendUinFromUid;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        long a16 = su3.c.a(g16);
        if (a16 != 0) {
            friendUinFromUid = String.valueOf(a16);
        } else {
            friendUinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUinFromUid(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j());
            Intrinsics.checkNotNullExpressionValue(friendUinFromUid, "{\n            val peerUi\u2026romUid(peerUid)\n        }");
        }
        this.mRobotUin = friendUinFromUid;
        this.mIsStoryAIO = AdelieUtils.f365929a.T((com.tencent.aio.api.runtime.a) getMContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        RobotAIOBackgroundContainer robotAIOBackgroundContainer = this.mBackground;
        if (robotAIOBackgroundContainer != null) {
            robotAIOBackgroundContainer.t();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull RobotBackgroundMviIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof RobotBackgroundMviIntent.InitBackground) {
            s((RobotBackgroundMviIntent.InitBackground) intent);
        }
    }
}
