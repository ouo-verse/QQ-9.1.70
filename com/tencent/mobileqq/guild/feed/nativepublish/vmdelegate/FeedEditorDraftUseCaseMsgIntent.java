package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalIntent;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnDraftResponseMsgIntent", "OnUserFinishSaveDraftDialogMsgIntent", "QueryLastDraftMsgIntent", "ShowSaveDraftTips", "TriggerSaveDraftMsgIntent", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$OnDraftResponseMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$OnUserFinishSaveDraftDialogMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$QueryLastDraftMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$ShowSaveDraftTips;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$TriggerSaveDraftMsgIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedEditorDraftUseCaseMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001f\u0010\u0010\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$OnDraftResponseMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorDraftModel;", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "a", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "draft", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class OnDraftResponseMsgIntent extends FeedEditorDraftUseCaseMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final GProGuildFeedDraft draft;

        public OnDraftResponseMsgIntent(@Nullable GProGuildFeedDraft gProGuildFeedDraft) {
            super(null);
            this.draft = gProGuildFeedDraft;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final GProGuildFeedDraft getDraft() {
            return this.draft;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnDraftResponseMsgIntent) && Intrinsics.areEqual(this.draft, ((OnDraftResponseMsgIntent) other).draft)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent";
        }

        public int hashCode() {
            GProGuildFeedDraft gProGuildFeedDraft = this.draft;
            if (gProGuildFeedDraft == null) {
                return 0;
            }
            return gProGuildFeedDraft.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnDraftResponseMsgIntent(draft=" + this.draft + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$OnUserFinishSaveDraftDialogMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "token", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward$SaveDraftIntent;", "intent", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward$SaveDraftIntent;", "a", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$Forward$SaveDraftIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class OnUserFinishSaveDraftDialogMsgIntent extends FeedEditorDraftUseCaseMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object token;

        @NotNull
        public final FeedEditorGlobalIntent.Forward.SaveDraftIntent a() {
            return null;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getToken() {
            return this.token;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnUserFinishSaveDraftDialogMsgIntent) && Intrinsics.areEqual(this.token, ((OnUserFinishSaveDraftDialogMsgIntent) other).token) && Intrinsics.areEqual((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.token;
            if (obj != null) {
                obj.hashCode();
            }
            throw null;
        }

        @NotNull
        public String toString() {
            return "OnUserFinishSaveDraftDialogMsgIntent(token=" + this.token + ", intent=" + ((Object) null) + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$QueryLastDraftMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class QueryLastDraftMsgIntent extends FeedEditorDraftUseCaseMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final QueryLastDraftMsgIntent f222392d = new QueryLastDraftMsgIntent();

        QueryLastDraftMsgIntent() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent.QueryLastDraftMsgIntent";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$ShowSaveDraftTips;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getFeedJson", "()Ljava/lang/String;", "feedJson", "e", "Z", "isMuteAndPublish", "()Z", "f", "isEditPublishedFeedDraft", h.F, "getClosePageAfterUserChoosing", "closePageAfterUserChoosing", "i", "Ljava/lang/Object;", "getToken", "()Ljava/lang/Object;", "token", "<init>", "(Ljava/lang/String;ZZZLjava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class ShowSaveDraftTips extends FeedEditorDraftUseCaseMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedJson;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isMuteAndPublish;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isEditPublishedFeedDraft;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean closePageAfterUserChoosing;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSaveDraftTips(@NotNull String feedJson, boolean z16, boolean z17, boolean z18, @Nullable Object obj) {
            super(null);
            Intrinsics.checkNotNullParameter(feedJson, "feedJson");
            this.feedJson = feedJson;
            this.isMuteAndPublish = z16;
            this.isEditPublishedFeedDraft = z17;
            this.closePageAfterUserChoosing = z18;
            this.token = obj;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowSaveDraftTips)) {
                return false;
            }
            ShowSaveDraftTips showSaveDraftTips = (ShowSaveDraftTips) other;
            if (Intrinsics.areEqual(this.feedJson, showSaveDraftTips.feedJson) && this.isMuteAndPublish == showSaveDraftTips.isMuteAndPublish && this.isEditPublishedFeedDraft == showSaveDraftTips.isEditPublishedFeedDraft && this.closePageAfterUserChoosing == showSaveDraftTips.closePageAfterUserChoosing && Intrinsics.areEqual(this.token, showSaveDraftTips.token)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.feedJson.hashCode() * 31;
            boolean z16 = this.isMuteAndPublish;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode2 + i16) * 31;
            boolean z17 = this.isEditPublishedFeedDraft;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            boolean z18 = this.closePageAfterUserChoosing;
            if (!z18) {
                i3 = z18 ? 1 : 0;
            }
            int i26 = (i19 + i3) * 31;
            Object obj = this.token;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return i26 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ShowSaveDraftTips(feedJson=" + this.feedJson + ", isMuteAndPublish=" + this.isMuteAndPublish + ", isEditPublishedFeedDraft=" + this.isEditPublishedFeedDraft + ", closePageAfterUserChoosing=" + this.closePageAfterUserChoosing + ", token=" + this.token + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$TriggerSaveDraftMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class TriggerSaveDraftMsgIntent extends FeedEditorDraftUseCaseMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final TriggerSaveDraftMsgIntent f222398d = new TriggerSaveDraftMsgIntent();

        TriggerSaveDraftMsgIntent() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent, com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent.TriggerSaveDraftMsgIntent";
        }
    }

    public /* synthetic */ FeedEditorDraftUseCaseMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    FeedEditorDraftUseCaseMsgIntent() {
    }
}
