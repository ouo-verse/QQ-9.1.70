package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import hk1.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$k;", "invoke", "()Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$k;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentPanelPart$halfDialogHeightChangeListener$2 extends Lambda implements Function0<QUSBaseHalfScreenFloatingView.k> {
    final /* synthetic */ GuildFeedGalleryCommentPanelPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryCommentPanelPart$halfDialogHeightChangeListener$2(GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart) {
        super(0);
        this.this$0 = guildFeedGalleryCommentPanelPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedGalleryCommentPanelPart this$0, float f16) {
        boolean z16;
        int oa5;
        wk1.i a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float screenHeight = DisplayUtil.getScreenHeight() - f16;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            screenHeight = 0.0f;
        }
        oa5 = this$0.oa();
        float f17 = screenHeight / oa5;
        gk1.b contextProvide = this$0.getContextProvide();
        if (contextProvide != null && (a16 = contextProvide.a()) != null) {
            a16.lh("message_comment_panel_height_change_even", new a.PanelHeightChangeEventDataArgs(screenHeight, f17));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUSBaseHalfScreenFloatingView.k invoke() {
        final GuildFeedGalleryCommentPanelPart guildFeedGalleryCommentPanelPart = this.this$0;
        return new QUSBaseHalfScreenFloatingView.k() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.o
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.k
            public final void a(float f16) {
                GuildFeedGalleryCommentPanelPart$halfDialogHeightChangeListener$2.b(GuildFeedGalleryCommentPanelPart.this, f16);
            }
        };
    }
}
