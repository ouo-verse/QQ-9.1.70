package com.qzone.publish.business.process;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.qzone.common.account.LoginData;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.i;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f implements com.qzone.publish.business.process.base.c {

    /* renamed from: a, reason: collision with root package name */
    public int f51054a;

    /* renamed from: b, reason: collision with root package name */
    public int f51055b;

    /* renamed from: c, reason: collision with root package name */
    public int f51056c;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f51058e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f51059f;

    /* renamed from: d, reason: collision with root package name */
    public int f51057d = 1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f51060g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f51061h = true;

    /* renamed from: i, reason: collision with root package name */
    private String f51062i = "";

    public f(boolean z16, boolean z17, boolean z18) {
        this.f51058e = z17;
        this.f51059f = z18;
        if (z16) {
            m();
        } else {
            l();
        }
    }

    public static int i(int i3) {
        if (i3 == 480) {
            return 100;
        }
        if (i3 == 540) {
            return 150;
        }
        if (i3 == 720 || i3 != 1080) {
            return 200;
        }
        return 300;
    }

    private boolean j() {
        boolean isHardwareAccelerated;
        if (this.f51058e) {
            return false;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_ENABLEH265ENCODER, 1) == 1) {
            if (this.f51059f) {
                QZLog.e("QZoneVideoParam", 1, "from mood open h265");
            } else if (!k()) {
                return false;
            }
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                String name = codecInfoAt.getName();
                if (codecInfoAt.isEncoder() && name.toLowerCase().contains("hevc")) {
                    if (Build.VERSION.SDK_INT < 29) {
                        return true;
                    }
                    isHardwareAccelerated = codecInfoAt.isHardwareAccelerated();
                    if (isHardwareAccelerated) {
                        return true;
                    }
                    QZLog.e("QZoneVideoParam", "Encoder is softEncoder");
                    return false;
                }
            }
        }
        return false;
    }

    private boolean k() {
        String config;
        long uin;
        try {
            config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_H265ENCODERGRAYUSERS, "1581405165");
            uin = LoginData.getInstance().getUin();
        } catch (Exception e16) {
            QZLog.e("QZoneVideoParam", "isGrayTarget error", e16);
        }
        if (config.contains(String.valueOf(uin))) {
            return true;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_H265ENCODERGRAYCONFIG, "0,0,1000").split(",").length == 3) {
            long parseInt = uin % Integer.parseInt(r0[2]);
            if (parseInt >= Integer.parseInt(r0[0])) {
                if (parseInt < Integer.parseInt(r0[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void l() {
        if (j()) {
            this.f51055b = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_H265VIDEORESOLUTION, 720);
            this.f51056c = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_H265VIDEOMAXFRAME, 30);
            this.f51054a = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_H265VIDEOMAXBITRATE, gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_WEBVIEW_INIT_START);
            this.f51057d = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_KEYFRAMEINTERVALDURATION, 2);
            this.f51060g = true;
            this.f51061h = false;
            return;
        }
        float config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_MAX_BITRATE_QCIRCLE_PUBLISH, 0.7f);
        this.f51055b = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_RESOLUTION_QCIRCLE_PUBLISH, 540);
        this.f51056c = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_FRAME_RATE_QCIRCLE_PUBLISH, 30);
        String[] split = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_NEWPARAM_ALL_QCIRCLE_PUBLISH, "0,720,1.5|540,0.7").split("\\|");
        boolean z16 = i.r().z() >= 0;
        try {
            if (split.length == 2) {
                String[] split2 = split[1].split(",");
                String[] split3 = split[0].split(",");
                if (split2.length == 2) {
                    this.f51055b = Integer.parseInt(split2[0]);
                    config = Float.parseFloat(split2[1]);
                }
                if (z16 && split3.length == 3) {
                    if (i.r().x() >= Integer.parseInt(split3[0])) {
                        this.f51055b = Integer.parseInt(split3[1]);
                        config = Float.parseFloat(split3[2]);
                    }
                }
            }
        } catch (Throwable th5) {
            QZLog.i("QZoneVideoParam", 1, "init config error=" + th5);
        }
        this.f51054a = (int) (config * 1048576.0f);
    }

    private void m() {
        this.f51055b = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_RESOLUTION_VIP_HIGH_QUALITY_QCIRCLE_PUBLISH, 1080);
        this.f51054a = (int) (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_MAX_BITRATE_VIP_HIGH_QUALITY_QCIRCLE_PUBLISH, 5.0f) * 1048576.0f);
        this.f51056c = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_FRAME_RATE_VIP_HIGH_QUALITY_QCIRCLE_PUBLISH, 30);
        if (j()) {
            this.f51060g = true;
            this.f51061h = false;
        }
    }

    @Override // com.qzone.publish.business.process.base.c
    public void a(String str) {
        this.f51062i = str;
    }

    @Override // com.qzone.publish.business.process.base.c
    public boolean b() {
        return this.f51060g;
    }

    @Override // com.qzone.publish.business.process.base.c
    public int c() {
        return this.f51054a;
    }

    @Override // com.qzone.publish.business.process.base.c
    public boolean d() {
        return this.f51061h;
    }

    @Override // com.qzone.publish.business.process.base.c
    public String e() {
        return this.f51062i;
    }

    @Override // com.qzone.publish.business.process.base.c
    public int f() {
        return this.f51055b;
    }

    @Override // com.qzone.publish.business.process.base.c
    public int g() {
        return this.f51056c;
    }

    @Override // com.qzone.publish.business.process.base.c
    public int h() {
        return this.f51057d;
    }

    public String toString() {
        return "QZoneQCircleVideoParam{videoMaxBitrate=" + this.f51054a + ", videoResolution=" + this.f51055b + ", frameRate=" + this.f51056c + ", iFrameInterval=" + this.f51057d + ", mFocusH264=" + this.f51058e + ", enableH265Encoder=" + this.f51060g + ", enableOriginVideo=" + this.f51061h + ", mOutVideoPath='" + this.f51062i + "'}";
    }
}
