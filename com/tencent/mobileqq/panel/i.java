package com.tencent.mobileqq.panel;

import QC.AioBubbleRecom$PayInfo;
import QC.AioBubbleRecom$SetRecommendItemRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static AtomicInteger f257179d;

    /* renamed from: a, reason: collision with root package name */
    public int f257180a;

    /* renamed from: b, reason: collision with root package name */
    public FontBubble f257181b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f257182c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements com.tencent.mobileqq.panel.bubble.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f257183a;

        a(QQAppInterface qQAppInterface) {
            this.f257183a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.panel.bubble.b
        public void a(AioBubbleRecom$SetRecommendItemRsp aioBubbleRecom$SetRecommendItemRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                i.this.b(aioBubbleRecom$SetRecommendItemRsp, this.f257183a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioBubbleRecom$SetRecommendItemRsp);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f257179d = new AtomicInteger();
        }
    }

    public i(FontBubble fontBubble, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fontBubble, Boolean.valueOf(z16));
            return;
        }
        this.f257180a = f257179d.getAndIncrement();
        this.f257181b = fontBubble;
        this.f257182c = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AioBubbleRecom$SetRecommendItemRsp aioBubbleRecom$SetRecommendItemRsp, QQAppInterface qQAppInterface) {
        if (qQAppInterface != null && this.f257181b != null) {
            if (aioBubbleRecom$SetRecommendItemRsp == null) {
                QLog.e("AIOFontBubble_SetFontBubble", 1, "handleSetRecomResult result = null , server error");
                FontBubbleManager.j(qQAppInterface).u(MobileQQ.sMobileQQ);
                return;
            }
            QLog.i("AIOFontBubble_SetFontBubble", 1, "handleSetRecomResult result = " + aioBubbleRecom$SetRecommendItemRsp.ret.get());
            if (aioBubbleRecom$SetRecommendItemRsp.ret.get() != 0) {
                AioBubbleRecom$PayInfo aioBubbleRecom$PayInfo = aioBubbleRecom$SetRecommendItemRsp.payInfo.get();
                if (aioBubbleRecom$PayInfo != null) {
                    this.f257181b.btn = aioBubbleRecom$PayInfo.buttonMsg.get();
                    this.f257181b.payUrl = aioBubbleRecom$PayInfo.payUrl.get();
                    this.f257181b.f257110msg = aioBubbleRecom$PayInfo.textMsg.get();
                    this.f257181b.title = aioBubbleRecom$PayInfo.titleMsg.get();
                }
                QLog.i("AIOFontBubble_SetFontBubble", 1, "handleSetRecomResult fontBubble = " + this.f257181b.toString());
                FontBubbleManager.j(qQAppInterface).z();
                return;
            }
            FontBubbleManager.j(qQAppInterface).s(this);
            return;
        }
        QLog.e("AIOFontBubble_SetFontBubble", 1, "handleSetRecomResult app = null");
    }

    public void c(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        } else if (this.f257181b != null && qQAppInterface != null) {
            com.tencent.mobileqq.panel.bubble.c.e().i(this.f257181b, this.f257182c, new a(qQAppInterface));
        }
    }
}
