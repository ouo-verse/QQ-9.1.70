package com.tencent.biz.richframework.localupload.recommend.trace;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier;
import com.tencent.biz.richframework.localupload.recommend.report.RFWLocalPhotoReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001YB\t\b\u0002\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fJ8\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0006\u0010 \u001a\u00020\u0002J\u001c\u0010#\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0!2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\u0002J\u0006\u0010%\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020\u0002J\u0016\u0010'\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010(\u001a\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0!2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\rJ\u0006\u0010+\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\u0002J\u0006\u0010.\u001a\u00020\u0002J\u000e\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020/J\u0016\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u0002022\u0006\u0010\u000b\u001a\u00020\nJ@\u00109\u001a\u00020\u00022\u0006\u00103\u001a\u0002022\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0!2\u0006\u00106\u001a\u00020\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001b0!2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ*\u0010:\u001a\u00020\u00022\u0006\u00103\u001a\u0002022\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0!2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u0010;\u001a\u00020\u00022\u0006\u00100\u001a\u00020/J\u0016\u0010>\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000fJ.\u0010D\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u000fJ\u0006\u0010E\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u000fR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010IR\u0016\u0010M\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010IR\u0016\u0010N\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010IR\u0016\u0010O\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010IR\u0016\u0010P\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010IR\u0016\u0010Q\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010IR\u0016\u0010R\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010IR\u0018\u0010S\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006Z"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/trace/RFWLocalPhotoTracer;", "", "", "reset", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/trace/RFWLocalPhotoTracer$TraceCallback;", "traceCallback", "setTraceCallback", "onStartScan", "", "msg", "onScanError", "", "isIncreaseScan", "", "resultSize", "lastScanTimeStr", "onScanFinish", "onScanResultDbInsertFinish", "onFillInfoStart", "offset", "size", "onMediaQuery", "onBaseInfoFill", "totalCount", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "needDeleteList", "needReResearchList", "needRePoiList", "onMediaQueryFinish", "onRequestPoiStart", "", "mediaInfoList", "onPoiResponse", "onRequestPoiFinish", "onNoNeedPoiFinish", "onDetectAITagStart", "onDetectAITagResult", "onDetectAITagBatchResult", "isBreak", "onDetectAITagFinish", "onNoNeedDetectAITag", "onNoInfoUpdateAndUseCache", "onCachePlaceHolder", "onNoInfoUpdateAndRecommend", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo$DataUpdateType;", "dataUpdateType", "onClassifyStart", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "classifier", "onClassifyError", "queryResult", "groupName", "groupResult", "handpickResult", "onClassifyResultWithGroup", "onClassifyResultWithoutGroup", "onClassifyFinish", "videoClassierCount", "photoClassierCount", "onPhotoRecommendFinish", "countWithLatLon", "countWithCity", "countWithAITag", "tagStr", "photoCount", "onReportFillInfoFinish", "getPhotoCount", "onStartReportFillInfoFinish", "", "mMediaQueryPageStart", "J", "mPhotoCount", "I", "mAITagStartTime", "mPoiStartTime", "mTotalStartTime", "mQueryStartTime", "mQueryCost", "mPoiCost", "mAITagCost", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "mTraceCallback", "Lcom/tencent/biz/richframework/localupload/recommend/trace/RFWLocalPhotoTracer$TraceCallback;", "<init>", "()V", "TraceCallback", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWLocalPhotoTracer {

    @NotNull
    public static final RFWLocalPhotoTracer INSTANCE = new RFWLocalPhotoTracer();
    private static long mAITagCost;
    private static long mAITagStartTime;

    @Nullable
    private static RecommendContext mContext;
    private static long mMediaQueryPageStart;
    private static int mPhotoCount;
    private static long mPoiCost;
    private static long mPoiStartTime;
    private static long mQueryCost;
    private static long mQueryStartTime;
    private static long mTotalStartTime;

    @Nullable
    private static TraceCallback mTraceCallback;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/trace/RFWLocalPhotoTracer$TraceCallback;", "", "onDevNode", "", "msg", "", "onNode", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public interface TraceCallback {
        void onDevNode(@NotNull String msg2);

        void onNode(@NotNull String msg2);
    }

    RFWLocalPhotoTracer() {
    }

    private final void reset() {
        mPhotoCount = 0;
        mAITagStartTime = 0L;
        mPoiStartTime = 0L;
        mTotalStartTime = 0L;
        mQueryStartTime = 0L;
        mQueryCost = 0L;
        mPoiCost = 0L;
        mAITagCost = 0L;
    }

    public final int getPhotoCount() {
        return mPhotoCount;
    }

    public final void onBaseInfoFill(int size) {
        long currentTimeMillis = System.currentTimeMillis() - mMediaQueryPageStart;
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u57fa\u7840\u4fe1\u606f\u586b\u5145, \u6570\u91cf: " + size + ", \u8017\u65f6: " + currentTimeMillis + "ms");
        }
    }

    public final void onCachePlaceHolder() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u4f7f\u7528\u7f13\u5b58\u5360\u4f4d");
        }
    }

    public final void onClassifyError(@NotNull RFWBaseClassifier classifier, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u805a\u7c7b\u5f02\u5e38, \u805a\u7c7b\u5668: " + classifier + ", \u5f02\u5e38: " + msg2);
        }
    }

    public final void onClassifyFinish(@NotNull RFWMediaInfo.DataUpdateType dataUpdateType) {
        Intrinsics.checkNotNullParameter(dataUpdateType, "dataUpdateType");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u805a\u7c7b\u5b8c\u6210, \u7c7b\u578b: " + dataUpdateType);
        }
    }

    public final void onClassifyResultWithGroup(@NotNull RFWBaseClassifier classifier, @NotNull List<RFWMediaInfo> queryResult, @NotNull String groupName, @NotNull List<RFWMediaInfo> groupResult, @NotNull List<RFWMediaInfo> handpickResult) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(queryResult, "queryResult");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(groupResult, "groupResult");
        Intrinsics.checkNotNullParameter(handpickResult, "handpickResult");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u805a\u7c7b\u5e76\u5206\u7ec4\u7ed3\u679c, \u805a\u7c7b\u5668: " + classifier + ", \u67e5\u8be2\u603b\u6570: " + queryResult.size() + ", \u5206\u7ec4\u540d: " + groupName + ", \u5206\u7ec4\u6570\u91cf: " + groupResult.size() + ", \u7cbe\u9009\u5b8c\u7684\u6570\u91cf: " + handpickResult.size());
        }
    }

    public final void onClassifyResultWithoutGroup(@NotNull RFWBaseClassifier classifier, @NotNull List<RFWMediaInfo> queryResult, @NotNull List<RFWMediaInfo> handpickResult) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(queryResult, "queryResult");
        Intrinsics.checkNotNullParameter(handpickResult, "handpickResult");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u805a\u7c7b\u7ed3\u679c, \u805a\u7c7b\u5668: " + classifier + ", \u67e5\u8be2\u603b\u6570: " + queryResult.size() + ", \u7cbe\u9009\u5b8c\u7684\u6570\u91cf: " + handpickResult.size());
        }
    }

    public final void onClassifyStart(@NotNull RFWMediaInfo.DataUpdateType dataUpdateType) {
        Intrinsics.checkNotNullParameter(dataUpdateType, "dataUpdateType");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u5f00\u59cb\u805a\u7c7b, \u7c7b\u578b: " + dataUpdateType);
        }
    }

    public final void onDetectAITagBatchResult(@NotNull List<RFWMediaInfo> mediaInfoList, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u6807\u7b7e\u8bc6\u522b\u6279\u6b21\u7ed3\u679c, \u6570\u91cf: " + mediaInfoList.size() + ", " + msg2);
        }
    }

    public final void onDetectAITagFinish(boolean isBreak) {
        long currentTimeMillis = System.currentTimeMillis() - mAITagStartTime;
        mAITagCost = currentTimeMillis;
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u6807\u7b7e\u8bc6\u522b\u5b8c\u6210, \u662f\u5426\u4e2d\u65ad: " + isBreak + ", \u8017\u65f6: " + currentTimeMillis + "ms");
        }
    }

    public final void onDetectAITagResult(@NotNull RFWMediaInfo mediaInfoList, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onDevNode("\u6807\u7b7e\u8bc6\u522b\u7ed3\u679c, " + msg2);
        }
    }

    public final void onDetectAITagStart() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u5f00\u59cb\u6807\u7b7e\u8bc6\u522b");
        }
        mAITagStartTime = System.currentTimeMillis();
    }

    public final void onFillInfoStart() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u5f00\u59cb\u586b\u5145\u6570\u636e");
        }
        mQueryStartTime = System.currentTimeMillis();
    }

    public final void onMediaQuery(int offset, int size) {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u67e5\u8be2\u5206\u9875\u7ed3\u679c, \u5355\u9875\u6570\u91cf: " + size + ", \u603b\u6570: " + offset);
        }
        mMediaQueryPageStart = System.currentTimeMillis();
    }

    public final void onMediaQueryFinish(int totalCount, @NotNull List<RFWMediaInfo> needDeleteList, @NotNull List<RFWMediaInfo> needReResearchList, @NotNull List<RFWMediaInfo> needRePoiList) {
        Intrinsics.checkNotNullParameter(needDeleteList, "needDeleteList");
        Intrinsics.checkNotNullParameter(needReResearchList, "needReResearchList");
        Intrinsics.checkNotNullParameter(needRePoiList, "needRePoiList");
        mPhotoCount = totalCount;
        long currentTimeMillis = System.currentTimeMillis() - mQueryStartTime;
        mQueryCost = currentTimeMillis;
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u7167\u7247\u67e5\u8be2\u5b8c\u6210, \u603b\u6570: " + totalCount + ", \u8017\u65f6: " + currentTimeMillis + "ms, \u9700\u8981\u5220\u9664\u7684\u6570\u91cf: " + needDeleteList.size() + ", \u9700\u8981\u6253\u6807\u7b7e\u7684\u6570\u91cf: " + needReResearchList.size() + ", \u9700\u8981\u8bf7\u6c42\u57ce\u5e02\u4fe1\u606f\u7684\u6570\u91cf: " + needRePoiList.size());
        }
        RFWLocalPhotoReporter.INSTANCE.reportQueryFinish(mContext, totalCount);
    }

    public final void onNoInfoUpdateAndRecommend() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u65e0\u4fe1\u606f\u9700\u8981\u586b\u5145, \u4e14\u65e0\u7f13\u5b58, \u91cd\u65b0\u8fdb\u884c\u5168\u90e8\u805a\u7c7b");
        }
    }

    public final void onNoInfoUpdateAndUseCache() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u65e0\u4fe1\u606f\u9700\u8981\u586b\u5145, \u76f4\u63a5\u4f7f\u7528\u7f13\u5b58");
        }
    }

    public final void onNoNeedDetectAITag() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u65e0\u7167\u7247\u9700\u8bc6\u522b\u6807\u7b7e, \u5f00\u59cb\u805a\u7c7b");
        }
    }

    public final void onNoNeedPoiFinish() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u65e0\u7167\u7247\u9700\u8bf7\u6c42\u5730\u7406\u4f4d\u7f6e, \u5f00\u59cb\u805a\u7c7b");
        }
    }

    public final void onPhotoRecommendFinish(int videoClassierCount, int photoClassierCount) {
        long currentTimeMillis = System.currentTimeMillis() - mTotalStartTime;
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u5b8c\u6210\u672c\u5730\u7167\u7247\u63a8\u8350, \u8017\u65f6: " + currentTimeMillis + "ms");
        }
        RFWLocalPhotoReporter rFWLocalPhotoReporter = RFWLocalPhotoReporter.INSTANCE;
        rFWLocalPhotoReporter.reportAllClassifyFinish(mContext, videoClassierCount, photoClassierCount);
        rFWLocalPhotoReporter.reportClassifyTimeCost(mContext, mQueryCost, Math.max(mPoiCost, mAITagCost), currentTimeMillis, mPhotoCount);
        reset();
    }

    public final void onPoiResponse(@NotNull List<RFWMediaInfo> mediaInfoList, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u57ce\u5e02\u4fe1\u606f\u56de\u5305, \u6570\u91cf: " + mediaInfoList.size());
        }
    }

    public final void onReportFillInfoFinish(int countWithLatLon, int countWithCity, int countWithAITag, @NotNull String tagStr, int photoCount) {
        Intrinsics.checkNotNullParameter(tagStr, "tagStr");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u4fe1\u606f\u586b\u5145\u4e0a\u62a5, countWithLatLon: " + countWithLatLon + ", countWithCity: " + countWithCity + ", countWithAITag: " + countWithAITag + ", photoCount: " + photoCount + ", tagStr: " + tagStr);
        }
    }

    public final void onRequestPoiFinish() {
        long currentTimeMillis = System.currentTimeMillis() - mPoiStartTime;
        mPoiCost = currentTimeMillis;
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u57ce\u5e02\u4fe1\u606f\u8bf7\u6c42\u5b8c\u6210, \u8017\u65f6: " + currentTimeMillis + "ms");
        }
    }

    public final void onRequestPoiStart() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u5f00\u59cb\u8bf7\u6c42\u57ce\u5e02\u4fe1\u606f");
        }
        mPoiStartTime = System.currentTimeMillis();
    }

    public final void onScanError(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u626b\u63cf\u5f02\u5e38: " + msg2);
        }
    }

    public final void onScanFinish(boolean isIncreaseScan, int resultSize, @NotNull String lastScanTimeStr) {
        Intrinsics.checkNotNullParameter(lastScanTimeStr, "lastScanTimeStr");
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u626b\u63cf\u5b8c\u6210, \u662f\u5426\u589e\u91cf\u626b\u63cf: " + isIncreaseScan + ", \u626b\u63cf\u6570\u91cf: " + resultSize + "\u6761, \u6700\u540e\u626b\u63cf\u65f6\u95f4: " + lastScanTimeStr);
        }
    }

    public final void onScanResultDbInsertFinish() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u626b\u63cf\u7ed3\u679c\u5165\u5e93\u5b8c\u6210");
        }
    }

    public final void onStartReportFillInfoFinish(int photoCount) {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u5f00\u59cb\u4fe1\u606f\u586b\u5145\u4e0a\u62a5, photoCount: " + photoCount);
        }
    }

    public final void onStartScan() {
        TraceCallback traceCallback = mTraceCallback;
        if (traceCallback != null) {
            traceCallback.onNode("\u5f00\u59cb\u626b\u63cf");
        }
        mTotalStartTime = System.currentTimeMillis();
    }

    public final void setTraceCallback(@NotNull RecommendContext context, @NotNull TraceCallback traceCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceCallback, "traceCallback");
        mContext = context;
        mTraceCallback = traceCallback;
    }
}
