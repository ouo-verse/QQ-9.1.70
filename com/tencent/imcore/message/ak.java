package com.tencent.imcore.message;

import com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator;
import com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGeneratorImpl;
import com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider;
import com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator;
import com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGeneratorImpl;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.RichTextAndMsgViaProviderGenerator;
import com.tencent.mobileqq.app.richtext.RichTextAndMsgViaProviderGeneratorImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ak {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.imcore.message.core.codec.e f116549a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.imcore.message.core.codec.g f116550b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.imcore.message.core.codec.b f116551c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.imcore.message.core.e f116552d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.service.message.codec.decoder.b f116553e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.imcore.message.decoder.l f116554f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.imcore.message.adder.a f116555g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.imcore.message.aiolist.a f116556h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.imcore.message.adder.c f116557i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.imcore.message.msgboxappender.f f116558j;

    /* renamed from: k, reason: collision with root package name */
    private GeneralFlagProviderGenerator f116559k;

    /* renamed from: l, reason: collision with root package name */
    private PbSendReqHandlerGenerator f116560l;

    /* renamed from: m, reason: collision with root package name */
    private RichTextAndMsgViaProviderGenerator f116561m;

    /* renamed from: n, reason: collision with root package name */
    private a f116562n;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void initAddMessageHandler(com.tencent.imcore.message.adder.a aVar);

        void initAioMsgHandler(com.tencent.imcore.message.aiolist.a aVar);

        void initC2CAddMessageHandler(com.tencent.imcore.message.adder.c cVar);

        void initC2CMessageDecoderGenerator(com.tencent.mobileqq.service.message.codec.decoder.b bVar);

        void initGeneralFlagProvider(GeneralFlagProviderGenerator generalFlagProviderGenerator);

        void initMessageDecoder(com.tencent.imcore.message.decoder.l lVar);

        void initMsgBoxAppender(com.tencent.imcore.message.msgboxappender.f fVar);

        void initPBMsgElemDecoder(com.tencent.imcore.message.core.codec.b bVar);

        void initPbSendReqHandler(PbSendReqHandlerGenerator pbSendReqHandlerGenerator);

        void initRichTextAndMsgViaProvider(RichTextAndMsgViaProviderGenerator richTextAndMsgViaProviderGenerator);

        void initRoutingType(com.tencent.imcore.message.core.codec.e eVar);

        void initUinTypeRoutingTypeMap(com.tencent.imcore.message.core.codec.g gVar);

        void initUnreadMsgNumCallback(com.tencent.imcore.message.core.e eVar);
    }

    public ak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public com.tencent.imcore.message.adder.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.imcore.message.adder.a) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        com.tencent.imcore.message.adder.a aVar = this.f116555g;
        if (aVar != null) {
            return aVar;
        }
        synchronized (com.tencent.imcore.message.adder.b.class) {
            com.tencent.imcore.message.adder.a aVar2 = this.f116555g;
            if (aVar2 != null) {
                return aVar2;
            }
            com.tencent.imcore.message.adder.b bVar = new com.tencent.imcore.message.adder.b();
            this.f116555g = bVar;
            this.f116562n.initAddMessageHandler(bVar);
            return this.f116555g;
        }
    }

    public List<com.tencent.imcore.message.adder.h> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return a().getInstances();
    }

    public com.tencent.imcore.message.aiolist.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.imcore.message.aiolist.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        com.tencent.imcore.message.aiolist.a aVar = this.f116556h;
        if (aVar != null) {
            return aVar;
        }
        synchronized (com.tencent.imcore.message.aiolist.b.class) {
            com.tencent.imcore.message.aiolist.a aVar2 = this.f116556h;
            if (aVar2 != null) {
                return aVar2;
            }
            com.tencent.imcore.message.aiolist.b bVar = new com.tencent.imcore.message.aiolist.b();
            this.f116556h = bVar;
            this.f116562n.initAioMsgHandler(bVar);
            return this.f116556h;
        }
    }

    public List<com.tencent.imcore.message.aiolist.f> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return c().getInstances();
    }

    public com.tencent.imcore.message.adder.c e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.imcore.message.adder.c) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        com.tencent.imcore.message.adder.c cVar = this.f116557i;
        if (cVar != null) {
            return cVar;
        }
        synchronized (com.tencent.imcore.message.adder.d.class) {
            com.tencent.imcore.message.adder.c cVar2 = this.f116557i;
            if (cVar2 != null) {
                return cVar2;
            }
            com.tencent.imcore.message.adder.d dVar = new com.tencent.imcore.message.adder.d();
            this.f116557i = dVar;
            this.f116562n.initC2CAddMessageHandler(dVar);
            return this.f116557i;
        }
    }

    public List<com.tencent.imcore.message.adder.i> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return e().getInstances();
    }

    public com.tencent.mobileqq.service.message.codec.decoder.d g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.service.message.codec.decoder.d) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return h().get(Integer.valueOf(i3));
    }

    public com.tencent.mobileqq.service.message.codec.decoder.b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.service.message.codec.decoder.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.mobileqq.service.message.codec.decoder.b bVar = this.f116553e;
        if (bVar != null) {
            return bVar;
        }
        synchronized (com.tencent.mobileqq.service.message.codec.decoder.b.class) {
            com.tencent.mobileqq.service.message.codec.decoder.b bVar2 = this.f116553e;
            if (bVar2 != null) {
                return bVar2;
            }
            com.tencent.mobileqq.service.message.codec.decoder.c cVar = new com.tencent.mobileqq.service.message.codec.decoder.c();
            this.f116553e = cVar;
            this.f116562n.initC2CMessageDecoderGenerator(cVar);
            return this.f116553e;
        }
    }

    public GeneralFlagProviderGenerator i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (GeneralFlagProviderGenerator) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        GeneralFlagProviderGenerator generalFlagProviderGenerator = this.f116559k;
        if (generalFlagProviderGenerator != null) {
            return generalFlagProviderGenerator;
        }
        synchronized (GeneralFlagProviderGeneratorImpl.class) {
            GeneralFlagProviderGenerator generalFlagProviderGenerator2 = this.f116559k;
            if (generalFlagProviderGenerator2 != null) {
                return generalFlagProviderGenerator2;
            }
            GeneralFlagProviderGeneratorImpl generalFlagProviderGeneratorImpl = new GeneralFlagProviderGeneratorImpl();
            this.f116559k = generalFlagProviderGeneratorImpl;
            this.f116562n.initGeneralFlagProvider(generalFlagProviderGeneratorImpl);
            return this.f116559k;
        }
    }

    public List<IGeneralFlagProvider> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return i().getInstances();
    }

    public com.tencent.imcore.message.decoder.l k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.imcore.message.decoder.l) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.imcore.message.decoder.l lVar = this.f116554f;
        if (lVar != null) {
            return lVar;
        }
        synchronized (com.tencent.imcore.message.decoder.m.class) {
            com.tencent.imcore.message.decoder.l lVar2 = this.f116554f;
            if (lVar2 != null) {
                return lVar2;
            }
            com.tencent.imcore.message.decoder.m mVar = new com.tencent.imcore.message.decoder.m();
            this.f116554f = mVar;
            this.f116562n.initMessageDecoder(mVar);
            return this.f116554f;
        }
    }

    public List<com.tencent.imcore.message.decoder.j> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return k().getInstances();
    }

    public com.tencent.imcore.message.msgboxappender.f m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.imcore.message.msgboxappender.f) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        com.tencent.imcore.message.msgboxappender.f fVar = this.f116558j;
        if (fVar != null) {
            return fVar;
        }
        synchronized (com.tencent.imcore.message.msgboxappender.g.class) {
            com.tencent.imcore.message.msgboxappender.f fVar2 = this.f116558j;
            if (fVar2 != null) {
                return fVar2;
            }
            com.tencent.imcore.message.msgboxappender.g gVar = new com.tencent.imcore.message.msgboxappender.g();
            this.f116558j = gVar;
            this.f116562n.initMsgBoxAppender(gVar);
            return this.f116558j;
        }
    }

    public List<com.tencent.imcore.message.msgboxappender.b> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return m().getInstances();
    }

    public List<com.tencent.imcore.message.core.codec.a> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.imcore.message.core.codec.b bVar = this.f116551c;
        if (bVar != null) {
            return bVar.getInstances();
        }
        synchronized (com.tencent.imcore.message.core.codec.c.class) {
            com.tencent.imcore.message.core.codec.b bVar2 = this.f116551c;
            if (bVar2 != null) {
                return bVar2.getInstances();
            }
            com.tencent.imcore.message.core.codec.c cVar = new com.tencent.imcore.message.core.codec.c();
            this.f116551c = cVar;
            this.f116562n.initPBMsgElemDecoder(cVar);
            return this.f116551c.getInstances();
        }
    }

    public PbSendReqHandlerGenerator p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (PbSendReqHandlerGenerator) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        PbSendReqHandlerGenerator pbSendReqHandlerGenerator = this.f116560l;
        if (pbSendReqHandlerGenerator != null) {
            return pbSendReqHandlerGenerator;
        }
        synchronized (PbSendReqHandlerGeneratorImpl.class) {
            PbSendReqHandlerGenerator pbSendReqHandlerGenerator2 = this.f116560l;
            if (pbSendReqHandlerGenerator2 != null) {
                return pbSendReqHandlerGenerator2;
            }
            PbSendReqHandlerGeneratorImpl pbSendReqHandlerGeneratorImpl = new PbSendReqHandlerGeneratorImpl();
            this.f116560l = pbSendReqHandlerGeneratorImpl;
            this.f116562n.initPbSendReqHandler(pbSendReqHandlerGeneratorImpl);
            return this.f116560l;
        }
    }

    public List<IPbSendReqHandler> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return p().getInstances();
    }

    public RichTextAndMsgViaProviderGenerator r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (RichTextAndMsgViaProviderGenerator) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        RichTextAndMsgViaProviderGenerator richTextAndMsgViaProviderGenerator = this.f116561m;
        if (richTextAndMsgViaProviderGenerator != null) {
            return richTextAndMsgViaProviderGenerator;
        }
        synchronized (RichTextAndMsgViaProviderGeneratorImpl.class) {
            RichTextAndMsgViaProviderGenerator richTextAndMsgViaProviderGenerator2 = this.f116561m;
            if (richTextAndMsgViaProviderGenerator2 != null) {
                return richTextAndMsgViaProviderGenerator2;
            }
            RichTextAndMsgViaProviderGeneratorImpl richTextAndMsgViaProviderGeneratorImpl = new RichTextAndMsgViaProviderGeneratorImpl();
            this.f116561m = richTextAndMsgViaProviderGeneratorImpl;
            this.f116562n.initRichTextAndMsgViaProvider(richTextAndMsgViaProviderGeneratorImpl);
            return this.f116561m;
        }
    }

    public List<IRichTextAndMsgViaProvider> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (List) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return r().getInstances();
    }

    public com.tencent.imcore.message.core.codec.e t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.imcore.message.core.codec.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.imcore.message.core.codec.e eVar = this.f116549a;
        if (eVar != null) {
            return eVar;
        }
        synchronized (com.tencent.imcore.message.core.codec.f.class) {
            com.tencent.imcore.message.core.codec.e eVar2 = this.f116549a;
            if (eVar2 != null) {
                return eVar2;
            }
            com.tencent.imcore.message.core.codec.f fVar = new com.tencent.imcore.message.core.codec.f();
            this.f116549a = fVar;
            this.f116562n.initRoutingType(fVar);
            return this.f116549a;
        }
    }

    public com.tencent.imcore.message.core.codec.g u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.imcore.message.core.codec.g) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.imcore.message.core.codec.g gVar = this.f116550b;
        if (gVar != null) {
            return gVar;
        }
        synchronized (com.tencent.imcore.message.core.codec.h.class) {
            com.tencent.imcore.message.core.codec.g gVar2 = this.f116550b;
            if (gVar2 != null) {
                return gVar2;
            }
            com.tencent.imcore.message.core.codec.h hVar = new com.tencent.imcore.message.core.codec.h();
            this.f116550b = hVar;
            this.f116562n.initUinTypeRoutingTypeMap(hVar);
            return this.f116550b;
        }
    }

    public List<com.tencent.imcore.message.core.d> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.imcore.message.core.e eVar = this.f116552d;
        if (eVar != null) {
            return eVar.getInstances();
        }
        synchronized (com.tencent.imcore.message.core.f.class) {
            com.tencent.imcore.message.core.e eVar2 = this.f116552d;
            if (eVar2 != null) {
                return eVar2.getInstances();
            }
            com.tencent.imcore.message.core.f fVar = new com.tencent.imcore.message.core.f();
            this.f116552d = fVar;
            this.f116562n.initUnreadMsgNumCallback(fVar);
            return this.f116552d.getInstances();
        }
    }

    public void w(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) aVar);
        } else {
            this.f116562n = aVar;
        }
    }
}
