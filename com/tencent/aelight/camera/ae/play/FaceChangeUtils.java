package com.tencent.aelight.camera.ae.play;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class FaceChangeUtils {
    private static final String TAG = "FaceChangeUtils";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    interface ChangeFaceBatchCallback {
        void onResult(List<ChangeFaceResult> list);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class ChangeFaceResult {
        public static final int ERROR_FACE_POINTS_EMPTY = -4;
        public static final int ERROR_FAILED_PARSE_MATERIAL = -2;
        public static final int ERROR_NO_FACE_DETECTED = -3;
        public static final int ERROR_NULL_PARAMETERS = -1;
        public static final int ERROR_OK = 0;
        public final Bitmap data;
        public final int errCode;
        public final Throwable exception;
        public final boolean isSuccess;

        /* renamed from: msg, reason: collision with root package name */
        public final String f65658msg;

        ChangeFaceResult(boolean z16, int i3, String str, Throwable th5, Bitmap bitmap) {
            this.isSuccess = z16;
            this.errCode = i3;
            this.f65658msg = str;
            this.exception = th5;
            this.data = bitmap;
        }

        private static ChangeFaceResult fail(int i3, String str) {
            return new ChangeFaceResult(false, i3, str, null, null);
        }

        private static ChangeFaceResult success(Bitmap bitmap) {
            return new ChangeFaceResult(true, 0, null, null, bitmap);
        }

        public String toString() {
            return "ChangeFaceResult{isSuccess=" + this.isSuccess + ", errCode=" + this.errCode + ", msg='" + this.f65658msg + "', exception=" + this.exception + ", data=" + this.data + '}';
        }

        private static ChangeFaceResult fail(int i3, String str, Throwable th5) {
            return new ChangeFaceResult(false, i3, str, th5, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    interface ChangeFaceSingleCallback {
        void onResult(ChangeFaceResult changeFaceResult);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface CropFaceCallback {
        public static final int ERROR_FAILED_DETECT_FACE = -2;
        public static final int ERROR_INTERNAL_EXCEPTION = -1;
        public static final int ERROR_INVALID_PHOTO = -3;

        void onFail(int i3);

        void onSuccess(Bitmap bitmap);
    }

    public static void cropFace(Bitmap bitmap, CropFaceCallback cropFaceCallback) {
        cropFace(bitmap, cropFaceCallback, false);
    }

    private static void cropFaceInternal(Bitmap bitmap, CropFaceCallback cropFaceCallback) {
        cropFaceInternal(detectFace(bitmap), bitmap, cropFaceCallback);
    }

    public static PTFaceAttr detectFace(Bitmap bitmap) {
        return detectFace(bitmap, 0.16666666666666666d);
    }

    public static List<PointF> getMaxFacePoints(List<List<PointF>> list, double d16) {
        if (list.size() == 1) {
            List<PointF> list2 = list.get(0);
            CosFunUtil.scale(list2, 1.0d / d16);
            FaceOffUtil.getFullCoords(list2, 2.0f);
            return list2;
        }
        long j3 = -1;
        int i3 = -1;
        int i16 = 0;
        for (int i17 = 0; i17 < list.size(); i17++) {
            List<PointF> list3 = list.get(i17);
            CosFunUtil.scale(list3, 1.0d / d16);
            FaceOffUtil.getFullCoords(list3, 2.0f);
            PointF pointF = list3.get(101);
            PointF pointF2 = list3.get(99);
            int distance = (int) AlgoUtils.getDistance(pointF2, list3.get(105));
            long distance2 = ((int) AlgoUtils.getDistance(pointF2, pointF)) * distance;
            if (distance2 > j3 || (distance2 == j3 && distance > i3)) {
                i16 = i17;
                i3 = distance;
                j3 = distance2;
            }
        }
        return list.get(i16);
    }

    private static SizeI initMaxLength() {
        if (DeviceUtils.hasDeviceHigh(AEModule.getContext())) {
            return new SizeI(1080, 1920);
        }
        if (DeviceUtils.hasDeviceNormal(AEModule.getContext())) {
            return new SizeI(720, 1280);
        }
        return new SizeI(720, 1280);
    }

    public static void cropFace(Bitmap bitmap, CropFaceCallback cropFaceCallback, boolean z16) {
        cropFace(bitmap, null, cropFaceCallback, z16);
    }

    public static PTFaceAttr detectFace(Bitmap bitmap, double d16) {
        if (!d.t()) {
            ms.a.c(TAG, "light sdk so not ready.");
            boolean s16 = d.s();
            ms.a.f(TAG, "load result: " + s16);
            if (!s16) {
                return new PTFaceAttr(new PTFaceAttr.Builder().facePoints(new ArrayList()));
            }
        }
        AEStaticDetector.initDetector(AEResUtil.v("FACE_AGENT"));
        return AEStaticDetector.detectFace(bitmap);
    }

    public static boolean hasFaceInPic(final Bitmap bitmap) {
        final PTFaceAttr[] pTFaceAttrArr = new PTFaceAttr[1];
        runInGLThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.FaceChangeUtils.1
            @Override // java.lang.Runnable
            public void run() {
                pTFaceAttrArr[0] = FaceChangeUtils.detectFace(bitmap);
            }
        }, true, "GLThread-checkHasFaceInPic");
        return hasValidFace(pTFaceAttrArr[0]);
    }

    public static void cropFace(final Bitmap bitmap, final PTFaceAttr pTFaceAttr, final CropFaceCallback cropFaceCallback, boolean z16) {
        if (cropFaceCallback == null) {
            return;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            runInGLThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.b
                @Override // java.lang.Runnable
                public final void run() {
                    FaceChangeUtils.lambda$cropFace$0(PTFaceAttr.this, bitmap, cropFaceCallback);
                }
            }, z16, "GLThread-cropFace");
        } else {
            cropFaceCallback.onFail(-3);
        }
    }

    private static void cropFaceInternal(PTFaceAttr pTFaceAttr, Bitmap bitmap, CropFaceCallback cropFaceCallback) {
        if (pTFaceAttr != null && pTFaceAttr.getAllFacePoints() != null && !pTFaceAttr.getAllFacePoints().isEmpty()) {
            List<PointF> maxFacePoints = getMaxFacePoints(pTFaceAttr.getAllFacePoints(), pTFaceAttr.getFaceDetectScale());
            PointF pointF = maxFacePoints.get(101);
            PointF pointF2 = maxFacePoints.get(99);
            PointF pointF3 = maxFacePoints.get(105);
            PointF pointF4 = maxFacePoints.get(103);
            int distance = (int) AlgoUtils.getDistance(pointF2, pointF3);
            int distance2 = (int) AlgoUtils.getDistance(pointF2, pointF);
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float[] fArr = {pointF2.x / width, pointF2.y / height, pointF.x / width, pointF.y / height, pointF4.x / width, pointF4.y / height, pointF3.x / width, pointF3.y / height};
            VideoFilterBase videoFilterBase = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
            videoFilterBase.ApplyGLSLFilter();
            videoFilterBase.setTexCords(fArr);
            int createTexture = RendererUtils.createTexture(bitmap);
            int createTexture2 = RendererUtils.createTexture();
            Frame frame = FrameBufferCache.getInstance().get(distance, distance2);
            videoFilterBase.RenderProcess(createTexture, distance, distance2, createTexture2, 0.0d, frame);
            Bitmap saveTexture = RendererUtils.saveTexture(createTexture2, distance, distance2);
            frame.unlock();
            videoFilterBase.clearGLSLSelf();
            RendererUtils.clearTexture(createTexture);
            RendererUtils.clearTexture(createTexture2);
            cropFaceCallback.onSuccess(saveTexture);
            return;
        }
        cropFaceCallback.onFail(-2);
    }

    public static PTFaceAttr detectFaceOrigin(Bitmap bitmap) {
        return detectFace(bitmap, 1.0d);
    }

    public static boolean hasValidFace(PTFaceAttr pTFaceAttr) {
        return (pTFaceAttr == null || pTFaceAttr.getAllFacePoints() == null || pTFaceAttr.getAllFacePoints().size() <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cropFace$0(PTFaceAttr pTFaceAttr, Bitmap bitmap, CropFaceCallback cropFaceCallback) {
        try {
            if (pTFaceAttr == null) {
                cropFaceInternal(bitmap, cropFaceCallback);
            } else {
                cropFaceInternal(pTFaceAttr, bitmap, cropFaceCallback);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            cropFaceCallback.onFail(-1);
        }
    }

    public static void runInGLThread(final Runnable runnable, boolean z16, String str) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "GLThread-default";
        }
        final SimpleGLThread simpleGLThread = new SimpleGLThread(null, str);
        Runnable runnable2 = new Runnable() { // from class: com.tencent.aelight.camera.ae.play.FaceChangeUtils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    simpleGLThread.destroy();
                }
            }
        };
        if (z16) {
            simpleGLThread.postJobSync(runnable2);
        } else {
            simpleGLThread.postJob(runnable2);
        }
    }

    public static List<PointF> transFromImageSpace2ContainerSpace(int i3, int i16, int i17, int i18, List<PointF> list) {
        float f16 = i3;
        float f17 = i16;
        float f18 = (f16 * 1.0f) / f17;
        float f19 = i17;
        float f26 = f19 * 1.0f;
        float f27 = i18;
        float f28 = f26 / f27;
        LinkedList linkedList = new LinkedList(list);
        LinkedList linkedList2 = new LinkedList();
        int i19 = 0;
        if (f18 <= f28) {
            float f29 = (f27 * 1.0f) / f17;
            float f36 = (f19 - (f16 * f29)) / 2.0f;
            while (i19 < linkedList.size()) {
                PointF pointF = (PointF) linkedList.get(i19);
                linkedList2.add(new PointF((pointF.x * f29) + f36, pointF.y * f29));
                i19++;
            }
        } else {
            float f37 = f26 / f16;
            float f38 = (f27 - (f17 * f37)) / 2.0f;
            while (i19 < linkedList.size()) {
                PointF pointF2 = (PointF) linkedList.get(i19);
                linkedList2.add(new PointF(pointF2.x * f37, (pointF2.y * f37) + f38));
                i19++;
            }
        }
        return linkedList2;
    }
}
