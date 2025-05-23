package com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.Part;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendListPart;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00046789B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lor0/a;", "", "F9", "H9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onThemeChanged", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;", "d", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;", "parentHost", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "e", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "E9", "()Landroidx/recyclerview/widget/RecyclerView;", "categoryRecycleView", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$CategoryItemAdapter;", tl.h.F, "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$CategoryItemAdapter;", "categoryAdapter", "Lhh1/a;", "i", "Lhh1/a;", "decoration", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", "viewModel", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isFromInit", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel$b;", "D", "Landroidx/lifecycle/Observer;", "observer", "<init>", "(Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "E", "CategoryItemAdapter", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRecommendListPart extends Part implements or0.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFromInit;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Observer<GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp> observer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u parentHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IPerformanceReportTask reportTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy categoryRecycleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CategoryItemAdapter categoryAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final hh1.a decoration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRecommendDetailViewModel viewModel;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0010\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000bj\b\u0012\u0004\u0012\u00020\u0005`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$CategoryItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "r0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "", "categorySourceName", "q0", "Landroidx/lifecycle/LiveData;", "l0", "s0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "type", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "getItemCount", "viewHolder", "onBindViewHolder", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$a;", "listener", "p0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "categoryList", "Le12/e;", BdhLogUtil.LogTag.Tag_Conn, "Le12/e;", "selectedItem", "D", "I", "m0", "()I", "t0", "(I)V", "selectedItemPosition", "E", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$a;", "clickListener", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "G", "Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "H", "Lkotlin/Lazy;", "k0", "()Lcom/tencent/mobileqq/guild/api/impl/GuildDTReportApiImpl;", "dtReportApi", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class CategoryItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private a clickListener;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private RecyclerView recyclerView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final Lazy dtReportApi;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<IGProRecommendCategory> categoryList = new ArrayList<>();

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final e12.e<IGProRecommendCategory> selectedItem = new e12.e<>();

        /* renamed from: D, reason: from kotlin metadata */
        private int selectedItemPosition = -1;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private String categorySourceName = "";

        public CategoryItemAdapter() {
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildDTReportApiImpl>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendListPart$CategoryItemAdapter$dtReportApi$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final GuildDTReportApiImpl invoke() {
                    return new GuildDTReportApiImpl();
                }
            });
            this.dtReportApi = lazy;
        }

        private final GuildDTReportApiImpl k0() {
            return (GuildDTReportApiImpl) this.dtReportApi.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean n0(View view, MotionEvent motionEvent) {
            TextView textView = (TextView) view.findViewById(R.id.jfo);
            if (textView != null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_secondary));
                        return false;
                    }
                    return false;
                }
                textView.setTextColor(textView.getResources().getColor(R.color.qui_common_brand_standard));
                return false;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o0(CategoryItemAdapter this$0, RecyclerView.ViewHolder viewHolder, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
            this$0.selectedItemPosition = ((b) viewHolder).getAdapterPosition();
            this$0.selectedItem.setValue(this$0.categoryList.get(i3));
            a aVar = this$0.clickListener;
            if (aVar != null) {
                IGProRecommendCategory iGProRecommendCategory = this$0.categoryList.get(i3);
                Intrinsics.checkNotNullExpressionValue(iGProRecommendCategory, "categoryList[position]");
                aVar.a(i3, iGProRecommendCategory);
            }
            this$0.notifyDataSetChanged();
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void r0(View view, IGProRecommendCategory item, int position) {
            Map<String, Object> mapOf;
            GuildDTReportApiImpl k06 = k0();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_category_type", item.getName()), TuplesKt.to("sgrp_category_source", this.categorySourceName), TuplesKt.to("sgrp_category_place", Integer.valueOf(position)));
            k06.setElementExposureAllAndClickParams(view, "em_sgrp_discover_category_btn", mapOf);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.categoryList.size();
        }

        @NotNull
        public final LiveData<IGProRecommendCategory> l0() {
            return this.selectedItem;
        }

        /* renamed from: m0, reason: from getter */
        public final int getSelectedItemPosition() {
            return this.selectedItemPosition;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onAttachedToRecyclerView(recyclerView);
            this.recyclerView = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder viewHolder, final int position) {
            boolean z16;
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if ((viewHolder instanceof b) && position < this.categoryList.size()) {
                View view = viewHolder.itemView;
                if (position == this.selectedItemPosition) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                view.setSelected(z16);
                Resources resources = view.getResources();
                if (view.isSelected()) {
                    i3 = R.drawable.qui_common_bg_bottom_light_bg;
                } else {
                    i3 = R.drawable.qui_common_bg_bottom_standard_bg;
                }
                view.setBackground(resources.getDrawable(i3));
                TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.jfo);
                if (textView != null) {
                    Resources resources2 = textView.getResources();
                    if (position == this.selectedItemPosition) {
                        i16 = R.color.qui_common_brand_standard;
                    } else {
                        i16 = R.color.qui_common_text_secondary;
                    }
                    textView.setTextColor(resources2.getColor(i16));
                }
                IGProRecommendCategory iGProRecommendCategory = this.categoryList.get(position);
                Intrinsics.checkNotNullExpressionValue(iGProRecommendCategory, "categoryList[position]");
                ((b) viewHolder).l(iGProRecommendCategory);
                viewHolder.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.q
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        boolean n06;
                        n06 = GuildRecommendListPart.CategoryItemAdapter.n0(view2, motionEvent);
                        return n06;
                    }
                });
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        GuildRecommendListPart.CategoryItemAdapter.o0(GuildRecommendListPart.CategoryItemAdapter.this, viewHolder, position, view2);
                    }
                });
                View view2 = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
                IGProRecommendCategory iGProRecommendCategory2 = this.categoryList.get(position);
                Intrinsics.checkNotNullExpressionValue(iGProRecommendCategory2, "categoryList[position]");
                r0(view2, iGProRecommendCategory2, position);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int type) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ehl, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026left_item, parent, false)");
            return new b(inflate);
        }

        public final void p0(@NotNull a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.clickListener = listener;
        }

        public final void q0(@NotNull ArrayList<IGProRecommendCategory> list, @NotNull String categorySourceName) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(categorySourceName, "categorySourceName");
            this.categoryList.clear();
            this.categoryList.addAll(list);
            this.categorySourceName = categorySourceName;
        }

        public final void s0(@NotNull IGProRecommendCategory item, int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            IGProRecommendCategory value = this.selectedItem.getValue();
            boolean z16 = false;
            if (value != null && value.getCategoryId() == item.getCategoryId()) {
                z16 = true;
            }
            if (!z16) {
                this.selectedItem.setValue(item);
            }
            this.selectedItemPosition = position;
        }

        public final void t0(int i3) {
            this.selectedItemPosition = i3;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$a;", "", "", "position", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void a(int position, @NotNull IGProRecommendCategory item);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", "data", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "splitLine", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final View splitLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.jfo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.textView)");
            this.textView = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.j0s);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.split_line)");
            this.splitLine = findViewById2;
        }

        public final void l(@NotNull IGProRecommendCategory data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.textView.setText(data.getName());
            if (this.itemView.isSelected()) {
                this.splitLine.setVisibility(0);
            } else {
                this.splitLine.setVisibility(8);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$d", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendListPart$a;", "", "position", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendListPart.a
        public void a(int position, @NotNull IGProRecommendCategory item) {
            Intrinsics.checkNotNullParameter(item, "item");
            GuildRecommendListPart.this.categoryAdapter.t0(position);
            GuildRecommendListPart.this.E9().invalidateItemDecorations();
        }
    }

    public GuildRecommendListPart(@NotNull u parentHost, @Nullable IPerformanceReportTask iPerformanceReportTask) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(parentHost, "parentHost");
        this.parentHost = parentHost;
        this.reportTask = iPerformanceReportTask;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendListPart$categoryRecycleView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) GuildRecommendListPart.this.getPartRootView().findViewById(R.id.f71353nx);
            }
        });
        this.categoryRecycleView = lazy;
        this.categoryAdapter = new CategoryItemAdapter();
        this.decoration = new hh1.a();
        this.viewModel = parentHost.y7();
        this.isFromInit = true;
        this.observer = new Observer() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecommendListPart.I9(GuildRecommendListPart.this, (GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView E9() {
        return (RecyclerView) this.categoryRecycleView.getValue();
    }

    private final void F9() {
        RecyclerView E9 = E9();
        if (E9 != null) {
            E9.setAdapter(this.categoryAdapter);
            E9.setLayoutManager(new com.tencent.mobileqq.guild.media.widget.audiofaceview.e(E9.getContext()));
        }
        hh1.a aVar = this.decoration;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        aVar.b(context);
        RecyclerView E92 = E9();
        if (E92 != null) {
            E92.addItemDecoration(this.decoration);
        }
        this.categoryAdapter.p0(new d());
        LiveData<IGProRecommendCategory> l06 = this.categoryAdapter.l0();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<IGProRecommendCategory, Unit> function1 = new Function1<IGProRecommendCategory, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendListPart$initGuildCategoryList$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProRecommendCategory iGProRecommendCategory) {
                invoke2(iGProRecommendCategory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IGProRecommendCategory iGProRecommendCategory) {
                boolean z16;
                boolean z17;
                z16 = GuildRecommendListPart.this.isFromInit;
                QLog.d("guild.re.new.GuildRecommendListPart", 4, "isFromInit " + z16);
                z17 = GuildRecommendListPart.this.isFromInit;
                if (z17) {
                    GuildRecommendListPart.this.isFromInit = false;
                } else {
                    GuildRecommendListPart.this.broadcastMessage("SELECT_POSITION", iGProRecommendCategory);
                }
            }
        };
        l06.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecommendListPart.G9(Function1.this, obj);
            }
        });
        H9();
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask != null) {
            qw1.b.k(iPerformanceReportTask, E9(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H9() {
        this.viewModel.getDiscoverRecommendDetailRsp().observe(getPartHost().getLifecycleOwner(), this.observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(GuildRecommendListPart this$0, GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp discoverRecommendDetailRsp) {
        int i3;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i16 = 0;
        if (discoverRecommendDetailRsp.getResult().d()) {
            Intrinsics.checkNotNullExpressionValue(discoverRecommendDetailRsp.getData().getCategories(), "rsp.data.categories");
            if (!r0.isEmpty()) {
                CategoryItemAdapter categoryItemAdapter = this$0.categoryAdapter;
                ArrayList<IGProRecommendCategory> categories = discoverRecommendDetailRsp.getData().getCategories();
                Intrinsics.checkNotNullExpressionValue(categories, "rsp.data.categories");
                categoryItemAdapter.q0(categories, this$0.viewModel.getCategorySourceName());
                ArrayList<IGProRecommendCategory> categories2 = discoverRecommendDetailRsp.getData().getCategories();
                Intrinsics.checkNotNullExpressionValue(categories2, "rsp.data.categories");
                Iterator<IGProRecommendCategory> it = categories2.iterator();
                int i17 = 0;
                while (true) {
                    i3 = -1;
                    if (it.hasNext()) {
                        IGProRecommendCategory next = it.next();
                        if (this$0.viewModel.getCategoryConfId() != 0 && this$0.viewModel.getCategoryConfId() == next.getCategoryConfId()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            break;
                        } else {
                            i17++;
                        }
                    } else {
                        i17 = -1;
                        break;
                    }
                }
                Integer valueOf = Integer.valueOf(i17);
                if (valueOf.intValue() >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    i3 = valueOf.intValue();
                } else {
                    ArrayList<IGProRecommendCategory> categories3 = discoverRecommendDetailRsp.getData().getCategories();
                    Intrinsics.checkNotNullExpressionValue(categories3, "rsp.data.categories");
                    Iterator<IGProRecommendCategory> it5 = categories3.iterator();
                    int i18 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (it5.next().getName().equals(this$0.viewModel.getCategoryName())) {
                            i3 = i18;
                            break;
                        }
                        i18++;
                    }
                }
                if (i3 < 0) {
                    QLog.d("guild.re.new.GuildRecommendListPart", 1, "observe index err " + i3);
                } else {
                    i16 = i3;
                }
                RecyclerView E9 = this$0.E9();
                if (E9 != null) {
                    E9.scrollToPosition(i16);
                }
                CategoryItemAdapter categoryItemAdapter2 = this$0.categoryAdapter;
                IGProRecommendCategory iGProRecommendCategory = discoverRecommendDetailRsp.getData().getCategories().get(i16);
                Intrinsics.checkNotNullExpressionValue(iGProRecommendCategory, "rsp.data.categories[index]");
                categoryItemAdapter2.s0(iGProRecommendCategory, i16);
                this$0.J9();
                return;
            }
            QQToast.makeText(this$0.getContext(), 1, HardCodeUtil.qqStr(R.string.f147430wv), 0).show();
            return;
        }
        QQToast.makeText(this$0.getContext(), 1, HardCodeUtil.qqStr(R.string.f147440ww), 0).show();
    }

    private final void J9() {
        this.viewModel.getDiscoverRecommendDetailRsp().removeObserver(this.observer);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        F9();
        GuildRecommendDetailViewModel.loadData$default(this.viewModel, 0, 0, null, 7, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        QQGuildThemeManager.d(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        QQGuildThemeManager.c(this);
    }

    @Override // or0.a
    public void onThemeChanged() {
        hh1.a aVar = this.decoration;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        aVar.b(context);
        RecyclerView E9 = E9();
        if (E9 != null) {
            E9.invalidateItemDecorations();
        }
        E9().setItemViewCacheSize(0);
        E9().setItemViewCacheSize(2);
        RecyclerView.Adapter adapter = E9().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
