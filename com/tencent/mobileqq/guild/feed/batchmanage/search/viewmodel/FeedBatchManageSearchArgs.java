package com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u00048F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchArgs;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "d", "Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "a", "()Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "contact", "e", "I", "getBusinessType", "()I", "businessType", "sectionType", "b", "setSectionType", "(I)V", "<init>", "(Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;I)V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class FeedBatchManageSearchArgs implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGuildParcelizeSimpleContact contact;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessType;

    @NotNull
    public static final Parcelable.Creator<FeedBatchManageSearchArgs> CREATOR = new b();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<FeedBatchManageSearchArgs> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FeedBatchManageSearchArgs createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeedBatchManageSearchArgs((IGuildParcelizeSimpleContact) parcel.readParcelable(FeedBatchManageSearchArgs.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FeedBatchManageSearchArgs[] newArray(int i3) {
            return new FeedBatchManageSearchArgs[i3];
        }
    }

    public FeedBatchManageSearchArgs(@NotNull IGuildParcelizeSimpleContact contact, int i3) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        this.contact = contact;
        this.businessType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final IGuildParcelizeSimpleContact getContact() {
        return this.contact;
    }

    public final int b() {
        int i3 = this.businessType;
        if (i3 != 14) {
            if (i3 != 16) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedBatchManageSearchArgs)) {
            return false;
        }
        FeedBatchManageSearchArgs feedBatchManageSearchArgs = (FeedBatchManageSearchArgs) other;
        if (Intrinsics.areEqual(this.contact, feedBatchManageSearchArgs.contact) && this.businessType == feedBatchManageSearchArgs.businessType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.contact.hashCode() * 31) + this.businessType;
    }

    @NotNull
    public String toString() {
        return "FeedBatchManageSearchArgs(contact=" + this.contact + ", businessType=" + this.businessType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.contact, flags);
        parcel.writeInt(this.businessType);
    }
}
