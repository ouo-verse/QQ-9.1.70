package com.tencent.mobileqq.zplan.minihome.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yk0.FurnitureDesc;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001\u0010B:\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00020\u0017\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R/\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001b\u001a\u00020\u001f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b%\u0010&R#\u0010,\u001a\n )*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeEditGuideComponent;", "", "", "j", "", HippyTKDListViewAdapter.X, "y", "k", "", "isOwned", "goldCost", "silverCost", "l", "i", "e", "Landroid/widget/RelativeLayout;", "a", "Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "Lyk0/c;", "b", "Lyk0/c;", "guideInfo", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "image", "c", "Lkotlin/jvm/functions/Function1;", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "d", "Lkotlin/Lazy;", tl.h.F, "()Landroid/widget/ImageView;", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomePriceHintView;", "g", "()Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomePriceHintView;", "hintView", "Lcom/tencent/image/URLDrawable;", "kotlin.jvm.PlatformType", "f", "()Lcom/tencent/image/URLDrawable;", "drawable", "<init>", "(Landroid/widget/RelativeLayout;Lyk0/c;Lkotlin/jvm/functions/Function1;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeEditGuideComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final FurnitureDesc guideInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function1<View, Unit> onClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy image;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy hintView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy drawable;

    /* JADX WARN: Multi-variable type inference failed */
    public MiniHomeEditGuideComponent(RelativeLayout container, FurnitureDesc guideInfo, Function1<? super View, Unit> onClick) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(guideInfo, "guideInfo");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.container = container;
        this.guideInfo = guideInfo;
        this.onClick = onClick;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent$image$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                RelativeLayout relativeLayout;
                relativeLayout = MiniHomeEditGuideComponent.this.container;
                return new ImageView(relativeLayout.getContext());
            }
        });
        this.image = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomePriceHintView>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent$hintView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomePriceHintView invoke() {
                RelativeLayout relativeLayout;
                relativeLayout = MiniHomeEditGuideComponent.this.container;
                Context context = relativeLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                return new MiniHomePriceHintView(context, null, 2, null);
            }
        });
        this.hintView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<URLDrawable>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent$drawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final URLDrawable invoke() {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                obtain.mUseApngImage = true;
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_double_bitmap", true);
                bundle.putIntArray("key_tagId_arr", new int[]{1010261});
                obtain.mExtraInfo = bundle;
                return URLDrawable.getDrawable("https://image.superqqshow.qq.com/qq/mini_home/edit_page/edit_mini_home_pointer.png", obtain);
            }
        });
        this.drawable = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URLDrawable f() {
        return (URLDrawable) this.drawable.getValue();
    }

    public final void e() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent$destroy$1
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
                RelativeLayout relativeLayout;
                RelativeLayout relativeLayout2;
                RelativeLayout relativeLayout3;
                RelativeLayout relativeLayout4;
                relativeLayout = MiniHomeEditGuideComponent.this.container;
                if (relativeLayout.indexOfChild(MiniHomeEditGuideComponent.this.h()) != -1) {
                    relativeLayout4 = MiniHomeEditGuideComponent.this.container;
                    relativeLayout4.removeView(MiniHomeEditGuideComponent.this.h());
                }
                relativeLayout2 = MiniHomeEditGuideComponent.this.container;
                if (relativeLayout2.indexOfChild(MiniHomeEditGuideComponent.this.g()) != -1) {
                    relativeLayout3 = MiniHomeEditGuideComponent.this.container;
                    relativeLayout3.removeView(MiniHomeEditGuideComponent.this.g());
                }
            }
        });
    }

    public final MiniHomePriceHintView g() {
        return (MiniHomePriceHintView) this.hintView.getValue();
    }

    public final ImageView h() {
        return (ImageView) this.image.getValue();
    }

    public final void i() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent$hidePrice$1
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
                MiniHomeEditGuideComponent.this.g().setVisibility(8);
            }
        });
    }

    public final void j() {
        CommonExKt.j(new MiniHomeEditGuideComponent$show$1(this));
    }

    public final void k(final int x16, final int y16) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent$updateGuidPosition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                RelativeLayout relativeLayout;
                QLog.i("MiniHomeEditGuideComponent", 1, "updateGuidPosition " + x16 + ", " + y16);
                relativeLayout = this.container;
                int height = relativeLayout.getHeight();
                this.h().setX((float) (x16 + (-62)));
                this.h().setY((float) ((height - y16) + (-62)));
                this.g().setX(this.h().getX() + com.tencent.sqshow.zootopia.utils.i.e(10));
                this.g().setY(this.h().getY() - com.tencent.sqshow.zootopia.utils.i.e(2));
            }
        });
    }

    public final void l(final boolean isOwned, final int goldCost, final int silverCost) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent$updatePrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MiniHomeEditGuideComponent.this.g().setVisibility(isOwned ? 8 : 0);
                MiniHomeEditGuideComponent.this.g().setIsOwned(isOwned);
                MiniHomeEditGuideComponent.this.g().setPrice(goldCost, silverCost);
            }
        });
    }
}
