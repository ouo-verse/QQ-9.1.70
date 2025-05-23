package com.tencent.state.square.avatar;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.media.extractor.MediaCoverReportListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/square/avatar/PlayerSourceHelper$extractCover$1$result$1", "Lcom/tencent/state/square/media/extractor/MediaCoverReportListener;", "getCoverDone", "", "cover", "Landroid/graphics/Bitmap;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PlayerSourceHelper$extractCover$1$result$1 extends MediaCoverReportListener {
    final /* synthetic */ PlayerSourceHelper$extractCover$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerSourceHelper$extractCover$1$result$1(PlayerSourceHelper$extractCover$1 playerSourceHelper$extractCover$1) {
        this.this$0 = playerSourceHelper$extractCover$1;
    }

    @Override // com.tencent.state.square.media.extractor.MediaCoverListener
    public void getCoverDone(final Bitmap cover) {
        Intrinsics.checkNotNullParameter(cover, "cover");
        SquareBaseKt.getSquareLog().i("PlayerSourceHelper", "get cover: " + this.this$0.$uniqueId);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.PlayerSourceHelper$extractCover$1$result$1$getCoverDone$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView = PlayerSourceHelper$extractCover$1$result$1.this.this$0.$imageView;
                if (imageView != null) {
                    imageView.setImageBitmap(cover);
                }
            }
        });
    }
}
