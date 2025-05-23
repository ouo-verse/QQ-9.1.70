package com.tencent.mobileqq.data.nativemonitor.traffic;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class NativeTrafficMonitorConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a parse(@NonNull byte[] bArr) {
        JSONObject jSONObject;
        a aVar;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(new String(bArr, StandardCharsets.UTF_8));
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            QLog.d("NativeTrafficMonitorCon", 1, jSONObject.toString());
        } catch (JSONException e17) {
            e = e17;
            jSONObject2 = jSONObject;
            QLog.e("NativeTrafficMonitorCon", 1, e, new Object[0]);
            jSONObject = jSONObject2;
            aVar = (a) com.tencent.mobileqq.jsonconverter.a.f(jSONObject, a.class);
            QLog.d("NativeTrafficMonitorCon", 1, "onParsed");
            if (aVar != null) {
            }
        }
        aVar = (a) com.tencent.mobileqq.jsonconverter.a.f(jSONObject, a.class);
        QLog.d("NativeTrafficMonitorCon", 1, "onParsed");
        if (aVar != null) {
            return new a();
        }
        return aVar;
    }
}
