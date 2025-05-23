package d91;

import com.tencent.freesia.IConfigData;
import cooperation.qzone.report.lp.LpReportInfoConfig;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends d implements IConfigData {

    /* renamed from: e, reason: collision with root package name */
    private final e91.g f393224e;

    public g() {
        this("", new e91.g());
    }

    @Override // d91.d
    public int a() {
        return LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT;
    }

    public e91.g c() {
        return this.f393224e;
    }

    public g(String str, e91.g gVar) {
        super(str);
        this.f393224e = gVar;
    }
}
