package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProPAInstructionInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAInstructionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPAInstructionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreventAddictionPushInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class o implements dz {

    /* renamed from: a, reason: collision with root package name */
    private GProPreventAddictionPushInfo f266731a;

    public o(GProPreventAddictionPushInfo gProPreventAddictionPushInfo) {
        this.f266731a = gProPreventAddictionPushInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dz
    public long a() {
        return this.f266731a.getCloseMask();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dz
    public String getInstrTraceId() {
        return this.f266731a.getInstrTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dz
    public ArrayList<IGProPAInstructionInfo> getInstructions() {
        ArrayList<IGProPAInstructionInfo> arrayList = new ArrayList<>();
        Iterator<GProPAInstructionInfo> it = this.f266731a.getInstructions().iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProPAInstructionInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dz
    public long getUin() {
        return this.f266731a.getUin();
    }
}
