package com.tencent.qqlive.module.videoreport.page;

import android.view.View;
import java.util.Map;

/* loaded from: classes22.dex */
public class VideoReportPageInfo {
    public final Object page;
    public final String pageId;
    public final Map<String, Object> pageParams;
    public final View pageView;
    public final Map<String, Object> reportData;

    public VideoReportPageInfo(Object obj, View view, String str, Map<String, Object> map, Map<String, Object> map2) {
        this.page = obj;
        this.pageView = view;
        this.pageId = str;
        this.pageParams = map;
        this.reportData = map2;
    }
}
