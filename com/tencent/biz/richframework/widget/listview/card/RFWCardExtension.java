package com.tencent.biz.richframework.widget.listview.card;

import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardStateListener;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardExtension {
    public RFWCardViewBuilder cardViewBuilder;
    public IRFWCardReport report;
    public RFWCardStateListener stateListener;

    public RFWCardExtension setCardViewBuilder(RFWCardViewBuilder rFWCardViewBuilder) {
        this.cardViewBuilder = rFWCardViewBuilder;
        return this;
    }

    public RFWCardExtension setReport(IRFWCardReport iRFWCardReport) {
        this.report = iRFWCardReport;
        return this;
    }

    public RFWCardExtension setStateListener(RFWCardStateListener rFWCardStateListener) {
        this.stateListener = rFWCardStateListener;
        return this;
    }
}
