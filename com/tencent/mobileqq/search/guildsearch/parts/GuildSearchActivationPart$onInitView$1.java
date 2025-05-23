package com.tencent.mobileqq.search.guildsearch.parts;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
final class GuildSearchActivationPart$onInitView$1 extends Lambda implements Function1<List<? extends ListBaseData>, Unit> {
    final /* synthetic */ GuildSearchActivationPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSearchActivationPart$onInitView$1(GuildSearchActivationPart guildSearchActivationPart) {
        super(1);
        this.this$0 = guildSearchActivationPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, GuildSearchActivationPart this$0, List list) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("QQSearch.Local.Guild.GuildSearchActivationPart", 1, "firstItemPos=" + i3 + " submit list.size=" + list.size() + " ");
        RecyclerView recyclerView3 = null;
        if (i3 == 0) {
            recyclerView2 = this$0.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            recyclerView2.scrollToPosition(0);
        }
        recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView3 = recyclerView;
        }
        VideoReport.traversePage(recyclerView3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ListBaseData> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<? extends ListBaseData> list) {
        RecyclerView recyclerView;
        GuildSearchActivationPart.c cVar;
        recyclerView = this.this$0.recyclerView;
        GuildSearchActivationPart.c cVar2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager");
        final int findFirstVisibleItemPosition = ((SafeLinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        cVar = this.this$0.entryListAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entryListAdapter");
        } else {
            cVar2 = cVar;
        }
        final GuildSearchActivationPart guildSearchActivationPart = this.this$0;
        cVar2.setItems(list, new Runnable() { // from class: com.tencent.mobileqq.search.guildsearch.parts.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildSearchActivationPart$onInitView$1.b(findFirstVisibleItemPosition, guildSearchActivationPart, list);
            }
        });
    }
}
