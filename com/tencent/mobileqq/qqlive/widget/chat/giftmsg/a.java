package com.tencent.mobileqq.qqlive.widget.chat.giftmsg;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 @2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003ABCB\u000f\u0012\u0006\u0010-\u001a\u00020(\u00a2\u0006\u0004\b>\u0010?J$\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J8\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J*\u0010&\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u001c\u0010'\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010/R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001e\u0010\u001d\u001a\n <*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010=\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a$c;", "holder", "", "position", "", "msg", "", "m0", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "j0", "l0", "", "roomId", "ownerId", "", "dataList", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "k0", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a$b;", "updateLastItemListener", "i0", "fontSize", "q0", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "p0", "getItemViewType", "getItemCount", "payloads", "o0", "n0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "J", "D", "E", "Ljava/util/List;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a$b;", "G", "Lvi2/a;", "H", "Lvi2/c;", "I", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "currentFontSize", "kotlin.jvm.PlatformType", "Landroid/graphics/Typeface;", "<init>", "(Landroid/content/Context;)V", "K", "a", "b", "c", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends RecyclerView.Adapter<c> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: D, reason: from kotlin metadata */
    private long ownerId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<Object> dataList;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private b updateLastItemListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private vi2.a dataSupport;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private vi2.c playFunc;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private FontSize currentFontSize;

    /* renamed from: J, reason: from kotlin metadata */
    private Typeface typeface;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.a$a, reason: collision with other inner class name and from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a$b;", "", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a;Landroid/view/View;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        final /* synthetic */ a E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) itemView);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27911);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.dataList = new ArrayList();
        this.currentFontSize = FontSize.STANDARD;
        this.typeface = Typeface.DEFAULT;
    }

    private final FontSize j0() {
        vi2.a aVar = this.dataSupport;
        boolean z16 = false;
        if (aVar != null && aVar.b()) {
            z16 = true;
        }
        if (z16) {
            return this.currentFontSize;
        }
        return FontSize.STANDARD;
    }

    private final void l0() {
        FontSize fontSize;
        vi2.a aVar = this.dataSupport;
        boolean z16 = false;
        if (aVar != null && aVar.b()) {
            z16 = true;
        }
        if (z16) {
            fontSize = com.tencent.mobileqq.qqlive.widget.chat.font.a.f273775a.a();
        } else {
            fontSize = FontSize.STANDARD;
        }
        this.currentFontSize = fontSize;
    }

    private final void m0(c holder, int position, Object msg2) {
        b bVar;
        View view = holder.itemView;
        if (view instanceof GiftMsgDetailItemView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView");
            ((GiftMsgDetailItemView) view).setRoomId(this.roomId);
            View view2 = holder.itemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView");
            ((GiftMsgDetailItemView) view2).D0();
            View view3 = holder.itemView;
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView");
            ((GiftMsgDetailItemView) view3).setSupportFunc(this.dataSupport, this.playFunc);
            View view4 = holder.itemView;
            Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView");
            ((GiftMsgDetailItemView) view4).setFontSize(j0());
            View view5 = holder.itemView;
            Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView");
            Typeface typeface = this.typeface;
            Intrinsics.checkNotNullExpressionValue(typeface, "typeface");
            ((GiftMsgDetailItemView) view5).setTypeface(typeface);
        }
        View view6 = holder.itemView;
        if (view6 instanceof GiftMsgDetailItemView) {
            Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.GiftMsgDetailItemView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.message.GiftScreenMsg");
            ((GiftMsgDetailItemView) view6).E0((com.tencent.mobileqq.qqlive.widget.chat.message.d) msg2, this.ownerId);
        }
        if (position == this.dataList.size() - 1 && (bVar = this.updateLastItemListener) != null) {
            bVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, position)).intValue();
        }
        return com.tencent.mobileqq.qqlive.widget.chat.util.a.a(this.dataList.get(position));
    }

    public final void i0(@NotNull b updateLastItemListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) updateLastItemListener);
        } else {
            Intrinsics.checkNotNullParameter(updateLastItemListener, "updateLastItemListener");
            this.updateLastItemListener = updateLastItemListener;
        }
    }

    public final void k0(long roomId, long ownerId, @NotNull List<Object> dataList, @Nullable vi2.a dataSupport, @Nullable vi2.c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Long.valueOf(ownerId), dataList, dataSupport, playFunc);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.roomId = roomId;
        this.ownerId = ownerId;
        this.dataList = dataList;
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
        l0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.dataList.get(position);
        AegisLogger.INSTANCE.d("Chat_Message|GiftMessageAdapter", "onBindViewHolder... itemView:" + holder.itemView + " msg:" + obj);
        m0(holder, position, obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Object obj = this.dataList.get(position);
        AegisLogger.INSTANCE.d("Chat_Message|GiftMessageAdapter", "onBindViewHolder... itemView:" + holder.itemView + " msg:" + obj, "payloads.isEmpty():" + payloads.isEmpty());
        m0(holder, position, obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View chatTextMsgItemView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 5) {
            chatTextMsgItemView = new GiftMsgDetailItemView(this.context, null, 0, 6, null);
        } else {
            chatTextMsgItemView = new ChatTextMsgItemView(this.context, null, 0, 6, null);
        }
        chatTextMsgItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new c(this, chatTextMsgItemView);
    }

    public final void q0(@NotNull FontSize fontSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fontSize);
            return;
        }
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        this.currentFontSize = fontSize;
        notifyDataSetChanged();
    }

    public final void r0(@NotNull Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) typeface);
        } else {
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.typeface = typeface;
        }
    }
}
