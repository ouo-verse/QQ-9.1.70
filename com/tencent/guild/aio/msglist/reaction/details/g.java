package com.tencent.guild.aio.msglist.reaction.details;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0011\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003456B\u0007\u00a2\u0006\u0004\b1\u00102J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u00060\u0005R\u00020\u0000H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003J*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001cJ\u0010\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\b\u0010\"\u001a\u00020\u0003H\u0016J\u001e\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/g;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "i", "Lcom/tencent/guild/aio/msglist/reaction/details/g$c;", "topTabViewHolder", "", "p0", "clickNum", "", "j0", "Landroid/view/ViewGroup;", "viewGroup", "onCreateViewHolder", "viewHolder", "onBindViewHolder", "", "Lcom/tencent/guild/aio/msglist/reaction/details/g$b;", "topTabs", "r0", "serverId", "emojiType", "o0", "position", "n0", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/data/GuildEmojiDetailsData$b;", "Lkotlin/collections/ArrayList;", "emojiDatas", "m0", "Lcom/tencent/guild/aio/msglist/reaction/utils/a;", "tabOnClickListener", "q0", "getItemCount", "emojiId", "finalClickNum", "s0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "k0", "()Ljava/util/List;", BdhLogUtil.LogTag.Tag_Conn, "I", "mOnClickPosition", "D", "Lcom/tencent/guild/aio/msglist/reaction/utils/a;", "mTabOnClickListener", "<init>", "()V", "E", "a", "b", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private int mOnClickPosition;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.msglist.reaction.utils.a mTabOnClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> topTabs = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/g$b;", "", "", "a", "I", "b", "()I", "e", "(I)V", "emojiId", "c", "f", "emojiType", "d", "clickNum", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int emojiId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int emojiType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int clickNum;

        /* renamed from: a, reason: from getter */
        public final int getClickNum() {
            return this.clickNum;
        }

        /* renamed from: b, reason: from getter */
        public final int getEmojiId() {
            return this.emojiId;
        }

        /* renamed from: c, reason: from getter */
        public final int getEmojiType() {
            return this.emojiType;
        }

        public final void d(int i3) {
            this.clickNum = i3;
        }

        public final void e(int i3) {
            this.emojiId = i3;
        }

        public final void f(int i3) {
            this.emojiType = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/details/g$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/LinearLayout;", "setLayout", "(Landroid/widget/LinearLayout;)V", TtmlNode.TAG_LAYOUT, "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "icon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "setClickNum", "(Landroid/widget/TextView;)V", "clickNum", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/guild/aio/msglist/reaction/details/g;Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private LinearLayout layout;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView icon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView clickNum;
        final /* synthetic */ g H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull g gVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = gVar;
            View findViewById = itemView.findViewById(R.id.b9w);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.content_layout)");
            this.layout = (LinearLayout) findViewById;
            View findViewById2 = itemView.findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.icon)");
            this.icon = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f164816ty4);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.click_num)");
            this.clickNum = (TextView) findViewById3;
        }

        @NotNull
        public final ImageView getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getClickNum() {
            return this.clickNum;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final LinearLayout getLayout() {
            return this.layout;
        }
    }

    private final String j0(int clickNum) {
        if (clickNum > 999) {
            return "999+";
        }
        if (clickNum < 0) {
            return "0";
        }
        return String.valueOf(clickNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(int i3, g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("TopTabAdapter", 4, "onClick onClickPosition: ", Integer.valueOf(i3));
        Object systemService = view.getContext().getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(20L);
        this$0.n0(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p0(int i3, c topTabViewHolder) {
        boolean z16;
        LinearLayout layout = topTabViewHolder.getLayout();
        if (this.mOnClickPosition == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        layout.setSelected(z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.topTabs.size();
    }

    @NotNull
    public final List<b> k0() {
        return this.topTabs;
    }

    @Nullable
    public final List<b> m0(@Nullable ArrayList<GuildEmojiDetailsData.b> emojiDatas) {
        if (emojiDatas == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(emojiDatas.size());
        Iterator<GuildEmojiDetailsData.b> it = emojiDatas.iterator();
        while (it.hasNext()) {
            GuildEmojiDetailsData.b next = it.next();
            b bVar = new b();
            bVar.d(next.f216402c);
            bVar.e(next.f216400a);
            bVar.f(next.f216401b);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public final void n0(int position) {
        if (this.mTabOnClickListener != null && position >= 0 && position < this.topTabs.size()) {
            b bVar = this.topTabs.get(position);
            com.tencent.guild.aio.msglist.reaction.utils.a aVar = this.mTabOnClickListener;
            Intrinsics.checkNotNull(aVar);
            aVar.a(position, bVar.getEmojiId(), bVar.getEmojiType());
        }
        this.mOnClickPosition = position;
        notifyDataSetChanged();
    }

    public final void o0(int serverId, int emojiType) {
        int i3;
        Iterator<b> it = this.topTabs.iterator();
        while (it.hasNext()) {
            b next = it.next();
            int b16 = ReactionUtilsKt.b(serverId, emojiType);
            if (next.getEmojiType() == emojiType && next.getEmojiId() == b16) {
                it.remove();
            }
        }
        int size = this.topTabs.size();
        int i16 = this.mOnClickPosition;
        if (size <= i16) {
            i3 = this.topTabs.size() - 1;
        } else if (i16 == 0) {
            i3 = 0;
        } else {
            i3 = i16 - 1;
        }
        if (i3 >= 0) {
            n0(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, final int i3) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (!(viewHolder instanceof c)) {
            return;
        }
        b bVar = this.topTabs.get(i3);
        if (bVar.getEmojiId() >= 0) {
            ((c) viewHolder).getIcon().setImageDrawable(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmojiDrawable(bVar.getEmojiId(), bVar.getEmojiType(), true));
        }
        c cVar = (c) viewHolder;
        cVar.getClickNum().setText(j0(bVar.getClickNum()));
        p0(i3, cVar);
        cVar.getLayout().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.reaction.details.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.l0(i3, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eme, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new c(this, view);
    }

    public final void q0(@Nullable com.tencent.guild.aio.msglist.reaction.utils.a tabOnClickListener) {
        this.mTabOnClickListener = tabOnClickListener;
    }

    public final void r0(@Nullable List<b> topTabs) {
        if (topTabs == null) {
            return;
        }
        this.topTabs.clear();
        this.topTabs.addAll(topTabs);
        notifyDataSetChanged();
    }

    public final void s0(int emojiId, int emojiType, int finalClickNum) {
        int b16 = ReactionUtilsKt.b(emojiId, emojiType);
        if (b16 == -1) {
            return;
        }
        for (b bVar : this.topTabs) {
            if (bVar.getEmojiId() == b16 && bVar.getEmojiType() == emojiType) {
                bVar.d(finalClickNum);
            }
        }
        notifyDataSetChanged();
    }
}
