package com.tencent.mobileqq.perf.metric;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.perf.metric.config.ScrollHitchConfig;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.d;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ScrollHitchRateMonitor$handler$2 extends Lambda implements Function0<Handler> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ScrollHitchRateMonitor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHitchRateMonitor$handler$2(ScrollHitchRateMonitor scrollHitchRateMonitor) {
        super(0);
        this.this$0 = scrollHitchRateMonitor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scrollHitchRateMonitor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean b(ScrollHitchRateMonitor this$0, Message msg2) {
        long j3;
        long j16;
        long j17;
        long j18;
        Long longOrNull;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            j3 = this$0.frameIndex;
            if (j3 < 3) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Scroll finish and reset, frame index:");
                    j16 = this$0.frameIndex;
                    sb5.append(j16);
                    QLog.d("ScrollHitchRate", 2, sb5.toString());
                }
                this$0.g();
            }
        } else if (i3 == 2) {
            Object obj = msg2.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("hitchDuration");
            if (str != null && longOrNull2 != null) {
                j17 = longOrNull2.longValue();
            } else {
                j17 = 0;
            }
            double d16 = j17 * 1000;
            String str2 = (String) hashMap.get("scrollDuration");
            if (str2 != null && longOrNull != null) {
                j18 = longOrNull.longValue();
            } else {
                j18 = 1;
            }
            double d17 = d16 / j18;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d17)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            hashMap.put("hitchRate", format);
            if (QLog.isColorLevel()) {
                QLog.d("ScrollHitchRate", 2, "**** HitchRate:" + ((String) hashMap.get("hitchRate")) + ", scene:" + ((String) hashMap.get("scene")) + ", total:" + ((String) hashMap.get("scrollDuration")) + ", hitched:" + ((String) hashMap.get("hitchDuration")) + ", index:" + ((String) hashMap.get("frameIndex")) + " ****");
            }
            if (Random.INSTANCE.nextDouble() <= ScrollHitchConfig.INSTANCE.a().d()) {
                hashMap.put("deviceLevel", String.valueOf(d.f363413a.a()));
                QQBeaconReport.report(PerfReportUtil.c(), "scroll_hitch_rate", hashMap);
            }
        }
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Handler invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Handler) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Looper looper = QQPerfHandlerThreadManager.INSTANCE.d().getLooper();
        final ScrollHitchRateMonitor scrollHitchRateMonitor = this.this$0;
        return new Handler(looper, new Handler.Callback() { // from class: com.tencent.mobileqq.perf.metric.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean b16;
                b16 = ScrollHitchRateMonitor$handler$2.b(ScrollHitchRateMonitor.this, message);
                return b16;
            }
        });
    }
}
