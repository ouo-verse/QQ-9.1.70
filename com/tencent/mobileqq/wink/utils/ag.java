package com.tencent.mobileqq.wink.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.gyailib.library.GYAISceneChain;
import com.gyailib.library.GYDetectCommonItemParams;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.IAISceneChainHelper;
import com.tencent.mobileqq.wink.model.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ag;", "", "Lcom/gyailib/library/GYDetectCommonResultStruct;", "resultStruct", "Lcom/tencent/mobileqq/wink/model/a;", "g", "", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/model/a$b;", tl.h.F, "Lcom/gyailib/library/GYAISceneChain;", "c", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "option", "d", "path", "e", "i", "b", "", "a", "f", "Ljava/lang/ThreadLocal;", "Ljava/lang/ThreadLocal;", "mAISceneChainThreadLocal", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ag f326666a = new ag();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ThreadLocal<GYAISceneChain> mAISceneChainThreadLocal = new ThreadLocal<>();

    ag() {
    }

    private final GYAISceneChain c() {
        Map<String, String> mapOf;
        ThreadLocal<GYAISceneChain> threadLocal = mAISceneChainThreadLocal;
        if (threadLocal.get() == null) {
            GYAISceneChain gYAISceneChain = new GYAISceneChain();
            SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
            sDKDeviceConfig.setDevice("ARM");
            if (gYAISceneChain.initInstance(sDKDeviceConfig) != 0) {
                ms.a.c("WinkAISceneChainHelper", "GYAISceneChain initInstance error");
                return null;
            }
            QRouteApi api = QRoute.api(IAEResUtil.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IAEResUtil::class.java)");
            SDKModelConfig sDKModelConfig = new SDKModelConfig();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("scene-dir", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir("SCENE_CLASSIFY")), TuplesKt.to("face-dir", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir("FACE_AGENT")), TuplesKt.to("feature-dir", ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(LightConstants.AgentType.FACE_STATIC_FEATURE_AGENT)));
            sDKModelConfig.modelPaths = mapOf;
            gYAISceneChain.setupWithModel(sDKModelConfig);
            threadLocal.set(gYAISceneChain);
        }
        return threadLocal.get();
    }

    private final com.tencent.mobileqq.wink.model.a g(GYDetectCommonResultStruct resultStruct) {
        boolean z16;
        boolean z17;
        GYDetectCommonItemParams[] gYDetectCommonItemParamsArr = resultStruct.items;
        if (gYDetectCommonItemParamsArr != null) {
            if (gYDetectCommonItemParamsArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                GYDetectCommonItemParams gYDetectCommonItemParams = gYDetectCommonItemParamsArr[0];
                ms.a.a("WinkAISceneChainHelper", "parseDetectChainResult ." + gYDetectCommonItemParams.classifyType + " " + gYDetectCommonItemParams.classifyName);
                com.tencent.mobileqq.wink.model.a aVar = new com.tencent.mobileqq.wink.model.a();
                a.C9064a c9064a = new a.C9064a();
                List<a.b> a16 = aVar.a();
                List<a.C9064a> b16 = aVar.b();
                String[] strArr = resultStruct.items[0].vExtString;
                if (strArr != null) {
                    if (strArr.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (true ^ z17) {
                        for (String it : strArr) {
                            ag agVar = f326666a;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            a.b h16 = agVar.h(it);
                            h16.i((int) gYDetectCommonItemParamsArr[0].frameW);
                            h16.h((int) gYDetectCommonItemParamsArr[0].frameH);
                            a16.add(h16);
                        }
                    }
                }
                c9064a.d(gYDetectCommonItemParamsArr[0].classifyConfidence);
                c9064a.f(gYDetectCommonItemParamsArr[0].classifyType);
                c9064a.e(gYDetectCommonItemParamsArr[0].classifyName);
                b16.add(c9064a);
                return aVar;
            }
        }
        ms.a.c("WinkAISceneChainHelper", "parseDetectChainResult item is null ");
        return null;
    }

    private final a.b h(String config) {
        a.b bVar = new a.b();
        try {
            JSONObject jSONObject = new JSONObject(config);
            String string = jSONObject.getString("gender");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"gender\")");
            int parseInt = Integer.parseInt(string);
            String string2 = jSONObject.getString("age");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"age\")");
            int parseInt2 = Integer.parseInt(string2);
            JSONArray faceRect = jSONObject.getJSONArray(PreDetect.FACE_DETECT);
            ms.a.a("WinkAISceneChainHelper", "parseFaceJson ." + parseInt + " " + parseInt2);
            bVar.j(parseInt);
            bVar.f(parseInt2);
            Intrinsics.checkNotNullExpressionValue(faceRect, "faceRect");
            bVar.g(com.tencent.kuikly.core.render.android.css.ktx.b.F(faceRect));
        } catch (Throwable th5) {
            ms.a.c("WinkAISceneChainHelper", "e " + th5.getMessage());
        }
        return bVar;
    }

    public final boolean a() {
        Iterator<T> it = IAISceneChainHelper.INSTANCE.a().iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist((AEResInfo) it.next())) {
                z16 = false;
            }
        }
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE)) {
            return false;
        }
        return z16;
    }

    public final int b() {
        try {
            return GYAISceneChain.getVersion();
        } catch (Throwable th5) {
            ms.a.c("WinkAISceneChainHelper", "e " + th5.getMessage());
            return 0;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.wink.model.a d(@NotNull Bitmap bitmap, int option) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ms.a.f("WinkAISceneChainHelper", "getSceneChainResult bitmap .");
        if (!f()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        GYDetectCommonResultStruct gYDetectCommonResultStruct = new GYDetectCommonResultStruct();
        GYAISceneChain c16 = c();
        if (c16 == null) {
            return null;
        }
        int forwardDetect = c16.forwardDetect(bitmap, gYDetectCommonResultStruct, 0);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (forwardDetect != 0) {
            ms.a.c("WinkAISceneChainHelper", "getSceneChainResult " + forwardDetect + ".");
            return null;
        }
        com.tencent.mobileqq.wink.model.a g16 = g(gYDetectCommonResultStruct);
        if (g16 != null) {
            g16.c(currentTimeMillis2);
        }
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        ms.a.f("WinkAISceneChainHelper", "getSceneChainResult cost " + currentTimeMillis2 + "ms");
        return g16;
    }

    @Nullable
    public final com.tencent.mobileqq.wink.model.a e(@NotNull String path, int option) {
        Intrinsics.checkNotNullParameter(path, "path");
        ms.a.f("WinkAISceneChainHelper", "getSceneChainResult " + path + ".");
        if (!f()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap i3 = i(path);
        GYDetectCommonResultStruct gYDetectCommonResultStruct = new GYDetectCommonResultStruct();
        GYAISceneChain c16 = c();
        if (c16 == null) {
            return null;
        }
        int forwardDetect = c16.forwardDetect(i3, gYDetectCommonResultStruct, 0);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (forwardDetect != 0) {
            ms.a.c("WinkAISceneChainHelper", "getSceneChainResult " + forwardDetect + ".");
            return null;
        }
        com.tencent.mobileqq.wink.model.a g16 = g(gYDetectCommonResultStruct);
        if (g16 != null) {
            g16.c(currentTimeMillis2);
        }
        if (!i3.isRecycled()) {
            i3.recycle();
        }
        ms.a.f("WinkAISceneChainHelper", "getSceneChainResult cost " + currentTimeMillis2 + "ms");
        return g16;
    }

    public final boolean f() {
        boolean isCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio");
        ms.a.c("WinkAISceneChainHelper", "resReady " + isCameraResReady);
        if (a() && isCameraResReady) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Bitmap i(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Bitmap bitmap = SafeBitmapFactory.decodeFile(path, new BitmapFactory.Options());
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }
}
