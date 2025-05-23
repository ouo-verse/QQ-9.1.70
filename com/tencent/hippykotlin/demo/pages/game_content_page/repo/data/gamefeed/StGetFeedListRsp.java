package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.feedcloud.LoadMoreFeedStatus;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.feedcloud.StUser;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StGetFeedListRsp implements ISSOReqModel, ISSORspModel<StGetFeedListRsp> {
    public final String adAttchInfo;
    public final String busiRspData;
    public final ArrayList<GameFeed> feed;
    public final String feedAttchInfo;
    public final int isFinish;
    public final boolean isFirstLogin;
    public final LoadMoreFeedStatus loadMoreStatus;
    public final StUser user;

    public StGetFeedListRsp(ArrayList<GameFeed> arrayList, int i3, StUser stUser, String str, String str2, String str3, boolean z16, LoadMoreFeedStatus loadMoreFeedStatus) {
        this.feed = arrayList;
        this.isFinish = i3;
        this.user = stUser;
        this.adAttchInfo = str;
        this.feedAttchInfo = str2;
        this.busiRspData = str3;
        this.isFirstLogin = z16;
        this.loadMoreStatus = loadMoreFeedStatus;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<GameFeed> arrayList = this.feed;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((GameFeed) it.next()).encode());
            }
        }
        eVar.v("feed", bVar);
        eVar.t("isFinish", this.isFinish);
        StUser stUser = this.user;
        if (stUser != null) {
            eVar.v(QCircleAlphaUserReporter.KEY_USER, stUser.encode());
        }
        eVar.v("adAttchInfo", this.adAttchInfo);
        eVar.v("feedAttchInfo", this.feedAttchInfo);
        eVar.v("busiRspData", this.busiRspData);
        eVar.w("isFirstLogin", this.isFirstLogin);
        LoadMoreFeedStatus loadMoreFeedStatus = this.loadMoreStatus;
        if (loadMoreFeedStatus != null) {
            eVar.v("load_more_status", loadMoreFeedStatus.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final StGetFeedListRsp decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("feed");
        if (l3 != null) {
            ArrayList arrayList2 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    GameFeed gameFeed = new GameFeed(null, null, null, null, null, 0L, null, null, null, null, null, null, 4095, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList2.add(gameFeed.decode((e) d16));
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        int k3 = eVar.k("isFinish", 0);
        e m3 = eVar.m(QCircleAlphaUserReporter.KEY_USER);
        StUser decode = m3 != null ? new StUser("", "", "", 0, 0, 0, 0L, "", "", "", 0, 0, 0, 0, "", "", "", "", "", 0, false, "", "", 0, 0L, 0L, 0L, 0L, 0, "", "").decode(m3) : null;
        String q16 = eVar.q("adAttchInfo", "");
        String q17 = eVar.q("feedAttchInfo", "");
        String q18 = eVar.q("busiRspData", "");
        boolean g16 = eVar.g("isFirstLogin", false);
        e m16 = eVar.m("load_more_status");
        return new StGetFeedListRsp(arrayList, k3, decode, q16, q17, q18, g16, m16 != null ? new LoadMoreFeedStatus(m16.g("can_page_up", false), m16.q("page_up_attach_info", "")) : null);
    }
}
