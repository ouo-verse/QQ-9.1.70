package com.tencent.mobileqq.icgame.widget.chat.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import com.tencent.mobileqq.icgame.widget.chat.message.LiveLocalMsg;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w42.e;
import w42.g;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatMsgWarpView;", "Landroid/widget/LinearLayout;", "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "", "setSupportFunc", "", "roomId", "setRoomId", "a", "Lw42/e;", "msg", "anchorId", "d", "Lcom/tencent/mobileqq/icgame/widget/chat/message/LiveLocalMsg;", "e", "Lw42/g;", "c", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AnchorRoomBulletScreenMsg;", "b", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;", "getMMsgView", "()Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;", "setMMsgView", "(Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;)V", "mMsgView", "J", "getMRoomId", "()J", "setMRoomId", "(J)V", "mRoomId", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatMsgWarpView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChatTextMsgItemView mMsgView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatMsgWarpView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void a() {
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.j();
        }
    }

    public final void b(@NotNull MessageOuterClass$AnchorRoomBulletScreenMsg msg2, long anchorId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.y(msg2, anchorId);
        }
    }

    public final void c(@NotNull g msg2, long anchorId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.B(msg2, anchorId);
        }
    }

    public final void d(@NotNull e msg2, long anchorId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.C(msg2, anchorId);
        }
    }

    public final void e(@NotNull LiveLocalMsg msg2, long anchorId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.D(msg2, anchorId);
        }
    }

    public final void setMMsgView(@Nullable ChatTextMsgItemView chatTextMsgItemView) {
        this.mMsgView = chatTextMsgItemView;
    }

    public final void setMRoomId(long j3) {
        this.mRoomId = j3;
    }

    public final void setRoomId(long roomId) {
        this.mRoomId = roomId;
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.setRoomId(roomId);
        }
    }

    public final void setSupportFunc(@Nullable z42.a dataSupport, @Nullable c playFunc) {
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.setSupportFunc(dataSupport, playFunc);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatMsgWarpView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ChatMsgWarpView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatMsgWarpView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setOrientation(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mMsgView = new ChatTextMsgItemView(context, null, 0, 6, null);
        addView(this.mMsgView, new LinearLayout.LayoutParams(-2, -2));
    }
}
