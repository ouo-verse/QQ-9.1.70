package org.apache.commons.fileupload.util.mime;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
final class Base64Decoder {
    private static final int INPUT_BYTES_PER_CHUNK = 4;
    private static final int INVALID_BYTE = -1;
    private static final int MASK_BYTE_UNSIGNED = 255;
    private static final byte PADDING = 61;
    private static final int PAD_BYTE = -2;
    private static final byte[] ENCODING_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] DECODING_TABLE = new byte[256];

    static {
        int i3 = 0;
        int i16 = 0;
        while (true) {
            byte[] bArr = DECODING_TABLE;
            if (i16 >= bArr.length) {
                break;
            }
            bArr[i16] = -1;
            i16++;
        }
        while (true) {
            byte[] bArr2 = ENCODING_TABLE;
            if (i3 < bArr2.length) {
                DECODING_TABLE[bArr2[i3]] = (byte) i3;
                i3++;
            } else {
                DECODING_TABLE[61] = -2;
                return;
            }
        }
    }

    Base64Decoder() {
    }

    public static int decode(byte[] bArr, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[4];
        int i3 = 0;
        int i16 = 0;
        for (byte b16 : bArr) {
            byte b17 = DECODING_TABLE[b16 & 255];
            if (b17 != -1) {
                int i17 = i3 + 1;
                bArr2[i3] = b17;
                if (i17 == 4) {
                    byte b18 = bArr2[0];
                    byte b19 = bArr2[1];
                    byte b26 = bArr2[2];
                    byte b27 = bArr2[3];
                    if (b18 != -2 && b19 != -2) {
                        outputStream.write((b18 << 2) | (b19 >> 4));
                        i16++;
                        if (b26 != -2) {
                            outputStream.write((b19 << 4) | (b26 >> 2));
                            i16++;
                            if (b27 != -2) {
                                outputStream.write((b26 << 6) | b27);
                                i16++;
                            }
                        } else if (b27 != -2) {
                            throw new IOException("Invalid Base64 input: incorrect padding, 4th byte must be padding if 3rd byte is");
                        }
                        i3 = 0;
                    } else {
                        throw new IOException("Invalid Base64 input: incorrect padding, first two bytes cannot be padding");
                    }
                } else {
                    i3 = i17;
                }
            }
        }
        if (i3 == 0) {
            return i16;
        }
        throw new IOException("Invalid Base64 input: truncated");
    }
}
