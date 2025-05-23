package oicq.wlogin_sdk.request;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public u f422889a;

    /* renamed from: b, reason: collision with root package name */
    public int f422890b;

    /* renamed from: c, reason: collision with root package name */
    public int f422891c;

    /* renamed from: d, reason: collision with root package name */
    public ErrMsg f422892d;

    public g(u uVar, int i3, int i16, ErrMsg errMsg) {
        this.f422889a = uVar;
        this.f422890b = i3;
        this.f422891c = i16;
        this.f422892d = errMsg;
    }

    public int a(byte[] bArr) {
        byte[] bArr2;
        byte[] decrypt;
        byte[] doFinal;
        util.LOGI("notice len " + bArr.length, this.f422889a.f422957d + "");
        byte[] string_to_buf = util.string_to_buf("30820122300d06092a864886f70d01010105000382010f003082010a0282010100bb65a9189e42aabf8c4c97b8bb7e35f6239df71152c0108d5c9b98d86ed7b14fa4b6e2ca5749eda03b5746e97b10c1772eab364fcedbfc4b3bb4d839ed97f657daa54622b54dfb29fe66f37f3e26e779675fec2337d0f8cbdf550b04f936be0927bbbecc851b6d966a3ba51c9747a8c588979ec248d5c8a66d1dd4fed0bcd3eb78725fd04b25cdceeac17d0068f07b3a2a360105cc1f4a0fd361d8d3ff0a9e5598b4196304635482be7ceda63a80479aa396a341fb206c81d7c476f860ac6d90734d523d1015eb73f390104c2bb85d0c05db4d11feae941ff5c92be9a1c123283dc2e0dc1368420d6f71cc50e343534e7c0ff16345680859e14c35f1f021cdfb0203010001");
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte[] bArr3 = null;
        try {
            byte[] bArr4 = new byte[wrap.getShort()];
            wrap.get(bArr4);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(string_to_buf)));
            doFinal = cipher.doFinal(bArr4);
        } catch (Exception e16) {
            e = e16;
            bArr2 = null;
        }
        if (doFinal != null && doFinal.length != 0) {
            ByteBuffer wrap2 = ByteBuffer.wrap(doFinal);
            byte[] bArr5 = new byte[wrap2.getShort()];
            try {
                wrap2.get(bArr5);
                bArr3 = new byte[wrap2.getShort()];
                wrap2.get(bArr3);
                wrap2.getInt();
            } catch (Exception e17) {
                e = e17;
                bArr2 = bArr3;
                bArr3 = bArr5;
                util.printException(e);
                byte[] bArr6 = bArr2;
                bArr5 = bArr3;
                bArr3 = bArr6;
                if (bArr5 != null) {
                    int limit = wrap.limit() - wrap.position();
                    byte[] bArr7 = new byte[limit];
                    wrap.get(bArr7);
                    decrypt = cryptor.decrypt(bArr7, 0, limit, bArr5);
                    if (decrypt != null) {
                    }
                }
                return -1000;
            }
            if (bArr5 != null && bArr3 != null) {
                int limit2 = wrap.limit() - wrap.position();
                byte[] bArr72 = new byte[limit2];
                wrap.get(bArr72);
                decrypt = cryptor.decrypt(bArr72, 0, limit2, bArr5);
                if (decrypt != null || decrypt.length == 0 || !Arrays.equals(bArr3, MD5.toMD5Byte(decrypt))) {
                    return -1000;
                }
                ByteBuffer wrap3 = ByteBuffer.wrap(decrypt);
                wrap3.getShort();
                short s16 = wrap3.getShort();
                if (s16 == 0) {
                    return -1000;
                }
                for (int i3 = 0; i3 < s16; i3++) {
                    short s17 = wrap3.getShort();
                    byte[] bArr8 = new byte[wrap3.getShort()];
                    wrap3.get(bArr8);
                    if (s17 == 1281) {
                        ByteBuffer wrap4 = ByteBuffer.wrap(bArr8);
                        int i16 = wrap4.getInt();
                        util.LOGI("what " + i16, "");
                        if (i16 != 0) {
                            return -1000;
                        }
                        int i17 = wrap4.getShort();
                        byte[] bArr9 = new byte[i17];
                        util.LOGI("msg len " + i17, "");
                        if (i17 == 0) {
                            return -1000;
                        }
                        wrap4.get(bArr9);
                        this.f422892d.setMessage(new String(bArr9));
                        this.f422892d.setType(257);
                    } else if (s17 == 1282) {
                        this.f422892d.setTitle(new String(bArr8));
                    }
                }
                return this.f422892d.getType();
            }
            return -1000;
        }
        return -1000;
    }

    public int b(int i3) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                byte[] a16 = a(i3);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("http://" + (new String[]{"ts7", "ts8", "ts9"}[((int) Math.round(Math.random() * 1000.0d)) % 3] + ".qq.com:8080") + "/msg").openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("Content-Length", a16.length + "");
                    httpURLConnection2.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection2.setConnectTimeout(tlv_t508.timeout);
                    httpURLConnection2.setReadTimeout(tlv_t508.timeout);
                    boolean z16 = true;
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    if (!h.a(httpURLConnection2, this.f422889a.f422963j)) {
                        util.LOGI("notice request connect failed", "" + this.f422889a.f422957d);
                        httpURLConnection2.disconnect();
                        return -1000;
                    }
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(a16);
                    outputStream.close();
                    int responseCode = httpURLConnection2.getResponseCode();
                    util.LOGI("notice request response code=" + responseCode, "" + this.f422889a.f422957d);
                    if (200 != responseCode) {
                        httpURLConnection2.disconnect();
                        return -1000;
                    }
                    util.LOGI("recv notice ...", "" + this.f422889a.f422957d);
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (a(byteArrayOutputStream.toByteArray()) == -1000) {
                        z16 = false;
                    }
                    byteArrayOutputStream.close();
                    httpURLConnection2.disconnect();
                    if (!z16) {
                        return -1000;
                    }
                    return 257;
                } catch (Exception e16) {
                    e = e16;
                    httpURLConnection = httpURLConnection2;
                    util.printException(e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return -1000;
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public byte[] a(int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(43);
        async_context b16 = u.b(this.f422889a.f422959f);
        allocate.put(u.f422927d0);
        allocate.putInt((int) b16._sappid);
        allocate.putInt((int) b16._sub_appid);
        allocate.putShort((short) 0);
        allocate.putLong(this.f422889a.f422957d);
        allocate.putShort((short) 10);
        allocate.put(util.SDK_VERSION.getBytes());
        allocate.putShort((short) this.f422890b);
        allocate.putShort((short) this.f422891c);
        allocate.put((byte) (i3 == -1000 ? 1 : 0));
        allocate.putInt(i3);
        byte[] bArr = new tlv_t8().get_tlv_8(0, u.f422951x, 0);
        ByteBuffer allocate2 = ByteBuffer.allocate(allocate.capacity() + 4 + 4 + tlv_t508.userBuf.length + 4 + 8 + bArr.length);
        allocate2.putShort((short) 2);
        allocate2.putShort((short) 3);
        allocate2.putShort((short) 512);
        allocate2.putShort((short) allocate.capacity());
        allocate2.put(allocate.array());
        allocate2.putShort((short) 513);
        allocate2.putShort((short) 4);
        allocate2.putInt(2);
        allocate2.putShort((short) 2);
        allocate2.putShort((short) tlv_t508.userBuf.length);
        allocate2.put(tlv_t508.userBuf);
        allocate2.put(bArr);
        byte[] encrypt = cryptor.encrypt(allocate2.array(), 0, allocate2.position(), this.f422889a.f422955b);
        if (encrypt == null) {
            encrypt = new byte[0];
        }
        ByteBuffer allocate3 = ByteBuffer.allocate(this.f422889a.f422955b.length + 2 + 2 + encrypt.length);
        allocate3.putShort((short) this.f422889a.f422955b.length);
        allocate3.put(this.f422889a.f422955b);
        allocate3.putShort((short) encrypt.length);
        allocate3.put(encrypt);
        return allocate3.array();
    }
}
