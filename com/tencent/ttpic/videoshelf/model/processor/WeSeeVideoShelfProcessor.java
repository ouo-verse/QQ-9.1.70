package com.tencent.ttpic.videoshelf.model.processor;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.video.AECoderFactory;
import com.tencent.ttpic.video.AEDecoder;
import com.tencent.ttpic.videoshelf.filter.VideoShelfAlphaFilter;
import com.tencent.ttpic.videoshelf.filter.VideoShelfMergeFilter;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import com.tencent.vbox.util.VideoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes27.dex */
public class WeSeeVideoShelfProcessor implements IVideoShelfProcessor {
    private static final String TAG = "WeSeeVideoShelfProcessor";
    public static final String WESEE_VS_LUT_PATH = "WeSeeVideoShelfProcessor_2";
    public static final String WESEE_VS_VIDEO_PATH = "WeSeeVideoShelfProcessor_1";
    public static final String WESEE_VS_VIDEO_TEMPLATE_TYPE = "WeSeeVideoShelfProcessor_3";
    private VideoShelfAlphaFilter alphaFilter;
    private int canvasH;
    private int canvasW;
    private int mDecodeTexture;
    private BaseFilter mEffectFilter;
    private String mInputVideo;
    private String mLutPath;
    private AEDecoder mVideoDecoder;
    private int mVideoTemplateType;
    private VideoShelfMergeFilter mergeFilter;
    private Frame mergeFrame = new Frame();
    private Frame effectFilterFrame = new Frame();
    private Frame mAlphaFrame = new Frame();
    private List<Long> mFrameStamps = new ArrayList();
    private int mFrameIndex = 0;

    private void initLutFilter(String str) {
        Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str, 1);
        if (decodeSampleBitmap == null) {
            decodeSampleBitmap = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(str);
        }
        BaseFilter lutFilterWithBitmap = TTPicFilterFactoryLocal.lutFilterWithBitmap(decodeSampleBitmap);
        this.mEffectFilter = lutFilterWithBitmap;
        if (lutFilterWithBitmap == null) {
            return;
        }
        lutFilterWithBitmap.needFlipBlend = true;
        lutFilterWithBitmap.setSrcFilterIndex(-1);
        this.mEffectFilter.applyFilterChain(true, 1.0f, 1.0f);
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public void clear() {
        AEDecoder aEDecoder = this.mVideoDecoder;
        if (aEDecoder != null) {
            aEDecoder.release();
            this.mVideoDecoder = null;
        }
        VideoShelfAlphaFilter videoShelfAlphaFilter = this.alphaFilter;
        if (videoShelfAlphaFilter != null) {
            videoShelfAlphaFilter.clearGLSLSelf();
            this.alphaFilter = null;
        }
        VideoShelfMergeFilter videoShelfMergeFilter = this.mergeFilter;
        if (videoShelfMergeFilter != null) {
            videoShelfMergeFilter.clearGLSLSelf();
            this.mergeFilter = null;
        }
        BaseFilter baseFilter = this.mEffectFilter;
        if (baseFilter != null) {
            baseFilter.clearGLSLSelf();
        }
        this.effectFilterFrame.clear();
        this.mAlphaFrame.clear();
        Frame frame = this.mergeFrame;
        if (frame != null) {
            frame.clear();
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public Frame draw() {
        VideoShelfAlphaFilter videoShelfAlphaFilter = this.alphaFilter;
        if (videoShelfAlphaFilter != null && this.mergeFilter != null) {
            videoShelfAlphaFilter.updateVideoTemplateType(this.mVideoTemplateType);
            this.alphaFilter.RenderProcess(this.mDecodeTexture, this.canvasW, this.canvasH, -1, 0.0d, this.mAlphaFrame);
            Frame frame = this.mAlphaFrame;
            this.mergeFilter.update(this.mFrameIndex);
            Frame updateAndRender = this.mergeFilter.updateAndRender(frame.getTextureId(), this.canvasW, this.canvasH);
            this.mergeFrame = updateAndRender;
            BaseFilter baseFilter = this.mEffectFilter;
            if (baseFilter != null) {
                baseFilter.RenderProcess(updateAndRender.getTextureId(), this.canvasW, this.canvasH, -1, 0.0d, this.effectFilterFrame);
                updateAndRender = this.effectFilterFrame;
            }
            GLES20.glFinish();
            return updateAndRender;
        }
        return null;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public long getCurFrameTimeStamp() {
        if (this.mFrameIndex < this.mFrameStamps.size()) {
            return this.mFrameStamps.get(this.mFrameIndex).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public int getProgress() {
        long longValue = this.mFrameStamps.get(this.mFrameIndex).longValue() * 100;
        List<Long> list = this.mFrameStamps;
        int longValue2 = (int) (longValue / list.get(list.size() - 1).longValue());
        if (longValue2 <= 1) {
            return 1;
        }
        return longValue2;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public void init(int[] iArr, List<VideoFrameItem> list, List<NodeGroup> list2) {
        this.mDecodeTexture = iArr[0];
        if (!TextUtils.isEmpty(this.mLutPath)) {
            initLutFilter(this.mLutPath);
        }
        VideoShelfAlphaFilter videoShelfAlphaFilter = new VideoShelfAlphaFilter();
        this.alphaFilter = videoShelfAlphaFilter;
        videoShelfAlphaFilter.ApplyGLSLFilter();
        VideoShelfMergeFilter videoShelfMergeFilter = new VideoShelfMergeFilter(list, list2);
        this.mergeFilter = videoShelfMergeFilter;
        videoShelfMergeFilter.ApplyGLSLFilter();
        List<Long> framestamps = VideoUtil.getFramestamps(this.mInputVideo);
        this.mFrameStamps = framestamps;
        if (framestamps != null) {
            Collections.sort(framestamps);
        }
        AEDecoder createDecoder = AECoderFactory.createDecoder(this.mInputVideo);
        this.mVideoDecoder = createDecoder;
        createDecoder.setTexture(this.mDecodeTexture);
        this.mFrameIndex = 0;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public int isPrepareInit() {
        File file = new File(this.mInputVideo);
        if (!TextUtils.isEmpty(this.mInputVideo) && file.exists()) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public int parseFrame() {
        AEDecoder aEDecoder = this.mVideoDecoder;
        if (aEDecoder != null) {
            return aEDecoder.getNextFrameTexture();
        }
        return -1;
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public void setParam(String str, Object obj) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1549738368:
                if (str.equals(IVideoShelfProcessor.OUT_VIDEO_WIDTH_HEIGHT)) {
                    c16 = 0;
                    break;
                }
                break;
            case -825523120:
                if (str.equals(WESEE_VS_VIDEO_PATH)) {
                    c16 = 1;
                    break;
                }
                break;
            case -825523119:
                if (str.equals(WESEE_VS_LUT_PATH)) {
                    c16 = 2;
                    break;
                }
                break;
            case -825523118:
                if (str.equals(WESEE_VS_VIDEO_TEMPLATE_TYPE)) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                if (obj != null && (obj instanceof int[])) {
                    int[] iArr = (int[]) obj;
                    this.canvasW = iArr[0];
                    this.canvasH = iArr[1];
                    return;
                }
                return;
            case 1:
                if (obj != null && (obj instanceof String)) {
                    this.mInputVideo = (String) obj;
                    return;
                }
                return;
            case 2:
                if (obj != null && (obj instanceof String)) {
                    this.mLutPath = (String) obj;
                    return;
                }
                return;
            case 3:
                if (obj != null && (obj instanceof Integer)) {
                    this.mVideoTemplateType = ((Integer) obj).intValue();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor
    public boolean updateFrameCursor() {
        if (this.mFrameIndex < this.mFrameStamps.size() - 2) {
            this.mFrameIndex++;
            return true;
        }
        return false;
    }
}
