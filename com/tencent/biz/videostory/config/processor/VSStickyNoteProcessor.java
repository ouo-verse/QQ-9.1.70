package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import mf0.d;

/* loaded from: classes5.dex */
public class VSStickyNoteProcessor extends l<d> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d migrateOldOrDefaultContent(int i3) {
        return new d();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            d b16 = d.b(aiVarArr[0].f202268b);
            onUpdate(b16);
            QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            return b16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(d dVar) {
        QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
        if (dVar != null) {
            QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + dVar.toString());
            VSConfigManager.c().j("sticky_note_publish_entrance_config", dVar.a());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<d> clazz() {
        return d.class;
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
        return 595;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
