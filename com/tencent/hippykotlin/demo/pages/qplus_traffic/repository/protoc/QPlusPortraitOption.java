package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes31.dex */
public final class QPlusPortraitOption implements ISSOReqModel, ISSORspModel<QPlusPortraitOption> {
    public final ArrayList<String> portraitUrl;

    public QPlusPortraitOption(ArrayList<String> arrayList) {
        this.portraitUrl = arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<String> arrayList = this.portraitUrl;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        eVar.v("portrait_url", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusPortraitOption decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("portrait_url");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                String o16 = l3.o(i3);
                if (o16 != null) {
                    arrayList.add(o16);
                }
            }
        } else {
            arrayList = null;
        }
        return new QPlusPortraitOption(arrayList);
    }
}
