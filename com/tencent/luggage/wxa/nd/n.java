package com.tencent.luggage.wxa.nd;

import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n {
    public String a(String str) {
        return str.replace(ContainerUtils.FIELD_DELIMITER, "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("'", "&apos;");
    }
}
