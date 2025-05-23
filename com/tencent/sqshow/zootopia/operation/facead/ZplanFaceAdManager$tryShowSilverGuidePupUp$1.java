package com.tencent.sqshow.zootopia.operation.facead;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanFaceAdManager$tryShowSilverGuidePupUp$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ZplanFaceAdManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanFaceAdManager$tryShowSilverGuidePupUp$1(ZplanFaceAdManager zplanFaceAdManager) {
        super(0);
        this.this$0 = zplanFaceAdManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZplanFaceAdManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ViewGroup viewGroup;
        viewGroup = this.this$0.fragmentContainer;
        if (viewGroup != null) {
            final ZplanFaceAdManager zplanFaceAdManager = this.this$0;
            viewGroup.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.operation.facead.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanFaceAdManager$tryShowSilverGuidePupUp$1.b(ZplanFaceAdManager.this);
                }
            });
        }
    }
}
