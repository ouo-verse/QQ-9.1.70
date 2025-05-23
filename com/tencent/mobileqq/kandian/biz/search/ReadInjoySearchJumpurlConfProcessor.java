package com.tencent.mobileqq.kandian.biz.search;

import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import y52.a;

/* loaded from: classes33.dex */
public class ReadInjoySearchJumpurlConfProcessor extends l<a> {
    public static a a() {
        return (a) am.s().x(292);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new d62.a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + aiVarArr);
        }
        if (aiVarArr == null || aiVarArr.length <= 0) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + aiVarArr[0].f202268b);
        }
        return new d62.a().h(aiVarArr[0].f202268b);
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
    public int type() {
        return 292;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
