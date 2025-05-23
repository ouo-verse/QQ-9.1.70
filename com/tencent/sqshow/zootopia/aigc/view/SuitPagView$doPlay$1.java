package com.tencent.sqshow.zootopia.aigc.view;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pagView", "Lorg/libpag/PAGView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class SuitPagView$doPlay$1 extends Lambda implements Function1<PAGView, Unit> {
    final /* synthetic */ Bitmap $image;
    final /* synthetic */ Integer $imageIdex;
    final /* synthetic */ String $pagFilePath;
    final /* synthetic */ int $repeatCount;
    final /* synthetic */ SuitPagView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitPagView$doPlay$1(Bitmap bitmap, String str, int i3, Integer num, SuitPagView suitPagView) {
        super(1);
        this.$image = bitmap;
        this.$pagFilePath = str;
        this.$repeatCount = i3;
        this.$imageIdex = num;
        this.this$0 = suitPagView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuitPagView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View mOuterPlaceholderView = this$0.getMOuterPlaceholderView();
        if (mOuterPlaceholderView != null) {
            mOuterPlaceholderView.setVisibility(8);
        }
        this$0.getMBinding().f419202b.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
        invoke2(pAGView);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PAGView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        if (this.$image == null) {
            pagView.setComposition(PagViewMonitor.Load(this.$pagFilePath));
            pagView.setScaleMode(3);
            pagView.setRepeatCount(this.$repeatCount);
        } else {
            PAGFile Load = PagViewMonitor.Load(this.$pagFilePath);
            PAGImage FromBitmap = PAGImage.FromBitmap(this.$image);
            Integer num = this.$imageIdex;
            Load.replaceImage(num != null ? num.intValue() : 0, FromBitmap);
            pagView.setComposition(Load);
            pagView.setScaleMode(3);
            pagView.setRepeatCount(this.$repeatCount);
        }
        if (this.this$0.getMEnablePlay()) {
            pagView.play();
            final SuitPagView suitPagView = this.this$0;
            suitPagView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.aigc.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    SuitPagView$doPlay$1.b(SuitPagView.this);
                }
            });
            return;
        }
        pagView.stop();
    }
}
