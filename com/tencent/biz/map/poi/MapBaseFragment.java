package com.tencent.biz.map.poi;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class MapBaseFragment extends QPublicBaseFragment {
    public static void ph(String str) {
        com.tencent.biz.map.c cVar = new com.tencent.biz.map.c(BaseApplication.getContext());
        cVar.b("pg_location_search", null);
        cVar.a(Arrays.asList("em_location_search_sheet", "em_location_search_bar", "em_location_search_send", "em_location_search_cancel"));
        if ("dt_pgin".equals(str)) {
            cVar.f();
        } else if ("dt_pgout".equals(str)) {
            cVar.h(null);
        }
    }
}
