package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes18.dex */
public class PreviewContext {
    public static final boolean SG_SUPPORT_CALLBACK = true;
    private static final String TAG = "PreviewContext";
    public static final boolean USE_USER_BUFFER = true;
    private static final int sCheckSizeLimt = 32;
    AVCodec mAVCodec;
    public boolean mActivtiyDestory;
    public CameraProxy mCamera;
    private boolean mCheckedDataValid;
    private boolean mDisablePrivilage;
    private volatile boolean mFrameProcessEnd;
    private boolean mInitHwEncode;
    public boolean notifyFirstFrame = false;
    List<AVIOStruct> mFrameSrcList = new ArrayList();
    private AVIOStruct mPTVRealBeautyCache = new AVIOStruct();
    Object mlockFrame = new Object();
    private int mFrameIndex = 0;
    int mWriteFrameCount = 0;
    int mBlockIndex = 0;
    int mLastFrameIndex = 0;
    ArrayList<Integer> mFrameCountArray = new ArrayList<>();
    private int mRecordToCache = 0;
    public Handler mMsghandler = null;
    public boolean mPTVRealBeauty = false;
    public AtomicInteger mVideoFrameWrite = new AtomicInteger(0);
    public AtomicInteger mVideoFrameProcess = new AtomicInteger(0);
    long updateTime = 0;
    int frameCount = 0;
    int fps = 0;
    public AtomicReference<SVHwEncoder> mEncodeRef = new AtomicReference<>(null);
    private long[] mTimeStamp = new long[1];
    private Object mlock = new Object();

    /* loaded from: classes18.dex */
    public class HandleVideo implements Runnable {
        public HandleVideo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PreviewContext.this.mEncodeRef.get() != null) {
                if (PreviewContext.this.mInitHwEncode) {
                    PreviewContext.this.mAVCodec.handleQQVideoFrameWithCallback();
                    if (QLog.isColorLevel()) {
                        QLog.d(PreviewContext.TAG, 2, "[@] HandleVideo: handleQQVideoFrameWithCallback");
                    }
                } else {
                    PreviewContext.this.mAVCodec.handleQQVideoOneFrame();
                    if (QLog.isColorLevel()) {
                        QLog.d(PreviewContext.TAG, 2, "[@] HandleVideo: handleQQVideoOneFrame");
                    }
                    PreviewContext.this.encodeOneFrameNotify();
                }
            } else {
                PreviewContext.this.mAVCodec.handleQQVideo();
                if (QLog.isColorLevel()) {
                    QLog.d(PreviewContext.TAG, 2, "[@] HandleVideo: encode=null");
                }
            }
            PreviewContext.this.mCamera.L.c(7, 0);
            PreviewContext.this.mVideoFrameProcess.incrementAndGet();
        }
    }

    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f288178a;

        /* renamed from: b, reason: collision with root package name */
        public AVIOStruct f288179b;
    }

    public PreviewContext(CameraProxy cameraProxy, int i3, int i16) {
        this.mAVCodec = null;
        this.mActivtiyDestory = false;
        this.mCheckedDataValid = false;
        this.mDisablePrivilage = false;
        this.mInitHwEncode = false;
        this.mFrameProcessEnd = false;
        this.mAVCodec = c.b().c();
        this.mActivtiyDestory = false;
        this.mCamera = cameraProxy;
        cameraProxy.f288139f = i3;
        cameraProxy.f288140h = i16;
        this.mInitHwEncode = initHwCallBackSecurity();
        this.mFrameProcessEnd = false;
        this.mVideoFrameWrite.getAndSet(0);
        this.mVideoFrameProcess.getAndSet(0);
        this.mCheckedDataValid = false;
        this.mDisablePrivilage = false;
    }

    public static boolean checkIsDisablePrivilage(byte[] bArr, int i3) {
        if (bArr == null || bArr.length < i3) {
            return true;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 += bArr[i17] & 255;
        }
        for (int length = bArr.length - i3; length < bArr.length; length++) {
            i16 += bArr[length] & 255;
        }
        if (i16 == 0) {
            return true;
        }
        return false;
    }

    private boolean checkPreviewDataLength(AVIOStruct aVIOStruct, byte[] bArr) {
        int i3 = aVIOStruct.vHeight;
        int i16 = aVIOStruct.vWidth;
        int i17 = aVIOStruct.vFormat;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[@] checkPreviewDataLength,height = " + i3 + ",width = " + i16 + ",imgFmt = " + i17 + ",data.length = " + bArr.length + " Build.MODEL=" + DeviceInfoMonitor.getModel() + " Build.CPU_ABI=" + Build.CPU_ABI);
        }
        if (i17 != 4 && i17 != 20) {
            if (i17 != 842094169) {
                if (i17 != 16) {
                    if (i17 != 17) {
                        if (!QLog.isColorLevel()) {
                            return true;
                        }
                        QLog.d(TAG, 2, "[@] checkPreviewDataLength error 3,imgFmt  = " + i17);
                        return true;
                    }
                }
            }
            if (((i16 * i3) * 3) / 2 != bArr.length) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.d(TAG, 2, "[@] checkPreviewDataLength error 2 [Build.MODEL=" + DeviceInfoMonitor.getModel() + "]");
                return true;
            }
            return false;
        }
        if (i16 * i3 * 2 != bArr.length) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.d(TAG, 2, "[@] checkPreviewDataLength error 1 [Build.MODEL=" + DeviceInfoMonitor.getModel() + "]");
            return true;
        }
        return false;
    }

    private native int getProcessedFrameData(byte[] bArr, long[] jArr, int i3);

    private native boolean initHwCallBack();

    private boolean initHwCallBackSecurity() {
        try {
            return initHwCallBack();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void addUserBufferRecycle(byte[] bArr) {
        if (bArr != null) {
            CameraControl.u().g(true, bArr);
        }
    }

    public void encodeOneFrameNotify() {
        int i3;
        SVHwEncoder sVHwEncoder = this.mEncodeRef.get();
        if (sVHwEncoder != null) {
            SVHwEncoder.a L = sVHwEncoder.L();
            if (L == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[@] encodeOneFrameNotify frame is null");
                    return;
                }
                return;
            }
            int i16 = sVHwEncoder.f287892a;
            try {
                i3 = getProcessedFrameData(L.f287989a, this.mTimeStamp, i16);
            } catch (UnsatisfiedLinkError unused) {
                i3 = -1001;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[@] HandleVideo: error=" + i3 + " colorspace=" + i16);
            }
            if (i3 == 0) {
                L.f287990b = 0;
                L.f287991c = L.f287989a.length;
                L.f287992d = this.mTimeStamp[0];
                L.f287993e = false;
                L.f287994f = true;
                sVHwEncoder.D(L, true);
                return;
            }
            this.mEncodeRef.getAndSet(null);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[@] HandleVideo: error=" + i3 + " set encode to null...");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[@] HandleVideo: [encodeOneFrameNotify] encode=null");
        }
    }

    public int getFrameIndex() {
        return this.mFrameIndex;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x027a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getPreviewFrame(byte[] bArr, Camera camera2) {
        AVIOStruct aVIOStruct;
        boolean checkPreviewDataLength;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[@] onPreviewFrame start Build.MODEL=" + DeviceInfoMonitor.getModel() + ", Build.CPU_ABI=" + Build.CPU_ABI + ", notifyFirstFrame=" + this.notifyFirstFrame);
        }
        if (this.updateTime == 0) {
            this.updateTime = SystemClock.uptimeMillis();
            this.frameCount = 0;
        } else {
            this.frameCount++;
        }
        if (this.frameCount == 100) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fps = ");
            int uptimeMillis = (int) ((this.frameCount * 1000) / (SystemClock.uptimeMillis() - this.updateTime));
            this.fps = uptimeMillis;
            sb5.append(uptimeMillis);
            QLog.d(TAG, 2, sb5.toString());
            this.updateTime = 0L;
            this.frameCount = 0;
        }
        if (!this.mCheckedDataValid) {
            if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeature(com.tencent.aelight.camera.constants.a.f69002p)) {
                this.mDisablePrivilage = checkIsDisablePrivilage(bArr, 32);
            } else {
                this.mDisablePrivilage = false;
            }
            this.mCheckedDataValid = true;
            if (this.mDisablePrivilage) {
                this.mCamera.L.c(12, "camera disabled zero data.");
                return;
            }
        } else if (this.mDisablePrivilage) {
            return;
        }
        if (bArr == null) {
            CameraControl.u().h(true);
            return;
        }
        this.mRecordToCache = 0;
        if (!this.mPTVRealBeauty) {
            sendFirstFrameMsg();
        }
        if (!this.mFrameSrcList.isEmpty()) {
            try {
                List<AVIOStruct> list = this.mFrameSrcList;
                aVIOStruct = list.get(list.size() - 1);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (aVIOStruct != null) {
                if (b.f288186b) {
                    if (aVIOStruct.pControlFlag == ControlFlagEnum.NONE.getValue()) {
                        CameraControl.b y16 = CameraControl.u().y();
                        int D = CameraControl.u().D();
                        aVIOStruct.vWidth = y16.f288111a;
                        aVIOStruct.vHeight = y16.f288112b;
                        aVIOStruct.vFormat = D;
                        aVIOStruct.vOrientation = CameraControl.u().F();
                        aVIOStruct.vFPS = CodecParam.VIDEO_FPS;
                        aVIOStruct.pControlFlag = ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue();
                        aVIOStruct.vBitrate = CodecParam.mDstVideoEncBitrate;
                        aVIOStruct.pCodec = CodecParam.mCodecId;
                    } else if (aVIOStruct.pControlFlag == ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue()) {
                        aVIOStruct.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA.getValue();
                    }
                } else if (aVIOStruct.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue()) {
                    aVIOStruct.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
                } else if (aVIOStruct.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue()) {
                    aVIOStruct.pControlFlag = ControlFlagEnum.NONE.getValue();
                }
            }
            if (aVIOStruct != null && aVIOStruct.isWriteFrame()) {
                checkPreviewDataLength = checkPreviewDataLength(aVIOStruct, bArr);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "[@] onPreviewFrame PreviewDataLength error : " + checkPreviewDataLength + " Build.MODEL=" + DeviceInfoMonitor.getModel() + " Build.CPU_ABI=" + Build.CPU_ABI);
                }
                if (!checkPreviewDataLength) {
                    this.mCamera.L.c(8, "unacceptable camera preview data");
                    return;
                }
                int i3 = this.mFrameIndex;
                this.mFrameIndex = i3 + 1;
                aVIOStruct.pFrameIndex = i3;
                aVIOStruct.vFrameTime = SystemClock.elapsedRealtime();
                this.mWriteFrameCount++;
                this.mRecordToCache = 1;
                if (!this.mPTVRealBeauty) {
                    this.mVideoFrameWrite.incrementAndGet();
                    this.mAVCodec.copyQQBuf(bArr, aVIOStruct);
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread, false).post(new HandleVideo());
                }
            }
            if (!this.mPTVRealBeauty) {
                Message obtain = Message.obtain(this.mMsghandler);
                obtain.what = -16716526;
                int i16 = this.mRecordToCache;
                obtain.arg1 = i16;
                obtain.arg2 = 1;
                obtain.obj = bArr;
                if (i16 == 1) {
                    a aVar = new a();
                    aVar.f288178a = bArr;
                    if (aVIOStruct != null) {
                        aVar.f288179b = (AVIOStruct) aVIOStruct.clone();
                    }
                    obtain.obj = aVar;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "[@] mPTVRealBeauty: [Build.MODEL=" + DeviceInfoMonitor.getModel() + "]  mMsghandler=" + this.mMsghandler);
                    }
                    CameraControl.b y17 = CameraControl.u().y();
                    if (y17 == null) {
                        return;
                    }
                    int D2 = CameraControl.u().D();
                    AVIOStruct aVIOStruct2 = this.mPTVRealBeautyCache;
                    aVIOStruct2.vWidth = y17.f288111a;
                    aVIOStruct2.vHeight = y17.f288112b;
                    aVIOStruct2.vFormat = D2;
                    if (checkPreviewDataLength(aVIOStruct2, bArr)) {
                        this.mCamera.L.c(8, "unacceptable camera preview data");
                        return;
                    }
                }
                Handler handler = this.mMsghandler;
                if (handler != null) {
                    handler.sendMessage(obtain);
                }
            } else {
                CameraControl.u().g(true, bArr);
            }
            if (!QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[@] onPreviewFrame end,mFrameIndex  = " + this.mFrameIndex);
                return;
            }
            return;
        }
        aVIOStruct = null;
        if (aVIOStruct != null) {
        }
        if (aVIOStruct != null) {
            checkPreviewDataLength = checkPreviewDataLength(aVIOStruct, bArr);
            if (QLog.isColorLevel()) {
            }
            if (!checkPreviewDataLength) {
            }
        }
        if (!this.mPTVRealBeauty) {
        }
        if (!QLog.isColorLevel()) {
        }
    }

    public int getRemainedRecordFrames(int i3) {
        int i16 = 0;
        if (i3 >= this.mFrameCountArray.size()) {
            return 0;
        }
        int i17 = this.mFrameIndex;
        while (i16 < i3) {
            ArrayList<Integer> arrayList = this.mFrameCountArray;
            i16++;
            i17 -= arrayList.get(arrayList.size() - i16).intValue();
        }
        return i17;
    }

    public int getSegmentCount() {
        List<AVIOStruct> list = this.mFrameSrcList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void lockFrameSync() {
        if (!this.mFrameProcessEnd) {
            synchronized (this.mlock) {
                if (!this.mFrameProcessEnd) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "lockFrameSync start wait");
                        }
                        this.mlock.wait(2000L);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "lockFrameSync wait finish");
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public void removeLatestVideo() {
        List<AVIOStruct> list = this.mFrameSrcList;
        if (list != null && list.size() > 0) {
            this.mFrameSrcList.remove(r0.size() - 1);
        }
        if (this.mFrameCountArray.size() > 0) {
            int intValue = this.mFrameIndex - this.mFrameCountArray.get(r1.size() - 1).intValue();
            this.mFrameIndex = intValue;
            if (intValue <= 0) {
                this.mFrameIndex = 0;
            }
            this.mFrameCountArray.remove(r0.size() - 1);
            if (this.mFrameCountArray.size() == 0) {
                this.mFrameIndex = 0;
                List<AVIOStruct> list2 = this.mFrameSrcList;
                if (list2 != null) {
                    list2.clear();
                }
            }
        }
    }

    public void reset() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[@] reset");
        }
        List<AVIOStruct> list = this.mFrameSrcList;
        if (list != null) {
            list.clear();
        }
        this.mFrameCountArray.clear();
        this.mBlockIndex = 0;
        this.mLastFrameIndex = 0;
        this.mWriteFrameCount = 0;
        this.mFrameIndex = 0;
    }

    public void sendFirstFrameMsg() {
        CameraProxy cameraProxy;
        if (this.notifyFirstFrame && (cameraProxy = this.mCamera) != null) {
            cameraProxy.L.c(10, "getted");
            this.notifyFirstFrame = false;
        }
    }

    public void setFrameIndex(int i3) {
        this.mFrameIndex = i3;
    }

    public void startCapture() {
        if (!b.f288186b) {
            return;
        }
        if (this.mFrameSrcList == null) {
            this.mFrameSrcList = new ArrayList();
        }
        AVIOStruct aVIOStruct = new AVIOStruct();
        int i3 = this.mBlockIndex;
        this.mBlockIndex = i3 + 1;
        aVIOStruct.pBlockIndex = i3;
        this.mFrameSrcList.add(aVIOStruct);
        this.mLastFrameIndex = this.mFrameIndex;
    }

    public void stopCapture() {
        this.mFrameCountArray.add(Integer.valueOf(this.mFrameIndex - this.mLastFrameIndex));
    }

    public void unlockFrameSync() {
        synchronized (this.mlock) {
            this.mFrameProcessEnd = true;
            this.mlock.notifyAll();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "unlockFrameSync notifyAll");
            }
        }
    }
}
