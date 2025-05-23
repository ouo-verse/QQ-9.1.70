package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BinderAdapter implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f36663a;

    /* renamed from: b, reason: collision with root package name */
    private final String f36664b;

    /* renamed from: c, reason: collision with root package name */
    private final String f36665c;

    /* renamed from: d, reason: collision with root package name */
    private BinderCallBack f36666d;

    /* renamed from: e, reason: collision with root package name */
    private IBinder f36667e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f36668f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private boolean f36669g = false;

    /* renamed from: h, reason: collision with root package name */
    private Handler f36670h = null;

    /* renamed from: i, reason: collision with root package name */
    private Handler f36671i = null;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface BinderCallBack {
        void onBinderFailed(int i3);

        void onBinderFailed(int i3, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f36663a = context;
        this.f36664b = str;
        this.f36665c = str2;
    }

    private void c() {
        synchronized (this.f36668f) {
            Handler handler = this.f36670h;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.f36670h = null;
            }
        }
    }

    private void d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message != null && message.what == BinderAdapter.this.getMsgDelayDisconnect()) {
                    HMSLog.i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                    BinderAdapter.this.unBind();
                    BinderCallBack f16 = BinderAdapter.this.f();
                    if (f16 != null) {
                        f16.onTimedDisconnected();
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
        this.f36671i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    private void e() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f36663a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack f16 = f();
            if (f16 != null) {
                f16.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e16) {
            HMSLog.e("BinderAdapter", "getBindFailPendingIntent failed " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack f() {
        return this.f36666d;
    }

    private void g() {
        Handler handler = this.f36670h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f36670h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message != null && message.what == BinderAdapter.this.getConnTimeOut()) {
                        HMSLog.e("BinderAdapter", "In connect, bind core service time out");
                        BinderAdapter.this.b();
                        return true;
                    }
                    return false;
                }
            });
        }
        this.f36670h.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
    }

    private void h() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f36671i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.f36666d = binderCallBack;
        a();
    }

    protected int getConnTimeOut() {
        return 0;
    }

    protected int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f36664b;
    }

    public IBinder getServiceBinder() {
        return this.f36667e;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f36669g) {
            this.f36669g = false;
            return;
        }
        unBind();
        c();
        BinderCallBack f16 = f();
        if (f16 != null) {
            f16.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f36667e = iBinder;
        c();
        BinderCallBack f16 = f();
        if (f16 != null) {
            f16.onServiceConnected(componentName, iBinder);
        }
        d();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack f16 = f();
        if (f16 != null) {
            f16.onServiceDisconnected(componentName);
        }
        h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f36663a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f36671i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.f36671i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
            }
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.f36664b) || TextUtils.isEmpty(this.f36665c)) {
            e();
        }
        Intent intent = new Intent(this.f36664b);
        try {
            intent.setPackage(this.f36665c);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            e();
        }
        synchronized (this.f36668f) {
            if (this.f36663a.bindService(intent, this, 1)) {
                g();
            } else {
                this.f36669g = true;
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BinderCallBack f16 = f();
        if (f16 != null) {
            f16.onBinderFailed(-1);
        }
    }
}
