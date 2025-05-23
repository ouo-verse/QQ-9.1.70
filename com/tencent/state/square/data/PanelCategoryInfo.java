package com.tencent.state.square.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/square/data/PanelCategoryInfo;", "", "id", "", "name", "panelData", "", "Lcom/tencent/state/square/data/StatusActionInfo;", "dressKey", "tip", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getDressKey", "()Ljava/lang/String;", "getId", "getName", "getPanelData", "()Ljava/util/List;", "getTip", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PanelCategoryInfo {
    private final String dressKey;
    private final String id;
    private final String name;
    private final List<StatusActionInfo> panelData;
    private final String tip;

    public PanelCategoryInfo(String id5, String name, List<StatusActionInfo> panelData, String dressKey, String tip) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(panelData, "panelData");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(tip, "tip");
        this.id = id5;
        this.name = name;
        this.panelData = panelData;
        this.dressKey = dressKey;
        this.tip = tip;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<StatusActionInfo> component3() {
        return this.panelData;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTip() {
        return this.tip;
    }

    public final PanelCategoryInfo copy(String id5, String name, List<StatusActionInfo> panelData, String dressKey, String tip) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(panelData, "panelData");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(tip, "tip");
        return new PanelCategoryInfo(id5, name, panelData, dressKey, tip);
    }

    public final String getDressKey() {
        return this.dressKey;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<StatusActionInfo> getPanelData() {
        return this.panelData;
    }

    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<StatusActionInfo> list = this.panelData;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.dressKey;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.tip;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "PanelCategoryInfo(id=" + this.id + ", name=" + this.name + ", panelData=" + this.panelData + ", dressKey=" + this.dressKey + ", tip=" + this.tip + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanelCategoryInfo)) {
            return false;
        }
        PanelCategoryInfo panelCategoryInfo = (PanelCategoryInfo) other;
        return Intrinsics.areEqual(this.id, panelCategoryInfo.id) && Intrinsics.areEqual(this.name, panelCategoryInfo.name) && Intrinsics.areEqual(this.panelData, panelCategoryInfo.panelData) && Intrinsics.areEqual(this.dressKey, panelCategoryInfo.dressKey) && Intrinsics.areEqual(this.tip, panelCategoryInfo.tip);
    }

    public static /* synthetic */ PanelCategoryInfo copy$default(PanelCategoryInfo panelCategoryInfo, String str, String str2, List list, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = panelCategoryInfo.id;
        }
        if ((i3 & 2) != 0) {
            str2 = panelCategoryInfo.name;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            list = panelCategoryInfo.panelData;
        }
        List list2 = list;
        if ((i3 & 8) != 0) {
            str3 = panelCategoryInfo.dressKey;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = panelCategoryInfo.tip;
        }
        return panelCategoryInfo.copy(str, str5, list2, str6, str4);
    }
}
