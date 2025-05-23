package com.tencent.mobileqq.vashealth.honorstep;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vashealth/honorstep/h;", "", "", "allowShowAuth", "", "b", "", "initStep", "allowAuth", "a", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f312298a = new h();

    h() {
    }

    private final void b(boolean allowShowAuth) {
        QLog.e("HonorStepManager", 1, "startQueryTodayStep " + allowShowAuth);
        e.f312286a.l(allowShowAuth);
    }

    public final int a(int initStep, boolean allowAuth) {
        QLog.d("HonorStepManager", 1, "queryHonorSdkTodaySteps start originStep=" + initStep);
        b(allowAuth);
        int h16 = g.f312292a.h();
        if (initStep < h16) {
            initStep = h16;
        }
        QLog.d("HonorStepManager", 1, "queryHonorSdkTodaySteps finish originStep=" + initStep);
        return initStep;
    }
}
