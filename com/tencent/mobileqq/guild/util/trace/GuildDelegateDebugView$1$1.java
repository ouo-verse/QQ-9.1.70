package com.tencent.mobileqq.guild.util.trace;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildDelegateDebugView$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GuildDelegateDebugView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDelegateDebugView$1$1(GuildDelegateDebugView guildDelegateDebugView) {
        super(1);
        this.this$0 = guildDelegateDebugView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildDelegateDebugView this$0, String it) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        textView = this$0.textView;
        textView.setText(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GuildDelegateDebugView guildDelegateDebugView = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.trace.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildDelegateDebugView$1$1.b(GuildDelegateDebugView.this, it);
            }
        });
    }
}
