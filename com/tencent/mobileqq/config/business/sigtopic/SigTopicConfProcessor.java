package com.tencent.mobileqq.config.business.sigtopic;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.config.business.sigtopic.a;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class SigTopicConfProcessor extends l<a> {
    public static a a() {
        a aVar = (a) am.s().x(529);
        if (aVar == null) {
            return new a();
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        a.C7476a c7476a = null;
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.e("SigTopicConfProcessor", 1, "SigTopic.[onParsed]\u00a0type=" + type() + ",\u00a0content\u00a0=\u00a0" + str);
                }
                try {
                    c7476a = (a.C7476a) as.e(str, a.C7476a.class);
                } catch (QStorageInstantiateException e16) {
                    QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", e16);
                }
                return new a(str, c7476a);
            }
        }
        return null;
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
        return 529;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
