package com.qzone.reborn.qzmoment.viewmodel;

import com.qzone.reborn.qzmoment.request.QZMBaseRequest;
import com.qzone.reborn.qzmoment.request.QZMGetMyFeedListRequest;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m extends c {
    @Override // com.qzone.reborn.qzmoment.viewmodel.c
    protected QZMBaseRequest S1() {
        return new QZMGetMyFeedListRequest(null, this.f59094i.getStringAttachInfo());
    }

    @Override // com.qzone.reborn.qzmoment.viewmodel.c
    protected String U1() {
        return "page_type_feed_my_do_like";
    }

    @Override // com.qzone.reborn.qzmoment.viewmodel.c
    protected String W1() {
        return "qzm_history_data_preload_id";
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMMyMomentViewModel";
    }
}
