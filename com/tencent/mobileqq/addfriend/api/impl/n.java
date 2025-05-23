package com.tencent.mobileqq.addfriend.api.impl;

import android.os.Looper;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.addfriend.api.a;
import com.tencent.mobileqq.addfriend.handler.NTDelFriendHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.DelBuddyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/impl/n;", "Lcom/tencent/qqnt/remote/c;", "", "callFrom", "Lcom/tencent/qqnt/remote/d;", "toNTMsg", "", "f", "", "result", "errMsg", "toNtMsg", "", "rsp", "", tl.h.F, "b", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/remote/b;", "response", "j", "a", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class n implements com.tencent.qqnt.remote.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/impl/n$a;", "", "", "SERVICE_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.api.impl.n$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean f(String callFrom, final com.tencent.qqnt.remote.d toNTMsg) {
        com.tencent.qqnt.kernel.api.m mVar;
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            mVar = iKernelService.getBuddyService();
        } else {
            mVar = null;
        }
        DelBuddyInfo delBuddyInfo = new DelBuddyInfo();
        delBuddyInfo.friendUid = toNTMsg.a().getString("uid", "");
        delBuddyInfo.tempBothDel = toNTMsg.a().getBoolean(PictureConst.KEY_DEL_TYPE, true);
        delBuddyInfo.tempBlock = toNTMsg.a().getBoolean("not_shield_tmp_session", false);
        if (mVar != null) {
            mVar.delBuddy(delBuddyInfo, new IOperateCallback() { // from class: com.tencent.mobileqq.addfriend.api.impl.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    n.g(n.this, toNTMsg, i3, str);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(n this$0, com.tencent.qqnt.remote.d toNTMsg, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toNTMsg, "$toNTMsg");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.h(i3, errMsg, toNTMsg, null);
    }

    private final void h(final int result, final String errMsg, final com.tencent.qqnt.remote.d toNtMsg, final Object rsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.addfriend.api.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                n.i(com.tencent.qqnt.remote.d.this, result, errMsg, rsp, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(com.tencent.qqnt.remote.d toNtMsg, int i3, String errMsg, Object obj, n this$0) {
        Intrinsics.checkNotNullParameter(toNtMsg, "$toNtMsg");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("DelFriendNTServiceImpl", 2, "handleNTCallback cmd: " + toNtMsg.b() + " result: " + i3 + TokenParser.SP + errMsg);
        }
        com.tencent.qqnt.remote.b bVar = new com.tencent.qqnt.remote.b(i3, errMsg, toNtMsg.c(), toNtMsg.d(), toNtMsg.b());
        bVar.e(obj);
        this$0.j(toNtMsg, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(com.tencent.qqnt.remote.d toNtMsg, n this$0, String callFrom) {
        boolean z16;
        Intrinsics.checkNotNullParameter(toNtMsg, "$toNtMsg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callFrom, "$callFrom");
        String b16 = toNtMsg.b();
        if (QLog.isColorLevel()) {
            QLog.d("DelFriendNTServiceImpl", 2, "sendToNTKernel: " + b16);
        }
        a.Companion companion = com.tencent.mobileqq.addfriend.api.a.INSTANCE;
        if (Intrinsics.areEqual(b16, companion.e())) {
            z16 = this$0.f(callFrom, toNtMsg);
        } else {
            z16 = false;
        }
        if (!z16) {
            this$0.j(toNtMsg, new com.tencent.qqnt.remote.b(companion.h(), companion.i(), toNtMsg.c(), toNtMsg.d(), toNtMsg.b()));
        }
    }

    @Override // com.tencent.qqnt.remote.c
    public void a(@NotNull final String callFrom, @NotNull final com.tencent.qqnt.remote.d toNtMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callFrom, (Object) toNtMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(toNtMsg, "toNtMsg");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.addfriend.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                n.k(com.tencent.qqnt.remote.d.this, this, callFrom);
            }
        };
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.qqnt.remote.c
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "friend.del.service";
    }

    public void j(@NotNull com.tencent.qqnt.remote.d request, @NotNull com.tencent.qqnt.remote.b response) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BusinessHandler businessHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            businessHandler = appInterface.getBusinessHandler(Reflection.getOrCreateKotlinClass(NTDelFriendHandler.class).getQualifiedName());
        }
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.addfriend.handler.NTDelFriendHandler");
        ((NTDelFriendHandler) businessHandler).F2(request, response);
    }
}
