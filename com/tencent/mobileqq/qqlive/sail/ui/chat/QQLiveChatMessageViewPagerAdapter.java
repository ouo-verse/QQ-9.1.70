package com.tencent.mobileqq.qqlive.sail.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.ui.chat.ChatMessagePageData;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.giftmsg.GiftMessageLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vi2.b;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/chat/QQLiveChatMessageViewPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qqlive/sail/ui/chat/QQLiveChatMessageViewPagerAdapter$a;", "", "viewType", "Landroid/view/View;", "i0", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "p0", "holder", "", "o0", "getItemCount", "q0", "Lcom/tencent/mobileqq/qqlive/sail/ui/chat/ChatMessagePageData$Page;", "page", "Landroid/widget/FrameLayout;", "l0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "n0", "()Z", "isAnchor", "", "Lcom/tencent/mobileqq/qqlive/sail/ui/chat/ChatMessagePageData;", "D", "Ljava/util/List;", "m0", "()Ljava/util/List;", "setPageDataList", "(Ljava/util/List;)V", "pageDataList", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout;", "E", "Lkotlin/Lazy;", "j0", "()Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout;", "chatMessageLayout", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout;", UserInfo.SEX_FEMALE, "k0", "()Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout;", "giftMessageLayout", "<init>", "(Landroid/content/Context;Z)V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveChatMessageViewPagerAdapter extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isAnchor;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<ChatMessagePageData> pageDataList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy chatMessageLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy giftMessageLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/chat/QQLiveChatMessageViewPagerAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "", "l", "", "", "E", "[Ljava/lang/String;", NodeProps.COLORS, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final String[] colors;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            } else {
                this.colors = new String[]{"#30CCFF99", "#3041F1E5"};
            }
        }

        public final void l(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
            }
        }
    }

    public QQLiveChatMessageViewPagerAdapter(@NotNull Context context, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        List<ChatMessagePageData> listOf;
        List<ChatMessagePageData> listOf2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        this.isAnchor = z16;
        this.pageDataList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChatMessageLayout>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.chat.QQLiveChatMessageViewPagerAdapter$chatMessageLayout$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessageViewPagerAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChatMessageLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ChatMessageLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ChatMessageLayout chatMessageLayout = new ChatMessageLayout(QQLiveChatMessageViewPagerAdapter.this.getContext(), null, 2, null);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 80;
                chatMessageLayout.setLayoutParams(layoutParams);
                return chatMessageLayout;
            }
        });
        this.chatMessageLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GiftMessageLayout>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.chat.QQLiveChatMessageViewPagerAdapter$giftMessageLayout$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessageViewPagerAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GiftMessageLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (GiftMessageLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                GiftMessageLayout giftMessageLayout = new GiftMessageLayout(QQLiveChatMessageViewPagerAdapter.this.getContext(), null, 2, null);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 80;
                giftMessageLayout.setLayoutParams(layoutParams);
                return giftMessageLayout;
            }
        });
        this.giftMessageLayout = lazy2;
        if (!z16) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new ChatMessagePageData(ChatMessagePageData.Page.ALL_MSG));
            this.pageDataList = listOf;
        } else {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new ChatMessagePageData[]{new ChatMessagePageData(ChatMessagePageData.Page.ALL_MSG), new ChatMessagePageData(ChatMessagePageData.Page.GIFT_MSG)});
            this.pageDataList = listOf2;
        }
    }

    private final View i0(int viewType) {
        if (viewType == ChatMessagePageData.Page.ALL_MSG.getId()) {
            return j0();
        }
        if (viewType == ChatMessagePageData.Page.GIFT_MSG.getId()) {
            return k0();
        }
        return j0();
    }

    private final ChatMessageLayout j0() {
        return (ChatMessageLayout) this.chatMessageLayout.getValue();
    }

    private final GiftMessageLayout k0() {
        return (GiftMessageLayout) this.giftMessageLayout.getValue();
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.pageDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, position)).intValue();
        }
        return this.pageDataList.get(position).a().getId();
    }

    @Nullable
    public final FrameLayout l0(@NotNull ChatMessagePageData.Page page) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 11, (Object) this, (Object) page);
        }
        Intrinsics.checkNotNullParameter(page, "page");
        if (page == ChatMessagePageData.Page.ALL_MSG) {
            return j0();
        }
        if (page == ChatMessagePageData.Page.GIFT_MSG) {
            return k0();
        }
        return null;
    }

    @NotNull
    public final List<ChatMessagePageData> m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.pageDataList;
    }

    public final boolean n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isAnchor;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.l(position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View i06 = i0(viewType);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.h_4, parent, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        frameLayout.addView(i06);
        return new a(frameLayout);
    }

    public final void q0(int position) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, position);
            return;
        }
        int i3 = 0;
        for (Object obj : this.pageDataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ChatMessagePageData chatMessagePageData = (ChatMessagePageData) obj;
            if (position == i3) {
                ViewParent l06 = l0(chatMessagePageData.a());
                if (l06 instanceof b) {
                    bVar = (b) l06;
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    bVar.a0();
                }
            }
            i3 = i16;
        }
    }
}
