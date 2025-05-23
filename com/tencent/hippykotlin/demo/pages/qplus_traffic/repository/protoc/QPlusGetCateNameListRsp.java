package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusGetCateNameListRsp implements ISSOReqModel, ISSORspModel<QPlusGetCateNameListRsp> {
    public final ArrayList<String> categories;

    public QPlusGetCateNameListRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusGetCateNameListRsp decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("categories");
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
        return new QPlusGetCateNameListRsp(arrayList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<String> arrayList = this.categories;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        eVar.v("categories", bVar);
        return eVar;
    }

    public QPlusGetCateNameListRsp(ArrayList<String> arrayList) {
        this.categories = arrayList;
    }

    public /* synthetic */ QPlusGetCateNameListRsp(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
