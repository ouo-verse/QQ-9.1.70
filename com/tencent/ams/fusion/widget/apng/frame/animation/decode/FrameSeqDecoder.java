package com.tencent.ams.fusion.widget.apng.frame.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.Loader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class FrameSeqDecoder<R extends Reader, W extends Writer> {
    static IPatchRedirector $redirector_ = null;
    public static final boolean DEBUG = false;
    private static final Rect RECT_EMPTY;
    private static final String TAG;
    private Set<Bitmap> cacheBitmaps;
    private final Object cacheBitmapsLock;
    protected Map<Bitmap, Canvas> cachedCanvas;
    private boolean finished;
    protected ByteBuffer frameBuffer;
    protected int frameIndex;
    protected List<Frame> frames;
    protected volatile Rect fullRect;
    private Integer loopLimit;
    private volatile HandlerThread mHandlerThread;
    private final Loader mLoader;
    private R mReader;
    private volatile State mState;
    private volatile Handler mWorkerHandler;
    private W mWriter;
    private AtomicBoolean paused;
    private int playCount;
    private Set<RenderListener> renderListeners;
    private Runnable renderTask;
    protected int sampleSize;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface RenderListener {
        void onEnd();

        void onRender(ByteBuffer byteBuffer);

        void onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class State {
        private static final /* synthetic */ State[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final State FINISHING;
        public static final State IDLE;
        public static final State INITIALIZING;
        public static final State RUNNING;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52086);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            State state = new State("IDLE", 0);
            IDLE = state;
            State state2 = new State(DebugCoroutineInfoImplKt.RUNNING, 1);
            RUNNING = state2;
            State state3 = new State("INITIALIZING", 2);
            INITIALIZING = state3;
            State state4 = new State("FINISHING", 3);
            FINISHING = state4;
            $VALUES = new State[]{state, state2, state3, state4};
        }

        State(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            TAG = FrameSeqDecoder.class.getSimpleName();
            RECT_EMPTY = new Rect();
        }
    }

    public FrameSeqDecoder(Loader loader, RenderListener renderListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) loader, (Object) renderListener);
            return;
        }
        this.frames = new ArrayList();
        this.frameIndex = -1;
        this.loopLimit = null;
        this.renderListeners = new HashSet();
        this.paused = new AtomicBoolean(true);
        this.renderTask = new Runnable() { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameSeqDecoder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (FrameSeqDecoder.this.paused.get()) {
                    return;
                }
                if (FrameSeqDecoder.this.canStep()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long step = FrameSeqDecoder.this.step();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    Handler handler = FrameSeqDecoder.this.mWorkerHandler;
                    if (handler != null) {
                        handler.postDelayed(this, Math.max(0L, step - currentTimeMillis2));
                    }
                    Iterator it = FrameSeqDecoder.this.renderListeners.iterator();
                    while (it.hasNext()) {
                        ((RenderListener) it.next()).onRender(FrameSeqDecoder.this.frameBuffer);
                    }
                    return;
                }
                FrameSeqDecoder.this.stop();
            }
        };
        this.sampleSize = 1;
        this.cacheBitmaps = new HashSet();
        this.cacheBitmapsLock = new Object();
        this.cachedCanvas = new WeakHashMap();
        this.mWriter = getWriter();
        this.mReader = null;
        this.finished = false;
        this.mState = State.IDLE;
        this.mLoader = loader;
        if (renderListener != null) {
            this.renderListeners.add(renderListener);
        }
        initThreadIfNecessary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canStep() {
        if (!isRunning() || this.frames.size() == 0) {
            return false;
        }
        if (getNumPlays() <= 0 || this.playCount < getNumPlays() - 1) {
            return true;
        }
        if (this.playCount == getNumPlays() - 1 && this.frameIndex < getFrameCount() - 1) {
            return true;
        }
        this.finished = true;
        return false;
    }

    private String debugInfo() {
        return "";
    }

    private Frame getFrame(int i3) {
        if (i3 >= 0 && i3 < this.frames.size()) {
            return this.frames.get(i3);
        }
        return null;
    }

    private int getFrameCount() {
        return this.frames.size();
    }

    private int getNumPlays() {
        Integer num = this.loopLimit;
        if (num != null) {
            return num.intValue();
        }
        return getLoopCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCanvasBounds(Rect rect) {
        this.fullRect = rect;
        int width = rect.width() * rect.height();
        int i3 = this.sampleSize;
        this.frameBuffer = ByteBuffer.allocate(((width / (i3 * i3)) + 1) * 4);
        if (this.mWriter == null) {
            this.mWriter = getWriter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStart() {
        Loader loader;
        this.paused.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.frames.size() == 0 && (loader = this.mLoader) != null) {
                try {
                    R r16 = this.mReader;
                    if (r16 == null) {
                        this.mReader = getReader(loader.obtain());
                    } else {
                        r16.reset();
                    }
                    initCanvasBounds(read(this.mReader));
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            String str = TAG;
            Log.i(str, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.mState = State.RUNNING;
            if (getNumPlays() != 0 && this.finished) {
                Log.i(str, debugInfo() + " No need to started");
                return;
            }
            this.frameIndex = -1;
            this.renderTask.run();
            Iterator<RenderListener> it = this.renderListeners.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
        } catch (Throwable th6) {
            Log.i(TAG, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.mState = State.RUNNING;
            throw th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStop() {
        Handler handler = this.mWorkerHandler;
        if (handler != null) {
            handler.removeCallbacks(this.renderTask);
        }
        this.frames.clear();
        synchronized (this.cacheBitmapsLock) {
            for (Bitmap bitmap : this.cacheBitmaps) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.cacheBitmaps.clear();
        }
        if (this.frameBuffer != null) {
            this.frameBuffer = null;
        }
        this.cachedCanvas.clear();
        try {
            R r16 = this.mReader;
            if (r16 != null) {
                r16.close();
                this.mReader = null;
            }
            W w3 = this.mWriter;
            if (w3 != null) {
                w3.close();
                this.mWriter = null;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        release();
        this.mState = State.IDLE;
        Iterator<RenderListener> it = this.renderListeners.iterator();
        while (it.hasNext()) {
            it.next().onEnd();
        }
        quitThread();
    }

    private void quitThread() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread == null) {
            return;
        }
        try {
            handlerThread.quitSafely();
        } catch (Throwable unused) {
        }
        this.mHandlerThread = null;
        if (this.mWorkerHandler != null) {
            this.mWorkerHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long step() {
        int i3 = this.frameIndex + 1;
        this.frameIndex = i3;
        if (i3 >= getFrameCount()) {
            this.frameIndex = 0;
            this.playCount++;
        }
        Frame frame = getFrame(this.frameIndex);
        if (frame == null) {
            return 0L;
        }
        renderFrame(frame);
        return frame.frameDuration;
    }

    public void addRenderListener(RenderListener renderListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) renderListener);
            return;
        }
        Handler handler = this.mWorkerHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable(renderListener) { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ RenderListener val$renderListener;

            {
                this.val$renderListener = renderListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameSeqDecoder.this, (Object) renderListener);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FrameSeqDecoder.this.renderListeners.add(this.val$renderListener);
                }
            }
        });
    }

    public Rect getBounds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Rect) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.fullRect == null) {
            if (this.mState == State.FINISHING) {
                Log.e(TAG, "In finishing,do not interrupt");
            }
            Thread currentThread = Thread.currentThread();
            Handler handler = this.mWorkerHandler;
            if (handler != null) {
                handler.post(new Runnable(currentThread) { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Thread val$thread;

                    {
                        this.val$thread = currentThread;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameSeqDecoder.this, (Object) currentThread);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            try {
                                if (FrameSeqDecoder.this.fullRect == null && FrameSeqDecoder.this.mLoader != null) {
                                    if (FrameSeqDecoder.this.mReader == null) {
                                        FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                                        frameSeqDecoder.mReader = frameSeqDecoder.getReader(frameSeqDecoder.mLoader.obtain());
                                    } else {
                                        FrameSeqDecoder.this.mReader.reset();
                                    }
                                    FrameSeqDecoder frameSeqDecoder2 = FrameSeqDecoder.this;
                                    frameSeqDecoder2.initCanvasBounds(frameSeqDecoder2.read(frameSeqDecoder2.mReader));
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                FrameSeqDecoder.this.fullRect = FrameSeqDecoder.RECT_EMPTY;
                            }
                        } finally {
                            LockSupport.unpark(this.val$thread);
                        }
                    }
                });
                LockSupport.park(currentThread);
            }
        }
        return this.fullRect;
    }

    protected int getDesiredSample(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 != 0 && i16 != 0) {
            if (getBounds() == null) {
                return 1;
            }
            int min = Math.min(getBounds().width() / i3, getBounds().height() / i16);
            while (true) {
                int i18 = i17 * 2;
                if (i18 > min) {
                    break;
                }
                i17 = i18;
            }
        }
        return i17;
    }

    public Bitmap getFrameBitmap(int i3) throws IOException {
        Loader loader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Bitmap) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        if (this.mState != State.IDLE) {
            Log.e(TAG, debugInfo() + ",stop first");
            return null;
        }
        this.mState = State.RUNNING;
        int i16 = 0;
        this.paused.compareAndSet(true, false);
        if (this.frames.size() == 0 && (loader = this.mLoader) != null) {
            R r16 = this.mReader;
            if (r16 == null) {
                this.mReader = getReader(loader.obtain());
            } else {
                r16.reset();
            }
            initCanvasBounds(read(this.mReader));
        }
        if (i3 < 0) {
            i3 += this.frames.size();
        }
        if (i3 >= 0) {
            i16 = i3;
        }
        this.frameIndex = -1;
        while (this.frameIndex < i16 && canStep()) {
            step();
        }
        if (getBounds() == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(getBounds().width() / getSampleSize(), getBounds().height() / getSampleSize(), Bitmap.Config.ARGB_8888);
        this.frameBuffer.rewind();
        createBitmap.copyPixelsFromBuffer(this.frameBuffer);
        innerStop();
        return createBitmap;
    }

    protected abstract int getLoopCount();

    public int getMemorySize() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        synchronized (this.cacheBitmapsLock) {
            i3 = 0;
            for (Bitmap bitmap : this.cacheBitmaps) {
                if (!bitmap.isRecycled()) {
                    i3 += bitmap.getAllocationByteCount();
                }
            }
            ByteBuffer byteBuffer = this.frameBuffer;
            if (byteBuffer != null) {
                i3 += byteBuffer.capacity();
            }
        }
        return i3;
    }

    protected abstract R getReader(Reader reader);

    public int getSampleSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.sampleSize;
    }

    protected abstract W getWriter();

    public void initThreadIfNecessary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        Handler handler = this.mWorkerHandler;
        if (handlerThread == null) {
            try {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AMS-FrameDecoderExecutor");
                try {
                    baseHandlerThread.start();
                    handlerThread = baseHandlerThread;
                } catch (Throwable unused) {
                    handlerThread = baseHandlerThread;
                }
            } catch (Throwable unused2) {
            }
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            this.mWorkerHandler = new Handler(looper);
        }
        this.mHandlerThread = handlerThread;
    }

    public boolean isPaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.paused.get();
    }

    public boolean isRunning() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.mState != State.RUNNING && this.mState != State.INITIALIZING) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap obtainBitmap(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Bitmap) iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        synchronized (this.cacheBitmapsLock) {
            Iterator<Bitmap> it = this.cacheBitmaps.iterator();
            Bitmap bitmap = null;
            while (it.hasNext()) {
                int i17 = i3 * i16 * 4;
                Bitmap next = it.next();
                if (next != null && next.getAllocationByteCount() >= i17) {
                    it.remove();
                    if (next.getWidth() != i3 || next.getHeight() != i16) {
                        next.reconfigure(i3, i16, Bitmap.Config.ARGB_8888);
                    }
                    next.eraseColor(0);
                    return next;
                }
                bitmap = next;
            }
            try {
                bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
            }
            return bitmap;
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Handler handler = this.mWorkerHandler;
        if (handler != null) {
            handler.removeCallbacks(this.renderTask);
        }
        this.paused.compareAndSet(false, true);
    }

    protected abstract Rect read(R r16) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void recycleBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
            return;
        }
        synchronized (this.cacheBitmapsLock) {
            if (bitmap != null) {
                if (!this.cacheBitmaps.contains(bitmap)) {
                    this.cacheBitmaps.add(bitmap);
                }
            }
        }
    }

    protected abstract void release();

    public void removeRenderListener(RenderListener renderListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) renderListener);
            return;
        }
        Handler handler = this.mWorkerHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable(renderListener) { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ RenderListener val$renderListener;

            {
                this.val$renderListener = renderListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameSeqDecoder.this, (Object) renderListener);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FrameSeqDecoder.this.renderListeners.remove(this.val$renderListener);
                }
            }
        });
    }

    protected abstract void renderFrame(Frame frame);

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.playCount = 0;
        this.frameIndex = -1;
        this.finished = false;
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.paused.compareAndSet(true, false);
        Handler handler = this.mWorkerHandler;
        if (handler != null) {
            handler.removeCallbacks(this.renderTask);
            handler.post(this.renderTask);
        }
    }

    public boolean setDesiredSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        int desiredSample = getDesiredSample(i3, i16);
        if (desiredSample == this.sampleSize) {
            return false;
        }
        this.sampleSize = desiredSample;
        boolean isRunning = isRunning();
        Handler handler = this.mWorkerHandler;
        if (handler == null) {
            return true;
        }
        handler.removeCallbacks(this.renderTask);
        handler.post(new Runnable(isRunning) { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.8
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$tempRunning;

            {
                this.val$tempRunning = isRunning;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FrameSeqDecoder.this, Boolean.valueOf(isRunning));
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    FrameSeqDecoder.this.innerStop();
                    try {
                        if (FrameSeqDecoder.this.mLoader != null) {
                            FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                            frameSeqDecoder.initCanvasBounds(frameSeqDecoder.read(frameSeqDecoder.getReader(frameSeqDecoder.mLoader.obtain())));
                            if (this.val$tempRunning) {
                                FrameSeqDecoder.this.innerStart();
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        return true;
    }

    public void setLoopLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.loopLimit = Integer.valueOf(i3);
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.fullRect == RECT_EMPTY) {
            return;
        }
        if (this.mState != State.RUNNING) {
            State state = this.mState;
            State state2 = State.INITIALIZING;
            if (state != state2) {
                if (this.mState == State.FINISHING) {
                    Log.e(TAG, debugInfo() + " Processing,wait for finish at " + this.mState);
                }
                this.mState = state2;
                Handler handler = this.mWorkerHandler;
                if (handler == null) {
                    return;
                }
                if (Looper.myLooper() == handler.getLooper()) {
                    innerStart();
                    return;
                } else {
                    handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.6
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameSeqDecoder.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                FrameSeqDecoder.this.innerStart();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    return;
                }
            }
        }
        Log.i(TAG, debugInfo() + " Already started");
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.fullRect == RECT_EMPTY) {
            return;
        }
        State state = this.mState;
        State state2 = State.FINISHING;
        if (state != state2 && this.mState != State.IDLE) {
            if (this.mState == State.INITIALIZING) {
                Log.e(TAG, debugInfo() + "Processing,wait for finish at " + this.mState);
            }
            this.mState = state2;
            Handler handler = this.mWorkerHandler;
            if (handler == null) {
                return;
            }
            if (Looper.myLooper() == handler.getLooper()) {
                innerStop();
                return;
            } else {
                handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.7
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameSeqDecoder.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            FrameSeqDecoder.this.innerStop();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
                return;
            }
        }
        Log.i(TAG, debugInfo() + "No need to stop");
    }

    public void stopIfNeeded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Handler handler = this.mWorkerHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameSeqDecoder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (FrameSeqDecoder.this.renderListeners.size() == 0) {
                    FrameSeqDecoder.this.stop();
                }
            }
        });
    }
}
