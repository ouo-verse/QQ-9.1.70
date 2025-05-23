package com.tencent.biz.richframework.localupload.recommend.classifier.handpick;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0014\u001a\u00020\u0012R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/handpick/RFWPhotoHandpickManager;", "", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "lastMedia", "curMedia", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "classifier", "", "isSimilarPicture", "", "rfwMediaInfoList", "handpickPhoto", "mediaList", "removeSimilarPicture", "mediaInfo", "isCoverMedia", "", "recordCoverMedia", "clearCoverMedia", "", "TAG", "Ljava/lang/String;", "", "coverMedia", "Ljava/util/List;", "<init>", "()V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWPhotoHandpickManager {

    @NotNull
    public static final RFWPhotoHandpickManager INSTANCE = new RFWPhotoHandpickManager();

    @NotNull
    private static final String TAG = "RFWPhotoHandpickManager";

    @NotNull
    private static List<Long> coverMedia = new ArrayList();

    RFWPhotoHandpickManager() {
    }

    private final boolean isSimilarPicture(RecommendContext context, RFWMediaInfo lastMedia, RFWMediaInfo curMedia, RFWBaseClassifier classifier) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (Math.abs(lastMedia.getMTakePicTime() - curMedia.getMTakePicTime()) < MiniBoxNoticeInfo.MIN_5) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (lastMedia.getMLongitude() > 0.0f && curMedia.getMLongitude() > 0.0f && lastMedia.getMLatitude() > 0.0f && curMedia.getMLatitude() > 0.0f && (Math.abs(lastMedia.getMLongitude() - curMedia.getMLongitude()) >= 0.001d || Math.abs(lastMedia.getMLongitude() - curMedia.getMLongitude()) >= 0.001d || !Intrinsics.areEqual(lastMedia.getMCity(), curMedia.getMCity()))) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (Intrinsics.areEqual(lastMedia.getMTagType(), curMedia.getMTagType()) && Intrinsics.areEqual(lastMedia.getMTagSubType(), curMedia.getMTagSubType())) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && z17 && z18) {
            z19 = true;
        }
        context.dev(TAG, "[removeSimilarPicture] isSimilarPicture: " + z19 + ", path1: " + lastMedia.getMTakePicTime() + ", " + lastMedia.getMPath() + ", path2: " + curMedia.getMTakePicTime() + ", " + curMedia.getMPath() + ", classifier: " + classifier);
        return z19;
    }

    public final void clearCoverMedia() {
        coverMedia.clear();
    }

    @NotNull
    public final List<RFWMediaInfo> handpickPhoto(@NotNull RecommendContext context, @Nullable List<RFWMediaInfo> rfwMediaInfoList, @Nullable RFWBaseClassifier classifier) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (classifier != null && classifier.isNeedHandpick()) {
            if (rfwMediaInfoList == null) {
                return new ArrayList();
            }
            if (rfwMediaInfoList.size() <= classifier.getMaxPhotoCount()) {
                context.dev(TAG, "[handpickPhoto] size is not enough, size: " + rfwMediaInfoList.size() + ", classifier: " + classifier);
                return rfwMediaInfoList;
            }
            List<RFWMediaInfo> handpick = classifier.handpick(rfwMediaInfoList);
            String str = TAG;
            context.d(str, "[handpickPhoto] handpick result : " + handpick.size());
            if (handpick.size() > classifier.getMaxPhotoCount()) {
                context.dev(str, "[handpickPhoto] over limit, sub list");
                return handpick.subList(0, classifier.getMaxPhotoCount());
            }
            return handpick;
        }
        context.d(TAG, "[handpickPhoto] need not handpick, classifier: " + classifier);
        if (rfwMediaInfoList == null) {
            return new ArrayList();
        }
        return rfwMediaInfoList;
    }

    public final boolean isCoverMedia(@Nullable RFWMediaInfo mediaInfo) {
        if (mediaInfo != null && coverMedia.contains(Long.valueOf(mediaInfo.getMId()))) {
            return true;
        }
        return false;
    }

    public final void recordCoverMedia(@NotNull RecommendContext context, @Nullable RFWMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (mediaInfo != null) {
            context.dev(TAG, "[recordCoverMedia] recordCoverMedia, id: " + mediaInfo.getMId());
            coverMedia.add(Long.valueOf(mediaInfo.getMId()));
        }
    }

    @NotNull
    public final List<RFWMediaInfo> removeSimilarPicture(@NotNull RecommendContext context, @NotNull List<RFWMediaInfo> mediaList, @NotNull RFWBaseClassifier classifier) {
        Integer intOrNull;
        boolean z16;
        List sortedWith;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(context, "classify_delete_same_enable"));
        if (intOrNull != null && intOrNull.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!mediaList.isEmpty() && z16) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(mediaList, new Comparator() { // from class: com.tencent.biz.richframework.localupload.recommend.classifier.handpick.RFWPhotoHandpickManager$removeSimilarPicture$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((RFWMediaInfo) t17).getMTakePicTime()), Long.valueOf(((RFWMediaInfo) t16).getMTakePicTime()));
                    return compareValues;
                }
            });
            ArrayList arrayList = new ArrayList();
            RFWMediaInfo rFWMediaInfo = (RFWMediaInfo) sortedWith.get(0);
            arrayList.add(rFWMediaInfo);
            int size = sortedWith.size();
            for (int i3 = 1; i3 < size; i3++) {
                if (!isSimilarPicture(context, rFWMediaInfo, (RFWMediaInfo) sortedWith.get(i3), classifier)) {
                    rFWMediaInfo = (RFWMediaInfo) sortedWith.get(i3);
                    arrayList.add(rFWMediaInfo);
                }
            }
            context.d(TAG, "[removeSimilarPicture] mediaList: " + mediaList.size() + ", filteredPhotos: " + arrayList.size() + ", classifier: " + classifier);
            return arrayList;
        }
        return mediaList;
    }
}
