package com.tencent.qqnt.startup.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/startup/task/b;", "", "x4", "a", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: x4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/startup/task/b$a;", "", "<init>", "()V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.startup.task.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f362280a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39010);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f362280a = new Companion();
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
    /* renamed from: com.tencent.qqnt.startup.task.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9701b {
        public static boolean a(@NotNull b bVar) {
            return false;
        }

        public static int b(@NotNull b bVar) {
            return 0;
        }

        public static boolean c(@NotNull b bVar) {
            return false;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39016), (Class<?>) b.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f362280a;
        }
    }
}
