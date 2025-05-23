package mqq.os;

import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MqqMessage {
    static boolean DEBUG_MESSAGE = true;
    private static final int MAX_POOL_SIZE = 10;
    private static MqqMessage sPool;
    private static int sPoolSize;
    private int index;
    MqqMessage next;
    IMqqMessageCallback target;
    long when;
    Message wrappedMsg;
    private static final Object sPoolSync = new Object();
    private static AtomicInteger sIndex = new AtomicInteger(0);

    MqqMessage() {
        if (DEBUG_MESSAGE) {
            this.index = sIndex.incrementAndGet();
        }
    }

    public static MqqMessage obtain() {
        synchronized (sPoolSync) {
            MqqMessage mqqMessage = sPool;
            if (mqqMessage != null) {
                sPool = mqqMessage.next;
                mqqMessage.next = null;
                if (DEBUG_MESSAGE) {
                    mqqMessage.index = sIndex.incrementAndGet();
                }
                sPoolSize--;
                return mqqMessage;
            }
            return new MqqMessage();
        }
    }

    public void recycle() {
        Message message = this.wrappedMsg;
        if (message != null) {
            message.recycle();
        }
        this.when = 0L;
        this.wrappedMsg = null;
        this.target = null;
        synchronized (sPoolSync) {
            int i3 = sPoolSize;
            if (i3 < 10) {
                this.next = sPool;
                sPool = this;
                sPoolSize = i3 + 1;
            }
        }
    }

    public String toString() {
        return "MqqMessage@" + this.index;
    }

    public static MqqMessage obtain(Message message) {
        MqqMessage obtain = obtain();
        obtain.wrappedMsg = message;
        return obtain;
    }
}
