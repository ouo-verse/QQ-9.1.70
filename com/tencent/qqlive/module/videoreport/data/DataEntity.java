package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DataEntity {

    @Nullable
    IElementDynamicParams elementDynamicParams;
    String elementId;
    Map<String, Object> elementParams;
    SparseArray<ElementDataEntity> elementVirtualParentParams;

    @Nullable
    IDynamicParams eventDynamicParams;
    Map<String, Object> extendMap;
    Map<String, Object> innerParams;
    String pageContentId;
    String pageId;
    Map<String, Object> pageParams;
    DataEntity parentEntity;

    private ElementDataEntity copyElementDataEntity(ElementDataEntity elementDataEntity) {
        HashMap hashMap = null;
        if (elementDataEntity == null) {
            return null;
        }
        ElementDataEntity elementDataEntity2 = new ElementDataEntity();
        elementDataEntity2.elementId = elementDataEntity.elementId;
        if (elementDataEntity.elementParams != null) {
            hashMap = new HashMap(elementDataEntity.elementParams);
        }
        elementDataEntity2.elementParams = hashMap;
        return elementDataEntity2;
    }

    private SparseArray<ElementDataEntity> copyVirtualParentParams(SparseArray<ElementDataEntity> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        SparseArray<ElementDataEntity> sparseArray2 = new SparseArray<>();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            sparseArray2.put(sparseArray.keyAt(i3), copyElementDataEntity(sparseArray.valueAt(i3)));
        }
        return sparseArray2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataEntity copy() {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        DataEntity copy;
        DataEntity dataEntity = new DataEntity();
        dataEntity.elementId = this.elementId;
        HashMap hashMap4 = null;
        if (this.elementParams == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(this.elementParams);
        }
        dataEntity.elementParams = hashMap;
        dataEntity.elementDynamicParams = this.elementDynamicParams;
        dataEntity.elementVirtualParentParams = copyVirtualParentParams(this.elementVirtualParentParams);
        dataEntity.pageId = this.pageId;
        dataEntity.pageContentId = this.pageContentId;
        if (this.pageParams == null) {
            hashMap2 = null;
        } else {
            hashMap2 = new HashMap(this.pageParams);
        }
        dataEntity.pageParams = hashMap2;
        if (this.innerParams == null) {
            hashMap3 = null;
        } else {
            hashMap3 = new HashMap(this.innerParams);
        }
        dataEntity.innerParams = hashMap3;
        DataEntity dataEntity2 = this.parentEntity;
        if (dataEntity2 == null) {
            copy = null;
        } else {
            copy = dataEntity2.copy();
        }
        dataEntity.parentEntity = copy;
        if (this.extendMap != null) {
            hashMap4 = new HashMap(this.extendMap);
        }
        dataEntity.extendMap = hashMap4;
        dataEntity.eventDynamicParams = this.eventDynamicParams;
        return dataEntity;
    }

    public IDynamicParams getEventDynamicParams() {
        return this.eventDynamicParams;
    }

    public String toString() {
        return "DataEntity{elementId='" + this.elementId + "', elementParams=" + this.elementParams + ", pageId='" + this.pageId + "', pageContentId='" + this.pageContentId + "', pageParams=" + this.pageParams + "', innerParams=" + this.innerParams + '}';
    }

    public void unRegisterDynamicParamsProvider() {
        this.eventDynamicParams = null;
    }
}
