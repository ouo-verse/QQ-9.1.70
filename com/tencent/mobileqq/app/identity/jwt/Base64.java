package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.app.identity.jwt.BaseNCodec;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QZoneHelper;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Base64 extends BaseNCodec {
    static IPatchRedirector $redirector_ = null;
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR;
    private static final byte[] DECODE_TABLE;
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE;
    private static final byte[] URL_SAFE_ENCODE_TABLE;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_KING_GAME_DAN_DISPLAY_SWITCH);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        CHUNK_SEPARATOR = new byte[]{13, 10};
        STANDARD_ENCODE_TABLE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        URL_SAFE_ENCODE_TABLE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};
        DECODE_TABLE = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51};
    }

    public Base64() {
        this(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    @Override // com.tencent.mobileqq.app.identity.jwt.BaseNCodec
    void decode(byte[] bArr, int i3, int i16, BaseNCodec.Context context) {
        byte b16;
        if (context.eof) {
            return;
        }
        if (i16 < 0) {
            context.eof = true;
        }
        int i17 = 0;
        while (true) {
            if (i17 >= i16) {
                break;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
            int i18 = i3 + 1;
            byte b17 = bArr[i3];
            if (b17 == 61) {
                context.eof = true;
                break;
            }
            if (b17 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b17 < bArr2.length && (b16 = bArr2[b17]) >= 0) {
                    int i19 = (context.modulus + 1) % 4;
                    context.modulus = i19;
                    int i26 = (context.ibitWorkArea << 6) + b16;
                    context.ibitWorkArea = i26;
                    if (i19 == 0) {
                        int i27 = context.pos;
                        int i28 = i27 + 1;
                        ensureBufferSize[i27] = (byte) ((i26 >> 16) & 255);
                        int i29 = i28 + 1;
                        ensureBufferSize[i28] = (byte) ((i26 >> 8) & 255);
                        context.pos = i29 + 1;
                        ensureBufferSize[i29] = (byte) (i26 & 255);
                    }
                }
            }
            i17++;
            i3 = i18;
        }
        if (context.eof && context.modulus != 0) {
            byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
            int i36 = context.modulus;
            if (i36 != 1) {
                if (i36 != 2) {
                    if (i36 == 3) {
                        int i37 = context.ibitWorkArea >> 2;
                        context.ibitWorkArea = i37;
                        int i38 = context.pos;
                        int i39 = i38 + 1;
                        ensureBufferSize2[i38] = (byte) ((i37 >> 8) & 255);
                        context.pos = i39 + 1;
                        ensureBufferSize2[i39] = (byte) (i37 & 255);
                        return;
                    }
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                int i46 = context.ibitWorkArea >> 4;
                context.ibitWorkArea = i46;
                int i47 = context.pos;
                context.pos = i47 + 1;
                ensureBufferSize2[i47] = (byte) (i46 & 255);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.identity.jwt.BaseNCodec
    protected boolean isInAlphabet(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Byte.valueOf(b16))).booleanValue();
        }
        if (b16 >= 0) {
            byte[] bArr = this.decodeTable;
            if (b16 < bArr.length && bArr[b16] != -1) {
                return true;
            }
        }
        return false;
    }

    public Base64(int i3) {
        this(i3, CHUNK_SEPARATOR);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }

    public Base64(int i3, byte[] bArr) {
        this(i3, bArr, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bArr);
    }

    public Base64(int i3, byte[] bArr, boolean z16) {
        super(3, 4, i3, bArr == null ? 0 : bArr.length);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), bArr, Boolean.valueOf(z16));
            return;
        }
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + new String(bArr) + "]");
            }
            if (i3 > 0) {
                this.encodeSize = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z16 ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
