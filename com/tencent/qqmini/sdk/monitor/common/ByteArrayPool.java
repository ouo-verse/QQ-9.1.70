package com.tencent.qqmini.sdk.monitor.common;

import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes23.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new Comparator<byte[]>() { // from class: com.tencent.qqmini.sdk.monitor.common.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };
    private static ByteArrayPool genericInstance = new ByteArrayPool(RFixConstants.MD5_FILE_BUF_LENGTH);
    private static ByteArrayPool maxBufPoolInstance;
    private List<byte[]> mBuffersByLastUse = new LinkedList();
    private List<byte[]> mBuffersBySize = new ArrayList(64);
    private int mCurrentSize = 0;
    private final int mSizeLimit;

    public ByteArrayPool(int i3) {
        this.mSizeLimit = i3;
    }

    public static ByteArrayPool getGenericInstance() {
        return genericInstance;
    }

    public static ByteArrayPool getMaxBufInstance() {
        if (maxBufPoolInstance == null) {
            synchronized (ByteArrayPool.class) {
                if (maxBufPoolInstance == null) {
                    maxBufPoolInstance = new ByteArrayPool(1024000);
                }
            }
        }
        return maxBufPoolInstance;
    }

    private synchronized void trim() {
        while (this.mCurrentSize > this.mSizeLimit) {
            byte[] remove = this.mBuffersByLastUse.remove(0);
            this.mBuffersBySize.remove(remove);
            this.mCurrentSize -= remove.length;
        }
    }

    public synchronized byte[] getBuf(int i3) {
        for (int i16 = 0; i16 < this.mBuffersBySize.size(); i16++) {
            byte[] bArr = this.mBuffersBySize.get(i16);
            if (bArr.length >= i3) {
                this.mCurrentSize -= bArr.length;
                this.mBuffersBySize.remove(i16);
                this.mBuffersByLastUse.remove(bArr);
                return bArr;
            }
        }
        return new byte[i3];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.mSizeLimit) {
                this.mBuffersByLastUse.add(bArr);
                int binarySearch = Collections.binarySearch(this.mBuffersBySize, bArr, BUF_COMPARATOR);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.mBuffersBySize.add(binarySearch, bArr);
                this.mCurrentSize += bArr.length;
                trim();
            }
        }
    }
}
