package com.tencent.av.doodle;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.m;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DoodleUtils {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f73603a = false;

    public static View a(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.g7u);
        if (findViewById == null) {
            View createDoodleSurfaceView = ((IDoodleApi) QRoute.api(IDoodleApi.class)).createDoodleSurfaceView(viewGroup.getContext());
            viewGroup.addView(createDoodleSurfaceView, -1, new ViewGroup.LayoutParams(-1, -1));
            return createDoodleSurfaceView;
        }
        return findViewById;
    }

    public static int b(int i3, int i16, float f16) {
        return i3 + Math.round(f16 * (i16 - i3));
    }

    public static int c(int[] iArr, float f16) {
        if (f16 <= 0.0f) {
            return iArr[0];
        }
        if (f16 >= 1.0f) {
            return iArr[iArr.length - 1];
        }
        float length = f16 * (iArr.length - 1);
        int i3 = (int) length;
        float f17 = length - i3;
        int i16 = iArr[i3];
        int i17 = iArr[i3 + 1];
        return Color.argb(b(Color.alpha(i16), Color.alpha(i17), f17), b(Color.red(i16), Color.red(i17), f17), b(Color.green(i16), Color.green(i17), f17), b(Color.blue(i16), Color.blue(i17), f17));
    }

    public static boolean d() {
        int numCores = AVCoreSystemInfo.getNumCores();
        if (numCores < 4) {
            AVCoreLog.printColorLog("DoodleUtils", "isSupportOfDevice error cpucount = " + numCores);
            return false;
        }
        long maxCpuFreq = AVCoreSystemInfo.getMaxCpuFreq();
        if (maxCpuFreq < 1400000) {
            AVCoreLog.printColorLog("DoodleUtils", "isSupportOfDevice error cpuFrequency = " + maxCpuFreq);
            return false;
        }
        long c16 = m.c();
        if (c16 < 1073741824) {
            AVCoreLog.printColorLog("DoodleUtils", "isSupportOfDevice error memory = " + c16);
            return false;
        }
        return true;
    }

    public static boolean e() {
        if (f73603a) {
            return true;
        }
        if (!d()) {
            return false;
        }
        f73603a = true;
        return true;
    }

    public static b f(int i3) {
        b dVar;
        if (i3 != 1) {
            if (i3 != 3) {
                dVar = new d();
            } else {
                dVar = new g(R.array.f155228be);
            }
        } else {
            dVar = new d();
        }
        dVar.f73609b = i3;
        return dVar;
    }

    public static void g(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.g7u);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
    }

    public static void h(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.doodle.DoodleUtils.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                ReportController.o(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
            }
        }, 16, null, true);
    }
}
