package com.tencent.biz.qqcircle.debug.controller;

import a30.a;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleAppMemoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84271b = QCircleDebugKey$MultipleStateKey.QCIRCLE_MEMORY_JAVA_DUMP_CONTROLLER.name();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements a.b {
        a() {
        }

        @Override // a30.a.b
        public void a() {
            ((IQCircleAppMemoryApi) QRoute.api(IQCircleAppMemoryApi.class)).dumpJava(null);
        }
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84271b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182393gc);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        a30.a.c(view.getContext(), new a());
    }
}
