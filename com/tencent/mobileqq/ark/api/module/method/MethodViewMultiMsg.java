package com.tencent.mobileqq.ark.api.module.method;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModule;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.a;
import com.tencent.qqnt.aio.utils.t;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MethodViewMultiMsg implements e {

    /* renamed from: a, reason: collision with root package name */
    private long f199076a;

    private String d(ark.VariantWrapper variantWrapper) {
        if (variantWrapper == null) {
            return "";
        }
        int GetType = variantWrapper.GetType();
        if (GetType == 5) {
            return variantWrapper.GetString();
        }
        if (GetType != 6) {
            return "";
        }
        return variantWrapper.GetTableAsJsonString();
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public boolean a() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public boolean b() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: all -> 0x00ac, TryCatch #1 {all -> 0x00ac, blocks: (B:25:0x007a, B:27:0x008e, B:28:0x0095), top: B:24:0x007a }] */
    @Override // com.tencent.mobileqq.ark.module.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        long parseLong;
        String d16;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f199076a < 500) {
            return;
        }
        this.f199076a = currentTimeMillis;
        if (variantWrapperArr != null && variantWrapperArr.length >= 4) {
            final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                QLog.i("ViewMultiMsg", 2, "invoke fail\uff0cactivity == null ");
                return;
            }
            AIOContact a16 = a.f352276a.a(qBaseActivity);
            if (a16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("ViewMultiMsg", 2, "invoke fail\uff0c null aioContact, activity is " + qBaseActivity);
                    return;
                }
                return;
            }
            String d17 = d(variantWrapperArr[0]);
            try {
                if (!TextUtils.isEmpty(d17)) {
                    try {
                        parseLong = Long.parseLong(d17);
                    } catch (NumberFormatException unused) {
                        QLog.w("ViewMultiMsg", 1, "invoke fail, format: " + d17);
                    }
                    final long j3 = parseLong;
                    final int e16 = a16.e();
                    final String j16 = a16.j();
                    d16 = d(variantWrapperArr[2]);
                    if (TextUtils.isEmpty(d16)) {
                        d16 = HardCodeUtil.qqStr(R.string.obo);
                    }
                    final String str = d16;
                    final long GetView = variantWrapperArr[3].GetView();
                    ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.method.MethodViewMultiMsg.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseArkAppContainer h06 = ArkAppQQModule.h0(GetView);
                            if (h06 == null) {
                                QLog.w("ViewMultiMsg", 1, "ark aio wrapper is null");
                                return;
                            }
                            Object contactData = h06.getContactData();
                            if (!(contactData instanceof MsgRecord)) {
                                QLog.w("ViewMultiMsg", 1, "contactData is wrong");
                                return;
                            }
                            t.f352318a.d(qBaseActivity, j16, e16, str, j3, (MsgRecord) contactData, new Intent());
                        }
                    });
                    return;
                }
                final int e162 = a16.e();
                final String j162 = a16.j();
                d16 = d(variantWrapperArr[2]);
                if (TextUtils.isEmpty(d16)) {
                }
                final String str2 = d16;
                final long GetView2 = variantWrapperArr[3].GetView();
                ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.method.MethodViewMultiMsg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseArkAppContainer h06 = ArkAppQQModule.h0(GetView2);
                        if (h06 == null) {
                            QLog.w("ViewMultiMsg", 1, "ark aio wrapper is null");
                            return;
                        }
                        Object contactData = h06.getContactData();
                        if (!(contactData instanceof MsgRecord)) {
                            QLog.w("ViewMultiMsg", 1, "contactData is wrong");
                            return;
                        }
                        t.f352318a.d(qBaseActivity, j162, e162, str2, j3, (MsgRecord) contactData, new Intent());
                    }
                });
                return;
            } catch (Throwable th5) {
                QLog.w("ViewMultiMsg", 1, "invoke method fail, ", th5);
                return;
            }
            parseLong = 0;
            final long j36 = parseLong;
        } else if (QLog.isColorLevel()) {
            QLog.i("ViewMultiMsg", 2, "invoke fail\uff0cargs.length err");
        }
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public String getMethodName() {
        return "ViewMultiMsg";
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public String getPermission() {
        return null;
    }
}
