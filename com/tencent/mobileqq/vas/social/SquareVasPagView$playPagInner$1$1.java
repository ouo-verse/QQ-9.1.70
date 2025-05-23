package com.tencent.mobileqq.vas.social;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.util.WeakReference;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pagFile", "Lorg/libpag/PAGFile;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SquareVasPagView$playPagInner$1$1 extends Lambda implements Function1<PAGFile, Unit> {
    final /* synthetic */ int $repeatCount;
    final /* synthetic */ WeakReference<PAGView> $weakPagView;
    final /* synthetic */ SquareVasPagView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareVasPagView$playPagInner$1$1(WeakReference<PAGView> weakReference, SquareVasPagView squareVasPagView, int i3) {
        super(1);
        this.$weakPagView = weakReference;
        this.this$0 = squareVasPagView;
        this.$repeatCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(WeakReference weakPagView, PAGFile pAGFile, SquareVasPagView this$0, int i3) {
        Intrinsics.checkNotNullParameter(weakPagView, "$weakPagView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PAGView pAGView = (PAGView) weakPagView.get();
        if (pAGView != null) {
            pAGView.setComposition(pAGFile);
        }
        this$0.n((PAGView) weakPagView.get(), i3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PAGFile pAGFile) {
        invoke2(pAGFile);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final PAGFile pAGFile) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WeakReference<PAGView> weakReference = this.$weakPagView;
        final SquareVasPagView squareVasPagView = this.this$0;
        final int i3 = this.$repeatCount;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.social.l
            @Override // java.lang.Runnable
            public final void run() {
                SquareVasPagView$playPagInner$1$1.b(WeakReference.this, pAGFile, squareVasPagView, i3);
            }
        });
    }
}
