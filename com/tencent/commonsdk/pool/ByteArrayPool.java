package com.tencent.commonsdk.pool;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes5.dex */
public class ByteArrayPool {
    static IPatchRedirector $redirector_;
    protected static final Comparator<byte[]> BUF_COMPARATOR;
    private static ByteArrayPool genericInstance;
    private static ByteArrayPool maxBufPoolInstance;
    private List<byte[]> mBuffersByLastUse;
    private List<byte[]> mBuffersBySize;
    private int mCurrentSize;
    private final int mSizeLimit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47002);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            genericInstance = new ByteArrayPool(RFixConstants.MD5_FILE_BUF_LENGTH);
            BUF_COMPARATOR = new Comparator<byte[]>() { // from class: com.tencent.commonsdk.pool.ByteArrayPool.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.util.Comparator
                public int compare(byte[] bArr, byte[] bArr2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? bArr.length - bArr2.length : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) bArr2)).intValue();
                }
            };
        }
    }

    public ByteArrayPool(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.mBuffersByLastUse = new LinkedList();
        this.mBuffersBySize = new ArrayList(64);
        this.mCurrentSize = 0;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            return;
        }
        if (bArr != null && bArr.length <= this.mSizeLimit) {
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
