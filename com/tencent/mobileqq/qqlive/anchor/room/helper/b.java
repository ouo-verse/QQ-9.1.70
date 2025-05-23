package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static byte[] a(String str, long j3, String str2) {
        byte[] bytes;
        fr4.c cVar = new fr4.c();
        cVar.f400378a = str;
        cVar.f400379b = j3;
        if (str2 == null) {
            bytes = null;
        } else {
            bytes = str2.getBytes();
        }
        cVar.f400380c = bytes;
        cVar.f400381d = 2;
        cVar.f400382e = AppSetting.f99554n;
        return MessageNano.toByteArray(cVar);
    }
}
