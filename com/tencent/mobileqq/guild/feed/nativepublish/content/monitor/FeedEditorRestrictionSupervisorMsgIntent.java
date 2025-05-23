package com.tencent.mobileqq.guild.feed.nativepublish.content.monitor;

import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ContentStatisticChangeMsgIntent", "FetchContentStatisticMsgIntent", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent$ContentStatisticChangeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent$FetchContentStatisticMsgIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedEditorRestrictionSupervisorMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent$ContentStatisticChangeMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$b;", "d", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$b;", "a", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$b;", "supervisorAttachInfo", "e", "Z", "getCanPost", "()Z", "canPost", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$b;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class ContentStatisticChangeMsgIntent extends FeedEditorRestrictionSupervisorMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final FeedEditorRestrictionSupervisorVMDelegate.b supervisorAttachInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean canPost;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentStatisticChangeMsgIntent(@NotNull FeedEditorRestrictionSupervisorVMDelegate.b supervisorAttachInfo, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(supervisorAttachInfo, "supervisorAttachInfo");
            this.supervisorAttachInfo = supervisorAttachInfo;
            this.canPost = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final FeedEditorRestrictionSupervisorVMDelegate.b getSupervisorAttachInfo() {
            return this.supervisorAttachInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContentStatisticChangeMsgIntent)) {
                return false;
            }
            ContentStatisticChangeMsgIntent contentStatisticChangeMsgIntent = (ContentStatisticChangeMsgIntent) other;
            if (Intrinsics.areEqual(this.supervisorAttachInfo, contentStatisticChangeMsgIntent.supervisorAttachInfo) && this.canPost == contentStatisticChangeMsgIntent.canPost) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.supervisorAttachInfo.hashCode() * 31;
            boolean z16 = this.canPost;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "ContentStatisticChangeMsgIntent(supervisorAttachInfo=" + this.supervisorAttachInfo + ", canPost=" + this.canPost + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent$FetchContentStatisticMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class FetchContentStatisticMsgIntent extends FeedEditorRestrictionSupervisorMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final FetchContentStatisticMsgIntent f221805d = new FetchContentStatisticMsgIntent();

        FetchContentStatisticMsgIntent() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent.FetchContentStatisticMsgIntent";
        }
    }

    public /* synthetic */ FeedEditorRestrictionSupervisorMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    FeedEditorRestrictionSupervisorMsgIntent() {
    }
}
