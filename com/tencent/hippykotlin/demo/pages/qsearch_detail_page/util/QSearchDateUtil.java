package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchDateUtil {
    public static final QSearchDateUtil INSTANCE = new QSearchDateUtil();

    public final String doubleD(int i3) {
        if (i3 < 10) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('0');
            sb5.append(i3);
            return sb5.toString();
        }
        return String.valueOf(i3);
    }
}
