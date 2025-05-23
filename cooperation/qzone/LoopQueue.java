package cooperation.qzone;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneResLoader;
import java.util.Arrays;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LoopQueue<T> {
    private int DEFAULT_SIZE;
    private int capacity;
    private Object[] elementData;
    private int front;
    private int rear;

    public LoopQueue() {
        this.DEFAULT_SIZE = 10;
        this.front = 0;
        this.rear = 0;
        this.capacity = 10;
        this.elementData = new Object[10];
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r1 = r3.elementData;
        r2 = r0 + 1;
        r3.rear = r2;
        r1[r0] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r2 != r3.capacity) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r3.rear = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void add(T t16) {
        int i3 = this.rear;
        int i16 = this.front;
        if (i3 == i16 && this.elementData[i16] != null) {
            throw new IndexOutOfBoundsException(HardCodeUtil.qqStr(((IQzoneResLoader) QRoute.api(IQzoneResLoader.class)).getStringId(2)));
        }
        throw new IllegalArgumentException("element\u4e0d\u80fd\u4e3anull,element=null");
    }

    public synchronized void clear() {
        Arrays.fill(this.elementData, (Object) null);
        this.front = 0;
        this.rear = 0;
    }

    public synchronized boolean isEmpty() {
        boolean z16;
        int i3 = this.rear;
        if (i3 == this.front) {
            if (this.elementData[i3] == null) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    public synchronized boolean isFull() {
        boolean z16;
        if (size() == this.capacity) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized T remove() {
        T t16;
        if (!isEmpty()) {
            Object[] objArr = this.elementData;
            int i3 = this.front;
            t16 = (T) objArr[i3];
            int i16 = i3 + 1;
            this.front = i16;
            objArr[i3] = null;
            if (i16 == this.capacity) {
                i16 = 0;
            }
            this.front = i16;
        } else {
            throw new IndexOutOfBoundsException(HardCodeUtil.qqStr(((IQzoneResLoader) QRoute.api(IQzoneResLoader.class)).getStringId(3)));
        }
        return t16;
    }

    public synchronized int size() {
        int i3;
        if (isEmpty()) {
            return 0;
        }
        int i16 = this.rear;
        int i17 = this.front;
        if (i16 > i17) {
            i3 = i16 - i17;
        } else {
            i3 = this.capacity - (i17 - i16);
        }
        return i3;
    }

    public synchronized String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        if (this.front < this.rear) {
            StringBuilder sb5 = new StringBuilder("[");
            for (int i3 = this.front; i3 < this.rear; i3++) {
                sb5.append(this.elementData[i3].toString() + "->");
            }
            int length = sb5.length();
            StringBuilder delete = sb5.delete(length - 2, length);
            delete.append("]");
            return delete.toString();
        }
        StringBuilder sb6 = new StringBuilder("[");
        for (int i16 = this.front; i16 < this.capacity; i16++) {
            sb6.append(this.elementData[i16].toString() + "->");
        }
        for (int i17 = 0; i17 < this.rear; i17++) {
            sb6.append(this.elementData[i17].toString() + "->");
        }
        int length2 = sb6.length();
        StringBuilder delete2 = sb6.delete(length2 - 2, length2);
        delete2.append("]");
        return delete2.toString();
    }

    public LoopQueue(int i3) {
        this.DEFAULT_SIZE = 10;
        this.front = 0;
        this.rear = 0;
        if (i3 >= 1) {
            this.capacity = i3;
            this.elementData = new Object[i3];
        } else {
            throw new IllegalArgumentException("size\u4e0d\u80fd\u5c0f\u4e8e1,size=" + i3);
        }
    }

    public LoopQueue(T t16) {
        this();
        this.elementData[0] = t16;
        this.rear++;
    }

    public LoopQueue(T t16, int i3) {
        this.DEFAULT_SIZE = 10;
        this.front = 0;
        this.rear = 0;
        if (i3 < 1) {
            throw new IllegalArgumentException("initSize\u4e0d\u80fd\u5c0f\u4e8e1,initSize=" + i3);
        }
        if (t16 != null) {
            this.capacity = i3;
            Object[] objArr = new Object[i3];
            this.elementData = objArr;
            objArr[0] = t16;
            this.rear = 0 + 1;
            return;
        }
        throw new IllegalArgumentException("element\u4e0d\u80fd\u4e3anull,element=null");
    }
}
