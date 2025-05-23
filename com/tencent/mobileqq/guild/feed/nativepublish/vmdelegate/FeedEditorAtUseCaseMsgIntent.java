package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorAtUseCaseMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetAnchorView", "OpenAtPanel", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorAtUseCaseMsgIntent$GetAnchorView;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorAtUseCaseMsgIntent$OpenAtPanel;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedEditorAtUseCaseMsgIntent implements MsgIntent {

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorAtUseCaseMsgIntent$GetAnchorView;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorAtUseCaseMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class GetAnchorView extends FeedEditorAtUseCaseMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetAnchorView f222388d = new GetAnchorView();

        GetAnchorView() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorAtUseCaseMsgIntent.GetAnchorView";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorAtUseCaseMsgIntent$OpenAtPanel;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorAtUseCaseMsgIntent;", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class OpenAtPanel extends FeedEditorAtUseCaseMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OpenAtPanel f222389d = new OpenAtPanel();

        OpenAtPanel() {
            super(null);
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            return "com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorAtUseCaseMsgIntent.OpenAtPanel";
        }
    }

    public /* synthetic */ FeedEditorAtUseCaseMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    FeedEditorAtUseCaseMsgIntent() {
    }
}
