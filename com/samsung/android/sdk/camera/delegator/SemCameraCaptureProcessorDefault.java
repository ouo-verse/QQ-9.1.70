package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Size;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor;
import java.util.List;

/* loaded from: classes3.dex */
public class SemCameraCaptureProcessorDefault extends AbstractSemCameraCaptureProcessor {
    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public CaptureRequest buildCaptureRequest(CaptureRequest.Builder builder) {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public void capture(CameraCaptureSession cameraCaptureSession, CaptureResult captureResult, AbstractSemCameraCaptureProcessor.CaptureCallback captureCallback, Handler handler, List<AbstractSemCameraCaptureProcessor.CaptureParameter> list) {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public SessionConfiguration createSessionConfiguration(List<OutputConfiguration> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback stateCallback, Handler handler) {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public void deinitialize() {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public List<AbstractSemCameraCaptureProcessor.ProcessorParameter> getAvailableParameters() {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public <T> T getProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> processorParameter) {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public void initialize(Context context, String str, Size size) throws CameraAccessException {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
    public <T> void setProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> processorParameter, T t16) {
        throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
    }
}
