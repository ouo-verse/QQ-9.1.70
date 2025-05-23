package com.tencent.component.network.utils;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class Coder {

        /* renamed from: op, reason: collision with root package name */
        public int f99905op;
        public byte[] output;

        Coder() {
        }

        public abstract int maxOutputSize(int i3);

        public abstract boolean process(byte[] bArr, int i3, int i16, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i3, byte[] bArr) {
            int[] iArr;
            this.output = bArr;
            if ((i3 & 8) == 0) {
                iArr = DECODE;
            } else {
                iArr = DECODE_WEBSAFE;
            }
            this.alphabet = iArr;
            this.state = 0;
            this.value = 0;
        }

        @Override // com.tencent.component.network.utils.Base64.Coder
        public int maxOutputSize(int i3) {
            return ((i3 * 3) / 4) + 10;
        }

        @Override // com.tencent.component.network.utils.Base64.Coder
        public boolean process(byte[] bArr, int i3, int i16, boolean z16) {
            int i17 = this.state;
            if (i17 == 6) {
                return false;
            }
            int i18 = i16 + i3;
            int i19 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i26 = 0;
            int i27 = i19;
            int i28 = i17;
            int i29 = i3;
            while (i29 < i18) {
                if (i28 == 0) {
                    while (true) {
                        int i36 = i29 + 4;
                        if (i36 > i18 || (i27 = (iArr[bArr[i29] & 255] << 18) | (iArr[bArr[i29 + 1] & 255] << 12) | (iArr[bArr[i29 + 2] & 255] << 6) | iArr[bArr[i29 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i26 + 2] = (byte) i27;
                        bArr2[i26 + 1] = (byte) (i27 >> 8);
                        bArr2[i26] = (byte) (i27 >> 16);
                        i26 += 3;
                        i29 = i36;
                    }
                    if (i29 >= i18) {
                        break;
                    }
                }
                int i37 = i29 + 1;
                int i38 = iArr[bArr[i29] & 255];
                if (i28 != 0) {
                    if (i28 != 1) {
                        if (i28 != 2) {
                            if (i28 != 3) {
                                if (i28 != 4) {
                                    if (i28 == 5 && i38 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                } else if (i38 == -2) {
                                    i28++;
                                } else if (i38 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i38 >= 0) {
                                int i39 = i38 | (i27 << 6);
                                bArr2[i26 + 2] = (byte) i39;
                                bArr2[i26 + 1] = (byte) (i39 >> 8);
                                bArr2[i26] = (byte) (i39 >> 16);
                                i26 += 3;
                                i27 = i39;
                                i28 = 0;
                            } else if (i38 == -2) {
                                bArr2[i26 + 1] = (byte) (i27 >> 2);
                                bArr2[i26] = (byte) (i27 >> 10);
                                i26 += 2;
                                i28 = 5;
                            } else if (i38 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else {
                            if (i38 < 0) {
                                if (i38 == -2) {
                                    bArr2[i26] = (byte) (i27 >> 4);
                                    i26++;
                                    i28 = 4;
                                } else if (i38 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            }
                            i38 |= i27 << 6;
                        }
                    } else {
                        if (i38 < 0) {
                            if (i38 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i38 |= i27 << 6;
                    }
                    i28++;
                    i27 = i38;
                } else {
                    if (i38 < 0) {
                        if (i38 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i28++;
                    i27 = i38;
                }
                i29 = i37;
            }
            if (!z16) {
                this.state = i28;
                this.value = i27;
                this.f99905op = i26;
                return true;
            }
            if (i28 != 1) {
                if (i28 != 2) {
                    if (i28 != 3) {
                        if (i28 == 4) {
                            this.state = 6;
                            return false;
                        }
                    } else {
                        int i46 = i26 + 1;
                        bArr2[i26] = (byte) (i27 >> 10);
                        i26 = i46 + 1;
                        bArr2[i46] = (byte) (i27 >> 2);
                    }
                } else {
                    bArr2[i26] = (byte) (i27 >> 4);
                    i26++;
                }
                this.state = i28;
                this.f99905op = i26;
                return true;
            }
            this.state = 6;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int i3, byte[] bArr) {
            boolean z16;
            boolean z17;
            byte[] bArr2;
            int i16;
            this.output = bArr;
            if ((i3 & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.do_padding = z16;
            if ((i3 & 2) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.do_newline = z17;
            this.do_cr = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = ENCODE;
            } else {
                bArr2 = ENCODE_WEBSAFE;
            }
            this.alphabet = bArr2;
            this.tail = new byte[2];
            this.tailLen = 0;
            if (z17) {
                i16 = 19;
            } else {
                i16 = -1;
            }
            this.count = i16;
        }

        @Override // com.tencent.component.network.utils.Base64.Coder
        public int maxOutputSize(int i3) {
            return ((i3 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        @Override // com.tencent.component.network.utils.Base64.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 478
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.component.network.utils.Base64.Encoder.process(byte[], int, int, boolean):boolean");
        }
    }

    Base64() {
    }

    public static byte[] decode(String str, int i3) {
        return decode(str.getBytes(), i3);
    }

    public static byte[] encode(byte[] bArr, int i3) {
        return encode(bArr, 0, bArr.length, i3);
    }

    public static String encodeToString(byte[] bArr, int i3) {
        try {
            return new String(encode(bArr, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new AssertionError(e16);
        }
    }

    public static byte[] decode(byte[] bArr, int i3) {
        return decode(bArr, 0, bArr.length, i3);
    }

    public static byte[] encode(byte[] bArr, int i3, int i16, int i17) {
        Encoder encoder = new Encoder(i17, null);
        int i18 = (i16 / 3) * 4;
        if (encoder.do_padding) {
            if (i16 % 3 > 0) {
                i18 += 4;
            }
        } else {
            int i19 = i16 % 3;
            if (i19 == 1) {
                i18 += 2;
            } else if (i19 == 2) {
                i18 += 3;
            }
        }
        if (encoder.do_newline && i16 > 0) {
            i18 += (((i16 - 1) / 57) + 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[i18];
        encoder.process(bArr, i3, i16, true);
        return encoder.output;
    }

    public static byte[] decode(byte[] bArr, int i3, int i16, int i17) {
        Decoder decoder = new Decoder(i17, new byte[(i16 * 3) / 4]);
        if (decoder.process(bArr, i3, i16, true)) {
            int i18 = decoder.f99905op;
            byte[] bArr2 = decoder.output;
            if (i18 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i18];
            System.arraycopy(bArr2, 0, bArr3, 0, i18);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String encodeToString(byte[] bArr, int i3, int i16, int i17) {
        try {
            return new String(encode(bArr, i3, i16, i17), "US-ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new AssertionError(e16);
        }
    }
}
