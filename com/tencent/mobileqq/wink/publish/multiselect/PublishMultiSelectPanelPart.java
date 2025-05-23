package com.tencent.mobileqq.wink.publish.multiselect;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.publish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.wink.publish.part.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u0001:\u0002BCB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J@\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0016J>\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00040\u000fJ\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010(R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020&078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "N9", "initViewModel", "O9", "Lcom/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart$Style;", "style", "", "title", "", "Lcom/tencent/mobileqq/wink/publish/multiselect/e;", "dataList", "Lkotlin/Function1;", "callback", "L9", "originDataList", "", "selectedIndex", "K9", "S9", "T9", "U9", "visibility", "H9", "B9", "R9", "I9", "J9", "onInitView", "", "onBackEvent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "d", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "panelContainer", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "selectPanel", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "panelTopIconLayout", h.F, "Landroid/view/View;", "panelBackground", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "titleTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "contentContainer", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "Lcom/tencent/mobileqq/wink/publish/multiselect/a;", "D", "Lcom/tencent/mobileqq/wink/publish/multiselect/a;", "viewModel", "<init>", "()V", "E", "a", "Style", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishMultiSelectPanelPart extends j {

    /* renamed from: C, reason: from kotlin metadata */
    private BottomSheetBehavior<LinearLayout> bottomSheetBehavior;

    /* renamed from: D, reason: from kotlin metadata */
    private a viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CoordinatorLayout panelContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout selectPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout panelTopIconLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View panelBackground;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout contentContainer;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart$Style;", "", "(Ljava/lang/String;I)V", "STYLE_CHECK", "STYLE_FORWARD", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum Style {
        STYLE_CHECK,
        STYLE_FORWARD
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f325666a;

        static {
            int[] iArr = new int[Style.values().length];
            try {
                iArr[Style.STYLE_CHECK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Style.STYLE_FORWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f325666a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends BottomSheetBehavior.e {
        c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 5) {
                PublishMultiSelectPanelPart.this.H9(8);
                a aVar = PublishMultiSelectPanelPart.this.viewModel;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    aVar = null;
                }
                aVar.M1(false);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/publish/multiselect/PublishMultiSelectPanelPart$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            PublishMultiSelectPanelPart.this.H9(8);
            a aVar = PublishMultiSelectPanelPart.this.viewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar = null;
            }
            aVar.M1(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(int visibility) {
        LinearLayout linearLayout = this.selectPanel;
        CoordinatorLayout coordinatorLayout = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPanel");
            linearLayout = null;
        }
        linearLayout.setVisibility(visibility);
        CoordinatorLayout coordinatorLayout2 = this.panelContainer;
        if (coordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        } else {
            coordinatorLayout = coordinatorLayout2;
        }
        coordinatorLayout.setVisibility(visibility);
    }

    private final List<WinkMultiSelectData> K9(List<WinkMultiSelectData> originDataList, int selectedIndex) {
        int collectionSizeOrDefault;
        boolean z16;
        List<WinkMultiSelectData> list = originDataList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            WinkMultiSelectData winkMultiSelectData = (WinkMultiSelectData) obj;
            if (i3 == selectedIndex) {
                z16 = true;
            } else {
                z16 = false;
            }
            arrayList.add(WinkMultiSelectData.b(winkMultiSelectData, null, null, null, z16, 7, null));
            i3 = i16;
        }
        return arrayList;
    }

    private final void L9(Style style, String title, final List<WinkMultiSelectData> dataList, final Function1<? super List<WinkMultiSelectData>, Unit> callback) {
        boolean isBlank;
        Drawable drawable;
        TextView textView = this.titleTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            textView = null;
        }
        textView.setText(title);
        LinearLayout linearLayout = this.contentContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(48.0f));
        layoutParams.topMargin = ViewUtils.dpToPx(8.0f);
        final int i3 = 0;
        for (Object obj : dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            WinkMultiSelectData winkMultiSelectData = (WinkMultiSelectData) obj;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gur, (ViewGroup) null, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            View findViewById = relativeLayout.findViewById(R.id.f58312po);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qpublish_multi_select_item_icon)");
            ((TextView) relativeLayout.findViewById(R.id.f58332pq)).setText(winkMultiSelectData.getText());
            View findViewById2 = relativeLayout.findViewById(R.id.f58322pp);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qpubli\u2026lect_item_operation_icon)");
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.multiselect.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishMultiSelectPanelPart.M9(Function1.this, this, dataList, i3, view);
                }
            });
            boolean z16 = true;
            if (winkMultiSelectData.getIconDrawable() == null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(winkMultiSelectData.getIconUrl());
                if (!isBlank) {
                    ((URLImageView) findViewById).setBackgroundURL(winkMultiSelectData.getIconUrl());
                } else {
                    QLog.e("PublishMultiSelectPanelPart", 1, "invalid icon path.");
                }
            } else {
                ((URLImageView) findViewById).setImageDrawable(winkMultiSelectData.getIconDrawable());
            }
            int i17 = b.f325666a[style.ordinal()];
            if (i17 != 1) {
                if (i17 == 2) {
                    drawable = getContext().getDrawable(R.drawable.m2m);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                drawable = getContext().getDrawable(R.drawable.l8_);
            }
            ImageView imageView = (ImageView) findViewById2;
            imageView.setImageDrawable(drawable);
            imageView.setVisibility(0);
            if (style != Style.STYLE_CHECK || winkMultiSelectData.getIsChecked()) {
                z16 = false;
            }
            if (z16) {
                imageView.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.contentContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                linearLayout2 = null;
            }
            linearLayout2.addView(relativeLayout, layoutParams);
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 callback, PublishMultiSelectPanelPart this$0, List dataList, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        callback.invoke(this$0.K9(dataList, i3));
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9(View rootView) {
        ViewStub viewStub = (ViewStub) rootView.findViewById(R.id.f58362pt);
        if (viewStub == null) {
            QLog.e(BlockPart.TAG, 1, "viewstub is null");
        }
        if (viewStub != null) {
            View findViewById = viewStub.inflate().findViewById(R.id.f58352ps);
            Intrinsics.checkNotNullExpressionValue(findViewById, "viewStub.inflate().findV\u2026i_select_panel_container)");
            this.panelContainer = (CoordinatorLayout) findViewById;
        }
        View findViewById2 = rootView.findViewById(R.id.f58352ps);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026i_select_panel_container)");
        this.panelContainer = (CoordinatorLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f58342pr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026blish_multi_select_panel)");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        this.selectPanel = linearLayout;
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPanel");
            linearLayout = null;
        }
        BottomSheetBehavior<LinearLayout> from = BottomSheetBehavior.from(linearLayout);
        Intrinsics.checkNotNullExpressionValue(from, "from(selectPanel)");
        this.bottomSheetBehavior = from;
        if (from == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        } else {
            bottomSheetBehavior = from;
        }
        bottomSheetBehavior.addBottomSheetCallback(new c());
        View findViewById4 = rootView.findViewById(R.id.f58382pv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026lish_multi_select_top_rl)");
        this.panelTopIconLayout = (RelativeLayout) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f58392pw);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026multi_select_transparent)");
        this.panelBackground = findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f58372pu);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026sh_multi_select_title_tv)");
        this.titleTextView = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f58302pn);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026_multi_content_container)");
        this.contentContainer = (LinearLayout) findViewById7;
    }

    private final void O9() {
        RelativeLayout relativeLayout = this.panelTopIconLayout;
        View view = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelTopIconLayout");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.multiselect.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PublishMultiSelectPanelPart.P9(PublishMultiSelectPanelPart.this, view2);
            }
        });
        View view2 = this.panelBackground;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelBackground");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.multiselect.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PublishMultiSelectPanelPart.Q9(PublishMultiSelectPanelPart.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(PublishMultiSelectPanelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(PublishMultiSelectPanelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S9() {
        QLog.d("PublishMultiSelectPanelPart", 1, "JurisdictionPanel is showing.");
        SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(false));
        H9(0);
        a aVar = this.viewModel;
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        aVar.M1(true);
        T9();
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior2 = this.bottomSheetBehavior;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        } else {
            bottomSheetBehavior = bottomSheetBehavior2;
        }
        bottomSheetBehavior.setState(3);
    }

    private final void T9() {
        QLog.d("PublishMultiSelectPanelPart", 1, "start multiselect panel enter animation");
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154922tr);
        LinearLayout linearLayout = this.selectPanel;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPanel");
            linearLayout = null;
        }
        linearLayout.clearAnimation();
        LinearLayout linearLayout3 = this.selectPanel;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPanel");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.startAnimation(loadAnimation);
    }

    private final void U9() {
        QLog.d("PublishMultiSelectPanelPart", 2, "start multiselect panel exit animation");
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154923ts);
        loadAnimation.setAnimationListener(new d());
        LinearLayout linearLayout = this.selectPanel;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPanel");
            linearLayout = null;
        }
        linearLayout.clearAnimation();
        LinearLayout linearLayout3 = this.selectPanel;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPanel");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.startAnimation(loadAnimation);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(MultiSelect\u2026nelViewModel::class.java)");
        this.viewModel = (a) viewModel;
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishMultiSelectPanelPart";
    }

    public final void I9() {
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        if (!aVar.getIsShowing()) {
            return;
        }
        QLog.d("PublishMultiSelectPanelPart", 1, "JurisdictionPanel is closing.");
        U9();
    }

    @Nullable
    public final View J9() {
        CoordinatorLayout coordinatorLayout = this.panelContainer;
        if (coordinatorLayout == null) {
            return null;
        }
        if (coordinatorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            coordinatorLayout = null;
        }
        return coordinatorLayout;
    }

    public final void R9(@NotNull Style style, @NotNull String title, @NotNull List<WinkMultiSelectData> dataList, @NotNull Function1<? super List<WinkMultiSelectData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        if (!aVar.getIsShowing() && !getActivity().isFinishing()) {
            L9(style, title, dataList, callback);
            S9();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        if (aVar.getIsShowing()) {
            I9();
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        N9(rootView);
        initViewModel();
        O9();
    }
}
