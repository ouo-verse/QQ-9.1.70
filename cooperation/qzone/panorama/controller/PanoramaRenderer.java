package cooperation.qzone.panorama.controller;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import com.tencent.mobileqq.apollo.view.opengl.k;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import cooperation.qzone.panorama.piece.PieceCacheList;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.panorama.util.ShaderUtil;
import cooperation.qzone.panorama.util.TextureUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes38.dex */
public class PanoramaRenderer implements k {
    private static final String TAG = "PanoramaRenderer";
    private PanoramaConfig.Builder builder;
    private PieceCacheList cachePieceDataList;
    private int modeType;
    private OnPanoramaLoadingListener onPanoramaLoadingListener;
    private int programId;
    private ShapeModel shapeModel;
    private int showType;
    private Drawable textureDrawable;
    private int textureId;

    public PanoramaRenderer(PanoramaConfig.Builder builder, OnPanoramaLoadingListener onPanoramaLoadingListener) {
        this.builder = builder;
        this.showType = builder.getShowType();
        this.shapeModel = builder.getShapeModel();
        this.modeType = builder.getModeType();
        this.onPanoramaLoadingListener = onPanoramaLoadingListener;
    }

    public void onRecycled() {
        TextureUtil.deleteTexture(this.textureId);
        TextureUtil.deleteTexture(this.cachePieceDataList);
    }

    public void setRotate(float f16, float f17) {
        ShapeModel shapeModel = this.shapeModel;
        if (shapeModel != null) {
            shapeModel.setRotate(f16, f17);
        }
    }

    public void setScale(float f16) {
        ShapeModel shapeModel = this.shapeModel;
        if (shapeModel != null) {
            shapeModel.setScale(f16);
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.k
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        GLES20.glViewport(0, 0, i3, i16);
        GLES20.glEnable(2884);
        float f16 = i3 / i16;
        ShapeModel shapeModel = this.shapeModel;
        if (shapeModel != null) {
            shapeModel.setScreenRatio(f16);
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.k
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        ShapeModel shapeModel;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        int programId = ShaderUtil.getProgramId();
        this.programId = programId;
        GLES20.glUseProgram(programId);
        ShapeModel shapeModel2 = this.shapeModel;
        if (shapeModel2 != null) {
            shapeModel2.initModel(this.programId);
        }
        PanoramaPieceManager panoramaPieceManager = this.builder.getPanoramaPieceManager();
        if (panoramaPieceManager == null || (shapeModel = this.shapeModel) == null) {
            return;
        }
        panoramaPieceManager.setSectorDegree(shapeModel.getSectorDegree());
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.k
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16384);
        PanoramaConfig.Builder builder = this.builder;
        if (builder != null && builder.isTextureChange()) {
            this.textureDrawable = this.builder.getTextureDrawable();
            TextureUtil.deleteTexture(this.textureId);
            Drawable drawable = this.textureDrawable;
            if (drawable != null) {
                this.textureId = TextureUtil.genTextureId(((BitmapDrawable) drawable).getBitmap(), false);
            }
            OnPanoramaLoadingListener onPanoramaLoadingListener = this.onPanoramaLoadingListener;
            if (onPanoramaLoadingListener != null) {
                onPanoramaLoadingListener.onPanoramaLoad();
            }
        }
        PanoramaConfig.Builder builder2 = this.builder;
        if (builder2 != null && builder2.getPanoramaPieceManager() != null) {
            this.builder.getPanoramaPieceManager().doProcess();
            PieceCacheList cachePieceDataList = this.builder.getPanoramaPieceManager().getCachePieceDataList();
            this.cachePieceDataList = cachePieceDataList;
            ShapeModel shapeModel = this.shapeModel;
            if (shapeModel != null) {
                shapeModel.setPieceDataList(cachePieceDataList);
            }
        }
        ShapeModel shapeModel2 = this.shapeModel;
        if (shapeModel2 != null) {
            shapeModel2.setTextureId(this.textureId);
            this.shapeModel.touchOperation();
            this.shapeModel.onModelDraw();
        }
    }
}
