package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class FlashChatConfProcessor extends com.tencent.mobileqq.config.l<p> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public p migrateOldOrDefaultContent(int i3) {
        return new p();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        com.tencent.mobileqq.config.ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            p a16 = p.a(aiVar.f202268b);
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                ((FlashChatManager) ((QQAppInterface) runtime).getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).v(a16.f202698a);
                return a16;
            }
            return a16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(p pVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FlashChatConfProcessor", 2, "onUpdate " + pVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<p> clazz() {
        return p.class;
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
        return 168;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
