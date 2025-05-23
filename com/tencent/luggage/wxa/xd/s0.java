package com.tencent.luggage.wxa.xd;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class s0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f144883a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f144884b;

        public a(com.tencent.luggage.wxa.ic.l lVar, int i3) {
            this.f144883a = lVar;
            this.f144884b = i3;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public void a(int i3, Intent intent) {
            this.f144883a.a(this.f144884b, s0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
        if (com.tencent.luggage.wxa.tn.w0.c(optString)) {
            lVar.a(i3, makeReturnJson("fail"));
            return;
        }
        Activity L = lVar.L();
        if (L == null) {
            lVar.a(i3, makeReturnJson("fail"));
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(WebView.SCHEME_TEL + Uri.encode(optString)));
            LuggageActivityHelper.FOR(L).startActivityForResult(intent, new a(lVar, i3));
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiMakePhoneCall", "startActivity failed");
            lVar.a(i3, makeReturnJson("fail"));
        }
    }
}
