package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor;
import com.samsung.android.sep.camera.SemCameraCaptureProcessor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class SemCameraCaptureProcessor10_2 extends AbstractSemCameraCaptureProcessor {
    private static final String TAG = "SemCameraCaptureProcessor10_2";
    private CameraCharacteristics mCharacteristics;
    private List<AbstractSemCameraCaptureProcessor.ProcessorParameter> mParameterList;
    private AbstractSemCameraCaptureProcessor.CaptureCallback mSDKCaptureCallback = null;
    private SemCameraCaptureProcessor mSemCameraCaptureProcessor;
    private SemCaptureCallBack mSemCaptureCallBack;

    /* loaded from: classes3.dex */
    private class SemCaptureCallBack extends SemCameraCaptureProcessor.CaptureCallback {
        SemCaptureCallBack() {
        }

        public void onError(int i3) {
            Log.i(SemCameraCaptureProcessor10_2.TAG, " SemCaptureCallBack onError!!! " + i3);
            if (SemCameraCaptureProcessor10_2.this.mSDKCaptureCallback != null) {
                SemCameraCaptureProcessor10_2.this.mSDKCaptureCallback.onError(i3);
            }
        }

        public void onPictureAvailable(ByteBuffer byteBuffer) {
            Log.i(SemCameraCaptureProcessor10_2.TAG, " SemCaptureCallBack onPictureAvailable!!! " + byteBuffer);
            if (SemCameraCaptureProcessor10_2.this.mSDKCaptureCallback != null) {
                SemCameraCaptureProcessor10_2.this.mSDKCaptureCallback.onPictureAvailable(byteBuffer);
            }
        }

        public void onShutter() {
            if (SemCameraCaptureProcessor10_2.this.mSDKCaptureCallback != null) {
                SemCameraCaptureProcessor10_2.this.mSDKCaptureCallback.onShutter();
            }
        }
    }

    private List<SemCameraCaptureProcessor.CaptureParameter> getSemParameters(List<AbstractSemCameraCaptureProcessor.CaptureParameter> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            Log.d(TAG, "getSemParameters: SemCaptureParametersSize: 0");
            return arrayList;
        }
        for (AbstractSemCameraCaptureProcessor.CaptureParameter captureParameter : list) {
            arrayList.add(new SemCameraCaptureProcessor.CaptureParameter(captureParameter.getKey(), captureParameter.getValue()));
        }
        Log.d(TAG, "getSemParameters: SemCaptureParametersSize: " + arrayList.size());
        return arrayList;
    }

    private void setFaceDetectMode(CaptureRequest.Builder builder) {
        CameraCharacteristics cameraCharacteristics = this.mCharacteristics;
        if (cameraCharacteristics != null) {
            boolean z16 = false;
            boolean z17 = false;
            for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES)) {
                if (i3 == 2) {
                    z16 = true;
                } else if (i3 == 1) {
                    z17 = true;
                }
            }
            if (z16) {
                builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 2);
            } else if (z17) {
                builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 1);
            }
        }
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public CaptureRequest buildCaptureRequest(CaptureRequest.Builder builder) {
        SemCameraCaptureProcessor semCameraCaptureProcessor = this.mSemCameraCaptureProcessor;
        if (semCameraCaptureProcessor != null) {
            return semCameraCaptureProcessor.buildCaptureRequest(builder);
        }
        return builder.build();
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public void capture(CameraCaptureSession cameraCaptureSession, CaptureResult captureResult, AbstractSemCameraCaptureProcessor.CaptureCallback captureCallback, Handler handler, List<AbstractSemCameraCaptureProcessor.CaptureParameter> list) {
        this.mSDKCaptureCallback = captureCallback;
        SemCameraCaptureProcessor semCameraCaptureProcessor = this.mSemCameraCaptureProcessor;
        if (semCameraCaptureProcessor != null) {
            semCameraCaptureProcessor.capture(cameraCaptureSession, new SemCameraCaptureProcessor.DynamicShotInfo(captureResult), this.mSemCaptureCallBack, handler, getSemParameters(list));
        }
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public SessionConfiguration createSessionConfiguration(List<OutputConfiguration> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) {
        if (this.mSemCameraCaptureProcessor != null) {
            Log.i(TAG, "createSessionConfiguration: outputConfigurations " + list + "  stateCallback: " + stateCallback);
            return this.mSemCameraCaptureProcessor.createSessionConfiguration(list, stateCallback, handler);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback stateCallback, Handler handler) {
        SemCameraCaptureProcessor semCameraCaptureProcessor = this.mSemCameraCaptureProcessor;
        if (semCameraCaptureProcessor != null) {
            return semCameraCaptureProcessor.createStateCallback(stateCallback, handler);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public void deinitialize() {
        this.mSemCameraCaptureProcessor.deinitialize();
        this.mSDKCaptureCallback = null;
        this.mSemCaptureCallBack = null;
        this.mSemCameraCaptureProcessor = null;
        this.mCharacteristics = null;
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public List<AbstractSemCameraCaptureProcessor.ProcessorParameter> getAvailableParameters() {
        List<SemCameraCaptureProcessor.ProcessorParameter> availableParameters = this.mSemCameraCaptureProcessor.getAvailableParameters();
        if (this.mParameterList == null) {
            this.mParameterList = new ArrayList();
            for (SemCameraCaptureProcessor.ProcessorParameter processorParameter : availableParameters) {
                if (processorParameter == SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
                    this.mParameterList.add(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY);
                } else if (processorParameter == SemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT) {
                    this.mParameterList.add(AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT);
                }
            }
        }
        return Collections.unmodifiableList(this.mParameterList);
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public <T> T getProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> processorParameter) {
        if (processorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
            return (T) this.mSemCameraCaptureProcessor.getProcessorParameter(SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY);
        }
        if (processorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT) {
            return (T) this.mSemCameraCaptureProcessor.getProcessorParameter(SemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public void initialize(Context context, String str, Size size) throws CameraAccessException {
        SemCameraCaptureProcessor semCameraCaptureProcessor = SemCameraCaptureProcessor.getInstance();
        this.mSemCameraCaptureProcessor = semCameraCaptureProcessor;
        semCameraCaptureProcessor.initialize(context, str, size);
        this.mSemCaptureCallBack = new SemCaptureCallBack();
        this.mCharacteristics = ((CameraManager) context.getSystemService("camera")).getCameraCharacteristics(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public <T> void setProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> processorParameter, T t16) {
        if (processorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
            this.mSemCameraCaptureProcessor.setProcessorParameter(SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY, (Boolean) t16);
        } else if (processorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT) {
            this.mSemCameraCaptureProcessor.setProcessorParameter(SemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT, (Integer) t16);
        }
    }
}
