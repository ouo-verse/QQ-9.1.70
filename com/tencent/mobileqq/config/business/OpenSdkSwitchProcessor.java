package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.business.ar;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class OpenSdkSwitchProcessor extends com.tencent.mobileqq.config.l<ar> {
    public static ar a(int i3) {
        ar arVar = (ar) com.tencent.mobileqq.config.am.s().x(i3);
        if (arVar == null) {
            return new ar();
        }
        return arVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ar migrateOldOrDefaultContent(int i3) {
        return new ar();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ar onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        ar.a aVar = null;
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (!TextUtils.isEmpty(str)) {
                QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content= " + str);
                try {
                    aVar = (ar.a) com.tencent.mobileqq.config.as.e(str, ar.a.class);
                } catch (QStorageInstantiateException e16) {
                    QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + str + "fail", e16);
                }
                return new ar(str, aVar);
            }
            QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ar> clazz() {
        return ar.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ar arVar) {
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content= " + arVar.b());
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
        return 467;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
