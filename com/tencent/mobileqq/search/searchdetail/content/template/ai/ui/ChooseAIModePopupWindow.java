package com.tencent.mobileqq.search.searchdetail.content.template.ai.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow;
import com.tencent.mobileqq.search.searchdetail.multimedia.p;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.kernel.nativeinterface.SearchModelInfo;
import hp2.i;
import java.util.HashMap;
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
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn2.j;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0003;\u0016\u0019B]\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n\u00126\u0010#\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120\u001c\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0012R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aRD\u0010#\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00120\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u001aR\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00108\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow;", "", "", "windowWidth", "Landroid/widget/PopupWindow;", "i", DomainData.DOMAIN_NAME, "o", "Landroid/view/View;", "anchor", "", "", "l", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;", "modeList", "initialSelected", "margin", "", "p", "j", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Ljava/util/Map;", "extraDtParams", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, "model", "c", "Lkotlin/jvm/functions/Function2;", "itemClickListener", "d", "Ljava/util/List;", "e", "Landroid/widget/PopupWindow;", "popupWindow", "Lhp2/i;", "f", "Lhp2/i;", "windowViewBinding", "g", "pageReportInfo", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$AIModeListAdapter;", h.F, "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$AIModeListAdapter;", "arrayAdapter", "Landroidx/constraintlayout/widget/ConstraintLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/constraintlayout/widget/ConstraintLayout;", "popupView", "<init>", "(Landroid/content/Context;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "AIModeListAdapter", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ChooseAIModePopupWindow {

    /* renamed from: k, reason: collision with root package name */
    private static final int f284151k = l.b(8);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> extraDtParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Integer, SearchModelInfo, Unit> itemClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<SearchModelInfo> modeList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i windowViewBinding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, ? extends Object> pageReportInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy arrayAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupView;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!BI\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$AIModeListAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;", "", "selectedItem", "", "c", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "d", "I", "resource", "", "e", "Ljava/util/List;", "items", "f", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$b;", h.F, "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$b;", "reportIOC", "Lkotlin/Function1;", "i", "Lkotlin/jvm/functions/Function1;", "itemClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;ILjava/util/List;ILcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$b;Lkotlin/jvm/functions/Function1;)V", "ViewHolder", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class AIModeListAdapter extends ArrayAdapter<SearchModelInfo> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int resource;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<SearchModelInfo> items;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int selectedItem;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b reportIOC;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<Integer, Unit> itemClickListener;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$AIModeListAdapter$ViewHolder;", "", "", "position", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchModelInfo;", "model", "", "selected", "", "a", "Lhp2/h;", "Lhp2/h;", "c", "()Lhp2/h;", "viewBinding", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$AIModeListAdapter;", "b", "Lmqq/util/WeakReference;", "()Lmqq/util/WeakReference;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Lhp2/h;Lmqq/util/WeakReference;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        private static final class ViewHolder {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final hp2.h viewBinding;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final WeakReference<AIModeListAdapter> parent;

            public ViewHolder(@NotNull hp2.h viewBinding, @NotNull WeakReference<AIModeListAdapter> parent) {
                Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
                Intrinsics.checkNotNullParameter(parent, "parent");
                this.viewBinding = viewBinding;
                this.parent = parent;
            }

            public final void a(final int position, @NotNull final SearchModelInfo model, boolean selected) {
                Intrinsics.checkNotNullParameter(model, "model");
                hp2.h hVar = this.viewBinding;
                hVar.f405668d.setText(model.modelShowName);
                hVar.f405667c.setText(model.modelDesc);
                ImageView checkImageView = hVar.f405666b;
                Intrinsics.checkNotNullExpressionValue(checkImageView, "checkImageView");
                p.b(checkImageView, selected);
                j jVar = j.f431768a;
                ConstraintLayout root = this.viewBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
                j.u(jVar, root, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow$AIModeListAdapter$ViewHolder$bindData$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0014, code lost:
                    
                        r14 = r14.itemClickListener;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(@NotNull View it) {
                        ChooseAIModePopupWindow.b bVar;
                        Function1 function1;
                        Intrinsics.checkNotNullParameter(it, "it");
                        ChooseAIModePopupWindow.AIModeListAdapter aIModeListAdapter = ChooseAIModePopupWindow.AIModeListAdapter.ViewHolder.this.b().get();
                        if (aIModeListAdapter != null && function1 != null) {
                            function1.invoke(Integer.valueOf(position));
                        }
                        ChooseAIModePopupWindow.AIModeListAdapter aIModeListAdapter2 = ChooseAIModePopupWindow.AIModeListAdapter.ViewHolder.this.b().get();
                        if (aIModeListAdapter2 != null) {
                            aIModeListAdapter2.c(position);
                        }
                        HashMap hashMap = new HashMap();
                        SearchModelInfo searchModelInfo = model;
                        int i3 = position;
                        ChooseAIModePopupWindow.AIModeListAdapter.ViewHolder viewHolder = ChooseAIModePopupWindow.AIModeListAdapter.ViewHolder.this;
                        hashMap.put(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, searchModelInfo.modelRealName);
                        hashMap.put("functional_location", Integer.valueOf(i3));
                        hashMap.put("selection_model", searchModelInfo.modelShowName);
                        ChooseAIModePopupWindow.AIModeListAdapter it5 = viewHolder.b().get();
                        if (it5 != null) {
                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                            bVar = it5.reportIOC;
                            hashMap.putAll(bVar.getReportParams());
                        }
                        com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
                        ConstraintLayout root2 = ChooseAIModePopupWindow.AIModeListAdapter.ViewHolder.this.getViewBinding().getRoot();
                        Intrinsics.checkNotNullExpressionValue(root2, "viewBinding.root");
                        com.tencent.mobileqq.search.report.a.b(aVar, "", "em_bas_bot_toggles_model_menu", root2, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_NONE, hashMap, null, 128, null);
                        VideoReport.reportEvent("dt_clck", ChooseAIModePopupWindow.AIModeListAdapter.ViewHolder.this.getViewBinding().getRoot(), hashMap);
                    }
                }, 3, null);
            }

            @NotNull
            public final WeakReference<AIModeListAdapter> b() {
                return this.parent;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final hp2.h getViewBinding() {
                return this.viewBinding;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AIModeListAdapter(@NotNull Context context, int i3, @NotNull List<SearchModelInfo> items, int i16, @NotNull b reportIOC, @NotNull Function1<? super Integer, Unit> itemClickListener) {
            super(context, i3, items);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(reportIOC, "reportIOC");
            Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
            this.resource = i3;
            this.items = items;
            this.selectedItem = i16;
            this.reportIOC = reportIOC;
            this.itemClickListener = itemClickListener;
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
            ViewHolder viewHolder;
            View view;
            Intrinsics.checkNotNullParameter(parent, "parent");
            boolean z16 = false;
            if (convertView == null) {
                hp2.h g16 = hp2.h.g(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
                viewHolder = new ViewHolder(g16, new WeakReference(this));
                view = g16.getRoot();
                Intrinsics.checkNotNullExpressionValue(view, "vBinding.root");
                view.setTag(viewHolder);
            } else {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow.AIModeListAdapter.ViewHolder");
                viewHolder = (ViewHolder) tag;
                view = convertView;
            }
            SearchModelInfo searchModelInfo = this.items.get(position);
            if (position == this.selectedItem) {
                z16 = true;
            }
            viewHolder.a(position, searchModelInfo, z16);
            EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
            return view;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$b;", "", "", "", "getReportParams", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        @NotNull
        Map<String, Object> getReportParams();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChooseAIModePopupWindow(@NotNull Context context, @NotNull Map<String, ? extends Object> extraDtParams, @NotNull Function2<? super Integer, ? super SearchModelInfo, Unit> itemClickListener) {
        Map<String, ? extends Object> emptyMap;
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraDtParams, "extraDtParams");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.context = context;
        this.extraDtParams = extraDtParams;
        this.itemClickListener = itemClickListener;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.pageReportInfo = emptyMap;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIModeListAdapter>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow$arrayAdapter$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$arrayAdapter$2$a", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow$b;", "", "", "", "getReportParams", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes18.dex */
            public static final class a implements ChooseAIModePopupWindow.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ChooseAIModePopupWindow f284168a;

                a(ChooseAIModePopupWindow chooseAIModePopupWindow) {
                    this.f284168a = chooseAIModePopupWindow;
                }

                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow.b
                @NotNull
                public Map<String, Object> getReportParams() {
                    Map<String, Object> map;
                    map = this.f284168a.pageReportInfo;
                    return map;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChooseAIModePopupWindow.AIModeListAdapter invoke() {
                Context context2;
                List list;
                context2 = ChooseAIModePopupWindow.this.context;
                list = ChooseAIModePopupWindow.this.modeList;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("modeList");
                    list = null;
                }
                List list2 = list;
                a aVar = new a(ChooseAIModePopupWindow.this);
                final ChooseAIModePopupWindow chooseAIModePopupWindow = ChooseAIModePopupWindow.this;
                return new ChooseAIModePopupWindow.AIModeListAdapter(context2, R.layout.fnx, list2, -1, aVar, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow$arrayAdapter$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        List list3;
                        Function2 function2;
                        PopupWindow popupWindow;
                        list3 = ChooseAIModePopupWindow.this.modeList;
                        if (list3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("modeList");
                            list3 = null;
                        }
                        SearchModelInfo searchModelInfo = (SearchModelInfo) list3.get(i3);
                        function2 = ChooseAIModePopupWindow.this.itemClickListener;
                        function2.invoke(Integer.valueOf(i3), searchModelInfo);
                        popupWindow = ChooseAIModePopupWindow.this.popupWindow;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        }
                    }
                });
            }
        });
        this.arrayAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow$popupView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConstraintLayout invoke() {
                Context context2;
                int i3;
                ChooseAIModePopupWindow.AIModeListAdapter k3;
                context2 = ChooseAIModePopupWindow.this.context;
                Object systemService = context2.getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                i g16 = i.g((LayoutInflater) systemService);
                final ChooseAIModePopupWindow chooseAIModePopupWindow = ChooseAIModePopupWindow.this;
                RoundFrameLayout roundFrameLayout = g16.f405672d;
                roundFrameLayout.setCorners(15);
                i3 = ChooseAIModePopupWindow.f284151k;
                roundFrameLayout.setRadius(i3);
                if (Build.VERSION.SDK_INT < 28) {
                    roundFrameLayout.setElevation(com.tencent.guild.aio.util.c.b(10));
                }
                ListView listView = g16.f405671c;
                k3 = chooseAIModePopupWindow.k();
                listView.setAdapter((ListAdapter) k3);
                j jVar = j.f431768a;
                ConstraintLayout root = g16.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "root");
                j.u(jVar, root, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow$popupView$2$viewBinding$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        PopupWindow popupWindow;
                        Intrinsics.checkNotNullParameter(it, "it");
                        popupWindow = ChooseAIModePopupWindow.this.popupWindow;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        }
                    }
                }, 3, null);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater).\u2026ow?.dismiss() }\n        }");
                ChooseAIModePopupWindow.this.windowViewBinding = g16;
                return g16.getRoot();
            }
        });
        this.popupView = lazy2;
    }

    private final PopupWindow i(int windowWidth) {
        return new PopupWindow((View) m(), windowWidth, -2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIModeListAdapter k() {
        return (AIModeListAdapter) this.arrayAdapter.getValue();
    }

    private final Map<String, Object> l(View anchor) {
        String str;
        PageInfo pageInfo = VideoReport.getPageInfo(anchor);
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.tencent.mobileqq.search.report.a.f283716a.c(pageInfo));
        HashMap hashMap2 = new HashMap();
        if (pageInfo == null || (str = pageInfo.getPageId()) == null) {
            str = "";
        }
        hashMap2.put("dt_pgid", str);
        hashMap2.put("cur_pg", hashMap);
        hashMap2.putAll(this.extraDtParams);
        return hashMap2;
    }

    private final ConstraintLayout m() {
        return (ConstraintLayout) this.popupView.getValue();
    }

    private final int n() {
        return (-m().getPaddingLeft()) - l.b(16);
    }

    private final int o() {
        int i3;
        ListView listView;
        int paddingTop = m().getPaddingTop();
        i iVar = this.windowViewBinding;
        if (iVar != null && (listView = iVar.f405671c) != null) {
            i3 = listView.getPaddingTop();
        } else {
            i3 = 0;
        }
        return (-(paddingTop + i3)) + l.b(7);
    }

    public final void j() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void p(@NotNull View anchor, @NotNull List<SearchModelInfo> modeList, int initialSelected, int margin) {
        Activity activity;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(modeList, "modeList");
        Context context = anchor.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        int width = activity.getWindow().getDecorView().getWidth() - (margin * 2);
        this.modeList = modeList;
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null) {
            this.popupWindow = i(width);
        } else if (popupWindow != null) {
            popupWindow.setWidth(width);
        }
        VideoReport.setLogicParent(m(), anchor);
        k().c(initialSelected);
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            if (!popupWindow2.isShowing()) {
                popupWindow2.showAsDropDown(anchor, n(), o());
            } else {
                popupWindow2.update(anchor, n(), o(), width, popupWindow2.getHeight());
            }
            this.pageReportInfo = l(anchor);
        }
    }
}
