package com.tencent.qqnt.emotion.emoreply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0011\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003./0B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u00060\u0005R\u00020\u0000H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0003J*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019J\u0010\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/n;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "i", "Lcom/tencent/qqnt/emotion/emoreply/n$c;", "topTabViewHolder", "", "o0", "clickNum", "", "j0", "Landroid/view/ViewGroup;", "viewGroup", "onCreateViewHolder", "viewHolder", "onBindViewHolder", "", "Lcom/tencent/qqnt/emotion/emoreply/n$b;", "topTabs", "q0", "position", "n0", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/emoreply/i;", "Lkotlin/collections/ArrayList;", "emojiDatas", "m0", "Lcom/tencent/qqnt/emotion/emoreply/l;", "tabOnClickListener", "p0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "k0", "()Ljava/util/List;", BdhLogUtil.LogTag.Tag_Conn, "I", "mOnClickPosition", "D", "Lcom/tencent/qqnt/emotion/emoreply/l;", "mTabOnClickListener", "<init>", "()V", "E", "a", "b", "c", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class n extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mOnClickPosition;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private l mTabOnClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> topTabs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.emoreply.n$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/n$b;", "", "", "a", "I", "b", "()I", "e", "(I)V", "emojiId", "c", "f", "emojiType", "d", "clickNum", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int emojiId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int emojiType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int clickNum;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.clickNum;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.emojiId;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.emojiType;
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.clickNum = i3;
            }
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.emojiId = i3;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.emojiType = i3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/n$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/LinearLayout;", "setLayout", "(Landroid/widget/LinearLayout;)V", TtmlNode.TAG_LAYOUT, "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "icon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "setClickNum", "(Landroid/widget/TextView;)V", "clickNum", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/qqnt/emotion/emoreply/n;Landroid/view/View;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private LinearLayout layout;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView icon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView clickNum;
        final /* synthetic */ n H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull n nVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nVar, (Object) itemView);
                return;
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.icon;
        }

        @NotNull
        public final TextView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.clickNum;
        }

        @NotNull
        public final LinearLayout m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LinearLayout) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.layout;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.topTabs = new ArrayList();
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
    public static final void l0(int i3, n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("TopTabAdapter", 4, "onClick onClickPosition: ", Integer.valueOf(i3));
        this$0.n0(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0(int i3, c topTabViewHolder) {
        boolean z16;
        LinearLayout m3 = topTabViewHolder.m();
        if (this.mOnClickPosition == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        m3.setSelected(z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.topTabs.size();
    }

    @NotNull
    public final List<b> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.topTabs;
    }

    @Nullable
    public final List<b> m0(@Nullable ArrayList<com.tencent.qqnt.aio.emoreply.i> emojiDatas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) emojiDatas);
        }
        if (emojiDatas == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(emojiDatas.size());
        Iterator<com.tencent.qqnt.aio.emoreply.i> it = emojiDatas.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.aio.emoreply.i next = it.next();
            b bVar = new b();
            bVar.d(next.a());
            bVar.e(next.b());
            bVar.f(next.c());
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public final void n0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, position);
            return;
        }
        if (this.mTabOnClickListener != null && position >= 0 && position < this.topTabs.size()) {
            b bVar = this.topTabs.get(position);
            l lVar = this.mTabOnClickListener;
            Intrinsics.checkNotNull(lVar);
            lVar.a(position, bVar.b(), bVar.c());
        }
        this.mOnClickPosition = position;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, i3);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (!(viewHolder instanceof c)) {
            return;
        }
        b bVar = this.topTabs.get(i3);
        if (bVar.b() >= 0) {
            ((c) viewHolder).getIcon().setImageDrawable(((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).getEmojiDrawable(bVar.b(), bVar.c(), true));
        }
        c cVar = (c) viewHolder;
        cVar.getIcon().setImportantForAccessibility(2);
        cVar.l().setText(j0(bVar.a()));
        cVar.l().setImportantForAccessibility(2);
        o0(i3, cVar);
        cVar.m().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.emotion.emoreply.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.l0(i3, this, view);
            }
        });
        cVar.m().setFocusable(true);
        cVar.m().setImportantForAccessibility(1);
        AccessibilityUtil.p(cVar.m(), h.b(bVar.b(), bVar.c()) + HardCodeUtil.qqStr(R.string.zui) + bVar.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167592dv0, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new c(this, view);
    }

    public final void p0(@Nullable l tabOnClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tabOnClickListener);
        } else {
            this.mTabOnClickListener = tabOnClickListener;
        }
    }

    public final void q0(@Nullable List<b> topTabs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) topTabs);
        } else {
            if (topTabs == null) {
                return;
            }
            this.topTabs.clear();
            this.topTabs.addAll(topTabs);
            notifyDataSetChanged();
        }
    }
}
