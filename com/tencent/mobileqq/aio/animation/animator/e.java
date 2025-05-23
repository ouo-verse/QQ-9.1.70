package com.tencent.mobileqq.aio.animation.animator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/e;", "", "", "b", "[F", "a", "()[F", "BOUNCE_ANIM_ARRAY", "c", "BOUNCE_SCALE_ARRAY", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f187854a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final float[] BOUNCE_ANIM_ARRAY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final float[] BOUNCE_SCALE_ARRAY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f187854a = new e();
        BOUNCE_ANIM_ARRAY = new float[]{0.0f, 3.82f, 7.28f, 10.38f, 13.12f, 15.499998f, 17.52f, 19.18f, 20.48f, 21.420002f, 21.999998f, 22.22f, 22.08f, 21.580004f, 20.720001f, 19.500004f, 17.920002f, 15.98f, 13.680004f, 11.020004f, 8.0f, 4.6200027f, 0.87999725f, 0.0f, 0.0f, 1.5679998f, 2.8479996f, 3.8399992f, 4.543999f, 4.959999f, 5.0879984f, 4.927998f, 4.4799986f, 3.7439995f, 2.7199993f, 1.407999f, 0.0f, 0.0f, 0.5824001f, 0.9344002f, 1.0560002f, 0.9472004f, 0.60800076f, 0.03840065f, 0.0f};
        BOUNCE_SCALE_ARRAY = new float[]{1.05f, 1.05f, 1.05f, 1.05f, 1.05f, 1.05f, 1.0419999f, 1.0239999f, 1.006f, 0.988f, 0.97f, 0.95199996f, 0.96599996f, 0.98399997f, 1.002f, 1.02f, 1.038f, 1.05f, 1.05f, 1.05f, 1.05f, 1.05f, 1.05f, 1.05f, 1.0356f, 1.0212f, 1.0067999f, 0.9924f, 0.978f, 0.9636f, 0.9508f, 0.9652f, 0.9796f, 0.99399996f, 1.0084f, 1.0228f, 1.0436f, 0.98488f, 0.97336f, 0.96184f, 0.95032f, 0.9612f, 0.97271997f, 0.98424f, 1.02288f};
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final float[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (float[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return BOUNCE_ANIM_ARRAY;
    }

    @NotNull
    public final float[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (float[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return BOUNCE_SCALE_ARRAY;
    }
}
