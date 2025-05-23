package com.tencent.zplan.http;

import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kx4.a;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
final class HttpRequestUtil$sendHttpPostJsonRequest$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f385652d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Map f385653e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ JSONObject f385654f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ a f385655h;

    @Override // java.lang.Runnable
    public final void run() {
        Response f16;
        String str;
        String str2;
        HttpRequestUtil httpRequestUtil = HttpRequestUtil.f385646a;
        f16 = httpRequestUtil.f(this.f385652d, this.f385653e, this.f385654f);
        if (f16 == null) {
            QLog.e("HttpRequestUtil", 1, "sendHttpPostJsonRequest response is null");
            httpRequestUtil.d(this.f385655h, -98701, "send request fail");
            return;
        }
        ResponseBody body = f16.body();
        if (body == null || (str = body.string()) == null) {
            str = "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sendHttpPostJsonRequest - code= ");
        sb5.append(f16.code());
        sb5.append(", msg= ");
        sb5.append(f16.message());
        sb5.append(", body= ");
        if (body == null) {
            str2 = null;
        } else {
            str2 = str;
        }
        sb5.append(str2);
        QLog.i("HttpRequestUtil", 1, sb5.toString());
        if (f16.isSuccessful()) {
            if (!TextUtils.isEmpty(str)) {
                httpRequestUtil.e(this.f385655h, str);
                return;
            } else {
                httpRequestUtil.d(this.f385655h, -98702, "body empty");
                return;
            }
        }
        a aVar = this.f385655h;
        int code = f16.code();
        String message = f16.message();
        Intrinsics.checkNotNullExpressionValue(message, "response.message()");
        httpRequestUtil.d(aVar, code, message);
    }
}
