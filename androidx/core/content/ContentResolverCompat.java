package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ContentResolverCompat {
    ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        Object cancellationSignalObject;
        if (cancellationSignal != null) {
            try {
                cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
            } catch (Exception e16) {
                if (e16 instanceof OperationCanceledException) {
                    throw new androidx.core.os.OperationCanceledException();
                }
                throw e16;
            }
        } else {
            cancellationSignalObject = null;
        }
        return ContactsMonitor.query(contentResolver, uri, strArr, str, strArr2, str2, (android.os.CancellationSignal) cancellationSignalObject);
    }
}
