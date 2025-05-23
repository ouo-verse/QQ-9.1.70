package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import androidx.viewpager2.widget.ViewPager2;
import bl2.HbSkinInfo;
import com.tencent.mobileqq.qwallet.hb.send.model.HbSkinViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "", "Lbl2/c;", "", "pair", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinListFragment$initData$1 extends Lambda implements Function1<Pair<? extends List<? extends HbSkinInfo>, ? extends Boolean>, Unit> {
    final /* synthetic */ HbSkinListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HbSkinListFragment$initData$1(HbSkinListFragment hbSkinListFragment) {
        super(1);
        this.this$0 = hbSkinListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final HbSkinListFragment this$0, final boolean z16, final List skinInfoList, final int i3) {
        ViewPager2 viewPager2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(skinInfoList, "$skinInfoList");
        viewPager2 = this$0.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.s
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinListFragment$initData$1.e(z16, this$0, skinInfoList, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(boolean z16, final HbSkinListFragment this$0, List skinInfoList, int i3) {
        int coerceIn;
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        HbSkinViewModel hbSkinViewModel;
        int indexOf;
        int coerceAtLeast;
        ViewPager2 viewPager23;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(skinInfoList, "$skinInfoList");
        ViewPager2 viewPager24 = null;
        if (!z16) {
            hbSkinViewModel = this$0.viewModel;
            if (hbSkinViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                hbSkinViewModel = null;
            }
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends HbSkinInfo>) ((List<? extends Object>) skinInfoList), hbSkinViewModel.S1().getValue());
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(indexOf, 0);
            viewPager23 = this$0.viewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager23 = null;
            }
            viewPager23.setCurrentItem(coerceAtLeast, false);
        } else {
            coerceIn = RangesKt___RangesKt.coerceIn(i3, 0, skinInfoList.size() - 1);
            viewPager2 = this$0.viewPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(coerceIn, false);
            MobileQQ.sMobileQQ.sendBroadcast(new Intent("com.tencent.mobileqq.qwallet.hb.skin.refresh"));
        }
        viewPager22 = this$0.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager24 = viewPager22;
        }
        viewPager24.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.t
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinListFragment$initData$1.f(HbSkinListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(HbSkinListFragment this$0) {
        ViewPager2 viewPager2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewPager2 = this$0.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.requestTransform();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends HbSkinInfo>, ? extends Boolean> pair) {
        invoke2((Pair<? extends List<HbSkinInfo>, Boolean>) pair);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Pair<? extends List<HbSkinInfo>, Boolean> pair) {
        ViewPager2 viewPager2;
        if (pair == null) {
            return;
        }
        final List<HbSkinInfo> first = pair.getFirst();
        final boolean booleanValue = pair.getSecond().booleanValue();
        viewPager2 = this.this$0.viewPager;
        al2.f fVar = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        final int currentItem = viewPager2.getCurrentItem();
        al2.f fVar2 = this.this$0.hbSkinListAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbSkinListAdapter");
        } else {
            fVar = fVar2;
        }
        final HbSkinListFragment hbSkinListFragment = this.this$0;
        fVar.submitList(first, new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.r
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinListFragment$initData$1.d(HbSkinListFragment.this, booleanValue, first, currentItem);
            }
        });
    }
}
