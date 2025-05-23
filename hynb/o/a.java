package hynb.o;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import hynb.p.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f406782d = new a();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f406783a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    public byte f406784b = 61;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f406785c = new byte[128];

    public a() {
        a();
    }

    public static String b(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                f406782d.a(bArr, byteArrayOutputStream);
            } catch (IOException e16) {
                g.f406799a.a(a.class, e16);
            }
            try {
                return new String(byteArrayOutputStream.toByteArray(), "US-ASCII");
            } catch (UnsupportedEncodingException e17) {
                g.f406799a.a("HuyaBase64", e17);
            }
        }
        return "";
    }

    public final boolean a(char c16) {
        return c16 == '\n' || c16 == '\r' || c16 == '\t' || c16 == ' ';
    }

    public static byte[] a(String str) {
        return a(str.getBytes());
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((bArr.length / 4) * 3);
        try {
            f406782d.a(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e16) {
            g.f406799a.a("HuyaBase64", e16);
            return new byte[0];
        }
    }

    public void a() {
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f406783a;
            if (i3 >= bArr.length) {
                return;
            }
            this.f406785c[bArr[i3]] = (byte) i3;
            i3++;
        }
    }

    public int a(byte[] bArr, OutputStream outputStream) {
        int length = bArr.length;
        int i3 = length % 3;
        int i16 = length - i3;
        for (int i17 = 0; i17 < i16; i17 += 3) {
            int i18 = bArr[i17] & 255;
            int i19 = bArr[i17 + 1] & 255;
            int i26 = bArr[i17 + 2] & 255;
            outputStream.write(this.f406783a[(i18 >>> 2) & 63]);
            outputStream.write(this.f406783a[((i18 << 4) | (i19 >>> 4)) & 63]);
            outputStream.write(this.f406783a[((i19 << 2) | (i26 >>> 6)) & 63]);
            outputStream.write(this.f406783a[i26 & 63]);
        }
        if (i3 == 1) {
            int i27 = bArr[i16] & 255;
            outputStream.write(this.f406783a[(i27 >>> 2) & 63]);
            outputStream.write(this.f406783a[(i27 << 4) & 63]);
            outputStream.write(this.f406784b);
            outputStream.write(this.f406784b);
        } else if (i3 == 2) {
            int i28 = bArr[i16] & 255;
            int i29 = bArr[i16 + 1] & 255;
            outputStream.write(this.f406783a[(i28 >>> 2) & 63]);
            outputStream.write(this.f406783a[((i28 << 4) | (i29 >>> 4)) & 63]);
            outputStream.write(this.f406783a[(i29 << 2) & 63]);
            outputStream.write(this.f406784b);
        }
        return ((i16 / 3) * 4) + (i3 != 0 ? 4 : 0);
    }

    public int a(byte[] bArr, int i3, int i16, OutputStream outputStream) {
        int i17 = i3 + i16;
        while (i17 > i3 && a((char) bArr[i17 - 1])) {
            i17--;
        }
        int i18 = i17 - 4;
        int a16 = a(bArr, i3, i18);
        int i19 = 0;
        while (a16 < i18) {
            int i26 = a16 + 1;
            byte b16 = this.f406785c[bArr[a16]];
            int a17 = a(bArr, i26, i18);
            int i27 = a17 + 1;
            byte b17 = this.f406785c[bArr[a17]];
            int a18 = a(bArr, i27, i18);
            int i28 = a18 + 1;
            byte b18 = this.f406785c[bArr[a18]];
            int a19 = a(bArr, i28, i18);
            int i29 = a19 + 1;
            byte b19 = this.f406785c[bArr[a19]];
            outputStream.write((b16 << 2) | (b17 >> 4));
            outputStream.write((b17 << 4) | (b18 >> 2));
            outputStream.write((b18 << 6) | b19);
            i19 += 3;
            a16 = a(bArr, i29, i18);
        }
        return i16 >= 4 ? i19 + a(outputStream, (char) bArr[i18], (char) bArr[i17 - 3], (char) bArr[i17 - 2], (char) bArr[i17 - 1]) : i19;
    }

    public final int a(byte[] bArr, int i3, int i16) {
        while (i3 < i16 && a((char) bArr[i3])) {
            i3++;
        }
        return i3;
    }

    public final int a(OutputStream outputStream, char c16, char c17, char c18, char c19) {
        byte b16 = this.f406784b;
        if (c18 == b16) {
            byte[] bArr = this.f406785c;
            outputStream.write((bArr[c16] << 2) | (bArr[c17] >> 4));
            return 1;
        }
        if (c19 == b16) {
            byte[] bArr2 = this.f406785c;
            byte b17 = bArr2[c16];
            byte b18 = bArr2[c17];
            byte b19 = bArr2[c18];
            outputStream.write((b17 << 2) | (b18 >> 4));
            outputStream.write((b18 << 4) | (b19 >> 2));
            return 2;
        }
        byte[] bArr3 = this.f406785c;
        byte b26 = bArr3[c16];
        byte b27 = bArr3[c17];
        byte b28 = bArr3[c18];
        byte b29 = bArr3[c19];
        outputStream.write((b26 << 2) | (b27 >> 4));
        outputStream.write((b27 << 4) | (b28 >> 2));
        outputStream.write((b28 << 6) | b29);
        return 3;
    }
}
