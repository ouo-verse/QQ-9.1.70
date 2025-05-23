package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.api.ICardHandler;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class CardHandlerImpl implements ICardHandler {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends CardObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ICardHandler.a f280587d;

        a(ICardHandler.a aVar) {
            this.f280587d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardHandlerImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetAutoReplyList(boolean z16, List<AutoReplyText> list, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, Integer.valueOf(i3));
            } else {
                this.f280587d.a(z16, list, i3);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetAutoReplyList(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.f280587d.b(z16);
            }
        }
    }

    public CardHandlerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.ICardHandler
    public void getAutoReplyList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((CardHandler) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).getAutoReplyList();
        }
    }

    @Override // com.tencent.mobileqq.relation.api.ICardHandler
    public BusinessObserver newCardHandlerForAutoReply(ICardHandler.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
        return new a(aVar);
    }

    @Override // com.tencent.mobileqq.relation.api.ICardHandler
    public void setAutoReplyList(ArrayList<AutoReplyText> arrayList, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        } else {
            ((CardHandler) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).setAutoReplyList(arrayList, i3, i16, z16);
        }
    }
}
