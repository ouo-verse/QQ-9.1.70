package com.tencent.biz.qqcircle.beans;

import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;

/* loaded from: classes4.dex */
public class QFSPersonalMenuInfo {
    private RFWSmartPopupWindow.IStatusCallback bubbleCallBack;
    private String bubbleTipText;
    private int iconResource;
    private String title;

    public QFSPersonalMenuInfo() {
    }

    public RFWSmartPopupWindow.IStatusCallback getBubbleCallBack() {
        return this.bubbleCallBack;
    }

    public String getBubbleTipText() {
        return this.bubbleTipText;
    }

    public int getIconResource() {
        return this.iconResource;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBubbleCallBack(RFWSmartPopupWindow.IStatusCallback iStatusCallback) {
        this.bubbleCallBack = iStatusCallback;
    }

    public void setBubbleTipText(String str) {
        this.bubbleTipText = str;
    }

    public void setIconResource(int i3) {
        this.iconResource = i3;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public QFSPersonalMenuInfo(String str, int i3) {
        this(str, i3, null, null);
    }

    public QFSPersonalMenuInfo(String str, int i3, String str2, RFWSmartPopupWindow.IStatusCallback iStatusCallback) {
        this.title = str;
        this.iconResource = i3;
        this.bubbleTipText = str2;
        this.bubbleCallBack = iStatusCallback;
    }
}
