package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusCirStGetFollowListRsp implements ISSOReqModel, ISSORspModel<QPlusCirStGetFollowListRsp> {
    public final String attachInfo;
    public final int hasNext;
    public final ArrayList<QPlusCirStRelationInfo> relationInfo;

    public QPlusCirStGetFollowListRsp(String str, int i3, ArrayList<QPlusCirStRelationInfo> arrayList) {
        this.attachInfo = str;
        this.hasNext = i3;
        this.relationInfo = arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("attachInfo", this.attachInfo);
        eVar.t("hasNext", this.hasNext);
        b bVar = new b();
        ArrayList<QPlusCirStRelationInfo> arrayList = this.relationInfo;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusCirStRelationInfo) it.next()).encode());
            }
        }
        eVar.v("relationInfo", bVar);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStGetFollowListRsp decode(e eVar) {
        ArrayList arrayList;
        String q16 = eVar.q("attachInfo", "");
        int k3 = eVar.k("hasNext", 0);
        b l3 = eVar.l("relationInfo");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new QPlusCirStRelationInfo(eVar2.q("uin", ""), eVar2.k("relation", 0), eVar2.k("relationState", 0), eVar2.k(LocalPhotoFaceInfo.SCORE, 0), eVar2.g("isBlock", false), eVar2.g("isBlocked", false), eVar2.g(IProfileProtocolConst.PARAM_IS_FRIEND, false), eVar2.g("isUncare", false)));
                }
            }
        } else {
            arrayList = null;
        }
        return new QPlusCirStGetFollowListRsp(q16, k3, arrayList);
    }
}
