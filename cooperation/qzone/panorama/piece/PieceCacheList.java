package cooperation.qzone.panorama.piece;

import android.util.SparseArray;
import cooperation.qzone.util.QZLog;

/* loaded from: classes28.dex */
public class PieceCacheList extends SparseArray<PieceData> {
    private static final String TAG = "PieceCacheList";
    private long currentSize;
    private long maxSize;
    private long pieceSize;

    public PieceCacheList(long j3) {
        this.maxSize = j3;
    }

    private void trimToSize(int i3, boolean z16) {
        int size;
        if (this.currentSize + this.pieceSize > this.maxSize) {
            int i16 = 0;
            try {
                if (z16) {
                    if (i3 < size()) {
                        size = i3;
                    } else {
                        size = 0;
                    }
                } else if (i3 < size()) {
                    size = size() - 1;
                } else {
                    size = size() - (36 - i3);
                }
                removeAt(size);
            } catch (IndexOutOfBoundsException e16) {
                e16.printStackTrace();
                if (!isNeedCheckSize() && size() > 0) {
                    if (!z16) {
                        i16 = size() - 1;
                    }
                    removeAt(i16);
                }
                QZLog.e(TAG, "trimToSize: IndexOutOfBoundsException temp " + (size() - (36 - i3)));
            }
        }
    }

    @Override // android.util.SparseArray
    public void clear() {
        super.clear();
        this.currentSize = 0L;
    }

    public boolean isNeedCheckSize() {
        long j3 = this.pieceSize;
        if (j3 == 0 || this.maxSize > j3 * 8) {
            return false;
        }
        return true;
    }

    @Override // android.util.SparseArray
    public void remove(int i3) {
        PieceData pieceData = get(i3);
        if (pieceData != null) {
            pieceData.recycleOrgTexture();
        }
        super.remove(i3);
        this.currentSize -= this.pieceSize;
    }

    @Override // android.util.SparseArray
    public void removeAt(int i3) {
        PieceData valueAt = valueAt(i3);
        if (valueAt != null) {
            valueAt.recycleOrgTexture();
        }
        super.removeAt(i3);
        this.currentSize -= this.pieceSize;
    }

    public synchronized void put(int i3, PieceData pieceData, boolean z16) {
        if (pieceData != null) {
            if (this.pieceSize == 0) {
                long sizeOf = pieceData.sizeOf();
                this.pieceSize = sizeOf;
                if (this.maxSize < sizeOf * 8) {
                    this.maxSize = sizeOf * 8;
                }
            }
        }
        trimToSize(i3, z16);
        put(i3, pieceData);
    }

    @Override // android.util.SparseArray
    public void put(int i3, PieceData pieceData) {
        if (pieceData != null) {
            super.put(i3, (int) pieceData);
            this.currentSize += pieceData.sizeOf();
        }
    }
}
