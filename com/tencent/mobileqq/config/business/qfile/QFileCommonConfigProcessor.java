package com.tencent.mobileqq.config.business.qfile;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class QFileCommonConfigProcessor extends com.tencent.mobileqq.config.l<l> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l migrateOldOrDefaultContent(int i3) {
        QLog.i("QFileCommonConfigProcessor", 1, "migrateOldOrDefaultContent: type[" + i3 + "]");
        return new l();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l onParsed(ai[] aiVarArr) {
        QLog.i("QFileCommonConfigProcessor", 1, "onParsed");
        if (aiVarArr != null && aiVarArr.length > 0) {
            return (l) rb1.b.a(aiVarArr[0].f202268b, l.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(l lVar) {
        QLog.i("QFileCommonConfigProcessor", 1, "onUpdate");
        BaseQQAppInterface A0 = QQFileManagerUtilImpl.A0();
        if (A0 != null) {
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_c2c_up", lVar.f202748d);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_c2c_down", lVar.f202749e);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_c2czip_down", lVar.f202750f);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_c2c_thumb", lVar.f202751h);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_disc_up", lVar.f202752i);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_disc_down", lVar.f202753m);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_disczip_down", lVar.C);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_disc_thumb", lVar.D);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_troop_up", lVar.E);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_troop_down", lVar.F);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_troopzip_down", lVar.G);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "https_troop_thumb", lVar.H);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "troop_video_preivew", lVar.I);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "troop_video_preivew_for_svip", lVar.J);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "troop_video_preivew_for_yearsvip", lVar.K);
            com.tencent.mobileqq.filemanager.util.h.f(A0, "enable_file_media_platform", lVar.L);
            QLog.i("QFileCommonConfigProcessor", 1, "save download config." + lVar.M);
            Bundle bundle = new Bundle();
            bundle.putBoolean("troop_video_preivew", lVar.I);
            bundle.putBoolean("troop_video_preivew_for_svip", lVar.J);
            bundle.putBoolean("troop_video_preivew_for_yearsvip", lVar.K);
            bundle.putBoolean("enable_file_media_platform", lVar.L);
            QFileConfigManager.J(A0).B0(bundle);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<l> clazz() {
        return l.class;
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
        QLog.i("QFileCommonConfigProcessor", 1, "onReqFailed: failCode[" + i3 + "]");
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 396;
    }
}
