package com.tencent.mobileqq.guild.feed.nativepublish.mediapreview;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetMediaList", "InitMediaList", "OnMediaChanged", "OpenAlbum", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$GetMediaList;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$InitMediaList;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$OnMediaChanged;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$OpenAlbum;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedEditorMediaMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$GetMediaList;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class GetMediaList extends FeedEditorMediaMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetMediaList f222118d = new GetMediaList();

        GetMediaList() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent.GetMediaList";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$InitMediaList;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lfm1/i;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "mediaList", "e", "I", "b", "()I", "unmodifiableMediaSize", "<init>", "(Ljava/util/List;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class InitMediaList extends FeedEditorMediaMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<fm1.i> mediaList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int unmodifiableMediaSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InitMediaList(@NotNull List<? extends fm1.i> mediaList, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            this.mediaList = mediaList;
            this.unmodifiableMediaSize = i3;
        }

        @NotNull
        public final List<fm1.i> a() {
            return this.mediaList;
        }

        /* renamed from: b, reason: from getter */
        public final int getUnmodifiableMediaSize() {
            return this.unmodifiableMediaSize;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitMediaList)) {
                return false;
            }
            InitMediaList initMediaList = (InitMediaList) other;
            if (Intrinsics.areEqual(this.mediaList, initMediaList.mediaList) && this.unmodifiableMediaSize == initMediaList.unmodifiableMediaSize) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent.InitMediaList";
        }

        public int hashCode() {
            return (this.mediaList.hashCode() * 31) + this.unmodifiableMediaSize;
        }

        @NotNull
        public String toString() {
            return "InitMediaList(mediaList=" + this.mediaList + ", unmodifiableMediaSize=" + this.unmodifiableMediaSize + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$OnMediaChanged;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "mediaCount", "e", "Z", "b", "()Z", "thirdPlatform", "f", "c", "thirdShare", "<init>", "(IZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class OnMediaChanged extends FeedEditorMediaMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int mediaCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean thirdPlatform;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean thirdShare;

        public OnMediaChanged(int i3, boolean z16, boolean z17) {
            super(null);
            this.mediaCount = i3;
            this.thirdPlatform = z16;
            this.thirdShare = z17;
        }

        /* renamed from: a, reason: from getter */
        public final int getMediaCount() {
            return this.mediaCount;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getThirdPlatform() {
            return this.thirdPlatform;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getThirdShare() {
            return this.thirdShare;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnMediaChanged)) {
                return false;
            }
            OnMediaChanged onMediaChanged = (OnMediaChanged) other;
            if (this.mediaCount == onMediaChanged.mediaCount && this.thirdPlatform == onMediaChanged.thirdPlatform && this.thirdShare == onMediaChanged.thirdShare) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent.OnMediaChanged";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.mediaCount * 31;
            boolean z16 = this.thirdPlatform;
            int i16 = 1;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i3 + i17) * 31;
            boolean z17 = this.thirdShare;
            if (!z17) {
                i16 = z17 ? 1 : 0;
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            return "OnMediaChanged(mediaCount=" + this.mediaCount + ", thirdPlatform=" + this.thirdPlatform + ", thirdShare=" + this.thirdShare + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$OpenAlbum;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OpenAlbum extends FeedEditorMediaMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OpenAlbum f222124d = new OpenAlbum();

        OpenAlbum() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent.OpenAlbum";
        }
    }

    public /* synthetic */ FeedEditorMediaMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    FeedEditorMediaMsgIntent() {
    }
}
