package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusGetTalentsByCategoryRsp implements ISSOReqModel, ISSORspModel<QPlusGetTalentsByCategoryRsp> {
    public final long isLastPage;
    public final int page;
    public final int size;
    public final ArrayList<QPlusUserInfo> talents;
    public final long total;

    public QPlusGetTalentsByCategoryRsp() {
        this(null, 0, 0, 0L, 0L, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusUserInfo> arrayList = this.talents;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusUserInfo) it.next()).encode());
            }
        }
        eVar.v("talents", bVar);
        eVar.t("page", this.page);
        eVar.t("size", this.size);
        eVar.u("total", this.total);
        eVar.u("is_last_page", this.isLastPage);
        return eVar;
    }

    public QPlusGetTalentsByCategoryRsp(ArrayList<QPlusUserInfo> arrayList, int i3, int i16, long j3, long j16) {
        this.talents = arrayList;
        this.page = i3;
        this.size = i16;
        this.total = j3;
        this.isLastPage = j16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusGetTalentsByCategoryRsp decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("talents");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new QPlusUserInfo(eVar2.o("uin", 0L), eVar2.q("nickname", ""), eVar2.q("icon", ""), eVar2.o(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, 0L), eVar2.o("feed_count", 0L), eVar2.g("isBigV", false), eVar2.g("isBlueV", false)));
                }
            }
        } else {
            arrayList = null;
        }
        return new QPlusGetTalentsByCategoryRsp(arrayList, eVar.k("page", 0), eVar.k("size", 0), eVar.o("total", 0L), eVar.o("is_last_page", 0L));
    }

    public /* synthetic */ QPlusGetTalentsByCategoryRsp(ArrayList arrayList, int i3, int i16, long j3, long j16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0, 0, 0L, 0L);
    }
}
