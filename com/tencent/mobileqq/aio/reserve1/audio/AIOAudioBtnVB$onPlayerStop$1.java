package com.tencent.mobileqq.aio.reserve1.audio;

import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIOAudioBtnVB$onPlayerStop$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOAudioBtnVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOAudioBtnVB$onPlayerStop$1(AIOAudioBtnVB aIOAudioBtnVB) {
        super(0);
        this.this$0 = aIOAudioBtnVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOAudioBtnVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOAudioBtnVB this$0) {
        LinearLayout k16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k16 = this$0.k1();
        k16.setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Handler j16;
        LinearLayout k16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            k16 = this.this$0.k1();
            k16.setVisibility(8);
        } else {
            j16 = this.this$0.j1();
            final AIOAudioBtnVB aIOAudioBtnVB = this.this$0;
            j16.post(new Runnable() { // from class: com.tencent.mobileqq.aio.reserve1.audio.c
                @Override // java.lang.Runnable
                public final void run() {
                    AIOAudioBtnVB$onPlayerStop$1.b(AIOAudioBtnVB.this);
                }
            });
        }
    }
}
