package com.tencent.biz.qqcircle.beans;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSEmotionParseBean {
    private List<int[]> mIndexList;
    private String mSourceText = this.mSourceText;
    private String mSourceText = this.mSourceText;

    public QFSEmotionParseBean(String str) {
    }

    public List<int[]> getIndexList() {
        if (this.mIndexList == null) {
            this.mIndexList = new ArrayList();
        }
        return this.mIndexList;
    }
}
