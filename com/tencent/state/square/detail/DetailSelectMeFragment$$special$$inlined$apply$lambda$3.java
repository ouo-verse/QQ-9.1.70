package com.tencent.state.square.detail;

import android.graphics.Bitmap;
import com.tencent.state.square.bubblesetting.BubbleSkinDownloadManager;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.event.UpdateBubbleSkinEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/state/square/event/UpdateBubbleSkinEvent;", "invoke", "com/tencent/state/square/detail/DetailSelectMeFragment$eventMap$1$3"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectMeFragment$$special$$inlined$apply$lambda$3 extends Lambda implements Function1<UpdateBubbleSkinEvent, Unit> {
    final /* synthetic */ DetailSelectMeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSelectMeFragment$$special$$inlined$apply$lambda$3(DetailSelectMeFragment detailSelectMeFragment) {
        super(1);
        this.this$0 = detailSelectMeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UpdateBubbleSkinEvent updateBubbleSkinEvent) {
        invoke2(updateBubbleSkinEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final UpdateBubbleSkinEvent it) {
        DetailSelectMeView detailSelectMeView;
        Intrinsics.checkNotNullParameter(it, "it");
        detailSelectMeView = this.this$0.selectedView;
        if (detailSelectMeView != null) {
            detailSelectMeView.post(new Runnable() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$$special$$inlined$apply$lambda$3.1
                @Override // java.lang.Runnable
                public final void run() {
                    DetailSelectMeView detailSelectMeView2;
                    if (SquareBubbleSkinKt.useDefault(it.getBubbleInfo())) {
                        detailSelectMeView2 = DetailSelectMeFragment$$special$$inlined$apply$lambda$3.this.this$0.selectedView;
                        if (detailSelectMeView2 != null) {
                            detailSelectMeView2.updateBubbleSkin(it.getBubbleInfo());
                            return;
                        }
                        return;
                    }
                    BubbleSkinDownloadManager.INSTANCE.getBubbleSkinBitmap(it.getBubbleInfo().getSkinLink(), new Function1<Bitmap, Unit>() { // from class: com.tencent.state.square.detail.DetailSelectMeFragment$$special$.inlined.apply.lambda.3.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                            invoke2(bitmap);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Bitmap bitmap) {
                            DetailSelectMeView detailSelectMeView3;
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            SquareBubbleInfo bubbleInfo = it.getBubbleInfo();
                            bubbleInfo.setBitmap(bitmap);
                            detailSelectMeView3 = DetailSelectMeFragment$$special$$inlined$apply$lambda$3.this.this$0.selectedView;
                            if (detailSelectMeView3 != null) {
                                detailSelectMeView3.updateBubbleSkin(bubbleInfo);
                            }
                        }
                    });
                }
            });
        }
    }
}
