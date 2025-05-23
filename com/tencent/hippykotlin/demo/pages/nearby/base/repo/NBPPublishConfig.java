package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n25.k;
import n25.m;

/* loaded from: classes31.dex */
public final class NBPPublishConfig {
    public final int feedType;
    public final boolean isAISelectTheme;
    public final String photoPath;
    public final k poiInfo;
    public final boolean showToast;
    public final String source;
    public final NBPPublishStatusData status;
    public final String textContent;
    public final List<String> themes;
    public final List<m> topics;

    public NBPPublishConfig(String str, String str2, NBPPublishStatusData nBPPublishStatusData, String str3, k kVar, List<m> list, List<String> list2, boolean z16, int i3, boolean z17) {
        this.source = str;
        this.photoPath = str2;
        this.status = nBPPublishStatusData;
        this.textContent = str3;
        this.poiInfo = kVar;
        this.topics = list;
        this.themes = list2;
        this.isAISelectTheme = z16;
        this.feedType = i3;
        this.showToast = z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.source.hashCode() * 31;
        String str = this.photoPath;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        NBPPublishStatusData nBPPublishStatusData = this.status;
        int hashCode3 = (hashCode2 + (nBPPublishStatusData == null ? 0 : nBPPublishStatusData.hashCode())) * 31;
        String str2 = this.textContent;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        k kVar = this.poiInfo;
        int hashCode5 = (this.themes.hashCode() + ((this.topics.hashCode() + ((hashCode4 + (kVar != null ? kVar.hashCode() : 0)) * 31)) * 31)) * 31;
        boolean z16 = this.isAISelectTheme;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.feedType, (hashCode5 + i3) * 31, 31);
        boolean z17 = this.showToast;
        return m3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("source: ");
        m3.append(this.source);
        m3.append(", ephotoPath: ");
        m3.append(this.photoPath);
        m3.append(", status: ");
        m3.append(this.status);
        m3.append(", textContent: ");
        m3.append(this.textContent);
        m3.append(", poiInfo: ");
        k kVar = this.poiInfo;
        m3.append(kVar != null ? NBPPublishServiceKt.desc(kVar) : null);
        m3.append(", topics: ");
        m3.append(this.topics);
        m3.append(", themes: ");
        m3.append(this.themes);
        m3.append(", isAISelectTheme: ");
        m3.append(this.isAISelectTheme);
        m3.append(", feedType: ");
        m3.append(this.feedType);
        m3.append(", showToast: ");
        m3.append(this.showToast);
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPPublishConfig)) {
            return false;
        }
        NBPPublishConfig nBPPublishConfig = (NBPPublishConfig) obj;
        return Intrinsics.areEqual(this.source, nBPPublishConfig.source) && Intrinsics.areEqual(this.photoPath, nBPPublishConfig.photoPath) && Intrinsics.areEqual(this.status, nBPPublishConfig.status) && Intrinsics.areEqual(this.textContent, nBPPublishConfig.textContent) && Intrinsics.areEqual(this.poiInfo, nBPPublishConfig.poiInfo) && Intrinsics.areEqual(this.topics, nBPPublishConfig.topics) && Intrinsics.areEqual(this.themes, nBPPublishConfig.themes) && this.isAISelectTheme == nBPPublishConfig.isAISelectTheme && this.feedType == nBPPublishConfig.feedType && this.showToast == nBPPublishConfig.showToast;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ NBPPublishConfig(String str, String str2, NBPPublishStatusData nBPPublishStatusData, String str3, k kVar, List list, List list2, int i3, int i16) {
        this(str, r5, r6, r7, r8, r9, r10, false, (i16 & 256) != 0 ? 0 : i3, (i16 & 512) != 0);
        List list3;
        List list4;
        List emptyList;
        List emptyList2;
        String str4 = (i16 & 2) != 0 ? null : str2;
        NBPPublishStatusData nBPPublishStatusData2 = (i16 & 4) != 0 ? null : nBPPublishStatusData;
        String str5 = (i16 & 8) != 0 ? null : str3;
        k kVar2 = (i16 & 16) != 0 ? null : kVar;
        if ((i16 & 32) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        if ((i16 & 64) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
    }
}
