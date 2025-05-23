package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.chat.data.DressUpBubble;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.chat.message.e;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.mobileqq.qqlive.widget.chat.message.g;
import com.tencent.mobileqq.qqlive.widget.chat.message.i;
import com.tencent.mobileqq.qqlive.widget.chat.util.b;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00109\u001a\u00020\u0006\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0011J\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0011J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00104\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatMsgWarpView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "", "c", "", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "setMargin", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "setSupportFunc", "", "roomId", "setRoomId", "b", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/e;", "anchorId", "f", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/LiveLocalMsg;", "g", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/g;", "e", "Ltrpc/yes/common/MessageOuterClass$AnchorRoomBulletScreenMsg;", "d", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "fontSize", CanvasView.ACTION_SET_FONT_SIZE, "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;", "a", "()Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;", "setMMsgView", "(Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;)V", "mMsgView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getMIconIv", "()Landroid/widget/ImageView;", "setMIconIv", "(Landroid/widget/ImageView;)V", "mIconIv", "J", "getMRoomId", "()J", "setMRoomId", "(J)V", "mRoomId", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ChatMsgWarpView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChatTextMsgItemView mMsgView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mIconIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatMsgWarpView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/itemview/ChatMsgWarpView$b", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$a;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "rightOffset", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements b.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatMsgWarpView.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.util.b.a
        public void a(@Nullable Drawable drawable, int rightOffset) {
            ChatTextMsgItemView a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable, rightOffset);
                return;
            }
            if (drawable != null && (a16 = ChatMsgWarpView.this.a()) != null) {
                a16.setBackgroundDrawable(drawable);
            }
            if (rightOffset > 0) {
                ChatTextMsgItemView a17 = ChatMsgWarpView.this.a();
                Intrinsics.checkNotNull(a17);
                ChatTextMsgItemView a18 = ChatMsgWarpView.this.a();
                Intrinsics.checkNotNull(a18);
                int paddingLeft = a18.getPaddingLeft();
                ChatTextMsgItemView a19 = ChatMsgWarpView.this.a();
                Intrinsics.checkNotNull(a19);
                int paddingTop = a19.getPaddingTop();
                ChatTextMsgItemView a26 = ChatMsgWarpView.this.a();
                Intrinsics.checkNotNull(a26);
                int paddingRight = a26.getPaddingRight() + rightOffset;
                ChatTextMsgItemView a27 = ChatMsgWarpView.this.a();
                Intrinsics.checkNotNull(a27);
                a17.setPadding(paddingLeft, paddingTop, paddingRight, a27.getPaddingBottom());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29582);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatMsgWarpView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) ctx);
    }

    private final void c(f msg2) {
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar;
        pq4.c cVar;
        com.tencent.mobileqq.qqlive.widget.chat.data.a a16;
        if (this.mMsgView == null) {
            return;
        }
        setClipChildren(true);
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        Intrinsics.checkNotNull(chatTextMsgItemView);
        chatTextMsgItemView.setSelfPadding();
        i header = msg2.getHeader();
        DressUpBubble dressUpBubble = null;
        pq4.c cVar2 = null;
        if (header != null && (a16 = header.a()) != null) {
            bVar = a16.f273754a;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            cVar = bVar.f273761f;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            setClipChildren(false);
            com.tencent.mobileqq.qqlive.widget.chat.util.b bVar2 = com.tencent.mobileqq.qqlive.widget.chat.util.b.f273904a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (bVar != null) {
                cVar2 = bVar.f273761f;
            }
            bVar2.g(context, cVar2, new b());
            return;
        }
        if (bVar != null) {
            dressUpBubble = bVar.f273760e;
        }
        if (dressUpBubble != null) {
            if (!TextUtils.isEmpty(bVar.f273760e.decorationUrl) && !bVar.f273760e.disableDecor) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wi2.c.b(28), wi2.c.b(22));
                ChatTextMsgItemView chatTextMsgItemView2 = this.mMsgView;
                Intrinsics.checkNotNull(chatTextMsgItemView2);
                this.mIconIv = new ImageView(chatTextMsgItemView2.getContext());
                layoutParams.leftMargin = wi2.c.b(-21);
                ChatTextMsgItemView chatTextMsgItemView3 = this.mMsgView;
                Intrinsics.checkNotNull(chatTextMsgItemView3);
                ViewGroup.LayoutParams layoutParams2 = chatTextMsgItemView3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.rightMargin = wi2.c.b(7);
                ChatTextMsgItemView chatTextMsgItemView4 = this.mMsgView;
                Intrinsics.checkNotNull(chatTextMsgItemView4);
                chatTextMsgItemView4.setLayoutParams(layoutParams3);
                AegisLogger.INSTANCE.i("Chat_Message|ChatMsgWarpView", "rendFansPrivilege", "rendFansPrivilege qqChatBubble" + bVar.f273760e);
                URLDrawable drawable = URLDrawable.getDrawable(bVar.f273760e.decorationUrl);
                ImageView imageView = this.mIconIv;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                addView(this.mIconIv, layoutParams);
            }
            DressUpBubble dressUpBubble2 = bVar.f273760e;
            GradientDrawable l3 = com.tencent.mobileqq.qqlive.widget.chat.util.b.f273904a.l(dressUpBubble2.bgColorFirst, dressUpBubble2.bgColorSecond, dressUpBubble2.andOrientation);
            if (l3 == null) {
                return;
            }
            ChatTextMsgItemView chatTextMsgItemView5 = this.mMsgView;
            Intrinsics.checkNotNull(chatTextMsgItemView5);
            chatTextMsgItemView5.setBackgroundDrawable(l3);
        }
    }

    @Nullable
    public final ChatTextMsgItemView a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ChatTextMsgItemView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mMsgView;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.k();
        }
    }

    public final void d(@NotNull MessageOuterClass$AnchorRoomBulletScreenMsg msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.C(msg2, anchorId);
        }
        removeView(this.mIconIv);
    }

    public final void e(@NotNull g msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.F(msg2, anchorId);
        }
        removeView(this.mIconIv);
    }

    public final void f(@NotNull e msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.G(msg2, anchorId);
        }
        removeView(this.mIconIv);
        c(msg2);
    }

    public final void g(@NotNull LiveLocalMsg msg2, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, msg2, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.H(msg2, anchorId);
        }
        removeView(this.mIconIv);
    }

    public final void setFontSize(@NotNull FontSize fontSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) fontSize);
            return;
        }
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.setFontSize(fontSize);
        }
    }

    public final void setMIconIv(@Nullable ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) imageView);
        } else {
            this.mIconIv = imageView;
        }
    }

    public final void setMMsgView(@Nullable ChatTextMsgItemView chatTextMsgItemView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) chatTextMsgItemView);
        } else {
            this.mMsgView = chatTextMsgItemView;
        }
    }

    public final void setMRoomId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.mRoomId = j3;
        }
    }

    public final void setMargin(int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(leftMargin), Integer.valueOf(topMargin), Integer.valueOf(rightMargin), Integer.valueOf(bottomMargin));
            return;
        }
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            Intrinsics.checkNotNull(chatTextMsgItemView);
            if (chatTextMsgItemView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ChatTextMsgItemView chatTextMsgItemView2 = this.mMsgView;
                Intrinsics.checkNotNull(chatTextMsgItemView2);
                ViewGroup.LayoutParams layoutParams = chatTextMsgItemView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = leftMargin;
                layoutParams2.rightMargin = rightMargin;
                layoutParams2.topMargin = topMargin;
                layoutParams2.bottomMargin = bottomMargin;
                layoutParams2.gravity = 16;
                ChatTextMsgItemView chatTextMsgItemView3 = this.mMsgView;
                Intrinsics.checkNotNull(chatTextMsgItemView3);
                chatTextMsgItemView3.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void setRoomId(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, roomId);
            return;
        }
        this.mRoomId = roomId;
        ChatTextMsgItemView chatTextMsgItemView = this.mMsgView;
        if (chatTextMsgItemView != null) {
            chatTextMsgItemView.setRoomId(roomId);
        }
    }

    public final void setSupportFunc(@Nullable vi2.a dataSupport, @Nullable vi2.c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) dataSupport, (Object) playFunc);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) ctx, (Object) attributeSet);
    }

    public /* synthetic */ ChatMsgWarpView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatMsgWarpView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, ctx, attributeSet, Integer.valueOf(i3));
            return;
        }
        setOrientation(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mMsgView = new ChatTextMsgItemView(context, null, 0, 6, null);
        addView(this.mMsgView, new LinearLayout.LayoutParams(-2, -2));
    }
}
