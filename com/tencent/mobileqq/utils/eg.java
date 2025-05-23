package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.shortvideo.filter.QQFilterConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarTintManager;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class eg {

    /* renamed from: g, reason: collision with root package name */
    private static int f307713g;

    /* renamed from: a, reason: collision with root package name */
    private boolean f307714a = true;

    /* renamed from: b, reason: collision with root package name */
    private int f307715b;

    /* renamed from: c, reason: collision with root package name */
    private int f307716c;

    /* renamed from: d, reason: collision with root package name */
    private View f307717d;

    /* renamed from: e, reason: collision with root package name */
    private b f307718e;

    /* renamed from: f, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f307719f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            if (!eg.this.f307714a) {
                return;
            }
            Rect rect = new Rect();
            eg.this.f307717d.getWindowVisibleDisplayFrame(rect);
            int height = eg.this.f307716c - rect.height();
            eg.this.f307716c = rect.height();
            if (height > eg.this.f307715b / 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                eg.this.f307714a = false;
                if (QLog.isColorLevel()) {
                    QLog.d("SoftKeyboardHeight", 2, "onGlobalLayout, keyboard height:", Integer.valueOf(height));
                }
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                if (fromV2.getInt("soft_keyboard_key_height", 0) != height) {
                    fromV2.putInt("soft_keyboard_key_height", height);
                }
                if (eg.this.f307718e != null) {
                    eg.this.f307718e.a(height, false);
                }
                eg.this.h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(int i3, boolean z16);
    }

    public eg(View view, int i3, b bVar) {
        this.f307715b = i3;
        this.f307717d = view;
        this.f307718e = bVar;
        l();
    }

    public static int i(int i3) {
        if (i3 == 0) {
            return com.tencent.mobileqq.util.x.c(BaseApplication.getContext(), 210.0f);
        }
        if (f307713g == 0) {
            f307713g = j();
        }
        int i16 = f307713g;
        if (i3 > i16) {
            return i16;
        }
        return i3;
    }

    private static int j() {
        double d16;
        BaseApplication context = BaseApplication.getContext();
        if (SystemBarTintManager.hasNavBar(context)) {
            d16 = SystemBarTintManager.getNavigationBarHeight(context) + context.getResources().getDisplayMetrics().heightPixels;
        } else {
            d16 = context.getResources().getDisplayMetrics().heightPixels;
        }
        int i3 = (int) (d16 * 0.4d);
        if (QLog.isColorLevel()) {
            QLog.d("SoftKeyboardHeight", 2, "getMaxEmotionPanelHeight, max keyboard height:", Integer.valueOf(i3));
        }
        return i3;
    }

    private void l() {
        this.f307719f = new a();
    }

    public void h() {
        if (this.f307719f != null) {
            this.f307717d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f307719f);
        }
    }

    public int k() {
        int i3;
        if (QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").contains("soft_keyboard_key_height")) {
            i3 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getInt("soft_keyboard_key_height", 0);
            this.f307718e.a(i3, true);
        } else {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_soft_keyboard", 0);
            if (sharedPreferences.contains(QQFilterConstants.FilterParameters.KEY_HEIGHT)) {
                int i16 = sharedPreferences.getInt(QQFilterConstants.FilterParameters.KEY_HEIGHT, 0);
                this.f307718e.a(i16, true);
                sharedPreferences.edit().remove(QQFilterConstants.FilterParameters.KEY_HEIGHT).apply();
                QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putInt("soft_keyboard_key_height", i16);
                i3 = i16;
            } else {
                i3 = 0;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoftKeyboardHeight", 2, "getSoftKeyboardHeight, keyboard height:", Integer.valueOf(i3));
        }
        this.f307717d.getViewTreeObserver().addOnGlobalLayoutListener(this.f307719f);
        return i3;
    }
}
