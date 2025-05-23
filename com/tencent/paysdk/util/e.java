package com.tencent.paysdk.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.util.ListenerMgr;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/paysdk/util/e;", "", "Lmq3/a;", "iAuthSdkLogin", "", "b", "c", "", "isInternalLogin", "a", "Lcom/tencent/paysdk/util/ListenerMgr;", "Lcom/tencent/paysdk/util/ListenerMgr;", "sListenerMgr", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ListenerMgr<mq3.a> sListenerMgr;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final e f342089b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lmq3/a;", "kotlin.jvm.PlatformType", "loginCallback", "", "a", "(Lmq3/a;)V"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class a<T> implements ListenerMgr.a<mq3.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f342090a;

        a(boolean z16) {
            this.f342090a = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }

        @Override // com.tencent.paysdk.util.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onNotify(mq3.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else if (aVar != null) {
                aVar.h(this.f342090a);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f342089b = new e();
            sListenerMgr = new ListenerMgr<>();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(@NotNull mq3.a iAuthSdkLogin) {
        Intrinsics.checkNotNullParameter(iAuthSdkLogin, "iAuthSdkLogin");
        sListenerMgr.a(iAuthSdkLogin);
    }

    @JvmStatic
    public static final void c(@NotNull mq3.a iAuthSdkLogin) {
        Intrinsics.checkNotNullParameter(iAuthSdkLogin, "iAuthSdkLogin");
        sListenerMgr.c(iAuthSdkLogin);
    }

    public final void a(boolean isInternalLogin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, isInternalLogin);
        } else {
            sListenerMgr.b(new a(isInternalLogin));
        }
    }
}
