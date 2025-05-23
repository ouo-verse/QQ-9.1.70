package com.tencent.sqshow.zootopia.aigc.view;

import android.view.View;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pagView", "Lorg/libpag/PAGView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class SuitPagView$doPlay$2 extends Lambda implements Function1<PAGView, Unit> {
    final /* synthetic */ String $pagFile0Path;
    final /* synthetic */ String $pagFile1Path;
    final /* synthetic */ SuitPagView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitPagView$doPlay$2(String str, String str2, SuitPagView suitPagView) {
        super(1);
        this.$pagFile0Path = str;
        this.$pagFile1Path = str2;
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
        PAGFile Load = PagViewMonitor.Load(this.$pagFile0Path);
        PAGFile Load2 = PagViewMonitor.Load(this.$pagFile1Path);
        if (Load != null && Load2 != null) {
            this.this$0.p(pagView, Load, Load2);
            if (this.this$0.getMEnablePlay()) {
                pagView.play();
                final SuitPagView suitPagView = this.this$0;
                suitPagView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.aigc.view.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitPagView$doPlay$2.b(SuitPagView.this);
                    }
                });
                return;
            }
            pagView.stop();
            return;
        }
        QLog.e("SuitPagView", 1, "pagFile0 or pagFile1 is null");
    }
}
