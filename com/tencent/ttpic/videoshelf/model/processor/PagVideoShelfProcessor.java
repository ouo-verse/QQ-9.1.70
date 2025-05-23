package com.tencent.ttpic.videoshelf.model.processor;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.libpag.PagUtil;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import com.tencent.view.FilterContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;

/* loaded from: classes27.dex */
public class PagVideoShelfProcessor implements IVideoShelfProcessor, SurfaceTexture.OnFrameAvailableListener {
    private static final int MAX_FRAME_PER = 25;
    public static final String PAG_CONTENT_OBJ = "PagVideoShelfProcessor_1";
    public static final String PAG_FILE_DURATION = "PagVideoShelfProcessor_3";
    public static final String PAG_FILE_PATH = "PagVideoShelfProcessor_0";
    public static final String PAG_IMG_LIST = "PagVideoShelfProcessor_4";
    public static final String PAG_RENDER_OBJ = "PagVideoShelfProcessor_2";
    private static final float PER_FRAME_GAP = 40000.0f;
    private static final String TAG = "PagVideoShelfProcessor";
    private FilterContext mFilterContext;
    private float mFrameGap;
    private Frame mOutFrame;
    private PAGFile mPagFile;
    private String mPagFilePath;
    private PAGRenderer mPagRenderer;
    private PAGSurface mPagSurface;
    private int mParsedTxtID;
    private HashMap<String, int[]> mReplaceImgs;
    private SurfaceTexture mSurfaceTexture;
    private int mVideoHeight;
    private int mVideoWidth;
    private double mProgress = 0.0d;
    private double mLastFlushProgress = -1.0d;
    private long mDuration = 0;
    private boolean mNeedUpdateFrame = false;
    private BaseFilter copyFilter = new SurfaceTextureFilter();
    private int mDrawCount = 0;
    private int mGetFpsCount = 0;

    public PagVideoShelfProcessor() throws PagNotSupportSystemException {
        if (PagUtil.isSupportPagForVideo()) {
        } else {
            throw new PagNotSupportSystemException(TAG);
        }
    }

    private long getDuration() {
        PAGFile pAGFile;
        float f16;
        if (this.mDuration == 0 && (pAGFile = this.mPagFile) != null) {
            this.mDuration = pAGFile.duration();
            TTPTLogger.i(TAG, "duration:" + this.mDuration);
            long j3 = this.mDuration;
            if (j3 > 0) {
                f16 = PER_FRAME_GAP / ((float) j3);
            } else {
                f16 = 0.0f;
            }
            this.mFrameGap = f16;
        }
        return this.mDuration;
    }

    private void parseImageText(List<NodeGroup> list) {
        Bitmap bitmap;
        if (list != null && list.size() != 0) {
            Iterator<NodeGroup> it = list.iterator();
            while (it.hasNext()) {
                for (NodeItem nodeItem : it.next().nodeItemList) {
                    if (nodeItem.type == 1) {
                        bitmap = nodeItem.bitmap;
                    } else {
                        bitmap = nodeItem.cropBitmap;
                    }
                    replacesImg(bitmap, nodeItem.indexLayerForPag);
                }
            }
        }
    }

    private void proceeHashMapSetting(HashMap<String, int[]> hashMap) {
        if (hashMap == null) {
            return;
        }
        if (this.mPagRenderer == null) {
            this.mReplaceImgs = hashMap;
            return;
        }
        this.mReplaceImgs = hashMap;
        for (Map.Entry<String, int[]> entry : hashMap.entrySet()) {
            Bitmap decodeSampledBitmapFromFile = BitmapUtils.decodeSampledBitmapFromFile(entry.getKey(), 1080, 1080);
            replacesImg(decodeSampledBitmapFromFile, entry.getValue());
            if (decodeSampledBitmapFromFile != null) {
                decodeSampledBitmapFromFile.recycle();
            }
        }
    }

    private void replacesImg(Bitmap bitmap, int[] iArr) {
        try {
            if (this.mPagRenderer != null && bitmap != null && !bitmap.isRecycled() && iArr != null) {
                PAGImage FromBitmap = PAGImage.FromBitmap(bitmap);
                FromBitmap.setScaleMode(3);
                for (int i3 : iArr) {
                    if (i3 < this.mPagFile.numImages()) {
                        this.mPagRenderer.replaceImage(i3, FromBitmap);
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public void clear() {
        TTPTLogger.i(TAG, "clear:" + this.mProgress);
        this.mFilterContext = null;
        PAGRenderer pAGRenderer = this.mPagRenderer;
        if (pAGRenderer != null) {
            pAGRenderer.setSurface((PAGSurface) null);
        }
        PAGSurface pAGSurface = this.mPagSurface;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        this.mParsedTxtID = 0;
        BaseFilter baseFilter = this.copyFilter;
        if (baseFilter != null) {
            baseFilter.clearGLSL();
        }
        this.mProgress = 0.0d;
        this.mLastFlushProgress = -1.0d;
        this.mNeedUpdateFrame = false;
        this.mDrawCount = 0;
        this.mGetFpsCount = 0;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public Frame draw() {
        if (this.mPagRenderer == null || !this.mNeedUpdateFrame) {
            return null;
        }
        this.mOutFrame = this.copyFilter.RenderProcess(this.mParsedTxtID, this.mVideoWidth, this.mVideoHeight);
        GLES20.glFinish();
        this.mNeedUpdateFrame = false;
        this.mDrawCount++;
        return this.mOutFrame;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public long getCurFrameTimeStamp() {
        return (long) (this.mProgress * this.mDuration * 0.001d);
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public int getProgress() {
        int i3 = (int) (this.mProgress * 100.0d);
        if (i3 <= 1) {
            return 1;
        }
        return i3;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public void init(int[] iArr, List<VideoFrameItem> list, List<NodeGroup> list2) {
        TTPTLogger.i(TAG, "init.");
        this.mParsedTxtID = iArr[0];
        this.copyFilter.apply();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mParsedTxtID);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(this.mVideoWidth, this.mVideoHeight);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        PAGSurface FromSurfaceTexture = PAGSurface.FromSurfaceTexture(this.mSurfaceTexture);
        this.mPagSurface = FromSurfaceTexture;
        this.mPagRenderer.setSurface(FromSurfaceTexture);
        this.mPagRenderer.setMaxFrameRate(25.0f);
        parseImageText(list2);
        proceeHashMapSetting(this.mReplaceImgs);
        if (this.mPagFile != null) {
            this.mDuration = getDuration();
            this.mPagRenderer.setFile(this.mPagFile);
            this.mPagRenderer.setProgress(0.0d);
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public int isPrepareInit() {
        PAGFile Load = PagViewMonitor.Load(this.mPagFilePath);
        this.mPagFile = Load;
        if (Load != null) {
            if (Load.tagLevel() > PAGFile.MaxSupportedTagLevel()) {
                return 2;
            }
            this.mPagRenderer = new PAGRenderer();
            if (AEOfflineConfig.isNeedSoftDecode()) {
                PagUtil.useSoftDecode();
                return 0;
            }
            return 0;
        }
        return 1;
    }

    public boolean makeCurrent() {
        FilterContext filterContext = this.mFilterContext;
        if (filterContext != null) {
            filterContext.usecurruntContext();
            return true;
        }
        return false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        if (makeCurrent() && (surfaceTexture2 = this.mSurfaceTexture) != null) {
            surfaceTexture2.updateTexImage();
            this.mNeedUpdateFrame = true;
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public int parseFrame() {
        if (!this.mNeedUpdateFrame && this.mDrawCount == this.mGetFpsCount && this.mProgress > this.mLastFlushProgress) {
            boolean flush = this.mPagRenderer.flush();
            Log.i(TAG, "parseFrame:flush:" + this.mProgress);
            if (!flush) {
                this.mNeedUpdateFrame = true;
            }
            this.mLastFlushProgress = this.mProgress;
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public void setParam(String str, Object obj) {
        float f16;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1549738368:
                if (str.equals(IVideoShelfProcessor.OUT_VIDEO_WIDTH_HEIGHT)) {
                    c16 = 0;
                    break;
                }
                break;
            case -148748546:
                if (str.equals(PAG_FILE_PATH)) {
                    c16 = 1;
                    break;
                }
                break;
            case -148748545:
                if (str.equals(PAG_CONTENT_OBJ)) {
                    c16 = 2;
                    break;
                }
                break;
            case -148748544:
                if (str.equals(PAG_RENDER_OBJ)) {
                    c16 = 3;
                    break;
                }
                break;
            case -148748543:
                if (str.equals(PAG_FILE_DURATION)) {
                    c16 = 4;
                    break;
                }
                break;
            case -148748542:
                if (str.equals(PAG_IMG_LIST)) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                if (obj != null && (obj instanceof int[])) {
                    int[] iArr = (int[]) obj;
                    this.mVideoWidth = iArr[0];
                    this.mVideoHeight = iArr[1];
                    return;
                }
                return;
            case 1:
                if (obj instanceof String) {
                    this.mPagFilePath = (String) obj;
                    return;
                }
                return;
            case 2:
                if (obj != null && (obj instanceof FilterContext)) {
                    this.mFilterContext = (FilterContext) obj;
                    return;
                }
                return;
            case 3:
                if (obj != null && (obj instanceof PAGRenderer)) {
                    this.mPagRenderer = (PAGRenderer) obj;
                    if (AEOfflineConfig.isNeedSoftDecode()) {
                        PagUtil.useSoftDecode();
                    }
                    PAGSurface pAGSurface = this.mPagSurface;
                    if (pAGSurface != null) {
                        this.mPagRenderer.setSurface(pAGSurface);
                    }
                    this.mProgress = this.mPagRenderer.getProgress();
                    return;
                }
                return;
            case 4:
                if (obj != null && (obj instanceof Long)) {
                    long longValue = ((Long) obj).longValue();
                    this.mDuration = longValue;
                    if (longValue > 0) {
                        f16 = PER_FRAME_GAP / ((float) longValue);
                    } else {
                        f16 = 0.0f;
                    }
                    this.mFrameGap = f16;
                    return;
                }
                return;
            case 5:
                if (obj != null && (obj instanceof HashMap)) {
                    proceeHashMapSetting((HashMap) obj);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public boolean updateFrameCursor() {
        if (!this.mNeedUpdateFrame) {
            int i3 = this.mDrawCount;
            int i16 = this.mGetFpsCount;
            if (i3 > i16) {
                double d16 = this.mProgress;
                if (d16 < 1.0d) {
                    this.mProgress = d16 + this.mFrameGap;
                    this.mGetFpsCount = i16 + 1;
                    Frame frame = this.mOutFrame;
                    if (frame != null) {
                        frame.unlock();
                    }
                    PAGRenderer pAGRenderer = this.mPagRenderer;
                    if (pAGRenderer != null) {
                        double d17 = this.mProgress;
                        if (d17 <= 1.0d) {
                            pAGRenderer.setProgress(d17);
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
