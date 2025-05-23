package com.tencent.mobileqq.wink.editor.subtitle;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkSubtitleViewModel$edit$1$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Runnable $runnable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSubtitleViewModel$edit$1$3(Runnable runnable) {
        super(1);
        this.$runnable = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.run();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Runnable runnable = this.$runnable;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.av
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleViewModel$edit$1$3.b(runnable);
            }
        });
    }
}
