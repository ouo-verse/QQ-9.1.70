package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RequiresApi(16)
/* loaded from: classes.dex */
public class NotificationCompatJellybean {
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = new Object();
    private static final Object sActionsLock = new Object();

    NotificationCompatJellybean() {
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            Bundle bundle = list.get(i3);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i3, bundle);
            }
        }
        return sparseArray;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                sActionIconField = cls.getDeclaredField("icon");
                sActionTitleField = cls.getDeclaredField("title");
                sActionIntentField = cls.getDeclaredField(KEY_ACTION_INTENT);
                Field declaredField = Notification.class.getDeclaredField("actions");
                sActionsField = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e16) {
            Log.e(TAG, "Unable to access notification actions", e16);
            sActionsAccessFailed = true;
        } catch (NoSuchFieldException e17) {
            Log.e(TAG, "Unable to access notification actions", e17);
            sActionsAccessFailed = true;
        }
        return !sActionsAccessFailed;
    }

    private static RemoteInput fromBundle(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new RemoteInput(bundle.getString(KEY_RESULT_KEY), bundle.getCharSequence(KEY_LABEL), bundle.getCharSequenceArray(KEY_CHOICES), bundle.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), 0, bundle.getBundle(KEY_EXTRAS), hashSet);
    }

    private static RemoteInput[] fromBundleArray(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i3 = 0; i3 < bundleArr.length; i3++) {
            remoteInputArr[i3] = fromBundle(bundleArr[i3]);
        }
        return remoteInputArr;
    }

    public static NotificationCompat.Action getAction(Notification notification, int i3) {
        Bundle bundle;
        SparseArray sparseParcelableArray;
        synchronized (sActionsLock) {
            try {
                try {
                    Object[] actionObjectsLocked = getActionObjectsLocked(notification);
                    if (actionObjectsLocked != null) {
                        Object obj = actionObjectsLocked[i3];
                        Bundle extras = getExtras(notification);
                        if (extras != null && (sparseParcelableArray = extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS)) != null) {
                            bundle = (Bundle) sparseParcelableArray.get(i3);
                        } else {
                            bundle = null;
                        }
                        return readAction(sActionIconField.getInt(obj), (CharSequence) sActionTitleField.get(obj), (PendingIntent) sActionIntentField.get(obj), bundle);
                    }
                } catch (IllegalAccessException e16) {
                    Log.e(TAG, "Unable to access notification actions", e16);
                    sActionsAccessFailed = true;
                }
                return null;
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public static int getActionCount(Notification notification) {
        int i3;
        synchronized (sActionsLock) {
            Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            if (actionObjectsLocked != null) {
                i3 = actionObjectsLocked.length;
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NotificationCompat.Action getActionFromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(KEY_EXTRAS);
        boolean z16 = false;
        if (bundle2 != null) {
            z16 = bundle2.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES, false);
        }
        return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable(KEY_ACTION_INTENT), bundle.getBundle(KEY_EXTRAS), fromBundleArray(getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS)), fromBundleArray(getBundleArrayFromBundle(bundle, KEY_DATA_ONLY_REMOTE_INPUTS)), z16, bundle.getInt(KEY_SEMANTIC_ACTION), bundle.getBoolean(KEY_SHOWS_USER_INTERFACE), false);
    }

    private static Object[] getActionObjectsLocked(Notification notification) {
        synchronized (sActionsLock) {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                return (Object[]) sActionsField.get(notification);
            } catch (IllegalAccessException e16) {
                Log.e(TAG, "Unable to access notification actions", e16);
                sActionsAccessFailed = true;
                return null;
            }
        }
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if (!(parcelableArray instanceof Bundle[]) && parcelableArray != null) {
            Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
            bundle.putParcelableArray(str, bundleArr);
            return bundleArr;
        }
        return (Bundle[]) parcelableArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle getBundleForAction(NotificationCompat.Action action) {
        int i3;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            i3 = iconCompat.getResId();
        } else {
            i3 = 0;
        }
        bundle2.putInt("icon", i3);
        bundle2.putCharSequence("title", action.getTitle());
        bundle2.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        bundle2.putBundle(KEY_EXTRAS, bundle);
        bundle2.putParcelableArray(KEY_REMOTE_INPUTS, toBundleArray(action.getRemoteInputs()));
        bundle2.putBoolean(KEY_SHOWS_USER_INTERFACE, action.getShowsUserInterface());
        bundle2.putInt(KEY_SEMANTIC_ACTION, action.getSemanticAction());
        return bundle2;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (sExtrasLock) {
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            try {
                try {
                    if (sExtrasField == null) {
                        Field declaredField = Notification.class.getDeclaredField(KEY_EXTRAS);
                        if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                            Log.e(TAG, "Notification.extras field is not of type Bundle");
                            sExtrasFieldAccessFailed = true;
                            return null;
                        }
                        declaredField.setAccessible(true);
                        sExtrasField = declaredField;
                    }
                    Bundle bundle = (Bundle) sExtrasField.get(notification);
                    if (bundle == null) {
                        bundle = new Bundle();
                        sExtrasField.set(notification, bundle);
                    }
                    return bundle;
                } catch (IllegalAccessException e16) {
                    Log.e(TAG, "Unable to access notification extras", e16);
                    sExtrasFieldAccessFailed = true;
                    return null;
                }
            } catch (NoSuchFieldException e17) {
                Log.e(TAG, "Unable to access notification extras", e17);
                sExtrasFieldAccessFailed = true;
                return null;
            }
        }
    }

    public static NotificationCompat.Action readAction(int i3, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        boolean z16;
        if (bundle != null) {
            remoteInputArr = fromBundleArray(getBundleArrayFromBundle(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
            remoteInputArr2 = fromBundleArray(getBundleArrayFromBundle(bundle, EXTRA_DATA_ONLY_REMOTE_INPUTS));
            z16 = bundle.getBoolean(EXTRA_ALLOW_GENERATED_REPLIES);
        } else {
            remoteInputArr = null;
            remoteInputArr2 = null;
            z16 = false;
        }
        return new NotificationCompat.Action(i3, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z16, 0, true, false);
    }

    private static Bundle toBundle(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_RESULT_KEY, remoteInput.getResultKey());
        bundle.putCharSequence(KEY_LABEL, remoteInput.getLabel());
        bundle.putCharSequenceArray(KEY_CHOICES, remoteInput.getChoices());
        bundle.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, remoteInput.getAllowFreeFormInput());
        bundle.putBundle(KEY_EXTRAS, remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(allowedDataTypes.size());
            Iterator<String> it = allowedDataTypes.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList(KEY_ALLOWED_DATA_TYPES, arrayList);
        }
        return bundle;
    }

    private static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i3 = 0; i3 < remoteInputArr.length; i3++) {
            bundleArr[i3] = toBundle(remoteInputArr[i3]);
        }
        return bundleArr;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat.Action action) {
        int i3;
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            i3 = iconCompat.getResId();
        } else {
            i3 = 0;
        }
        builder.addAction(i3, action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, toBundleArray(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray(EXTRA_DATA_ONLY_REMOTE_INPUTS, toBundleArray(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        return bundle;
    }
}
