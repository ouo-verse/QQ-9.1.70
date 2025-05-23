package com.tencent.mobileqq.wink.inspirationlibrary.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.event.FavoriteMaterialEvent;
import com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationTemplateUtils;
import com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationTemplateCategoryView;
import com.tencent.mobileqq.wink.inspirationlibrary.part.view.WinkInspirationViewPager;
import com.tencent.mobileqq.wink.templatelibrary.viewmodel.WinkTemplateViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003?@AB\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d`\u001eH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/j;", "Lp53/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "J9", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "H9", "", "isHotCategory", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/WinkInspirationTemplateUtils$Companion$SIZE;", "G9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/core/widget/NestedScrollView;", "d", "Landroidx/core/widget/NestedScrollView;", "nestedScrollView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "categoryRv", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/j$a;", "f", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/j$a;", "categoryListAdapter", "Lcom/tencent/mobileqq/wink/templatelibrary/viewmodel/WinkTemplateViewModel;", tl.h.F, "Lcom/tencent/mobileqq/wink/templatelibrary/viewmodel/WinkTemplateViewModel;", "templateViewModel", "", "i", "J", "lastScrollUpdate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "threshold", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Runnable;", "checkRunnable", "<init>", "()V", "D", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j extends p53.b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NestedScrollView nestedScrollView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView categoryRv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a categoryListAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkTemplateViewModel templateViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastScrollUpdate = -1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int threshold = WinkInspirationTemplateUtils.Companion.d(WinkInspirationTemplateUtils.INSTANCE, null, 1, null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Runnable checkRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.i
        @Override // java.lang.Runnable
        public final void run() {
            j.F9(j.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0015\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/j$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/j$b;", "", "Lcom/tencent/mobileqq/wink/inspirationlibrary/part/view/a;", "data", "", "k0", "", "index", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "getItemCount", "holder", "position", "l0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "layoutId", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "i0", "()Ljava/util/List;", "setChildList", "(Ljava/util/List;)V", "childList", "<init>", "(I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<b> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private List<com.tencent.mobileqq.wink.inspirationlibrary.part.view.a> childList = new ArrayList();

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final int layoutId;

        public a(@LayoutRes int i3) {
            this.layoutId = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.childList.size();
        }

        @NotNull
        public final List<com.tencent.mobileqq.wink.inspirationlibrary.part.view.a> i0() {
            return this.childList;
        }

        @NotNull
        public final com.tencent.mobileqq.wink.inspirationlibrary.part.view.a j0(int index) {
            return this.childList.get(index);
        }

        public final void k0(@NotNull List<? extends com.tencent.mobileqq.wink.inspirationlibrary.part.view.a> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.childList.clear();
            this.childList.addAll(data);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            Object orNull;
            Intrinsics.checkNotNullParameter(holder, "holder");
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.childList, position);
            Object obj = (com.tencent.mobileqq.wink.inspirationlibrary.part.view.a) orNull;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            holder.l((View) obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(this.layoutId, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(itemView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/part/j$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "childView", "", "l", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final LinearLayout container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.container = (LinearLayout) itemView.findViewById(R.id.f122897f7);
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/inspirationlibrary/part/j$d", "Landroidx/core/widget/NestedScrollView$OnScrollChangeListener;", "Landroidx/core/widget/NestedScrollView;", "v", "", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "", "onScrollChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements NestedScrollView.OnScrollChangeListener {
        d() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(@Nullable NestedScrollView v3, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            if (j.this.categoryRv != null && scrollY != oldScrollY) {
                if (j.this.lastScrollUpdate == -1) {
                    j.this.lastScrollUpdate = System.currentTimeMillis();
                    NestedScrollView nestedScrollView = j.this.nestedScrollView;
                    if (nestedScrollView != null) {
                        nestedScrollView.removeCallbacks(j.this.checkRunnable);
                    }
                    NestedScrollView nestedScrollView2 = j.this.nestedScrollView;
                    if (nestedScrollView2 != null) {
                        nestedScrollView2.postDelayed(j.this.checkRunnable, 100L);
                        return;
                    }
                    return;
                }
                j.this.lastScrollUpdate = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.lastScrollUpdate > 100) {
            this$0.lastScrollUpdate = -1L;
            this$0.J9();
            return;
        }
        NestedScrollView nestedScrollView = this$0.nestedScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.removeCallbacks(this$0.checkRunnable);
        }
        NestedScrollView nestedScrollView2 = this$0.nestedScrollView;
        if (nestedScrollView2 != null) {
            nestedScrollView2.postDelayed(this$0.checkRunnable, 100L);
        }
    }

    private final WinkInspirationTemplateUtils.Companion.SIZE G9(boolean isHotCategory) {
        if (isHotCategory) {
            return WinkInspirationTemplateUtils.Companion.SIZE.EXP_BIG;
        }
        return WinkInspirationTemplateUtils.Companion.SIZE.EXP_NORMAL;
    }

    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r7v7 */
    private final void H9(List<MetaCategory> categories) {
        int i3;
        int collectionSizeOrDefault;
        Intent intent;
        List<MetaCategory> reversed;
        int collectionSizeOrDefault2;
        Intent intent2;
        ArrayList arrayList = new ArrayList();
        ?? r75 = 0;
        int i16 = 0;
        int i17 = 2;
        if (categories.size() >= 2 && Intrinsics.areEqual(categories.get(0).f30532id, "TEMPLATE_FAVORITE")) {
            reversed = CollectionsKt___CollectionsKt.reversed(categories.subList(0, 2));
            WinkInspirationTemplateUtils.Companion.SIZE G9 = G9(true);
            reversed.get(0).name = "\u70ed\u95e8\u1f525";
            List<MetaCategory> list = reversed;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            int i18 = 0;
            for (Object obj : list) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MetaCategory metaCategory = (MetaCategory) obj;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                WinkInspirationTemplateCategoryView winkInspirationTemplateCategoryView = new WinkInspirationTemplateCategoryView(context, r75, i17, r75);
                Activity activity = getActivity();
                if (activity != null) {
                    intent2 = activity.getIntent();
                } else {
                    intent2 = r75;
                }
                ArrayList arrayList3 = arrayList2;
                winkInspirationTemplateCategoryView.setData(intent2, i18, metaCategory, false, G9);
                arrayList3.add(winkInspirationTemplateCategoryView);
                arrayList2 = arrayList3;
                i18 = i19;
                r75 = 0;
                i17 = 2;
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            WinkInspirationViewPager winkInspirationViewPager = new WinkInspirationViewPager(context2, G9, null, 4, null);
            winkInspirationViewPager.setData(reversed, arrayList2);
            winkInspirationViewPager.z0(false);
            winkInspirationViewPager.K(true);
            arrayList.add(winkInspirationViewPager);
        }
        WinkInspirationTemplateUtils.Companion.SIZE G92 = G9(false);
        if (true ^ arrayList.isEmpty()) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        List<MetaCategory> subList = categories.subList(i3, categories.size());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (Object obj2 : subList) {
            int i26 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MetaCategory metaCategory2 = (MetaCategory) obj2;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            WinkInspirationTemplateCategoryView winkInspirationTemplateCategoryView2 = new WinkInspirationTemplateCategoryView(context3, null, 2, null);
            Activity activity2 = getActivity();
            if (activity2 != null) {
                intent = activity2.getIntent();
            } else {
                intent = null;
            }
            winkInspirationTemplateCategoryView2.setData(intent, i16 + i3, metaCategory2, true, G92);
            arrayList4.add(winkInspirationTemplateCategoryView2);
            i16 = i26;
        }
        arrayList.addAll(arrayList4);
        a aVar = this.categoryListAdapter;
        if (aVar != null) {
            aVar.k0(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(j this$0, List categories) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("WinkInspirationTemplatePart", 1, "categories rsp size ==> " + categories.size());
        Intrinsics.checkNotNullExpressionValue(categories, "categories");
        this$0.H9(categories);
    }

    private final void J9() {
        com.tencent.mobileqq.wink.inspirationlibrary.part.view.a j06;
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.wink.inspirationlibrary.part.view.a j07;
        ArrayList arrayList = new ArrayList();
        RecyclerView recyclerView = this.categoryRv;
        if (recyclerView != null) {
            Rect rect = new Rect();
            recyclerView.getGlobalVisibleRect(rect);
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                Rect rect2 = new Rect();
                childAt.getGlobalVisibleRect(rect2);
                int i16 = rect2.top;
                int i17 = rect.bottom;
                int i18 = this.threshold;
                if (i16 < i17 - i18 && rect2.bottom > rect.top + i18) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                QLog.d("WinkInspirationTemplatePart", 1, "childPosition:" + recyclerView.getChildAdapterPosition(childAt) + ", isChildVisible:" + z17);
                if (z17) {
                    arrayList.add(Integer.valueOf(i3));
                } else {
                    a aVar = this.categoryListAdapter;
                    if (aVar != null && (j07 = aVar.j0(i3)) != null) {
                        j07.K(false);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            boolean contains = arrayList.contains(Integer.valueOf(recyclerView.getChildCount() - 1));
            int i19 = 0;
            for (Object obj : arrayList) {
                int i26 = i19 + 1;
                if (i19 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) obj).intValue();
                a aVar2 = this.categoryListAdapter;
                if (aVar2 != null && (j06 = aVar2.j0(intValue)) != null) {
                    if (!contains && i19 != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    j06.K(z16);
                }
                i19 = i26;
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FavoriteMaterialEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkInspirationTemplatePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        NestedScrollView nestedScrollView;
        MutableLiveData<List<MetaCategory>> Q1;
        super.onInitView(rootView);
        RecyclerView recyclerView = null;
        if (rootView != null) {
            nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.f122927f_);
        } else {
            nestedScrollView = null;
        }
        this.nestedScrollView = nestedScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new d());
        }
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f123077fo);
        }
        this.categoryRv = recyclerView;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
            this.categoryListAdapter = new a(R.layout.i5p);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setItemViewCacheSize(5);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.categoryListAdapter);
        }
        WinkTemplateViewModel winkTemplateViewModel = (WinkTemplateViewModel) getViewModel(WinkTemplateViewModel.class);
        this.templateViewModel = winkTemplateViewModel;
        if (winkTemplateViewModel != null && (Q1 = winkTemplateViewModel.Q1()) != null) {
            Q1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.part.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    j.I9(j.this, (List) obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        List<com.tencent.mobileqq.wink.inspirationlibrary.part.view.a> i06;
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        NestedScrollView nestedScrollView = this.nestedScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.clearAnimation();
            nestedScrollView.removeCallbacks(this.checkRunnable);
        }
        a aVar = this.categoryListAdapter;
        if (aVar != null && (i06 = aVar.i0()) != null) {
            Iterator<T> it = i06.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.wink.inspirationlibrary.part.view.a) it.next()).release();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        J9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        List<com.tencent.mobileqq.wink.inspirationlibrary.part.view.a> i06;
        Object obj;
        ArrayList<MetaMaterial> R1;
        if (event instanceof FavoriteMaterialEvent) {
            WinkTemplateViewModel winkTemplateViewModel = this.templateViewModel;
            if (winkTemplateViewModel != null && (R1 = winkTemplateViewModel.R1()) != null) {
                FavoriteMaterialEvent favoriteMaterialEvent = (FavoriteMaterialEvent) event;
                int i3 = 0;
                if (favoriteMaterialEvent.getFavorite()) {
                    if (!R1.contains(favoriteMaterialEvent.getMaterial())) {
                        R1.add(0, favoriteMaterialEvent.getMaterial());
                    }
                } else {
                    Iterator<MetaMaterial> it = R1.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual(it.next().f30533id, favoriteMaterialEvent.getMaterial().f30533id)) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 != -1) {
                        R1.remove(i3);
                    }
                }
            }
            a aVar = this.categoryListAdapter;
            if (aVar != null && (i06 = aVar.i0()) != null) {
                Iterator<T> it5 = i06.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (((com.tencent.mobileqq.wink.inspirationlibrary.part.view.a) obj) instanceof WinkInspirationViewPager) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.mobileqq.wink.inspirationlibrary.part.view.a aVar2 = (com.tencent.mobileqq.wink.inspirationlibrary.part.view.a) obj;
                if (aVar2 != null) {
                    aVar2.refresh();
                }
            }
        }
    }
}
