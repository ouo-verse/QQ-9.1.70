package com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag;

import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qqcircle.immersive.views.ae;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pagView", "Lorg/libpag/PAGImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PlusEntryDailyPagComposer$playPagView$1 extends Lambda implements Function1<PAGImageView, Unit> {
    final /* synthetic */ String $pagFileName;
    final /* synthetic */ VasPagImageView $vasPagView;
    final /* synthetic */ PlusEntryDailyPagComposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlusEntryDailyPagComposer$playPagView$1(PlusEntryDailyPagComposer plusEntryDailyPagComposer, String str, VasPagImageView vasPagImageView) {
        super(1);
        this.this$0 = plusEntryDailyPagComposer;
        this.$pagFileName = str;
        this.$vasPagView = vasPagImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String pagFileName, final PlusEntryDailyPagComposer this$0, final VasPagImageView vasPagView, final PAGImageView pagView) {
        String c16;
        Intrinsics.checkNotNullParameter(pagFileName, "$pagFileName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vasPagView, "$vasPagView");
        Intrinsics.checkNotNullParameter(pagView, "$pagView");
        c16 = PlusEntryDailyPagComposer.INSTANCE.c(pagFileName);
        final PAGFile Load = PagViewMonitor.Load(c16);
        if (Load != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.c
                @Override // java.lang.Runnable
                public final void run() {
                    PlusEntryDailyPagComposer$playPagView$1.d(PlusEntryDailyPagComposer.this, vasPagView, pagView, Load);
                }
            });
        } else {
            QLog.w(this$0.d(), 1, "playPagView, pagFile null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PlusEntryDailyPagComposer this$0, VasPagImageView vasPagView, PAGImageView pagView, PAGFile pAGFile) {
        ae q16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(vasPagView, "$vasPagView");
        Intrinsics.checkNotNullParameter(pagView, "$pagView");
        this$0.v(vasPagView, true);
        pagView.setComposition(pAGFile);
        pagView.setRepeatCount(1);
        q16 = this$0.q();
        pagView.addListener(q16);
        pagView.setCurrentFrame(0);
        pagView.flush();
        pagView.play();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
        invoke2(pAGImageView);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final PAGImageView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        QLog.i(this.this$0.d(), 1, "playPagView, do action ");
        RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        final String str = this.$pagFileName;
        final PlusEntryDailyPagComposer plusEntryDailyPagComposer = this.this$0;
        final VasPagImageView vasPagImageView = this.$vasPagView;
        rFWThreadManager.execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.dailypag.b
            @Override // java.lang.Runnable
            public final void run() {
                PlusEntryDailyPagComposer$playPagView$1.c(str, plusEntryDailyPagComposer, vasPagImageView, pagView);
            }
        });
    }
}
