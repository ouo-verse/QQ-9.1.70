package com.tencent.hippykotlin.demo.pages.vas_base.vlog;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.Keport;
import com.tencent.hippykotlin.demo.pages.vas_base.report.keport.LogParam;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VLog {
    public static final Companion Companion = new Companion();
    public static final Lazy<VLog> instance$delegate;
    public static int reportLevel;
    public final Keport keport = new Keport();
    public final String module;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final VLog getInstance() {
            return VLog.instance$delegate.getValue();
        }
    }

    static {
        Lazy<VLog> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<VLog>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog$Companion$instance$2
            @Override // kotlin.jvm.functions.Function0
            public final VLog invoke() {
                return new VLog("Main");
            }
        });
        instance$delegate = lazy;
        reportLevel = 2;
    }

    public VLog(String str) {
        this.module = str;
    }

    public final String getTag() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("$VLog:");
        m3.append(this.module);
        return m3.toString();
    }

    public static void debug$default(VLog vLog, String str, boolean z16, int i3, Object obj) {
        vLog.log$enumunboxing$(str, 1, true);
    }

    public final void log$enumunboxing$(final String str, final int i3, boolean z16) {
        if (i3 == 0) {
            throw null;
        }
        int i16 = i3 - 1;
        if (i16 == 0) {
            KLog.INSTANCE.d(getTag(), str);
        } else if (i16 == 1) {
            KLog.INSTANCE.i(getTag(), str);
        } else if (i16 == 2) {
            KLog.INSTANCE.e(getTag(), str);
        }
        if (z16) {
            int i17 = reportLevel;
            if (i3 == 0) {
                throw null;
            }
            if (i17 == 0) {
                throw null;
            }
            if (i3 - i17 >= 0) {
                this.keport.logAggregator.add(new LogParam(i3, str, this.module, null));
            } else {
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Keport keport = VLog.this.keport;
                        keport.logAggregator.add(new LogParam(i3, str, VLog.this.module, null));
                        return Unit.INSTANCE;
                    }
                };
                if (c.f117352a.g().getPageData().u()) {
                    function0.invoke();
                }
            }
        }
    }
}
