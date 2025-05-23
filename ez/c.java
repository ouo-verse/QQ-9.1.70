package ez;

import UserGrowth.stFunctionalIconInfo;
import UserGrowth.stSchema;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private final stFunctionalIconInfo f397442b;

    @Override // ez.a
    public String a() {
        stFunctionalIconInfo stfunctionaliconinfo = this.f397442b;
        if (stfunctionaliconinfo == null) {
            return null;
        }
        return stfunctionaliconinfo.imgUrl;
    }

    @Override // ez.a
    public stSchema b() {
        stFunctionalIconInfo stfunctionaliconinfo = this.f397442b;
        if (stfunctionaliconinfo == null) {
            return null;
        }
        return stfunctionaliconinfo.jump;
    }

    @Override // ez.a
    public String c() {
        stFunctionalIconInfo stfunctionaliconinfo = this.f397442b;
        if (stfunctionaliconinfo == null) {
            return null;
        }
        return stfunctionaliconinfo.text;
    }

    public c(stFunctionalIconInfo stfunctionaliconinfo) {
        super(1);
        this.f397442b = stfunctionaliconinfo;
    }
}
