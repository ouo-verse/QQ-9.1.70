package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterPromotionPanel;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import zf2.PromotionPanelItem;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\t0\u001cj\b\u0012\u0004\u0012\u00020\t`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterPromotionPanel;", "Landroid/widget/LinearLayout;", "", "i", "", "newDisplayMode", "j", tl.h.F, "", "Lzf2/d;", "data", "setDataList", "Landroid/widget/GridView;", "d", "Landroid/widget/GridView;", "gridview", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "arrowView", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "g", "()Lkotlin/jvm/functions/Function1;", "setOnPromotionViewClick", "(Lkotlin/jvm/functions/Function1;)V", "onPromotionViewClick", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "dataList", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntRange;", "displayIndexRange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "curDisplayMode", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageCenterPromotionPanel extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GridView gridview;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView arrowView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1<? super PromotionPanelItem, Unit> onPromotionViewClick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<PromotionPanelItem> dataList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IntRange displayIndexRange;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curDisplayMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCenterPromotionPanel(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<PromotionPanelItem> arrayList = new ArrayList<>();
        this.dataList = arrayList;
        this.displayIndexRange = new IntRange(0, arrayList.size() - 1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.cvm, (ViewGroup) this, true);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(ECRuntimeManager.INSTANCE.b(), false, null);
        setBackground(new ColorDrawable(isNowThemeIsNight ? Color.parseColor("#1A1A1A") : -1));
        View findViewById = findViewById(R.id.ogq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.promotion_panel_grid_view)");
        GridView gridView = (GridView) findViewById;
        this.gridview = gridView;
        gridView.setNumColumns(4);
        this.gridview.setAdapter((ListAdapter) new a(context, isNowThemeIsNight));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterPromotionPanel.c(MessageCenterPromotionPanel.this, view);
            }
        });
        View findViewById2 = findViewById(R.id.ogp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.promotion_panel_arrow_view)");
        ImageView imageView = (ImageView) findViewById2;
        this.arrowView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageCenterPromotionPanel.d(MessageCenterPromotionPanel.this, view);
            }
        });
        this.arrowView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MessageCenterPromotionPanel this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MessageCenterPromotionPanel this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i() {
        if (this.dataList.size() > 4) {
            j(this.curDisplayMode == 1 ? 2 : 1);
        }
    }

    private final void j(int newDisplayMode) {
        int lastIndex;
        int lastIndex2;
        if (this.curDisplayMode == newDisplayMode) {
            return;
        }
        this.curDisplayMode = newDisplayMode;
        this.arrowView.setImageResource(newDisplayMode == 1 ? R.drawable.ew_ : R.drawable.ewa);
        if (newDisplayMode == 1) {
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(this.dataList);
            lastIndex = Math.min(lastIndex2, 3);
        } else {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.dataList);
        }
        this.displayIndexRange = new IntRange(0, lastIndex);
        ViewParent parent = this.gridview.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) parent).setLayoutParams(new LinearLayout.LayoutParams(-1, h(newDisplayMode)));
        ListAdapter adapter = this.gridview.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type android.widget.BaseAdapter");
        ((BaseAdapter) adapter).notifyDataSetChanged();
    }

    public final Function1<PromotionPanelItem, Unit> g() {
        return this.onPromotionViewClick;
    }

    public final void setDataList(List<PromotionPanelItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList.clear();
        this.dataList.addAll(data);
        if (this.dataList.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (data.size() > 4) {
            this.gridview.setNumColumns(4);
            this.arrowView.setVisibility(0);
        } else {
            this.gridview.setNumColumns(data.size());
            this.arrowView.setVisibility(4);
        }
        j(1);
    }

    public final void setOnPromotionViewClick(Function1<? super PromotionPanelItem, Unit> function1) {
        this.onPromotionViewClick = function1;
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterPromotionPanel$a", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "Lzf2/d;", "b", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends BaseAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f263304e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f263305f;

        a(Context context, boolean z16) {
            this.f263304e = context;
            this.f263305f = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MessageCenterPromotionPanel this$0, PromotionPanelItem promotionItem, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(promotionItem, "$promotionItem");
            Function1<PromotionPanelItem, Unit> g16 = this$0.g();
            if (g16 != null) {
                g16.invoke(promotionItem);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PromotionPanelItem getItem(int position) {
            Object obj = MessageCenterPromotionPanel.this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "dataList[position]");
            return (PromotionPanelItem) obj;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int count;
            count = CollectionsKt___CollectionsKt.count(MessageCenterPromotionPanel.this.displayIndexRange);
            return count;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            String iconUrl;
            View view = convertView == null ? LayoutInflater.from(this.f263304e).inflate(R.layout.cvo, parent, false) : convertView;
            final PromotionPanelItem item = getItem(position);
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.ogo);
            if (this.f263305f) {
                iconUrl = item.getNightIconUrl();
            } else {
                iconUrl = item.getIconUrl();
            }
            uRLImageView.setBackgroundURL(iconUrl);
            View findViewById = view.findViewById(R.id.ogr);
            boolean z16 = this.f263305f;
            TextView textView = (TextView) findViewById;
            textView.setText(item.getName());
            textView.setTextColor(z16 ? -1 : -16777216);
            final MessageCenterPromotionPanel messageCenterPromotionPanel = MessageCenterPromotionPanel.this;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MessageCenterPromotionPanel.a.c(MessageCenterPromotionPanel.this, item, view2);
                }
            });
            Intrinsics.checkNotNullExpressionValue(view, "view");
            EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
            return view;
        }
    }

    private final int h(int newDisplayMode) {
        if (newDisplayMode == 2 && this.displayIndexRange.getLast() >= 4) {
            return x.c(getContext(), 188.0f);
        }
        return x.c(getContext(), 106.0f);
    }
}
