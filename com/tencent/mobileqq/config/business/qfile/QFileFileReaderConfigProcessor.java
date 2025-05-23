package com.tencent.mobileqq.config.business.qfile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QFileFileReaderConfigProcessor extends com.tencent.mobileqq.config.l<QFileFileReaderConfigBean> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QFileFileReaderConfigBean migrateOldOrDefaultContent(int i3) {
        return new QFileFileReaderConfigBean();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QFileFileReaderConfigBean onParsed(ai[] aiVarArr) {
        QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (QFileFileReaderConfigBean) rb1.b.a(aiVarArr[0].f202268b, QFileFileReaderConfigBean.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(QFileFileReaderConfigBean qFileFileReaderConfigBean) {
        if (qFileFileReaderConfigBean == null) {
            QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
            return;
        }
        QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: config[" + qFileFileReaderConfigBean.strConfigContent + "]");
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 != null) {
            com.tencent.mobileqq.filemanager.util.h.h(A0, "file_reader_key", qFileFileReaderConfigBean.strConfigContent);
            QFileConfigManager.J(A0).F0(qFileFileReaderConfigBean);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QFileFileReaderConfigBean> clazz() {
        return QFileFileReaderConfigBean.class;
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
        return MiniReportManager.EventId.PAGE_LOAD_END;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
