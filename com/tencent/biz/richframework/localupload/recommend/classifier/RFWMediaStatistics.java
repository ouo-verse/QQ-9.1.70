package com.tencent.biz.richframework.localupload.recommend.classifier;

import android.text.TextUtils;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWBaseVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R.\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\"\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\"\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\"\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\"\u001a\u0004\b<\u0010$\"\u0004\b=\u0010&\u00a8\u0006A"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWMediaStatistics;", "", "", "getScoreForPicRecommend", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaList", "", "calculateMediaStatistics", "mediaInfo", "calMedia", "getScore", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "classifier", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "getClassifier", "()Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "", "halfYearPicFlag", "Z", "getHalfYearPicFlag", "()Z", "setHalfYearPicFlag", "(Z)V", "day30PicFlag", "getDay30PicFlag", "setDay30PicFlag", "day7PicFlag", "getDay7PicFlag", "setDay7PicFlag", "partyFaceSize5Flag", "getPartyFaceSize5Flag", "setPartyFaceSize5Flag", "newPicSize", "I", "getNewPicSize", "()I", "setNewPicSize", "(I)V", "highQualitySize", "getHighQualitySize", "setHighQualitySize", "Ljava/util/concurrent/ConcurrentHashMap;", "", "poiMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getPoiMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setPoiMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "partyPicSize", "getPartyPicSize", "setPartyPicSize", "weddingPicSize30Day", "getWeddingPicSize30Day", "setWeddingPicSize30Day", "badyPicSize30Day", "getBadyPicSize30Day", "setBadyPicSize30Day", "bigBadyPicSize30Day", "getBigBadyPicSize30Day", "setBigBadyPicSize30Day", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;)V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWMediaStatistics {

    @NotNull
    private static final Map<String, Integer> RECOMMEND_SCORE_MAP;

    @NotNull
    private static final List<String> VIDEO_TYPE_ORDER_LIST;
    private int badyPicSize30Day;
    private int bigBadyPicSize30Day;

    @NotNull
    private final RFWBaseClassifier classifier;
    private boolean day30PicFlag;
    private boolean day7PicFlag;
    private boolean halfYearPicFlag;
    private int highQualitySize;
    private int newPicSize;
    private boolean partyFaceSize5Flag;
    private int partyPicSize;

    @NotNull
    private ConcurrentHashMap<String, String> poiMap;
    private int weddingPicSize30Day;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        RECOMMEND_SCORE_MAP = concurrentHashMap;
        ArrayList arrayList = new ArrayList();
        VIDEO_TYPE_ORDER_LIST = arrayList;
        concurrentHashMap.put("1_1", 30);
        concurrentHashMap.put("1_2", 30);
        concurrentHashMap.put("1_3", 30);
        concurrentHashMap.put("2_1", 20);
        concurrentHashMap.put("2_2", 20);
        concurrentHashMap.put("3_1", 34);
        concurrentHashMap.put("3_2", 35);
        concurrentHashMap.put("3_3", 37);
        concurrentHashMap.put("3_4", 40);
        concurrentHashMap.put("3_5", 39);
        concurrentHashMap.put("3_6", 38);
        concurrentHashMap.put("3_7", 33);
        concurrentHashMap.put("3_8", 36);
        concurrentHashMap.put("4_1", 20);
        arrayList.add("5_3");
        arrayList.add("5_6");
        arrayList.add("5_5");
        arrayList.add("5_4");
        arrayList.add("5_7");
        arrayList.add("5_1");
        arrayList.add("5_2");
    }

    public RFWMediaStatistics(@NotNull RFWBaseClassifier classifier) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        this.classifier = classifier;
        this.poiMap = new ConcurrentHashMap<>();
    }

    private final int getScoreForPicRecommend() {
        int i3;
        Integer num = RECOMMEND_SCORE_MAP.get(this.classifier.getClassifyId());
        int i16 = 0;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (this.day7PicFlag) {
            i16 = 5;
        }
        if (this.day30PicFlag) {
            i16 += 5;
        }
        if (this.halfYearPicFlag) {
            i16 += 5;
        }
        int i17 = this.newPicSize;
        if (i17 > 20) {
            i16 += 5;
        }
        if (i17 > 50) {
            i16 += 5;
        }
        if (i17 > 100) {
            i16 += 5;
        }
        int i18 = this.highQualitySize;
        if (i18 > 10) {
            i16 += 5;
        }
        if (i18 > 20) {
            i16 += 5;
        }
        if (i18 > 30) {
            i16 += 5;
        }
        int size = this.poiMap.size();
        if (size > 2) {
            i16 += 20;
        }
        if (size > 3) {
            i16 += 10;
        }
        if (this.partyFaceSize5Flag) {
            i16 += 10;
        }
        if (this.partyPicSize > 5) {
            i16 += 10;
        }
        if (this.weddingPicSize30Day > 3) {
            i16 += 30;
        }
        if (this.badyPicSize30Day > 3) {
            i16 += 20;
        }
        if (this.bigBadyPicSize30Day > 3) {
            i16 += 10;
        }
        int uploadHistorySize = this.classifier.getMContext().getDelegate().getDbDelegate().getUploadHistorySize(this.classifier.getClassifyId());
        if (uploadHistorySize > 1) {
            i16 += 10;
        }
        if (uploadHistorySize > 2) {
            i16 += 5;
        }
        if (uploadHistorySize > 3) {
            i16 += 5;
        }
        return i3 + i16;
    }

    public final void calMedia(@NotNull RFWMediaInfo mediaInfo) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.isMatchTimeDistance(RFWRecommendDateUtils.convertDayToTimeMillis(7))) {
            this.day7PicFlag = true;
        } else if (mediaInfo.isMatchTimeDistance(RFWRecommendDateUtils.convertDayToTimeMillis(30))) {
            this.day30PicFlag = true;
        } else if (mediaInfo.isMatchTimeDistance(RFWRecommendDateUtils.convertDayToTimeMillis(182))) {
            this.halfYearPicFlag = true;
        }
        if (!RFWRecommendDateUtils.isDifferentDay(mediaInfo.getMScanTime(), System.currentTimeMillis())) {
            this.newPicSize++;
        }
        if (mediaInfo.getMWidth() > 3000 || mediaInfo.getMHeight() > 3000) {
            this.highQualitySize++;
        }
        if (mediaInfo.havePoiInfo()) {
            this.poiMap.put(mediaInfo.getMCity(), mediaInfo.getMCity());
        }
        if (mediaInfo.getMFaceSize() > 5) {
            this.partyFaceSize5Flag = true;
        }
        if (mediaInfo.getMFaceSize() >= 3) {
            this.partyPicSize++;
        }
        if (mediaInfo.isMatchTimeDistance(RFWRecommendDateUtils.convertDayToTimeMillis(30))) {
            Integer[] numArr = {Integer.valueOf(mediaInfo.getMFaceAge1()), Integer.valueOf(mediaInfo.getMFaceAge2()), Integer.valueOf(mediaInfo.getMFaceAge3()), Integer.valueOf(mediaInfo.getMFaceAge4())};
            for (int i3 = 0; i3 < 4; i3++) {
                int intValue = numArr[i3].intValue();
                if (intValue >= 0 && intValue < 9) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.badyPicSize30Day++;
                } else {
                    if (9 <= intValue && intValue < 19) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        this.bigBadyPicSize30Day++;
                    }
                }
            }
            if (TextUtils.equals(mediaInfo.getMTagSubType(), "\u5a5a\u793c")) {
                this.weddingPicSize30Day++;
            }
        }
    }

    public final void calculateMediaStatistics(@NotNull List<RFWMediaInfo> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Iterator<T> it = mediaList.iterator();
        while (it.hasNext()) {
            calMedia((RFWMediaInfo) it.next());
        }
    }

    @NotNull
    public final ConcurrentHashMap<String, String> getPoiMap() {
        return this.poiMap;
    }

    public final int getScore() {
        RFWBaseClassifier rFWBaseClassifier = this.classifier;
        if (rFWBaseClassifier instanceof RFWBaseVideoClassifier) {
            List<String> list = VIDEO_TYPE_ORDER_LIST;
            if (list.contains(rFWBaseClassifier.getClassifyId())) {
                return list.size() - list.indexOf(this.classifier.getClassifyId());
            }
            return 0;
        }
        return getScoreForPicRecommend();
    }
}
