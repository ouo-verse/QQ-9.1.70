package com.tencent.state.utils;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/utils/SquarePagViewUtils$playUrl$1", "Lcom/tencent/state/utils/SimpleDownloadListener;", "onTaskFailed", "", "errorCode", "", "errorMessage", "", "onTaskSuccess", "resultFile", "Ljava/io/File;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquarePagViewUtils$playUrl$1 extends SimpleDownloadListener {
    final /* synthetic */ Function1 $onLoaded;
    final /* synthetic */ ISquarePagView $pagView;
    final /* synthetic */ int $repeatCount;
    final /* synthetic */ String $url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquarePagViewUtils$playUrl$1(String str, ISquarePagView iSquarePagView, int i3, Function1 function1) {
        this.$url = str;
        this.$pagView = iSquarePagView;
        this.$repeatCount = i3;
        this.$onLoaded = function1;
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskFailed(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "onTaskFailed, " + errorCode + ", " + errorMessage + ", url:" + this.$url);
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskSuccess(final File resultFile) {
        Intrinsics.checkNotNullParameter(resultFile, "resultFile");
        SquareBaseKt.getSquareLog().d("SquarePagViewUtils", "onTaskSuccess, " + resultFile.getAbsolutePath() + ", url: " + this.$url);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.utils.SquarePagViewUtils$playUrl$1$onTaskSuccess$1
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
                SquarePagViewUtils squarePagViewUtils = SquarePagViewUtils.INSTANCE;
                ISquarePagView iSquarePagView = SquarePagViewUtils$playUrl$1.this.$pagView;
                String absolutePath = resultFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "resultFile.absolutePath");
                SquarePagViewUtils$playUrl$1 squarePagViewUtils$playUrl$1 = SquarePagViewUtils$playUrl$1.this;
                squarePagViewUtils.playFile(iSquarePagView, absolutePath, squarePagViewUtils$playUrl$1.$repeatCount, squarePagViewUtils$playUrl$1.$onLoaded);
            }
        });
    }
}
