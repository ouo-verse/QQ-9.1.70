package com.tencent.state.square.flower.data;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\t\u0010%\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/flower/data/MedalData;", "", "id", "", "level", "name", "", "imageUrl", "miniImageUrl", "target", "", "color", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getId", "()I", "getImageUrl", "getLevel", "setLevel", "(I)V", "getMiniImageUrl", "getName", "getTarget", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MedalData {
    private final String color;
    private final int id;
    private final String imageUrl;
    private int level;
    private final String miniImageUrl;
    private final String name;
    private final long target;

    public MedalData() {
        this(0, 0, null, null, null, 0L, null, 127, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMiniImageUrl() {
        return this.miniImageUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTarget() {
        return this.target;
    }

    /* renamed from: component7, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    public final MedalData copy(int id5, int level, String name, String imageUrl, String miniImageUrl, long target, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(miniImageUrl, "miniImageUrl");
        Intrinsics.checkNotNullParameter(color, "color");
        return new MedalData(id5, level, name, imageUrl, miniImageUrl, target, color);
    }

    public final String getColor() {
        return this.color;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getMiniImageUrl() {
        return this.miniImageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final long getTarget() {
        return this.target;
    }

    public int hashCode() {
        int i3 = ((this.id * 31) + this.level) * 31;
        String str = this.name;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.miniImageUrl;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + c.a(this.target)) * 31;
        String str4 = this.color;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setLevel(int i3) {
        this.level = i3;
    }

    public String toString() {
        return "MedalData(id=" + this.id + ", level=" + this.level + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ", miniImageUrl=" + this.miniImageUrl + ", target=" + this.target + ", color=" + this.color + ")";
    }

    public MedalData(int i3, int i16, String name, String imageUrl, String miniImageUrl, long j3, String color) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(miniImageUrl, "miniImageUrl");
        Intrinsics.checkNotNullParameter(color, "color");
        this.id = i3;
        this.level = i16;
        this.name = name;
        this.imageUrl = imageUrl;
        this.miniImageUrl = miniImageUrl;
        this.target = j3;
        this.color = color;
    }

    public /* synthetic */ MedalData(int i3, int i16, String str, String str2, String str3, long j3, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) == 0 ? i16 : 0, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? "" : str3, (i17 & 32) != 0 ? 0L : j3, (i17 & 64) == 0 ? str4 : "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalData)) {
            return false;
        }
        MedalData medalData = (MedalData) other;
        return this.id == medalData.id && this.level == medalData.level && Intrinsics.areEqual(this.name, medalData.name) && Intrinsics.areEqual(this.imageUrl, medalData.imageUrl) && Intrinsics.areEqual(this.miniImageUrl, medalData.miniImageUrl) && this.target == medalData.target && Intrinsics.areEqual(this.color, medalData.color);
    }
}
