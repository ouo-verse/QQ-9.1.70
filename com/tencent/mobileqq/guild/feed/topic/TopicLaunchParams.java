package com.tencent.mobileqq.guild.feed.topic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B1\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J7\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0011H\u00d6\u0001J\u0019\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b#\u0010\"R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b$\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicLaunchParams;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Landroid/os/Bundle;", "toBundle", "", "component1", "", "component2", "component3", "component4", "topicId", "topicName", "traceId", "guildId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "J", "getTopicId", "()J", "Ljava/lang/String;", "getTopicName", "()Ljava/lang/String;", "getTraceId", "getGuildId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class TopicLaunchParams implements Parcelable, Serializable {

    @Nullable
    private final String guildId;
    private final long topicId;

    @Nullable
    private final String topicName;

    @Nullable
    private final String traceId;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<TopicLaunchParams> CREATOR = new b();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/TopicLaunchParams$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/feed/topic/TopicLaunchParams;", "a", "", "LAUNCH_INTENT_KEY", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.TopicLaunchParams$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final TopicLaunchParams a(@Nullable Bundle bundle) {
            TopicLaunchParams topicLaunchParams;
            if (bundle != null) {
                topicLaunchParams = (TopicLaunchParams) bundle.getParcelable("TopicFusionLaunchIntent");
            } else {
                topicLaunchParams = null;
            }
            if (!(topicLaunchParams instanceof TopicLaunchParams)) {
                return null;
            }
            return topicLaunchParams;
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b implements Parcelable.Creator<TopicLaunchParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final TopicLaunchParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TopicLaunchParams(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final TopicLaunchParams[] newArray(int i3) {
            return new TopicLaunchParams[i3];
        }
    }

    public TopicLaunchParams(long j3, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.topicId = j3;
        this.topicName = str;
        this.traceId = str2;
        this.guildId = str3;
    }

    public static /* synthetic */ TopicLaunchParams copy$default(TopicLaunchParams topicLaunchParams, long j3, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = topicLaunchParams.topicId;
        }
        long j16 = j3;
        if ((i3 & 2) != 0) {
            str = topicLaunchParams.topicName;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = topicLaunchParams.traceId;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            str3 = topicLaunchParams.guildId;
        }
        return topicLaunchParams.copy(j16, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTopicId() {
        return this.topicId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTopicName() {
        return this.topicName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final TopicLaunchParams copy(long topicId, @Nullable String topicName, @Nullable String traceId, @Nullable String guildId) {
        return new TopicLaunchParams(topicId, topicName, traceId, guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopicLaunchParams)) {
            return false;
        }
        TopicLaunchParams topicLaunchParams = (TopicLaunchParams) other;
        if (this.topicId == topicLaunchParams.topicId && Intrinsics.areEqual(this.topicName, topicLaunchParams.topicName) && Intrinsics.areEqual(this.traceId, topicLaunchParams.traceId) && Intrinsics.areEqual(this.guildId, topicLaunchParams.guildId)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getGuildId() {
        return this.guildId;
    }

    public final long getTopicId() {
        return this.topicId;
    }

    @Nullable
    public final String getTopicName() {
        return this.topicName;
    }

    @Nullable
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int a16 = androidx.fragment.app.a.a(this.topicId) * 31;
        String str = this.topicName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        String str2 = this.traceId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.guildId;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public final Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to("TopicFusionLaunchIntent", this));
    }

    @NotNull
    public String toString() {
        return "TopicLaunchParams(topicId=" + this.topicId + ", topicName=" + this.topicName + ", traceId=" + this.traceId + ", guildId=" + this.guildId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.topicId);
        parcel.writeString(this.topicName);
        parcel.writeString(this.traceId);
        parcel.writeString(this.guildId);
    }

    public /* synthetic */ TopicLaunchParams(long j3, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3);
    }
}
