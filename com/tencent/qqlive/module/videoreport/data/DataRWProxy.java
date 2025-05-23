package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.InnerKey;
import java.util.Map;

/* loaded from: classes22.dex */
public class DataRWProxy {
    public static String getContentId(Object obj) {
        return DataEntityOperator.getContentId(getDataEntity(obj, false));
    }

    public static DataEntity getDataEntity(Object obj, boolean z16) {
        DataEntity dataEntity = DataBinder.getDataEntity(obj);
        if (dataEntity == null && z16) {
            DataEntity dataEntity2 = new DataEntity();
            DataBinder.setDataEntity(obj, dataEntity2);
            return dataEntity2;
        }
        return dataEntity;
    }

    public static String getElementId(Object obj) {
        return DataEntityOperator.getElementId(getDataEntity(obj, false));
    }

    public static Map<String, Object> getElementParams(Object obj) {
        return DataEntityOperator.getElementParams(getDataEntity(obj, false));
    }

    public static EventAgingType getEventType(Object obj) {
        return (EventAgingType) DataEntityOperator.getInnerParam(getDataEntity(obj, false), InnerKey.ELEMENT_EVENT_TYPE);
    }

    public static Object getExtendParam(Object obj, String str) {
        return getExtendParam(getDataEntity(obj, true), str);
    }

    @Nullable
    public static Object getInnerParam(Object obj, String str) {
        return DataEntityOperator.getInnerParam(getDataEntity(obj, true), str);
    }

    public static String getPageId(Object obj) {
        return DataEntityOperator.getPageId(getDataEntity(obj, false));
    }

    public static Map<String, ?> getPageParams(Object obj) {
        return DataEntityOperator.getPageParams(getDataEntity(obj, false));
    }

    public static void putExtendParam(Object obj, String str, Object obj2) {
        putExtendParam(getDataEntity(obj, true), str, obj2);
    }

    public static void removeAllElementParams(Object obj) {
        DataEntityOperator.removeAllElementParams(getDataEntity(obj, false));
    }

    public static void removeAllPageParams(Object obj) {
        DataEntityOperator.removeAllPageParams(getDataEntity(obj, false));
    }

    public static void removeElementParam(Object obj, String str) {
        DataEntityOperator.removeElementParam(getDataEntity(obj, false), str);
    }

    public static void removeInnerParam(Object obj, String str) {
        DataEntityOperator.removeInnerParam(getDataEntity(obj, true), str);
    }

    public static void removePageParam(Object obj, String str) {
        DataEntityOperator.removePageParam(getDataEntity(obj, false), str);
    }

    @Deprecated
    public static void setElementDynamicParam(Object obj, IElementDynamicParams iElementDynamicParams) {
        DataEntityOperator.setElementParams(getDataEntity(obj, true), iElementDynamicParams);
    }

    public static void setElementId(Object obj, String str) {
        DataEntityOperator.setElementId(getDataEntity(obj, true), str);
    }

    public static void setElementParam(Object obj, String str, Object obj2) {
        DataEntityOperator.setElementParams(getDataEntity(obj, true), str, obj2);
    }

    public static void setElementParams(Object obj, Map<String, ?> map) {
        DataEntityOperator.setElementParams(getDataEntity(obj, true), map);
    }

    public static void setElementVirtualParentParams(Object obj, int i3, String str, Map<String, Object> map) {
        DataEntityOperator.setElementVirtualParentParams(getDataEntity(obj, false), i3, str, map);
    }

    public static void setEventDynamicParam(Object obj, @Nullable IDynamicParams iDynamicParams) {
        DataEntityOperator.setEventDynamicParams(getDataEntity(obj, true), iDynamicParams);
    }

    public static void setEventType(Object obj, EventAgingType eventAgingType) {
        DataEntityOperator.putInnerParam(getDataEntity(obj, true), InnerKey.ELEMENT_EVENT_TYPE, eventAgingType);
    }

    public static void setInnerParam(Object obj, String str, Object obj2) {
        DataEntityOperator.putInnerParam(getDataEntity(obj, true), str, obj2);
    }

    public static void setPageContentId(Object obj, String str) {
        DataEntityOperator.setPageContentId(getDataEntity(obj, true), str);
    }

    public static void setPageId(Object obj, String str) {
        DataEntityOperator.setPageId(getDataEntity(obj, true), str);
    }

    public static void setPageParams(Object obj, Map<String, ?> map) {
        DataEntityOperator.setPageParams(getDataEntity(obj, true), map);
    }

    public static Object getExtendParam(Object obj, String str, Object obj2) {
        Object extendParam = getExtendParam(getDataEntity(obj, true), str);
        return extendParam != null ? extendParam : obj2;
    }

    public static void putExtendParam(DataEntity dataEntity, String str, Object obj) {
        DataEntityOperator.putExtendParam(dataEntity, str, obj);
    }

    public static void setPageParams(Object obj, String str, Object obj2) {
        DataEntityOperator.setPageParams(getDataEntity(obj, true), str, obj2);
    }

    public static Object getExtendParam(DataEntity dataEntity, String str) {
        return DataEntityOperator.getExtendParam(dataEntity, str);
    }
}
