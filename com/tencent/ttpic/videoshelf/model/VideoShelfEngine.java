package com.tencent.ttpic.videoshelf.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.baseutils.thread.HandlerThreadTag;
import com.tencent.ttpic.video.AECoderFactory;
import com.tencent.ttpic.video.AEEncoder;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.processor.IVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.model.processor.PagVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.model.processor.WeSeeVideoShelfProcessor;
import com.tencent.ttpic.videoshelf.model.template.VideoFrameItem;
import com.tencent.view.FilterContext;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoShelfEngine {
    private static final int DECODE = 102;
    private static final int DESTROY_GLCONTEXT = 106;
    private static final int DRAW = 103;
    private static final int ENCODE = 104;
    private static final int ERR_DECODE = -1;
    private static final int INIT_GLCONTEXT = 100;
    private static final int QUIT = 107;
    private static final int REQUEST_CANCEL_SAVE = 108;
    private static final int START_SAVE = 101;
    private static final int STOP = 105;
    private static final String TAG = "VideoShelfEngine";
    public static final int VIDEO_SHELF_VERSION_PAG = 1;
    public static final int VIDEO_SHELF_VERSION_WESEE = 0;
    private int canvasH;
    private int canvasW;
    private int decodeTexture;
    private boolean enableWatermark;
    private Frame encodeFrame;
    private int encodeTexture;
    private ReentrantLock lock;
    private Callback mCallback;
    private FilterContext mFilterContext;
    private Handler mHandler;
    private boolean mIsNotNeedFile;
    private Handler.Callback mMessageCallback;
    private List<NodeGroup> mNodeGroupList;
    private String mOutputVideo;
    private boolean mRequestCancel;
    private AEEncoder mVideoEncoder;
    private List<VideoFrameItem> mVideoFrameItemList;
    private IVideoShelfProcessor mVideoShelfProcessor;
    private Bitmap watermarkBmp;
    private BaseFilter watermarkFilter;
    private String watermarkPath;
    private float[] watermarkPosition;
    private float[] watermarkRect;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Callback {
        void onCancelCompleted();

        void onCompleted();

        void onError(int i3, int i16, String str);

        void onProgress(int i3);

        void onStartGenerate();
    }

    @Deprecated
    public VideoShelfEngine() throws PagNotSupportSystemException {
        this(0);
    }

    private float[] calcWatermarkPosition(float[] fArr, int i3, int i16) {
        float f16;
        float f17;
        if (!BitmapUtils.isLegal(this.watermarkBmp)) {
            Log.e(TAG, "watermark bitmap illeagal.");
            return this.watermarkPosition;
        }
        float width = this.watermarkBmp.getWidth();
        float height = this.watermarkBmp.getHeight();
        if ((fArr != null && fArr.length == 0) || fArr == null) {
            f16 = (i3 / 2) - (this.watermarkBmp.getWidth() / 2);
            f17 = (i16 - 30.0f) - this.watermarkBmp.getHeight();
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        if (fArr != null) {
            if (fArr.length == 1) {
                f16 = (i3 / 2) - (this.watermarkBmp.getWidth() / 2);
                f17 = fArr[0];
            } else if (fArr.length == 2) {
                f16 = fArr[0];
                f17 = fArr[1];
            } else if (fArr.length == 3) {
                f16 = fArr[0];
                f17 = fArr[1];
                width = fArr[2];
            } else if (fArr.length >= 4) {
                f16 = fArr[0];
                f17 = fArr[1];
                width = fArr[2];
                height = fArr[3];
            }
        }
        float[] fArr2 = this.watermarkPosition;
        float f18 = i3;
        float f19 = ((f16 / f18) * 2.0f) - 1.0f;
        fArr2[0] = f19;
        float f26 = i16;
        float f27 = ((f17 / f26) * 2.0f) - 1.0f;
        fArr2[1] = f27;
        fArr2[2] = f19;
        float f28 = (((f17 + height) / f26) * 2.0f) - 1.0f;
        fArr2[3] = f28;
        float f29 = (((f16 + width) / f18) * 2.0f) - 1.0f;
        fArr2[4] = f29;
        fArr2[5] = f28;
        fArr2[6] = f29;
        fArr2[7] = f27;
        return fArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decodeFrame() {
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor != null) {
            return iVideoShelfProcessor.parseFrame();
        }
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void draw() {
        Frame frame;
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor != null) {
            frame = iVideoShelfProcessor.draw();
        } else {
            frame = null;
        }
        this.encodeFrame = frame;
        this.lock.lock();
        try {
            if (this.encodeFrame != null && this.watermarkFilter != null && this.enableWatermark) {
                int createTexture = RendererUtils.createTexture(this.watermarkBmp);
                GlUtil.setBlendMode(true);
                this.watermarkFilter.setPositions(this.watermarkPosition);
                BaseFilter baseFilter = this.watermarkFilter;
                Frame frame2 = this.encodeFrame;
                baseFilter.RenderProcess(createTexture, frame2.width, frame2.height, -1, 0.0d, frame2);
                GlUtil.setBlendMode(false);
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encodeFrame() {
        Frame frame = this.encodeFrame;
        if (frame != null && this.mVideoShelfProcessor != null) {
            this.mVideoEncoder.writeFrame(frame.getTextureId(), this.mVideoShelfProcessor.getCurFrameTimeStamp());
            if (this.mCallback != null) {
                this.mCallback.onProgress(this.mVideoShelfProcessor.getProgress());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor != null) {
            iVideoShelfProcessor.clear();
        }
        AEEncoder aEEncoder = this.mVideoEncoder;
        if (aEEncoder != null) {
            aEEncoder.release();
        }
        this.lock.lock();
        try {
            BaseFilter baseFilter = this.watermarkFilter;
            if (baseFilter != null) {
                baseFilter.clearGLSLSelf();
                this.watermarkFilter = null;
            }
            this.lock.unlock();
            BitmapUtils.recycle(this.watermarkBmp);
            GLES20.glDeleteBuffers(2, new int[]{this.decodeTexture, this.encodeTexture}, 0);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessage(106);
                this.mHandler.sendEmptyMessage(107);
            }
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    public void cancelSave() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(108);
        }
    }

    public String getOutputVideoPath() {
        return this.mOutputVideo;
    }

    public void init() {
        int[] iArr = new int[2];
        GlUtil.glGenTextures(2, iArr, 0);
        this.decodeTexture = iArr[0];
        this.encodeTexture = iArr[1];
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor != null) {
            iVideoShelfProcessor.init(iArr, this.mVideoFrameItemList, this.mNodeGroupList);
        }
        this.mVideoEncoder = AECoderFactory.createEncoder(this.mOutputVideo, this.canvasW, this.canvasH);
        BaseFilter baseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.watermarkFilter = baseFilter;
        baseFilter.apply();
    }

    public void save(int i3, int i16) {
        this.mHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(HandlerThreadTag.VIDEO_SHELF_SAVE).getLooper(), this.mMessageCallback);
        this.canvasW = i3;
        this.canvasH = i16;
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor != null) {
            iVideoShelfProcessor.setParam(IVideoShelfProcessor.OUT_VIDEO_WIDTH_HEIGHT, new int[]{i3, i16});
        }
        this.mHandler.sendEmptyMessage(100);
        this.mHandler.sendEmptyMessage(101);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setLutPath(String str) {
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor instanceof WeSeeVideoShelfProcessor) {
            iVideoShelfProcessor.setParam(WeSeeVideoShelfProcessor.WESEE_VS_LUT_PATH, str);
        }
    }

    public void setNodeGroupItemList(List<NodeGroup> list) {
        this.mNodeGroupList = list;
    }

    public void setOutputVideoPath(String str) {
        this.mOutputVideo = str;
    }

    public void setParam(String str, Object obj) {
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor != null) {
            iVideoShelfProcessor.setParam(str, obj);
        }
    }

    public void setSrcPath(String str) {
        String str2;
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor instanceof PagVideoShelfProcessor) {
            str2 = PagVideoShelfProcessor.PAG_FILE_PATH;
        } else {
            str2 = WeSeeVideoShelfProcessor.WESEE_VS_VIDEO_PATH;
        }
        iVideoShelfProcessor.setParam(str2, str);
    }

    public void setVideoFrameItemList(List<VideoFrameItem> list) {
        this.mVideoFrameItemList = list;
    }

    public void setVideoTemplateType(int i3) {
        IVideoShelfProcessor iVideoShelfProcessor = this.mVideoShelfProcessor;
        if (iVideoShelfProcessor instanceof WeSeeVideoShelfProcessor) {
            iVideoShelfProcessor.setParam(WeSeeVideoShelfProcessor.WESEE_VS_VIDEO_TEMPLATE_TYPE, Integer.valueOf(i3));
        }
    }

    public void setWatermarkEnable(boolean z16) {
        this.enableWatermark = z16;
    }

    public void setWatermarkPath(String str) {
        this.watermarkPath = str;
    }

    public void setWatermarkRect(float[] fArr) {
        this.watermarkRect = fArr;
    }

    public VideoShelfEngine(int i3) throws PagNotSupportSystemException {
        this.mVideoFrameItemList = new ArrayList();
        this.mNodeGroupList = new ArrayList();
        this.enableWatermark = false;
        this.watermarkBmp = null;
        this.watermarkRect = null;
        this.watermarkPosition = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mIsNotNeedFile = false;
        this.lock = new ReentrantLock();
        this.mMessageCallback = new Handler.Callback() { // from class: com.tencent.ttpic.videoshelf.model.VideoShelfEngine.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x018d, code lost:
            
                return false;
             */
            @Override // android.os.Handler.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean handleMessage(Message message) {
                int isPrepareInit;
                switch (message.what) {
                    case 100:
                        VideoShelfEngine.this.mFilterContext = new FilterContext();
                        VideoShelfEngine.this.mFilterContext.usecurruntContext();
                        if (VideoShelfEngine.this.mVideoShelfProcessor instanceof PagVideoShelfProcessor) {
                            VideoShelfEngine.this.mVideoShelfProcessor.setParam(PagVideoShelfProcessor.PAG_CONTENT_OBJ, VideoShelfEngine.this.mFilterContext);
                            break;
                        }
                        break;
                    case 101:
                        if (VideoShelfEngine.this.mIsNotNeedFile) {
                            isPrepareInit = 0;
                        } else {
                            isPrepareInit = VideoShelfEngine.this.mVideoShelfProcessor.isPrepareInit();
                        }
                        if (VideoShelfEngine.this.mVideoShelfProcessor != null && isPrepareInit <= 0) {
                            VideoShelfEngine.this.mCallback.onStartGenerate();
                            if (VideoShelfEngine.this.mCallback != null) {
                                VideoShelfEngine.this.mCallback.onProgress(1);
                            }
                            VideoShelfEngine.this.init();
                            VideoShelfEngine.this.mHandler.sendEmptyMessage(102);
                            break;
                        } else {
                            VideoShelfEngine.this.mCallback.onError(-1, isPrepareInit, "file not exit or app version is low.");
                            VideoShelfEngine.this.mHandler.sendEmptyMessage(105);
                            break;
                        }
                    case 102:
                        if (VideoShelfEngine.this.mVideoShelfProcessor != null && VideoShelfEngine.this.mVideoShelfProcessor.getProgress() >= 100) {
                            VideoShelfEngine.this.mHandler.sendEmptyMessage(105);
                        }
                        if (VideoShelfEngine.this.decodeFrame() < 0) {
                            VideoShelfEngine.this.mCallback.onError(-1, 0, "decode error");
                            VideoShelfEngine.this.mHandler.sendEmptyMessage(105);
                            break;
                        } else {
                            VideoShelfEngine.this.mHandler.sendEmptyMessage(103);
                            break;
                        }
                        break;
                    case 103:
                        VideoShelfEngine.this.draw();
                        VideoShelfEngine.this.mHandler.sendEmptyMessage(104);
                        break;
                    case 104:
                        if (!VideoShelfEngine.this.mRequestCancel) {
                            VideoShelfEngine.this.encodeFrame();
                            if (VideoShelfEngine.this.mVideoShelfProcessor != null && VideoShelfEngine.this.mVideoShelfProcessor.updateFrameCursor()) {
                                VideoShelfEngine.this.mHandler.sendEmptyMessage(102);
                                break;
                            } else {
                                VideoShelfEngine.this.mHandler.sendEmptyMessage(105);
                                break;
                            }
                        } else {
                            VideoShelfEngine.this.mHandler.sendEmptyMessage(105);
                            break;
                        }
                    case 105:
                        VideoShelfEngine.this.stop();
                        break;
                    case 106:
                        VideoShelfEngine.this.mFilterContext.destroyEgl();
                        break;
                    case 107:
                        if (VideoShelfEngine.this.mRequestCancel) {
                            VideoShelfEngine.this.mCallback.onCancelCompleted();
                        } else {
                            VideoShelfEngine.this.mCallback.onCompleted();
                        }
                        VideoShelfEngine.this.mRequestCancel = false;
                        VideoShelfEngine.this.mHandler.removeCallbacksAndMessages(null);
                        HandlerThreadManager.getInstance().destroyHandlerThread(HandlerThreadTag.VIDEO_SHELF_SAVE);
                        break;
                    case 108:
                        VideoShelfEngine.this.mRequestCancel = true;
                        VideoShelfEngine.this.stop();
                        break;
                }
            }
        };
        if (i3 == 0) {
            this.mVideoShelfProcessor = new WeSeeVideoShelfProcessor();
        } else {
            if (i3 != 1) {
                return;
            }
            this.mVideoShelfProcessor = new PagVideoShelfProcessor();
        }
    }

    public VideoShelfEngine(boolean z16) throws PagNotSupportSystemException {
        this(1);
        this.mIsNotNeedFile = z16;
    }
}
