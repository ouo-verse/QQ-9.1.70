package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.ElementDataEntity;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.reuse.ReusablePool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DataBuilderWithFormatter implements IDataBuilder {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final DataBuilderWithFormatter INSTANCE = new DataBuilderWithFormatter();

        InstanceHolder() {
        }
    }

    private List<ReportData> addVirtualParentParams(DataEntity dataEntity) {
        ArrayList arrayList = null;
        if (dataEntity == null) {
            return null;
        }
        SparseArray<ElementDataEntity> virtualElementParentParams = DataEntityOperator.getVirtualElementParentParams(dataEntity);
        if (virtualElementParentParams != null && virtualElementParentParams.size() != 0) {
            arrayList = new ArrayList();
            for (int i3 = 0; i3 < virtualElementParentParams.size(); i3++) {
                ElementDataEntity valueAt = virtualElementParentParams.valueAt(i3);
                if (valueAt != null) {
                    ReportData reportData = (ReportData) ReusablePool.obtain(ReportData.class);
                    reportData.setId(valueAt.elementId);
                    reportData.setParams(valueAt.elementParams);
                    arrayList.add(reportData);
                }
            }
        }
        return arrayList;
    }

    @NonNull
    private ArrayList<ReportData> getElementsData(String str, PathData pathData) {
        ArrayList<ReportData> arrayList = new ArrayList<>();
        Iterator<DataEntity> it = pathData.iterator();
        while (it.hasNext()) {
            DataEntity next = it.next();
            if (next != null) {
                String elementId = DataEntityOperator.getElementId(next);
                HashMap hashMap = new HashMap();
                Map<String, Object> elementParams = DataEntityOperator.getElementParams(next);
                ReportData reportData = (ReportData) ReusablePool.obtain(ReportData.class);
                reportData.setId(elementId);
                Map<String, Object> dynamicElementParams = DataEntityOperator.getDynamicElementParams(str, next);
                if (!BaseUtils.isEmpty(elementParams)) {
                    hashMap.putAll(elementParams);
                }
                if (!BaseUtils.isEmpty(dynamicElementParams)) {
                    hashMap.putAll(dynamicElementParams);
                }
                reportData.setParams(hashMap);
                arrayList.add(reportData);
                List<ReportData> addVirtualParentParams = addVirtualParentParams(next);
                if (!BaseUtils.isEmpty(addVirtualParentParams)) {
                    arrayList.addAll(addVirtualParentParams);
                }
            }
        }
        return arrayList;
    }

    public static DataBuilderWithFormatter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private ReportData getPageData(String str, PathData pathData) {
        ReportData reportData = (ReportData) ReusablePool.obtain(ReportData.class);
        Object page = pathData.getPage();
        if (page == null) {
            return null;
        }
        String pageId = DataRWProxy.getPageId(page);
        Map<String, ?> pageInfo = PageUtils.getPageInfo(str, page, page.hashCode());
        reportData.setId(pageId);
        reportData.setParams(pageInfo);
        return reportData;
    }

    private void recycleObjects(ArrayList<ReportData> arrayList, ReportData reportData) {
        Iterator<ReportData> it = arrayList.iterator();
        while (it.hasNext()) {
            ReusablePool.recycle(it.next());
        }
        ReusablePool.recycle(reportData);
    }

    @Override // com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder
    @Nullable
    public FinalData build(String str, PathData pathData) {
        if (pathData == null) {
            return null;
        }
        ArrayList<ReportData> elementsData = getElementsData(str, pathData);
        ReportData pageData = getPageData(str, pathData);
        Map<String, Object> formatElementParams = VideoReportInner.getInstance().getConfiguration().getFormatter().formatElementParams(elementsData, pageData);
        FinalData finalData = (FinalData) ReusablePool.obtain(FinalData.class);
        if (formatElementParams != null) {
            finalData.eventParams = formatElementParams;
        }
        recycleObjects(elementsData, pageData);
        return finalData;
    }

    DataBuilderWithFormatter() {
    }
}
