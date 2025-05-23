package com.qzone.proxy.feedcomponent.util;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f50879a;

        /* renamed from: b, reason: collision with root package name */
        public int f50880b;

        a() {
        }
    }

    public static byte[] a(String str, int i3) {
        return b(str.getBytes(), i3);
    }

    public static byte[] b(byte[] bArr, int i3) {
        return c(bArr, 0, bArr.length, i3);
    }

    public static byte[] c(byte[] bArr, int i3, int i16, int i17) {
        C0433b c0433b = new C0433b(i17, new byte[(i16 * 3) / 4]);
        if (c0433b.a(bArr, i3, i16, true)) {
            int i18 = c0433b.f50880b;
            byte[] bArr2 = c0433b.f50879a;
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
        if (cVar.f50891f) {
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
        if (cVar.f50892g && i16 > 0) {
            i18 += (((i16 - 1) / 57) + 1) * (cVar.f50893h ? 2 : 1);
        }
        cVar.f50879a = new byte[i18];
        cVar.a(bArr, i3, i16, true);
        return cVar.f50879a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.proxy.feedcomponent.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0433b extends a {

        /* renamed from: f, reason: collision with root package name */
        static final int[] f50881f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g, reason: collision with root package name */
        static final int[] f50882g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c, reason: collision with root package name */
        int f50883c;

        /* renamed from: d, reason: collision with root package name */
        int f50884d;

        /* renamed from: e, reason: collision with root package name */
        final int[] f50885e;

        public C0433b(int i3, byte[] bArr) {
            int[] iArr;
            this.f50879a = bArr;
            if ((i3 & 8) == 0) {
                iArr = f50881f;
            } else {
                iArr = f50882g;
            }
            this.f50885e = iArr;
            this.f50883c = 0;
            this.f50884d = 0;
        }

        public boolean a(byte[] bArr, int i3, int i16, boolean z16) {
            int i17 = this.f50883c;
            if (i17 == 6) {
                return false;
            }
            int i18 = i16 + i3;
            int i19 = this.f50884d;
            byte[] bArr2 = this.f50879a;
            int[] iArr = this.f50885e;
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
                    if (i28 == 1) {
                        if (i38 < 0) {
                            if (i38 != -1) {
                                this.f50883c = 6;
                                return false;
                            }
                        }
                        i38 |= i27 << 6;
                    } else if (i28 == 2) {
                        if (i38 < 0) {
                            if (i38 == -2) {
                                bArr2[i26] = (byte) (i27 >> 4);
                                i26++;
                                i28 = 4;
                            } else if (i38 != -1) {
                                this.f50883c = 6;
                                return false;
                            }
                        }
                        i38 |= i27 << 6;
                    } else if (i28 != 3) {
                        if (i28 != 4) {
                            if (i28 == 5 && i38 != -1) {
                                this.f50883c = 6;
                                return false;
                            }
                        } else if (i38 == -2) {
                            i28++;
                        } else if (i38 != -1) {
                            this.f50883c = 6;
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
                        this.f50883c = 6;
                        return false;
                    }
                    i28++;
                    i27 = i38;
                } else {
                    if (i38 < 0) {
                        if (i38 != -1) {
                            this.f50883c = 6;
                            return false;
                        }
                    }
                    i28++;
                    i27 = i38;
                }
                i29 = i37;
            }
            if (!z16) {
                this.f50883c = i28;
                this.f50884d = i27;
                this.f50880b = i26;
                return true;
            }
            if (i28 != 1) {
                if (i28 == 2) {
                    bArr2[i26] = (byte) (i27 >> 4);
                    i26++;
                } else if (i28 == 3) {
                    int i46 = i26 + 1;
                    bArr2[i26] = (byte) (i27 >> 10);
                    i26 = i46 + 1;
                    bArr2[i46] = (byte) (i27 >> 2);
                } else if (i28 == 4) {
                    this.f50883c = 6;
                    return false;
                }
                this.f50883c = i28;
                this.f50880b = i26;
                return true;
            }
            this.f50883c = 6;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c extends a {

        /* renamed from: j, reason: collision with root package name */
        static final byte[] f50886j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k, reason: collision with root package name */
        static final byte[] f50887k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

        /* renamed from: c, reason: collision with root package name */
        final byte[] f50888c;

        /* renamed from: d, reason: collision with root package name */
        int f50889d;

        /* renamed from: e, reason: collision with root package name */
        int f50890e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f50891f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f50892g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f50893h;

        /* renamed from: i, reason: collision with root package name */
        final byte[] f50894i;

        public c(int i3, byte[] bArr) {
            byte[] bArr2;
            this.f50879a = bArr;
            this.f50891f = (i3 & 1) == 0;
            boolean z16 = (i3 & 2) == 0;
            this.f50892g = z16;
            this.f50893h = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = f50886j;
            } else {
                bArr2 = f50887k;
            }
            this.f50894i = bArr2;
            this.f50888c = new byte[2];
            this.f50889d = 0;
            this.f50890e = z16 ? 19 : -1;
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
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 478
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qzone.proxy.feedcomponent.util.b.c.a(byte[], int, int, boolean):boolean");
        }
    }
}
