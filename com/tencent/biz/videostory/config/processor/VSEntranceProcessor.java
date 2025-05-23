package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import mf0.a;

/* loaded from: classes5.dex */
public class VSEntranceProcessor extends l<a> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            a d16 = a.d(aiVarArr[0].f202268b);
            QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            onUpdate(d16);
            return d16;
        }
        QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (aVar != null) {
            VSConfigManager.c().j("mine_videostory_entrance", aVar.c());
            VSConfigManager.c().j("enable_click_take_picture", aVar.a());
            VSConfigManager.c().j("mine_videostory_drawer_entrance", aVar.b());
            QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + aVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
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
        return 411;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
