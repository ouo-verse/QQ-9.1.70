package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DataEntityOperator {
    public static DataEntity copy(@NonNull DataEntity dataEntity) {
        return dataEntity.copy();
    }

    public static void filterNotNullKeyValue(Map<String, ?> map, Map<String, Object> map2) {
        if (map2 != null && map.size() > 0) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static String getContentId(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return null;
        }
        return dataEntity.pageContentId;
    }

    @Nullable
    public static Map<String, Object> getDynamicElementParams(String str, @Nullable DataEntity dataEntity) {
        Map<String, Object> map = null;
        if (dataEntity == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        IDynamicParams eventDynamicParams = dataEntity.getEventDynamicParams();
        if (eventDynamicParams != null) {
            map = eventDynamicParams.getDynamicParams(str);
        }
        if (!BaseUtils.isEmpty(map)) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public static String getElementId(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return null;
        }
        return dataEntity.elementId;
    }

    @Nullable
    public static Map<String, Object> getElementParams(@Nullable DataEntity dataEntity) {
        Map<String, Object> map = null;
        if (dataEntity == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (!BaseUtils.isEmpty(dataEntity.elementParams)) {
            hashMap.putAll(dataEntity.elementParams);
        }
        IElementDynamicParams iElementDynamicParams = dataEntity.elementDynamicParams;
        if (iElementDynamicParams != null) {
            map = iElementDynamicParams.getElementDynamicParams();
        }
        if (!BaseUtils.isEmpty(map)) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public static Object getExtendParam(DataEntity dataEntity, String str) {
        Map<String, Object> map;
        if (dataEntity != null && !TextUtils.isEmpty(str) && (map = dataEntity.extendMap) != null) {
            return map.get(str);
        }
        return null;
    }

    @Nullable
    public static Object getInnerParam(DataEntity dataEntity, String str) {
        if (dataEntity != null && dataEntity.innerParams != null && !TextUtils.isEmpty(str)) {
            return dataEntity.innerParams.get(str);
        }
        return null;
    }

    public static String getPageId(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return null;
        }
        return dataEntity.pageId;
    }

    public static Map<String, ?> getPageParams(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return null;
        }
        return dataEntity.pageParams;
    }

    public static DataEntity getParentEntity(DataEntity dataEntity) {
        if (dataEntity != null) {
            return dataEntity.parentEntity;
        }
        return null;
    }

    @Nullable
    public static SparseArray<ElementDataEntity> getVirtualElementParentParams(@Nullable DataEntity dataEntity) {
        if (dataEntity == null) {
            return null;
        }
        return dataEntity.elementVirtualParentParams;
    }

    public static void putExtendParam(DataEntity dataEntity, String str, Object obj) {
        if (dataEntity != null && !TextUtils.isEmpty(str)) {
            if (dataEntity.extendMap == null) {
                dataEntity.extendMap = new HashMap(1);
            }
            dataEntity.extendMap.put(str, obj);
        }
    }

    public static void putInnerParam(DataEntity dataEntity, String str, Object obj) {
        if (dataEntity != null && !TextUtils.isEmpty(str) && obj != null) {
            if (dataEntity.innerParams == null) {
                dataEntity.innerParams = new ConcurrentHashMap(1);
            }
            dataEntity.innerParams.put(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAllElementParams(DataEntity dataEntity) {
        if (dataEntity == null) {
            return;
        }
        Map<String, Object> map = dataEntity.elementParams;
        if (map != null) {
            map.clear();
        }
        dataEntity.elementDynamicParams = null;
        SparseArray<ElementDataEntity> sparseArray = dataEntity.elementVirtualParentParams;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        dataEntity.elementVirtualParentParams = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeAllPageParams(DataEntity dataEntity) {
        Map<String, Object> map;
        if (dataEntity != null && (map = dataEntity.pageParams) != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeElementParam(DataEntity dataEntity, String str) {
        Map<String, Object> map;
        if (dataEntity != null && (map = dataEntity.elementParams) != null) {
            map.remove(str);
        }
    }

    public static void removeInnerParam(DataEntity dataEntity, String str) {
        Map<String, Object> map;
        if (dataEntity != null && (map = dataEntity.innerParams) != null) {
            map.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removePageParam(DataEntity dataEntity, String str) {
        Map<String, Object> map;
        if (dataEntity != null && !TextUtils.isEmpty(str) && (map = dataEntity.pageParams) != null) {
            map.remove(str);
        }
    }

    public static void setElementId(DataEntity dataEntity, String str) {
        if (dataEntity != null) {
            dataEntity.elementId = str;
        }
    }

    public static void setElementParams(DataEntity dataEntity, Map<String, ?> map) {
        if (dataEntity == null || map == null || map.size() <= 0) {
            return;
        }
        if (dataEntity.elementParams == null) {
            dataEntity.elementParams = new ConcurrentHashMap(map.size());
        }
        filterNotNullKeyValue(map, dataEntity.elementParams);
    }

    public static void setElementVirtualParentParams(DataEntity dataEntity, int i3, String str, @Nullable Map<String, Object> map) {
        if (dataEntity == null || i3 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        if (dataEntity.elementVirtualParentParams == null) {
            dataEntity.elementVirtualParentParams = new SparseArray<>();
        }
        ElementDataEntity elementDataEntity = new ElementDataEntity();
        elementDataEntity.elementId = str;
        elementDataEntity.elementParams = map;
        dataEntity.elementVirtualParentParams.put(i3, elementDataEntity);
    }

    public static void setEventDynamicParams(DataEntity dataEntity, @Nullable IDynamicParams iDynamicParams) {
        if (dataEntity == null) {
            return;
        }
        dataEntity.eventDynamicParams = iDynamicParams;
    }

    public static void setPageContentId(DataEntity dataEntity, String str) {
        if (dataEntity != null) {
            dataEntity.pageContentId = str;
        }
    }

    public static void setPageId(DataEntity dataEntity, String str) {
        if (dataEntity != null) {
            dataEntity.pageId = str;
        }
    }

    public static void setPageParams(DataEntity dataEntity, Map<String, ?> map) {
        if (dataEntity == null || map == null || map.size() <= 0) {
            return;
        }
        if (dataEntity.pageParams == null) {
            dataEntity.pageParams = new ConcurrentHashMap();
        }
        filterNotNullKeyValue(map, dataEntity.pageParams);
    }

    public static void setParentEntity(DataEntity dataEntity, DataEntity dataEntity2) {
        if (dataEntity != null) {
            dataEntity.parentEntity = dataEntity2;
        }
    }

    public static void setElementParams(DataEntity dataEntity, IElementDynamicParams iElementDynamicParams) {
        if (dataEntity == null) {
            return;
        }
        dataEntity.elementDynamicParams = iElementDynamicParams;
    }

    public static void setPageParams(DataEntity dataEntity, String str, Object obj) {
        if (dataEntity == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if (dataEntity.pageParams == null) {
            dataEntity.pageParams = new ConcurrentHashMap();
        }
        dataEntity.pageParams.put(str, obj);
    }

    public static void setElementParams(DataEntity dataEntity, String str, Object obj) {
        if (dataEntity == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if (dataEntity.elementParams == null) {
            dataEntity.elementParams = new ConcurrentHashMap(1);
        }
        dataEntity.elementParams.put(str, obj);
    }
}
