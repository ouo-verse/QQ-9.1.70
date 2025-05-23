package du;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import pu.d;
import pu.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f394852b;

    /* renamed from: a, reason: collision with root package name */
    private d f394853a;

    b() {
        if (QLog.isColorLevel()) {
            QLog.d("MediaCodecChipConfigManager", 2, "MediaCodecChipConfigManager constructor ");
        }
    }

    public static b a() {
        if (f394852b == null) {
            synchronized (b.class) {
                if (f394852b == null) {
                    b bVar = new b();
                    f394852b = bVar;
                    bVar.c();
                }
            }
        }
        return f394852b;
    }

    public d b() {
        d dVar;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("MediaCodecChipConfigManager", 2, "getMediaCodecChipConfigInfo");
        }
        synchronized (b.class) {
            if (this.f394853a == null) {
                this.f394853a = d.f(e.a(BaseApplication.getContext().getFilesDir().getAbsolutePath(), "av_mediacodec_file_config"));
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getMediaCodecChipConfigInfo content:=");
                d dVar2 = this.f394853a;
                if (dVar2 != null) {
                    str = dVar2.toString();
                } else {
                    str = null;
                }
                sb5.append(str);
                QLog.d("MediaCodecChipConfigManager", 2, sb5.toString());
            }
            dVar = this.f394853a;
        }
        return dVar;
    }

    private void c() {
    }
}
