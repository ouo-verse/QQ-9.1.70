package com.tencent.sqshow.zootopia.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\r\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/z;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "avatar", "b", "d", "name", "c", "e", "subText", "label", "Z", "()Z", "defaultDarkStyle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.z, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaUserData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String avatar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String subText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String label;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean defaultDarkStyle;

    public ZootopiaUserData() {
        this(null, null, null, null, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDefaultDarkStyle() {
        return this.defaultDarkStyle;
    }

    /* renamed from: c, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final String getSubText() {
        return this.subText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subText;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.label;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z16 = this.defaultDarkStyle;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "ZootopiaUserData(avatar=" + this.avatar + ", name=" + this.name + ", subText=" + this.subText + ", label=" + this.label + ", defaultDarkStyle=" + this.defaultDarkStyle + ")";
    }

    public ZootopiaUserData(String str, String str2, String str3, String str4, boolean z16) {
        this.avatar = str;
        this.name = str2;
        this.subText = str3;
        this.label = str4;
        this.defaultDarkStyle = z16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaUserData)) {
            return false;
        }
        ZootopiaUserData zootopiaUserData = (ZootopiaUserData) other;
        return Intrinsics.areEqual(this.avatar, zootopiaUserData.avatar) && Intrinsics.areEqual(this.name, zootopiaUserData.name) && Intrinsics.areEqual(this.subText, zootopiaUserData.subText) && Intrinsics.areEqual(this.label, zootopiaUserData.label) && this.defaultDarkStyle == zootopiaUserData.defaultDarkStyle;
    }

    public /* synthetic */ ZootopiaUserData(String str, String str2, String str3, String str4, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) == 0 ? str4 : null, (i3 & 16) != 0 ? true : z16);
    }
}
