package com.tencent.robot.discover.part;

import a54.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import com.tencent.robot.relation.api.IRobotRelationService;
import com.tencent.util.LongSparseArray;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u001c\u0010\u0015\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR,\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/discover/part/RobotTroopObserverPart;", "Lcom/tencent/biz/richframework/part/Part;", "Ll34/c;", "", "success", "", "robotUin", "", "B9", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", IRobotUtilApi.MMKV_SCENE_ID, "Lkotlin/Function0;", "callback", "i1", "", "redDot", "B2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "d", "Ljava/lang/String;", "mTroopUin", "Lcom/tencent/util/LongSparseArray;", "Lkotlin/Pair;", "e", "Lcom/tencent/util/LongSparseArray;", "mAddRobotCallbackSparseArray", "com/tencent/robot/discover/part/RobotTroopObserverPart$a", "f", "Lcom/tencent/robot/discover/part/RobotTroopObserverPart$a;", "mRobotRelationObserver", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotTroopObserverPart extends Part implements l34.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTroopUin = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LongSparseArray<Pair<RobotBase, Function0<Unit>>> mAddRobotCallbackSparseArray = new LongSparseArray<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mRobotRelationObserver = new a();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/discover/part/RobotTroopObserverPart$a", "La54/a;", "", "robotUin", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "", "d", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements a54.a {
        a() {
        }

        @Override // a54.a
        public void a(@NotNull String str) {
            a.C0013a.e(this, str);
        }

        @Override // a54.a
        public void b(@NotNull String str) {
            a.C0013a.d(this, str);
        }

        @Override // a54.a
        public void c(@NotNull String str) {
            a.C0013a.a(this, str);
        }

        @Override // a54.a
        public void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.c(this, robotUin, troopUin, extraData);
            if (Intrinsics.areEqual(troopUin, RobotTroopObserverPart.this.mTroopUin)) {
                RobotTroopObserverPart.this.B9(true, Util.toLongOrDefault(robotUin, 0L));
            }
        }

        @Override // a54.a
        public void e(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            a.C0013a.b(this, robotUin, troopUin, extraData);
            if (Intrinsics.areEqual(troopUin, RobotTroopObserverPart.this.mTroopUin)) {
                RobotTroopObserverPart.this.B9(false, Util.toLongOrDefault(robotUin, 0L));
            }
        }

        @Override // a54.a
        public void f(@NotNull String str, @NotNull String str2) {
            a.C0013a.f(this, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B9(boolean success, long robotUin) {
        LifecycleCoroutineScope lifecycleScope;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        if (lifecycleOwner != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            String logTag = getLogTag();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            CorountineFunKt.e(lifecycleScope, logTag, Boolean.TRUE, null, null, new RobotTroopObserverPart$dispatchOnAddRobotCallback$1(success, this, robotUin, null), 12, null);
        }
    }

    @Override // l34.c
    public void B2(@NotNull String robotUin, boolean redDot) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
    }

    @Override // l34.c
    public void i1(@NotNull RobotBase robot, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(robot, "robot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mAddRobotCallbackSparseArray.append(robot.robotUin, TuplesKt.to(robot, callback));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        l34.e.f(rootView, this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        String str;
        Intent intent;
        IRuntimeService iRuntimeService = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("troop_uin");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.mTroopUin = str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.addRelationObserver(this.mRobotRelationObserver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IRuntimeService iRuntimeService;
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            iRobotRelationService.removeRelationObserver(this.mRobotRelationObserver);
        }
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        l34.e.g(rootView, l34.c.class);
        this.mAddRobotCallbackSparseArray.clear();
    }
}
