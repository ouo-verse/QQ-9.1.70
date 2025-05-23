package com.tencent.biz.richframework.part.adapter.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

/* compiled from: P */
/* loaded from: classes5.dex */
interface StableIdStorage {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId = 0;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();

            WrapperStableIdLookup() {
            }

            @Override // com.tencent.biz.richframework.part.adapter.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j3) {
                Long l3 = this.mLocalToGlobalLookup.get(j3);
                if (l3 == null) {
                    l3 = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j3, l3);
                }
                return l3.longValue();
            }
        }

        @Override // com.tencent.biz.richframework.part.adapter.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup();
        }

        long obtainId() {
            long j3 = this.mNextStableId;
            this.mNextStableId = 1 + j3;
            return j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new StableIdLookup() { // from class: com.tencent.biz.richframework.part.adapter.widget.StableIdStorage.NoStableIdStorage.1
            @Override // com.tencent.biz.richframework.part.adapter.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j3) {
                return -1L;
            }
        };

        @Override // com.tencent.biz.richframework.part.adapter.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new StableIdLookup() { // from class: com.tencent.biz.richframework.part.adapter.widget.StableIdStorage.SharedPoolStableIdStorage.1
            @Override // com.tencent.biz.richframework.part.adapter.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j3) {
                return j3;
            }
        };

        @Override // com.tencent.biz.richframework.part.adapter.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface StableIdLookup {
        long localToGlobal(long j3);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}
