package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public final class DragAndDropPermissionsCompat {
    private Object mDragAndDropPermissions;

    DragAndDropPermissionsCompat(Object obj) {
        this.mDragAndDropPermissions = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r2 = r2.requestDragAndDropPermissions(r3);
     */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DragAndDropPermissionsCompat request(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions requestDragAndDropPermissions;
        if (Build.VERSION.SDK_INT >= 24 && requestDragAndDropPermissions != null) {
            return new DragAndDropPermissionsCompat(requestDragAndDropPermissions);
        }
        return null;
    }

    public void release() {
        if (Build.VERSION.SDK_INT >= 24) {
            ((DragAndDropPermissions) this.mDragAndDropPermissions).release();
        }
    }
}
