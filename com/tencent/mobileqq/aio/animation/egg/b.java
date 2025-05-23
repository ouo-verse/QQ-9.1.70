package com.tencent.mobileqq.aio.animation.egg;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/egg/b;", "", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "", "w", h.F, "", "a", "width", "height", "scaleType", "b", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f188090a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29798);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f188090a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int[] a(AIOAnimationContainer container, int w3, int h16) {
        int width = container.getWidth();
        int height = container.getHeight();
        float f16 = w3 / h16;
        if (f16 > width / height) {
            height = (int) (width / f16);
        } else {
            width = (int) (height * f16);
        }
        return new int[]{width, height};
    }

    @NotNull
    public final int[] b(@NotNull AIOAnimationContainer container, int width, int height, int scaleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, this, container, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(scaleType));
        }
        Intrinsics.checkNotNullParameter(container, "container");
        if (width != 0 && height != 0) {
            if (scaleType != 0) {
                if (scaleType != 1) {
                    if (scaleType != 2) {
                        if (scaleType != 3) {
                            return new int[]{width, height};
                        }
                        int height2 = (container.getHeight() - container.getPaddingTop()) - container.getPaddingBottom();
                        return new int[]{(int) ((width * height2) / height), height2};
                    }
                    int width2 = (container.getWidth() - container.getPaddingLeft()) - container.getPaddingRight();
                    return new int[]{width2, (int) ((height * width2) / width)};
                }
                return a(container, width, height);
            }
            return new int[]{width, height};
        }
        return new int[]{width, height};
    }
}
