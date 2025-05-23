package com.tencent.mobileqq.pic.operator;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public abstract class BasePicOperator extends a {
    static IPatchRedirector $redirector_;

    public BasePicOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(MessageRecord messageRecord, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, messageRecord, Long.valueOf(j3));
        } else {
            ((IOrderMediaMsgService) this.f258754m.getRuntimeService(IOrderMediaMsgService.class, "")).updateMediaMsgByUniseq(messageRecord.frienduin, j3, messageRecord.uniseq);
            ((IOrderMediaMsgService) this.f258754m.getRuntimeService(IOrderMediaMsgService.class, "")).addOrderMsg(messageRecord, ((MessageForPic) messageRecord).path);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a l(p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) pVar);
        }
        a i3 = com.tencent.mobileqq.pic.i.i(pVar.f258783d, pVar.f258784e);
        if (i3 != null) {
            i3.f258749d = this.f258749d;
            i3.f258750e = this.f258750e;
            i3.f258751f = pVar;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(v vVar, MessageForPic messageForPic) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) vVar, (Object) messageForPic);
            return;
        }
        ArrayList<Integer> arrayList = vVar.P;
        int size = arrayList.size();
        if (size == 10) {
            i3 = 9;
            i16 = 4;
        } else {
            if (size == 6) {
                i3 = 5;
            } else {
                i3 = -1;
            }
            i16 = i3;
        }
        if (i3 != -1) {
            messageForPic.mDownloadLength = arrayList.get(i3).intValue();
            messageForPic.mShowLength = arrayList.get(i16).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("peak_pgjpeg", 2, "AioPicOperator.loadPgInfo():showLen " + messageForPic.mShowLength + ", downloadLen " + messageForPic.mDownloadLength);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForPic);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        URLDrawable drawable = ((IPicHelper) QRoute.api(IPicHelper.class)).getDrawable(messageForPic, 65537, null, null);
        drawable.downloadImediatly();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(drawable) { // from class: com.tencent.mobileqq.pic.operator.BasePicOperator.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ URLDrawable f258740d;

            {
                this.f258740d = drawable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasePicOperator.this, (Object) drawable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (this.f258740d.getStatus() == 2) {
                    this.f258740d.restartDownload();
                }
            }
        });
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "preload thumb", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }
}
