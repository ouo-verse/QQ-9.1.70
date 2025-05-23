package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameUserAction;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameUserActionPush;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ch implements ex {

    /* renamed from: a, reason: collision with root package name */
    private final GProVoiceSmobaGameUserActionPush f265815a;

    public ch(GProVoiceSmobaGameUserActionPush gProVoiceSmobaGameUserActionPush) {
        this.f265815a = gProVoiceSmobaGameUserActionPush;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ex
    public long a() {
        return this.f265815a.getNewLeaderId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ex
    public ArrayList<ew> b() {
        ArrayList<GProVoiceSmobaGameUserAction> userAction = this.f265815a.getUserAction();
        ArrayList<ew> arrayList = new ArrayList<>();
        Iterator<GProVoiceSmobaGameUserAction> it = userAction.iterator();
        while (it.hasNext()) {
            arrayList.add(new cg(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ex
    public long getCurrentMemberNum() {
        return this.f265815a.getCurrentMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ex
    public long getRoomId() {
        return this.f265815a.getRoomId();
    }
}
