package com.tencent.mobileqq.aio.input.at.common;

import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u0013*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0013J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J0\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000b0\f0\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/a;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "", "", "d", "b", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "dialogContext", "Lcom/tencent/mobileqq/aio/input/at/common/b;", "delegateListener", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/base/b;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", tl.h.F, "", "g", "e", "f", "a", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface a<T extends c> {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/a$a;", "", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.common.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f189261a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53350);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f189261a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class b {
        public static <T extends c> int a(@NotNull a<T> aVar) {
            return com.tencent.qqnt.util.view.b.f362999a.b(0);
        }

        public static <T extends c> int b(@NotNull a<T> aVar) {
            return 0;
        }

        public static <T extends c> int c(@NotNull a<T> aVar) {
            return 600;
        }

        public static <T extends c> int d(@NotNull a<T> aVar) {
            return com.tencent.qqnt.util.view.b.f362999a.b(60);
        }

        public static <T extends c> boolean e(@NotNull a<T> aVar) {
            return false;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(53355), (Class<?>) a.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f189261a;
        }
    }

    int a();

    int b();

    int c();

    int d();

    int e();

    int f();

    boolean g();

    @NotNull
    List<com.tencent.mobileqq.aio.input.at.common.list.base.b<List<com.tencent.mobileqq.aio.input.at.common.list.data.b>>> h(@NotNull j<T> dialogContext, @NotNull com.tencent.mobileqq.aio.input.at.common.b delegateListener);
}
