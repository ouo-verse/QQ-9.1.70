package com.tencent.tmassistantbase.util;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f380435a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tmassistantbase.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static abstract class AbstractC9995a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f380436a;

        /* renamed from: b, reason: collision with root package name */
        public int f380437b;

        AbstractC9995a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b extends AbstractC9995a {

        /* renamed from: j, reason: collision with root package name */
        private static final byte[] f380438j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k, reason: collision with root package name */
        private static final byte[] f380439k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, MultipartStream.DASH, 95};

        /* renamed from: l, reason: collision with root package name */
        static final /* synthetic */ boolean f380440l = true;

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f380441c;

        /* renamed from: d, reason: collision with root package name */
        int f380442d;

        /* renamed from: e, reason: collision with root package name */
        private int f380443e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f380444f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f380445g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f380446h;

        /* renamed from: i, reason: collision with root package name */
        private final byte[] f380447i;

        public b(int i3, byte[] bArr) {
            boolean z16;
            boolean z17;
            byte[] bArr2;
            int i16;
            this.f380436a = bArr;
            if ((i3 & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f380444f = z16;
            if ((i3 & 2) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f380445g = z17;
            this.f380446h = (i3 & 4) != 0;
            if ((i3 & 8) == 0) {
                bArr2 = f380438j;
            } else {
                bArr2 = f380439k;
            }
            this.f380447i = bArr2;
            this.f380441c = new byte[2];
            this.f380442d = 0;
            if (z17) {
                i16 = 19;
            } else {
                i16 = -1;
            }
            this.f380443e = i16;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01cd A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 514
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantbase.util.a.b.a(byte[], int, int, boolean):boolean");
        }
    }

    a() {
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
        if (bVar.f380444f) {
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
        if (bVar.f380445g && i16 > 0) {
            i18 += (((i16 - 1) / 57) + 1) * (bVar.f380446h ? 2 : 1);
        }
        bVar.f380436a = new byte[i18];
        bVar.a(bArr, i3, i16, true);
        if (f380435a || bVar.f380437b == i18) {
            return bVar.f380436a;
        }
        throw new AssertionError();
    }
}
