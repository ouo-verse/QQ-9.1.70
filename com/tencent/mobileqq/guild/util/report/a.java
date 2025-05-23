package com.tencent.mobileqq.guild.util.report;

import android.view.View;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    public static void a(View view, String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        map.put("sgrp_channel_id", str);
        map.put("sgrp_user_type", Integer.valueOf(v.c(str)));
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) map));
    }
}
