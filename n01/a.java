package n01;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements q01.a {

    /* renamed from: a, reason: collision with root package name */
    public final p01.c f417914a;

    /* renamed from: b, reason: collision with root package name */
    public Function5<? super Integer, ? super Integer, ? super Integer, ? super Boolean, ? super e, Unit> f417915b;

    public a(String str) {
        this.f417914a = new p01.c(str);
    }

    @Override // q01.a
    public final void a(int i3, int i16, int i17, boolean z16, e eVar) {
        Function5<? super Integer, ? super Integer, ? super Integer, ? super Boolean, ? super e, Unit> function5 = this.f417915b;
        if (function5 != null) {
            function5.invoke(Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), eVar);
        }
    }
}
