package com.tencent.common.app;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes5.dex */
public abstract class BaseProtocolCoder {
    static IPatchRedirector $redirector_;
    public HashMap<String, Integer> requestHandles;

    public BaseProtocolCoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.requestHandles = new HashMap<>();
        }
    }

    public static long createUserId(long j3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        try {
            new DataOutputStream(byteArrayOutputStream).writeLong(j3);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArray[0] = 0;
            byteArray[1] = 0;
            return new DataInputStream(new ByteArrayInputStream(byteArray)).readLong();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public abstract String[] cmdHeaderPrefix();

    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        return null;
    }

    public final <T> T decodePacket(byte[] bArr, String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, this, bArr, str, t16);
        }
        UniPacket uniPacket = new UniPacket(true);
        try {
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(bArr);
            return (T) uniPacket.getByClass(str, t16);
        } catch (Exception unused) {
            return null;
        }
    }

    public void decodeRespMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public boolean enableBinaryProtocol() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    public abstract boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket);

    public byte[] encodeReqMsg(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg);
        }
        return null;
    }
}
