package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.quicksearch.model.GuildSearchActionSource;
import com.tencent.mobileqq.guild.quicksearch.model.SearchData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zg1.TextData;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/d;", "kotlin.jvm.PlatformType", "searchData", "", "invoke", "(Lcom/tencent/mobileqq/guild/quicksearch/model/d;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedListPart$initViewModel$1 extends Lambda implements Function1<SearchData, Unit> {
    final /* synthetic */ QuickSearchFeedListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSearchFeedListPart$initViewModel$1(QuickSearchFeedListPart quickSearchFeedListPart) {
        super(1);
        this.this$0 = quickSearchFeedListPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SearchData searchData, QuickSearchFeedListPart this$0) {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (searchData.getSource() != GuildSearchActionSource.LOAD_MORE) {
            overScrollRecyclerViewWithHeaderFooter = this$0.feedListView;
            if (overScrollRecyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedListView");
                overScrollRecyclerViewWithHeaderFooter = null;
            }
            overScrollRecyclerViewWithHeaderFooter.scrollToPosition(0);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchData searchData) {
        invoke2(searchData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final SearchData searchData) {
        List<zg1.a> b16;
        com.tencent.mobileqq.guild.quicksearch.adapter.c F9;
        QuickSearchAICardAdapter E9;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QuickSearchFeedListPart", "searchData(" + searchData.getSource() + ") " + searchData.b().size() + " " + searchData.getAiSearchInfo());
        }
        if (searchData.getSource() != GuildSearchActionSource.LOAD_MORE) {
            E9 = this.this$0.E9();
            E9.p0(searchData.getAiSearchInfo());
        }
        if (searchData.e()) {
            List<zg1.a> b17 = searchData.b();
            String qqStr = HardCodeUtil.qqStr(R.string.f152661a0);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_quick_search_no_more_hint)");
            b16 = CollectionsKt___CollectionsKt.plus((Collection<? extends TextData>) ((Collection<? extends Object>) b17), new TextData(qqStr, zg1.a.INSTANCE.b()));
        } else {
            b16 = searchData.b();
        }
        F9 = this.this$0.F9();
        final QuickSearchFeedListPart quickSearchFeedListPart = this.this$0;
        F9.setItems(b16, new Runnable() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.o
            @Override // java.lang.Runnable
            public final void run() {
                QuickSearchFeedListPart$initViewModel$1.b(SearchData.this, quickSearchFeedListPart);
            }
        });
    }
}
