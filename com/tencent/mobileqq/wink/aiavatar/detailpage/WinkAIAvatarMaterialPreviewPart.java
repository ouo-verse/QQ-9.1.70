package com.tencent.mobileqq.wink.aiavatar.detailpage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAIAvatarGenerateBtn;
import com.tencent.mobileqq.wink.view.WinkRoundedCornerImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u001b\u001a\u00020\u0004J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00104R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialPreviewPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "", "isCouple", "P9", "view", "", "dp", "G9", "F9", "O9", "I9", "Landroid/widget/ImageView;", "imageView", "", "imageUrl", "N9", "J9", "E9", "D9", VasPerfReportUtils.WHILE_UPDATE_ITEM, "C9", "onInitView", "initViewModel", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "d", "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "firstMaterialImagePreview", "e", "cpMaterialFirstCoverPreview", "f", "cpMaterialSecondCoverPreview", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "uploadSuggestList", "Landroidx/recyclerview/widget/GridLayoutManager;", "i", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/h;", "uploadPicSuggestListAdapter", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "avatarContainer", "D", "closeBtn", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "E", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "makeSameKindBtn", UserInfo.SEX_FEMALE, "coupleItemCoverView", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", "G", "Lkotlin/Lazy;", "H9", "()Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", "materialDetailViewModel", "<init>", "()V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarMaterialPreviewPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View avatarContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View closeBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private WinkAIAvatarGenerateBtn makeSameKindBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View coupleItemCoverView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy materialDetailViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkRoundedCornerImageView firstMaterialImagePreview;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkRoundedCornerImageView cpMaterialFirstCoverPreview;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkRoundedCornerImageView cpMaterialSecondCoverPreview;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView uploadSuggestList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GridLayoutManager layoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h uploadPicSuggestListAdapter;

    public WinkAIAvatarMaterialPreviewPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarMaterialDetailViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialPreviewPart$materialDetailViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarMaterialDetailViewModel invoke() {
                return (WinkAIAvatarMaterialDetailViewModel) WinkAIAvatarMaterialPreviewPart.this.getViewModel(WinkAIAvatarMaterialDetailViewModel.class);
            }
        });
        this.materialDetailViewModel = lazy;
    }

    private final void C9() {
        ViewGroup.LayoutParams layoutParams;
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity())) {
            View view = this.avatarContainer;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.LayoutParams) layoutParams2).width = hVar.u(getActivity());
                if (H9().getIsCoupleAvatar()) {
                    ((ViewGroup.LayoutParams) layoutParams2).height = -2;
                } else {
                    ((ViewGroup.LayoutParams) layoutParams2).height = hVar.u(getActivity());
                }
                View view2 = this.avatarContainer;
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private final void D9() {
        ViewGroup.LayoutParams layoutParams;
        RecyclerView recyclerView = this.uploadSuggestList;
        if (recyclerView != null) {
            layoutParams = recyclerView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).bottomMargin = (int) o53.h.f422138a.t(getActivity());
        }
    }

    private final void E9() {
        ViewGroup.LayoutParams layoutParams;
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity())) {
            RecyclerView recyclerView = this.uploadSuggestList;
            if (recyclerView != null) {
                layoutParams = recyclerView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.width = hVar.s(getActivity());
            }
        }
    }

    private final void F9(View view, float dp5) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(ImmersiveUtils.dpToPx(dp5));
            layoutParams2.setMarginEnd(ImmersiveUtils.dpToPx(dp5));
            view.setLayoutParams(layoutParams);
        }
    }

    private final void G9(View view, float dp5) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = ImmersiveUtils.dpToPx(dp5);
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAIAvatarMaterialDetailViewModel H9() {
        Object value = this.materialDetailViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-materialDetailViewModel>(...)");
        return (WinkAIAvatarMaterialDetailViewModel) value;
    }

    private final void I9() {
        w53.b.f("WinkAIAvatarMaterialPreviewPart", "handleCloseBtnClick click");
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void J9() {
        RecyclerView recyclerView;
        View partRootView = getPartRootView();
        Context context = null;
        if (partRootView != null) {
            recyclerView = (RecyclerView) partRootView.findViewById(R.id.f114656tx);
        } else {
            recyclerView = null;
        }
        this.uploadSuggestList = recyclerView;
        E9();
        D9();
        this.uploadPicSuggestListAdapter = new h(WinkAIAvatarUtils.f317678a.g(H9().getOriginStyleMaterial()));
        View partRootView2 = getPartRootView();
        if (partRootView2 != null) {
            context = partRootView2.getContext();
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        this.layoutManager = gridLayoutManager;
        RecyclerView recyclerView2 = this.uploadSuggestList;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(gridLayoutManager);
        }
        RecyclerView recyclerView3 = this.uploadSuggestList;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.uploadPicSuggestListAdapter);
        }
    }

    private final void K9(View rootView) {
        WinkRoundedCornerImageView winkRoundedCornerImageView;
        WinkRoundedCornerImageView winkRoundedCornerImageView2;
        WinkRoundedCornerImageView winkRoundedCornerImageView3;
        View view;
        View view2;
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn;
        View view3 = null;
        if (rootView != null) {
            winkRoundedCornerImageView = (WinkRoundedCornerImageView) rootView.findViewById(R.id.y3_);
        } else {
            winkRoundedCornerImageView = null;
        }
        this.firstMaterialImagePreview = winkRoundedCornerImageView;
        if (rootView != null) {
            winkRoundedCornerImageView2 = (WinkRoundedCornerImageView) rootView.findViewById(R.id.f122487e3);
        } else {
            winkRoundedCornerImageView2 = null;
        }
        this.cpMaterialFirstCoverPreview = winkRoundedCornerImageView2;
        if (rootView != null) {
            winkRoundedCornerImageView3 = (WinkRoundedCornerImageView) rootView.findViewById(R.id.f122517e6);
        } else {
            winkRoundedCornerImageView3 = null;
        }
        this.cpMaterialSecondCoverPreview = winkRoundedCornerImageView3;
        if (rootView != null) {
            view = rootView.findViewById(R.id.u_f);
        } else {
            view = null;
        }
        this.coupleItemCoverView = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f164548a32);
        } else {
            view2 = null;
        }
        this.avatarContainer = view2;
        if (rootView != null) {
            winkAIAvatarGenerateBtn = (WinkAIAvatarGenerateBtn) rootView.findViewById(R.id.tfd);
        } else {
            winkAIAvatarGenerateBtn = null;
        }
        this.makeSameKindBtn = winkAIAvatarGenerateBtn;
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.g(winkAIAvatarGenerateBtn);
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.az7);
        }
        this.closeBtn = view3;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WinkAIAvatarMaterialPreviewPart.L9(WinkAIAvatarMaterialPreviewPart.this, view4);
                }
            });
        }
        P9(H9().getIsCoupleAvatar());
        J9();
        C9();
        O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(WinkAIAvatarMaterialPreviewPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9(ImageView imageView, String imageUrl) {
        boolean z16;
        int dpToPx;
        if (imageView != null) {
            boolean z17 = true;
            if (imageUrl != null && imageUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                ColorDrawable colorDrawable = new ColorDrawable(imageView.getContext().getColor(R.color.qui_common_bg_nav_bottom));
                WinkRoundedCornerImageView winkRoundedCornerImageView = this.cpMaterialSecondCoverPreview;
                if (winkRoundedCornerImageView == null || winkRoundedCornerImageView.getVisibility() != 0) {
                    z17 = false;
                }
                if (z17) {
                    dpToPx = ImmersiveUtils.dpToPx(178.0f);
                } else {
                    dpToPx = ImmersiveUtils.dpToPx(325.0f);
                }
                Option obtain = Option.obtain();
                obtain.setLoadingDrawable(colorDrawable);
                obtain.setFailedDrawable(colorDrawable);
                obtain.setTargetView(imageView);
                obtain.setUrl(imageUrl);
                obtain.setRequestWidth(dpToPx);
                obtain.setRequestHeight(dpToPx);
                QQPicLoader.f201806a.d().loadImage(obtain, null);
            }
        }
    }

    private final void O9() {
        if (H9().getIsCoupleAvatar()) {
            N9(this.cpMaterialFirstCoverPreview, com.tencent.mobileqq.wink.editor.c.A(H9().getOriginStyleMaterial()));
            N9(this.cpMaterialSecondCoverPreview, com.tencent.mobileqq.wink.editor.c.n0(H9().getOriginStyleMaterial()));
            return;
        }
        N9(this.firstMaterialImagePreview, com.tencent.mobileqq.wink.editor.c.A(H9().getOriginStyleMaterial()));
    }

    private final void P9(boolean isCouple) {
        if (isCouple) {
            WinkRoundedCornerImageView winkRoundedCornerImageView = this.firstMaterialImagePreview;
            if (winkRoundedCornerImageView != null) {
                winkRoundedCornerImageView.setVisibility(8);
            }
            View view = this.coupleItemCoverView;
            if (view != null) {
                view.setVisibility(0);
            }
            WinkRoundedCornerImageView winkRoundedCornerImageView2 = this.cpMaterialFirstCoverPreview;
            if (winkRoundedCornerImageView2 != null) {
                winkRoundedCornerImageView2.setVisibility(0);
            }
            WinkRoundedCornerImageView winkRoundedCornerImageView3 = this.cpMaterialSecondCoverPreview;
            if (winkRoundedCornerImageView3 != null) {
                winkRoundedCornerImageView3.setVisibility(0);
            }
            G9(this.avatarContainer, 104.0f);
            F9(this.avatarContainer, 18.0f);
            WinkRoundedCornerImageView winkRoundedCornerImageView4 = this.cpMaterialFirstCoverPreview;
            if (winkRoundedCornerImageView4 != null) {
                winkRoundedCornerImageView4.setTransitionName("previewFirst");
            }
            WinkRoundedCornerImageView winkRoundedCornerImageView5 = this.cpMaterialSecondCoverPreview;
            if (winkRoundedCornerImageView5 != null) {
                winkRoundedCornerImageView5.setTransitionName("previewSecond");
                return;
            }
            return;
        }
        WinkRoundedCornerImageView winkRoundedCornerImageView6 = this.firstMaterialImagePreview;
        if (winkRoundedCornerImageView6 != null) {
            winkRoundedCornerImageView6.setVisibility(0);
        }
        View view2 = this.coupleItemCoverView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        WinkRoundedCornerImageView winkRoundedCornerImageView7 = this.cpMaterialFirstCoverPreview;
        if (winkRoundedCornerImageView7 != null) {
            winkRoundedCornerImageView7.setVisibility(8);
        }
        WinkRoundedCornerImageView winkRoundedCornerImageView8 = this.cpMaterialSecondCoverPreview;
        if (winkRoundedCornerImageView8 != null) {
            winkRoundedCornerImageView8.setVisibility(8);
        }
        G9(this.avatarContainer, 20.0f);
        F9(this.avatarContainer, 40.0f);
        WinkRoundedCornerImageView winkRoundedCornerImageView9 = this.firstMaterialImagePreview;
        if (winkRoundedCornerImageView9 != null) {
            winkRoundedCornerImageView9.setTransitionName("previewFirst");
        }
    }

    private final void updateView() {
        C9();
        J9();
    }

    public final void initViewModel() {
        LiveData<MetaCategory> N1 = H9().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<MetaCategory, Unit> function1 = new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialPreviewPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetaCategory metaCategory) {
                invoke2(metaCategory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MetaCategory metaCategory) {
                h hVar;
                WinkAIAvatarMaterialDetailViewModel H9;
                hVar = WinkAIAvatarMaterialPreviewPart.this.uploadPicSuggestListAdapter;
                if (hVar != null) {
                    WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
                    H9 = WinkAIAvatarMaterialPreviewPart.this.H9();
                    hVar.setData(winkAIAvatarUtils.g(H9.getOriginStyleMaterial()));
                }
            }
        };
        N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarMaterialPreviewPart.M9(Function1.this, obj);
            }
        });
        H9().R1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity()) || hVar.w(getActivity())) {
            updateView();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        K9(rootView);
        initViewModel();
    }
}
