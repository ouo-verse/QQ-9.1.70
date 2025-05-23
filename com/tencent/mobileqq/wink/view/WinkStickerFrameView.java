package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.videocut.model.SizeF;
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkStickerFrameView extends View {
    private RectF C;
    private boolean D;
    private boolean E;
    private Boolean F;
    private WinkStickerModel G;
    private WinkStickerModel H;
    private final Bitmap I;
    private final Bitmap J;
    private final Bitmap K;
    private final Bitmap L;

    /* renamed from: d, reason: collision with root package name */
    private float f326909d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f326910e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f326911f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f326912h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f326913i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f326914m;

    public WinkStickerFrameView(Context context) {
        this(context, null);
    }

    public static void b(View view, WinkStickerModel winkStickerModel, RectF rectF, @Nullable WinkStickerModel winkStickerModel2, @Nullable RectF rectF2, Float f16, Boolean bool) {
        Map<String, String> map;
        int intValue;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        c(rectF, winkStickerModel, view, bool);
        int measuredWidth = view.getMeasuredWidth();
        view.getMeasuredHeight();
        MetaMaterial material = winkStickerModel.getMaterial();
        if (material != null && (map = material.additionalFields) != null && map.containsKey("pagViewWidth") && (intValue = Integer.valueOf(material.additionalFields.get("pagViewWidth")).intValue()) > 0) {
            if (material.additionalFields.containsKey("pagViewCenterX")) {
                Float.valueOf(material.additionalFields.get("pagViewCenterX")).floatValue();
            }
            if (material.additionalFields.containsKey("pagViewCenterY")) {
                f17 = Float.valueOf(material.additionalFields.get("pagViewCenterY")).floatValue();
            } else {
                f17 = 0.0f;
            }
            if (material.additionalFields.containsKey("textBoundsTop")) {
                f18 = Float.valueOf(material.additionalFields.get("textBoundsTop")).floatValue();
            } else {
                f18 = 0.0f;
            }
            if (material.additionalFields.containsKey("textBoundsBottom")) {
                f19 = Float.valueOf(material.additionalFields.get("textBoundsBottom")).floatValue();
            } else {
                f19 = 0.0f;
            }
            if (material.additionalFields.containsKey("textBoundsLeft")) {
                f26 = Float.valueOf(material.additionalFields.get("textBoundsLeft")).floatValue();
            } else {
                f26 = 0.0f;
            }
            if (material.additionalFields.containsKey("textBoundsRight")) {
                f27 = Float.valueOf(material.additionalFields.get("textBoundsRight")).floatValue();
            } else {
                f27 = 0.0f;
            }
            float f28 = measuredWidth;
            float f29 = ((f28 / (intValue + 0.0f)) * winkStickerModel.scaleX) / 0.8f;
            float f36 = rectF.right;
            float floatValue = (f27 - f26) * f29 * f16.floatValue();
            if (floatValue < f28 && floatValue + 60.0f >= f28) {
                floatValue = (f28 - 60.0f) - 2.0f;
            }
            float floatValue2 = (f19 - f18) * f29 * f16.floatValue();
            float f37 = (rectF.left + rectF.right) / 2.0f;
            float f38 = ((rectF.top + rectF.bottom) / 2.0f) + ((((f19 + f18) / 2.0f) - f17) * f29);
            float D = ((f37 - (floatValue * 0.5f)) - 30.0f) - ((float) com.tencent.mobileqq.wink.editor.sticker.m.D(material));
            rectF.left = D;
            rectF.top = (f38 - (0.5f * floatValue2)) - 30.0f;
            rectF.right = D + floatValue + 60.0f + ((float) com.tencent.mobileqq.wink.editor.sticker.m.E(material)) + ((float) com.tencent.mobileqq.wink.editor.sticker.m.D(material));
            rectF.bottom = rectF.top + floatValue2 + 60.0f;
        }
        if (winkStickerModel2 != null && rectF2 != null) {
            c(rectF2, winkStickerModel2, view, bool);
        }
    }

    private static void c(RectF rectF, WinkStickerModel winkStickerModel, View view, Boolean bool) {
        float f16;
        float f17;
        float f18 = (winkStickerModel.centerX + 1.0f) / 2.0f;
        float f19 = ((-winkStickerModel.centerY) + 1.0f) / 2.0f;
        SizeF a16 = com.tencent.mobileqq.wink.editor.sticker.n.a(winkStickerModel, view, bool.booleanValue());
        float measuredWidth = view.getMeasuredWidth();
        float measuredHeight = view.getMeasuredHeight();
        Matrix f26 = com.tencent.mobileqq.wink.editor.sticker.n.f(a16, new SizeF(measuredWidth, measuredHeight, ByteString.EMPTY));
        float[] fArr = {f18 * measuredWidth, f19 * measuredHeight};
        f26.mapPoints(fArr);
        float f27 = winkStickerModel.width * winkStickerModel.scaleX;
        float f28 = a16.height;
        float f29 = (f27 * f28) / 1280.0f;
        float f36 = ((winkStickerModel.height * winkStickerModel.scaleY) * f28) / 1280.0f;
        if (f29 < f36) {
            float f37 = winkStickerModel.frameScale;
            f17 = f29 * f37;
            f16 = f36 + ((f37 - 1.0f) * f17);
        } else {
            float f38 = winkStickerModel.frameScale;
            f16 = f36 * f38;
            f17 = f29 + ((f38 - 1.0f) * f16);
        }
        float f39 = fArr[0];
        float f46 = f17 / 2.0f;
        rectF.left = f39 - f46;
        float f47 = fArr[1];
        float f48 = f16 / 2.0f;
        rectF.top = f47 - f48;
        rectF.right = f39 + f46;
        rectF.bottom = f47 + f48;
    }

    private void d(Canvas canvas) {
        PointF j3 = j(this.G);
        float f16 = j3.f320587x;
        float f17 = j3.f320588y;
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.rotate(-this.G.rotate, f16, f17);
        this.C.left = this.f326911f.left - (this.L.getWidth() / 2.0f);
        this.C.right = this.f326911f.left + (this.L.getWidth() / 2.0f);
        this.C.top = this.f326911f.bottom - (this.L.getHeight() / 2.0f);
        this.C.bottom = this.f326911f.bottom + (this.L.getHeight() / 2.0f);
        canvas.drawBitmap(this.L, (Rect) null, this.C, (Paint) null);
        canvas.getMatrix().mapRect(this.C);
        canvas.restore();
    }

    private void e(Canvas canvas) {
        PointF j3 = j(this.G);
        float f16 = j3.f320587x;
        float f17 = j3.f320588y;
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.rotate(-this.G.rotate, f16, f17);
        this.f326914m.left = this.f326911f.left - (this.K.getWidth() / 2.0f);
        this.f326914m.right = this.f326911f.left + (this.K.getWidth() / 2.0f);
        this.f326914m.top = this.f326911f.top - (this.K.getHeight() / 2.0f);
        this.f326914m.bottom = this.f326911f.top + (this.K.getHeight() / 2.0f);
        canvas.drawBitmap(this.K, (Rect) null, this.f326914m, (Paint) null);
        canvas.getMatrix().mapRect(this.f326914m);
        canvas.restore();
    }

    private void f(Canvas canvas, Boolean bool) {
        PointF j3 = j(this.G);
        float f16 = j3.f320587x;
        float f17 = j3.f320588y;
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.rotate(-this.G.rotate, f16, f17);
        this.f326913i.left = this.f326911f.right - (this.I.getWidth() / 2.0f);
        this.f326913i.right = this.f326911f.right + (this.I.getWidth() / 2.0f);
        this.f326913i.top = this.f326911f.bottom - (this.I.getWidth() / 2.0f);
        this.f326913i.bottom = this.f326911f.bottom + (this.I.getWidth() / 2.0f);
        if (bool.booleanValue()) {
            canvas.drawBitmap(this.J, (Rect) null, this.f326913i, (Paint) null);
        } else {
            canvas.drawBitmap(this.I, (Rect) null, this.f326913i, (Paint) null);
        }
        canvas.getMatrix().mapRect(this.f326913i);
        canvas.restore();
    }

    private PointF j(WinkStickerModel winkStickerModel) {
        float[] fArr = {l(winkStickerModel), n(winkStickerModel)};
        com.tencent.mobileqq.wink.editor.sticker.n.f(com.tencent.mobileqq.wink.editor.sticker.n.a(winkStickerModel, this, this.F.booleanValue()), new SizeF(getMeasuredWidth() * 1.0f, getMeasuredHeight() * 1.0f, ByteString.EMPTY)).mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    private void p() {
        this.f326909d = com.tencent.mobileqq.util.x.c(getContext(), 4.0f);
        Paint paint = new Paint(1);
        this.f326910e = paint;
        paint.setStrokeWidth(com.tencent.mobileqq.util.x.c(getContext(), 2.0f));
        this.f326910e.setStyle(Paint.Style.STROKE);
        this.f326910e.setColor(-1);
        this.f326911f = new RectF();
        this.f326912h = new RectF();
        this.f326913i = new RectF();
        this.f326914m = new RectF();
        this.C = new RectF();
    }

    private void q() {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, this.G.getMaterial().f30533id);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(this.G.getMaterial()));
        VideoReport.setElementId(this, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_COPYRIGHT_NOTICE);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", this, buildElementParams);
    }

    private void r() {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_DELETE_CROSS_BUTTON);
        WinkStickerModel winkStickerModel = this.G;
        if (winkStickerModel != null && winkStickerModel.isTextSticker()) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR);
        } else {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_DELETE_BUTTON_TYPE, "paste");
        }
        VideoReport.setElementId(this, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_DELETE_CROSS_BUTTON);
        VideoReport.reportEvent("dt_imp", this, buildElementParams);
    }

    public void a(WinkStickerModel winkStickerModel, WinkStickerModel winkStickerModel2, Float f16) {
        this.G = winkStickerModel;
        this.H = winkStickerModel2;
        b(this, winkStickerModel, this.f326911f, winkStickerModel2, this.f326912h, f16, this.F);
        invalidate();
    }

    public RectF g() {
        return this.C;
    }

    public RectF h() {
        return this.f326914m;
    }

    public RectF i() {
        return this.f326911f;
    }

    public float k() {
        return l(this.G);
    }

    public float l(WinkStickerModel winkStickerModel) {
        float f16;
        if (winkStickerModel != null) {
            f16 = (winkStickerModel.centerX + 1.0f) / 2.0f;
        } else {
            f16 = 0.5f;
        }
        return f16 * getMeasuredWidth();
    }

    public float m() {
        return n(this.G);
    }

    public float n(WinkStickerModel winkStickerModel) {
        float f16;
        if (winkStickerModel != null) {
            f16 = ((-winkStickerModel.centerY) + 1.0f) / 2.0f;
        } else {
            f16 = 0.5f;
        }
        return f16 * getMeasuredHeight();
    }

    public RectF o() {
        return this.f326913i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        WinkStickerModel winkStickerModel = this.G;
        if (winkStickerModel == null) {
            return;
        }
        PointF j3 = j(winkStickerModel);
        float f16 = j3.f320587x;
        float f17 = j3.f320588y;
        canvas.save();
        canvas.rotate(-this.G.rotate, f16, f17);
        RectF rectF = this.f326911f;
        float f18 = this.f326909d;
        canvas.drawRoundRect(rectF, f18, f18, this.f326910e);
        canvas.restore();
        WinkStickerModel winkStickerModel2 = this.H;
        if (winkStickerModel2 != null) {
            PointF j16 = j(winkStickerModel2);
            float f19 = j16.f320587x;
            float f26 = j16.f320588y;
            canvas.save();
            canvas.rotate(-this.H.rotate, f19, f26);
            RectF rectF2 = this.f326912h;
            float f27 = this.f326909d;
            canvas.drawRoundRect(rectF2, f27, f27, this.f326910e);
            canvas.restore();
        }
        if (com.tencent.mobileqq.wink.editor.sticker.m.N(this.G.getMaterial())) {
            f(canvas, Boolean.TRUE);
        } else {
            f(canvas, Boolean.FALSE);
        }
        if (this.D) {
            e(canvas);
            r();
        }
        if (this.E) {
            d(canvas);
            q();
        }
    }

    public void setEnableCreatorBtn(Boolean bool) {
        this.E = bool.booleanValue();
    }

    public void setEnableDeleteBtn(Boolean bool) {
        this.D = bool.booleanValue();
    }

    public void setIsCover(Boolean bool) {
        this.F = bool;
    }

    public WinkStickerFrameView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WinkStickerFrameView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = false;
        this.E = false;
        this.F = Boolean.FALSE;
        this.I = BitmapFactory.decodeResource(getResources(), R.drawable.oeq);
        this.J = BitmapFactory.decodeResource(getResources(), R.drawable.f162692ox3);
        this.K = BitmapFactory.decodeResource(getResources(), R.drawable.oep);
        this.L = BitmapFactory.decodeResource(getResources(), R.drawable.f162691ox2);
        p();
    }
}
