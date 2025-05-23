package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusQueryInterestTagsRsp implements ISSOReqModel, ISSORspModel<QPlusQueryInterestTagsRsp> {
    public final ArrayList<QPlusTag> tags;

    public QPlusQueryInterestTagsRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<QPlusTag> arrayList = this.tags;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((QPlusTag) it.next()).encode());
            }
        }
        eVar.v(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, bVar);
        return eVar;
    }

    public QPlusQueryInterestTagsRsp(ArrayList<QPlusTag> arrayList) {
        this.tags = arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusQueryInterestTagsRsp decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList.add(new QPlusTag(((e) d16).q("tag_name", "")));
                }
            }
        } else {
            arrayList = null;
        }
        return new QPlusQueryInterestTagsRsp(arrayList);
    }

    public /* synthetic */ QPlusQueryInterestTagsRsp(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
