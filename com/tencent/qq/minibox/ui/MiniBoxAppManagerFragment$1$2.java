package com.tencent.qq.minibox.ui;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qq.minibox.manager.MiniBoxDownloadTask;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/qq/minibox/manager/MiniBoxDownloadTask;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
final class MiniBoxAppManagerFragment$1$2 extends Lambda implements Function1<List<? extends MiniBoxDownloadTask>, Unit> {
    final /* synthetic */ MiniBoxAppManagerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniBoxAppManagerFragment$1$2(MiniBoxAppManagerFragment miniBoxAppManagerFragment) {
        super(1);
        this.this$0 = miniBoxAppManagerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MiniBoxAppManagerFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.Sh(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends MiniBoxDownloadTask> list) {
        invoke2((List<MiniBoxDownloadTask>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final List<MiniBoxDownloadTask> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final MiniBoxAppManagerFragment miniBoxAppManagerFragment = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.qq.minibox.ui.y
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxAppManagerFragment$1$2.b(MiniBoxAppManagerFragment.this, it);
            }
        });
    }
}
