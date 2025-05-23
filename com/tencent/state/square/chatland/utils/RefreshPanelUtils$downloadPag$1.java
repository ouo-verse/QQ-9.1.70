package com.tencent.state.square.chatland.utils;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.utils.SimplePagDownloadListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/chatland/utils/RefreshPanelUtils$downloadPag$1", "Lcom/tencent/state/utils/SimplePagDownloadListener;", "onTaskFailed", "", "errorCode", "", "errorMessage", "", "onTaskSuccess", "resultFile", "Ljava/io/File;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RefreshPanelUtils$downloadPag$1 extends SimplePagDownloadListener {
    final /* synthetic */ ISquarePagView $pagView;
    final /* synthetic */ String $tagText;
    final /* synthetic */ String $url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RefreshPanelUtils$downloadPag$1(String str, ISquarePagView iSquarePagView, String str2) {
        this.$url = str;
        this.$pagView = iSquarePagView;
        this.$tagText = str2;
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskFailed(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        SquareBaseKt.getSquareLog().d("RefreshPanelUtils", "onTaskFailed, " + errorCode + ", " + errorMessage + ", url:" + this.$url);
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskSuccess(final File resultFile) {
        Intrinsics.checkNotNullParameter(resultFile, "resultFile");
        SquareBaseKt.getSquareLog().d("RefreshPanelUtils", "onTaskSuccess, " + resultFile.getAbsolutePath() + ", url: " + this.$url);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.utils.RefreshPanelUtils$downloadPag$1$onTaskSuccess$1
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
                RefreshPanelUtils refreshPanelUtils = RefreshPanelUtils.INSTANCE;
                ISquarePagView iSquarePagView = RefreshPanelUtils$downloadPag$1.this.$pagView;
                String absolutePath = resultFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "resultFile.absolutePath");
                RefreshPanelUtils.access$playPag(refreshPanelUtils, iSquarePagView, absolutePath, RefreshPanelUtils$downloadPag$1.this.$tagText);
            }
        });
    }
}
