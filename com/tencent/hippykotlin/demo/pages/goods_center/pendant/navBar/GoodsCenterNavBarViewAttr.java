package com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterNavBarViewAttr extends GoodsCenterPendantAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewAttr.class, "navAreaHeight", "getNavAreaHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewAttr.class, "searchTop", "getSearchTop()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewAttr.class, "searchLeftSpace", "getSearchLeftSpace()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewAttr.class, "navTitleOpacity", "getNavTitleOpacity()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewAttr.class, "isSearching", "isSearching()Z", 0)};
    public final ReadWriteProperty isSearching$delegate;
    public float lastSearchTop;
    public final ReadWriteProperty navAreaHeight$delegate;
    public final Lazy navAreaMaxHeight$delegate;
    public final ReadWriteProperty navTitleOpacity$delegate;
    public final ReadWriteProperty searchLeftSpace$delegate;
    public final Lazy searchMaxTop$delegate;
    public final ReadWriteProperty searchTop$delegate;

    public GoodsCenterNavBarViewAttr() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr$navAreaMaxHeight$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(GoodsCenterNavBarViewAttr.this.getPagerData().getNavigationBarHeight() + 52.0f);
            }
        });
        this.navAreaMaxHeight$delegate = lazy;
        Float valueOf = Float.valueOf(0.0f);
        this.navAreaHeight$delegate = c.a(valueOf);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr$searchMaxTop$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(GoodsCenterNavBarViewAttr.this.getPagerData().getNavigationBarHeight() + 6.0f);
            }
        });
        this.searchMaxTop$delegate = lazy2;
        LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr$searchMinTop$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(GoodsCenterNavBarViewAttr.this.getSearchMaxTop() - 45.0f);
            }
        });
        this.searchTop$delegate = c.a(valueOf);
        this.searchLeftSpace$delegate = c.a(Float.valueOf(16.0f));
        this.navTitleOpacity$delegate = c.a(Float.valueOf(1.0f));
        this.isSearching$delegate = c.a(Boolean.FALSE);
    }

    public final float getSearchMaxTop() {
        return ((Number) this.searchMaxTop$delegate.getValue()).floatValue();
    }

    public final float getSearchTop() {
        return ((Number) this.searchTop$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final boolean isSearching() {
        return ((Boolean) this.isSearching$delegate.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    public final GoodsCenterNavBarViewModel navViewModel() {
        IGoodsCenterPendantViewModel viewModel = getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewModel");
        return (GoodsCenterNavBarViewModel) viewModel;
    }

    public final void setNavAreaHeight(float f16) {
        this.navAreaHeight$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f16));
    }

    public final void setSearchTop(float f16) {
        this.searchTop$delegate.setValue(this, $$delegatedProperties[1], Float.valueOf(f16));
    }
}
