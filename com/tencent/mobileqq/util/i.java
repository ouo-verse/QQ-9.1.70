package com.tencent.mobileqq.util;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f306758a;

        /* renamed from: b, reason: collision with root package name */
        public int f306759b;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends a {

        /* renamed from: f, reason: collision with root package name */
        private static final int[] f306760f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g, reason: collision with root package name */
        private static final int[] f306761g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: h, reason: collision with root package name */
        private static final int[] f306762h = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8, -1, -1, 18, 37, 21, 41, 20, 49, 4, 13, 39, 22, -1, -1, -1, -2, -1, -1, -1, 50, 47, 24, 15, 36, 56, 46, 26, 9, 31, 19, 1, 61, 14, 27, 52, 25, 58, 28, 38, 30, 29, 60, 63, 6, 45, -1, -1, -1, -1, 2, -1, 17, 43, 32, 62, 3, 59, 44, 23, 51, 34, 53, 55, 33, 0, 12, 11, 57, 5, 54, 40, 7, 16, 35, 10, 42, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c, reason: collision with root package name */
        private int f306763c;

        /* renamed from: d, reason: collision with root package name */
        private int f306764d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f306765e;

        public b(int i3, byte[] bArr) {
            int[] iArr;
            this.f306758a = bArr;
            if ((i3 & 8) == 0) {
                iArr = f306760f;
            } else {
                iArr = f306762h;
            }
            this.f306765e = iArr;
            this.f306763c = 0;
            this.f306764d = 0;
        }

        public boolean a(byte[] bArr, int i3, int i16, boolean z16) {
            int i17 = this.f306763c;
            if (i17 == 6) {
                return false;
            }
            int i18 = i16 + i3;
            int i19 = this.f306764d;
            byte[] bArr2 = this.f306758a;
            int[] iArr = this.f306765e;
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
                                        this.f306763c = 6;
                                        return false;
                                    }
                                } else if (i38 == -2) {
                                    i28++;
                                } else if (i38 != -1) {
                                    this.f306763c = 6;
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
                                this.f306763c = 6;
                                return false;
                            }
                        } else {
                            if (i38 < 0) {
                                if (i38 == -2) {
                                    bArr2[i26] = (byte) (i27 >> 4);
                                    i26++;
                                    i28 = 4;
                                } else if (i38 != -1) {
                                    this.f306763c = 6;
                                    return false;
                                }
                            }
                            i38 |= i27 << 6;
                        }
                    } else {
                        if (i38 < 0) {
                            if (i38 != -1) {
                                this.f306763c = 6;
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
                            this.f306763c = 6;
                            return false;
                        }
                    }
                    i28++;
                    i27 = i38;
                }
                i29 = i37;
            }
            if (!z16) {
                this.f306763c = i28;
                this.f306764d = i27;
                this.f306759b = i26;
                return true;
            }
            if (i28 != 1) {
                if (i28 != 2) {
                    if (i28 != 3) {
                        if (i28 == 4) {
                            this.f306763c = 6;
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
                this.f306763c = i28;
                this.f306759b = i26;
                return true;
            }
            this.f306763c = 6;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends a {

        /* renamed from: j, reason: collision with root package name */
        private static final byte[] f306766j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k, reason: collision with root package name */
        private static final byte[] f306767k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

        /* renamed from: l, reason: collision with root package name */
        private static final byte[] f306768l = {Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 76, 95, 101, 54, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, 89, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, MultipartStream.DASH, 73, 120, PublicAccountH5AbilityPluginImpl.OPENCAMERA, PublicAccountH5AbilityPluginImpl.OPENIMG, 55, 78, 68, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 97, 48, 75, 52, 50, 57, 104, 67, 81, 72, 79, 83, 86, 85, 74, 99, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, 106, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 69, 49, 84, 56, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 51, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 103, 90, 71, 66, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 53, 65, 105, 80, 107, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 70, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, 82, 102, 87, 77, 100, 88};

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f306769c;

        /* renamed from: d, reason: collision with root package name */
        int f306770d;

        /* renamed from: e, reason: collision with root package name */
        private int f306771e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f306772f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f306773g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f306774h;

        /* renamed from: i, reason: collision with root package name */
        private final byte[] f306775i;

        public c(int i3, byte[] bArr) {
            boolean z16;
            boolean z17;
            byte[] bArr2;
            int i16;
            this.f306758a = bArr;
            if ((i3 & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f306772f = z16;
            if ((i3 & 2) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f306773g = z17;
            this.f306774h = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = f306766j;
            } else {
                bArr2 = f306768l;
            }
            this.f306775i = bArr2;
            this.f306769c = new byte[2];
            this.f306770d = 0;
            if (z17) {
                i16 = 19;
            } else {
                i16 = -1;
            }
            this.f306771e = i16;
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.util.i.c.a(byte[], int, int, boolean):boolean");
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
            int i18 = bVar.f306759b;
            byte[] bArr2 = bVar.f306758a;
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
        if (cVar.f306772f) {
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
        if (cVar.f306773g && i16 > 0) {
            int i27 = ((i16 - 1) / 57) + 1;
            if (!cVar.f306774h) {
                i19 = 1;
            }
            i18 += i27 * i19;
        }
        cVar.f306758a = new byte[i18];
        cVar.a(bArr, i3, i16, true);
        return cVar.f306758a;
    }

    public static String f(byte[] bArr, int i3) {
        try {
            return new String(d(bArr, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new AssertionError(e16);
        }
    }
}
