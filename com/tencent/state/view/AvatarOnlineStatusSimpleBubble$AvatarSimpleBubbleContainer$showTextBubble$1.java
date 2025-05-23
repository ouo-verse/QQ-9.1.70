package com.tencent.state.view;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.view.AvatarOnlineStatusSimpleBubble;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isMe;
    final /* synthetic */ OnlineStatus $status;
    final /* synthetic */ AvatarOnlineStatusSimpleBubble.AvatarSimpleBubbleContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1(AvatarOnlineStatusSimpleBubble.AvatarSimpleBubbleContainer avatarSimpleBubbleContainer, OnlineStatus onlineStatus, boolean z16) {
        super(0);
        this.this$0 = avatarSimpleBubbleContainer;
        this.$status = onlineStatus;
        this.$isMe = z16;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final Drawable iconDrawable = OnlineStatusBubbleViewHelper.INSTANCE.getIconDrawable(this.$status, this.$isMe, new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1$iconDrawable$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable p06) {
                SquareBaseKt.getSquareLog().d("AvatarOnlineStatusSimpleBubble", "onLoadCanceled status:" + AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this.$status);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable p06, Throwable p16) {
                SquareBaseKt.getSquareLog().d("AvatarOnlineStatusSimpleBubble", "onLoadFialed status:" + AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this.$status);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable p06, int p16) {
                SquareBaseKt.getSquareLog().d("AvatarOnlineStatusSimpleBubble", "onLoadProgressed status:" + AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this.$status);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable p06) {
                SquareBaseKt.getSquareLog().d("AvatarOnlineStatusSimpleBubble", "onLoadSuccessed status:" + AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this.$status);
                SimpleBubbleReadyListener listener = AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this.this$0.getListener();
                if (listener != null) {
                    listener.onBubbleStateChange(true);
                }
                AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1 avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1 = AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this;
                avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this$0.updateBubbleIcon(avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.$status, avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.$isMe, p06);
            }
        });
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.view.AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1 avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1 = AvatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this;
                avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.this$0.updateBubbleIcon(avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.$status, avatarOnlineStatusSimpleBubble$AvatarSimpleBubbleContainer$showTextBubble$1.$isMe, iconDrawable);
            }
        });
    }
}
