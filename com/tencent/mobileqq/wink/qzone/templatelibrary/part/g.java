package com.tencent.mobileqq.wink.qzone.templatelibrary.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.WinkQZoneTemplateLibJumpHelper;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u0002HIB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0012R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R*\u0010=\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u000108j\n\u0012\u0004\u0012\u000209\u0018\u0001`:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/g;", "Lcom/tencent/biz/richframework/part/Part;", "", "initViewModel", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "categoriesData", "F9", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "G9", "H9", "C9", "B9", "", "startHeight", "endHeight", "K9", "", "expand", "M9", "E9", "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "D9", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "aiToolRecyclerView", "Ls93/a;", "e", "Ls93/a;", "aiToolAdapter", "Landroidx/recyclerview/widget/GridLayoutManager;", "f", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", tl.h.F, "Landroid/view/View;", "aiToolContainer", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "expandBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "collapseBtn", BdhLogUtil.LogTag.Tag_Conn, "btnContainer", "D", "I", "backupRecyclerViewHeight", "E", "Z", "isExpand", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "aiToolMaterials", "Landroid/view/animation/Interpolator;", "G", "Landroid/view/animation/Interpolator;", "bezierInterpolator", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "H", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "templateViewModel", "<init>", "()V", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View btnContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private int backupRecyclerViewHeight;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ArrayList<MetaMaterial> aiToolMaterials;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel templateViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView aiToolRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s93.a aiToolAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GridLayoutManager layoutManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View aiToolContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView expandBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView collapseBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isExpand = true;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Interpolator bezierInterpolator = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/g$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.left = ImmersiveUtils.dpToPx(2.0f);
            outRect.right = ImmersiveUtils.dpToPx(2.0f);
            outRect.bottom = ImmersiveUtils.dpToPx(2.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/qzone/templatelibrary/part/g$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f326197d;

        c(ImageView imageView) {
            this.f326197d = imageView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            this.f326197d.setVisibility(8);
        }
    }

    private final void B9() {
        int i3;
        int i16;
        View findViewByPosition;
        int i17 = 0;
        this.isExpand = false;
        M9(false);
        RecyclerView recyclerView = this.aiToolRecyclerView;
        if (recyclerView != null) {
            i3 = recyclerView.getHeight();
        } else {
            i3 = 0;
        }
        this.backupRecyclerViewHeight = i3;
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager != null) {
            i16 = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
        } else {
            i16 = 0;
        }
        GridLayoutManager gridLayoutManager2 = this.layoutManager;
        if (gridLayoutManager2 != null && (findViewByPosition = gridLayoutManager2.findViewByPosition(i16)) != null) {
            i17 = findViewByPosition.getHeight();
        }
        K9(this.backupRecyclerViewHeight, i17);
    }

    private final void C9() {
        int i3;
        this.isExpand = true;
        M9(true);
        RecyclerView recyclerView = this.aiToolRecyclerView;
        if (recyclerView != null) {
            i3 = recyclerView.getHeight();
        } else {
            i3 = 0;
        }
        K9(i3, this.backupRecyclerViewHeight);
    }

    private final int E9() {
        if (com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.n()) {
            return 8;
        }
        return 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if ((!r3.isEmpty()) == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void F9(WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
        ArrayList<MetaMaterial> arrayList;
        boolean z16;
        MetaCategory aiToolCategory = categoriesData.getAiToolCategory();
        if (aiToolCategory != null) {
            arrayList = aiToolCategory.materials;
        } else {
            arrayList = null;
        }
        this.aiToolMaterials = arrayList;
        if (arrayList != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            View view = this.aiToolContainer;
            if (view != null) {
                view.setVisibility(0);
            }
            s93.a aVar = this.aiToolAdapter;
            if (aVar != null) {
                ArrayList<MetaMaterial> arrayList2 = this.aiToolMaterials;
                Intrinsics.checkNotNull(arrayList2);
                aVar.l0(arrayList2);
            }
            N9();
            return;
        }
        View view2 = this.aiToolContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private final void G9(View rootView) {
        RecyclerView recyclerView;
        Intent intent;
        Bundle bundle = null;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f124077id);
        } else {
            recyclerView = null;
        }
        this.aiToolRecyclerView = recyclerView;
        if (recyclerView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = new WinkQZoneTemplateLibJumpHelper(context, null);
            Activity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                bundle = intent.getExtras();
            }
            s93.a aVar = new s93.a(bundle, winkQZoneTemplateLibJumpHelper);
            this.aiToolAdapter = aVar;
            recyclerView.setAdapter(aVar);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), E9());
            this.layoutManager = gridLayoutManager;
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.addItemDecoration(new b());
        }
    }

    private final void H9(View rootView) {
        View view;
        ImageView imageView;
        String str;
        ImageView imageView2;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f124037i_);
        } else {
            view = null;
        }
        this.btnContainer = view;
        if (view != null) {
            com.tencent.mobileqq.wink.report.e.f(com.tencent.mobileqq.wink.report.e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_QZ_UNFOLD_BUTTON, null, null, 12, null);
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.f124067ic);
        } else {
            imageView = null;
        }
        this.expandBtn = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView3 = this.expandBtn;
        if (imageView3 != null) {
            imageView3.setAlpha(0.0f);
        }
        if (QQTheme.isNowThemeIsNight()) {
            str = "https://downv6.qq.com/shadow_qqcamera/QZoneTemplateLib/qvideo_icon_dark_expand.png";
        } else {
            str = "https://downv6.qq.com/shadow_qqcamera/QZoneTemplateLib/qvideo_icon_light_expand.png";
        }
        Option obtain = Option.obtain();
        obtain.setLoadingDrawableColor(getContext().getColor(R.color.ajr));
        obtain.setTargetView(this.expandBtn);
        obtain.setUrl(str);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        qQPicLoader.d().loadImage(obtain, null);
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.f124047ia);
        } else {
            imageView2 = null;
        }
        this.collapseBtn = imageView2;
        if (imageView2 != null) {
            imageView2.setRotation(180.0f);
        }
        Option obtain2 = Option.obtain();
        obtain2.setLoadingDrawableColor(getContext().getColor(R.color.ajr));
        obtain2.setTargetView(this.collapseBtn);
        obtain2.setUrl(str);
        qQPicLoader.d().loadImage(obtain2, null);
        View view2 = this.btnContainer;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    g.I9(g.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(g this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.report.e.m(eVar, it, WinkDaTongReportConstant.ElementId.EM_QZ_UNFOLD_BUTTON, null, null, 12, null);
        if (this$0.isExpand) {
            this$0.B9();
        } else {
            this$0.C9();
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(g this$0, WinkQZoneTemplateLibViewModel.CategoriesData categories) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(categories, "categories");
        this$0.F9(categories);
    }

    private final void K9(final int startHeight, final int endHeight) {
        ValueAnimator ofInt = ValueAnimator.ofInt(startHeight, endHeight);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.L9(g.this, endHeight, startHeight, valueAnimator);
            }
        });
        ofInt.setInterpolator(this.bezierInterpolator);
        ofInt.setDuration(200L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(g this$0, int i3, int i16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.aiToolRecyclerView == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        RecyclerView recyclerView = this$0.aiToolRecyclerView;
        Intrinsics.checkNotNull(recyclerView);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        if (i3 > i16 && i3 == intValue) {
            Intrinsics.checkNotNull(layoutParams);
            layoutParams.height = -2;
        } else {
            Intrinsics.checkNotNull(layoutParams);
            layoutParams.height = intValue;
        }
        RecyclerView recyclerView2 = this$0.aiToolRecyclerView;
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setLayoutParams(layoutParams);
        RecyclerView recyclerView3 = this$0.aiToolRecyclerView;
        Intrinsics.checkNotNull(recyclerView3);
        int childCount = recyclerView3.getChildCount();
        for (int E9 = this$0.E9(); E9 < childCount; E9++) {
            RecyclerView recyclerView4 = this$0.aiToolRecyclerView;
            Intrinsics.checkNotNull(recyclerView4);
            RecyclerView recyclerView5 = this$0.aiToolRecyclerView;
            Intrinsics.checkNotNull(recyclerView5);
            RecyclerView.ViewHolder childViewHolder = recyclerView4.getChildViewHolder(recyclerView5.getChildAt(E9));
            View view = null;
            if (i16 > i3) {
                float f16 = (intValue - i3) / (i16 - i3);
                if (childViewHolder != null) {
                    view = childViewHolder.itemView;
                }
                if (view != null) {
                    view.setAlpha(f16);
                }
            } else {
                float f17 = (intValue - i16) / (i3 - i16);
                if (childViewHolder != null) {
                    view = childViewHolder.itemView;
                }
                if (view != null) {
                    view.setAlpha(f17);
                }
            }
        }
    }

    private final void M9(boolean expand2) {
        ImageView imageView;
        ImageView imageView2;
        if (expand2) {
            imageView = this.collapseBtn;
        } else {
            imageView = this.expandBtn;
        }
        if (expand2) {
            imageView2 = this.expandBtn;
        } else {
            imageView2 = this.collapseBtn;
        }
        if (imageView2 != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat.setInterpolator(this.bezierInterpolator);
            ofFloat.setDuration(150L);
            ofFloat.addListener(new c(imageView2));
            ofFloat.start();
        }
        if (imageView != null) {
            imageView.setVisibility(0);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat2.setInterpolator(this.bezierInterpolator);
            ofFloat2.setStartDelay(50L);
            ofFloat2.setDuration(150L);
            ofFloat2.start();
        }
    }

    private final void N9() {
        View view;
        int i3;
        ArrayList<MetaMaterial> arrayList = this.aiToolMaterials;
        if (arrayList != null && (view = this.btnContainer) != null) {
            if (arrayList.size() > E9()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private final void initViewModel() {
        MutableLiveData<WinkQZoneTemplateLibViewModel.CategoriesData> N1;
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = (WinkQZoneTemplateLibViewModel) getViewModel(WinkQZoneTemplateLibViewModel.class);
        this.templateViewModel = winkQZoneTemplateLibViewModel;
        if (winkQZoneTemplateLibViewModel != null && (N1 = winkQZoneTemplateLibViewModel.N1()) != null) {
            N1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.J9(g.this, (WinkQZoneTemplateLibViewModel.CategoriesData) obj);
                }
            });
        }
    }

    /* renamed from: D9, reason: from getter */
    public final boolean getIsExpand() {
        return this.isExpand;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager != null) {
            gridLayoutManager.setSpanCount(E9());
        }
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        super.onInitView(rootView);
        if (rootView != null) {
            view = rootView.findViewById(R.id.f124057ib);
        } else {
            view = null;
        }
        this.aiToolContainer = view;
        G9(rootView);
        H9(rootView);
        initViewModel();
    }
}
