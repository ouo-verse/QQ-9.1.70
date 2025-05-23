package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.quic.internal.QuicNative;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class AbTransportRunnable implements ITaskHandler, QuicNative.QuicCallback {
    static IPatchRedirector $redirector_ = null;
    static final int CLIENT_CANCELED = 10;
    static final int CLIENT_FAILED = 5;
    static final String CODE = "CODE";
    static final int COMPLETED_MANUAL = 3;
    static final int CONNECTED = 1;
    static final String DATA = "DATA";
    static final String DESC = "DESC";
    static final int ENQUEUE_TASK = 9;
    static final String ID = "ID";
    static final String LEN = "LEN";
    static final int RECEIVING = 2;
    static final int SERVER_CLOSED = 4;
    static final int TASK_FAIL = 8;
    static final int TASK_FINISH = 7;
    static final int TASK_SUCC = 6;
    protected Bundle bundle;
    protected Message message;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbTransportRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.message = new Message();
        }
    }

    public abstract void enqueue(QuicDownloadTask quicDownloadTask);

    @Override // com.tencent.mobileqq.transfile.quic.internal.ITaskHandler
    public abstract void handleMessage(Message message);

    protected Bundle obtainBundle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Bundle bundle = this.bundle;
        if (bundle == null) {
            this.bundle = new Bundle();
        } else {
            bundle.clear();
        }
        return this.bundle;
    }

    @Override // com.tencent.mobileqq.transfile.quic.internal.QuicNative.QuicCallback
    public void onClose(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("quic", 4, Integer.valueOf(i3), " onClose code -> ", Integer.valueOf(i16), " desc -> ", str);
        }
        this.message.what = 4;
        Bundle obtainBundle = obtainBundle();
        obtainBundle.putInt(ID, i3);
        obtainBundle.putInt(CODE, i16);
        obtainBundle.putString(DESC, str);
        Message message = this.message;
        message.obj = obtainBundle;
        handleMessage(message);
    }

    @Override // com.tencent.mobileqq.transfile.quic.internal.QuicNative.QuicCallback
    public void onCompleted(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("quic", 4, "[" + i3 + "] onCompleted");
        }
    }

    @Override // com.tencent.mobileqq.transfile.quic.internal.QuicNative.QuicCallback
    public void onConnect(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("quic", 4, "[" + i3 + "] onConnect");
        }
        this.message.what = 1;
        Bundle obtainBundle = obtainBundle();
        obtainBundle.putInt(ID, i3);
        Message message = this.message;
        message.obj = obtainBundle;
        handleMessage(message);
    }

    @Override // com.tencent.mobileqq.transfile.quic.internal.QuicNative.QuicCallback
    public void onDataReceive(int i3, byte[] bArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16));
            return;
        }
        this.message.what = 2;
        Bundle obtainBundle = obtainBundle();
        obtainBundle.putByteArray(DATA, bArr);
        obtainBundle.putInt(LEN, i16);
        obtainBundle.putInt(ID, i3);
        Message message = this.message;
        message.obj = obtainBundle;
        handleMessage(message);
    }
}
