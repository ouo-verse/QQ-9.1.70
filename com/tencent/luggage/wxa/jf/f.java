package com.tencent.luggage.wxa.jf;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.ic.c0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 252;
    public static final String NAME = "navigateBackMiniProgram";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.i f131004a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131005b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131006c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f131007d;

        public a(com.tencent.luggage.wxa.xd.i iVar, JSONObject jSONObject, JSONObject jSONObject2, int i3) {
            this.f131004a = iVar;
            this.f131005b = jSONObject;
            this.f131006c = jSONObject2;
            this.f131007d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f131004a.getRuntime().a(c0.a(this.f131004a.getRuntime(), this.f131005b, this.f131006c));
            this.f131004a.a(this.f131007d, f.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.xd.i iVar, JSONObject jSONObject, int i3) {
        iVar.a(new a(iVar, jSONObject.optJSONObject(WadlProxyConsts.EXTRA_DATA), jSONObject.optJSONObject("privateExtraData"), i3));
    }
}
