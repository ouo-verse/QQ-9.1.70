package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusGetLiveAnchorRsp implements ISSOReqModel, ISSORspModel<QPlusGetLiveAnchorRsp> {
    public final ArrayList<QPlusLiveAnchorsKV> liveAnchors;

    public QPlusGetLiveAnchorRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusGetLiveAnchorRsp decode(e eVar) {
        b l3 = eVar.l("live_anchors");
        ArrayList arrayList = null;
        if (l3 != null) {
            ArrayList arrayList2 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    long o16 = eVar2.o("key", 0L);
                    e m3 = eVar2.m("value");
                    arrayList2.add(new QPlusLiveAnchorsKV(o16, m3 != null ? new QPlusLiveStatus(m3.o("uid", 0L), m3.o(AudienceReportConst.ROOM_ID, 0L), m3.k("stat", 0), m3.k("video_begin_timestamp", 0), m3.q("jump_url", ""), m3.q("name", ""), m3.q("head_img_url", ""), m3.q("cover", "")) : null));
                }
            }
            arrayList = arrayList2;
        }
        return new QPlusGetLiveAnchorRsp(arrayList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusLiveAnchorsKV> arrayList = this.liveAnchors;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusLiveAnchorsKV) it.next()).encode());
            }
        }
        eVar.v("live_anchors", bVar);
        return eVar;
    }

    public QPlusGetLiveAnchorRsp(ArrayList<QPlusLiveAnchorsKV> arrayList) {
        this.liveAnchors = arrayList;
    }

    public /* synthetic */ QPlusGetLiveAnchorRsp(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
