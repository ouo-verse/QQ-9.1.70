package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$m;", "invoke", "()Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$m;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class GuildFeedGalleryCommentPanelPart$halfScreenDismissStartListenerAdapter$2 extends Lambda implements Function0<QUSBaseHalfScreenFloatingView.m> {
    final /* synthetic */ GuildFeedGalleryCommentPanelPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryCommentPanelPart$halfScreenDismissStartListenerAdapter$2(GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart) {
        super(0);
        this.this$0 = guildFeedGalleryCommentPanelPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedGalleryCommentPanelPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("message_comment_panel_animation_ing", Boolean.TRUE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUSBaseHalfScreenFloatingView.m invoke() {
        final GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart = this.this$0;
        return new QUSBaseHalfScreenFloatingView.m() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.q
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.m
            public final void a() {
                GuildFeedGalleryCommentPanelPart$halfScreenDismissStartListenerAdapter$2.b(GuildFeedGalleryCommentPanelPart.this);
            }
        };
    }
}
