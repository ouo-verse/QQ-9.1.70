package com.tencent.biz.richframework.localupload.recommend;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.poi.RFWRecommendPoiWrapper;
import com.tencent.biz.richframework.localupload.recommend.report.RFWLocalPhotoReporter;
import com.tencent.biz.richframework.localupload.recommend.research.RFWResearchEnvManager;
import com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IAISceneChainHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001e\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u001d\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010 \u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\bH\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013\u00a8\u00061"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoInfoManager;", "", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "mDbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "mIsAIDetectorUpdate", "", "Ljava/lang/Boolean;", "mIsFirstPageShow", "mIsPoiFilling", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsResearchFilling", "mPoiWrapper", "Lcom/tencent/biz/richframework/localupload/recommend/poi/RFWRecommendPoiWrapper;", "mReportTagArray", "", "", "[Ljava/lang/String;", "checkAllInfoFill", "", "fillInfoListener", "Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoInfoManager$RFWLocalPhotoInfoFillListener;", "shouldReport", "doGetPoiResult", "needGetPoiList", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "doGetResearchResult", "mediaInfoList", "fillLocalPhotoInfo", "hasAccessMediaLocationPermission", "isAIDetectorUpdate", "isPhotoRecordNeedDelete", "rfwMediaInfo", "context", "needFillLocation", "queryPhotoCountByTag", "", "tagType", "queryPhotoCountWithAITag", "queryPhotoCountWithCity", "queryPhotoCountWithLatLon", "reportPhotoInfo", "photoCount", "resetAIDetectorUpdateStatus", "Companion", "RFWLocalPhotoInfoFillListener", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWLocalPhotoInfoManager {

    @NotNull
    private final RecommendContext mContext;

    @NotNull
    private final RFWUploadRecommendDbManager mDbManager;

    @Nullable
    private Boolean mIsAIDetectorUpdate;
    private boolean mIsFirstPageShow;

    @NotNull
    private AtomicBoolean mIsPoiFilling;

    @NotNull
    private AtomicBoolean mIsResearchFilling;

    @NotNull
    private RFWRecommendPoiWrapper mPoiWrapper;

    @NotNull
    private final String[] mReportTagArray;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoInfoManager$RFWLocalPhotoInfoFillListener;", "", "onPhotoInfoFill", "", "dataUpdateType", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo$DataUpdateType;", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface RFWLocalPhotoInfoFillListener {
        void onPhotoInfoFill(@NotNull RFWMediaInfo.DataUpdateType dataUpdateType);
    }

    public RFWLocalPhotoInfoManager(@NotNull RecommendContext mContext, @NotNull RFWUploadRecommendDbManager mDbManager) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mDbManager, "mDbManager");
        this.mContext = mContext;
        this.mDbManager = mDbManager;
        this.mPoiWrapper = new RFWRecommendPoiWrapper(mContext);
        this.mIsResearchFilling = new AtomicBoolean(false);
        this.mIsPoiFilling = new AtomicBoolean(false);
        this.mReportTagArray = new String[]{"\u5408\u5f71", "\u5a5a\u793c", "\u83dc\u80b4", "\u751c\u70b9", "\u897f\u9910", "\u690d\u7269", "\u591c\u666f", "\u4eba\u50cf\u52a0\u98ce\u5149", "\u5929\u7a7a", "\u706b\u9505", "\u996e\u54c1", "\u996e\u6599", "\u6237\u5916", "\u6d77", "\u6c34\u679c", "\u513f\u7ae5", "\u5efa\u7b51", "\u70df\u82b1", "\u52a8\u7269", "\u4e50\u5668", "\u751f\u65e5", "\u86cb\u7cd5", "\u5a5a\u793c", "\u5176\u4ed6"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAllInfoFill(RFWLocalPhotoInfoFillListener fillInfoListener, boolean shouldReport) {
        this.mContext.d("RFWLocalPhotoInfoManager", "[checkAllInfoFill] finish mIsResearchFilling: " + this.mIsResearchFilling.get() + ", mIsPoiFilling: " + this.mIsPoiFilling.get());
        if (!this.mIsResearchFilling.get() && !this.mIsPoiFilling.get()) {
            if (shouldReport) {
                reportPhotoInfo(RFWLocalPhotoTracer.INSTANCE.getPhotoCount());
            }
            fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.ALL_DATA);
        }
    }

    private final void doGetPoiResult(List<RFWMediaInfo> needGetPoiList, final RFWLocalPhotoInfoFillListener fillInfoListener) {
        if (this.mContext.getDelegate().getConfigDelegate().disableGetPoi()) {
            this.mContext.e("RFWLocalPhotoInfoManager", "[doGetPoiResult] is disable");
            return;
        }
        RFWLocalPhotoTracer.INSTANCE.onRequestPoiStart();
        this.mIsPoiFilling.set(true);
        this.mContext.d("RFWLocalPhotoInfoManager", "[doGetPoiResult] needGetPoiList size:" + needGetPoiList.size());
        this.mPoiWrapper.getPoi(needGetPoiList, new IResultCallBack() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWLocalPhotoInfoManager$doGetPoiResult$1
            @Override // com.tencent.biz.richframework.localupload.recommend.IResultCallBack
            public void handleBatchResult(@NotNull List<RFWMediaInfo> mediaInfos, @NotNull String msg2) {
                RecommendContext recommendContext;
                RFWUploadRecommendDbManager rFWUploadRecommendDbManager;
                Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
                Intrinsics.checkNotNullParameter(msg2, "msg");
                recommendContext = RFWLocalPhotoInfoManager.this.mContext;
                recommendContext.d("RFWLocalPhotoInfoManager", "[doPoiResultClassify] handleResult");
                rFWUploadRecommendDbManager = RFWLocalPhotoInfoManager.this.mDbManager;
                rFWUploadRecommendDbManager.updateMediaInfo(mediaInfos);
                RFWLocalPhotoTracer.INSTANCE.onPoiResponse(mediaInfos, msg2);
            }

            @Override // com.tencent.biz.richframework.localupload.recommend.IResultCallBack
            public void onFinish(boolean isBreak) {
                AtomicBoolean atomicBoolean;
                RecommendContext recommendContext;
                atomicBoolean = RFWLocalPhotoInfoManager.this.mIsPoiFilling;
                atomicBoolean.set(false);
                RFWLocalPhotoTracer.INSTANCE.onRequestPoiFinish();
                fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.POI_DATA);
                RFWLocalPhotoInfoManager.this.checkAllInfoFill(fillInfoListener, true);
                recommendContext = RFWLocalPhotoInfoManager.this.mContext;
                recommendContext.d("RFWLocalPhotoInfoManager", "[doPoiResultClassify] finish isBreak: " + isBreak);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doGetResearchResult(final List<RFWMediaInfo> mediaInfoList, final RFWLocalPhotoInfoFillListener fillInfoListener) {
        if (this.mContext.getDelegate().getConfigDelegate().disableResearch()) {
            this.mContext.e("RFWLocalPhotoInfoManager", "[doGetResearchResult] is disable");
            return;
        }
        RFWLocalPhotoTracer.INSTANCE.onDetectAITagStart();
        this.mIsResearchFilling.set(true);
        RFWRecommendThread.INSTANCE.runOnRealTimeThread(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.a
            @Override // java.lang.Runnable
            public final void run() {
                RFWLocalPhotoInfoManager.doGetResearchResult$lambda$1(RFWLocalPhotoInfoManager.this, mediaInfoList, fillInfoListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.concurrent.atomic.AtomicInteger] */
    public static final void doGetResearchResult$lambda$1(final RFWLocalPhotoInfoManager this$0, final List mediaInfoList, final RFWLocalPhotoInfoFillListener fillInfoListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfoList, "$mediaInfoList");
        Intrinsics.checkNotNullParameter(fillInfoListener, "$fillInfoListener");
        RFWResearchEnvManager rFWResearchEnvManager = RFWResearchEnvManager.INSTANCE;
        if (!rFWResearchEnvManager.isEnvReady(this$0.mContext)) {
            this$0.mContext.d("RFWLocalPhotoInfoManager", "[doResearchResultClassify] env not ready");
            RFWResearchEnvManager.initEnv$default(rFWResearchEnvManager, this$0.mContext, new RFWResearchEnvManager.IInitEnvCallBack() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWLocalPhotoInfoManager$doGetResearchResult$1$1
                @Override // com.tencent.biz.richframework.localupload.recommend.research.RFWResearchEnvManager.IInitEnvCallBack
                public void onInitError() {
                    RecommendContext recommendContext;
                    recommendContext = RFWLocalPhotoInfoManager.this.mContext;
                    recommendContext.d("RFWLocalPhotoInfoManager", "[doResearchResultClassify] onInitError");
                }

                @Override // com.tencent.biz.richframework.localupload.recommend.research.RFWResearchEnvManager.IInitEnvCallBack
                public void onInitSucceed() {
                    RecommendContext recommendContext;
                    recommendContext = RFWLocalPhotoInfoManager.this.mContext;
                    recommendContext.d("RFWLocalPhotoInfoManager", "[doResearchResultClassify] env ready reClassify; mediaSize:" + mediaInfoList.size());
                    RFWLocalPhotoInfoManager.this.doGetResearchResult(mediaInfoList, fillInfoListener);
                }
            }, 0, 4, null);
        } else {
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new AtomicInteger(0);
            rFWResearchEnvManager.chunkedDetectAISceneChain(this$0.mContext, mediaInfoList, new IResultCallBack() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWLocalPhotoInfoManager$doGetResearchResult$1$2
                /* JADX WARN: Type inference failed for: r5v8, types: [T, java.util.concurrent.atomic.AtomicInteger] */
                @Override // com.tencent.biz.richframework.localupload.recommend.IResultCallBack
                public void handleBatchResult(@NotNull List<RFWMediaInfo> batchResultMediaInfos, @NotNull String msg2) {
                    RFWUploadRecommendDbManager rFWUploadRecommendDbManager;
                    Intrinsics.checkNotNullParameter(batchResultMediaInfos, "batchResultMediaInfos");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    rFWUploadRecommendDbManager = RFWLocalPhotoInfoManager.this.mDbManager;
                    rFWUploadRecommendDbManager.updateMediaInfo(batchResultMediaInfos);
                    atomicInteger.addAndGet(batchResultMediaInfos.size());
                    RFWLocalPhotoTracer.INSTANCE.onDetectAITagBatchResult(batchResultMediaInfos, msg2 + ", total: " + mediaInfoList.size() + ", finish: " + atomicInteger.get());
                    if (objectRef.element.addAndGet(batchResultMediaInfos.size()) >= 300) {
                        objectRef.element = new AtomicInteger(0);
                        fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.RESEARCH_DATA);
                    }
                }

                @Override // com.tencent.biz.richframework.localupload.recommend.IResultCallBack
                public void onFinish(boolean isBreak) {
                    AtomicBoolean atomicBoolean;
                    RecommendContext recommendContext;
                    atomicBoolean = RFWLocalPhotoInfoManager.this.mIsResearchFilling;
                    atomicBoolean.set(false);
                    RFWLocalPhotoTracer.INSTANCE.onDetectAITagFinish(isBreak);
                    fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.RESEARCH_DATA);
                    RFWLocalPhotoInfoManager.this.checkAllInfoFill(fillInfoListener, true);
                    recommendContext = RFWLocalPhotoInfoManager.this.mContext;
                    recommendContext.d("RFWLocalPhotoInfoManager", "[doResearchResultClassify] finish isBreak" + isBreak);
                }
            });
        }
    }

    private final boolean hasAccessMediaLocationPermission() {
        if (Build.VERSION.SDK_INT < 29 || ContextCompat.checkSelfPermission(this.mContext.getAndroidContext(), QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION) == 0) {
            return true;
        }
        return false;
    }

    private final boolean isAIDetectorUpdate() {
        int i3;
        if (this.mIsAIDetectorUpdate == null) {
            RFWResearchEnvManager rFWResearchEnvManager = RFWResearchEnvManager.INSTANCE;
            if (!rFWResearchEnvManager.isEnvReady(this.mContext)) {
                RFWResearchEnvManager.initEnv$default(rFWResearchEnvManager, this.mContext, null, 0, 4, null);
            }
            int aIDetectorVersion = ((IAISceneChainHelper) QRoute.api(IAISceneChainHelper.class)).getAIDetectorVersion();
            try {
                i3 = Integer.parseInt(this.mContext.getDelegate().getConfigDelegate().getConfig("KEY_AI_DETECTOR_VERSION"));
            } catch (Throwable unused) {
                i3 = -1;
            }
            if (aIDetectorVersion > i3) {
                this.mIsAIDetectorUpdate = Boolean.TRUE;
                this.mContext.getDelegate().getConfigDelegate().saveConfig("KEY_AI_DETECTOR_VERSION", String.valueOf(aIDetectorVersion));
            } else {
                this.mIsAIDetectorUpdate = Boolean.FALSE;
            }
            this.mContext.d("RFWLocalPhotoInfoManager", "[isAIDetectorUpdate] curVersion: " + aIDetectorVersion + ", oldVersion: " + i3 + ", mIsAIDetectorUpdate: " + this.mIsAIDetectorUpdate);
        }
        Boolean bool = this.mIsAIDetectorUpdate;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean isPhotoRecordNeedDelete(RFWMediaInfo rfwMediaInfo, RecommendContext context) {
        return !rfwMediaInfo.fileExists(context);
    }

    private final boolean needFillLocation(RFWMediaInfo rfwMediaInfo) {
        boolean z16;
        boolean z17;
        if (!this.mContext.getDelegate().getConfigDelegate().enableAccessMediaLocationCheck()) {
            return false;
        }
        if (rfwMediaInfo.getMLatitude() == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (rfwMediaInfo.getMLongitude() == -1.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 || !hasAccessMediaLocationPermission()) {
            return false;
        }
        return true;
    }

    private final int queryPhotoCountByTag(String tagType) {
        return this.mDbManager.count("mTagType = ? or mTagSubType = ?", new String[]{tagType, tagType});
    }

    private final int queryPhotoCountWithAITag() {
        return this.mDbManager.count("mTagType != ? and mTagType != ?", new String[]{"", "none"});
    }

    private final int queryPhotoCountWithCity() {
        return this.mDbManager.count("mCity != ? and mCity != ?", new String[]{"", "none"});
    }

    private final int queryPhotoCountWithLatLon() {
        return this.mDbManager.count("mLatitude > ? and mLongitude > ?", new String[]{"0", "0"});
    }

    private final void reportPhotoInfo(final int photoCount) {
        RFWLocalPhotoTracer.INSTANCE.onStartReportFillInfoFinish(photoCount);
        RFWRecommendThread.INSTANCE.getRECOMMEND_THREAD_POOL().execute(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWLocalPhotoInfoManager.reportPhotoInfo$lambda$3(RFWLocalPhotoInfoManager.this, photoCount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportPhotoInfo$lambda$3(RFWLocalPhotoInfoManager this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            int queryPhotoCountWithLatLon = this$0.queryPhotoCountWithLatLon();
            int queryPhotoCountWithCity = this$0.queryPhotoCountWithCity();
            int queryPhotoCountWithAITag = this$0.queryPhotoCountWithAITag();
            JSONObject jSONObject = new JSONObject();
            for (String str : this$0.mReportTagArray) {
                jSONObject.put(str, this$0.queryPhotoCountByTag(str));
            }
            RFWLocalPhotoTracer rFWLocalPhotoTracer = RFWLocalPhotoTracer.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonResult.toString()");
            rFWLocalPhotoTracer.onReportFillInfoFinish(queryPhotoCountWithLatLon, queryPhotoCountWithCity, queryPhotoCountWithAITag, jSONObject2, i3);
            RFWLocalPhotoReporter rFWLocalPhotoReporter = RFWLocalPhotoReporter.INSTANCE;
            RecommendContext recommendContext = this$0.mContext;
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonResult.toString()");
            rFWLocalPhotoReporter.reportFillInfoFinish(recommendContext, queryPhotoCountWithLatLon, queryPhotoCountWithCity, queryPhotoCountWithAITag, jSONObject3, i3);
        } catch (Throwable th5) {
            this$0.mContext.fatal("RFWLocalPhotoInfoManager", th5);
        }
    }

    private final void resetAIDetectorUpdateStatus() {
        if (this.mIsAIDetectorUpdate != null) {
            this.mIsAIDetectorUpdate = Boolean.FALSE;
        }
    }

    public final void fillLocalPhotoInfo(@NotNull RFWLocalPhotoInfoFillListener fillInfoListener) {
        Object last;
        List<RFWMediaInfo> listOf;
        Intrinsics.checkNotNullParameter(fillInfoListener, "fillInfoListener");
        if (this.mContext.getDelegate().getConfigDelegate().disableRecommend()) {
            this.mContext.e("RFWLocalPhotoInfoManager", "[doDbRestoreClassify] is disable");
            return;
        }
        RFWLocalPhotoTracer.INSTANCE.onFillInfoStart();
        fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.CACHE_PLACEHOLDER);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        long j3 = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            List<RFWMediaInfo> query = this.mDbManager.query("_id<" + j3, null, "_id DESC", "200");
            if (query.isEmpty()) {
                break;
            }
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) query);
            long mId = ((RFWMediaInfo) last).getMId();
            i3 += query.size();
            RFWLocalPhotoTracer.INSTANCE.onMediaQuery(i3, query.size());
            for (RFWMediaInfo rFWMediaInfo : query) {
                if (isPhotoRecordNeedDelete(rFWMediaInfo, this.mContext)) {
                    arrayList2.add(rFWMediaInfo);
                } else {
                    if (rFWMediaInfo.getMTakePicTime() == -1 || needFillLocation(rFWMediaInfo)) {
                        rFWMediaInfo.fillInfoByExif(this.mContext);
                        RFWUploadRecommendDbManager rFWUploadRecommendDbManager = this.mDbManager;
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(rFWMediaInfo);
                        rFWUploadRecommendDbManager.updateMediaInfo(listOf);
                    }
                    if (isAIDetectorUpdate() || rFWMediaInfo.needRunResearch()) {
                        arrayList.add(rFWMediaInfo);
                    }
                    if (rFWMediaInfo.needRequestPoi()) {
                        arrayList3.add(rFWMediaInfo);
                    }
                }
            }
            RFWLocalPhotoTracer.INSTANCE.onBaseInfoFill(query.size());
            if (!this.mIsFirstPageShow && i3 >= 1000) {
                fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.FIRST_PAGE_HOLDER);
                this.mIsFirstPageShow = true;
            }
            this.mContext.d("RFWLocalPhotoInfoManager", "[doDbRestoreClassify] offset:" + i3 + ", queryList size:" + query.size() + ",needReResearchList size:" + arrayList.size() + ",needDeleteList size:" + arrayList2.size() + ",needRePoiList size:" + arrayList3.size());
            if (query.size() < 200) {
                break;
            } else {
                j3 = mId;
            }
        }
        if (!arrayList2.isEmpty()) {
            this.mContext.d("RFWLocalPhotoInfoManager", "[mResumeClassifyRunnable] needDeleteList isNotEmpty");
            this.mDbManager.delete(arrayList2);
        }
        RFWLocalPhotoTracer rFWLocalPhotoTracer = RFWLocalPhotoTracer.INSTANCE;
        rFWLocalPhotoTracer.onMediaQueryFinish(i3, arrayList2, arrayList, arrayList3);
        if (arrayList.isEmpty() && arrayList3.isEmpty()) {
            fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.NO_UPDATE_AND_USE_CACHE);
            return;
        }
        fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.BASE_DATA);
        if (arrayList.isEmpty()) {
            rFWLocalPhotoTracer.onNoNeedDetectAITag();
            fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.RESEARCH_DATA);
        } else {
            doGetResearchResult(arrayList, fillInfoListener);
            resetAIDetectorUpdateStatus();
        }
        if (arrayList3.isEmpty()) {
            rFWLocalPhotoTracer.onNoNeedPoiFinish();
            fillInfoListener.onPhotoInfoFill(RFWMediaInfo.DataUpdateType.POI_DATA);
        } else {
            doGetPoiResult(arrayList3, fillInfoListener);
        }
        checkAllInfoFill(fillInfoListener, false);
    }
}
