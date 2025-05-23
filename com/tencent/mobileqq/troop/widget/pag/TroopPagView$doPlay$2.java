package com.tencent.mobileqq.troop.widget.pag;

import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pagView", "Lorg/libpag/PAGView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopPagView$doPlay$2 extends Lambda implements Function1<PAGView, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $pagFile0Path;
    final /* synthetic */ String $pagFile1Path;
    final /* synthetic */ TroopPagView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopPagView$doPlay$2(String str, String str2, TroopPagView troopPagView) {
        super(1);
        this.$pagFile0Path = str;
        this.$pagFile1Path = str2;
        this.this$0 = troopPagView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, troopPagView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopPagView this$0) {
        View view;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view = this$0.mOuterPlaceholderView;
        if (view != null) {
            view.setVisibility(8);
        }
        imageView = this$0.placeHolderImageView;
        imageView.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
        invoke2(pAGView);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull PAGView pagView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pagView);
            return;
        }
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        PAGFile pagFile0 = PagViewMonitor.Load(this.$pagFile0Path);
        PAGFile pagFile1 = PagViewMonitor.Load(this.$pagFile1Path);
        TroopPagView troopPagView = this.this$0;
        Intrinsics.checkNotNullExpressionValue(pagFile0, "pagFile0");
        Intrinsics.checkNotNullExpressionValue(pagFile1, "pagFile1");
        troopPagView.initPagView(pagView, pagFile0, pagFile1);
        z16 = this.this$0.mEnablePlay;
        if (z16) {
            pagView.play();
            final TroopPagView troopPagView2 = this.this$0;
            troopPagView2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.i
                @Override // java.lang.Runnable
                public final void run() {
                    TroopPagView$doPlay$2.b(TroopPagView.this);
                }
            });
            return;
        }
        pagView.stop();
    }
}
