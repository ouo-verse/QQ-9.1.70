package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusInteractData implements ISSOReqModel, ISSORspModel<QPlusInteractData> {
    public final QPlusAudienceDist audienceDist;
    public final ArrayList<QPlusIndex> indexs;
    public final QPlusInteractDist interactDist;

    public QPlusInteractData(ArrayList<QPlusIndex> arrayList, QPlusAudienceDist qPlusAudienceDist, QPlusInteractDist qPlusInteractDist) {
        this.indexs = arrayList;
        this.audienceDist = qPlusAudienceDist;
        this.interactDist = qPlusInteractDist;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusIndex> arrayList = this.indexs;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusIndex) it.next()).encode());
            }
        }
        eVar.v("indexs", bVar);
        QPlusAudienceDist qPlusAudienceDist = this.audienceDist;
        if (qPlusAudienceDist != null) {
            eVar.v("audience_dist", qPlusAudienceDist.encode());
        }
        QPlusInteractDist qPlusInteractDist = this.interactDist;
        if (qPlusInteractDist != null) {
            eVar.v("interact_dist", qPlusInteractDist.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusInteractData decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("indexs");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new QPlusIndex(eVar2.q("index_name", ""), eVar2.k("cnt", 0)));
                }
            }
        } else {
            arrayList = null;
        }
        e m3 = eVar.m("audience_dist");
        QPlusAudienceDist decode = m3 != null ? new QPlusAudienceDist(null, null, null).decode(m3) : null;
        e m16 = eVar.m("interact_dist");
        return new QPlusInteractData(arrayList, decode, m16 != null ? new QPlusInteractDist(null, null, null, null, null).decode(m16) : null);
    }
}
