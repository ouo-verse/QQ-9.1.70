package com.tencent.mobileqq.guild.feed.nativepublish.mediapreview;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/r;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class r implements com.tencent.mvi.base.route.k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/r$a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lfm1/i;", "a", "Ljava/util/List;", "()Ljava/util/List;", "mediaList", "b", "I", "()I", "unmodifiableMediaCount", "c", "Z", "()Z", "isRemoveGameCenterShareMedia", "<init>", "(Ljava/util/List;IZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.r$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GetMediaListResult extends r {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<fm1.i> mediaList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int unmodifiableMediaCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isRemoveGameCenterShareMedia;

        public /* synthetic */ GetMediaListResult(List list, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, i3, (i16 & 4) != 0 ? false : z16);
        }

        @NotNull
        public final List<fm1.i> a() {
            return this.mediaList;
        }

        /* renamed from: b, reason: from getter */
        public final int getUnmodifiableMediaCount() {
            return this.unmodifiableMediaCount;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsRemoveGameCenterShareMedia() {
            return this.isRemoveGameCenterShareMedia;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetMediaListResult)) {
                return false;
            }
            GetMediaListResult getMediaListResult = (GetMediaListResult) other;
            if (Intrinsics.areEqual(this.mediaList, getMediaListResult.mediaList) && this.unmodifiableMediaCount == getMediaListResult.unmodifiableMediaCount && this.isRemoveGameCenterShareMedia == getMediaListResult.isRemoveGameCenterShareMedia) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.mediaList.hashCode() * 31) + this.unmodifiableMediaCount) * 31;
            boolean z16 = this.isRemoveGameCenterShareMedia;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "GetMediaListResult(mediaList=" + this.mediaList + ", unmodifiableMediaCount=" + this.unmodifiableMediaCount + ", isRemoveGameCenterShareMedia=" + this.isRemoveGameCenterShareMedia + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GetMediaListResult(@NotNull List<? extends fm1.i> mediaList, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            this.mediaList = mediaList;
            this.unmodifiableMediaCount = i3;
            this.isRemoveGameCenterShareMedia = z16;
        }
    }
}
