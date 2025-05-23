package com.tencent.mobileqq.wink.magicstudio.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicstudio.ImageCreationFragment;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.PageInfoCallbackInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/ImageCreateStylePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "G9", "F9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "magicStudioVm", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "e", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "E9", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "vm", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "styleList", "Lcom/tencent/mobileqq/wink/magicstudio/view/MagicNextButton;", tl.h.F, "Lcom/tencent/mobileqq/wink/magicstudio/view/MagicNextButton;", "nextBtnArea", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "collectionTip", "Lcom/tencent/mobileqq/wink/magicstudio/view/StyleAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/magicstudio/view/StyleAdapter;", "styleAdapter", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ImageCreateStylePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioViewModel magicStudioVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioCreationViewModel vm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView styleList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private MagicNextButton nextBtnArea;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView collectionTip;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StyleAdapter styleAdapter;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/view/ImageCreateStylePart$a", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "canScrollVertically", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends GridLayoutManager {
        a(Context context, int i3) {
            super(context, i3, 0, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/view/ImageCreateStylePart$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = ViewExKt.d(10);
            outRect.bottom = ViewExKt.d(10);
        }
    }

    public ImageCreateStylePart(@NotNull MagicStudioViewModel magicStudioVm, @NotNull MagicStudioCreationViewModel vm5) {
        Intrinsics.checkNotNullParameter(magicStudioVm, "magicStudioVm");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.magicStudioVm = magicStudioVm;
        this.vm = vm5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new ImageCreateStylePart$initObserver$1(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new ImageCreateStylePart$initObserver$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new ImageCreateStylePart$initObserver$3(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenStarted(new ImageCreateStylePart$initObserver$4(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new ImageCreateStylePart$initObserver$5(this, null));
    }

    private final void G9() {
        int i3;
        RecyclerView recyclerView = this.styleList;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
            recyclerView = null;
        }
        Context context = getContext();
        if (ImmersiveUtils.getScreenWidth() * 16 > ImmersiveUtils.getScreenHeight() * 9) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        recyclerView.setLayoutManager(new a(context, i3));
        int screenWidth = ImmersiveUtils.getScreenWidth();
        ImageCreationFragment.Companion companion = ImageCreationFragment.INSTANCE;
        int d16 = (int) ((screenWidth - ViewExKt.d(((companion.a() - 1) * 10) + 16)) / (companion.a() - 0.75d));
        RecyclerView recyclerView3 = this.styleList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
            recyclerView3 = null;
        }
        recyclerView3.getLayoutParams().height = (d16 * (8 / companion.a())) + (ViewExKt.d(10) * ((8 / companion.a()) - 1));
        RecyclerView recyclerView4 = this.styleList;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
            recyclerView4 = null;
        }
        recyclerView4.setOverScrollMode(2);
        RecyclerView recyclerView5 = this.styleList;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
            recyclerView5 = null;
        }
        if (recyclerView5.getItemDecorationCount() > 0) {
            RecyclerView recyclerView6 = this.styleList;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("styleList");
                recyclerView6 = null;
            }
            recyclerView6.removeItemDecorationAt(0);
        }
        RecyclerView recyclerView7 = this.styleList;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
        } else {
            recyclerView2 = recyclerView7;
        }
        recyclerView2.addItemDecoration(new b());
    }

    @NotNull
    /* renamed from: E9, reason: from getter */
    public final MagicStudioCreationViewModel getVm() {
        return this.vm;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        G9();
        RecyclerView recyclerView = this.styleList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
            recyclerView = null;
        }
        recyclerView.setAdapter(this.styleAdapter);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f897750o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.styleList)");
        this.styleList = (RecyclerView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.zqh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.nextBtnArea)");
        this.nextBtnArea = (MagicNextButton) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.u0n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.collection_tip)");
        this.collectionTip = (TextView) findViewById3;
        MagicNextButton magicNextButton = this.nextBtnArea;
        RecyclerView recyclerView = null;
        if (magicNextButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtnArea");
            magicNextButton = null;
        }
        magicNextButton.setClick(new Function1<MagicStudioButtonInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.ImageCreateStylePart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicStudioButtonInfo magicStudioButtonInfo) {
                invoke2(magicStudioButtonInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable MagicStudioButtonInfo magicStudioButtonInfo) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
                } else {
                    w53.b.f("ImageCreationFragment", "img nextBtnArea prepareEditorData");
                    ImageCreateStylePart.this.getVm().r3();
                }
            }
        });
        MagicNextButton magicNextButton2 = this.nextBtnArea;
        if (magicNextButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtnArea");
            magicNextButton2 = null;
        }
        magicNextButton2.setShareCallBack(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.ImageCreateStylePart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MagicStudioViewModel magicStudioViewModel;
                magicStudioViewModel = ImageCreateStylePart.this.magicStudioVm;
                magicStudioViewModel.T1(2);
            }
        });
        MagicNextButton magicNextButton3 = this.nextBtnArea;
        if (magicNextButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtnArea");
            magicNextButton3 = null;
        }
        VideoReport.setElementId(magicNextButton3, QCircleDaTongConstant.ElementId.EM_XSJ_TASK_OPERATION_BUTTON);
        MagicNextButton magicNextButton4 = this.nextBtnArea;
        if (magicNextButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtnArea");
            magicNextButton4 = null;
        }
        magicNextButton4.setReportCallBack(new Function1<HashMap<String, Object>, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.ImageCreateStylePart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                invoke2(hashMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HashMap<String, Object> it) {
                Object orNull;
                String str;
                MagicNextButton magicNextButton5;
                String styleID;
                Intrinsics.checkNotNullParameter(it, "it");
                orNull = CollectionsKt___CollectionsKt.getOrNull(ImageCreateStylePart.this.getVm().V2().getValue(), 0);
                com.tencent.mobileqq.wink.magicstudio.model.f fVar = (com.tencent.mobileqq.wink.magicstudio.model.f) orNull;
                String str2 = "";
                if (fVar == null || (str = fVar.getStyleName()) == null) {
                    str = "";
                }
                it.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, str);
                com.tencent.mobileqq.wink.magicstudio.model.f curStyle = ImageCreateStylePart.this.getVm().getCurStyle();
                if (curStyle != null && (styleID = curStyle.getStyleID()) != null) {
                    str2 = styleID;
                }
                it.put("xsj_material_id", str2);
                it.put("xsj_text_content", ImageCreateStylePart.this.getVm().getCurDesc());
                it.put("xsj_if_picture", "1");
                magicNextButton5 = ImageCreateStylePart.this.nextBtnArea;
                if (magicNextButton5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("nextBtnArea");
                    magicNextButton5 = null;
                }
                VideoReport.reportEvent("dt_clck", magicNextButton5, it);
            }
        });
        G9();
        RecyclerView recyclerView2 = this.styleList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleList");
        } else {
            recyclerView = recyclerView2;
        }
        StyleAdapter styleAdapter = new StyleAdapter(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.ImageCreateStylePart$onInitView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void invoke(int i3) {
                ImageCreateStylePart.this.getVm().g3(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        });
        this.styleAdapter = styleAdapter;
        recyclerView.setAdapter(styleAdapter);
        this.magicStudioVm.a2(new Function1<PageInfoCallbackInfo, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.ImageCreateStylePart$onInitView$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PageInfoCallbackInfo pageInfoCallbackInfo) {
                invoke2(pageInfoCallbackInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable PageInfoCallbackInfo pageInfoCallbackInfo) {
                if (pageInfoCallbackInfo == null) {
                    return;
                }
                ImageCreateStylePart.this.getVm().e3(pageInfoCallbackInfo.a(), pageInfoCallbackInfo.b(), pageInfoCallbackInfo.c());
                ImageCreateStylePart.this.F9();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        super.onPartStart(activity);
    }
}
