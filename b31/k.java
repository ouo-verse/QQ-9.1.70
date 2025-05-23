package b31;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.kj.i1;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public final /* synthetic */ class k {
    public static View b(i1 i1Var, Context context, Class cls) {
        return (View) cls.cast(Reflect.on((Class<?>) cls).create(context).get());
    }

    public static Context a(i1 i1Var, Context context, Class cls) {
        return context;
    }
}
