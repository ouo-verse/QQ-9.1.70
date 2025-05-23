package com.tencent.aelight.camera.aeeditor.manage;

import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;

/* loaded from: classes32.dex */
public class AEEditorEffectConfigProcessor extends l<AEEditorEffectGroupListBean> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AEEditorEffectGroupListBean migrateOldOrDefaultContent(int i3) {
        return new AEEditorEffectGroupListBean();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AEEditorEffectGroupListBean onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            ai aiVar = aiVarArr[aiVarArr.length - 1];
            if (aiVar == null) {
                return null;
            }
            AEEditorEffectGroupListBean parse = AEEditorEffectGroupListBean.parse(aiVar.f202268b);
            ms.a.a("AEEditorFilterConfigProcessor", "effect group list version: " + parse.version);
            return parse;
        }
        ms.a.a("AEEditorFilterConfigProcessor", "confFiles is empty");
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(AEEditorEffectGroupListBean aEEditorEffectGroupListBean) {
        ms.a.a("AEEditorFilterConfigProcessor", "onUpdate");
        AEEditorEffectConfigManager.f().h(aEEditorEffectGroupListBean);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<AEEditorEffectGroupListBean> clazz() {
        return AEEditorEffectGroupListBean.class;
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
        ms.a.a("AEEditorFilterConfigProcessor", "isNeedUpgradeReset");
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        ms.a.a("AEEditorFilterConfigProcessor", "migrateOldVersion");
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        ms.a.a("AEEditorFilterConfigProcessor", "onReqFailed");
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        super.onReqNoReceive();
        ms.a.a("AEEditorFilterConfigProcessor", "onReqNoReceive");
    }

    @Override // com.tencent.mobileqq.config.l
    public int onSend(int i3) {
        try {
            if (b.a(AEEditorEffectConfigManager.d()) == null) {
                am.s().P(643, 0);
                return 0;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return super.onSend(i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 643;
    }
}
