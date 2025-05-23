package com.tencent.mobileqq.onlinestatus.model;

import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f256004a;

    /* renamed from: b, reason: collision with root package name */
    public String f256005b;

    /* renamed from: c, reason: collision with root package name */
    public String f256006c;

    /* renamed from: d, reason: collision with root package name */
    public String f256007d;

    /* renamed from: e, reason: collision with root package name */
    public int f256008e;

    /* renamed from: f, reason: collision with root package name */
    public String f256009f;

    /* renamed from: g, reason: collision with root package name */
    public String f256010g;

    /* renamed from: h, reason: collision with root package name */
    public String f256011h;

    public static void a(JSONObject jSONObject, au auVar) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("event_share");
            if (optJSONObject == null) {
                return;
            }
            c cVar = new c();
            cVar.f256004a = optJSONObject.optInt("share_dialog_type", 0);
            cVar.f256005b = optJSONObject.optString("share_dialog_url", "");
            cVar.f256007d = auVar.f255501n;
            cVar.f256006c = optJSONObject.optString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_QRCODE_URL, "");
            cVar.f256008e = optJSONObject.optInt("egg_type", 0);
            cVar.f256009f = optJSONObject.optString("egg_apng", "");
            cVar.f256010g = optJSONObject.optString("res_url", "");
            cVar.f256011h = optJSONObject.optString("res_md5", "");
            auVar.A = cVar;
        } catch (Exception e16) {
            QLog.e("OnlineStatus.EventOnlineStatus", 1, "parseJsonConfig error.", e16);
        }
    }
}
