package com.huawei.hms.health;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.hihealth.HiHealthKitClient;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabf extends ReportAndroidXFragment {
    private static Handler aabc;
    private View aab;
    private HandlerThread aaba;
    private Activity aabb;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class aab extends BaseThread {
        aab(String str) {
            super(str);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                HiHealthKitClient.getInstance().connectHmsWithTransActivity(aabf.this.aabb);
            } catch (Throwable unused) {
                aabz.aab("HealthKitTransparentFragment", "ConnectHmsInBackGroundTaskThread has exception");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class aaba implements Thread.UncaughtExceptionHandler {
        /* synthetic */ aaba(aabe aabeVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th5) {
            aabz.aab("HealthKitTransparentFragment", "HealthKitTransparentFragment thread catch exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        aabz.aabb("HealthKitTransparentFragment", "HealthKitTransparentFragment onFinish");
        aabc = null;
        this.aaba = null;
        this.aabb.finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aabb = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.aab == null) {
            this.aab = layoutInflater.inflate(R.layout.e_8, viewGroup, false);
        }
        if (this.aaba == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("kit_activity_thread_handler");
            this.aaba = baseHandlerThread;
            baseHandlerThread.start();
            aabc = new aabe(this, this.aaba.getLooper());
        }
        aab aabVar = new aab("HealthKitConnectHmsInTaskThread");
        aabVar.setUncaughtExceptionHandler(new aaba(null));
        aabVar.start();
        View view = this.aab;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    public static Handler aaba() {
        return aabc;
    }
}
