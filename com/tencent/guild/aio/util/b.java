package com.tencent.guild.aio.util;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f112369a;

        /* renamed from: b, reason: collision with root package name */
        public int f112370b;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.guild.aio.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1216b extends a {

        /* renamed from: j, reason: collision with root package name */
        private static final byte[] f112371j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k, reason: collision with root package name */
        private static final byte[] f112372k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f112373c;

        /* renamed from: d, reason: collision with root package name */
        int f112374d;

        /* renamed from: e, reason: collision with root package name */
        private int f112375e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f112376f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f112377g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f112378h;

        /* renamed from: i, reason: collision with root package name */
        private final byte[] f112379i;

        public C1216b(int i3, byte[] bArr) {
            boolean z16;
            boolean z17;
            byte[] bArr2;
            int i16;
            this.f112369a = bArr;
            if ((i3 & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f112376f = z16;
            if ((i3 & 2) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f112377g = z17;
            this.f112378h = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = f112371j;
            } else {
                bArr2 = f112372k;
            }
            this.f112379i = bArr2;
            this.f112373c = new byte[2];
            this.f112374d = 0;
            if (z17) {
                i16 = 19;
            } else {
                i16 = -1;
            }
            this.f112375e = i16;
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
                Method dump skipped, instructions count: 479
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.guild.aio.util.b.C1216b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i3) {
        return b(bArr, 0, bArr.length, i3);
    }

    public static byte[] b(byte[] bArr, int i3, int i16, int i17) {
        C1216b c1216b = new C1216b(i17, null);
        int i18 = (i16 / 3) * 4;
        int i19 = 2;
        if (c1216b.f112376f) {
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
        if (c1216b.f112377g && i16 > 0) {
            int i27 = ((i16 - 1) / 57) + 1;
            if (!c1216b.f112378h) {
                i19 = 1;
            }
            i18 += i27 * i19;
        }
        c1216b.f112369a = new byte[i18];
        c1216b.a(bArr, i3, i16, true);
        return c1216b.f112369a;
    }

    public static String c(byte[] bArr, int i3) {
        try {
            return new String(a(bArr, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new AssertionError(e16);
        }
    }
}
