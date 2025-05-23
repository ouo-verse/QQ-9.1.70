package com.tencent.gamecenter.wadl.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameMMKVService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameMMKVServiceImpl implements IQQGameMMKVService {
    public static final String TAG = "QQGameMMKVServiceImpl";

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public boolean deleteToSp(String... strArr) {
        String str;
        if (strArr != null && strArr.length > 0) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = "";
            }
            p03.a q16 = p03.a.q(str);
            for (String str2 : strArr) {
                q16.r(str2);
            }
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public int getIntOutAccount(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "getIntOutAccount fail, key is empty");
            return 0;
        }
        int d16 = p03.a.q("").d(str, i3);
        QLog.i(TAG, 1, "getIntOutAccount key=" + str + ",defaultValue=" + i3 + ",value=" + d16);
        return d16;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public String getStringOutAccount(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "getStringOutAccount fail, key is empty");
            return "";
        }
        String g16 = p03.a.q("").g(str, "");
        QLog.i(TAG, 1, "getStringOutAccount key=" + str + ",value=" + g16);
        return g16;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public boolean readBoolFromSp(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = "";
        }
        return p03.a.q(str2).c(str, false);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public String readFromSp(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            str2 = "";
        } else {
            str2 = peekAppRuntime.getAccount();
        }
        return p03.a.q(str2).g(str, "");
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public int readFromSpInt(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = "";
        }
        return p03.a.q(str2).d(str, 0);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public long readFromSpLong(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = "";
        }
        return p03.a.q(str2).e(str, 0L);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public void setIntOutAccount(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "setIntOutAccount fail, key=" + str + ",value=" + i3);
            return;
        }
        p03.a.q("").i(str, i3);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public void setStringOutAccount(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            p03.a.q("").l(str, str2);
            QLog.i(TAG, 1, "setStringOutAccount key=" + str + ",value=" + str2);
            return;
        }
        QLog.w(TAG, 1, "setStringOutAccount fail, key=" + str + ",value=" + str2);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public boolean writeToSp(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str3 = peekAppRuntime.getAccount();
        } else {
            str3 = "";
        }
        p03.a.q(str3).l(str, str2);
        QLog.i(TAG, 1, "writeToSp " + str + " :" + str2);
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public boolean writeToSpBool(String str, boolean z16) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = "";
        }
        p03.a.q(str2).h(str, z16);
        QLog.i(TAG, 1, "writeToSpBool " + str + " :" + z16);
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public void writeToSpInt(String str, int i3) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = "";
        }
        p03.a.q(str2).i(str, i3);
        QLog.i(TAG, 1, "writeToSpInt " + str + " :" + i3);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameMMKVService
    public void writeToSpLong(String str, long j3) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getAccount();
        } else {
            str2 = "";
        }
        p03.a.q(str2).j(str, j3);
        QLog.i(TAG, 1, "writeToSpLong " + str + " :" + j3);
    }
}
