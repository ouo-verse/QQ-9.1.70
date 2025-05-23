package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseFragmentContainerImp implements d5.u {

    /* renamed from: a, reason: collision with root package name */
    private final BaseFragment f45048a;

    /* renamed from: b, reason: collision with root package name */
    private int f45049b = -1;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f45050c = new a(Looper.getMainLooper());

    @Inject
    public BaseFragmentContainerImp(BaseFragment baseFragment) {
        this.f45048a = baseFragment;
    }

    @Override // d5.u
    public void a(Intent intent, int i3) {
        getActivity().startActivityForResult(intent, i3);
    }

    @Override // d5.u
    public boolean b(int i3) {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NAME_RESUME_FRAGMENT, 4095);
        if ((i3 & config) != 0) {
            boolean isResumed = this.f45048a.isResumed();
            QZLog.i("BaseFragmentContainerIm", 2, "isResumed   flag:", Integer.valueOf(i3), "\uff0cwnsFlags:", Integer.valueOf(config), "\uff0ccall isResumed\uff1a", Boolean.valueOf(isResumed));
            return isResumed;
        }
        boolean isVisible = this.f45048a.isVisible();
        QZLog.i("BaseFragmentContainerIm", 2, "isResumed   flag:", Integer.valueOf(i3), "\uff0cwnsFlags:", Integer.valueOf(config), "\uff0ccall isVisible:", Boolean.valueOf(isVisible));
        return isVisible;
    }

    @Override // d5.u
    public void c(Runnable runnable, long j3) {
        this.f45050c.postDelayed(runnable, j3);
    }

    public boolean e() {
        return this.f45048a.checkNetworkConnect();
    }

    @Override // d5.u
    public <V extends View> V findViewById(int i3) {
        View view = this.f45048a.getView();
        if (view != null) {
            return (V) view.findViewById(i3);
        }
        QZLog.e("BaseFragmentContainerIm", "not attach activity:", new IllegalArgumentException());
        return null;
    }

    @Override // d5.u
    public void finish() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // d5.u
    public Activity getActivity() {
        return this.f45048a.getActivity();
    }

    @Override // d5.u
    public Context getContext() {
        return getActivity();
    }

    @Override // d5.u
    public Fragment getFragment() {
        return this.f45048a;
    }

    @Override // d5.u
    public Handler getHandler() {
        return this.f45050c;
    }

    @Override // d5.u
    public Intent getIntent() {
        if (getActivity() != null) {
            return getActivity().getIntent();
        }
        QZLog.e("BaseFragmentContainerIm", "not attach activity:", new IllegalArgumentException());
        return null;
    }

    @Override // d5.u
    public Resources getResources() {
        return this.f45048a.getResources();
    }

    @Override // d5.u
    public String getString(int i3) {
        return getResources().getString(i3);
    }

    @Override // d5.u
    public Window getWindow() {
        if (getActivity() != null) {
            return getActivity().getWindow();
        }
        QZLog.e("BaseFragmentContainerIm", "not attach activity:", new IllegalArgumentException());
        return null;
    }

    @Override // d5.u
    public boolean isDestroyed() {
        return this.f45048a.isDestroyed();
    }

    @Override // d5.u
    public boolean isFinishing() {
        return this.f45048a.isFinishing();
    }

    @Override // d5.u
    public void overridePendingTransition(int i3, int i16) {
        if (getActivity() != null) {
            getActivity().overridePendingTransition(i3, i16);
        }
    }

    @Override // d5.u
    public void post(Runnable runnable) {
        this.f45050c.post(runnable);
    }

    @Override // d5.u
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            if (getActivity() != null) {
                if (getActivity().isFinishing()) {
                    QZLog.w("BaseFragmentContainerIm", 1, "registerReceiver cancel for activity isFinishing");
                    return null;
                }
                return getActivity().registerReceiver(broadcastReceiver, intentFilter);
            }
        } catch (Throwable th5) {
            QLog.e("BaseFragmentContainerIm", 1, "[registerReceiver] error: ", th5);
        }
        return null;
    }

    @Override // d5.u
    public void sendBroadcast(Intent intent) {
        if (getActivity() != null) {
            getActivity().sendBroadcast(intent);
        }
    }

    @Override // d5.u
    public void setResult(int i3, Intent intent) {
        if (getActivity() != null) {
            getActivity().setResult(i3, intent);
        }
    }

    @Override // d5.u
    public void startActivity(Intent intent) {
        this.f45048a.startActivity(intent);
    }

    @Override // d5.u
    public void startActivityForResult(Intent intent, int i3) {
        this.f45048a.startActivityForResult(intent, i3);
    }

    @Override // d5.u
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            if (getActivity() != null) {
                getActivity().unregisterReceiver(broadcastReceiver);
            }
        } catch (Throwable th5) {
            QZLog.e("BaseFragmentContainerIm", 1, th5, new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (BaseFragmentContainerImp.this.f45048a.isFinishing()) {
                return;
            }
            super.dispatchMessage(message);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            BaseFragmentContainerImp.this.f45048a.handleMessage(message);
        }
    }

    @Override // d5.u
    public void setResult(int i3) {
        if (getActivity() != null) {
            getActivity().setResult(i3);
        }
    }
}
