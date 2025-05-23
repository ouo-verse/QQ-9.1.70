package hynb.e;

import android.util.Log;
import com.huya.huyasdk.api.IHYLogger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements IHYLogger {
    @Override // com.huya.huyasdk.api.IHYLogger
    public void debug(Object obj, String str) {
        Log.d(String.valueOf(obj), str);
    }

    @Override // com.huya.huyasdk.api.IHYLogger
    public void error(Object obj, String str) {
        Log.e(String.valueOf(obj), str);
    }

    @Override // com.huya.huyasdk.api.IHYLogger
    public void info(Object obj, String str) {
        Log.i(String.valueOf(obj), str);
    }

    @Override // com.huya.huyasdk.api.IHYLogger
    public boolean isLogLevelEnabled(int i3) {
        return Log.isLoggable("", i3);
    }

    @Override // com.huya.huyasdk.api.IHYLogger
    public void uncaughtException(Throwable th5) {
        Log.e("HuyaDefaultLogLogger", "uncaughtException: ", th5);
    }

    @Override // com.huya.huyasdk.api.IHYLogger
    public void flushToDisk() {
    }
}
