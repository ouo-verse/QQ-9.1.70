package f01;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.SizeF;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import d01.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 ;2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R*\u0010/\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010-\"\u0004\b#\u0010.R\"\u00105\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u00101\u001a\u0004\b\u0014\u00102\"\u0004\b3\u00104R*\u00107\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010+\u001a\u0004\b6\u0010-\"\u0004\b'\u0010.R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010+\u001a\u0004\b8\u0010-\"\u0004\b\u001c\u0010.\u00a8\u0006<"}, d2 = {"Lf01/b;", "Landroid/graphics/drawable/GradientDrawable;", "", "backgroundImage", "", "i", "", "scrollX", "scrollY", "Landroid/graphics/Canvas;", PM.CANVAS, "a", "draw", "", "Z", "isForeground", "()Z", "f", "(Z)V", "Landroid/view/View;", "b", "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", h.F, "(Landroid/view/View;)V", "targetView", "Lcom/tencent/kuikly/core/render/android/a;", "c", "Lcom/tencent/kuikly/core/render/android/a;", "getKuiklyContext", "()Lcom/tencent/kuikly/core/render/android/a;", "g", "(Lcom/tencent/kuikly/core/render/android/a;)V", "kuiklyContext", "d", UserInfo.SEX_FEMALE, "borderRadiusF", "", "e", "[F", "borderRadii", "value", "Ljava/lang/String;", "getBorderRadius", "()Ljava/lang/String;", "(Ljava/lang/String;)V", NodeProps.BORDER_RADIUS, "", "I", "()I", "setBorderWidth", "(I)V", NodeProps.BORDER_WIDTH, "getBorderStyle", NodeProps.BORDER_STYLES, "getBackgroundImage", "<init>", "()V", "j", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b extends GradientDrawable {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isForeground;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View targetView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.kuikly.core.render.android.a kuiklyContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float[] borderRadii;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int borderWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float borderRadiusF = -1.0f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String borderRadius = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String borderStyle = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String backgroundImage = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0016R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0016R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0016R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0016R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0016R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0016R\u0014\u0010-\u001a\u00020#8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0016R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0016R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0016R\u0014\u00101\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0016R\u0014\u00102\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0016R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0016\u00a8\u00066"}, d2 = {"Lf01/b$a;", "", "", "direction", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "a", "", "radii", "", "b", "", "backgroundImage", "Lkotlin/Triple;", "", "c", "Landroid/util/SizeF;", "size", "Landroid/graphics/Shader$TileMode;", "titleMode", "Landroid/graphics/LinearGradient;", "d", "BACKGROUND_IMAGE_COLORS_COLOR_INDEX", "I", "BACKGROUND_IMAGE_COLORS_OFFSET_INDEX", "BACKGROUND_IMAGE_DIRECTION_BL_TR", "BACKGROUND_IMAGE_DIRECTION_BOTTOM_TOP", "BACKGROUND_IMAGE_DIRECTION_BR_TL", "BACKGROUND_IMAGE_DIRECTION_INDEX", "BACKGROUND_IMAGE_DIRECTION_LEFT_RIGHT", "BACKGROUND_IMAGE_DIRECTION_RIGHT_LEFT", "BACKGROUND_IMAGE_DIRECTION_TL_BR", "BACKGROUND_IMAGE_DIRECTION_TOP_BOTTOM", "BACKGROUND_IMAGE_DIRECTION_TR_BL", "BORDER_BOTTOM_LEFT_INDEX", "BORDER_BOTTOM_RIGHT_INDEX", "", "BORDER_DASH_GAP", UserInfo.SEX_FEMALE, "BORDER_DASH_WIDTH", "BORDER_ELEMENT_SIZE", "BORDER_LINE_STYLE_INDEX", "BORDER_RADII_BL", "BORDER_RADII_BR", "BORDER_RADII_TL", "BORDER_RADII_TR", "BORDER_RADIUS_UNSET_VALUE", "BORDER_STYLE_ELEMENT_SIZE", "BORDER_STYLE_LINE_COLOR", "BORDER_STYLE_WIDTH_INDEX", "BORDER_TOP_LEFT_INDEX", "BORDER_TOP_RIGHT_INDEX", "BORDER_WIDTH_DEFAULT_VALUE", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: f01.b$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        private final GradientDrawable.Orientation a(int direction) {
            switch (direction) {
                case 0:
                    return GradientDrawable.Orientation.BOTTOM_TOP;
                case 1:
                    return GradientDrawable.Orientation.TOP_BOTTOM;
                case 2:
                    return GradientDrawable.Orientation.RIGHT_LEFT;
                case 3:
                    return GradientDrawable.Orientation.LEFT_RIGHT;
                case 4:
                    return GradientDrawable.Orientation.BR_TL;
                case 5:
                    return GradientDrawable.Orientation.BL_TR;
                case 6:
                    return GradientDrawable.Orientation.TR_BL;
                case 7:
                    return GradientDrawable.Orientation.TL_BR;
                default:
                    return GradientDrawable.Orientation.BOTTOM_TOP;
            }
        }

        public final boolean b(@NotNull float[] radii) {
            Intrinsics.checkNotNullParameter(radii, "radii");
            float f16 = radii[0];
            float f17 = radii[2];
            float f18 = radii[4];
            float f19 = radii[6];
            if (f16 != f17 || f16 != f18 || f16 != f19) {
                return false;
            }
            return true;
        }

        @NotNull
        public final Triple<GradientDrawable.Orientation, int[], float[]> c(@NotNull String backgroundImage) {
            List split$default;
            CharSequence trim;
            List split$default2;
            Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
            String substring = backgroundImage.substring(16, backgroundImage.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            split$default = StringsKt__StringsKt.split$default((CharSequence) substring, new String[]{","}, false, 0, 6, (Object) null);
            int[] iArr = new int[split$default.size() - 1];
            float[] fArr = new float[split$default.size() - 1];
            int size = split$default.size();
            for (int i3 = 1; i3 < size; i3++) {
                String str = (String) split$default.get(i3);
                if (str != null) {
                    trim = StringsKt__StringsKt.trim((CharSequence) str);
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) trim.toString(), new String[]{" "}, false, 0, 6, (Object) null);
                    int i16 = i3 - 1;
                    iArr[i16] = com.tencent.kuikly.core.render.android.css.ktx.b.w((String) split$default2.get(0));
                    fArr[i16] = Float.parseFloat((String) split$default2.get(1));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return new Triple<>(a(Integer.parseInt((String) split$default.get(0))), iArr, fArr);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x003a. Please report as an issue. */
        @Nullable
        public final LinearGradient d(@NotNull String backgroundImage, @NotNull SizeF size, @NotNull Shader.TileMode titleMode) {
            float f16;
            float f17;
            float f18;
            float f19;
            float f26;
            float f27;
            float f28;
            float f29;
            float f36;
            float f37;
            float f38;
            float f39;
            float f46;
            float f47;
            Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(titleMode, "titleMode");
            Triple<GradientDrawable.Orientation, int[], float[]> c16 = c(backgroundImage);
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = size.getWidth();
            rectF.bottom = size.getHeight();
            switch (a.f397487a[c16.getFirst().ordinal()]) {
                case 1:
                    f16 = rectF.left;
                    f17 = rectF.top;
                    f18 = rectF.bottom;
                    f38 = f16;
                    f39 = f38;
                    f46 = f18;
                    f47 = f17;
                    break;
                case 2:
                    f19 = rectF.right;
                    f26 = rectF.top;
                    f27 = rectF.left;
                    f28 = rectF.bottom;
                    f38 = f19;
                    f46 = f28;
                    f47 = f26;
                    f39 = f27;
                    break;
                case 3:
                    f29 = rectF.right;
                    f36 = rectF.top;
                    f37 = rectF.left;
                    f38 = f29;
                    f39 = f37;
                    f47 = f36;
                    f46 = f47;
                    break;
                case 4:
                    f19 = rectF.right;
                    f26 = rectF.bottom;
                    f27 = rectF.left;
                    f28 = rectF.top;
                    f38 = f19;
                    f46 = f28;
                    f47 = f26;
                    f39 = f27;
                    break;
                case 5:
                    f16 = rectF.left;
                    f17 = rectF.bottom;
                    f18 = rectF.top;
                    f38 = f16;
                    f39 = f38;
                    f46 = f18;
                    f47 = f17;
                    break;
                case 6:
                    f19 = rectF.left;
                    f26 = rectF.bottom;
                    f27 = rectF.right;
                    f28 = rectF.top;
                    f38 = f19;
                    f46 = f28;
                    f47 = f26;
                    f39 = f27;
                    break;
                case 7:
                    f29 = rectF.left;
                    f36 = rectF.top;
                    f37 = rectF.right;
                    f38 = f29;
                    f39 = f37;
                    f47 = f36;
                    f46 = f47;
                    break;
                default:
                    f19 = rectF.left;
                    f26 = rectF.top;
                    f27 = rectF.right;
                    f28 = rectF.bottom;
                    f38 = f19;
                    f46 = f28;
                    f47 = f26;
                    f39 = f27;
                    break;
            }
            return new LinearGradient(f38, f47, f39, f46, c16.getSecond(), c16.getThird(), titleMode);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(float scrollX, float scrollY, Canvas canvas) {
        if (scrollX == 0.0f && scrollY == 0.0f) {
            super.draw(canvas);
            return;
        }
        canvas.translate(scrollX, scrollY);
        super.draw(canvas);
        canvas.translate(-scrollX, -scrollY);
    }

    private final void i(String backgroundImage) {
        if (Intrinsics.areEqual(backgroundImage, "")) {
            setColors(new int[]{0, 0});
            return;
        }
        Triple<GradientDrawable.Orientation, int[], float[]> c16 = INSTANCE.c(backgroundImage);
        setOrientation(c16.getFirst());
        if (Build.VERSION.SDK_INT >= 29) {
            setColors(c16.getSecond(), c16.getThird());
        } else {
            setColors(c16.getSecond());
        }
    }

    /* renamed from: b, reason: from getter */
    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final void c(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.backgroundImage, value)) {
            return;
        }
        i(value);
        this.backgroundImage = value;
    }

    public final void d(@NotNull String value) {
        List split$default;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.borderRadius, value)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) value, new String[]{","}, false, 0, 6, (Object) null);
            if (split$default.size() == 4) {
                float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(0)));
                float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(1)));
                float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(2)));
                float I4 = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, Float.parseFloat((String) split$default.get(3)));
                float[] fArr = {I, I, I2, I2, I4, I4, I3, I3};
                if (INSTANCE.b(fArr)) {
                    setCornerRadius(I - (this.borderWidth / 2.0f));
                    this.borderRadiusF = I;
                } else {
                    setCornerRadii(fArr);
                    this.borderRadii = fArr;
                }
                this.borderRadius = value;
            }
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        float f16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isForeground) {
            View view = this.targetView;
            float f17 = 0.0f;
            if (view != null) {
                f16 = view.getScrollX();
            } else {
                f16 = 0.0f;
            }
            View view2 = this.targetView;
            if (view2 != null) {
                f17 = view2.getScrollY();
            }
            a(f16, f17, canvas);
            return;
        }
        try {
            super.draw(canvas);
        } catch (Throwable th5) {
            w.f392617a.b("KRCSSBackgroundDrawable", "draw error: " + th5);
        }
    }

    public final void e(@NotNull String value) {
        List split$default;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.borderStyle, value)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) value, new String[]{" "}, false, 0, 6, (Object) null);
            if (split$default.size() != 3) {
                return;
            }
            int K = com.tencent.kuikly.core.render.android.css.ktx.b.K(this.kuiklyContext, Float.parseFloat((String) split$default.get(0)));
            String str = (String) split$default.get(1);
            int w3 = com.tencent.kuikly.core.render.android.css.ktx.b.w((String) split$default.get(2));
            int hashCode = str.hashCode();
            if (hashCode != -1338941519) {
                if (hashCode != -1325970902) {
                    if (hashCode == 109618859 && str.equals("solid")) {
                        setStroke(K, ColorStateList.valueOf(w3));
                    }
                } else if (str.equals("dotted")) {
                    setStroke(K, ColorStateList.valueOf(w3), K, com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, 1.0f));
                }
            } else if (str.equals("dashed")) {
                setStroke(K, ColorStateList.valueOf(w3), com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, 4.0f), com.tencent.kuikly.core.render.android.css.ktx.b.I(this.kuiklyContext, 1.0f));
            }
            this.borderWidth = K;
            this.borderStyle = value;
        }
    }

    public final void f(boolean z16) {
        this.isForeground = z16;
    }

    public final void g(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        this.kuiklyContext = aVar;
    }

    public final void h(@Nullable View view) {
        this.targetView = view;
    }
}
