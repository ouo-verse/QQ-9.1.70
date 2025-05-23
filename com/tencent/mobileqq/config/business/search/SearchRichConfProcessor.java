package com.tencent.mobileqq.config.business.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.search.rich.n;
import com.tencent.qphone.base.util.QLog;
import sa1.b;

/* loaded from: classes10.dex */
public class SearchRichConfProcessor extends l<b> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        if (QLog.isColorLevel()) {
            QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("SearchRichConfProcessor", 2, "onParsed start");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchRichConfProcessor", 2, "onParsed " + aiVarArr.length);
            }
            return b.f(aiVarArr[0]);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onUpdate ");
            if (bVar != null) {
                str = bVar.toString();
            } else {
                str = " empty";
            }
            sb5.append(str);
            QLog.d("SearchRichConfProcessor", 2, sb5.toString());
        }
        n.g().i();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
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
        if (QLog.isColorLevel()) {
            QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 432;
    }
}
