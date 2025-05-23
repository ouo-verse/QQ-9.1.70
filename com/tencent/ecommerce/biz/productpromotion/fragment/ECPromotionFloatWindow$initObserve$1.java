package com.tencent.ecommerce.biz.productpromotion.fragment;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import yj0.ECPromoteItem;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u000520\u0010\u0004\u001a,\u0012\u0004\u0012\u00020\u0001 \u0003*\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00020\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/util/ArrayList;", "Lyj0/c;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/ArrayList;)V"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECPromotionFloatWindow$initObserve$1<T> implements Observer<ArrayList<ECPromoteItem>> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECPromotionFloatWindow f103940d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECPromotionFloatWindow$initObserve$1(ECPromotionFloatWindow eCPromotionFloatWindow) {
        this.f103940d = eCPromotionFloatWindow;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onChanged(ArrayList<ECPromoteItem> arrayList) {
        IECSchemeCallback iECSchemeCallback;
        int size = arrayList.size();
        if (size == 0) {
            ECPromotionFloatWindow.Oh(this.f103940d).setSucceededState();
            final g gVar = new g(this.f103940d.requireContext());
            gVar.setTitle("");
            gVar.Y("\u4f60\u8fd8\u6ca1\u6709\u63a8\u5e7f\u6743\u9650");
            gVar.b0("");
            gVar.a0(null);
            gVar.f0(gVar.getContext().getResources().getString(R.string.wo7));
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.productpromotion.fragment.ECPromotionFloatWindow$initObserve$1$$special$$inlined$apply$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    g.this.dismiss();
                    FragmentActivity activity = this.f103940d.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
            gVar.c0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.productpromotion.fragment.ECPromotionFloatWindow$initObserve$1$$special$$inlined$apply$lambda$2
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
                    g.this.dismiss();
                    FragmentActivity activity = this.f103940d.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
            gVar.show();
            return;
        }
        if (size != 1) {
            ECPromotionFloatWindow.Oh(this.f103940d).setSucceededState();
            ECPromotionFloatWindow.Oh(this.f103940d).setVisibility(8);
            ECPromotionFloatWindow.Lh(this.f103940d).setData(arrayList);
            ECPromotionFloatWindow.Mh(this.f103940d).setVisibility(0);
            this.f103940d.Rh();
            return;
        }
        String str = arrayList.get(0).url;
        iECSchemeCallback = this.f103940d.promotionProductCallback;
        ECScheme.f(str, iECSchemeCallback, null, 4, null);
        FragmentActivity activity = this.f103940d.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
