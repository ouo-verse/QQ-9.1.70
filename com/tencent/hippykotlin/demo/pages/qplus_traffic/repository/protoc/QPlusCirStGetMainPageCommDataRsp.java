package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusCirStGetMainPageCommDataRsp implements ISSOReqModel, ISSORspModel<QPlusCirStGetMainPageCommDataRsp> {
    public final String feedAttchInfo;
    public final int feedCount;
    public final int isFinish;
    public final ArrayList<QPlusCirStFeed> vecFeed;

    public QPlusCirStGetMainPageCommDataRsp() {
        this(0, null, 0, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStGetMainPageCommDataRsp decode(e eVar) {
        int k3 = eVar.k(QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, 0);
        b l3 = eVar.l("vecFeed");
        ArrayList arrayList = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (l3 != null) {
            ArrayList arrayList2 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    QPlusCirStFeed qPlusCirStFeed = new QPlusCirStFeed(b18 == true ? 1 : 0, b17 == true ? 1 : 0, b16 == true ? 1 : 0, 1023);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList2.add(qPlusCirStFeed.decode((e) d16));
                }
            }
            arrayList = arrayList2;
        }
        return new QPlusCirStGetMainPageCommDataRsp(k3, arrayList, eVar.k("isFinish", 0), eVar.q("feedAttchInfo", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t(QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, this.feedCount);
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

    public QPlusCirStGetMainPageCommDataRsp(int i3, ArrayList<QPlusCirStFeed> arrayList, int i16, String str) {
        this.feedCount = i3;
        this.vecFeed = arrayList;
        this.isFinish = i16;
        this.feedAttchInfo = str;
    }

    public /* synthetic */ QPlusCirStGetMainPageCommDataRsp(int i3, ArrayList arrayList, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null, 0, "");
    }
}
