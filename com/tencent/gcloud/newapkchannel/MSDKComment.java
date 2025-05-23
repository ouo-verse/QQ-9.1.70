package com.tencent.gcloud.newapkchannel;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gcloud.newapkchannel.v2.ZipShort;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MSDKComment {
    static IPatchRedirector $redirector_ = null;
    private static final int CHANNEL_HEAD = 38650;
    private static final ZipShort PROTO_HEAD;
    private byte[] otherData;

    /* renamed from: p, reason: collision with root package name */
    private final Properties f108393p;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            PROTO_HEAD = new ZipShort(CHANNEL_HEAD);
        }
    }

    public MSDKComment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108393p = new Properties();
        }
    }

    public void decode(byte[] bArr) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            System.out.println("WARNING:[YYBComment]decode|data=null|exit");
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ZipShort zipShort = PROTO_HEAD;
        int length = zipShort.getBytes().length;
        byte[] bArr2 = new byte[length];
        wrap.get(bArr2);
        if (zipShort.equals(new ZipShort(bArr2))) {
            if (bArr.length - length <= 2) {
                System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|1|exit");
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int value = new ZipShort(bArr3).getValue();
            if ((bArr.length - length) - 2 < value) {
                System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|2|exit");
                return;
            }
            byte[] bArr4 = new byte[value];
            wrap.get(bArr4);
            this.f108393p.load(new InputStreamReader(new ByteArrayInputStream(bArr4), StandardCharsets.UTF_8));
            int length2 = ((bArr.length - length) - value) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.otherData = bArr5;
                wrap.get(bArr5);
                return;
            }
            return;
        }
        System.out.println("ERROR:[YYBComment]decode|unknow protocol|exit");
        throw new ProtocolException("[YYBComment] unknow protocl [" + Arrays.toString(bArr) + "]");
    }

    public byte[] encode() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? encode(false) : (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public Properties getP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Properties) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f108393p;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "YYBComment [p=" + this.f108393p + ", otherData=" + Arrays.toString(this.otherData) + "]";
    }

    public byte[] encode(boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(PROTO_HEAD.getBytes());
        StringBuilder sb5 = new StringBuilder();
        for (Object obj : this.f108393p.keySet()) {
            sb5.append(obj);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f108393p.getProperty((String) obj));
            sb5.append("\r\n");
        }
        byte[] bytes = sb5.toString().getBytes(StandardCharsets.UTF_8);
        byteArrayOutputStream.write(new ZipShort(bytes.length).getBytes());
        byteArrayOutputStream.write(bytes);
        byte[] bArr = this.otherData;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!z16) {
            return byteArray;
        }
        int length = (byteArray.length + 12) % 4096;
        int length2 = (length > 0 ? 4096 - length : 0) + byteArray.length;
        byte[] bArr2 = new byte[length2];
        System.arraycopy(byteArray, 0, bArr2, 0, byteArray.length);
        for (int length3 = byteArray.length; length3 < length2; length3++) {
            bArr2[length3] = 0;
        }
        return bArr2;
    }
}
