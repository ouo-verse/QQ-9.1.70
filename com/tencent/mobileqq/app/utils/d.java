package com.tencent.mobileqq.app.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0015\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/app/utils/d;", "Landroid/content/res/Resources;", "Landroid/util/TypedValue;", "c", "value", "", "d", "", "b", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "a", "e", "", "id", "getDimension", "getDimensionPixelSize", "getDimensionPixelOffset", "Landroid/content/res/Resources;", "getBase", "()Landroid/content/res/Resources;", PM.BASE, "Landroid/util/DisplayMetrics;", "displayMetrics", "", "Ljava/lang/Object;", "mTmpValueLock", "Landroid/util/TypedValue;", "mTmpValue", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends Resources {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Resources base;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DisplayMetrics displayMetrics;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mTmpValueLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TypedValue mTmpValue;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/utils/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.utils.d$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37311);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    private final float b() {
        return getDisplayMetrics().density / super.getDisplayMetrics().density;
    }

    private final TypedValue c() {
        TypedValue typedValue;
        synchronized (this.mTmpValueLock) {
            typedValue = this.mTmpValue;
            if (typedValue != null) {
                this.mTmpValue = null;
            } else {
                typedValue = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (typedValue != null) {
            return typedValue;
        }
        return new TypedValue();
    }

    private final void d(TypedValue value) {
        synchronized (this.mTmpValueLock) {
            if (this.mTmpValue == null) {
                this.mTmpValue = value;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.base.getDisplayMetrics().setTo(this.displayMetrics);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        updateConfiguration(this.base.getConfiguration(), this.base.getDisplayMetrics());
        DisplayMetrics displayMetrics = this.displayMetrics;
        if (displayMetrics != null) {
            displayMetrics.setTo(this.base.getDisplayMetrics());
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this, id5)).floatValue();
        }
        TypedValue c16 = c();
        try {
            getValue(id5, c16, true);
            if (c16.type == 5) {
                return TypedValue.complexToDimension(c16.data, getDisplayMetrics());
            }
            throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id5) + " type #0x" + Integer.toHexString(c16.type) + " is not valid");
        } catch (Throwable unused) {
            return super.getDimension(id5) * b();
        } finally {
            d(c16);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, id5)).intValue();
        }
        TypedValue c16 = c();
        try {
            getValue(id5, c16, true);
            if (c16.type == 5) {
                return TypedValue.complexToDimensionPixelOffset(c16.data, getDisplayMetrics());
            }
            throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id5) + " type #0x" + Integer.toHexString(c16.type) + " is not valid");
        } catch (Throwable unused) {
            return (int) (super.getDimensionPixelOffset(id5) * b());
        } finally {
            d(c16);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int id5) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, id5)).intValue();
        }
        TypedValue c16 = c();
        try {
            getValue(id5, c16, true);
            if (c16.type == 5) {
                return TypedValue.complexToDimensionPixelSize(c16.data, getDisplayMetrics());
            }
            throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(id5) + " type #0x" + Integer.toHexString(c16.type) + " is not valid");
        } catch (Throwable unused) {
            float dimensionPixelSize = super.getDimensionPixelSize(id5) * b();
            if (dimensionPixelSize >= 0.0f) {
                f16 = dimensionPixelSize + 0.5f;
            } else {
                f16 = dimensionPixelSize - 0.5f;
            }
            return (int) f16;
        } finally {
            d(c16);
        }
    }

    @Override // android.content.res.Resources
    @NotNull
    public DisplayMetrics getDisplayMetrics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DisplayMetrics) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        DisplayMetrics displayMetrics = this.base.getDisplayMetrics();
        if (this.displayMetrics == null) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(displayMetrics);
            this.displayMetrics = displayMetrics2;
        }
        DisplayMetrics displayMetrics3 = this.displayMetrics;
        Intrinsics.checkNotNull(displayMetrics3);
        displayMetrics3.widthPixels = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics4 = this.displayMetrics;
        Intrinsics.checkNotNull(displayMetrics4);
        displayMetrics4.heightPixels = displayMetrics.heightPixels;
        DisplayMetrics displayMetrics5 = this.displayMetrics;
        Intrinsics.checkNotNull(displayMetrics5);
        return displayMetrics5;
    }
}
