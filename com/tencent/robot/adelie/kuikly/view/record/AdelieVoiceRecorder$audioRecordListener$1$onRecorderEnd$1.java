package com.tencent.robot.adelie.kuikly.view.record;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "success", "", "path", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class AdelieVoiceRecorder$audioRecordListener$1$onRecorderEnd$1 extends Lambda implements Function2<Boolean, String, Unit> {
    final /* synthetic */ AdelieVoiceRecorder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieVoiceRecorder$audioRecordListener$1$onRecorderEnd$1(AdelieVoiceRecorder adelieVoiceRecorder) {
        super(2);
        this.this$0 = adelieVoiceRecorder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieVoiceRecorder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e callback = this$0.getCallback();
        if (callback != null) {
            callback.onRecorderEnd();
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
        invoke(bool.booleanValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @NotNull String path) {
        String str;
        Intrinsics.checkNotNullParameter(path, "path");
        this.this$0.wavFilePath = path;
        str = this.this$0.wavFilePath;
        QLog.i("AdelieVoiceRecorder", 1, "wavFile.saveWav result: " + z16 + ", file path = " + str);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final AdelieVoiceRecorder adelieVoiceRecorder = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.view.record.c
            @Override // java.lang.Runnable
            public final void run() {
                AdelieVoiceRecorder$audioRecordListener$1$onRecorderEnd$1.b(AdelieVoiceRecorder.this);
            }
        });
    }
}
