package com.tencent.kuikly.core.render.android.css.animation;

import android.graphics.Matrix;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00107\u001a\u000205\u00a2\u0006\u0004\b8\u00109J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u001a\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\"\u0010\u001e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\"\u0010!\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\"\u0010$\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\"\u0010'\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\"\u0010)\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b(\u0010\u0012R\"\u0010+\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b*\u0010\u0012R$\u00101\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00104\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/n;", "", "", "transform", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "l", "a", DomainData.DOMAIN_NAME, "b", "o", "", UserInfo.SEX_FEMALE, "e", "()F", "r", "(F)V", CanvasView.ACTION_ROTATE, "getRotateX", "setRotateX", "rotateX", "c", "getRotateY", "setRotateY", "rotateY", "d", "f", ReportConstant.COSTREPORT_PREFIX, BasicAnimation.KeyPath.SCALE_X, "g", "t", BasicAnimation.KeyPath.SCALE_Y, tl.h.F, "u", "translateX", "i", "v", "translateY", "p", "pivotX", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "pivotY", "Ljava/lang/Float;", "getSkewX", "()Ljava/lang/Float;", "setSkewX", "(Ljava/lang/Float;)V", "skewX", "getSkewY", "setSkewY", "skewY", "Landroid/view/View;", "Landroid/view/View;", "target", "<init>", "(Ljava/lang/String;Landroid/view/View;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class n {

    /* renamed from: m, reason: collision with root package name */
    private static final Void f117642m = null;

    /* renamed from: n, reason: collision with root package name */
    private static final Void f117643n = null;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float rotate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float rotateX;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float rotateY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float scaleX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float scaleY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float translateX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float translateY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float pivotX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float pivotY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Float skewX;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Float skewY;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final View target;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0004\u00a8\u0006&"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/n$a;", "", "", "ANCHOR_INDEX", "I", "ANCHOR_X_INDEX", "ANCHOR_Y_INDEX", "", "DEFAULT_PIVOT_X", UserInfo.SEX_FEMALE, "DEFAULT_PIVOT_Y", "DEFAULT_ROTATE", "DEFAULT_SCALE_X", "DEFAULT_SCALE_Y", "", "DEFAULT_SKEW_X", "Ljava/lang/Void;", "DEFAULT_SKEW_Y", "DEFAULT_TRANSLATE_X", "DEFAULT_TRANSLATE_Y", "ROTATE_INDEX", "ROTATE_XY_INDEX", "ROTATE_X_INDEX", "ROTATE_Y_INDEX", "SCALE_INDEX", "SCALE_X_INDEX", "SCALE_Y_INDEX", "SKEW_INDEX", "SKEW_X_INDEX", "SKEW_Y_INDEX", "", "TRANSFORM_SEPARATOR", "Ljava/lang/String;", "TRANSLATE_INDEX", "TRANSLATE_X_INDEX", "TRANSLATE_Y_INDEX", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.css.animation.n$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public n(@Nullable String str, @NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.skewX = (Float) f117642m;
        this.skewY = (Float) f117643n;
        k(str);
    }

    private final void a() {
        Float f16 = this.skewX;
        if (f16 != null) {
            float floatValue = f16.floatValue();
            Float f17 = this.skewY;
            if (f17 != null) {
                float floatValue2 = f17.floatValue();
                float radians = (float) Math.toRadians(floatValue);
                float radians2 = (float) Math.toRadians(floatValue2);
                KRViewDecoration x16 = KRCSSViewExtensionKt.x(this.target);
                if (x16 != null) {
                    Matrix matrix = new Matrix();
                    matrix.setSkew(radians, radians2);
                    Unit unit = Unit.INSTANCE;
                    x16.z(matrix);
                }
            }
        }
    }

    private final void j() {
        this.rotate = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.translateX = 0.0f;
        this.translateY = 0.0f;
        this.pivotX = 0.0f;
        this.pivotY = 0.0f;
        n();
    }

    private final void k(String transform) {
        if (transform == null) {
            m();
        } else if (transform.hashCode() == 0 && transform.equals("")) {
            j();
        } else {
            l(transform);
        }
    }

    private final void l(String transform) {
        List split$default;
        List split$default2;
        List split$default3;
        List split$default4;
        List split$default5;
        List split$default6;
        split$default = StringsKt__StringsKt.split$default((CharSequence) transform, new String[]{"|"}, false, 0, 6, (Object) null);
        this.rotate = Float.parseFloat((String) split$default.get(0));
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{" "}, false, 0, 6, (Object) null);
        this.scaleX = Float.parseFloat((String) split$default2.get(0));
        this.scaleY = Float.parseFloat((String) split$default2.get(1));
        split$default3 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(2), new String[]{" "}, false, 0, 6, (Object) null);
        this.translateX = Float.parseFloat((String) split$default3.get(0)) * com.tencent.kuikly.core.render.android.css.ktx.b.h(this.target);
        this.translateY = Float.parseFloat((String) split$default3.get(1)) * com.tencent.kuikly.core.render.android.css.ktx.b.g(this.target);
        split$default4 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(3), new String[]{" "}, false, 0, 6, (Object) null);
        this.pivotX = Float.parseFloat((String) split$default4.get(0)) * com.tencent.kuikly.core.render.android.css.ktx.b.h(this.target);
        this.pivotY = Float.parseFloat((String) split$default4.get(1)) * com.tencent.kuikly.core.render.android.css.ktx.b.g(this.target);
        if (split$default.size() > 4) {
            split$default6 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(4), new String[]{" "}, false, 0, 6, (Object) null);
            this.skewX = Float.valueOf(Float.parseFloat((String) split$default6.get(0)));
            this.skewY = Float.valueOf(Float.parseFloat((String) split$default6.get(1)));
        }
        if (split$default.size() > 5) {
            split$default5 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(5), new String[]{" "}, false, 0, 6, (Object) null);
            this.rotateX = Float.parseFloat((String) split$default5.get(0));
            this.rotateY = Float.parseFloat((String) split$default5.get(1));
        }
    }

    private final void m() {
        this.rotate = this.target.getRotation();
        this.scaleX = this.target.getScaleX();
        this.scaleY = this.target.getScaleY();
        this.translateX = this.target.getTranslationX();
        this.translateY = this.target.getTranslationY();
        this.pivotX = this.target.getPivotX();
        this.pivotY = this.target.getPivotY();
    }

    private final void n() {
        this.skewX = null;
        this.skewY = null;
        KRViewDecoration x16 = KRCSSViewExtensionKt.x(this.target);
        if (x16 != null) {
            x16.z(null);
        }
    }

    public final void b() {
        this.target.setRotation(this.rotate);
        this.target.setRotationX(this.rotateX);
        this.target.setRotationY(this.rotateY);
        this.target.setScaleX(this.scaleX);
        this.target.setScaleY(this.scaleY);
        this.target.setTranslationX(this.translateX);
        this.target.setTranslationY(this.translateY);
        this.target.setPivotX(this.pivotX);
        this.target.setPivotY(this.pivotY);
        a();
    }

    /* renamed from: c, reason: from getter */
    public final float getPivotX() {
        return this.pivotX;
    }

    /* renamed from: d, reason: from getter */
    public final float getPivotY() {
        return this.pivotY;
    }

    /* renamed from: e, reason: from getter */
    public final float getRotate() {
        return this.rotate;
    }

    /* renamed from: f, reason: from getter */
    public final float getScaleX() {
        return this.scaleX;
    }

    /* renamed from: g, reason: from getter */
    public final float getScaleY() {
        return this.scaleY;
    }

    /* renamed from: h, reason: from getter */
    public final float getTranslateX() {
        return this.translateX;
    }

    /* renamed from: i, reason: from getter */
    public final float getTranslateY() {
        return this.translateY;
    }

    public final void o() {
        if (this.rotate != 0.0f) {
            this.target.setRotation(0.0f);
        }
        if (this.rotateX != 0.0f) {
            this.target.setRotationX(0.0f);
        }
        if (this.rotateY != 0.0f) {
            this.target.setRotationY(0.0f);
        }
        if (this.scaleX != 1.0f) {
            this.target.setScaleX(1.0f);
        }
        if (this.scaleY != 1.0f) {
            this.target.setScaleY(1.0f);
        }
        if (this.translateX != 0.0f) {
            this.target.setTranslationX(0.0f);
        }
        if (this.translateY != 0.0f) {
            this.target.setTranslationY(0.0f);
        }
        if (this.pivotX != 0.0f) {
            this.target.setPivotX(0.0f);
        }
        if (this.pivotY != 0.0f) {
            this.target.setPivotY(0.0f);
        }
        n();
    }

    public final void p(float f16) {
        this.pivotX = f16;
    }

    public final void q(float f16) {
        this.pivotY = f16;
    }

    public final void r(float f16) {
        this.rotate = f16;
    }

    public final void s(float f16) {
        this.scaleX = f16;
    }

    public final void t(float f16) {
        this.scaleY = f16;
    }

    public final void u(float f16) {
        this.translateX = f16;
    }

    public final void v(float f16) {
        this.translateY = f16;
    }
}
