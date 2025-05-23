package com.tencent.gamecenter.wadl.util;

import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    private static final n f107664c = new n(38650);

    /* renamed from: a, reason: collision with root package name */
    private final Properties f107665a = new Properties();

    /* renamed from: b, reason: collision with root package name */
    private byte[] f107666b;

    public void a(byte[] bArr) throws IOException, ProtocolException {
        if (bArr == null) {
            QLog.w("MSDKComment", 2, "WARNING:[YYBComment]decode|data=null|exit");
            return;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        n nVar = f107664c;
        int length = nVar.a().length;
        byte[] bArr2 = new byte[length];
        wrap.get(bArr2);
        if (nVar.equals(new n(bArr2))) {
            if (bArr.length - length <= 2) {
                QLog.e("MSDKComment", 2, "ERROR:[YYBComment]decode|data.length - headLength <= 2|1|exit");
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int b16 = new n(bArr3).b();
            if ((bArr.length - length) - 2 < b16) {
                QLog.e("MSDKComment", 2, "ERROR:[YYBComment]decode|data.length - headLength <= 2|2|exit");
                return;
            }
            byte[] bArr4 = new byte[b16];
            wrap.get(bArr4);
            this.f107665a.load(new InputStreamReader(new ByteArrayInputStream(bArr4), StandardCharsets.UTF_8));
            int length2 = ((bArr.length - length) - b16) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.f107666b = bArr5;
                wrap.get(bArr5);
                return;
            }
            return;
        }
        QLog.e("MSDKComment", 2, "ERROR:[YYBComment]decode|unknow protocol|exit");
        throw new ProtocolException("[YYBComment] unknow protocl [" + Arrays.toString(bArr) + "]");
    }

    public Properties b() {
        return this.f107665a;
    }

    public String toString() {
        return "YYBComment [p=" + this.f107665a + ", otherData=" + Arrays.toString(this.f107666b) + "]";
    }
}
