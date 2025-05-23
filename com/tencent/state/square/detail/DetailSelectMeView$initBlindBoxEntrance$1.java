package com.tencent.state.square.detail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.data.SquareBlindBoxEntranceInfo;
import com.tencent.state.status.SquareOnlineStatusViewPanel;
import com.tencent.state.utils.RegexUtils;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/square/detail/DetailSelectMeView$initBlindBoxEntrance$1", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/SquareBlindBoxEntranceInfo;", "onResultSuccess", "", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailSelectMeView$initBlindBoxEntrance$1 implements ResultCallback<SquareBlindBoxEntranceInfo> {
    final /* synthetic */ DetailSelectMeView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetailSelectMeView$initBlindBoxEntrance$1(DetailSelectMeView detailSelectMeView) {
        this.this$0 = detailSelectMeView;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str, String str2) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(final SquareBlindBoxEntranceInfo result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String linkUrl = result.getLinkUrl();
        if (linkUrl == null || linkUrl.length() == 0) {
            return;
        }
        this.this$0.isBlindBoxShow = result.isShow();
        FrameLayout frameLayout = this.this$0.getBinding().btnBlindBox;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.btnBlindBox");
        int i3 = 8;
        if (result.isShow()) {
            SquareOnlineStatusViewPanel squareOnlineStatusViewPanel = this.this$0.getBinding().onlineStatusPanel;
            Intrinsics.checkNotNullExpressionValue(squareOnlineStatusViewPanel, "binding.onlineStatusPanel");
            if (squareOnlineStatusViewPanel.getVisibility() == 8) {
                i3 = 0;
            }
        }
        frameLayout.setVisibility(i3);
        String boxCover = result.getBoxCover();
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, boxCover, false, 2, null)) {
            URLDrawable drawable = URLDrawable.getDrawable(boxCover, SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
            drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initBlindBoxEntrance$1$onResultSuccess$$inlined$apply$lambda$1
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable p06, Throwable p16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "DetailSelectMeView", "onLoadFailed", null, 4, null);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable drawable2) {
                    DetailSelectMeView$initBlindBoxEntrance$1.this.this$0.getBinding().btnBlindBoxIc.setImageDrawable(drawable2);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable p06) {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable p06, int p16) {
                }
            });
            this.this$0.getBinding().btnBlindBoxIc.setImageDrawable(drawable);
            this.this$0.getBinding().btnBlindBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.DetailSelectMeView$initBlindBoxEntrance$1$onResultSuccess$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IReporter iReporter;
                    IRouter router = Square.INSTANCE.getConfig().getRouter();
                    Context context = DetailSelectMeView$initBlindBoxEntrance$1.this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    router.routeLink(context, new EntranceLink(result.getLinkUrl(), 2));
                    iReporter = DetailSelectMeView$initBlindBoxEntrance$1.this.this$0.reporter;
                    FrameLayout frameLayout2 = DetailSelectMeView$initBlindBoxEntrance$1.this.this$0.getBinding().btnBlindBox;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.btnBlindBox");
                    iReporter.reportEvent("clck", frameLayout2, new LinkedHashMap());
                }
            });
        }
    }
}
