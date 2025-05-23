package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public final class TencentDocUrl2DocConfigProcessor extends l<a> {
    public static a a() {
        QLog.d("TencentDocUrl2DocConfigProcessor", 1, "getConfig");
        return new a();
    }

    public static boolean b(String str) {
        a a16 = a();
        if (a16.a() && a16.b(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        QLog.w("TencentDocUrl2DocConfigProcessor", 1, "migrateOldOrDefaultContent type:" + i3);
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        return a.c(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        QLog.w("TencentDocUrl2DocConfigProcessor", 1, "onUpdate");
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
    public void onReqFailed(int i3) {
        QLog.e("TencentDocUrl2DocConfigProcessor", 1, "onReqFailed: " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return PlayerResources.ViewId.ADVTISMENT_VIDEO_TIP;
    }
}
