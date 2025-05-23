package com.tencent.mobileqq.multishare.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J \u0010\f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/multishare/util/e;", "", "Landroid/graphics/drawable/Drawable;", "normalDrawable", "pressedDrawable", "Landroid/graphics/drawable/StateListDrawable;", "c", "srcDrawable", "b", "", "insetLeftRight", "insetTopBottom", "a", "Landroid/graphics/drawable/Drawable;", "iconBg", "iconMaskForPressedState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable iconBg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable iconMaskForPressedState;

    public e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.iconBg = ResourcesCompat.getDrawable(context.getResources(), R.drawable.k1i, null);
            this.iconMaskForPressedState = ResourcesCompat.getDrawable(context.getResources(), R.drawable.j2e, null);
        }
    }

    @NotNull
    public final Drawable a(@Nullable Drawable srcDrawable, int insetLeftRight, int insetTopBottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, this, srcDrawable, Integer.valueOf(insetLeftRight), Integer.valueOf(insetTopBottom));
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.iconBg, srcDrawable});
        layerDrawable.setLayerInset(1, insetLeftRight, insetTopBottom, insetLeftRight, insetTopBottom);
        return layerDrawable;
    }

    @NotNull
    public final Drawable b(@NotNull Drawable srcDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) srcDrawable);
        }
        Intrinsics.checkNotNullParameter(srcDrawable, "srcDrawable");
        return new LayerDrawable(new Drawable[]{srcDrawable, this.iconMaskForPressedState});
    }

    @NotNull
    public final StateListDrawable c(@Nullable Drawable normalDrawable, @Nullable Drawable pressedDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StateListDrawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) normalDrawable, (Object) pressedDrawable);
        }
        int[] iArr = {android.R.attr.state_pressed};
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(iArr, pressedDrawable);
        stateListDrawable.addState(new int[0], normalDrawable);
        return stateListDrawable;
    }
}
