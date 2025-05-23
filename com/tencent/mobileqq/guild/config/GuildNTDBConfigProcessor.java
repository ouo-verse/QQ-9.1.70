package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.litetransfersdk.LiteTransferType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.guild.api.IGuildManageUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes13.dex */
public class GuildNTDBConfigProcessor extends com.tencent.mobileqq.config.l<a> {

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f216080a = "";

        /* JADX INFO: Access modifiers changed from: private */
        public void c(String str) {
            this.f216080a = str;
        }

        public String b() {
            return this.f216080a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
        ((IGuildManageUtilApi) QRoute.api(IGuildManageUtilApi.class)).setConfigForNT();
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        QLog.d("Guild.config.GuildNTDBConfigProcessor", 2, "migrateOldOrDefaultContent, type = " + i3);
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.config.GuildNTDBConfigProcessor", 2, "onParsed");
        }
        if (aiVarArr.length > 0 && !TextUtils.isEmpty(aiVarArr[0].f202268b)) {
            String str = aiVarArr[0].f202268b;
            a aVar = new a();
            aVar.c(str);
            return aVar;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.config.m
            @Override // java.lang.Runnable
            public final void run() {
                GuildNTDBConfigProcessor.b();
            }
        }, 16, null, false);
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
        QLog.d("Guild.config.GuildNTDBConfigProcessor", 1, "onReqFailed, failCode = " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return LiteTransferType.MsgBodyType.MsgType_0x346;
    }
}
