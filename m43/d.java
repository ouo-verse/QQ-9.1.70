package m43;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lm43/d;", "", "", "allowShowAuth", "", "b", "", "initStep", "allowAuth", "a", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f416148a = new d();

    d() {
    }

    private final void b(boolean allowShowAuth) {
        QLog.e("OppoStepManager", 1, "startQueryTodayStep " + allowShowAuth);
        b.f416141a.h(allowShowAuth);
    }

    public final int a(int initStep, boolean allowAuth) {
        QLog.d("OppoStepManager", 1, "queryOpppSdkTodaySteps start originStep=" + initStep);
        b(allowAuth);
        int a16 = c.f416147a.a();
        if (initStep < a16) {
            initStep = a16;
        }
        QLog.d("OppoStepManager", 1, "queryOpppSdkTodaySteps finish originStep=" + initStep);
        return initStep;
    }
}
