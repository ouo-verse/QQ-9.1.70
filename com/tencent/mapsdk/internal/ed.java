package com.tencent.mapsdk.internal;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ed<IN extends MapJceStruct, OUT extends MapJceStruct> extends eb {

    /* renamed from: a, reason: collision with root package name */
    private Class<IN> f148146a;

    /* renamed from: b, reason: collision with root package name */
    private Class<OUT> f148147b;

    /* renamed from: c, reason: collision with root package name */
    private MapJceStruct f148148c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a<OUT extends MapJceStruct> extends NetResponse {

        /* renamed from: a, reason: collision with root package name */
        public OUT f148149a;

        public a(NetResponse netResponse, Class<OUT> cls) {
            clone(netResponse);
            byte[] bArr = netResponse.data;
            if (bArr != null) {
                m mVar = new m(bArr);
                OUT out = (OUT) hq.a(cls, new Object[0]);
                this.f148149a = out;
                if (out != null) {
                    out.readFrom(mVar);
                }
            }
            LogUtil.c("TS", "[JCE-RESP]:" + this.f148149a);
        }

        private OUT a() {
            return this.f148149a;
        }

        @Override // com.tencent.map.tools.net.NetResponse
        public final boolean available() {
            if (super.available() && this.f148149a != null) {
                return true;
            }
            return false;
        }
    }

    public ed(Class<IN> cls, Class<OUT> cls2) {
        this.f148146a = cls;
        this.f148147b = cls2;
    }

    private a<OUT> b(NetResponse netResponse) {
        return new a<>(netResponse, this.f148147b);
    }

    @Override // com.tencent.mapsdk.internal.eb, com.tencent.mapsdk.internal.ef
    public final Object[] a(int[] iArr, Object[] objArr) {
        if (objArr != null && iArr != null && iArr.length > 0 && objArr.length > 0) {
            List asList = Arrays.asList(objArr);
            int i3 = iArr[0];
            int i16 = iArr.length == 1 ? i3 : iArr[1];
            if (objArr.length - 1 >= i16 && i3 >= 0) {
                MapJceStruct mapJceStruct = (MapJceStruct) hq.a(this.f148146a, Arrays.copyOfRange(objArr, i3, i16 + 1));
                this.f148148c = mapJceStruct;
                byte[] bArr = new byte[0];
                if (mapJceStruct != null) {
                    bArr = mapJceStruct.toByteArray();
                }
                ArrayList arrayList = new ArrayList();
                for (int i17 = 0; i17 < asList.size(); i17++) {
                    if (i17 < i3 || i17 > i16) {
                        arrayList.add(asList.get(i17));
                    } else if (i17 == i16) {
                        arrayList.add(bArr);
                    }
                }
                return arrayList.toArray();
            }
        }
        return super.a(iArr, objArr);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("JceResolver{");
        stringBuffer.append("inJce=");
        stringBuffer.append(this.f148148c);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.tencent.mapsdk.internal.eb, com.tencent.mapsdk.internal.ef
    public final /* synthetic */ NetResponse a(NetResponse netResponse) {
        return new a(netResponse, this.f148147b);
    }
}
