package com.tencent.mobileqq.guild.home.views.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&Bw\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u0016\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u001e\u00a2\u0006\u0004\b$\u0010%J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000eR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/dialog/c;", "Landroid/widget/ArrayAdapter;", "", "", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "selectedItem", "", "e", "d", "I", "resource", "", "[Ljava/lang/Integer;", "keys", "f", "[Ljava/lang/String;", "items", "", h.F, "Ljava/util/Map;", "itemReportMap", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "extraDtParams", "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "itemClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I[Ljava/lang/Integer;[Ljava/lang/String;Ljava/util/Map;ILjava/util/Map;Lkotlin/jvm/functions/Function1;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends ArrayAdapter<String> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> itemClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int resource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Integer[] keys;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] items;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Integer> itemReportMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int selectedItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> extraDtParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/dialog/c$a;", "", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "b", "()Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "imageView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
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
    public c(@NotNull Context context, int i3, @NotNull Integer[] keys, @NotNull String[] items, @NotNull Map<Integer, Integer> itemReportMap, int i16, @NotNull Map<String, ? extends Object> extraDtParams, @NotNull Function1<? super Integer, Unit> itemClickListener) {
        super(context, i3, items);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemReportMap, "itemReportMap");
        Intrinsics.checkNotNullParameter(extraDtParams, "extraDtParams");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.resource = i3;
        this.keys = keys;
        this.items = items;
        this.itemReportMap = itemReportMap;
        this.selectedItem = i16;
        this.extraDtParams = extraDtParams;
        this.itemClickListener = itemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.itemClickListener.invoke(Integer.valueOf(i3));
        this$0.e(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map d(c this$0, int i3, String str) {
        int i16;
        Map mapOf;
        Map plus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> map = this$0.extraDtParams;
        Integer num = this$0.itemReportMap.get(this$0.keys[i3]);
        if (num != null) {
            i16 = num.intValue();
        } else {
            i16 = 0;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_sort_type", Integer.valueOf(i16)));
        plus = MapsKt__MapsKt.plus(map, mapOf);
        return plus;
    }

    public final void e(int selectedItem) {
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
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.views.dialog.OptionArrayAdapter.ViewHolder");
            aVar = (a) tag;
            view = convertView;
        }
        aVar.getTextView().setText((CharSequence) getItem(position));
        ImageView imageView = aVar.getImageView();
        if (position != this.selectedItem) {
            i3 = 4;
        }
        imageView.setVisibility(i3);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.c(c.this, position, view2);
            }
        });
        if1.a.b(view, "em_sgrp_sort_panel", null, null, ExposurePolicy.REPORT_NONE, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.home.views.dialog.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map d16;
                d16 = c.d(c.this, position, str);
                return d16;
            }
        }, 118, null);
        View view2 = view;
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view2;
    }
}
