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
import com.samsung.android.sep.camera.vendor.SemCameraCaptureRequestKey;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class SemCameraCaptureProcessor10_1 extends AbstractSemCameraCaptureProcessor {
    private static final String TAG = "SemCameraCaptureProcessor10_1";
    private CameraCharacteristics mCharacteristics;
    private Context mContext;
    private List<AbstractSemCameraCaptureProcessor.ProcessorParameter> mParameterList;
    private AbstractSemCameraCaptureProcessor.CaptureCallback mSDKCaptureCallback = null;
    private SemCameraCaptureProcessor mSemCameraCaptureProcessor;
    private SemCaptureCallBack mSemCaptureCallBack;
    private SessionConfiguration mSessionConfiguration;

    /* loaded from: classes3.dex */
    private class SemCaptureCallBack extends SemCameraCaptureProcessor.CaptureCallback {
        SemCaptureCallBack() {
        }

        public void onError(int i3) {
            Log.i(SemCameraCaptureProcessor10_1.TAG, " SemCaptureCallBack onError!!! " + i3);
            if (SemCameraCaptureProcessor10_1.this.mSDKCaptureCallback != null) {
                SemCameraCaptureProcessor10_1.this.mSDKCaptureCallback.onError(i3);
            }
        }

        public void onPictureAvailable(ByteBuffer byteBuffer) {
            Log.i(SemCameraCaptureProcessor10_1.TAG, " SemCaptureCallBack onPictureAvailable!!! " + byteBuffer);
            if (SemCameraCaptureProcessor10_1.this.mSDKCaptureCallback != null) {
                SemCameraCaptureProcessor10_1.this.mSDKCaptureCallback.onPictureAvailable(byteBuffer);
            }
        }

        public void onShutter() {
            if (SemCameraCaptureProcessor10_1.this.mSDKCaptureCallback != null) {
                SemCameraCaptureProcessor10_1.this.mSDKCaptureCallback.onShutter();
            }
        }
    }

    private CaptureRequest buildMultipleCaptureRequest(CaptureRequest.Builder builder) {
        Log.i(TAG, "buildMultipleCaptureRequest E");
        builder.set(SemCameraCaptureRequestKey.REQUEST_CONTROL_LIGHT_CONDITION_ENABLE_MODE, 1);
        builder.set(SemCameraCaptureRequestKey.CONTROL_LIVE_HDR_MODE, 2);
        setFaceDetectMode(builder);
        return builder.build();
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
            try {
                return semCameraCaptureProcessor.buildCaptureRequest(builder);
            } catch (IllegalStateException unused) {
                return buildMultipleCaptureRequest(builder);
            }
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
    public SessionConfiguration createSessionConfiguration(List<OutputConfiguration> list, CameraCaptureSession.StateCallback stateCallback, final Handler handler) {
        List outputConfigurations;
        Executor executor;
        if (this.mSemCameraCaptureProcessor != null) {
            Log.i(TAG, "createSessionConfiguration: outputConfigurations " + list + "  stateCallback: " + stateCallback);
            try {
                SessionConfiguration createSessionConfiguration = this.mSemCameraCaptureProcessor.createSessionConfiguration(list, stateCallback, handler);
                this.mSessionConfiguration = createSessionConfiguration;
                return createSessionConfiguration;
            } catch (IllegalStateException e16) {
                Log.i(TAG, "catch createSessionConfiguration exception !!!!!" + e16);
                if (list != null) {
                    if (stateCallback != null) {
                        if (this.mSessionConfiguration != null) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<OutputConfiguration> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next());
                            }
                            outputConfigurations = this.mSessionConfiguration.getOutputConfigurations();
                            Iterator it5 = outputConfigurations.subList(Math.max(outputConfigurations.size() - 2, 0), outputConfigurations.size()).iterator();
                            while (it5.hasNext()) {
                                arrayList.add((OutputConfiguration) it5.next());
                            }
                            if (handler == null) {
                                executor = this.mContext.getMainExecutor();
                            } else {
                                executor = new Executor() { // from class: com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_1.1
                                    @Override // java.util.concurrent.Executor
                                    public void execute(Runnable runnable) {
                                        handler.post(runnable);
                                    }
                                };
                            }
                            return new SessionConfiguration(0, arrayList, executor, stateCallback);
                        }
                        throw new IllegalStateException("Called in wrong state");
                    }
                    throw new IllegalArgumentException("statecallback cannot be null");
                }
                throw new IllegalArgumentException("Session cannot be null");
            }
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
        this.mSessionConfiguration = null;
        this.mContext = null;
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public List<AbstractSemCameraCaptureProcessor.ProcessorParameter> getAvailableParameters() {
        List availableParameters = this.mSemCameraCaptureProcessor.getAvailableParameters();
        if (this.mParameterList == null) {
            this.mParameterList = new ArrayList();
            Iterator it = availableParameters.iterator();
            while (it.hasNext()) {
                if (((SemCameraCaptureProcessor.ProcessorParameter) it.next()) == SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
                    this.mParameterList.add(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY);
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
        return null;
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public void initialize(Context context, String str, Size size) throws CameraAccessException {
        SemCameraCaptureProcessor semCameraCaptureProcessor = SemCameraCaptureProcessor.getInstance();
        this.mSemCameraCaptureProcessor = semCameraCaptureProcessor;
        semCameraCaptureProcessor.initialize(context, str, size);
        this.mSemCaptureCallBack = new SemCaptureCallBack();
        this.mCharacteristics = ((CameraManager) context.getSystemService("camera")).getCameraCharacteristics(str);
        this.mContext = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public <T> void setProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> processorParameter, T t16) {
        if (processorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
            this.mSemCameraCaptureProcessor.setProcessorParameter(SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY, (Boolean) t16);
        }
    }
}
