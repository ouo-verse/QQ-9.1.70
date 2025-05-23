package com.tencent.mobileqq.tux.core;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmetersdk.export.injector.event.ITuxRemoteEventReport;
import com.tencent.tuxmetersdk.impl.event.EventType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/tux/core/a;", "Lcom/tencent/tuxmetersdk/export/injector/event/ITuxRemoteEventReport;", "", "beaconAppKey", "Lcom/tencent/tuxmetersdk/impl/event/EventType;", "eventType", "eventCode", "", "params", "", "report", "<init>", "()V", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements ITuxRemoteEventReport {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tuxmetersdk.export.injector.event.ITuxRemoteEventReport
    public void report(@NotNull String beaconAppKey, @NotNull EventType eventType, @NotNull String eventCode, @NotNull Map<String, String> params) {
        com.tencent.beacon.event.open.EventType eventType2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, beaconAppKey, eventType, eventCode, params);
            return;
        }
        Intrinsics.checkNotNullParameter(beaconAppKey, "beaconAppKey");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        if (QLog.isColorLevel()) {
            QLog.d("TuxSdkHelper", 2, "TuxReport beaconAppKey:" + beaconAppKey + ", eventType:" + eventType + ", eventCode:" + eventCode + ", params:" + params);
        }
        if (eventType == EventType.REALTIME) {
            eventType2 = com.tencent.beacon.event.open.EventType.REALTIME;
        } else {
            eventType2 = com.tencent.beacon.event.open.EventType.NORMAL;
        }
        BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(beaconAppKey).withCode(eventCode).withType(eventType2).withParams(params).build());
    }
}
