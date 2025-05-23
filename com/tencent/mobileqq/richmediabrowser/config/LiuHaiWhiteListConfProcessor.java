package com.tencent.mobileqq.richmediabrowser.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

@KeepClassConstructor
/* loaded from: classes18.dex */
public class LiuHaiWhiteListConfProcessor extends l<b> {

    /* renamed from: a, reason: collision with root package name */
    public b f281798a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final LiuHaiWhiteListConfProcessor f281799a = new LiuHaiWhiteListConfProcessor();
    }

    LiuHaiWhiteListConfProcessor() {
    }

    public static LiuHaiWhiteListConfProcessor b() {
        return a.f281799a;
    }

    public b a() {
        b bVar = (b) am.s().x(654);
        this.f281798a = bVar;
        return bVar;
    }

    public boolean c(String str, String str2, String str3) {
        List<c> list;
        if (this.f281798a == null) {
            this.f281798a = a();
        }
        b bVar = this.f281798a;
        if (bVar != null && (list = bVar.f281801b) != null && !list.isEmpty() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            for (c cVar : this.f281798a.f281801b) {
                if (!TextUtils.isEmpty(cVar.f281802a) && !TextUtils.isEmpty(cVar.f281803b) && !TextUtils.isEmpty(cVar.f281804c) && str.equals(cVar.f281802a) && str2.equals(cVar.f281803b) && str3.equals(cVar.f281804c)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("LiuHaiWhiteListConfProcessor", 2, "onParsed confFiles = " + aiVarArr);
        }
        if (this.f281798a == null) {
            this.f281798a = new b();
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("LiuHaiWhiteListConfProcessor", 2, "onParsed config = " + str);
            }
            this.f281798a.f281801b = com.tencent.mobileqq.richmediabrowser.config.a.a(str);
        }
        return this.f281798a;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("LiuHaiWhiteListConfProcessor", 2, "onUpdate newConf = " + bVar);
        }
        if (bVar != null && bVar.f281801b != null) {
            this.f281798a = bVar;
        }
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
        if (QLog.isColorLevel()) {
            QLog.d("LiuHaiWhiteListConfProcessor", 2, "onReqFailed failCode = " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 654;
    }
}
