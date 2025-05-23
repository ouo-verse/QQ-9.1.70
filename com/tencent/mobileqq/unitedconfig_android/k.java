package com.tencent.mobileqq.unitedconfig_android;

import com.tencent.freesia.Tack;
import com.tencent.freesia.Tick;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/k;", "Lcom/tencent/freesia/Tick;", "", "seq", "", "delay", "", "tick", "Lcom/tencent/freesia/Tack;", "a", "Lcom/tencent/freesia/Tack;", "mTack", "<init>", "()V", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class k implements Tick {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Tack mTack;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mTack = com.tencent.freesia.d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(k this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Tack tack = this$0.mTack;
        if (tack != null) {
            tack.tack(i3);
        }
    }

    @Override // com.tencent.freesia.Tick
    public void tick(final int seq, long delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(seq), Long.valueOf(delay));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("FreesiaTick", 4, "tick after " + delay + MsgSummary.STR_COLON + seq);
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.unitedconfig_android.j
            @Override // java.lang.Runnable
            public final void run() {
                k.b(k.this, seq);
            }
        }, 16, null, true, delay);
    }
}
