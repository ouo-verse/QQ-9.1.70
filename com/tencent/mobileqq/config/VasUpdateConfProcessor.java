package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class VasUpdateConfProcessor extends BaseQVipConfigProcessor<av> {
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public av migrateDefaultContent() {
        return new av();
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public av migrateOldContent() {
        return new av();
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public av parsed(@NonNull ai[] aiVarArr) {
        QLog.e("VasUpdateConfProcessor", 1, "onParsed ");
        if (aiVarArr != null) {
            try {
                if (aiVarArr.length > 0) {
                    for (ai aiVar : aiVarArr) {
                        if (aiVar != null) {
                            av a16 = av.a(aiVar.f202268b);
                            if (QLog.isColorLevel()) {
                                QLog.d("VasUpdateConfProcessor", 2, "onParsed " + aiVar.f202268b);
                            }
                            if (a16 != null) {
                                return a16;
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("VasUpdateConfProcessor", 1, "onParsed Exception = " + e16.getMessage());
            }
        }
        return new av();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<av> clazz() {
        return av.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 649;
    }
}
