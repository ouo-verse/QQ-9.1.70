package o1;

import com.google.android.vending.licensing.util.Base64DecoderException;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import cooperation.qzone.QZoneHelper;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f421714a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f421715b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f421716c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f421717d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9};

    public static byte[] a(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return b(bytes, 0, bytes.length);
    }

    public static byte[] b(byte[] bArr, int i3, int i16) throws Base64DecoderException {
        return c(bArr, i3, i16, f421716c);
    }

    public static byte[] c(byte[] bArr, int i3, int i16, byte[] bArr2) throws Base64DecoderException {
        byte[] bArr3 = new byte[((i16 * 3) / 4) + 2];
        byte[] bArr4 = new byte[4];
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i17 >= i16) {
                break;
            }
            int i26 = i17 + i3;
            byte b16 = (byte) (bArr[i26] & Byte.MAX_VALUE);
            byte b17 = bArr2[b16];
            if (b17 >= -5) {
                if (b17 >= -1) {
                    if (b16 == 61) {
                        int i27 = i16 - i17;
                        byte b18 = (byte) (bArr[(i16 - 1) + i3] & Byte.MAX_VALUE);
                        if (i18 != 0 && i18 != 1) {
                            if ((i18 == 3 && i27 > 2) || (i18 == 4 && i27 > 1)) {
                                throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset " + i17);
                            }
                            if (b18 != 61 && b18 != 10) {
                                throw new Base64DecoderException("encoded value has invalid trailing byte");
                            }
                        } else {
                            throw new Base64DecoderException("invalid padding byte '=' at byte offset " + i17);
                        }
                    } else {
                        int i28 = i18 + 1;
                        bArr4[i18] = b16;
                        if (i28 == 4) {
                            i19 += d(bArr4, 0, bArr3, i19, bArr2);
                            i18 = 0;
                        } else {
                            i18 = i28;
                        }
                    }
                }
                i17++;
            } else {
                throw new Base64DecoderException("Bad Base64 input character at " + i17 + MsgSummary.STR_COLON + ((int) bArr[i26]) + "(decimal)");
            }
        }
        if (i18 != 0) {
            if (i18 != 1) {
                bArr4[i18] = 61;
                i19 += d(bArr4, 0, bArr3, i19, bArr2);
            } else {
                throw new Base64DecoderException("single trailing character at offset " + (i16 - 1));
            }
        }
        byte[] bArr5 = new byte[i19];
        System.arraycopy(bArr3, 0, bArr5, 0, i19);
        return bArr5;
    }

    private static int d(byte[] bArr, int i3, byte[] bArr2, int i16, byte[] bArr3) {
        byte b16 = bArr[i3 + 2];
        if (b16 == 61) {
            bArr2[i16] = (byte) ((((bArr3[bArr[i3 + 1]] << 24) >>> 12) | ((bArr3[bArr[i3]] << 24) >>> 6)) >>> 16);
            return 1;
        }
        byte b17 = bArr[i3 + 3];
        if (b17 == 61) {
            int i17 = ((bArr3[bArr[i3 + 1]] << 24) >>> 12) | ((bArr3[bArr[i3]] << 24) >>> 6) | ((bArr3[b16] << 24) >>> 18);
            bArr2[i16] = (byte) (i17 >>> 16);
            bArr2[i16 + 1] = (byte) (i17 >>> 8);
            return 2;
        }
        int i18 = ((bArr3[bArr[i3 + 1]] << 24) >>> 12) | ((bArr3[bArr[i3]] << 24) >>> 6) | ((bArr3[b16] << 24) >>> 18) | ((bArr3[b17] << 24) >>> 24);
        bArr2[i16] = (byte) (i18 >> 16);
        bArr2[i16 + 1] = (byte) (i18 >> 8);
        bArr2[i16 + 2] = (byte) i18;
        return 3;
    }

    public static byte[] e(String str) throws Base64DecoderException {
        byte[] bytes = str.getBytes();
        return f(bytes, 0, bytes.length);
    }

    public static byte[] f(byte[] bArr, int i3, int i16) throws Base64DecoderException {
        return c(bArr, i3, i16, f421717d);
    }

    public static String g(byte[] bArr) {
        return h(bArr, 0, bArr.length, f421714a, true);
    }

    public static String h(byte[] bArr, int i3, int i16, byte[] bArr2, boolean z16) {
        byte[] i17 = i(bArr, i3, i16, bArr2, Integer.MAX_VALUE);
        int length = i17.length;
        while (!z16 && length > 0 && i17[length - 1] == 61) {
            length--;
        }
        return new String(i17, 0, length);
    }

    public static byte[] i(byte[] bArr, int i3, int i16, byte[] bArr2, int i17) {
        int i18 = ((i16 + 2) / 3) * 4;
        byte[] bArr3 = new byte[i18 + (i18 / i17)];
        int i19 = i16 - 2;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (i26 < i19) {
            int i29 = ((bArr[i26 + i3] << 24) >>> 8) | ((bArr[(i26 + 1) + i3] << 24) >>> 16) | ((bArr[(i26 + 2) + i3] << 24) >>> 24);
            bArr3[i27] = bArr2[i29 >>> 18];
            int i36 = i27 + 1;
            bArr3[i36] = bArr2[(i29 >>> 12) & 63];
            bArr3[i27 + 2] = bArr2[(i29 >>> 6) & 63];
            bArr3[i27 + 3] = bArr2[i29 & 63];
            i28 += 4;
            if (i28 == i17) {
                bArr3[i27 + 4] = 10;
                i28 = 0;
                i27 = i36;
            }
            i26 += 3;
            i27 += 4;
        }
        if (i26 < i16) {
            j(bArr, i26 + i3, i16 - i26, bArr3, i27, bArr2);
            if (i28 + 4 == i17) {
                bArr3[i27 + 4] = 10;
            }
        }
        return bArr3;
    }

    private static byte[] j(byte[] bArr, int i3, int i16, byte[] bArr2, int i17, byte[] bArr3) {
        int i18;
        int i19;
        int i26 = 0;
        if (i16 > 0) {
            i18 = (bArr[i3] << 24) >>> 8;
        } else {
            i18 = 0;
        }
        if (i16 > 1) {
            i19 = (bArr[i3 + 1] << 24) >>> 16;
        } else {
            i19 = 0;
        }
        int i27 = i18 | i19;
        if (i16 > 2) {
            i26 = (bArr[i3 + 2] << 24) >>> 24;
        }
        int i28 = i27 | i26;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    return bArr2;
                }
                bArr2[i17] = bArr3[i28 >>> 18];
                bArr2[i17 + 1] = bArr3[(i28 >>> 12) & 63];
                bArr2[i17 + 2] = bArr3[(i28 >>> 6) & 63];
                bArr2[i17 + 3] = bArr3[i28 & 63];
                return bArr2;
            }
            bArr2[i17] = bArr3[i28 >>> 18];
            bArr2[i17 + 1] = bArr3[(i28 >>> 12) & 63];
            bArr2[i17 + 2] = bArr3[(i28 >>> 6) & 63];
            bArr2[i17 + 3] = 61;
            return bArr2;
        }
        bArr2[i17] = bArr3[i28 >>> 18];
        bArr2[i17 + 1] = bArr3[(i28 >>> 12) & 63];
        bArr2[i17 + 2] = 61;
        bArr2[i17 + 3] = 61;
        return bArr2;
    }
}
