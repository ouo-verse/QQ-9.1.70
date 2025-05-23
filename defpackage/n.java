package defpackage;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class n implements ISSOReqModel, ISSORspModel<n> {

    /* renamed from: a, reason: collision with root package name */
    public final String f417908a;

    /* renamed from: b, reason: collision with root package name */
    public final int f417909b;

    public n() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final n decode(e eVar) {
        return new n(eVar.q("words", ""), eVar.k("eflag", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("words", this.f417908a);
        eVar.t("eflag", this.f417909b);
        return eVar;
    }

    public n(String str, int i3) {
        this.f417908a = str;
        this.f417909b = i3;
    }

    public /* synthetic */ n(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
    }
}
