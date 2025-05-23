package com.tencent.mobileqq.config.business.qfile;

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
public class QFileExcitingGroupUploadConfigProcessor extends com.tencent.mobileqq.config.l<r> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public r migrateOldOrDefaultContent(int i3) {
        return new r();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r onParsed(ai[] aiVarArr) {
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (r) rb1.b.a(aiVarArr[0].f202268b, r.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(r rVar) {
        BaseQQAppInterface A0;
        if (rVar != null && (A0 = QQFileManagerUtilImpl.A0()) != null) {
            if (TextUtils.isEmpty(rVar.f202774d)) {
                rVar.f202774d = "{}";
            }
            com.tencent.mobileqq.filemanager.util.h.h(A0, "qfile_groupfile_excitingupload", rVar.f202774d);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "groupfile_excitingupload_", true);
            QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + rVar.f202774d + "]");
            QFileConfigManager.J(A0).z0(rVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<r> clazz() {
        return r.class;
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
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON;
    }
}
