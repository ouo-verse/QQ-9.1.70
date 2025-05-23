package com.tencent.mobileqq.intervideo.now.lifecycle;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.GVideoSoMonitorApiImpl;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IGVideoSoMonitorApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.IForeground;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NowForegroundImpl implements IForeground {

    /* renamed from: a, reason: collision with root package name */
    private int f238383a = 0;

    /* renamed from: b, reason: collision with root package name */
    private IGVideoSoMonitorApi f238384b = new GVideoSoMonitorApiImpl();

    /* renamed from: c, reason: collision with root package name */
    protected AppRuntime f238385c;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<Activity> f238386d;

    public NowForegroundImpl() {
        a();
    }

    public void a() {
        this.f238385c = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    }

    @Override // com.tencent.qqinterface.IForeground
    public void onCreate(Context context) {
        QLog.d("NowForegroundImpl", 2, "onCreate context = " + context);
        Foreground.updateRuntimeState(this.f238385c);
        if (context instanceof Activity) {
            this.f238386d = new WeakReference<>((Activity) context);
        }
    }

    @Override // com.tencent.qqinterface.IForeground
    public void onDestroy() {
        QLog.d("NowForegroundImpl", 2, "onDestroy mRuntime = " + this.f238385c);
    }

    @Override // com.tencent.qqinterface.IForeground
    public void onStart() {
        QLog.d("NowForegroundImpl", 2, "onStart mActivity = " + this.f238386d);
    }

    @Override // com.tencent.qqinterface.IForeground
    public void onStop() {
        QLog.d("NowForegroundImpl", 2, "onStop mRuntime = " + this.f238385c);
    }

    @Override // com.tencent.qqinterface.IForeground
    public void onPause() {
    }

    @Override // com.tencent.qqinterface.IForeground
    public void onResume() {
    }
}
