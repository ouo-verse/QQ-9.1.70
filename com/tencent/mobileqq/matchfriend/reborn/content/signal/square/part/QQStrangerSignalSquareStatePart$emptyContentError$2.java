package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareRefreshEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class QQStrangerSignalSquareStatePart$emptyContentError$2 extends Lambda implements Function0<QUIEmptyState> {
    final /* synthetic */ QQStrangerSignalSquareStatePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalSquareStatePart$emptyContentError$2(QQStrangerSignalSquareStatePart qQStrangerSignalSquareStatePart) {
        super(0);
        this.this$0 = qQStrangerSignalSquareStatePart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        SimpleEventBus.getInstance().dispatchEvent(QQStrangerSignalSquareRefreshEvent.INSTANCE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QUIEmptyState invoke() {
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(5);
        String string = this.this$0.getContext().getString(R.string.x0e);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026tch_friend_network_error)");
        QUIEmptyState.Builder halfScreenState = imageType.setTitle(string).setHalfScreenState(true);
        String string2 = this.this$0.getContext().getString(R.string.x3w);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026qq_stranger_square_retry)");
        QUIEmptyState build = halfScreenState.setButton(string2, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerSignalSquareStatePart$emptyContentError$2.b(view);
            }
        }).setBackgroundColorType(0).build();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        build.setGravity(17);
        build.setLayoutParams(layoutParams);
        return build;
    }
}
