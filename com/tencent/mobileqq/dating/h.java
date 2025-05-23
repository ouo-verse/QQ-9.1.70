package com.tencent.mobileqq.dating;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.oidb.cmd0x876.oidb_0x876$ReqBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static abstract class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;
    }

    public static void b(AppInterface appInterface, int i3, a aVar) {
        ProtoUtils.a(appInterface, aVar, new MessageMicro<oidb_0x876$ReqBody>() { // from class: tencent.im.oidb.cmd0x876.oidb_0x876$ReqBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x876$ReqBody.class);
        }.toByteArray(), "OidbSvc.0x876_" + i3, 2166, i3);
    }

    public static void a(AppInterface appInterface) {
    }
}
