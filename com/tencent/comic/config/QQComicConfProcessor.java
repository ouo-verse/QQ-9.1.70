package com.tencent.comic.config;

import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class QQComicConfProcessor extends l<QQComicConfBean> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QQComicConfBean migrateOldOrDefaultContent(int i3) {
        return new QQComicConfBean();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QQComicConfBean onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicConfProcessor", 2, "onParsed");
        }
        return QQComicConfBean.e(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(QQComicConfBean qQComicConfBean) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicConfProcessor", 2, "onUpdate " + qQComicConfBean.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QQComicConfBean> clazz() {
        return QQComicConfBean.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
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
        return 534;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
