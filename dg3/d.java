package dg3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioTrack;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.text.TextUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.gyailib.library.ValidFacePhotoQuality;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.zplan.cc.util.i;
import com.tencent.mobileqq.zplan.cc.util.o;
import com.tencent.mobileqq.zplan.cc.util.q;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.AudioOutput;
import org.light.CameraConfig;
import org.light.CameraController;
import org.light.Config;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.RendererConfig;
import org.light.VideoOutput;
import org.light.bean.LightFaceData;
import org.light.device.ApiHelper;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d implements GLSurfaceView.Renderer {

    /* renamed from: q0, reason: collision with root package name */
    public static final String f393774q0 = "d";

    /* renamed from: r0, reason: collision with root package name */
    static final float[] f393775r0 = {1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};

    /* renamed from: s0, reason: collision with root package name */
    static final float[] f393776s0 = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: t0, reason: collision with root package name */
    static FloatBuffer f393777t0;

    /* renamed from: u0, reason: collision with root package name */
    static FloatBuffer f393778u0;
    private int C;
    private SurfaceTexture D;
    private g E;
    private LightEngine F;
    private VideoOutput G;
    private AudioOutput H;
    private AudioTrack I;
    private LightAsset J;
    private LightSurface K;
    private CameraConfig L;
    private CameraController M;
    private volatile String N;
    private String P;
    private volatile String Q;
    private volatile Map<String, String> R;
    private volatile Map<String, String> S;
    private volatile Map<String, String> T;
    private Context U;
    private f V;
    protected int Y;
    protected int Z;

    /* renamed from: a0, reason: collision with root package name */
    protected int f393779a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f393780b0;

    /* renamed from: c0, reason: collision with root package name */
    protected int f393781c0;

    /* renamed from: d, reason: collision with root package name */
    private int f393782d;

    /* renamed from: d0, reason: collision with root package name */
    protected int f393783d0;

    /* renamed from: g0, reason: collision with root package name */
    protected double f393788g0;

    /* renamed from: h, reason: collision with root package name */
    int f393789h;

    /* renamed from: h0, reason: collision with root package name */
    protected double f393790h0;

    /* renamed from: k0, reason: collision with root package name */
    private Bitmap f393794k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f393795l0;

    /* renamed from: m, reason: collision with root package name */
    private dg3.a f393796m;

    /* renamed from: m0, reason: collision with root package name */
    private int f393797m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f393798n0;

    /* renamed from: o0, reason: collision with root package name */
    private final int f393799o0;

    /* renamed from: p0, reason: collision with root package name */
    private eg3.a f393800p0;

    /* renamed from: e, reason: collision with root package name */
    int[] f393784e = new int[2];

    /* renamed from: f, reason: collision with root package name */
    int f393786f = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f393791i = 0;
    private boolean W = false;
    private boolean X = false;

    /* renamed from: e0, reason: collision with root package name */
    float f393785e0 = 0.0f;

    /* renamed from: f0, reason: collision with root package name */
    float f393787f0 = 0.0f;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f393792i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    private long f393793j0 = 0;

    public d(Context context, int i3, eg3.a aVar) {
        this.U = context;
        this.f393799o0 = i3;
        this.f393800p0 = aVar;
    }

    private void H() {
        if (this.S == null || this.S.isEmpty()) {
            return;
        }
        this.L.setConfigData(this.S);
        this.S = null;
    }

    private void I() {
        if (this.R == null || this.R.size() == 0) {
            return;
        }
        this.L.setConfigData(this.R);
        this.R = null;
    }

    private void J() {
        if (this.T == null) {
            return;
        }
        for (String str : this.T.keySet()) {
            this.L.setLightAIModelPath(str, this.T.get(str));
        }
        this.T = null;
    }

    private void K() {
        if (TextUtils.isEmpty(this.Q)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lut.src", this.Q);
        hashMap.put("lut.intensity", "0.8");
        this.L.setConfigData(hashMap);
        this.Q = null;
    }

    private void M() {
        if (TextUtils.isEmpty(this.N)) {
            QLog.e(f393774q0, 1, "updateTemplate templatePath is empty");
            return;
        }
        LightAsset Load = LightAsset.Load(this.N, 100);
        LightAsset lightAsset = this.J;
        if (lightAsset != null) {
            lightAsset.performFinalize();
            this.J = null;
        }
        this.J = Load;
        this.M = this.F.setAssetForCamera(Load);
        this.N = null;
        if (this.f393799o0 == 2 && this.f393795l0 == null) {
            e(false);
        }
        this.f393793j0 = System.nanoTime();
    }

    private void g(int i3, int i16) {
        if (this.W) {
            return;
        }
        this.R = new HashMap();
        this.R.put("smooth.smooth", "0.55");
        this.R.put("smooth.sharpen", Global.TRACKING_SDKVS_VALUE);
        this.S = new HashMap();
        this.S.put("ai.gender.enable", "true");
        LightLogUtil.init();
        LightLogUtil.setMinPriority(6);
        int[] iArr = this.f393784e;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        int[] iArr2 = this.f393784e;
        this.f393786f = iArr2[0];
        this.f393789h = iArr2[1];
        this.C = c(36197);
        this.f393791i = d(GLSLRender.GL_TEXTURE_2D, this.Y, this.Z);
        dg3.a aVar = new dg3.a(this.C);
        this.f393796m = aVar;
        aVar.e(this.f393791i);
        this.D = new SurfaceTexture(this.C);
        this.f393796m.f(this.f393779a0, this.f393780b0, this.f393790h0, this.f393788g0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f393789h);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 10497);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 10497);
        this.K = LightSurface.makeFromTexture(this.f393789h, i3, i16);
        int initAuth = LightEngine.initAuth(this.U, "", "lightsdk_qq", QQWinkConstants.ENTRY_QQ_ZPLAN);
        String str = f393774q0;
        QLog.e(str, 1, "LightEngine.initAuth = " + initAuth);
        String lightAssetsDir = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightAssetsDir();
        this.P = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightEmptyMaterialConfigPath();
        QLog.i(str, 1, "bundle path = " + lightAssetsDir + ", emptyTemplatePath = " + this.P);
        LightEngine make = LightEngine.make(null, null, new RendererConfig(lightAssetsDir));
        this.F = make;
        make.setSurface(this.K);
        CameraConfig make2 = CameraConfig.make();
        this.L = make2;
        this.F.setConfig(make2);
        this.G = this.F.videoOutput();
        this.H = this.F.audioOutput();
        HashMap hashMap = new HashMap();
        hashMap.put(Config.ConfigKeys.ResourceDir.value(), lightAssetsDir);
        this.L.setConfigData(hashMap);
        this.L.setRenderSize(this.Y, this.Z);
        LightAsset Load = LightAsset.Load(this.P, 100);
        this.J = Load;
        this.M = this.F.setAssetForCamera(Load);
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        if (lightBundleMap != null) {
            String str2 = AEResInfo.LIGHT_RES_BUNDLE_3DMM.agentType;
            for (String str3 : lightBundleMap.keySet()) {
                this.L.setLightAIModelPath(lightBundleMap.get(str3), str3);
                if (str2.equals(str3)) {
                    String str4 = lightBundleMap.get(str3);
                    this.L.setLightAIModelPath(str4, "k3D_MM_AGENT_V2");
                    this.L.setLightAIModelPath(str4, "kZPLAN_AGENT");
                }
            }
        }
        if (this.f393799o0 == 2) {
            h();
        }
        this.f393793j0 = System.nanoTime();
        this.W = true;
        g gVar = this.E;
        if (gVar != null) {
            gVar.a(this.D);
        }
    }

    private void h() {
        this.L.setLoadAssetListener(new a());
    }

    private void i() {
        if (f393777t0 == null) {
            float[] fArr = f393775r0;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f393777t0 = asFloatBuffer;
            asFloatBuffer.put(fArr);
            f393777t0.position(0);
        }
        if (f393778u0 == null) {
            float[] fArr2 = f393776s0;
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f393778u0 = asFloatBuffer2;
            asFloatBuffer2.put(fArr2);
            f393778u0.position(0);
        }
        if (this.f393782d == 0) {
            this.f393782d = i.a("attribute vec2  vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\n\nvoid main() {\n    texCoord = vTexCoord;\n    gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "precision mediump float;\n\nvarying vec2 texCoord;\nuniform sampler2D sTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, texCoord);\n}");
        }
    }

    private void m() {
        SurfaceTexture surfaceTexture;
        if (!ApiHelper.HAS_RELEASE_SURFACE_TEXTURE || (surfaceTexture = this.D) == null) {
            return;
        }
        surfaceTexture.release();
        this.D = null;
    }

    public void F(g gVar) {
        this.E = gVar;
    }

    public void G() {
        SurfaceTexture surfaceTexture = this.D;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
                this.D.getTransformMatrix(this.f393796m.c());
                this.f393796m.b(this.Y, this.Z);
            } catch (Exception e16) {
                QLog.e(f393774q0, 1, "update exception:" + e16.getMessage());
            }
        }
    }

    public void N(String str) {
        QLog.i(f393774q0, 1, "updateTemplate");
        this.N = str;
    }

    public void b() {
        int[] iArr = this.f393784e;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        GLES20.glDeleteTextures(2, new int[]{this.f393791i, this.C}, 0);
        dg3.a aVar = this.f393796m;
        if (aVar != null) {
            aVar.a();
        }
        m();
        AudioTrack audioTrack = this.I;
        if (audioTrack != null) {
            audioTrack.release();
            this.I = null;
        }
        VideoOutput videoOutput = this.G;
        if (videoOutput != null) {
            videoOutput.release();
            this.G = null;
        }
        AudioOutput audioOutput = this.H;
        if (audioOutput != null) {
            audioOutput.release();
            this.H = null;
        }
        CameraController cameraController = this.M;
        if (cameraController != null) {
            cameraController.release();
            this.M = null;
        }
        LightEngine lightEngine = this.F;
        if (lightEngine != null) {
            lightEngine.release();
            this.F = null;
        }
        LightSurface lightSurface = this.K;
        if (lightSurface != null) {
            lightSurface.release();
            this.K = null;
        }
        CameraConfig cameraConfig = this.L;
        if (cameraConfig != null) {
            cameraConfig.performFinalize();
            this.L = null;
        }
        this.f393789h = 0;
        this.f393782d = 0;
        this.W = false;
    }

    public void e(boolean z16) {
        String str;
        if (this.M != null) {
            QLog.i(f393774q0, 1, "enableFilamentTemplate enable:" + z16);
            HashMap<String, String> hashMap = new HashMap<>();
            if (z16) {
                str = "true";
            } else {
                str = "false";
            }
            hashMap.put("event.script.lightsdk.filamentrender.enabled", str);
            this.M.setAssetData(hashMap);
        }
    }

    public void f(e eVar) {
        if (this.W) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap a16 = o.a(this.f393789h, this.Y, this.Z);
            QLog.i(f393774q0, 1, "taking pic costs " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            eVar.a(a16);
        }
    }

    public void j(String str, int i3) {
        Bitmap k3;
        Bitmap k16 = k(str, i3);
        if (k16 != null) {
            float width = this.f393779a0 / k16.getWidth();
            if (width < 1.0f) {
                k3 = com.tencent.mobileqq.zplan.cc.util.c.k(k16, width, true);
            } else {
                k3 = com.tencent.mobileqq.zplan.cc.util.c.k(k16, 1.0f, true);
            }
            l(this.f393786f, k3);
            this.f393794k0 = k3;
            this.f393779a0 = k3.getWidth();
            this.f393780b0 = k3.getHeight();
            this.f393792i0 = true;
        }
        dg3.a aVar = this.f393796m;
        if (aVar != null) {
            aVar.f(this.f393779a0, this.f393780b0, this.f393790h0, this.f393788g0);
        }
    }

    public Bitmap k(String str, int i3) {
        Bitmap b16 = com.tencent.mobileqq.zplan.cc.util.c.b(this.U, str, 1);
        if (i3 != 0) {
            b16 = com.tencent.mobileqq.zplan.cc.util.c.i(b16, i3);
        }
        if (!com.tencent.mobileqq.zplan.cc.util.c.g(b16) || Math.abs((b16.getHeight() / b16.getWidth()) - 1.7777778f) <= 1.0E-4d) {
            return b16;
        }
        Bitmap createBitmap = Bitmap.createBitmap(b16.getWidth(), (int) ((b16.getWidth() * 16.0f) / 9.0f), Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(-1);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(6);
        paint.setAntiAlias(true);
        canvas.drawBitmap(b16, 0.0f, (r8 - b16.getHeight()) / 2, paint);
        return createBitmap;
    }

    public void n(String str, String str2) {
        CameraConfig cameraConfig = this.L;
        if (cameraConfig != null) {
            cameraConfig.setLightAIModelPath(str, str2);
            return;
        }
        if (this.T == null) {
            this.T = new HashMap();
        }
        this.T.put(str, str2);
    }

    public void o(String str, int i3, String str2) {
        QLog.i(f393774q0, 1, "setFilamentFaceAttr");
        this.f393795l0 = str;
        this.f393797m0 = i3;
        this.f393798n0 = str2;
    }

    public void p(f fVar) {
        this.V = fVar;
    }

    private int c(int i3) {
        return d(i3, 0, 0);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        GLES20.glViewport(0, 0, i3, i16);
        this.Y = i3;
        this.Z = i16;
        L(i3, i16);
    }

    private int d(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i3, iArr[0]);
        GLES20.glTexParameterf(i3, 10241, 9729.0f);
        GLES20.glTexParameterf(i3, 10240, 9729.0f);
        GLES20.glTexParameteri(i3, 10242, 33071);
        GLES20.glTexParameteri(i3, 10243, 33071);
        if (i16 > 0 && i17 > 0) {
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i16, i17, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        }
        return iArr[0];
    }

    public static void l(int i3, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, bitmap, 0);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        eg3.a aVar = this.f393800p0;
        if (aVar != null) {
            aVar.a("CAMERA_FIRST_FRAME_END");
        }
        g(this.Y, this.Z);
        M();
        K();
        I();
        H();
        J();
        if (this.W) {
            if (this.f393799o0 == 2 && this.f393795l0 != null && this.M != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("faceJson", this.f393795l0);
                    if (!TextUtils.isEmpty(this.f393798n0)) {
                        jSONObject.put("avatarInfo", this.f393798n0);
                    }
                } catch (JSONException e16) {
                    QLog.e(f393774q0, 1, "generate face asset json error:" + e16.getMessage());
                }
                hashMap.put("event.zplan.filament.face", jSONObject.toString());
                this.M.setAssetData(hashMap);
                e(true);
                eg3.a aVar2 = this.f393800p0;
                if (aVar2 != null) {
                    aVar2.a("SET_FACE_JSON_BEGIN");
                }
                this.f393795l0 = null;
                this.f393798n0 = null;
                this.f393797m0 = 0;
            }
            if (this.f393792i0) {
                this.L.setCameraTexture(this.f393786f, this.Y, this.Z, CameraConfig.DeviceCameraOrientation.ROTATION_0, CameraConfig.ImageOrigin.BottomLeft);
            } else {
                this.L.setCameraTexture(this.f393791i, this.Y, this.Z, CameraConfig.DeviceCameraOrientation.ROTATION_0, CameraConfig.ImageOrigin.BottomLeft);
            }
            long nanoTime = (System.nanoTime() - this.f393793j0) / 1000;
            if (!this.X) {
                this.G.readSample(nanoTime);
            }
            if (this.V != null) {
                LightFaceData faceData = this.L.getFaceData();
                if (faceData != null && faceData.mLightFaceFeatureList.size() > 0) {
                    int[] iArr = faceData.imageSize;
                    Bitmap createBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(faceData.imageByteBuffer);
                    Bitmap bitmap = this.f393794k0;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    this.f393794k0 = createBitmap;
                    ValidFacePhotoQuality d16 = q.d(this.f393794k0, faceData.mLightFaceFeatureList.get(0).faceFeature256Points);
                    if (d16 != null) {
                        this.V.b(d16.poseValid == 1, d16.expressionValid == 1, d16.lightingOverExposure == 0 && d16.lightingUnderExposure == 0);
                    }
                    this.V.a(faceData.mLightFaceFeatureList.size());
                } else {
                    this.V.b(false, false, false);
                    this.V.a(0);
                }
            }
            GLES20.glUseProgram(this.f393782d);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.f393782d, "vPosition");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) f393777t0);
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f393782d, "vTexCoord");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
            GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) f393778u0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f393789h);
            GLES20.glClear(16640);
            GLES20.glDrawArrays(5, 0, 4);
        }
    }

    public void L(int i3, int i16) {
        this.f393790h0 = i3 / i16;
        this.f393781c0 = i3;
        this.f393783d0 = i16;
        Camera.Parameters parameters = com.tencent.mobileqq.zplan.cc.camera.b.f332504b;
        if (parameters == null) {
            this.f393779a0 = 720;
            this.f393780b0 = 1280;
        } else if (!this.f393792i0) {
            this.f393779a0 = Math.min(parameters.getPreviewSize().width, com.tencent.mobileqq.zplan.cc.camera.b.f332504b.getPreviewSize().height);
            this.f393780b0 = Math.max(com.tencent.mobileqq.zplan.cc.camera.b.f332504b.getPreviewSize().width, com.tencent.mobileqq.zplan.cc.camera.b.f332504b.getPreviewSize().height);
        }
        int i17 = this.f393779a0;
        int i18 = this.f393780b0;
        double d16 = i17 / i18;
        this.f393788g0 = d16;
        dg3.a aVar = this.f393796m;
        if (aVar != null) {
            aVar.f(i17, i18, this.f393790h0, d16);
        }
        CameraConfig cameraConfig = this.L;
        if (cameraConfig != null) {
            cameraConfig.setRenderSize(this.Y, this.Z);
            this.L.clearAICachedData();
        }
        LightSurface lightSurface = this.K;
        if (lightSurface != null) {
            lightSurface.updateSize(this.Y, this.Z);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements OnLoadAssetListener {
        a() {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(HashMap<String, String> hashMap) {
            if (hashMap.containsKey(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME) && "0".equals(hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME)) && d.this.f393800p0 != null) {
                d.this.f393800p0.a("SET_FACE_JSON_END");
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long j3) {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int i3) {
        }
    }
}
