package com.tencent.luggage.wxa.ih;

import android.app.Activity;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends com.tencent.luggage.wxa.xd.a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements LuggageActivityHelper.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130361a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f130362b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130363c;

        public a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            this.f130361a = dVar;
            this.f130362b = jSONObject;
            this.f130363c = i3;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.h
        public void a(String[] strArr, int[] iArr) {
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                w.d("MicroMsg.BaseRecordJsApi", "PERMISSION_GRANTED, do invoke again");
                b.this.invoke(this.f130361a, this.f130362b, this.f130363c);
            } else {
                w.b("MicroMsg.BaseRecordJsApi", "operateRecorder, SYS_PERM_DENIED");
                this.f130361a.a(this.f130363c, b.this.makeReturnJson("fail:system permission denied"));
            }
        }
    }

    public abstract void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3);

    public final boolean b(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Activity activity = dVar.getContext() instanceof Activity ? (Activity) dVar.getContext() : null;
        if (activity == null) {
            w.b("MicroMsg.BaseRecordJsApi", "operateRecorder, pageContext is null");
            dVar.a(i3, makeReturnJson("fail:internal error invalid android context"));
            return false;
        }
        return LuggageActivityHelper.FOR(activity).checkRequestPermission(dVar, QQPermissionConstants.Permission.RECORD_AUDIO, new a(dVar, jSONObject, i3));
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (!b(dVar, jSONObject, i3)) {
            w.b("MicroMsg.BaseRecordJsApi", "%s requestPermission fail", getName());
        } else if (jSONObject == null) {
            w.b("MicroMsg.BaseRecordJsApi", "%s invalid data", getName());
            dVar.a(i3, makeReturnJson("fail:invalid data"));
        } else {
            a(dVar, jSONObject, i3);
        }
    }

    public String b(String str) {
        int lastIndexOf;
        return (w0.c(str) || (lastIndexOf = str.lastIndexOf(".")) == -1) ? "" : str.substring(lastIndexOf);
    }
}
