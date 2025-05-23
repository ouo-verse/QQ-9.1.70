package com.tencent.kuikly.core.render.android.css.decoration;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import f01.b;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010g\u001a\u00020\u001b\u00a2\u0006\u0004\bh\u0010iJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u001b\u00102\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b0\u00101R\u001b\u00106\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b4\u00105R*\u0010=\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010D\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u00010>8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR*\u0010J\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010LR\"\u0010S\u001a\u00020N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010\u0013\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR*\u0010\u000f\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010E\u001a\u0004\bU\u0010G\"\u0004\bV\u0010IR*\u0010X\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010E\u001a\u0004\bW\u0010G\"\u0004\b\u0003\u0010IR\u0016\u0010Y\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0013R\u0016\u0010Z\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0013R\u0016\u0010[\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00108R\u0016\u0010\\\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R*\u0010_\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010E\u001a\u0004\b]\u0010G\"\u0004\b^\u0010IR\u0018\u0010b\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010aR,\u0010f\u001a\u0004\u0018\u00010`*\u00020\u001b2\b\u00107\u001a\u0004\u0018\u00010`8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bT\u0010c\"\u0004\bd\u0010e\u00a8\u0006j"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/decoration/KRViewDecoration;", "", "", "w", h.F, "Landroid/graphics/Canvas;", PM.CANVAS, "", "f", "e", "i", "", "shadowValue", "r", ReportConstant.COSTREPORT_PREFIX, NodeProps.BORDER_RADIUS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "E", "B", "Landroid/view/ViewOutlineProvider;", "outlineProvider", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "g", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "targetViewWeakRef", "Lcom/tencent/kuikly/core/render/android/a;", "b", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "Landroid/graphics/Path;", "c", "Lkotlin/Lazy;", "o", "()Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "d", "p", "()Landroid/graphics/RectF;", "rectF", "Landroid/graphics/Paint;", DomainData.DOMAIN_NAME, "()Landroid/graphics/Paint;", "paint", "Landroid/graphics/drawable/LayerDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/graphics/drawable/LayerDrawable;", "layerDrawable", "value", "I", "j", "()I", "t", "(I)V", "backgroundColor", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/graphics/Matrix;)V", "matrix", "Ljava/lang/String;", "getBackgroundImage", "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "backgroundImage", "", "[F", "borderRadii", "", "k", "()F", "setBorderRadiusF", "(F)V", "borderRadiusF", "l", "getBorderRadius", "v", "getBorderStyle", NodeProps.BORDER_STYLES, NodeProps.SHADOW_OFFSET_X, NodeProps.SHADOW_OFFSET_Y, NodeProps.SHADOW_COLOR, NodeProps.SHADOW_RADIUS, "getBoxShadow", HippyTKDListViewAdapter.X, "boxShadow", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "foregroundDrawableForAndroidM", "(Landroid/view/View;)Landroid/graphics/drawable/Drawable;", "y", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "foregroundCompat", "targetView", "<init>", "(Landroid/view/View;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRViewDecoration {

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<View> targetViewWeakRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy path;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy rectF;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy layerDrawable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int backgroundColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Matrix matrix;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String backgroundImage;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float[] borderRadii;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float borderRadiusF;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String borderRadius;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String borderStyle;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float shadowOffsetX;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float shadowOffsetY;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int shadowColor;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private float shadowRadius;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String boxShadow;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Drawable foregroundDrawableForAndroidM;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/decoration/KRViewDecoration$a;", "", "", "BORDER_RADIUS_UNSET_VALUE", UserInfo.SEX_FEMALE, "", "LAYER_ID_COLOR_DRAWABLE", "I", "LAYER_ID_GRADIENT_DRAWABLE", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/kuikly/core/render/android/css/decoration/KRViewDecoration$setOutlineViewProviderIfNeed$1$1", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            Drawable drawable;
            int i3;
            if (view != null && outline != null && view.getWidth() > 0 && view.getHeight() > 0) {
                if (KRViewDecoration.this.getBorderRadiusF() != -1.0f) {
                    if (KRCSSViewExtensionKt.z()) {
                        View view2 = (View) KRViewDecoration.this.targetViewWeakRef.get();
                        Drawable drawable2 = null;
                        if (view2 != null) {
                            drawable = KRViewDecoration.this.l(view2);
                        } else {
                            drawable = null;
                        }
                        if (drawable instanceof f01.b) {
                            drawable2 = drawable;
                        }
                        f01.b bVar = (f01.b) drawable2;
                        if (bVar != null) {
                            i3 = bVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.BORDER_WIDTH java.lang.String();
                        } else {
                            i3 = 0;
                        }
                        int i16 = -i3;
                        outline.setRoundRect(i16, i16, view.getWidth() + i3, view.getHeight() + i3, KRViewDecoration.this.getBorderRadiusF());
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), KRViewDecoration.this.getBorderRadiusF());
                    return;
                }
                if (KRViewDecoration.this.borderRadii != null) {
                    KRViewDecoration.this.o().reset();
                    KRViewDecoration.this.p().set(0.0f, 0.0f, view.getWidth(), view.getHeight());
                    Path o16 = KRViewDecoration.this.o();
                    RectF p16 = KRViewDecoration.this.p();
                    float[] fArr = KRViewDecoration.this.borderRadii;
                    Intrinsics.checkNotNull(fArr);
                    o16.addRoundRect(p16, fArr, Path.Direction.CW);
                    if (Build.VERSION.SDK_INT >= 30) {
                        outline.setPath(KRViewDecoration.this.o());
                    } else {
                        outline.setConvexPath(KRViewDecoration.this.o());
                    }
                }
            }
        }
    }

    public KRViewDecoration(@NotNull View targetView) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.targetViewWeakRef = new WeakReference<>(targetView);
        Object context = targetView.getContext();
        this.kuiklyContext = (com.tencent.kuikly.core.render.android.a) (context instanceof com.tencent.kuikly.core.render.android.a ? context : null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Path>() { // from class: com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration$path$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Path invoke() {
                return new Path();
            }
        });
        this.path = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RectF>() { // from class: com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration$rectF$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RectF invoke() {
                return new RectF();
            }
        });
        this.rectF = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration$paint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL);
                return paint;
            }
        });
        this.paint = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<LayerDrawable>() { // from class: com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration$layerDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LayerDrawable invoke() {
                if (!KRCSSViewExtensionKt.z()) {
                    return new LayerDrawable(new Drawable[0]);
                }
                return new LayerDrawable(new b[]{new b(), new b()});
            }
        });
        this.layerDrawable = lazy4;
        this.backgroundImage = "";
        this.borderRadiusF = -1.0f;
        this.borderRadius = "";
        this.borderStyle = "";
        this.boxShadow = "";
    }

    private final void A(ViewOutlineProvider outlineProvider) {
        boolean z16;
        View it = this.targetViewWeakRef.get();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.setOutlineProvider(outlineProvider);
            if (outlineProvider != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            it.setClipToOutline(z16);
        }
    }

    private final void B() {
        boolean z16;
        if (this.targetViewWeakRef.get() != null) {
            if (this.boxShadow.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                A(null);
            } else {
                A(new b());
            }
        }
    }

    private final void C() {
        int i3;
        Drawable findDrawableByLayerId = m().findDrawableByLayerId(1);
        Drawable drawable = findDrawableByLayerId;
        if (findDrawableByLayerId == null) {
            f01.b bVar = new f01.b();
            bVar.g(this.kuiklyContext);
            if (KRCSSViewExtensionKt.z()) {
                if (m().findDrawableByLayerId(2) == null) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                m().setId(i3, 1);
                m().setDrawableByLayerId(1, bVar);
                drawable = bVar;
            } else {
                m().setId(m().addLayer(bVar), 1);
                drawable = bVar;
            }
        }
        f01.b bVar2 = (f01.b) drawable;
        bVar2.setColor(this.backgroundColor);
        bVar2.d(this.borderRadius);
        F();
    }

    private final void D() {
        Drawable findDrawableByLayerId = m().findDrawableByLayerId(2);
        Drawable drawable = findDrawableByLayerId;
        if (findDrawableByLayerId == null) {
            f01.b bVar = new f01.b();
            bVar.g(this.kuiklyContext);
            if (KRCSSViewExtensionKt.z()) {
                int i3 = 1;
                if (m().findDrawableByLayerId(1) == null) {
                    i3 = 0;
                }
                m().setId(i3, 2);
                m().setDrawableByLayerId(2, bVar);
                drawable = bVar;
            } else {
                m().setId(m().addLayer(bVar), 2);
                drawable = bVar;
            }
        }
        f01.b bVar2 = (f01.b) drawable;
        bVar2.c(this.backgroundImage);
        bVar2.d(this.borderRadius);
        F();
    }

    private final void E() {
        View view = this.targetViewWeakRef.get();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            Drawable l3 = l(view);
            if (l3 == null) {
                l3 = new f01.b();
            }
            f01.b bVar = (f01.b) l3;
            bVar.g(this.kuiklyContext);
            bVar.e(this.borderStyle);
            bVar.d(this.borderRadius);
            bVar.h(view);
            bVar.f(true);
            if (l(view) == null) {
                y(view, l3);
            } else {
                view.invalidate();
            }
        }
    }

    private final void F() {
        View it = this.targetViewWeakRef.get();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (Intrinsics.areEqual(it.getBackground(), m())) {
                it.invalidate();
            } else {
                it.setBackground(m());
            }
        }
    }

    private final void e(int w3, int h16, Canvas canvas) {
        Matrix matrix = this.matrix;
        if (matrix != null) {
            canvas.concat(matrix);
        }
    }

    private final void f(int w3, int h16, Canvas canvas) {
        if (this.borderRadiusF == -1.0f && this.borderRadii == null) {
            return;
        }
        p().set(0.0f, 0.0f, w3, h16);
        n().setColor(0);
        if (this.borderRadiusF != -1.0f) {
            o().reset();
            Path o16 = o();
            RectF p16 = p();
            float f16 = this.borderRadiusF;
            o16.addRoundRect(p16, f16, f16, Path.Direction.CW);
        } else if (this.borderRadii != null) {
            o().reset();
            Path o17 = o();
            RectF p17 = p();
            float[] fArr = this.borderRadii;
            Intrinsics.checkNotNull(fArr);
            o17.addRoundRect(p17, fArr, Path.Direction.CW);
        }
        canvas.drawPath(o(), n());
        canvas.clipPath(o());
    }

    private final void i(int w3, int h16, Canvas canvas) {
        if (this.shadowRadius == 0.0f) {
            return;
        }
        RectF p16 = p();
        float f16 = this.shadowOffsetX;
        float f17 = this.shadowOffsetY;
        p16.set(f16, f17, w3 + f16, h16 + f17);
        n().setColor(this.shadowColor);
        n().setMaskFilter(new BlurMaskFilter(this.shadowRadius, BlurMaskFilter.Blur.NORMAL));
        if (this.borderRadiusF != -1.0f) {
            RectF p17 = p();
            float f18 = this.borderRadiusF;
            canvas.drawRoundRect(p17, f18, f18, n());
        } else {
            if (this.borderRadii != null) {
                o().reset();
                Path o16 = o();
                RectF p18 = p();
                float[] fArr = this.borderRadii;
                Intrinsics.checkNotNull(fArr);
                o16.addRoundRect(p18, fArr, Path.Direction.CW);
                canvas.drawPath(o(), n());
                return;
            }
            canvas.drawRect(p(), n());
        }
    }

    private final LayerDrawable m() {
        return (LayerDrawable) this.layerDrawable.getValue();
    }

    private final Paint n() {
        return (Paint) this.paint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Path o() {
        return (Path) this.path.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RectF p() {
        return (RectF) this.rectF.getValue();
    }

    private final void q(String borderRadius) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) borderRadius, new String[]{","}, false, 0, 6, (Object) null);
        if (split$default.size() == 4) {
            float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(0)));
            float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(1)));
            float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(2)));
            float I4 = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(3)));
            float[] fArr = {I, I, I2, I2, I4, I4, I3, I3};
            if (f01.b.INSTANCE.b(fArr)) {
                this.borderRadiusF = I;
                this.borderRadii = null;
            } else {
                this.borderRadiusF = -1.0f;
                this.borderRadii = fArr;
            }
        }
    }

    private final void r(String shadowValue) {
        if (Intrinsics.areEqual(shadowValue, "")) {
            s();
            return;
        }
        a aVar = new a(shadowValue, this.kuiklyContext);
        this.shadowOffsetX = aVar.getShadowOffsetX();
        this.shadowOffsetY = aVar.getShadowOffsetY();
        this.shadowRadius = aVar.getShadowRadius();
        this.shadowColor = aVar.getCom.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_COLOR java.lang.String();
    }

    private final void s() {
        this.shadowOffsetX = 0.0f;
        this.shadowOffsetY = 0.0f;
        this.shadowRadius = 0.0f;
        this.shadowColor = 0;
    }

    public void g(int w3, int h16, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        i(w3, h16, canvas);
        f(w3, h16, canvas);
        e(w3, h16, canvas);
    }

    public void h(int w3, int h16, @NotNull Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (KRCSSViewExtensionKt.z() && (drawable = this.foregroundDrawableForAndroidM) != null) {
            Rect bounds = drawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "it.bounds");
            bounds.set(0, 0, w3, h16);
            drawable.setBounds(bounds);
            drawable.draw(canvas);
        }
    }

    /* renamed from: j, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: k, reason: from getter */
    public final float getBorderRadiusF() {
        return this.borderRadiusF;
    }

    @Nullable
    public final Drawable l(@NotNull View foregroundCompat) {
        Intrinsics.checkNotNullParameter(foregroundCompat, "$this$foregroundCompat");
        if (KRCSSViewExtensionKt.z()) {
            return this.foregroundDrawableForAndroidM;
        }
        return foregroundCompat.getForeground();
    }

    public final void t(int i3) {
        if (i3 == this.backgroundColor) {
            return;
        }
        this.backgroundColor = i3;
        C();
    }

    public final void u(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.backgroundImage, value)) {
            return;
        }
        this.backgroundImage = value;
        D();
    }

    public final void v(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.borderRadius, value)) {
            return;
        }
        this.borderRadius = value;
        q(value);
        B();
        C();
        D();
        E();
    }

    public final void w(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.borderStyle, value)) {
            return;
        }
        this.borderStyle = value;
        E();
    }

    public final void x(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.boxShadow, value)) {
            return;
        }
        this.boxShadow = value;
        r(value);
        if (this.shadowRadius != 0.0f) {
            A(null);
            View view = this.targetViewWeakRef.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public final void y(@NotNull View foregroundCompat, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(foregroundCompat, "$this$foregroundCompat");
        if (KRCSSViewExtensionKt.z()) {
            this.foregroundDrawableForAndroidM = drawable;
        } else {
            foregroundCompat.setForeground(drawable);
        }
    }

    public final void z(@Nullable Matrix matrix) {
        if (Intrinsics.areEqual(this.matrix, matrix)) {
            return;
        }
        this.matrix = matrix;
        View view = this.targetViewWeakRef.get();
        if (view != null) {
            view.invalidate();
        }
    }
}
