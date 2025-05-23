package com.tencent.mobileqq.z1.download.data;

import cooperation.qzone.QZoneRequestEncoder;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/z1/download/data/ZootopiaSummaryData;", "Ljava/io/Serializable;", "id", "", "type", "", "title", "cover", "buttonText", "typeIcon", "typeName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonText", "()Ljava/lang/String;", QZoneRequestEncoder.KEY_COVER_REQ, "getId", "getTitle", "getType", "()I", "getTypeIcon", "getTypeName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaSummaryData implements Serializable {

    @NotNull
    private final String buttonText;

    @NotNull
    private final String cover;

    @NotNull
    private final String id;

    @NotNull
    private final String title;
    private final int type;

    @NotNull
    private final String typeIcon;

    @NotNull
    private final String typeName;

    public ZootopiaSummaryData(@NotNull String id5, int i3, @NotNull String title, @NotNull String cover, @NotNull String buttonText, @NotNull String typeIcon, @NotNull String typeName) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(typeIcon, "typeIcon");
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        this.id = id5;
        this.type = i3;
        this.title = title;
        this.cover = cover;
        this.buttonText = buttonText;
        this.typeIcon = typeIcon;
        this.typeName = typeName;
    }

    public static /* synthetic */ ZootopiaSummaryData copy$default(ZootopiaSummaryData zootopiaSummaryData, String str, int i3, String str2, String str3, String str4, String str5, String str6, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = zootopiaSummaryData.id;
        }
        if ((i16 & 2) != 0) {
            i3 = zootopiaSummaryData.type;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            str2 = zootopiaSummaryData.title;
        }
        String str7 = str2;
        if ((i16 & 8) != 0) {
            str3 = zootopiaSummaryData.cover;
        }
        String str8 = str3;
        if ((i16 & 16) != 0) {
            str4 = zootopiaSummaryData.buttonText;
        }
        String str9 = str4;
        if ((i16 & 32) != 0) {
            str5 = zootopiaSummaryData.typeIcon;
        }
        String str10 = str5;
        if ((i16 & 64) != 0) {
            str6 = zootopiaSummaryData.typeName;
        }
        return zootopiaSummaryData.copy(str, i17, str7, str8, str9, str10, str6);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCover() {
        return this.cover;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getTypeIcon() {
        return this.typeIcon;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getTypeName() {
        return this.typeName;
    }

    @NotNull
    public final ZootopiaSummaryData copy(@NotNull String id5, int type, @NotNull String title, @NotNull String cover, @NotNull String buttonText, @NotNull String typeIcon, @NotNull String typeName) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(typeIcon, "typeIcon");
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        return new ZootopiaSummaryData(id5, type, title, cover, buttonText, typeIcon, typeName);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaSummaryData)) {
            return false;
        }
        ZootopiaSummaryData zootopiaSummaryData = (ZootopiaSummaryData) other;
        if (Intrinsics.areEqual(this.id, zootopiaSummaryData.id) && this.type == zootopiaSummaryData.type && Intrinsics.areEqual(this.title, zootopiaSummaryData.title) && Intrinsics.areEqual(this.cover, zootopiaSummaryData.cover) && Intrinsics.areEqual(this.buttonText, zootopiaSummaryData.buttonText) && Intrinsics.areEqual(this.typeIcon, zootopiaSummaryData.typeIcon) && Intrinsics.areEqual(this.typeName, zootopiaSummaryData.typeName)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    public final String getCover() {
        return this.cover;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getTypeIcon() {
        return this.typeIcon;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.type) * 31) + this.title.hashCode()) * 31) + this.cover.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.typeIcon.hashCode()) * 31) + this.typeName.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZootopiaSummaryData(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", cover=" + this.cover + ", buttonText=" + this.buttonText + ", typeIcon=" + this.typeIcon + ", typeName=" + this.typeName + ')';
    }
}
