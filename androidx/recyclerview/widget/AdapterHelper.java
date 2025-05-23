package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i3);

        void markViewHoldersUpdated(int i3, int i16, Object obj);

        void offsetPositionsForAdd(int i3, int i16);

        void offsetPositionsForMove(int i3, int i16);

        void offsetPositionsForRemovingInvisible(int i3, int i16);

        void offsetPositionsForRemovingLaidOutOrNewView(int i3, int i16);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        UpdateOp(int i3, int i16, int i17, Object obj) {
            this.cmd = i3;
            this.positionStart = i16;
            this.itemCount = i17;
            this.payload = obj;
        }

        String cmdToString() {
            int i3 = this.cmd;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 8) {
                            return "??";
                        }
                        return QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID_FOR_SHARE;
                    }
                    return "up";
                }
                return MsfCmdConfig.CMD_DELETE_FILE;
            }
            return "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i3 = this.cmd;
            if (i3 != updateOp.cmd) {
                return false;
            }
            if (i3 == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.payload)) {
                    return false;
                }
            } else if (updateOp.payload != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        boolean z16;
        char c16;
        int i3 = updateOp.positionStart;
        int i16 = updateOp.itemCount + i3;
        char c17 = '\uffff';
        int i17 = i3;
        int i18 = 0;
        while (i17 < i16) {
            if (this.mCallback.findViewHolder(i17) == null && !canFindInPreLayout(i17)) {
                if (c17 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i3, i18, null));
                    z16 = true;
                } else {
                    z16 = false;
                }
                c16 = 0;
            } else {
                if (c17 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i3, i18, null));
                    z16 = true;
                } else {
                    z16 = false;
                }
                c16 = 1;
            }
            if (z16) {
                i17 -= i18;
                i16 -= i18;
                i18 = 1;
            } else {
                i18++;
            }
            i17++;
            c17 = c16;
        }
        if (i18 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i3, i18, null);
        }
        if (c17 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i3 = updateOp.positionStart;
        int i16 = updateOp.itemCount + i3;
        int i17 = 0;
        boolean z16 = -1;
        int i18 = i3;
        while (i3 < i16) {
            if (this.mCallback.findViewHolder(i3) == null && !canFindInPreLayout(i3)) {
                if (z16) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i18, i17, updateOp.payload));
                    i18 = i3;
                    i17 = 0;
                }
                z16 = false;
            } else {
                if (!z16) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i18, i17, updateOp.payload));
                    i18 = i3;
                    i17 = 0;
                }
                z16 = true;
            }
            i17++;
            i3++;
        }
        if (i17 != updateOp.itemCount) {
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i18, i17, obj);
        }
        if (!z16) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private boolean canFindInPreLayout(int i3) {
        int size = this.mPostponedList.size();
        for (int i16 = 0; i16 < size; i16++) {
            UpdateOp updateOp = this.mPostponedList.get(i16);
            int i17 = updateOp.cmd;
            if (i17 == 8) {
                if (findPositionOffset(updateOp.itemCount, i16 + 1) == i3) {
                    return true;
                }
            } else if (i17 == 1) {
                int i18 = updateOp.positionStart;
                int i19 = updateOp.itemCount + i18;
                while (i18 < i19) {
                    if (findPositionOffset(i18, i16 + 1) == i3) {
                        return true;
                    }
                    i18++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i3;
        boolean z16;
        int i16 = updateOp.cmd;
        if (i16 != 1 && i16 != 8) {
            int updatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i16);
            int i17 = updateOp.positionStart;
            int i18 = updateOp.cmd;
            if (i18 != 2) {
                if (i18 == 4) {
                    i3 = 1;
                } else {
                    throw new IllegalArgumentException("op should be remove or update." + updateOp);
                }
            } else {
                i3 = 0;
            }
            int i19 = 1;
            for (int i26 = 1; i26 < updateOp.itemCount; i26++) {
                int updatePositionWithPostponed2 = updatePositionWithPostponed(updateOp.positionStart + (i3 * i26), updateOp.cmd);
                int i27 = updateOp.cmd;
                if (i27 == 2 ? updatePositionWithPostponed2 != updatePositionWithPostponed : i27 != 4 || updatePositionWithPostponed2 != updatePositionWithPostponed + 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    i19++;
                } else {
                    UpdateOp obtainUpdateOp = obtainUpdateOp(i27, updatePositionWithPostponed, i19, updateOp.payload);
                    dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp, i17);
                    recycleUpdateOp(obtainUpdateOp);
                    if (updateOp.cmd == 4) {
                        i17 += i19;
                    }
                    i19 = 1;
                    updatePositionWithPostponed = updatePositionWithPostponed2;
                }
            }
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            if (i19 > 0) {
                UpdateOp obtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, updatePositionWithPostponed, i19, obj);
                dispatchFirstPassAndUpdateViewHolders(obtainUpdateOp2, i17);
                recycleUpdateOp(obtainUpdateOp2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i3 = updateOp.cmd;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 8) {
                        this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                        return;
                    }
                    throw new IllegalArgumentException("Unknown update op type for " + updateOp);
                }
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                return;
            }
            this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
            return;
        }
        this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
    }

    private int updatePositionWithPostponed(int i3, int i16) {
        int i17;
        int i18;
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.mPostponedList.get(size);
            int i19 = updateOp.cmd;
            if (i19 == 8) {
                int i26 = updateOp.positionStart;
                int i27 = updateOp.itemCount;
                if (i26 < i27) {
                    i18 = i26;
                    i17 = i27;
                } else {
                    i17 = i26;
                    i18 = i27;
                }
                if (i3 >= i18 && i3 <= i17) {
                    if (i18 == i26) {
                        if (i16 == 1) {
                            updateOp.itemCount = i27 + 1;
                        } else if (i16 == 2) {
                            updateOp.itemCount = i27 - 1;
                        }
                        i3++;
                    } else {
                        if (i16 == 1) {
                            updateOp.positionStart = i26 + 1;
                        } else if (i16 == 2) {
                            updateOp.positionStart = i26 - 1;
                        }
                        i3--;
                    }
                } else if (i3 < i26) {
                    if (i16 == 1) {
                        updateOp.positionStart = i26 + 1;
                        updateOp.itemCount = i27 + 1;
                    } else if (i16 == 2) {
                        updateOp.positionStart = i26 - 1;
                        updateOp.itemCount = i27 - 1;
                    }
                }
            } else {
                int i28 = updateOp.positionStart;
                if (i28 <= i3) {
                    if (i19 == 1) {
                        i3 -= updateOp.itemCount;
                    } else if (i19 == 2) {
                        i3 += updateOp.itemCount;
                    }
                } else if (i16 == 1) {
                    updateOp.positionStart = i28 + 1;
                } else if (i16 == 2) {
                    updateOp.positionStart = i28 - 1;
                }
            }
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            if (updateOp2.cmd == 8) {
                int i29 = updateOp2.itemCount;
                if (i29 == updateOp2.positionStart || i29 < 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i3;
    }

    AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        Collections.addAll(this.mPendingUpdates, updateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i3) {
        int size = this.mPendingUpdates.size();
        for (int i16 = 0; i16 < size; i16++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i16);
            int i17 = updateOp.cmd;
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 8) {
                        int i18 = updateOp.positionStart;
                        if (i18 == i3) {
                            i3 = updateOp.itemCount;
                        } else {
                            if (i18 < i3) {
                                i3--;
                            }
                            if (updateOp.itemCount <= i3) {
                                i3++;
                            }
                        }
                    }
                } else {
                    int i19 = updateOp.positionStart;
                    if (i19 <= i3) {
                        int i26 = updateOp.itemCount;
                        if (i19 + i26 > i3) {
                            return -1;
                        }
                        i3 -= i26;
                    } else {
                        continue;
                    }
                }
            } else if (updateOp.positionStart <= i3) {
                i3 += updateOp.itemCount;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i3));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i3);
            int i16 = updateOp.cmd;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 4) {
                        if (i16 == 8) {
                            this.mCallback.onDispatchSecondPass(updateOp);
                            this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
                        }
                    } else {
                        this.mCallback.onDispatchSecondPass(updateOp);
                        this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                    }
                } else {
                    this.mCallback.onDispatchSecondPass(updateOp);
                    this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
                }
            } else {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i3) {
        this.mCallback.onDispatchFirstPass(updateOp);
        int i16 = updateOp.cmd;
        if (i16 != 2) {
            if (i16 == 4) {
                this.mCallback.markViewHoldersUpdated(i3, updateOp.itemCount, updateOp.payload);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        this.mCallback.offsetPositionsForRemovingInvisible(i3, updateOp.itemCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findPositionOffset(int i3) {
        return findPositionOffset(i3, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasAnyUpdateTypes(int i3) {
        if ((i3 & this.mExistingUpdateTypes) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasPendingUpdates() {
        if (this.mPendingUpdates.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasUpdates() {
        if (!this.mPostponedList.isEmpty() && !this.mPendingUpdates.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i3, int i16, int i17, Object obj) {
        UpdateOp acquire = this.mUpdateOpPool.acquire();
        if (acquire == null) {
            return new UpdateOp(i3, i16, i17, obj);
        }
        acquire.cmd = i3;
        acquire.positionStart = i16;
        acquire.itemCount = i17;
        acquire.payload = obj;
        return acquire;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemRangeChanged(int i3, int i16, Object obj) {
        if (i16 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(4, i3, i16, obj));
        this.mExistingUpdateTypes |= 4;
        if (this.mPendingUpdates.size() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemRangeInserted(int i3, int i16) {
        if (i16 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(1, i3, i16, null));
        this.mExistingUpdateTypes |= 1;
        if (this.mPendingUpdates.size() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemRangeMoved(int i3, int i16, int i17) {
        if (i3 == i16) {
            return false;
        }
        if (i17 == 1) {
            this.mPendingUpdates.add(obtainUpdateOp(8, i3, i16, null));
            this.mExistingUpdateTypes |= 8;
            if (this.mPendingUpdates.size() != 1) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onItemRangeRemoved(int i3, int i16) {
        if (i16 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(2, i3, i16, null));
        this.mExistingUpdateTypes |= 2;
        if (this.mPendingUpdates.size() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i3);
            int i16 = updateOp.cmd;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 4) {
                        if (i16 == 8) {
                            applyMove(updateOp);
                        }
                    } else {
                        applyUpdate(updateOp);
                    }
                } else {
                    applyRemove(updateOp);
                }
            } else {
                applyAdd(updateOp);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.mPendingUpdates.clear();
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (!this.mDisableRecycler) {
            updateOp.payload = null;
            this.mUpdateOpPool.release(updateOp);
        }
    }

    void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            recycleUpdateOp(list.get(i3));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    AdapterHelper(Callback callback, boolean z16) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = callback;
        this.mDisableRecycler = z16;
        this.mOpReorderer = new OpReorderer(this);
    }

    int findPositionOffset(int i3, int i16) {
        int size = this.mPostponedList.size();
        while (i16 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i16);
            int i17 = updateOp.cmd;
            if (i17 == 8) {
                int i18 = updateOp.positionStart;
                if (i18 == i3) {
                    i3 = updateOp.itemCount;
                } else {
                    if (i18 < i3) {
                        i3--;
                    }
                    if (updateOp.itemCount <= i3) {
                        i3++;
                    }
                }
            } else {
                int i19 = updateOp.positionStart;
                if (i19 > i3) {
                    continue;
                } else if (i17 == 2) {
                    int i26 = updateOp.itemCount;
                    if (i3 < i19 + i26) {
                        return -1;
                    }
                    i3 -= i26;
                } else if (i17 == 1) {
                    i3 += updateOp.itemCount;
                }
            }
            i16++;
        }
        return i3;
    }
}
