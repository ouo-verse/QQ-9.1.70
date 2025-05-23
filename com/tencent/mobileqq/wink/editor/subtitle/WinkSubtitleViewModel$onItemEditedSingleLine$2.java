package com.tencent.mobileqq.wink.editor.subtitle;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkSubtitleViewModel$onItemEditedSingleLine$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function2<String, Boolean, Unit> $callBack;
    final /* synthetic */ String $content;
    final /* synthetic */ Subtitle $copy;
    final /* synthetic */ Runnable $runnable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkSubtitleViewModel$onItemEditedSingleLine$2(Runnable runnable, String str, Function2<? super String, ? super Boolean, Unit> function2, Subtitle subtitle) {
        super(1);
        this.$runnable = runnable;
        this.$content = str;
        this.$callBack = function2;
        this.$copy = subtitle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable, String content, Function2 callBack, boolean z16, Subtitle copy) {
        boolean z17;
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        Intrinsics.checkNotNullParameter(content, "$content");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        Intrinsics.checkNotNullParameter(copy, "$copy");
        runnable.run();
        if (content.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            callBack.invoke(content, Boolean.valueOf(z16));
        } else {
            callBack.invoke(copy.getTranslate(), Boolean.valueOf(z16));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean z16) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Runnable runnable = this.$runnable;
        final String str = this.$content;
        final Function2<String, Boolean, Unit> function2 = this.$callBack;
        final Subtitle subtitle = this.$copy;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.subtitle.aw
            @Override // java.lang.Runnable
            public final void run() {
                WinkSubtitleViewModel$onItemEditedSingleLine$2.b(runnable, str, function2, z16, subtitle);
            }
        });
    }
}
