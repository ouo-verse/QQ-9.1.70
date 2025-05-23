package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.j;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.qcircle.weseevideo.model.template.light.LightPatterHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends j {

    /* renamed from: f, reason: collision with root package name */
    private static final String f65241f;

    /* renamed from: g, reason: collision with root package name */
    private static final String f65242g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f65243h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f65244i;

    /* renamed from: j, reason: collision with root package name */
    private static final String f65245j;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f65246a = b.f65264m + File.separator + AECameraConstants.CAMERA_STORY_DEFAULT_JSON;

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.ae.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public static class C0559a {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65247a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65248b;

            /* renamed from: c, reason: collision with root package name */
            public static final String f65249c;

            /* renamed from: d, reason: collision with root package name */
            public static final String f65250d;

            /* renamed from: e, reason: collision with root package name */
            public static final String f65251e;

            static {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j.a.f65592c);
                String str = File.separator;
                sb5.append(str);
                sb5.append("camera");
                String sb6 = sb5.toString();
                f65247a = sb6;
                f65248b = sb6 + str + "photo_compress";
                f65249c = sb6 + str + "multi_camera";
                f65250d = sb6 + str + "audioCache" + str;
                StringBuilder sb7 = new StringBuilder();
                sb7.append(j.f65588d);
                sb7.append(str);
                sb7.append("light_cache");
                f65251e = sb7.toString();
            }
        }

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65252a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65253b;

            /* renamed from: c, reason: collision with root package name */
            public static final String f65254c;

            /* renamed from: d, reason: collision with root package name */
            public static final String f65255d;

            /* renamed from: e, reason: collision with root package name */
            public static final String f65256e;

            /* renamed from: f, reason: collision with root package name */
            public static final String f65257f;

            /* renamed from: g, reason: collision with root package name */
            public static final String f65258g;

            /* renamed from: h, reason: collision with root package name */
            public static final String f65259h;

            /* renamed from: i, reason: collision with root package name */
            public static final String f65260i;

            /* renamed from: j, reason: collision with root package name */
            public static final String f65261j;

            /* renamed from: k, reason: collision with root package name */
            public static final String f65262k;

            /* renamed from: l, reason: collision with root package name */
            public static final String f65263l;

            /* renamed from: m, reason: collision with root package name */
            public static final String f65264m;

            /* renamed from: n, reason: collision with root package name */
            public static final String f65265n;

            static {
                StringBuilder sb5 = new StringBuilder();
                String str = j.a.f65591b;
                sb5.append(str);
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append("camera");
                String sb6 = sb5.toString();
                f65252a = sb6;
                f65253b = str + str2 + "sv_config_resources" + str2;
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                sb7.append(str2);
                sb7.append("capture");
                f65254c = sb7.toString();
                f65255d = sb6 + str2 + "material_zip_download";
                f65256e = sb6 + str2 + "material_usable";
                f65257f = sb6 + str2 + "material_config";
                f65258g = sb6 + str2 + "material_zip_download_v2";
                f65259h = sb6 + str2 + "material_usable_v2";
                f65260i = sb6 + str2 + "pendent_pag_download";
                f65261j = sb6 + str2 + "zshow_mood_usable_v2";
                f65262k = sb6 + str2 + "material_usable_v3";
                f65263l = sb6 + str2 + "material_zip_download_v3";
                f65264m = sb6 + str2 + "material_config_v2";
                f65265n = sb6 + str2 + "qzone_material_usable";
            }
        }

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65266a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65267b;

            /* renamed from: c, reason: collision with root package name */
            public static final String f65268c;

            /* renamed from: d, reason: collision with root package name */
            public static final String f65269d;

            static {
                StringBuilder sb5 = new StringBuilder();
                String str = j.f65587c;
                sb5.append(str);
                sb5.append("/app_lib/qq_bundle_new");
                String str2 = File.separator;
                sb5.append(str2);
                String sb6 = sb5.toString();
                f65266a = sb6;
                f65267b = sb6;
                String str3 = str + "/app_lib/qq_filter_new" + str2;
                f65268c = str3;
                f65269d = str3 + "final_ptu_res_file" + str2;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f65270a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f65271b;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65272a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65273b;

            static {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j.a.f65592c);
                String str = File.separator;
                sb5.append(str);
                sb5.append("gif");
                String sb6 = sb5.toString();
                f65272a = sb6;
                f65273b = sb6 + str + "gifPreview";
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.ae.g$b$b, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public static class C0560b {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65274a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65275b;

            /* renamed from: c, reason: collision with root package name */
            public static final String f65276c;

            /* renamed from: d, reason: collision with root package name */
            public static final String f65277d;

            /* renamed from: e, reason: collision with root package name */
            public static final String f65278e;

            /* renamed from: f, reason: collision with root package name */
            public static final String f65279f;

            /* renamed from: g, reason: collision with root package name */
            public static final String f65280g;

            static {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j.a.f65591b);
                String str = File.separator;
                sb5.append(str);
                sb5.append("gif");
                String sb6 = sb5.toString();
                f65274a = sb6;
                f65275b = sb6 + str + "capture";
                String str2 = sb6 + str + "res";
                f65276c = str2;
                f65277d = sb6 + str + "res_zip_download";
                f65278e = str2 + str + "GifGuide";
                f65279f = sb6 + str + "material_config";
                f65280g = sb6 + str + "material_config_v2";
            }
        }

        static {
            StringBuilder sb5 = new StringBuilder();
            String str = C0560b.f65280g;
            sb5.append(str);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(AECameraConstants.CAMERA_EMO_DEFAULT_JSON);
            f65270a = sb5.toString();
            f65271b = str + str2 + AECameraConstants.CAMERA_EMO_UPDATED_JSON;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final String f65281a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f65282b;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65283a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65284b;

            /* renamed from: c, reason: collision with root package name */
            public static final String f65285c;

            /* renamed from: d, reason: collision with root package name */
            public static final String f65286d;

            static {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j.a.f65592c);
                String str = File.separator;
                sb5.append(str);
                sb5.append("playshow");
                String sb6 = sb5.toString();
                f65283a = sb6;
                f65284b = sb6 + str + "crazyface_tmp";
                f65285c = sb6 + str + "qudong_tmp";
                f65286d = sb6 + str + "web_tmp";
            }
        }

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65287a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65288b;

            /* renamed from: c, reason: collision with root package name */
            public static final String f65289c;

            /* renamed from: d, reason: collision with root package name */
            public static final String f65290d;

            /* renamed from: e, reason: collision with root package name */
            public static final String f65291e;

            /* renamed from: f, reason: collision with root package name */
            public static final String f65292f;

            static {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j.a.f65591b);
                String str = File.separator;
                sb5.append(str);
                sb5.append("playshow");
                String sb6 = sb5.toString();
                f65287a = sb6;
                f65288b = a.b.f65262k;
                f65289c = sb6 + str + "material_config";
                f65290d = sb6 + str + "material_config_v2";
                f65291e = sb6 + str + "thumbs";
                f65292f = sb6 + str + "videos";
            }
        }

        static {
            StringBuilder sb5 = new StringBuilder();
            String str = b.f65290d;
            sb5.append(str);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(AECameraConstants.CAMERA_PLAY_SHOW_DEFAULT_JSON);
            f65281a = sb5.toString();
            f65282b = str + str2 + AECameraConstants.CAMERA_PLAY_SHOW_UPDATED_JSON;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final String f65293a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f65294b;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final String f65295a;

            /* renamed from: b, reason: collision with root package name */
            public static final String f65296b;

            /* renamed from: c, reason: collision with root package name */
            public static final String f65297c;

            static {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j.a.f65591b);
                String str = File.separator;
                sb5.append(str);
                sb5.append(LightPatterHelper.KEY_WATERMARK);
                String sb6 = sb5.toString();
                f65295a = sb6;
                f65296b = sb6 + str + "material_config";
                f65297c = sb6 + str + "material_config_v2";
            }
        }

        static {
            StringBuilder sb5 = new StringBuilder();
            String str = a.f65297c;
            sb5.append(str);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("camera_watermark_current_template.json");
            f65293a = sb5.toString();
            f65294b = str + str2 + "camera_watermark_updated_template.json";
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_ROOT;
        sb5.append(str);
        sb5.append("/DCIM/Video/");
        f65241f = sb5.toString();
        f65242g = str + HardCodeUtil.qqStr(R.string.jno);
        f65243h = str + HardCodeUtil.qqStr(R.string.jnp);
        f65244i = str + "/Camera/Video/";
        f65245j = str + "/DCIM/Camera/";
    }

    public static String a() {
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (upperCase.contains("GN9000L")) {
            return f65242g;
        }
        if (!upperCase.contains("MX4") && !upperCase.contains("MX6") && !upperCase.contains("MX5") && !upperCase.contains("M355") && !upperCase.contains("M571C")) {
            if (upperCase.contains("M040")) {
                return f65244i;
            }
            if (!upperCase.contains("VIVO X7") && !upperCase.contains("VIVO X6A") && !upperCase.contains("VIVO XPLAY6") && !upperCase.contains("VIVO X5PRO") && !upperCase.contains("VIVO X9 PLUS") && !upperCase.contains("VIVO Y51A") && !upperCase.contains("VIVO X9I") && !upperCase.contains("VIVO X9") && !upperCase.contains("VIVO X6D")) {
                return f65245j;
            }
            return f65243h;
        }
        return f65241f;
    }

    public static String b(String str) {
        StringBuilder sb5 = new StringBuilder(str);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        while (true) {
            sb5.append(VidUtil.generateVid());
            sb5.append(".mp4");
            if (!new File(sb5.toString()).exists()) {
                return sb5.toString();
            }
            sb5 = new StringBuilder(sb5);
        }
    }
}
