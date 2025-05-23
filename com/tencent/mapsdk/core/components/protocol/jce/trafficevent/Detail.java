package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.p;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class Detail extends MapJceStruct {

    /* renamed from: a, reason: collision with root package name */
    static Basic f147620a = new Basic();

    /* renamed from: b, reason: collision with root package name */
    static ArrayList<Float> f147621b = new ArrayList<>();
    public Basic basic;
    public ArrayList<Float> coord;

    static {
        f147621b.add(Float.valueOf(0.0f));
    }

    public Detail() {
        this.basic = null;
        this.coord = null;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.basic = (Basic) mVar.a((p) f147620a, 0, true);
        this.coord = (ArrayList) mVar.a((m) f147621b, 1, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a((p) this.basic, 0);
        ArrayList<Float> arrayList = this.coord;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 1);
        }
    }

    public Detail(Basic basic, ArrayList<Float> arrayList) {
        this.basic = basic;
        this.coord = arrayList;
    }
}
