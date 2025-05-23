package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.util.InputMethodUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "state", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class FeedBatchManageSearchLayerPart$bindSearchBarUserIntent$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ QUISearchBar $searchBar;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBatchManageSearchLayerPart$bindSearchBarUserIntent$3(QUISearchBar qUISearchBar) {
        super(1);
        this.$searchBar = qUISearchBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QUISearchBar searchBar) {
        Intrinsics.checkNotNullParameter(searchBar, "$searchBar");
        searchBar.getInputWidget().requestFocus();
        InputMethodUtil.show(searchBar.getInputWidget());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num) {
        if (num != null && num.intValue() == 0) {
            this.$searchBar.getInputWidget().getText().clear();
        } else if (num != null && num.intValue() == 1) {
            final QUISearchBar qUISearchBar = this.$searchBar;
            qUISearchBar.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    FeedBatchManageSearchLayerPart$bindSearchBarUserIntent$3.b(QUISearchBar.this);
                }
            }, 100L);
        }
    }
}
