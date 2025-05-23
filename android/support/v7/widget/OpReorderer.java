package android.support.v7.widget;

import android.support.v7.widget.AdapterHelper;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class OpReorderer {
    final Callback mCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i3, int i16, int i17, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z16 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd == 8) {
                if (z16) {
                    return size;
                }
            } else {
                z16 = true;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i3, AdapterHelper.UpdateOp updateOp, int i16, AdapterHelper.UpdateOp updateOp2) {
        int i17;
        int i18 = updateOp.itemCount;
        int i19 = updateOp2.positionStart;
        if (i18 < i19) {
            i17 = -1;
        } else {
            i17 = 0;
        }
        int i26 = updateOp.positionStart;
        if (i26 < i19) {
            i17++;
        }
        if (i19 <= i26) {
            updateOp.positionStart = i26 + updateOp2.itemCount;
        }
        int i27 = updateOp2.positionStart;
        if (i27 <= i18) {
            updateOp.itemCount = i18 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i27 + i17;
        list.set(i3, updateOp2);
        list.set(i16, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i3, int i16) {
        AdapterHelper.UpdateOp updateOp = list.get(i3);
        AdapterHelper.UpdateOp updateOp2 = list.get(i16);
        int i17 = updateOp2.cmd;
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 == 4) {
                    swapMoveUpdate(list, i3, updateOp, i16, updateOp2);
                    return;
                }
                return;
            }
            swapMoveRemove(list, i3, updateOp, i16, updateOp2);
            return;
        }
        swapMoveAdd(list, i3, updateOp, i16, updateOp2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i3, AdapterHelper.UpdateOp updateOp, int i16, AdapterHelper.UpdateOp updateOp2) {
        boolean z16;
        int i17 = updateOp.positionStart;
        int i18 = updateOp.itemCount;
        boolean z17 = false;
        if (i17 < i18) {
            if (updateOp2.positionStart == i17 && updateOp2.itemCount == i18 - i17) {
                z16 = false;
                z17 = true;
            } else {
                z16 = false;
            }
        } else if (updateOp2.positionStart == i18 + 1 && updateOp2.itemCount == i17 - i18) {
            z16 = true;
            z17 = true;
        } else {
            z16 = true;
        }
        int i19 = updateOp2.positionStart;
        if (i18 < i19) {
            updateOp2.positionStart = i19 - 1;
        } else {
            int i26 = updateOp2.itemCount;
            if (i18 < i19 + i26) {
                updateOp2.itemCount = i26 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i16);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i27 = updateOp.positionStart;
        int i28 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i27 <= i28) {
            updateOp2.positionStart = i28 + 1;
        } else {
            int i29 = updateOp2.itemCount;
            if (i27 < i28 + i29) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i27 + 1, (i28 + i29) - i27, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z17) {
            list.set(i3, updateOp2);
            list.remove(i16);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z16) {
            if (updateOp3 != null) {
                int i36 = updateOp.positionStart;
                if (i36 > updateOp3.positionStart) {
                    updateOp.positionStart = i36 - updateOp3.itemCount;
                }
                int i37 = updateOp.itemCount;
                if (i37 > updateOp3.positionStart) {
                    updateOp.itemCount = i37 - updateOp3.itemCount;
                }
            }
            int i38 = updateOp.positionStart;
            if (i38 > updateOp2.positionStart) {
                updateOp.positionStart = i38 - updateOp2.itemCount;
            }
            int i39 = updateOp.itemCount;
            if (i39 > updateOp2.positionStart) {
                updateOp.itemCount = i39 - updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                int i46 = updateOp.positionStart;
                if (i46 >= updateOp3.positionStart) {
                    updateOp.positionStart = i46 - updateOp3.itemCount;
                }
                int i47 = updateOp.itemCount;
                if (i47 >= updateOp3.positionStart) {
                    updateOp.itemCount = i47 - updateOp3.itemCount;
                }
            }
            int i48 = updateOp.positionStart;
            if (i48 >= updateOp2.positionStart) {
                updateOp.positionStart = i48 - updateOp2.itemCount;
            }
            int i49 = updateOp.itemCount;
            if (i49 >= updateOp2.positionStart) {
                updateOp.itemCount = i49 - updateOp2.itemCount;
            }
        }
        list.set(i3, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i16, updateOp);
        } else {
            list.remove(i16);
        }
        if (updateOp3 != null) {
            list.add(i3, updateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int i3, AdapterHelper.UpdateOp updateOp, int i16, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp obtainUpdateOp;
        int i17;
        int i18;
        int i19 = updateOp.itemCount;
        int i26 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i19 < i26) {
            updateOp2.positionStart = i26 - 1;
        } else {
            int i27 = updateOp2.itemCount;
            if (i19 < i26 + i27) {
                updateOp2.itemCount = i27 - 1;
                obtainUpdateOp = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
                i17 = updateOp.positionStart;
                i18 = updateOp2.positionStart;
                if (i17 > i18) {
                    updateOp2.positionStart = i18 + 1;
                } else {
                    int i28 = updateOp2.itemCount;
                    if (i17 < i18 + i28) {
                        int i29 = (i18 + i28) - i17;
                        updateOp3 = this.mCallback.obtainUpdateOp(4, i17 + 1, i29, updateOp2.payload);
                        updateOp2.itemCount -= i29;
                    }
                }
                list.set(i16, updateOp);
                if (updateOp2.itemCount <= 0) {
                    list.set(i3, updateOp2);
                } else {
                    list.remove(i3);
                    this.mCallback.recycleUpdateOp(updateOp2);
                }
                if (obtainUpdateOp != null) {
                    list.add(i3, obtainUpdateOp);
                }
                if (updateOp3 == null) {
                    list.add(i3, updateOp3);
                    return;
                }
                return;
            }
        }
        obtainUpdateOp = null;
        i17 = updateOp.positionStart;
        i18 = updateOp2.positionStart;
        if (i17 > i18) {
        }
        list.set(i16, updateOp);
        if (updateOp2.itemCount <= 0) {
        }
        if (obtainUpdateOp != null) {
        }
        if (updateOp3 == null) {
        }
    }
}
