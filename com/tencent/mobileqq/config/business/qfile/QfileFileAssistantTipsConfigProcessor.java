package com.tencent.mobileqq.config.business.qfile;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QfileFileAssistantTipsConfigProcessor extends com.tencent.mobileqq.config.l<QfileFileAssistantTipsConfigBean> {

    /* renamed from: a, reason: collision with root package name */
    final String f202740a = "QfileFileAssistantTipsConfigProcessor<FileAssistant>";

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QfileFileAssistantTipsConfigBean migrateOldOrDefaultContent(int i3) {
        QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "migrateOldOrDefaultContent: type[" + i3 + "]");
        return new QfileFileAssistantTipsConfigBean();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QfileFileAssistantTipsConfigBean onParsed(ai[] aiVarArr) {
        QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (QfileFileAssistantTipsConfigBean) rb1.b.a(aiVarArr[0].f202268b, QfileFileAssistantTipsConfigBean.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(QfileFileAssistantTipsConfigBean qfileFileAssistantTipsConfigBean) {
        if (qfileFileAssistantTipsConfigBean == null) {
            QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onUpdate: newConf is null.");
            return;
        }
        QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "QfileFileAssistantTipsConfigProcessor onUpdate");
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 == null) {
            QLog.e("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "app is null!!!");
            return;
        }
        if (TextUtils.isEmpty(qfileFileAssistantTipsConfigBean.f202730d)) {
            qfileFileAssistantTipsConfigBean.f202730d = "{}";
        }
        SharedPreferences.Editor edit = A0.getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + A0.getCurrentUin(), 0).edit();
        edit.putString("qfile_file_assistant_tips", qfileFileAssistantTipsConfigBean.f202730d);
        edit.apply();
        QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "save FileAssistantTips config [" + qfileFileAssistantTipsConfigBean.f202730d + "]");
        QFileConfigManager.J(A0).A0(qfileFileAssistantTipsConfigBean);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QfileFileAssistantTipsConfigBean> clazz() {
        return QfileFileAssistantTipsConfigBean.class;
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
        QLog.i("QfileFileAssistantTipsConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 606;
    }
}
