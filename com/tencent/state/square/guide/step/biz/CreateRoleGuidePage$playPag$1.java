package com.tencent.state.square.guide.step.biz;

import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.databinding.VasSquareCreateRoleGuidePageBinding;
import com.tencent.state.utils.SimplePagDownloadListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/guide/step/biz/CreateRoleGuidePage$playPag$1", "Lcom/tencent/state/utils/SimplePagDownloadListener;", "onTaskFailed", "", "errorCode", "", "errorMessage", "", "onTaskSuccess", "resultFile", "Ljava/io/File;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CreateRoleGuidePage$playPag$1 extends SimplePagDownloadListener {
    final /* synthetic */ CreateRoleGuidePage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreateRoleGuidePage$playPag$1(CreateRoleGuidePage createRoleGuidePage) {
        this.this$0 = createRoleGuidePage;
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskFailed(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        SquareBaseKt.getSquareLog().d("CreateRoleGuidePage", "[NoviceGuide] taskFailed:" + errorCode + ", " + errorMessage);
    }

    @Override // com.tencent.state.square.IDownloadListener
    public void onTaskSuccess(File resultFile) {
        ISquarePagView iSquarePagView;
        ISquarePagView iSquarePagView2;
        Intrinsics.checkNotNullParameter(resultFile, "resultFile");
        SquareBaseKt.getSquareLog().d("CreateRoleGuidePage", "[NoviceGuide] onTaskSuccess");
        iSquarePagView = this.this$0.pagView;
        if (iSquarePagView != null) {
            String absolutePath = resultFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "resultFile.absolutePath");
            iSquarePagView.setPagFile(absolutePath);
        }
        iSquarePagView2 = this.this$0.pagView;
        if (iSquarePagView2 != null) {
            iSquarePagView2.preparePagRuntime(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$playPag$1$onTaskSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    VasSquareCreateRoleGuidePageBinding vasSquareCreateRoleGuidePageBinding;
                    SquareBaseKt.getSquareLog().d("CreateRoleGuidePage", "[NoviceGuide] preparePagRuntime: " + z16);
                    if (z16) {
                        vasSquareCreateRoleGuidePageBinding = CreateRoleGuidePage$playPag$1.this.this$0.binding;
                        vasSquareCreateRoleGuidePageBinding.getRoot().post(new Runnable() { // from class: com.tencent.state.square.guide.step.biz.CreateRoleGuidePage$playPag$1$onTaskSuccess$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ISquarePagView iSquarePagView3;
                                iSquarePagView3 = CreateRoleGuidePage$playPag$1.this.this$0.pagView;
                                if (iSquarePagView3 != null) {
                                    iSquarePagView3.playPag(10000);
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
