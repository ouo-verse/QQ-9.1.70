package com.tencent.biz.qqcircle.beans;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPrivateSubSettingBean extends QCircleInitBean {
    private final List<Integer> mOpMaskList = new ArrayList();
    private final List<String> mSwitchKeyList = new ArrayList();
    private final String mTitle;

    public QFSPrivateSubSettingBean(String str) {
        this.mTitle = str;
    }

    public List<Integer> getOpMaskList() {
        return this.mOpMaskList;
    }

    public List<String> getSwitchKeyList() {
        return this.mSwitchKeyList;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setOpMaskList(List<Integer> list) {
        this.mOpMaskList.addAll(list);
    }

    public void setSwitchKeyList(List<String> list) {
        this.mSwitchKeyList.addAll(list);
    }
}
