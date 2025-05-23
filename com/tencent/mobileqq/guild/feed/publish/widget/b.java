package com.tencent.mobileqq.guild.feed.publish.widget;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.GuildFeedKeyboardUtils;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class b implements s.c {
    private boolean C;
    private a D;

    /* renamed from: d, reason: collision with root package name */
    protected Context f223194d;

    /* renamed from: e, reason: collision with root package name */
    protected FrameLayout f223195e;

    /* renamed from: f, reason: collision with root package name */
    protected View f223196f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f223197h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences.Editor f223198i;

    /* renamed from: m, reason: collision with root package name */
    private int f223199m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface a {
        void cc(b bVar, boolean z16);

        boolean kh(b bVar);
    }

    public b(Context context, FrameLayout frameLayout, a aVar) {
        this.f223194d = context;
        this.f223195e = frameLayout;
        this.D = aVar;
        e();
        this.f223196f = j();
        f();
        k(this.f223199m);
        d();
    }

    private void a(int i3) {
        int i16;
        boolean b16 = b();
        if (b16) {
            i16 = DisplayUtil.getNavigationBarHeight(this.f223194d);
        } else {
            i16 = 0;
        }
        int i17 = i3 - i16;
        QLog.d("GuildFeedPublishBaseBottomPanel", 1, "onSoftKeyboardOpened hasNavBar=" + b16 + " navigationBarHeight = " + i16 + " keyboardHeightInPx = " + i17 + " preKeyboardHeightInPx = " + this.f223199m);
        if (this.f223199m != i17) {
            this.f223199m = i17;
            k(i17);
            this.f223198i.putInt("GroupSoftKeyboardHeight", i17);
            this.f223198i.commit();
        }
    }

    private boolean b() {
        if (DisplayUtil.hasNavBar(this.f223194d) && ScreenUtil.isNavigationBarExist((Activity) this.f223194d)) {
            return true;
        }
        return false;
    }

    private void e() {
        SharedPreferences sharedPreferences = this.f223194d.getSharedPreferences("weishi_comment_prefs_version", 0);
        this.f223198i = sharedPreferences.edit();
        this.f223199m = sharedPreferences.getInt("GroupSoftKeyboardHeight", cx.a(250.0f));
    }

    private void f() {
        this.f223196f.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(layoutParams.leftMargin, ScreenUtil.dip2px(44.0f), layoutParams.rightMargin, layoutParams.bottomMargin);
        this.f223195e.addView(this.f223196f, layoutParams);
        l(false);
    }

    private boolean h() {
        a aVar = this.D;
        if (aVar != null) {
            return aVar.kh(this);
        }
        return true;
    }

    private void k(int i3) {
        if (this.f223196f.getLayoutParams() != null) {
            this.f223196f.getLayoutParams().height = i3;
            this.f223196f.invalidate();
            QLog.d("GuildFeedPublishBaseBottomPanel", 1, "onGetKeyBoardHeight() :" + i3);
        }
    }

    private void l(boolean z16) {
        boolean z17;
        boolean z18;
        int i3;
        boolean z19 = true;
        if (this.f223195e.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && z16 && h()) {
            z18 = true;
        } else {
            z18 = false;
        }
        QLog.d("GuildFeedPublishBaseBottomPanel", 1, "setVisibility: visibility[" + z16 + "] needShow[" + h() + "] height[" + this.f223196f.getHeight() + "]");
        View view = this.f223196f;
        if (z18) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        a aVar = this.D;
        if (aVar != null) {
            if (g() || !z18) {
                z19 = false;
            }
            aVar.cc(this, z19);
        }
    }

    public void c() {
        l(false);
    }

    public boolean g() {
        return this.C;
    }

    public void i() {
        if (g()) {
            l(true);
        }
    }

    @NonNull
    @MainThread
    protected abstract View j();

    public void m() {
        this.f223197h = true;
        if (this.f223196f.getVisibility() == 0) {
            GuildFeedKeyboardUtils.d(this.f223194d);
        }
        l(true);
    }

    @Override // com.tencent.mobileqq.guild.window.s.c
    public void onSoftKeyboardClosed() {
        QLog.d("GuildFeedPublishBaseBottomPanel", 1, "onSoftKeyboardClosed");
        this.C = false;
        if (this.f223197h) {
            this.f223197h = false;
            l(true);
        } else {
            l(false);
        }
    }

    @Override // com.tencent.mobileqq.guild.window.s.c
    public void onSoftKeyboardOpened(int i3) {
        this.C = true;
        a(i3);
        this.f223197h = false;
        l(true);
    }

    protected void d() {
    }
}
