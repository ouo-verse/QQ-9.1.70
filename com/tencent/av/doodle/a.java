package com.tencent.av.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.doodle.ColorPickerView;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    public static int c() {
        DoodleLogic b16 = DoodleLogic.b();
        if (!DoodleUtils.e()) {
            return R.string.d_s;
        }
        if (!b16.d()) {
            return R.string.d_r;
        }
        if (b16.f73593l) {
            return 0;
        }
        return R.string.d_q;
    }

    public static void d(long j3, AVActivity aVActivity) {
        ViewGroup viewGroup;
        DoodleLogic b16 = DoodleLogic.b();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("hideDoodle, activity[");
            sb5.append(aVActivity != null);
            sb5.append("], logic[");
            sb5.append(b16 != null);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.w("Doodle", 2, sb5.toString());
        }
        if (aVActivity == null || b16 == null || (viewGroup = (ViewGroup) aVActivity.findViewById(R.id.a2f)) == null) {
            return;
        }
        DoodleSurfaceView doodleSurfaceView = (DoodleSurfaceView) viewGroup.findViewById(R.id.g7u);
        if (doodleSurfaceView != null) {
            doodleSurfaceView.setClickable(false);
            if (!doodleSurfaceView.c()) {
                DoodleUtils.g(viewGroup);
            }
        }
        ColorPickerView colorPickerView = (ColorPickerView) viewGroup.findViewById(R.id.g7k);
        if (colorPickerView != null) {
            colorPickerView.clearAnimation();
            colorPickerView.setVisibility(8);
            g(viewGroup);
        }
        b16.f73595n.f(false);
    }

    public static boolean e(long j3, AVActivity aVActivity) {
        DoodleLogic b16 = DoodleLogic.b();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isDoodleShow, activity[");
            sb5.append(aVActivity != null);
            sb5.append("], logic[");
            sb5.append(b16 != null);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.i("Doodle", 2, sb5.toString());
        }
        if (aVActivity == null || b16 == null) {
            return false;
        }
        return b16.f73595n.a();
    }

    public static boolean f() {
        DoodleLogic b16 = DoodleLogic.b();
        return DoodleUtils.e() && b16.f73593l && b16.d();
    }

    public static void h(long j3, AVActivity aVActivity) {
        DoodleLogic b16 = DoodleLogic.b();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("restoreDoodle, activity[");
            sb5.append(aVActivity != null);
            sb5.append("], logic[");
            sb5.append(b16 != null);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.i("Doodle", 2, sb5.toString());
        }
        if (aVActivity == null || b16 == null || !b16.f73595n.a()) {
            return;
        }
        i(com.tencent.av.utils.e.d(), aVActivity);
    }

    public static void i(long j3, AVActivity aVActivity) {
        ViewGroup viewGroup;
        DoodleLogic b16 = DoodleLogic.b();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("showDoodle, activity[");
            sb5.append(aVActivity != null);
            sb5.append("], logic[");
            sb5.append(b16 != null);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.w("Doodle", 2, sb5.toString());
        }
        if (aVActivity == null || b16 == null || (viewGroup = (ViewGroup) aVActivity.findViewById(R.id.a2f)) == null) {
            return;
        }
        View a16 = DoodleUtils.a(viewGroup);
        if (a16 != null) {
            a16.setClickable(true);
        }
        ColorPickerView a17 = a(viewGroup, aVActivity);
        a17.clearAnimation();
        a17.setVisibility(0);
        b16.f73595n.f(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.doodle.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0739a implements ColorPickerView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AVActivity f73607a;

        C0739a(AVActivity aVActivity) {
            this.f73607a = aVActivity;
        }

        @Override // com.tencent.av.doodle.ColorPickerView.a
        public void onCancel() {
            a.d(-1055L, this.f73607a);
            ReportController.o(null, "dc00898", "", "", "0X800BC16", "0X800BC16", 0, 0, "", "", "", "");
        }
    }

    public static String b(Context context) {
        int c16;
        if (context != null && (c16 = c()) != 0) {
            return context.getString(c16);
        }
        return "";
    }

    private static ColorPickerView a(ViewGroup viewGroup, AVActivity aVActivity) {
        ColorPickerView colorPickerView = (ColorPickerView) viewGroup.findViewById(R.id.g7k);
        if (colorPickerView != null) {
            return colorPickerView;
        }
        ColorPickerView colorPickerView2 = new ColorPickerView(viewGroup.getContext());
        colorPickerView2.setOnCancelClickListener(new C0739a(aVActivity));
        Resources resources = viewGroup.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.f159332a33);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.a2s);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.a2t);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset2);
        layoutParams.setMargins(0, dimensionPixelOffset3, 0, 0);
        layoutParams.addRule(11);
        viewGroup.addView(colorPickerView2, layoutParams);
        return colorPickerView2;
    }

    private static void g(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.g7k);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
    }
}
