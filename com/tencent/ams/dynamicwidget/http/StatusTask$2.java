package com.tencent.ams.dynamicwidget.http;

import com.tencent.ams.dynamicwidget.utils.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/ams/dynamicwidget/http/StatusTask$2", "Ljava/util/concurrent/FutureTask;", "", "done", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class StatusTask$2 extends FutureTask<Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ a this$0;

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            a.a(null, get());
        } catch (InterruptedException e16) {
            b.f70218a.d("StatusTask", "An error occurred while executing doInBackground(): " + e16.getMessage());
        } catch (CancellationException unused) {
            a.a(null, null);
        } catch (ExecutionException e17) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e17.getCause());
        } catch (Throwable th5) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th5);
        }
    }
}
