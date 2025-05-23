package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class MediaBrowserCompatUtils {
    MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        }
        if (bundle2 == null) {
            if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        }
        if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1)) {
            return true;
        }
        return false;
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        if (bundle == null) {
            i3 = -1;
        } else {
            i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        }
        if (bundle2 == null) {
            i16 = -1;
        } else {
            i16 = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        }
        if (bundle == null) {
            i17 = -1;
        } else {
            i17 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        }
        if (bundle2 == null) {
            i18 = -1;
        } else {
            i18 = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        }
        int i28 = Integer.MAX_VALUE;
        if (i3 != -1 && i17 != -1) {
            i26 = i3 * i17;
            i19 = (i17 + i26) - 1;
        } else {
            i19 = Integer.MAX_VALUE;
            i26 = 0;
        }
        if (i16 != -1 && i18 != -1) {
            i27 = i16 * i18;
            i28 = (i18 + i27) - 1;
        } else {
            i27 = 0;
        }
        if (i19 >= i27 && i28 >= i26) {
            return true;
        }
        return false;
    }
}
