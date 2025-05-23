package com.tencent.luggage.wxa.t9;

import com.tencent.luggage.wxa.tn.b1;
import com.tencent.luggage.wxa.tn.p0;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v1008 */
    /* JADX WARN: Type inference failed for: r2v1009 */
    /* JADX WARN: Type inference failed for: r2v1010 */
    /* JADX WARN: Type inference failed for: r2v327 */
    /* JADX WARN: Type inference failed for: r2v550 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v933 */
    /* JADX WARN: Type inference failed for: r2v937 */
    public boolean a(String str, j jVar, d dVar, c cVar, e eVar, t tVar, z zVar, n nVar, q qVar, w wVar, p pVar, b bVar, p pVar2) {
        Exception exc;
        int i3;
        c cVar2;
        boolean z16;
        e eVar2;
        t tVar2;
        z zVar2;
        boolean z17;
        boolean z18;
        int a16;
        int a17;
        int a18;
        int a19;
        int a26;
        int a27;
        int a28;
        int a29;
        int a36;
        int a37;
        int a38;
        int a39;
        int a46;
        int a47;
        int a48;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        String str2 = "MicroMsg.DeviceInfoParser";
        try {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.DeviceInfoParser", "xml: " + str);
            Map a49 = b1.a(str, "deviceinfoconfig", null);
            if (a49 == null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "hy: null device config");
                return false;
            }
            if (a49.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                z19 = false;
                try {
                    jVar.f141062b = w0.a((String) a49.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                    jVar.f141061a = true;
                } catch (Exception e16) {
                    e = e16;
                    exc = e;
                    i3 = z19;
                    com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                    return i3;
                }
            }
            if (a49.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                z17 = false;
                try {
                    jVar.f141063c = w0.a((String) a49.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                    jVar.f141061a = true;
                } catch (Exception e17) {
                    exc = e17;
                    i3 = z17;
                    com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                    return i3;
                }
            }
            if (a49.get(".deviceinfoconfig.voip.camera.num") != null) {
                dVar.f140961a = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.num"), 0);
                dVar.f140962b = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.surface") != null) {
                dVar.f140963c = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.surface"), 0);
                dVar.f140964d = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.format") != null) {
                dVar.f140967g = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.format"), 0);
                dVar.f140968h = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.autofloatcamera") != null) {
                dVar.f140965e = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.autofloatcamera"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
                dVar.f140966f = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                dVar.f140971k.f140987a = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                dVar.f140972l = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                dVar.f140971k.f140988b = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                dVar.f140972l = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                dVar.f140971k.f140989c = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                dVar.f140972l = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                dVar.f140971k.f140990d = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                dVar.f140972l = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                dVar.f140971k.f140991e = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                dVar.f140972l = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                dVar.f140971k.f140992f = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                dVar.f140972l = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                dVar.f140971k.f140993g = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                dVar.f140972l = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                dVar.f140969i.f140987a = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                dVar.f140970j = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                dVar.f140969i.f140988b = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                dVar.f140970j = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                dVar.f140969i.f140989c = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                dVar.f140970j = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                dVar.f140969i.f140990d = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                dVar.f140970j = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                dVar.f140969i.f140991e = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                dVar.f140970j = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                dVar.f140969i.f140992f = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                dVar.f140970j = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                dVar.f140969i.f140993g = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                dVar.f140970j = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                dVar.f140974n = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                dVar.f140973m = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                dVar.f140975o = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                dVar.f140973m = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                dVar.f140976p = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                dVar.f140973m = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                dVar.f140977q = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                dVar.f140973m = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                dVar.f140978r = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                dVar.f140979s = true;
                dVar.f140973m = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                dVar.f140981u = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                z27 = false;
                try {
                    dVar.f140980t = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
                } catch (Exception e18) {
                    exc = e18;
                    i3 = z27;
                    com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                    return i3;
                }
            }
            if (a49.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                dVar.f140982v = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                dVar.f140983w = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                dVar.K = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                dVar.L = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                dVar.f140978r = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                dVar.f140979s = true;
                dVar.f140973m = true;
            }
            if (a49.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                z26 = false;
                try {
                    dVar.f140981u = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
                } catch (Exception e19) {
                    exc = e19;
                    i3 = z26;
                    com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                    return i3;
                }
            }
            if (a49.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                dVar.f140980t = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                dVar.f140984x = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                dVar.f140985y = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                dVar.f140986z = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                dVar.A = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                dVar.B = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                dVar.C = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                dVar.E = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                dVar.F = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                dVar.G = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                dVar.H = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
                dVar.M = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.voipBeautyWhite") != null) {
                dVar.N = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.voipBeautyWhite"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.enable720cap") != null) {
                dVar.I = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.enable720cap"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.mEnc720pCfg") != null) {
                dVar.J = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.mEnc720pCfg"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.stFilter") != null) {
                dVar.O = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.stFilter"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.stFilteroff") != null) {
                dVar.P = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.stFilteroff"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
                dVar.Q = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
                dVar.R = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
                dVar.S = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
            }
            if (a49.get(".deviceinfoconfig.voip.camera.sharpenFilter") != null) {
                dVar.T = w0.a((String) a49.get(".deviceinfoconfig.voip.camera.sharpenFilter"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                z16 = false;
                try {
                    cVar2 = cVar;
                    cVar2.f140910b = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                    cVar2.f140907a = true;
                } catch (Exception e26) {
                    exc = e26;
                    i3 = z16;
                    com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                    return i3;
                }
            } else {
                cVar2 = cVar;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.smode") != null) {
                cVar2.f140913c = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.smode"), 0);
                cVar2.f140907a = true;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.omode") != null) {
                cVar2.f140915d = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.omode"), 0);
                cVar2.f140907a = true;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                cVar2.f140917e = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                cVar2.f140907a = true;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.operating") != null) {
                cVar2.f140919f = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.operating"), 0);
                cVar2.f140907a = true;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                cVar2.f140921g = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                cVar2.f140907a = true;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                cVar2.f140923h = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                cVar2.f140907a = true;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                cVar2.f140925i = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                cVar2.f140927j = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                cVar2.f140929k = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                cVar2.f140931l = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                cVar2.f140933m = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                cVar2.D = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                cVar2.C = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                cVar2.E = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                cVar2.F = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                cVar2.G = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                cVar2.H = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                cVar2.I = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                cVar2.K = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                cVar2.L = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                cVar2.M = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                cVar2.N = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                cVar2.O = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                cVar2.P = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.nsModeNewMulti") != null) {
                cVar2.Q = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.nsModeNewMulti"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.voipfullbandcfg") != null) {
                cVar2.R = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.voipfullbandcfg"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                cVar2.S = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                cVar2.T = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                cVar2.U = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                cVar2.V = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcspkgaindb") != null) {
                cVar2.Y = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcspkgaindb"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcphngaindb") != null) {
                cVar2.Z = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcphngaindb"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agchdsgaindb") != null) {
                cVar2.f140908a0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agchdsgaindb"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.playvolvoip") != null) {
                cVar2.f140911b0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.playvolvoip"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.playvolmt") != null) {
                cVar2.f140914c0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.playvolmt"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                cVar2.W = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                cVar2.X = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcCompRatio") != null) {
                cVar2.f140916d0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcCompRatio"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcDnGainThr") != null) {
                cVar2.f140918e0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcDnGainThr"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcMode") != null) {
                cVar2.f140920f0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain") != null) {
                cVar2.f140922g0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain") != null) {
                cVar2.f140924h0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain") != null) {
                cVar2.f140926i0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcCRatio") != null) {
                cVar2.f140930k0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcCRatio"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR") != null) {
                cVar2.f140932l0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcTarget") != null) {
                cVar2.f140928j0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcTarget"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcBase") != null) {
                cVar2.f140934m0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcBase"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR") != null) {
                cVar2.f140936n0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR") != null) {
                cVar2.f140938o0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.waveAgcDamper") != null) {
                cVar2.f140940p0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.waveAgcDamper"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                cVar2.f140935n = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                cVar2.f140937o = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                cVar2.f140939p = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                cVar2.f140941q = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                cVar2.f140955x = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                cVar2.f140957y = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                cVar2.f140959z = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                cVar2.A = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                cVar2.f140942q0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                cVar2.f140944r0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                cVar2.f140948t0[0] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                cVar2.f140948t0[1] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                cVar2.f140948t0[2] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                cVar2.f140948t0[3] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                cVar2.f140948t0[4] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                cVar2.f140948t0[5] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                cVar2.f140948t0[6] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                cVar2.f140948t0[7] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                cVar2.f140948t0[8] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                cVar2.f140948t0[9] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                cVar2.f140948t0[10] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                cVar2.f140948t0[11] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                cVar2.f140948t0[12] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                cVar2.f140948t0[13] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                cVar2.f140948t0[14] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                cVar2.f140946s0 = 1;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.correctoff") != null && w0.a((String) a49.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                cVar2.f140946s0 = 0;
            }
            if (a49.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                cVar2.f140943r = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                cVar2.f140945s = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                cVar2.f140950u0[0] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                cVar2.f140950u0[1] = (short) w0.a((String) a49.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                cVar2.E0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                cVar2.F0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                cVar2.G0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                cVar2.H0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                cVar2.f140954w0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
                cVar2.B = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                z19 = false;
                cVar2.f140927j = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dFlag") != null) {
                cVar2.I0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dFlag"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim1") != null) {
                cVar2.J0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim1"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim2") != null) {
                cVar2.K0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim2"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim3") != null) {
                cVar2.L0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim3"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim4") != null) {
                cVar2.M0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim4"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim5") != null) {
                cVar2.N0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim5"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim6") != null) {
                cVar2.O0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim6"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim7") != null) {
                cVar2.P0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim7"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dAzim8") != null) {
                cVar2.Q0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dAzim8"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl1") != null) {
                cVar2.R0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl1"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl2") != null) {
                cVar2.S0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl2"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl3") != null) {
                cVar2.T0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl3"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl4") != null) {
                cVar2.U0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl4"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl5") != null) {
                cVar2.V0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl5"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl6") != null) {
                cVar2.W0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl6"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl7") != null) {
                cVar2.X0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl7"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dElvl8") != null) {
                cVar2.Y0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dElvl8"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.forbiddenUseSco") != null) {
                cVar2.f140947t = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.forbidSco"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.audioForbiddenStrategy") != null) {
                cVar2.f140949u = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.audioForbiddenStrategy"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.audioForbiddenRefreshTime") != null) {
                cVar2.f140951v = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.audioForbiddenRefreshTime"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.audioForbiddenRequestTimes") != null) {
                cVar2.f140953w = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.audioForbiddenRequestTimes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dPhi") != null) {
                cVar2.Z0 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dPhi"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dTheta1") != null) {
                cVar2.f140909a1 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dTheta1"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.audio.mt3dTheta2") != null) {
                cVar2.f140912b1 = w0.a((String) a49.get(".deviceinfoconfig.voip.audio.mt3dTheta2"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                cVar2.f140958y0 = w0.a((String) a49.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                cVar2.f140956x0 = true;
            }
            if (a49.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                cVar2.f140960z0 = w0.a((String) a49.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                cVar2.f140956x0 = true;
            }
            if (a49.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                cVar2.A0 = w0.a((String) a49.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                cVar2.f140956x0 = true;
            }
            if (a49.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                cVar2.B0 = w0.a((String) a49.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                cVar2.f140956x0 = true;
            }
            if (a49.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                cVar2.C0 = w0.a((String) a49.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                cVar2.f140956x0 = true;
            }
            if (a49.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                cVar2.D0 = w0.a((String) a49.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                cVar2.f140956x0 = true;
            }
            if (a49.get(".deviceinfoconfig.voip.common.js") != null) {
                eVar2 = eVar;
                eVar2.f141011i = true;
                eVar2.f141013j = w0.a((String) a49.get(".deviceinfoconfig.voip.common.js"), 0);
            } else {
                eVar2 = eVar;
            }
            if (a49.get(".deviceinfoconfig.voip.common.js") != null) {
                eVar2.f140995a = w0.a((String) a49.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                eVar2.f140997b = w0.a((String) a49.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                eVar2.f140999c = w0.a((String) a49.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                eVar2.f141003e = w0.a((String) a49.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                eVar2.f141001d = w0.a((String) a49.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                eVar2.f141005f = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                eVar2.f141009h = w0.a((String) a49.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                eVar2.f141007g = w0.a((String) a49.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.app") != null) {
                eVar2.f141015k = w0.a((String) a49.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                eVar2.O = w0.a((String) a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                eVar2.P = w0.a((String) a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                eVar2.Q = w0.a((String) a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                eVar2.R = w0.a((String) a49.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipnewrenderer") != null) {
                eVar2.S = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipnewrenderer"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipUseRemovePreviewCallback") != null) {
                eVar2.Z = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipUseRemovePreviewCallback"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipForceUseEncodeMode") != null) {
                eVar2.f140996a0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipForceUseEncodeMode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipFaceBeautyUseHighRank") != null) {
                eVar2.f140998b0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipFaceBeautyUseHighRank"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipUseCameraApi2") != null) {
                eVar2.f141000c0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipUseCameraApi2"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipUseNewCameraModular") != null) {
                eVar2.f141002d0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipUseNewCameraModular"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv") != null) {
                eVar2.f141004e0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.voipgpucrop") != null) {
                eVar2.f141006f0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.voipgpucrop"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.groupRs") != null) {
                eVar2.N = w0.a((String) a49.get(".deviceinfoconfig.voip.common.groupRs"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                eVar2.f141017l = w0.a((String) a49.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                eVar2.f141019m = w0.a((String) a49.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                eVar2.f141021n = w0.a((String) a49.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                eVar2.f141023o = w0.a((String) a49.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.linespe") != null) {
                eVar2.f141025p = w0.a((String) a49.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                eVar2.A = w0.a((String) a49.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                eVar2.f141027q = w0.a((String) a49.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                eVar2.f141029r = w0.a((String) a49.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                eVar2.f141031s = w0.a((String) a49.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                eVar2.f141037v = w0.a((String) a49.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                eVar2.f141035u = w0.a((String) a49.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                eVar2.f141039w = w0.a((String) a49.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                z18 = false;
                try {
                    eVar2.f141041x = w0.a((String) a49.get(".deviceinfoconfig.voip.common.qrcam"), 0);
                } catch (Exception e27) {
                    exc = e27;
                    i3 = z18;
                    com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                    return i3;
                }
            }
            if (a49.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                eVar2.f141033t = w0.a((String) a49.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                eVar2.f141039w = w0.a((String) a49.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                eVar2.f141041x = w0.a((String) a49.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.base") != null) {
                eVar2.f141008g0 = (String) a49.get(".deviceinfoconfig.voip.common.base");
            }
            if (a49.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                eVar2.f141010h0 = (String) a49.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (a49.get(".deviceinfoconfig.voip.common.classloader") != null) {
                eVar2.f141012i0 = (String) a49.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (a49.get(".deviceinfoconfig.voip.common.resources") != null) {
                eVar2.f141014j0 = (String) a49.get(".deviceinfoconfig.voip.common.resources");
            }
            if (a49.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                eVar2.f141043y = w0.a((String) a49.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                eVar2.f141016k0 = (String) a49.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (a49.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                eVar2.f141018l0 = (String) a49.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (a49.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                eVar2.f141020m0 = (String) a49.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (a49.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                eVar2.f141022n0 = (String) a49.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (a49.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                eVar2.f141024o0 = (String) a49.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (a49.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                eVar2.f141026p0 = (String) a49.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (a49.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                eVar2.f141045z = w0.a((String) a49.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                eVar2.f141028q0 = (String) a49.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (a49.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                eVar2.f141030r0 = (String) a49.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (a49.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == w0.a((String) a49.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                p0.f141693a = true;
            }
            if (a49.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                p0.f141694b = w0.a((String) a49.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (a49.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                eVar2.f141032s0 = (String) a49.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (a49.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                eVar2.f141034t0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                eVar2.f141036u0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                int a56 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                eVar2.f141038v0 = a56;
                com.tencent.luggage.wxa.z9.a.a(a56 == 1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                eVar2.f141040w0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                eVar2.B = w0.a((String) a49.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                eVar2.C = w0.a((String) a49.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (a49.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                eVar2.f141042x0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
                eVar2.f141044y0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
                eVar2.f141046z0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus") != null) {
                eVar2.A0 = w0.a((String) a49.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus"), 1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes") != null) {
                eVar2.D = w0.a((String) a49.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes") != null) {
                eVar2.E = w0.a((String) a49.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.hw264MaxEncRes") != null) {
                eVar2.F = w0.a((String) a49.get(".deviceinfoconfig.voip.common.hw264MaxEncRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.hw265MaxEncRes") != null) {
                eVar2.G = w0.a((String) a49.get(".deviceinfoconfig.voip.common.hw265MaxEncRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes") != null) {
                eVar2.H = w0.a((String) a49.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
                eVar2.I = w0.a((String) a49.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes") != null) {
                eVar2.J = w0.a((String) a49.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.hw264MaxDecRes") != null) {
                eVar2.K = w0.a((String) a49.get(".deviceinfoconfig.voip.common.hw264MaxDecRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.hw265MaxDecRes") != null) {
                eVar2.L = w0.a((String) a49.get(".deviceinfoconfig.voip.common.hw265MaxDecRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
                eVar2.M = w0.a((String) a49.get(".deviceinfoconfig.voip.common.vcodec1MixMaxDecRes"), -1);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                if (w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1) {
                    tVar2 = tVar;
                    z29 = true;
                } else {
                    tVar2 = tVar;
                    z29 = false;
                }
                tVar2.f141159a = z29;
            } else {
                tVar2 = tVar;
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                tVar2.f141160b = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                tVar2.f141161c = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                tVar2.f141162d = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                tVar2.f141163e = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                tVar2.f141164f = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                tVar2.f141165g = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                tVar2.f141166h = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                tVar2.f141167i = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                tVar2.f141168j = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
                tVar2.f141169k = w0.a((String) a49.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
            }
            if (a49.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                if (w0.a((String) a49.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1) {
                    zVar2 = zVar;
                    z28 = true;
                } else {
                    zVar2 = zVar;
                    z28 = false;
                }
                zVar2.f141192a = z28;
            } else {
                zVar2 = zVar;
            }
            if (a49.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                boolean z36 = w0.a((String) a49.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                zVar2.f141193b = z36;
                Object[] objArr = new Object[1];
                z27 = false;
                objArr[0] = Boolean.valueOf(z36);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", objArr);
                com.tencent.luggage.wxa.tn.z.c().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", zVar2.f141193b).commit();
            }
            eVar.a();
            int a57 = w0.a((String) a49.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int a58 = w0.a((String) a49.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(a57));
            if (nVar != null) {
                nVar.b(a57);
                nVar.a(a58);
            }
            try {
                int a59 = w0.a((String) a49.get(".deviceinfoconfig.soter.isSupport"), 0);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(a59));
                if (wVar != null) {
                    wVar.b(a59 >= 1);
                    wVar.a(a59);
                }
                if (a57 == 11 && a58 == 11 && wVar != null) {
                    nVar.b(1);
                    nVar.a(1);
                    wVar.b(true);
                    wVar.a(1);
                    wVar.a(true);
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
                }
                String str3 = (String) a49.get(".deviceinfoconfig.freeWifi.operations.bizUserName");
                Object[] objArr2 = new Object[1];
                objArr2[0] = str3;
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", objArr2);
                if (qVar != null) {
                    qVar.a(str3);
                }
                Map a65 = b1.a(str, "manufacturerName", null);
                Object[] objArr3 = new Object[1];
                z17 = false;
                objArr3[0] = a65;
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", objArr3);
                if (qVar != null) {
                    qVar.a(a65);
                }
                boolean z37 = false;
                try {
                    int a66 = w0.a((String) a49.get(".deviceinfoconfig.style.swipback"), 0);
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(a66));
                    if (qVar != null) {
                        qVar.a(a66);
                    }
                    int a67 = w0.a((String) a49.get(".deviceinfoconfig.game.isLimit"), 0);
                    String str4 = (String) a49.get(".deviceinfoconfig.game.limitPrompt");
                    Object[] objArr4 = new Object[2];
                    z18 = false;
                    objArr4[0] = Integer.valueOf(a67);
                    objArr4[1] = str4;
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", objArr4);
                    if (bVar != null) {
                        bVar.a(a67 == 1);
                        bVar.a(str4);
                    }
                    if (a49.get(".deviceinfoconfig.appbrand.enableV8Lite") != null) {
                        z26 = false;
                        a.f140903a.a(w0.a((String) a49.get(".deviceinfoconfig.appbrand.enableV8Lite"), false));
                    }
                    if (a49.get(".deviceinfoconfig.debug.multitalkSdkApply") != null) {
                        eVar2.T = w0.a((String) a49.get(".deviceinfoconfig.debug.multitalkSdkApply"), 0);
                    }
                    if (a49.get(".deviceinfoconfig.debug.screenPcCastDebug") != null) {
                        eVar2.U = w0.a((String) a49.get(".deviceinfoconfig.debug.screenPcCastDebug"), 0);
                    }
                    if (a49.get(".deviceinfoconfig.debug.screenPcCastUseAsyncCodec") != null) {
                        eVar2.V = w0.a((String) a49.get(".deviceinfoconfig.debug.screenPcCastUseAsyncCodec"), 0);
                    }
                    if (a49.get(".deviceinfoconfig.debug.screenCast2PcRenderUseAsyncCodec") != null) {
                        eVar2.W = w0.a((String) a49.get(".deviceinfoconfig.debug.screenCast2PcRenderUseAsyncCodec"), 0);
                    }
                    if (a49.get(".deviceinfoconfig.debug.screenCast2PcDebugIgnoreScan") != null) {
                        eVar2.X = w0.a((String) a49.get(".deviceinfoconfig.debug.screenCast2PcDebugIgnoreScan"), 0);
                    }
                    if (a49.get(".deviceinfoconfig.debug.blackBoardProjectDebug") != null) {
                        z37 = false;
                        eVar2.Y = w0.a((String) a49.get(".deviceinfoconfig.debug.blackBoardProjectDebug"), 0);
                    }
                    a16 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.recordertype"), -1);
                    a17 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
                    a18 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
                    a19 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
                    a26 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
                    a27 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
                    a28 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
                    a29 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
                    a36 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.useMetering"), -1);
                    a37 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
                    a38 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
                    a39 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
                    a46 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
                    a47 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
                    a48 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
                } catch (Exception e28) {
                    exc = e28;
                    i3 = z37;
                    com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                    return i3;
                }
            } catch (Exception e29) {
                exc = e29;
                i3 = 0;
            }
            try {
                int a68 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
                int a69 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
                int a75 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
                int a76 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.c2cRemuxUseSoftEncode"), -1);
                int a77 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.snsRemuxUseSoftEncode"), -1);
                int a78 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.takePhotoAlignType"), -1);
                int a79 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.nativeToThumb"), -1);
                int a85 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.HWQPCfg"), -1);
                int a86 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.useCameraApi2"), -1);
                int a87 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.fullFuncApi2"), -1);
                int a88 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.camera2UseRecordStream"), -1);
                int a89 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.vendorCameraEffectSupported"), -1);
                int a95 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.useImageStreamCapture"), -1);
                int a96 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.useRenderScriptCropImage"), -1);
                int a97 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.isVendorDebugModeSupported"), -1);
                int a98 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.captureHwHevcEncodeEnable"), -1);
                int a99 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.captureSwHevcEncodeEnable"), -1);
                int a100 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.remuxHwHevcEncodeEnable"), -1);
                int a101 = w0.a((String) a49.get(".deviceinfoconfig.mmsight.remuxSwHevcEncodeEnable"), -1);
                if (pVar != null) {
                    pVar.f141104a = a16;
                    pVar.f141105b = a17;
                    pVar.f141106c = a18;
                    pVar.f141107d = a19;
                    pVar.f141108e = a26;
                    pVar.f141109f = a27;
                    pVar.f141110g = a28;
                    pVar.f141111h = a29;
                    pVar.f141112i = a36;
                    pVar.f141113j = a37;
                    pVar.f141114k = a38;
                    pVar.f141117n = a48;
                    pVar.f141118o = a68;
                    pVar.f141119p = a69;
                    pVar.f141120q = a75;
                    pVar.f141128y = a76;
                    pVar.f141129z = a77;
                    pVar.B = a78;
                    pVar.C = a79;
                    pVar.A = a85;
                    pVar.f141121r = a86;
                    pVar.f141123t = a87;
                    pVar.f141122s = a88;
                    pVar.f141124u = a89;
                    pVar.f141125v = a95;
                    pVar.f141126w = a96;
                    pVar.f141127x = a97;
                    pVar.D = a98;
                    pVar.E = a99;
                    pVar.F = a100;
                    pVar.G = a101;
                    Object[] objArr5 = new Object[1];
                    z19 = false;
                    try {
                        objArr5[0] = pVar.toString();
                        str2 = "MicroMsg.DeviceInfoParser";
                        com.tencent.luggage.wxa.tn.w.d(str2, "get mmSightRecorderInfo: %s", objArr5);
                    } catch (Exception e36) {
                        e = e36;
                        str2 = "MicroMsg.DeviceInfoParser";
                        exc = e;
                        i3 = z19;
                        com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                        return i3;
                    }
                } else {
                    str2 = "MicroMsg.DeviceInfoParser";
                }
                if (pVar2 == null) {
                    return true;
                }
                pVar2.f141104a = a46;
                pVar2.f141105b = a17;
                pVar2.f141106c = a18;
                pVar2.f141107d = a19;
                pVar2.f141108e = a26;
                pVar2.f141109f = a27;
                pVar2.f141110g = a28;
                pVar2.f141111h = a29;
                pVar2.f141112i = a36;
                pVar2.f141113j = a37;
                pVar2.f141114k = a38;
                pVar2.f141115l = a39;
                pVar2.f141116m = a47;
                Object[] objArr6 = new Object[1];
                z16 = false;
                objArr6[0] = pVar2.toString();
                com.tencent.luggage.wxa.tn.w.d(str2, "get mmStoryRecorderInfo: %s", objArr6);
                return true;
            } catch (Exception e37) {
                e = e37;
                str2 = "MicroMsg.DeviceInfoParser";
                exc = e;
                i3 = 0;
                com.tencent.luggage.wxa.tn.w.a(str2, exc, "", new Object[i3]);
                return i3;
            }
        } catch (Exception e38) {
            e = e38;
        }
    }
}
