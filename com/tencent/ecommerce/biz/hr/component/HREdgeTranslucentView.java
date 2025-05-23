package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B\u000f\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0014J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010#R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0014\u0010&\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0014\u0010(\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u0016\u0010*\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010,\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HREdgeTranslucentView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Li01/c;", "", "propValue", "", "M", "L", "K", "", "propKey", "", "b", "", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/view/View;", "child", "", "drawingTime", "drawChild", "Landroid/graphics/Paint;", "H", "Landroid/graphics/Paint;", "mTopPaint", "I", "mBottomPaint", "J", "position", "", UserInfo.SEX_FEMALE, "edgeTop", "edgeBottom", "topMask", "N", "bottomMask", "P", "mWidth", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mHeight", "", BdhLogUtil.LogTag.Tag_Req, "[I", "mGradientColors", "", ExifInterface.LATITUDE_SOUTH, "[F", "mGradientPosition", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "T", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HREdgeTranslucentView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private Paint mTopPaint;

    /* renamed from: I, reason: from kotlin metadata */
    private Paint mBottomPaint;

    /* renamed from: J, reason: from kotlin metadata */
    private int position;

    /* renamed from: K, reason: from kotlin metadata */
    private float edgeTop;

    /* renamed from: L, reason: from kotlin metadata */
    private float edgeBottom;

    /* renamed from: M, reason: from kotlin metadata */
    private final int topMask;

    /* renamed from: N, reason: from kotlin metadata */
    private final int bottomMask;

    /* renamed from: P, reason: from kotlin metadata */
    private float mWidth;

    /* renamed from: Q, reason: from kotlin metadata */
    private float mHeight;

    /* renamed from: R, reason: from kotlin metadata */
    private final int[] mGradientColors;

    /* renamed from: S, reason: from kotlin metadata */
    private final float[] mGradientPosition;

    public HREdgeTranslucentView(Context context) {
        super(context);
        this.mTopPaint = new Paint(1);
        this.mBottomPaint = new Paint(1);
        this.topMask = 1;
        this.bottomMask = 1 << 1;
        this.mTopPaint.setStyle(Paint.Style.FILL);
        this.mTopPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mBottomPaint.setStyle(Paint.Style.FILL);
        this.mBottomPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mGradientColors = new int[]{-1, 0};
        this.mGradientPosition = new float[]{0.0f, 1.0f};
    }

    private final void K() {
        this.mTopPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mHeight * this.edgeTop, this.mGradientColors, this.mGradientPosition, Shader.TileMode.CLAMP));
        this.mBottomPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mHeight * this.edgeBottom, this.mGradientColors, this.mGradientPosition, Shader.TileMode.CLAMP));
    }

    private final void L(Object propValue) {
        if (!(propValue instanceof Float)) {
            propValue = null;
        }
        Float f16 = (Float) propValue;
        if (f16 != null) {
            this.edgeTop = f16.floatValue();
            this.position = this.topMask;
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, Object propValue) {
        int hashCode = propKey.hashCode();
        if (hashCode != -1890277800) {
            if (hashCode == 1892163434 && propKey.equals("edgeTopAndBottom")) {
                M(propValue);
                return true;
            }
        } else if (propKey.equals("edgeTop")) {
            L(propValue);
            return true;
        }
        return super.b(propKey, propValue);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        boolean drawChild = super.drawChild(canvas, child, drawingTime);
        int i3 = this.position;
        if (i3 == 0 || (i3 & this.topMask) != 0) {
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.edgeTop * this.mHeight, this.mTopPaint);
        }
        int i16 = this.position;
        if (i16 == 0 || (i16 & this.bottomMask) != 0) {
            int save = canvas.save();
            canvas.rotate(180.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.edgeBottom * this.mHeight, this.mBottomPaint);
            canvas.restoreToCount(save);
        }
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    private final void M(Object propValue) {
        List split$default;
        if (propValue != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) propValue, new String[]{" "}, false, 0, 6, (Object) null);
            if (split$default.size() != 2) {
                return;
            }
            this.edgeTop = Float.parseFloat((String) split$default.get(0));
            this.edgeBottom = Float.parseFloat((String) split$default.get(1));
            this.position = this.topMask & this.bottomMask;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
