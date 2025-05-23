package org.java_websocket.util;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes37.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    private static final String PREFERRED_ENCODING = "US-ASCII";
    public static final int URL_SAFE = 16;
    private static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte EQUALS_SIGN = 61;
    private static final byte[] _STANDARD_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] _URL_SAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};
    private static final byte[] _URL_SAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] _ORDERED_ALPHABET = {MultipartStream.DASH, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION};
    private static final byte[] _ORDERED_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, EQUALS_SIGN, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class OutputStream extends FilterOutputStream {

        /* renamed from: b4, reason: collision with root package name */
        private byte[] f423602b4;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int options;
        private int position;
        private boolean suspendEncoding;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            ((FilterOutputStream) this).out = null;
        }

        public void flushBase64() throws IOException {
            int i3 = this.position;
            if (i3 > 0) {
                if (this.encode) {
                    ((FilterOutputStream) this).out.write(Base64.encode3to4(this.f423602b4, this.buffer, i3, this.options));
                    this.position = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i3) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(i3);
                return;
            }
            if (this.encode) {
                byte[] bArr = this.buffer;
                int i16 = this.position;
                int i17 = i16 + 1;
                this.position = i17;
                bArr[i16] = (byte) i3;
                int i18 = this.bufferLength;
                if (i17 >= i18) {
                    ((FilterOutputStream) this).out.write(Base64.encode3to4(this.f423602b4, bArr, i18, this.options));
                    int i19 = this.lineLength + 4;
                    this.lineLength = i19;
                    if (this.breakLines && i19 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                    return;
                }
                return;
            }
            byte b16 = this.decodabet[i3 & 127];
            if (b16 <= -5) {
                if (b16 != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
                return;
            }
            byte[] bArr2 = this.buffer;
            int i26 = this.position;
            int i27 = i26 + 1;
            this.position = i27;
            bArr2[i26] = (byte) i3;
            if (i27 >= this.bufferLength) {
                ((FilterOutputStream) this).out.write(this.f423602b4, 0, Base64.decode4to3(bArr2, 0, this.f423602b4, 0, this.options));
                this.position = 0;
            }
        }

        public OutputStream(java.io.OutputStream outputStream, int i3) {
            super(outputStream);
            this.breakLines = (i3 & 8) != 0;
            boolean z16 = (i3 & 1) != 0;
            this.encode = z16;
            int i16 = z16 ? 3 : 4;
            this.bufferLength = i16;
            this.buffer = new byte[i16];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.f423602b4 = new byte[4];
            this.options = i3;
            this.decodabet = Base64.getDecodabet(i3);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i16) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(bArr, i3, i16);
                return;
            }
            for (int i17 = 0; i17 < i16; i17++) {
                write(bArr[i3 + i17]);
            }
        }
    }

    Base64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int decode4to3(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        int i18;
        int i19;
        if (bArr == null) {
            throw new IllegalArgumentException("Source array was null.");
        }
        if (bArr2 != null) {
            if (i3 >= 0 && (i18 = i3 + 3) < bArr.length) {
                if (i16 >= 0 && (i19 = i16 + 2) < bArr2.length) {
                    byte[] decodabet = getDecodabet(i17);
                    byte b16 = bArr[i3 + 2];
                    if (b16 == 61) {
                        bArr2[i16] = (byte) ((((decodabet[bArr[i3 + 1]] & 255) << 12) | ((decodabet[bArr[i3]] & 255) << 18)) >>> 16);
                        return 1;
                    }
                    byte b17 = bArr[i18];
                    if (b17 == 61) {
                        int i26 = ((decodabet[bArr[i3 + 1]] & 255) << 12) | ((decodabet[bArr[i3]] & 255) << 18) | ((decodabet[b16] & 255) << 6);
                        bArr2[i16] = (byte) (i26 >>> 16);
                        bArr2[i16 + 1] = (byte) (i26 >>> 8);
                        return 2;
                    }
                    int i27 = ((decodabet[bArr[i3 + 1]] & 255) << 12) | ((decodabet[bArr[i3]] & 255) << 18) | ((decodabet[b16] & 255) << 6) | (decodabet[b17] & 255);
                    bArr2[i16] = (byte) (i27 >> 16);
                    bArr2[i16 + 1] = (byte) (i27 >> 8);
                    bArr2[i19] = (byte) i27;
                    return 3;
                }
                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i16)));
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i3)));
        }
        throw new IllegalArgumentException("Destination array was null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i3, int i16) {
        encode3to4(bArr2, 0, i3, bArr, 0, i16);
        return bArr;
    }

    public static String encodeBytes(byte[] bArr) {
        try {
            return encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    private static byte[] encode3to4(byte[] bArr, int i3, int i16, byte[] bArr2, int i17, int i18) {
        byte[] alphabet = getAlphabet(i18);
        int i19 = (i16 > 0 ? (bArr[i3] << 24) >>> 8 : 0) | (i16 > 1 ? (bArr[i3 + 1] << 24) >>> 16 : 0) | (i16 > 2 ? (bArr[i3 + 2] << 24) >>> 24 : 0);
        if (i16 == 1) {
            bArr2[i17] = alphabet[i19 >>> 18];
            bArr2[i17 + 1] = alphabet[(i19 >>> 12) & 63];
            bArr2[i17 + 2] = EQUALS_SIGN;
            bArr2[i17 + 3] = EQUALS_SIGN;
            return bArr2;
        }
        if (i16 == 2) {
            bArr2[i17] = alphabet[i19 >>> 18];
            bArr2[i17 + 1] = alphabet[(i19 >>> 12) & 63];
            bArr2[i17 + 2] = alphabet[(i19 >>> 6) & 63];
            bArr2[i17 + 3] = EQUALS_SIGN;
            return bArr2;
        }
        if (i16 != 3) {
            return bArr2;
        }
        bArr2[i17] = alphabet[i19 >>> 18];
        bArr2[i17 + 1] = alphabet[(i19 >>> 12) & 63];
        bArr2[i17 + 2] = alphabet[(i19 >>> 6) & 63];
        bArr2[i17 + 3] = alphabet[i19 & 63];
        return bArr2;
    }

    public static String encodeBytes(byte[] bArr, int i3, int i16, int i17) throws IOException {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i3, i16, i17);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(encodeBytesToBytes);
        }
    }

    private static final byte[] getAlphabet(int i3) {
        if ((i3 & 16) == 16) {
            return _URL_SAFE_ALPHABET;
        }
        if ((i3 & 32) == 32) {
            return _ORDERED_ALPHABET;
        }
        return _STANDARD_ALPHABET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getDecodabet(int i3) {
        if ((i3 & 16) == 16) {
            return _URL_SAFE_DECODABET;
        }
        if ((i3 & 32) == 32) {
            return _ORDERED_DECODABET;
        }
        return _STANDARD_DECODABET;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] encodeBytesToBytes(byte[] bArr, int i3, int i16, int i17) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ?? r46;
        if (bArr == null) {
            throw new IllegalArgumentException("Cannot serialize a null array.");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i3);
        }
        if (i16 >= 0) {
            if (i3 + i16 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(bArr.length)));
            }
            if ((i17 & 2) != 0) {
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        outputStream = new OutputStream(byteArrayOutputStream, i17 | 1);
                    } catch (IOException e16) {
                        e = e16;
                        outputStream = null;
                        r46 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStream = null;
                    }
                } catch (IOException e17) {
                    e = e17;
                    outputStream = null;
                    r46 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                    outputStream = null;
                }
                try {
                    r46 = new GZIPOutputStream(outputStream);
                    try {
                        r46.write(bArr, i3, i16);
                        r46.close();
                        try {
                            r46.close();
                        } catch (Exception unused) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e18) {
                        e = e18;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        r46 = r46;
                        try {
                            throw e;
                        } catch (Throwable th7) {
                            th = th7;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            byteArrayOutputStream2 = r46;
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        byteArrayOutputStream2 = r46;
                        if (byteArrayOutputStream2 != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                    }
                } catch (IOException e19) {
                    e = e19;
                    r46 = 0;
                } catch (Throwable th9) {
                    th = th9;
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                }
            } else {
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
                    encode3to4(bArr, i27 + i3, 3, bArr2, i28, i17);
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
                    encode3to4(bArr, i38 + i3, i16 - i38, bArr2, i28, i17);
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
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i16);
        }
    }
}
