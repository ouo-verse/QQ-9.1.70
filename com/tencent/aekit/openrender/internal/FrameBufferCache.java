package com.tencent.aekit.openrender.internal;

import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameBufferCache {
    static IPatchRedirector $redirector_;
    public static boolean DEBUG;
    private static final ThreadLocal<FrameBufferCache> INSTANCE;
    private static final String TAG;
    private Map<FrameSize, Queue<Frame>> allMap;
    private Map<FrameSize, Integer> countMap;
    private Map<FrameSize, Queue<Frame>> map;
    private Map<FrameSize, Queue<Frame>> usedMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class FrameSize {
        static IPatchRedirector $redirector_;
        public int height;
        public int width;

        public FrameSize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FrameBufferCache.this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.width = i3;
                this.height = i16;
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FrameSize frameSize = (FrameSize) obj;
            if (this.width == frameSize.width && this.height == frameSize.height) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return (this.width * 42) + this.height;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return String.format("[FrameSize] width = %d, height = %d", Integer.valueOf(this.width), Integer.valueOf(this.height));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        TAG = FrameBufferCache.class.getSimpleName();
        DEBUG = false;
        INSTANCE = new ThreadLocal<FrameBufferCache>() { // from class: com.tencent.aekit.openrender.internal.FrameBufferCache.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public FrameBufferCache initialValue() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new FrameBufferCache() : (FrameBufferCache) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        };
    }

    public FrameBufferCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.map = new HashMap();
        this.allMap = new HashMap();
        this.usedMap = new HashMap();
        this.countMap = new HashMap();
    }

    public static FrameBufferCache getInstance() {
        return INSTANCE.get();
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        for (Queue<Frame> queue : this.allMap.values()) {
            while (!queue.isEmpty()) {
                queue.poll().clear();
            }
        }
        this.allMap.clear();
        this.map.clear();
        this.usedMap.clear();
        this.countMap.clear();
    }

    public void destroyReserveFrame(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) frame);
            return;
        }
        if (frame == null) {
            return;
        }
        for (Queue<Frame> queue : this.allMap.values()) {
            while (!queue.isEmpty()) {
                Frame poll = queue.poll();
                if (poll != frame) {
                    poll.clear();
                }
            }
        }
        this.allMap.clear();
        this.map.clear();
        this.usedMap.clear();
        this.countMap.clear();
        LinkedList linkedList = new LinkedList();
        linkedList.offer(frame);
        this.allMap.put(new FrameSize(frame.width, frame.height), linkedList);
    }

    public void forceRecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<Queue<Frame>> it = this.allMap.values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Iterator<Frame> it5 = it.next().iterator();
            while (it5.hasNext()) {
                if (it5.next().unlock()) {
                    i3++;
                }
            }
        }
        if (DEBUG && i3 > 0) {
            Log.e(TAG, i3 + " frames are leaked!");
        }
    }

    public Frame get(int i3, int i16) {
        Frame poll;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Frame) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        FrameSize frameSize = new FrameSize(i3, i16);
        Queue<Frame> queue = this.map.get(frameSize);
        if (queue == null) {
            queue = new LinkedList<>();
            this.map.put(frameSize, queue);
        }
        Queue<Frame> queue2 = this.allMap.get(frameSize);
        if (queue2 == null) {
            queue2 = new LinkedList<>();
            this.allMap.put(frameSize, queue2);
        }
        if (queue.isEmpty()) {
            poll = new Frame(Frame.Type.FRAME_CACHE);
            poll.bindFrame(-1, i3, i16, 0.0d);
            queue2.offer(poll);
        } else {
            poll = queue.poll();
            if (DEBUG) {
                Queue<Frame> queue3 = this.usedMap.get(frameSize);
                if (queue3 == null) {
                    queue3 = new LinkedList<>();
                    this.usedMap.put(frameSize, queue3);
                }
                if (!queue3.contains(poll)) {
                    queue3.offer(poll);
                }
            }
        }
        if (!this.countMap.containsKey(frameSize)) {
            this.countMap.put(frameSize, Integer.MAX_VALUE);
        }
        Map<FrameSize, Integer> map = this.countMap;
        map.put(frameSize, Integer.valueOf(Math.min(map.get(frameSize).intValue(), queue.size())));
        return poll;
    }

    public boolean put(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) frame)).booleanValue();
        }
        if (frame == null) {
            return false;
        }
        FrameSize frameSize = new FrameSize(frame.width, frame.height);
        Queue<Frame> queue = this.map.get(frameSize);
        if (queue == null) {
            queue = new LinkedList<>();
            this.map.put(frameSize, queue);
        }
        if (queue.contains(frame)) {
            return false;
        }
        return queue.offer(frame);
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.usedMap.clear();
        }
    }

    public void shrink() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        for (Map.Entry<FrameSize, Queue<Frame>> entry : this.map.entrySet()) {
            Queue<Frame> value = entry.getValue();
            Queue<Frame> queue = this.allMap.get(entry.getKey());
            if (this.countMap.containsKey(entry.getKey())) {
                size = this.countMap.get(entry.getKey()).intValue();
            } else {
                size = value.size();
            }
            while (true) {
                int i3 = size - 1;
                if (size > 0 && !value.isEmpty()) {
                    Frame poll = value.poll();
                    if (queue != null) {
                        queue.remove(poll);
                    }
                    poll.clear();
                    size = i3;
                }
            }
        }
        this.countMap.clear();
    }
}
