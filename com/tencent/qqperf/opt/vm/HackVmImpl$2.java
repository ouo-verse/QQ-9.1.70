package com.tencent.qqperf.opt.vm;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes25.dex */
class HackVmImpl$2 implements Runnable {
    HackVmImpl$2() {
    }

    @Override // java.lang.Runnable
    public void run() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_hack_dvm", 4);
        if (a.f363349b == 21) {
            sharedPreferences.edit().putInt("key_art_continuous_crash_count", 0);
        }
        sharedPreferences.edit().putLong("key_last_hack_art_time", 0L).commit();
    }
}
