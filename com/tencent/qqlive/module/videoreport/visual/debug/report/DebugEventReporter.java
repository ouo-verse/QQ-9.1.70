package com.tencent.qqlive.module.videoreport.visual.debug.report;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.PublicParamImpl;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import com.tencent.qqlive.module.videoreport.visual.debug.data.PageData;
import com.tencent.qqlive.module.videoreport.visual.debug.data.ViewData;
import com.tencent.qqlive.module.videoreport.visual.debug.util.UIUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DebugEventReporter {
    private static List<Object> buildElement(ViewData viewData) {
        View view;
        int i3;
        int i16;
        WeakReference<View> weakReference;
        WeakReference<View> weakReference2 = viewData.target;
        View view2 = null;
        if (weakReference2 != null) {
            view = weakReference2.get();
        } else {
            view = null;
        }
        ViewData viewData2 = viewData.parent;
        if (viewData2 != null && (weakReference = viewData2.target) != null) {
            view2 = weakReference.get();
        }
        int i17 = 0;
        int i18 = (viewData.reportClick ? 1 : 0) + 0;
        if (viewData.reportExposure) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        int i19 = i18 + i3;
        if (viewData.reportEndExposure) {
            i17 = 4;
        }
        int i26 = i19 + i17;
        ArrayList arrayList = new ArrayList();
        int i27 = -1;
        if (view != null) {
            i16 = view.hashCode();
        } else {
            i16 = -1;
        }
        arrayList.add(Integer.valueOf(i16));
        if (view2 != null) {
            i27 = view2.hashCode();
        }
        arrayList.add(Integer.valueOf(i27));
        arrayList.add(1);
        arrayList.add(Integer.valueOf(viewData.viewRect.top));
        arrayList.add(Integer.valueOf(viewData.viewRect.bottom));
        arrayList.add(Integer.valueOf(viewData.viewRect.left));
        arrayList.add(Integer.valueOf(viewData.viewRect.right));
        arrayList.add(Integer.valueOf(viewData.visibleRect.top));
        arrayList.add(Integer.valueOf(viewData.visibleRect.bottom));
        arrayList.add(Integer.valueOf(viewData.visibleRect.left));
        arrayList.add(Integer.valueOf(viewData.visibleRect.right));
        arrayList.add(viewData.elementId);
        arrayList.add(Integer.valueOf(i26));
        return arrayList;
    }

    private static List<Object> buildElements(@Nullable PageData pageData, List<ViewData> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ViewData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(buildElement(it.next()));
        }
        return arrayList;
    }

    private static Map<String, Object> prepareVisualParams(@Nullable PageData pageData, List<ViewData> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(UIUtils.getAppScreenWidth(ReportUtils.getContext())));
        hashMap.put("height", Integer.valueOf(UIUtils.getAppScreenHeight(ReportUtils.getContext())));
        hashMap.put("sessionId", PublicParamImpl.getInstance().getSessionId());
        hashMap.put(DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, buildElements(pageData, list));
        return hashMap;
    }

    public static void reportScreenEvent(@Nullable PageData pageData, List<ViewData> list) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_VISUAL_DATA, prepareVisualParams(pageData, list));
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(DTEventKey.SCREEN_DOM);
        finalData.putAll(hashMap);
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setEventDynamicParams(DTEventKey.SCREEN_DOM, finalData.getEventParams());
        }
        FinalDataTarget.handle(null, finalData);
    }
}
