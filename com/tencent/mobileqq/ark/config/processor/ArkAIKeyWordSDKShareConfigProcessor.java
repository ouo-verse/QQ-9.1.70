package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.as;
import com.tencent.qphone.base.util.QLog;
import d91.c;

/* loaded from: classes11.dex */
public class ArkAIKeyWordSDKShareConfigProcessor extends ArkConfProcessor<c> {
    @Override // com.tencent.mobileqq.config.l
    public Class<c> clazz() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int i3) {
        return new c();
    }

    @Override // com.tencent.mobileqq.ark.config.processor.ArkConfProcessor
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c b(String str) {
        e91.c cVar;
        try {
            cVar = (e91.c) as.e(str, e91.c.class);
        } catch (QStorageInstantiateException e16) {
            QLog.i("ArkApp.ConfProcessor", 1, "loadConfig:" + str + "fail", e16);
            cVar = null;
        }
        return new c(str, cVar);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onUpdate(c cVar) {
    }
}
