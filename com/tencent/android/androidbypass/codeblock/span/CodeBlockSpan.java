package com.tencent.android.androidbypass.codeblock.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001JB\u000f\u0012\u0006\u0010B\u001a\u00020?\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J2\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J2\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\u001c\u001a\u00020\u001bJ4\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016JR\u0010#\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0016\u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eJ\u0006\u0010(\u001a\u00020\fR\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010-R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010/R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010/R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001b\u00109\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001d\u0010F\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0C8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/CodeBlockSpan;", "Landroid/text/style/ReplacementSpan;", "", "l", "k", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "text", "o", "effectiveWidth", "effectiveHeight", "", "d", "", HippyTKDListViewAdapter.X, "top", "bottom", "r", "Landroid/graphics/Canvas;", PM.CANVAS, h.F, "f", "width", "height", "e", "g", "Lcom/tencent/android/androidbypass/codeblock/span/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint;", "paint", "start", "end", "getSize", "y", "draw", "posX", "posY", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "codeBlockBitmap", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "codeBlockBitmapJob", "I", "codeBlockWidth", "codeBlockHeight", "Landroid/graphics/Rect;", "i", "Landroid/graphics/Rect;", "codeBlockDrawRect", "Lkotlin/Lazy;", "j", "()Landroid/graphics/Paint;", "bitmapPaint", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/center/a;", BdhLogUtil.LogTag.Tag_Conn, DomainData.DOMAIN_NAME, "()Lcom/tencent/android/androidbypass/codeblock/span/plugin/center/a;", "pluginCenter", "Lcom/tencent/android/androidbypass/codeblock/span/c;", "D", "Lcom/tencent/android/androidbypass/codeblock/span/c;", "spanInfo", "", "", "()Ljava/util/Map;", "attr", "<init>", "(Lcom/tencent/android/androidbypass/codeblock/span/c;)V", "E", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class CodeBlockSpan extends ReplacementSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy pluginCenter;

    /* renamed from: D, reason: from kotlin metadata */
    private final c spanInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bitmap codeBlockBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Job codeBlockBitmapJob;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int codeBlockWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int codeBlockHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Rect codeBlockDrawRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy bitmapPaint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/CodeBlockSpan$a;", "", "", "BOTTOM_LINE_SPACING_DEFAULT", UserInfo.SEX_FEMALE, "BOTTOM_SPACE_CONTENT_DP", "BOTTOM_SPACE_END_DP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CodeBlockSpan(@NotNull c spanInfo) {
        Intrinsics.checkNotNullParameter(spanInfo, "spanInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) spanInfo);
            return;
        }
        this.spanInfo = spanInfo;
        this.codeBlockDrawRect = new Rect();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.bitmapPaint = LazyKt.lazy(lazyThreadSafetyMode, (Function0) CodeBlockSpan$bitmapPaint$2.INSTANCE);
        this.pluginCenter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.android.androidbypass.codeblock.span.plugin.center.a>() { // from class: com.tencent.android.androidbypass.codeblock.span.CodeBlockSpan$pluginCenter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) CodeBlockSpan.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.android.androidbypass.codeblock.span.plugin.center.a invoke() {
                c cVar;
                Context context;
                c cVar2;
                c cVar3;
                List listOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (com.tencent.android.androidbypass.codeblock.span.plugin.center.a) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                com.tencent.android.androidbypass.codeblock.span.plugin.center.a aVar = new com.tencent.android.androidbypass.codeblock.span.plugin.center.a();
                cVar = CodeBlockSpan.this.spanInfo;
                TextView textView = cVar.e().get();
                if (textView != null && (context = textView.getContext()) != null) {
                    cVar2 = CodeBlockSpan.this.spanInfo;
                    b c16 = cVar2.c();
                    cVar3 = CodeBlockSpan.this.spanInfo;
                    com.tencent.android.androidbypass.codeblock.span.plugin.b bVar = new com.tencent.android.androidbypass.codeblock.span.plugin.b(context, c16, cVar3.a(), new com.tencent.android.androidbypass.codeblock.span.event.d(aVar));
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3});
                    Iterator it = listOf.iterator();
                    while (it.hasNext()) {
                        aVar.f(com.tencent.android.androidbypass.codeblock.span.plugin.factory.a.f72030a.a(((Number) it.next()).intValue(), bVar));
                    }
                }
                return aVar;
            }
        });
    }

    private final void d(int effectiveWidth, int effectiveHeight) {
        if (effectiveWidth != this.codeBlockWidth || effectiveHeight != this.codeBlockHeight) {
            Job job = this.codeBlockBitmapJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.codeBlockBitmapJob = null;
            Bitmap bitmap = this.codeBlockBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.codeBlockBitmap = null;
            this.codeBlockWidth = effectiveWidth;
            this.codeBlockHeight = effectiveHeight;
        }
    }

    private final void e(int width, int height, CharSequence text) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (this.codeBlockBitmapJob == null && width > 0 && height > 0 && (lifecycleOwner = this.spanInfo.b().get()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            this.codeBlockBitmapJob = BuildersKt.launch$default(lifecycleScope, Dispatchers.getIO(), null, new CodeBlockSpan$createCodeBlockBitmapAsync$1(this, width, height, text, null), 2, null);
        }
    }

    private final void f(Canvas canvas, float x16, int top, int bottom, CharSequence text) {
        if (this.spanInfo.a().getGlobalConfig().a()) {
            int length = this.spanInfo.d().length();
            if (text != null && length == text.length()) {
                Bitmap bitmap = this.codeBlockBitmap;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, x16, top, j());
                    return;
                } else {
                    e(this.codeBlockWidth, (bottom - l()) - top, text);
                }
            }
        }
        n().b(canvas, x16, this.codeBlockWidth, top, bottom - l(), text);
    }

    private final void g(Canvas canvas, CharSequence text) {
        TextView textView = this.spanInfo.e().get();
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(textView, "spanInfo.tvRef.get() ?: return");
            Rect rect = new Rect();
            if (!textView.getLocalVisibleRect(rect) || rect.isEmpty() || !rect.intersect(this.codeBlockDrawRect)) {
                return;
            }
            n().d(canvas, rect, this.codeBlockDrawRect, text);
        }
    }

    private final void h(Canvas canvas, float x16, int top, int bottom, CharSequence text) {
        r(x16, top, bottom);
        if (this.spanInfo.a().getGlobalConfig().b()) {
            g(canvas, text);
        } else {
            f(canvas, x16, top, bottom, text);
        }
    }

    private final Paint j() {
        return (Paint) this.bitmapPaint.getValue();
    }

    private final int k() {
        TextView textView = this.spanInfo.e().get();
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(textView, "spanInfo.tvRef.get() ?: return 0");
            if (this.spanInfo.c().d()) {
                com.tencent.android.androidbypass.codeblock.utils.e eVar = com.tencent.android.androidbypass.codeblock.utils.e.f72044a;
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "textView.context");
                return (int) eVar.b(context, 0.0f);
            }
            return (int) (textView.getLineSpacingExtra() * textView.getLineSpacingMultiplier());
        }
        return 0;
    }

    private final int l() {
        Context context;
        float b16;
        TextView textView = this.spanInfo.e().get();
        if (textView != null && (context = textView.getContext()) != null) {
            if (this.spanInfo.c().d()) {
                b16 = com.tencent.android.androidbypass.codeblock.utils.e.f72044a.b(context, 0.0f);
            } else {
                b16 = com.tencent.android.androidbypass.codeblock.utils.e.f72044a.b(context, 5.0f);
            }
            return (int) b16;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.android.androidbypass.codeblock.span.plugin.center.a n() {
        return (com.tencent.android.androidbypass.codeblock.span.plugin.center.a) this.pluginCenter.getValue();
    }

    private final int o(Paint.FontMetricsInt fm5, CharSequence text) {
        int i3;
        TextView textView = this.spanInfo.e().get();
        if (textView != null) {
            i3 = textView.getMaxWidth();
        } else {
            i3 = 0;
        }
        if (i3 > 0 && fm5 != null) {
            Rect d16 = this.spanInfo.a().getGlobalConfig().d();
            fm5.top = 0;
            fm5.ascent = 0;
            int i16 = d16.top;
            fm5.bottom = i16;
            fm5.descent = i16;
            n().e(fm5, i3, text);
            int l3 = fm5.bottom + ((d16.bottom + l()) - k());
            fm5.bottom = l3;
            fm5.descent = l3;
            d(i3, l3);
        }
        return i3;
    }

    private final void r(float x16, int top, int bottom) {
        Rect rect = this.codeBlockDrawRect;
        rect.top = top;
        rect.bottom = bottom - l();
        Rect rect2 = this.codeBlockDrawRect;
        int i3 = (int) x16;
        rect2.left = i3;
        rect2.right = i3 + this.codeBlockWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        CharSequence charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, text, Integer.valueOf(start), Integer.valueOf(end), Float.valueOf(x16), Integer.valueOf(top), Integer.valueOf(y16), Integer.valueOf(bottom), paint);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        com.tencent.android.androidbypass.b.b().c();
        if (text != null) {
            charSequence = text.subSequence(start, end);
        } else {
            charSequence = null;
        }
        h(canvas, 0.0f, top, bottom, charSequence);
        com.tencent.android.androidbypass.b.b().b(i());
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        CharSequence charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, paint, text, Integer.valueOf(start), Integer.valueOf(end), fm5)).intValue();
        }
        Intrinsics.checkNotNullParameter(paint, "paint");
        com.tencent.android.androidbypass.b.c().c();
        if (text != null) {
            charSequence = text.subSequence(start, end);
        } else {
            charSequence = null;
        }
        int o16 = o(fm5, charSequence);
        com.tencent.android.androidbypass.b.c().b(i());
        return o16;
    }

    @NotNull
    public final Map<String, String> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Pair[] pairArr = new Pair[5];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("text_length", String.valueOf(this.spanInfo.c().c().length()));
        pairArr[1] = TuplesKt.to("node_size", String.valueOf(this.spanInfo.c().a().size()));
        Bitmap bitmap = this.codeBlockBitmap;
        if (bitmap != null) {
            i3 = bitmap.getByteCount();
        }
        pairArr[2] = TuplesKt.to("bitmap_size", String.valueOf(i3));
        pairArr[3] = TuplesKt.to("width", String.valueOf(this.codeBlockWidth));
        pairArr[4] = TuplesKt.to("height", String.valueOf(this.codeBlockHeight));
        return com.tencent.android.androidbypass.b.g(pairArr);
    }

    @NotNull
    public final b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (b) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.spanInfo.c();
    }

    public final boolean p(float posX, float posY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(posX), Float.valueOf(posY))).booleanValue();
        }
        if (!this.codeBlockDrawRect.contains((int) posX, (int) posY)) {
            return false;
        }
        return this.spanInfo.a().getGlobalConfig().c(this.spanInfo.c().c().toString(), this.spanInfo.c().b());
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.codeBlockWidth = 0;
        this.codeBlockHeight = 0;
        Job job = this.codeBlockBitmapJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.codeBlockBitmapJob = null;
        Bitmap bitmap = this.codeBlockBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.codeBlockBitmap = null;
    }
}
