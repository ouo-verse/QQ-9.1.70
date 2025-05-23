package com.tencent.mobileqq.activity.aio.ecommerce;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.v6.d;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ECommerceDataReportConfigProcessor extends l<a> {

    /* loaded from: classes10.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public HashMap<String, String> f178646a = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ECommerceDataReportConfigProcessor", 2, "configText : " + str);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (!TextUtils.isEmpty(str2)) {
                            String optString = jSONObject.optString(str2, "");
                            if (!TextUtils.isEmpty(optString)) {
                                this.f178646a.put(str2, optString);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("ECommerceDataReportConfigProcessor", 1, th5, new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        ai aiVar;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            aVar.b(aiVar.f202268b);
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return d.CTRL_INDEX;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
