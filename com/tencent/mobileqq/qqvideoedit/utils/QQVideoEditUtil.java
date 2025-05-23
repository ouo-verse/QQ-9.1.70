package com.tencent.mobileqq.qqvideoedit.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQVideoEditUtil {
    public static boolean d(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (it.hasNext()) {
                if ("com.tencent.mobileqq:peak".equals(it.next().processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("QQVideoEditUtil", 2, "get process info fail.");
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, View view) {
        try {
            if (Utils.z() < FileUtils.getFileSizes(str)) {
                k(view, R.string.f237977ii);
            } else if (TextUtils.isEmpty(com.tencent.mobileqq.filemanager.util.l.a(str))) {
                k(view, R.string.f237987ij);
            } else {
                l(view);
            }
        } catch (Exception unused) {
            k(view, R.string.f237997ik);
        } catch (OutOfMemoryError unused2) {
            k(view, R.string.f237977ii);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(View view) {
        QQToast.makeText(view.getContext(), 1, R.string.f237957ig, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(View view) {
        QQToast.makeText(view.getContext(), 2, R.string.f238007il, 0).show();
    }

    public static void h(Context context) {
        i(context, null, null);
    }

    public static void i(final Context context, Runnable runnable, String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.utils.QQVideoEditUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (QQVideoEditUtil.d(context)) {
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
                intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 6);
                try {
                    context.startService(intent);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQVideoEditUtil", 2, "preLoadPeakProcess, ", th5);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQVideoEditUtil", 2, "preLoadPeakProcess");
                }
            }
        }, 64, null, false);
    }

    public static void j(@NonNull final View view, @NonNull final String str) {
        if (!new VFSFile(str).exists()) {
            k(view, R.string.f237967ih);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.utils.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQVideoEditUtil.e(str, view);
                }
            }, 64, null, true);
        }
    }

    public static void k(final View view, int i3) {
        com.tencent.mobileqq.qqvideoedit.editor.c.k(view, i3);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.utils.g
            @Override // java.lang.Runnable
            public final void run() {
                QQVideoEditUtil.f(view);
            }
        });
        QLog.i("QQVideoEditUtil", 1, "saveToAlbumFailed: " + HardCodeUtil.qqStr(i3));
    }

    private static void l(@NonNull final View view) {
        com.tencent.mobileqq.qqvideoedit.editor.c.l(view);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.utils.h
            @Override // java.lang.Runnable
            public final void run() {
                QQVideoEditUtil.g(view);
            }
        });
        QLog.i("QQVideoEditUtil", 1, "saveToAlbumSuccess.");
    }
}
