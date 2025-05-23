package cooperation.ilive.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import m05.b;

/* loaded from: classes28.dex */
public class IliveManagerConfProcessor extends BaseQVipConfigProcessor<b> {
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateDefaultContent() {
        return new b();
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b migrateOldContent() {
        return new b();
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parsed(@NonNull ai[] aiVarArr) {
        QLog.e("IliveManagerConfProcessor", 1, "onParsed ");
        try {
            if (aiVarArr.length > 0) {
                for (ai aiVar : aiVarArr) {
                    if (aiVar != null) {
                        b b16 = b.b(aiVar.f202268b);
                        QLog.e("IliveManagerConfProcessor", 1, "onParsed content = " + aiVar.f202268b);
                        return b16;
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("IliveManagerConfProcessor", 1, "onParsed Exception = " + th5.getMessage());
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 689;
    }
}
