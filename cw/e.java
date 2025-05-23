package cw;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class e {
    public static void a(long j3, VideoAppInterface videoAppInterface) {
        if (videoAppInterface == null) {
            return;
        }
        QLog.w("NewTipsManager", 1, "hideAllTips, seq[" + j3 + "]");
        ju.a aVar = (ju.a) videoAppInterface.B(11);
        if (aVar != null) {
            aVar.B();
        }
    }

    @Deprecated
    public static void b(VideoAppInterface videoAppInterface, boolean z16) {
        if (videoAppInterface == null) {
            return;
        }
        ((ju.a) videoAppInterface.B(11)).y(z16);
    }

    public static void c(VideoAppInterface videoAppInterface) {
        if (videoAppInterface == null) {
            return;
        }
        ((ju.a) videoAppInterface.B(11)).z();
    }

    public static void d(VideoAppInterface videoAppInterface, int i3) {
        if (videoAppInterface == null) {
            return;
        }
        ((ju.a) videoAppInterface.B(11)).l(i3);
    }

    public static void e(VideoAppInterface videoAppInterface) {
        if (videoAppInterface == null) {
            return;
        }
        ((ju.a) videoAppInterface.B(11)).m();
    }

    public static void f(VideoAppInterface videoAppInterface) {
        if (videoAppInterface == null) {
            return;
        }
        ((ju.a) videoAppInterface.B(11)).s();
    }

    @Deprecated
    public static boolean g(VideoAppInterface videoAppInterface, int i3, long j3) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).D(i3, j3);
    }

    @Deprecated
    public static boolean h(VideoAppInterface videoAppInterface, int i3, long j3, boolean z16) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).E(i3, j3, z16);
    }

    @Deprecated
    public static boolean i(VideoAppInterface videoAppInterface, String str, long j3, boolean z16) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).F(str, j3, z16);
    }

    public static boolean j(VideoAppInterface videoAppInterface, int i3, View.OnClickListener onClickListener) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).J(i3, onClickListener);
    }

    public static boolean k(VideoAppInterface videoAppInterface, int i3, String str, View.OnClickListener onClickListener) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).L(i3, str, null, -1, onClickListener);
    }

    public static boolean l(VideoAppInterface videoAppInterface, int i3, String str, String str2, View.OnClickListener onClickListener) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).r(i3, str, str2, null, -1, onClickListener);
    }

    public static boolean m(VideoAppInterface videoAppInterface, c cVar) {
        ju.a aVar;
        if (videoAppInterface == null || cVar == null || (aVar = (ju.a) videoAppInterface.B(11)) == null) {
            return false;
        }
        return aVar.H(cVar);
    }

    public static boolean n(VideoAppInterface videoAppInterface, int i3) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).p(i3);
    }

    public static boolean o(VideoAppInterface videoAppInterface, int i3, int i16) {
        if (videoAppInterface == null) {
            return false;
        }
        return p(videoAppInterface, i3, videoAppInterface.getApp().getString(i16));
    }

    public static boolean p(VideoAppInterface videoAppInterface, int i3, String str) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).q(i3, str);
    }

    public static boolean q(VideoAppInterface videoAppInterface, int i3, String str, Drawable drawable, int i16, View.OnClickListener onClickListener) {
        if (videoAppInterface == null) {
            return false;
        }
        return ((ju.a) videoAppInterface.B(11)).L(i3, str, drawable, i16, onClickListener);
    }
}
