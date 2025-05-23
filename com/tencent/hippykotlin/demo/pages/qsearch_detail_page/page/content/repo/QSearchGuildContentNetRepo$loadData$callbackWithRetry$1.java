package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGuildContentNetRepo$loadData$callbackWithRetry$1 extends Lambda implements Function5<Boolean, Boolean, List<? extends ISearchItemModel>, String, e, Unit> {
    public final /* synthetic */ Function5<Boolean, Boolean, List<? extends ISearchItemModel>, String, e, Unit> $callback;
    public final /* synthetic */ String $keyword;
    public final /* synthetic */ int $querySource;
    public final /* synthetic */ int $retryCount;
    public final /* synthetic */ QSearchGuildContentNetRepo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QSearchGuildContentNetRepo$loadData$callbackWithRetry$1(int i3, QSearchGuildContentNetRepo qSearchGuildContentNetRepo, String str, int i16, Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5) {
        super(5);
        this.$retryCount = i3;
        this.this$0 = qSearchGuildContentNetRepo;
        this.$keyword = str;
        this.$querySource = i16;
        this.$callback = function5;
    }

    @Override // kotlin.jvm.functions.Function5
    public final Unit invoke(Boolean bool, Boolean bool2, List<? extends ISearchItemModel> list, String str, e eVar) {
        int i3;
        boolean booleanValue = bool.booleanValue();
        boolean booleanValue2 = bool2.booleanValue();
        List<? extends ISearchItemModel> list2 = list;
        String str2 = str;
        e eVar2 = eVar;
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadData ");
        sb5.append(booleanValue);
        sb5.append(" end:");
        sb5.append(booleanValue2);
        sb5.append(" size:");
        sb5.append(list2 != null ? Integer.valueOf(list2.size()) : null);
        sb5.append(" retryCount:");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(sb5, this.$retryCount, kLog, "QSearchGuildContentNetRepo");
        if (booleanValue) {
            if ((list2 != null && list2.isEmpty()) && (i3 = this.$retryCount) > 0 && !booleanValue2) {
                QSearchGuildContentNetRepo qSearchGuildContentNetRepo = this.this$0;
                String str3 = this.$keyword;
                int i16 = this.$querySource;
                qSearchGuildContentNetRepo.loadMoreData(str3, false, i16, new QSearchGuildContentNetRepo$loadData$callbackWithRetry$1(i3 - 1, qSearchGuildContentNetRepo, str3, i16, this.$callback));
                return Unit.INSTANCE;
            }
        }
        this.$callback.invoke(Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), list2, str2, eVar2);
        return Unit.INSTANCE;
    }
}
