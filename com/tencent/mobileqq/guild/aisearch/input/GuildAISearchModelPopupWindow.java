package com.tencent.mobileqq.guild.aisearch.input;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchModelPopupWindow;
import com.tencent.mobileqq.guild.config.GuildAISearchModel;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.util.NumberUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00032\u00020\u0001:\u0002\r\u0012BE\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R#\u0010/\u001a\n +*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchModelPopupWindow;", "", "Landroid/widget/PopupWindow;", "i", "", "anchorX", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "anchor", "initialSelected", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/guild/config/d;", "b", "Ljava/util/List;", "items", "Lkotlin/Function2;", "", "c", "Lkotlin/jvm/functions/Function2;", "itemClickListener", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "dismissListener", "e", "Landroid/widget/PopupWindow;", "popupWindow", "Landroid/widget/ListView;", "f", "Landroid/widget/ListView;", "listView", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchModelPopupWindow$b;", "g", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchModelPopupWindow$b;", "arrayAdapter", "kotlin.jvm.PlatformType", tl.h.F, "l", "()Landroid/view/View;", "popupView", "<init>", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildAISearchModelPopupWindow {

    /* renamed from: j, reason: collision with root package name */
    private static final int f214037j = (int) cw.c(12.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GuildAISearchModel> items;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Integer, String, Unit> itemClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> dismissListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ListView listView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy arrayAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupView;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dBA\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchModelPopupWindow$b;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mobileqq/guild/config/d;", "", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "selectedItem", "", "c", "d", "I", "resource", "", "e", "Ljava/util/List;", "items", "f", "Lkotlin/Function1;", tl.h.F, "Lkotlin/jvm/functions/Function1;", "itemClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ILjava/util/List;ILkotlin/jvm/functions/Function1;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends ArrayAdapter<GuildAISearchModel> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int resource;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<GuildAISearchModel> items;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int selectedItem;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<Integer, Unit> itemClickListener;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchModelPopupWindow$b$a;", "", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "titleView", "b", "descView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        private static final class a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final TextView titleView;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final TextView descView;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final ImageView imageView;

            public a(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                View findViewById = view.findViewById(R.id.sg9);
                Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.ai_search_model_name)");
                this.titleView = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.sg8);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.ai_search_model_desc)");
                this.descView = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.sg7);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ai_search_model_check_view)");
                this.imageView = (ImageView) findViewById3;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final TextView getDescView() {
                return this.descView;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final ImageView getImageView() {
                return this.imageView;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final TextView getTitleView() {
                return this.titleView;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Context context, int i3, @NotNull List<GuildAISearchModel> items, int i16, @NotNull Function1<? super Integer, Unit> itemClickListener) {
            super(context, i3, items);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
            this.resource = i3;
            this.items = items;
            this.selectedItem = i16;
            this.itemClickListener = itemClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(b this$0, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.itemClickListener.invoke(Integer.valueOf(i3));
            this$0.c(i3);
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
        public View getView(final int position, @Nullable View convertView, @NotNull ViewGroup parent) {
            a aVar;
            View view;
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(parent, "parent");
            int i3 = 0;
            if (convertView == null) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(this.resource, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026(resource, parent, false)");
                a aVar2 = new a(inflate);
                inflate.setTag(aVar2);
                view = inflate;
                aVar = aVar2;
            } else {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.aisearch.input.GuildAISearchModelPopupWindow.ModelArrayAdapter.ViewHolder");
                aVar = (a) tag;
                view = convertView;
            }
            TextView titleView = aVar.getTitleView();
            GuildAISearchModel guildAISearchModel = (GuildAISearchModel) getItem(position);
            String str3 = null;
            if (guildAISearchModel != null) {
                str = guildAISearchModel.getModelTitle();
            } else {
                str = null;
            }
            titleView.setText(str);
            TextView descView = aVar.getDescView();
            GuildAISearchModel guildAISearchModel2 = (GuildAISearchModel) getItem(position);
            if (guildAISearchModel2 != null) {
                str2 = guildAISearchModel2.getModelDesc();
            } else {
                str2 = null;
            }
            descView.setText(str2);
            ImageView imageView = aVar.getImageView();
            if (position != this.selectedItem) {
                i3 = 4;
            }
            imageView.setVisibility(i3);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.aisearch.input.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildAISearchModelPopupWindow.b.b(GuildAISearchModelPopupWindow.b.this, position, view2);
                }
            });
            GuildAISearchModel guildAISearchModel3 = (GuildAISearchModel) getItem(position);
            if (guildAISearchModel3 != null) {
                str3 = guildAISearchModel3.getModelType();
            }
            int stringToInt = NumberUtil.stringToInt(str3);
            VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
            HashMap hashMap = new HashMap();
            if (pageInfo != null) {
                Intrinsics.checkNotNullExpressionValue(pageInfo, "pageInfo");
                hashMap.put("dt_pgid", pageInfo.pageId);
                Map<String, Object> map = pageInfo.reportData;
                if (map == null) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                hashMap.put("cur_pg", map);
            }
            hashMap.put("sgrp_ai_model_type", Integer.valueOf(stringToInt));
            if1.a.b(view, "em_sgrp_ai_model_panel", null, hashMap, ExposurePolicy.REPORT_NONE, null, null, null, null, 242, null);
            View view2 = view;
            EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
            return view2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildAISearchModelPopupWindow(@NotNull Context context, @NotNull List<GuildAISearchModel> items, @NotNull Function2<? super Integer, ? super String, Unit> itemClickListener, @NotNull Function0<Unit> dismissListener) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        this.context = context;
        this.items = items;
        this.itemClickListener = itemClickListener;
        this.dismissListener = dismissListener;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.aisearch.input.GuildAISearchModelPopupWindow$arrayAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildAISearchModelPopupWindow.b invoke() {
                Context context2;
                List list;
                context2 = GuildAISearchModelPopupWindow.this.context;
                list = GuildAISearchModelPopupWindow.this.items;
                final GuildAISearchModelPopupWindow guildAISearchModelPopupWindow = GuildAISearchModelPopupWindow.this;
                return new GuildAISearchModelPopupWindow.b(context2, R.layout.f168026ee3, list, -1, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.input.GuildAISearchModelPopupWindow$arrayAdapter$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        List list2;
                        Function2 function2;
                        PopupWindow popupWindow;
                        list2 = GuildAISearchModelPopupWindow.this.items;
                        String modelType = ((GuildAISearchModel) list2.get(i3)).getModelType();
                        function2 = GuildAISearchModelPopupWindow.this.itemClickListener;
                        function2.invoke(Integer.valueOf(i3), modelType);
                        popupWindow = GuildAISearchModelPopupWindow.this.popupWindow;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        }
                    }
                });
            }
        });
        this.arrayAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new GuildAISearchModelPopupWindow$popupView$2(this));
        this.popupView = lazy2;
    }

    private final PopupWindow i() {
        PopupWindow popupWindow = new PopupWindow(l(), -2, -2, true);
        popupWindow.setAnimationStyle(R.style.aw6);
        popupWindow.setInputMethodMode(2);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.guild.aisearch.input.g
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                GuildAISearchModelPopupWindow.j(GuildAISearchModelPopupWindow.this);
            }
        });
        return popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildAISearchModelPopupWindow this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissListener.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b k() {
        return (b) this.arrayAdapter.getValue();
    }

    private final View l() {
        return (View) this.popupView.getValue();
    }

    private final void n(int anchorX) {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(cw.d(12));
        Iterator<T> it = this.items.iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            f16 = Math.max(f16, textPaint.measureText(((GuildAISearchModel) it.next()).getModelDesc()));
        }
        int dpToPx = ViewUtils.dpToPx(14.0f) * 2;
        int dpToPx2 = ViewUtils.dpToPx(18.0f);
        int dpToPx3 = ViewUtils.dpToPx(16.0f);
        int i3 = dpToPx + dpToPx2 + dpToPx3 + ((int) f16);
        int screenWidth = (((ViewUtils.getScreenWidth() - anchorX) - l().getPaddingLeft()) - l().getPaddingRight()) - dpToPx3;
        ListView listView = this.listView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.width = Math.min(i3, screenWidth);
        listView.setLayoutParams(layoutParams);
    }

    public final void m(@NotNull View anchor, int initialSelected) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow == null) {
            this.popupWindow = i();
        }
        k().c(initialSelected);
        int dip2px = ViewUtils.dip2px(20.0f);
        int dip2px2 = ViewUtils.dip2px(12.0f);
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = i3 + dip2px2;
        if (i16 < dip2px) {
            View popupView = l();
            Intrinsics.checkNotNullExpressionValue(popupView, "popupView");
            ViewExtKt.d(popupView, i16);
        } else {
            View popupView2 = l();
            Intrinsics.checkNotNullExpressionValue(popupView2, "popupView");
            ViewExtKt.d(popupView2, dip2px);
        }
        int paddingLeft = dip2px2 - l().getPaddingLeft();
        int height = anchor.getHeight();
        int dip2px3 = ((((-height) - dip2px) + ViewUtils.dip2px(4.0f)) - (this.items.size() * ViewUtils.dip2px(64.0f))) - ((this.items.size() - 1) * ViewUtils.dip2px(0.5f));
        n(i3);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            if (!popupWindow.isShowing()) {
                popupWindow.showAsDropDown(anchor, paddingLeft, dip2px3);
            } else {
                popupWindow.update(anchor, paddingLeft, dip2px3, popupWindow.getWidth(), popupWindow.getHeight());
            }
        }
    }
}
