package cooperation.qzone.event;

import com.tencent.qzonehub.api.IQzoneEventApi;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes38.dex */
public class ExoticEventPool {
    private static final int MAX_QUEUE_SIZE = 20;
    private static final String TAG = "ExoticEventPool";
    private final BlockingQueue<IQzoneEventApi.ExoticEventInterface> mQueue = new LinkedBlockingDeque(20);

    /* loaded from: classes38.dex */
    private static class ExoticEventPoolHolder {
        private static final ExoticEventPool INSTANCE = new ExoticEventPool();

        ExoticEventPoolHolder() {
        }
    }

    ExoticEventPool() {
    }

    public static ExoticEventPool getInstance() {
        return ExoticEventPoolHolder.INSTANCE;
    }

    public boolean onEventReceived(IQzoneEventApi.ExoticEventInterface exoticEventInterface) {
        if (QZoneApiProxy.isInQZoneEnvironment()) {
            return false;
        }
        if (exoticEventInterface == null) {
            return true;
        }
        try {
            return this.mQueue.add(exoticEventInterface);
        } catch (Throwable unused) {
            return false;
        }
    }

    public IQzoneEventApi.ExoticEventInterface pollEvent() {
        try {
            return this.mQueue.take();
        } catch (Throwable unused) {
            return null;
        }
    }
}
