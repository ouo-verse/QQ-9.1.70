package com.tencent.luggage.wxa.yb;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f145501a = true;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yb.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static abstract class AbstractC6948a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f145502a;

        /* renamed from: b, reason: collision with root package name */
        public int f145503b;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends AbstractC6948a {

        /* renamed from: j, reason: collision with root package name */
        public static final byte[] f145504j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k, reason: collision with root package name */
        public static final byte[] f145505k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ boolean f145506l = true;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f145507c;

        /* renamed from: d, reason: collision with root package name */
        public int f145508d;

        /* renamed from: e, reason: collision with root package name */
        public int f145509e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f145510f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f145511g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f145512h;

        /* renamed from: i, reason: collision with root package name */
        public final byte[] f145513i;

        public b(int i3, byte[] bArr) {
            boolean z16;
            boolean z17;
            byte[] bArr2;
            int i16;
            this.f145502a = bArr;
            if ((i3 & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f145510f = z16;
            if ((i3 & 2) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f145511g = z17;
            this.f145512h = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = f145504j;
            } else {
                bArr2 = f145505k;
            }
            this.f145513i = bArr2;
            this.f145507c = new byte[2];
            this.f145508d = 0;
            if (z17) {
                i16 = 19;
            } else {
                i16 = -1;
            }
            this.f145509e = i16;
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
                Method dump skipped, instructions count: 513
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.wxa.yb.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(byte[] bArr, int i3) {
        return a(bArr, 0, bArr.length, i3);
    }

    public static String b(byte[] bArr, int i3) {
        try {
            return new String(a(bArr, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e16) {
            throw new AssertionError(e16);
        }
    }

    public static byte[] a(byte[] bArr, int i3, int i16, int i17) {
        b bVar = new b(i17, null);
        int i18 = (i16 / 3) * 4;
        if (bVar.f145510f) {
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
        if (bVar.f145511g && i16 > 0) {
            i18 += (((i16 - 1) / 57) + 1) * (bVar.f145512h ? 2 : 1);
        }
        bVar.f145502a = new byte[i18];
        bVar.a(bArr, i3, i16, true);
        if (f145501a || bVar.f145503b == i18) {
            return bVar.f145502a;
        }
        throw new AssertionError();
    }
}
