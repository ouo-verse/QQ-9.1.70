package com.tencent.mobileqq.vas.gift;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pagView", "Lorg/libpag/PAGView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class TroopGiftPagView$show$1 extends Lambda implements Function1<PAGView, Unit> {
    final /* synthetic */ TroopGiftPagView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftPagView$show$1(TroopGiftPagView troopGiftPagView) {
        super(1);
        this.this$0 = troopGiftPagView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopGiftPagView this$0, PAGView pagView) {
        PAGFile pAGFile;
        PAGFile pAGFile2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pagView, "$pagView");
        this$0.s();
        pAGFile = this$0.headPagFile;
        this$0.x(pAGFile, true);
        pAGFile2 = this$0.jumpPagFile;
        this$0.x(pAGFile2, false);
        this$0.mSendIconBm = null;
        this$0.mRecIconBm = null;
        this$0.v(pagView);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
        invoke2(pAGView);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final PAGView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        final TroopGiftPagView troopGiftPagView = this.this$0;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.i
            @Override // java.lang.Runnable
            public final void run() {
                TroopGiftPagView$show$1.b(TroopGiftPagView.this, pagView);
            }
        }, 16, null, true);
    }
}
