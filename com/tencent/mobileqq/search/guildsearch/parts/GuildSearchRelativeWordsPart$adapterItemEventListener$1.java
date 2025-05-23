package com.tencent.mobileqq.search.guildsearch.parts;

import android.content.Context;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import rp2.a;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrp2/a;", "event", "", "invoke", "(Lrp2/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes18.dex */
final class GuildSearchRelativeWordsPart$adapterItemEventListener$1 extends Lambda implements Function1<rp2.a, Unit> {
    final /* synthetic */ GuildSearchRelativeWordsPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSearchRelativeWordsPart$adapterItemEventListener$1(GuildSearchRelativeWordsPart guildSearchRelativeWordsPart) {
        super(1);
        this.this$0 = guildSearchRelativeWordsPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildSearchRelativeWordsPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("scroll_to_top", "sug_word_click");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(rp2.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull rp2.a event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof a.C11153a) {
            a.C11153a c11153a = (a.C11153a) event;
            SearchDetailFragment.Companion.NetSearchPageParam netSearchPageParam = new SearchDetailFragment.Companion.NetSearchPageParam(c11153a.getWordChangeEvent().getKeyword(), "", 30, 13, false, 3L, "", System.currentTimeMillis(), "", c11153a.getWordChangeEvent().getSugTraceId(), null, 0, 3072, null);
            SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.d(context, netSearchPageParam, "");
            this.this$0.broadcastMessage("MESSAGE_CLEAR_SEARCH_TEXT", "");
            final GuildSearchRelativeWordsPart guildSearchRelativeWordsPart = this.this$0;
            C11736d.b(50, new Runnable() { // from class: com.tencent.mobileqq.search.guildsearch.parts.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildSearchRelativeWordsPart$adapterItemEventListener$1.b(GuildSearchRelativeWordsPart.this);
                }
            });
        }
    }
}
