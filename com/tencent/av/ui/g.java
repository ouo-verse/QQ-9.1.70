package com.tencent.av.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.m;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<Context> f75906a;

    /* renamed from: b, reason: collision with root package name */
    VideoAppInterface f75907b;

    /* renamed from: c, reason: collision with root package name */
    ViewGroup f75908c;

    /* renamed from: d, reason: collision with root package name */
    Resources f75909d = null;

    /* renamed from: e, reason: collision with root package name */
    Button f75910e = null;

    /* renamed from: f, reason: collision with root package name */
    boolean f75911f = false;

    public g(VideoAppInterface videoAppInterface, AVActivity aVActivity, ViewGroup viewGroup) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ChildGuideUi", 2, "ChildGuideUi");
        }
        this.f75906a = new WeakReference<>(aVActivity);
        this.f75907b = videoAppInterface;
        this.f75908c = viewGroup;
    }

    public boolean a() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("com.tencent.av.count", 0);
        String str = "DoubleVideoChildLock_ShowGuide";
        if (this.f75907b != null) {
            str = "DoubleVideoChildLock_ShowGuide" + this.f75907b.getCurrentAccountUin();
        }
        if (sharedPreferences.getInt(str, 0) != 0) {
            return false;
        }
        sharedPreferences.edit().putInt(str, 1).commit();
        return true;
    }

    public void b() {
        this.f75911f = false;
        cw.e.f(this.f75907b);
        this.f75908c.setVisibility(8);
    }

    void c() {
        AVActivity aVActivity;
        if (QLog.isDevelopLevel()) {
            QLog.d("ChildGuideUi", 2, "initUI");
        }
        WeakReference<Context> weakReference = this.f75906a;
        if (weakReference != null && weakReference.get() != null && (aVActivity = (AVActivity) this.f75906a.get()) != null) {
            aVActivity.getLayoutInflater().inflate(R.layout.f168475x7, this.f75908c);
            this.f75909d = aVActivity.getResources();
        }
        this.f75910e = (Button) this.f75908c.findViewById(m.l.M);
    }

    public boolean d() {
        return this.f75911f;
    }

    public boolean e() {
        b();
        return true;
    }

    public void f() {
        b();
        this.f75906a = null;
        this.f75907b = null;
        this.f75908c = null;
        this.f75909d = null;
        this.f75910e = null;
    }

    public void g() {
        if (this.f75909d == null || this.f75910e == null) {
            c();
        }
        this.f75911f = true;
        cw.e.e(this.f75907b);
        this.f75908c.setVisibility(0);
    }

    public void onClick(View view) {
        if (view.getId() == m.l.M) {
            e();
        }
    }
}
