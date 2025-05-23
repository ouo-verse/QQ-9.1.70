package com.tencent.mobileqq.guild.message.registerproxy.manage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.uf.i;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import nu1.a;

/* loaded from: classes14.dex */
public class GuildRegisterProxyConfigProcessor extends l<a> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f230788a = "GuildRegisterProxyConfigProcessor";

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
        return a.a(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
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
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return i.CTRL_INDEX;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
