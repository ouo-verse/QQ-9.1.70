package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/HotEventInfo;", "Ljava/io/Serializable;", "id", "", "rank", "", "title", QQWinkConstants.TAB_SUBTITLE, "description", "coverUrl", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoverUrl", "()Ljava/lang/String;", "getDescription", "getId", "getRank", "()I", "getSubTitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HotEventInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String coverUrl;

    @NotNull
    private final String description;

    @NotNull
    private final String id;
    private final int rank;

    @NotNull
    private final String subTitle;

    @NotNull
    private final String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/HotEventInfo$Companion;", "", "()V", "fromIdAndRank", "Lcom/tencent/biz/qqcircle/beans/HotEventInfo;", "id", "", "rank", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final HotEventInfo fromIdAndRank(@NotNull String id5, int rank) {
            Intrinsics.checkNotNullParameter(id5, "id");
            return new HotEventInfo(id5, rank, "", "", "", "");
        }

        Companion() {
        }
    }

    public HotEventInfo(@NotNull String id5, int i3, @NotNull String title, @NotNull String subTitle, @NotNull String description, @NotNull String coverUrl) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        this.id = id5;
        this.rank = i3;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.coverUrl = coverUrl;
    }

    public static /* synthetic */ HotEventInfo copy$default(HotEventInfo hotEventInfo, String str, int i3, String str2, String str3, String str4, String str5, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = hotEventInfo.id;
        }
        if ((i16 & 2) != 0) {
            i3 = hotEventInfo.rank;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            str2 = hotEventInfo.title;
        }
        String str6 = str2;
        if ((i16 & 8) != 0) {
            str3 = hotEventInfo.subTitle;
        }
        String str7 = str3;
        if ((i16 & 16) != 0) {
            str4 = hotEventInfo.description;
        }
        String str8 = str4;
        if ((i16 & 32) != 0) {
            str5 = hotEventInfo.coverUrl;
        }
        return hotEventInfo.copy(str, i17, str6, str7, str8, str5);
    }

    @JvmStatic
    @NotNull
    public static final HotEventInfo fromIdAndRank(@NotNull String str, int i3) {
        return INSTANCE.fromIdAndRank(str, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final HotEventInfo copy(@NotNull String id5, int rank, @NotNull String title, @NotNull String subTitle, @NotNull String description, @NotNull String coverUrl) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        return new HotEventInfo(id5, rank, title, subTitle, description, coverUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HotEventInfo)) {
            return false;
        }
        HotEventInfo hotEventInfo = (HotEventInfo) other;
        if (Intrinsics.areEqual(this.id, hotEventInfo.id) && this.rank == hotEventInfo.rank && Intrinsics.areEqual(this.title, hotEventInfo.title) && Intrinsics.areEqual(this.subTitle, hotEventInfo.subTitle) && Intrinsics.areEqual(this.description, hotEventInfo.description) && Intrinsics.areEqual(this.coverUrl, hotEventInfo.coverUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getRank() {
        return this.rank;
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.rank) * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.description.hashCode()) * 31) + this.coverUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "HotEventInfo(id=" + this.id + ", rank=" + this.rank + ", title=" + this.title + ", subTitle=" + this.subTitle + ", description=" + this.description + ", coverUrl=" + this.coverUrl + ")";
    }
}
