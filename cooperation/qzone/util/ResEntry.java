package cooperation.qzone.util;

import cooperation.qzone.util.ResDownloadManger;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ResEntry {
    private static final int MAX_POOL_SIZE = 100;
    private static ResEntry sPool;
    private static int sPoolSize;
    private static final Object sPoolSync = new Object();
    public String fileName;
    public String mPath;
    public WeakReference<ResDownloadManger.ResLoadListener> mResLoadListener;
    public String mUrl;
    public String mUrlKey;
    private ResEntry next;
    public int type;

    public ResEntry(int i3, String str) {
        this.mUrlKey = i3 + " " + str;
    }

    private void clearForRecycle() {
        this.mUrl = null;
        this.mUrlKey = null;
        this.mPath = null;
        this.fileName = null;
        this.mResLoadListener = null;
    }

    public static ResEntry obtain(int i3, String str) {
        synchronized (sPoolSync) {
            ResEntry resEntry = sPool;
            if (resEntry != null) {
                sPool = resEntry.next;
                resEntry.next = null;
                resEntry.mUrlKey = i3 + " " + str;
                resEntry.type = i3;
                sPoolSize = sPoolSize + (-1);
                return resEntry;
            }
            return new ResEntry(i3, str);
        }
    }

    public void recycle() {
        clearForRecycle();
        synchronized (sPoolSync) {
            int i3 = sPoolSize;
            if (i3 < 100) {
                this.next = sPool;
                sPool = this;
                sPoolSize = i3 + 1;
            }
        }
    }
}
