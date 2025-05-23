package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExifInfoSwitch;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class PicCommonConfProcessor extends com.tencent.mobileqq.config.l<at> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public at migrateOldOrDefaultContent(int i3) {
        return new at();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public at onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (QLog.isColorLevel() && aiVarArr != null) {
            QLog.d("PicCommonConfProcessor", 2, "onParsed " + aiVarArr.length);
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            return at.a(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(at atVar) {
        if (QLog.isColorLevel()) {
            QLog.d("PicCommonConfProcessor", 2, "onUpdate " + atVar.toString());
        }
        SafeBitmapFactory.setNeedRegionDecode(atVar.f202527a);
        SafeBitmapFactory.setPxThreshoidToSp(atVar.f202529c);
        SafeBitmapFactory.setRamThreshoidToSp(atVar.f202528b);
        SafeBitmapFactory.setThreadCountToSp(atVar.f202530d);
        PicUploadFileSizeLimit.setLimitC2C(atVar.f202531e);
        PicUploadFileSizeLimit.setLimitGroup(atVar.f202532f);
        PicUploadExifInfoSwitch.setSwitch(atVar.f202533g);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<at> clazz() {
        return at.class;
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
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 251;
    }
}
