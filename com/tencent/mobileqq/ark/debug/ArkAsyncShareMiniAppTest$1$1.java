package com.tencent.mobileqq.ark.debug;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import o91.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
class ArkAsyncShareMiniAppTest$1$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSONObject f199364d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c f199365e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object f199366f;

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Object obj;
        boolean z16;
        c cVar;
        long j3;
        if (this.f199364d != null && this.f199365e != null && (obj = this.f199366f) != null && (obj instanceof Bundle)) {
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.process engine res =", "test");
            }
            try {
                j3 = ((Bundle) this.f199366f).getLong("key_process_message_uniseq");
            } catch (JSONException e16) {
                QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.mArkMessagePreprocessor process e =", e16);
            }
            if (!TextUtils.isEmpty("test")) {
                JSONObject jSONObject = new JSONObject(this.f199364d.getString("forward_ark_app_meta"));
                JSONObject optJSONObject = jSONObject.optJSONObject("intro");
                if (optJSONObject == null) {
                    optJSONObject = jSONObject.optJSONObject("detail");
                }
                optJSONObject.put("desc", "uniseq=" + String.valueOf(j3) + ", \u66f4\u65b0metaData\u63a5\u53e3\u6d4b\u8bd5,\u6d4b\u8bd5\u66f4\u65b0meta\u4e2d\u7684desc");
                this.f199364d.put("forward_ark_app_meta", jSONObject.toString());
                z16 = true;
                QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.process isProcessed=", Boolean.valueOf(z16), ", msgJson=", this.f199364d.toString());
                cVar = this.f199365e;
                if (cVar == null) {
                    cVar.a(z16, this.f199364d, this.f199366f);
                    return;
                }
                return;
            }
            z16 = false;
            QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.process isProcessed=", Boolean.valueOf(z16), ", msgJson=", this.f199364d.toString());
            cVar = this.f199365e;
            if (cVar == null) {
            }
        } else {
            QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.process return callback=", this.f199365e);
        }
    }
}
