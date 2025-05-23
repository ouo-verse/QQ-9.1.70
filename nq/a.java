package nq;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.Map;
import org.light.LightEngine;
import org.light.report.LightReportInterface;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements LightReportInterface {

    /* renamed from: a, reason: collision with root package name */
    private String f420681a = QQWinkConstants.ENTRY_QQ_OTHER;

    /* renamed from: b, reason: collision with root package name */
    private String f420682b;

    /* compiled from: P */
    /* renamed from: nq.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    private static final class C10862a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f420683a = new a();
    }

    a() {
    }

    public static a b() {
        return C10862a.f420683a;
    }

    public String a() {
        return this.f420681a;
    }

    public void c(String str) {
        ms.a.f("ReporterForLightSdk", "setEntry---str entry=" + str);
        this.f420681a = str;
    }

    @Override // org.light.report.LightReportInterface
    public void report(String str, Map<String, String> map) {
        if (this.f420682b == null) {
            this.f420682b = LightEngine.version();
        }
        map.put("lightsdk_version", this.f420682b);
        map.put("app_id", "lightsdk_qq");
        map.put("entry", this.f420681a);
        BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str).withParams(map).withAppKey("0AND0WH9714UPYKY").build());
    }
}
