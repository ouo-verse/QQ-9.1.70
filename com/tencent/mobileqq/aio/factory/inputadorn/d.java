package com.tencent.mobileqq.aio.factory.inputadorn;

import android.content.Context;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.bottombar.GroupAIOBottomBarVB;
import com.tencent.mobileqq.aio.factory.inputadorn.c;
import com.tencent.mobileqq.aio.input.adorn.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.robot.api.IAIORobotApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J<\u0010\u0010\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0012\u0006\b\u0000\u0012\u00020\u00020\fj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\u000f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J2\u0010\u0015\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0012j\u0002`\u00140\u000b2\u0006\u0010\n\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/inputadorn/d;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "", h.F, "g", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "c", "Lcom/tencent/aio/base/mvvm/a;", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d implements com.tencent.mobileqq.aio.input.adorn.a<com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/inputadorn/d$a;", "", "", "KEY_INTERCEPT_AT_ROBOT_SEND_MSG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.factory.inputadorn.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean g() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("group_at_robot_intercept_9110_132947055", true);
    }

    private final boolean h() {
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode() && ((IAIORobotApi) QRoute.api(IAIORobotApi.class)).isInterceptAtRobotSendMsgEnable()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new GroupAIOBottomBarVB();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> c(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
        List plus;
        List plus2;
        List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> plus3;
        com.tencent.qqnt.aio.interceptor.sendmsg.b bVar;
        com.tencent.qqnt.aio.interceptor.sendmsg.b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        c.C7245c c7245c = c.C7245c.f188794a;
        plus = CollectionsKt___CollectionsKt.plus((Collection) c7245c.b(host), (Iterable) c7245c.f(host));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) c7245c.e(host));
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) plus2, (Iterable) c7245c.a(host));
        if (g() && h()) {
            Iterator it = plus3.iterator();
            while (true) {
                bVar = null;
                if (it.hasNext()) {
                    bVar2 = it.next();
                    if (((com.tencent.input.base.mvicompat.e) bVar2) instanceof com.tencent.qqnt.aio.interceptor.sendmsg.b) {
                        break;
                    }
                } else {
                    bVar2 = 0;
                    break;
                }
            }
            if (bVar2 instanceof com.tencent.qqnt.aio.interceptor.sendmsg.b) {
                bVar = bVar2;
            }
            if (bVar != null) {
                bVar.a(((IAIORobotApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIORobotApi.class)).createAIOSendMsgInterceptor());
            }
        }
        return plus3;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return a.C7250a.b(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> e(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
        List plus;
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> plus2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        c.b bVar = c.b.f188793a;
        plus = CollectionsKt___CollectionsKt.plus((Collection) bVar.a(host), (Iterable) bVar.e(host));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) bVar.d(host));
        return plus2;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.inputbar.viewbinding.a b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.inputbar.viewbinding.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return c.INSTANCE.a(context);
    }
}
