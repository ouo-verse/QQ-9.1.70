package com.tencent.mobileqq.matchfriend.reborn.drag;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionUnreadCleanUpEvent;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout$OnDragModeChangedListener;", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerDragLayoutPart$onDragModeChangedListener$2 extends Lambda implements Function0<QUIBadgeDragLayout.OnDragModeChangedListener<QUIBadgeDragLayout>> {
    final /* synthetic */ QQStrangerDragLayoutPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerDragLayoutPart$onDragModeChangedListener$2(QQStrangerDragLayoutPart qQStrangerDragLayoutPart) {
        super(0);
        this.this$0 = qQStrangerDragLayoutPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQStrangerDragLayoutPart this$0, boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qUIBadgeDragLayout, "<anonymous parameter 2>");
        if (z16 && i3 == 2) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToast(1, R.string.f169694x30);
                this$0.F9();
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("QQStrangerDragLayoutPart", 2, "OnDragModeChangedListener start unread clean up");
                }
                SimpleEventBus.getInstance().dispatchEvent(new QQStrangerLiteActionUnreadCleanUpEvent(false, new QQStrangerDragLayoutPart$onDragModeChangedListener$2$1$1(this$0)));
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QUIBadgeDragLayout.OnDragModeChangedListener<QUIBadgeDragLayout> invoke() {
        final QQStrangerDragLayoutPart qQStrangerDragLayoutPart = this.this$0;
        return new QUIBadgeDragLayout.OnDragModeChangedListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.drag.d
            @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
            public final void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
                QQStrangerDragLayoutPart$onDragModeChangedListener$2.b(QQStrangerDragLayoutPart.this, z16, i3, qUIBadgeDragLayout);
            }
        };
    }
}
