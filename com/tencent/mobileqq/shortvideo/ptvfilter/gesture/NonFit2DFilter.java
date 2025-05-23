package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class NonFit2DFilter extends VideoFilterBase {
    private static final String TAG = "NonFit2DFilter";
    private int ItemLength;
    PointF anchor;
    private int currentIndex;
    private double distanceX;
    private double distanceY;
    protected long frameStartTime;
    volatile boolean hasCleared;
    private boolean initialized;
    private StickerItem item;
    private int lastDecodeImageIndex;
    private int lastImageIndex;
    private long lastMills;
    private boolean mAlwayslastFrame;
    private int mItemCount;
    private boolean mNeedSetPosition;
    private PlayerUtil.Player mPlayer;
    float mScaleFactor;
    PointF mShowPosition;
    protected UniformParam.TextureBitmapParam mTextureParam;
    protected String materialId;
    protected StickerItem nonFitItems;
    protected int playCount;
    private int realHeight;
    private int realWidth;
    public long startTime;
    private int[] tex;

    public NonFit2DFilter(StickerItem stickerItem, String str) {
        super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
        this.initialized = false;
        this.lastImageIndex = -1;
        this.lastDecodeImageIndex = -1;
        this.playCount = 0;
        this.tex = new int[1];
        this.currentIndex = 0;
        this.ItemLength = 0;
        this.distanceX = 0.0d;
        this.distanceY = 0.0d;
        this.anchor = new PointF();
        this.mShowPosition = new PointF();
        this.mScaleFactor = 0.5f;
        this.mNeedSetPosition = false;
        this.lastMills = 0L;
        this.mItemCount = 0;
        this.mAlwayslastFrame = false;
        this.hasCleared = false;
        if (stickerItem != null) {
            this.nonFitItems = stickerItem;
            this.ItemLength = 1;
            this.dataPath = str;
            this.materialId = VideoMaterial.getMaterialId(str);
            this.mNeedSetPosition = true;
            this.nonFitItems.playCount = 1;
            setCurrentItem(stickerItem, 0);
            this.realWidth = stickerItem.width;
            this.realHeight = stickerItem.height;
            filterLog("dataPath:" + str + ", materialId:" + this.materialId + ", ItemLength:" + this.ItemLength);
            initParams();
            if (stickerItem.anchorPoint != null) {
                this.anchor = new PointF(stickerItem.anchorPoint[0], stickerItem.anchorPoint[1]);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("items length error!");
    }

    public static void filterLog(String str) {
        if (SLog.isEnable()) {
            SLog.i(TAG, str);
        }
    }

    private int getCount(long j3) {
        boolean z16;
        if (this.nonFitItems.playCount == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int max = (int) ((j3 - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0d));
        int i3 = this.item.frames;
        int i16 = this.playCount;
        if (max >= i3 * (i16 + 1)) {
            this.playCount = i16 + 1;
        }
        int max2 = max % Math.max(this.item.frames, 1);
        if (!z16) {
            if (this.mAlwayslastFrame || max2 < this.mItemCount) {
                max2 = this.item.frames - 1;
            }
            this.mItemCount = max2;
            if (max2 >= this.item.frames - 1) {
                int i17 = this.item.frames - 1;
                this.mAlwayslastFrame = true;
                return i17;
            }
            return max2;
        }
        return max2;
    }

    private static float getDist(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    private int getNextFrame(int i3) {
        boolean z16;
        boolean z17;
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.id, i3);
        if (loadImage != null && BitmapUtils.isLegal(loadImage)) {
            z16 = false;
        } else {
            loadImage = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), FileUtils.genSeperateFileDir(this.dataPath) + this.item.subFolder + File.separator + this.item.id + "_" + i3 + ".png", MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
            z16 = true;
        }
        if (BitmapUtils.isLegal(loadImage)) {
            GlUtil.loadTexture(this.tex[0], loadImage);
            if (z16) {
                loadImage.recycle();
            }
            z17 = true;
        } else {
            z17 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getNextFrame load cache:");
        sb5.append(!z16);
        sb5.append(", updateTexture:");
        sb5.append(z17);
        sb5.append(",bitmap content:");
        sb5.append(BitmapUtils.isLegal(loadImage));
        filterLog(sb5.toString());
        return this.tex[0];
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static DisplayMetrics getScreenWH(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private void updateTextureParam(long j3) {
        int count = getCount(j3);
        if (count == this.lastImageIndex) {
            filterLog("updateTextureParam return!");
            return;
        }
        filterLog("updateTextureParam" + count);
        addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(count), 33986));
        this.lastImageIndex = count;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        filterLog("TimGestureLog: ApplyGLSLFilter Create Shader");
        super.ApplyGLSLFilter();
        int[] iArr = this.tex;
        GLES20.glGenTextures(iArr.length, iArr, 0);
    }

    public PointF ScreenPonitToGLPoint(float f16, float f17) {
        PointF pointF = new PointF();
        DisplayMetrics screenWH = getScreenWH(SdkContext.getInstance().getApplication());
        pointF.x = f16 * (this.width / screenWH.widthPixels);
        pointF.y = f17 * (this.height / screenWH.heightPixels);
        return pointF;
    }

    public void adjustPosition() {
        double d16;
        double d17;
        int i3 = this.width;
        int i16 = this.height;
        if (i3 / i16 >= 0.75d) {
            d16 = i3;
            d17 = 720.0d;
        } else {
            d16 = i16;
            d17 = 960.0d;
        }
        double d18 = d16 / d17;
        float f16 = this.item.scaleFactor / 960.0f;
        this.mScaleFactor = f16;
        if (f16 == 0.0f) {
            this.mScaleFactor = 1.0f;
        }
        float f17 = this.mScaleFactor * 1.2f;
        this.mScaleFactor = f17;
        PointF pointF = this.mShowPosition;
        float f18 = pointF.x;
        PointF pointF2 = this.anchor;
        float f19 = f18 - ((float) ((pointF2.x * d18) * f17));
        float f26 = pointF.y - ((float) ((pointF2.y * d18) * f17));
        setPositions(AlgoUtils.calPositions(f19, (float) (f26 + (this.item.height * d18 * this.mScaleFactor)), (float) (f19 + (this.item.width * d18 * this.mScaleFactor)), f26, this.width, this.height));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean canUseBlendMode() {
        return true;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void clearGLSLSelf() {
        this.hasCleared = true;
        filterLog("clearGLSLSelf!");
        filterLog("TimGestureLog: clearGLSLSelf Clear Shader");
        clearTextureParam();
        destroyAudio();
        super.clearGLSLSelf();
        int[] iArr = this.tex;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    public void clearTextureParam() {
        UniformParam.TextureBitmapParam textureBitmapParam = this.mTextureParam;
        if (textureBitmapParam != null) {
            textureBitmapParam.clear();
            this.mTextureParam = null;
        }
        setPositions(GlUtil.EMPTY_POSITIONS);
        this.initialized = false;
        this.lastImageIndex = -1;
        this.lastDecodeImageIndex = -1;
        this.playCount = 0;
        filterLog("clearTextureParam!");
    }

    public void destroyAudio() {
        filterLog("destroyAudio!");
        PlayerUtil.destroyPlayer(this.mPlayer);
        this.mPlayer = null;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        addParam(new UniformParam.IntParam("texNeedTransform", -1));
        addParam(new UniformParam.IntParam(c.W, this.item.blendMode));
        addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        addParam(new UniformParam.Float2fParam("displacement", 0.0f, 0.0f));
        addParam(new UniformParam.IntParam("displacementEnableLut", 0));
        addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
        addParam(new UniformParam.Float2fParam("canvasSize", 0.0f, 0.0f));
        addParam(new UniformParam.Float2fParam("texAnchor", 0.0f, 0.0f));
        addParam(new UniformParam.FloatParam("texScale", 1.0f));
        addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
        addParam(new UniformParam.FloatParam(c.f123400v, 1.0f));
        addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
    }

    public void initPositionAdjusted() {
        initScale();
        if (!this.mNeedSetPosition) {
            adjustPosition(this.distanceX, this.distanceY);
        } else {
            adjustPosition();
        }
    }

    void initScale() {
        if (!this.mNeedSetPosition) {
            this.distanceX = this.item.position[0];
            this.distanceY = this.item.position[1];
        }
    }

    public boolean isAnimationPlay(long j3) {
        if (this.frameStartTime == 0 || j3 - r0 <= this.item.frames * this.item.frameDuration) {
            return true;
        }
        return false;
    }

    public boolean isHasCleared() {
        return this.hasCleared;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean renderTexture(int i3, int i16, int i17) {
        return super.renderTexture(i3, i16, i17);
    }

    public void resetAnimationEndStatus() {
        setCurrentItem(this.nonFitItems, 0);
        this.frameStartTime = 0L;
        this.initialized = false;
    }

    public void setCurrentItem(StickerItem stickerItem, int i3) {
        this.item = stickerItem;
        this.currentIndex = i3;
        this.lastImageIndex = -1;
        this.lastDecodeImageIndex = -1;
        this.playCount = 0;
        this.mItemCount = 0;
        this.mAlwayslastFrame = false;
        this.initialized = false;
        destroyAudio();
        VideoMemoryManager.getInstance().reset(stickerItem.id);
        filterLog("currentItem id:" + this.item.id);
    }

    protected void updateActionTriggered(long j3) {
        boolean z16;
        if (this.item != null) {
            if (!this.initialized) {
                z16 = true;
                this.initialized = true;
                this.frameStartTime = j3;
            } else {
                z16 = false;
            }
            if (!TextUtils.isEmpty(this.dataPath) && !TextUtils.isEmpty(this.item.id) && !TextUtils.isEmpty(this.item.audio)) {
                if (this.mPlayer == null && !VideoPrefsUtil.getMaterialMute()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.dataPath);
                    String str = File.separator;
                    sb5.append(str);
                    sb5.append(this.item.id);
                    sb5.append(str);
                    sb5.append(this.item.audio);
                    String sb6 = sb5.toString();
                    if (sb6.startsWith("assets://")) {
                        this.mPlayer = PlayerUtil.createPlayerFromAssets(AEModule.getContext(), sb6.replace("assets://", ""), false);
                    } else {
                        this.mPlayer = PlayerUtil.createPlayerFromUri(AEModule.getContext(), sb6, false);
                    }
                    filterLog("mPlayer init!");
                }
                if (VideoPrefsUtil.getMaterialMute()) {
                    PlayerUtil.stopPlayer(this.mPlayer);
                    return;
                } else {
                    PlayerUtil.startPlayer(this.mPlayer, z16);
                    return;
                }
            }
            return;
        }
        PlayerUtil.stopPlayer(this.mPlayer);
    }

    public void updateFilterPosition(PointF pointF) {
        this.mShowPosition = pointF;
    }

    public void updateFilterWidthAndHeight(int i3, int i16) {
        this.realWidth = i3;
        this.realHeight = i16;
    }

    public void updatePointAndScale(PointF pointF, float f16) {
        PointF pointF2 = this.anchor;
        pointF2.x = pointF.x;
        pointF2.y = pointF.y;
        this.mScaleFactor = f16;
    }

    protected void updatePositions(List<PointF> list, float[] fArr, float f16) {
        initPositionAdjusted();
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase, com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
        PTDetectInfo pTDetectInfo;
        if (obj instanceof PTDetectInfo) {
            pTDetectInfo = (PTDetectInfo) obj;
        } else {
            pTDetectInfo = null;
        }
        if (pTDetectInfo == null) {
            return;
        }
        filterLog("initialized:" + this.initialized + ", frameStartTime:" + this.frameStartTime + ", needChange:");
        updateActionTriggered(pTDetectInfo.timestamp);
        updatePositions(pTDetectInfo.facePoints, pTDetectInfo.faceAngles, pTDetectInfo.phoneAngle);
        updateTextureParam(pTDetectInfo.timestamp);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void updateVideoSize(int i3, int i16, double d16) {
        super.updateVideoSize(i3, i16, d16);
    }

    public void adjustPosition(double d16, double d17) {
        StickerItem stickerItem = this.item;
        if (stickerItem != null && stickerItem.position != null && this.item.position.length >= 2) {
            int i3 = this.width;
            int i16 = this.height;
            if (i3 / i16 >= 0.75d) {
                double d18 = i3 / 720.0d;
                int i17 = (int) (i3 / 0.75d);
                int i18 = (int) (i17 * this.item.position[1]);
                int i19 = (int) (this.width * this.item.position[0]);
                int i26 = i18 - ((i17 - this.height) / 2);
                double d19 = i26;
                double d26 = i19;
                setPositions(AlgoUtils.calPositions(i19, (float) ((this.item.height * d18) + d19), (float) ((this.item.width * d18) + d26), i26, this.width, this.height));
                this.anchor.x = (float) (d26 + ((this.item.width * d18) / 2.0d));
                this.anchor.y = (float) (d19 + ((this.item.height * d18) / 2.0d));
            } else {
                double d27 = i16 / 960.0d;
                int i27 = (int) (i16 * 0.75d);
                int i28 = (int) (i16 * this.item.position[1]);
                int i29 = ((int) (i27 * this.item.position[0])) - ((i27 - this.width) / 2);
                double d28 = i28;
                double d29 = i29;
                setPositions(AlgoUtils.calPositions(i29, (float) ((this.item.height * d27) + d28), (float) ((this.item.width * d27) + d29), i28, this.width, this.height));
                this.anchor.x = (float) (d29 + ((this.item.width * d27) / 2.0d));
                this.anchor.y = (float) (d28 + ((this.item.height * d27) / 2.0d));
            }
            if (SLog.isEnable()) {
                SLog.d("GestureTestUse", "should nerver run this clause");
                return;
            }
            return;
        }
        setPositions(GlUtil.EMPTY_POSITIONS);
    }
}
