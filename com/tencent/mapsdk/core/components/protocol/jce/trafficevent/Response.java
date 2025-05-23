package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class Response extends MapJceStruct {

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<Detail> f147622a = new ArrayList<>();
    public ArrayList<Detail> detail;
    public short error;

    /* renamed from: msg, reason: collision with root package name */
    public String f147623msg;

    static {
        f147622a.add(new Detail());
    }

    public Response() {
        this.error = (short) 0;
        this.f147623msg = "";
        this.detail = null;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.error = mVar.a(this.error, 0, true);
        this.f147623msg = mVar.b(1, false);
        this.detail = (ArrayList) mVar.a((m) f147622a, 2, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.error, 0);
        String str = this.f147623msg;
        if (str != null) {
            nVar.a(str, 1);
        }
        ArrayList<Detail> arrayList = this.detail;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 2);
        }
    }

    public Response(short s16, String str, ArrayList<Detail> arrayList) {
        this.error = s16;
        this.f147623msg = str;
        this.detail = arrayList;
    }
}
