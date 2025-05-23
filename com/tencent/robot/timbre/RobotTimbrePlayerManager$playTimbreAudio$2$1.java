package com.tencent.robot.timbre;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "ttsInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotTimbrePlayerManager$playTimbreAudio$2$1 extends Lambda implements Function2<TtsInfo, String, Unit> {
    final /* synthetic */ RobotTimbrePlayerManager $this_run;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotTimbrePlayerManager$playTimbreAudio$2$1(RobotTimbrePlayerManager robotTimbrePlayerManager) {
        super(2);
        this.$this_run = robotTimbrePlayerManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        r1 = r1.onDownloadCompleted;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(RobotTimbrePlayerManager this_run, TtsInfo ttsInfo) {
        TtsInfo ttsInfo2;
        Function2 function2;
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(ttsInfo, "$ttsInfo");
        ttsInfo2 = this_run.pendingPlayTtsInfo;
        if (Intrinsics.areEqual(ttsInfo2, ttsInfo) && function2 != null) {
            function2.invoke(Boolean.FALSE, ttsInfo);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo, String str) {
        invoke2(ttsInfo, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        r4 = r2.$this_run.onDownloadCompleted;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(@NotNull final TtsInfo ttsInfo, @NotNull String str) {
        TtsInfo ttsInfo2;
        Function2 function2;
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ttsInfo2 = this.$this_run.pendingPlayTtsInfo;
            if (!Intrinsics.areEqual(ttsInfo2, ttsInfo) || function2 == null) {
                return;
            }
            function2.invoke(Boolean.FALSE, ttsInfo);
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final RobotTimbrePlayerManager robotTimbrePlayerManager = this.$this_run;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.timbre.b
            @Override // java.lang.Runnable
            public final void run() {
                RobotTimbrePlayerManager$playTimbreAudio$2$1.b(RobotTimbrePlayerManager.this, ttsInfo);
            }
        });
    }
}
