package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DialogListUtil {
    private static Map<Activity, List<WeakReference<Dialog>>> mActivityDialogMap = Collections.synchronizedMap(new WeakHashMap());

    public static Activity getDialogActivity(Dialog dialog) {
        Context context = dialog.getContext();
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    public static List<WeakReference<Dialog>> getDialogList(Activity activity) {
        return mActivityDialogMap.get(activity);
    }

    public static void onDialogResume(@NonNull final Dialog dialog) {
        ThreadUtils.ensureRunOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.page.DialogListUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Activity dialogActivity = DialogListUtil.getDialogActivity(dialog);
                if (dialogActivity != null) {
                    List dialogList = DialogListUtil.getDialogList(dialogActivity);
                    if (dialogList == null) {
                        dialogList = new ArrayList();
                        DialogListUtil.mActivityDialogMap.put(dialogActivity, dialogList);
                    }
                    DialogListUtil.saveDialog(dialog, dialogList);
                }
            }
        });
    }

    public static void onDialogStop(final Dialog dialog) {
        ThreadUtils.ensureRunOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.page.DialogListUtil.2
            @Override // java.lang.Runnable
            public void run() {
                List<WeakReference<Dialog>> dialogList;
                Activity dialogActivity = DialogListUtil.getDialogActivity(dialog);
                if (dialogActivity != null && (dialogList = DialogListUtil.getDialogList(dialogActivity)) != null) {
                    DialogListUtil.removeDialog(dialog, dialogList);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeDialog(@NonNull Dialog dialog, @NonNull List<WeakReference<Dialog>> list) {
        Dialog dialog2;
        Iterator<WeakReference<Dialog>> it = list.iterator();
        while (it.hasNext()) {
            WeakReference<Dialog> next = it.next();
            if (next == null) {
                dialog2 = null;
            } else {
                dialog2 = next.get();
            }
            if (dialog2 == null || dialog2 == dialog) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveDialog(Dialog dialog, List<WeakReference<Dialog>> list) {
        removeDialog(dialog, list);
        list.add(new WeakReference<>(dialog));
    }
}
