package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent;

import com.tencent.mobileqq.guild.data.s;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "CallFirstDataShowOnScreen", "CallRefreshMsgIntent", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallFirstDataShowOnScreen;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedSectionListPartCallerMsgIntent implements MsgIntent {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallFirstDataShowOnScreen;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class CallFirstDataShowOnScreen extends FeedSectionListPartCallerMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String channelId;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof CallFirstDataShowOnScreen) && Intrinsics.areEqual(this.channelId, ((CallFirstDataShowOnScreen) other).channelId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "CallFirstDataShowOnScreen(channelId=" + this.channelId + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u000b\u0010\u0013R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/data/s;", "d", "Lcom/tencent/mobileqq/guild/data/s;", "a", "()Lcom/tencent/mobileqq/guild/data/s;", "contact", "e", "Z", "b", "()Z", "enableUseCache", "f", "isShowHeadRefresher", h.F, "forceScrollTop", "i", "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", "extendArgs", "<init>", "(Lcom/tencent/mobileqq/guild/data/s;ZZZLjava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class CallRefreshMsgIntent extends FeedSectionListPartCallerMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final s contact;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enableUseCache;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShowHeadRefresher;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean forceScrollTop;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object extendArgs;

        public CallRefreshMsgIntent(@Nullable s sVar, boolean z16, boolean z17, boolean z18, @Nullable Object obj) {
            super(null);
            this.contact = sVar;
            this.enableUseCache = z16;
            this.isShowHeadRefresher = z17;
            this.forceScrollTop = z18;
            this.extendArgs = obj;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final s getContact() {
            return this.contact;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getEnableUseCache() {
            return this.enableUseCache;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Object getExtendArgs() {
            return this.extendArgs;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getForceScrollTop() {
            return this.forceScrollTop;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsShowHeadRefresher() {
            return this.isShowHeadRefresher;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallRefreshMsgIntent)) {
                return false;
            }
            CallRefreshMsgIntent callRefreshMsgIntent = (CallRefreshMsgIntent) other;
            if (Intrinsics.areEqual(this.contact, callRefreshMsgIntent.contact) && this.enableUseCache == callRefreshMsgIntent.enableUseCache && this.isShowHeadRefresher == callRefreshMsgIntent.isShowHeadRefresher && this.forceScrollTop == callRefreshMsgIntent.forceScrollTop && Intrinsics.areEqual(this.extendArgs, callRefreshMsgIntent.extendArgs)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            s sVar = this.contact;
            int i3 = 0;
            if (sVar == null) {
                hashCode = 0;
            } else {
                hashCode = sVar.hashCode();
            }
            int i16 = hashCode * 31;
            boolean z16 = this.enableUseCache;
            int i17 = 1;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            int i19 = (i16 + i18) * 31;
            boolean z17 = this.isShowHeadRefresher;
            int i26 = z17;
            if (z17 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            boolean z18 = this.forceScrollTop;
            if (!z18) {
                i17 = z18 ? 1 : 0;
            }
            int i28 = (i27 + i17) * 31;
            Object obj = this.extendArgs;
            if (obj != null) {
                i3 = obj.hashCode();
            }
            return i28 + i3;
        }

        @NotNull
        public String toString() {
            return "CallRefreshMsgIntent(contact=" + this.contact + ", enableUseCache=" + this.enableUseCache + ", isShowHeadRefresher=" + this.isShowHeadRefresher + ", forceScrollTop=" + this.forceScrollTop + ", extendArgs=" + this.extendArgs + ")";
        }
    }

    public /* synthetic */ FeedSectionListPartCallerMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    FeedSectionListPartCallerMsgIntent() {
    }
}
