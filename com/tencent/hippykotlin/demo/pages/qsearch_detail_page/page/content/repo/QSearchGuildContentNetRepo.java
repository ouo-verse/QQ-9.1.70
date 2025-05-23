package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchChannelConditonFilter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchReqBody;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.kuikly.core.pager.g;
import defpackage.k;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function5;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.a;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.c;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGuildContentNetRepo extends QSearchContentNetRepo {
    public a conditionFilter;

    public QSearchGuildContentNetRepo(g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        super(gVar.getAppVersion(), gVar, unifySearchTabInfo, z16);
        this.conditionFilter = new a(0, 0, 7);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo
    public final void loadData(String str, boolean z16, int i3, boolean z17, Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5) {
        super.loadData(str, z16, i3, z17, new QSearchGuildContentNetRepo$loadData$callbackWithRetry$1(10, this, str, i3, function5));
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo
    public final UnifySearchReqBody createMSFReqBody(String str, boolean z16, int i3) {
        Object orNull;
        Object orNull2;
        List base64CodeBatch = Utils.INSTANCE.currentBridgeModule().base64CodeBatch(new String[]{this.lbs, getExtensionData(i3)});
        String str2 = this.appVersion;
        UnifySearchTabInfo unifySearchTabInfo = this.tab;
        String str3 = this.sessionInfoMSF;
        String str4 = this.busiSessionInfoMSf;
        a aVar = this.conditionFilter;
        UnifySearchChannelConditonFilter unifySearchChannelConditonFilter = new UnifySearchChannelConditonFilter(aVar.f413173d, aVar.f413174e);
        orNull = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 0);
        String str5 = (String) orNull;
        String str6 = str5 == null ? "" : str5;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 1);
        String str7 = (String) orNull2;
        return new UnifySearchReqBody(str, str2, unifySearchTabInfo, str3, null, null, z16, str6, unifySearchChannelConditonFilter, str4, str7 == null ? "" : str7, 48);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo
    public final ReqGetSearchResult createReqBody(String str, boolean z16, int i3) {
        Object orNull;
        Object orNull2;
        List base64CodeBatch = Utils.INSTANCE.currentBridgeModule().base64CodeBatch(new String[]{this.lbs, getExtensionData(i3)});
        c cVar = new c(k.a(com.tencent.kuikly.core.manager.c.f117352a) ? 2 : 0, this.studyMode, this.nightMode, 17);
        String str2 = this.appVersion;
        UnifySearchTabInfo unifySearchTabInfo = this.tab;
        c45.a aVar = this.sessionInfo;
        c45.a aVar2 = this.busiSessionInfo;
        orNull = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 0);
        String str3 = (String) orNull;
        String str4 = str3 == null ? "" : str3;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 1);
        String str5 = (String) orNull2;
        return new ReqGetSearchResult(str, str2, unifySearchTabInfo, aVar, cVar, aVar2, z16, str4, str5 == null ? "" : str5, this.conditionFilter, null, 1024);
    }
}
