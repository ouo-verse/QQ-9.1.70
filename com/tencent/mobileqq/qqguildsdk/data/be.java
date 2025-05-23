package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSearchRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class be implements dw {

    /* renamed from: a, reason: collision with root package name */
    private final GProMsgSearchRsp f265747a;

    public be(@NonNull GProMsgSearchRsp gProMsgSearchRsp) {
        this.f265747a = gProMsgSearchRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dw
    public List<ds> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<GProGuildMsg> it = this.f265747a.getResults().iterator();
        while (it.hasNext()) {
            arrayList.add(new au(it.next()));
        }
        return arrayList;
    }

    public String toString() {
        return "GProMsgSearchRspImpl{mRsp=" + this.f265747a + '}';
    }
}
