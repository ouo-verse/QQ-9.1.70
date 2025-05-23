package com.tencent.mobileqq.pluginsdk;

import android.util.Xml;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.fileupload.MultipartStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes16.dex */
public final class PluginBaseInfoHelper {
    static IPatchRedirector $redirector_;

    /* loaded from: classes16.dex */
    public static class Base64Helper {
        static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_ = null;
        public static final int CRLF = 4;
        public static final int DEFAULT = 0;
        public static final int NO_CLOSE = 16;
        public static final int NO_PADDING = 1;
        public static final int NO_WRAP = 2;
        public static final int URL_SAFE = 8;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes16.dex */
        public static abstract class Coder {
            static IPatchRedirector $redirector_;

            /* renamed from: op, reason: collision with root package name */
            public int f258933op;
            public byte[] output;

            Coder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public abstract int maxOutputSize(int i3);

            public abstract boolean process(byte[] bArr, int i3, int i16, boolean z16);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes16.dex */
        public static class Decoder extends Coder {
            static IPatchRedirector $redirector_ = null;
            private static final int[] DECODE;
            private static final int[] DECODE_WEBSAFE;
            private static final int EQUALS = -2;
            private static final int SKIP = -1;
            private final int[] alphabet;
            private int state;
            private int value;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12640);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 4)) {
                    redirector.redirect((short) 4);
                } else {
                    DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
                    DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
                }
            }

            public Decoder(int i3, byte[] bArr) {
                int[] iArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
                    return;
                }
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

            @Override // com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.Base64Helper.Coder
            public int maxOutputSize(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
                }
                return ((i3 * 3) / 4) + 10;
            }

            @Override // com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.Base64Helper.Coder
            public boolean process(byte[] bArr, int i3, int i16, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                int i17 = 1;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
                }
                int i18 = this.state;
                if (i18 == 6) {
                    return false;
                }
                int i19 = i16 + i3;
                int i26 = this.value;
                byte[] bArr2 = this.output;
                int[] iArr = this.alphabet;
                int i27 = 0;
                int i28 = i26;
                int i29 = i18;
                int i36 = i3;
                while (i36 < i19) {
                    if (i29 == 0) {
                        while (true) {
                            int i37 = i36 + 4;
                            if (i37 > i19 || (i28 = iArr[bArr[i36 + 3] & 255] | (iArr[bArr[i36 + 1] & 255] << 12) | (iArr[bArr[i36] & 255] << 18) | (iArr[bArr[i36 + 2] & 255] << 6)) < 0) {
                                break;
                            }
                            bArr2[i27 + 2] = (byte) i28;
                            bArr2[i27 + 1] = (byte) (i28 >> 8);
                            bArr2[i27] = (byte) (i28 >> 16);
                            i27 += 3;
                            i36 = i37;
                        }
                        if (i36 >= i19) {
                            break;
                        }
                    }
                    int i38 = i36 + 1;
                    int i39 = iArr[bArr[i36] & 255];
                    if (i29 != 0) {
                        if (i29 != i17) {
                            if (i29 != 2) {
                                if (i29 != 3) {
                                    if (i29 != 4) {
                                        if (i29 == 5 && i39 != -1) {
                                            this.state = 6;
                                            return false;
                                        }
                                    } else if (i39 == -2) {
                                        i29++;
                                    } else if (i39 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                } else if (i39 >= 0) {
                                    int i46 = i39 | (i28 << 6);
                                    bArr2[i27 + 2] = (byte) i46;
                                    bArr2[i27 + 1] = (byte) (i46 >> 8);
                                    bArr2[i27] = (byte) (i46 >> 16);
                                    i27 += 3;
                                    i28 = i46;
                                    i29 = 0;
                                } else if (i39 == -2) {
                                    bArr2[i27 + 1] = (byte) (i28 >> 2);
                                    bArr2[i27] = (byte) (i28 >> 10);
                                    i27 += 2;
                                    i29 = 5;
                                } else if (i39 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i39 >= 0) {
                                i39 |= i28 << 6;
                                i29++;
                                i28 = i39;
                            } else if (i39 == -2) {
                                bArr2[i27] = (byte) (i28 >> 4);
                                i27++;
                                i29 = 4;
                            } else if (i39 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i39 >= 0) {
                            i39 |= i28 << 6;
                            i29++;
                            i28 = i39;
                        } else if (i39 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else {
                        if (i39 < 0) {
                            if (i39 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i29++;
                        i28 = i39;
                    }
                    i36 = i38;
                    i17 = 1;
                }
                if (!z16) {
                    this.state = i29;
                    this.value = i28;
                    this.f258933op = i27;
                    return true;
                }
                if (i29 != 1) {
                    if (i29 != 2) {
                        if (i29 != 3) {
                            if (i29 == 4) {
                                this.state = 6;
                                return false;
                            }
                        } else {
                            int i47 = i27 + 1;
                            bArr2[i27] = (byte) (i28 >> 10);
                            i27 = i47 + 1;
                            bArr2[i47] = (byte) (i28 >> 2);
                        }
                    } else {
                        bArr2[i27] = (byte) (i28 >> 4);
                        i27++;
                    }
                    this.state = i29;
                    this.f258933op = i27;
                    return true;
                }
                this.state = 6;
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes16.dex */
        public static class Encoder extends Coder {
            static final /* synthetic */ boolean $assertionsDisabled;
            static IPatchRedirector $redirector_ = null;
            private static final byte[] ENCODE;
            private static final byte[] ENCODE_WEBSAFE;
            public static final int LINE_GROUPS = 19;
            private final byte[] alphabet;
            private int count;
            public final boolean do_cr;
            public final boolean do_newline;
            public final boolean do_padding;
            private final byte[] tail;
            int tailLen;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12653);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 4)) {
                    redirector.redirect((short) 4);
                    return;
                }
                $assertionsDisabled = true;
                ENCODE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
                ENCODE_WEBSAFE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};
            }

            public Encoder(int i3, byte[] bArr) {
                boolean z16;
                boolean z17;
                byte[] bArr2;
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
                    return;
                }
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

            @Override // com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.Base64Helper.Coder
            public int maxOutputSize(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
                }
                return ((i3 * 8) / 5) + 10;
            }

            /* JADX WARN: Code restructure failed: missing block: B:31:0x0104, code lost:
            
                if (r19.do_cr == false) goto L38;
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0106, code lost:
            
                r9 = r4 + 1;
                r8[r4] = 13;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x010b, code lost:
            
                r8[r9] = 10;
                r11 = r2;
                r4 = r9 + 1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
            
                r8[r4] = 10;
                r11 = r2;
                r4 = r4 + 1;
             */
            @Override // com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.Base64Helper.Coder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean process(byte[] bArr, int i3, int i16, boolean z16) {
                int i17;
                int i18;
                int i19;
                int i26;
                byte b16;
                int i27;
                byte b17;
                boolean z17;
                int i28;
                byte b18;
                IPatchRedirector iPatchRedirector = $redirector_;
                int i29 = 5;
                int i36 = 0;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
                }
                byte[] bArr2 = this.alphabet;
                byte[] bArr3 = this.output;
                int i37 = this.count;
                int i38 = i16 + i3;
                int i39 = this.tailLen;
                if (i39 != 1) {
                    if (i39 == 2 && (i18 = i3 + 1) <= i38) {
                        byte[] bArr4 = this.tail;
                        i17 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i3] & 255);
                        this.tailLen = 0;
                    }
                    i18 = i3;
                    i17 = -1;
                } else {
                    if (i3 + 2 <= i38) {
                        int i46 = i3 + 1;
                        int i47 = i46 + 1;
                        i17 = (bArr[i46] & 255) | ((this.tail[0] & 255) << 16) | ((bArr[i3] & 255) << 8);
                        this.tailLen = 0;
                        i18 = i47;
                    }
                    i18 = i3;
                    i17 = -1;
                }
                if (i17 != -1) {
                    bArr3[0] = bArr2[(i17 >> 18) & 63];
                    bArr3[1] = bArr2[(i17 >> 12) & 63];
                    bArr3[2] = bArr2[(i17 >> 6) & 63];
                    bArr3[3] = bArr2[i17 & 63];
                    i37--;
                    if (i37 == 0) {
                        if (this.do_cr) {
                            bArr3[4] = 13;
                        } else {
                            i29 = 4;
                        }
                        i19 = i29 + 1;
                        bArr3[i29] = 10;
                        i37 = 19;
                    } else {
                        i19 = 4;
                    }
                } else {
                    i19 = 0;
                }
                while (true) {
                    int i48 = i18 + 3;
                    if (i48 <= i38) {
                        int i49 = (bArr[i18 + 2] & 255) | ((bArr[i18] & 255) << 16) | ((bArr[i18 + 1] & 255) << 8);
                        bArr3[i19] = bArr2[(i49 >> 18) & 63];
                        bArr3[i19 + 1] = bArr2[(i49 >> 12) & 63];
                        bArr3[i19 + 2] = bArr2[(i49 >> 6) & 63];
                        bArr3[i19 + 3] = bArr2[i49 & 63];
                        i19 += 4;
                        i37--;
                        if (i37 == 0) {
                            break;
                        }
                        i18 = i48;
                    } else {
                        if (z16) {
                            int i56 = this.tailLen;
                            if (i18 - i56 == i38 - 1) {
                                if (i56 > 0) {
                                    b18 = this.tail[0];
                                    i28 = 1;
                                } else {
                                    i28 = 0;
                                    b18 = bArr[i18];
                                    i18++;
                                }
                                int i57 = (b18 & 255) << 4;
                                this.tailLen = i56 - i28;
                                int i58 = i19 + 1;
                                bArr3[i19] = bArr2[(i57 >> 6) & 63];
                                i19 = i58 + 1;
                                bArr3[i58] = bArr2[i57 & 63];
                                if (this.do_padding) {
                                    int i59 = i19 + 1;
                                    bArr3[i19] = 61;
                                    i19 = i59 + 1;
                                    bArr3[i59] = 61;
                                }
                                if (this.do_newline) {
                                    if (this.do_cr) {
                                        bArr3[i19] = 13;
                                        i19++;
                                    }
                                    i26 = i19 + 1;
                                    bArr3[i19] = 10;
                                    i19 = i26;
                                }
                                z17 = $assertionsDisabled;
                                if (z17 && this.tailLen != 0) {
                                    throw new AssertionError();
                                }
                                if (!z17 && i18 != i38) {
                                    throw new AssertionError();
                                }
                            } else {
                                if (i18 - i56 == i38 - 2) {
                                    if (i56 > 1) {
                                        b16 = this.tail[0];
                                        i36 = 1;
                                    } else {
                                        int i65 = i18 + 1;
                                        byte b19 = bArr[i18];
                                        i18 = i65;
                                        b16 = b19;
                                    }
                                    int i66 = (b16 & 255) << 10;
                                    if (i56 > 0) {
                                        i27 = i36 + 1;
                                        b17 = this.tail[i36];
                                    } else {
                                        i27 = i36;
                                        b17 = bArr[i18];
                                        i18++;
                                    }
                                    int i67 = i66 | ((b17 & 255) << 2);
                                    this.tailLen = i56 - i27;
                                    int i68 = i19 + 1;
                                    bArr3[i19] = bArr2[(i67 >> 12) & 63];
                                    int i69 = i68 + 1;
                                    bArr3[i68] = bArr2[(i67 >> 6) & 63];
                                    int i75 = i69 + 1;
                                    bArr3[i69] = bArr2[i67 & 63];
                                    if (this.do_padding) {
                                        bArr3[i75] = 61;
                                        i75++;
                                    }
                                    if (this.do_newline) {
                                        if (this.do_cr) {
                                            bArr3[i75] = 13;
                                            i75++;
                                        }
                                        bArr3[i75] = 10;
                                        i75++;
                                    }
                                    i19 = i75;
                                } else if (this.do_newline && i19 > 0 && i37 != 19) {
                                    if (this.do_cr) {
                                        bArr3[i19] = 13;
                                        i19++;
                                    }
                                    i26 = i19 + 1;
                                    bArr3[i19] = 10;
                                    i19 = i26;
                                }
                                z17 = $assertionsDisabled;
                                if (z17) {
                                }
                                if (!z17) {
                                    throw new AssertionError();
                                }
                            }
                        } else if (i18 == i38 - 1) {
                            byte[] bArr5 = this.tail;
                            int i76 = this.tailLen;
                            this.tailLen = i76 + 1;
                            bArr5[i76] = bArr[i18];
                        } else if (i18 == i38 - 2) {
                            byte[] bArr6 = this.tail;
                            int i77 = this.tailLen;
                            int i78 = i77 + 1;
                            bArr6[i77] = bArr[i18];
                            this.tailLen = i78 + 1;
                            bArr6[i78] = bArr[i18 + 1];
                        }
                        this.f258933op = i19;
                        this.count = i37;
                        return true;
                    }
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12661);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                $assertionsDisabled = true;
            }
        }

        protected Base64Helper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
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
            if ($assertionsDisabled || encoder.f258933op == i18) {
                return encoder.output;
            }
            throw new AssertionError();
        }

        public static byte[] decode(byte[] bArr, int i3, int i16, int i17) {
            Decoder decoder = new Decoder(i17, new byte[(i16 * 3) / 4]);
            if (decoder.process(bArr, i3, i16, true)) {
                int i18 = decoder.f258933op;
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

    /* loaded from: classes16.dex */
    public static class PluginInfoParser extends DefaultHandler {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG_CUR_VERSION = "CurVersion";
        private static final String TAG_FINGER = "Finger";
        private static final String TAG_FORCE_URL = "ForceUrl";
        private static final String TAG_ID = "ID";
        private static final String TAG_INSTALLED_PATH = "InstalledPath";
        private static final String TAG_INSTALL_TYPE = "InstallType";
        private static final String TAG_LENGTH = "Length";
        private static final String TAG_MD5 = "MD5";
        private static final String TAG_NAME = "Name";
        private static final String TAG_PACKAGE_NAME = "PackageName";
        private static final String TAG_PATCH_DESC = "PatchDescription";
        private static final String TAG_PLUGIN_INFO = "PluginInfo";
        private static final String TAG_PROCESSES = "Processes";
        private static final String TAG_STATE = "State";
        private static final String TAG_SUB_TYPE = "SubType";
        private static final String TAG_TYPE = "Type";
        private static final String TAG_UPDATE_TYPE = "UpdateType";
        private static final String TAG_URL = "URL";
        private static final String TAG_VERSION = "Version";
        private StringBuilder mBuilder;
        private PluginBaseInfo mResult;
        private Class<? extends PluginBaseInfo> mResultClass;

        public PluginInfoParser() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static String pluginToXML(PluginBaseInfo pluginBaseInfo) throws Exception {
            String str;
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument("utf-8", null);
            newSerializer.startTag("", TAG_PLUGIN_INFO);
            newSerializer.startTag("", TAG_ID);
            newSerializer.text(pluginBaseInfo.mID);
            newSerializer.endTag("", TAG_ID);
            newSerializer.startTag("", TAG_NAME);
            newSerializer.text(pluginBaseInfo.mName);
            newSerializer.endTag("", TAG_NAME);
            newSerializer.startTag("", TAG_VERSION);
            newSerializer.text(pluginBaseInfo.mVersion);
            newSerializer.endTag("", TAG_VERSION);
            newSerializer.startTag("", "URL");
            newSerializer.text(pluginBaseInfo.mURL);
            newSerializer.endTag("", "URL");
            newSerializer.startTag("", "MD5");
            newSerializer.text(pluginBaseInfo.mMD5);
            newSerializer.endTag("", "MD5");
            newSerializer.startTag("", TAG_FINGER);
            newSerializer.text(pluginBaseInfo.mFingerPrint);
            newSerializer.endTag("", TAG_FINGER);
            newSerializer.startTag("", TAG_TYPE);
            newSerializer.text(String.valueOf(pluginBaseInfo.mType));
            newSerializer.endTag("", TAG_TYPE);
            newSerializer.startTag("", TAG_SUB_TYPE);
            newSerializer.text(String.valueOf(pluginBaseInfo.mSubType));
            newSerializer.endTag("", TAG_SUB_TYPE);
            newSerializer.startTag("", TAG_PACKAGE_NAME);
            newSerializer.text(pluginBaseInfo.mPackageName);
            newSerializer.endTag("", TAG_PACKAGE_NAME);
            newSerializer.startTag("", TAG_CUR_VERSION);
            newSerializer.text(String.valueOf(pluginBaseInfo.mCurVersion));
            newSerializer.endTag("", TAG_CUR_VERSION);
            newSerializer.startTag("", TAG_LENGTH);
            newSerializer.text(String.valueOf(pluginBaseInfo.mLength));
            newSerializer.endTag("", TAG_LENGTH);
            newSerializer.startTag("", TAG_STATE);
            newSerializer.text(String.valueOf(pluginBaseInfo.mState));
            newSerializer.endTag("", TAG_STATE);
            String[] strArr = pluginBaseInfo.mProcesses;
            if (strArr == null) {
                str = "";
            } else {
                str = "";
                for (String str2 : strArr) {
                    str = str + str2 + "|";
                }
            }
            newSerializer.startTag("", TAG_PROCESSES);
            newSerializer.text(str);
            newSerializer.endTag("", TAG_PROCESSES);
            newSerializer.startTag("", TAG_UPDATE_TYPE);
            newSerializer.text(String.valueOf(pluginBaseInfo.mUpdateType));
            newSerializer.endTag("", TAG_UPDATE_TYPE);
            newSerializer.startTag("", TAG_INSTALL_TYPE);
            newSerializer.text(String.valueOf(pluginBaseInfo.mInstallType));
            newSerializer.endTag("", TAG_INSTALL_TYPE);
            newSerializer.startTag("", TAG_INSTALLED_PATH);
            String str3 = pluginBaseInfo.mInstalledPath;
            if (str3 == null) {
                str3 = "";
            }
            newSerializer.text(str3);
            newSerializer.endTag("", TAG_INSTALLED_PATH);
            newSerializer.startTag("", TAG_PATCH_DESC);
            String str4 = pluginBaseInfo.mPatchDescription;
            if (str4 == null) {
                str4 = "";
            }
            newSerializer.text(str4);
            newSerializer.endTag("", TAG_PATCH_DESC);
            newSerializer.endTag("", TAG_PLUGIN_INFO);
            newSerializer.endDocument();
            return stringWriter.toString();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.mBuilder.append(cArr, i3, i16);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                this.mBuilder = null;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, str, str2, str3);
                return;
            }
            String sb5 = this.mBuilder.toString();
            if (TAG_ID.equals(str2)) {
                this.mResult.mID = sb5;
                return;
            }
            if (TAG_NAME.equals(str2)) {
                this.mResult.mName = sb5;
                return;
            }
            if (TAG_VERSION.equals(str2)) {
                this.mResult.mVersion = sb5;
                return;
            }
            if ("URL".equals(str2)) {
                this.mResult.mURL = sb5;
                return;
            }
            if ("MD5".equals(str2)) {
                this.mResult.mMD5 = sb5;
                return;
            }
            if (TAG_FINGER.equals(str2)) {
                this.mResult.mFingerPrint = sb5;
                return;
            }
            if (TAG_TYPE.equals(str2)) {
                this.mResult.mType = Integer.valueOf(sb5).intValue();
                return;
            }
            if (TAG_SUB_TYPE.equals(str2)) {
                this.mResult.mSubType = Integer.valueOf(sb5).intValue();
                return;
            }
            if (TAG_PACKAGE_NAME.equals(str2)) {
                this.mResult.mPackageName = sb5;
                return;
            }
            if (TAG_CUR_VERSION.equals(str2)) {
                this.mResult.mCurVersion = Long.parseLong(sb5);
                return;
            }
            if (TAG_LENGTH.equals(str2)) {
                this.mResult.mLength = Long.parseLong(sb5);
                return;
            }
            if (TAG_STATE.equals(str2)) {
                this.mResult.mState = Integer.parseInt(sb5);
                return;
            }
            if (TAG_PROCESSES.equals(str2)) {
                if (sb5 != null) {
                    this.mResult.mProcesses = sb5.split("\\|");
                    return;
                } else {
                    this.mResult.mProcesses = new String[0];
                    return;
                }
            }
            if (TAG_UPDATE_TYPE.equals(str2)) {
                this.mResult.mUpdateType = Integer.parseInt(sb5);
                return;
            }
            if (TAG_INSTALL_TYPE.equals(str2)) {
                this.mResult.mInstallType = Integer.parseInt(sb5);
                return;
            }
            if (TAG_INSTALLED_PATH.equals(str2)) {
                if (sb5 != null && sb5.length() != 0) {
                    this.mResult.mInstalledPath = sb5;
                    return;
                } else {
                    this.mResult.mInstalledPath = null;
                    return;
                }
            }
            if (TAG_FORCE_URL.equals(str2)) {
                if (sb5 != null && sb5.length() > 0) {
                    this.mResult.mForceUrl = 1;
                    return;
                }
                return;
            }
            if (TAG_PATCH_DESC.equals(str2)) {
                this.mResult.mPatchDescription = sb5;
            }
        }

        public PluginBaseInfo getResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PluginBaseInfo) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mResult;
        }

        public void setResultClass(Class<? extends PluginBaseInfo> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            } else {
                this.mResultClass = cls;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.mBuilder = new StringBuilder();
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, str3, attributes);
                return;
            }
            this.mBuilder.setLength(0);
            if (TAG_PLUGIN_INFO.equals(str2)) {
                try {
                    this.mResult = this.mResultClass.newInstance();
                } catch (Exception unused) {
                }
            }
        }
    }

    public PluginBaseInfoHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r2 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PluginBaseInfo createFromFile(File file, Class<? extends PluginBaseInfo> cls) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[(int) file.length()];
        FileInputStream fileInputStream2 = null;
        r1 = null;
        PluginBaseInfo pluginBaseInfo = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            fileInputStream.read(bArr);
            String str = new String(Base64Helper.decode(bArr, 0));
            PluginInfoParser pluginInfoParser = new PluginInfoParser();
            pluginInfoParser.setResultClass(cls);
            pluginBaseInfo = parseConfig(str, pluginInfoParser);
        } catch (Exception unused2) {
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused4) {
            return pluginBaseInfo;
        }
    }

    public static PluginBaseInfo parseConfig(String str, PluginInfoParser pluginInfoParser) {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(str.getBytes()), pluginInfoParser);
            return pluginInfoParser.getResult();
        } catch (Exception unused) {
            return null;
        }
    }
}
