package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends VideoFilterBase {

    /* renamed from: a, reason: collision with root package name */
    List<List<PointF>> f68401a;

    /* renamed from: b, reason: collision with root package name */
    Point f68402b;

    /* renamed from: c, reason: collision with root package name */
    List<Bitmap> f68403c;

    /* renamed from: d, reason: collision with root package name */
    protected UniformParam.TextureBitmapParam f68404d;

    /* renamed from: e, reason: collision with root package name */
    int f68405e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f68406f;

    private void a() {
        List<Bitmap> list = this.f68403c;
        int i3 = this.f68405e;
        this.f68405e = i3 + 1;
        Bitmap bitmap = list.get(i3 % list.size());
        UniformParam.TextureBitmapParam textureBitmapParam = this.f68404d;
        if (textureBitmapParam != null) {
            textureBitmapParam.swapTextureBitmap(bitmap);
            return;
        }
        UniformParam.TextureBitmapParam textureBitmapParam2 = new UniformParam.TextureBitmapParam("inputImageTexture2", bitmap, 33986, false);
        this.f68404d = textureBitmapParam2;
        textureBitmapParam2.initialParams(super.getProgramIds());
        super.addParam(this.f68404d);
    }

    private double b(PointF pointF, PointF pointF2) {
        float f16 = pointF.x;
        float f17 = pointF2.x;
        float f18 = pointF.y;
        float f19 = pointF2.y;
        return Math.sqrt(((f16 - f17) * (f16 - f17)) + ((f18 - f19) * (f18 - f19)));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        if (this.f68406f) {
            return;
        }
        this.f68406f = true;
        super.ApplyGLSLFilter();
    }

    public void c(List<PointF> list) {
        this.f68401a = new ArrayList(1);
        if (this.f68403c.size() < 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : list) {
            float f16 = pointF.x;
            Point point = this.f68402b;
            arrayList.add(new PointF(f16 + point.x, pointF.y + point.y));
        }
        this.f68401a.add(arrayList);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initAttribParams() {
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        setTexCords(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f});
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
        super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
        super.addParam(new UniformParam.FloatParam(com.tencent.luggage.wxa.c8.c.f123400v, 1.0f));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean renderTexture(int i3, int i16, int i17) {
        List<List<PointF>> list = this.f68401a;
        if (list == null || list.size() < 1 || this.f68401a.get(0).size() < 1) {
            return false;
        }
        this.f68405e = 0;
        PointF pointF = null;
        for (int i18 = 0; i18 < this.f68401a.size(); i18++) {
            int i19 = 0;
            while (i19 < this.f68401a.get(i18).size()) {
                PointF pointF2 = this.f68401a.get(i18).get(i19);
                if (pointF != null) {
                    b(pointF2, pointF);
                }
                a();
                int i26 = this.width;
                float f16 = i26;
                int i27 = this.height;
                float f17 = i27;
                float f18 = pointF2.x - (f16 / 2.0f);
                float f19 = (f17 / 2.0f) + (i27 - pointF2.y);
                super.setPositions(AlgoUtils.calPositions(f18, f19, f16 + f18, f19 - f17, i26, i27));
                Point point = this.f68402b;
                super.addParam(new UniformParam.Float2fParam("texAnchor", -point.x, point.y));
                super.addParam(new UniformParam.FloatParam("texScale", 1.0f));
                super.addParam(new UniformParam.FloatParam("texScaleX", 1.0f));
                super.addParam(new UniformParam.FloatParam("texScaleY", 1.0f));
                super.addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
                GLES20.glFlush();
                super.OnDrawFrameGLSL();
                super.renderTexture(i3, this.width, this.height);
                i19++;
                pointF = pointF2;
            }
        }
        return true;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void updateVideoSize(int i3, int i16, double d16) {
        super.updateVideoSize(i3, i16, d16);
        this.f68402b = new Point(i3 / 2, i16 / 2);
        super.addParam(new UniformParam.Float2fParam("canvasSize", i3, i16));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase, com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
    }
}
