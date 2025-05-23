package com.tencent.mobileqq.aio.helper;

import android.app.Activity;
import android.os.Handler;
import com.tencent.biz.qui.toast.QUIStatusToast;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isLowVolume", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class PttHelper$getPhoneLowVolumeListener$onLowVolume$1 extends Lambda implements Function1<Boolean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ PttHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PttHelper$getPhoneLowVolumeListener$onLowVolume$1(PttHelper pttHelper, Activity activity) {
        super(1);
        this.this$0 = pttHelper;
        this.$activity = activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pttHelper, (Object) activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PttHelper this$0, Activity activity) {
        QUIStatusToast qUIStatusToast;
        QUIStatusToast qUIStatusToast2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        qUIStatusToast = this$0.lowVolumeDialog;
        if (qUIStatusToast == null) {
            QUIStatusToast qUIStatusToast3 = new QUIStatusToast(activity);
            qUIStatusToast3.P(HardCodeUtil.qqStr(R.string.z77));
            qUIStatusToast3.setIcon(R.drawable.qui_voice_mute_icon_white_primary);
            this$0.lowVolumeDialog = qUIStatusToast3;
        }
        qUIStatusToast2 = this$0.lowVolumeDialog;
        if (qUIStatusToast2 != null) {
            qUIStatusToast2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PttHelper this$0) {
        QUIStatusToast qUIStatusToast;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        qUIStatusToast = this$0.lowVolumeDialog;
        if (qUIStatusToast != null) {
            qUIStatusToast.dismiss();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        r4 = r3.this$0.handler;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(boolean z16) {
        QUIStatusToast qUIStatusToast;
        Handler handler;
        QUIStatusToast qUIStatusToast2;
        Handler handler2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            qUIStatusToast2 = this.this$0.lowVolumeDialog;
            if (!(qUIStatusToast2 != null && qUIStatusToast2.isShowing())) {
                handler2 = this.this$0.handler;
                if (handler2 != null) {
                    final PttHelper pttHelper = this.this$0;
                    final Activity activity = this.$activity;
                    handler2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.az
                        @Override // java.lang.Runnable
                        public final void run() {
                            PttHelper$getPhoneLowVolumeListener$onLowVolume$1.c(PttHelper.this, activity);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (z16) {
            return;
        }
        qUIStatusToast = this.this$0.lowVolumeDialog;
        if (!(qUIStatusToast != null && qUIStatusToast.isShowing()) || handler == null) {
            return;
        }
        final PttHelper pttHelper2 = this.this$0;
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.ba
            @Override // java.lang.Runnable
            public final void run() {
                PttHelper$getPhoneLowVolumeListener$onLowVolume$1.d(PttHelper.this);
            }
        });
    }
}
