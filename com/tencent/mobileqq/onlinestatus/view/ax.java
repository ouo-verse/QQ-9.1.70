package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Long, v> f256528a = new HashMap<>(4);

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Long, WeakReference<BaseStatusCardViewFragment>> f256529b = new HashMap<>(4);

    private BaseStatusCardViewFragment c(QBaseActivity qBaseActivity, OnLineStatusBlurBg onLineStatusBlurBg, BaseStatusCardViewFragment.a aVar, long j3) {
        BaseStatusCardViewFragment baseStatusCardViewFragment;
        WeakReference<BaseStatusCardViewFragment> weakReference = this.f256529b.get(Long.valueOf(j3));
        if (weakReference != null) {
            baseStatusCardViewFragment = weakReference.get();
        } else {
            baseStatusCardViewFragment = null;
        }
        if (baseStatusCardViewFragment == null && (baseStatusCardViewFragment = aw.c(qBaseActivity, onLineStatusBlurBg, aVar, j3)) != null) {
            this.f256529b.put(Long.valueOf(j3), new WeakReference<>(baseStatusCardViewFragment));
        }
        return baseStatusCardViewFragment;
    }

    public void a() {
        this.f256528a.clear();
        this.f256529b.clear();
    }

    public void b() {
        try {
            Iterator<v> it = this.f256528a.values().iterator();
            while (it.hasNext()) {
                it.next().P();
            }
            Iterator<WeakReference<BaseStatusCardViewFragment>> it5 = this.f256529b.values().iterator();
            while (it5.hasNext()) {
                BaseStatusCardViewFragment baseStatusCardViewFragment = it5.next().get();
                if (baseStatusCardViewFragment != null) {
                    baseStatusCardViewFragment.uh();
                }
            }
        } catch (Exception e16) {
            QLog.e("StatusCardViewHolder", 1, "dismissRecursive: failed. ", e16);
        }
    }

    float[] d(View view) {
        float[] fArr = new float[2];
        if (view == null) {
            fArr[0] = 0.5f;
            fArr[1] = 0.5f;
            return fArr;
        }
        int i3 = view.getResources().getDisplayMetrics().widthPixels;
        int i16 = view.getResources().getDisplayMetrics().heightPixels;
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(new int[2]);
        fArr[0] = ((width / 2.0f) + r0[0]) / i3;
        fArr[1] = ((height / 2.0f) + r0[1]) / i16;
        return fArr;
    }

    public boolean e(long j3, int i3, Intent intent) {
        QLog.d("StatusCardViewHolder", 1, "onActivityResult: requestCode= ", Long.valueOf(j3), " responseCode=", Integer.valueOf(i3));
        v vVar = this.f256528a.get(Long.valueOf(j3));
        if (vVar == null) {
            return false;
        }
        vVar.S((int) j3, i3, intent);
        return true;
    }

    public boolean f(View view, QBaseActivity qBaseActivity, OnLineStatusBlurBg.a aVar, OnLineStatusBlurBg onLineStatusBlurBg, v.a aVar2, BaseStatusCardViewFragment.a aVar3, long j3, int i3) {
        QLog.d("StatusCardViewHolder", 1, "showStatusCardView: id= ", Long.valueOf(j3));
        long a16 = aw.a(j3);
        v vVar = this.f256528a.get(Long.valueOf(a16));
        if (vVar == null) {
            vVar = aw.b(qBaseActivity, onLineStatusBlurBg, aVar2, a16);
        }
        if (vVar != null) {
            vVar.U(d(view));
            vVar.W();
            this.f256528a.put(Long.valueOf(a16), vVar);
            return true;
        }
        BaseStatusCardViewFragment c16 = c(qBaseActivity, onLineStatusBlurBg, aVar3, a16);
        if (c16 == null) {
            return false;
        }
        c16.Ch(aVar);
        c16.Dh(i3);
        c16.Bh(d(view));
        c16.Eh();
        return true;
    }
}
