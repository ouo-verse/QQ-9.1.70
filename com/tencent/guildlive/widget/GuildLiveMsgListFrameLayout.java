package com.tencent.guildlive.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ts0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0004\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0014J \u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010*R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010*R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010*R\u0018\u00105\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006="}, d2 = {"Lcom/tencent/guildlive/widget/GuildLiveMsgListFrameLayout;", "Landroid/widget/FrameLayout;", "", "b", "", "position", "", "drawSize", "setPositionAndDrawSize", "", "gradientColors", "setGradientColors", "Lts0/a;", "liveAIOListener", "a", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/view/View;", "child", "", "drawingTime", "drawChild", "", "d", "[F", "mGradientPosition", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "mPaint", "f", "[I", "mGradientColors", "I", "mPosition", "i", UserInfo.SEX_FEMALE, "mDrawSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mWidth", BdhLogUtil.LogTag.Tag_Conn, "mHeight", "D", "Lts0/a;", "mLiveAioListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveMsgListFrameLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int mHeight;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private a mLiveAioListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] mGradientPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] mGradientColors;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mDrawSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLiveMsgListFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mDrawSize, this.mGradientColors, this.mGradientPosition, Shader.TileMode.CLAMP));
    }

    public final void a(@Nullable a liveAIOListener) {
        this.mLiveAioListener = liveAIOListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002d, code lost:
    
        if (((android.app.Activity) r0).isFinishing() != false) goto L8;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        a aVar;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (!((Activity) context).isDestroyed()) {
                Context context2 = getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            }
            QLog.i("GuildLiveMsgListFrameLayout", 1, "dispatchTouchEvent activity is finishing");
            return false;
        }
        if (getVisibility() == 0 && (aVar = this.mLiveAioListener) != null) {
            aVar.ch(ev5.getAction());
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long drawingTime) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, child, drawingTime);
        if ((this.mPosition & 1) != 0) {
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mDrawSize, this.mPaint);
        }
        if ((this.mPosition & 2) != 0) {
            int save = canvas.save();
            canvas.rotate(180.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mDrawSize, this.mPaint);
            canvas.restoreToCount(save);
        }
        int i3 = (this.mHeight - this.mWidth) / 2;
        if ((this.mPosition & 4) != 0) {
            int save2 = canvas.save();
            canvas.rotate(90.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            float f16 = i3;
            canvas.translate(0.0f, f16);
            canvas.drawRect(-f16, 0.0f, this.mWidth + i3, this.mDrawSize, this.mPaint);
            canvas.restoreToCount(save2);
        }
        if ((this.mPosition & 8) != 0) {
            int save3 = canvas.save();
            canvas.rotate(270.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            float f17 = i3;
            canvas.translate(0.0f, f17);
            canvas.drawRect(-f17, 0.0f, this.mWidth + i3, this.mDrawSize, this.mPaint);
            canvas.restoreToCount(save3);
        }
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        b();
        this.mWidth = getWidth();
        this.mHeight = getHeight();
    }

    public final void setGradientColors(@NotNull int[] gradientColors) {
        Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
        this.mGradientColors = gradientColors;
    }

    public final void setPositionAndDrawSize(int position, float drawSize) {
        this.mPosition = position;
        this.mDrawSize = drawSize;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLiveMsgListFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildLiveMsgListFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildLiveMsgListFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGradientPosition = new float[]{0.0f, 1.0f};
        this.mGradientColors = new int[]{-1, 0};
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
