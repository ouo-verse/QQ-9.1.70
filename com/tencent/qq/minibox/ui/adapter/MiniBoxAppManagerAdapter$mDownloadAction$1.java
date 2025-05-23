package com.tencent.qq.minibox.ui.adapter;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qq.minibox.manager.MiniBoxDownloadTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class MiniBoxAppManagerAdapter$mDownloadAction$1 extends Lambda implements Function1<MiniBoxDownloadTask, Unit> {
    final /* synthetic */ MiniBoxAppManagerAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniBoxAppManagerAdapter$mDownloadAction$1(MiniBoxAppManagerAdapter miniBoxAppManagerAdapter) {
        super(1);
        this.this$0 = miniBoxAppManagerAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MiniBoxAppManagerAdapter this$0, MiniBoxDownloadTask it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.x0(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MiniBoxDownloadTask miniBoxDownloadTask) {
        invoke2(miniBoxDownloadTask);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final MiniBoxDownloadTask it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final MiniBoxAppManagerAdapter miniBoxAppManagerAdapter = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.qq.minibox.ui.adapter.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxAppManagerAdapter$mDownloadAction$1.b(MiniBoxAppManagerAdapter.this, it);
            }
        });
    }
}
