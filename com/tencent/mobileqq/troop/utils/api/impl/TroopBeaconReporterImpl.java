package com.tencent.mobileqq.troop.utils.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0096\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/api/impl/TroopBeaconReporterImpl;", "Lcom/tencent/mobileqq/troop/utils/api/ITroopBeaconReporter;", "()V", "report", "", "event", "", "params", "", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopBeaconReporterImpl implements ITroopBeaconReporter {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopBeaconReporter $$delegate_0;

    public TroopBeaconReporterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopBeaconReporter.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter
    public void report(@Nullable String event, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) event, (Object) params);
        } else {
            this.$$delegate_0.report(event, params);
        }
    }
}
