package com.tencent.android.androidbypass.custom;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.custom.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R.\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/android/androidbypass/custom/c;", "Lcom/tencent/android/androidbypass/custom/f;", "", "widthSpec", "heightSpec", "", "measure", "", "changed", "left", "top", "right", "bottom", "j", "Landroid/graphics/Canvas;", PM.CANVAS, "a", "Landroid/graphics/drawable/Drawable;", "value", "i", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/graphics/drawable/Drawable;)V", "drawable", "", "id", "<init>", "(Ljava/lang/String;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable drawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String id5) {
        super(id5);
        Intrinsics.checkNotNullParameter(id5, "id");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) id5);
        }
    }

    @Override // com.tencent.android.androidbypass.custom.f
    public void a(@NotNull Canvas canvas) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (h() && (drawable = this.drawable) != null) {
            drawable.setBounds(b());
            drawable.draw(canvas);
        }
    }

    @Override // com.tencent.android.androidbypass.custom.f
    public void j(boolean changed, int left, int top, int right, int bottom) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        super.j(changed, left, top, right, bottom);
        if (h() && (drawable = this.drawable) != null) {
            drawable.setBounds(left, top, right, bottom);
        }
    }

    @Override // com.tencent.android.androidbypass.custom.d
    public void measure(int widthSpec, int heightSpec) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(widthSpec), Integer.valueOf(heightSpec));
            return;
        }
        f.Companion companion = f.INSTANCE;
        Drawable drawable = this.drawable;
        if (drawable != null) {
            i3 = drawable.getMinimumWidth();
        } else {
            i3 = 0;
        }
        r(companion.a(i3, widthSpec));
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            i16 = drawable2.getMinimumHeight();
        } else {
            i16 = 0;
        }
        q(companion.a(i16, heightSpec));
        if (e() <= 0 || f() <= 0) {
            z16 = false;
        }
        p(z16);
    }

    public final void s(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
        } else if (!Intrinsics.areEqual(this.drawable, drawable)) {
            this.drawable = drawable;
            g();
        }
    }
}
