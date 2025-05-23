package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.entrancewidget.a;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import mf0.b;

/* loaded from: classes5.dex */
public class VSEntranceStyleProcessor extends l<b> {
    private void c(String str, String str2) {
        QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
        if (!TextUtils.isEmpty(str2)) {
            VSConfigManager.c().j("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.TRUE);
            VSConfigManager.c().j("KEY_VS_ENTRANCE_STYLE_MD5", str);
            VSConfigManager.c().j("KEY_VS_ENTRANCE_STYLE_CONTENT", str2);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            b d16 = b.d(aiVarArr[0].f202268b);
            if (d16 == null) {
                QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
                return null;
            }
            String str = (String) VSConfigManager.c().e("KEY_VS_ENTRANCE_STYLE_MD5", "");
            if (!TextUtils.isEmpty(d16.c()) && !d16.c().equals(str)) {
                a.e().a(d16);
                c(d16.c(), aiVarArr[0].f202268b);
            }
            return d16;
        }
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        if (bVar != null) {
            QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + bVar.toString());
        }
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
        return LpReportInfoConfig.ACTION_TYPE_DIY;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
