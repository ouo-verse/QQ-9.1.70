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
public final class QPlusSearchTalentsRsp implements ISSOReqModel, ISSORspModel<QPlusSearchTalentsRsp> {
    public final String attachInfo;
    public final int end;
    public final ArrayList<QPlusUserInfo> talents;

    public QPlusSearchTalentsRsp() {
        this(null, null, 0, 7, null);
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
        eVar.v("attach_info", this.attachInfo);
        eVar.t("end", this.end);
        return eVar;
    }

    public QPlusSearchTalentsRsp(ArrayList<QPlusUserInfo> arrayList, String str, int i3) {
        this.talents = arrayList;
        this.attachInfo = str;
        this.end = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusSearchTalentsRsp decode(e eVar) {
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
        return new QPlusSearchTalentsRsp(arrayList, eVar.q("attach_info", ""), eVar.k("end", 0));
    }

    public /* synthetic */ QPlusSearchTalentsRsp(ArrayList arrayList, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "", 0);
    }
}
