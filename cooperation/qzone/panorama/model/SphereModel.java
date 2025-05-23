package cooperation.qzone.panorama.model;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.panorama.model.ShapeModel;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SphereModel extends ShapeModel {
    public static final float INIT_ROTATE = 90.0f;
    private static final String TAG = "SphereModel";

    public SphereModel(boolean z16) {
        super(z16);
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    public int getTextureType() {
        return 2;
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    public int getVertexType() {
        return 3;
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    protected void initCoordinate() {
        ArrayList<float[]> sphereCoordinate = ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).getSphereCoordinate();
        if (sphereCoordinate != null && sphereCoordinate.size() == 2) {
            float[] fArr = sphereCoordinate.get(0);
            if (fArr != null) {
                this.vertexSize = fArr.length / 3;
                FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.vertexBuffer = asFloatBuffer;
                asFloatBuffer.put(fArr);
                this.vertexBuffer.position(0);
            }
            float[] fArr2 = sphereCoordinate.get(1);
            if (fArr2 != null) {
                FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.textureBuffer = asFloatBuffer2;
                asFloatBuffer2.put(fArr2);
                this.textureBuffer.position(0);
            }
        }
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    protected void initRotate() {
        this.rotateY = 90.0f;
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    public void onModelDraw() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureId);
        GLES20.glUniformMatrix4fv(this.mUProjectMatrixLocation, 1, false, getMultiplyMatrix(), 0);
        GLES20.glDrawArrays(4, 0, getVertexSize());
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    public void touchOperation() {
        float f16 = this.rotateX;
        if (f16 > 90.0f) {
            this.rotateX = 90.0f;
        } else if (f16 < -90.0f) {
            this.rotateX = -90.0f;
        }
        float f17 = this.mScale;
        if (f17 != 0.0f) {
            Matrix.perspectiveM(this.projectMatrix, 0, (float) (Math.toDegrees(Math.atan(f17)) * 2.0d), this.screenRatio, 1.0f, 500.0f);
            Matrix.translateM(this.projectMatrix, 0, 0.0f, 0.0f, -2.0f);
        }
        Matrix.rotateM(this.modelMatrix, 0, -this.rotateX, 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(this.modelMatrix, 0, -this.rotateY, 0.0f, 1.0f, 0.0f);
        Matrix.rotateM(this.modelMatrix, 0, 0.0f, 0.0f, 0.0f, 1.0f);
        ShapeModel.OnRotateListener onRotateListener = this.onRotateListener;
        if (onRotateListener != null) {
            onRotateListener.onRotate((int) this.sectorDegree, -this.rotateX, -this.rotateY, this.mScale);
        }
    }
}
