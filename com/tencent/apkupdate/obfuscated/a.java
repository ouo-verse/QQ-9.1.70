package com.tencent.apkupdate.obfuscated;

import android.content.SharedPreferences;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.logic.protocol.jce.Response;
import com.tencent.apkupdate.logic.protocol.jce.RspHead;
import com.tencent.tmassistant.common.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static int a(int i3) {
        int i16 = (i3 >> 0) & 255;
        int i17 = (i3 >> 8) & 255;
        int i18 = (i3 >> 16) & 255;
        return (((i3 >> 24) & 255) << 0) | (i16 << 24) | (i17 << 16) | (i18 << 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JceStruct b(JceStruct jceStruct, byte[] bArr) {
        JceStruct jceStruct2;
        if (jceStruct != null && bArr != null) {
            try {
                jceStruct2 = (JceStruct) Class.forName("com.tencent.apkupdate.logic.protocol.jce." + (jceStruct.getClass().getSimpleName().substring(0, r4.length() - 7) + "Response")).newInstance();
            } catch (ClassNotFoundException e16) {
                e16.printStackTrace();
                jceStruct2 = null;
                if (jceStruct2 != null) {
                }
                return null;
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
                jceStruct2 = null;
                if (jceStruct2 != null) {
                }
                return null;
            } catch (InstantiationException e18) {
                e18.printStackTrace();
                jceStruct2 = null;
                if (jceStruct2 != null) {
                }
                return null;
            }
            if (jceStruct2 != null) {
                try {
                    JceInputStream jceInputStream = new JceInputStream(bArr);
                    jceInputStream.setServerEncoding("utf-8");
                    jceStruct2.readFrom(jceInputStream);
                    return jceStruct2;
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Response c(byte[] bArr) {
        SharedPreferences sharedPreferences;
        if (bArr.length < 4) {
            return null;
        }
        Response response = new Response();
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf-8");
            response.readFrom(jceInputStream);
            RspHead rspHead = response.head;
            if (rspHead.ret == 0) {
                if ((rspHead.encryptWithPack & 2) == 2) {
                    response.body = f(response.body, ProtocolPackage.CRYPT_KEY.getBytes());
                }
                if ((response.head.encryptWithPack & 1) == 1) {
                    response.body = g(response.body);
                }
                l a16 = l.a();
                String str = response.head.phoneGuid;
                a16.getClass();
                if (str != null && (sharedPreferences = a16.f72549a.getSharedPreferences("TMAssistantSDKSharedPreference", 0)) != null) {
                    sharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", str).commit();
                }
            }
            return response;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static short d(short s16) {
        int i3 = s16 & 255;
        return (short) ((((s16 >> 8) & 255) << 0) | (i3 << 8));
    }

    public static void e(b bVar, DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(1347094280);
        dataOutputStream.writeInt(a(bVar.f72488g));
        dataOutputStream.writeInt(a(bVar.f72489h));
        dataOutputStream.writeInt(a(bVar.f72490i));
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        k kVar = new k();
        int length = bArr.length;
        kVar.f72538e = 0;
        kVar.f72537d = 0;
        kVar.f72541h = bArr2;
        byte[] bArr3 = new byte[8];
        if (length % 8 == 0 && length >= 16) {
            byte[] c16 = kVar.c(bArr, 0);
            kVar.f72535b = c16;
            int i3 = c16[0] & 7;
            kVar.f72539f = i3;
            int i16 = (length - i3) - 10;
            if (i16 >= 0) {
                for (int i17 = 0; i17 < 8; i17++) {
                    bArr3[i17] = 0;
                }
                kVar.f72536c = new byte[i16];
                kVar.f72538e = 0;
                kVar.f72537d = 8;
                kVar.f72543j = 8;
                kVar.f72539f++;
                kVar.f72540g = 1;
                while (true) {
                    int i18 = kVar.f72540g;
                    if (i18 <= 2) {
                        int i19 = kVar.f72539f;
                        if (i19 < 8) {
                            kVar.f72539f = i19 + 1;
                            kVar.f72540g = i18 + 1;
                        }
                        if (kVar.f72539f == 8) {
                            if (!kVar.b(bArr, 0, length)) {
                                break;
                            }
                            bArr3 = bArr;
                        }
                    } else {
                        int i26 = 0;
                        while (true) {
                            if (i16 != 0) {
                                int i27 = kVar.f72539f;
                                if (i27 < 8) {
                                    kVar.f72536c[i26] = (byte) (bArr3[(kVar.f72538e + 0) + i27] ^ kVar.f72535b[i27]);
                                    i26++;
                                    i16--;
                                    kVar.f72539f = i27 + 1;
                                }
                                if (kVar.f72539f == 8) {
                                    kVar.f72538e = kVar.f72537d - 8;
                                    if (!kVar.b(bArr, 0, length)) {
                                        break;
                                    }
                                    bArr3 = bArr;
                                }
                            } else {
                                kVar.f72540g = 1;
                                while (kVar.f72540g < 8) {
                                    int i28 = kVar.f72539f;
                                    if (i28 < 8) {
                                        if ((bArr3[(kVar.f72538e + 0) + i28] ^ kVar.f72535b[i28]) == 0) {
                                            kVar.f72539f = i28 + 1;
                                        }
                                    }
                                    if (kVar.f72539f == 8) {
                                        kVar.f72538e = kVar.f72537d;
                                        if (kVar.b(bArr, 0, length)) {
                                            bArr3 = bArr;
                                        }
                                    }
                                    kVar.f72540g++;
                                }
                                return kVar.f72536c;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static byte[] g(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Inflater inflater = new Inflater();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    byte[] bArr2 = new byte[1024];
                    inflater.setInput(bArr);
                    while (!inflater.finished()) {
                        byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                    }
                    inflater.end();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                    }
                } catch (DataFormatException e16) {
                    e = e16;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    e.printStackTrace();
                    inflater.end();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    byteArrayOutputStream = byteArrayOutputStream2;
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    inflater.end();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (DataFormatException e17) {
            e = e17;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
