package com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "FocusSearchMsgIntent", "OnBindViewAndData", "OnFinishActivityMsgIntent", "RequestFinishActivityMsgIntent", "ShowInputMethod", "TriggerCloseEditorAnyway", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$FocusSearchMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$OnBindViewAndData;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$OnFinishActivityMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$RequestFinishActivityMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$ShowInputMethod;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$TriggerCloseEditorAnyway;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedEditorRootMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$FocusSearchMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent;", "", "d", "Z", "getShowInputMethod", "()Z", "showInputMethod", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class FocusSearchMsgIntent extends FeedEditorRootMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean showInputMethod;

        public FocusSearchMsgIntent(boolean z16) {
            super(null);
            this.showInputMethod = z16;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent.FocusSearchMsgIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$OnBindViewAndData;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OnBindViewAndData extends FeedEditorRootMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnBindViewAndData f222245d = new OnBindViewAndData();

        OnBindViewAndData() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent.OnBindViewAndData";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$OnFinishActivityMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$RequestFinishActivityMsgIntent;", "d", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$RequestFinishActivityMsgIntent;", "getRequest", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$RequestFinishActivityMsgIntent;", Const.BUNDLE_KEY_REQUEST, "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$RequestFinishActivityMsgIntent;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class OnFinishActivityMsgIntent extends FeedEditorRootMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RequestFinishActivityMsgIntent request;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFinishActivityMsgIntent(@NotNull RequestFinishActivityMsgIntent request) {
            super(null);
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent.OnFinishActivityMsgIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$RequestFinishActivityMsgIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent;", "", "d", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "", "e", "Z", "isForce", "()Z", "<init>", "(Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class RequestFinishActivityMsgIntent extends FeedEditorRootMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isForce;

        public /* synthetic */ RequestFinishActivityMsgIntent(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? false : z16);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent.RequestFinishActivityMsgIntent";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestFinishActivityMsgIntent(@NotNull String source, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.isForce = z16;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$ShowInputMethod;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent;", "", "d", "Z", "a", "()Z", "isForceCheckRequired", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ShowInputMethod extends FeedEditorRootMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isForceCheckRequired;

        public ShowInputMethod() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsForceCheckRequired() {
            return this.isForceCheckRequired;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent.ShowInputMethod";
        }

        public ShowInputMethod(boolean z16) {
            super(null);
            this.isForceCheckRequired = z16;
        }

        public /* synthetic */ ShowInputMethod(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$TriggerCloseEditorAnyway;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent;", "", "d", "I", "a", "()I", "source", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class TriggerCloseEditorAnyway extends FeedEditorRootMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int source;

        public TriggerCloseEditorAnyway(int i3) {
            super(null);
            this.source = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getSource() {
            return this.source;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent.TriggerCloseEditorAnyway";
        }
    }

    public /* synthetic */ FeedEditorRootMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    FeedEditorRootMsgIntent() {
    }
}
