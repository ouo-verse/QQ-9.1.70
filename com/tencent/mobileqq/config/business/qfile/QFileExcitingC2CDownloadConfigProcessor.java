package com.tencent.mobileqq.config.business.qfile;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QFileExcitingC2CDownloadConfigProcessor extends com.tencent.mobileqq.config.l<o> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o migrateOldOrDefaultContent(int i3) {
        return new o();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o onParsed(ai[] aiVarArr) {
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (o) rb1.b.a(aiVarArr[0].f202268b, o.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(o oVar) {
        BaseQQAppInterface A0;
        if (oVar != null && (A0 = QQFileManagerUtilImpl.A0()) != null) {
            if (TextUtils.isEmpty(oVar.f202762d)) {
                oVar.f202762d = "{}";
            }
            SharedPreferences.Editor edit = A0.getApplicationContext().getSharedPreferences("c2cfile_excitingdownload_" + A0.getCurrentUin(), 0).edit();
            edit.putString("qfile_c2cfile_excitingdownload", oVar.f202762d);
            edit.apply();
            QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + oVar.f202762d + "]");
            QFileConfigManager.J(A0).w0(oVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<o> clazz() {
        return o.class;
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
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return PlayerResources.ViewId.CONTROLLER_PROGRESS;
    }
}
