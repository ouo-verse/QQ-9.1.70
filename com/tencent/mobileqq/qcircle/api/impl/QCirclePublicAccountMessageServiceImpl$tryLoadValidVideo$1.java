package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
final class QCirclePublicAccountMessageServiceImpl$tryLoadValidVideo$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ QCirclePublicAccountMessageServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCirclePublicAccountMessageServiceImpl$tryLoadValidVideo$1(QCirclePublicAccountMessageServiceImpl qCirclePublicAccountMessageServiceImpl) {
        super(1);
        this.this$0 = qCirclePublicAccountMessageServiceImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final QCirclePublicAccountMessageServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fetchLastMessageInfo(new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl$tryLoadValidVideo$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                if (qCirclePublicAccountMessageInfo == null) {
                    return;
                }
                QCirclePublicAccountMessageServiceImpl.this.loadValidVideo(qCirclePublicAccountMessageInfo);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        if (!z16) {
            QLog.i(QCirclePublicAccountMessageServiceImpl.TAG, 1, "tryLoadValidVideo, has not unReadMessage, return");
        } else {
            final QCirclePublicAccountMessageServiceImpl qCirclePublicAccountMessageServiceImpl = this.this$0;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    QCirclePublicAccountMessageServiceImpl$tryLoadValidVideo$1.b(QCirclePublicAccountMessageServiceImpl.this);
                }
            }, 128, null, false);
        }
    }
}
