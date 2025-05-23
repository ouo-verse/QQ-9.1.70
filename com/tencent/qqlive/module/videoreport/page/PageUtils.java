package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.IPageParamsFormatter;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes22.dex */
public class PageUtils {
    public static final String VR_PAGE_NONE = "vr_page_none";

    private static void addPagePath(Map<String, Object> map, DataEntity dataEntity) {
        if (!VideoReportInner.getInstance().getConfiguration().isEnablePageLink()) {
            return;
        }
        map.put(ParamKey.PAGE_PATH, getPagePath(dataEntity));
    }

    public static FinalData createTrackData(String str, @NonNull Object obj) {
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        finalData.setEventKey(str);
        finalData.put("cur_pg", getPageInfo(str, obj, obj.hashCode()));
        return finalData;
    }

    private static void fillPageInfo(String str, Map<String, Object> map, DataEntity dataEntity, int i3, boolean z16) {
        ListIterator<DataEntity> entityLink = getEntityLink(dataEntity, true);
        while (entityLink.hasNext()) {
            putPageParams(str, map, entityLink.next());
            if (z16) {
                insertLastClickInfo(dataEntity, map);
            }
        }
        addPagePath(map, dataEntity);
        map.put(ParamKey.REPORT_KEY_PG_STP, Integer.valueOf(i3));
    }

    private static ListIterator<DataEntity> getEntityLink(DataEntity dataEntity, boolean z16) {
        ArrayList arrayList = new ArrayList();
        while (dataEntity != null) {
            if (z16) {
                arrayList.add(0, dataEntity);
            } else {
                arrayList.add(dataEntity);
            }
            dataEntity = DataEntityOperator.getParentEntity(dataEntity);
        }
        return arrayList.listIterator();
    }

    @NonNull
    public static Map<String, Object> getPageInfo(String str, Object obj, int i3) {
        int i16;
        DataEntity dataEntity;
        HashMap hashMap = new HashMap(4);
        PageContext pageContext = PageContextManager.getInstance().get(i3);
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        if (pageContext != null) {
            i16 = pageContext.pageStep;
            dataEntity = pageContext.curPageData;
            fillPageInfo(str, hashMap2, pageContext.refPageData, pageContext.refPageStep, true);
            fillPageInfo(str, hashMap3, pageContext.crePageData, pageContext.crePageStep, true);
        } else {
            i16 = -1;
            dataEntity = null;
        }
        hashMap.put("ref_pg", hashMap2);
        hashMap.put("cre_pg", hashMap3);
        if (dataEntity == null) {
            dataEntity = DataBinder.getDataEntity(obj);
        }
        fillPageInfo(str, hashMap, dataEntity, i16, false);
        IPageParamsFormatter pageParamsFormatter = VideoReportInner.getInstance().getPageParamsFormatter();
        if (pageParamsFormatter != null) {
            return pageParamsFormatter.format(str, hashMap);
        }
        return hashMap;
    }

    private static PageLastClickEleInfo getPageLastClickEleInfo(DataEntity dataEntity) {
        if (dataEntity == null) {
            return null;
        }
        Object innerParam = DataEntityOperator.getInnerParam(dataEntity, InnerKey.LAST_CLICK_ELEMENT);
        if (!(innerParam instanceof PageLastClickEleInfo)) {
            return null;
        }
        return (PageLastClickEleInfo) innerParam;
    }

    private static List<String> getPagePath(DataEntity dataEntity) {
        ArrayList arrayList = new ArrayList();
        ListIterator<DataEntity> entityLink = getEntityLink(dataEntity, false);
        while (entityLink.hasNext()) {
            arrayList.add(DataEntityOperator.getPageId(entityLink.next()));
        }
        return arrayList;
    }

    public static void insertLastClickInfo(DataEntity dataEntity, Map<String, Object> map) {
        PageLastClickEleInfo pageLastClickEleInfo = getPageLastClickEleInfo(dataEntity);
        if (pageLastClickEleInfo != null && pageLastClickEleInfo.getElementParams() != null) {
            map.put(ParamKey.LAST_CLICK_ELE, pageLastClickEleInfo.getElementParams());
        }
    }

    public static boolean isCurrentPage(@Nullable PageInfo pageInfo) {
        return pageInfo != null && isCurrentPage(pageInfo.getPage());
    }

    private static void putPageParams(String str, Map<String, Object> map, DataEntity dataEntity) {
        Map<String, Object> dynamicParams;
        if (dataEntity == null) {
            return;
        }
        String pageId = DataEntityOperator.getPageId(dataEntity);
        String contentId = DataEntityOperator.getContentId(dataEntity);
        Map<String, ?> pageParams = DataEntityOperator.getPageParams(dataEntity);
        map.put("pgid", pageId);
        if (contentId != null) {
            map.put(ParamKey.CONTENT_ID, contentId);
        }
        if (pageParams != null) {
            map.putAll(pageParams);
        }
        IDynamicParams eventDynamicParams = dataEntity.getEventDynamicParams();
        if (eventDynamicParams == null) {
            dynamicParams = null;
        } else {
            dynamicParams = eventDynamicParams.getDynamicParams(str);
        }
        if (dynamicParams != null) {
            map.putAll(dynamicParams);
        }
    }

    public static boolean isCurrentPage(@Nullable Object obj) {
        PageInfo currentPageInfo;
        return (obj == null || (currentPageInfo = PageManager.getInstance().getCurrentPageInfo()) == null || currentPageInfo.getPage() != obj) ? false : true;
    }
}
