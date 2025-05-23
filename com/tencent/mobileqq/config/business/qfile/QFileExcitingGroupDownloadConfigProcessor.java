package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QFileExcitingGroupDownloadConfigProcessor extends com.tencent.mobileqq.config.l<q> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public q migrateOldOrDefaultContent(int i3) {
        return new q();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q onParsed(ai[] aiVarArr) {
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (q) rb1.b.a(aiVarArr[0].f202268b, q.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(q qVar) {
        BaseQQAppInterface A0;
        if (qVar != null && (A0 = QQFileManagerUtilImpl.A0()) != null) {
            if (TextUtils.isEmpty(qVar.f202770d)) {
                qVar.f202770d = "{}";
            }
            com.tencent.mobileqq.filemanager.util.h.h(A0, "qfile_groupfile_excitingdownload", qVar.f202770d);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "groupfile_excitingdownload_", true);
            QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + qVar.f202770d + "]");
            QFileConfigManager.J(A0).y0(qVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<q> clazz() {
        return q.class;
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
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 555;
    }
}
