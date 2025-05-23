package cooperation.qzone.util;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class WeakReferenceHandler<T> extends Handler {
    private WeakReference<T> mTarget;

    public WeakReferenceHandler(T t16) {
        this.mTarget = new WeakReference<>(t16);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        T t16 = this.mTarget.get();
        if (t16 != null) {
            handleMessage(t16, message);
        }
    }

    public abstract void handleMessage(T t16, Message message);
}
