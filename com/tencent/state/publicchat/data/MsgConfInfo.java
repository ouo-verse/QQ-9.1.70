package com.tencent.state.publicchat.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zr4.a;
import zr4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0004\b0\u00101B\u0013\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b0\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\f\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\u0002H\u00c6\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH\u00c6\u0003Jq\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\u0014\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b+\u0010*R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b,\u0010 R#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/state/publicchat/data/MsgConfInfo;", "", "", "component1", "Lcom/tencent/state/publicchat/data/DisplayType;", "component2", "", "Lcom/tencent/state/publicchat/data/ElemConfInfo;", "component3", "component4", "", "component5", "component6", "component7", "", "component8", "templateId", "displayType", "titleConfInfos", "bodyConfInfos", "showTtl", "wordsLimit", "minVersion", "extra", "copy", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTemplateId", "()Ljava/lang/String;", "Lcom/tencent/state/publicchat/data/DisplayType;", "getDisplayType", "()Lcom/tencent/state/publicchat/data/DisplayType;", "Ljava/util/List;", "getTitleConfInfos", "()Ljava/util/List;", "getBodyConfInfos", "I", "getShowTtl", "()I", "getWordsLimit", "getMinVersion", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Lcom/tencent/state/publicchat/data/DisplayType;Ljava/util/List;Ljava/util/List;IILjava/lang/String;Ljava/util/Map;)V", "Lzr4/c;", "pb", "(Lzr4/c;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgConfInfo {
    private final List<ElemConfInfo> bodyConfInfos;
    private final DisplayType displayType;
    private final Map<String, String> extra;
    private final String minVersion;
    private final int showTtl;
    private final String templateId;
    private final List<ElemConfInfo> titleConfInfos;
    private final int wordsLimit;

    public MsgConfInfo(String templateId, DisplayType displayType, List<ElemConfInfo> titleConfInfos, List<ElemConfInfo> bodyConfInfos, int i3, int i16, String minVersion, Map<String, String> extra) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(displayType, "displayType");
        Intrinsics.checkNotNullParameter(titleConfInfos, "titleConfInfos");
        Intrinsics.checkNotNullParameter(bodyConfInfos, "bodyConfInfos");
        Intrinsics.checkNotNullParameter(minVersion, "minVersion");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.templateId = templateId;
        this.displayType = displayType;
        this.titleConfInfos = titleConfInfos;
        this.bodyConfInfos = bodyConfInfos;
        this.showTtl = i3;
        this.wordsLimit = i16;
        this.minVersion = minVersion;
        this.extra = extra;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTemplateId() {
        return this.templateId;
    }

    /* renamed from: component2, reason: from getter */
    public final DisplayType getDisplayType() {
        return this.displayType;
    }

    public final List<ElemConfInfo> component3() {
        return this.titleConfInfos;
    }

    public final List<ElemConfInfo> component4() {
        return this.bodyConfInfos;
    }

    /* renamed from: component5, reason: from getter */
    public final int getShowTtl() {
        return this.showTtl;
    }

    /* renamed from: component6, reason: from getter */
    public final int getWordsLimit() {
        return this.wordsLimit;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMinVersion() {
        return this.minVersion;
    }

    public final Map<String, String> component8() {
        return this.extra;
    }

    public final MsgConfInfo copy(String templateId, DisplayType displayType, List<ElemConfInfo> titleConfInfos, List<ElemConfInfo> bodyConfInfos, int showTtl, int wordsLimit, String minVersion, Map<String, String> extra) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(displayType, "displayType");
        Intrinsics.checkNotNullParameter(titleConfInfos, "titleConfInfos");
        Intrinsics.checkNotNullParameter(bodyConfInfos, "bodyConfInfos");
        Intrinsics.checkNotNullParameter(minVersion, "minVersion");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return new MsgConfInfo(templateId, displayType, titleConfInfos, bodyConfInfos, showTtl, wordsLimit, minVersion, extra);
    }

    public final List<ElemConfInfo> getBodyConfInfos() {
        return this.bodyConfInfos;
    }

    public final DisplayType getDisplayType() {
        return this.displayType;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getMinVersion() {
        return this.minVersion;
    }

    public final int getShowTtl() {
        return this.showTtl;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final List<ElemConfInfo> getTitleConfInfos() {
        return this.titleConfInfos;
    }

    public final int getWordsLimit() {
        return this.wordsLimit;
    }

    public int hashCode() {
        String str = this.templateId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DisplayType displayType = this.displayType;
        int hashCode2 = (hashCode + (displayType != null ? displayType.hashCode() : 0)) * 31;
        List<ElemConfInfo> list = this.titleConfInfos;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<ElemConfInfo> list2 = this.bodyConfInfos;
        int hashCode4 = (((((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.showTtl) * 31) + this.wordsLimit) * 31;
        String str2 = this.minVersion;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.extra;
        return hashCode5 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "MsgConfInfo(templateId=" + this.templateId + ", displayType=" + this.displayType + ", titleConfInfos=" + this.titleConfInfos + ", bodyConfInfos=" + this.bodyConfInfos + ", showTtl=" + this.showTtl + ", wordsLimit=" + this.wordsLimit + ", minVersion=" + this.minVersion + ", extra=" + this.extra + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MsgConfInfo(c cVar) {
        this(r3, r4, r5, r6, cVar != null ? cVar.f453086e : 0, cVar != null ? cVar.f453087f : 0, (cVar == null || (r1 = cVar.f453088g) == null) ? "" : r1, (cVar == null || (r12 = cVar.f453089h) == null) ? MapsKt__MapsKt.emptyMap() : r12);
        List emptyList;
        List list;
        List emptyList2;
        List list2;
        Map<String, String> map;
        String str;
        a[] aVarArr;
        List list3;
        int collectionSizeOrDefault;
        a[] aVarArr2;
        List list4;
        int collectionSizeOrDefault2;
        String str2;
        String str3 = (cVar == null || (str2 = cVar.f453082a) == null) ? "" : str2;
        DisplayType parse = DisplayType.INSTANCE.parse(cVar != null ? Integer.valueOf(cVar.f453083b) : null);
        if (cVar == null || (aVarArr2 = cVar.f453084c) == null || (list4 = ArraysKt.toList(aVarArr2)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            List list5 = list4;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
            list = new ArrayList(collectionSizeOrDefault2);
            Iterator it = list5.iterator();
            while (it.hasNext()) {
                list.add(new ElemConfInfo((a) it.next()));
            }
        }
        if (cVar == null || (aVarArr = cVar.f453085d) == null || (list3 = ArraysKt.toList(aVarArr)) == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList2;
        } else {
            List list6 = list3;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
            list2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = list6.iterator();
            while (it5.hasNext()) {
                list2.add(new ElemConfInfo((a) it5.next()));
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgConfInfo)) {
            return false;
        }
        MsgConfInfo msgConfInfo = (MsgConfInfo) other;
        return Intrinsics.areEqual(this.templateId, msgConfInfo.templateId) && Intrinsics.areEqual(this.displayType, msgConfInfo.displayType) && Intrinsics.areEqual(this.titleConfInfos, msgConfInfo.titleConfInfos) && Intrinsics.areEqual(this.bodyConfInfos, msgConfInfo.bodyConfInfos) && this.showTtl == msgConfInfo.showTtl && this.wordsLimit == msgConfInfo.wordsLimit && Intrinsics.areEqual(this.minVersion, msgConfInfo.minVersion) && Intrinsics.areEqual(this.extra, msgConfInfo.extra);
    }
}
