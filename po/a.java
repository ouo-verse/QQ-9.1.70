package po;

import android.text.TextUtils;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lpo/a;", "", "", "scene", "", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f426574a = new a();

    a() {
    }

    public final void a(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (TextUtils.isEmpty(scene)) {
            return;
        }
        QLog.d("QZoneRMonitorUtils", 4, "traceEnd: " + scene);
        IPerfApi iPerfApi = (IPerfApi) QRoute.api(IPerfApi.class);
        if (iPerfApi != null) {
            iPerfApi.traceEnd(scene);
        }
    }

    public final void b(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (TextUtils.isEmpty(scene)) {
            return;
        }
        QLog.d("QZoneRMonitorUtils", 4, "traceStart: " + scene);
        IPerfApi iPerfApi = (IPerfApi) QRoute.api(IPerfApi.class);
        if (iPerfApi != null) {
            iPerfApi.traceStart(scene);
        }
    }
}
