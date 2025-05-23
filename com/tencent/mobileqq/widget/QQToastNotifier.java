package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQToastNotifier {
    private static final int MSG_SHOW_TOAST = 1;
    Toast mToast = null;
    private Handler handler = new a(Looper.getMainLooper());
    Context mContext = BaseApplication.getContext();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ToastData {
        int duration;
        int icon;
        int msgId;
        String msgString;
        int offset;

        ToastData() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ToastData toastData = (ToastData) message.obj;
            String str = toastData.msgString;
            if (str == null || str.length() == 0) {
                try {
                    str = QQToastNotifier.this.mContext.getResources().getString(toastData.msgId);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            QQToastNotifier qQToastNotifier = QQToastNotifier.this;
            Toast toast = qQToastNotifier.mToast;
            if (toast == null) {
                qQToastNotifier.mToast = QQToast.makeText(qQToastNotifier.mContext, toastData.icon, str, toastData.duration).create(toastData.offset);
            } else {
                try {
                    View view = toast.getView();
                    ((TextView) view.findViewById(R.id.toast_msg)).setText(str);
                    ((ImageView) view.findViewById(R.id.toast_icon)).setImageResource(QQToast.getIconRes(toastData.icon));
                    QQToastNotifier.this.mToast.setDuration(toastData.duration);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    QQToastNotifier.this.mToast = null;
                    if (QLog.isColorLevel()) {
                        QLog.i("QQToastNotifier", 2, th5.toString());
                    }
                }
            }
            Toast toast2 = QQToastNotifier.this.mToast;
            if (toast2 != null) {
                toast2.show();
            }
        }
    }

    public QQToastNotifier(Context context) {
    }

    public void cancelQQToast() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.cancel();
        }
    }

    public void notifyUser(int i3) {
        notifyUser(i3, 0, 0, 0);
    }

    public void notifyUser(int i3, int i16) {
        notifyUser(i3, i16, 0, 0);
    }

    public void notifyUser(int i3, int i16, int i17, int i18) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        ToastData toastData = new ToastData();
        toastData.icon = i18;
        toastData.msgId = i3;
        toastData.duration = i17;
        toastData.offset = i16;
        obtain.obj = toastData;
        this.handler.removeMessages(1);
        this.handler.sendMessage(obtain);
    }

    public void notifyUser(String str, int i3, int i16, int i17) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        ToastData toastData = new ToastData();
        toastData.icon = i17;
        toastData.msgString = str;
        toastData.duration = i16;
        toastData.offset = i3;
        obtain.obj = toastData;
        this.handler.sendMessage(obtain);
    }
}
