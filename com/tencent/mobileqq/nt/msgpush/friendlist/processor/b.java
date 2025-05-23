package com.tencent.mobileqq.nt.msgpush.friendlist.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/friendlist/processor/b;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f254432b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/friendlist/processor/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nt.msgpush.friendlist.processor.b$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f254432b = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("friend_cache_save_optimization_2", true);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        a a16 = convertResultData.a();
        if (a16 == null) {
            return;
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).initFriendsInfoListener("FriendListCommonProcessor", false);
        if (QLog.isColorLevel()) {
            QLog.i("FriendListCommonProcessor", 1, "FriendListCommonProcessor processor friendListBusinessData.seq is " + a16.a() + " FriendNTMMKV.getInstance().requestFriendListSeq is " + com.tencent.mobileqq.friend.utils.b.d().f());
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.e("FriendListCommonProcessor", 1, "FriendListCommonProcessor processor is error! app is null!");
            return;
        }
        if (a16.a() == com.tencent.mobileqq.friend.utils.b.d().f()) {
            QLog.i("FriendListCommonProcessor", 1, "friendListBusinessData.seq == FriendNTMMKV.getInstance().requestFriendListSeq, seq is " + a16.a());
            return;
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IFriendDataService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026dDataService::class.java)");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
        QLog.i("FriendListCommonProcessor", 1, "requestFriendListForNT friend_cache_save_optimization_2 switchState is " + f254432b);
        if (!f254432b) {
            IRuntimeService runtimeService2 = qQAppInterface.getRuntimeService(IFriendHandlerService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IF\u2026ndlerService::class.java)");
            ((IFriendHandlerService) runtimeService2).requestFriendList(false, a16.a());
        } else {
            if (iFriendDataService.isInitFinished()) {
                IRuntimeService runtimeService3 = qQAppInterface.getRuntimeService(IFriendHandlerService.class);
                Intrinsics.checkNotNullExpressionValue(runtimeService3, "app.getRuntimeService(IF\u2026ndlerService::class.java)");
                ((IFriendHandlerService) runtimeService3).requestFriendList(false, a16.a());
                return;
            }
            iFriendDataService.setNtRequestFriendListSeq(a16.a());
        }
    }
}
