package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class BaseViewHolderV2$fetchStateTextAsync$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ BaseViewHolderV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolderV2$fetchStateTextAsync$1(BaseViewHolderV2 baseViewHolderV2) {
        super(1);
        this.this$0 = baseViewHolderV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BaseViewHolderV2 this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.q(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        final BaseViewHolderV2 baseViewHolderV2 = this.this$0;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseViewHolderV2$fetchStateTextAsync$1.b(BaseViewHolderV2.this, it);
            }
        });
    }
}
