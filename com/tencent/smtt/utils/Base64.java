package com.tencent.smtt.utils;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Base64 {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f369613a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f369614a;

        /* renamed from: b, reason: collision with root package name */
        public int f369615b;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f369616c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f369617d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e, reason: collision with root package name */
        private int f369618e;

        /* renamed from: f, reason: collision with root package name */
        private int f369619f;

        /* renamed from: g, reason: collision with root package name */
        private final int[] f369620g;

        public b(int i3, byte[] bArr) {
            int[] iArr;
            this.f369614a = bArr;
            if ((i3 & 8) == 0) {
                iArr = f369616c;
            } else {
                iArr = f369617d;
            }
            this.f369620g = iArr;
            this.f369618e = 0;
            this.f369619f = 0;
        }

        public boolean a(byte[] bArr, int i3, int i16, boolean z16) {
            int i17 = this.f369618e;
            if (i17 == 6) {
                return false;
            }
            int i18 = i16 + i3;
            int i19 = this.f369619f;
            byte[] bArr2 = this.f369614a;
            int[] iArr = this.f369620g;
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
                                        this.f369618e = 6;
                                        return false;
                                    }
                                } else if (i38 == -2) {
                                    i28++;
                                } else if (i38 != -1) {
                                    this.f369618e = 6;
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
                                this.f369618e = 6;
                                return false;
                            }
                        } else {
                            if (i38 < 0) {
                                if (i38 == -2) {
                                    bArr2[i26] = (byte) (i27 >> 4);
                                    i26++;
                                    i28 = 4;
                                } else if (i38 != -1) {
                                    this.f369618e = 6;
                                    return false;
                                }
                            }
                            i38 |= i27 << 6;
                        }
                    } else {
                        if (i38 < 0) {
                            if (i38 != -1) {
                                this.f369618e = 6;
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
                            this.f369618e = 6;
                            return false;
                        }
                    }
                    i28++;
                    i27 = i38;
                }
                i29 = i37;
            }
            if (!z16) {
                this.f369618e = i28;
                this.f369619f = i27;
                this.f369615b = i26;
                return true;
            }
            if (i28 != 1) {
                if (i28 != 2) {
                    if (i28 != 3) {
                        if (i28 == 4) {
                            this.f369618e = 6;
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
                this.f369618e = i28;
                this.f369615b = i26;
                return true;
            }
            this.f369618e = 6;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class c extends a {

        /* renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f369621g = true;

        /* renamed from: h, reason: collision with root package name */
        private static final byte[] f369622h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: i, reason: collision with root package name */
        private static final byte[] f369623i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

        /* renamed from: c, reason: collision with root package name */
        int f369624c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f369625d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f369626e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f369627f;

        /* renamed from: j, reason: collision with root package name */
        private final byte[] f369628j;

        /* renamed from: k, reason: collision with root package name */
        private int f369629k;

        /* renamed from: l, reason: collision with root package name */
        private final byte[] f369630l;

        public c(int i3, byte[] bArr) {
            boolean z16;
            boolean z17;
            byte[] bArr2;
            int i16;
            this.f369614a = bArr;
            if ((i3 & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f369625d = z16;
            if ((i3 & 2) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f369626e = z17;
            this.f369627f = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = f369622h;
            } else {
                bArr2 = f369623i;
            }
            this.f369630l = bArr2;
            this.f369628j = new byte[2];
            this.f369624c = 0;
            if (z17) {
                i16 = 19;
            } else {
                i16 = -1;
            }
            this.f369629k = i16;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 515
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Base64.c.a(byte[], int, int, boolean):boolean");
        }
    }

    Base64() {
    }

    public static byte[] a(String str, int i3) {
        return a(str.getBytes(), i3);
    }

    public static byte[] b(byte[] bArr, int i3) {
        return b(bArr, 0, bArr.length, i3);
    }

    public static String encodeToString(byte[] bArr, int i3) {
        try {
            return new String(b(bArr, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new AssertionError(e16);
        }
    }

    public static byte[] a(byte[] bArr, int i3) {
        return a(bArr, 0, bArr.length, i3);
    }

    public static byte[] b(byte[] bArr, int i3, int i16, int i17) {
        c cVar = new c(i17, null);
        int i18 = (i16 / 3) * 4;
        if (cVar.f369625d) {
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
        if (cVar.f369626e && i16 > 0) {
            i18 += (((i16 - 1) / 57) + 1) * (cVar.f369627f ? 2 : 1);
        }
        cVar.f369614a = new byte[i18];
        cVar.a(bArr, i3, i16, true);
        if (f369613a || cVar.f369615b == i18) {
            return cVar.f369614a;
        }
        throw new AssertionError();
    }

    public static byte[] a(byte[] bArr, int i3, int i16, int i17) {
        b bVar = new b(i17, new byte[(i16 * 3) / 4]);
        if (bVar.a(bArr, i3, i16, true)) {
            int i18 = bVar.f369615b;
            byte[] bArr2 = bVar.f369614a;
            if (i18 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i18];
            System.arraycopy(bArr2, 0, bArr3, 0, i18);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
