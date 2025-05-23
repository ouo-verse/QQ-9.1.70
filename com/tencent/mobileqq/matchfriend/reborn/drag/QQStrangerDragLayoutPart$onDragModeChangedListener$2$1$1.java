package com.tencent.mobileqq.matchfriend.reborn.drag;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.msg.f;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class QQStrangerDragLayoutPart$onDragModeChangedListener$2$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ QQStrangerDragLayoutPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerDragLayoutPart$onDragModeChangedListener$2$1$1(QQStrangerDragLayoutPart qQStrangerDragLayoutPart) {
        super(1);
        this.this$0 = qQStrangerDragLayoutPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16, QQStrangerDragLayoutPart this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QQStrangerDragLayoutPart", 1, "setMsgReadByChatType result: " + i3 + ", errMsg: " + str);
        if (!z16 || i3 != 0) {
            QQToastUtil.showQQToast(1, R.string.f169694x30);
        }
        this$0.F9();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final boolean z16) {
        QLog.i("QQStrangerDragLayoutPart", 1, "QQStrangerLiteActionUnreadCleanUpEvent result: " + z16);
        w e16 = f.e();
        if (e16 != null) {
            final QQStrangerDragLayoutPart qQStrangerDragLayoutPart = this.this$0;
            e16.setMsgReadByChatType(104, new IOperateCallback() { // from class: com.tencent.mobileqq.matchfriend.reborn.drag.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQStrangerDragLayoutPart$onDragModeChangedListener$2$1$1.b(z16, qQStrangerDragLayoutPart, i3, str);
                }
            });
        }
    }
}
