package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.v;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f251674a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.mobileqq.pic.p f251675b;

    /* renamed from: c, reason: collision with root package name */
    public v f251676c;

    /* renamed from: d, reason: collision with root package name */
    public CopyOnWriteArrayList<g> f251677d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251677d = new CopyOnWriteArrayList<>();
        }
    }

    public static c a(MessageForPic messageForPic) {
        int i3;
        if (messageForPic.fileSizeFlag == 1) {
            i3 = 7;
        } else {
            i3 = 6;
        }
        c cVar = new c();
        com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(i3, 1);
        createPicReq.d(messageForPic, messageForPic.getPicDownloadInfo());
        cVar.f251675b = createPicReq;
        cVar.f251674a = 1;
        return cVar;
    }

    public static c b(QQAppInterface qQAppInterface, MessageForShortVideo messageForShortVideo) {
        c cVar = new c();
        cVar.f251676c = com.tencent.mobileqq.shortvideo.h.c(qQAppInterface, messageForShortVideo, 1);
        cVar.f251674a = 3;
        return cVar;
    }
}
