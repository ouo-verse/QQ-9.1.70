package com.tencent.qqlive.module.videoreport.flutter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes22.dex */
public class DTFlutterPageManager implements PageManager.IPageListener {
    private static final String VIRTUAL_FLUTTER_PAGE_ID = "virtual_flutter_page_id";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final DTFlutterPageManager INSTANCE = new DTFlutterPageManager();

        InstanceHolder() {
        }
    }

    public static DTFlutterPageManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void bindFlutter(View view, DTFlutterApi dTFlutterApi) {
        DataRWProxy.putExtendParam(view, DTConstants.DTExtendMapKey.FLUTTER_API, dTFlutterApi);
        VideoReportInner.getInstance().setPageId(view, VIRTUAL_FLUTTER_PAGE_ID, true);
    }

    public DTFlutterApi getFlutterApi(View view) {
        Object extendParam = DataRWProxy.getExtendParam(view, DTConstants.DTExtendMapKey.FLUTTER_API);
        if (extendParam instanceof DTFlutterApi) {
            return (DTFlutterApi) extendParam;
        }
        return null;
    }

    public DataEntity getRealFlutterDataEntity(DataEntity dataEntity) {
        DTFlutterApi flutterApi = getFlutterApi(dataEntity);
        if (flutterApi == null) {
            return dataEntity;
        }
        DataEntity copy = DataEntityOperator.copy(dataEntity);
        VideoReportPageInfo pageInfo = flutterApi.getPageInfo();
        DataEntityOperator.setPageId(copy, pageInfo.pageId);
        DataEntityOperator.setPageParams(copy, pageInfo.pageParams);
        return copy;
    }

    public boolean isFlutterEntity(DataEntity dataEntity) {
        return DataRWProxy.getExtendParam(dataEntity, DTConstants.DTExtendMapKey.FLUTTER_API) instanceof DTFlutterApi;
    }

    public boolean isFlutterView(View view) {
        return DataRWProxy.getExtendParam(view, DTConstants.DTExtendMapKey.FLUTTER_API) instanceof DTFlutterApi;
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageIn(@NonNull PageInfo pageInfo, @NonNull Set<PageInfo> set, int i3) {
        Iterator<PageInfo> it = set.iterator();
        while (it.hasNext()) {
            DTFlutterApi flutterApi = getFlutterApi(it.next().getPageView());
            if (flutterApi != null) {
                flutterApi.onVisibilityChanged(0);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageOut(@NonNull PageInfo pageInfo, DataEntity dataEntity, @NonNull Set<PageInfo> set, boolean z16) {
        Object extendParam = DataEntityOperator.getExtendParam(dataEntity, DTConstants.DTExtendMapKey.FLUTTER_API);
        if (extendParam instanceof DTFlutterApi) {
            DTFlutterApi dTFlutterApi = (DTFlutterApi) extendParam;
            VideoReportPageInfo pageInfo2 = dTFlutterApi.getPageInfo();
            DataEntityOperator.setPageId(dataEntity, pageInfo2.pageId);
            DataEntityOperator.setPageParams(dataEntity, pageInfo2.pageParams);
            dTFlutterApi.onVisibilityChanged(4);
        }
    }

    public void putPageParams(Map<String, Object> map, DataEntity dataEntity) {
        DTFlutterApi flutterApi = getFlutterApi(dataEntity);
        if (flutterApi == null) {
            return;
        }
        VideoReportPageInfo pageInfo = flutterApi.getPageInfo();
        Object obj = pageInfo.pageId;
        String contentId = DataEntityOperator.getContentId(dataEntity);
        Map<? extends String, ? extends Object> map2 = pageInfo.pageParams;
        map.put("pgid", obj);
        if (!TextUtils.isEmpty(contentId)) {
            map.put(ParamKey.CONTENT_ID, contentId);
        }
        if (map2 != null) {
            map.putAll(map2);
        }
    }

    public void reportFlutterEvent(String str, Map<String, ?> map) {
        if (TextUtils.isEmpty(str)) {
            if (!VideoReport.isDebugMode()) {
                return;
            } else {
                throw new IllegalArgumentException("reportEvent, eventId is empty");
            }
        }
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(str);
        if (map != null) {
            finalData.putAll(map);
        }
        FinalDataTarget.handle(null, finalData);
    }

    DTFlutterPageManager() {
        PageManager.getInstance().register(this);
    }

    public DTFlutterApi getFlutterApi(DataEntity dataEntity) {
        Object extendParam = DataRWProxy.getExtendParam(dataEntity, DTConstants.DTExtendMapKey.FLUTTER_API);
        if (extendParam instanceof DTFlutterApi) {
            return (DTFlutterApi) extendParam;
        }
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageUpdate(PageInfo pageInfo, int i3) {
    }
}
