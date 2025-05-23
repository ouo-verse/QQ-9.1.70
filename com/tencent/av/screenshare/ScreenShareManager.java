package com.tencent.av.screenshare;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ReqGroupVideo$MsgScreenShareAnswer;
import com.tencent.av.ReqGroupVideo$MsgScreenShareAsk;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScreenShareManager extends com.tencent.av.business.manager.a implements Handler.Callback {

    /* renamed from: h, reason: collision with root package name */
    private final WeakReferenceHandler f74283h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ScreenShareCtrl f74285d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f74286e;

        a(ScreenShareCtrl screenShareCtrl, String str) {
            this.f74285d = screenShareCtrl;
            this.f74286e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f74285d.w(e.d());
            ScreenShareManager.this.m(true);
            ReportController.o(null, "dc00898", "", "", "0X800B8A9", "0X800B8A9", 0, 0, this.f74286e, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f74288d;

        b(String str) {
            this.f74288d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ScreenShareManager.this.m(false);
            ReportController.o(null, "dc00898", "", "", "0X800B8AA", "0X800B8AA", 0, 0, this.f74288d, "", "", "");
        }
    }

    public ScreenShareManager(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.f74283h = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    private void q(final String str, long j3) {
        Runnable runnable = new Runnable() { // from class: com.tencent.av.screenshare.ScreenShareManager.3
            @Override // java.lang.Runnable
            public void run() {
                cw.e.i(((com.tencent.av.business.manager.a) ScreenShareManager.this).f73316e, str, 3000L, false);
            }
        };
        if (j3 == 0) {
            this.f74283h.post(runnable);
        } else {
            this.f74283h.postDelayed(runnable, j3);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 4 && message.obj != null) {
            QLog.i("ScreenShareManager", 1, "handleMessage msgtype:" + message.arg1);
            int i3 = message.arg1;
            if (i3 == 5) {
                ReqGroupVideo$MsgScreenShareAsk reqGroupVideo$MsgScreenShareAsk = (ReqGroupVideo$MsgScreenShareAsk) message.obj;
                p(reqGroupVideo$MsgScreenShareAsk.ask_wording.get().toStringUtf8(), String.valueOf(reqGroupVideo$MsgScreenShareAsk.from_uin.get()));
            } else if (i3 == 6 && !((ReqGroupVideo$MsgScreenShareAnswer) message.obj).is_accept.get()) {
                q(n.e().f().f73099y + BaseApplication.getContext().getString(R.string.f224136i4), 0L);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ScreenShareManager", 4, "onQavPushMsg");
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        return false;
    }

    public void m(boolean z16) {
        ((ScreenShareHandler) this.f73316e.getBusinessHandler(com.tencent.av.business.handler.b.f73289a)).D2(z16);
    }

    public void n() {
        ((ScreenShareHandler) this.f73316e.getBusinessHandler(com.tencent.av.business.handler.b.f73289a)).E2();
    }

    public void o(int i3, byte[] bArr) {
        QLog.i("ScreenShareManager", 2, "onReceivePushMsg");
        if (bArr != null && bArr.length != 0) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.arg1 = i3;
            boolean z16 = true;
            if (i3 == 5) {
                ReqGroupVideo$MsgScreenShareAsk reqGroupVideo$MsgScreenShareAsk = new ReqGroupVideo$MsgScreenShareAsk();
                try {
                    reqGroupVideo$MsgScreenShareAsk.mergeFrom(bArr);
                    obtain.obj = reqGroupVideo$MsgScreenShareAsk;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAsk", e16);
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAsk", th5);
                    }
                }
            } else {
                if (i3 == 6) {
                    ReqGroupVideo$MsgScreenShareAnswer reqGroupVideo$MsgScreenShareAnswer = new ReqGroupVideo$MsgScreenShareAnswer();
                    try {
                        reqGroupVideo$MsgScreenShareAnswer.mergeFrom(bArr);
                        obtain.obj = reqGroupVideo$MsgScreenShareAnswer;
                    } catch (InvalidProtocolBufferMicroException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAnswer", e17);
                        }
                    } catch (Throwable th6) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAnswer", th6);
                        }
                    }
                }
                z16 = false;
            }
            if (z16) {
                this.f74283h.sendMessage(obtain);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScreenShareManager", 2, "onReceivePushMsg, param illegal.");
        }
    }

    public void p(String str, String str2) {
        BaseApplication context = BaseApplication.getContext();
        ScreenShareCtrl y06 = r.h0().y0();
        if (y06 == null) {
            return;
        }
        DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f224126i3), str, R.string.f224116i2, R.string.f224106i1, new a(y06, str2), new b(str2)).show();
        ReportController.o(null, "dc00898", "", "", "0X800B8A8", "0X800B8A8", 0, 0, str2, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void g() {
    }
}
