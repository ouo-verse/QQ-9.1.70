package com.samsung.android.sdk.camera;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import com.samsung.android.sdk.camera.delegator.AbstractSemCamera;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_1;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_2;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessorDefault;
import com.samsung.android.sdk.camera.util.SsdkVersionCheck;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class SCameraCaptureProcessor {
    private static final String CAMERA_ID_REAR_WIDE = "2";
    public static final int IMAGE_FORMAT_JPEG = 256;
    public static final int IMAGE_FORMAT_NV21 = 17;
    public static final ProcessorParameter<Boolean> PARAMETER_ENABLE_FACE_BEAUTY = new ProcessorParameter<>("beauty_parameter");
    public static final ProcessorParameter<Integer> PARAMETER_IMAGE_FORMAT = new ProcessorParameter<>("image_format");
    private static final String TAG = "SCameraCaptureProcessor";
    private static SCameraCaptureProcessor mSCameraCaptureProcessor;
    private Handler mAppCaptureHandler;
    private CameraCaptureSession.CaptureCallback mAppPreviewCaptureCallback;
    private Context mContext;
    private List<ProcessorParameter> mParameterList;
    private PreviewCaptureCallback mPreviewCaptureCallback;
    private CaptureResult mPreviewCaptureResult;
    private AbstractSemCameraCaptureProcessor mSemCameraCaptureProcessor;
    private SemCaptureCallBack mSemCaptureCallBack;
    private CaptureCallback mAppCaptureCallback = null;
    private volatile boolean isSCameraProcessorInitialized = false;

    /* loaded from: classes3.dex */
    public static abstract class CaptureCallback {
        public static final int ERROR_CAPTURE_FAILED = 1;
        public static final int ERROR_PROCESSING_FAILED = 2;

        public abstract void onError(int i3);

        public abstract void onPictureAvailable(ByteBuffer byteBuffer);

        public abstract void onShutter();
    }

    /* loaded from: classes3.dex */
    public static class CaptureParameter {
        private final CaptureRequest.Key mKey;
        private final Object mValue;

        public <T> CaptureParameter(CaptureRequest.Key<T> key, T t16) {
            this.mKey = key;
            this.mValue = t16;
        }
    }

    /* loaded from: classes3.dex */
    private class PreviewCaptureCallback extends CameraCaptureSession.CaptureCallback {
        PreviewCaptureCallback() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j3) {
            Log.i(SCameraCaptureProcessor.TAG, "onCaptureBufferLost: frameNumber " + j3);
            synchronized (SCameraCaptureProcessor.this) {
                if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
                    SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j3);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            SCameraCaptureProcessor.this.mPreviewCaptureResult = totalCaptureResult;
            synchronized (SCameraCaptureProcessor.this) {
                if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
                    SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            Log.i(SCameraCaptureProcessor.TAG, "onCaptureFailed: failure " + captureFailure.getReason() + "  mAppPreviewCaptureCallback: " + SCameraCaptureProcessor.this.mAppPreviewCaptureCallback);
            synchronized (SCameraCaptureProcessor.this) {
                if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
                    SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            synchronized (SCameraCaptureProcessor.this) {
                if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
                    SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i3) {
            Log.i(SCameraCaptureProcessor.TAG, "onCaptureSequenceAborted: sequenceId " + i3);
            synchronized (SCameraCaptureProcessor.this) {
                if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
                    SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureSequenceAborted(cameraCaptureSession, i3);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i3, long j3) {
            synchronized (SCameraCaptureProcessor.this) {
                if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
                    SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureSequenceCompleted(cameraCaptureSession, i3, j3);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j3, long j16) {
            synchronized (SCameraCaptureProcessor.this) {
                if (SCameraCaptureProcessor.this.mAppPreviewCaptureCallback != null) {
                    SCameraCaptureProcessor.this.mAppPreviewCaptureCallback.onCaptureStarted(cameraCaptureSession, captureRequest, j3, j16);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class ProcessorParameter<T> {
        private String mName;

        ProcessorParameter(String str) {
            this.mName = str;
        }

        public String getName() {
            return this.mName;
        }
    }

    /* loaded from: classes3.dex */
    private class SemCaptureCallBack extends AbstractSemCameraCaptureProcessor.CaptureCallback {
        SemCaptureCallBack() {
        }

        @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureCallback
        public void onError(int i3) {
            if (SCameraCaptureProcessor.this.mAppCaptureCallback != null) {
                SCameraCaptureProcessor.this.mAppCaptureCallback.onError(i3);
            }
        }

        @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureCallback
        public void onPictureAvailable(ByteBuffer byteBuffer) {
            if (SCameraCaptureProcessor.this.mAppCaptureCallback != null) {
                SCameraCaptureProcessor.this.mAppCaptureCallback.onPictureAvailable(byteBuffer);
            }
        }

        @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureCallback
        public void onShutter() {
            if (SCameraCaptureProcessor.this.mAppCaptureCallback != null) {
                SCameraCaptureProcessor.this.mAppCaptureCallback.onShutter();
            }
        }
    }

    SCameraCaptureProcessor() {
    }

    private void checkIsSCameraProcessorInitialized() {
        if (this.isSCameraProcessorInitialized) {
            return;
        }
        Log.i(TAG, "checkIsSCameraProcessorInitialized: sdk not initialized");
        throw new IllegalStateException("SCameraCaptureProcessor not initialized");
    }

    public static synchronized SCameraCaptureProcessor getInstance() {
        SCameraCaptureProcessor sCameraCaptureProcessor;
        synchronized (SCameraCaptureProcessor.class) {
            if (mSCameraCaptureProcessor == null) {
                mSCameraCaptureProcessor = new SCameraCaptureProcessor();
            }
            sCameraCaptureProcessor = mSCameraCaptureProcessor;
        }
        return sCameraCaptureProcessor;
    }

    private AbstractSemCameraCaptureProcessor getSemCameraCaptureProcessor() {
        if (this.mSemCameraCaptureProcessor == null) {
            if (AbstractSemCamera.getSepPlatformVersion(this.mContext) >= 100100) {
                try {
                    String sEPClientVersion = AbstractSemCamera.getSEPClientVersion();
                    Log.i(TAG, "getSemCameraCaptureProcessor semVersion : " + sEPClientVersion);
                    if (SsdkVersionCheck.compareVersion(sEPClientVersion, "2.0.1") >= 0) {
                        this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_2();
                    }
                } catch (Throwable unused) {
                    Log.i(TAG, "getSemCameraCaptureProcessor semVersion : SEP_VERSION_10_1 in caught Error:");
                    this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_1();
                }
            } else {
                this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessorDefault();
            }
        }
        Log.i(TAG, "getSemCameraCaptureProcessor  " + this.mSemCameraCaptureProcessor);
        return this.mSemCameraCaptureProcessor;
    }

    private List<AbstractSemCameraCaptureProcessor.CaptureParameter> getSemParameters(List<CaptureParameter> list) {
        checkIsSCameraProcessorInitialized();
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (CaptureParameter captureParameter : list) {
            arrayList.add(new AbstractSemCameraCaptureProcessor.CaptureParameter(captureParameter.mKey, captureParameter.mValue));
        }
        return arrayList;
    }

    public synchronized CaptureRequest buildCaptureRequest(CaptureRequest.Builder builder) {
        Log.i(TAG, "buildCaptureRequest  : builder " + builder);
        checkIsSCameraProcessorInitialized();
        return getSemCameraCaptureProcessor().buildCaptureRequest(builder);
    }

    public synchronized void capture(CameraCaptureSession cameraCaptureSession, CaptureCallback captureCallback, Handler handler, List<CaptureParameter> list) {
        checkIsSCameraProcessorInitialized();
        this.mAppCaptureCallback = captureCallback;
        getSemCameraCaptureProcessor().capture(cameraCaptureSession, this.mPreviewCaptureResult, this.mSemCaptureCallBack, handler, getSemParameters(list));
    }

    public synchronized CameraCaptureSession.CaptureCallback createCaptureCallback(CameraCaptureSession.CaptureCallback captureCallback, Handler handler) {
        Log.i(TAG, "createCaptureCallback");
        checkIsSCameraProcessorInitialized();
        this.mAppPreviewCaptureCallback = captureCallback;
        this.mAppCaptureHandler = handler;
        return this.mPreviewCaptureCallback;
    }

    public synchronized SessionConfiguration createSessionConfiguration(List<OutputConfiguration> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) {
        checkIsSCameraProcessorInitialized();
        return getSemCameraCaptureProcessor().createSessionConfiguration(list, stateCallback, handler);
    }

    public synchronized CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback stateCallback, Handler handler) {
        checkIsSCameraProcessorInitialized();
        return getSemCameraCaptureProcessor().createStateCallback(stateCallback, handler);
    }

    public synchronized void deinitialize() {
        Log.i(TAG, "deinitialize");
        checkIsSCameraProcessorInitialized();
        getSemCameraCaptureProcessor().deinitialize();
        this.mAppCaptureCallback = null;
        this.mAppCaptureHandler = null;
        this.mPreviewCaptureResult = null;
        this.mAppPreviewCaptureCallback = null;
        this.mSemCaptureCallBack = null;
        this.mPreviewCaptureCallback = null;
        this.mParameterList = null;
        this.isSCameraProcessorInitialized = false;
    }

    public List<ProcessorParameter> getAvailableParameters() {
        checkIsSCameraProcessorInitialized();
        List<AbstractSemCameraCaptureProcessor.ProcessorParameter> availableParameters = getSemCameraCaptureProcessor().getAvailableParameters();
        if (this.mParameterList == null) {
            this.mParameterList = new ArrayList();
            for (AbstractSemCameraCaptureProcessor.ProcessorParameter<Boolean> processorParameter : availableParameters) {
                if (processorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
                    this.mParameterList.add(PARAMETER_ENABLE_FACE_BEAUTY);
                } else if (processorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT) {
                    this.mParameterList.add(PARAMETER_IMAGE_FORMAT);
                }
            }
        }
        return Collections.unmodifiableList(this.mParameterList);
    }

    public synchronized <T> T getProcessorParameter(ProcessorParameter<T> processorParameter) {
        if (processorParameter == PARAMETER_ENABLE_FACE_BEAUTY) {
            return (T) getSemCameraCaptureProcessor().getProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY);
        }
        if (processorParameter == PARAMETER_IMAGE_FORMAT) {
            return (T) getSemCameraCaptureProcessor().getProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT);
        }
        return null;
    }

    public synchronized void initialize(Context context, String str, Size size) throws CameraAccessException {
        String str2 = TAG;
        Log.i(str2, "initialize: cameraId - " + str + ", pictureSize - " + size);
        if (SCamera.getInstance().checkAvailability(context) == 0) {
            try {
                String sEPClientVersion = AbstractSemCamera.getSEPClientVersion();
                Log.i(str2, "getSemCameraCaptureProcessor semVersion : " + sEPClientVersion);
                if (SsdkVersionCheck.compareVersion(sEPClientVersion, "2.0.2") == 0 && str.equals("2")) {
                    throw new IllegalArgumentException("cameraId unsupported by SDK");
                }
            } catch (NoSuchMethodError unused) {
            }
            this.mContext = context;
            getSemCameraCaptureProcessor().initialize(context, str, size);
            this.mPreviewCaptureCallback = new PreviewCaptureCallback();
            this.mSemCaptureCallBack = new SemCaptureCallBack();
            this.isSCameraProcessorInitialized = true;
        } else {
            throw new UnsupportedOperationException("CameraSdk not supported");
        }
    }

    public synchronized boolean isInitialized() {
        return this.isSCameraProcessorInitialized;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized <T> void setProcessorParameter(ProcessorParameter<T> processorParameter, T t16) {
        checkIsSCameraProcessorInitialized();
        if (processorParameter == PARAMETER_ENABLE_FACE_BEAUTY) {
            if (t16 instanceof Boolean) {
                getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY, (Boolean) t16);
            } else {
                throw new IllegalArgumentException("argument for PARAMETER_ENABLE_FACE_BEAUTY should be of type Boolean");
            }
        } else if (processorParameter == PARAMETER_IMAGE_FORMAT) {
            if (t16 instanceof Integer) {
                getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT, (Integer) t16);
            } else {
                throw new IllegalArgumentException("argument for PARAMETER_IMAGE_FORMAT should be of type Integer");
            }
        }
    }
}
