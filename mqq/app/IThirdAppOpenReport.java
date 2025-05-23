package mqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IThirdAppOpenReport {
    public static final int TYPE_BIND_SERVICE = 2;
    public static final int TYPE_START_ACTIVITY = 0;
    public static final int TYPE_START_SERVICE = 1;

    void report(Context context, Intent intent, int i3);

    void startActivityForResult(Activity activity, Intent intent, int i3, Bundle bundle);
}
