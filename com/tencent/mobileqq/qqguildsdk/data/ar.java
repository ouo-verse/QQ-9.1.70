package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCategoryAdminInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelAdminInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ar implements dg {

    /* renamed from: a, reason: collision with root package name */
    private final GProCategoryAdminInfo f265688a;

    public ar(GProCategoryAdminInfo gProCategoryAdminInfo) {
        this.f265688a = gProCategoryAdminInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dg
    public ArrayList<dh> a() {
        ArrayList<dh> arrayList = new ArrayList<>();
        Iterator<GProChannelAdminInfo> it = this.f265688a.getChannelAdminList().iterator();
        while (it.hasNext()) {
            arrayList.add(new as(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dg
    public String getCategoryName() {
        return this.f265688a.getCategoryName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dg
    public int getCategoryType() {
        return this.f265688a.getCategoryType();
    }
}
