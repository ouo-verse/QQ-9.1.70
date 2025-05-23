package com.tencent.biz.richframework.part.adapter.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public interface ViewTypeStorage {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class IsolatedViewTypeStorage implements ViewTypeStorage {
        SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper = new SparseArray<>();
        int mNextViewType = 0;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class WrapperViewTypeLookup implements ViewTypeLookup {
            final NestedAdapterWrapper mWrapper;
            private final SparseIntArray mLocalToGlobalMapping = new SparseIntArray(1);
            private final SparseIntArray mGlobalToLocalMapping = new SparseIntArray(1);

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                IsolatedViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int i3) {
                int indexOfKey = this.mGlobalToLocalMapping.indexOfKey(i3);
                if (indexOfKey >= 0) {
                    return this.mGlobalToLocalMapping.valueAt(indexOfKey);
                }
                throw new IllegalStateException("requested global type " + i3 + " does not belong to the adapter:" + this.mWrapper.adapter);
            }

            @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int i3) {
                int indexOfKey = this.mLocalToGlobalMapping.indexOfKey(i3);
                if (indexOfKey > -1) {
                    return this.mLocalToGlobalMapping.valueAt(indexOfKey);
                }
                int obtainViewType = IsolatedViewTypeStorage.this.obtainViewType(this.mWrapper);
                this.mLocalToGlobalMapping.put(i3, obtainViewType);
                this.mGlobalToLocalMapping.put(obtainViewType, i3);
                return obtainViewType;
            }
        }

        @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage
        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage
        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int i3) {
            NestedAdapterWrapper nestedAdapterWrapper = this.mGlobalTypeToWrapper.get(i3);
            if (nestedAdapterWrapper != null) {
                return nestedAdapterWrapper;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i3);
        }

        int obtainViewType(NestedAdapterWrapper nestedAdapterWrapper) {
            int i3 = this.mNextViewType;
            this.mNextViewType = i3 + 1;
            this.mGlobalTypeToWrapper.put(i3, nestedAdapterWrapper);
            return i3;
        }

        void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                if (this.mGlobalTypeToWrapper.valueAt(size) == nestedAdapterWrapper) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int i3);

        int localToGlobal(int i3);
    }

    @NonNull
    ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

    @NonNull
    NestedAdapterWrapper getWrapperForGlobalType(int i3);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SharedIdRangeViewTypeStorage implements ViewTypeStorage {
        SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper = new SparseArray<>();

        @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage
        @NonNull
        public ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            return new WrapperViewTypeLookup(nestedAdapterWrapper);
        }

        @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage
        @NonNull
        public NestedAdapterWrapper getWrapperForGlobalType(int i3) {
            List<NestedAdapterWrapper> list = this.mGlobalTypeToWrapper.get(i3);
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i3);
        }

        void removeWrapper(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
            for (int size = this.mGlobalTypeToWrapper.size() - 1; size >= 0; size--) {
                List<NestedAdapterWrapper> valueAt = this.mGlobalTypeToWrapper.valueAt(size);
                if (valueAt.remove(nestedAdapterWrapper) && valueAt.isEmpty()) {
                    this.mGlobalTypeToWrapper.removeAt(size);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class WrapperViewTypeLookup implements ViewTypeLookup {
            final NestedAdapterWrapper mWrapper;

            WrapperViewTypeLookup(NestedAdapterWrapper nestedAdapterWrapper) {
                this.mWrapper = nestedAdapterWrapper;
            }

            @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage.ViewTypeLookup
            public void dispose() {
                SharedIdRangeViewTypeStorage.this.removeWrapper(this.mWrapper);
            }

            @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage.ViewTypeLookup
            public int localToGlobal(int i3) {
                List<NestedAdapterWrapper> list = SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.get(i3);
                if (list == null) {
                    list = new ArrayList<>();
                    SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.put(i3, list);
                }
                if (!list.contains(this.mWrapper)) {
                    list.add(this.mWrapper);
                }
                return i3;
            }

            @Override // com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage.ViewTypeLookup
            public int globalToLocal(int i3) {
                return i3;
            }
        }
    }
}
