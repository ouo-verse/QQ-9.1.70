package com.tencent.qqlive.module.videoreport.scheme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.visual.debug.VisualDebugManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SchemeRouterHelper {
    private static final String PARAM_APP_ID = "dt_appid";
    private static final String PARAM_DEBUG_ID = "dt_debugid";
    private static final String PATH_VISUAL_DEBUG = "visual_debug";
    private static final String TAG = "Visual.SchemeRouterHelper";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f345298d;

        a(Activity activity) {
            this.f345298d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f345298d.finish();
        }
    }

    public static void handleSchemeUrl(Activity activity, Intent intent) {
        Uri uri;
        try {
            if (activity == null) {
                Log.w(TAG, "handleSchemeUrl, activity is null!");
                return;
            }
            if (intent != null) {
                uri = intent.getData();
            } else {
                uri = null;
            }
            if (uri == null) {
                Log.w(TAG, "handleSchemeUrl, uri is null!");
                activity.finish();
                return;
            }
            Log.d(TAG, "handleSchemeUrl, uri=" + uri);
            if (PATH_VISUAL_DEBUG.equals(uri.getHost())) {
                String queryParameter = uri.getQueryParameter("dt_appid");
                String queryParameter2 = uri.getQueryParameter("dt_debugid");
                if (TextUtils.isEmpty(queryParameter)) {
                    Log.w(TAG, "handleSchemeUrl, \u7f3a\u5c11\u5fc5\u8981\u53c2\u6570\uff1adt_appid");
                    showDialog(activity, "\u7f3a\u5c11\u5fc5\u8981\u53c2\u6570\uff1adt_appid");
                    return;
                } else if (TextUtils.isEmpty(queryParameter2)) {
                    Log.w(TAG, "handleSchemeUrl, \u7f3a\u5c11\u5fc5\u8981\u53c2\u6570\uff1adt_debugid");
                    showDialog(activity, "\u7f3a\u5c11\u5fc5\u8981\u53c2\u6570\uff1adt_debugid");
                    return;
                } else {
                    VisualDebugManager.getInstance().startVisualDebug(queryParameter, queryParameter2);
                    showToast(activity, "\u5df2\u5f00\u542f\u5927\u540c\u53ef\u89c6\u5316\u8054\u8c03\u6a21\u5f0f \uff1a)");
                    activity.finish();
                    return;
                }
            }
            activity.finish();
        } catch (Exception e16) {
            Log.e(TAG, "handleSchemeUrl exception: " + e16.getLocalizedMessage());
        }
    }

    public static void showDialog(Activity activity, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("\u63d0\u793a").setMessage(str).setCancelable(false).setPositiveButton("\u786e\u5b9a", new a(activity));
        AlertDialog create = builder.create();
        try {
            create.getButton(-1).setTextColor(SupportMenu.CATEGORY_MASK);
            create.getButton(-1).setBackgroundColor(-1);
        } catch (Exception e16) {
            Log.e(TAG, "showDialog exception: " + e16.getLocalizedMessage());
        }
        create.show();
    }

    public static void showToast(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static void startLaunchActivity(Context context) {
        try {
            context.startActivity(InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), context.getPackageName()));
            Log.i(TAG, "startLaunchActivity");
        } catch (Exception e16) {
            Log.e(TAG, "startLaunchActivity exception: " + e16.getLocalizedMessage());
        }
    }
}
