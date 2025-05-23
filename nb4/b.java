package nb4;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.f;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\f"}, d2 = {"Lnb4/b;", "", "", "b", "", "c", "", "a", "Ljava/lang/String;", "mVersionInfo", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f419779a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String mVersionInfo;

    static {
        b bVar = new b();
        f419779a = bVar;
        String b16 = bVar.b();
        mVersionInfo = b16;
        QLog.i("ZPlanPortalVerUtil_", 1, "mVersionInfo:" + b16);
    }

    b() {
    }

    private final String b() {
        int a16 = f.a(BaseApplication.context);
        return f.b(BaseApplication.context) + "#" + a16;
    }

    public final boolean a() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(mVersionInfo, false);
    }

    public final void c() {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(mVersionInfo, true);
    }
}
