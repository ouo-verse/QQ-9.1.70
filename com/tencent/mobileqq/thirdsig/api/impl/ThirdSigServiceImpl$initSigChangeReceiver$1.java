package com.tencent.mobileqq.thirdsig.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/thirdsig/api/impl/ThirdSigServiceImpl$initSigChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class ThirdSigServiceImpl$initSigChangeReceiver$1 extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ThirdSigServiceImpl f292869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThirdSigServiceImpl$initSigChangeReceiver$1(ThirdSigServiceImpl thirdSigServiceImpl) {
        this.f292869a = thirdSigServiceImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) thirdSigServiceImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ThirdSigServiceImpl this$0, long j3) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        arrayList = this$0.mListenerList;
        synchronized (arrayList) {
            arrayList2 = this$0.mListenerList;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.thirdsig.api.e) it.next()).onChange(j3);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (context != null && intent != null) {
            final long longExtra = intent.getLongExtra("uin", 0L);
            if (((int) longExtra) == 0) {
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && longExtra != peekAppRuntime.getLongAccountUin()) {
                return;
            }
            final ThirdSigServiceImpl thirdSigServiceImpl = this.f292869a;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.thirdsig.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    ThirdSigServiceImpl$initSigChangeReceiver$1.b(ThirdSigServiceImpl.this, longExtra);
                }
            }, 16, null, false);
        }
    }
}
