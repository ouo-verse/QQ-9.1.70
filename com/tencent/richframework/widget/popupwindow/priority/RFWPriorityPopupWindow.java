package com.tencent.richframework.widget.popupwindow.priority;

import a04.d;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementFactory;
import com.tencent.biz.richframework.order.a;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;

/* loaded from: classes25.dex */
public class RFWPriorityPopupWindow extends RFWSmartPopupWindow<RFWPriorityPopupWindow> implements IOrderElement {
    private String mBusinessTag;
    private String mGroup;
    private int mPriority;

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWPriorityPopupWindow(Context context) {
        super(context);
        this.mBusinessTag = "common_business_tag";
        this.mPriority = Integer.MIN_VALUE;
        addStatusCallback(new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.richframework.widget.popupwindow.priority.RFWPriorityPopupWindow.1
            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public /* bridge */ /* synthetic */ void onClick(View view) {
                d.a(this, view);
            }

            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public void onDismiss() {
                if (RFWPriorityPopupWindow.this.isEnablePriority() && RFWOrderElementFactory.getOrderElementManager(RFWPriorityPopupWindow.this.mBusinessTag).isElementActivating(RFWPriorityPopupWindow.this)) {
                    RFWOrderElementFactory.getOrderElementManager(RFWPriorityPopupWindow.this.mBusinessTag).inactivateElement(RFWPriorityPopupWindow.this);
                    RFWOrderElementFactory.getOrderElementManager(RFWPriorityPopupWindow.this.mBusinessTag).removeElement(RFWPriorityPopupWindow.this);
                }
            }

            @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
            public void onShow() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEnablePriority() {
        return !TextUtils.isEmpty(this.mGroup);
    }

    private void showByPriority() {
        RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "isEnablePriority is true. group: " + this.mGroup + ", business: " + this.mBusinessTag);
        if (!RFWOrderElementFactory.getOrderElementManager(this.mBusinessTag).isElementActivating(this)) {
            RFWOrderElementFactory.getOrderElementManager(this.mBusinessTag).addElement(this);
            RFWOrderElementFactory.getOrderElementManager(this.mBusinessTag).notifyGroupActivate(this);
        }
    }

    @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow
    protected String generateWindowKey() {
        String valueOf = String.valueOf(this.mContextHashCode);
        if (isEnablePriority()) {
            valueOf = valueOf + getGroup();
        }
        RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "generateTipKey: " + valueOf);
        return valueOf;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.mContextHashCode);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        if (!isEnablePriority()) {
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "enable priority must specify group");
            return null;
        }
        return this.mGroup;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return a.b(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        int i3 = this.mPriority;
        if (i3 == Integer.MIN_VALUE) {
            RFWLog.d("RFWSmartPopupWindow", RFWLog.USR, "enable priority must specify priority");
            return 0;
        }
        return i3;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return true;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        if (!isEnablePriority()) {
            return;
        }
        super.show();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        if (isEnablePriority()) {
            setShowCondition(null);
        }
    }

    public RFWPriorityPopupWindow setBusinessTag(String str) {
        this.mBusinessTag = str;
        return this;
    }

    public RFWPriorityPopupWindow setGroup(String str) {
        this.mGroup = str;
        return this;
    }

    public RFWPriorityPopupWindow setPriority(int i3) {
        this.mPriority = i3;
        return this;
    }

    @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow
    public void show() {
        if (isEnablePriority()) {
            showByPriority();
        } else {
            super.show();
        }
    }

    public RFWPriorityPopupWindow setShowCondition(RFWSmartPopupWindow.IShowCondition iShowCondition) {
        return this;
    }
}
