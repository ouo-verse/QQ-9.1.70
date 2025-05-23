package com.gcore.abase.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DialogUtils {
    private static WeakReference<Activity> sActivityReference;
    private static Context sContext;

    public static void init(Activity activity) {
        sActivityReference = new WeakReference<>(activity);
    }

    public static void initContext(Context context) {
        sContext = context;
    }

    public static void registerBugly(String str, String str2) {
        Context context;
        if (str != null && str2 != null) {
            Activity activity = sActivityReference.get();
            if (activity != null) {
                context = activity.getApplicationContext();
                Log.i("GCloudCore", "get context from activity");
            } else {
                context = sContext;
                if (context != null) {
                    Log.i("GCloudCore", "get context from context");
                } else {
                    Log.e("GCloudCore", "activity and context is null");
                    return;
                }
            }
            if (context == null) {
                Log.e("GCloudCore", "context is null");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
            edit.putString(str, str2);
            edit.apply();
            Log.i("GCloudCore", "registerBugly finish");
            return;
        }
        Log.e("GCloudCore", "input string is null");
    }

    public static void showAlertDialog() {
        Activity activity = sActivityReference.get();
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("GCloudSDK\u63d0\u793a");
            builder.setMessage("GameID\u4e3a0\uff0c\u8bf7\u786e\u8ba4AndroidManifest\u4e2d\u662f\u5426\u6b63\u786e\u914d\u7f6eGameId");
            builder.setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.gcore.abase.utils.DialogUtils.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            });
            builder.setNegativeButton("\u5173\u95ed", new DialogInterface.OnClickListener() { // from class: com.gcore.abase.utils.DialogUtils.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            });
            builder.show();
            return;
        }
        Log.e("GCloudCore", "activity is null");
    }
}
