package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScribbleBaseOperator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public AppRuntime f282506a;

    public ScribbleBaseOperator(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        } else {
            this.f282506a = appRuntime;
        }
    }

    public MessageForScribble a(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MessageForScribble) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForScribble);
        }
        MessageForScribble messageForScribble2 = (MessageForScribble) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createResendMsg(messageForScribble);
        if (messageForScribble2 == null) {
            QLog.e("CreateResendScribbleMsg", 2, "null msg");
        }
        if (messageForScribble2 != null) {
            messageForScribble2.offSet = messageForScribble.offSet;
            messageForScribble2.gifId = messageForScribble.gifId;
            messageForScribble2.localFildPath = messageForScribble.localFildPath;
            messageForScribble2.combineFileMd5 = messageForScribble.combineFileMd5;
            messageForScribble2.isread = true;
            messageForScribble2.fileUploadStatus = 0;
        }
        return messageForScribble2;
    }

    public MessageForScribble b(String str, String str2, int i3, String str3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageForScribble) iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), str3, Integer.valueOf(i16), Integer.valueOf(i17));
        }
        MessageForScribble messageForScribble = (MessageForScribble) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(-7001);
        ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).setSendingMsgRecordBaseInfo(this.f282506a, messageForScribble, str3, str3, i16);
        messageForScribble.msgtype = -7001;
        messageForScribble.offSet = i3;
        messageForScribble.gifId = i17;
        messageForScribble.localFildPath = str;
        messageForScribble.combineFileMd5 = str2;
        String currentAccountUin = this.f282506a.getCurrentAccountUin();
        messageForScribble.selfuin = currentAccountUin;
        messageForScribble.senderuin = currentAccountUin;
        messageForScribble.issend = 1;
        messageForScribble.fileUploadStatus = 0;
        return messageForScribble;
    }

    public boolean c(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForScribble)).booleanValue();
        }
        ThreadManagerV2.post(new Runnable(messageForScribble) { // from class: com.tencent.mobileqq.scribble.ScribbleBaseOperator.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageForScribble f282507d;

            {
                this.f282507d = messageForScribble;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScribbleBaseOperator.this, (Object) messageForScribble);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IMessageFacade iMessageFacade = (IMessageFacade) ScribbleBaseOperator.this.f282506a.getRuntimeService(IMessageFacade.class, "");
                if (iMessageFacade == null) {
                    return;
                }
                iMessageFacade.addMessage(this.f282507d, ScribbleBaseOperator.this.f282506a.getCurrentAccountUin());
                ScribbleBaseOperator scribbleBaseOperator = ScribbleBaseOperator.this;
                MessageForScribble messageForScribble2 = this.f282507d;
                scribbleBaseOperator.e(messageForScribble2, messageForScribble2.localFildPath, null);
                QLog.i("SCRIBBLEMSG", 2, "!!!addMessage uniseq:" + this.f282507d.uniseq);
            }
        }, 8, null, false);
        return true;
    }

    public boolean d(MessageForScribble messageForScribble, com.tencent.mobileqq.pic.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageForScribble, (Object) cVar)).booleanValue();
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = false;
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_SCRIBBLE_DATA;
        transferRequest.mSelfUin = messageForScribble.selfuin;
        transferRequest.mPeerUin = messageForScribble.frienduin;
        transferRequest.mUinType = messageForScribble.istroop;
        transferRequest.mUniseq = messageForScribble.uniseq;
        transferRequest.mDownCallBack = cVar;
        transferRequest.mRec = messageForScribble;
        ((ITransFileController) this.f282506a.getRuntimeService(ITransFileController.class, "")).transferAsync(transferRequest);
        return true;
    }

    public boolean e(MessageForScribble messageForScribble, String str, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, messageForScribble, str, adVar)).booleanValue();
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_SCRIBBLE_DATA;
        transferRequest.mSelfUin = messageForScribble.selfuin;
        transferRequest.mPeerUin = messageForScribble.frienduin;
        transferRequest.mUinType = messageForScribble.istroop;
        transferRequest.mUniseq = messageForScribble.uniseq;
        transferRequest.mUpCallBack = adVar;
        transferRequest.mLocalPath = str;
        transferRequest.mRec = messageForScribble;
        messageForScribble.fileUploadStatus = 3;
        ((ITransFileController) this.f282506a.getRuntimeService(ITransFileController.class, "")).transferAsync(transferRequest);
        return true;
    }
}
