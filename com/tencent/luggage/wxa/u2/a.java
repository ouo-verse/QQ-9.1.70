package com.tencent.luggage.wxa.u2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u2.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6781a implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f142088a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142089b;

        public C6781a(d dVar, int i3) {
            this.f142088a = dVar;
            this.f142089b = i3;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public void a(int i3, Intent intent) {
            List<com.tencent.luggage.wxa.f1.b> a16 = com.tencent.luggage.wxa.x0.b.a(intent);
            if (a16 == null) {
                w.b("MicroMsg.JsApiChooseImage", "chooseImage onActivityResult get NULL images, resultCode=%d, appId=%s", Integer.valueOf(i3), this.f142088a.getAppId());
                this.f142088a.a(this.f142089b, a.this.makeReturnJson("fail cancel"));
                return;
            }
            ArrayList arrayList = new ArrayList(a16.size());
            ArrayList arrayList2 = new ArrayList(a16.size());
            for (com.tencent.luggage.wxa.f1.b bVar : a16) {
                v vVar = new v(bVar.b());
                i iVar = new i();
                if (this.f142088a.getFileSystem().createTempFileFrom(vVar, FilenameUtils.getExtension(bVar.b()), false, iVar) == l.OK) {
                    arrayList.add((String) iVar.f141499a);
                    arrayList2.add(Long.valueOf(vVar.s()));
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("tempFilePaths", a.b(arrayList));
            hashMap.put("tempFileSizes", a.b(arrayList2));
            this.f142088a.a(this.f142089b, a.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }
    }

    public static JSONArray b(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                jSONArray.mo162put(arrayList.get(i3));
            }
            return jSONArray;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    @Override // com.tencent.luggage.wxa.xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        int i16;
        Intent intent;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        jSONObject.optString("sizeType");
        try {
            i16 = Integer.parseInt(jSONObject.optString("count"), 10);
        } catch (Exception unused) {
            i16 = 1;
        }
        if (!(dVar.getContext() instanceof Activity)) {
            dVar.a(i3, "fail");
            return;
        }
        Activity activity = (Activity) dVar.getContext();
        if (optJSONArray != null) {
            try {
            } catch (JSONException e16) {
                w.h("MicroMsg.JsApiChooseImage", "invoke: Never arrive", e16);
            }
            if (optJSONArray.length() == 1 && optJSONArray.get(0).equals("camera")) {
                intent = com.tencent.luggage.wxa.x0.b.a().a(activity);
                if (intent == null) {
                    intent = com.tencent.luggage.wxa.x0.b.a(activity).a(i16).a((Context) activity);
                }
                LuggageActivityHelper.FOR(dVar.getContext()).startActivityForResult(intent, new C6781a(dVar, i3));
            }
        }
        intent = null;
        if (intent == null) {
        }
        LuggageActivityHelper.FOR(dVar.getContext()).startActivityForResult(intent, new C6781a(dVar, i3));
    }
}
