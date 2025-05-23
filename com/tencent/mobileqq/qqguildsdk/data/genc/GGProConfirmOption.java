package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProConfirmNode;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProConfirmOption;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProConfirmOption implements IGProConfirmOption {
    public final GProConfirmOption mInfo;

    public GGProConfirmOption(GProConfirmOption gProConfirmOption) {
        this.mInfo = gProConfirmOption;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmOption
    public String getConfirmMsg() {
        return this.mInfo.getConfirmMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmOption
    public ArrayList<IGProConfirmNode> getConfirmNodes() {
        ArrayList<GProConfirmNode> confirmNodes = this.mInfo.getConfirmNodes();
        ArrayList<IGProConfirmNode> arrayList = new ArrayList<>();
        Iterator<GProConfirmNode> it = confirmNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProConfirmNode(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmOption
    public String toString() {
        return this.mInfo.toString();
    }
}
