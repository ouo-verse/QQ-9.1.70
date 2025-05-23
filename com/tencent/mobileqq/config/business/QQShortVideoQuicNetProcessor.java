package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class QQShortVideoQuicNetProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f202466a = 0;

        public static a b(com.tencent.mobileqq.config.ai[] aiVarArr) {
            a aVar = new a();
            try {
                for (com.tencent.mobileqq.config.ai aiVar : aiVarArr) {
                    if (aiVar != null) {
                        String str = aiVar.f202268b;
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("quic_open")) {
                                    aVar.f202466a = jSONObject.optInt("quic_open");
                                }
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("QQShortVideoQuicNetProcessor", 2, "parse S$EConfBean: " + str);
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.d("QQShortVideoQuicNetProcessor", 2, "parse S$EConfBean failed!", th5);
            }
            return aVar;
        }

        public boolean a() {
            if (this.f202466a == 1 && !Utils.checkIfCPUx86()) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "ShortVideoQuicNetConfBean{mQuicOpen=" + this.f202466a + '}';
        }
    }

    public static a a() {
        return (a) com.tencent.mobileqq.config.am.s().x(685);
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return a.b(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("QQShortVideoQuicNetProcessor", 2, "QQShortVideoQuicNetProcessor onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
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
        return 685;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
