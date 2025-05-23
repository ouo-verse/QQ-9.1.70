package com.tencent.robot.timbre;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "ttsInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "path", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotTimbrePlayerManager$playTimbreAudio$2$2 extends Lambda implements Function2<TtsInfo, String, Unit> {
    final /* synthetic */ RobotTimbrePlayerManager $this_run;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotTimbrePlayerManager$playTimbreAudio$2$2(RobotTimbrePlayerManager robotTimbrePlayerManager) {
        super(2);
        this.$this_run = robotTimbrePlayerManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotTimbrePlayerManager this_run, TtsInfo ttsInfo, String path) {
        Function2 function2;
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(ttsInfo, "$ttsInfo");
        Intrinsics.checkNotNullParameter(path, "$path");
        function2 = this_run.onDownloadCompleted;
        if (function2 != null) {
            function2.invoke(Boolean.TRUE, ttsInfo);
        }
        d dVar = d.f368605a;
        String str = ttsInfo.ttsExample;
        Intrinsics.checkNotNullExpressionValue(str, "ttsInfo.ttsExample");
        String str2 = ttsInfo.ttsId;
        Intrinsics.checkNotNullExpressionValue(str2, "ttsInfo.ttsId");
        dVar.f(str, str2, path);
        this_run.w(ttsInfo, path);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo, String str) {
        invoke2(ttsInfo, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final TtsInfo ttsInfo, @NotNull final String path) {
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        Intrinsics.checkNotNullParameter(path, "path");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final RobotTimbrePlayerManager robotTimbrePlayerManager = this.$this_run;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.timbre.c
            @Override // java.lang.Runnable
            public final void run() {
                RobotTimbrePlayerManager$playTimbreAudio$2$2.b(RobotTimbrePlayerManager.this, ttsInfo, path);
            }
        });
    }
}
