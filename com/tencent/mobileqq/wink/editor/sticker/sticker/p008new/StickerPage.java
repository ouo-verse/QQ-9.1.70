package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.tabs.TabLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.StickerPanelContentAdapter;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0093\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010!\u001a\u00020\u001e\u0012\b\u0010$\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010%\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u0010-\u001a\u00020+\u0012\b\u00101\u001a\u0004\u0018\u00010.\u0012<\b\u0002\u0010:\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u000106\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u000102\u0012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\u00a2\u0006\u0004\bY\u0010ZJ\"\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100RH\u0010:\u001a6\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u000106\u00a2\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u0001028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010\u001cR\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR*\u0010U\u001a\u00020M2\u0006\u0010N\u001a\u00020M8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010P\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPage;", "Lcom/google/android/material/tabs/TabLayout$d;", "", "tabIndex", "Lkotlin/Function0;", "", "action", "j", "i", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/a;", "data", "p", "f", "itemPos", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "index", DomainData.DOMAIN_NAME, h.F, "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "onTabSelected", "onTabUnselected", "onTabReselected", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "e", "Ljava/lang/String;", "tabCateId", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "fragment", "Lcom/tencent/mobileqq/wink/editor/dr;", "Lcom/tencent/mobileqq/wink/editor/dr;", "winkTavCutDelegate", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;", "stickerViewModel", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "winkEditPerformanceViewModel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "D", "Lkotlin/jvm/functions/Function2;", "onItemClick", "E", "root", "Landroid/support/v7/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroid/support/v7/widget/RecyclerView;", "contentRv", "Lcom/google/android/material/tabs/TabLayout;", "G", "Lcom/google/android/material/tabs/TabLayout;", "categoryTab", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "H", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "contentAdapter", "Landroid/support/v7/widget/GridLayoutManager;", "I", "Landroid/support/v7/widget/GridLayoutManager;", "contentLayoutManager", "", "value", "J", "Z", "getHide", "()Z", "o", "(Z)V", "hide", "K", "attached", "editModeSupplier", "<init>", "(Landroid/view/ViewGroup;Ljava/lang/String;Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;Lcom/tencent/mobileqq/wink/editor/dr;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "L", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StickerPage implements TabLayout.d {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final WinkEditPerformanceViewModel winkEditPerformanceViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final Function2<Integer, MetaMaterial, Unit> onItemClick;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup root;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RecyclerView contentRv;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TabLayout categoryTab;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final StickerPanelContentAdapter contentAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GridLayoutManager contentLayoutManager;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean hide;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean attached;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup parent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String tabCateId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WinkEditorFragment fragment;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final dr winkTavCutDelegate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorViewModel winkEditorViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkEditorStickerViewModel stickerViewModel;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPage$b", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "", c.G, "getSpanSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StickerListData f321799a;

        b(StickerListData stickerListData) {
            this.f321799a = stickerListData;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int pos) {
            String str;
            String e16 = this.f321799a.e(pos);
            if (Intrinsics.areEqual(e16, "qq_small_sticker")) {
                return 2;
            }
            if (Intrinsics.areEqual(e16, "qq_favorite_sticker")) {
                MetaMaterial f16 = this.f321799a.f(pos);
                if (f16 != null) {
                    str = f16.f30533id;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "qq_favor_empty_id")) {
                    return 12;
                }
            }
            return 3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerPage(@NotNull ViewGroup parent, @NotNull String tabCateId, @Nullable WinkEditorFragment winkEditorFragment, @Nullable dr drVar, @NotNull WinkEditorViewModel winkEditorViewModel, @NotNull WinkEditorStickerViewModel stickerViewModel, @Nullable WinkEditPerformanceViewModel winkEditPerformanceViewModel, @Nullable Function2<? super Integer, ? super MetaMaterial, Unit> function2, @NotNull Function0<? extends WinkEditorViewModel.EditMode> editModeSupplier) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(tabCateId, "tabCateId");
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "winkEditorViewModel");
        Intrinsics.checkNotNullParameter(stickerViewModel, "stickerViewModel");
        Intrinsics.checkNotNullParameter(editModeSupplier, "editModeSupplier");
        this.parent = parent;
        this.tabCateId = tabCateId;
        this.fragment = winkEditorFragment;
        this.winkTavCutDelegate = drVar;
        this.winkEditorViewModel = winkEditorViewModel;
        this.stickerViewModel = stickerViewModel;
        this.winkEditPerformanceViewModel = winkEditPerformanceViewModel;
        this.onItemClick = function2;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hdz, parent, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.root = viewGroup;
        View findViewById = viewGroup.findViewById(R.id.u7w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.contentRv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.contentRv = recyclerView;
        View findViewById2 = viewGroup.findViewById(R.id.tox);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.categoryTab)");
        TabLayout tabLayout = (TabLayout) findViewById2;
        this.categoryTab = tabLayout;
        StickerPanelContentAdapter.Companion companion = StickerPanelContentAdapter.INSTANCE;
        String str = this.tabCateId;
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "contentRv.context");
        StickerRvConfig a16 = companion.a(recyclerView, str, winkEditorFragment, drVar, context, winkEditorViewModel, stickerViewModel.getCurrentText(), winkEditPerformanceViewModel, editModeSupplier, new Function3<String, Integer, MetaMaterial, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPage$config$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str2, Integer num, MetaMaterial metaMaterial) {
                invoke(str2, num.intValue(), metaMaterial);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String tabCateId2, int i3, @NotNull MetaMaterial material) {
                WinkEditorStickerViewModel winkEditorStickerViewModel;
                Intrinsics.checkNotNullParameter(tabCateId2, "tabCateId");
                Intrinsics.checkNotNullParameter(material, "material");
                winkEditorStickerViewModel = StickerPage.this.stickerViewModel;
                winkEditorStickerViewModel.r2(tabCateId2, i3, material);
            }
        }, new Function2<Integer, MetaMaterial, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPage$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, MetaMaterial metaMaterial) {
                invoke(num.intValue(), metaMaterial);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable MetaMaterial metaMaterial) {
                Function2 function22;
                function22 = StickerPage.this.onItemClick;
                if (function22 != null) {
                    function22.invoke(Integer.valueOf(i3), metaMaterial);
                }
            }
        }, new Function2<String, Integer, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPage$config$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str2, Integer num) {
                invoke(str2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String tabCateId2, int i3) {
                WinkEditorStickerViewModel winkEditorStickerViewModel;
                Intrinsics.checkNotNullParameter(tabCateId2, "tabCateId");
                winkEditorStickerViewModel = StickerPage.this.stickerViewModel;
                winkEditorStickerViewModel.u2(tabCateId2, i3);
            }
        });
        this.contentLayoutManager = a16.getContentLayoutManager();
        this.contentAdapter = a16.getContentAdapter();
        tabLayout.f(this);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        e.f326265a.y();
    }

    private final void j(final int tabIndex, final Function0<Unit> action) {
        this.categoryTab.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.f
            @Override // java.lang.Runnable
            public final void run() {
                StickerPage.l(tabIndex, this, action);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void k(StickerPage stickerPage, int i3, Function0 function0, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            function0 = null;
        }
        stickerPage.j(i3, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(int i3, StickerPage this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != -1) {
            TabLayout.g B = this$0.categoryTab.B(i3);
            this$0.categoryTab.Q(B);
            if (B != null) {
                aa.a(B, true);
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void f() {
        if (this.attached) {
            return;
        }
        this.attached = true;
        this.parent.addView(this.root);
        this.root.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.e
            @Override // java.lang.Runnable
            public final void run() {
                StickerPage.g();
            }
        });
    }

    public final void h() {
        ViewGroup viewGroup;
        this.attached = false;
        ViewParent parent = this.root.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this.root);
        }
    }

    public final void i() {
        this.contentAdapter.notifyDataSetChanged();
    }

    public final void m(int itemPos) {
        this.contentLayoutManager.scrollToPositionWithOffset(itemPos, 0);
    }

    public final void n(int index) {
        if (this.categoryTab.A() == index) {
            return;
        }
        this.categoryTab.O(this);
        TabLayout tabLayout = this.categoryTab;
        tabLayout.Q(tabLayout.B(index));
        this.categoryTab.f(this);
    }

    public final void o(boolean z16) {
        this.hide = z16;
        if (z16) {
            h();
        } else {
            f();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(@NotNull TabLayout.g tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(@NotNull TabLayout.g tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.stickerViewModel.t2(tab.g());
        aa.a(tab, true);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(@NotNull TabLayout.g tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        aa.a(tab, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f0, code lost:
    
        if (r7 != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(@NotNull StickerListData data) {
        int i3;
        TabLayout.g t16;
        boolean z16;
        String str;
        boolean isBlank;
        boolean startsWith$default;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(data, "data");
        String str2 = data.getTabType().f30532id;
        Intrinsics.checkNotNullExpressionValue(str2, "data.tabType.id");
        this.tabCateId = str2;
        this.contentAdapter.Q0(data.j(), this.contentRv);
        this.contentLayoutManager.setSpanSizeLookup(new b(data));
        TabLayout tabLayout = this.categoryTab;
        if (Intrinsics.areEqual(this.tabCateId, "qq_sticker")) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        tabLayout.setTabGravity(i3);
        this.categoryTab.O(this);
        this.categoryTab.M();
        Iterator<MetaCategory> it = data.d().iterator();
        while (true) {
            Drawable drawable = null;
            if (!it.hasNext()) {
                break;
            }
            MetaCategory next = it.next();
            if (Intrinsics.areEqual(data.getTabType().f30532id, "qq_sticker")) {
                w53.b.a("StickerPage", "set category icon: " + next.thumbUrl);
                TabLayout.g J = this.categoryTab.J();
                if (Intrinsics.areEqual(next.f30532id, "qq_sys_face_sticker")) {
                    drawable = ContextCompat.getDrawable(this.contentRv.getContext(), R.drawable.opp);
                } else if (Intrinsics.areEqual(next.f30532id, "qq_favorite_sticker")) {
                    drawable = ContextCompat.getDrawable(this.contentRv.getContext(), R.drawable.opo);
                } else {
                    String str3 = next.thumbUrl;
                    boolean z17 = false;
                    if (str3 != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
                        if (!isBlank2) {
                            z16 = false;
                            if (!z16) {
                                String str4 = next.thumbUrl;
                                Intrinsics.checkNotNullExpressionValue(str4, "category.thumbUrl");
                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str4, "http", false, 2, null);
                                if (startsWith$default) {
                                    drawable = URLDrawable.getDrawable(next.thumbUrl, URLDrawable.URLDrawableOptions.obtain());
                                }
                            }
                            str = next.thumbUrl;
                            if (str != null) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                            }
                            z17 = true;
                            if (!z17) {
                                drawable = URLDrawable.getFileDrawable(next.thumbUrl, URLDrawable.URLDrawableOptions.obtain());
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                    str = next.thumbUrl;
                    if (str != null) {
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                t16 = J.q(drawable);
            } else {
                t16 = this.categoryTab.J().t(next.name);
            }
            Intrinsics.checkNotNullExpressionValue(t16, "if (data.tabType.id == Q\u2026egory.name)\n            }");
            this.categoryTab.g(t16);
        }
        if (data.getSelectCateNeedAffectContent()) {
            this.categoryTab.f(this);
            k(this, data.getSelectCateIndex(), null, 2, null);
        } else {
            j(data.getSelectCateIndex(), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerPage$showContent$2
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
                    TabLayout tabLayout2;
                    tabLayout2 = StickerPage.this.categoryTab;
                    tabLayout2.f(StickerPage.this);
                }
            });
        }
    }

    public final void q(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        this.contentAdapter.g0(editMode);
    }
}
