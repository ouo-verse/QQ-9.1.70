package com.tencent.luggage.wxa.ka;

import android.content.Intent;
import android.os.Parcelable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f131819a;

        public a(Function1 function1) {
            this.f131819a = function1;
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(Parcelable data) {
            Function1 function1 = this.f131819a;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            function1.invoke(data);
        }
    }

    public static /* synthetic */ void a(String str, Parcelable parcelable, f fVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        a(str, parcelable, fVar, function1);
    }

    public static final void a(String targetProcessName, Parcelable parcelable, f process, Function1 function1) {
        Intrinsics.checkNotNullParameter(targetProcessName, "targetProcessName");
        Intrinsics.checkNotNullParameter(process, "process");
        o.a(targetProcessName, parcelable, process.getClass(), function1 != null ? new a(function1) : null);
    }

    public static final Parcelable a(String targetProcessName, Parcelable parcelable, r process) {
        Intrinsics.checkNotNullParameter(targetProcessName, "targetProcessName");
        Intrinsics.checkNotNullParameter(process, "process");
        return o.a(targetProcessName, parcelable, process.getClass());
    }

    public static final void a(Intent intent) {
        if (intent != null) {
            com.tencent.luggage.wxa.ta.c.c("MicoMsg.proc.ServiceConnection", "#tagOfServiceIntent: " + intent.getStringExtra("ams_pull_service_proc") + ", caller=" + intent.getStringExtra("ams_pull_service_from") + ", id=" + intent.getIntExtra("ams_pull_service_id", -1), new Object[0]);
        }
    }
}
