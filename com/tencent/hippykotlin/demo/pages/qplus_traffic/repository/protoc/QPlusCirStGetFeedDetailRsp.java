package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusCirStGetFeedDetailRsp implements ISSOReqModel, ISSORspModel<QPlusCirStGetFeedDetailRsp> {
    public final QPlusCirStFeed feed;

    public QPlusCirStGetFeedDetailRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStGetFeedDetailRsp decode(e eVar) {
        e m3 = eVar.m("feed");
        QPlusCirStFeed qPlusCirStFeed = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (m3 != null) {
            qPlusCirStFeed = new QPlusCirStFeed(b18 == true ? 1 : 0, b17 == true ? 1 : 0, b16 == true ? 1 : 0, 1023).decode(m3);
        }
        return new QPlusCirStGetFeedDetailRsp(qPlusCirStFeed);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QPlusCirStFeed qPlusCirStFeed = this.feed;
        if (qPlusCirStFeed != null) {
            eVar.v("feed", qPlusCirStFeed.encode());
        }
        return eVar;
    }

    public QPlusCirStGetFeedDetailRsp(QPlusCirStFeed qPlusCirStFeed) {
        this.feed = qPlusCirStFeed;
    }

    public /* synthetic */ QPlusCirStGetFeedDetailRsp(QPlusCirStFeed qPlusCirStFeed, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
