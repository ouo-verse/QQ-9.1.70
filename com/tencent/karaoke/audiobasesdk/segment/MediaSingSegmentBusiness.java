package com.tencent.karaoke.audiobasesdk.segment;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.segment.MediaSingSegment;
import com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy;
import com.tencent.karaoke.audiobasesdk.segment.strategy.GreedyHighLightStrategy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00016B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J3\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00190(j\b\u0012\u0004\u0012\u00020\u0019`)H\u0002\u00a2\u0006\u0002\u0010*J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0018J9\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00190(j\b\u0012\u0004\u0012\u00020\u0019`)H\u0002\u00a2\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020!J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\fJ\u0006\u00105\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentBusiness;", "", "()V", "TAG", "", "filterConfig", "Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentBusiness$FilterConfig;", "getFilterConfig", "()Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentBusiness$FilterConfig;", "setFilterConfig", "(Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentBusiness$FilterConfig;)V", "offsetTime", "", "getOffsetTime", "()I", "setOffsetTime", "(I)V", "pcmChannel", "getPcmChannel", "setPcmChannel", "pcmSampleRate", "getPcmSampleRate", "setPcmSampleRate", "scoreList", "", "Lcom/tencent/karaoke/audiobasesdk/segment/SingScoreData;", "getScoreList", "()Ljava/util/List;", "setScoreList", "(Ljava/util/List;)V", "singSegment", "Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegment;", "checkAndResetConfig", "", "createHighLightStrategy", "Lcom/tencent/karaoke/audiobasesdk/segment/strategy/BaseHighLightStrategy;", "segmentList", "", "Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "singScoreList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "([Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;Ljava/util/ArrayList;)Lcom/tencent/karaoke/audiobasesdk/segment/strategy/BaseHighLightStrategy;", "getHighLightList", "Lcom/tencent/karaoke/audiobasesdk/segment/HighLightItem;", "pickHighLightList", "([Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;Ljava/util/ArrayList;)Ljava/util/List;", "prepare", "process", "", "pcmDataBuffer", "", "readSize", "release", "FilterConfig", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class MediaSingSegmentBusiness {
    private int offsetTime;

    @Nullable
    private List<SingScoreData> scoreList;
    private MediaSingSegment singSegment;
    private final String TAG = "MediaSingSegmentBusiness";
    private int pcmChannel = -1;
    private int pcmSampleRate = -1;

    @NotNull
    private FilterConfig filterConfig = new FilterConfig(0, 0, 0.0f, 0, 0, 0, 63, null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001J\t\u0010&\u001a\u00020'H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentBusiness$FilterConfig;", "", "minDuration", "", "maxDuration", "avgScoreAtLeast", "", "minCount", "mergeMaxInterval", "clipTimePadding", "(IIFIII)V", "getAvgScoreAtLeast", "()F", "setAvgScoreAtLeast", "(F)V", "getClipTimePadding", "()I", "setClipTimePadding", "(I)V", "getMaxDuration", "setMaxDuration", "getMergeMaxInterval", "setMergeMaxInterval", "getMinCount", "setMinCount", "getMinDuration", "setMinDuration", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public static final /* data */ class FilterConfig {
        private float avgScoreAtLeast;
        private int clipTimePadding;
        private int maxDuration;
        private int mergeMaxInterval;
        private int minCount;
        private int minDuration;

        public FilterConfig() {
            this(0, 0, 0.0f, 0, 0, 0, 63, null);
        }

        @NotNull
        public static /* synthetic */ FilterConfig copy$default(FilterConfig filterConfig, int i3, int i16, float f16, int i17, int i18, int i19, int i26, Object obj) {
            if ((i26 & 1) != 0) {
                i3 = filterConfig.minDuration;
            }
            if ((i26 & 2) != 0) {
                i16 = filterConfig.maxDuration;
            }
            int i27 = i16;
            if ((i26 & 4) != 0) {
                f16 = filterConfig.avgScoreAtLeast;
            }
            float f17 = f16;
            if ((i26 & 8) != 0) {
                i17 = filterConfig.minCount;
            }
            int i28 = i17;
            if ((i26 & 16) != 0) {
                i18 = filterConfig.mergeMaxInterval;
            }
            int i29 = i18;
            if ((i26 & 32) != 0) {
                i19 = filterConfig.clipTimePadding;
            }
            return filterConfig.copy(i3, i27, f17, i28, i29, i19);
        }

        /* renamed from: component1, reason: from getter */
        public final int getMinDuration() {
            return this.minDuration;
        }

        /* renamed from: component2, reason: from getter */
        public final int getMaxDuration() {
            return this.maxDuration;
        }

        /* renamed from: component3, reason: from getter */
        public final float getAvgScoreAtLeast() {
            return this.avgScoreAtLeast;
        }

        /* renamed from: component4, reason: from getter */
        public final int getMinCount() {
            return this.minCount;
        }

        /* renamed from: component5, reason: from getter */
        public final int getMergeMaxInterval() {
            return this.mergeMaxInterval;
        }

        /* renamed from: component6, reason: from getter */
        public final int getClipTimePadding() {
            return this.clipTimePadding;
        }

        @NotNull
        public final FilterConfig copy(int minDuration, int maxDuration, float avgScoreAtLeast, int minCount, int mergeMaxInterval, int clipTimePadding) {
            return new FilterConfig(minDuration, maxDuration, avgScoreAtLeast, minCount, mergeMaxInterval, clipTimePadding);
        }

        public boolean equals(@Nullable Object other) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            if (this != other) {
                if (other instanceof FilterConfig) {
                    FilterConfig filterConfig = (FilterConfig) other;
                    if (this.minDuration == filterConfig.minDuration) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (this.maxDuration == filterConfig.maxDuration) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17 && Float.compare(this.avgScoreAtLeast, filterConfig.avgScoreAtLeast) == 0) {
                            if (this.minCount == filterConfig.minCount) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                if (this.mergeMaxInterval == filterConfig.mergeMaxInterval) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (z19) {
                                    if (this.clipTimePadding == filterConfig.clipTimePadding) {
                                        z26 = true;
                                    } else {
                                        z26 = false;
                                    }
                                    if (z26) {
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final float getAvgScoreAtLeast() {
            return this.avgScoreAtLeast;
        }

        public final int getClipTimePadding() {
            return this.clipTimePadding;
        }

        public final int getMaxDuration() {
            return this.maxDuration;
        }

        public final int getMergeMaxInterval() {
            return this.mergeMaxInterval;
        }

        public final int getMinCount() {
            return this.minCount;
        }

        public final int getMinDuration() {
            return this.minDuration;
        }

        public int hashCode() {
            return (((((((((this.minDuration * 31) + this.maxDuration) * 31) + Float.floatToIntBits(this.avgScoreAtLeast)) * 31) + this.minCount) * 31) + this.mergeMaxInterval) * 31) + this.clipTimePadding;
        }

        public final void setAvgScoreAtLeast(float f16) {
            this.avgScoreAtLeast = f16;
        }

        public final void setClipTimePadding(int i3) {
            this.clipTimePadding = i3;
        }

        public final void setMaxDuration(int i3) {
            this.maxDuration = i3;
        }

        public final void setMergeMaxInterval(int i3) {
            this.mergeMaxInterval = i3;
        }

        public final void setMinCount(int i3) {
            this.minCount = i3;
        }

        public final void setMinDuration(int i3) {
            this.minDuration = i3;
        }

        @NotNull
        public String toString() {
            return "FilterConfig(minDuration=" + this.minDuration + ", maxDuration=" + this.maxDuration + ", avgScoreAtLeast=" + this.avgScoreAtLeast + ", minCount=" + this.minCount + ", mergeMaxInterval=" + this.mergeMaxInterval + ", clipTimePadding=" + this.clipTimePadding + ")";
        }

        public FilterConfig(int i3, int i16, float f16, int i17, int i18, int i19) {
            this.minDuration = i3;
            this.maxDuration = i16;
            this.avgScoreAtLeast = f16;
            this.minCount = i17;
            this.mergeMaxInterval = i18;
            this.clipTimePadding = i19;
        }

        public /* synthetic */ FilterConfig(int i3, int i16, float f16, int i17, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
            this((i26 & 1) != 0 ? 10000 : i3, (i26 & 2) != 0 ? 60000 : i16, (i26 & 4) != 0 ? 80.0f : f16, (i26 & 8) != 0 ? 3 : i17, (i26 & 16) != 0 ? 1000 : i18, (i26 & 32) != 0 ? 1000 : i19);
        }
    }

    private final void checkAndResetConfig() {
        FilterConfig filterConfig = new FilterConfig(0, 0, 0.0f, 0, 0, 0, 63, null);
        float avgScoreAtLeast = this.filterConfig.getAvgScoreAtLeast();
        if (avgScoreAtLeast < 40.0f || avgScoreAtLeast > 99.0f) {
            this.filterConfig.setAvgScoreAtLeast(filterConfig.getAvgScoreAtLeast());
        }
        int minCount = this.filterConfig.getMinCount();
        if (1 > minCount || 20 < minCount) {
            this.filterConfig.setMinCount(filterConfig.getMinCount());
        }
        int minDuration = this.filterConfig.getMinDuration();
        if (5000 > minDuration || 30000 < minDuration) {
            this.filterConfig.setMinDuration(filterConfig.getMinDuration());
        }
        int maxDuration = this.filterConfig.getMaxDuration();
        if (30000 > maxDuration || 120000 < maxDuration) {
            this.filterConfig.setMaxDuration(filterConfig.getMaxDuration());
        }
        int mergeMaxInterval = this.filterConfig.getMergeMaxInterval();
        if (mergeMaxInterval < 0 || 5000 < mergeMaxInterval) {
            this.filterConfig.setMergeMaxInterval(filterConfig.getMergeMaxInterval());
        }
        int clipTimePadding = this.filterConfig.getClipTimePadding();
        if (clipTimePadding < 0 || 5000 < clipTimePadding) {
            this.filterConfig.setClipTimePadding(filterConfig.getClipTimePadding());
        }
        LogUtil.i(this.TAG, "checkAndResetConfig filterConfig:" + this.filterConfig);
    }

    private final BaseHighLightStrategy createHighLightStrategy(SingSegmentData[] segmentList, ArrayList<SingScoreData> singScoreList) {
        return new GreedyHighLightStrategy(this.offsetTime, this.filterConfig, segmentList, singScoreList);
    }

    private final List<HighLightItem> pickHighLightList(SingSegmentData[] segmentList, ArrayList<SingScoreData> singScoreList) {
        return createHighLightStrategy(segmentList, singScoreList).execute();
    }

    @NotNull
    public final FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r0 != null) goto L8;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<HighLightItem> getHighLightList() {
        SingSegmentData[] singSegmentDataArr;
        Integer num;
        MediaSingSegment mediaSingSegment = this.singSegment;
        if (mediaSingSegment != null) {
            mediaSingSegment.finish();
            singSegmentDataArr = mediaSingSegment.fetchSingSegment();
        }
        singSegmentDataArr = new SingSegmentData[0];
        ArrayList<SingScoreData> arrayList = new ArrayList<>();
        List<SingScoreData> list = this.scoreList;
        if (list != null) {
            arrayList.addAll(list);
        }
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getHighLightSegmentList pcmChannel:");
        sb5.append(this.pcmChannel);
        sb5.append(", pcmSampleRate:");
        sb5.append(this.pcmSampleRate);
        sb5.append(", fetchSingSegment size: ");
        sb5.append(singSegmentDataArr.length);
        sb5.append(", scoreList size:");
        List<SingScoreData> list2 = this.scoreList;
        if (list2 != null) {
            num = Integer.valueOf(list2.size());
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(TokenParser.SP);
        LogUtil.i(str, sb5.toString());
        return pickHighLightList(singSegmentDataArr, arrayList);
    }

    public final int getOffsetTime() {
        return this.offsetTime;
    }

    public final int getPcmChannel() {
        return this.pcmChannel;
    }

    public final int getPcmSampleRate() {
        return this.pcmSampleRate;
    }

    @Nullable
    public final List<SingScoreData> getScoreList() {
        return this.scoreList;
    }

    public final void prepare() {
        Integer num;
        MediaSingSegment mediaSingSegment = this.singSegment;
        if (mediaSingSegment != null) {
            mediaSingSegment.release();
        }
        MediaSingSegment.Builder builder = new MediaSingSegment.Builder();
        builder.setChannel(this.pcmChannel);
        builder.setSampleRate(this.pcmSampleRate);
        MediaSingSegment build = builder.build();
        if (build != null) {
            build.init();
        }
        this.singSegment = build;
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("prepare pcmChannel:");
        sb5.append(this.pcmChannel);
        sb5.append(", pcmSampleRate:");
        sb5.append(this.pcmSampleRate);
        sb5.append(" , scoreList size:");
        List<SingScoreData> list = this.scoreList;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", offsetTime:");
        sb5.append(this.offsetTime);
        sb5.append(", filterConfig:");
        sb5.append(this.filterConfig);
        LogUtil.i(str, sb5.toString());
        checkAndResetConfig();
    }

    public final boolean process(@NotNull byte[] pcmDataBuffer, int readSize) {
        Intrinsics.checkParameterIsNotNull(pcmDataBuffer, "pcmDataBuffer");
        MediaSingSegment mediaSingSegment = this.singSegment;
        if (mediaSingSegment != null) {
            return mediaSingSegment.process(pcmDataBuffer, readSize);
        }
        return false;
    }

    public final void release() {
        MediaSingSegment mediaSingSegment = this.singSegment;
        if (mediaSingSegment != null) {
            mediaSingSegment.release();
        }
        LogUtil.i(this.TAG, "release ");
    }

    public final void setFilterConfig(@NotNull FilterConfig filterConfig) {
        Intrinsics.checkParameterIsNotNull(filterConfig, "<set-?>");
        this.filterConfig = filterConfig;
    }

    public final void setOffsetTime(int i3) {
        this.offsetTime = i3;
    }

    public final void setPcmChannel(int i3) {
        this.pcmChannel = i3;
    }

    public final void setPcmSampleRate(int i3) {
        this.pcmSampleRate = i3;
    }

    public final void setScoreList(@Nullable List<SingScoreData> list) {
        this.scoreList = list;
    }
}
