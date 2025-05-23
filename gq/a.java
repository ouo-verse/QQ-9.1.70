package gq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static boolean A(int i3) {
        return i3 == js.a.H.b();
    }

    private static boolean E(Intent intent) {
        return p(intent) && M(intent);
    }

    private static boolean G(Intent intent) {
        return Q(intent) && M(intent);
    }

    public static boolean I(int i3) {
        return js.a.S.b() == i3;
    }

    public static boolean N(Context context) {
        Intent intent;
        if (!(context instanceof Activity) || (intent = ((Activity) context).getIntent()) == null) {
            return false;
        }
        return "QCIRCLE".equals(intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME));
    }

    public static boolean O(int i3) {
        return i3 == js.a.f410910j.b() || i3 == js.a.f410918r.b() || i3 == js.a.f410921u.b() || i3 == js.a.f410925y.b();
    }

    public static boolean P(int i3) {
        return js.a.f410917q.b() == i3;
    }

    public static boolean R(Intent intent) {
        return G(intent) || o(intent) || E(intent);
    }

    public static boolean V(int i3) {
        return i3 == js.a.f410906f.b();
    }

    public static boolean W(int i3) {
        return (i3 == js.a.f410908h.b() || i3 == js.a.Q.b() || i3 == js.a.f410912l.b() || i3 == js.a.f410919s.b() || i3 == js.a.f410926z.b() || i3 == js.a.A.b() || i3 == js.a.U.b() || i3 == js.a.V.b()) ? false : true;
    }

    public static int X(String str) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("camera", 200);
        hashMap.put("all", 201);
        hashMap.put("gif", 202);
        hashMap.put(AECameraConstants.AECAMERA_MODE_SINGLE_GIF_MODE, 203);
        hashMap.put(AECameraConstants.AECAMERA_MODE_NO_GIF_MODE, 204);
        hashMap.put(AECameraConstants.AECAMERA_MODE_NO_PLAY_MODE, 205);
        hashMap.put("play", 206);
        hashMap.put(AECameraConstants.AECAMERA_MODE_PLAY_AND_GIF_MODE, 207);
        hashMap.put(AECameraConstants.AECAMERA_MODE_ARCAKE, 208);
        if (str == null || !hashMap.containsKey(str) || hashMap.get(str) == null) {
            return 200;
        }
        return ((Integer) hashMap.get(str)).intValue();
    }

    public static String Y(String str) {
        if ("camera".equals(str)) {
            return String.valueOf(AECaptureMode.NORMAL.name);
        }
        if ("play".equals(str)) {
            return String.valueOf(AECaptureMode.PLAY.name);
        }
        if ("gif".equals(str)) {
            return String.valueOf(AECaptureMode.GIF.name);
        }
        return String.valueOf(AECaptureMode.NORMAL.name);
    }

    public static int c(Intent intent) {
        if (intent.hasExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE)) {
            return intent.getIntExtra(AECameraConstants.ORIGIN_VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        }
        return intent.getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
    }

    public static boolean f(int i3) {
        return js.a.f410908h.b() == i3 || js.a.Q.b() == i3;
    }

    public static boolean g(int i3) {
        return i3 == js.a.f410910j.b() || i3 == js.a.f410918r.b() || i3 == js.a.f410921u.b() || i3 == js.a.f410908h.b() || i3 == js.a.f410925y.b();
    }

    public static boolean l(Intent intent) {
        int a16 = a(intent);
        return a16 == js.a.f410908h.b() || a16 == js.a.Q.b();
    }

    public static boolean m(int i3) {
        return i3 == js.a.N.b();
    }

    private static boolean o(Intent intent) {
        return u(intent) && M(intent);
    }

    public static boolean p(Intent intent) {
        int a16 = a(intent);
        return a16 == js.a.f410914n.b() || a16 == js.a.f410915o.b();
    }

    public static boolean q(int i3) {
        return i3 == js.a.A.b() || w(i3) || A(i3) || m(i3);
    }

    public static boolean t(int i3) {
        return i3 == js.a.f410923w.b();
    }

    public static boolean w(int i3) {
        return i3 == js.a.D.b() || i3 == js.a.C.b();
    }

    public static boolean z(Intent intent) {
        int a16 = a(intent);
        return a16 == js.a.K.b() || a16 == js.a.L.b();
    }

    public static boolean B(Intent intent) {
        return intent != null && a(intent) == js.a.H.b();
    }

    public static boolean C(Intent intent) {
        return intent != null && a(intent) == js.a.U.b();
    }

    public static boolean D(Intent intent) {
        return intent != null && a(intent) == js.a.T.b();
    }

    public static boolean F(Intent intent) {
        return intent != null && a(intent) == js.a.Q.b();
    }

    public static boolean H(Intent intent) {
        return intent != null && a(intent) == js.a.V.b();
    }

    private static boolean M(Intent intent) {
        return intent != null && intent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101;
    }

    public static boolean Q(Intent intent) {
        return intent != null && a(intent) == js.a.f410917q.b();
    }

    public static boolean S(Intent intent) {
        return intent == null || intent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0;
    }

    public static boolean T(Intent intent) {
        return intent == null || intent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 100;
    }

    public static int a(Intent intent) {
        if (intent == null) {
            return js.a.f410904d.b();
        }
        return intent.getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
    }

    public static int b(AEBaseCameraUnit aEBaseCameraUnit) {
        if (aEBaseCameraUnit != null && aEBaseCameraUnit.C() != null) {
            return aEBaseCameraUnit.C().e();
        }
        if (aEBaseCameraUnit == null || aEBaseCameraUnit.z() == null || aEBaseCameraUnit.z().getIntent() == null) {
            return 200;
        }
        return aEBaseCameraUnit.z().getIntent().getIntExtra(AECameraConstants.AECAMERA_MODE, 200);
    }

    public static boolean j(Intent intent) {
        return intent != null && a(intent) == js.a.M.b();
    }

    public static boolean k(Intent intent) {
        return intent != null && a(intent) == js.a.f410912l.b();
    }

    public static boolean n(Intent intent) {
        return Boolean.valueOf(intent != null && a(intent) == js.a.N.b()).booleanValue();
    }

    public static boolean r(Intent intent) {
        return (intent != null && (a(intent) == js.a.A.b() || x(intent))) || B(intent) || n(intent) || v(intent);
    }

    public static boolean s(AEPituCameraUnit aEPituCameraUnit) {
        if (aEPituCameraUnit == null || aEPituCameraUnit.z() == null) {
            return false;
        }
        return r(aEPituCameraUnit.z().getIntent());
    }

    public static boolean v(Intent intent) {
        return intent != null && a(intent) == js.a.O.b();
    }

    public static boolean x(Intent intent) {
        return intent != null && (a(intent) == js.a.C.b() || a(intent) == js.a.D.b());
    }

    public static boolean y(Intent intent) {
        return intent != null && a(intent) == js.a.S.b();
    }

    public static boolean J(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return false;
        }
        int intExtra = activity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        return intExtra == js.a.V.b() || intExtra == js.a.U.b();
    }

    private static boolean u(Intent intent) {
        return intent != null && intent.getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()) == js.a.f410923w.b();
    }

    public static boolean K(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return O(c(intent));
    }

    public static boolean L(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return js.a.f410917q.b() == c(intent);
    }

    public static boolean U(Intent intent, int i3) {
        return (i3 != 14 || S(intent) || T(intent)) ? false : true;
    }

    public static int e(Intent intent) {
        if (intent == null) {
            return 0;
        }
        return intent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0);
    }

    public static boolean h(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return g(intent.getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
    }

    public static boolean i(Intent intent) {
        if (intent == null) {
            return false;
        }
        int a16 = a(intent);
        return a16 == js.a.I.b() || a16 == js.a.J.b() || a16 == js.a.G.b();
    }

    public static int d(Intent intent) {
        if (intent == null) {
            return 100;
        }
        return intent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    }
}
