package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchNetSugWordsRsp implements ISSOReqModel, ISSORspModel<UnifySearchNetSugWordsRsp> {
    public final String extension;
    public final List<UnifySearchNetSugInfo> netSugInfos;

    public UnifySearchNetSugWordsRsp() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchNetSugWordsRsp decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("net_sug_infos");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new UnifySearchNetSugInfo(eVar2.q("sug_word", ""), eVar2.q("hit_key_word", ""), eVar2.q(MimeTypeParser.ATTR_EXTENSION, "")));
                }
            }
        } else {
            arrayList = null;
        }
        return new UnifySearchNetSugWordsRsp(arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null, eVar.q(MimeTypeParser.ATTR_EXTENSION, ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        List<UnifySearchNetSugInfo> list = this.netSugInfos;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((UnifySearchNetSugInfo) it.next()).encode());
            }
        }
        eVar.v("net_sug_infos", bVar);
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        return eVar;
    }

    public UnifySearchNetSugWordsRsp(List<UnifySearchNetSugInfo> list, String str) {
        this.netSugInfos = list;
        this.extension = str;
    }

    public /* synthetic */ UnifySearchNetSugWordsRsp(List list, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "");
    }
}
