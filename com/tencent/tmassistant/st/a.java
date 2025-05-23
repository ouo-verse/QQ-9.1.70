package com.tencent.tmassistant.st;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a {
    public static final String EMPTY = " ";
    public static final String SPLIT = "|";

    public abstract String build();

    public void doReport() {
        SDKReportManager2.getInstance().postReport(getType(), build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String filterSplitStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("|", "");
    }

    protected abstract int getType();
}
