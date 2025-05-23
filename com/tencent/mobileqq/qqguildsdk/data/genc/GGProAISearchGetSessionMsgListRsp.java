package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetSessionMsgListRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchSessionMsg;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProAISearchGetSessionMsgListRsp implements IGProAISearchGetSessionMsgListRsp {
    public final GProAISearchGetSessionMsgListRsp mInfo;

    public GGProAISearchGetSessionMsgListRsp(GProAISearchGetSessionMsgListRsp gProAISearchGetSessionMsgListRsp) {
        this.mInfo = gProAISearchGetSessionMsgListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp
    public long getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp
    public boolean getIsFinished() {
        return this.mInfo.getIsFinished();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp
    public ArrayList<IGProAISearchSessionMsg> getSessionMsgList() {
        ArrayList<GProAISearchSessionMsg> sessionMsgList = this.mInfo.getSessionMsgList();
        ArrayList<IGProAISearchSessionMsg> arrayList = new ArrayList<>();
        Iterator<GProAISearchSessionMsg> it = sessionMsgList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAISearchSessionMsg(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp
    public String getWebCookie() {
        return this.mInfo.getWebCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
