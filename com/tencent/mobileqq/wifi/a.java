package com.tencent.mobileqq.wifi;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f317550a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wifi.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static abstract class AbstractC9005a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public byte[] f317551a;

        /* renamed from: b, reason: collision with root package name */
        public int f317552b;

        AbstractC9005a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends AbstractC9005a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        private static final int[] f317553f;

        /* renamed from: g, reason: collision with root package name */
        private static final int[] f317554g;

        /* renamed from: c, reason: collision with root package name */
        private int f317555c;

        /* renamed from: d, reason: collision with root package name */
        private int f317556d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f317557e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77405);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f317553f = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
                f317554g = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            }
        }

        public b(int i3, byte[] bArr) {
            int[] iArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
                return;
            }
            this.f317551a = bArr;
            if ((i3 & 8) == 0) {
                iArr = f317553f;
            } else {
                iArr = f317554g;
            }
            this.f317557e = iArr;
            this.f317555c = 0;
            this.f317556d = 0;
        }

        public boolean a(byte[] bArr, int i3, int i16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
            }
            int i18 = this.f317555c;
            if (i18 == 6) {
                return false;
            }
            int i19 = i16 + i3;
            int i26 = this.f317556d;
            byte[] bArr2 = this.f317551a;
            int[] iArr = this.f317557e;
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
                                        this.f317555c = 6;
                                        return false;
                                    }
                                } else if (i39 == -2) {
                                    i29++;
                                } else if (i39 != -1) {
                                    this.f317555c = 6;
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
                                this.f317555c = 6;
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
                            this.f317555c = 6;
                            return false;
                        }
                    } else if (i39 >= 0) {
                        i39 |= i28 << 6;
                        i29++;
                        i28 = i39;
                    } else if (i39 != -1) {
                        this.f317555c = 6;
                        return false;
                    }
                } else {
                    if (i39 < 0) {
                        if (i39 != -1) {
                            this.f317555c = 6;
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
                this.f317555c = i29;
                this.f317556d = i28;
                this.f317552b = i27;
                return true;
            }
            if (i29 != 1) {
                if (i29 != 2) {
                    if (i29 != 3) {
                        if (i29 == 4) {
                            this.f317555c = 6;
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
                this.f317555c = i29;
                this.f317552b = i27;
                return true;
            }
            this.f317555c = 6;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends AbstractC9005a {
        static IPatchRedirector $redirector_;

        /* renamed from: j, reason: collision with root package name */
        private static final byte[] f317558j;

        /* renamed from: k, reason: collision with root package name */
        private static final byte[] f317559k;

        /* renamed from: l, reason: collision with root package name */
        static final /* synthetic */ boolean f317560l;

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f317561c;

        /* renamed from: d, reason: collision with root package name */
        int f317562d;

        /* renamed from: e, reason: collision with root package name */
        private int f317563e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f317564f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f317565g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f317566h;

        /* renamed from: i, reason: collision with root package name */
        private final byte[] f317567i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77406);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            f317560l = true;
            f317558j = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            f317559k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};
        }

        public c(int i3, byte[] bArr) {
            boolean z16;
            boolean z17;
            byte[] bArr2;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) bArr);
                return;
            }
            this.f317551a = bArr;
            if ((i3 & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f317564f = z16;
            if ((i3 & 2) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f317565g = z17;
            this.f317566h = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = f317558j;
            } else {
                bArr2 = f317559k;
            }
            this.f317567i = bArr2;
            this.f317561c = new byte[2];
            this.f317562d = 0;
            if (z17) {
                i16 = 19;
            } else {
                i16 = -1;
            }
            this.f317563e = i16;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0104, code lost:
        
            if (r19.f317566h == false) goto L38;
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i3, int i16, boolean z16) {
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
            byte[] bArr2 = this.f317567i;
            byte[] bArr3 = this.f317551a;
            int i37 = this.f317563e;
            int i38 = i16 + i3;
            int i39 = this.f317562d;
            if (i39 != 1) {
                if (i39 == 2 && (i18 = i3 + 1) <= i38) {
                    byte[] bArr4 = this.f317561c;
                    i17 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i3] & 255);
                    this.f317562d = 0;
                }
                i18 = i3;
                i17 = -1;
            } else {
                if (i3 + 2 <= i38) {
                    int i46 = i3 + 1;
                    int i47 = i46 + 1;
                    i17 = (bArr[i46] & 255) | ((this.f317561c[0] & 255) << 16) | ((bArr[i3] & 255) << 8);
                    this.f317562d = 0;
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
                    if (this.f317566h) {
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
                        int i56 = this.f317562d;
                        if (i18 - i56 == i38 - 1) {
                            if (i56 > 0) {
                                b18 = this.f317561c[0];
                                i28 = 1;
                            } else {
                                i28 = 0;
                                b18 = bArr[i18];
                                i18++;
                            }
                            int i57 = (b18 & 255) << 4;
                            this.f317562d = i56 - i28;
                            int i58 = i19 + 1;
                            bArr3[i19] = bArr2[(i57 >> 6) & 63];
                            i19 = i58 + 1;
                            bArr3[i58] = bArr2[i57 & 63];
                            if (this.f317564f) {
                                int i59 = i19 + 1;
                                bArr3[i19] = 61;
                                i19 = i59 + 1;
                                bArr3[i59] = 61;
                            }
                            if (this.f317565g) {
                                if (this.f317566h) {
                                    bArr3[i19] = 13;
                                    i19++;
                                }
                                i26 = i19 + 1;
                                bArr3[i19] = 10;
                                i19 = i26;
                            }
                            z17 = f317560l;
                            if (z17 && this.f317562d != 0) {
                                throw new AssertionError();
                            }
                            if (!z17 && i18 != i38) {
                                throw new AssertionError();
                            }
                        } else {
                            if (i18 - i56 == i38 - 2) {
                                if (i56 > 1) {
                                    b16 = this.f317561c[0];
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
                                    b17 = this.f317561c[i36];
                                } else {
                                    i27 = i36;
                                    b17 = bArr[i18];
                                    i18++;
                                }
                                int i67 = i66 | ((b17 & 255) << 2);
                                this.f317562d = i56 - i27;
                                int i68 = i19 + 1;
                                bArr3[i19] = bArr2[(i67 >> 12) & 63];
                                int i69 = i68 + 1;
                                bArr3[i68] = bArr2[(i67 >> 6) & 63];
                                int i75 = i69 + 1;
                                bArr3[i69] = bArr2[i67 & 63];
                                if (this.f317564f) {
                                    bArr3[i75] = 61;
                                    i75++;
                                }
                                if (this.f317565g) {
                                    if (this.f317566h) {
                                        bArr3[i75] = 13;
                                        i75++;
                                    }
                                    bArr3[i75] = 10;
                                    i75++;
                                }
                                i19 = i75;
                            } else if (this.f317565g && i19 > 0 && i37 != 19) {
                                if (this.f317566h) {
                                    bArr3[i19] = 13;
                                    i19++;
                                }
                                i26 = i19 + 1;
                                bArr3[i19] = 10;
                                i19 = i26;
                            }
                            z17 = f317560l;
                            if (z17) {
                            }
                            if (!z17) {
                                throw new AssertionError();
                            }
                        }
                    } else if (i18 == i38 - 1) {
                        byte[] bArr5 = this.f317561c;
                        int i76 = this.f317562d;
                        this.f317562d = i76 + 1;
                        bArr5[i76] = bArr[i18];
                    } else if (i18 == i38 - 2) {
                        byte[] bArr6 = this.f317561c;
                        int i77 = this.f317562d;
                        int i78 = i77 + 1;
                        bArr6[i77] = bArr[i18];
                        this.f317562d = i78 + 1;
                        bArr6[i78] = bArr[i18 + 1];
                    }
                    this.f317552b = i19;
                    this.f317563e = i37;
                    return true;
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f317550a = true;
        }
    }

    public static byte[] a(String str, int i3) {
        return b(str.getBytes(), i3);
    }

    public static byte[] b(byte[] bArr, int i3) {
        return c(bArr, 0, bArr.length, i3);
    }

    public static byte[] c(byte[] bArr, int i3, int i16, int i17) {
        b bVar = new b(i17, new byte[(i16 * 3) / 4]);
        if (bVar.a(bArr, i3, i16, true)) {
            int i18 = bVar.f317552b;
            byte[] bArr2 = bVar.f317551a;
            if (i18 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i18];
            System.arraycopy(bArr2, 0, bArr3, 0, i18);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] d(byte[] bArr, int i3) {
        return e(bArr, 0, bArr.length, i3);
    }

    public static byte[] e(byte[] bArr, int i3, int i16, int i17) {
        c cVar = new c(i17, null);
        int i18 = (i16 / 3) * 4;
        int i19 = 2;
        if (cVar.f317564f) {
            if (i16 % 3 > 0) {
                i18 += 4;
            }
        } else {
            int i26 = i16 % 3;
            if (i26 != 1) {
                if (i26 == 2) {
                    i18 += 3;
                }
            } else {
                i18 += 2;
            }
        }
        if (cVar.f317565g && i16 > 0) {
            int i27 = ((i16 - 1) / 57) + 1;
            if (!cVar.f317566h) {
                i19 = 1;
            }
            i18 += i27 * i19;
        }
        cVar.f317551a = new byte[i18];
        cVar.a(bArr, i3, i16, true);
        if (!f317550a && cVar.f317552b != i18) {
            throw new AssertionError();
        }
        return cVar.f317551a;
    }

    public static String f(byte[] bArr, int i3) {
        try {
            return new String(d(bArr, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new AssertionError(e16);
        }
    }
}
