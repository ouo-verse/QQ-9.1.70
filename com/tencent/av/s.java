package com.tencent.av;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import org.slf4j.Marker;
import tencent.im.cs.longconn.hd_video$CmdS2CInviteReqBody;
import tencent.im.cs.longconn.hd_video$InviteTempSessionData;
import tencent.im.cs.longconn.hd_video$MsgBody;
import tencent.im.cs.longconn.hd_video$VideoHead;

/* compiled from: P */
/* loaded from: classes3.dex */
public class s {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f74240a;

        /* renamed from: b, reason: collision with root package name */
        public String f74241b;

        /* renamed from: c, reason: collision with root package name */
        public long f74242c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f74243d = 0;

        /* renamed from: e, reason: collision with root package name */
        public long f74244e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f74245f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f74246g = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f74247h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f74248i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f74249j = false;

        /* renamed from: k, reason: collision with root package name */
        public int f74250k = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f74251l = 0;

        /* renamed from: m, reason: collision with root package name */
        public long f74252m = 0;

        public boolean a() {
            if (this.f74243d == 3) {
                return true;
            }
            return false;
        }

        public String toString() {
            boolean z16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("VideoPacket{roomId=");
            sb5.append(this.f74242c);
            sb5.append(", bodyType=");
            sb5.append(this.f74243d);
            sb5.append(", uin=");
            sb5.append(this.f74244e);
            sb5.append(", fromuin=");
            sb5.append(this.f74247h);
            sb5.append(", subServiceType=");
            sb5.append(this.f74245f);
            sb5.append(", seq=");
            sb5.append(this.f74246g);
            sb5.append(", business_flag=");
            sb5.append(this.f74248i);
            sb5.append(", terminal_switch_flag =");
            sb5.append(this.f74249j);
            sb5.append(", u32AccountType =");
            sb5.append(this.f74251l);
            sb5.append(", uint64_group_uin =");
            sb5.append(this.f74252m);
            sb5.append(", str_from_nation =");
            sb5.append(this.f74241b);
            sb5.append(", str_from_mobile =");
            if (this.f74240a != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", inviteScene =");
            sb5.append(this.f74250k);
            sb5.append('}');
            return sb5.toString();
        }
    }

    public static int a(byte[] bArr, int i3) {
        if (bArr.length != i3 || bArr.length > 4) {
            return 0;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 = (int) (i16 | ((bArr[i17] & 255) << (((i3 - i17) - 1) * 8)));
        }
        return i16;
    }

    public static long b(byte[] bArr, int i3) {
        long j3 = 0;
        if (bArr.length == i3 && bArr.length <= 8) {
            for (int i16 = 0; i16 < i3; i16++) {
                j3 |= (bArr[i16] & 255) << (((i3 - i16) - 1) * 8);
            }
        }
        return j3;
    }

    public static long c(byte[] bArr, int i3) {
        long j3 = 0;
        if (bArr.length == i3 && bArr.length <= 4) {
            for (int i16 = i3 - 1; i16 >= 0; i16--) {
                j3 |= (bArr[i16] & 255) << (i16 * 8);
            }
        }
        return j3;
    }

    public static long d(String str) {
        if (str == null || str.length() <= 0) {
            return 0L;
        }
        try {
            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                str = str.substring(1);
            }
            long g16 = com.tencent.av.utils.i.g(str);
            if (g16 < 10000) {
                return 0L;
            }
            return g16;
        } catch (NumberFormatException unused) {
            if (!QLog.isColorLevel()) {
                return 0L;
            }
            QLog.d("VideoPackageUtils", 2, "uin = " + str + " is error");
            return 0L;
        }
    }

    public static long e(int i3) {
        return i3 & 4294967295L;
    }

    public static a f(byte[] bArr) {
        int i3;
        a aVar = new a();
        try {
            hd_video$MsgBody mergeFrom = new hd_video$MsgBody().mergeFrom(bArr);
            if (mergeFrom.msg_video_head.has()) {
                hd_video$VideoHead hd_video_videohead = mergeFrom.msg_video_head.get();
                aVar.f74240a = hd_video_videohead.str_from_mobile.get();
                aVar.f74241b = hd_video_videohead.str_from_nation.get();
                aVar.f74243d = hd_video_videohead.enum_body_type.get();
                aVar.f74244e = hd_video_videohead.uint64_uin.get();
                if (hd_video_videohead.int32_sub_service_type.has()) {
                    i3 = hd_video_videohead.int32_sub_service_type.get();
                } else {
                    i3 = -1;
                }
                aVar.f74245f = i3;
                aVar.f74246g = hd_video_videohead.uint32_seq.get();
                aVar.f74242c = hd_video_videohead.uint64_room_id.get();
            } else if (QLog.isColorLevel()) {
                QLog.e(LogTag.TAG_NEARBY_VIDEO_MULTI_MSG, 2, " head not exist");
            }
            if (mergeFrom.msg_invite_body.has()) {
                hd_video$CmdS2CInviteReqBody hd_video_cmds2cinvitereqbody = mergeFrom.msg_invite_body.get();
                aVar.f74247h = hd_video_cmds2cinvitereqbody.uint64_from_uin.get();
                aVar.f74248i = hd_video_cmds2cinvitereqbody.uint32_new_business_flag.get();
                aVar.f74249j = hd_video_cmds2cinvitereqbody.bool_terminal_switch_flag.get();
                aVar.f74250k = hd_video_cmds2cinvitereqbody.uint32_invite_scene.get();
                if (QLog.isColorLevel()) {
                    QLog.e("VideoPackageUtils", 2, " inviteBody.uint32_invite_scene.has() " + hd_video_cmds2cinvitereqbody.uint32_invite_scene.has());
                }
                if (hd_video_cmds2cinvitereqbody.msg_temp_session.has()) {
                    hd_video$InviteTempSessionData hd_video_invitetempsessiondata = hd_video_cmds2cinvitereqbody.msg_temp_session;
                    aVar.f74252m = hd_video_invitetempsessiondata.uint64_group_uin.get();
                    aVar.f74251l = hd_video_invitetempsessiondata.uint32_relationship_type.get();
                }
            }
            QLog.d("VideoPackageUtils", 1, " --- parse video message " + aVar.toString());
        } catch (Exception e16) {
            QLog.e("VideoPackageUtils", 1, " invalid format:" + e16.toString());
        }
        return aVar;
    }
}
