package com.tencent.mobileqq.vip;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.api.AbsProtocol;

/* compiled from: P */
/* loaded from: classes20.dex */
public class n extends AbsProtocol {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static long f313038d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f313038d = 0L;
        }
    }

    public static void request(String str, MessageMicro messageMicro, Class cls, BusinessObserver businessObserver) {
        ((com.tencent.mobileqq.apollo.handler.b) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).request(str, messageMicro, cls, businessObserver);
    }

    public static void request(String str, String str2, BusinessObserver businessObserver) {
        ((com.tencent.mobileqq.apollo.handler.b) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).request(str, str2, businessObserver);
    }

    public static void request(String str, byte[] bArr, BusinessObserver businessObserver) {
        ((com.tencent.mobileqq.apollo.handler.b) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).request(str, bArr, businessObserver);
    }
}
