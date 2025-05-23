package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j extends VideoFilterBase {

    /* renamed from: a, reason: collision with root package name */
    List<PointF> f68396a;

    /* renamed from: b, reason: collision with root package name */
    Point f68397b;

    /* renamed from: c, reason: collision with root package name */
    List<Bitmap> f68398c;

    /* renamed from: d, reason: collision with root package name */
    protected UniformParam.TextureBitmapParam f68399d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f68400e;

    private void b() {
        Bitmap bitmap = this.f68398c.get(0);
        UniformParam.TextureBitmapParam textureBitmapParam = this.f68399d;
        if (textureBitmapParam != null) {
            textureBitmapParam.swapTextureBitmap(bitmap);
            return;
        }
        UniformParam.TextureBitmapParam textureBitmapParam2 = new UniformParam.TextureBitmapParam("inputImageTexture2", bitmap, 33986, false);
        this.f68399d = textureBitmapParam2;
        textureBitmapParam2.initialParams(super.getProgramIds());
        super.addParam(this.f68399d);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        if (this.f68400e) {
            return;
        }
        this.f68400e = true;
        super.ApplyGLSLFilter();
    }

    PointF a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, float f16) {
        PointF pointF5 = new PointF((pointF3.x - pointF.x) * 0.5f, (pointF3.y - pointF.y) * 0.5f);
        float f17 = pointF3.x;
        float f18 = pointF2.x;
        float f19 = (((f17 - f18) * 3.0f) - ((pointF4.x - f18) * 0.5f)) - ((f17 - pointF.x) * 1.0f);
        float f26 = pointF3.y;
        float f27 = pointF2.y;
        PointF pointF6 = new PointF(f19, (((f26 - f27) * 3.0f) - ((pointF4.y - f27) * 0.5f)) - (1.0f * (f26 - pointF.y)));
        float f28 = pointF3.x;
        float f29 = pointF2.x;
        float f36 = ((f28 - f29) * (-2.0f)) + ((pointF4.x - f29) * 0.5f) + ((f28 - pointF.x) * 0.5f);
        float f37 = pointF3.y;
        float f38 = pointF2.y;
        PointF pointF7 = new PointF(f36, ((f37 - f38) * (-2.0f)) + ((pointF4.y - f38) * 0.5f) + ((f37 - pointF.y) * 0.5f));
        return new PointF((pointF7.x * f16 * f16 * f16) + (pointF6.x * f16 * f16) + (pointF5.x * f16) + pointF2.x, (pointF7.y * f16 * f16 * f16) + (pointF6.y * f16 * f16) + (pointF5.y * f16) + pointF2.y);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006b, code lost:
    
        if (r2 < 0.01f) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void c(ArrayList<PointF> arrayList) {
        float f16 = this.width;
        for (int i3 = 3; i3 < this.f68396a.size(); i3++) {
            int i16 = i3 - 3;
            int i17 = i3 - 2;
            int i18 = i3 - 1;
            float b16 = 1.0f / ((((int) (((((float) m.b(this.f68396a.get(i16), this.f68396a.get(i17))) + ((float) m.b(this.f68396a.get(i17), this.f68396a.get(i18)))) + ((float) m.b(this.f68396a.get(i18), this.f68396a.get(i3)))) / f16)) * 12) * 1.0f);
            float f17 = b16 <= 0.1f ? 0.01f : 0.1f;
            b16 = f17;
            for (float f18 = 0.0f; f18 < 1.0f; f18 += b16) {
                arrayList.add(a(this.f68396a.get(i16), this.f68396a.get(i17), this.f68396a.get(i18), this.f68396a.get(i3), f18));
            }
        }
    }

    public void e(List<PointF> list) {
        this.f68396a.clear();
        if (this.f68398c.size() < 1) {
            return;
        }
        b();
        for (PointF pointF : list) {
            float f16 = pointF.x;
            Point point = this.f68397b;
            this.f68396a.add(new PointF(f16 + point.x, pointF.y + point.y));
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        super.addParam(new UniformParam.IntParam("texNeedTransform", 1));
        super.addParam(new UniformParam.Float2fParam("canvasSize", 0.0f, 0.0f));
        super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0f, 0.0f));
        super.addParam(new UniformParam.FloatParam("texScale", 1.0f));
        super.addParam(new UniformParam.FloatParam("texScaleX", 1.0f));
        super.addParam(new UniformParam.FloatParam("texScaleY", 1.0f));
        super.addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
        super.addParam(new UniformParam.FloatParam("positionRotate", 0.0f));
        super.addParam(new UniformParam.FloatParam(com.tencent.luggage.wxa.c8.c.f123400v, 1.0f));
        super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void updateVideoSize(int i3, int i16, double d16) {
        super.updateVideoSize(i3, i16, d16);
        this.f68397b = new Point(i3 / 2, i16 / 2);
        super.addParam(new UniformParam.Float2fParam("canvasSize", i3, i16));
    }

    public boolean d() {
        List<PointF> list = this.f68396a;
        if (list == null || list.size() < 1) {
            return false;
        }
        System.currentTimeMillis();
        m.e(2);
        float f16 = this.width;
        float f17 = this.height;
        ArrayList<PointF> arrayList = new ArrayList<>();
        int i3 = this.f68396a.size() <= 3 ? 3 : 2;
        for (int i16 = 0; i16 < this.f68396a.size() && i16 < i3; i16++) {
            if (i16 > 0) {
                PointF pointF = this.f68396a.get(i16 - 1);
                PointF pointF2 = this.f68396a.get(i16);
                int b16 = ((int) ((((float) m.b(pointF, pointF2)) / f16) * 18.0f)) + 1;
                if (b16 < 6) {
                    b16 = 6;
                }
                float f18 = b16 * 1.0f;
                float f19 = (pointF2.x - pointF.x) / f18;
                float f26 = (pointF2.y - pointF.y) / f18;
                for (int i17 = 0; i17 < b16; i17++) {
                    float f27 = i17;
                    arrayList.add(new PointF(pointF.x + (f19 * f27), pointF.y + (f27 * f26)));
                }
                if (!arrayList.get(arrayList.size() - 1).equals(pointF2.x, pointF2.y)) {
                    arrayList.add(pointF);
                }
            }
        }
        if (this.f68396a.size() > 3) {
            c(arrayList);
        }
        float[] fArr = new float[arrayList.size() * 8];
        float[] fArr2 = new float[arrayList.size() * 8];
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            PointF pointF3 = arrayList.get(i18);
            float f28 = pointF3.x - (f16 / 2.0f);
            int i19 = this.height;
            float f29 = (i19 - pointF3.y) + (f17 / 2.0f);
            float f36 = f28 + f16;
            float f37 = f29 - f17;
            int i26 = this.width;
            float f38 = ((f28 / i26) * 2.0f) - 1.0f;
            float f39 = ((f29 / i19) * 2.0f) - 1.0f;
            float f46 = ((f36 / i26) * 2.0f) - 1.0f;
            float f47 = ((f37 / i19) * 2.0f) - 1.0f;
            int i27 = i18 * 8;
            int i28 = i27 + 0;
            fArr[i28] = f38;
            int i29 = i27 + 1;
            fArr[i29] = f47;
            int i36 = i27 + 2;
            fArr[i36] = f46;
            int i37 = i27 + 3;
            fArr[i37] = f47;
            int i38 = i27 + 4;
            fArr[i38] = f38;
            int i39 = i27 + 5;
            fArr[i39] = f39;
            int i46 = i27 + 6;
            fArr[i46] = f46;
            int i47 = i27 + 7;
            fArr[i47] = f39;
            fArr2[i28] = 0.0f;
            fArr2[i29] = 1.0f;
            fArr2[i36] = 1.0f;
            fArr2[i37] = 1.0f;
            fArr2[i38] = 0.0f;
            fArr2[i39] = 0.0f;
            fArr2[i46] = 1.0f;
            fArr2[i47] = 0.0f;
        }
        super.setPositions(fArr);
        super.setTexCords(fArr2);
        Point point = this.f68397b;
        super.addParam(new UniformParam.Float2fParam("texAnchor", -point.x, point.y));
        super.addParam(new UniformParam.FloatParam("texScale", 1.0f));
        super.addParam(new UniformParam.FloatParam("texScaleX", 1.0f));
        super.addParam(new UniformParam.FloatParam("texScaleY", 1.0f));
        super.addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
        super.OnDrawFrameGLSL();
        GLES20.glDrawArrays(5, 0, arrayList.size() * 4);
        GLES20.glFlush();
        m.e(0);
        System.currentTimeMillis();
        return true;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase, com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
    }
}
