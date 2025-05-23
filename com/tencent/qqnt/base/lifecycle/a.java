package com.tencent.qqnt.base.lifecycle;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/a;", "Lyv3/a;", "Lcom/tencent/qqnt/base/lifecycle/data/a;", "a", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a extends yv3.a<com.tencent.qqnt.base.lifecycle.data.a> {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/a$a;", "", "Lcom/tencent/qqnt/base/lifecycle/a;", "b", "Lcom/tencent/qqnt/base/lifecycle/a;", "a", "()Lcom/tencent/qqnt/base/lifecycle/a;", "DEFAULT", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.base.lifecycle.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f353018a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final a DEFAULT;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/base/lifecycle/a$a$a", "Lcom/tencent/qqnt/base/lifecycle/a;", "Lcom/tencent/qqnt/base/lifecycle/data/a;", "a", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.base.lifecycle.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C9513a implements a {
            static IPatchRedirector $redirector_;

            C9513a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // yv3.a
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.tencent.qqnt.base.lifecycle.data.a get() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (com.tencent.qqnt.base.lifecycle.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return new com.tencent.qqnt.base.lifecycle.data.a(0, 0L, 3, null);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39208);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f353018a = new Companion();
                DEFAULT = new C9513a();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return DEFAULT;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39212), (Class<?>) a.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f353018a;
        }
    }
}
