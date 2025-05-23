package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import c45.a;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchGroupConditonFilter;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchReqBody;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.kuikly.core.pager.g;
import defpackage.k;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTroopContentNetRepo extends QSearchContentNetRepo {
    public GroupConditonFilterCustom conditionFilter;

    public QSearchTroopContentNetRepo(String str, g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        super(str, gVar, unifySearchTabInfo, z16);
        this.conditionFilter = new GroupConditonFilterCustom(new kuikly.com.tencent.trpcprotocol.search.unifysearch.g(0, null, null, 15), new UnifySearchGroupConditonFilter());
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
        UnifySearchGroupConditonFilter unifySearchGroupConditonFilter = this.conditionFilter.msfFilter;
        orNull = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 0);
        String str5 = (String) orNull;
        String str6 = str5 == null ? "" : str5;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 1);
        String str7 = (String) orNull2;
        return new UnifySearchReqBody(str, str2, unifySearchTabInfo, str3, null, unifySearchGroupConditonFilter, z16, str6, null, str4, str7 == null ? "" : str7, 272);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo
    public final ReqGetSearchResult createReqBody(String str, boolean z16, int i3) {
        Object orNull;
        Object orNull2;
        List base64CodeBatch = Utils.INSTANCE.currentBridgeModule().base64CodeBatch(new String[]{this.lbs, getExtensionData(i3)});
        c cVar = new c(k.a(com.tencent.kuikly.core.manager.c.f117352a) ? 2 : 0, this.studyMode, this.nightMode, 17);
        String str2 = this.appVersion;
        UnifySearchTabInfo unifySearchTabInfo = this.tab;
        a aVar = this.sessionInfo;
        a aVar2 = this.busiSessionInfo;
        orNull = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 0);
        String str3 = (String) orNull;
        String str4 = str3 == null ? "" : str3;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(base64CodeBatch, 1);
        String str5 = (String) orNull2;
        return new ReqGetSearchResult(str, str2, unifySearchTabInfo, aVar, cVar, aVar2, z16, str4, str5 == null ? "" : str5, null, this.conditionFilter.oidbFilter, 512);
    }
}
