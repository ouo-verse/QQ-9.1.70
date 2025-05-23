package androidx.transition;

import android.os.IBinder;

/* compiled from: P */
/* loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
