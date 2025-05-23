package com.tencent.av.app;

import com.tencent.av.qav_gvideo_sdk_transfer$gVideoAcceptType;
import com.tencent.av.qav_gvideo_sdk_transfer$gVideoDownChannelControl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f73191b = false;

    /* renamed from: a, reason: collision with root package name */
    volatile HashMap<Long, Integer> f73190a = new HashMap<>();

    public static int d() {
        return com.tencent.av.utils.e.e(20);
    }

    public static boolean e() {
        return true;
    }

    public boolean a(long j3, int i3) {
        int d16 = d();
        if (d16 >= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("GVideoDownloadChannelControl", 2, "CheckUinIsBig Debug Mode DEBUG_SMALL_CHANNEL_NUM=" + d16);
            }
            if (i3 >= d16) {
                return true;
            }
            return false;
        }
        if (this.f73190a.containsKey(Long.valueOf(j3))) {
            if (this.f73190a.get(Long.valueOf(j3)).intValue() == 2) {
                return true;
            }
            return false;
        }
        return e();
    }

    public void b() {
        this.f73190a.clear();
        this.f73191b = false;
    }

    public boolean c(qav_gvideo_sdk_transfer$gVideoDownChannelControl qav_gvideo_sdk_transfer_gvideodownchannelcontrol) {
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("GVideoDownloadChannelControl", 2, "UpdateChannelCtlList start");
        }
        int d16 = d();
        if (qav_gvideo_sdk_transfer_gvideodownchannelcontrol == null) {
            return false;
        }
        if (qav_gvideo_sdk_transfer_gvideodownchannelcontrol.uint32_switch.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != this.f73191b) {
            this.f73191b = z16;
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16) {
            b();
            if (!z17 || d16 >= 0) {
                return false;
            }
            return true;
        }
        HashMap<Long, Integer> hashMap = new HashMap<>();
        int i3 = qav_gvideo_sdk_transfer_gvideodownchannelcontrol.uint32_videoacceptTypeSize.get();
        for (int i16 = 0; i16 < i3; i16++) {
            qav_gvideo_sdk_transfer$gVideoAcceptType qav_gvideo_sdk_transfer_gvideoaccepttype = qav_gvideo_sdk_transfer_gvideodownchannelcontrol.msg_video_accept_type.get(i16);
            long j3 = qav_gvideo_sdk_transfer_gvideoaccepttype.uint64_account.get();
            int i17 = qav_gvideo_sdk_transfer_gvideoaccepttype.video_type.get();
            if (QLog.isColorLevel()) {
                QLog.d("GVideoDownloadChannelControl", 2, "UpdateChannelCtlList index=" + i16 + " |uin=" + j3 + " |type=" + i17);
            }
            Integer num = this.f73190a.get(Long.valueOf(j3));
            if (num == null || num.intValue() != i17) {
                hashMap.put(Long.valueOf(j3), Integer.valueOf(i17));
                z17 = true;
            }
        }
        if (i3 != this.f73190a.size() || z17) {
            this.f73190a = hashMap;
        }
        if (!z17 || d16 >= 0) {
            return false;
        }
        return true;
    }
}
