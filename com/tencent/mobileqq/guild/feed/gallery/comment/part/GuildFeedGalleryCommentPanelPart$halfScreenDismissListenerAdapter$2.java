package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.feed.gallery.widget.FeedHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "invoke", "()Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentPanelPart$halfScreenDismissListenerAdapter$2 extends Lambda implements Function0<QUSBaseHalfScreenFloatingView.l> {
    final /* synthetic */ GuildFeedGalleryCommentPanelPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryCommentPanelPart$halfScreenDismissListenerAdapter$2(GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart) {
        super(0);
        this.this$0 = guildFeedGalleryCommentPanelPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedGalleryCommentPanelPart this$0) {
        FeedHalfScreenFloatingView feedHalfScreenFloatingView;
        FrameLayout frameLayout;
        boolean la5;
        wk1.i a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onShowCompletely = false;
        feedHalfScreenFloatingView = this$0.halfScreenFloatingView;
        if (feedHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            feedHalfScreenFloatingView = null;
        }
        feedHalfScreenFloatingView.L();
        frameLayout = this$0.containerView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        gk1.b contextProvide = this$0.getContextProvide();
        if (contextProvide != null && (a16 = contextProvide.a()) != null) {
            a16.lh("message_comment_panel_close_event", null);
        }
        this$0.broadcastMessage("message_comment_panel_close_event", null);
        this$0.broadcastMessage("message_comment_panel_animation_ing", Boolean.FALSE);
        la5 = this$0.la();
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryCommentPanelPart", 1, "[onDismiss] isShowing:" + la5);
        this$0.ma();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUSBaseHalfScreenFloatingView.l invoke() {
        final GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart = this.this$0;
        return new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.p
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildFeedGalleryCommentPanelPart$halfScreenDismissListenerAdapter$2.b(GuildFeedGalleryCommentPanelPart.this);
            }
        };
    }
}
