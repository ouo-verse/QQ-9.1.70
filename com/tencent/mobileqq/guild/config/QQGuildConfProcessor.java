package com.tencent.mobileqq.guild.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes13.dex */
public class QQGuildConfProcessor extends com.tencent.mobileqq.config.l<y> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public y migrateOldOrDefaultContent(int i3) {
        QLog.d("Guild.config.QQGuildConfProcessor_733", 2, "migrateOldOrDefaultContent, type: " + i3);
        return new y();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return y.c(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(y yVar) {
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).d3();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<y> clazz() {
        return y.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        QLog.d("Guild.config.QQGuildConfProcessor_733", 1, "onReqFailed, failCode = " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 733;
    }
}
