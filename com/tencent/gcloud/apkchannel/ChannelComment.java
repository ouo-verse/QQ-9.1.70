package com.tencent.gcloud.apkchannel;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gcloud.apkchannel.v1.ZipShort;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ChannelComment {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ChannelComment";
    private static final ZipShort protoHead;
    public byte[] otherData;

    /* renamed from: p, reason: collision with root package name */
    public Properties f108391p;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            protoHead = new ZipShort(38650);
        }
    }

    public ChannelComment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108391p = new Properties();
        }
    }

    public void decode(byte[] bArr) throws IOException, ProtocolException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            Log.e(TAG, "apollo0511 WARNING:[ChannelComment]decode data=null and return");
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ZipShort zipShort = protoHead;
        int length = zipShort.getBytes().length;
        byte[] bArr2 = new byte[length];
        wrap.get(bArr2);
        if (zipShort.equals(new ZipShort(bArr2))) {
            if (bArr.length - length <= 2) {
                Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|1|exit");
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int value = new ZipShort(bArr3).getValue();
            if ((bArr.length - length) - 2 < value) {
                Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|2|exit");
                return;
            }
            byte[] bArr4 = new byte[value];
            wrap.get(bArr4);
            this.f108391p.load(new InputStreamReader(new ByteArrayInputStream(bArr4), "UTF-8"));
            int length2 = ((bArr.length - length) - value) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.otherData = bArr5;
                wrap.get(bArr5);
                return;
            }
            return;
        }
        Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|unknow protocol|exit");
        throw new ProtocolException("[ChannelComment] unknow protocl [" + Arrays.toString(bArr) + "]");
    }

    public byte[] encode() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(protoHead.getBytes());
        String str = "";
        for (Object obj : this.f108391p.keySet()) {
            str = str + obj + ContainerUtils.KEY_VALUE_DELIMITER + this.f108391p.getProperty((String) obj) + "\r\n";
        }
        byte[] bytes = str.getBytes("UTF-8");
        byteArrayOutputStream.write(new ZipShort(bytes.length).getBytes());
        byteArrayOutputStream.write(bytes);
        byte[] bArr = this.otherData;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getValue(byte[] bArr) throws IOException, ProtocolException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        }
        if (bArr == null) {
            Log.e(TAG, "apollo0511 WARNING:[Comment]decode|data=null|exit");
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ZipShort zipShort = protoHead;
        int length = zipShort.getBytes().length;
        byte[] bArr2 = new byte[length];
        wrap.get(bArr2);
        if (zipShort.equals(new ZipShort(bArr2))) {
            if (bArr.length - length <= 2) {
                Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|1|exit");
                return null;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int value = new ZipShort(bArr3).getValue();
            if ((bArr.length - length) - 2 < value) {
                Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|2|exit");
                return null;
            }
            byte[] bArr4 = new byte[value];
            wrap.get(bArr4);
            String str = new String(bArr4);
            int length2 = ((bArr.length - length) - value) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.otherData = bArr5;
                wrap.get(bArr5);
            }
            return str;
        }
        Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|unknow protocol|exit");
        throw new ProtocolException("[ChannelComment] unknow protocl [" + Arrays.toString(bArr) + "]");
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "ChannelComment [p=" + this.f108391p + ", otherData=" + Arrays.toString(this.otherData) + "]";
    }

    public byte[] encode(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(protoHead.getBytes());
        byte[] bytes = str.getBytes("UTF-8");
        byteArrayOutputStream.write(new ZipShort(bytes.length).getBytes());
        byteArrayOutputStream.write(bytes);
        byte[] bArr = this.otherData;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
