package com.tencent.mobileqq.exportfile.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b!\u0010\"J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/k;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/exportfile/fragment/rootpage/viewmodel/a;", "getDataList", "dataList", "", "updateList", "Landroid/view/ViewGroup;", "p0", "", "p1", "onCreateViewHolder", "onBindViewHolder", "position", "getItemViewType", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", BdhLogUtil.LogTag.Tag_Conn, "I", "headType", "D", "itemType", "Lcom/tencent/mobileqq/exportfile/fragment/k$c;", "E", "Lcom/tencent/mobileqq/exportfile/fragment/k$c;", "getItemClick", "()Lcom/tencent/mobileqq/exportfile/fragment/k$c;", "k0", "(Lcom/tencent/mobileqq/exportfile/fragment/k$c;)V", "itemClick", "<init>", "(Ljava/util/List;)V", "a", "b", "c", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class k extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final int headType;

    /* renamed from: D, reason: from kotlin metadata */
    private final int itemType;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private c itemClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/k$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "textView", "<init>", "(Landroid/widget/TextView;)V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull TextView textView) {
            super(textView);
            Intrinsics.checkNotNullParameter(textView, "textView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView);
                return;
            }
            this.textView = textView;
            textView.setTextSize(14.0f);
            textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_secondary));
            textView.setSingleLine();
            textView.setPadding(24, 6, 16, 6);
        }

        @NotNull
        public final TextView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.textView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/k$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lm53/j;", "E", "Lm53/j;", "l", "()Lm53/j;", "binding", "<init>", "(Lm53/j;)V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final m53.j binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull m53.j binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding);
            } else {
                this.binding = binding;
            }
        }

        @NotNull
        public final m53.j l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (m53.j) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/k$c;", "", "Landroid/view/View;", "view", "", "position", "", "onItemClick", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface c {
        void onItemClick(@NotNull View view, int position);
    }

    public k() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(k this$0, int i3, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a aVar = this$0.dataList.get(i3);
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.DiskItem");
        hashMap.put("folder_type", Integer.valueOf(((com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.c) aVar).c().ordinal()));
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.d("em_bas_folder", "pg_bas_access_computer_folder", hashMap);
        c cVar = this$0.itemClick;
        if (cVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cVar.onItemClick(it, i3);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @NotNull
    public final List<com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a> getDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, position)).intValue();
        }
        if (this.dataList.get(position) instanceof com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.b) {
            return this.headType;
        }
        return this.itemType;
    }

    public final void k0(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.itemClick = cVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder p06, final int p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) p06, p16);
            return;
        }
        Intrinsics.checkNotNullParameter(p06, "p0");
        if (p06 instanceof a) {
            ((a) p06).l().setText(this.dataList.get(p16).a());
            return;
        }
        com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a aVar = this.dataList.get(p16);
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.DiskItem");
        b bVar = (b) p06;
        bVar.l().f416275b.setBackgroundResource(com.tencent.mobileqq.exportfile.global.a.a(((com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.c) aVar).c()));
        bVar.l().f416277d.setText(this.dataList.get(p16).a());
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a aVar2 = this.dataList.get(p16);
        Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.DiskItem");
        hashMap.put("folder_type", Integer.valueOf(((com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.c) aVar2).c().ordinal()));
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.f("em_bas_folder", "pg_bas_access_computer_folder", hashMap);
        bVar.l().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.j0(k.this, p16, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) p06, p16);
        }
        Intrinsics.checkNotNullParameter(p06, "p0");
        if (p16 == this.headType) {
            return new a(new TextView(p06.getContext()));
        }
        m53.j g16 = m53.j.g(LayoutInflater.from(p06.getContext()), p06, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026m(p0.context), p0, false)");
        return new b(g16);
    }

    public final void updateList(@NotNull List<? extends com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a> dataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dataList);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public k(@NotNull List<? extends com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.a> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataList);
            return;
        }
        this.dataList = dataList;
        this.headType = 1;
        this.itemType = 2;
    }

    public /* synthetic */ k(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
