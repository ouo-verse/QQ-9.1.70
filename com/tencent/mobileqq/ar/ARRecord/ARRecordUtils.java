package com.tencent.mobileqq.ar.ARRecord;

import android.content.DialogInterface;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ARRecordUtils {
    public static String a(int i3) {
        StringBuilder sb5 = new StringBuilder(10);
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        double d16 = (i3 / 1024.0f) / 1024.0f;
        if (d16 < 1.0d) {
            sb5.append(0);
        }
        sb5.append(decimalFormat.format(d16));
        sb5.append("M");
        return sb5.toString();
    }

    public static String b(int i3) {
        StringBuilder sb5 = new StringBuilder(30);
        sb5.append("\u5f55\u5236\u4e2d (");
        int i16 = i3 / 60;
        int i17 = i3 - (i16 * 60);
        if (i16 < 10) {
            sb5.append("0");
            sb5.append(i16);
        } else {
            sb5.append(i16);
        }
        sb5.append(":");
        if (i17 < 10) {
            sb5.append("0");
            sb5.append(i17);
        } else {
            sb5.append(i17);
        }
        sb5.append(")");
        return sb5.toString();
    }

    public static boolean c() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("ARRecordUtils_AR", 4).getBoolean("ARVideoRecordPressKey12", false);
    }

    public static boolean d(long j3) {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (statFs.getAvailableBlocks() * statFs.getBlockSize() < j3) {
            return false;
        }
        return true;
    }

    public static void e(File file) {
        com.tencent.biz.qqstory.utils.d.b(BaseApplication.getContext(), file);
    }

    public static void f(boolean z16) {
        ea.i(BaseApplicationImpl.getApplication().getSharedPreferences("ARRecordUtils_AR", 4).edit().putBoolean("ARVideoRecordPressKey12", z16));
    }

    public static void g(final String str, final String str2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARRecordUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DialogUtil.createCustomDialog(ARVideoRecordUIControllerImpl.t().s(), 230, str, str2, "", HardCodeUtil.qqStr(R.string.f171611jr3), new a(), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.ar.ARRecord.ARRecordUtils$1$a */
            /* loaded from: classes11.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            }
        });
    }

    public static void h(final String str, final boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARRecordUtils.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z16) {
                    QQToast.makeText(BaseApplication.getContext(), str, 0).show();
                } else {
                    QQToast.makeText(BaseApplication.getContext(), 2, str, 0).show();
                }
            }
        });
    }
}
