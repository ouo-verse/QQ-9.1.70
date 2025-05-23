package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchGetGuildLabelInfoRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildLabelInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProBatchGetGuildLabelInfoRsp implements IGProBatchGetGuildLabelInfoRsp {
    public final GProBatchGetGuildLabelInfoRsp mInfo;

    public GGProBatchGetGuildLabelInfoRsp(GProBatchGetGuildLabelInfoRsp gProBatchGetGuildLabelInfoRsp) {
        this.mInfo = gProBatchGetGuildLabelInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetGuildLabelInfoRsp
    public ArrayList<IGProGuildLabelInfo> getList() {
        ArrayList<GProGuildLabelInfo> list = this.mInfo.getList();
        ArrayList<IGProGuildLabelInfo> arrayList = new ArrayList<>();
        Iterator<GProGuildLabelInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildLabelInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetGuildLabelInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
