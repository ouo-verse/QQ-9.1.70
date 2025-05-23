package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b implements xq2.b, com.tencent.mobileqq.pic.ad {
    protected Handler C;

    /* renamed from: d, reason: collision with root package name */
    public BaseQQAppInterface f287783d;

    /* renamed from: e, reason: collision with root package name */
    public v f287784e;

    /* renamed from: f, reason: collision with root package name */
    protected ab f287785f;

    /* renamed from: h, reason: collision with root package name */
    public String f287786h;

    /* renamed from: i, reason: collision with root package name */
    public String f287787i;

    /* renamed from: m, reason: collision with root package name */
    public MessageRecord f287788m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b.this.u(message);
        }
    }

    public b(BaseQQAppInterface baseQQAppInterface) {
        this.f287783d = baseQQAppInterface;
        if (this.C == null) {
            this.C = new a(Looper.getMainLooper());
        }
    }

    public void a(MessageRecord messageRecord, long j3) {
        if (messageRecord == null) {
            return;
        }
        ((IOrderMediaMsgService) this.f287783d.getRuntimeService(IOrderMediaMsgService.class)).updateMediaMsgByUniseq(messageRecord.frienduin, j3, messageRecord.uniseq);
        ((IOrderMediaMsgService) this.f287783d.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(messageRecord, ((MessageForShortVideo) messageRecord).videoFileName);
    }

    @Override // xq2.b
    public void c(p pVar) {
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "forwardShortVideo", "start " + Thread.currentThread().getId());
        if (h(pVar)) {
            ThreadManagerV2.excute(new ForwardShortVideoTask(this, pVar), 128, null, true);
        } else if (pVar != null) {
            v(3, pVar.f288214a);
        }
    }

    @Override // xq2.b
    public void d(ab abVar) {
        this.f287785f = abVar;
    }

    @Override // xq2.b
    public void e(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return;
        }
        ((IOrderMediaMsgService) this.f287783d.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(messageRecord, ((MessageForShortVideo) messageRecord).videoFileName);
    }

    boolean h(p pVar) {
        if (pVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "checkShortVideoForwardInfo", "info:" + pVar);
            return pVar.b();
        }
        com.tencent.mobileqq.pic.f.e(this.f287787i, this.f287786h, "checkShortVideoForwardInfo", "info == null");
        return false;
    }

    @Override // xq2.b
    public void j(ArrayList<p> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseShortVideoOprerator", 2, "multiForwardShortVideo start:" + Thread.currentThread().getId());
        }
        if (arrayList != null && arrayList.size() > 0) {
            ThreadManagerV2.excute(new MultiForwardShortVideoTask(this, arrayList), 128, null, true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
        }
        x(3, -1, null);
    }

    @Override // xq2.b
    public void p(aa aaVar) {
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "sendShortVideo", "start " + Thread.currentThread().getId());
        if (t(aaVar)) {
            ThreadManagerV2.excute(new SendShortVideoTask(this, aaVar), 128, null, true);
            return;
        }
        if (aaVar != null) {
            QLog.e("BaseShortVideoOprerator", 1, "sendShortVideo info:" + aaVar);
            v(2, aaVar.f288214a);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        if (aVar == null) {
            v(2, null);
            return;
        }
        if (aVar.f258597a == 0) {
            r(aVar);
            y yVar = new y();
            yVar.f288328a = 0;
            yVar.f288331d = aVar;
            w(2, yVar);
        } else {
            m.a aVar2 = new m.a();
            aVar2.f258737b = aVar.f258599c;
            v(2, aVar2);
        }
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMsgUploadTaskEnd(this.f287788m);
    }

    boolean t(aa aaVar) {
        if (aaVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "checkShortVideoUploadInfo", "info:" + aaVar);
            return aaVar.b();
        }
        com.tencent.mobileqq.pic.f.e(this.f287787i, this.f287786h, "checkShortVideoUploadInfo", "info == null");
        return false;
    }

    public void u(Message message) {
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "dispatchMessage", "what:" + message.what + ",result:" + message.arg1 + ",obj:" + message.obj);
        ab abVar = this.f287785f;
        if (abVar == null) {
            return;
        }
        int i3 = message.arg1;
        int i16 = message.what;
        if (i16 != 2) {
            if (i16 == 3) {
                Object obj = message.obj;
                ArrayList<y> arrayList = null;
                if (obj != null) {
                    try {
                        arrayList = (ArrayList) obj;
                    } catch (ClassCastException unused) {
                    }
                }
                this.f287785f.b(i3, arrayList);
                return;
            }
            return;
        }
        abVar.c(i3, (y) message.obj);
    }

    protected void v(int i3, m.a aVar) {
        y yVar = new y();
        yVar.f288330c = this.f287784e;
        yVar.f288329b = aVar;
        yVar.f288328a = -1;
        x(i3, -1, yVar);
        if (aVar != null) {
            com.tencent.mobileqq.pic.f.e(this.f287787i, this.f287786h, aVar.f258736a, aVar.f258737b);
        } else {
            com.tencent.mobileqq.pic.f.e(this.f287787i, this.f287786h, "handleError", "unkown err,err == null");
        }
    }

    protected void w(int i3, y yVar) {
        if (yVar == null) {
            yVar = new y();
        }
        yVar.f288328a = 0;
        yVar.f288330c = this.f287784e;
        x(i3, 0, yVar);
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "handleSuccess", "what:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(int i3, int i16, Object obj) {
        Message message = new Message();
        message.what = i3;
        message.arg1 = i16;
        message.obj = obj;
        this.C.sendMessage(message);
    }

    public b() {
    }
}
