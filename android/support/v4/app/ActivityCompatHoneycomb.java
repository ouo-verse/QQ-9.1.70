package android.support.v4.app;

import android.app.Activity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: P */
/* loaded from: classes.dex */
public class ActivityCompatHoneycomb {
    public static void dump(Activity activity, String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        activity.dump(str, fileDescriptor, printWriter, strArr);
    }

    public static void invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
    }
}
