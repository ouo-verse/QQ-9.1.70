package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleMagicAlgoHandler;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends VideoFilterBase {

    /* renamed from: o, reason: collision with root package name */
    public static final String f68379o = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksAndLighterVertexShader.dat");

    /* renamed from: q, reason: collision with root package name */
    public static final String f68380q = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/DoodleFireworksFragmentShader.dat");

    /* renamed from: r, reason: collision with root package name */
    public static final float[] f68381r = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    Point f68382a;

    /* renamed from: b, reason: collision with root package name */
    int f68383b;

    /* renamed from: c, reason: collision with root package name */
    int f68384c;

    /* renamed from: d, reason: collision with root package name */
    int[] f68385d;

    /* renamed from: e, reason: collision with root package name */
    Frame f68386e;

    /* renamed from: f, reason: collision with root package name */
    int f68387f;

    /* renamed from: g, reason: collision with root package name */
    boolean f68388g;

    /* renamed from: h, reason: collision with root package name */
    float f68389h;

    /* renamed from: i, reason: collision with root package name */
    Queue<DoodleMagicAlgoHandler.RenderPoint> f68390i;

    /* renamed from: j, reason: collision with root package name */
    int f68391j;

    /* renamed from: k, reason: collision with root package name */
    boolean f68392k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f68393l;

    /* renamed from: m, reason: collision with root package name */
    float f68394m;

    /* renamed from: n, reason: collision with root package name */
    float f68395n;

    public i() {
        super(f68379o, f68380q);
        this.f68385d = new int[1];
        this.f68386e = new Frame();
        this.f68387f = -1;
        this.f68389h = 0.35f;
        this.f68390i = new LinkedBlockingDeque();
        this.f68391j = 0;
        this.f68392k = false;
        this.f68393l = false;
        initParams();
    }

    private void g() {
        super.addParam(new UniformParam.IntParam("drawType", 0));
        super.setTexCords(new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f});
        super.addAttribParam(new AttributeParam("inputBlendAlpha", f68381r, 1));
    }

    private void h(DoodleMagicAlgoHandler.RenderPoint renderPoint, int i3) {
        super.addParam(new UniformParam.IntParam("drawType", i3));
        int length = renderPoint.xList.length;
        float[] fArr = new float[length * 2];
        float[] fArr2 = new float[length];
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            float[] fArr3 = renderPoint.aList;
            if (fArr3[i18] > 0.8f) {
                int i19 = i16 + 1;
                fArr[i16] = renderPoint.xList[i18];
                i16 = i19 + 1;
                fArr[i19] = renderPoint.yList[i18];
                fArr2[i17] = fArr3[i18];
                i17++;
            }
        }
        for (int i26 = 0; i26 < length; i26++) {
            float[] fArr4 = renderPoint.aList;
            if (fArr4[i26] <= 0.8f) {
                int i27 = i16 + 1;
                fArr[i16] = renderPoint.xList[i26];
                i16 = i27 + 1;
                fArr[i27] = renderPoint.yList[i26];
                fArr2[i17] = fArr4[i26];
                i17++;
            }
        }
        super.setPositions(fArr);
        super.setTexCords(fArr);
        super.addAttribParam(new AttributeParam("inputBlendAlpha", fArr2, 1));
        super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0f, 0.0f));
        super.addParam(new UniformParam.FloatParam("texScale", 1.0f));
        super.addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        if (this.f68393l) {
            return;
        }
        this.f68393l = true;
        super.ApplyGLSLFilter();
    }

    public void b() {
        if (this.f68388g) {
            return;
        }
        int[] iArr = this.f68385d;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        this.f68386e.bindFrame(this.f68385d[0], this.f68383b, this.f68384c, 1.0d);
        this.f68387f = this.f68386e.getTextureId();
        this.f68388g = true;
    }

    public void c(int i3, int i16, int i17) {
        super.setPositions(AlgoUtils.calPositions(0.0f, this.f68384c, this.f68383b + 0.0f, 0.0f, i16, i17));
        Point point = this.f68382a;
        super.addParam(new UniformParam.Float2fParam("texAnchor", point.x, point.y));
        super.addParam(new UniformParam.FloatParam("texScale", 1.0f));
        super.addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
        GLES20.glFlush();
        super.OnDrawFrameGLSL();
        super.renderTexture(i3, i16, i17);
    }

    public void e(int i3) {
        UniformParam.TextureParam textureParam = new UniformParam.TextureParam("inputImageTexture2", this.f68387f, 33986);
        textureParam.initialParams(super.getProgramIds());
        super.addParam(textureParam);
        super.addParam(new UniformParam.IntParam("drawType", 0));
        c(i3, this.f68383b, this.f68384c);
    }

    public void f(DoodleMagicAlgoHandler.RenderPoint renderPoint) {
        if (renderPoint.xList.length != 0) {
            this.f68390i.add(renderPoint);
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initAttribParams() {
        super.initAttribParams();
        super.addAttribParam(new AttributeParam("inputBlendAlpha", f68381r, 1));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        super.addParam(new UniformParam.IntParam("texNeedTransform", 1));
        super.addParam(new UniformParam.Float2fParam("canvasSize", 0.0f, 0.0f));
        super.addParam(new UniformParam.Float2fParam("texAnchor", 0.0f, 0.0f));
        super.addParam(new UniformParam.FloatParam("texScale", 1.0f));
        super.addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
        super.addParam(new UniformParam.FloatParam("positionRotate", 0.0f));
        super.addParam(new UniformParam.IntParam(com.tencent.luggage.wxa.c8.c.W, -1));
        super.addParam(new UniformParam.IntParam("drawType", 0));
        super.addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void updateVideoSize(int i3, int i16, double d16) {
        super.updateVideoSize(i3, i16, d16);
        this.f68382a = new Point(i3 / 2, i16 / 2);
        this.f68383b = i3;
        this.f68384c = i16;
        super.addParam(new UniformParam.Float2fParam("canvasSize", i3, i16));
        DoodleMagicAlgoHandler.OnUpdateSize(this.f68383b, this.f68384c, this.f68389h);
        DoodleMagicAlgoHandler.setFilter(this);
    }

    public void a(DoodleMagicAlgoHandler.RenderPoint renderPoint) {
        h(renderPoint, 4);
        super.OnDrawFrameGLSL();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f68387f);
        GLES20.glDrawArrays(5, 0, renderPoint.xList.length);
        GLES20.glFlush();
        g();
    }

    public boolean d(List<PointF> list, boolean z16, l lVar) {
        GLES20.glBlendFuncSeparate(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, 1);
        this.f68386e.bindFrame(this.f68385d[0], this.f68383b, this.f68384c, 1.0d);
        GLES20.glBindFramebuffer(36160, this.f68386e.getFBO());
        GLES20.glViewport(0, 0, this.f68383b, this.f68384c);
        if (this.f68391j == 0 && this.f68388g) {
            this.f68386e.bindFrame(this.f68385d[0], this.f68383b, this.f68384c, 1.0d);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glFlush();
        }
        for (int i3 = this.f68391j; i3 < list.size(); i3++) {
            PointF pointF = list.get(i3);
            float f16 = pointF.x;
            Point point = this.f68382a;
            PointF pointF2 = new PointF(f16 + point.x, pointF.y + point.y);
            if (i3 == 0) {
                float f17 = pointF2.x;
                this.f68394m = f17;
                float f18 = pointF2.y;
                this.f68395n = f18;
                DoodleMagicAlgoHandler.onTouchEvent(0, f17, f18);
            } else {
                DoodleMagicAlgoHandler.onTouchEvent(1, pointF2.x, pointF2.y);
            }
        }
        if (z16) {
            PointF pointF3 = list.get(list.size() - 1);
            PointF pointF4 = new PointF(this.f68383b / 2, this.f68384c / 2);
            PointF pointF5 = new PointF(pointF3.x + pointF4.x, pointF3.y + pointF4.y);
            float f19 = pointF5.x;
            if (f19 == this.f68394m) {
                float f26 = pointF5.y;
                if (f26 == this.f68395n) {
                    pointF5.x = f19 + 1.0f;
                    pointF5.y = f26 + 1.0f;
                }
            }
            DoodleMagicAlgoHandler.onTouchEvent(2, pointF5.x, pointF5.y);
            this.f68391j = 0;
            this.f68394m = -1.0f;
        } else {
            this.f68391j = list.size() - 1;
        }
        this.f68392k = z16;
        while (!this.f68390i.isEmpty()) {
            DoodleMagicAlgoHandler.RenderPoint poll = this.f68390i.poll();
            if (poll != null) {
                lVar.f68418m.add(poll);
                a(poll);
            }
        }
        return true;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean renderTexture(int i3, int i16, int i17) {
        GLES20.glBlendFuncSeparate(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, 1, 1);
        UniformParam.TextureParam textureParam = new UniformParam.TextureParam("inputImageTexture2", this.f68387f, 33986);
        textureParam.initialParams(super.getProgramIds());
        super.addParam(textureParam);
        c(i3, this.f68383b, this.f68384c);
        return true;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase, com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
    }
}
