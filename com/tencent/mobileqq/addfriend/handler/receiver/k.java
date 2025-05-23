package com.tencent.mobileqq.addfriend.handler.receiver;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/k;", "Lcom/tencent/mobileqq/addfriend/handler/receiver/a;", "Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;", "Lcom/tencent/qqnt/remote/d;", "req", "Lcom/tencent/qqnt/remote/b;", "res", "", "e", "", "b", "toNTMsg", "fromNTMsg", "d", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;)V", "c", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class k extends a<NTAddFriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.handler.receiver.k$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21953);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull AppInterface appRuntime, @NotNull NTAddFriendHandler handler) {
        super(appRuntime, handler);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        }
    }

    private final void e(com.tencent.qqnt.remote.d req, com.tencent.qqnt.remote.b res) {
        Integer num;
        Object a16 = res.a();
        if (a16 instanceof Integer) {
            num = (Integer) a16;
        } else {
            num = null;
        }
        if (num == null) {
            QLog.d("NTQueryUinFlagReceiver", 1, "handleQueryUinSafetyFlag null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("uin", req.a().getLong("uin"));
        if (res.b() != com.tencent.mobileqq.addfriend.api.a.INSTANCE.j()) {
            NTAddFriendHandler c16 = c();
            if (c16 != null) {
                c16.notifyUI(7, false, bundle);
                return;
            }
            return;
        }
        try {
            bundle.putInt(FriendListHandler.KEY_SAFETY_FLAG, num.intValue());
            NTAddFriendHandler c17 = c();
            if (c17 != null) {
                c17.notifyUI(7, true, bundle);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("NTQueryUinFlagReceiver", 2, "handle_oidb_0x476 error:" + e16.getMessage());
            }
            NTAddFriendHandler c18 = c();
            if (c18 != null) {
                c18.notifyUI(7, false, bundle);
            }
        }
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.api.a.INSTANCE.c();
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    public void d(@NotNull com.tencent.qqnt.remote.d toNTMsg, @NotNull com.tencent.qqnt.remote.b fromNTMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toNTMsg, (Object) fromNTMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(toNTMsg, "toNTMsg");
        Intrinsics.checkNotNullParameter(fromNTMsg, "fromNTMsg");
        e(toNTMsg, fromNTMsg);
    }
}
