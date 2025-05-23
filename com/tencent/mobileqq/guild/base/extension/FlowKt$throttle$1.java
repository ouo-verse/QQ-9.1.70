package com.tencent.mobileqq.guild.base.extension;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes12.dex */
public final class FlowKt$throttle$1 extends Lambda implements Function1<Object, Long> {
    final /* synthetic */ Ref.LongRef $fireTime;
    final /* synthetic */ long $timeout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt$throttle$1(Ref.LongRef longRef, long j3) {
        super(1);
        this.$fireTime = longRef;
        this.$timeout = j3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Long invoke(Object obj) {
        long j3;
        long uptimeMillis = SystemClock.uptimeMillis();
        Ref.LongRef longRef = this.$fireTime;
        long j16 = uptimeMillis - longRef.element;
        long j17 = this.$timeout;
        if (j16 > j17) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("FlowEx", "throttle: " + longRef.element + ", immediately");
            }
            j3 = 0;
        } else {
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("FlowEx", "throttle: " + longRef.element + ", wait " + (j17 - j16));
            }
            j3 = this.$timeout - j16;
        }
        return Long.valueOf(j3);
    }
}
