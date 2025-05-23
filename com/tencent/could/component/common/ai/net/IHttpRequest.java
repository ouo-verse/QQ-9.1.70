package com.tencent.could.component.common.ai.net;

import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IHttpRequest {
    void cleanExecute();

    void execute();

    NetWorkParam getNetWorkParam();

    void setListener(CallBackListener callBackListener);

    void setNeedIpBackUrl(boolean z16);

    void setNeedIpBackUrls(boolean z16, int i3);

    void setNeedUseDeputy(boolean z16);

    void setNetWorkParam(NetWorkParam netWorkParam);
}
