package com.tencent.android.androidbypass.codeblock.span.plugin.center;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.SparseArray;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.codeblock.span.event.b;
import com.tencent.android.androidbypass.config.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u00012\u00020\u00022\u00020\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J:\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/center/a;", "Lcom/tencent/android/androidbypass/codeblock/span/event/b;", "", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/a;", "plugin", "", "f", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetricsInt", "", "width", "", "text", "e", "Landroid/graphics/Canvas;", PM.CANVAS, "", "left", "top", "bottom", "b", "height", "c", "Landroid/graphics/Rect;", "tvVisibleRect", "codeBlockRect", "d", "Lcom/tencent/android/androidbypass/codeblock/span/event/a;", "event", "a", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "plugins", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<com.tencent.android.androidbypass.codeblock.span.plugin.a> plugins;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/center/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.codeblock.span.plugin.center.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.plugins = new SparseArray<>();
        }
    }

    @Override // com.tencent.android.androidbypass.codeblock.span.event.b
    public void a(@NotNull com.tencent.android.androidbypass.codeblock.span.event.a event) {
        String stackTraceToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        SparseArray<com.tencent.android.androidbypass.codeblock.span.plugin.a> sparseArray = this.plugins;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            try {
                sparseArray.valueAt(i3).e(event);
            } catch (Exception e16) {
                g gVar = com.tencent.android.androidbypass.config.a.f72049a;
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                gVar.e("PluginRegistry", stackTraceToString);
            }
        }
    }

    public void b(@NotNull Canvas canvas, float left, int width, int top, int bottom, @Nullable CharSequence text) {
        String stackTraceToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, canvas, Float.valueOf(left), Integer.valueOf(width), Integer.valueOf(top), Integer.valueOf(bottom), text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        SparseArray<com.tencent.android.androidbypass.codeblock.span.plugin.a> sparseArray = this.plugins;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            try {
                sparseArray.valueAt(i3).d(canvas, left, width, top, bottom, text);
            } catch (Exception e16) {
                g gVar = com.tencent.android.androidbypass.config.a.f72049a;
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                gVar.e("PluginRegistry", stackTraceToString);
            }
        }
    }

    public void c(@NotNull Canvas canvas, int width, int height, @Nullable CharSequence text) {
        String stackTraceToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, Integer.valueOf(width), Integer.valueOf(height), text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        SparseArray<com.tencent.android.androidbypass.codeblock.span.plugin.a> sparseArray = this.plugins;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            try {
                sparseArray.valueAt(i3).c(canvas, width, height, text);
            } catch (Exception e16) {
                g gVar = com.tencent.android.androidbypass.config.a.f72049a;
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                gVar.e("PluginRegistry", stackTraceToString);
            }
        }
    }

    public void d(@NotNull Canvas canvas, @NotNull Rect tvVisibleRect, @NotNull Rect codeBlockRect, @Nullable CharSequence text) {
        String stackTraceToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, canvas, tvVisibleRect, codeBlockRect, text);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(tvVisibleRect, "tvVisibleRect");
        Intrinsics.checkNotNullParameter(codeBlockRect, "codeBlockRect");
        SparseArray<com.tencent.android.androidbypass.codeblock.span.plugin.a> sparseArray = this.plugins;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            try {
                sparseArray.valueAt(i3).b(canvas, tvVisibleRect, codeBlockRect, text);
            } catch (Exception e16) {
                g gVar = com.tencent.android.androidbypass.config.a.f72049a;
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                gVar.e("PluginRegistry", stackTraceToString);
            }
        }
    }

    public void e(@NotNull Paint.FontMetricsInt fontMetricsInt, int width, @Nullable CharSequence text) {
        String stackTraceToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fontMetricsInt, Integer.valueOf(width), text);
            return;
        }
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        SparseArray<com.tencent.android.androidbypass.codeblock.span.plugin.a> sparseArray = this.plugins;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            try {
                sparseArray.valueAt(i3).a(fontMetricsInt, width, text);
            } catch (Exception e16) {
                g gVar = com.tencent.android.androidbypass.config.a.f72049a;
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                gVar.e("PluginRegistry", stackTraceToString);
            }
        }
    }

    public void f(@NotNull com.tencent.android.androidbypass.codeblock.span.plugin.a plugin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) plugin);
            return;
        }
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        if (this.plugins.get(plugin.w()) == null) {
            this.plugins.put(plugin.w(), plugin);
            return;
        }
        throw new RuntimeException("register plugin exist! id = " + plugin.w());
    }
}
