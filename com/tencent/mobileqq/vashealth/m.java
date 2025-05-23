package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(Boolean bool);
    }

    private static boolean b(String str, Activity activity) {
        String str2;
        FileOutputStream fileOutputStream;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = false;
        if (activity == null) {
            QLog.e("QQHealthShareUtil", 1, "doShareSnapshotToGuild activity is null");
            return false;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            try {
                decodeFile = BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e16) {
                QLog.e("QQHealthShareUtil", 1, "doShareSnapshotToGuild error:" + e16);
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(str));
                    try {
                        z16 = decodeFile.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                        d(str, activity);
                        QLog.i("QQHealthShareUtil", 1, "Time used:" + (System.currentTimeMillis() - currentTimeMillis));
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        fileOutputStream2 = fileOutputStream;
                        QLog.e("QQHealthShareUtil", 1, "doShareSnapshotToGuild error:" + e);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e18) {
                                str2 = "doShareSnapshotToGuild error:" + e18;
                                QLog.e("QQHealthShareUtil", 1, str2);
                                return z16;
                            }
                        }
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e19) {
                                QLog.e("QQHealthShareUtil", 1, "doShareSnapshotToGuild error:" + e19);
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e27) {
                    str2 = "doShareSnapshotToGuild error:" + e27;
                    QLog.e("QQHealthShareUtil", 1, str2);
                    return z16;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e28) {
            QLog.e("QQHealthShareUtil", 1, "doShareSnapshotToGuild error:" + e28);
        }
        return z16;
    }

    private static Bundle c(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 2);
        return bundle;
    }

    private static void d(String str, Activity activity) {
        Intent intent = new Intent();
        intent.putExtras(c(str));
        intent.putExtra("call_by_forward", true);
        intent.putExtra("is_multi_selection", false);
        intent.putExtra("only_single_selection", true);
        intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>());
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, Activity activity, a aVar) {
        aVar.a(Boolean.valueOf(b(str, activity)));
    }

    public static void f(final String str, final Activity activity, final a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.l
            @Override // java.lang.Runnable
            public final void run() {
                m.e(str, activity, aVar);
            }
        }, 16, null, false);
    }
}
