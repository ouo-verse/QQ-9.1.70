package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.entrancewidget.a;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import mf0.c;

/* loaded from: classes5.dex */
public class VSEntranceWidgetProcessor extends l<c> {
    private void c(String str, String str2) {
        QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
        if (!TextUtils.isEmpty(str2)) {
            VSConfigManager.c().j("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.TRUE);
            VSConfigManager.c().j("KEY_VS_ENTRANCE_WIDGET_MD5", str);
            VSConfigManager.c().j("KEY_VS_ENTRANCE_WIDGET_CONTENT", str2);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int i3) {
        return new c();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            c d16 = c.d(aiVarArr[0].f202268b);
            if (d16 == null) {
                QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
                return null;
            }
            String str = (String) VSConfigManager.c().e("KEY_VS_ENTRANCE_WIDGET_MD5", "");
            if (!TextUtils.isEmpty(d16.c()) && !d16.c().equals(str)) {
                a.e().b(d16);
                c(d16.c(), aiVarArr[0].f202268b);
            }
            return d16;
        }
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<c> clazz() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(c cVar) {
        if (cVar != null) {
            QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + cVar.toString());
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
        return 474;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
