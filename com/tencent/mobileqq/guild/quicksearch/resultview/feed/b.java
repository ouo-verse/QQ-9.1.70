package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quicksearch.model.QuickSearchSortType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bBA\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/b;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mobileqq/guild/quicksearch/model/QuickSearchSortType;", "", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "selectedItem", "", "c", "d", "I", "resource", "e", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "itemClickListener", "Landroid/content/Context;", "context", "", "items", "<init>", "(Landroid/content/Context;I[Lcom/tencent/mobileqq/guild/quicksearch/model/QuickSearchSortType;ILkotlin/jvm/functions/Function1;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends ArrayAdapter<QuickSearchSortType> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int resource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int selectedItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<QuickSearchSortType, Unit> itemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/b$a;", "", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "b", "()Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView imageView;

        public a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.f213700u);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.option_text_view)");
            this.textView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.tvd);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.check_image_view)");
            this.imageView = (ImageView) findViewById2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ImageView getImageView() {
            return this.imageView;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Context context, int i3, @NotNull QuickSearchSortType[] items, int i16, @NotNull Function1<? super QuickSearchSortType, Unit> itemClickListener) {
        super(context, i3, items);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.resource = i3;
        this.selectedItem = i16;
        this.itemClickListener = itemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b this$0, QuickSearchSortType item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.itemClickListener.invoke(item);
        this$0.c(item.getRankType());
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void c(int selectedItem) {
        if (this.selectedItem != selectedItem) {
            this.selectedItem = selectedItem;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        a aVar;
        View view;
        boolean z16;
        Intrinsics.checkNotNullParameter(parent, "parent");
        int i3 = 0;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(this.resource, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "from(parent.context).inf\u2026(resource, parent, false)");
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.quicksearch.resultview.feed.OptionArrayAdapter.ViewHolder");
            aVar = (a) tag;
            view = convertView;
        }
        final QuickSearchSortType quickSearchSortType = (QuickSearchSortType) getItem(position);
        if (quickSearchSortType != null) {
            aVar.getTextView().setText(quickSearchSortType.getSortNameInList());
            ImageView imageView = aVar.getImageView();
            if (quickSearchSortType.getRankType() == this.selectedItem) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.b(b.this, quickSearchSortType, view2);
                }
            });
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view;
    }
}
