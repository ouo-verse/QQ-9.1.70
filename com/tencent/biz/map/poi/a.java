package com.tencent.biz.map.poi;

import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a extends Part {
    public static void x9(String str, String str2) {
        com.tencent.biz.map.c cVar = new com.tencent.biz.map.c(BaseApplication.getContext());
        cVar.b("pg_location_search", null);
        cVar.a(Arrays.asList("em_location_search_sheet", "em_location_search_bar", "em_location_search_send", "em_location_search_cancel"));
        if ("dt_imp".equals(str2)) {
            cVar.d(str, null);
        } else if ("dt_imp_end".equals(str2)) {
            cVar.e(str, null);
        } else if ("dt_clck".equals(str2)) {
            cVar.c(str, null);
        }
    }
}
