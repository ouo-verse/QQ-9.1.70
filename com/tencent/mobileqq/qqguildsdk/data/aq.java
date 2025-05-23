package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.dr;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBlackList;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBlackUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class aq implements dr {

    /* renamed from: a, reason: collision with root package name */
    private final GProBlackList f265687a;

    public aq(GProBlackList gProBlackList) {
        this.f265687a = gProBlackList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dr
    public int a() {
        return this.f265687a.getListId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dr
    public String b() {
        return this.f265687a.getListName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dr
    @NonNull
    public List<dr.a> getMemberList() {
        ArrayList arrayList = new ArrayList();
        Iterator<GProBlackUserInfo> it = this.f265687a.getMemberList().iterator();
        while (it.hasNext()) {
            GProBlackUserInfo next = it.next();
            arrayList.add(new dr.a(com.tencent.mobileqq.qqguildsdk.util.g.X0(next.getTinyId()), next.getNickName(), next.getAvatarUrl()));
        }
        return arrayList;
    }
}
