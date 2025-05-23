package com.tencent.qqlive.module.videoreport.page;

import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.data.DataEntity;

/* loaded from: classes22.dex */
public class PageContextManager {
    public static final int DEFAULT_PAGE_STEP = -1;
    private SparseArray<PageContext> mContextMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final PageContextManager INSTANCE = new PageContextManager();

        InstanceHolder() {
        }
    }

    public static PageContextManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void clear() {
        int i3;
        DataEntity dataEntity;
        DataEntity dataEntity2;
        int size = this.mContextMap.size();
        for (int i16 = 0; i16 < size; i16++) {
            PageContext valueAt = this.mContextMap.valueAt(i16);
            if (valueAt == null) {
                i3 = -1;
            } else {
                i3 = valueAt.crePageStep;
            }
            int i17 = i3;
            if (valueAt == null) {
                dataEntity = null;
            } else {
                dataEntity = valueAt.curPageData;
            }
            if (valueAt == null) {
                dataEntity2 = null;
            } else {
                dataEntity2 = valueAt.crePageData;
            }
            this.mContextMap.setValueAt(i16, new PageContext(-1, -1, i17, dataEntity, null, dataEntity2));
        }
    }

    public PageContext get(int i3) {
        return this.mContextMap.get(i3);
    }

    public void remove(int i3) {
        this.mContextMap.remove(i3);
    }

    public void set(int i3, PageContext pageContext) {
        this.mContextMap.put(i3, pageContext);
    }

    PageContextManager() {
        this.mContextMap = new SparseArray<>();
    }
}
