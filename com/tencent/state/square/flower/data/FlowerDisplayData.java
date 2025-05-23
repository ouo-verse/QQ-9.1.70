package com.tencent.state.square.flower.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u00c6\u0003Ja\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u00c6\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\tH\u00d6\u0001J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011\u00a8\u0006."}, d2 = {"Lcom/tencent/state/square/flower/data/FlowerDisplayData;", "", "pageText", "", "tipsText", "isShowFlowerRecordsEntry", "", "flowerRecordsEntryUrl", "flowerTotalNum", "", "flowerTodayNum", "medal", "Lcom/tencent/state/square/flower/data/MedalData;", "medalConfig", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILcom/tencent/state/square/flower/data/MedalData;Ljava/util/List;)V", "getFlowerRecordsEntryUrl", "()Ljava/lang/String;", "getFlowerTodayNum", "()I", "setFlowerTodayNum", "(I)V", "getFlowerTotalNum", "setFlowerTotalNum", "()Z", "getMedal", "()Lcom/tencent/state/square/flower/data/MedalData;", "setMedal", "(Lcom/tencent/state/square/flower/data/MedalData;)V", "getMedalConfig", "()Ljava/util/List;", "getPageText", "getTipsText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FlowerDisplayData {
    private final String flowerRecordsEntryUrl;
    private int flowerTodayNum;
    private int flowerTotalNum;
    private final boolean isShowFlowerRecordsEntry;
    private MedalData medal;
    private final List<MedalData> medalConfig;
    private final String pageText;
    private final String tipsText;

    public FlowerDisplayData(String pageText, String tipsText, boolean z16, String flowerRecordsEntryUrl, int i3, int i16, MedalData medalData, List<MedalData> medalConfig) {
        Intrinsics.checkNotNullParameter(pageText, "pageText");
        Intrinsics.checkNotNullParameter(tipsText, "tipsText");
        Intrinsics.checkNotNullParameter(flowerRecordsEntryUrl, "flowerRecordsEntryUrl");
        Intrinsics.checkNotNullParameter(medalConfig, "medalConfig");
        this.pageText = pageText;
        this.tipsText = tipsText;
        this.isShowFlowerRecordsEntry = z16;
        this.flowerRecordsEntryUrl = flowerRecordsEntryUrl;
        this.flowerTotalNum = i3;
        this.flowerTodayNum = i16;
        this.medal = medalData;
        this.medalConfig = medalConfig;
    }

    /* renamed from: component1, reason: from getter */
    public final String getPageText() {
        return this.pageText;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTipsText() {
        return this.tipsText;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsShowFlowerRecordsEntry() {
        return this.isShowFlowerRecordsEntry;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFlowerRecordsEntryUrl() {
        return this.flowerRecordsEntryUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final int getFlowerTotalNum() {
        return this.flowerTotalNum;
    }

    /* renamed from: component6, reason: from getter */
    public final int getFlowerTodayNum() {
        return this.flowerTodayNum;
    }

    /* renamed from: component7, reason: from getter */
    public final MedalData getMedal() {
        return this.medal;
    }

    public final List<MedalData> component8() {
        return this.medalConfig;
    }

    public final FlowerDisplayData copy(String pageText, String tipsText, boolean isShowFlowerRecordsEntry, String flowerRecordsEntryUrl, int flowerTotalNum, int flowerTodayNum, MedalData medal, List<MedalData> medalConfig) {
        Intrinsics.checkNotNullParameter(pageText, "pageText");
        Intrinsics.checkNotNullParameter(tipsText, "tipsText");
        Intrinsics.checkNotNullParameter(flowerRecordsEntryUrl, "flowerRecordsEntryUrl");
        Intrinsics.checkNotNullParameter(medalConfig, "medalConfig");
        return new FlowerDisplayData(pageText, tipsText, isShowFlowerRecordsEntry, flowerRecordsEntryUrl, flowerTotalNum, flowerTodayNum, medal, medalConfig);
    }

    public final String getFlowerRecordsEntryUrl() {
        return this.flowerRecordsEntryUrl;
    }

    public final int getFlowerTodayNum() {
        return this.flowerTodayNum;
    }

    public final int getFlowerTotalNum() {
        return this.flowerTotalNum;
    }

    public final MedalData getMedal() {
        return this.medal;
    }

    public final List<MedalData> getMedalConfig() {
        return this.medalConfig;
    }

    public final String getPageText() {
        return this.pageText;
    }

    public final String getTipsText() {
        return this.tipsText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.pageText;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tipsText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.isShowFlowerRecordsEntry;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        String str3 = this.flowerRecordsEntryUrl;
        int hashCode3 = (((((i16 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.flowerTotalNum) * 31) + this.flowerTodayNum) * 31;
        MedalData medalData = this.medal;
        int hashCode4 = (hashCode3 + (medalData != null ? medalData.hashCode() : 0)) * 31;
        List<MedalData> list = this.medalConfig;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isShowFlowerRecordsEntry() {
        return this.isShowFlowerRecordsEntry;
    }

    public final void setFlowerTodayNum(int i3) {
        this.flowerTodayNum = i3;
    }

    public final void setFlowerTotalNum(int i3) {
        this.flowerTotalNum = i3;
    }

    public final void setMedal(MedalData medalData) {
        this.medal = medalData;
    }

    public String toString() {
        return "FlowerDisplayData(pageText=" + this.pageText + ", tipsText=" + this.tipsText + ", isShowFlowerRecordsEntry=" + this.isShowFlowerRecordsEntry + ", flowerRecordsEntryUrl=" + this.flowerRecordsEntryUrl + ", flowerTotalNum=" + this.flowerTotalNum + ", flowerTodayNum=" + this.flowerTodayNum + ", medal=" + this.medal + ", medalConfig=" + this.medalConfig + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ FlowerDisplayData(String str, String str2, boolean z16, String str3, int i3, int i16, MedalData medalData, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, r6, r7, r8, r9, r10, r11);
        List list2;
        List emptyList;
        boolean z17 = (i17 & 4) != 0 ? false : z16;
        String str4 = (i17 & 8) != 0 ? "" : str3;
        int i18 = (i17 & 16) != 0 ? 0 : i3;
        int i19 = (i17 & 32) != 0 ? 0 : i16;
        MedalData medalData2 = (i17 & 64) != 0 ? null : medalData;
        if ((i17 & 128) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowerDisplayData)) {
            return false;
        }
        FlowerDisplayData flowerDisplayData = (FlowerDisplayData) other;
        return Intrinsics.areEqual(this.pageText, flowerDisplayData.pageText) && Intrinsics.areEqual(this.tipsText, flowerDisplayData.tipsText) && this.isShowFlowerRecordsEntry == flowerDisplayData.isShowFlowerRecordsEntry && Intrinsics.areEqual(this.flowerRecordsEntryUrl, flowerDisplayData.flowerRecordsEntryUrl) && this.flowerTotalNum == flowerDisplayData.flowerTotalNum && this.flowerTodayNum == flowerDisplayData.flowerTodayNum && Intrinsics.areEqual(this.medal, flowerDisplayData.medal) && Intrinsics.areEqual(this.medalConfig, flowerDisplayData.medalConfig);
    }
}
