package com.tencent.mobileqq.aio.input;

import android.graphics.Typeface;
import android.widget.EditText;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/input/g;", "", "Ljava/lang/ref/WeakReference;", "Landroid/widget/EditText;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "inputRef", "Landroid/graphics/Typeface;", "d", "()Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "", "c", "()Ljava/lang/Float;", "textSize", "", "b", "()Ljava/lang/Integer;", NodeProps.PADDING_LEFT, "measuredWidth", "input", "<init>", "(Landroid/widget/EditText;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<EditText> inputRef;

    public g(@NotNull EditText input) {
        Intrinsics.checkNotNullParameter(input, "input");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) input);
        } else {
            this.inputRef = new WeakReference<>(input);
        }
    }

    @Nullable
    public final Integer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Integer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        EditText editText = this.inputRef.get();
        if (editText != null) {
            return Integer.valueOf(editText.getMeasuredWidth());
        }
        return null;
    }

    @Nullable
    public final Integer b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        EditText editText = this.inputRef.get();
        if (editText != null) {
            return Integer.valueOf(editText.getPaddingLeft());
        }
        return null;
    }

    @Nullable
    public final Float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Float) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        EditText editText = this.inputRef.get();
        if (editText != null) {
            return Float.valueOf(editText.getTextSize());
        }
        return null;
    }

    @Nullable
    public final Typeface d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Typeface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        EditText editText = this.inputRef.get();
        if (editText != null) {
            return editText.getTypeface();
        }
        return null;
    }
}
