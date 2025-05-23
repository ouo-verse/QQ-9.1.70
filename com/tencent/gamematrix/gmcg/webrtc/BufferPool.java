package com.tencent.gamematrix.gmcg.webrtc;

import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.util.LinkedList;
import java.util.Queue;
import org.tencwebrtc.JavaI420Buffer;

/* loaded from: classes6.dex */
public class BufferPool {
    private final int frameHeight;
    private final int frameWidth;
    private final Queue<JavaI420Buffer> pool = new LinkedList();

    public BufferPool(int i3, int i16, int i17) {
        this.frameWidth = i16;
        this.frameHeight = i17;
        for (int i18 = 0; i18 < i3; i18++) {
            this.pool.offer(JavaI420Buffer.allocate(i16, i17));
            CGLog.i("Loopback, allocate a buffer with width=" + i16 + ", height=" + i17);
        }
    }

    public synchronized JavaI420Buffer getBuffer(boolean z16) {
        JavaI420Buffer poll;
        poll = this.pool.poll();
        if (z16 && poll == null) {
            poll = JavaI420Buffer.allocate(this.frameWidth, this.frameHeight);
            CGLog.i("Loopback, pool is null, allocate a buffer with width=" + this.frameWidth + ", height=" + this.frameHeight);
        }
        return poll;
    }

    public synchronized void returnBuffer(JavaI420Buffer javaI420Buffer) {
        this.pool.offer(javaI420Buffer);
    }
}
