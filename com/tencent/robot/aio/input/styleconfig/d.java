package com.tencent.robot.aio.input.styleconfig;

import com.tencent.adelie.av.api.IAdelieAVActivityApi;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import com.tencent.robot.api.IRobotDebugApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/aio/input/styleconfig/d;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "e", "f", "c", "d", "g", "Lcom/tencent/aio/api/runtime/a;", "aioContext", h.F, "b", "i", "Lcom/tencent/robot/aio/input/styleconfig/a;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f367243a = new d();

    d() {
    }

    private final boolean b() {
        return !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("robot_share_message_disabled_9120", false);
    }

    private final boolean c(GroupRobotProfile robotProfile) {
        QRouteApi api = QRoute.api(IRobotDebugApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotDebugApi::class.java)");
        IRobotDebugApi iRobotDebugApi = (IRobotDebugApi) api;
        if (iRobotDebugApi.isUseDebugInputConfig()) {
            boolean isSupportInputCamera = iRobotDebugApi.isSupportInputCamera();
            QLog.i("RobotInputStyleConfigCreator", 1, "useDebugInputConfig isSupportInputCamera = " + isSupportInputCamera);
            return isSupportInputCamera;
        }
        InputBox inputBox = robotProfile.inputBox;
        boolean z16 = false;
        if (inputBox != null && inputBox.supportCamera == 0) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean d(GroupRobotProfile robotProfile) {
        QRouteApi api = QRoute.api(IRobotDebugApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotDebugApi::class.java)");
        IRobotDebugApi iRobotDebugApi = (IRobotDebugApi) api;
        if (iRobotDebugApi.isUseDebugInputConfig()) {
            boolean isSupportInputFile = iRobotDebugApi.isSupportInputFile();
            QLog.i("RobotInputStyleConfigCreator", 1, "useDebugInputConfig isSupportInputFile = " + isSupportInputFile);
            return isSupportInputFile;
        }
        InputBox inputBox = robotProfile.inputBox;
        boolean z16 = false;
        if (inputBox != null && inputBox.supportFile == 0) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean e(GroupRobotProfile robotProfile) {
        QRouteApi api = QRoute.api(IRobotDebugApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotDebugApi::class.java)");
        IRobotDebugApi iRobotDebugApi = (IRobotDebugApi) api;
        if (iRobotDebugApi.isUseDebugInputConfig()) {
            QLog.i("RobotInputStyleConfigCreator", 1, "useDebugInputConfig isSupportInputMenu = " + iRobotDebugApi.isSupportInputMenu());
            return iRobotDebugApi.isSupportInputMenu();
        }
        InputBox inputBox = robotProfile.inputBox;
        boolean z16 = false;
        if (inputBox != null && inputBox.supportMenu == 0) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean f(GroupRobotProfile robotProfile) {
        QRouteApi api = QRoute.api(IRobotDebugApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotDebugApi::class.java)");
        IRobotDebugApi iRobotDebugApi = (IRobotDebugApi) api;
        if (iRobotDebugApi.isUseDebugInputConfig()) {
            boolean isSupportInputPic = iRobotDebugApi.isSupportInputPic();
            QLog.i("RobotInputStyleConfigCreator", 1, "useDebugInputConfig isSupportInputPic = " + isSupportInputPic);
            return isSupportInputPic;
        }
        InputBox inputBox = robotProfile.inputBox;
        boolean z16 = false;
        if (inputBox != null && inputBox.supportPhoto == 0) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean g(GroupRobotProfile robotProfile) {
        QRouteApi api = QRoute.api(IRobotDebugApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotDebugApi::class.java)");
        IRobotDebugApi iRobotDebugApi = (IRobotDebugApi) api;
        if (iRobotDebugApi.isUseDebugInputConfig()) {
            QLog.i("RobotInputStyleConfigCreator", 1, "useDebugInputConfig isSupportInputSlashPanel = " + iRobotDebugApi.isSupportInputSlashPanel());
            return iRobotDebugApi.isSupportInputSlashPanel();
        }
        InputBox inputBox = robotProfile.inputBox;
        boolean z16 = false;
        if (inputBox != null && inputBox.supportPanel == 0) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean h(com.tencent.aio.api.runtime.a aioContext, GroupRobotProfile robotProfile) {
        boolean z16;
        QRouteApi api = QRoute.api(IRobotDebugApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotDebugApi::class.java)");
        IRobotDebugApi iRobotDebugApi = (IRobotDebugApi) api;
        if (iRobotDebugApi.isUseDebugInputConfig()) {
            boolean isSupportInputStory = iRobotDebugApi.isSupportInputStory();
            QLog.i("RobotInputStyleConfigCreator", 1, "useDebugInputConfig isSupportInputStory = " + isSupportInputStory);
            return isSupportInputStory;
        }
        if (com.tencent.mobileqq.aio.a.c(aioContext) || com.tencent.mobileqq.aio.a.d(aioContext)) {
            return false;
        }
        if (q64.b.f428454a.a()) {
            InputBox inputBox = robotProfile.inputBox;
            if (inputBox != null && inputBox.supportStory == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return true;
            }
        }
        return false;
    }

    private final boolean i(com.tencent.aio.api.runtime.a aioContext) {
        y24.a aVar = (y24.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("106076");
        if (aVar != null) {
            AIOParam g16 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            return aVar.b(su3.c.b(g16));
        }
        return false;
    }

    @NotNull
    public final a a(@NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable GroupRobotProfile robotProfile) {
        InputStyleType inputStyleType;
        int G;
        int z16;
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        boolean z17 = false;
        if (robotProfile == null) {
            InputStyleType inputStyleType2 = InputStyleType.STYLE_SINGLE_BASE;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return new a(inputStyleType2, emptyList, emptyList2, false);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean e16 = e(robotProfile);
        boolean f16 = f(robotProfile);
        boolean c16 = c(robotProfile);
        boolean d16 = d(robotProfile);
        boolean g16 = g(robotProfile);
        InputBox inputBox = robotProfile.inputBox;
        if (inputBox != null && inputBox.supportTelephone == 0) {
            z17 = true;
        }
        boolean z18 = !z17;
        boolean h16 = h(aioContext, robotProfile);
        b();
        if (e16) {
            arrayList.add(1011);
        }
        if (f16) {
            if (i(aioContext)) {
                z16 = 1300000004;
            } else {
                z16 = com.tencent.qqnt.pluspanel.utils.a.INSTANCE.z();
            }
            arrayList2.add(Integer.valueOf(z16));
        }
        if (c16) {
            if (i(aioContext)) {
                G = 1300000005;
            } else {
                G = com.tencent.qqnt.pluspanel.utils.a.INSTANCE.G();
            }
            arrayList2.add(Integer.valueOf(G));
        }
        if (d16) {
            arrayList2.add(Integer.valueOf(com.tencent.qqnt.pluspanel.utils.a.INSTANCE.q()));
        }
        if (z18 && ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).isOpenEntrance()) {
            arrayList2.add(Integer.valueOf(com.tencent.qqnt.pluspanel.utils.a.INSTANCE.x()));
        }
        if (h16) {
            arrayList2.add(1300000002);
        }
        if (arrayList2.isEmpty()) {
            inputStyleType = InputStyleType.STYLE_SINGLE_BASE;
        } else {
            inputStyleType = InputStyleType.STYLE_SINGLE_PLUS;
        }
        return new a(inputStyleType, arrayList, arrayList2, g16);
    }
}
