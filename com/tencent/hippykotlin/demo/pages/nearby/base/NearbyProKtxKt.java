package com.tencent.hippykotlin.demo.pages.nearby.base;

import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.af;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import n35.v;
import r25.b;
import r25.c;
import v25.p;

/* loaded from: classes31.dex */
public final class NearbyProKtxKt {
    public static final String avatarDressBorderUrl(p pVar) {
        Object obj;
        c cVar;
        String str;
        Iterator<T> it = pVar.D.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((b) obj).f430598d == 1001) {
                break;
            }
        }
        b bVar = (b) obj;
        return (bVar == null || (cVar = bVar.f430600f) == null || (str = cVar.f430604h) == null) ? "" : str;
    }

    public static final af srcWithIndexNode(final af afVar, final v vVar) {
        BDHService.INSTANCE.reqDownPhoto(vVar, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt$srcWithIndexNode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(String str) {
                String str2 = str;
                if (str2.length() > 0) {
                    b.a.b(af.this, str2, false, 2, null);
                } else {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder sb5 = new StringBuilder();
                    v vVar2 = vVar;
                    sb5.append(vVar2 != null ? vVar2.f418268e : null);
                    sb5.append(" is empty");
                    kLog.d("ImageSrcWithIndexNode", sb5.toString());
                }
                return Unit.INSTANCE;
            }
        });
        return afVar;
    }
}
