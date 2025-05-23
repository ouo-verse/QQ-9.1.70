package com.tencent.mobileqq.wink.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.gyailib.library.FaceDetector;
import com.gyailib.library.FaceDetectorFeature;
import com.gyailib.library.GYAIFace;
import com.gyailib.library.GYAIFaceClassify;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.play.api.IFaceChangeUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/utils/j;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "f", "", "path", "g", "isFaceNecessary", "Lcom/tencent/mobileqq/wink/utils/j$a;", "callback", "", "i", "Lcom/gyailib/library/GYAIFaceClassify;", "d", "Lcom/gyailib/library/GYAIFace;", "e", "Lcom/gyailib/library/FaceDetectorFeature;", "faceDetectorFeature", "Landroid/graphics/Rect;", "c", "imagePath", "", "b", "a", "", "longEdgeMax", "shortEdgeMax", tl.h.F, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f326712a = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/j$a;", "", "", "hasFace", "isLegal", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean hasFace, boolean isLegal);
    }

    j() {
    }

    private final Rect c(FaceDetectorFeature faceDetectorFeature) {
        int i3 = faceDetectorFeature.boundsX;
        int i16 = faceDetectorFeature.boundsY;
        return new Rect(i3, i16, faceDetectorFeature.boundsW + i3, faceDetectorFeature.boundsH + i16);
    }

    private final GYAIFaceClassify d() {
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_FACE_CLASSIFY)) {
            return null;
        }
        GYAIFaceClassify gYAIFaceClassify = new GYAIFaceClassify();
        SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
        sDKDeviceConfig.setDevice("ARM");
        int initInstance = gYAIFaceClassify.initInstance(sDKDeviceConfig);
        if (initInstance != 0) {
            w53.b.c("FaceDetectHelper", "getGYAIFaceClassifyInstance initInstance error, ret:" + initInstance);
            return null;
        }
        QRouteApi api = QRoute.api(IAEResUtil.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAEResUtil::class.java)");
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        String lightBundleDir = ((IAEResUtil) api).getLightBundleDir(LightConstants.AgentType.FACE_CLASSIFY_AGENT);
        Intrinsics.checkNotNullExpressionValue(lightBundleDir, "aeResUtil.getLightBundle\u2026Type.FACE_CLASSIFY_AGENT)");
        hashMap.put("root-path", lightBundleDir);
        sDKModelConfig.modelPaths = hashMap;
        gYAIFaceClassify.setupWithModel(sDKModelConfig);
        return gYAIFaceClassify;
    }

    private final GYAIFace e() {
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_FACE)) {
            return null;
        }
        GYAIFace gYAIFace = new GYAIFace();
        SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
        sDKDeviceConfig.setDevice(PreDownloadConstants.RPORT_KEY_CPU);
        int initInstance = gYAIFace.initInstance(sDKDeviceConfig);
        if (initInstance != 0) {
            w53.b.c("FaceDetectHelper", "getGYAIFaceInstance initInstance error, ret:" + initInstance);
            return null;
        }
        QRouteApi api = QRoute.api(IAEResUtil.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAEResUtil::class.java)");
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        String lightBundleDir = ((IAEResUtil) api).getLightBundleDir("FACE_AGENT");
        Intrinsics.checkNotNullExpressionValue(lightBundleDir, "aeResUtil.getLightBundle\u2026nts.AgentType.FACE_AGENT)");
        hashMap.put("root-path", lightBundleDir);
        sDKModelConfig.modelPaths = hashMap;
        gYAIFace.setupWithModel(sDKModelConfig);
        return gYAIFace;
    }

    @JvmStatic
    public static final boolean f(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        w53.b.a("FaceDetectHelper", "hasFaceInImage width: " + bitmap.getWidth() + " height:" + bitmap.getHeight());
        PTFaceAttr detectFaceOrigin = ((IFaceChangeUtils) QRoute.api(IFaceChangeUtils.class)).detectFaceOrigin(bitmap);
        if (detectFaceOrigin == null || detectFaceOrigin.getAllFacePoints() == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(detectFaceOrigin.getAllFacePoints(), "faceAttr.allFacePoints");
        if (!(!r4.isEmpty())) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean g(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return f326712a.h(path, 512, 512);
    }

    @JvmStatic
    public static final void i(@NotNull String path, boolean isFaceNecessary, @NotNull a callback) {
        Bitmap bitmap;
        FaceDetectorFeature[] faceDetectorFeatureArr;
        boolean z16;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!com.tencent.mobileqq.wink.l.d()) {
            w53.b.c("FaceDetectHelper", "hasLegalFaceFromImage isLibrary not Loaded");
            callback.a(true, true);
            return;
        }
        j jVar = f326712a;
        GYAIFace e16 = jVar.e();
        if (e16 == null) {
            w53.b.c("FaceDetectHelper", "hasLegalFaceFromImage getGYAIFaceInstance null");
            callback.a(true, true);
            return;
        }
        GYAIFaceClassify d16 = jVar.d();
        if (d16 == null) {
            w53.b.c("FaceDetectHelper", "hasLegalFaceFromImage getGYAIFaceClassifyInstance null");
            callback.a(true, true);
            return;
        }
        try {
            bitmap = f.j(path, 512, 512, true);
        } catch (Throwable th5) {
            w53.b.d("FaceDetectHelper", "hasLegalFaceFromImage : getBitmapWithSize fail", th5);
            bitmap = null;
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            w53.b.c("FaceDetectHelper", "hasLegalFaceFromImage bitmap is null");
            callback.a(false, false);
            return;
        }
        boolean f16 = f(bitmap2);
        FaceDetector faceDetector = new FaceDetector();
        e16.forwardDetect(bitmap2, faceDetector, 0);
        e16.cleanupModelData();
        if (f16 && (faceDetectorFeatureArr = faceDetector.faces) != null) {
            Intrinsics.checkNotNullExpressionValue(faceDetectorFeatureArr, "faceDetectorCommon.faces");
            if (faceDetectorFeatureArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                j jVar2 = f326712a;
                FaceDetectorFeature faceDetectorFeature = faceDetector.faces[0];
                Intrinsics.checkNotNullExpressionValue(faceDetectorFeature, "faceDetectorCommon.faces[0]");
                Rect c16 = jVar2.c(faceDetectorFeature);
                GYDetectCommonResultStruct gYDetectCommonResultStruct = new GYDetectCommonResultStruct();
                d16.forwardDetect(bitmap2, c16, faceDetector.faces[0].fFeatures256, gYDetectCommonResultStruct, 0);
                d16.cleanupModelData();
                String str = gYDetectCommonResultStruct.items[0].classifyName;
                w53.b.f("FaceDetectHelper", "hasLegalFaceFromImage detect success, classifyName:" + str);
                callback.a(true, Intrinsics.areEqual(str, "sensitive_person") ^ true);
                return;
            }
        }
        w53.b.f("FaceDetectHelper", "hasLegalFaceFromImage detect failed\uff0c has no face, isFaceNecessary:" + isFaceNecessary);
        callback.a(false, isFaceNecessary ^ true);
    }

    @Nullable
    public final List<FaceDetectorFeature> a(@NotNull Bitmap bitmap) {
        List<FaceDetectorFeature> list;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            GYAIFace e16 = e();
            if (e16 == null) {
                return null;
            }
            FaceDetector faceDetector = new FaceDetector();
            e16.forwardDetect(bitmap, faceDetector, 0);
            e16.cleanupModelData();
            FaceDetectorFeature[] faceDetectorFeatureArr = faceDetector.faces;
            Intrinsics.checkNotNullExpressionValue(faceDetectorFeatureArr, "faceDetectorCommon.faces");
            list = ArraysKt___ArraysKt.toList(faceDetectorFeatureArr);
            return list;
        } catch (Throwable th5) {
            w53.b.d("FaceDetectHelper", "detectFaces : getBitmapWithSize fail", th5);
            return null;
        }
    }

    @Nullable
    public final List<FaceDetectorFeature> b(@NotNull String imagePath) {
        List<FaceDetectorFeature> list;
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        try {
            Bitmap c16 = f.c(imagePath);
            GYAIFace e16 = e();
            if (e16 == null) {
                return null;
            }
            FaceDetector faceDetector = new FaceDetector();
            e16.forwardDetect(c16, faceDetector, 0);
            e16.cleanupModelData();
            FaceDetectorFeature[] faceDetectorFeatureArr = faceDetector.faces;
            Intrinsics.checkNotNullExpressionValue(faceDetectorFeatureArr, "faceDetectorCommon.faces");
            list = ArraysKt___ArraysKt.toList(faceDetectorFeatureArr);
            return list;
        } catch (Throwable th5) {
            w53.b.d("FaceDetectHelper", "detectFaces : getBitmapWithSize fail", th5);
            return null;
        }
    }

    public final boolean h(@NotNull String path, int longEdgeMax, int shortEdgeMax) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            bitmap = f.j(path, longEdgeMax, shortEdgeMax, true);
        } catch (Throwable th5) {
            w53.b.d("FaceDetectHelper", "hasFaceInImageWithScale : getBitmapWithSize fail", th5);
            bitmap = null;
        }
        if (bitmap != null) {
            boolean f16 = f(bitmap);
            bitmap.recycle();
            return f16;
        }
        return false;
    }
}
