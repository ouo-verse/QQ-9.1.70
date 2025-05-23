package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.videocut.model.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import l73.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b\n\u0002\b\u000b*\u0002iq\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\by\u0010zJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\n\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u000e\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J$\u0010!\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\"\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0016\u0010(\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0016\u0010+\u001a\u00020\u00072\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0016\u0010-\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170%H\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.H\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u00105\u001a\u00020\u00072\u0006\u0010/\u001a\u0002022\u0006\u00104\u001a\u000203H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u0010/\u001a\u000202H\u0002R\"\u0010<\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010808078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010;\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010@R\u001b\u0010H\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010;\u001a\u0004\bF\u0010GR\u001b\u0010L\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010;\u001a\u0004\bJ\u0010KR\u001b\u0010O\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010;\u001a\u0004\bN\u0010KR$\u0010U\u001a\u0012\u0012\u0004\u0012\u00020Q0Pj\b\u0012\u0004\u0012\u00020Q`R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010Z\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010;\u001a\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001b\u0010h\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010;\u001a\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u001a\u0010p\u001a\u00020\u00178\u0014X\u0094D\u00a2\u0006\f\n\u0004\bm\u0010c\u001a\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u001b\u0010\u001f\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\bu\u0010v*\u0004\bw\u0010x\u00a8\u0006{"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/a;", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "", "B9", "Lkotlin/Function0;", "", "onStartAction", "onEndAction", "ua", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "ta", "wa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "pa", "Landroid/os/Bundle;", "args", "L9", "", "disableAnim", LocaleUtils.L_JAPANESE, "x9", "onBackEvent", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", ParseCommon.CONTAINER, "Va", "jb", "tb", "fb", "initViewModel", "", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/a;", "it", "nb", "kb", "pageList", "mb", "selectStatus", "sb", "Lcom/google/android/material/tabs/TabLayout;", "tab", "rb", "ob", "Lcom/google/android/material/tabs/TabLayout$g;", "", "id", "qb", "pb", "Lkotlin/Lazy;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "kotlin.jvm.PlatformType", "N", "Lkotlin/Lazy;", "containerDelegate", "Landroid/widget/FrameLayout;", "P", "Xa", "()Landroid/widget/FrameLayout;", "contentLayout", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Za", "pageContainer", BdhLogUtil.LogTag.Tag_Req, "cb", "()Lcom/google/android/material/tabs/TabLayout;", "topTab", ExifInterface.LATITUDE_SOUTH, "ab", "()Landroid/view/View;", "redDot", "T", "Ya", "gradient", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPage;", "Lkotlin/collections/ArrayList;", "U", "Ljava/util/ArrayList;", "pages", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerSearchPage;", "V", "bb", "()Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerSearchPage;", "searchPage", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;", "W", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorStickerViewModel;", "stickerViewModel", "X", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "backToMenuType", "Y", "Z", "isPlaying", "Landroidx/lifecycle/ViewModelProvider;", "eb", "()Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$f", "a0", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$f;", "userBottomSheetCallback", "b0", "X9", "()Z", "autoAnimate", "com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$c", "c0", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$c;", "onTabSelectedListener", "Wa", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getContainer$delegate", "(Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart;)Ljava/lang/Object;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorNewStickerMenuPart extends com.tencent.mobileqq.wink.editor.sticker.sticker.a {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy<CoordinatorLayout> containerDelegate;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageContainer;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy topTab;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy redDot;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy gradient;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<StickerPage> pages;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchPage;

    /* renamed from: W, reason: from kotlin metadata */
    private WinkEditorStickerViewModel stickerViewModel;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private MenuType backToMenuType;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModelProvider;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f userBottomSheetCallback;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final boolean autoAnimate;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c onTabSelectedListener;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$a", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends BottomSheetBehavior.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321841b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<FrameLayout> f321842c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkEditorNewStickerMenuPart f321843d;

        a(Function0<Unit> function0, BottomSheetBehavior<FrameLayout> bottomSheetBehavior, WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart) {
            this.f321841b = function0;
            this.f321842c = bottomSheetBehavior;
            this.f321843d = winkEditorNewStickerMenuPart;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 3) {
                this.f321841b.invoke();
                this.f321842c.removeBottomSheetCallback(this);
                this.f321842c.addBottomSheetCallback(this.f321843d.userBottomSheetCallback);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f321844d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkEditorNewStickerMenuPart f321845e;

        b(View view, WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart) {
            this.f321844d = view;
            this.f321845e = winkEditorNewStickerMenuPart;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f321844d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f321845e.containerDelegate.isInitialized()) {
                WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart = this.f321845e;
                winkEditorNewStickerMenuPart.Va(winkEditorNewStickerMenuPart.Wa());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$c", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements TabLayout.d {
        c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            WinkEditorNewStickerMenuPart.this.pb(tab);
            WinkEditorStickerViewModel winkEditorStickerViewModel = WinkEditorNewStickerMenuPart.this.stickerViewModel;
            if (winkEditorStickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
                winkEditorStickerViewModel = null;
            }
            winkEditorStickerViewModel.x2(tab.g());
            aa.a(tab, true);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            aa.a(tab, false);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$d", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends BottomSheetBehavior.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321847b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<FrameLayout> f321848c;

        d(Function0<Unit> function0, BottomSheetBehavior<FrameLayout> bottomSheetBehavior) {
            this.f321847b = function0;
            this.f321848c = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                this.f321847b.invoke();
                this.f321848c.removeBottomSheetCallback(this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$e", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321850e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f321851f;

        e(Function0<Unit> function0, Function0<Unit> function02) {
            this.f321850e = function0;
            this.f321851f = function02;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WinkEditorNewStickerMenuPart.this.jb(this.f321850e, this.f321851f);
            WinkEditorNewStickerMenuPart.this.Wa().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$f", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends BottomSheetBehavior.e {
        f() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                WinkEditorNewStickerMenuPart.this.ja(true);
                WinkEditorNewStickerMenuPart.this.x9();
            }
        }
    }

    public WinkEditorNewStickerMenuPart() {
        Lazy<CoordinatorLayout> lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoordinatorLayout>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$containerDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CoordinatorLayout invoke() {
                View partRootView = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) partRootView.findViewById(R.id.b8q);
                View partRootView2 = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView2);
                Intrinsics.checkNotNull(partRootView2.getParent(), "null cannot be cast to non-null type android.view.View");
                double measuredHeight = ((View) r1).getMeasuredHeight() * 0.8d;
                if (coordinatorLayout.getLayoutParams().height >= measuredHeight) {
                    coordinatorLayout.getLayoutParams().height = (int) measuredHeight;
                }
                return coordinatorLayout;
            }
        });
        this.containerDelegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$contentLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View partRootView = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (FrameLayout) partRootView.findViewById(R.id.leb);
            }
        });
        this.contentLayout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$pageContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View partRootView = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (FrameLayout) partRootView.findViewById(R.id.f220002j);
            }
        });
        this.pageContainer = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TabLayout>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$topTab$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TabLayout invoke() {
                View partRootView = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return (TabLayout) partRootView.findViewById(R.id.f99655qd);
            }
        });
        this.topTab = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$redDot$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View partRootView = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return partRootView.findViewById(R.id.i4q);
            }
        });
        this.redDot = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$gradient$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View partRootView = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                return partRootView.findViewById(R.id.vrm);
            }
        });
        this.gradient = lazy6;
        this.pages = new ArrayList<>();
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<StickerSearchPage>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$searchPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final StickerSearchPage invoke() {
                WinkEditorFragment F9;
                dr H9;
                WinkEditorStickerViewModel winkEditorStickerViewModel;
                WinkEditorStickerViewModel winkEditorStickerViewModel2;
                WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart = WinkEditorNewStickerMenuPart.this;
                Object partHost = winkEditorNewStickerMenuPart.getPartHost();
                Fragment fragment = partHost instanceof Fragment ? (Fragment) partHost : null;
                LifecycleCoroutineScope lifecycleScope = fragment != null ? LifecycleOwnerKt.getLifecycleScope(fragment) : null;
                F9 = WinkEditorNewStickerMenuPart.this.F9();
                H9 = WinkEditorNewStickerMenuPart.this.H9();
                WinkEditorViewModel G9 = WinkEditorNewStickerMenuPart.this.G9();
                WinkEditorStickerViewModel winkEditorStickerViewModel3 = WinkEditorNewStickerMenuPart.this.stickerViewModel;
                if (winkEditorStickerViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
                    winkEditorStickerViewModel = null;
                } else {
                    winkEditorStickerViewModel = winkEditorStickerViewModel3;
                }
                WinkEditPerformanceViewModel ea5 = WinkEditorNewStickerMenuPart.this.ea();
                View partRootView = WinkEditorNewStickerMenuPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView);
                WinkEditorStickerViewModel winkEditorStickerViewModel4 = WinkEditorNewStickerMenuPart.this.stickerViewModel;
                if (winkEditorStickerViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
                    winkEditorStickerViewModel2 = null;
                } else {
                    winkEditorStickerViewModel2 = winkEditorStickerViewModel4;
                }
                return new StickerSearchPage(winkEditorNewStickerMenuPart, lifecycleScope, F9, H9, G9, winkEditorStickerViewModel, ea5, partRootView, winkEditorStickerViewModel2, null);
            }
        });
        this.searchPage = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ViewModelProvider>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$viewModelProvider$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/sticker/sticker/new/WinkEditorNewStickerMenuPart$viewModelProvider$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ WinkEditorNewStickerMenuPart f321854a;

                a(WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart) {
                    this.f321854a = winkEditorNewStickerMenuPart;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
                    WinkMaterialViewModel aa5;
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    try {
                        if (Intrinsics.areEqual(modelClass, WinkEditorStickerViewModel.class)) {
                            aa5 = this.f321854a.aa();
                            return new WinkEditorStickerViewModel(new StickerMenuDataSourceImpl(aa5, this.f321854a));
                        }
                        return modelClass.newInstance();
                    } catch (IllegalAccessException e16) {
                        throw new RuntimeException("Cannot create an instance of " + modelClass, e16);
                    } catch (InstantiationException e17) {
                        throw new RuntimeException("Cannot create an instance of " + modelClass, e17);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider invoke() {
                return new ViewModelProvider(WinkEditorNewStickerMenuPart.this.getHostFragment(), new a(WinkEditorNewStickerMenuPart.this));
            }
        });
        this.viewModelProvider = lazy8;
        this.userBottomSheetCallback = new f();
        this.onTabSelectedListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Va(View container) {
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView);
        Intrinsics.checkNotNull(partRootView.getParent(), "null cannot be cast to non-null type android.view.View");
        double measuredHeight = ((View) r0).getMeasuredHeight() * 0.8d;
        if (container.getMeasuredHeight() >= measuredHeight) {
            container.getLayoutParams().height = (int) measuredHeight;
            View partRootView2 = getPartRootView();
            Intrinsics.checkNotNull(partRootView2);
            partRootView2.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoordinatorLayout Wa() {
        CoordinatorLayout value = this.containerDelegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-container>(...)");
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout Xa() {
        Object value = this.contentLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-contentLayout>(...)");
        return (FrameLayout) value;
    }

    private final View Ya() {
        Object value = this.gradient.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gradient>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout Za() {
        Object value = this.pageContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pageContainer>(...)");
        return (FrameLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View ab() {
        Object value = this.redDot.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-redDot>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StickerSearchPage bb() {
        return (StickerSearchPage) this.searchPage.getValue();
    }

    private final TabLayout cb() {
        Object value = this.topTab.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-topTab>(...)");
        return (TabLayout) value;
    }

    private final ViewModelProvider eb() {
        return (ViewModelProvider) this.viewModelProvider.getValue();
    }

    private final void fb() {
        Xa().addView(LayoutInflater.from(Xa().getContext()).inflate(R.layout.f168935he1, (ViewGroup) Xa(), false), 0);
        bb();
        int color = ContextCompat.getColor(getContext(), R.color.bd6);
        Ya().setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{color, Color.argb(0, Color.red(color), Color.green(color), Color.blue(color))}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        Fragment fragment;
        LifecycleCoroutineScope lifecycleScope;
        ViewModel viewModel = eb().get(WinkEditorStickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(Wi\u2026kerViewModel::class.java)");
        this.stickerViewModel = (WinkEditorStickerViewModel) viewModel;
        LiveData<Configuration> h36 = G9().h3();
        final Function1<Configuration, Unit> function1 = new Function1<Configuration, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Configuration configuration) {
                ArrayList arrayList;
                arrayList = WinkEditorNewStickerMenuPart.this.pages;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((StickerPage) it.next()).i();
                }
            }
        };
        h36.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorNewStickerMenuPart.gb(Function1.this, obj);
            }
        });
        WinkEditorStickerViewModel winkEditorStickerViewModel = this.stickerViewModel;
        if (winkEditorStickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
            winkEditorStickerViewModel = null;
        }
        LiveData<List<StickerListData>> o26 = winkEditorStickerViewModel.o2();
        final Function1<List<? extends StickerListData>, Unit> function12 = new Function1<List<? extends StickerListData>, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StickerListData> list) {
                invoke2((List<StickerListData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StickerListData> list) {
                if (list != null) {
                    WinkEditorNewStickerMenuPart.this.nb(list);
                    WinkEditorNewStickerMenuPart.this.mb(list);
                }
            }
        };
        o26.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorNewStickerMenuPart.hb(Function1.this, obj);
            }
        });
        Object partHost = getPartHost();
        if (partHost instanceof Fragment) {
            fragment = (Fragment) partHost;
        } else {
            fragment = null;
        }
        if (fragment != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragment)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new WinkEditorNewStickerMenuPart$initViewModel$3(this, null), 3, null);
        }
        LiveData<MenuType> F2 = G9().F2();
        final Function1<MenuType, Unit> function13 = new Function1<MenuType, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MenuType menuType) {
                invoke2(menuType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MenuType menuType) {
                Intrinsics.checkNotNullParameter(menuType, "menuType");
                WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart = WinkEditorNewStickerMenuPart.this;
                if (menuType == winkEditorNewStickerMenuPart.ba()) {
                    winkEditorNewStickerMenuPart.x9();
                }
            }
        };
        F2.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorNewStickerMenuPart.ib(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jb(Function0<Unit> onStartAction, Function0<Unit> onEndAction) {
        BottomSheetBehavior from = BottomSheetBehavior.from(Xa());
        onStartAction.invoke();
        from.addBottomSheetCallback(new a(onEndAction, from, this));
        from.setState(3);
    }

    private final void kb() {
        cb().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.z
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorNewStickerMenuPart.lb(WinkEditorNewStickerMenuPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(WinkEditorNewStickerMenuPart this$0) {
        IntRange until;
        Object obj;
        Object firstOrNull;
        int i3;
        Object obj2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        until = RangesKt___RangesKt.until(0, this$0.cb().C());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = until.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            TabLayout.g B = this$0.cb().B(((IntIterator) it).nextInt());
            if (B != null) {
                obj2 = B.i();
            } else {
                obj2 = null;
            }
            if (Intrinsics.areEqual(obj2, "qq_sticker")) {
                obj = B;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        TabLayout.g gVar = (TabLayout.g) firstOrNull;
        if (gVar != null) {
            View ab5 = this$0.ab();
            if (ar.f326685a.c("ae_key_editor_need_show_qq_emo_sticker_reddot", true)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            ab5.setVisibility(i3);
            Paint paint = new Paint();
            paint.setTextSize(this$0.getContext().getResources().getDimensionPixelSize(R.dimen.djj));
            float measureText = paint.measureText(String.valueOf(gVar.j()));
            gVar.f34288i.getLocationInWindow(new int[2]);
            this$0.ab().setTranslationY(com.tencent.videocut.utils.e.f384236a.a(20.0f));
            float measuredWidth = r4[0] + (gVar.f34288i.getMeasuredWidth() / 2) + (measureText / 2) + ViewExKt.d(4);
            w53.b.f(this$0.TAG, "locateRedDot: " + measuredWidth);
            this$0.ab().setTranslationX(measuredWidth);
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            w53.b.f(this$0.TAG, "locateRedDot: QQ_STICKER_CATEGORY_ID empty ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mb(List<StickerListData> pageList) {
        int collectionSizeOrDefault;
        if (pageList.size() < this.pages.size()) {
            int size = this.pages.size();
            for (int size2 = pageList.size(); size2 < size; size2++) {
                this.pages.remove(2).h();
            }
        } else if (pageList.size() > this.pages.size()) {
            int size3 = pageList.size();
            for (int size4 = this.pages.size(); size4 < size3; size4++) {
                ArrayList<StickerPage> arrayList = this.pages;
                FrameLayout Za = Za();
                String str = pageList.get(size4).getTabType().f30532id;
                Intrinsics.checkNotNullExpressionValue(str, "pageList[i].tabType.id");
                WinkEditorFragment F9 = F9();
                dr H9 = H9();
                WinkEditorViewModel G9 = G9();
                WinkEditorStickerViewModel winkEditorStickerViewModel = this.stickerViewModel;
                if (winkEditorStickerViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
                    winkEditorStickerViewModel = null;
                }
                arrayList.add(new StickerPage(Za, str, F9, H9, G9, winkEditorStickerViewModel, ea(), new Function2<Integer, MetaMaterial, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$refreshStickerPage$1
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
                        if (metaMaterial == null || !(!a.f413927a.j(metaMaterial).isEmpty())) {
                            return;
                        }
                        WinkEditorNewStickerMenuPart.this.isPlaying = true;
                    }
                }, new Function0<WinkEditorViewModel.EditMode>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$refreshStickerPage$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final WinkEditorViewModel.EditMode invoke() {
                        return WinkEditorNewStickerMenuPart.this.G9().getEditMode();
                    }
                }));
            }
        }
        Iterator<StickerListData> it = pageList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            this.pages.get(i3).p(it.next());
            i3++;
        }
        List<StickerListData> list = pageList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Boolean.valueOf(((StickerListData) it5.next()).getSelected()));
        }
        sb(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nb(List<StickerListData> it) {
        cb().O(this.onTabSelectedListener);
        cb().M();
        for (StickerListData stickerListData : it) {
            TabLayout.g t16 = cb().J().t(stickerListData.getTabType().name);
            Intrinsics.checkNotNullExpressionValue(t16, "topTab.newTab().setText(\u2026kerListData.tabType.name)");
            t16.s(stickerListData.getTabType().f30532id);
            cb().g(t16);
        }
        kb();
        cb().f(this.onTabSelectedListener);
    }

    private final void ob(View rootView) {
        View findViewById = rootView.findViewById(R.id.f80524bp);
        if (findViewById != null) {
            Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
            VideoReport.setElementParams(findViewById, params);
            VideoReport.setElementId(findViewById, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_SEARCH_BOX);
            VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(findViewById, EndExposurePolicy.REPORT_NONE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pb(TabLayout.g tab) {
        String str;
        if (Intrinsics.areEqual(tab.i(), "common_sticker")) {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_STICKER_TAB;
        } else {
            str = WinkDaTongReportConstant.ElementId.EM_XSJ_QQ_EXPRESSION_TAB;
        }
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        TabLayout.TabView tabView = tab.f34288i;
        Intrinsics.checkNotNullExpressionValue(tabView, "tab.view");
        com.tencent.mobileqq.wink.report.e.k(eVar, tabView, str, WinkDTParamBuilder.buildElementParams(), null, 8, null);
    }

    private final void qb(TabLayout.g tab, String id5) {
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "dt_imp", tab.f34288i, id5, WinkDTParamBuilder.buildElementParams(), null, 16, null);
    }

    private final void rb(TabLayout tab) {
        if (tab.C() == 2) {
            TabLayout.g B = tab.B(0);
            if (B != null) {
                qb(B, WinkDaTongReportConstant.ElementId.EM_XSJ_STICKER_TAB);
            }
            TabLayout.g B2 = tab.B(1);
            if (B2 != null) {
                qb(B2, WinkDaTongReportConstant.ElementId.EM_XSJ_QQ_EXPRESSION_TAB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sb(List<Boolean> selectStatus) {
        Iterator<Boolean> it = selectStatus.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            boolean booleanValue = it.next().booleanValue();
            this.pages.get(i3).o(!booleanValue);
            TabLayout.g B = cb().B(i3);
            if (B != null) {
                aa.a(B, booleanValue);
            }
            if (booleanValue && cb().A() != i3) {
                cb().Q(B);
            }
            i3 = i16;
        }
    }

    private final void tb(Bundle args) {
        Unit unit;
        String string;
        if (args != null && (string = args.getString("ARGS_BACK_TO_MENU_TYPE")) != null) {
            this.backToMenuType = MenuType.valueOf(string);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.backToMenuType = null;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zpj;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.a, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        if (!getViewStubIsInflated()) {
            return;
        }
        Iterator<StickerPage> it = this.pages.iterator();
        while (it.hasNext()) {
            it.next().q(editMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        Size size;
        Size size2;
        super.L9(args);
        dr H9 = H9();
        WinkEditorStickerViewModel winkEditorStickerViewModel = null;
        if (H9 != null) {
            size = H9.a();
        } else {
            size = null;
        }
        dr H92 = H9();
        if (H92 != null) {
            size2 = H92.getRenderSize();
        } else {
            size2 = null;
        }
        WinkEditorStickerViewModel winkEditorStickerViewModel2 = this.stickerViewModel;
        if (winkEditorStickerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
            winkEditorStickerViewModel2 = null;
        }
        winkEditorStickerViewModel2.G2(G9().getEditMode(), size, size2);
        rb(cb());
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView);
        ob(partRootView);
        tb(args);
        WinkEditorStickerViewModel winkEditorStickerViewModel3 = this.stickerViewModel;
        if (winkEditorStickerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
        } else {
            winkEditorStickerViewModel = winkEditorStickerViewModel3;
        }
        boolean z16 = false;
        winkEditorStickerViewModel.F2(false);
        if (G9().getEditMode() == WinkEditorViewModel.EditMode.Video) {
            dr H93 = H9();
            if (H93 != null) {
                z16 = H93.isPlaying();
            }
            this.isPlaying = z16;
            dr H94 = H9();
            if (H94 != null) {
                H94.pause();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    /* renamed from: X9, reason: from getter */
    protected boolean getAutoAnimate() {
        return this.autoAnimate;
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
        initViewModel();
        fb();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ja(boolean disableAnim) {
        dr H9;
        WinkEditorStickerViewModel winkEditorStickerViewModel = this.stickerViewModel;
        if (winkEditorStickerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
            winkEditorStickerViewModel = null;
        }
        winkEditorStickerViewModel.H2();
        bb().K();
        if (G9().getEditMode() == WinkEditorViewModel.EditMode.Video && G9().D2() == null && this.isPlaying && (H9 = H9()) != null) {
            H9.play();
        }
        super.ja(disableAnim);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            x9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView);
        Object parent = partRootView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        View view = (View) parent;
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void pa() {
        super.pa();
        dr H9 = H9();
        if (H9 != null) {
            H9.pause();
        }
        com.tencent.mobileqq.wink.report.e.f326265a.y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ta(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        BottomSheetBehavior from = BottomSheetBehavior.from(Xa());
        from.removeBottomSheetCallback(this.userBottomSheetCallback);
        onStartAction.invoke();
        from.addBottomSheetCallback(new d(onEndAction, from));
        from.setState(4);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    protected void ua(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        if (Wa().isLaidOut()) {
            jb(onStartAction, onEndAction);
        } else {
            Wa().getViewTreeObserver().addOnGlobalLayoutListener(new e(onStartAction, onEndAction));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.a
    public int wa() {
        return 300;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void x9() {
        MenuType menuType = this.backToMenuType;
        Unit unit = null;
        if (menuType != null) {
            WinkEditorViewModel.v5(G9(), menuType, null, 2, null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.x9();
        }
    }
}
