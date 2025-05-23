package com.heytap.mcssdk;

import android.content.Context;
import com.heytap.msp.push.callback.ICallBackResultService;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
interface b {
    String a();

    @Deprecated
    void a(int i3);

    @Deprecated
    void a(int i3, JSONObject jSONObject);

    void a(Context context, String str, String str2, ICallBackResultService iCallBackResultService);

    void a(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService);

    void a(String str);

    void a(List<Integer> list, int i3, int i16, int i17, int i18);

    void a(List<Integer> list, int i3, int i16, int i17, int i18, JSONObject jSONObject);

    void a(JSONObject jSONObject);

    void b();

    void b(JSONObject jSONObject);

    void c();

    void c(JSONObject jSONObject);

    void d();

    @Deprecated
    void d(JSONObject jSONObject);

    @Deprecated
    void e();

    void e(JSONObject jSONObject);

    void f();

    void f(JSONObject jSONObject);

    void g();

    void g(JSONObject jSONObject);

    void h();

    void h(JSONObject jSONObject);

    void i();

    void j();
}
