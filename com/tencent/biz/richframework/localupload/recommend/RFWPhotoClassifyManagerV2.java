package com.tencent.biz.richframework.localupload.recommend;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWFestivalClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoBabyBirthdayClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoBabyGrowthClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoBabyHaveYouClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoBirthdayClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoCityClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoLifeFoodClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoMarryClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoPartyClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWPhotoPetClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWWeekClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWBaseRecommendFilter;
import com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWRecommendBlackListFilter;
import com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWRecommendCountFilter;
import com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWRecommendLogicFilter;
import com.tencent.biz.richframework.localupload.recommend.classifier.handpick.RFWPhotoHandpickManager;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWBabyDiaryVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWFootprintVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWHappyDayVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWPetBabyVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWThatYearTodayVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWTravelVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWUnforgettableVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.report.RFWLocalPhotoReporter;
import com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u0012\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0002J\u0016\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rJ\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0004J\u0010\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020 J\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000f0%J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R#\u00103\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000f0%8\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0006\u00a2\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0006\u00a2\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010:R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0006\u00a2\u0006\f\n\u0004\b?\u00108\u001a\u0004\b@\u0010:R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u00108\u00a8\u0006F"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWPhotoClassifyManagerV2;", "", "", "hasRecommendResultCache", "", "notifyRecommendFinish", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "classifier", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "classifyResult", "", "groupName", "", "handleClassifyResult", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "uploadPhotoList", "makeVideoList", "onRecommendListChange", "handleRecommendInfo", "recommendList", "selectCoverMedia", "recommendInfo", "saveClassifyResult", "isRecommendInfoCanShow", "sortedList", "getFinalRecommendListResult", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo$DataUpdateType;", "dataUpdateType", "classifyByDataUpdateType", "classifierList", "doFullClassify", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "classifyInfo", "queryMediaByClassifyInfo", "notifyRecommendResult", "getClassifier", "", "getRecommendResult", "clearRecommendResult", "resetRecommend", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "mDbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "getMDbManager", "()Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "mDataLastUpdateType", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo$DataUpdateType;", "mRecommendInfoMap", "Ljava/util/Map;", "getMRecommendInfoMap", "()Ljava/util/Map;", "mRealTimeClassifierList", "Ljava/util/List;", "getMRealTimeClassifierList", "()Ljava/util/List;", "mPoiClassifierList", "getMPoiClassifierList", "mFullAllInfoClassifierList", "getMFullAllInfoClassifierList", "mResearchResultClassifierList", "getMResearchResultClassifierList", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWBaseRecommendFilter;", "mRecommendFilterList", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWPhotoClassifyManagerV2 {

    @NotNull
    private final RecommendContext mContext;

    @NotNull
    private RFWMediaInfo.DataUpdateType mDataLastUpdateType;

    @NotNull
    private final RFWUploadRecommendDbManager mDbManager;

    @NotNull
    private final List<RFWBaseClassifier> mFullAllInfoClassifierList;

    @NotNull
    private final List<RFWBaseClassifier> mPoiClassifierList;

    @NotNull
    private final List<RFWBaseClassifier> mRealTimeClassifierList;

    @NotNull
    private final List<RFWBaseRecommendFilter> mRecommendFilterList;

    @NotNull
    private final Map<RFWClassifyInfo, RFWUploadRecommendInfo> mRecommendInfoMap;

    @NotNull
    private final List<RFWBaseClassifier> mResearchResultClassifierList;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFWMediaInfo.DataUpdateType.values().length];
            try {
                iArr[RFWMediaInfo.DataUpdateType.FIRST_PAGE_HOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RFWMediaInfo.DataUpdateType.BASE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RFWMediaInfo.DataUpdateType.RESEARCH_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RFWMediaInfo.DataUpdateType.POI_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RFWMediaInfo.DataUpdateType.ALL_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RFWMediaInfo.DataUpdateType.CACHE_PLACEHOLDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RFWMediaInfo.DataUpdateType.NO_UPDATE_AND_USE_CACHE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RFWPhotoClassifyManagerV2(@NotNull RecommendContext mContext, @NotNull RFWUploadRecommendDbManager mDbManager) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mDbManager, "mDbManager");
        this.mContext = mContext;
        this.mDbManager = mDbManager;
        this.mDataLastUpdateType = RFWMediaInfo.DataUpdateType.DEFAULT;
        this.mRecommendInfoMap = new ConcurrentHashMap();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mRealTimeClassifierList = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.mPoiClassifierList = copyOnWriteArrayList2;
        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
        this.mFullAllInfoClassifierList = copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4 = new CopyOnWriteArrayList();
        this.mResearchResultClassifierList = copyOnWriteArrayList4;
        CopyOnWriteArrayList copyOnWriteArrayList5 = new CopyOnWriteArrayList();
        this.mRecommendFilterList = copyOnWriteArrayList5;
        copyOnWriteArrayList2.add(new RFWPhotoCityClassifier(mContext, mDbManager));
        copyOnWriteArrayList3.add(new RFWFootprintVideoClassifier(mContext, mDbManager));
        copyOnWriteArrayList3.add(new RFWTravelVideoClassifier(mContext, mDbManager));
        copyOnWriteArrayList.add(new RFWFestivalClassifier(mContext, mDbManager));
        copyOnWriteArrayList.add(new RFWWeekClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoPartyClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoBirthdayClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoMarryClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoBabyBirthdayClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoBabyHaveYouClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoBabyGrowthClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoPetClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPhotoLifeFoodClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWThatYearTodayVideoClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWHappyDayVideoClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWPetBabyVideoClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWBabyDiaryVideoClassifier(mContext, mDbManager));
        copyOnWriteArrayList4.add(new RFWUnforgettableVideoClassifier(mContext, mDbManager));
        copyOnWriteArrayList5.add(new RFWRecommendCountFilter(mContext));
        copyOnWriteArrayList5.add(new RFWRecommendBlackListFilter(mContext));
        copyOnWriteArrayList5.add(new RFWRecommendLogicFilter(mContext));
    }

    private final List<RFWUploadRecommendInfo> getFinalRecommendListResult(List<RFWUploadRecommendInfo> sortedList) {
        Integer intOrNull;
        int i3;
        String str;
        int i16;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(sortedList);
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(this.mContext, "same_classify_count_max"));
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 5;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "resultList.iterator()");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            RFWUploadRecommendInfo rFWUploadRecommendInfo = (RFWUploadRecommendInfo) next;
            if (rFWUploadRecommendInfo.getClassifier().isMakeVideoClassifier()) {
                str = "video";
            } else {
                str = "photo";
            }
            String str2 = str + "_" + RFWRecommendDateUtils.getDateTime(rFWUploadRecommendInfo.getLastTakePicTime());
            if (rFWUploadRecommendInfo.getClassifier().isPhotoFromSameDay() && concurrentHashMap.containsKey(str2)) {
                this.mContext.dev("RFWPhotoClassifyManager", "[getFinalResult] hasSameDayClassify:" + rFWUploadRecommendInfo.getClassifier());
                it.remove();
            } else {
                Integer num = (Integer) concurrentHashMap2.get(rFWUploadRecommendInfo.getRecommendClassifyId());
                if (num != null) {
                    i16 = num.intValue();
                } else {
                    i16 = 0;
                }
                if (i16 >= i3) {
                    it.remove();
                    this.mContext.dev("RFWPhotoClassifyManager", "[getFinalResult] isBeyondClassifyCount:" + rFWUploadRecommendInfo.getClassifier());
                } else {
                    if (rFWUploadRecommendInfo.getClassifier().isPhotoFromSameDay()) {
                        concurrentHashMap.put(str2, Boolean.FALSE);
                    }
                    concurrentHashMap2.put(rFWUploadRecommendInfo.getRecommendClassifyId(), Integer.valueOf(i16 + 1));
                }
            }
        }
        this.mContext.dev("RFWPhotoClassifyManager", "[getFinalResult] size" + arrayList.size());
        return arrayList;
    }

    private final List<RFWMediaInfo> handleClassifyResult(RFWBaseClassifier classifier, List<RFWMediaInfo> classifyResult, String groupName) {
        List<RFWMediaInfo> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) classifyResult);
        RFWPhotoHandpickManager rFWPhotoHandpickManager = RFWPhotoHandpickManager.INSTANCE;
        List<RFWMediaInfo> removeSimilarPicture = rFWPhotoHandpickManager.removeSimilarPicture(this.mContext, mutableList, classifier);
        List<RFWMediaInfo> handpickPhoto = rFWPhotoHandpickManager.handpickPhoto(this.mContext, removeSimilarPicture, classifier);
        RFWUploadRecommendInfo rFWUploadRecommendInfo = new RFWUploadRecommendInfo(this.mContext, new RFWClassifyInfo(classifier.getClassifyId(), groupName), classifier);
        String result = rFWUploadRecommendInfo.setResult(handpickPhoto);
        saveClassifyResult(rFWUploadRecommendInfo);
        RFWLocalPhotoReporter.INSTANCE.reportSingleClassifyFinish(this.mContext, classifier.getClassifyId(), result, classifyResult.size(), removeSimilarPicture.size(), handpickPhoto.size());
        return handpickPhoto;
    }

    private final List<RFWUploadRecommendInfo> handleRecommendInfo() {
        List<RFWUploadRecommendInfo> sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.mRecommendInfoMap.values(), new Comparator() { // from class: com.tencent.biz.richframework.localupload.recommend.RFWPhotoClassifyManagerV2$handleRecommendInfo$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((RFWUploadRecommendInfo) t17).getMediaStatistics().getScore()), Integer.valueOf(((RFWUploadRecommendInfo) t16).getMediaStatistics().getScore()));
                return compareValues;
            }
        });
        return getFinalRecommendListResult(sortedWith);
    }

    private final boolean hasRecommendResultCache() {
        return !this.mRecommendInfoMap.isEmpty();
    }

    private final boolean isRecommendInfoCanShow(RFWUploadRecommendInfo recommendInfo) {
        for (RFWBaseRecommendFilter rFWBaseRecommendFilter : this.mRecommendFilterList) {
            if (!rFWBaseRecommendFilter.isRecommendCanShow(recommendInfo)) {
                this.mContext.dev("RFWPhotoClassifyManager", "[isRecommendInfoCanShow] recommendInfo" + recommendInfo + " filter by " + rFWBaseRecommendFilter.getTag());
                return false;
            }
        }
        return true;
    }

    private final void notifyRecommendFinish() {
        List<RFWUploadRecommendInfo> handleRecommendInfo = handleRecommendInfo();
        List<RFWUploadRecommendInfo> list = handleRecommendInfo;
        int i3 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((RFWUploadRecommendInfo) it.next()).getClassifier().isMakeVideoClassifier() && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        RFWLocalPhotoTracer.INSTANCE.onPhotoRecommendFinish(i3, handleRecommendInfo.size() - i3);
        this.mContext.onRecommendFinish();
    }

    private final void onRecommendListChange(final List<RFWUploadRecommendInfo> uploadPhotoList, final List<RFWUploadRecommendInfo> makeVideoList) {
        RFWRecommendThread.INSTANCE.getS_MAIN_HANDLER().post(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.c
            @Override // java.lang.Runnable
            public final void run() {
                RFWPhotoClassifyManagerV2.onRecommendListChange$lambda$6(RFWPhotoClassifyManagerV2.this, uploadPhotoList, makeVideoList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRecommendListChange$lambda$6(RFWPhotoClassifyManagerV2 this$0, List uploadPhotoList, List makeVideoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uploadPhotoList, "$uploadPhotoList");
        Intrinsics.checkNotNullParameter(makeVideoList, "$makeVideoList");
        for (IUploadRecommendCallBack iUploadRecommendCallBack : this$0.mContext.getMRecommendCallBacks()) {
            iUploadRecommendCallBack.onPhotoRecommendListChange(uploadPhotoList);
            iUploadRecommendCallBack.onMakeVideoRecommendListChange(makeVideoList);
            iUploadRecommendCallBack.onScanProcessChange(!this$0.mContext.getIsRecommending().get());
        }
    }

    private final void saveClassifyResult(RFWUploadRecommendInfo recommendInfo) {
        if (isRecommendInfoCanShow(recommendInfo)) {
            this.mRecommendInfoMap.put(recommendInfo.getClassifyInfo(), recommendInfo);
        }
    }

    private final void selectCoverMedia(List<RFWUploadRecommendInfo> recommendList) {
        Object obj;
        for (RFWUploadRecommendInfo rFWUploadRecommendInfo : recommendList) {
            if (rFWUploadRecommendInfo.getFirstMediaInfo() == null) {
                Iterator<T> it = rFWUploadRecommendInfo.getRecommendMediaInfoList().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (!RFWPhotoHandpickManager.INSTANCE.isCoverMedia((RFWMediaInfo) obj)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                rFWUploadRecommendInfo.setFirstMediaInfo((RFWMediaInfo) obj);
                RFWPhotoHandpickManager.INSTANCE.recordCoverMedia(this.mContext, rFWUploadRecommendInfo.getFirstMediaInfo());
            }
        }
    }

    public final void classifyByDataUpdateType(@NotNull RFWMediaInfo.DataUpdateType dataUpdateType) {
        Intrinsics.checkNotNullParameter(dataUpdateType, "dataUpdateType");
        RFWLocalPhotoTracer rFWLocalPhotoTracer = RFWLocalPhotoTracer.INSTANCE;
        rFWLocalPhotoTracer.onClassifyStart(dataUpdateType);
        switch (WhenMappings.$EnumSwitchMapping$0[dataUpdateType.ordinal()]) {
            case 1:
                if (!hasRecommendResultCache()) {
                    resetRecommend();
                    doFullClassify(dataUpdateType, this.mRealTimeClassifierList);
                    break;
                }
                break;
            case 2:
                resetRecommend();
                doFullClassify(dataUpdateType, this.mRealTimeClassifierList);
                break;
            case 3:
                doFullClassify(dataUpdateType, this.mResearchResultClassifierList);
                break;
            case 4:
                doFullClassify(dataUpdateType, this.mPoiClassifierList);
                break;
            case 5:
                doFullClassify(dataUpdateType, this.mFullAllInfoClassifierList);
                notifyRecommendFinish();
                break;
            case 6:
                if (hasRecommendResultCache()) {
                    rFWLocalPhotoTracer.onCachePlaceHolder();
                    notifyRecommendResult();
                    break;
                }
                break;
            case 7:
                if (hasRecommendResultCache() && this.mDataLastUpdateType != RFWMediaInfo.DataUpdateType.FIRST_PAGE_HOLDER) {
                    rFWLocalPhotoTracer.onNoInfoUpdateAndUseCache();
                    notifyRecommendResult();
                    notifyRecommendFinish();
                    break;
                } else {
                    rFWLocalPhotoTracer.onNoInfoUpdateAndRecommend();
                    resetRecommend();
                    doFullClassify(dataUpdateType, this.mRealTimeClassifierList);
                    doFullClassify(dataUpdateType, this.mResearchResultClassifierList);
                    doFullClassify(dataUpdateType, this.mPoiClassifierList);
                    doFullClassify(dataUpdateType, this.mFullAllInfoClassifierList);
                    notifyRecommendFinish();
                    break;
                }
                break;
        }
        this.mDataLastUpdateType = dataUpdateType;
    }

    public final void clearRecommendResult() {
        this.mRecommendInfoMap.clear();
    }

    public final void doFullClassify(@NotNull RFWMediaInfo.DataUpdateType dataUpdateType, @Nullable List<RFWBaseClassifier> classifierList) {
        Intrinsics.checkNotNullParameter(dataUpdateType, "dataUpdateType");
        if (classifierList != null) {
            for (RFWBaseClassifier rFWBaseClassifier : classifierList) {
                List<RFWMediaInfo> queryMediaList = rFWBaseClassifier.queryMediaList(null);
                if (rFWBaseClassifier.isNeedGroup()) {
                    for (Map.Entry<String, List<RFWMediaInfo>> entry : rFWBaseClassifier.groupBy(queryMediaList).entrySet()) {
                        RFWLocalPhotoTracer.INSTANCE.onClassifyResultWithGroup(rFWBaseClassifier, queryMediaList, entry.getKey(), entry.getValue(), handleClassifyResult(rFWBaseClassifier, entry.getValue(), entry.getKey()));
                    }
                } else {
                    RFWLocalPhotoTracer.INSTANCE.onClassifyResultWithoutGroup(rFWBaseClassifier, queryMediaList, handleClassifyResult(rFWBaseClassifier, queryMediaList, ""));
                }
            }
        }
        RFWLocalPhotoTracer.INSTANCE.onClassifyFinish(dataUpdateType);
        notifyRecommendResult();
    }

    @Nullable
    public final RFWBaseClassifier getClassifier(@NotNull RFWClassifyInfo classifyInfo) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(classifyInfo, "classifyInfo");
        Collection<RFWUploadRecommendInfo> values = this.mRecommendInfoMap.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj5 : values) {
            if (Intrinsics.areEqual(((RFWUploadRecommendInfo) obj5).getClassifyInfo(), classifyInfo)) {
                arrayList.add(obj5);
            }
        }
        if (!arrayList.isEmpty()) {
            return ((RFWUploadRecommendInfo) arrayList.get(0)).getClassifier();
        }
        Iterator<T> it = this.mRealTimeClassifierList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (Intrinsics.areEqual(((RFWBaseClassifier) obj2).getClassifyId(), classifyInfo.getClassifyId())) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        RFWBaseClassifier rFWBaseClassifier = (RFWBaseClassifier) obj2;
        if (rFWBaseClassifier == null) {
            Iterator<T> it5 = this.mPoiClassifierList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj4 = it5.next();
                    if (Intrinsics.areEqual(((RFWBaseClassifier) obj4).getClassifyId(), classifyInfo.getClassifyId())) {
                        break;
                    }
                } else {
                    obj4 = null;
                    break;
                }
            }
            rFWBaseClassifier = (RFWBaseClassifier) obj4;
        }
        if (rFWBaseClassifier == null) {
            Iterator<T> it6 = this.mResearchResultClassifierList.iterator();
            while (true) {
                if (it6.hasNext()) {
                    obj3 = it6.next();
                    if (Intrinsics.areEqual(((RFWBaseClassifier) obj3).getClassifyId(), classifyInfo.getClassifyId())) {
                        break;
                    }
                } else {
                    obj3 = null;
                    break;
                }
            }
            rFWBaseClassifier = (RFWBaseClassifier) obj3;
        }
        if (rFWBaseClassifier == null) {
            Iterator<T> it7 = this.mFullAllInfoClassifierList.iterator();
            while (true) {
                if (!it7.hasNext()) {
                    break;
                }
                Object next = it7.next();
                if (Intrinsics.areEqual(((RFWBaseClassifier) next).getClassifyId(), classifyInfo.getClassifyId())) {
                    obj = next;
                    break;
                }
            }
            return (RFWBaseClassifier) obj;
        }
        return rFWBaseClassifier;
    }

    @NotNull
    public final List<RFWBaseClassifier> getMRealTimeClassifierList() {
        return this.mRealTimeClassifierList;
    }

    @NotNull
    public final Map<RFWClassifyInfo, RFWUploadRecommendInfo> getRecommendResult() {
        return this.mRecommendInfoMap;
    }

    public final void notifyRecommendResult() {
        RFWPhotoHandpickManager.INSTANCE.clearCoverMedia();
        List<RFWUploadRecommendInfo> handleRecommendInfo = handleRecommendInfo();
        ArrayList arrayList = new ArrayList();
        for (Object obj : handleRecommendInfo) {
            if (((RFWUploadRecommendInfo) obj).getClassifier().isMakeVideoClassifier()) {
                arrayList.add(obj);
            }
        }
        selectCoverMedia(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : handleRecommendInfo) {
            if (!((RFWUploadRecommendInfo) obj2).getClassifier().isMakeVideoClassifier()) {
                arrayList2.add(obj2);
            }
        }
        selectCoverMedia(arrayList2);
        onRecommendListChange(arrayList2, arrayList);
    }

    @NotNull
    public final List<RFWMediaInfo> queryMediaByClassifyInfo(@NotNull RFWClassifyInfo classifyInfo) {
        List<RFWMediaInfo> mutableList;
        Intrinsics.checkNotNullParameter(classifyInfo, "classifyInfo");
        RFWBaseClassifier classifier = getClassifier(classifyInfo);
        if (classifier == null) {
            this.mContext.e("RFWPhotoClassifyManager", "queryMediaByClassifyInfo error, classifier is null");
            return new ArrayList();
        }
        List<RFWMediaInfo> queryMediaList = classifier.queryMediaList(null);
        if (!classifier.isNeedGroup()) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) queryMediaList);
        } else {
            List<RFWMediaInfo> list = classifier.groupBy(queryMediaList).get(classifyInfo.getSubClassifyId());
            if (list != null) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            } else {
                return new ArrayList();
            }
        }
        RFWPhotoHandpickManager rFWPhotoHandpickManager = RFWPhotoHandpickManager.INSTANCE;
        return rFWPhotoHandpickManager.handpickPhoto(this.mContext, rFWPhotoHandpickManager.removeSimilarPicture(this.mContext, mutableList, classifier), classifier);
    }

    public final void resetRecommend() {
        this.mDataLastUpdateType = RFWMediaInfo.DataUpdateType.DEFAULT;
        clearRecommendResult();
        RFWPhotoHandpickManager.INSTANCE.clearCoverMedia();
    }
}
