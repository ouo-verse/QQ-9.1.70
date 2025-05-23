package com.tencent.sqshow.zootopia.samestyle;

import com.tencent.sqshow.zootopia.samestyle.data.MaterialWrapper;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZplanEntranceInfo;", "Ljava/io/Serializable;", "iconMaterial", "Lcom/tencent/sqshow/zootopia/samestyle/data/MaterialWrapper;", "title", "", "sdkUrl", QZoneDTLoginReporter.SCHEMA, "(Lcom/tencent/sqshow/zootopia/samestyle/data/MaterialWrapper;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconMaterial", "()Lcom/tencent/sqshow/zootopia/samestyle/data/MaterialWrapper;", "getSchema", "()Ljava/lang/String;", "getSdkUrl", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final /* data */ class ZplanEntranceInfo implements Serializable {
    private final MaterialWrapper iconMaterial;
    private final String schema;
    private final String sdkUrl;
    private final String title;

    public ZplanEntranceInfo(MaterialWrapper iconMaterial, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(iconMaterial, "iconMaterial");
        this.iconMaterial = iconMaterial;
        this.title = str;
        this.sdkUrl = str2;
        this.schema = str3;
    }

    /* renamed from: component1, reason: from getter */
    public final MaterialWrapper getIconMaterial() {
        return this.iconMaterial;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSdkUrl() {
        return this.sdkUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    public final ZplanEntranceInfo copy(MaterialWrapper iconMaterial, String title, String sdkUrl, String schema) {
        Intrinsics.checkNotNullParameter(iconMaterial, "iconMaterial");
        return new ZplanEntranceInfo(iconMaterial, title, sdkUrl, schema);
    }

    public final MaterialWrapper getIconMaterial() {
        return this.iconMaterial;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSdkUrl() {
        return this.sdkUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.iconMaterial.hashCode() * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sdkUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.schema;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ZplanEntranceInfo(iconMaterial=" + this.iconMaterial + ", title=" + this.title + ", sdkUrl=" + this.sdkUrl + ", schema=" + this.schema + ")";
    }

    public static /* synthetic */ ZplanEntranceInfo copy$default(ZplanEntranceInfo zplanEntranceInfo, MaterialWrapper materialWrapper, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            materialWrapper = zplanEntranceInfo.iconMaterial;
        }
        if ((i3 & 2) != 0) {
            str = zplanEntranceInfo.title;
        }
        if ((i3 & 4) != 0) {
            str2 = zplanEntranceInfo.sdkUrl;
        }
        if ((i3 & 8) != 0) {
            str3 = zplanEntranceInfo.schema;
        }
        return zplanEntranceInfo.copy(materialWrapper, str, str2, str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZplanEntranceInfo)) {
            return false;
        }
        ZplanEntranceInfo zplanEntranceInfo = (ZplanEntranceInfo) other;
        return Intrinsics.areEqual(this.iconMaterial, zplanEntranceInfo.iconMaterial) && Intrinsics.areEqual(this.title, zplanEntranceInfo.title) && Intrinsics.areEqual(this.sdkUrl, zplanEntranceInfo.sdkUrl) && Intrinsics.areEqual(this.schema, zplanEntranceInfo.schema);
    }
}
