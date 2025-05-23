package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
class MultiForwardShortVideoTask implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public final b f287619d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<p> f287620e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<y> f287621f;

    /* renamed from: h, reason: collision with root package name */
    int f287622h = 0;

    public MultiForwardShortVideoTask(b bVar, ArrayList<p> arrayList) {
        this.f287619d = bVar;
        this.f287620e = arrayList;
    }

    public TransferRequest a(int i3, p pVar, MessageRecord messageRecord) {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = messageRecord.selfuin;
        transferRequest.mPeerUin = messageRecord.frienduin;
        transferRequest.mUinType = messageRecord.istroop;
        transferRequest.mFileType = 20;
        transferRequest.mExtraObj = pVar;
        transferRequest.mUniseq = messageRecord.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = 1010;
        transferRequest.mMd5 = pVar.f288047j;
        transferRequest.mLocalPath = pVar.f288204r + ShortVideoForwardProcessor.SEPERATOR + pVar.f288205s + ShortVideoForwardProcessor.SEPERATOR + pVar.f288209w + ShortVideoForwardProcessor.SEPERATOR + pVar.f288049l;
        transferRequest.mUpCallBack = new d(this, i3);
        transferRequest.mRec = this.f287619d.f287788m;
        return transferRequest;
    }

    public void e() {
        if (this.f287620e == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseShortVideoOprerator", 2, "mInfoList is null");
                return;
            }
            return;
        }
        if (this.f287621f == null) {
            this.f287621f = new ArrayList<>(this.f287620e.size());
        }
        Iterator<p> it = this.f287620e.iterator();
        while (it.hasNext()) {
            it.next();
            y yVar = new y();
            yVar.f288328a = -2;
            yVar.f288330c = this.f287619d.f287784e;
            this.f287621f.add(yVar);
        }
        h();
    }

    public void f(TransferRequest transferRequest) {
        ((ITransFileController) this.f287619d.f287783d.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
    }

    public int g() {
        int i3;
        synchronized (this.f287621f) {
            Iterator<y> it = this.f287621f.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().f288328a == -2) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public void h() {
        int size;
        MessageRecord s16;
        if (this.f287622h >= this.f287620e.size()) {
            return;
        }
        if (this.f287622h + 3 < this.f287620e.size()) {
            size = this.f287622h + 3;
        } else {
            size = this.f287620e.size();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseShortVideoOprerator", 2, "mInfoList:" + this.f287620e.size() + " ,uploadStartIndex:" + this.f287622h + " ,finishIndex:" + size);
        }
        for (int i3 = this.f287622h; i3 < size; i3++) {
            p pVar = this.f287620e.get(i3);
            Object obj = pVar.f288210x;
            if (obj != null) {
                s16 = (MessageForShortVideo) obj;
            } else {
                s16 = this.f287619d.s(pVar);
            }
            if (s16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("BaseShortVideoOprerator", 2, "mr is null");
                }
            } else {
                this.f287619d.f287788m = s16;
                long currentTimeMillis = System.currentTimeMillis();
                TransferRequest a16 = a(i3, pVar, s16);
                f(a16);
                if (QLog.isColorLevel()) {
                    QLog.d("BaseShortVideoOprerator", 2, "MultiForwardShortVideo req" + i3 + MsgSummary.STR_COLON + a16.toString() + " ,cost:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
        this.f287622h += 3;
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }
}
