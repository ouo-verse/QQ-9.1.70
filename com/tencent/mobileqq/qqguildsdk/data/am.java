package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProArea;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAreaList;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class am implements dd {

    /* renamed from: a, reason: collision with root package name */
    private final GProAreaList f265681a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<db> f265682b = new ArrayList<>();

    public am(GProAreaList gProAreaList) {
        this.f265681a = gProAreaList;
        Iterator<GProArea> it = gProAreaList.getAreas().iterator();
        while (it.hasNext()) {
            this.f265682b.add(new ak(it.next()));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dd
    public ArrayList<db> a() {
        return this.f265682b;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dd
    public byte[] getCookie() {
        return this.f265681a.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dd
    public boolean getIsEnd() {
        return this.f265681a.getIsEnd();
    }
}
