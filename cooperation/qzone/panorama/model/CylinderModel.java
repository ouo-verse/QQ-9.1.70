package cooperation.qzone.panorama.model;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.piece.PieceData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CylinderModel extends ShapeModel {
    public static final int DEGREE_OFFEST = 40;
    public static final int IMAGE_RATE = 6;
    public static float INIT_ROTATE = 0.0f;
    public static final int PIECE_VERTEX_SIZE = 6;
    private static final float ROTATE_MAX_DEGREE = 55.207924f;
    private static final float SCALE_RATE = 0.5228754f;
    private static final String TAG = "CylinderModel";
    private float maxDegree;

    public CylinderModel(boolean z16) {
        super(z16);
        this.maxDegree = ROTATE_MAX_DEGREE;
        if (z16) {
            this.pieceSize = 36;
        }
        this.rotateY = INIT_ROTATE;
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
        ArrayList<float[]> arrayList;
        float[] fArr;
        this.mScale = 0.5228754f;
        ArrayList<float[]> cylinderCoordinate = ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).getCylinderCoordinate(this.sectorDegree, false);
        if (this.isPieceLoad) {
            arrayList = ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).getCylinderCoordinate(this.sectorDegree, true);
        } else {
            arrayList = null;
        }
        if (cylinderCoordinate == null || cylinderCoordinate.size() != 2 || (fArr = cylinderCoordinate.get(0)) == null) {
            return;
        }
        int length = fArr.length;
        if (arrayList != null) {
            float[] fArr2 = arrayList.get(0);
            fArr = Arrays.copyOf(fArr, fArr2.length + length);
            System.arraycopy(fArr2, 0, fArr, length, fArr2.length);
        }
        if (fArr != null) {
            this.vertexSize = length / 3;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.vertexBuffer = asFloatBuffer;
            asFloatBuffer.put(fArr);
            this.vertexBuffer.position(0);
        }
        float[] fArr3 = cylinderCoordinate.get(1);
        if (fArr3 == null) {
            return;
        }
        int length2 = fArr3.length;
        if (arrayList != null) {
            float[] fArr4 = arrayList.get(1);
            fArr3 = Arrays.copyOf(fArr3, fArr4.length + length2);
            System.arraycopy(fArr4, 0, fArr3, length2, fArr4.length);
        }
        if (fArr3 != null) {
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.textureBuffer = asFloatBuffer2;
            asFloatBuffer2.put(fArr3);
            this.textureBuffer.position(0);
        }
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    protected void initRotate() {
        int i3;
        if (this.imageWidth != 0 && (i3 = this.imageHeight) != 0) {
            this.sectorDegree = 360 - ((6 - ((int) ((r0 / i3) + 0.1f))) * 40);
        } else {
            this.sectorDegree = 360.0f;
        }
        if (this.sectorDegree > 360.0f) {
            this.sectorDegree = 360.0f;
        }
        float f16 = this.sectorDegree / 2.0f;
        INIT_ROTATE = f16;
        this.rotateY = f16;
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    public void onModelDraw() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureId);
        GLES20.glUniformMatrix4fv(this.mUProjectMatrixLocation, 1, false, getMultiplyMatrix(), 0);
        GLES20.glDrawArrays(4, 0, getVertexSize());
        if (this.pieceDataList != null) {
            for (int i3 = 0; i3 < this.pieceDataList.size(); i3++) {
                PieceData valueAt = this.pieceDataList.valueAt(i3);
                int textureOrgObjectId = valueAt.getTextureOrgObjectId();
                if (textureOrgObjectId > 0) {
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, textureOrgObjectId);
                    GLES20.glDrawArrays(4, getVertexSize() + (((((int) (this.sectorDegree / 10.0f)) - 1) - valueAt.getPieceIndex()) * 6), 6);
                }
            }
        }
    }

    @Override // cooperation.qzone.panorama.model.ShapeModel
    public void touchOperation() {
        int i3;
        float f16 = this.mScale;
        int i16 = 0;
        if (f16 != 0.0f) {
            if (f16 > 0.5228754f) {
                this.mScale = 0.5228754f;
            }
            float degrees = (float) (Math.toDegrees(Math.atan(this.mScale)) * 2.0d);
            this.maxDegree = (int) ((ROTATE_MAX_DEGREE - degrees) * 0.5d);
            Matrix.perspectiveM(this.projectMatrix, 0, degrees, this.screenRatio, 1.0f, 500.0f);
            Matrix.translateM(this.projectMatrix, 0, 0.0f, 0.0f, -2.0f);
        }
        float f17 = this.rotateX;
        float f18 = this.maxDegree;
        if (f17 > f18) {
            this.rotateX = f18;
        } else if (f17 < (-f18)) {
            this.rotateX = -f18;
        }
        if (INIT_ROTATE != 180.0f) {
            if (this.showType == 1) {
                i3 = 44;
            } else {
                i3 = 17;
            }
            i16 = i3;
            float f19 = this.rotateY;
            float f26 = this.sectorDegree;
            float f27 = i16;
            if (f19 > f26 - f27) {
                this.rotateY = f26 - f27;
            } else if (f19 < f27) {
                this.rotateY = f27;
            }
        }
        PanoramaTouchListener panoramaTouchListener = this.panoramaTouchListener;
        if (panoramaTouchListener != null) {
            panoramaTouchListener.onTouchScale(this.mScale);
            this.panoramaTouchListener.onTouchMove(this.rotateX, this.rotateY);
        }
        Matrix.rotateM(this.modelMatrix, 0, -this.rotateX, 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(this.modelMatrix, 0, -this.rotateY, 0.0f, 1.0f, 0.0f);
        Matrix.rotateM(this.modelMatrix, 0, 0.0f, 0.0f, 0.0f, 1.0f);
        ShapeModel.OnRotateListener onRotateListener = this.onRotateListener;
        if (onRotateListener != null) {
            float f28 = this.mScale;
            if (f28 != 1.0f) {
                onRotateListener.onRotate(((int) this.sectorDegree) - i16, -this.rotateX, -this.rotateY, f28);
            }
        }
    }
}
