package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qzone.remote.ServiceConst;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class DrawSceneRsp implements ISSOReqModel, ISSORspModel<DrawSceneRsp> {
    public final ArrayList<ChatContentBot> messages;
    public final int retCode;
    public final String retMsg;
    public final String sessionId;
    public final int waitTs;

    public DrawSceneRsp() {
        this(0, null, null, null, 0, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("ret_code", this.retCode);
        eVar.v("ret_msg", this.retMsg);
        b a16 = o.a(eVar, ServiceConst.PARA_SESSION_ID, this.sessionId);
        ArrayList<ChatContentBot> arrayList = this.messages;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((ChatContentBot) it.next()).encode());
            }
        }
        eVar.v("messages", a16);
        eVar.t("wait_ts", this.waitTs);
        return eVar;
    }

    public DrawSceneRsp(int i3, String str, String str2, ArrayList<ChatContentBot> arrayList, int i16) {
        this.retCode = i3;
        this.retMsg = str;
        this.sessionId = str2;
        this.messages = arrayList;
        this.waitTs = i16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final DrawSceneRsp decode(e eVar) {
        ArrayList arrayList;
        int k3 = eVar.k("ret_code", 0);
        String q16 = eVar.q("ret_msg", "");
        String q17 = eVar.q(ServiceConst.PARA_SESSION_ID, "");
        b l3 = eVar.l("messages");
        if (l3 != null) {
            ArrayList arrayList2 = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    ChatContentBot chatContentBot = new ChatContentBot(0, null, null, null, null, null, null, 127, null);
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    arrayList2.add(chatContentBot.decode((e) d16));
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new DrawSceneRsp(k3, q16, q17, arrayList, eVar.k("wait_ts", 0));
    }

    public /* synthetic */ DrawSceneRsp(int i3, String str, String str2, ArrayList arrayList, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", null, 0);
    }
}
