package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    LayoutInflater mInflater;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: androidx.asynclayoutinflater.view.AsyncLayoutInflater.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.view == null) {
                inflateRequest.view = AsyncLayoutInflater.this.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
            }
            inflateRequest.callback.onInflateFinished(inflateRequest.view, inflateRequest.resid, inflateRequest.parent);
            AsyncLayoutInflater.this.mInflateThread.releaseRequest(inflateRequest);
            return true;
        }
    };
    Handler mHandler = new Handler(this.mHandlerCallback);
    InflateThread mInflateThread = InflateThread.getInstance();

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            for (String str2 : sClassPrefixList) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class InflateRequest {
        OnInflateFinishedListener callback;
        AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        InflateRequest() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class InflateThread extends BaseThread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<InflateRequest> mQueue = new ArrayBlockingQueue<>(10);
        private Pools.SynchronizedPool<InflateRequest> mRequestPool = new Pools.SynchronizedPool<>(10);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (InterruptedException e16) {
                throw new RuntimeException("Failed to enqueue async inflate request", e16);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.mRequestPool.acquire();
            if (acquire == null) {
                return new InflateRequest();
            }
            return acquire;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.callback = null;
            inflateRequest.inflater = null;
            inflateRequest.parent = null;
            inflateRequest.resid = 0;
            inflateRequest.view = null;
            this.mRequestPool.release(inflateRequest);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                InflateRequest take = this.mQueue.take();
                try {
                    take.view = take.inflater.mInflater.inflate(take.resid, take.parent, false);
                } catch (RuntimeException e16) {
                    Log.w(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e16);
                }
                Message.obtain(take.inflater.mHandler, 0, take).sendToTarget();
            } catch (InterruptedException e17) {
                Log.w(AsyncLayoutInflater.TAG, e17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view, @LayoutRes int i3, @Nullable ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.mInflater = new BasicInflater(context);
    }

    @UiThread
    public void inflate(@LayoutRes int i3, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener != null) {
            InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
            obtainRequest.inflater = this;
            obtainRequest.resid = i3;
            obtainRequest.parent = viewGroup;
            obtainRequest.callback = onInflateFinishedListener;
            this.mInflateThread.enqueue(obtainRequest);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
