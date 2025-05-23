package com.tencent.upload.request;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.utils.PDUtil;
import com.tencent.upload.utils.PduHeader;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadResponse {
    static IPatchRedirector $redirector_;
    public int code;
    private int mCmd;
    private int mRequestSequence;
    private byte[] mResult;
    private int mTaskId;

    /* renamed from: msg, reason: collision with root package name */
    public String f383921msg;
    private String sid;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class DecodeResult {
        private static final /* synthetic */ DecodeResult[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DecodeResult DECODE_BUF_EMPTY_ERROR;
        public static final DecodeResult DECODE_JCE_ERROR;
        public static final DecodeResult DECODE_PDU_HEADER_ERROR;
        public static final DecodeResult DECODE_PDU_JCE_ERROR;
        public static final DecodeResult SUCCEED;
        public static final DecodeResult UNKNOWN_CMD_ERROR;
        private int code;

        /* renamed from: msg, reason: collision with root package name */
        private String f383922msg;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11930);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
                return;
            }
            DecodeResult decodeResult = new DecodeResult("SUCCEED", 0, 0, "\u6210\u529f");
            SUCCEED = decodeResult;
            DecodeResult decodeResult2 = new DecodeResult("DECODE_PDU_HEADER_ERROR", 1, 1001, "\u89e3\u6790PDU\u5934\u90e8\u5931\u8d25");
            DECODE_PDU_HEADER_ERROR = decodeResult2;
            DecodeResult decodeResult3 = new DecodeResult("DECODE_PDU_JCE_ERROR", 2, 1002, "\u89e3\u6790PDU\u6570\u636e\u5931\u8d25");
            DECODE_PDU_JCE_ERROR = decodeResult3;
            DecodeResult decodeResult4 = new DecodeResult("DECODE_JCE_ERROR", 3, 1003, "\u89e3\u6790JCE\u6570\u636e\u5931\u8d25");
            DECODE_JCE_ERROR = decodeResult4;
            DecodeResult decodeResult5 = new DecodeResult("UNKNOWN_CMD_ERROR", 4, 1004, "\u65e0\u6548\u7684\u547d\u4ee4\u5b57");
            UNKNOWN_CMD_ERROR = decodeResult5;
            DecodeResult decodeResult6 = new DecodeResult("DECODE_BUF_EMPTY_ERROR", 5, 1005, "\u89e3\u6790\u6570\u636e\u4e3a\u7a7a\u5931\u8d25");
            DECODE_BUF_EMPTY_ERROR = decodeResult6;
            $VALUES = new DecodeResult[]{decodeResult, decodeResult2, decodeResult3, decodeResult4, decodeResult5, decodeResult6};
        }

        DecodeResult(String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            } else {
                this.code = i16;
                this.f383922msg = str2;
            }
        }

        public static DecodeResult valueOf(String str) {
            return (DecodeResult) Enum.valueOf(DecodeResult.class, str);
        }

        public static DecodeResult[] values() {
            return (DecodeResult[]) $VALUES.clone();
        }

        public int getCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.code;
        }

        public String getMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f383922msg;
        }

        @Override // java.lang.Enum
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "[" + this.code + "," + this.f383922msg + "]";
        }
    }

    public UploadResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public DecodeResult decode(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DecodeResult) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
        }
        PduHeader decodeHeader = PDUtil.decodeHeader(bArr);
        if (decodeHeader == null) {
            PDUtil.printHexString("----------recv header:", bArr);
            return DecodeResult.DECODE_PDU_HEADER_ERROR;
        }
        byte[] decodeJce = PDUtil.decodeJce(bArr);
        if (decodeJce == null) {
            return DecodeResult.DECODE_PDU_JCE_ERROR;
        }
        int i3 = decodeHeader.cmd;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return DecodeResult.UNKNOWN_CMD_ERROR;
        }
        this.mCmd = i3;
        this.mRequestSequence = decodeHeader.seq;
        this.mResult = decodeJce;
        return DecodeResult.SUCCEED;
    }

    public int getCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mCmd;
    }

    public byte[] getReponseData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mResult;
    }

    public int getRequestSequence() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mRequestSequence;
    }

    public String getSid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.sid;
    }

    public int getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mTaskId;
    }

    public void setRequestSequence(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mRequestSequence = i3;
        }
    }

    public void setSid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.sid = str;
        }
    }

    public void setTaskId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mTaskId = i3;
        }
    }
}
