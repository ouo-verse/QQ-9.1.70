package com.qzone.common.activities.base;

import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import java.util.Map;

/* compiled from: P */
@Named("BaseFeedFragmentSchemeImp")
/* loaded from: classes39.dex */
public class v implements d5.ac {

    /* renamed from: a, reason: collision with root package name */
    private d5.u f45549a;

    @Inject
    public v() {
    }

    @Override // d5.ac
    public void a(String str, String str2, Map map) {
        yo.g gVar = new yo.g(str, null);
        gVar.f450714g = map;
        if (str2 != null) {
            gVar.f450709b = str2;
        }
        yo.d.b(this.f45549a.getActivity(), gVar);
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45549a = uVar;
    }
}
