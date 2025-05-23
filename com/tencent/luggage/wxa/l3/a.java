package com.tencent.luggage.wxa.l3;

import android.os.Process;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/luggage/wxa/l3/a;", "Lcom/tencent/luggage/wxa/ka/f;", "Lcom/tencent/luggage/wxa/va/e;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "a", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.ka.f {
    @Override // com.tencent.luggage.wxa.ka.f
    public void a(com.tencent.luggage.wxa.va.e data, com.tencent.luggage.wxa.ka.i callback) {
        try {
            SystemMethodProxy.killProcess(Process.myPid());
        } catch (Throwable th5) {
            w.f("Luggage.task.IPCKillProcessTask", "runInLuggageProcess: handled throwable [" + th5 + ']');
        }
    }
}
