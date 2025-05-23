package com.tencent.luggage.wxa.hl;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.luggage.wxa.tn.w;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f127230a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f127231b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f127232c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f127233d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f127234e = {MultipartStream.DASH, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f127235f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static final byte[] b(int i3) {
        if ((i3 & 16) == 16) {
            return f127232c;
        }
        if ((i3 & 32) == 32) {
            return f127234e;
        }
        return f127230a;
    }

    public static final byte[] c(int i3) {
        if ((i3 & 16) == 16) {
            return f127233d;
        }
        if ((i3 & 32) == 32) {
            return f127235f;
        }
        return f127231b;
    }

    public static byte[] a(byte[] bArr, int i3, int i16, byte[] bArr2, int i17, int i18) {
        byte[] b16 = b(i18);
        int i19 = (i16 > 0 ? (bArr[i3] << 24) >>> 8 : 0) | (i16 > 1 ? (bArr[i3 + 1] << 24) >>> 16 : 0) | (i16 > 2 ? (bArr[i3 + 2] << 24) >>> 24 : 0);
        if (i16 == 1) {
            bArr2[i17] = b16[i19 >>> 18];
            bArr2[i17 + 1] = b16[(i19 >>> 12) & 63];
            bArr2[i17 + 2] = 61;
            bArr2[i17 + 3] = 61;
            return bArr2;
        }
        if (i16 == 2) {
            bArr2[i17] = b16[i19 >>> 18];
            bArr2[i17 + 1] = b16[(i19 >>> 12) & 63];
            bArr2[i17 + 2] = b16[(i19 >>> 6) & 63];
            bArr2[i17 + 3] = 61;
            return bArr2;
        }
        if (i16 != 3) {
            return bArr2;
        }
        bArr2[i17] = b16[i19 >>> 18];
        bArr2[i17 + 1] = b16[(i19 >>> 12) & 63];
        bArr2[i17 + 2] = b16[(i19 >>> 6) & 63];
        bArr2[i17 + 3] = b16[i19 & 63];
        return bArr2;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, int i3, int i16) {
        a(bArr2, 0, i3, bArr, 0, i16);
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static byte[] b(byte[] bArr, int i3, int i16, int i17) {
        C6269a c6269a;
        ?? r46;
        ByteArrayOutputStream byteArrayOutputStream;
        if (bArr == null) {
            w.d("MicroMsg.AppBrandNetWork.Base64", "Cannot serialize a null array.");
            return new byte[0];
        }
        if (i3 < 0) {
            w.d("MicroMsg.AppBrandNetWork.Base64", "Cannot have negative offset: " + i3);
            return new byte[0];
        }
        if (i16 < 0) {
            w.d("MicroMsg.AppBrandNetWork.Base64", "Cannot have length offset: " + i16);
            return new byte[0];
        }
        if (i3 + i16 > bArr.length) {
            w.d("MicroMsg.AppBrandNetWork.Base64", "off + len > source.length  ");
            return new byte[0];
        }
        if ((i17 & 2) != 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    c6269a = new C6269a(byteArrayOutputStream, i17 | 1);
                } catch (IOException e16) {
                    e = e16;
                    c6269a = null;
                    r46 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    c6269a = null;
                }
                try {
                    r46 = new GZIPOutputStream(c6269a);
                } catch (IOException e17) {
                    e = e17;
                    r46 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        c6269a.close();
                    } catch (Exception unused2) {
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (Exception unused3) {
                        throw th;
                    }
                }
            } catch (IOException e18) {
                e = e18;
                c6269a = null;
                r46 = 0;
            } catch (Throwable th7) {
                th = th7;
                c6269a = null;
                r46 = 0;
                byteArrayOutputStream = byteArrayOutputStream2;
                byteArrayOutputStream2 = r46;
                byteArrayOutputStream2.close();
                c6269a.close();
                byteArrayOutputStream.close();
                throw th;
            }
            try {
                r46.write(bArr, i3, i16);
                r46.close();
                try {
                    r46.close();
                } catch (Exception unused4) {
                }
                try {
                    c6269a.close();
                } catch (Exception unused5) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused6) {
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e19) {
                e = e19;
                byteArrayOutputStream2 = byteArrayOutputStream;
                r46 = r46;
                try {
                    throw e;
                } catch (Throwable th8) {
                    th = th8;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    byteArrayOutputStream2 = r46;
                    byteArrayOutputStream2.close();
                    c6269a.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                byteArrayOutputStream2 = r46;
                byteArrayOutputStream2.close();
                c6269a.close();
                byteArrayOutputStream.close();
                throw th;
            }
        }
        boolean z16 = (i17 & 8) != 0;
        int i18 = ((i16 / 3) * 4) + (i16 % 3 > 0 ? 4 : 0);
        if (z16) {
            i18 += i18 / 76;
        }
        int i19 = i18;
        byte[] bArr2 = new byte[i19];
        int i26 = i16 - 2;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (i27 < i26) {
            int i36 = i27;
            a(bArr, i27 + i3, 3, bArr2, i28, i17);
            int i37 = i29 + 4;
            if (!z16 || i37 < 76) {
                i29 = i37;
            } else {
                bArr2[i28 + 4] = 10;
                i28++;
                i29 = 0;
            }
            i27 = i36 + 3;
            i28 += 4;
        }
        int i38 = i27;
        if (i38 < i16) {
            a(bArr, i38 + i3, i16 - i38, bArr2, i28, i17);
            i28 += 4;
        }
        int i39 = i28;
        if (i39 > i19 - 1) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i39];
        System.arraycopy(bArr2, 0, bArr3, 0, i39);
        return bArr3;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.hl.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6269a extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        public boolean f127236a;

        /* renamed from: b, reason: collision with root package name */
        public int f127237b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f127238c;

        /* renamed from: d, reason: collision with root package name */
        public int f127239d;

        /* renamed from: e, reason: collision with root package name */
        public int f127240e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f127241f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f127242g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f127243h;

        /* renamed from: i, reason: collision with root package name */
        public int f127244i;

        /* renamed from: j, reason: collision with root package name */
        public byte[] f127245j;

        public C6269a(OutputStream outputStream, int i3) {
            super(outputStream);
            boolean z16;
            int i16;
            if ((i3 & 8) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f127241f = z16;
            boolean z17 = (i3 & 1) != 0;
            this.f127236a = z17;
            if (z17) {
                i16 = 3;
            } else {
                i16 = 4;
            }
            this.f127239d = i16;
            this.f127238c = new byte[i16];
            this.f127237b = 0;
            this.f127240e = 0;
            this.f127243h = false;
            this.f127242g = new byte[4];
            this.f127244i = i3;
            this.f127245j = a.c(i3);
        }

        public void a() {
            int i3 = this.f127237b;
            if (i3 > 0) {
                if (this.f127236a) {
                    ((FilterOutputStream) this).out.write(a.b(this.f127242g, this.f127238c, i3, this.f127244i));
                    this.f127237b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
            super.close();
            this.f127238c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i3) {
            if (this.f127243h) {
                ((FilterOutputStream) this).out.write(i3);
                return;
            }
            if (this.f127236a) {
                byte[] bArr = this.f127238c;
                int i16 = this.f127237b;
                int i17 = i16 + 1;
                this.f127237b = i17;
                bArr[i16] = (byte) i3;
                int i18 = this.f127239d;
                if (i17 >= i18) {
                    ((FilterOutputStream) this).out.write(a.b(this.f127242g, bArr, i18, this.f127244i));
                    int i19 = this.f127240e + 4;
                    this.f127240e = i19;
                    if (this.f127241f && i19 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.f127240e = 0;
                    }
                    this.f127237b = 0;
                    return;
                }
                return;
            }
            byte b16 = this.f127245j[i3 & 127];
            if (b16 <= -5) {
                if (b16 != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
                return;
            }
            byte[] bArr2 = this.f127238c;
            int i26 = this.f127237b;
            int i27 = i26 + 1;
            this.f127237b = i27;
            bArr2[i26] = (byte) i3;
            if (i27 >= this.f127239d) {
                ((FilterOutputStream) this).out.write(this.f127242g, 0, a.b(bArr2, 0, this.f127242g, 0, this.f127244i));
                this.f127237b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i16) {
            if (this.f127243h) {
                ((FilterOutputStream) this).out.write(bArr, i3, i16);
                return;
            }
            for (int i17 = 0; i17 < i16; i17++) {
                write(bArr[i3 + i17]);
            }
        }
    }

    public static String a(byte[] bArr) {
        try {
            return a(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String a(byte[] bArr, int i3, int i16, int i17) {
        byte[] b16 = b(bArr, i3, i16, i17);
        try {
            return new String(b16, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b16);
        }
    }

    public static int b(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        int i18;
        int i19;
        if (bArr == null) {
            w.d("MicroMsg.AppBrandNetWork.Base64", "Source array was null.");
            return 0;
        }
        if (bArr2 == null) {
            w.d("MicroMsg.AppBrandNetWork.Base64", "Destination array was null.");
            return 0;
        }
        if (i3 >= 0 && (i18 = i3 + 3) < bArr.length) {
            if (i16 >= 0 && (i19 = i16 + 2) < bArr2.length) {
                byte[] c16 = c(i17);
                byte b16 = bArr[i3 + 2];
                if (b16 == 61) {
                    bArr2[i16] = (byte) ((((c16[bArr[i3 + 1]] & 255) << 12) | ((c16[bArr[i3]] & 255) << 18)) >>> 16);
                    return 1;
                }
                byte b17 = bArr[i18];
                if (b17 == 61) {
                    int i26 = ((c16[bArr[i3 + 1]] & 255) << 12) | ((c16[bArr[i3]] & 255) << 18) | ((c16[b16] & 255) << 6);
                    bArr2[i16] = (byte) (i26 >>> 16);
                    bArr2[i16 + 1] = (byte) (i26 >>> 8);
                    return 2;
                }
                int i27 = ((c16[bArr[i3 + 1]] & 255) << 12) | ((c16[bArr[i3]] & 255) << 18) | ((c16[b16] & 255) << 6) | (c16[b17] & 255);
                bArr2[i16] = (byte) (i27 >> 16);
                bArr2[i16 + 1] = (byte) (i27 >> 8);
                bArr2[i19] = (byte) i27;
                return 3;
            }
            w.d("MicroMsg.AppBrandNetWork.Base64", "Destination array with length cannot have offset of and still store three bytes.");
            return 0;
        }
        w.d("MicroMsg.AppBrandNetWork.Base64", "srcOffset < 0 || srcOffset + 3 >= source.length");
        return 0;
    }
}
