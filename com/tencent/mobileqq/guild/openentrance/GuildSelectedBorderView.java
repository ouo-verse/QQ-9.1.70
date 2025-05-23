package com.tencent.mobileqq.guild.openentrance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001a\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/openentrance/GuildSelectedBorderView;", "Landroid/view/View;", "", "w", h.F, "oldw", "oldh", "", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", "path", "e", "I", "startColor", "f", "endColor", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "", "i", UserInfo.SEX_FEMALE, "boardWidthPX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "innerRadiusPX", BdhLogUtil.LogTag.Tag_Conn, "outerRadiusPX", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSelectedBorderView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float outerRadiusPX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int startColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int endColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float boardWidthPX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float innerRadiusPX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSelectedBorderView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawPath(this.path, this.paint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), this.startColor, this.endColor, Shader.TileMode.CLAMP));
        Path path = new Path();
        float f16 = this.boardWidthPX;
        float width = getWidth() - this.boardWidthPX;
        float height = getHeight() - this.boardWidthPX;
        float f17 = this.innerRadiusPX;
        path.addRoundRect(f16, f16, width, height, f17, f17, Path.Direction.CW);
        this.path.reset();
        Path path2 = this.path;
        float width2 = getWidth();
        float height2 = getHeight();
        float f18 = this.outerRadiusPX;
        path2.addRoundRect(0.0f, 0.0f, width2, height2, f18, f18, Path.Direction.CW);
        this.path.op(path, Path.Op.DIFFERENCE);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSelectedBorderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildSelectedBorderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSelectedBorderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.startColor = Color.parseColor("#55FD70");
        this.endColor = Color.parseColor("#0D9EFF");
        this.paint = new Paint();
        this.boardWidthPX = QQGuildUIUtil.f(5.0f);
        this.innerRadiusPX = QQGuildUIUtil.f(3.0f);
        this.outerRadiusPX = QQGuildUIUtil.f(8.0f);
    }
}
