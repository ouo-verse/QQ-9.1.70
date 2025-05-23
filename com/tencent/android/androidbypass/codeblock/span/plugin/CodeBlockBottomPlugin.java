package com.tencent.android.androidbypass.codeblock.span.plugin;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.codeblock.span.event.c;
import com.tencent.android.androidbypass.codeblock.span.plugin.a;
import com.tencent.android.androidbypass.codeblock.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u00100\u001a\u00020.\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J(\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\"\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J:\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J*\u0010 \u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J*\u0010#\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010&R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010&R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/CodeBlockBottomPlugin;", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/a;", "", "g", "", "top", "left", "right", "Landroid/graphics/Rect;", "f", "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/android/androidbypass/codeblock/config/bottom/b;", "bottomConfig", "dividerRect", "", h.F, "i", "w", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetricsInt", "width", "", "text", "a", "Lcom/tencent/android/androidbypass/codeblock/span/event/a;", "event", "e", "", "bottom", "d", "height", "c", "tvVisibleRect", "codeBlockRect", "b", "Z", "isShowAllCode", "I", "bottomAreaVerticalOffset", "bottomAreaHeight", "Landroid/graphics/Paint;", "Lkotlin/Lazy;", "j", "()Landroid/graphics/Paint;", "bottomPaint", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "pluginContext", "<init>", "(Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CodeBlockBottomPlugin implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isShowAllCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int bottomAreaVerticalOffset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int bottomAreaHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy bottomPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b pluginContext;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/CodeBlockBottomPlugin$a;", "", "", "DIVIDER_HEIGHT_DP", UserInfo.SEX_FEMALE, "DIVIDER_PADDING_TOP_DP", "FONT_PADDING_TOP_DP", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.codeblock.span.plugin.CodeBlockBottomPlugin$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CodeBlockBottomPlugin(@NotNull b pluginContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(pluginContext, "pluginContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pluginContext);
            return;
        }
        this.pluginContext = pluginContext;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) CodeBlockBottomPlugin$bottomPaint$2.INSTANCE);
        this.bottomPaint = lazy;
    }

    private final Rect f(int top, int left, int right) {
        e eVar = e.f72044a;
        int b16 = top + this.bottomAreaVerticalOffset + ((int) eVar.b(this.pluginContext.b(), 6.0f));
        return new Rect(left, b16, right, ((int) eVar.b(this.pluginContext.b(), 1.0f)) + b16);
    }

    private final boolean g() {
        return !this.isShowAllCode;
    }

    private final void h(Canvas canvas, com.tencent.android.androidbypass.codeblock.config.bottom.b bottomConfig, Rect dividerRect) {
        j().setColor(bottomConfig.getDividerColor());
        canvas.drawRect(dividerRect, j());
    }

    private final void i(Canvas canvas, com.tencent.android.androidbypass.codeblock.config.bottom.b bottomConfig, int top, int left) {
        float b16 = top + e.f72044a.b(this.pluginContext.b(), 4.0f) + Math.abs(j().getFontMetricsInt().top);
        String text = bottomConfig.getText();
        j().setColor(bottomConfig.b());
        canvas.drawText(text, 0, text.length(), left, b16, j());
    }

    private final Paint j() {
        return (Paint) this.bottomPaint.getValue();
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void a(@NotNull Paint.FontMetricsInt fontMetricsInt, int width, @Nullable CharSequence text) {
        com.tencent.android.androidbypass.codeblock.config.bottom.b a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fontMetricsInt, Integer.valueOf(width), text);
            return;
        }
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        if (g() && (a16 = this.pluginContext.a().a()) != null) {
            Paint j3 = j();
            j3.setTextSize(a16.a());
            j3.setTypeface(a16.c());
            Paint.FontMetricsInt fontMetricsInt2 = j().getFontMetricsInt();
            int b16 = (fontMetricsInt2.bottom - fontMetricsInt2.top) + ((int) e.f72044a.b(this.pluginContext.b(), 11.0f));
            this.bottomAreaHeight = b16;
            int i3 = fontMetricsInt.bottom;
            this.bottomAreaVerticalOffset = i3;
            int i16 = i3 + b16;
            fontMetricsInt.bottom = i16;
            fontMetricsInt.descent = i16;
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void b(@NotNull Canvas canvas, @NotNull Rect tvVisibleRect, @NotNull Rect codeBlockRect, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, tvVisibleRect, codeBlockRect, text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(tvVisibleRect, "tvVisibleRect");
        Intrinsics.checkNotNullParameter(codeBlockRect, "codeBlockRect");
        int i3 = codeBlockRect.top + this.bottomAreaVerticalOffset;
        int i16 = i3 + this.bottomAreaHeight;
        if (tvVisibleRect.bottom <= i3 && tvVisibleRect.top <= i16) {
            d(canvas, 0.0f, codeBlockRect.width(), i3, i16, text);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void c(@NotNull Canvas canvas, int width, int height, @Nullable CharSequence text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, Integer.valueOf(width), Integer.valueOf(height), text);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            d(canvas, 0.0f, width, 0, height, text);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void d(@NotNull Canvas canvas, float left, int width, int top, int bottom, @Nullable CharSequence text) {
        com.tencent.android.androidbypass.codeblock.config.bottom.b a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, Float.valueOf(left), Integer.valueOf(width), Integer.valueOf(top), Integer.valueOf(bottom), text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (g() && (a16 = this.pluginContext.a().a()) != null) {
            Rect d16 = this.pluginContext.a().getGlobalConfig().d();
            int i3 = (int) (d16.left + left);
            Rect f16 = f(top, i3, (int) ((width - d16.right) - left));
            h(canvas, a16, f16);
            i(canvas, a16, f16.bottom, i3);
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public void e(@NotNull com.tencent.android.androidbypass.codeblock.span.event.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        a.C0712a.a(this, event);
        if (event instanceof c.a) {
            this.isShowAllCode = ((c.a) event).a();
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.plugin.a
    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return 3;
    }
}
