package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepageViewModel$updateTree$1$4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ List<UpgradeCard> $upgradeCards;
    public final /* synthetic */ LoveWallHomepageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallHomepageViewModel$updateTree$1$4(List<UpgradeCard> list, LoveWallHomepageViewModel loveWallHomepageViewModel) {
        super(0);
        this.$upgradeCards = list;
        this.this$0 = loveWallHomepageViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        List<UpgradeCard> list = this.$upgradeCards;
        LoveWallHomepageViewModel loveWallHomepageViewModel = this.this$0;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            loveWallHomepageViewModel.upgradeCardQueue.add((UpgradeCard) it.next());
            if (!loveWallHomepageViewModel.isShowingUpgradeCard.getValue().booleanValue()) {
                loveWallHomepageViewModel.showNextUpgradeCard();
            }
        }
        return Unit.INSTANCE;
    }
}
