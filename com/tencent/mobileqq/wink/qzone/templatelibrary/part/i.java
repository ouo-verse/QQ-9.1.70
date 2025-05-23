package com.tencent.mobileqq.wink.qzone.templatelibrary.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneMagicStudioCategoryView;
import com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView;
import com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryView;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0004 !\"\u0012B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "categoriesData", "", "z9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "categoryRv", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i$a;", "e", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i$a;", "categoryListAdapter", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "f", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "templateViewModel", "<init>", "()V", tl.h.F, "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView categoryRv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a categoryListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel templateViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i$b;", "", "Landroid/view/View;", "data", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "i0", "()Ljava/util/List;", "setChildList", "(Ljava/util/List;)V", "childList", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<b> {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<View> childList = new ArrayList();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.childList.size();
        }

        @NotNull
        public final List<View> i0() {
            return this.childList;
        }

        public final void j0(@NotNull List<? extends View> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.childList.clear();
            this.childList.addAll(data);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.l(this.childList.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i7l, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(itemView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "childView", "", "l", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f124087ie);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026_category_container_root)");
            this.container = (LinearLayout) findViewById;
        }

        public final void l(@NotNull View childView) {
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(childView, "childView");
            ViewParent parent = childView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(childView);
            }
            this.container.removeAllViews();
            this.container.addView(childView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/i$d;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int dpToPx;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildLayoutPosition(view) == 0) {
                dpToPx = ImmersiveUtils.dpToPx(20.0f);
            } else {
                dpToPx = ImmersiveUtils.dpToPx(20.0f) / 2;
            }
            outRect.top = dpToPx;
            outRect.bottom = ImmersiveUtils.dpToPx(20.0f) / 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(i this$0, WinkQZoneTemplateLibViewModel.CategoriesData categories) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(categories, "categories");
        this$0.z9(categories);
    }

    private final void z9(WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
        ArrayList<MetaCategory> arrayList;
        Intent intent;
        Intent intent2;
        ArrayList arrayList2 = new ArrayList();
        int i3 = 2;
        AttributeSet attributeSet = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (categoriesData.getPicGenPicCategory() != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            WinkQZoneMagicStudioCategoryView winkQZoneMagicStudioCategoryView = new WinkQZoneMagicStudioCategoryView(context, attributeSet, i3, b18 == true ? 1 : 0);
            Activity activity = getActivity();
            if (activity != null) {
                intent2 = activity.getIntent();
            } else {
                intent2 = null;
            }
            winkQZoneMagicStudioCategoryView.setData(intent2, categoriesData.getPicGenPicCategory(), categoriesData);
            arrayList2.add(winkQZoneMagicStudioCategoryView);
        }
        MetaCategory templateCategory = categoriesData.getTemplateCategory();
        if (templateCategory != null && (arrayList = templateCategory.subCategories) != null) {
            int i16 = 0;
            for (Object obj : arrayList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MetaCategory metaCategory = (MetaCategory) obj;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                WinkQZoneTemplateCategoryView winkQZoneTemplateCategoryView = new WinkQZoneTemplateCategoryView(context2, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
                Activity activity2 = getActivity();
                if (activity2 != null) {
                    intent = activity2.getIntent();
                } else {
                    intent = null;
                }
                Intrinsics.checkNotNullExpressionValue(metaCategory, "metaCategory");
                winkQZoneTemplateCategoryView.setData(intent, metaCategory, categoriesData);
                arrayList2.add(winkQZoneTemplateCategoryView);
                i16 = i17;
            }
        }
        a aVar = this.categoryListAdapter;
        if (aVar != null) {
            aVar.j0(arrayList2);
        }
        com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.o("inflateData", categoriesData);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkQZoneTemplateCategoryPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RecyclerView recyclerView;
        MutableLiveData<WinkQZoneTemplateLibViewModel.CategoriesData> N1;
        super.onInitView(rootView);
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f124127ii);
        } else {
            recyclerView = null;
        }
        this.categoryRv = recyclerView;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
            this.categoryListAdapter = new a();
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setItemViewCacheSize(5);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.categoryListAdapter);
            recyclerView.addItemDecoration(new d());
        }
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = (WinkQZoneTemplateLibViewModel) getViewModel(WinkQZoneTemplateLibViewModel.class);
        this.templateViewModel = winkQZoneTemplateLibViewModel;
        if (winkQZoneTemplateLibViewModel != null && (N1 = winkQZoneTemplateLibViewModel.N1()) != null) {
            N1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    i.A9(i.this, (WinkQZoneTemplateLibViewModel.CategoriesData) obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        List<View> i06;
        super.onPartDestroy(activity);
        a aVar = this.categoryListAdapter;
        if (aVar != null && (i06 = aVar.i0()) != null) {
            for (View view : i06) {
                if (view instanceof WinkQZoneTemplateCategoryBaseView) {
                    ((WinkQZoneTemplateCategoryBaseView) view).release();
                }
            }
        }
    }
}
