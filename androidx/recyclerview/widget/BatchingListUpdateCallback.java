package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    final ListUpdateCallback mWrapped;
    int mLastEventType = 0;
    int mLastEventPosition = -1;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i3 = this.mLastEventType;
        if (i3 == 0) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
                }
            } else {
                this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            }
        } else {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i3, int i16, Object obj) {
        int i17;
        if (this.mLastEventType == 3) {
            int i18 = this.mLastEventPosition;
            int i19 = this.mLastEventCount;
            if (i3 <= i18 + i19 && (i17 = i3 + i16) >= i18 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i3, i18);
                this.mLastEventCount = Math.max(i19 + i18, i17) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i3;
        this.mLastEventCount = i16;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i3, int i16) {
        int i17;
        if (this.mLastEventType == 1 && i3 >= (i17 = this.mLastEventPosition)) {
            int i18 = this.mLastEventCount;
            if (i3 <= i17 + i18) {
                this.mLastEventCount = i18 + i16;
                this.mLastEventPosition = Math.min(i3, i17);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i3;
        this.mLastEventCount = i16;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i3, int i16) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i3, i16);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i3, int i16) {
        int i17;
        if (this.mLastEventType == 2 && (i17 = this.mLastEventPosition) >= i3 && i17 <= i3 + i16) {
            this.mLastEventCount += i16;
            this.mLastEventPosition = i3;
        } else {
            dispatchLastEvent();
            this.mLastEventPosition = i3;
            this.mLastEventCount = i16;
            this.mLastEventType = 2;
        }
    }
}
