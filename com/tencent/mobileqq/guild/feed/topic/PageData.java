package com.tencent.mobileqq.guild.feed.topic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "getType", "()I", "type", "e", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "str", "<init>", "(ILjava/lang/String;)V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class PageData implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String str;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<PageData> CREATOR = new b();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final PageData f223507h = new PageData(2, "\u65b0\u53d1\u8868");

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final PageData f223508i = new PageData(3, "\u65b0\u56de\u590d");

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/PageData$a;", "", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "PUBLISH", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "a", "()Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "REPLY", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.PageData$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PageData a() {
            return PageData.f223507h;
        }

        @NotNull
        public final PageData b() {
            return PageData.f223508i;
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<PageData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PageData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PageData(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PageData[] newArray(int i3) {
            return new PageData[i3];
        }
    }

    public PageData(int i3, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.type = i3;
        this.str = str;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getStr() {
        return this.str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageData)) {
            return false;
        }
        PageData pageData = (PageData) other;
        if (this.type == pageData.type && Intrinsics.areEqual(this.str, pageData.str)) {
            return true;
        }
        return false;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.str.hashCode();
    }

    @NotNull
    public String toString() {
        return "PageData(type=" + this.type + ", str=" + this.str + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.type);
        parcel.writeString(this.str);
    }
}
