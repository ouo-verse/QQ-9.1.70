package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class DtVideoReportConfProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f202432a = false;

        public static a a(String str) {
            boolean z16;
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (new JSONObject(str).optInt("DTVideoSwitch") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    aVar.f202432a = z16;
                } catch (Throwable th5) {
                    QLog.e("DtVideoReportConfProcessor", 1, "[parse] parse error: ", th5);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("DtVideoReportConfProcessor", 2, "[parse] config: ", str);
            }
            return aVar;
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
    public a onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return a.a(aiVarArr[0].f202268b);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        QLog.d("DtVideoReportConfProcessor", 1, "[onUpdate] switch: ", Boolean.valueOf(aVar.f202432a));
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface != null) {
            qQAppInterface.getApp().getSharedPreferences("dt_sdk_start", 4).edit().putBoolean("key_need_turn_on_dt_video", aVar.f202432a).apply();
        }
        DtSdkInitStep.m(aVar.f202432a);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
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
    public boolean isNeedUpgradeReset() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 711;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
