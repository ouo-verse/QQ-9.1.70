package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;

/* loaded from: classes10.dex */
public class OpenSdkConfProcessor extends com.tencent.mobileqq.config.l<al> {
    public static boolean a() {
        boolean z16;
        al b16 = b();
        if (b16 != null) {
            z16 = b16.c();
        } else {
            z16 = false;
        }
        com.tencent.open.agent.util.t.b("OpenSdkConfProcessor", "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(z16));
        return z16;
    }

    public static al b() {
        return (al) com.tencent.mobileqq.config.am.s().x(PlayUI.UIType.BIG_CARD_SHAPED_PIC);
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public al migrateOldOrDefaultContent(int i3) {
        return new al();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<al> clazz() {
        return al.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public al onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return al.d(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onUpdate(al alVar) {
        String alVar2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onUpdate ");
        if (alVar == null) {
            alVar2 = "";
        } else {
            alVar2 = alVar.toString();
        }
        sb5.append(alVar2);
        com.tencent.open.agent.util.t.c("OpenSdkConfProcessor", sb5.toString());
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
        return PlayUI.UIType.BIG_CARD_SHAPED_PIC;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
