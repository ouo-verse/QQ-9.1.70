package com.tencent.biz.richframework.ioc.bean;

import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FindIocKeyResult {
    private final List<String> mIocKeyList;

    public FindIocKeyResult(List<String> list) {
        this.mIocKeyList = list;
    }

    public List<String> getIocKeyList() {
        return this.mIocKeyList;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("FindIocKeyResult{mIocKeyList=");
        List<String> list = this.mIocKeyList;
        if (list != null) {
            str = Arrays.toString(list.toArray());
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }
}
