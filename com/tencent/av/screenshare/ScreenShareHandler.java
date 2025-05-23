package com.tencent.av.screenshare;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.ReqGroupVideo$ReqScreenShareAnswer;
import com.tencent.av.ReqGroupVideo$ReqScreenShareAsk;
import com.tencent.av.ReqGroupVideo$RspScreenShareAnswer;
import com.tencent.av.ReqGroupVideo$RspScreenShareAsk;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.common$ErrorInfo;
import com.tencent.av.n;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScreenShareHandler extends BusinessHandler {

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f74279e = {"QQRTCSvc.screen_share_ask", "QQRTCSvc.screen_share_answer"};

    /* renamed from: d, reason: collision with root package name */
    private final VideoAppInterface f74280d;

    public ScreenShareHandler(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.f74280d = videoAppInterface;
    }

    public static String[] F2() {
        return f74279e;
    }

    public void D2(boolean z16) {
        ReqGroupVideo$ReqScreenShareAnswer reqGroupVideo$ReqScreenShareAnswer = new ReqGroupVideo$ReqScreenShareAnswer();
        reqGroupVideo$ReqScreenShareAnswer.from_uin.set(this.f74280d.getLongAccountUin());
        reqGroupVideo$ReqScreenShareAnswer.to_uin.set(Long.parseLong(n.e().f().f73091w));
        reqGroupVideo$ReqScreenShareAnswer.is_accept.set(z16);
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQRTCSvc.screen_share_answer");
        createToServiceMsg.putWupBuffer(reqGroupVideo$ReqScreenShareAnswer.toByteArray());
        sendPbReq(createToServiceMsg);
        if (QLog.isDevelopLevel()) {
            QLog.i("ScreenShareHandler", 4, "answerScreenShare, from " + reqGroupVideo$ReqScreenShareAnswer.from_uin + ", to " + reqGroupVideo$ReqScreenShareAnswer.to_uin + ", isAccept: " + reqGroupVideo$ReqScreenShareAnswer.is_accept);
        }
    }

    public void E2() {
        ReqGroupVideo$ReqScreenShareAsk reqGroupVideo$ReqScreenShareAsk = new ReqGroupVideo$ReqScreenShareAsk();
        reqGroupVideo$ReqScreenShareAsk.from_uin.set(this.f74280d.getLongAccountUin());
        reqGroupVideo$ReqScreenShareAsk.to_uin.set(Long.parseLong(n.e().f().f73091w));
        reqGroupVideo$ReqScreenShareAsk.is_online.set(true);
        ToServiceMsg createToServiceMsg = createToServiceMsg("QQRTCSvc.screen_share_ask");
        createToServiceMsg.putWupBuffer(reqGroupVideo$ReqScreenShareAsk.toByteArray());
        sendPbReq(createToServiceMsg);
        QLog.i("ScreenShareHandler", 4, "askScreenShare, from " + reqGroupVideo$ReqScreenShareAsk.from_uin.get() + " , to " + reqGroupVideo$ReqScreenShareAsk.to_uin.get());
        if (QLog.isDevelopLevel()) {
            QLog.i("ScreenShareHandler", 4, "askScreenShare, from " + reqGroupVideo$ReqScreenShareAsk.from_uin + " , to " + reqGroupVideo$ReqScreenShareAsk.to_uin);
        }
    }

    public void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ReqGroupVideo$RspScreenShareAnswer reqGroupVideo$RspScreenShareAnswer;
        boolean z17 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            reqGroupVideo$RspScreenShareAnswer = new ReqGroupVideo$RspScreenShareAnswer();
            try {
                reqGroupVideo$RspScreenShareAnswer.mergeFrom((byte[]) obj);
                z17 = z16;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("ScreenShareHandler", 1, "handleScreenShareAnswer(): " + e16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ScreenShareHandler", 2, "handleScreenShareAnswer receive success");
            }
            z16 = z17;
        } else {
            reqGroupVideo$RspScreenShareAnswer = null;
        }
        if (!z16) {
            QLog.e("ScreenShareHandler", 2, "handleScreenShareAnswer() failed");
            return;
        }
        common$ErrorInfo common_errorinfo = reqGroupVideo$RspScreenShareAnswer.result.get();
        int F2 = MessageHandler.F2(common_errorinfo);
        String G2 = MessageHandler.G2(common_errorinfo);
        if (F2 != -99) {
            QLog.e("ScreenShareHandler", 2, "handleScreenShareAnswer() error code: %d" + F2 + "error msg: " + G2);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ScreenShareHandler", 2, "handleScreenShareAnswer() found no error");
        }
    }

    public void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ReqGroupVideo$RspScreenShareAsk reqGroupVideo$RspScreenShareAsk;
        boolean z17 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            reqGroupVideo$RspScreenShareAsk = new ReqGroupVideo$RspScreenShareAsk();
            try {
                reqGroupVideo$RspScreenShareAsk.mergeFrom((byte[]) obj);
                z17 = z16;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("ScreenShareHandler", 1, "handleScreenShareAsk(): " + e16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ScreenShareHandler", 2, "handleScreenShareAsk receive success");
            }
            z16 = z17;
        } else {
            reqGroupVideo$RspScreenShareAsk = null;
        }
        if (!z16) {
            QLog.e("ScreenShareHandler", 2, "handleScreenShareAsk() failed");
            return;
        }
        common$ErrorInfo common_errorinfo = reqGroupVideo$RspScreenShareAsk.result.get();
        int F2 = MessageHandler.F2(common_errorinfo);
        final String G2 = MessageHandler.G2(common_errorinfo);
        if (F2 != -99 && F2 != 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.av.screenshare.ScreenShareHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    PopupDialog.o0(BaseApplication.getContext(), 230, null, G2, R.string.f224186i9, R.string.f224186i9, new a(), null);
                    ReportController.o(null, "dc00898", "", "", "0X800B8AB", "0X800B8AB", 0, 0, "", "", "", "");
                }

                /* compiled from: P */
                /* renamed from: com.tencent.av.screenshare.ScreenShareHandler$1$a */
                /* loaded from: classes3.dex */
                class a implements DialogInterface.OnClickListener {
                    a() {
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                    }
                }
            });
            QLog.e("ScreenShareHandler", 2, "handleScreenShareAsk() error code: %d" + F2 + "error msg: " + G2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScreenShareHandler", 2, "handleScreenShareAsk() found no error");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("QQRTCSvc.screen_share_ask");
            this.allowCmdSet.add("QQRTCSvc.screen_share_answer");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("QQRTCSvc.screen_share_ask".equals(fromServiceMsg.getServiceCmd())) {
            H2(toServiceMsg, fromServiceMsg, obj);
        } else if ("QQRTCSvc.screen_share_answer".equals(fromServiceMsg.getServiceCmd())) {
            G2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
