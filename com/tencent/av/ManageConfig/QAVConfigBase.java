package com.tencent.av.ManageConfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.av.utils.e;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class QAVConfigBase<T> extends l<T> {

    /* renamed from: a, reason: collision with root package name */
    String f72815a;

    /* renamed from: b, reason: collision with root package name */
    int f72816b;

    public QAVConfigBase() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static ai b(String str, int i3, ai[] aiVarArr) {
        boolean z16;
        String str2 = null;
        if (aiVarArr != null && aiVarArr.length != 0) {
            if (!QLog.isDevelopLevel() && aiVarArr.length <= 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            int g16 = am.s().g(i3, ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getCurrentAccountUin());
            if (z16) {
                str2 = "getSuitableItem, Version[" + g16 + "], size[" + aiVarArr.length + "]";
            }
            ai aiVar = aiVarArr[0];
            if (aiVarArr.length > 1) {
                int i16 = 0;
                for (ai aiVar2 : aiVarArr) {
                    int c16 = c(aiVar2.f202268b);
                    if (z16) {
                        str2 = str2 + ", \nindex[" + i16 + "], taskId[" + aiVar2.f202267a + "], task_id[" + c16 + "]";
                    }
                    if (c16 == aiVar2.f202267a) {
                        aiVar = aiVar2;
                    }
                    i16++;
                }
            }
            return aiVar;
        }
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, "getSuitableItem, confFiles is null or empty.");
        }
        return null;
    }

    private static int c(String str) {
        try {
            return new JSONObject(str).optInt("task_id");
        } catch (Exception unused) {
            return 0;
        }
    }

    public int a() {
        String str;
        if (isAccountRelated()) {
            str = ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getCurrentAccountUin();
        } else {
            str = "";
        }
        return am.s().g(this.f72816b, str);
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
    @Nullable
    public final T onParsed(ai[] aiVarArr) {
        try {
            return parsed(aiVarArr);
        } catch (Exception e16) {
            QLog.w(this.f72815a, 1, "onParsed, \u914d\u7f6e\u89e3\u6790\u5f02\u5e38, [\n" + aiVarArr[0].f202268b + "\n]", e16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f72815a);
            sb5.append("\u914d\u7f6e\u89e3\u6790\u5f02\u5e38");
            e.u(sb5.toString());
            return migrateOldOrDefaultContent(type());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isDevelopLevel()) {
            int a16 = a();
            QLog.w(this.f72815a, 1, "onReqFailed, failCode[" + i3 + "], version[" + a16 + "]");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        if (QLog.isDevelopLevel()) {
            int a16 = a();
            QLog.w(this.f72815a, 1, "onReqNoReceive, version[" + a16 + "]");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(T t16) {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f72815a, 1, "onUpdate, " + t16);
        }
    }

    @NonNull
    protected abstract T parsed(ai[] aiVarArr) throws Exception;

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return this.f72816b;
    }

    public QAVConfigBase(int i3) {
        this.f72816b = i3;
        this.f72815a = "QAVConfig_" + this.f72816b;
    }
}
