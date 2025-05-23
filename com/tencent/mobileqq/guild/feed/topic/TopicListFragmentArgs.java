package com.tencent.mobileqq.guild.feed.topic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicListFragmentArgs;", "Landroid/os/Parcelable;", "Landroid/os/Bundle;", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "d", "Lcom/tencent/mobileqq/guild/feed/topic/PageData;", "a", "()Lcom/tencent/mobileqq/guild/feed/topic/PageData;", ISchemeApi.KEY_PAGE_DATA, "<init>", "(Lcom/tencent/mobileqq/guild/feed/topic/PageData;)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class TopicListFragmentArgs implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PageData pageData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<TopicListFragmentArgs> CREATOR = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicListFragmentArgs$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/feed/topic/TopicListFragmentArgs;", "a", "", "LAUNCH_INTENT_KEY", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.TopicListFragmentArgs$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final TopicListFragmentArgs a(@Nullable Bundle bundle) {
            TopicListFragmentArgs topicListFragmentArgs;
            if (bundle != null) {
                topicListFragmentArgs = (TopicListFragmentArgs) bundle.getParcelable("TopicListFragmentArgs");
            } else {
                topicListFragmentArgs = null;
            }
            if (!(topicListFragmentArgs instanceof TopicListFragmentArgs)) {
                return null;
            }
            return topicListFragmentArgs;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<TopicListFragmentArgs> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TopicListFragmentArgs createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TopicListFragmentArgs(PageData.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TopicListFragmentArgs[] newArray(int i3) {
            return new TopicListFragmentArgs[i3];
        }
    }

    public TopicListFragmentArgs(@NotNull PageData pageData) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        this.pageData = pageData;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final PageData getPageData() {
        return this.pageData;
    }

    @NotNull
    public final Bundle b() {
        return BundleKt.bundleOf(TuplesKt.to("TopicListFragmentArgs", this));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TopicListFragmentArgs) && Intrinsics.areEqual(this.pageData, ((TopicListFragmentArgs) other).pageData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.pageData.hashCode();
    }

    @NotNull
    public String toString() {
        return "TopicListFragmentArgs(pageData=" + this.pageData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.pageData.writeToParcel(parcel, flags);
    }
}
