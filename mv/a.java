package mv;

import com.tencent.av.config.api.IConfigParser;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f417645a;

    public static a a() {
        synchronized (a.class) {
            a aVar = f417645a;
            if (aVar != null) {
                return aVar;
            }
            try {
                a aVar2 = new a();
                f417645a = aVar2;
                return aVar2;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public boolean b() {
        if (du.a.b(BaseApplication.getContext()).getIntValue("sharp/EffectFaceDeviceConfig/enable", 0) != 1) {
            return false;
        }
        return true;
    }

    public boolean c() {
        IConfigParser b16 = du.a.b(BaseApplication.getContext());
        if (b16 == null || 1 != b16.getIntValue("sharp/EffectFaceDetectInversion/Inversion", 0)) {
            return false;
        }
        return true;
    }

    public boolean d() {
        if (du.a.b(BaseApplication.getContext()).getIntValue("sharp/EffectFilterDeviceConfig/isClose", 0) != 0) {
            return false;
        }
        return true;
    }

    public boolean e() {
        if (du.a.b(BaseApplication.getContext()).getIntValue("sharp/EffectFaceDeviceConfig/isClose", 0) != 0) {
            return false;
        }
        return true;
    }

    public boolean f() {
        if (du.a.b(BaseApplication.getContext()).getIntValue("sharp/qavScreenRecoder/isClose", 0) != 0) {
            return false;
        }
        return true;
    }

    public boolean g() {
        IConfigParser b16 = du.a.b(BaseApplication.getContext());
        if (b16 == null || b16.getIntValue("sharp/CameraFocusMethod/isUseSelfDev", 0) != 1) {
            return false;
        }
        return true;
    }
}
