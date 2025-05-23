package com.tencent.android.androidbypass.custom.feedstyle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.android.androidbypass.codeblock.utils.e;
import com.tencent.android.androidbypass.custom.c;
import com.tencent.android.androidbypass.custom.g;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.span.BypassCompatStyleSpan;
import com.tencent.android.androidbypass.span.f;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001KB9\u0012\u0006\u00107\u001a\u000205\u0012\u0006\u0010:\u001a\u000208\u0012\u000e\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;\u0012\b\u0010C\u001a\u0004\u0018\u00010@\u0012\u0006\u0010G\u001a\u00020D\u00a2\u0006\u0004\bH\u0010IJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J4\u0010$\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016JR\u0010,\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u001fH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010.R!\u00104\u001a\b\u0012\u0004\u0012\u0002000/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00109R\u001c\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u0004\u0018\u00010@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpan;", "Landroid/text/style/ReplacementSpan;", "Lcom/tencent/android/androidbypass/span/f;", "", "height", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "b", "Landroid/content/Context;", "context", "Landroid/text/TextPaint;", "paint", "Lcom/tencent/android/androidbypass/custom/feedstyle/a;", TtmlNode.TAG_LAYOUT, "k", "g", "Lcom/tencent/android/androidbypass/custom/g;", h.F, "Lcom/tencent/android/androidbypass/custom/c;", "d", "", "hasLeftImage", "hasTitle", "e", "i", "Landroid/util/Size;", "wanted", "j", "imageSize", "f", "Landroid/graphics/Paint;", "", "text", "start", "end", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "draw", "Lcom/tencent/android/androidbypass/custom/feedstyle/a;", "Landroid/graphics/Paint$FontMetricsInt;", "Landroidx/core/util/Consumer;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Lazy;", "c", "()Landroidx/core/util/Consumer;", "onDrawableLoadedCallback", "Lcom/tencent/android/androidbypass/enhance/i;", "Lcom/tencent/android/androidbypass/enhance/i;", "styleSheet", "Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpanElementSoup;", "Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpanElementSoup;", "elementSoup", "Landroidx/core/util/Supplier;", "Lcom/tencent/android/androidbypass/custom/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/core/util/Supplier;", "hostVisitorProvider", "Lcom/tencent/android/androidbypass/Bypass$e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/android/androidbypass/Bypass$e;", "imageGetter", "", "D", "J", "traceId", "<init>", "(Lcom/tencent/android/androidbypass/enhance/i;Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpanElementSoup;Landroidx/core/util/Supplier;Lcom/tencent/android/androidbypass/Bypass$e;J)V", "E", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class FeedStyleSpan extends ReplacementSpan implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final Bypass.e imageGetter;

    /* renamed from: D, reason: from kotlin metadata */
    private final long traceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a layout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Paint.FontMetricsInt fm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy onDrawableLoadedCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final i styleSheet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final FeedStyleSpanElementSoup elementSoup;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Supplier<com.tencent.android.androidbypass.custom.a> hostVisitorProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpan$a;", "", "", "AVATAR_RIGHT_MARGIN_DP", UserInfo.SEX_FEMALE, "AVATAR_VERTICAL_MARGIN_DP", "DEFAULT_AVATAR_SIZE_DP", "DEFAULT_LEFT_IMAGE_RADIUS_DP", "DEFAULT_LEFT_IMAGE_SIZE_DP", "LEFT_IMAGE_RIGHT_MARGIN_DP", "", "MAX_LEFT_IMAGE_SIZE_DP", "I", "MIN_LEFT_IMAGE_SIZE_DP", "", "TAG", "Ljava/lang/String;", "TITLE_DESC_MARGIN_DP", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpan$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpan$b", "Lcom/tencent/android/androidbypass/custom/b;", "", "invalidate", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class b implements com.tencent.android.androidbypass.custom.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) FeedStyleSpan.this);
            }
        }

        @Override // com.tencent.android.androidbypass.custom.b
        public void invalidate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            com.tencent.android.androidbypass.custom.a aVar = (com.tencent.android.androidbypass.custom.a) FeedStyleSpan.this.hostVisitorProvider.get();
            if (aVar != null) {
                aVar.invalidate();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16670);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FeedStyleSpan(@NotNull i styleSheet, @NotNull FeedStyleSpanElementSoup elementSoup, @NotNull Supplier<com.tencent.android.androidbypass.custom.a> hostVisitorProvider, @Nullable Bypass.e eVar, long j3) {
        Lazy lazy;
        Context context;
        Intrinsics.checkNotNullParameter(styleSheet, "styleSheet");
        Intrinsics.checkNotNullParameter(elementSoup, "elementSoup");
        Intrinsics.checkNotNullParameter(hostVisitorProvider, "hostVisitorProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, styleSheet, elementSoup, hostVisitorProvider, eVar, Long.valueOf(j3));
            return;
        }
        this.styleSheet = styleSheet;
        this.elementSoup = elementSoup;
        this.hostVisitorProvider = hostVisitorProvider;
        this.imageGetter = eVar;
        this.traceId = j3;
        this.fm = new Paint.FontMetricsInt();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Consumer<Drawable>>() { // from class: com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpan$onDrawableLoadedCallback$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "it", "", "a", "(Landroid/graphics/drawable/Drawable;)V"}, k = 3, mv = {1, 4, 0})
            /* loaded from: classes3.dex */
            public static final class a<T> implements Consumer<Drawable> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) FeedStyleSpan$onDrawableLoadedCallback$2.this);
                    }
                }

                @Override // androidx.core.util.Consumer
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void accept(Drawable drawable) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
                        return;
                    }
                    com.tencent.android.androidbypass.custom.a aVar = (com.tencent.android.androidbypass.custom.a) FeedStyleSpan.this.hostVisitorProvider.get();
                    if (aVar != null) {
                        aVar.invalidate();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FeedStyleSpan.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Consumer<Drawable> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new a() : (Consumer) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.onDrawableLoadedCallback = lazy;
        com.tencent.android.androidbypass.custom.a aVar = hostVisitorProvider.get();
        if (aVar != null && (context = aVar.getContext()) != null) {
            this.layout = g(context);
        }
    }

    private final void b(int height, Paint.FontMetricsInt fm5) {
        int i3 = (int) ((height / 2.0f) - ((-(fm5.ascent + fm5.descent)) / 2.0f));
        fm5.bottom = i3;
        int i16 = i3 - height;
        fm5.top = i16;
        fm5.ascent = i16;
        fm5.descent = i3;
        Paint.FontMetricsInt fontMetricsInt = this.fm;
        fontMetricsInt.top = i16;
        fontMetricsInt.bottom = i3;
    }

    private final Consumer<Drawable> c() {
        return (Consumer) this.onDrawableLoadedCallback.getValue();
    }

    private final c d(Context context) {
        h.b bVar;
        String str;
        c cVar = new c("avatar");
        int a16 = vt.a.a(context, 16.0f);
        Size size = new Size(a16, a16);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(size.getWidth(), size.getHeight());
        int a17 = vt.a.a(context, 3.0f);
        marginLayoutParams.topMargin = a17;
        marginLayoutParams.bottomMargin = a17;
        marginLayoutParams.rightMargin = vt.a.a(context, 4.0f);
        Unit unit = Unit.INSTANCE;
        cVar.o(marginLayoutParams);
        Bypass.e eVar = this.imageGetter;
        if (eVar != null) {
            Pair<String, String> b16 = this.elementSoup.b();
            if (b16 == null || (str = b16.getFirst()) == null) {
                str = "";
            }
            h.b.c cVar2 = new h.b.c();
            cVar2.f72172a = this.traceId;
            cVar2.f72173b = size;
            bVar = eVar.b(context, str, cVar2, new com.tencent.android.androidbypass.enhance.drawable.transformer.a(ImageView.ScaleType.FIT_XY));
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.k(c());
        }
        cVar.s(bVar);
        return cVar;
    }

    private final g e(boolean hasLeftImage, boolean hasTitle, Context context) {
        int i3;
        g gVar = new g("description", this.elementSoup.c());
        if (hasLeftImage && hasTitle) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        gVar.v(i3);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        if (!hasLeftImage) {
            marginLayoutParams.bottomMargin = vt.a.a(context, 5.0f);
        }
        Unit unit = Unit.INSTANCE;
        gVar.o(marginLayoutParams);
        return gVar;
    }

    private final c f(Context context, Size imageSize) {
        h.b bVar;
        c cVar = new c("image");
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(imageSize.getWidth(), imageSize.getHeight());
        marginLayoutParams.rightMargin = vt.a.a(context, 12.0f);
        Unit unit = Unit.INSTANCE;
        cVar.o(marginLayoutParams);
        Bypass.e eVar = this.imageGetter;
        if (eVar != null) {
            String e16 = this.elementSoup.e();
            h.b.c cVar2 = new h.b.c();
            cVar2.f72172a = this.traceId;
            cVar2.f72173b = imageSize;
            cVar2.f72174c = true;
            cVar2.f72175d = ImageView.ScaleType.CENTER_CROP;
            bVar = eVar.b(context, e16, cVar2, new com.tencent.android.androidbypass.enhance.drawable.transformer.b(vt.a.b(context, 8.0f), ImageView.ScaleType.CENTER_CROP));
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.k(c());
        }
        cVar.s(bVar);
        return cVar;
    }

    private final a g(Context context) {
        boolean z16;
        boolean z17;
        com.tencent.android.androidbypass.custom.f[] fVarArr = new com.tencent.android.androidbypass.custom.f[5];
        boolean z18 = true;
        if (this.elementSoup.e().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            fVarArr[0] = f(context, j(context, this.elementSoup.d()));
        }
        if (this.elementSoup.h().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            fVarArr[1] = i(z16, context);
        }
        if (this.elementSoup.c().length() <= 0) {
            z18 = false;
        }
        if (z18) {
            fVarArr[2] = e(z16, z17, context);
        }
        fVarArr[3] = d(context);
        fVarArr[4] = h();
        return new a(fVarArr, new b());
    }

    private final g h() {
        String str;
        Pair<String, String> b16 = this.elementSoup.b();
        if (b16 == null || (str = b16.getSecond()) == null) {
            str = "";
        }
        g gVar = new g("nickname", str);
        gVar.o(new ViewGroup.MarginLayoutParams(-2, -2));
        gVar.v(1);
        return gVar;
    }

    private final g i(boolean hasLeftImage, Context context) {
        g gVar = new g("title", this.elementSoup.h());
        gVar.v(1);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        if (!hasLeftImage) {
            marginLayoutParams.bottomMargin = (int) e.f72044a.b(context, 5.0f);
        }
        Unit unit = Unit.INSTANCE;
        gVar.o(marginLayoutParams);
        return gVar;
    }

    private final Size j(Context context, Size wanted) {
        int coerceIn;
        int coerceIn2;
        if (wanted == null) {
            int a16 = vt.a.a(context, 72.0f);
            return new Size(a16, a16);
        }
        int a17 = vt.a.a(context, 50);
        int a18 = vt.a.a(context, 100);
        coerceIn = RangesKt___RangesKt.coerceIn(vt.a.a(context, wanted.getWidth()), a17, a18);
        coerceIn2 = RangesKt___RangesKt.coerceIn(vt.a.a(context, wanted.getHeight()), a17, a18);
        return new Size(coerceIn, coerceIn2);
    }

    private final void k(Context context, TextPaint paint, a layout) {
        com.tencent.android.androidbypass.custom.f[] fVarArr;
        com.tencent.android.androidbypass.custom.f[] fVarArr2;
        com.tencent.android.androidbypass.custom.f[] fVarArr3;
        TextPaint s16;
        TextPaint s17;
        TextPaint s18;
        fVarArr = layout.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node.CHILDREN_ATTR java.lang.String;
        com.tencent.android.androidbypass.custom.f fVar = fVarArr[1];
        if (!(fVar instanceof g)) {
            fVar = null;
        }
        g gVar = (g) fVar;
        if (gVar != null && (s18 = gVar.s()) != null) {
            s18.set(paint);
            s18.setTextSize(s18.getTextSize() * this.styleSheet.X);
            s18.setColor(this.styleSheet.d(null).c());
            new BypassCompatStyleSpan(1).updateMeasureState(s18);
        }
        fVarArr2 = layout.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node.CHILDREN_ATTR java.lang.String;
        com.tencent.android.androidbypass.custom.f fVar2 = fVarArr2[2];
        if (!(fVar2 instanceof g)) {
            fVar2 = null;
        }
        g gVar2 = (g) fVar2;
        if (gVar2 != null && (s17 = gVar2.s()) != null) {
            s17.set(paint);
            s17.setColor(this.styleSheet.d(null).a());
        }
        fVarArr3 = layout.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node.CHILDREN_ATTR java.lang.String;
        com.tencent.android.androidbypass.custom.f fVar3 = fVarArr3[4];
        if (!(fVar3 instanceof g)) {
            fVar3 = null;
        }
        g gVar3 = (g) fVar3;
        if (gVar3 != null && (s16 = gVar3.s()) != null) {
            s16.set(paint);
            s16.setColor(this.styleSheet.d(null).b());
            float f16 = this.styleSheet.Y;
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            s16.setTextSize(TypedValue.applyDimension(2, f16, resources.getDisplayMetrics()));
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, text, Integer.valueOf(start), Integer.valueOf(end), Float.valueOf(x16), Integer.valueOf(top), Integer.valueOf(y16), Integer.valueOf(bottom), paint);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        a aVar = this.layout;
        if (aVar != null) {
            float f16 = y16 + this.fm.top;
            canvas.translate(x16, f16);
            aVar.f(canvas);
            canvas.translate(-x16, -f16);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, this, paint, text, Integer.valueOf(start), Integer.valueOf(end), fm5)).intValue();
        }
        Intrinsics.checkNotNullParameter(paint, "paint");
        com.tencent.android.androidbypass.custom.a aVar = this.hostVisitorProvider.get();
        if (text == null || aVar == null) {
            return 0;
        }
        int maxWidth = aVar.getMaxWidth();
        if (maxWidth > 0 && fm5 != null) {
            a aVar2 = this.layout;
            if (aVar2 != null) {
                if (aVar2.h() != maxWidth) {
                    TextPaint it = this.styleSheet.c();
                    if (it != null) {
                        Context context = aVar.getContext();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        k(context, it, aVar2);
                    }
                    aVar2.k(maxWidth);
                }
                b(aVar2.g(), fm5);
            }
            return aVar.getMaxWidth();
        }
        return maxWidth;
    }
}
