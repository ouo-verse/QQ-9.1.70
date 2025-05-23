package com.qwallet.home;

import android.os.Handler;
import android.widget.TextView;
import com.qwallet.home.b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qwallet/home/PopDialog$initCountdown$1", "Ljava/util/TimerTask;", TencentLocation.RUN_MODE, "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PopDialog$initCountdown$1 extends TimerTask {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f41577d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Timer f41578e;
    final /* synthetic */ PopDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PopDialog$initCountdown$1(Ref.IntRef intRef, Timer timer, PopDialog popDialog) {
        this.f41577d = intRef;
        this.f41578e = timer;
        this.this$0 = popDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PopDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PopDialog this$0, Ref.IntRef countdownNum) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(countdownNum, "$countdownNum");
        textView = this$0.mCountdownText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCountdownText");
            textView = null;
        }
        textView.setText(countdownNum.element + ReportConstant.COSTREPORT_PREFIX);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f41577d.element <= 0) {
            this.f41578e.cancel();
            b.InterfaceC0306b mListener = this.this$0.getMListener();
            if (mListener != null) {
                mListener.a("countdown");
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PopDialog popDialog = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.qwallet.home.l
                @Override // java.lang.Runnable
                public final void run() {
                    PopDialog$initCountdown$1.c(PopDialog.this);
                }
            });
            return;
        }
        Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
        final PopDialog popDialog2 = this.this$0;
        final Ref.IntRef intRef = this.f41577d;
        uIHandlerV22.post(new Runnable() { // from class: com.qwallet.home.m
            @Override // java.lang.Runnable
            public final void run() {
                PopDialog$initCountdown$1.d(PopDialog.this, intRef);
            }
        });
        Ref.IntRef intRef2 = this.f41577d;
        intRef2.element--;
    }
}
