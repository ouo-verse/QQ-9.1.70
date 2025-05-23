package com.tencent.mobileqq.wink.dailysign;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014J\u0006\u0010\u0015\u001a\u00020\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R0\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(0'j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010%R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010E\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/WinkSlidMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "Ia", "Landroid/content/Context;", "context", "Ha", "La", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "Ea", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "Landroid/os/Bundle;", "args", "L9", "initAfterInflation", "Ga", "oa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/wink/dailysign/WinkSlidPageView;", "M", "Lcom/tencent/mobileqq/wink/dailysign/WinkSlidPageView;", "winkSlidPageView", "Lcom/tencent/mobileqq/wink/dailysign/at;", "N", "Lcom/tencent/mobileqq/wink/dailysign/at;", "pagerAdapter", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "P", "Ljava/util/List;", "mStickerMaterials", "Ljava/util/HashMap;", "Landroid/support/v7/widget/RecyclerView;", "Lkotlin/collections/HashMap;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/HashMap;", "stickerViewMap", "Lcom/tencent/mobileqq/wink/dailysign/au;", BdhLogUtil.LogTag.Tag_Req, "mAdapterList", ExifInterface.LATITUDE_SOUTH, "I", "mPageCount", "T", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "selectMaterial", "Lkotlin/Function0;", "U", "Lkotlin/jvm/functions/Function0;", "handleItemClick", "V", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "applyMaterialOnlineTask", "W", "Landroid/view/View;", "containerView", "Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "X", "Lkotlin/Lazy;", "Fa", "()Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "dailySignViewModel", "<init>", "()V", "Y", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSlidMenuPart extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private WinkSlidPageView winkSlidPageView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private at pagerAdapter;

    /* renamed from: S, reason: from kotlin metadata */
    private int mPageCount;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial selectMaterial;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy dailySignViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final List<MetaMaterial> mStickerMaterials = new ArrayList();

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, RecyclerView> stickerViewMap = new LinkedHashMap();

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final List<au> mAdapterList = new ArrayList();

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> handleItemClick = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.WinkSlidMenuPart$handleItemClick$1
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
            WinkSlidMenuPart.this.Ga();
        }
    };

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final ApplyMaterialTask applyMaterialOnlineTask = Ea();

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/dailysign/WinkSlidMenuPart$b", "Lcom/tencent/mobileqq/wink/flow/a;", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "", "F1", "g", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.wink.flow.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void F1(@NotNull ApplyMaterialTask.Status downloadStatus, int position, @NotNull MetaMaterial material, @NotNull ApplyMaterialTask.a callback) {
            Intrinsics.checkNotNullParameter(downloadStatus, "downloadStatus");
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(callback, "callback");
            super.F1(downloadStatus, position, material, callback);
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void g(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            WinkSlidMenuPart.this.Ga();
            Iterator it = WinkSlidMenuPart.this.mAdapterList.iterator();
            while (it.hasNext()) {
                ((au) it.next()).e0(material);
            }
            WinkSlidMenuPart.this.selectMaterial = material;
            WinkSlidMenuPart.this.Fa().X1(material);
        }
    }

    public WinkSlidMenuPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DailySignViewModel>() { // from class: com.tencent.mobileqq.wink.dailysign.WinkSlidMenuPart$dailySignViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DailySignViewModel invoke() {
                return (DailySignViewModel) WinkSlidMenuPart.this.getViewModel(DailySignViewModel.class);
            }
        });
        this.dailySignViewModel = lazy;
    }

    private final ApplyMaterialTask Ea() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DailySignViewModel Fa() {
        Object value = this.dailySignViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dailySignViewModel>(...)");
        return (DailySignViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha(Context context) {
        this.mPageCount = this.mStickerMaterials.size() / 8;
        if (this.mStickerMaterials.size() % 8 != 0) {
            this.mPageCount++;
        }
        try {
            int i3 = this.mPageCount;
            for (int i16 = 0; i16 < i3; i16++) {
                RecyclerView recyclerView = new RecyclerView(context);
                int i17 = i16 * 8;
                int i18 = i17 + 8;
                if (i18 > this.mStickerMaterials.size()) {
                    i18 = this.mStickerMaterials.size();
                }
                w53.b.a(this.TAG, "materialData subList index " + i16 + " endIndex " + i18);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "this.context");
                au auVar = new au(context2, WinkEditorViewModel.EditMode.Video, this.handleItemClick);
                auVar.Y(this.mStickerMaterials.subList(i17, i18));
                auVar.S(this.applyMaterialOnlineTask);
                recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
                recyclerView.setAdapter(auVar);
                this.stickerViewMap.put(Integer.valueOf(i16), recyclerView);
                this.mAdapterList.add(auVar);
            }
            this.pagerAdapter = new at(context, this.stickerViewMap);
            La();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void Ia() {
        MutableLiveData<List<MetaCategory>> g26 = Fa().g2();
        final Function1<List<? extends MetaCategory>, Unit> function1 = new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.mobileqq.wink.dailysign.WinkSlidMenuPart$initViewPagerData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaCategory> list) {
                invoke2((List<MetaCategory>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MetaCategory> list) {
                List list2;
                HashMap hashMap;
                List list3;
                w53.b.a(WinkSlidMenuPart.this.TAG, "dailySignMoodListLiveData materialData size " + list.size() + ", dailySignViewModel is " + WinkSlidMenuPart.this.Fa());
                list2 = WinkSlidMenuPart.this.mStickerMaterials;
                list2.clear();
                hashMap = WinkSlidMenuPart.this.stickerViewMap;
                hashMap.clear();
                WinkSlidMenuPart.this.mAdapterList.clear();
                for (MetaCategory metaCategory : list) {
                    list3 = WinkSlidMenuPart.this.mStickerMaterials;
                    ArrayList<MetaMaterial> arrayList = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "category.materials");
                    list3.addAll(arrayList);
                }
                WinkSlidMenuPart winkSlidMenuPart = WinkSlidMenuPart.this;
                Context context = winkSlidMenuPart.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                winkSlidMenuPart.Ha(context);
            }
        };
        g26.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.dailysign.aw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkSlidMenuPart.Ja(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(WinkSlidMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void La() {
        MetaMaterial metaMaterial = this.selectMaterial;
        if (metaMaterial != null) {
            Iterator<T> it = this.mAdapterList.iterator();
            while (it.hasNext()) {
                ((au) it.next()).e0(metaMaterial);
            }
        }
        at atVar = this.pagerAdapter;
        if (atVar != null) {
            WinkSlidPageView winkSlidPageView = this.winkSlidPageView;
            if (winkSlidPageView != null) {
                winkSlidPageView.setAdapter(atVar);
            }
            if (this.mPageCount <= 1) {
                WinkSlidPageView winkSlidPageView2 = this.winkSlidPageView;
                if (winkSlidPageView2 != null) {
                    winkSlidPageView2.setPageIndicatorVisible(false);
                    return;
                }
                return;
            }
            WinkSlidPageView winkSlidPageView3 = this.winkSlidPageView;
            if (winkSlidPageView3 != null) {
                winkSlidPageView3.setPageIndicatorVisible(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.utg;
    }

    public final void Ga() {
        if (!this.visible) {
            return;
        }
        View view = this.containerView;
        if (view != null) {
            view.setOnClickListener(null);
        }
        View view2 = this.containerView;
        if (view2 != null) {
            view2.setClickable(false);
        }
        super.x9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        Fa().w2();
        View view = this.containerView;
        if (view != null) {
            view.bringToFront();
        }
        View view2 = this.containerView;
        if (view2 != null) {
            view2.setClickable(true);
        }
        View view3 = this.containerView;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.av
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WinkSlidMenuPart.Ka(WinkSlidMenuPart.this, view4);
                }
            });
        }
        La();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.STICKER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        this.containerView = rootView.findViewById(R.id.f86234r4);
        this.winkSlidPageView = (WinkSlidPageView) rootView.findViewById(R.id.f122397du);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Ia();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        WinkSlidPageView winkSlidPageView = this.winkSlidPageView;
        if (winkSlidPageView != null) {
            winkSlidPageView.setAdapter(null);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
