package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BaseSVReceiveOperator implements com.tencent.mobileqq.pic.c, xq2.b {

    /* renamed from: d, reason: collision with root package name */
    public BaseQQAppInterface f287608d;

    /* renamed from: e, reason: collision with root package name */
    public v f287609e;

    /* renamed from: f, reason: collision with root package name */
    protected ab f287610f;

    /* renamed from: h, reason: collision with root package name */
    public String f287611h;

    /* renamed from: i, reason: collision with root package name */
    public String f287612i;

    /* renamed from: m, reason: collision with root package name */
    protected Handler f287613m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaseSVReceiveOperator.this.g(message);
        }
    }

    public BaseSVReceiveOperator(BaseQQAppInterface baseQQAppInterface) {
        this.f287608d = baseQQAppInterface;
        if (this.f287613m == null) {
            this.f287613m = new a(Looper.getMainLooper());
        }
    }

    public static void v(final BaseQQAppInterface baseQQAppInterface, final v vVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.BaseSVReceiveOperator.2
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoPreDownloader shortVideoPredownloer = ((QQAppInterface) BaseQQAppInterface.this).getShortVideoPredownloer();
                if (shortVideoPredownloer.G.contains(vVar)) {
                    shortVideoPredownloer.G.remove(vVar);
                    shortVideoPredownloer.H.decrementAndGet();
                    shortVideoPredownloer.f287672e.remove(vVar.f288268i.f288039b);
                    com.tencent.mobileqq.pic.f.b("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + vVar.f288268i.f288045h + ",curHandingNum:" + shortVideoPredownloer.H.get());
                    ((QQAppInterface) BaseQQAppInterface.this).getShortVideoPredownloer().d();
                }
            }
        }, 8, null, false);
    }

    @Override // com.tencent.mobileqq.pic.c
    public void a(int i3, boolean z16) {
        y yVar = new y();
        yVar.f288328a = 0;
        yVar.f288331d = Integer.valueOf(i3);
        u(1, 0, yVar);
    }

    boolean b(n nVar) {
        if (nVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f287612i, this.f287611h, "checkShortVideoDownloadInfo", "info:" + nVar);
            return nVar.b();
        }
        com.tencent.mobileqq.pic.f.e(this.f287612i, this.f287611h, "checkShortVideoDownloadInfo", "info == null");
        return false;
    }

    @Override // xq2.b
    public p f(Object obj, v vVar) {
        return null;
    }

    public void g(Message message) {
        if (message.what != 1) {
            com.tencent.mobileqq.pic.f.c(this.f287612i, this.f287611h, "dispatchMessage", "what:" + message.what + ",result:" + message.arg1 + ",obj:" + message.obj);
        }
        ab abVar = this.f287610f;
        if (abVar == null) {
            return;
        }
        int i3 = message.arg1;
        int i16 = message.what;
        if (i16 != 0) {
            if (i16 == 1) {
                Object obj = ((y) message.obj).f288331d;
                if (obj instanceof Integer) {
                    abVar.onUpdateProgress(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            return;
        }
        abVar.a(i3, (y) message.obj);
    }

    @Override // com.tencent.mobileqq.pic.c
    public void h(c.a aVar) {
        if (aVar == null) {
            m.a aVar2 = new m.a();
            aVar2.f258737b = "result == null";
            aVar2.f258736a = "onDownload";
            r(0, aVar2);
            return;
        }
        v(this.f287608d, this.f287609e);
        com.tencent.mobileqq.pic.f.c(this.f287612i, this.f287611h, "onDownload", "result:" + aVar.f258654a);
        y yVar = new y();
        int i3 = aVar.f258654a;
        yVar.f288328a = i3;
        yVar.f288331d = aVar;
        if (i3 == 0) {
            t(0, yVar);
            return;
        }
        m.a aVar3 = aVar.f258657d;
        if (aVar3 == null) {
            m.a aVar4 = new m.a();
            aVar4.f258737b = aVar.f258655b + "_" + aVar.f258656c;
            aVar4.f258736a = "onDownload";
            r(0, aVar4);
            return;
        }
        r(0, aVar3);
    }

    @Override // xq2.b
    public aa i(Object obj, v vVar) {
        return null;
    }

    @Override // xq2.b
    public void k(BaseQQAppInterface baseQQAppInterface) {
        this.f287608d = baseQQAppInterface;
    }

    @Override // xq2.b
    public MessageRecord l(aa aaVar) {
        return null;
    }

    void m(n nVar) {
        MessageForShortVideo messageForShortVideo;
        long currentTimeMillis = System.currentTimeMillis();
        nVar.f288042e = this.f287608d.getCurrentAccountUin();
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mSelfUin = nVar.f288042e;
        transferRequest.mPeerUin = nVar.f288043f;
        transferRequest.mSecondId = nVar.f288044g;
        transferRequest.mUinType = nVar.f288041d;
        transferRequest.mUniseq = nVar.f288045h;
        transferRequest.mIsUp = false;
        transferRequest.mBusiType = nVar.f288040c;
        transferRequest.mDownMode = nVar.f288196t;
        transferRequest.mExtraObj = Integer.valueOf(nVar.f288197u);
        transferRequest.mIsOnlyGetUrl = nVar.f288198v;
        transferRequest.mTargetVideoCodecFormat = nVar.f288199w;
        transferRequest.mSourceVideoCodecFormat = nVar.f288050m;
        int i3 = nVar.f288195s;
        if (i3 == 1001 || i3 == 1003 || i3 == 1005 || i3 == 1007 || i3 == 1002 || i3 == 1004 || i3 == 1006 || i3 == 1008) {
            transferRequest.mMd5 = nVar.f288047j;
        }
        if (this.f287610f != null) {
            transferRequest.mDownCallBack = this;
        }
        switch (i3) {
            case 1001:
                transferRequest.mFileType = 6;
                transferRequest.mLocalPath = nVar.f288193q + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s + ShortVideoForwardProcessor.SEPERATOR + nVar.f288190n;
                break;
            case 1002:
                transferRequest.mFileType = 7;
                transferRequest.mLocalPath = nVar.f288194r + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s;
                break;
            case 1003:
                transferRequest.mFileType = 9;
                transferRequest.mLocalPath = nVar.f288193q + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s + ShortVideoForwardProcessor.SEPERATOR + nVar.f288190n;
                break;
            case 1004:
                transferRequest.mFileType = 16;
                transferRequest.mLocalPath = nVar.f288194r + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s;
                break;
            case 1005:
                transferRequest.mFileType = 17;
                transferRequest.mLocalPath = nVar.f288193q + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s + ShortVideoForwardProcessor.SEPERATOR + nVar.f288190n;
                break;
            case 1006:
                transferRequest.mFileType = 18;
                transferRequest.mLocalPath = nVar.f288194r + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s;
                break;
            case 1007:
                transferRequest.mFileType = 67;
                transferRequest.mLocalPath = nVar.f288193q + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s + ShortVideoForwardProcessor.SEPERATOR + nVar.f288190n;
                break;
            case 1008:
                transferRequest.mFileType = 68;
                transferRequest.mLocalPath = nVar.f288194r + ShortVideoForwardProcessor.SEPERATOR + nVar.f288039b + ShortVideoForwardProcessor.SEPERATOR + nVar.f288195s;
                break;
        }
        v vVar = this.f287609e;
        if (vVar != null && (messageForShortVideo = vVar.F) != null) {
            transferRequest.mRec = messageForShortVideo;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + nVar.f288195s + "downloadvideo MD5==" + nVar.f288047j);
        }
        ((ITransFileController) this.f287608d.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        com.tencent.mobileqq.pic.f.c(this.f287612i, this.f287611h, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mobileqq.pic.f.c(this.f287612i, this.f287611h, "doDownloadShortVideo.start", "TransferRequest: " + transferRequest.toString());
    }

    @Override // xq2.b
    public void n(v vVar) {
        this.f287609e = vVar;
    }

    @Override // xq2.b
    public void o(String str) {
        this.f287611h = str;
    }

    public void q(n nVar) {
        com.tencent.mobileqq.pic.f.c(this.f287612i, this.f287611h, "downloadShortVideo", "start " + Thread.currentThread().getId());
        if (b(nVar)) {
            m(nVar);
            return;
        }
        c.a aVar = new c.a();
        aVar.f258654a = -1;
        aVar.f258657d = nVar.f288214a;
        h(aVar);
    }

    protected void r(int i3, m.a aVar) {
        y yVar = new y();
        yVar.f288330c = this.f287609e;
        yVar.f288329b = aVar;
        yVar.f288328a = -1;
        u(i3, -1, yVar);
        if (aVar != null) {
            com.tencent.mobileqq.pic.f.e(this.f287612i, this.f287611h, aVar.f258736a, aVar.f258737b);
        } else {
            com.tencent.mobileqq.pic.f.e(this.f287612i, this.f287611h, "handleError", "unkown err,err == null");
        }
    }

    @Override // xq2.b
    public void setLogTag(String str) {
        this.f287612i = str;
    }

    protected void t(int i3, y yVar) {
        if (yVar == null) {
            yVar = new y();
        }
        yVar.f288328a = 0;
        yVar.f288330c = this.f287609e;
        u(i3, 0, yVar);
        com.tencent.mobileqq.pic.f.c(this.f287612i, this.f287611h, "handleSuccess", "what:" + i3);
    }

    protected void u(int i3, int i16, Object obj) {
        Message message = new Message();
        message.what = i3;
        message.arg1 = i16;
        message.obj = obj;
        this.f287613m.sendMessage(message);
    }

    public void w(ab abVar) {
        this.f287610f = abVar;
    }

    public BaseSVReceiveOperator() {
    }

    @Override // xq2.b
    public void c(p pVar) {
    }

    @Override // xq2.b
    public void d(ab abVar) {
    }

    @Override // xq2.b
    public void e(MessageRecord messageRecord) {
    }

    @Override // xq2.b
    public void j(ArrayList<p> arrayList) {
    }

    @Override // xq2.b
    public void p(aa aaVar) {
    }
}
