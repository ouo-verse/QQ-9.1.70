package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StaticGestureFilter extends VideoFilterBase {
    public static final String TAG = "StaticGestureFilter";
    protected long frameStartTime;
    private boolean havePlayEnd;
    private boolean initialized;
    private StickerItem item;
    private int lastDecodeImageIndex;
    private int lastImageIndex;
    private boolean mAlwayslastFrame;
    public int mGestureAnimGapTime;
    public int mGestureAnimType;
    public int mGesturePointIndex;
    private String mGestureType;
    private int mItemCount;
    private long mLastReconizeTime;
    private PlayerUtil.Player mPlayer;
    protected UniformParam.TextureBitmapParam mTextureParam;
    protected String materialId;
    protected int playCount;
    float[] postion;
    private int[] tex;

    public StaticGestureFilter(StickerItem stickerItem, String str) {
        super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
        this.initialized = false;
        this.lastImageIndex = -1;
        this.lastDecodeImageIndex = -1;
        this.postion = new float[]{-1.0f, 1.0f, 1.0f, -1.0f};
        this.mGestureType = "qheart";
        this.mLastReconizeTime = 0L;
        this.havePlayEnd = false;
        this.mItemCount = 0;
        this.playCount = 0;
        this.mAlwayslastFrame = false;
        this.tex = new int[1];
        this.mGestureAnimType = -1;
        this.mGestureAnimGapTime = -1;
        this.mGesturePointIndex = -1;
        this.dataPath = str;
        stickerItem.playCount = 1;
        this.materialId = VideoMaterial.getMaterialId(str);
        setCurrentItem(stickerItem, 0);
        initParams();
    }

    public static void filterLog(String str) {
        if (SLog.isEnable()) {
            SLog.i(TAG, str);
        }
    }

    private int getCount(long j3) {
        int i3 = this.item.playCount;
        int max = (int) ((j3 - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0d));
        int i16 = this.item.frames;
        int i17 = this.playCount;
        if (max >= i16 * (i17 + 1)) {
            this.playCount = i17 + 1;
        }
        return max % Math.max(this.item.frames, 1);
    }

    private int getNextFrame(int i3) {
        boolean z16;
        boolean z17;
        Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(this.item.id, i3);
        if (loadImage == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.dataPath);
            String str = File.separator;
            sb5.append(str);
            sb5.append(this.item.subFolder);
            sb5.append(str);
            sb5.append(this.item.id);
            sb5.append("_");
            sb5.append(i3);
            sb5.append(".png");
            loadImage = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), sb5.toString(), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
            z16 = true;
        } else {
            z16 = false;
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
        StringBuilder sb6 = new StringBuilder();
        sb6.append("getNextFrame load cache:");
        sb6.append(!z16);
        sb6.append(", updateTexture:");
        sb6.append(z17);
        filterLog(sb6.toString());
        return this.tex[0];
    }

    private void resetAnimationStatus(long j3) {
        this.havePlayEnd = false;
        this.frameStartTime = j3;
        this.mAlwayslastFrame = false;
        this.mItemCount = -1;
        this.lastImageIndex = -1;
        this.lastDecodeImageIndex = -1;
    }

    private void updateTextureParam(long j3) {
        int count = getCount(j3);
        if (count == this.lastImageIndex) {
            filterLog("updateTextureParam return! + lastImageIndex:" + this.lastImageIndex + ";count is" + count + ":timestamp:=" + j3 + ":framestartTimes " + this.frameStartTime);
            return;
        }
        filterLog("updateTextureParam" + count);
        addParam(new UniformParam.TextureParam("inputImageTexture2", getNextFrame(count), 33986));
        this.lastImageIndex = count;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        super.ApplyGLSLFilter();
        int[] iArr = this.tex;
        GLES20.glGenTextures(iArr.length, iArr, 0);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void OnDrawFrameGLSL() {
        super.OnDrawFrameGLSL();
    }

    public void adjustPosition() {
        setPositions(AlgoUtils.calPositions(0.0f, 100.0f, 100.0f, 0.0f, 100, 100));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean canUseBlendMode() {
        return true;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void clearGLSLSelf() {
        if (SLog.isEnable()) {
            SLog.d("GestureTEST", "StaticGestureFilter clearGLSLSelf");
        }
        filterLog("clearGLSLSelf!");
        clearTextureParam();
        destroyAudio();
        this.mLastReconizeTime = 0L;
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
        this.mAlwayslastFrame = false;
        filterLog("clearTextureParam!");
    }

    public void destroyAudio() {
        filterLog("destroyAudio!");
        PlayerUtil.destroyPlayer(this.mPlayer);
        this.mPlayer = null;
    }

    public boolean hasAnimationEnd(long j3) {
        if (j3 - this.frameStartTime <= this.item.frames * this.item.frameDuration) {
            return false;
        }
        return true;
    }

    public boolean haveAnimationStart() {
        if (this.frameStartTime != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        addParam(new UniformParam.IntParam("texNeedTransform", -1));
        addParam(new UniformParam.IntParam(c.W, this.item.blendMode));
        addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        addParam(new UniformParam.Float2fParam("displacement", 0.0f, 0.0f));
        addParam(new UniformParam.IntParam("displacementEnableLut", 0));
    }

    public String printControllerInfo() {
        return "mGestureAnimType:=" + this.mGestureAnimType + ";" + this.mGestureAnimGapTime + ";" + this.mGesturePointIndex;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean renderTexture(int i3, int i16, int i17) {
        return super.renderTexture(i3, i16, i17);
    }

    public void setControllerInfo(int i3, int i16, int i17) {
        this.mGestureAnimType = i3;
        this.mGestureAnimGapTime = i16;
        this.mGesturePointIndex = i17;
    }

    public void setCurrentItem(StickerItem stickerItem, int i3) {
        this.item = stickerItem;
        this.lastImageIndex = -1;
        this.lastDecodeImageIndex = -1;
        this.playCount = 0;
        this.mItemCount = 0;
        this.mAlwayslastFrame = false;
        destroyAudio();
        VideoMemoryManager.getInstance().reset(stickerItem.id);
        filterLog("currentItem id:" + this.item.id);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean setRenderMode(int i3) {
        return super.setRenderMode(i3);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase, com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
        PTDetectInfo pTDetectInfo;
        boolean z16;
        if (obj instanceof PTDetectInfo) {
            pTDetectInfo = (PTDetectInfo) obj;
        } else {
            pTDetectInfo = null;
        }
        if (pTDetectInfo == null) {
            return;
        }
        boolean z17 = false;
        if (this.item.getTriggerTypeInt() == 1001 && this.item.type == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            GestureKeyInfo gestureInfo = GestureMgrRecognize.getInstance().getGestureInfo();
            if (gestureInfo != null && gestureInfo.vaild && gestureInfo.type.equalsIgnoreCase(GestureFilterManager.sGestureType)) {
                if (this.mLastReconizeTime == 0) {
                    this.frameStartTime = pTDetectInfo.timestamp;
                }
                this.mLastReconizeTime = pTDetectInfo.timestamp;
                z17 = true;
            }
        } else {
            z17 = z16;
        }
        if (z17) {
            if (hasAnimationEnd(pTDetectInfo.timestamp)) {
                resetAnimationStatus(pTDetectInfo.timestamp);
            }
            adjustPosition();
            updateTextureParam(pTDetectInfo.timestamp);
            return;
        }
        if (!hasAnimationEnd(pTDetectInfo.timestamp) && this.frameStartTime != 0) {
            adjustPosition();
            updateTextureParam(pTDetectInfo.timestamp);
            if (SLog.isEnable()) {
                SLog.d(TAG, "updatePreview continue");
                return;
            }
            return;
        }
        clearTextureParam();
        this.frameStartTime = 0L;
        this.mLastReconizeTime = 0L;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void updateVideoSize(int i3, int i16, double d16) {
        super.updateVideoSize(i3, i16, d16);
        setPositions(GlUtil.EMPTY_POSITIONS);
    }

    protected void updatePositions(List<PointF> list, float[] fArr, float f16) {
    }
}
