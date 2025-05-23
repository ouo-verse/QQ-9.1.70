package com.tencent.qqperf.monitor.crash.safemode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes25.dex */
public class SafeModeProcessor extends l<b> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + str);
            b a16 = b.a(str);
            if (a16 != null) {
                BaseApplication.getContext().getSharedPreferences(MsfPullConfigUtil.SP_SAFEMODE_TEST_CRASH_CONFIG, 4).edit().putBoolean(MsfPullConfigUtil.KEY_TEST_CRASH_SWITCH, a16.f363217a).apply();
                BaseApplication.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", a16.f363217a).commit();
            }
            return a16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
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
        return 424;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
