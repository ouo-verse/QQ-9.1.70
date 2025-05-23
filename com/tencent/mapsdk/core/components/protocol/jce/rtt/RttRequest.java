package com.tencent.mapsdk.core.components.protocol.jce.rtt;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.cw;
import com.tencent.mapsdk.internal.k;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.mapsdk.internal.q;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class RttRequest extends MapJceStruct implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<Integer> f147604a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    static int f147605b = 0;

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<Long> f147606c = null;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f147607d = true;
    public ArrayList<Integer> bounds;
    public ArrayList<Long> crcs;
    public int type;
    public short zip;
    public short zoom;

    static {
        f147604a.add(0);
        f147605b = 0;
        f147606c = new ArrayList<>();
        f147606c.add(0L);
    }

    public RttRequest() {
        this.bounds = null;
        this.zoom = (short) 0;
        this.zip = (short) 0;
        this.type = cw.f148085c.f148094a;
        this.crcs = null;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "navsns.RttRequest";
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f147607d) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void display(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a((Collection) this.bounds, "bounds");
        kVar.a(this.zoom, "zoom");
        kVar.a(this.zip, "zip");
        kVar.a(this.type, "type");
        kVar.a((Collection) this.crcs, "crcs");
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void displaySimple(StringBuilder sb5, int i3) {
        k kVar = new k(sb5, i3);
        kVar.a((Collection) this.bounds, true);
        kVar.a(this.zoom, true);
        kVar.a(this.zip, true);
        kVar.a(this.type, true);
        kVar.a((Collection) this.crcs, false);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RttRequest rttRequest = (RttRequest) obj;
        if (!q.a((Object) this.bounds, (Object) rttRequest.bounds) || !q.a(this.zoom, rttRequest.zoom) || !q.a(this.zip, rttRequest.zip) || !q.a(this.type, rttRequest.type) || !q.a((Object) this.crcs, (Object) rttRequest.crcs)) {
            return false;
        }
        return true;
    }

    public final ArrayList<Integer> getBounds() {
        return this.bounds;
    }

    public final ArrayList<Long> getCrcs() {
        return this.crcs;
    }

    public final int getType() {
        return this.type;
    }

    public final short getZip() {
        return this.zip;
    }

    public final short getZoom() {
        return this.zoom;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.bounds = (ArrayList) mVar.a((m) f147604a, 0, true);
        this.zoom = mVar.a(this.zoom, 1, true);
        this.zip = mVar.a(this.zip, 2, true);
        this.type = mVar.a(this.type, 3, false);
        this.crcs = (ArrayList) mVar.a((m) f147606c, 4, false);
    }

    public final void setBounds(ArrayList<Integer> arrayList) {
        this.bounds = arrayList;
    }

    public final void setCrcs(ArrayList<Long> arrayList) {
        this.crcs = arrayList;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setZip(short s16) {
        this.zip = s16;
    }

    public final void setZoom(short s16) {
        this.zoom = s16;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a((Collection) this.bounds, 0);
        nVar.a(this.zoom, 1);
        nVar.a(this.zip, 2);
        nVar.a(this.type, 3);
        ArrayList<Long> arrayList = this.crcs;
        if (arrayList != null) {
            nVar.a((Collection) arrayList, 4);
        }
    }

    public RttRequest(ArrayList<Integer> arrayList, short s16, short s17, int i3, ArrayList<Long> arrayList2) {
        this.bounds = null;
        this.zoom = (short) 0;
        this.zip = (short) 0;
        int i16 = cw.f148085c.f148094a;
        this.bounds = arrayList;
        this.zoom = s16;
        this.zip = s17;
        this.type = i3;
        this.crcs = arrayList2;
    }
}
