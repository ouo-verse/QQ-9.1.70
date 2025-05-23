package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.onlinestatus.aw;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class bt {

    /* renamed from: a, reason: collision with root package name */
    private OnlineStatusPanel f255656a;

    /* renamed from: b, reason: collision with root package name */
    private ba f255657b;

    /* renamed from: c, reason: collision with root package name */
    EmoticonPagerRadioGroup f255658c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void c(au auVar, View view);
    }

    public bt(@NonNull Context context, @NonNull ViewGroup viewGroup, aw.a aVar, ba baVar, OnlineStatusPanel.a aVar2) {
        OnlineStatusPanel onlineStatusPanel = (OnlineStatusPanel) View.inflate(context, R.layout.f167786lr, null);
        this.f255656a = onlineStatusPanel;
        this.f255658c = (EmoticonPagerRadioGroup) onlineStatusPanel.findViewById(R.id.d_j);
        this.f255657b = baVar;
        this.f255656a.setListener(aVar2);
        this.f255656a.g(baVar);
        this.f255656a.f255350e.k(aVar);
        viewGroup.addView(this.f255656a);
        g();
    }

    private void k() {
        int i3;
        ba baVar = this.f255657b;
        if (baVar.f255576o) {
            if (baVar.f255577p) {
                i3 = R.drawable.f161168k61;
            } else {
                i3 = R.drawable.f161167k60;
            }
        } else {
            i3 = R.drawable.k5z;
        }
        this.f255658c.setIndicatorDrawable(i3);
    }

    public void a(boolean z16) {
        if (!z16) {
            this.f255656a.m();
        } else {
            k();
            this.f255656a.l();
        }
    }

    public void b() {
        OnlineStatusPanel onlineStatusPanel = this.f255656a;
        QQViewPager qQViewPager = onlineStatusPanel.f255349d;
        boolean z16 = true;
        if (onlineStatusPanel.f255350e.getF373114d() <= 1) {
            z16 = false;
        }
        qQViewPager.disableGesture(z16);
    }

    public au c() {
        if (this.f255656a.f255350e.f255553i.size() <= 0) {
            return null;
        }
        return this.f255656a.f255350e.f255553i.get(0);
    }

    public OnlineStatusPanel d() {
        return this.f255656a;
    }

    public ArrayList<au> e() {
        return this.f255656a.f255350e.f255553i;
    }

    public void f() {
        this.f255656a.k();
    }

    public void g() {
        if (!this.f255657b.f255576o) {
            return;
        }
        j();
    }

    public void h(AppRuntime.Status status, long j3) {
        i(status, j3, null);
    }

    public void i(AppRuntime.Status status, long j3, a aVar) {
        au I = af.C().I(status, j3);
        if ((this.f255656a.f255350e.f255553i.isEmpty() || !OnlineStatusListLayout.h(I, this.f255656a.f255350e.f255553i.get(0))) && I != null) {
            this.f255656a.f255350e.f255553i.clear();
            this.f255656a.f255350e.f255553i.add(I);
            this.f255656a.f255350e.n();
            if (aVar != null) {
                au auVar = new au(status);
                auVar.f255489b = j3;
                aVar.c(auVar, null);
            }
        }
    }

    public void j() {
        k();
        this.f255656a.o();
    }

    public void l() {
        this.f255656a.f();
    }

    public void m(boolean z16, AppRuntime.Status status, long j3) {
        au I = af.C().I(status, j3);
        if (I != null) {
            this.f255656a.f255350e.f255553i.clear();
            this.f255656a.f255350e.f255553i.add(I);
        }
        this.f255656a.p(z16);
    }
}
