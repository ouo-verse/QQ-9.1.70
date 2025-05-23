package com.tencent.mobileqq.guild.feed.nativepublish.content;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.video.i;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u000b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "FetchMediaUploadTasks", "InsertTencentDocEvent", "InsertThirdPartyVideoEvent", "MakeJsonForDraft", "MakeJsonForPost", "MakeJsonForSwitchToH5", "OnTriggerPublishEvent", "TriggerMediasCancelUpload", "TriggerMediasModify", "TriggerMediasRestore", "TriggerMediasUpload", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$FetchMediaUploadTasks;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$InsertTencentDocEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$InsertThirdPartyVideoEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$MakeJsonForDraft;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$MakeJsonForPost;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$MakeJsonForSwitchToH5;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$OnTriggerPublishEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasCancelUpload;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasModify;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasRestore;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasUpload;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedEditorContentMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$FetchMediaUploadTasks;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class FetchMediaUploadTasks extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final FetchMediaUploadTasks f221790d = new FetchMediaUploadTasks();

        FetchMediaUploadTasks() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.FetchMediaUploadTasks";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$InsertTencentDocEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "docUrl", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTencentDocsRsp;", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTencentDocsRsp;", "b", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTencentDocsRsp;", QCircleScheme.AttrDetail.VIDEO_INFO, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class InsertTencentDocEvent extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String docUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IGProTencentDocsRsp videoInfo;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getDocUrl() {
            return this.docUrl;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final IGProTencentDocsRsp getVideoInfo() {
            return this.videoInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InsertTencentDocEvent)) {
                return false;
            }
            InsertTencentDocEvent insertTencentDocEvent = (InsertTencentDocEvent) other;
            if (Intrinsics.areEqual(this.docUrl, insertTencentDocEvent.docUrl) && Intrinsics.areEqual(this.videoInfo, insertTencentDocEvent.videoInfo)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.InsertTencentDocEvent";
        }

        public int hashCode() {
            return (this.docUrl.hashCode() * 31) + this.videoInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "InsertTencentDocEvent(docUrl=" + this.docUrl + ", videoInfo=" + this.videoInfo + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$InsertThirdPartyVideoEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/video/i;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/tencent/mobileqq/guild/feed/video/i;", "a", "()Lcom/tencent/mobileqq/guild/feed/video/i;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class InsertThirdPartyVideoEvent extends FeedEditorContentMsgIntent {
        @NotNull
        public final i a() {
            return null;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InsertThirdPartyVideoEvent)) {
                return false;
            }
            ((InsertThirdPartyVideoEvent) other).getClass();
            if (Intrinsics.areEqual((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.InsertThirdPartyVideoEvent";
        }

        public int hashCode() {
            throw null;
        }

        @NotNull
        public String toString() {
            return "InsertThirdPartyVideoEvent(videoInfo=" + ((Object) null) + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$MakeJsonForDraft;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class MakeJsonForDraft extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MakeJsonForDraft f221793d = new MakeJsonForDraft();

        MakeJsonForDraft() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.MakeJsonForDraft";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$MakeJsonForPost;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class MakeJsonForPost extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MakeJsonForPost f221794d = new MakeJsonForPost();

        MakeJsonForPost() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.MakeJsonForPost";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$MakeJsonForSwitchToH5;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class MakeJsonForSwitchToH5 extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final MakeJsonForSwitchToH5 f221795d = new MakeJsonForSwitchToH5();

        MakeJsonForSwitchToH5() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.MakeJsonForSwitchToH5";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$OnTriggerPublishEvent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OnTriggerPublishEvent extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnTriggerPublishEvent f221796d = new OnTriggerPublishEvent();

        OnTriggerPublishEvent() {
            super(null);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasCancelUpload;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "canceledTaskMap", "<init>", "(Ljava/util/Set;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class TriggerMediasCancelUpload extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Set<String> canceledTaskMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TriggerMediasCancelUpload(@NotNull Set<String> canceledTaskMap) {
            super(null);
            Intrinsics.checkNotNullParameter(canceledTaskMap, "canceledTaskMap");
            this.canceledTaskMap = canceledTaskMap;
        }

        @NotNull
        public final Set<String> a() {
            return this.canceledTaskMap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof TriggerMediasCancelUpload) && Intrinsics.areEqual(this.canceledTaskMap, ((TriggerMediasCancelUpload) other).canceledTaskMap)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasCancelUpload";
        }

        public int hashCode() {
            return this.canceledTaskMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "TriggerMediasCancelUpload(canceledTaskMap=" + this.canceledTaskMap + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasModify;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorLocalMediaModel;", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "newTaskMap", "", "e", "Ljava/util/Set;", "b", "()Ljava/util/Set;", "removedTaskIds", "<init>", "(Ljava/util/Map;Ljava/util/Set;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class TriggerMediasModify extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, LocalMediaInfo> newTaskMap;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Set<String> removedTaskIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TriggerMediasModify(@NotNull Map<String, ? extends LocalMediaInfo> newTaskMap, @NotNull Set<String> removedTaskIds) {
            super(null);
            Intrinsics.checkNotNullParameter(newTaskMap, "newTaskMap");
            Intrinsics.checkNotNullParameter(removedTaskIds, "removedTaskIds");
            this.newTaskMap = newTaskMap;
            this.removedTaskIds = removedTaskIds;
        }

        @NotNull
        public final Map<String, LocalMediaInfo> a() {
            return this.newTaskMap;
        }

        @NotNull
        public final Set<String> b() {
            return this.removedTaskIds;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TriggerMediasModify)) {
                return false;
            }
            TriggerMediasModify triggerMediasModify = (TriggerMediasModify) other;
            if (Intrinsics.areEqual(this.newTaskMap, triggerMediasModify.newTaskMap) && Intrinsics.areEqual(this.removedTaskIds, triggerMediasModify.removedTaskIds)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasModify";
        }

        public int hashCode() {
            return (this.newTaskMap.hashCode() * 31) + this.removedTaskIds.hashCode();
        }

        @NotNull
        public String toString() {
            return "TriggerMediasModify(newTaskMap=" + this.newTaskMap.keySet() + ", removedTaskIds=" + this.removedTaskIds + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasRestore;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/publish/api/QQAlbumMediumModel;", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "queryMap", "<init>", "(Ljava/util/Map;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class TriggerMediasRestore extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, LocalMediaInfo> queryMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TriggerMediasRestore(@NotNull Map<String, ? extends LocalMediaInfo> queryMap) {
            super(null);
            Intrinsics.checkNotNullParameter(queryMap, "queryMap");
            this.queryMap = queryMap;
        }

        @NotNull
        public final Map<String, LocalMediaInfo> a() {
            return this.queryMap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof TriggerMediasRestore) && Intrinsics.areEqual(this.queryMap, ((TriggerMediasRestore) other).queryMap)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasRestore";
        }

        public int hashCode() {
            return this.queryMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "TriggerMediasRestore(queryMap.size=" + this.queryMap.size() + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u000fB\u001f\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent$TriggerMediasUpload;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/FeedEditorContentMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorLocalMediaModel;", "d", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "taskMap", "<init>", "(Ljava/util/Map;)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    @AutoEventName
    /* loaded from: classes13.dex */
    public static final /* data */ class TriggerMediasUpload extends FeedEditorContentMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, LocalMediaInfo> taskMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TriggerMediasUpload(@NotNull Map<String, ? extends LocalMediaInfo> taskMap) {
            super(null);
            Intrinsics.checkNotNullParameter(taskMap, "taskMap");
            this.taskMap = taskMap;
        }

        @NotNull
        public final Map<String, LocalMediaInfo> a() {
            return this.taskMap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof TriggerMediasUpload) && Intrinsics.areEqual(this.taskMap, ((TriggerMediasUpload) other).taskMap)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.TriggerMediasUpload";
        }

        public int hashCode() {
            return this.taskMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "TriggerMediasUpload(taskMap=" + this.taskMap.keySet() + ")";
        }
    }

    public /* synthetic */ FeedEditorContentMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    FeedEditorContentMsgIntent() {
    }
}
