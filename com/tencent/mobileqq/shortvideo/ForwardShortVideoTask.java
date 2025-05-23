package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

/* compiled from: P */
/* loaded from: classes18.dex */
class ForwardShortVideoTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final b f287617d;

    /* renamed from: e, reason: collision with root package name */
    p f287618e;

    public ForwardShortVideoTask(b bVar, p pVar) {
        this.f287617d = bVar;
        this.f287618e = pVar;
    }

    public TransferRequest a(p pVar, MessageRecord messageRecord) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = messageRecord.selfuin;
        transferRequest.mPeerUin = messageRecord.frienduin;
        transferRequest.mUinType = messageRecord.istroop;
        transferRequest.mFileType = 20;
        transferRequest.mExtraObj = pVar;
        transferRequest.mUniseq = messageRecord.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = 0;
        transferRequest.mMd5 = pVar.f288047j;
        transferRequest.mLocalPath = pVar.f288204r + ShortVideoForwardProcessor.SEPERATOR + pVar.f288205s + ShortVideoForwardProcessor.SEPERATOR + pVar.f288209w + ShortVideoForwardProcessor.SEPERATOR + pVar.f288049l;
        b bVar = this.f287617d;
        transferRequest.mUpCallBack = bVar;
        transferRequest.mRec = bVar.f287788m;
        return transferRequest;
    }

    public void b(p pVar, MessageRecord messageRecord, long j3, int i3, boolean z16) {
        ((IForwardOrderManager) QRoute.api(IForwardOrderManager.class)).mapUniSeqId(messageRecord.uniseq, j3, i3);
        this.f287617d.f287788m = messageRecord;
        long currentTimeMillis = System.currentTimeMillis();
        TransferRequest a16 = a(pVar, messageRecord);
        f(a16);
        if (z16) {
            this.f287617d.a(messageRecord, pVar.R);
        }
        b bVar = this.f287617d;
        com.tencent.mobileqq.pic.f.c(bVar.f287787i, bVar.f287786h, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        b bVar2 = this.f287617d;
        com.tencent.mobileqq.pic.f.c(bVar2.f287787i, bVar2.f287786h, "doForwardShortVideo.start", "TransferRequest: " + a16.toString());
    }

    public void e() {
        boolean z16;
        MessageRecord messageRecord;
        p pVar = this.f287618e;
        if (pVar == null) {
            return;
        }
        long j3 = pVar.f288045h;
        int i3 = pVar.I;
        int i16 = pVar.f288211y;
        if (i16 == 3) {
            messageRecord = this.f287617d.s(pVar);
            z16 = true;
        } else {
            z16 = false;
            if (i16 == 4) {
                messageRecord = (MessageForShortVideo) pVar.f288210x;
            } else {
                messageRecord = null;
            }
        }
        MessageRecord messageRecord2 = messageRecord;
        if (messageRecord2 == null) {
            return;
        }
        b(pVar, messageRecord2, j3, i3, z16);
    }

    public void f(TransferRequest transferRequest) {
        ((ITransFileController) this.f287617d.f287783d.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }
}
