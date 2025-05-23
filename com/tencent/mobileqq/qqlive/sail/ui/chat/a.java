package com.tencent.mobileqq.qqlive.sail.ui.chat;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.message.QQLiveGiftMessageLayoutManager;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.giftmsg.GiftMessageLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager;
import com.tencent.timi.game.liveroom.impl.util.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ0\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0002J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002J\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010$R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/chat/a;", "", "", "isAnchorLive", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout;", "msgLayout", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout;", "giftLayout", "", "e", "Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager;", "d", "Landroid/content/Context;", "context", "", "roomType", "a", "", "roomId", "", "platform", "anchorUid", "fromFloatWindow", "b", "c", NodeProps.MAX_HEIGHT, "j", "g", "finish", "i", "show", "isLandScape", "k", LightConstants.DowngradeStrategyKey.SMOOTH, h.F, "f", "Z", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager;", "msgLayoutMgr", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout;", "Lcom/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager;", "Lcom/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager;", "giftLayoutMgr", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchorLive;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChatMessageLayout msgLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChatMessageLayoutManager msgLayoutMgr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GiftMessageLayout giftLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveGiftMessageLayoutManager giftLayoutMgr;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Context context, int roomType) {
        ChatMessageLayoutManager chatMessageLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, roomType);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (roomType == 0) {
            chatMessageLayoutManager = new com.tencent.mobileqq.qqlive.room.message.a();
        } else {
            chatMessageLayoutManager = new ChatMessageLayoutManager();
        }
        this.msgLayoutMgr = chatMessageLayoutManager;
        ChatMessageLayout chatMessageLayout = this.msgLayout;
        if (chatMessageLayout != null) {
            chatMessageLayoutManager.Z(chatMessageLayout, context, this.isAnchorLive);
        }
        if (this.isAnchorLive) {
            this.giftLayoutMgr = new QQLiveGiftMessageLayoutManager();
            GiftMessageLayout giftMessageLayout = this.giftLayout;
            if (giftMessageLayout != null) {
                giftMessageLayout.setTypeface(c.h(c.f378976a, "https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf", null, 2, null));
                QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager = this.giftLayoutMgr;
                if (qQLiveGiftMessageLayoutManager != null) {
                    qQLiveGiftMessageLayoutManager.K(giftMessageLayout, context, this.isAnchorLive);
                }
            }
        }
    }

    public final void b(long roomId, @Nullable String platform, long anchorUid, int roomType, boolean fromFloatWindow) {
        QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(roomId), platform, Long.valueOf(anchorUid), Integer.valueOf(roomType), Boolean.valueOf(fromFloatWindow));
            return;
        }
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            chatMessageLayoutManager.A0(roomId, platform);
            chatMessageLayoutManager.w0(roomId, platform, anchorUid, roomType, fromFloatWindow);
        }
        if (this.isAnchorLive && (qQLiveGiftMessageLayoutManager = this.giftLayoutMgr) != null) {
            qQLiveGiftMessageLayoutManager.c0(roomId, platform);
            qQLiveGiftMessageLayoutManager.Z(roomId, anchorUid, roomType, fromFloatWindow);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            chatMessageLayoutManager.s0();
        }
    }

    @Nullable
    public final ChatMessageLayoutManager d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ChatMessageLayoutManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgLayoutMgr;
    }

    public final void e(boolean isAnchorLive, @Nullable ChatMessageLayout msgLayout, @Nullable GiftMessageLayout giftLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isAnchorLive), msgLayout, giftLayout);
            return;
        }
        this.isAnchorLive = isAnchorLive;
        this.msgLayout = msgLayout;
        this.giftLayout = giftLayout;
    }

    public final void f(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, roomId);
            return;
        }
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            chatMessageLayoutManager.x0(roomId);
        }
        ChatMessageLayoutManager chatMessageLayoutManager2 = this.msgLayoutMgr;
        if (chatMessageLayoutManager2 != null) {
            chatMessageLayoutManager2.I0(true);
        }
        if (this.isAnchorLive) {
            QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager = this.giftLayoutMgr;
            if (qQLiveGiftMessageLayoutManager != null) {
                qQLiveGiftMessageLayoutManager.a0(roomId);
            }
            QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager2 = this.giftLayoutMgr;
            if (qQLiveGiftMessageLayoutManager2 != null) {
                qQLiveGiftMessageLayoutManager2.i0(true);
            }
        }
    }

    public final void g() {
        QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            chatMessageLayoutManager.D0();
        }
        if (this.isAnchorLive && (qQLiveGiftMessageLayoutManager = this.giftLayoutMgr) != null) {
            qQLiveGiftMessageLayoutManager.f0();
        }
    }

    public final void h(boolean smooth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, smooth);
            return;
        }
        ChatMessageLayout chatMessageLayout = this.msgLayout;
        if (chatMessageLayout != null) {
            chatMessageLayout.c(smooth);
        }
    }

    public final void i(boolean finish) {
        QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, finish);
            return;
        }
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            chatMessageLayoutManager.I0(finish);
        }
        if (this.isAnchorLive && (qQLiveGiftMessageLayoutManager = this.giftLayoutMgr) != null) {
            qQLiveGiftMessageLayoutManager.i0(finish);
        }
    }

    public final void j(int maxHeight) {
        GiftMessageLayout giftMessageLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, maxHeight);
            return;
        }
        ChatMessageLayout chatMessageLayout = this.msgLayout;
        if (chatMessageLayout != null) {
            chatMessageLayout.setMaxHeight(maxHeight);
        }
        if (this.isAnchorLive && (giftMessageLayout = this.giftLayout) != null) {
            giftMessageLayout.setMaxHeight(maxHeight);
        }
    }

    public final void k(boolean show, boolean isLandScape) {
        QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(show), Boolean.valueOf(isLandScape));
            return;
        }
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            chatMessageLayoutManager.P0(show, isLandScape);
        }
        if (this.isAnchorLive && (qQLiveGiftMessageLayoutManager = this.giftLayoutMgr) != null) {
            qQLiveGiftMessageLayoutManager.j0(show, isLandScape);
        }
    }
}
