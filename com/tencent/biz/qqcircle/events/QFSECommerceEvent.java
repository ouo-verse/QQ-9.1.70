package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.utils.be;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSECommerceEvent extends SimpleBaseEvent {
    public static int TYPE_ADD_ECOMMERCE_GOODS = 1;
    public static int TYPE_CLOSE_ECOMMERCE_PAGE;
    private be mEcommerceBean;
    private String mFeedId;
    private int mType;

    public be getEcommerceBean() {
        return this.mEcommerceBean;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getType() {
        return this.mType;
    }

    public void setEcommerceBean(be beVar) {
        this.mEcommerceBean = beVar;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public String toString() {
        return "QFSECommerceEvent{mType=" + this.mType + ", mEcommerceBean=" + this.mEcommerceBean + "} " + super.toString();
    }
}
