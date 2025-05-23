package com.tencent.youtu.sdkkitframework.common;

import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtCameraSetting {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "YtCameraSetting";
    private static int customFPS = 15000;
    public static int mCameraFacing = 1;
    public static int mDesiredPreviewHeight = 480;
    public static int mDesiredPreviewWidth = 640;
    public static int mRotate;

    public YtCameraSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int chooseFixedPreviewFps(Camera.Parameters parameters, int i3) {
        int parseInt;
        Iterator<int[]> it = parameters.getSupportedPreviewFpsRange().iterator();
        while (true) {
            if (it.hasNext()) {
                int[] next = it.next();
                String str = TAG;
                YtLogger.d(str, "entry: " + next[0] + " - " + next[1]);
                int i16 = next[0];
                int i17 = next[1];
                if (i16 == i17 && i16 == i3) {
                    parameters.setPreviewFpsRange(i16, i17);
                    YtLogger.d(str, "use preview fps range: " + next[0] + " " + next[1]);
                    return next[0];
                }
            } else {
                int[] iArr = new int[2];
                parameters.getPreviewFpsRange(iArr);
                int i18 = iArr[0];
                int i19 = iArr[1];
                if (i18 != i19) {
                    if (i3 > i19) {
                        i3 = i19;
                    }
                    if (i3 >= i18) {
                        i18 = i3;
                    }
                }
                String str2 = parameters.get("preview-frame-rate-values");
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.contains("" + (i18 / 1000))) {
                        String[] split = str2.split(",");
                        for (String str3 : split) {
                            int parseInt2 = Integer.parseInt(str3) * 1000;
                            if (i18 < parseInt2) {
                                parameters.setPreviewFrameRate(parseInt2 / 1000);
                                return parseInt2;
                            }
                        }
                        if (split.length > 0 && i18 > (parseInt = Integer.parseInt(split[split.length - 1]) * 1000)) {
                            i18 = parseInt;
                        }
                    }
                }
                parameters.setPreviewFrameRate(i18 / 1000);
                return i18;
            }
        }
    }

    public static int getDesiredPreviewHeight() {
        return mDesiredPreviewHeight;
    }

    public static int getDesiredPreviewWidth() {
        return mDesiredPreviewWidth;
    }

    private static Camera.Size getOptimalPreviewSize(List<Camera.Size> list, int i3, int i16) {
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        int max = Math.max(i3, i16);
        int min = Math.min(i3, i16);
        double d16 = max / min;
        YtLogger.d(TAG, "sizes size=" + list.size());
        double d17 = Double.MAX_VALUE;
        double d18 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((size2.width / size2.height) - d16) <= 0.001d && Math.abs(size2.height - min) < d18) {
                d18 = Math.abs(size2.height - min);
                size = size2;
            }
        }
        if (size == null) {
            YtLogger.d(TAG, "No preview size match the aspect ratio");
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - min) < d17) {
                    d17 = Math.abs(size3.height - min);
                    size = size3;
                }
            }
        }
        return size;
    }

    public static int getRotate(Context context, int i3, int i16) {
        return getRotateTag(getVideoRotate(context, i3), i16);
    }

    public static int getRotateTag(int i3, int i16) {
        int i17;
        if (i3 == 90) {
            i17 = 7;
        } else if (i3 == 180) {
            i17 = 3;
        } else if (i3 == 270) {
            i17 = 5;
        } else {
            YtLogger.i(TAG, "camera rotate not 90degree or 180degree, input: " + i3);
            i17 = 1;
        }
        if (i16 != 1) {
            return transBackFacingCameraRatateTag(i17);
        }
        return i17;
    }

    public static int getVideoRotate(Context context, int i3) {
        int i16;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i3, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i17 = 0;
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        i17 = 270;
                    }
                } else {
                    i17 = 180;
                }
            } else {
                i17 = 90;
            }
        }
        if (cameraInfo.facing == 1) {
            i16 = (360 - ((cameraInfo.orientation + i17) % 360)) % 360;
        } else {
            i16 = ((cameraInfo.orientation - i17) + 360) % 360;
        }
        YtLogger.i(TAG, "debug camera orientation is " + cameraInfo.orientation + " ui degrees is " + i17);
        return i16;
    }

    public static int initCamera(Context context, Camera camera2, int i3) {
        return initCamera(context, camera2, i3, 4, false);
    }

    public static void setCameraFacing(int i3) {
        mCameraFacing = i3;
    }

    public static void setCameraRotate(int i3) {
        mRotate = i3;
    }

    public static void setCustomFPS(int i3) {
        customFPS = i3;
    }

    public static void setVideoSize(Camera.Parameters parameters, CamcorderProfile camcorderProfile) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (parameters.getSupportedVideoSizes() == null) {
            String str = TAG;
            YtLogger.d(str, "video size from profile is : " + camcorderProfile.videoFrameWidth + " " + camcorderProfile.videoFrameHeight);
            if (getOptimalPreviewSize(supportedPreviewSizes, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) == null) {
                YtLogger.d(str, "do not find proper preview size, use default");
                camcorderProfile.videoFrameWidth = 640;
                camcorderProfile.videoFrameHeight = 480;
            }
        }
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            boolean z16 = false;
            for (int i3 = 0; i3 < supportedVideoSizes.size(); i3++) {
                Camera.Size size = supportedVideoSizes.get(i3);
                if (size.width == camcorderProfile.videoFrameWidth && size.height == camcorderProfile.videoFrameHeight) {
                    z16 = true;
                }
            }
            if (!z16) {
                camcorderProfile.videoFrameWidth = 640;
                camcorderProfile.videoFrameHeight = 480;
            }
        }
        YtLogger.d(TAG, "select video size camcorderProfile:" + camcorderProfile.videoFrameWidth + HippyTKDListViewAdapter.X + camcorderProfile.videoFrameHeight);
    }

    public static int transBackFacingCameraRatateTag(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 4;
        }
        if (i3 == 4) {
            return 3;
        }
        if (i3 == 5) {
            return 8;
        }
        if (i3 == 6) {
            return 7;
        }
        if (i3 == 7) {
            return 6;
        }
        if (i3 == 8) {
            return 5;
        }
        YtLogger.w(TAG, "[YtCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: " + i3, null);
        return 0;
    }

    public static int initCamera(Context context, Camera camera2, int i3, int i16) {
        return initCamera(context, camera2, i3, i16, false);
    }

    /* JADX WARN: Finally extract failed */
    public static int initCamera(Context context, Camera camera2, int i3, int i16, boolean z16) {
        CamcorderProfile camcorderProfile;
        mDesiredPreviewWidth = 640;
        mDesiredPreviewHeight = 480;
        try {
            Camera.Parameters parameters = camera2.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            for (int i17 = 0; i17 < supportedFocusModes.size(); i17++) {
                YtLogger.v(TAG, "suporrtedFocusModes " + i17 + " :" + supportedFocusModes.get(i17));
            }
            if (supportedFocusModes.indexOf("continuous-video") >= 0) {
                parameters.setFocusMode("continuous-video");
                YtLogger.d(TAG, "set camera focus mode continuous video");
            } else if (supportedFocusModes.indexOf("auto") >= 0) {
                parameters.setFocusMode("auto");
                YtLogger.d(TAG, "set camera focus mode auto");
            } else {
                YtLogger.d(TAG, "NOT set camera focus mode");
            }
            try {
                try {
                    camera2.setParameters(parameters);
                } catch (Throwable th5) {
                    camera2.getParameters();
                    throw th5;
                }
            } catch (Exception e16) {
                YtLogger.e(TAG, "Camera.setParameters.setPreviewSize failed!!: ", e16);
            }
            Camera.Parameters parameters2 = camera2.getParameters();
            int videoRotate = getVideoRotate(context, i3);
            camera2.setDisplayOrientation(videoRotate);
            String str = TAG;
            YtLogger.d(str, "videoOrietation is" + videoRotate);
            if (CamcorderProfile.hasProfile(i3, i16)) {
                camcorderProfile = CamcorderProfile.get(i3, i16);
                YtLogger.d(str, "custom camcorderProfile:" + camcorderProfile.videoFrameWidth + HippyTKDListViewAdapter.X + camcorderProfile.videoFrameHeight);
            } else if (CamcorderProfile.hasProfile(i3, 4)) {
                camcorderProfile = CamcorderProfile.get(i3, 4);
                YtLogger.d(str, "480P camcorderProfile:" + camcorderProfile.videoFrameWidth + HippyTKDListViewAdapter.X + camcorderProfile.videoFrameHeight);
            } else if (CamcorderProfile.hasProfile(i3, 5)) {
                camcorderProfile = CamcorderProfile.get(i3, 5);
                YtLogger.d(str, "720P camcorderProfile:" + camcorderProfile.videoFrameWidth + HippyTKDListViewAdapter.X + camcorderProfile.videoFrameHeight);
            } else {
                camcorderProfile = CamcorderProfile.get(i3, 1);
                YtLogger.d(str, "High camcorderProfile:" + camcorderProfile.videoFrameWidth + HippyTKDListViewAdapter.X + camcorderProfile.videoFrameHeight);
            }
            List<Camera.Size> supportedPictureSizes = camera2.getParameters().getSupportedPictureSizes();
            List<Camera.Size> supportedPreviewSizes = camera2.getParameters().getSupportedPreviewSizes();
            for (int i18 = 0; i18 < supportedPictureSizes.size(); i18++) {
                Camera.Size size = supportedPictureSizes.get(i18);
                YtLogger.d("pictureSize", size.width + " x " + size.height);
            }
            for (int i19 = 0; i19 < supportedPreviewSizes.size(); i19++) {
                Camera.Size size2 = supportedPreviewSizes.get(i19);
                YtLogger.d("previewSize", size2.width + " x " + size2.height);
            }
            setVideoSize(parameters2, camcorderProfile);
            if (z16) {
                mDesiredPreviewWidth = camcorderProfile.videoFrameWidth;
                mDesiredPreviewHeight = camcorderProfile.videoFrameHeight;
            }
            YtLogger.d(TAG, "mDesiredPreviewWidth: " + mDesiredPreviewWidth + ", mDesiredPreviewHeight: " + mDesiredPreviewHeight);
            parameters2.setPreviewSize(mDesiredPreviewWidth, mDesiredPreviewHeight);
            parameters2.setPreviewFormat(17);
            try {
                camera2.setParameters(parameters2);
            } catch (Exception e17) {
                YtLogger.e(TAG, "Camera.setParameters.setPreviewSize failed!!: ", e17);
            }
            Camera.Parameters parameters3 = camera2.getParameters();
            int chooseFixedPreviewFps = chooseFixedPreviewFps(parameters3, customFPS);
            YtLogger.d(TAG, "choose camera fps is : " + chooseFixedPreviewFps);
            try {
                camera2.setParameters(parameters3);
            } catch (Exception e18) {
                YtLogger.e(TAG, "Camera.setParameters.preview fps failed!!: ", e18);
            }
            Camera.Parameters parameters4 = camera2.getParameters();
            int[] iArr = new int[2];
            parameters4.getPreviewFpsRange(iArr);
            int previewFrameRate = parameters4.getPreviewFrameRate();
            String str2 = TAG;
            YtLogger.d(str2, "after set parameters getPreviewFpsRange=" + iArr[0] + "-" + iArr[1] + " ;after set parameter fps=" + previewFrameRate);
            Camera.Size previewSize = parameters4.getPreviewSize();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("camera preview size is ");
            sb5.append(previewSize.width);
            sb5.append(" ");
            sb5.append(previewSize.height);
            YtLogger.d(str2, sb5.toString());
            return 0;
        } catch (Exception e19) {
            YtLogger.e(TAG, "get camera parameters failed. 1. Check Camera.getParameters() interface. 2. Get logs for more detail.", e19);
            return 1;
        }
    }
}
