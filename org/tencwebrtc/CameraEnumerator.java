package org.tencwebrtc;

import java.util.List;
import org.tencwebrtc.CameraEnumerationAndroid;
import org.tencwebrtc.CameraVideoCapturer;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface CameraEnumerator {
    CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler);

    String[] getDeviceNames();

    List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str);

    boolean isBackFacing(String str);

    boolean isFrontFacing(String str);
}
