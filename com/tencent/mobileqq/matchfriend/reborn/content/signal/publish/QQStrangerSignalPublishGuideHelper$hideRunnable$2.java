package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish;

import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishGuideHelper$hideRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ QQStrangerSignalPublishGuideHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalPublishGuideHelper$hideRunnable$2(QQStrangerSignalPublishGuideHelper qQStrangerSignalPublishGuideHelper) {
        super(0);
        this.this$0 = qQStrangerSignalPublishGuideHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQStrangerSignalPublishGuideHelper this$0) {
        ObjectAnimator l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l3 = this$0.l();
        l3.start();
    }

    @Override // kotlin.jvm.functions.Function0
    public final Runnable invoke() {
        final QQStrangerSignalPublishGuideHelper qQStrangerSignalPublishGuideHelper = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.c
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerSignalPublishGuideHelper$hideRunnable$2.b(QQStrangerSignalPublishGuideHelper.this);
            }
        };
    }
}
