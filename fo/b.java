package fo;

import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f400124a;

    /* renamed from: b, reason: collision with root package name */
    private IDynamicParams f400125b;

    /* renamed from: c, reason: collision with root package name */
    private String f400126c;

    /* renamed from: d, reason: collision with root package name */
    private ExposurePolicy f400127d = ExposurePolicy.REPORT_ALL;

    /* renamed from: e, reason: collision with root package name */
    private EndExposurePolicy f400128e = EndExposurePolicy.REPORT_ALL;

    /* renamed from: f, reason: collision with root package name */
    private ClickPolicy f400129f = ClickPolicy.REPORT_ALL;

    public ClickPolicy a() {
        return this.f400129f;
    }

    public IDynamicParams b() {
        return this.f400125b;
    }

    public String c() {
        return this.f400126c;
    }

    public EndExposurePolicy d() {
        return this.f400128e;
    }

    public ExposurePolicy e() {
        return this.f400127d;
    }

    public Map<String, Object> f() {
        return this.f400124a;
    }

    public b g(ClickPolicy clickPolicy) {
        this.f400129f = clickPolicy;
        return this;
    }

    public b h(IDynamicParams iDynamicParams) {
        this.f400125b = iDynamicParams;
        return this;
    }

    public b i(String str) {
        this.f400126c = str;
        return this;
    }

    public b j(EndExposurePolicy endExposurePolicy) {
        this.f400128e = endExposurePolicy;
        return this;
    }

    public b k(ExposurePolicy exposurePolicy) {
        this.f400127d = exposurePolicy;
        return this;
    }

    public b l(Map<String, Object> map) {
        this.f400124a = map;
        return this;
    }
}
