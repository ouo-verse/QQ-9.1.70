package com.tencent.mobileqq.vas.gift;

import android.os.Handler;
import com.tencent.mobileqq.aio.msg.ai;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class TroopGiftView$loadArkData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $curPagFile;
    final /* synthetic */ a $giftListener;
    final /* synthetic */ ai $troopGiftItem;
    final /* synthetic */ TroopGiftView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGiftView$loadArkData$1(TroopGiftView troopGiftView, ai aiVar, String str, a aVar) {
        super(0);
        this.this$0 = troopGiftView;
        this.$troopGiftItem = aiVar;
        this.$curPagFile = str;
        this.$giftListener = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopGiftView this$0, ai troopGiftItem, String curPagFile, a giftListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopGiftItem, "$troopGiftItem");
        Intrinsics.checkNotNullParameter(curPagFile, "$curPagFile");
        Intrinsics.checkNotNullParameter(giftListener, "$giftListener");
        this$0.A(troopGiftItem, curPagFile, giftListener);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final TroopGiftView troopGiftView = this.this$0;
        final ai aiVar = this.$troopGiftItem;
        final String str = this.$curPagFile;
        final a aVar = this.$giftListener;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.gift.n
            @Override // java.lang.Runnable
            public final void run() {
                TroopGiftView$loadArkData$1.b(TroopGiftView.this, aiVar, str, aVar);
            }
        });
    }
}
