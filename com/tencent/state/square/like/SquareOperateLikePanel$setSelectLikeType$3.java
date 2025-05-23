package com.tencent.state.square.like;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.utils.SquarePagViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOperateLikePanel$setSelectLikeType$3 implements Runnable {
    final /* synthetic */ int $likeType;
    final /* synthetic */ SquareOperateLikePanel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareOperateLikePanel$setSelectLikeType$3(SquareOperateLikePanel squareOperateLikePanel, int i3) {
        this.this$0 = squareOperateLikePanel;
        this.$likeType = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ISquarePagView iSquarePagView;
        iSquarePagView = this.this$0.pagView;
        if (iSquarePagView != null) {
            SquarePagViewUtils.INSTANCE.playFile(iSquarePagView, R.raw.f130982, 1, new Function1<ISquarePagView, Unit>() { // from class: com.tencent.state.square.like.SquareOperateLikePanel$setSelectLikeType$3$$special$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ISquarePagView iSquarePagView2) {
                    invoke2(iSquarePagView2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ISquarePagView iSquarePagView2) {
                    Integer num = LikeData.INSTANCE.getTYPE_IMG_RES().get(Integer.valueOf(SquareOperateLikePanel$setSelectLikeType$3.this.$likeType));
                    if (num != null) {
                        int intValue = num.intValue();
                        if (iSquarePagView2 != null) {
                            Context context = SquareOperateLikePanel$setSelectLikeType$3.this.this$0.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            iSquarePagView2.replaceImageLayer(0, BitmapFactory.decodeResource(context.getResources(), intValue));
                        }
                    }
                }
            });
        }
    }
}
