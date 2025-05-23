package com.tencent.upload.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public class PduHeader {
    static IPatchRedirector $redirector_;
    public static int length;
    private byte[] buf;
    public int checksum;
    public int cmd;
    public int key;
    public int len;
    public char reserved;
    public short response_flag;
    public short response_info;
    public int seq;
    public final int version;

    /* loaded from: classes27.dex */
    public static class OFFSET {
        static IPatchRedirector $redirector_;
        public static int CHECKSUM;
        public static int CMD;
        public static int KEY;
        public static int LEN;
        public static int RESERVERD;
        public static int RESPONSE_FLAG;
        public static int RESPONSE_INFO;
        public static int SEQ;
        public static int VERSION;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34638);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            VERSION = 0;
            CMD = 1;
            CHECKSUM = 5;
            SEQ = 7;
            KEY = 11;
            RESPONSE_FLAG = 15;
            RESPONSE_INFO = 16;
            RESERVERD = 18;
            LEN = 19;
        }

        public OFFSET() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34640);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            length = 23;
        }
    }

    public PduHeader(int i3, int i16) {
        this(i3, 0, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static int byte2int(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    public static PduHeader decode(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, OFFSET.CMD, bArr2, 0, 4);
        int byte2int = byte2int(bArr2);
        System.arraycopy(bArr, OFFSET.SEQ, bArr2, 0, 4);
        int byte2int2 = byte2int(bArr2);
        System.arraycopy(bArr, OFFSET.LEN, bArr2, 0, 4);
        return new PduHeader(byte2int, byte2int2, byte2int(bArr2));
    }

    public static void int2byte(int i3, byte[] bArr) {
        int2byte(i3, bArr, 0);
    }

    public byte[] getBuf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.buf;
    }

    public PduHeader(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.buf = new byte[23];
        this.version = 0;
        this.checksum = 0;
        this.key = 0;
        this.response_flag = (short) 0;
        this.response_info = (short) 0;
        this.cmd = i3;
        this.len = i17;
        this.seq = i16;
        byte[] bArr = new byte[4];
        int2byte(i3, bArr);
        System.arraycopy(bArr, 0, this.buf, OFFSET.CMD, 4);
        if (i16 != 0) {
            int2byte(i16, bArr);
            System.arraycopy(bArr, 0, this.buf, OFFSET.SEQ, 4);
        }
        int2byte(this.len, bArr);
        System.arraycopy(bArr, 0, this.buf, OFFSET.LEN, 4);
    }

    public static void int2byte(int i3, byte[] bArr, int i16) {
        bArr[i16] = (byte) (i3 >> 24);
        bArr[i16 + 1] = (byte) (i3 >> 16);
        bArr[i16 + 2] = (byte) (i3 >> 8);
        bArr[i16 + 3] = (byte) i3;
    }
}
