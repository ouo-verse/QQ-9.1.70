package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class ShortcutManagerCompat {

    @VisibleForTesting
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;

    @VisibleForTesting
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    /* compiled from: P */
    @RequiresApi(25)
    /* loaded from: classes.dex */
    private static class Api25Impl {
        Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(@NonNull List<ShortcutInfo> list) {
            int rank;
            String id5;
            int rank2;
            int i3 = -1;
            String str = null;
            for (ShortcutInfo shortcutInfo : list) {
                rank = shortcutInfo.getRank();
                if (rank > i3) {
                    id5 = shortcutInfo.getId();
                    rank2 = shortcutInfo.getRank();
                    str = id5;
                    i3 = rank2;
                }
            }
            return str;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ShortcutMatchFlags {
    }

    ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        boolean addDynamicShortcuts;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 29) {
            convertUriIconsToBitmapIcons(context, list);
        }
        if (i3 >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            addDynamicShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList);
            if (!addDynamicShortcuts) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        Iterator<ShortcutInfoChangeListener> it5 = getShortcutInfoListeners(context).iterator();
        while (it5.hasNext()) {
            it5.next().onShortcutAdded(list);
        }
        return true;
    }

    @VisibleForTesting
    static boolean convertUriIconToBitmapIcon(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Bitmap decodeStream;
        IconCompat createWithBitmap;
        IconCompat iconCompat = shortcutInfoCompat.mIcon;
        if (iconCompat == null) {
            return false;
        }
        int i3 = iconCompat.mType;
        if (i3 != 6 && i3 != 4) {
            return true;
        }
        InputStream uriInputStream = iconCompat.getUriInputStream(context);
        if (uriInputStream == null || (decodeStream = BitmapFactory.decodeStream(uriInputStream)) == null) {
            return false;
        }
        if (i3 == 6) {
            createWithBitmap = IconCompat.createWithAdaptiveBitmap(decodeStream);
        } else {
            createWithBitmap = IconCompat.createWithBitmap(decodeStream);
        }
        shortcutInfoCompat.mIcon = createWithBitmap;
        return true;
    }

    @VisibleForTesting
    static void convertUriIconsToBitmapIcons(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        for (ShortcutInfoCompat shortcutInfoCompat : new ArrayList(list)) {
            if (!convertUriIconToBitmapIcon(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = new Intent();
        }
        return shortcutInfoCompat.addToIntent(intent);
    }

    public static void disableShortcuts(@NonNull Context context, @NonNull List<String> list, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        Iterator<ShortcutInfoChangeListener> it = getShortcutInfoListeners(context).iterator();
        while (it.hasNext()) {
            it.next().onShortcutRemoved(list);
        }
    }

    public static void enableShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().mId);
            }
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        Iterator<ShortcutInfoChangeListener> it5 = getShortcutInfoListeners(context).iterator();
        while (it5.hasNext()) {
            it5.next().onShortcutAdded(list);
        }
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context context) {
        List dynamicShortcuts;
        if (Build.VERSION.SDK_INT >= 25) {
            dynamicShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
            ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
            Iterator it = dynamicShortcuts.iterator();
            while (it.hasNext()) {
                arrayList.add(new ShortcutInfoCompat.Builder(context, (ShortcutInfo) it.next()).build());
            }
            return arrayList;
        }
        try {
            return getShortcutInfoSaverInstance(context).getShortcuts();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private static int getIconDimensionInternal(@NonNull Context context, boolean z16) {
        boolean z17;
        int i3;
        float f16;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null && !activityManager.isLowRamDevice()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            i3 = 48;
        } else {
            i3 = 96;
        }
        int max = Math.max(1, i3);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z16) {
            f16 = displayMetrics.xdpi;
        } else {
            f16 = displayMetrics.ydpi;
        }
        return (int) (max * (f16 / 160.0f));
    }

    public static int getIconMaxHeight(@NonNull Context context) {
        int iconMaxHeight;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            iconMaxHeight = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
            return iconMaxHeight;
        }
        return getIconDimensionInternal(context, false);
    }

    public static int getIconMaxWidth(@NonNull Context context) {
        int iconMaxWidth;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            iconMaxWidth = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
            return iconMaxWidth;
        }
        return getIconDimensionInternal(context, true);
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context context) {
        int maxShortcutCountPerActivity;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            maxShortcutCountPerActivity = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
            return maxShortcutCountPerActivity;
        }
        return 5;
    }

    @VisibleForTesting
    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(@NonNull List<ShortcutInfoCompat> list) {
        int i3 = -1;
        String str = null;
        for (ShortcutInfoCompat shortcutInfoCompat : list) {
            if (shortcutInfoCompat.getRank() > i3) {
                str = shortcutInfoCompat.getId();
                i3 = shortcutInfoCompat.getRank();
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        Bundle bundle;
        if (sShortcutInfoChangeListeners == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it = InstalledAppListMonitor.queryIntentActivities(packageManager, intent, 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                    String string = bundle.getString(SHORTCUT_LISTENER_META_DATA_KEY);
                    if (string != null) {
                        try {
                            arrayList.add((ShortcutInfoChangeListener) Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                        } catch (Exception unused) {
                        }
                    }
                    while (it.hasNext()) {
                    }
                }
            }
            if (sShortcutInfoChangeListeners == null) {
                sShortcutInfoChangeListeners = arrayList;
            }
        }
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            } catch (Exception unused) {
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context context, int i3) {
        List pinnedShortcuts;
        List dynamicShortcuts;
        List manifestShortcuts;
        List shortcuts;
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 30) {
            shortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getShortcuts(i3);
            return ShortcutInfoCompat.fromShortcuts(context, shortcuts);
        }
        if (i16 >= 25) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            ArrayList arrayList = new ArrayList();
            if ((i3 & 1) != 0) {
                manifestShortcuts = shortcutManager.getManifestShortcuts();
                arrayList.addAll(manifestShortcuts);
            }
            if ((i3 & 2) != 0) {
                dynamicShortcuts = shortcutManager.getDynamicShortcuts();
                arrayList.addAll(dynamicShortcuts);
            }
            if ((i3 & 4) != 0) {
                pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                arrayList.addAll(pinnedShortcuts);
            }
            return ShortcutInfoCompat.fromShortcuts(context, arrayList);
        }
        if ((i3 & 2) != 0) {
            try {
                return getShortcutInfoSaverInstance(context).getShortcuts();
            } catch (Exception unused) {
            }
        }
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(@NonNull Context context) {
        boolean isRateLimitingActive;
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            isRateLimitingActive = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
            return isRateLimitingActive;
        }
        if (getShortcuts(context, 3).size() == getMaxShortcutCountPerActivity(context)) {
            return true;
        }
        return false;
    }

    public static boolean isRequestPinShortcutSupported(@NonNull Context context) {
        boolean isRequestPinShortcutSupported;
        if (Build.VERSION.SDK_INT >= 26) {
            isRequestPinShortcutSupported = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
            return isRequestPinShortcutSupported;
        }
        if (ContextCompat.checkSelfPermission(context, INSTALL_SHORTCUT_PERMISSION) != 0) {
            return false;
        }
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.permission;
            if (TextUtils.isEmpty(str) || INSTALL_SHORTCUT_PERMISSION.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pushDynamicShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        boolean isRateLimitingActive;
        List dynamicShortcuts;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutInfoCompat);
        int maxShortcutCountPerActivity = getMaxShortcutCountPerActivity(context);
        if (maxShortcutCountPerActivity == 0) {
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 29) {
            convertUriIconToBitmapIcon(context, shortcutInfoCompat);
        }
        if (i3 >= 30) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).pushDynamicShortcut(shortcutInfoCompat.toShortcutInfo());
        } else if (i3 >= 25) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            isRateLimitingActive = shortcutManager.isRateLimitingActive();
            if (!isRateLimitingActive) {
                dynamicShortcuts = shortcutManager.getDynamicShortcuts();
                if (dynamicShortcuts.size() >= maxShortcutCountPerActivity) {
                    shortcutManager.removeDynamicShortcuts(Arrays.asList(Api25Impl.getShortcutInfoWithLowestRank(dynamicShortcuts)));
                }
                shortcutManager.addDynamicShortcuts(Arrays.asList(shortcutInfoCompat.toShortcutInfo()));
            } else {
                return false;
            }
        }
        ShortcutInfoCompatSaver<?> shortcutInfoSaverInstance = getShortcutInfoSaverInstance(context);
        try {
            List<ShortcutInfoCompat> shortcuts = shortcutInfoSaverInstance.getShortcuts();
            if (shortcuts.size() >= maxShortcutCountPerActivity) {
                shortcutInfoSaverInstance.removeShortcuts(Arrays.asList(getShortcutInfoCompatWithLowestRank(shortcuts)));
            }
            shortcutInfoSaverInstance.addShortcuts(Arrays.asList(shortcutInfoCompat));
            Iterator<ShortcutInfoChangeListener> it = getShortcutInfoListeners(context).iterator();
            while (it.hasNext()) {
                it.next().onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            reportShortcutUsed(context, shortcutInfoCompat.getId());
            return true;
        } catch (Exception unused) {
            Iterator<ShortcutInfoChangeListener> it5 = getShortcutInfoListeners(context).iterator();
            while (it5.hasNext()) {
                it5.next().onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            reportShortcutUsed(context, shortcutInfoCompat.getId());
            return false;
        } catch (Throwable th5) {
            Iterator<ShortcutInfoChangeListener> it6 = getShortcutInfoListeners(context).iterator();
            while (it6.hasNext()) {
                it6.next().onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            reportShortcutUsed(context, shortcutInfoCompat.getId());
            throw th5;
        }
    }

    public static void removeAllDynamicShortcuts(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> it = getShortcutInfoListeners(context).iterator();
        while (it.hasNext()) {
            it.next().onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        Iterator<ShortcutInfoChangeListener> it = getShortcutInfoListeners(context).iterator();
        while (it.hasNext()) {
            it.next().onShortcutRemoved(list);
        }
    }

    public static void removeLongLivedShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 30) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
            getShortcutInfoSaverInstance(context).removeShortcuts(list);
            Iterator<ShortcutInfoChangeListener> it = getShortcutInfoListeners(context).iterator();
            while (it.hasNext()) {
                it.next().onShortcutRemoved(list);
            }
            return;
        }
        removeDynamicShortcuts(context, list);
    }

    public static void reportShortcutUsed(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).reportShortcutUsed(str);
        }
        Iterator<ShortcutInfoChangeListener> it = getShortcutInfoListeners(context).iterator();
        while (it.hasNext()) {
            it.next().onShortcutUsageReported(Collections.singletonList(str));
        }
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable final IntentSender intentSender) {
        boolean requestPinShortcut;
        if (Build.VERSION.SDK_INT >= 26) {
            requestPinShortcut = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
            return requestPinShortcut;
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        Intent addToIntent = shortcutInfoCompat.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (intentSender == null) {
            context.sendBroadcast(addToIntent);
            return true;
        }
        context.sendOrderedBroadcast(addToIntent, null, new BroadcastReceiver() { // from class: androidx.core.content.pm.ShortcutManagerCompat.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                try {
                    intentSender.sendIntent(context2, 0, null, null, null);
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }, null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        boolean dynamicShortcuts;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(list);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            dynamicShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList);
            if (!dynamicShortcuts) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        for (ShortcutInfoChangeListener shortcutInfoChangeListener : getShortcutInfoListeners(context)) {
            shortcutInfoChangeListener.onAllShortcutsRemoved();
            shortcutInfoChangeListener.onShortcutAdded(list);
        }
        return true;
    }

    @VisibleForTesting
    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> list) {
        sShortcutInfoChangeListeners = list;
    }

    @VisibleForTesting
    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> shortcutInfoCompatSaver) {
        sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
    }

    public static boolean updateShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        boolean updateShortcuts;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 29) {
            convertUriIconsToBitmapIcons(context, list);
        }
        if (i3 >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<ShortcutInfoCompat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toShortcutInfo());
            }
            updateShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList);
            if (!updateShortcuts) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        Iterator<ShortcutInfoChangeListener> it5 = getShortcutInfoListeners(context).iterator();
        while (it5.hasNext()) {
            it5.next().onShortcutUpdated(list);
        }
        return true;
    }
}
