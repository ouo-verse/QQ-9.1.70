package com.tencent.biz.richframework.localupload.recommend.research;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.localupload.recommend.IResultCallBack;
import com.tencent.biz.richframework.localupload.recommend.RFWRecommendThread;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.research.RFWResearchEnvManager;
import com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IAISceneChainHelper;
import com.tencent.mobileqq.wink.model.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J&\u0010\t\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002J(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006J$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010J\"\u0010 \u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010$\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/research/RFWResearchEnvManager;", "", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "", "path", "", "option", "Lcom/tencent/mobileqq/wink/model/a;", "detectAISceneChain", "Landroid/graphics/Bitmap;", "scaleBitmap", "chunkIndex", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfoList", "Lcom/tencent/biz/richframework/localupload/recommend/IResultCallBack;", "callback", "", "handleDetectAITaskPerThread", "result", "", "costTime", "mediaInfo", "buildAITagResultStr", "originWidth", "originHeight", "getBitmapScaleFactor", "", "chunkedDetectAISceneChain", "Lcom/tencent/biz/richframework/localupload/recommend/research/RFWResearchEnvManager$IInitEnvCallBack;", "currentRetryCount", "initEnv", "bundlesExists", "isEnvReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mEnvReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getMEnvReady", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "IInitEnvCallBack", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWResearchEnvManager {

    @NotNull
    public static final RFWResearchEnvManager INSTANCE = new RFWResearchEnvManager();

    @NotNull
    private static final AtomicBoolean mEnvReady = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/research/RFWResearchEnvManager$IInitEnvCallBack;", "", "onInitError", "", "onInitSucceed", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface IInitEnvCallBack {
        void onInitError();

        void onInitSucceed();
    }

    RFWResearchEnvManager() {
    }

    private final String buildAITagResultStr(a result, long costTime, RFWMediaInfo mediaInfo, int chunkIndex) {
        StringBuilder sb5 = new StringBuilder();
        if (!result.b().isEmpty()) {
            String classifyType = result.b().get(0).getClassifyType();
            String classifyName = result.b().get(0).getClassifyName();
            float classifyConfidence = result.b().get(0).getClassifyConfidence();
            sb5.append("type:" + classifyType);
            sb5.append(", classifyName:" + classifyName);
            sb5.append(", score:" + classifyConfidence);
        }
        for (a.b bVar : result.a()) {
            sb5.append(", age\uff1a" + bVar.getAge() + ",faceRect\uff1a" + bVar.b() + ",gender\uff1a" + bVar.getGender() + "\n");
        }
        sb5.append(", costTime:" + costTime + "ms");
        sb5.append(", path:" + mediaInfo.getMPath());
        sb5.append(", chunkIndex: " + chunkIndex);
        return "[detectAISceneChain] " + ((Object) sb5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void chunkedDetectAISceneChain$lambda$1$lambda$0(RecommendContext context, int i3, List list, IResultCallBack callback, AtomicInteger chunkCount, long j3, Ref.IntRef researchThreadNum, List mediaInfoList) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(chunkCount, "$chunkCount");
        Intrinsics.checkNotNullParameter(researchThreadNum, "$researchThreadNum");
        Intrinsics.checkNotNullParameter(mediaInfoList, "$mediaInfoList");
        boolean handleDetectAITaskPerThread = INSTANCE.handleDetectAITaskPerThread(context, i3, list, callback);
        if (chunkCount.decrementAndGet() == 0) {
            long currentTimeMillis = System.currentTimeMillis() - j3;
            context.d("RFWResearchEnvManager", "[detectAISceneChain] finish, thread num:" + researchThreadNum.element + ", mediaInfoList.size:" + mediaInfoList.size() + ", cost: " + currentTimeMillis + "ms");
            callback.onFinish(handleDetectAITaskPerThread);
        }
    }

    private final a detectAISceneChain(RecommendContext context, String path, int option) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap scaleBitmap = scaleBitmap(path);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis3 = System.currentTimeMillis();
            a detectAISceneChain = ((IAISceneChainHelper) QRoute.api(IAISceneChainHelper.class)).detectAISceneChain(scaleBitmap, 0);
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            context.dev("RFWResearchEnvManager", "[detectAISceneChain] total cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms, bitmap cost: " + currentTimeMillis2 + "ms, ai tag cost: " + currentTimeMillis4 + "ms, bitmap size: " + scaleBitmap.getWidth() + "*" + scaleBitmap.getHeight() + ", path: " + path);
            return detectAISceneChain;
        } catch (Exception e16) {
            context.e("RFWResearchEnvManager", "[detectAISceneChain] error " + e16);
            return null;
        }
    }

    private final boolean handleDetectAITaskPerThread(RecommendContext context, int chunkIndex, List<RFWMediaInfo> mediaInfoList, IResultCallBack callback) {
        List<List<RFWMediaInfo>> chunked;
        chunked = CollectionsKt___CollectionsKt.chunked(mediaInfoList, 100);
        boolean z16 = false;
        for (List<RFWMediaInfo> list : chunked) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean detectAISceneChain = INSTANCE.detectAISceneChain(context, list, chunkIndex);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            callback.handleBatchResult(list, "chunk index: " + chunkIndex + ", cost: " + currentTimeMillis2 + "ms, cost per photo: " + (currentTimeMillis2 / list.size()) + "ms");
            z16 = detectAISceneChain;
        }
        return z16;
    }

    public static /* synthetic */ void initEnv$default(RFWResearchEnvManager rFWResearchEnvManager, RecommendContext recommendContext, IInitEnvCallBack iInitEnvCallBack, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        rFWResearchEnvManager.initEnv(recommendContext, iInitEnvCallBack, i3);
    }

    private final Bitmap scaleBitmap(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = getBitmapScaleFactor(options.outWidth, options.outHeight);
        Bitmap decodeFile = BitmapFactory.decodeFile(path, options);
        Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(path, options)");
        return decodeFile;
    }

    public final boolean bundlesExists(@NotNull RecommendContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z16 = true;
        for (AEResInfo aEResInfo : IAISceneChainHelper.INSTANCE.a()) {
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo)) {
                context.e("RFWResearchEnvManager", "bundlesExists " + aEResInfo + " not exist");
                z16 = false;
            }
        }
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE)) {
            context.e("RFWResearchEnvManager", "bundlesExists base res not exist");
            return false;
        }
        return z16;
    }

    public final void chunkedDetectAISceneChain(@NotNull final RecommendContext context, @NotNull final List<RFWMediaInfo> mediaInfoList, @NotNull final IResultCallBack callback) {
        List chunked;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = context.getDelegate().getConfigDelegate().getResearchThreadNum();
        if (mediaInfoList.size() < 30) {
            intRef.element = 1;
        }
        int size = (mediaInfoList.size() / intRef.element) + 1;
        chunked = CollectionsKt___CollectionsKt.chunked(mediaInfoList, size);
        context.d("RFWResearchEnvManager", "[chunkedDetectAISceneChain] chunk num:" + chunked.size() + ", mediaInfoList.size:" + mediaInfoList.size() + ", sizePerChunk: " + size);
        final AtomicInteger atomicInteger = new AtomicInteger(chunked.size());
        final long currentTimeMillis = System.currentTimeMillis();
        final int i3 = 0;
        for (Object obj : chunked) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final List list = (List) obj;
            RFWRecommendThread.INSTANCE.getRECOMMEND_THREAD_POOL().execute(new Runnable() { // from class: le0.a
                @Override // java.lang.Runnable
                public final void run() {
                    RFWResearchEnvManager.chunkedDetectAISceneChain$lambda$1$lambda$0(RecommendContext.this, i3, list, callback, atomicInteger, currentTimeMillis, intRef, mediaInfoList);
                }
            });
            i3 = i16;
        }
    }

    public final int getBitmapScaleFactor(int originWidth, int originHeight) {
        int min = Math.min(originWidth / 512, originHeight / 512);
        if (min <= 0) {
            return 1;
        }
        return min;
    }

    public final void initEnv(@NotNull RecommendContext context, @Nullable IInitEnvCallBack callback, int currentRetryCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isEnvReady(context)) {
            if (callback != null) {
                callback.onInitSucceed();
                return;
            }
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (AEResInfo aEResInfo : IAISceneChainHelper.INSTANCE.a()) {
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(aEResInfo)) {
                context.d("RFWResearchEnvManager", "request download " + aEResInfo + ",currentDownloadFileSize:" + atomicInteger.incrementAndGet());
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType, new RFWResearchEnvManager$initEnv$1$1(atomicInteger, context, callback, currentRetryCount));
            }
        }
    }

    public final boolean isEnvReady(@NotNull RecommendContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AtomicBoolean atomicBoolean = mEnvReady;
        boolean z16 = true;
        if (atomicBoolean.get()) {
            return true;
        }
        boolean isCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio");
        boolean loadLightSdk = ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadLightSdk();
        boolean bundlesExists = bundlesExists(context);
        if (!bundlesExists || !isCameraResReady || !loadLightSdk) {
            z16 = false;
        }
        context.d("RFWResearchEnvManager", "resReady " + isCameraResReady + ",loadLightSdk:" + loadLightSdk + ",bundlesExists:" + bundlesExists);
        atomicBoolean.set(z16);
        return z16;
    }

    private final boolean detectAISceneChain(RecommendContext context, List<RFWMediaInfo> mediaInfoList, int chunkIndex) {
        String str;
        for (RFWMediaInfo rFWMediaInfo : mediaInfoList) {
            if (!context.getIsInQZoneEnv().get()) {
                context.d("RFWResearchEnvManager", "[detectAISceneChain] $ app onPause");
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            a detectAISceneChain = detectAISceneChain(context, rFWMediaInfo.getMPath(), 0);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (detectAISceneChain != null) {
                rFWMediaInfo.fillResearchInfo(detectAISceneChain);
                str = buildAITagResultStr(detectAISceneChain, currentTimeMillis2, rFWMediaInfo, chunkIndex);
            } else {
                str = "[detectAISceneChain] error, result is null, path: " + rFWMediaInfo.getMPath() + ", chunkIndex: " + chunkIndex;
            }
            context.dev("RFWResearchEnvManager", str);
            RFWLocalPhotoTracer.INSTANCE.onDetectAITagResult(rFWMediaInfo, str);
        }
        return false;
    }
}
