package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.heytap.mcssdk.a.b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.component.cache.database.table.photo.PhotoQualityInfo;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YTImageData;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSdkConfig;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceQualityState extends YtFSMBaseState {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FaceQualityState";
    private static int continuousQualityNumThreshold = 10;
    private float closeEyeLeftThreshold;
    private float closeEyeRightThreshold;
    private float closeMouthThreshold;
    private int compressPoseImageScore;
    private int continuousCount;
    private float faceMaxHeightThreshold;
    private float faceMinHeightThreshold;
    private float faceRealMinHeightThreshold;
    private int localFaceBestImageQuality;
    private boolean needCloseTimeout;
    private boolean needFaceQuality;
    private boolean needLocalFaceBestImage;
    private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
    private float secondaryPitchThreshold;
    private float secondaryRollThreshold;
    private float secondaryYawThreshold;

    /* compiled from: P */
    /* renamed from: com.tencent.youtu.sdkkitframework.liveness.FaceQualityState$2, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(b.f36130x);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            YtSDKKitFramework.YtSDKKitFrameworkWorkMode.values();
            int[] iArr = new int[8];
            $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode2 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr3[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode3 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class BestFaceImage {
        static IPatchRedirector $redirector_;
        public byte[] imageData;
        public int imageHeight;
        public int imageWidth;

        public BestFaceImage(byte[] bArr, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.imageData = bArr;
            this.imageWidth = i3;
            this.imageHeight = i16;
        }
    }

    public FaceQualityState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.secondaryYawThreshold = 25.0f;
        this.secondaryPitchThreshold = 25.0f;
        this.secondaryRollThreshold = 25.0f;
        this.faceMinHeightThreshold = 0.6f;
        this.faceRealMinHeightThreshold = 0.1f;
        this.faceMaxHeightThreshold = 0.95f;
        this.closeEyeLeftThreshold = 0.25f;
        this.closeEyeRightThreshold = 0.25f;
        this.closeMouthThreshold = 0.25f;
        this.compressPoseImageScore = 99;
        this.localFaceBestImageQuality = 90;
        this.needCloseTimeout = false;
    }

    private byte[] compressImage(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeStream.compress(Bitmap.CompressFormat.JPEG, this.compressPoseImageScore, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayInputStream.close();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (FileNotFoundException e16) {
            YtLogger.e(TAG, "compressImage error", e16);
            return null;
        } catch (IOException e17) {
            YtLogger.e(TAG, "compressImage error", e17);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|(2:5|(8:7|8|(1:10)|11|12|13|14|15))|20|8|(0)|11|12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009b, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009c, code lost:
    
        com.tencent.youtu.sdkkitframework.common.YtLogger.e(com.tencent.youtu.sdkkitframework.liveness.FaceQualityState.TAG, "LocalFaceBestImage close IO error", r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] faceHeightStandard(YTFaceTracker.TrackedFace trackedFace, YTImageData yTImageData) {
        float f16;
        float f17;
        float f18;
        int height = trackedFace.faceRect.height();
        int width = trackedFace.faceRect.width();
        float f19 = yTImageData.height * this.faceMinHeightThreshold;
        byte[] bgr2JPEG = yTImageData.bgr2JPEG(this.localFaceBestImageQuality);
        float f26 = height;
        if (f26 < f19) {
            float f27 = yTImageData.width;
            float f28 = yTImageData.height;
            float f29 = f27 / f28;
            float f36 = f26 / f28;
            float f37 = this.faceMinHeightThreshold;
            if (f36 < f37) {
                if (this.faceRealMinHeightThreshold < f37) {
                    f16 = (float) (((f36 - r6) / (f37 - r6)) * 0.1d);
                    float f38 = f26 / (f16 + 0.61f);
                    f17 = f29 * f38;
                    f18 = width;
                    if (f18 > f17) {
                        f17 = f18;
                    }
                    Rect rect = trackedFace.faceRect;
                    float width2 = (trackedFace.faceRect.width() / 2.0f) + rect.left;
                    float height2 = ((rect.height() / 2.0f) + trackedFace.faceRect.top) - (f38 / 2.0f);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bgr2JPEG, 0, bgr2JPEG.length);
                    Bitmap cropBitmap = cropBitmap(decodeByteArray, (int) (width2 - (f17 / 2.0f)), (int) height2, (int) f17, (int) f38);
                    Bitmap scaleBitmap = scaleBitmap(cropBitmap, yTImageData.width, yTImageData.height);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    scaleBitmap.compress(Bitmap.CompressFormat.JPEG, this.localFaceBestImageQuality, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    decodeByteArray.recycle();
                    cropBitmap.recycle();
                    scaleBitmap.recycle();
                    return byteArray;
                }
            }
            f16 = 0.01f;
            float f382 = f26 / (f16 + 0.61f);
            f17 = f29 * f382;
            f18 = width;
            if (f18 > f17) {
            }
            Rect rect2 = trackedFace.faceRect;
            float width22 = (trackedFace.faceRect.width() / 2.0f) + rect2.left;
            float height22 = ((rect2.height() / 2.0f) + trackedFace.faceRect.top) - (f382 / 2.0f);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bgr2JPEG, 0, bgr2JPEG.length);
            Bitmap cropBitmap2 = cropBitmap(decodeByteArray2, (int) (width22 - (f17 / 2.0f)), (int) height22, (int) f17, (int) f382);
            Bitmap scaleBitmap2 = scaleBitmap(cropBitmap2, yTImageData.width, yTImageData.height);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            scaleBitmap2.compress(Bitmap.CompressFormat.JPEG, this.localFaceBestImageQuality, byteArrayOutputStream2);
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream2.close();
            decodeByteArray2.recycle();
            cropBitmap2.recycle();
            scaleBitmap2.recycle();
            return byteArray2;
        }
        return bgr2JPEG;
    }

    private boolean isEyeOpen(YTFaceTracker.TrackedFace trackedFace) {
        boolean z16;
        float[] fArr = trackedFace.faceShape;
        float f16 = fArr[32] - fArr[40];
        float f17 = fArr[33] - fArr[41];
        float sqrt = (float) Math.sqrt((f16 * f16) + (f17 * f17));
        float f18 = fArr[36] - fArr[44];
        float f19 = fArr[37] - fArr[45];
        float sqrt2 = ((float) Math.sqrt((f18 * f18) + (f19 * f19))) / sqrt;
        float f26 = fArr[56] - fArr[48];
        float f27 = fArr[57] - fArr[49];
        float sqrt3 = (float) Math.sqrt((f26 * f26) + (f27 * f27));
        float f28 = fArr[52] - fArr[60];
        float f29 = fArr[53] - fArr[61];
        float sqrt4 = ((float) Math.sqrt((f28 * f28) + (f29 * f29))) / sqrt3;
        if (sqrt2 > this.closeEyeLeftThreshold && sqrt4 > this.closeEyeRightThreshold) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("quality_type", "eye_close");
                jSONObject.put(PhotoQualityInfo.QUALITY_SCORE, sqrt2 + "," + sqrt4);
                jSONObject.put("quality_thr", this.closeEyeLeftThreshold + "," + this.closeEyeRightThreshold);
            } catch (JSONException e16) {
                YtLogger.e(TAG, "make log json error", e16);
            }
            YtLogger.o(TAG, jSONObject.toString());
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isFaceCenter(YTFaceTracker.TrackedFace trackedFace, float f16, float f17) {
        float f18;
        float f19;
        float f26;
        float f27;
        int height = trackedFace.faceRect.height();
        int width = trackedFace.faceRect.width();
        float f28 = this.faceMinHeightThreshold;
        float f29 = height;
        boolean z16 = true;
        if (f29 < f17 * f28) {
            float f36 = f16 / f17;
            if (f29 / f17 < f28) {
                if (this.faceRealMinHeightThreshold < f28) {
                    f18 = (float) (((r5 - r6) / (f28 - r6)) * 0.1d);
                    float f37 = f29 / (f18 + 0.61f);
                    f19 = f36 * f37;
                    f26 = width;
                    if (f26 > f19) {
                        f19 = f26;
                    }
                    Rect rect = trackedFace.faceRect;
                    float width2 = (trackedFace.faceRect.width() / 2.0f) + rect.left;
                    float height2 = ((rect.height() / 2.0f) + trackedFace.faceRect.top) - (f37 / 2.0f);
                    f27 = width2 - (f19 / 2.0f);
                    if (f19 + f27 < f16 || f37 + height2 >= f17 || f27 <= 0.0f || height2 <= 0.0f) {
                        z16 = false;
                    }
                    if (!z16) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("quality_type", "face_not_center");
                            jSONObject.put(PhotoQualityInfo.QUALITY_SCORE, "x:" + f27 + ",y:" + height2 + "height:" + f37 + ",width:" + f19);
                        } catch (JSONException e16) {
                            YtLogger.e(TAG, "make log json error", e16);
                        }
                        YtLogger.o(TAG, jSONObject.toString());
                    }
                }
            }
            f18 = 0.01f;
            float f372 = f29 / (f18 + 0.61f);
            f19 = f36 * f372;
            f26 = width;
            if (f26 > f19) {
            }
            Rect rect2 = trackedFace.faceRect;
            float width22 = (trackedFace.faceRect.width() / 2.0f) + rect2.left;
            float height22 = ((rect2.height() / 2.0f) + trackedFace.faceRect.top) - (f372 / 2.0f);
            f27 = width22 - (f19 / 2.0f);
            if (f19 + f27 < f16) {
            }
            z16 = false;
            if (!z16) {
            }
        }
        return z16;
    }

    private int isFaceHeightStandard(YTFaceTracker.TrackedFace trackedFace, int i3) {
        int height = trackedFace.faceRect.height();
        float f16 = i3;
        float f17 = this.faceRealMinHeightThreshold * f16;
        float f18 = f16 * this.faceMaxHeightThreshold;
        float f19 = height;
        if (f19 < f17) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("quality_type", "face_too_near");
                jSONObject.put(PhotoQualityInfo.QUALITY_SCORE, height);
                jSONObject.put("quality_thr", f17);
            } catch (JSONException e16) {
                YtLogger.e(TAG, "make log json error", e16);
            }
            YtLogger.o(TAG, jSONObject.toString());
            return 1;
        }
        if (f19 > f18) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("quality_type", "face_too_far");
                jSONObject2.put(PhotoQualityInfo.QUALITY_SCORE, height);
                jSONObject2.put("quality_thr", f18);
            } catch (JSONException e17) {
                YtLogger.e(TAG, "make log json error", e17);
            }
            YtLogger.o(TAG, jSONObject2.toString());
            return 2;
        }
        return 0;
    }

    private boolean isMouthCLose(YTFaceTracker.TrackedFace trackedFace) {
        boolean z16;
        float[] fArr = trackedFace.faceShape;
        float abs = Math.abs(((fArr[129] + fArr[109]) / 2.0f) - ((fArr[119] + fArr[97]) / 2.0f)) / Math.abs(fArr[90] - fArr[102]);
        if (abs < this.closeMouthThreshold) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("quality_type", "mouth_cLose");
                jSONObject.put(PhotoQualityInfo.QUALITY_SCORE, abs);
                jSONObject.put("quality_thr", this.closeMouthThreshold);
            } catch (JSONException e16) {
                YtLogger.e(TAG, "make log json error", e16);
            }
            YtLogger.o(TAG, jSONObject.toString());
        }
        return z16;
    }

    private void sendFSMEvent(HashMap<String, Object> hashMap) {
        YtFSM.getInstance().sendFSMEvent(hashMap);
    }

    public Bitmap cropBitmap(Bitmap bitmap, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
        return Bitmap.createBitmap(bitmap, i3, i16, i17, i18);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.enter();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        YtLogger.o(TAG, makeStateInfo(TAG, 1));
        YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        if (stateByName == null) {
            return;
        }
        String str = (String) stateByName.getStateDataBy("control_config");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length > 1 && split[0].equals("quality_close_mouth_threshold")) {
                this.closeMouthThreshold = Float.parseFloat(split[1]);
            }
            if (split.length > 1 && split[0].equals("compress_pose_image_score")) {
                int parseInt = Integer.parseInt(split[1]);
                this.compressPoseImageScore = parseInt;
                if (parseInt < 80) {
                    this.compressPoseImageScore = 80;
                } else if (parseInt > 100) {
                    this.compressPoseImageScore = 99;
                }
            }
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.exit();
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void loadStateWith(String str, JSONObject jSONObject, YtSdkConfig ytSdkConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, jSONObject, ytSdkConfig);
            return;
        }
        super.loadStateWith(str, jSONObject, ytSdkConfig);
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        this.continuousCount = 0;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void moveToNextState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.moveToNextState();
        if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE) {
            if (YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName)) == -1) {
                sendFSMTransitError(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
                return;
            }
            return;
        }
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.reset();
        this.continuousCount = 0;
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    }

    public Bitmap scaleBitmap(Bitmap bitmap, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return Bitmap.createScaledBitmap(bitmap, i3, i16, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01b0, code lost:
    
        if (r8 != 5) goto L82;
     */
    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(YTImageData yTImageData, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, yTImageData, Long.valueOf(j3));
            return;
        }
        super.update(yTImageData, j3);
        if (this.needCloseTimeout && this.isPause.get()) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.liveness.FaceQualityState.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceQualityState.this);
                    } else {
                        put(StateEvent.Name.FSM_STATE_PAUSE, YtSDKKitCommon.StateNameHelper.StateClassName.QUALITY_STATE);
                        put(StateEvent.Name.UI_TIPS, StringCode.MSG_FSM_PAUSE);
                    }
                }
            });
            try {
                LockMethodProxy.sleep(30L);
                return;
            } catch (InterruptedException e16) {
                YtLogger.e(TAG, "Thread sleep error", e16);
                return;
            }
        }
        YtSDKKitCommon.StateNameHelper.StateClassName stateClassName = this.nextStateName;
        YtSDKKitCommon.StateNameHelper.StateClassName stateClassName2 = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        if (stateClassName != stateClassName2) {
            moveToNextState();
            return;
        }
        if (this.needFaceQuality && this.needLocalFaceBestImage) {
            YtFSMBaseState stateByName = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(stateClassName2));
            int intValue = ((Integer) stateByName.getStateDataBy("pose_state")).intValue();
            int intValue2 = ((Integer) stateByName.getStateDataBy("shelter_state")).intValue();
            if (intValue != 0 && intValue != 9) {
                this.continuousCount = 0;
                moveToNextState();
                return;
            }
            YTFaceTracker.TrackedFace[] trackedFaceArr = (YTFaceTracker.TrackedFace[]) stateByName.getStateDataBy("face_status");
            if (trackedFaceArr != null && trackedFaceArr.length > 0) {
                YTFaceTracker.TrackedFace trackedFace = trackedFaceArr[0];
                if (intValue2 != 0) {
                    this.continuousCount = 0;
                    sendFSMEvent(StateEvent.ActionValue.STAGE_NOTPASS, SilentLivenessHelper.convertBlock(intValue2));
                    moveToNextState();
                    return;
                }
                if (!SilentLivenessHelper.faceAngleForceCheck(trackedFace, this.secondaryYawThreshold, this.secondaryPitchThreshold, this.secondaryRollThreshold)) {
                    YtLogger.o(TAG, "correctionFace  angle not pass, threshold y:" + this.secondaryYawThreshold + "|p=" + this.secondaryPitchThreshold + "|r=" + this.secondaryRollThreshold);
                    this.continuousCount = 0;
                    sendFSMEvent(StateEvent.ActionValue.STAGE_NOTPASS, StringCode.FL_POSE_INCORRECT);
                    moveToNextState();
                    return;
                }
                int isFaceHeightStandard = isFaceHeightStandard(trackedFace, Math.max(yTImageData.height, yTImageData.width));
                if (isFaceHeightStandard != 1) {
                    if (isFaceHeightStandard != 2) {
                        if (!isMouthCLose(trackedFace)) {
                            this.continuousCount = 0;
                            sendFSMEvent(StateEvent.ActionValue.STAGE_NOTPASS, StringCode.FL_CLOSE_MOUTH);
                            moveToNextState();
                            return;
                        }
                        if (!isEyeOpen(trackedFace)) {
                            this.continuousCount = 0;
                            sendFSMEvent(StateEvent.ActionValue.STAGE_NOTPASS, StringCode.FL_POSE_OPEN_EYE);
                            moveToNextState();
                            return;
                        }
                        boolean isFaceCenter = isFaceCenter(trackedFace, yTImageData.width, yTImageData.height);
                        if (this.needLocalFaceBestImage && !isFaceCenter) {
                            this.continuousCount = 0;
                            sendFSMEvent(StateEvent.ActionValue.STAGE_NOTPASS, StringCode.FL_POSE_CLOSER);
                            moveToNextState();
                            return;
                        }
                        int i3 = this.continuousCount + 1;
                        this.continuousCount = i3;
                        if (i3 < continuousQualityNumThreshold) {
                            sendFSMEvent(StateEvent.ActionValue.STAGE_PASS, StringCode.FL_POSE_KEEP);
                            moveToNextState();
                            return;
                        } else {
                            byte[] faceHeightStandard = faceHeightStandard(trackedFace, yTImageData);
                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put(StateEvent.Name.BEST_FACE_IMAGE, new BestFaceImage(faceHeightStandard, yTImageData.width, yTImageData.height));
                            hashMap.put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.STAGE_PASS);
                            sendFSMEvent(hashMap);
                        }
                    } else {
                        this.continuousCount = 0;
                        sendFSMEvent(StateEvent.ActionValue.STAGE_NOTPASS, StringCode.FL_POSE_FARER);
                        moveToNextState();
                        return;
                    }
                } else {
                    this.continuousCount = 0;
                    sendFSMEvent(StateEvent.ActionValue.STAGE_NOTPASS, StringCode.FL_POSE_CLOSER);
                    moveToNextState();
                    return;
                }
            } else {
                this.continuousCount = 0;
                moveToNextState();
                return;
            }
        }
        int ordinal = YtFSM.getInstance().getWorkMode().ordinal();
        if (ordinal != 2 && ordinal != 3) {
            if (ordinal == 4) {
                this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE;
            }
            this.continuousCount = 0;
            moveToNextState();
        }
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE;
        this.continuousCount = 0;
        moveToNextState();
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void updateSDKSetting(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        super.updateSDKSetting(jSONObject);
        try {
            if (jSONObject.has("quality_close_eye_left_threshold")) {
                this.closeEyeLeftThreshold = (float) jSONObject.getDouble("quality_close_eye_left_threshold");
            }
            if (jSONObject.has("quality_close_eye_right_threshold")) {
                this.closeEyeRightThreshold = (float) jSONObject.getDouble("quality_close_eye_right_threshold");
            }
            if (jSONObject.has("quality_close_mouth_threshold")) {
                this.closeMouthThreshold = (float) jSONObject.getDouble("quality_close_mouth_threshold");
            }
            if (jSONObject.has("quality_face_min_height_threshold")) {
                this.faceMinHeightThreshold = (float) jSONObject.getDouble("quality_face_min_height_threshold");
            }
            if (jSONObject.has("quality_face_max_height_threshold")) {
                this.faceMaxHeightThreshold = (float) jSONObject.getDouble("quality_face_max_height_threshold");
            }
            if (jSONObject.has("secondary_yaw_threshold")) {
                this.secondaryYawThreshold = (float) jSONObject.getDouble("secondary_yaw_threshold");
            }
            if (jSONObject.has("secondary_pitch_threshold")) {
                this.secondaryPitchThreshold = (float) jSONObject.getDouble("secondary_pitch_threshold");
            }
            if (jSONObject.has("secondary_roll_threshold")) {
                this.secondaryRollThreshold = (float) jSONObject.getDouble("secondary_roll_threshold");
            }
            if (jSONObject.has("need_face_quality")) {
                this.needFaceQuality = jSONObject.getBoolean("need_face_quality");
            }
            if (jSONObject.has("need_local_face_best_image")) {
                this.needLocalFaceBestImage = jSONObject.getBoolean("need_local_face_best_image");
            }
            if (jSONObject.has("local_face_best_image_quality")) {
                this.localFaceBestImageQuality = jSONObject.getInt("local_face_best_image_quality");
            }
            if (jSONObject.has("continuous_quality_num_threshold")) {
                continuousQualityNumThreshold = jSONObject.getInt("continuous_quality_num_threshold");
            }
            if (jSONObject.has("quality_face_real_min_height_threshold")) {
                this.faceRealMinHeightThreshold = (float) jSONObject.getDouble("quality_face_real_min_height_threshold");
            }
            if (jSONObject.has("need_close_timeout")) {
                this.needCloseTimeout = jSONObject.getBoolean("need_close_timeout");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void sendFSMEvent(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(StateEvent.Name.UI_ACTION, str);
        hashMap.put(StateEvent.Name.UI_TIPS, str2);
        YtFSM.getInstance().sendFSMEvent(hashMap);
    }
}
