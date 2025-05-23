package com.tencent.biz.richframework.localupload.recommend;

import android.app.Application;
import android.os.Looper;
import com.tencent.biz.richframework.localupload.recommend.RFWLocalPhotoInfoManager;
import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate;
import com.tencent.biz.richframework.localupload.recommend.research.RFWResearchEnvManager;
import com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 32\u00020\u0001:\u000234B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bJ(\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001e\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001f\u001a\u00020\u0002R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2;", "", "", "startLocalPhotoRecommend", "Landroid/app/Application;", "appContext", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWUploadRecommendDelegate;", "delegate", "init", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "classifyInfo", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2$QueryCallBack;", "queryCallBack", "queryMediaListByClassifyInfo", "", "startTime", "endTime", "", "limit", "queryMediaListByTime", "reInit", "startRecommend", "stopRecommend", "deleteAll", "", "deviceHaveEnoughSpace", "preloadRes", "Lcom/tencent/biz/richframework/localupload/recommend/IUploadRecommendCallBack;", "recommendCallBack", "registerRecommendCallBack", "unregisterRecommendCallBack", "testClassify", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "mDbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "getMDbManager", "()Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWPhotoClassifyManagerV2;", "mPhotoClassifyManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWPhotoClassifyManagerV2;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoScanManager;", "mPhotoScanManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoScanManager;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoInfoManager;", "mPhotoInfoManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWLocalPhotoInfoManager;", "<init>", "()V", "Companion", "QueryCallBack", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public class RFWUploadRecommendDirectorV2 {

    @NotNull
    private final RecommendContext mContext;

    @NotNull
    private final RFWUploadRecommendDbManager mDbManager;

    @NotNull
    private final RFWPhotoClassifyManagerV2 mPhotoClassifyManager;

    @NotNull
    private final RFWLocalPhotoInfoManager mPhotoInfoManager;

    @NotNull
    private final RFWLocalPhotoScanManager mPhotoScanManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2$QueryCallBack;", "", "queryFinish", "", "queryResult", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface QueryCallBack {
        void queryFinish(@NotNull List<RFWMediaInfo> queryResult);
    }

    public RFWUploadRecommendDirectorV2() {
        RecommendContext recommendContext = new RecommendContext();
        this.mContext = recommendContext;
        RFWUploadRecommendDbManager rFWUploadRecommendDbManager = new RFWUploadRecommendDbManager(recommendContext);
        this.mDbManager = rFWUploadRecommendDbManager;
        this.mPhotoClassifyManager = new RFWPhotoClassifyManagerV2(recommendContext, rFWUploadRecommendDbManager);
        this.mPhotoScanManager = new RFWLocalPhotoScanManager(recommendContext, rFWUploadRecommendDbManager);
        this.mPhotoInfoManager = new RFWLocalPhotoInfoManager(recommendContext, rFWUploadRecommendDbManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadRes$lambda$4(RFWUploadRecommendDirectorV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWResearchEnvManager rFWResearchEnvManager = RFWResearchEnvManager.INSTANCE;
        if (!rFWResearchEnvManager.isEnvReady(this$0.mContext)) {
            RFWResearchEnvManager.initEnv$default(rFWResearchEnvManager, this$0.mContext, null, 0, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryMediaListByClassifyInfo$lambda$1(RFWUploadRecommendDirectorV2 this$0, RFWClassifyInfo rFWClassifyInfo, QueryCallBack queryCallBack) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(queryCallBack, "$queryCallBack");
        List<RFWMediaInfo> queryMediaByClassifyInfo = this$0.mPhotoClassifyManager.queryMediaByClassifyInfo(rFWClassifyInfo);
        this$0.mContext.d("RFWUploadRecommendDirectorV2", "[queryMediaListByClassifyInfo] has cache from db: " + queryMediaByClassifyInfo.size());
        queryCallBack.queryFinish(queryMediaByClassifyInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryMediaListByTime$lambda$3(String startTime, String endTime, RFWUploadRecommendDirectorV2 this$0, int i3, final QueryCallBack queryCallBack) {
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        Intrinsics.checkNotNullParameter(endTime, "$endTime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(queryCallBack, "$queryCallBack");
        final List<RFWMediaInfo> query = this$0.mDbManager.query("_id<9223372036854775807 and mTakePicTime>? and mTakePicTime<?", new String[]{startTime, endTime}, "_id DESC", String.valueOf(i3));
        RFWRecommendThread.INSTANCE.getS_MAIN_HANDLER().post(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.h
            @Override // java.lang.Runnable
            public final void run() {
                RFWUploadRecommendDirectorV2.queryMediaListByTime$lambda$3$lambda$2(RFWUploadRecommendDirectorV2.QueryCallBack.this, query);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryMediaListByTime$lambda$3$lambda$2(QueryCallBack queryCallBack, List queryResult) {
        List<RFWMediaInfo> mutableList;
        Intrinsics.checkNotNullParameter(queryCallBack, "$queryCallBack");
        Intrinsics.checkNotNullParameter(queryResult, "$queryResult");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) queryResult);
        queryCallBack.queryFinish(mutableList);
    }

    private final void startLocalPhotoRecommend() {
        this.mContext.d("RFWUploadRecommendDirectorV2", "[startLocalPhotoRecommend]");
        RFWRecommendThread.INSTANCE.runOnRealTimeThread(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.f
            @Override // java.lang.Runnable
            public final void run() {
                RFWUploadRecommendDirectorV2.startLocalPhotoRecommend$lambda$0(RFWUploadRecommendDirectorV2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLocalPhotoRecommend$lambda$0(final RFWUploadRecommendDirectorV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (!this$0.mContext.getIsRecommending().get()) {
                this$0.mContext.getIsRecommending().set(true);
                this$0.mContext.resetRecommendSessionId();
                this$0.mPhotoScanManager.scanLocalPhoto();
                this$0.mPhotoInfoManager.fillLocalPhotoInfo(new RFWLocalPhotoInfoManager.RFWLocalPhotoInfoFillListener() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2$startLocalPhotoRecommend$1$1
                    @Override // com.tencent.biz.richframework.localupload.recommend.RFWLocalPhotoInfoManager.RFWLocalPhotoInfoFillListener
                    public void onPhotoInfoFill(@NotNull RFWMediaInfo.DataUpdateType dataUpdateType) {
                        RFWPhotoClassifyManagerV2 rFWPhotoClassifyManagerV2;
                        Intrinsics.checkNotNullParameter(dataUpdateType, "dataUpdateType");
                        rFWPhotoClassifyManagerV2 = RFWUploadRecommendDirectorV2.this.mPhotoClassifyManager;
                        rFWPhotoClassifyManagerV2.classifyByDataUpdateType(dataUpdateType);
                    }
                });
            } else {
                this$0.mContext.d("RFWUploadRecommendDirectorV2", "startLocalPhotoRecommend fail, is recommending");
            }
        } catch (Throwable th5) {
            this$0.mContext.getIsRecommending().set(false);
            this$0.mContext.fatal("RFWUploadRecommendDirectorV2", th5);
        }
    }

    public final void deleteAll() {
        this.mDbManager.deleteAll();
        this.mContext.getDelegate().getConfigDelegate().saveConfig("KEY_LAST_SCAN_TIME", "0");
        this.mPhotoClassifyManager.clearRecommendResult();
    }

    public final boolean deviceHaveEnoughSpace() {
        return this.mPhotoScanManager.deviceHaveEnoughSpace();
    }

    public final void init(@NotNull Application appContext, @NotNull IRFWUploadRecommendDelegate delegate) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.mContext.setAndroidContext(appContext);
        this.mContext.setDelegate(delegate);
        this.mContext.d("RFWUploadRecommendDirectorV2", "[init]");
        RFWLocalPhotoTracer.INSTANCE.setTraceCallback(this.mContext, new RFWLocalPhotoTracer.TraceCallback() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2$init$1
            @Override // com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer.TraceCallback
            public void onDevNode(@NotNull String msg2) {
                RecommendContext recommendContext;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                recommendContext = RFWUploadRecommendDirectorV2.this.mContext;
                recommendContext.dev("RFWLocalPhotoTracer", msg2);
            }

            @Override // com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer.TraceCallback
            public void onNode(@NotNull String msg2) {
                RecommendContext recommendContext;
                RecommendContext recommendContext2;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                recommendContext = RFWUploadRecommendDirectorV2.this.mContext;
                recommendContext.d("RFWLocalPhotoTracer", msg2);
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    recommendContext2 = RFWUploadRecommendDirectorV2.this.mContext;
                    recommendContext2.e("RFWLocalPhotoTracer", "do action in main thread, pay attention!!!");
                }
            }
        });
    }

    public final void preloadRes() {
        this.mContext.d("RFWUploadRecommendDirectorV2", "[preloadRes]");
        RFWRecommendThread.INSTANCE.runOnRealTimeThread(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWUploadRecommendDirectorV2.preloadRes$lambda$4(RFWUploadRecommendDirectorV2.this);
            }
        });
    }

    public final void queryMediaListByClassifyInfo(@Nullable final RFWClassifyInfo classifyInfo, @NotNull final QueryCallBack queryCallBack) {
        List<RFWMediaInfo> list;
        Intrinsics.checkNotNullParameter(queryCallBack, "queryCallBack");
        if (classifyInfo == null) {
            queryCallBack.queryFinish(new ArrayList());
            this.mContext.d("RFWUploadRecommendDirectorV2", "[queryMediaListByClassifyInfo] classify info is null");
            return;
        }
        RFWUploadRecommendInfo rFWUploadRecommendInfo = this.mPhotoClassifyManager.getRecommendResult().get(classifyInfo);
        if (rFWUploadRecommendInfo != null) {
            list = rFWUploadRecommendInfo.getMediaList();
        } else {
            list = null;
        }
        if (list != null && (!list.isEmpty())) {
            this.mContext.d("RFWUploadRecommendDirectorV2", "[queryMediaListByClassifyInfo] has cache from memory: " + list.size());
            queryCallBack.queryFinish(list);
            return;
        }
        RFWRecommendThread.INSTANCE.getRECOMMEND_THREAD_POOL().execute(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.e
            @Override // java.lang.Runnable
            public final void run() {
                RFWUploadRecommendDirectorV2.queryMediaListByClassifyInfo$lambda$1(RFWUploadRecommendDirectorV2.this, classifyInfo, queryCallBack);
            }
        });
    }

    public final void queryMediaListByTime(@NotNull final String startTime, @NotNull final String endTime, final int limit, @NotNull final QueryCallBack queryCallBack) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(queryCallBack, "queryCallBack");
        RFWRecommendThread.INSTANCE.getRECOMMEND_THREAD_POOL().execute(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.g
            @Override // java.lang.Runnable
            public final void run() {
                RFWUploadRecommendDirectorV2.queryMediaListByTime$lambda$3(startTime, endTime, this, limit, queryCallBack);
            }
        });
    }

    public final void registerRecommendCallBack(@Nullable IUploadRecommendCallBack recommendCallBack) {
        this.mContext.d("RFWUploadRecommendDirectorV2", "[registerRecommendCallBack] " + recommendCallBack);
        this.mContext.registerRecommendCallBack(recommendCallBack);
        this.mPhotoClassifyManager.notifyRecommendResult();
    }

    public final void startRecommend() {
        if (this.mContext.getDelegate().getConfigDelegate().disableRecommend()) {
            this.mContext.e("RFWUploadRecommendDirectorV2", "[startRecommend] recommend is disable");
        } else {
            if (this.mContext.getIsInQZoneEnv().get()) {
                this.mContext.d("RFWUploadRecommendDirectorV2", "[startRecommend] re call, return");
                return;
            }
            this.mContext.getIsInQZoneEnv().set(true);
            this.mContext.d("RFWUploadRecommendDirectorV2", "[startRecommend] do recommend");
            startLocalPhotoRecommend();
        }
    }

    public final void stopRecommend() {
        this.mContext.d("RFWUploadRecommendDirectorV2", "[stopRecommend]");
        this.mContext.getIsInQZoneEnv().set(false);
        this.mContext.getIsRecommending().set(false);
    }

    public final void testClassify() {
        this.mContext.d("RFWUploadRecommendDirectorV2", "[testClassify]");
        RFWPhotoClassifyManagerV2 rFWPhotoClassifyManagerV2 = this.mPhotoClassifyManager;
        rFWPhotoClassifyManagerV2.doFullClassify(RFWMediaInfo.DataUpdateType.BASE_DATA, rFWPhotoClassifyManagerV2.getMRealTimeClassifierList());
    }

    public final void unregisterRecommendCallBack(@Nullable IUploadRecommendCallBack recommendCallBack) {
        this.mContext.d("RFWUploadRecommendDirectorV2", "[unregisterRecommendCallBack] " + recommendCallBack);
        this.mContext.unregisterRecommendCallBack(recommendCallBack);
    }

    public final void reInit() {
    }
}
