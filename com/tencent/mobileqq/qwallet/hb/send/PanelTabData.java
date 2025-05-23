package com.tencent.mobileqq.qwallet.hb.send;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "e", "I", "getType", "()I", "type", "f", "a", "name", h.F, "b", "url", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class PanelTabData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PanelTabData> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String name;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String url;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a implements Parcelable.Creator<PanelTabData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PanelTabData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PanelTabData(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PanelTabData[] newArray(int i3) {
            return new PanelTabData[i3];
        }
    }

    public PanelTabData(@Nullable String str, int i3, @Nullable String str2, @Nullable String str3) {
        this.id = str;
        this.type = i3;
        this.name = str2;
        this.url = str3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanelTabData)) {
            return false;
        }
        PanelTabData panelTabData = (PanelTabData) other;
        if (Intrinsics.areEqual(this.id, panelTabData.id) && this.type == panelTabData.type && Intrinsics.areEqual(this.name, panelTabData.name) && Intrinsics.areEqual(this.url, panelTabData.url)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.id;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = ((hashCode * 31) + this.type) * 31;
        String str2 = this.name;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "PanelTabData(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeInt(this.type);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
    }
}
