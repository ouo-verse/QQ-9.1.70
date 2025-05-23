package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SendShortVideoTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final b f287669d;

    /* renamed from: e, reason: collision with root package name */
    aa f287670e;

    public SendShortVideoTask(b bVar, aa aaVar) {
        this.f287669d = bVar;
        this.f287670e = aaVar;
    }

    private void b(aa aaVar, MessageRecord messageRecord, boolean z16) {
        if (!aaVar.C && !aaVar.E) {
            if (!aaVar.f287755x) {
                ((IMessageFacade) this.f287669d.f287783d.getRuntimeService(IMessageFacade.class)).setChangeAndNotify(messageRecord);
            } else if (z16) {
                this.f287669d.e(messageRecord);
            }
        }
    }

    private void f(TransferRequest transferRequest) {
        ((ITransFileController) this.f287669d.f287783d.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    public TransferRequest a(aa aaVar, MessageRecord messageRecord) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = messageRecord.selfuin;
        transferRequest.mPeerUin = messageRecord.frienduin;
        int i3 = messageRecord.istroop;
        transferRequest.mUinType = i3;
        if (i3 != 0 && i3 != 1008) {
            if (i3 == 3000) {
                transferRequest.mFileType = 17;
            } else if (i3 == 1) {
                transferRequest.mFileType = 9;
            } else if (i3 == 10014) {
                transferRequest.mFileType = 67;
            }
        } else {
            transferRequest.mFileType = 6;
        }
        transferRequest.mUniseq = messageRecord.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = aaVar.f288040c;
        transferRequest.mMd5 = aaVar.f288047j;
        transferRequest.mLocalPath = aaVar.f287745n + ShortVideoForwardProcessor.SEPERATOR + aaVar.f287746o + ShortVideoForwardProcessor.SEPERATOR + aaVar.f287750s + ShortVideoForwardProcessor.SEPERATOR + aaVar.f288049l;
        transferRequest.mSourceVideoCodecFormat = aaVar.f288050m;
        transferRequest.mUpCallBack = this.f287669d;
        transferRequest.mRec = messageRecord;
        transferRequest.mExtraObj = this.f287670e;
        return transferRequest;
    }

    public void c(aa aaVar, MessageRecord messageRecord, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        TransferRequest a16 = a(aaVar, messageRecord);
        f(a16);
        b(aaVar, messageRecord, z16);
        b bVar = this.f287669d;
        com.tencent.mobileqq.pic.f.c(bVar.f287787i, bVar.f287786h, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        b bVar2 = this.f287669d;
        com.tencent.mobileqq.pic.f.c(bVar2.f287787i, bVar2.f287786h, "doSendShortVideo.start", "TransferRequest: " + a16.toString());
    }

    public void e() {
        MessageRecord messageRecord;
        QLog.e("SendShortVideoTask", 1, "doSendShortVideoTask,mInfo:" + this.f287670e);
        aa aaVar = this.f287670e;
        if (aaVar == null) {
            return;
        }
        boolean z16 = false;
        if (!aaVar.f287755x) {
            messageRecord = (MessageForShortVideo) aaVar.f287751t;
        } else {
            int i3 = aaVar.f287752u;
            if (i3 == 0) {
                messageRecord = this.f287669d.l(aaVar);
                z16 = true;
            } else if (i3 == 1) {
                messageRecord = (MessageForShortVideo) aaVar.f287751t;
            } else {
                messageRecord = null;
            }
        }
        if (messageRecord == null) {
            QLog.e("SendShortVideoTask", 1, "doSendShortVideoTask, message nullmInfo:" + this.f287670e);
            return;
        }
        this.f287669d.f287788m = messageRecord;
        c(aaVar, messageRecord, z16);
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }
}
