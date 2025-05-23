package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.MediaRecorder;
import android.os.Handler;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import java.util.Set;
import java.util.concurrent.Executor;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CameraMonitor {
    private static final String SYSTEM_CALL_CAMERA = "call system api:AudioRecord.";
    public static final String TAG = "CameraMonitor";

    @SuppressLint({"NewApi"})
    public static CaptureRequest.Builder createCaptureRequest(CameraDevice cameraDevice, int i3, Set<String> set) throws CameraAccessException {
        CaptureRequest.Builder createCaptureRequest;
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAMDVC#CCR#IS", new a.C11438a().b("ban").d(), null))) {
            createCaptureRequest = cameraDevice.createCaptureRequest(i3, set);
            return createCaptureRequest;
        }
        throw new CameraAccessException(1);
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static Camera open() {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAM#OPN", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return Camera.open();
        }
        return null;
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void openCamera(CameraManager cameraManager, String str, CameraDevice.StateCallback stateCallback, Handler handler) throws CameraAccessException {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAMM#OPN_CAM#SCH", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            cameraManager.openCamera(str, stateCallback, handler);
        }
    }

    @SuppressLint({"NewApi"})
    public static int setRepeatingRequest(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback, Handler handler) throws CameraAccessException {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAMCS#SRR#CCH", new a.C11438a().b("ban").d(), null))) {
            return cameraCaptureSession.setRepeatingRequest(captureRequest, captureCallback, handler);
        }
        throw new CameraAccessException(1);
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void setVideoSource(MediaRecorder mediaRecorder, int i3) throws IllegalStateException {
        if (i3 != 1 && i3 != 2) {
            mediaRecorder.setVideoSource(i3);
        } else if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "MR#SET_VID_SRC#I", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            mediaRecorder.setVideoSource(i3);
        }
    }

    public static void takePicture(Camera camera2, Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAM#TAKE_PIC#SPP", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            camera2.takePicture(shutterCallback, pictureCallback, pictureCallback2);
        }
    }

    @SuppressLint({"NewApi"})
    public static CaptureRequest.Builder createCaptureRequest(CameraDevice cameraDevice, int i3) throws CameraAccessException {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAMDVC#CCR#I", new a.C11438a().b("ban").d(), null))) {
            return cameraDevice.createCaptureRequest(i3);
        }
        throw new CameraAccessException(1);
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static Camera open(int i3) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAM#OPN#I", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return Camera.open(i3);
        }
        return null;
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void openCamera(CameraManager cameraManager, String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessException {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAMM#OPN_CAM#SES", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            cameraManager.openCamera(str, executor, stateCallback);
        }
    }

    public static void takePicture(Camera camera2, Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("camera", "CAM#TAKE_PIC#SPPP", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            camera2.takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
        }
    }
}
