package com.tencent.ecommerce.biz.live.ui.viewholder;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperViewHolder;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECOnDragSortListener;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%Bw\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0018j\u0002`\u0019\u0012\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0018j\u0002`\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0018j\u0002`\u0019\u0012\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0018j\u0002`\u0019\u00a2\u0006\u0004\b\"\u0010#J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J2\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0018j\u0002`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0018j\u0002`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECNormalMasterLiveItemViewHolder;", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECNormalBaseLiveItemViewHolder;", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECItemTouchHelperViewHolder;", "", "position", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", "y0", "z0", "onItemSelected", "onItemClear", "", "isEditable", "", "", "payloads", "t", "x0", "Z", "isStartDrag", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;", "dragSortListener", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/CustomClick;", "Lkotlin/jvm/functions/Function1;", "onSelectClick", "A0", "onSellingPointClick", "Landroid/view/View;", "itemView", "onItemClick", "onActionClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "G0", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECNormalMasterLiveItemViewHolder extends ECNormalBaseLiveItemViewHolder implements ECItemTouchHelperViewHolder {
    private static final Lazy B0;
    private static final Lazy C0;
    private static final Lazy D0;
    private static final Lazy E0;
    private static final Lazy F0;

    /* renamed from: G0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A0, reason: from kotlin metadata */
    private final Function1<LiveProduct, Unit> onSellingPointClick;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private boolean isStartDrag;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private final ECOnDragSortListener dragSortListener;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private final Function1<LiveProduct, Unit> onSelectClick;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "motionEvent", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            ECNormalMasterLiveItemViewHolder.this.dragSortListener.onStartDrag(ECNormalMasterLiveItemViewHolder.this);
            ECNormalMasterLiveItemViewHolder.this.isStartDrag = true;
            ei0.d.f396304b.u(ECNormalMasterLiveItemViewHolder.this.getReorderButton(), ECNormalMasterLiveItemViewHolder.this.getCurrentLiveProduct());
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECMasterLiveItemViewHolder", "selectCheckBox onClickListener: " + ECNormalMasterLiveItemViewHolder.this.getCurrentLiveProduct());
            LiveProduct currentLiveProduct = ECNormalMasterLiveItemViewHolder.this.getCurrentLiveProduct();
            if (currentLiveProduct != null) {
                ECNormalMasterLiveItemViewHolder.this.onSelectClick.invoke(currentLiveProduct);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECMasterLiveItemViewHolder", "adTextView onClickListener: " + ECNormalMasterLiveItemViewHolder.this.getCurrentLiveProduct());
            LiveProduct currentLiveProduct = ECNormalMasterLiveItemViewHolder.this.getCurrentLiveProduct();
            if (currentLiveProduct != null) {
                ECNormalMasterLiveItemViewHolder.this.onSellingPointClick.invoke(currentLiveProduct);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECNormalMasterLiveItemViewHolder$d;", "", "", "EDIT_ICON_SIZE$delegate", "Lkotlin/Lazy;", "b", "()I", "EDIT_ICON_SIZE", "EDIT_ICON_PADDING_SIZE$delegate", "a", "EDIT_ICON_PADDING_SIZE", "EXPAND_CLICK_AREA$delegate", "c", "EXPAND_CLICK_AREA", "ROOT_HORIZONTAL_PADDING$delegate", "d", "ROOT_HORIZONTAL_PADDING", "ROOT_VERTICAL_PADDING$delegate", "e", "ROOT_VERTICAL_PADDING", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalMasterLiveItemViewHolder$d, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return ((Number) ECNormalMasterLiveItemViewHolder.C0.getValue()).intValue();
        }

        public final int b() {
            return ((Number) ECNormalMasterLiveItemViewHolder.B0.getValue()).intValue();
        }

        public final int c() {
            return ((Number) ECNormalMasterLiveItemViewHolder.D0.getValue()).intValue();
        }

        public final int d() {
            return ((Number) ECNormalMasterLiveItemViewHolder.E0.getValue()).intValue();
        }

        public final int e() {
            return ((Number) ECNormalMasterLiveItemViewHolder.F0.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalMasterLiveItemViewHolder$Companion$EDIT_ICON_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(10.0f);
            }
        });
        B0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalMasterLiveItemViewHolder$Companion$EDIT_ICON_PADDING_SIZE$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(2.0f);
            }
        });
        C0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalMasterLiveItemViewHolder$Companion$EXPAND_CLICK_AREA$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(20.0f);
            }
        });
        D0 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalMasterLiveItemViewHolder$Companion$ROOT_HORIZONTAL_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(16.0f);
            }
        });
        E0 = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalMasterLiveItemViewHolder$Companion$ROOT_VERTICAL_PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return com.tencent.ecommerce.biz.util.e.c(8.0f);
            }
        });
        F0 = lazy5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECNormalMasterLiveItemViewHolder(View view, Function1<? super LiveProduct, Unit> function1, Function1<? super LiveProduct, Unit> function12, ECOnDragSortListener eCOnDragSortListener, Function1<? super LiveProduct, Unit> function13, Function1<? super LiveProduct, Unit> function14) {
        super(view, function1, function12);
        this.dragSortListener = eCOnDragSortListener;
        this.onSelectClick = function13;
        this.onSellingPointClick = function14;
        getReorderButton().setOnTouchListener(new a());
        getSelectCheckBox().setOnClickListener(new b());
        getSecondTitleTextView().setOnClickListener(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void y0(int position, LiveProduct liveProduct) {
        boolean z16;
        boolean isBlank;
        boolean z17 = false;
        getSelectCheckBox().setVisibility(0);
        ImageView selectCheckBox = getSelectCheckBox();
        Companion companion = INSTANCE;
        ViewExtKt.a(selectCheckBox, companion.c());
        getReorderButton().setVisibility(0);
        ECSkin eCSkin = ECSkin.INSTANCE;
        Drawable drawable = eCSkin.getDrawable(R.drawable.eea);
        if (drawable != null) {
            drawable.setBounds(new Rect(0, 0, companion.b(), companion.b()));
        }
        getSecondTitleTextView().setCompoundDrawables(drawable, null, null, null);
        getSecondTitleTextView().setCompoundDrawablePadding(com.tencent.ecommerce.biz.util.e.c(3.0f));
        getSecondTitleTextView().setBackground(new ColorDrawable(eCSkin.getColor(R.color.f6832m)));
        getSecondTitleTextView().setPadding(com.tencent.ecommerce.biz.util.e.c(4.0f), 0, com.tencent.ecommerce.biz.util.e.c(4.0f), 0);
        String adTxt = liveProduct != null ? liveProduct.getAdTxt() : null;
        if (adTxt != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(adTxt);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    getSecondTitleTextView().setText(getContext().getText(R.string.wlg));
                } else {
                    getSecondTitleTextView().setText(liveProduct != null ? liveProduct.getAdTxt() : null);
                }
                ViewExtKt.a(getSecondTitleTextView(), companion.c());
                getSecondTitleTextView().setVisibility(0);
                getThirdTitleTextView().setVisibility(8);
                getActionButton().setVisibility(8);
                ImageView selectCheckBox2 = getSelectCheckBox();
                if (liveProduct != null && liveProduct.getIsSelected()) {
                    z17 = true;
                }
                selectCheckBox2.setSelected(z17);
                ei0.d dVar = ei0.d.f396304b;
                dVar.j(getSelectCheckBox(), liveProduct);
                dVar.k(getSecondTitleTextView(), liveProduct);
                dVar.e(getReorderButton(), liveProduct);
            }
        }
        z16 = true;
        if (!z16) {
        }
        ViewExtKt.a(getSecondTitleTextView(), companion.c());
        getSecondTitleTextView().setVisibility(0);
        getThirdTitleTextView().setVisibility(8);
        getActionButton().setVisibility(8);
        ImageView selectCheckBox22 = getSelectCheckBox();
        if (liveProduct != null) {
            z17 = true;
        }
        selectCheckBox22.setSelected(z17);
        ei0.d dVar2 = ei0.d.f396304b;
        dVar2.j(getSelectCheckBox(), liveProduct);
        dVar2.k(getSecondTitleTextView(), liveProduct);
        dVar2.e(getReorderButton(), liveProduct);
    }

    private final void z0(int position, LiveProduct liveProduct) {
        boolean z16;
        boolean isBlank;
        getSelectCheckBox().setVisibility(8);
        getReorderButton().setVisibility(8);
        getSecondTitleTextView().setCompoundDrawables(null, null, null, null);
        getSecondTitleTextView().setCompoundDrawablePadding(INSTANCE.a());
        getSecondTitleTextView().setBackground(null);
        boolean z17 = false;
        getSecondTitleTextView().setPadding(0, 0, 0, 0);
        b0(liveProduct);
        getActionButton().setVisibility(0);
        if (liveProduct != null && liveProduct.getIsExplaining()) {
            getActionButton().setText(getContext().getText(R.string.wlu));
            getActionButton().setSelected(true);
            getActionButton().setEnabled(true);
        } else {
            getActionButton().setText(getContext().getText(R.string.wlt));
            getActionButton().setSelected(false);
            Button actionButton = getActionButton();
            String statusTxt = liveProduct != null ? liveProduct.getStatusTxt() : null;
            if (statusTxt != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(statusTxt);
                if (!isBlank) {
                    z16 = false;
                    if (z16 && liveProduct != null && liveProduct.getStatus() == 1 && !liveProduct.I()) {
                        z17 = true;
                    }
                    actionButton.setEnabled(z17);
                }
            }
            z16 = true;
            if (z16) {
                z17 = true;
            }
            actionButton.setEnabled(z17);
        }
        ei0.d.f396304b.f(getActionButton(), liveProduct);
    }

    @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperViewHolder
    public void onItemClear() {
        cg0.a.b("ECMasterLiveItemViewHolder", "onItemClear");
        getItemRoot().setBackground(new ColorDrawable(0));
        if (this.isStartDrag) {
            this.dragSortListener.onDragEnd(this);
            this.isStartDrag = false;
        }
        FrameLayout itemRoot = getItemRoot();
        Companion companion = INSTANCE;
        itemRoot.setPadding(companion.d(), companion.e(), companion.d(), companion.e());
    }

    @Override // com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperViewHolder
    public void onItemSelected() {
        cg0.a.b("ECMasterLiveItemViewHolder", "onItemSelected");
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNightManager().isNightMode()) {
            getItemRoot().setBackground(getContext().getDrawable(R.drawable.e5g));
        } else {
            getItemRoot().setBackground(getContext().getDrawable(R.drawable.e5f));
        }
        FrameLayout itemRoot = getItemRoot();
        Companion companion = INSTANCE;
        itemRoot.setPadding(companion.d(), companion.e(), companion.d(), companion.e());
    }

    @Override // com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder, com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder
    public void t(int position, LiveProduct liveProduct, boolean isEditable, List<Object> payloads) {
        super.t(position, liveProduct, isEditable, payloads);
        if (isEditable) {
            y0(position, liveProduct);
        } else {
            z0(position, liveProduct);
        }
    }
}
