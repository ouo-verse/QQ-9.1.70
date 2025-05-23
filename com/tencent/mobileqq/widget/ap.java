package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ap implements DialogInterface.OnCancelListener, Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    protected QQProgressDialog f316674d;

    /* renamed from: e, reason: collision with root package name */
    protected final WeakReference<Activity> f316675e;

    /* renamed from: f, reason: collision with root package name */
    int f316676f;

    /* renamed from: h, reason: collision with root package name */
    protected final Handler f316677h;

    /* renamed from: i, reason: collision with root package name */
    protected final ArrayList<DialogInterface.OnCancelListener> f316678i;

    public ap(Activity activity) {
        this(activity, -1);
    }

    public void b() {
        this.f316677h.removeMessages(1);
        this.f316677h.removeMessages(2);
        try {
            QQProgressDialog qQProgressDialog = this.f316674d;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f316674d.dismiss();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.f316678i.clear();
    }

    public boolean c() {
        QQProgressDialog qQProgressDialog = this.f316674d;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void d(int i3, int i16, int i17) {
        Activity activity = this.f316675e.get();
        if (activity == null) {
            if (QLog.isColorLevel()) {
                QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
                return;
            }
            return;
        }
        e(i3, activity.getString(i16), i17);
    }

    public void e(int i3, String str, int i16) {
        f(i3, str, i16, null);
    }

    public void f(int i3, String str, int i16, DialogInterface.OnCancelListener onCancelListener) {
        long j3;
        Activity activity = this.f316675e.get();
        if (activity == null) {
            if (QLog.isColorLevel()) {
                QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
                return;
            }
            return;
        }
        if (onCancelListener != null && !this.f316678i.contains(onCancelListener)) {
            this.f316678i.add(onCancelListener);
        }
        this.f316677h.removeMessages(1);
        this.f316677h.removeMessages(2);
        if (i3 == 0 && i16 > 0) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i3;
            obtain.arg2 = 0;
            obtain.obj = str;
            this.f316677h.sendMessageDelayed(obtain, i16);
            return;
        }
        if (this.f316674d == null) {
            if (this.f316676f > 0) {
                this.f316674d = new QQProgressDialog(activity, 0, this.f316676f, 17);
            } else {
                this.f316674d = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
        if (this.f316678i.isEmpty()) {
            this.f316674d.setOnCancelListener(null);
        } else {
            this.f316674d.setOnCancelListener(this);
        }
        if (i3 == 0) {
            if (str != null && !"".equals(str.trim())) {
                this.f316674d.setMessage(str);
            } else {
                this.f316674d.setMessage(activity.getString(R.string.hex));
            }
            this.f316674d.showTipImageView(false);
            this.f316674d.showProgerss(true);
            if (activity.isFinishing()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQProgressNotifier", 4, "[" + activity.isFinishing() + "]");
                    return;
                }
                return;
            }
            this.f316674d.show();
            return;
        }
        if (i3 != 2 && i3 != 4 && i3 != 6) {
            this.f316674d.setMessage(str);
            this.f316674d.setTipImageView(R.drawable.f160604l9);
        } else {
            this.f316674d.setMessage(str);
            this.f316674d.setTipImageView(R.drawable.f160601l6);
        }
        this.f316674d.showTipImageView(true);
        this.f316674d.showProgerss(false);
        if (!this.f316674d.isShowing()) {
            if (activity.isFinishing()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQProgressNotifier", 4, "[" + activity.isFinishing() + "]");
                }
            } else {
                this.f316674d.show();
            }
        }
        Message obtain2 = Message.obtain();
        obtain2.what = 2;
        obtain2.arg1 = i3;
        Handler handler = this.f316677h;
        if (i16 > 0) {
            j3 = i16;
        } else {
            j3 = 1000;
        }
        handler.sendMessageDelayed(obtain2, j3);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            e(message.arg1, (String) message.obj, message.arg2);
        } else if (i3 == 2) {
            b();
            int i16 = message.arg1;
            if (i16 == 3 || i16 == 4 || i16 == 6 || i16 == 5) {
                Activity activity = this.f316675e.get();
                if (activity != null) {
                    int i17 = message.arg1;
                    if (i17 != 6 && i17 != 5) {
                        activity.setResult(-1);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                        activity.setResult(-1, intent);
                    }
                    activity.finish();
                } else if (QLog.isColorLevel()) {
                    QLog.i("QQProgressNotifier", 2, "handleMessage baseActivity is null");
                }
            }
        }
        return true;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (QLog.isDevelopLevel()) {
            QLog.d("QQProgressNotifier", 4, "onCancel");
        }
        if (this.f316678i.size() > 0) {
            Iterator<DialogInterface.OnCancelListener> it = this.f316678i.iterator();
            while (it.hasNext()) {
                DialogInterface.OnCancelListener next = it.next();
                if (next != null) {
                    next.onCancel(this.f316674d);
                }
            }
        }
        this.f316678i.clear();
    }

    public ap(Activity activity, int i3) {
        this.f316675e = new WeakReference<>(activity);
        this.f316676f = i3;
        this.f316678i = new ArrayList<>();
        this.f316677h = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }
}
