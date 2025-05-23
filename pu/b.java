package pu;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$AndroidCameraInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$AudioSwitchPointInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$CmdReportClientInfoReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$CmdToClientConfigInfoRspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$MobileHardWareValue;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$MobileQQPttInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$PutinfoHead;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$ReqBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$RspBody;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$SharpTraeInfo;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$TransBuffer;
import tencent.im.cs.longconn.putinfo.hd_video_putinfo$VideoHardWareInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static String f427249c = "";

    /* renamed from: a, reason: collision with root package name */
    private a f427250a = new a();

    /* renamed from: b, reason: collision with root package name */
    private c f427251b = new c();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private long f427252a = 0;

        /* renamed from: b, reason: collision with root package name */
        private d f427253b = null;

        /* renamed from: c, reason: collision with root package name */
        private hd_video_putinfo$ReqBody f427254c = new hd_video_putinfo$ReqBody();

        public a() {
        }

        private void b() {
            hd_video_putinfo$CmdReportClientInfoReqBody hd_video_putinfo_cmdreportclientinforeqbody = this.f427254c.msg_report_client_info_req_body.get();
            hd_video_putinfo_cmdreportclientinforeqbody.uint32_mobile_type.set(this.f427253b.f427332a);
            hd_video_putinfo_cmdreportclientinforeqbody.uint32_mobile_os_info.set(this.f427253b.f427333b);
            hd_video_putinfo_cmdreportclientinforeqbody.uint32_instid.set(11001);
            hd_video_putinfo_cmdreportclientinforeqbody.bytes_client_system_info.set(ByteStringMicro.copyFrom(this.f427253b.f427346o.getBytes()));
            hd_video_putinfo_cmdreportclientinforeqbody.bytes_device_info.set(ByteStringMicro.copyFrom(this.f427253b.f427347p.getBytes()));
            hd_video_putinfo$MobileHardWareValue hd_video_putinfo_mobilehardwarevalue = hd_video_putinfo_cmdreportclientinforeqbody.msg_device_info.get();
            hd_video_putinfo_mobilehardwarevalue.uint32_mobile_cpu_struct.set(this.f427253b.f427334c);
            hd_video_putinfo_mobilehardwarevalue.uint32_mobile_cpu_number.set(this.f427253b.f427335d);
            hd_video_putinfo_mobilehardwarevalue.uint32_mobile_cpu_hertz.set(this.f427253b.f427336e);
            hd_video_putinfo_mobilehardwarevalue.uint32_mobile_camera_turn.set(this.f427253b.f427337f);
            hd_video_putinfo_cmdreportclientinforeqbody.msg_device_info.set(hd_video_putinfo_mobilehardwarevalue);
            hd_video_putinfo$VideoHardWareInfo hd_video_putinfo_videohardwareinfo = hd_video_putinfo_cmdreportclientinforeqbody.msg_video_info.get();
            hd_video_putinfo_videohardwareinfo.uint32_mobile_max_encodeframe.set(this.f427253b.f427338g);
            hd_video_putinfo_videohardwareinfo.uint32_mobile_max_decodeframe.set(this.f427253b.f427339h);
            hd_video_putinfo_videohardwareinfo.uint32_mobile_width.set(this.f427253b.f427340i);
            hd_video_putinfo_videohardwareinfo.uint32_mobile_height.set(this.f427253b.f427341j);
            hd_video_putinfo_cmdreportclientinforeqbody.msg_video_info.set(hd_video_putinfo_videohardwareinfo);
            hd_video_putinfo_cmdreportclientinforeqbody.bytes_mobile_rom_info.set(ByteStringMicro.copyFrom(this.f427253b.f427348q.getBytes()));
            hd_video_putinfo_cmdreportclientinforeqbody.uint32_sharp_sdk_ver.set(this.f427253b.f427344m);
            hd_video_putinfo_cmdreportclientinforeqbody.uint32_open_general_info.set(this.f427253b.f427343l);
            hd_video_putinfo_cmdreportclientinforeqbody.bytes_app_version.set(ByteStringMicro.copyFrom(this.f427253b.f427349r.getBytes()));
            this.f427254c.msg_report_client_info_req_body.set(hd_video_putinfo_cmdreportclientinforeqbody);
        }

        private void c() {
            hd_video_putinfo$PutinfoHead hd_video_putinfo_putinfohead = this.f427254c.msg_putinfo_head.get();
            hd_video_putinfo_putinfohead.enum_body_type.set(1);
            hd_video_putinfo_putinfohead.uint64_uin.set(this.f427252a);
            hd_video_putinfo_putinfohead.bytes_appid.set(ByteStringMicro.copyFrom(this.f427253b.f427345n.getBytes()));
            hd_video_putinfo_putinfohead.uint64_seq.set(new Random().nextLong());
            hd_video_putinfo_putinfohead.bytes_config_ver.set(ByteStringMicro.copyFrom(b.f427249c.getBytes()));
            this.f427254c.msg_putinfo_head.set(hd_video_putinfo_putinfohead);
        }

        public void a(long j3, d dVar) {
            this.f427252a = j3;
            this.f427253b = dVar;
        }

        public byte[] d() {
            c();
            b();
            return this.f427254c.toByteArray();
        }
    }

    /* compiled from: P */
    /* renamed from: pu.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C11041b {

        /* renamed from: a, reason: collision with root package name */
        boolean f427256a = true;

        /* renamed from: b, reason: collision with root package name */
        String f427257b = "";

        /* renamed from: c, reason: collision with root package name */
        String f427258c = "";

        /* renamed from: d, reason: collision with root package name */
        a f427259d = new a();

        /* renamed from: e, reason: collision with root package name */
        d f427260e = new d();

        /* renamed from: f, reason: collision with root package name */
        e f427261f = new e();

        /* renamed from: g, reason: collision with root package name */
        c f427262g = new c();

        /* renamed from: h, reason: collision with root package name */
        C11042b f427263h = new C11042b();

        /* renamed from: i, reason: collision with root package name */
        List<f> f427264i = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: pu.b$b$a */
        /* loaded from: classes3.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            byte f427266a = 0;

            /* renamed from: b, reason: collision with root package name */
            byte f427267b = 0;

            /* renamed from: c, reason: collision with root package name */
            byte f427268c = 0;

            /* renamed from: d, reason: collision with root package name */
            byte f427269d = 0;

            /* renamed from: e, reason: collision with root package name */
            byte f427270e = 0;

            /* renamed from: f, reason: collision with root package name */
            byte f427271f = 0;

            /* renamed from: g, reason: collision with root package name */
            byte f427272g = 0;

            /* renamed from: h, reason: collision with root package name */
            byte f427273h = 0;

            /* renamed from: i, reason: collision with root package name */
            byte f427274i = 0;

            /* renamed from: j, reason: collision with root package name */
            byte f427275j = 0;

            /* renamed from: k, reason: collision with root package name */
            byte f427276k = 0;

            /* renamed from: l, reason: collision with root package name */
            byte f427277l = 0;

            a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: pu.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C11042b {

            /* renamed from: a, reason: collision with root package name */
            int f427279a = 0;

            /* renamed from: b, reason: collision with root package name */
            int f427280b = 0;

            /* renamed from: c, reason: collision with root package name */
            int f427281c = 0;

            /* renamed from: d, reason: collision with root package name */
            int f427282d = 0;

            /* renamed from: e, reason: collision with root package name */
            String f427283e = "";

            /* renamed from: f, reason: collision with root package name */
            int f427284f = 0;

            /* renamed from: g, reason: collision with root package name */
            int f427285g = 0;

            /* renamed from: h, reason: collision with root package name */
            int f427286h = 0;

            /* renamed from: i, reason: collision with root package name */
            int f427287i = 0;

            /* renamed from: j, reason: collision with root package name */
            String f427288j = "";

            C11042b() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: pu.b$b$c */
        /* loaded from: classes3.dex */
        public class c {

            /* renamed from: a, reason: collision with root package name */
            boolean f427290a = false;

            /* renamed from: b, reason: collision with root package name */
            int f427291b = 0;

            /* renamed from: c, reason: collision with root package name */
            int f427292c = 0;

            /* renamed from: d, reason: collision with root package name */
            int f427293d = 0;

            /* renamed from: e, reason: collision with root package name */
            int f427294e = 0;

            /* renamed from: f, reason: collision with root package name */
            int f427295f = 0;

            /* renamed from: g, reason: collision with root package name */
            int f427296g = 0;

            /* renamed from: h, reason: collision with root package name */
            int f427297h = 0;

            /* renamed from: i, reason: collision with root package name */
            int f427298i = 0;

            /* renamed from: j, reason: collision with root package name */
            int f427299j = 0;

            /* renamed from: k, reason: collision with root package name */
            int f427300k = 0;

            /* renamed from: l, reason: collision with root package name */
            int f427301l = 0;

            /* renamed from: m, reason: collision with root package name */
            int f427302m = 0;

            /* renamed from: n, reason: collision with root package name */
            int f427303n = 0;

            /* renamed from: o, reason: collision with root package name */
            int f427304o = 0;

            /* renamed from: p, reason: collision with root package name */
            int f427305p = 0;

            c() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: pu.b$b$d */
        /* loaded from: classes3.dex */
        public class d {

            /* renamed from: a, reason: collision with root package name */
            int f427307a = 0;

            /* renamed from: b, reason: collision with root package name */
            int f427308b = 0;

            /* renamed from: c, reason: collision with root package name */
            int f427309c = 0;

            /* renamed from: d, reason: collision with root package name */
            int f427310d = 0;

            /* renamed from: e, reason: collision with root package name */
            int f427311e = 0;

            /* renamed from: f, reason: collision with root package name */
            int f427312f = 0;

            /* renamed from: g, reason: collision with root package name */
            int f427313g = 0;

            /* renamed from: h, reason: collision with root package name */
            int f427314h = 0;

            d() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: pu.b$b$e */
        /* loaded from: classes3.dex */
        public class e {

            /* renamed from: a, reason: collision with root package name */
            byte f427316a = 1;

            /* renamed from: b, reason: collision with root package name */
            byte f427317b = 0;

            /* renamed from: c, reason: collision with root package name */
            byte f427318c = 1;

            /* renamed from: d, reason: collision with root package name */
            byte f427319d = 1;

            /* renamed from: e, reason: collision with root package name */
            byte f427320e = 1;

            /* renamed from: f, reason: collision with root package name */
            byte f427321f = 0;

            /* renamed from: g, reason: collision with root package name */
            byte f427322g = 0;

            /* renamed from: h, reason: collision with root package name */
            byte f427323h = 0;

            /* renamed from: i, reason: collision with root package name */
            byte f427324i = 0;

            e() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: pu.b$b$f */
        /* loaded from: classes3.dex */
        public class f {

            /* renamed from: a, reason: collision with root package name */
            int f427326a = 0;

            /* renamed from: b, reason: collision with root package name */
            String f427327b = "";

            f() {
            }
        }

        public C11041b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private C11041b f427329a;

        /* renamed from: b, reason: collision with root package name */
        private hd_video_putinfo$RspBody f427330b = new hd_video_putinfo$RspBody();

        public c() {
            this.f427329a = new C11041b();
        }

        private int c() {
            List<hd_video_putinfo$TransBuffer> list;
            boolean z16;
            if (!this.f427330b.msg_to_client_config_info_rsq_body.has()) {
                return -1;
            }
            hd_video_putinfo$CmdToClientConfigInfoRspBody hd_video_putinfo_cmdtoclientconfiginforspbody = this.f427330b.msg_to_client_config_info_rsq_body.get();
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.uint32_log_flag.has()) {
                int i3 = hd_video_putinfo_cmdtoclientconfiginforspbody.uint32_log_flag.get();
                C11041b c11041b = this.f427329a;
                if (i3 == 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                c11041b.f427256a = z16;
            }
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.bytes_log_report_time.has()) {
                hd_video_putinfo_cmdtoclientconfiginforspbody.bytes_log_report_time.get().toStringUtf8();
            }
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.msg_android_camera_set.has()) {
                hd_video_putinfo$AndroidCameraInfo hd_video_putinfo_androidcamerainfo = hd_video_putinfo_cmdtoclientconfiginforspbody.msg_android_camera_set.get();
                this.f427329a.f427259d.f427266a = (byte) hd_video_putinfo_androidcamerainfo.uint32_param1.get();
                this.f427329a.f427259d.f427267b = (byte) hd_video_putinfo_androidcamerainfo.uint32_param2.get();
                this.f427329a.f427259d.f427268c = (byte) hd_video_putinfo_androidcamerainfo.uint32_param3.get();
                this.f427329a.f427259d.f427269d = (byte) hd_video_putinfo_androidcamerainfo.uint32_param4.get();
                this.f427329a.f427259d.f427270e = (byte) hd_video_putinfo_androidcamerainfo.uint32_param5.get();
                this.f427329a.f427259d.f427271f = (byte) hd_video_putinfo_androidcamerainfo.uint32_param6.get();
                this.f427329a.f427259d.f427272g = (byte) hd_video_putinfo_androidcamerainfo.uint32_param7.get();
                this.f427329a.f427259d.f427273h = (byte) hd_video_putinfo_androidcamerainfo.uint32_param8.get();
                this.f427329a.f427259d.f427274i = (byte) hd_video_putinfo_androidcamerainfo.uint32_param9.get();
                this.f427329a.f427259d.f427275j = (byte) hd_video_putinfo_androidcamerainfo.uint32_param10.get();
                this.f427329a.f427259d.f427276k = (byte) hd_video_putinfo_androidcamerainfo.uint32_param11.get();
                this.f427329a.f427259d.f427277l = (byte) hd_video_putinfo_androidcamerainfo.uint32_param12.get();
            }
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.msg_sharp_trae_info_set.has()) {
                hd_video_putinfo$SharpTraeInfo hd_video_putinfo_sharptraeinfo = hd_video_putinfo_cmdtoclientconfiginforspbody.msg_sharp_trae_info_set.get();
                this.f427329a.f427260e.f427307a = hd_video_putinfo_sharptraeinfo.uint32_trae_source.get();
                this.f427329a.f427260e.f427308b = hd_video_putinfo_sharptraeinfo.uint32_trae_interface.get();
                this.f427329a.f427260e.f427309c = hd_video_putinfo_sharptraeinfo.uint32_trae_stream_type.get();
                this.f427329a.f427260e.f427310d = hd_video_putinfo_sharptraeinfo.uint32_trae_volume.get();
                this.f427329a.f427260e.f427311e = hd_video_putinfo_sharptraeinfo.uint32_trae_mode.get();
                this.f427329a.f427260e.f427312f = hd_video_putinfo_sharptraeinfo.uint32_arm_flag.get();
                this.f427329a.f427260e.f427313g = hd_video_putinfo_sharptraeinfo.uint32_cpu_hertz.get();
                this.f427329a.f427260e.f427314h = hd_video_putinfo_sharptraeinfo.uint32_audio_set.get();
            }
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.uint64_switch.has()) {
                long j3 = hd_video_putinfo_cmdtoclientconfiginforspbody.uint64_switch.get();
                C11041b.e eVar = this.f427329a.f427261f;
                eVar.f427316a = (byte) (j3 & 1);
                eVar.f427317b = (byte) ((j3 >> 1) & 1);
                eVar.f427318c = (byte) ((j3 >> 2) & 1);
                eVar.f427319d = (byte) ((j3 >> 3) & 1);
                eVar.f427320e = (byte) ((j3 >> 4) & 1);
                eVar.f427321f = (byte) ((j3 >> 5) & 1);
                eVar.f427322g = (byte) ((j3 >> 6) & 1);
                eVar.f427323h = (byte) ((j3 >> 7) & 1);
                eVar.f427324i = (byte) ((j3 >> 13) & 1);
            }
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.msg_qq_ptt_info_set.has()) {
                this.f427329a.f427262g.f427290a = true;
                hd_video_putinfo$MobileQQPttInfo hd_video_putinfo_mobileqqpttinfo = hd_video_putinfo_cmdtoclientconfiginforspbody.msg_qq_ptt_info_set.get();
                this.f427329a.f427262g.f427291b = hd_video_putinfo_mobileqqpttinfo.uint32_param1.get();
                this.f427329a.f427262g.f427292c = hd_video_putinfo_mobileqqpttinfo.uint32_param2.get();
                this.f427329a.f427262g.f427293d = hd_video_putinfo_mobileqqpttinfo.uint32_param3.get();
                this.f427329a.f427262g.f427294e = hd_video_putinfo_mobileqqpttinfo.uint32_param4.get();
                this.f427329a.f427262g.f427295f = hd_video_putinfo_mobileqqpttinfo.uint32_param5.get();
                this.f427329a.f427262g.f427296g = hd_video_putinfo_mobileqqpttinfo.uint32_param6.get();
                this.f427329a.f427262g.f427297h = hd_video_putinfo_mobileqqpttinfo.uint32_param7.get();
                this.f427329a.f427262g.f427298i = hd_video_putinfo_mobileqqpttinfo.uint32_param8.get();
                this.f427329a.f427262g.f427299j = hd_video_putinfo_mobileqqpttinfo.uint32_param9.get();
                this.f427329a.f427262g.f427300k = hd_video_putinfo_mobileqqpttinfo.uint32_param10.get();
                this.f427329a.f427262g.f427301l = hd_video_putinfo_mobileqqpttinfo.uint32_param11.get();
                this.f427329a.f427262g.f427302m = hd_video_putinfo_mobileqqpttinfo.uint32_param12.get();
                this.f427329a.f427262g.f427303n = hd_video_putinfo_mobileqqpttinfo.uint32_param13.get();
                this.f427329a.f427262g.f427304o = hd_video_putinfo_mobileqqpttinfo.uint32_param14.get();
                this.f427329a.f427262g.f427305p = hd_video_putinfo_mobileqqpttinfo.uint32_param15.get();
            }
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.msg_audio_quality_set.has()) {
                hd_video_putinfo$AudioSwitchPointInfo hd_video_putinfo_audioswitchpointinfo = hd_video_putinfo_cmdtoclientconfiginforspbody.msg_audio_quality_set.get();
                this.f427329a.f427263h.f427279a = hd_video_putinfo_audioswitchpointinfo.uint32_wifi_shake.get();
                this.f427329a.f427263h.f427280b = hd_video_putinfo_audioswitchpointinfo.uint32_wifi_time_delay.get();
                this.f427329a.f427263h.f427281c = hd_video_putinfo_audioswitchpointinfo.uint32_wifi_pack_loss.get();
                this.f427329a.f427263h.f427282d = hd_video_putinfo_audioswitchpointinfo.uint32_wifi_pack_loss_rate.get();
                this.f427329a.f427263h.f427283e = hd_video_putinfo_audioswitchpointinfo.bytes_wifi_words.get().toStringUtf8();
                this.f427329a.f427263h.f427284f = hd_video_putinfo_audioswitchpointinfo.uint32_nowifi_shake.get();
                this.f427329a.f427263h.f427285g = hd_video_putinfo_audioswitchpointinfo.uint32_nowifi_time_delay.get();
                this.f427329a.f427263h.f427286h = hd_video_putinfo_audioswitchpointinfo.uint32_nowifi_pack_loss.get();
                this.f427329a.f427263h.f427287i = hd_video_putinfo_audioswitchpointinfo.uint32_nowifi_pack_loss_rate.get();
                this.f427329a.f427263h.f427288j = hd_video_putinfo_audioswitchpointinfo.bytes_nowifi_words.get().toStringUtf8();
            }
            if (hd_video_putinfo_cmdtoclientconfiginforspbody.rpt_msg_trans_buffer_list.has() && (list = hd_video_putinfo_cmdtoclientconfiginforspbody.rpt_msg_trans_buffer_list.get()) != null && list.size() > 0) {
                for (int i16 = 0; i16 < list.size(); i16++) {
                    C11041b c11041b2 = this.f427329a;
                    Objects.requireNonNull(c11041b2);
                    C11041b.f fVar = new C11041b.f();
                    fVar.f427326a = list.get(i16).uint32_type.get();
                    fVar.f427327b = list.get(i16).bytes_content.get().toStringUtf8();
                    this.f427329a.f427264i.add(fVar);
                    int i17 = fVar.f427326a;
                    if (i17 == 1) {
                        this.f427329a.f427257b = fVar.f427327b;
                    } else if (i17 == 2) {
                        this.f427329a.f427258c = fVar.f427327b;
                    }
                }
            }
            return 0;
        }

        public C11041b a() {
            return this.f427329a;
        }

        public int b(byte[] bArr) {
            hd_video_putinfo$PutinfoHead hd_video_putinfo_putinfohead;
            if (bArr == null) {
                return -1;
            }
            try {
                this.f427330b.mergeFrom(bArr);
                if (this.f427330b.msg_putinfo_head.has() && (hd_video_putinfo_putinfohead = this.f427330b.msg_putinfo_head.get()) != null && hd_video_putinfo_putinfohead.uint32_error_no.has() && hd_video_putinfo_putinfohead.uint32_error_no.get() == 0 && hd_video_putinfo_putinfohead.enum_body_type.has() && hd_video_putinfo_putinfohead.enum_body_type.get() == 2) {
                    if (hd_video_putinfo_putinfohead.bytes_config_ver.has()) {
                        b.f427249c = hd_video_putinfo_putinfohead.bytes_config_ver.get().toStringUtf8();
                    }
                    return c();
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        int f427332a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f427333b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f427334c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f427335d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f427336e = 0;

        /* renamed from: f, reason: collision with root package name */
        int f427337f = 0;

        /* renamed from: g, reason: collision with root package name */
        int f427338g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f427339h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f427340i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f427341j = 0;

        /* renamed from: k, reason: collision with root package name */
        int f427342k = 0;

        /* renamed from: l, reason: collision with root package name */
        int f427343l = 0;

        /* renamed from: m, reason: collision with root package name */
        int f427344m = 0;

        /* renamed from: n, reason: collision with root package name */
        String f427345n = "";

        /* renamed from: o, reason: collision with root package name */
        String f427346o = "";

        /* renamed from: p, reason: collision with root package name */
        String f427347p = "";

        /* renamed from: q, reason: collision with root package name */
        String f427348q = "";

        /* renamed from: r, reason: collision with root package name */
        String f427349r = "";

        public d() {
        }
    }

    public byte[] a() {
        a aVar = this.f427250a;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public C11041b b() {
        c cVar = this.f427251b;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    public void c(long j3, d dVar) {
        this.f427250a.a(j3, dVar);
    }

    public int d(byte[] bArr) {
        c cVar = this.f427251b;
        if (cVar != null) {
            return cVar.b(bArr);
        }
        return -1;
    }
}
