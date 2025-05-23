package com.tencent.mobileqq.guild.widget.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u001c\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/BannerMask;", "Landroid/view/View;", "", "c", "", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "d", UserInfo.SEX_FEMALE, "rotateToRightDegree", "e", "I", "gradientDistanceYInDesign", "f", "widthInDesign", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "i", "pageBackgroundColor", "Landroidx/lifecycle/Observer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/Observer;", "gradientStartColorObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class BannerMask extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float rotateToRightDegree;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int gradientDistanceYInDesign;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int widthInDesign;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int pageBackgroundColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Integer> gradientStartColorObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerMask(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BannerMask this$0, Context context, Integer num) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (num != null) {
            i3 = kotlin.g.a(num.intValue(), 100);
        } else {
            i3 = QQGuildUIUtil.i(context, R.color.qui_common_bg_middle_light);
        }
        this$0.pageBackgroundColor = i3;
        this$0.c();
    }

    private final void c() {
        float width = (this.gradientDistanceYInDesign / this.widthInDesign) * getWidth();
        this.paint.setShader(new LinearGradient(getWidth() - (((float) Math.tan(this.rotateToRightDegree)) * width), width, getWidth(), 0.0f, kotlin.g.a(this.pageBackgroundColor, 100), kotlin.g.a(this.pageBackgroundColor, 30), Shader.TileMode.CLAMP));
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        int i3;
        super.onAttachedToWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LiveData<Integer> g16 = QuiBitmapResourceObtainColorHelper.g(context, R.drawable.qui_common_bg_bottom_standard_bg);
        g16.observeForever(this.gradientStartColorObserver);
        if (g16.getValue() != null) {
            Integer value = g16.getValue();
            Intrinsics.checkNotNull(value);
            i3 = kotlin.g.a(value.intValue(), 100);
        } else {
            i3 = QQGuildUIUtil.i(getContext(), R.color.qui_common_bg_middle_light);
        }
        this.pageBackgroundColor = i3;
        c();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QuiBitmapResourceObtainColorHelper.g(context, R.drawable.qui_common_bg_bottom_standard_bg).removeObserver(this.gradientStartColorObserver);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (w3 != oldw || h16 != oldh) {
            c();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerMask(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BannerMask(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerMask(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rotateToRightDegree = 0.27576202f;
        this.gradientDistanceYInDesign = QQGuildUIUtil.f(96.0f);
        this.widthInDesign = QQGuildUIUtil.f(355.64f);
        this.paint = new Paint();
        this.pageBackgroundColor = QQGuildUIUtil.i(context, R.color.qui_common_bg_middle_light);
        this.gradientStartColorObserver = new Observer() { // from class: com.tencent.mobileqq.guild.widget.banner.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BannerMask.b(BannerMask.this, context, (Integer) obj);
            }
        };
    }
}
