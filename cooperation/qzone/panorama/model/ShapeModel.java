package cooperation.qzone.panorama.model;

import android.opengl.GLES20;
import android.opengl.Matrix;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.piece.PieceCacheList;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ShapeModel {
    public static final String A_POSITION = "aPosition";
    public static final String A_TEXTURE_COORD = "aTextureCoord";
    public static final String U_COLOR = "uColor";
    public static final String U_PROJECT_MATRIX = "uProjectMatrix";
    protected int imageHeight;
    protected int imageWidth;
    protected boolean isPieceLoad;
    protected int mAPositionLocation;
    protected int mATextureCoordLocation;
    protected int mUProjectMatrixLocation;
    protected OnRotateListener onRotateListener;
    protected PanoramaTouchListener panoramaTouchListener;
    protected PieceCacheList pieceDataList;
    protected float rotateX;
    protected float rotateY;
    protected float screenRatio;
    protected int showType;
    protected FloatBuffer textureBuffer;
    protected int textureId;
    protected FloatBuffer vertexBuffer;
    protected int vertexSize = 0;
    protected float[] modelMatrix = new float[16];
    protected float[] projectMatrix = new float[16];
    protected float mScale = 1.0f;
    protected int pieceSize = 1;
    protected float sectorDegree = 360.0f;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface OnRotateListener {
        void onRotate(int i3, float f16, float f17, float f18);
    }

    public ShapeModel(boolean z16) {
        this.isPieceLoad = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] getMultiplyMatrix() {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.multiplyMM(fArr, 0, this.projectMatrix, 0, this.modelMatrix, 0);
        Matrix.setIdentityM(this.modelMatrix, 0);
        return fArr;
    }

    public PieceCacheList getPieceDataList() {
        return this.pieceDataList;
    }

    public int getPieceSize() {
        return this.pieceSize;
    }

    public float getSectorDegree() {
        return this.sectorDegree;
    }

    public FloatBuffer getTextureBuffer() {
        return this.textureBuffer;
    }

    public abstract int getTextureType();

    public FloatBuffer getVertexBuffer() {
        return this.vertexBuffer;
    }

    public int getVertexSize() {
        return this.vertexSize;
    }

    public abstract int getVertexType();

    protected abstract void initCoordinate();

    protected void initLocation(int i3) {
        this.mAPositionLocation = GLES20.glGetAttribLocation(i3, "aPosition");
        this.mUProjectMatrixLocation = GLES20.glGetUniformLocation(i3, "uProjectMatrix");
        this.mATextureCoordLocation = GLES20.glGetAttribLocation(i3, "aTextureCoord");
    }

    protected void initMatrix() {
        Matrix.setIdentityM(this.modelMatrix, 0);
        Matrix.setIdentityM(this.projectMatrix, 0);
    }

    public void initModel(int i3) {
        initRotate();
        if (this.vertexBuffer == null || this.textureBuffer == null) {
            initCoordinate();
        }
        initLocation(i3);
        initVertexArray();
        initTextureArray();
        initMatrix();
    }

    protected abstract void initRotate();

    protected void initTextureArray() {
        if (getTextureBuffer() != null) {
            getTextureBuffer().position(0);
            GLES20.glVertexAttribPointer(this.mATextureCoordLocation, getTextureType(), 5126, false, 0, (Buffer) getTextureBuffer());
            GLES20.glEnableVertexAttribArray(this.mATextureCoordLocation);
        }
    }

    protected void initVertexArray() {
        if (getVertexBuffer() != null) {
            getVertexBuffer().position(0);
            GLES20.glVertexAttribPointer(this.mAPositionLocation, getVertexType(), 5126, false, 0, (Buffer) getVertexBuffer());
            GLES20.glEnableVertexAttribArray(this.mAPositionLocation);
        }
    }

    public boolean isPieceLoad() {
        return this.isPieceLoad;
    }

    public abstract void onModelDraw();

    public void setImageSize(int i3, int i16) {
        this.imageWidth = i3;
        this.imageHeight = i16;
    }

    public void setOnRotateListener(OnRotateListener onRotateListener) {
        this.onRotateListener = onRotateListener;
    }

    public void setPanoramaTouchListener(PanoramaTouchListener panoramaTouchListener) {
        this.panoramaTouchListener = panoramaTouchListener;
    }

    public void setPieceDataList(PieceCacheList pieceCacheList) {
        this.pieceDataList = pieceCacheList;
    }

    public void setRotate(float f16, float f17) {
        this.rotateX += f16;
        this.rotateY += f17;
    }

    public void setScale(float f16) {
        this.mScale = f16;
    }

    public void setScreenRatio(float f16) {
        this.screenRatio = f16;
        if (this.showType == 1) {
            if (this instanceof CylinderModel) {
                this.mScale = 0.5228754f;
            } else {
                this.mScale = 0.41426522f;
            }
        }
    }

    public void setShowType(int i3) {
        this.showType = i3;
    }

    public void setTextureId(int i3) {
        this.textureId = i3;
    }

    public abstract void touchOperation();
}
