package com.tencent.mobileqq.wink.editor.template;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.template.o;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R&\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000b0 j\b\u0012\u0004\u0012\u00020\u000b`!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/o;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/template/o$b;", "", "textContent", "j0", "Lcom/tencent/mobileqq/wink/editor/template/o$a;", "listener", "", "r0", "", "Lcom/tencent/mobileqq/wink/editor/template/d;", "items", "setItems", "", "position", "p0", "stickerUid", "l0", "index", "k0", "q0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "holder", "m0", "getItemCount", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "textItems", BdhLogUtil.LogTag.Tag_Conn, "I", "selectedIndex", "D", "Lcom/tencent/mobileqq/wink/editor/template/o$a;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "()V", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class o extends RecyclerView.Adapter<b> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private a listener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<d> textItems = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    private int selectedIndex = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/o$a;", "", "", "position", "Lcom/tencent/mobileqq/wink/editor/template/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(int position, @NotNull d item);

        void b(int position, @NotNull d item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/o$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "templateTextTextview", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "l", "()Landroid/widget/FrameLayout;", "templateTextEditBtn", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView templateTextTextview;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final FrameLayout templateTextEditBtn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.f94005b4);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.template_text_textview)");
            this.templateTextTextview = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.f93985b2);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.template_text_edit_btn)");
            this.templateTextEditBtn = (FrameLayout) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final FrameLayout getTemplateTextEditBtn() {
            return this.templateTextEditBtn;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getTemplateTextTextview() {
            return this.templateTextTextview;
        }
    }

    private final String j0(String textContent) {
        String replace$default;
        if (textContent != null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(textContent, "\n", " ", false, 4, (Object) null);
            return replace$default;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(b holder, o this$0, int i3, d item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (holder.getAdapterPosition() != -1) {
            if (this$0.selectedIndex == holder.getAdapterPosition()) {
                a aVar = this$0.listener;
                if (aVar != null) {
                    aVar.b(i3, item);
                }
            } else {
                RecyclerView recyclerView = this$0.recyclerView;
                if (recyclerView != null) {
                    com.tencent.mobileqq.wink.utils.e.i(recyclerView, this$0.selectedIndex, i3);
                }
                this$0.selectedIndex = holder.getAdapterPosition();
                a aVar2 = this$0.listener;
                if (aVar2 != null) {
                    aVar2.a(i3, item);
                }
                this$0.notifyDataSetChanged();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.textItems.size();
    }

    @Nullable
    public final d k0(int index) {
        if (index >= 0 && index < this.textItems.size()) {
            return this.textItems.get(index);
        }
        return null;
    }

    @Nullable
    public final d l0(@NotNull String stickerUid) {
        Intrinsics.checkNotNullParameter(stickerUid, "stickerUid");
        Iterator<d> it = this.textItems.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getStickerUid(), stickerUid)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            return null;
        }
        return this.textItems.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final b holder, final int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.selectedIndex == position) {
            z16 = true;
        } else {
            z16 = false;
        }
        holder.itemView.setSelected(z16);
        d dVar = this.textItems.get(position);
        Intrinsics.checkNotNullExpressionValue(dVar, "textItems[position]");
        final d dVar2 = dVar;
        holder.getTemplateTextTextview().setText(j0(dVar2.getTextContent()));
        if (z16) {
            holder.getTemplateTextEditBtn().setVisibility(0);
            ViewGroup.LayoutParams layoutParams = holder.getTemplateTextTextview().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(com.tencent.videocut.utils.e.f384236a.a(66.0f));
            holder.getTemplateTextTextview().setTextColor(-1);
        } else {
            holder.getTemplateTextEditBtn().setVisibility(4);
            ViewGroup.LayoutParams layoutParams2 = holder.getTemplateTextTextview().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(com.tencent.videocut.utils.e.f384236a.a(18.0f));
            holder.getTemplateTextTextview().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.bfq));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.template.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.n0(o.b.this, this, position, dVar2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heq, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    public final void p0(int position) {
        RecyclerView recyclerView;
        if (position != -1 && (recyclerView = this.recyclerView) != null) {
            com.tencent.mobileqq.wink.utils.e.i(recyclerView, this.selectedIndex, position);
        }
        this.selectedIndex = position;
        notifyDataSetChanged();
    }

    public final void q0(@NotNull String stickerUid) {
        Intrinsics.checkNotNullParameter(stickerUid, "stickerUid");
        Iterator<d> it = this.textItems.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getStickerUid(), stickerUid)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == this.selectedIndex) {
            return;
        }
        p0(i3);
    }

    public final void r0(@Nullable a listener) {
        this.listener = listener;
    }

    public final void setItems(@NotNull List<d> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.selectedIndex = -1;
        this.textItems.clear();
        this.textItems.addAll(items);
        notifyDataSetChanged();
    }
}
