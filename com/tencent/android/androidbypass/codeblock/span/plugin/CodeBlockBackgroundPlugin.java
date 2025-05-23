package com.tencent.android.androidbypass.codeblock.span.plugin;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.codeblock.span.plugin.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/CodeBlockBackgroundPlugin;", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/a;", "", "w", "Landroid/graphics/Canvas;", PM.CANVAS, "", "left", "width", "top", "bottom", "", "text", "", "d", "height", "c", "Landroid/graphics/Rect;", "tvVisibleRect", "codeBlockRect", "b", "Landroid/graphics/Paint;", "a", "Lkotlin/Lazy;", "f", "()Landroid/graphics/Paint;", "backgroundPaint", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "pluginContext", "<init>", "(Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CodeBlockBackgroundPlugin implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy backgroundPaint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b pluginContext;

    public CodeBlockBackgroundPlugin(@NotNull b pluginContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(pluginContext, "pluginContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pluginContext);
            return;
        }
        this.pluginContext = pluginContext;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) CodeBlockBackgroundPlugin$backgroundPaint$2.INSTANCE);
        this.backgroundPaint = lazy;
    }

    private final Paint f() {
        return (Paint) this.backgroundPaint.getValue();
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void a(@NotNull Paint.FontMetricsInt fontMetricsInt, int i3, @Nullable CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, fontMetricsInt, Integer.valueOf(i3), charSequence);
        } else {
            Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
            a.C0712a.b(this, fontMetricsInt, i3, charSequence);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void b(@NotNull Canvas canvas, @NotNull Rect tvVisibleRect, @NotNull Rect codeBlockRect, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, tvVisibleRect, codeBlockRect, text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(tvVisibleRect, "tvVisibleRect");
        Intrinsics.checkNotNullParameter(codeBlockRect, "codeBlockRect");
        d(canvas, 0.0f, codeBlockRect.width(), codeBlockRect.top, codeBlockRect.bottom, text);
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void c(@NotNull Canvas canvas, int width, int height, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, canvas, Integer.valueOf(width), Integer.valueOf(height), text);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            d(canvas, 0.0f, width, 0, height, text);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void d(@NotNull Canvas canvas, float left, int width, int top, int bottom, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, Float.valueOf(left), Integer.valueOf(width), Integer.valueOf(top), Integer.valueOf(bottom), text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        com.tencent.android.androidbypass.codeblock.config.background.b c16 = this.pluginContext.a().c();
        if (c16 != null) {
            float a16 = c16.a();
            RectF rectF = new RectF(left, top, width + left, bottom);
            f().setColor(c16.getBackgroundColor());
            canvas.drawRoundRect(rectF, a16, a16, f());
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void e(@NotNull com.tencent.android.androidbypass.codeblock.span.event.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            a.C0712a.a(this, event);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return 1;
        }
        return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
    }
}
