package com.tencent.mobileqq.config.business.dataline;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.qphone.base.util.QLog;
import pa1.a;
import rb1.b;

/* loaded from: classes10.dex */
public class QDatalineHttpsConfigProcessor extends l<a> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        QLog.i("QDatalineHttpsConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + i3 + "]");
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        QLog.i("QDatalineHttpsConfigProcessor", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (a) b.a(aiVarArr[0].f202268b, a.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        QLog.i("QDatalineHttpsConfigProcessor", 1, "onUpdate");
        BaseQQAppInterface W = ah.W();
        if (W != null) {
            SharedPreferences.Editor edit = W.getApplicationContext().getSharedPreferences("dataline_config_" + W.getCurrentUin(), 0).edit();
            edit.putBoolean("use_new_httpclient", aVar.f425844d);
            edit.putBoolean("use_https_connect", aVar.f425845e);
            edit.apply();
            QLog.i("QDatalineHttpsConfigProcessor", 1, "save download config." + aVar.f425846f);
        }
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
    public void onReqFailed(int i3) {
        QLog.i("QDatalineHttpsConfigProcessor", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 637;
    }
}
