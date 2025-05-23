package cooperation.qzone.panorama.util;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import cooperation.qzone.panorama.model.CylinderModel;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.model.SphereModel;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import java.util.HashMap;

/* loaded from: classes28.dex */
public class PanoramaConfig {
    public static final float HALF_SCREEN_SCALE_BALL = 0.41426522f;
    public static final float HALF_SCREEN_SCALE_CYLINDER = 0.5228754f;
    public static final String KEY_CURRENT_UIN = "currentUin";
    public static final int PANORAMA_TYPE_COVER = 1;
    public static final int PANORAMA_TYPE_DETAIL_FEED = 3;
    public static final int PANORAMA_TYPE_FEED = 2;
    public static final int PANORAMA_TYPE_GALLERY_FEED = 4;
    public static final int TYPE_CUBE_MODEL = 1;
    public static final int TYPE_CYLINDER_MODEL = 2;
    public static final int TYPE_FULL_SCREEN = 0;
    public static final int TYPE_HALF_SCREEN = 1;
    public static final int TYPE_NONE = -1;
    public static final int TYPE_SPHERE_MODEL = 0;

    /* loaded from: classes28.dex */
    public static class Builder {
        private boolean isNeedPieceLoad;
        private int modeType;
        private String originalUrl;
        private HashMap<String, String> panoramaExtra;
        private PanoramaPieceManager panoramaPieceManager;
        private int panoramaType;
        private ShapeModel shapeModel;
        private String smallUrl;
        private Drawable textureDrawable;
        private String thumbUrl;
        private int showType = 0;
        private int renderMode = 1;
        private boolean isOpenGyroscopeSensor = false;
        private boolean isOpenTouchMove = false;
        private boolean isShowLoadingProgress = false;
        private boolean isShowGuideAnimate = false;
        private boolean isShowPanoramaBall = false;
        private boolean isTextureChange = false;

        public Builder(int i3) {
            this.isNeedPieceLoad = false;
            this.modeType = i3;
            if (i3 == 0) {
                this.isNeedPieceLoad = false;
                this.shapeModel = new SphereModel(false);
            } else if (i3 == 2) {
                this.isNeedPieceLoad = true;
                this.shapeModel = new CylinderModel(true);
            }
        }

        public int getModeType() {
            return this.modeType;
        }

        public String getOriginalUrl() {
            return this.originalUrl;
        }

        public String getPanoramaExtraValue(String str) {
            HashMap<String, String> hashMap;
            if (!TextUtils.isEmpty(str) && (hashMap = this.panoramaExtra) != null) {
                return hashMap.get(str);
            }
            return null;
        }

        public PanoramaPieceManager getPanoramaPieceManager() {
            return this.panoramaPieceManager;
        }

        public int getPanoramaType() {
            return this.panoramaType;
        }

        public int getRenderMode() {
            return this.renderMode;
        }

        public ShapeModel getShapeModel() {
            return this.shapeModel;
        }

        public int getShowType() {
            return this.showType;
        }

        public String getSmallUrl() {
            return this.smallUrl;
        }

        public Drawable getTextureDrawable() {
            this.isTextureChange = false;
            return this.textureDrawable;
        }

        public String getThumbUrl() {
            return this.thumbUrl;
        }

        public boolean isNeedPieceLoad() {
            return this.isNeedPieceLoad;
        }

        public boolean isOpenGyroscopeSensor() {
            return this.isOpenGyroscopeSensor;
        }

        public boolean isOpenTouchMove() {
            return this.isOpenTouchMove;
        }

        public boolean isShowGuideAnimate() {
            return this.isShowGuideAnimate;
        }

        public boolean isShowLoadingProgress() {
            return this.isShowLoadingProgress;
        }

        public boolean isShowPanoramaBall() {
            return this.isShowPanoramaBall;
        }

        public boolean isTextureChange() {
            return this.isTextureChange;
        }

        public Builder setModeType(int i3) {
            this.modeType = i3;
            return this;
        }

        public Builder setOnRotateListener(ShapeModel.OnRotateListener onRotateListener) {
            ShapeModel shapeModel = this.shapeModel;
            if (shapeModel != null && onRotateListener != null) {
                shapeModel.setOnRotateListener(onRotateListener);
            }
            return this;
        }

        public Builder setOpenGyroscopeSensor(boolean z16) {
            this.isOpenGyroscopeSensor = z16;
            return this;
        }

        public Builder setOpenTouchMove(boolean z16) {
            this.isOpenTouchMove = z16;
            return this;
        }

        public Builder setOriginalUrl(String str) {
            this.originalUrl = str;
            return this;
        }

        public Builder setPanoramaExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.panoramaExtra == null) {
                    this.panoramaExtra = new HashMap<>();
                }
                this.panoramaExtra.put(str, str2);
            }
            return this;
        }

        public void setPanoramaPieceManager(PanoramaPieceManager panoramaPieceManager) {
            this.panoramaPieceManager = panoramaPieceManager;
            ShapeModel shapeModel = this.shapeModel;
            if (shapeModel != null) {
                shapeModel.setPanoramaTouchListener(panoramaPieceManager);
            }
        }

        public Builder setPanoramaType(int i3) {
            this.panoramaType = i3;
            return this;
        }

        public Builder setRenderMode(int i3) {
            this.renderMode = i3;
            return this;
        }

        public Builder setShowGuideAnimate(boolean z16) {
            this.isShowGuideAnimate = z16;
            return this;
        }

        public Builder setShowLoadingProgress(boolean z16) {
            this.isShowLoadingProgress = z16;
            return this;
        }

        public Builder setShowPanoramaBall(boolean z16) {
            this.isShowPanoramaBall = z16;
            return this;
        }

        public Builder setShowType(int i3) {
            this.showType = i3;
            ShapeModel shapeModel = this.shapeModel;
            if (shapeModel != null) {
                shapeModel.setShowType(i3);
            }
            return this;
        }

        public Builder setSmallUrl(String str) {
            this.smallUrl = str;
            return this;
        }

        public void setTextureChange(boolean z16) {
            this.isTextureChange = z16;
        }

        public Builder setTextureDrawable(Drawable drawable) {
            ShapeModel shapeModel;
            this.textureDrawable = drawable;
            this.isTextureChange = true;
            if (drawable != null && (shapeModel = this.shapeModel) != null) {
                shapeModel.setImageSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            return this;
        }

        public Builder setThumbUrl(String str) {
            this.thumbUrl = str;
            return this;
        }
    }
}
