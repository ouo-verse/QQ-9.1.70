package com.tencent.mobileqq.troop.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/data/RobotInfoUpdateProcessor;", "Lm44/a;", "", "robotUin", "", "a", "newName", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class RobotInfoUpdateProcessor implements m44.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/data/RobotInfoUpdateProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.data.RobotInfoUpdateProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62010);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RobotInfoUpdateProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // m44.a
    public void a(@NotNull String robotUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) robotUin);
            return;
        }
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            IRuntimeService runtimeService = runtime.getRuntimeService(IQQAvatarHandlerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime\n             \u2026va, ProcessConstant.MAIN)");
            IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) runtimeService;
            iQQAvatarHandlerService.getCustomHead(robotUin);
            iQQAvatarHandlerService.sendBroadCastHeadChanged(1, robotUin);
        }
    }

    @Override // m44.a
    public void b(@NotNull final String robotUin, @NotNull String newName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) robotUin, (Object) newName);
            return;
        }
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(newName, "newName");
        final AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QLog.i("RobotInfoUpdateProcessor", 1, "updateFriendRobotName new nick length = " + newName.length() + ", robot uin: " + robotUin);
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(robotUin);
        QRouteApi api = QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IFriendsInfoService::class.java)");
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uid, robotUin);
        dVar.M();
        dVar.k0(newName);
        dVar.m0(newName);
        ((IFriendsInfoService) api).accurateUpdateNTFriendSimpleInfo(dVar, "RobotInfoUpdateProcessor", new hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>(robotUin) { // from class: com.tencent.mobileqq.troop.data.RobotInfoUpdateProcessor$updateFriendRobotName$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f294763b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f294763b = robotUin;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AppRuntime.this, (Object) robotUin);
                }
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> responseData) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) responseData);
                    return;
                }
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "RobotInfoUpdateProcessor_updateFriendRobotName", null, null, null, new RobotInfoUpdateProcessor$updateFriendRobotName$1$onUpdateResult$1(AppRuntime.this, this.f294763b, null), 14, null);
                }
            }
        });
    }
}
