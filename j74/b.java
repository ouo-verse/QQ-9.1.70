package j74;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002J\u001a\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lj74/b;", "", "", "g", "", "f", "key", "d", "urlTemplate", "", h.F, "c", "b", "a", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f409622a = new b();

    b() {
    }

    private final String g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentUin();
        }
        return null;
    }

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        return false;
    }

    public final String d(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return "";
    }

    public final void h(String key, String urlTemplate) {
        Intrinsics.checkNotNullParameter(key, "key");
        String g16 = g();
        if (TextUtils.isEmpty(urlTemplate)) {
            a.f409621a.f(g16, key, "");
            return;
        }
        a aVar = a.f409621a;
        Intrinsics.checkNotNull(urlTemplate);
        aVar.f(g16, key, urlTemplate);
    }

    public final boolean f() {
        QLog.i("ZPlanDebugUtils_", 1, "getForceHideLoadingSwitch isPublicVersion, default false");
        return false;
    }

    public static /* synthetic */ String e(b bVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "zplan_debug_lite_url_temp";
        }
        return bVar.d(str);
    }
}
