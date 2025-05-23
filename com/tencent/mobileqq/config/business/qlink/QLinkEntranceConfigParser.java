package com.tencent.mobileqq.config.business.qlink;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.config.business.qlink.a;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class QLinkEntranceConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        QLog.d("QLinkEntranceConfigParser", 1, "parse jsonString: " + str);
        if (TextUtils.isEmpty(str)) {
            return new a();
        }
        a aVar = new a();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("blockConfigList");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                    a.C7474a c7474a = new a.C7474a();
                    c7474a.f202791a = jSONObject.optString("brand");
                    c7474a.f202792b = jSONObject.optString("model");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("blackSystemVersions");
                    if (optJSONArray2 != null) {
                        for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            c7474a.f202793c.add(Integer.valueOf(optJSONArray2.getInt(i16)));
                        }
                    }
                    aVar.f202790d.add(c7474a);
                }
            }
        } catch (Exception e16) {
            QLog.d("QLinkEntranceConfigParser", 1, "parse err. ", e16);
        }
        QLog.d("QLinkEntranceConfigParser", 1, aVar);
        return aVar;
    }
}
