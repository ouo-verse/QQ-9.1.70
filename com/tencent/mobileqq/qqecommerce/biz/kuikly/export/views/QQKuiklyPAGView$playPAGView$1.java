package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.util.WeakReference;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class QQKuiklyPAGView$playPAGView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WeakReference<QQKuiklyPAGView> $selfRef;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyPAGView$playPAGView$1(WeakReference<QQKuiklyPAGView> weakReference) {
        super(0);
        this.$selfRef = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        r1 = r1.pagView;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(WeakReference selfRef) {
        PAGView pAGView;
        Intrinsics.checkNotNullParameter(selfRef, "$selfRef");
        QQKuiklyPAGView qQKuiklyPAGView = (QQKuiklyPAGView) selfRef.get();
        if (qQKuiklyPAGView == null || pAGView == null) {
            return;
        }
        pAGView.play();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final WeakReference<QQKuiklyPAGView> weakReference = this.$selfRef;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.g
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyPAGView$playPAGView$1.b(WeakReference.this);
            }
        });
    }
}
