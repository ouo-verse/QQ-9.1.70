package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusCirStGetFeedListRsp implements ISSOReqModel, ISSORspModel<QPlusCirStGetFeedListRsp> {
    public final String feedAttchInfo;
    public final int isFinish;
    public final ArrayList<QPlusCirStFeed> vecFeed;

    public QPlusCirStGetFeedListRsp(ArrayList<QPlusCirStFeed> arrayList, int i3, String str) {
        this.vecFeed = arrayList;
        this.isFinish = i3;
        this.feedAttchInfo = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStGetFeedListRsp decode(e eVar) {
        b l3 = eVar.l("vecFeed");
        ArrayList arrayList = null;
        if (l3 != null) {
            ArrayList arrayList2 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QPlusCirStFeed qPlusCirStFeed = new QPlusCirStFeed(null, null, null, 1023);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList2.add(qPlusCirStFeed.decode((e) d16));
                }
            }
            arrayList = arrayList2;
        }
        return new QPlusCirStGetFeedListRsp(arrayList, eVar.k("isFinish", 0), eVar.q("feedAttchInfo", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusCirStFeed> arrayList = this.vecFeed;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusCirStFeed) it.next()).encode());
            }
        }
        eVar.v("vecFeed", bVar);
        eVar.t("isFinish", this.isFinish);
        eVar.v("feedAttchInfo", this.feedAttchInfo);
        return eVar;
    }
}
