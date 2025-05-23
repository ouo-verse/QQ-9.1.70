package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.widget.RelativeLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/gdtad/aditem/GdtAd;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSFullScreenPauseAdPresenter$handlerVideoPlayClickEvent$1 extends Lambda implements Function1<GdtAd, Unit> {
    final /* synthetic */ QFSFullScreenPauseAdPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSFullScreenPauseAdPresenter$handlerVideoPlayClickEvent$1(QFSFullScreenPauseAdPresenter qFSFullScreenPauseAdPresenter) {
        super(1);
        this.this$0 = qFSFullScreenPauseAdPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QFSFullScreenPauseAdPresenter this$0, GdtAd it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.p1();
        this$0.q1(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GdtAd gdtAd) {
        invoke2(gdtAd);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final GdtAd it) {
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isValid()) {
            relativeLayout = this.this$0.adContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adContainer");
                relativeLayout = null;
            }
            final QFSFullScreenPauseAdPresenter qFSFullScreenPauseAdPresenter = this.this$0;
            relativeLayout.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.h
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenPauseAdPresenter$handlerVideoPlayClickEvent$1.b(QFSFullScreenPauseAdPresenter.this, it);
                }
            });
            return;
        }
        QLog.w("QDM-QFSFullScreenPauseAdPresenter", 1, "handlerVideoStatusEvent: ad is not valid");
    }
}
