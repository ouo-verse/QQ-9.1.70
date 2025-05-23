package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.model.BuckleFrameItem;
import com.tencent.ttpic.util.FaceOffUtil;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQGameBuckleFaceFilter {
    public static final int FLOAT_SIZE_BYTES = 4;
    private static final String TAG = "QQGameBuckleFaceFilter";
    private float[] attrPositions;
    private float[] attrTexCoords;
    protected int height;
    private final String mFragmentShader;
    private boolean mIsInitialized;
    private int mProgram;
    protected double mScreenScale;
    public int mTextureType;
    private FloatBuffer mUserTextureCoord;
    private final String mVertexShader;
    private FloatBuffer mVertextPosition;
    protected int width;
    public static final String FACE_CROP_VERTEX = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/FaceCropVertexShader.dat");
    public static final String FACE_CROP_FRAGMENT = FileUtils.loadAssetsString(AEModule.getContext(), "camera/camera_video/shader/FaceCropFragmentShader.dat");
    public static float[] VERTEXT_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] TEXUTURE_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    public QQGameBuckleFaceFilter() {
        this(FACE_CROP_VERTEX, FACE_CROP_FRAGMENT);
    }

    private static float DISTANCE_OF(PointF pointF, PointF pointF2) {
        float f16 = pointF2.x - pointF.x;
        float f17 = pointF2.y - pointF.y;
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    private static float RADIANS2DEGREES(float f16) {
        return (float) ((f16 * 180.0f) / 3.141592653589793d);
    }

    private void checkGlError(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                SLog.e(TAG, new RuntimeException(str + ": glError " + glGetError));
            } else {
                return;
            }
        }
    }

    private void checkLocation(int i3, String str) {
        if (i3 < 0) {
            SLog.e(TAG, new RuntimeException("Unable to locate '" + str + "' in program"));
        }
    }

    private void setUserTextureCoords(float[] fArr) {
        this.mUserTextureCoord.position(0);
        this.mUserTextureCoord.put(fArr);
        this.mUserTextureCoord.position(0);
    }

    private void setVertextPosition(float[] fArr) {
        this.mVertextPosition.position(0);
        this.mVertextPosition.put(fArr);
        this.mVertextPosition.position(0);
    }

    public void computeFaceRectAndUpdateShader(List<PointF> list, float[] fArr, BuckleFrameItem buckleFrameItem) {
        float f16;
        float f17;
        double d16 = buckleFrameItem.size[0];
        double d17 = buckleFrameItem.size[1];
        double d18 = buckleFrameItem.nosePoint[0];
        double d19 = buckleFrameItem.nosePoint[1];
        double min = (float) Math.min(d16 / this.width, d17 / this.height);
        PointF pointF = new PointF((((float) (d16 / min)) - this.width) / 2.0f, (((float) (d17 / min)) - this.height) / 2.0f);
        float f18 = (float) (buckleFrameItem.faceWidth / min);
        float f19 = (float) ((d18 / min) - pointF.x);
        float f26 = (float) ((d19 / min) - pointF.y);
        List<PointF> fullCoords = FaceOffUtil.getFullCoords(list, 3.0f);
        for (PointF pointF2 : fullCoords) {
            double d26 = pointF2.x;
            double d27 = this.mScreenScale;
            pointF2.x = (float) (d26 / d27);
            pointF2.y = (float) (pointF2.y / d27);
        }
        float DISTANCE_OF = DISTANCE_OF(fullCoords.get(0), fullCoords.get(18));
        float f27 = fullCoords.get(64).x;
        float f28 = fullCoords.get(64).y;
        ArrayList<PointF> arrayList = new ArrayList();
        arrayList.add(fullCoords.get(99));
        arrayList.add(fullCoords.get(105));
        arrayList.add(fullCoords.get(101));
        arrayList.add(fullCoords.get(103));
        float f29 = f18 / DISTANCE_OF;
        float f36 = fArr[1];
        if (Math.abs(f36) > 0.2d) {
            if (f36 > 0.0f) {
                f17 = f36 - 0.2f;
            } else {
                f17 = f36 + 0.2f;
            }
            f16 = f18 * f17;
        } else {
            f16 = 0.0f;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.postRotate(RADIANS2DEGREES((float) (fArr[2] - buckleFrameItem.faceAngle)), f27, f28);
        matrix.postScale(f29, f29, f27, f28);
        matrix.postTranslate(f19 - f27, f26 - f28);
        matrix.postTranslate(f16, 0.0f);
        ArrayList arrayList2 = new ArrayList();
        for (PointF pointF3 : arrayList) {
            float[] fArr2 = new float[2];
            matrix.mapPoints(fArr2, new float[]{pointF3.x, pointF3.y});
            arrayList2.add(new PointF(fArr2[0], fArr2[1]));
        }
        int i3 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            PointF pointF4 = (PointF) arrayList2.get(i16);
            float[] fArr3 = this.attrPositions;
            fArr3[i3] = ((pointF4.x * 2.0f) / this.width) - 1.0f;
            int i17 = i3 + 1;
            fArr3[i17] = ((pointF4.y * 2.0f) / this.height) - 1.0f;
            PointF pointF5 = (PointF) arrayList.get(i16);
            float[] fArr4 = this.attrTexCoords;
            fArr4[i3] = pointF5.x / this.width;
            fArr4[i17] = pointF5.y / this.height;
            i3 += 2;
        }
        setVertextPosition(this.attrPositions);
        setUserTextureCoords(this.attrTexCoords);
    }

    public void destroy() {
        SLog.d(TAG, "destroy");
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mProgram);
        this.mProgram = 0;
    }

    public void drawTexture(int i3) {
        checkGlError("onDrawFrame start");
        int i16 = this.mProgram;
        GLES20.glUseProgram(i16);
        checkGlError("glUseProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(i16, "position");
        checkLocation(glGetAttribLocation, "position");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i16, "inputTextureCoordinate");
        checkLocation(glGetAttribLocation2, "inputTextureCoordinate");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) this.mVertextPosition);
        checkGlError("glVertexAttribPointer position");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        checkGlError("glEnableVertexAttribArray mPositionHandle");
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) this.mUserTextureCoord);
        checkGlError("glVertexAttribPointer mTextureHandle");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        checkGlError("glEnableVertexAttribArray mTextureHandle");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
    }

    public void init() {
        if (this.mIsInitialized) {
            return;
        }
        int createProgram = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
        this.mProgram = createProgram;
        if (createProgram == 0) {
            SLog.e(TAG, new RuntimeException("failed creating program " + getClass().getSimpleName()));
        }
        this.mIsInitialized = true;
    }

    public void updateFilterSize(int i3, int i16, double d16) {
        this.width = i3;
        this.height = i16;
        this.mScreenScale = d16;
    }

    public QQGameBuckleFaceFilter(String str, String str2) {
        this.mVertextPosition = GlUtil.createFloatBuffer(VERTEXT_COORDS);
        this.mUserTextureCoord = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
        this.attrPositions = new float[8];
        this.attrTexCoords = new float[8];
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        this.mTextureType = GLSLRender.GL_TEXTURE_2D;
    }
}
