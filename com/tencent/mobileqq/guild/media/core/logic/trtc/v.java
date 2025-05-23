package com.tencent.mobileqq.guild.media.core.logic.trtc;

import com.tencent.mobileqq.guild.util.bw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.trtc.TRTCCloud;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final TRTCCloud f228598a;

    /* renamed from: b, reason: collision with root package name */
    private int f228599b = 2;

    public v(TRTCCloud tRTCCloud) {
        this.f228598a = tRTCCloud;
    }

    private void b(int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DTConstants.TAG.API, "enableAudioANS");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("enable", 1);
            jSONObject2.put("level", i3);
            jSONObject.put("params", jSONObject2);
            this.f228598a.callExperimentalAPI(jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public int a() {
        return this.f228599b;
    }

    public void c(int i3) {
        int i16;
        if (this.f228598a != null) {
            if (i3 == 4) {
                i16 = 120;
            } else {
                i16 = 100;
            }
            if (!com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228101i || com.tencent.mobileqq.guild.media.core.m.l(com.tencent.mobileqq.guild.media.core.j.c())) {
                i16 = 0;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.f228598a.setAudioCaptureVolume(i16);
                            bw.U1(120);
                            this.f228598a.setSystemVolumeType(1);
                            this.f228598a.setAudioQuality(1);
                            b(20);
                            return;
                        }
                        return;
                    }
                    this.f228598a.setAudioCaptureVolume(i16);
                    bw.U1(100);
                    this.f228598a.setSystemVolumeType(0);
                    this.f228598a.setAudioQuality(2);
                    b(100);
                    return;
                }
                this.f228598a.setAudioCaptureVolume(i16);
                bw.U1(100);
                this.f228598a.setSystemVolumeType(1);
                this.f228598a.setAudioQuality(2);
                b(40);
                return;
            }
            this.f228598a.setAudioCaptureVolume(i16);
            bw.U1(100);
            this.f228598a.setSystemVolumeType(2);
            this.f228598a.setAudioQuality(1);
            b(120);
        }
    }

    public void d(int i3) {
        if (this.f228598a != null) {
            if (i3 == 0) {
                if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 2) {
                    this.f228599b = 3;
                } else if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 6) {
                    this.f228599b = 4;
                } else if (com.tencent.mobileqq.guild.media.core.j.c().I() != null && com.tencent.mobileqq.guild.media.core.j.c().I().getPlayNodeExInfo().getPlayState() != 5) {
                    this.f228599b = 4;
                } else {
                    this.f228599b = 2;
                }
                if (com.tencent.mobileqq.guild.media.core.j.a().J0()) {
                    this.f228599b = 2;
                }
            } else {
                this.f228599b = i3;
            }
            c(this.f228599b);
            QLog.i("QGMC.TRTCAudioQualityAdapter", 1, "onEnterRoom startLocalAudio " + this.f228599b);
        }
    }
}
