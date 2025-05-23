package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lar4/a;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lar4/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceBottomLandscapePart$observeData$9 extends Lambda implements Function1<ar4.a, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQLiveAudienceBottomLandscapePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAudienceBottomLandscapePart$observeData$9(QQLiveAudienceBottomLandscapePart qQLiveAudienceBottomLandscapePart) {
        super(1);
        this.this$0 = qQLiveAudienceBottomLandscapePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveAudienceBottomLandscapePart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQLiveAudienceBottomLandscapePart this$0, ar4.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Gb(it);
        this$0.Va(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ar4.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final ar4.a aVar) {
        boolean z16;
        com.tencent.mobileqq.qqlive.room.displayview.horizontal.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        z16 = this.this$0.isUILandscape;
        if (z16) {
            bVar = this.this$0.autoCollapse;
            if (bVar != null) {
                bVar.l();
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQLiveAudienceBottomLandscapePart qQLiveAudienceBottomLandscapePart = this.this$0;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.x
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveAudienceBottomLandscapePart$observeData$9.b(QQLiveAudienceBottomLandscapePart.this, aVar);
                }
            }, 300L);
        }
    }
}
