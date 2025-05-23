package com.tencent.mobileqq.guild.feed.partpanel.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.quickAt.ui.GuildAtPanelTouchController;
import com.tencent.mobileqq.guild.feed.partpanel.ui.c;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d implements GuildAtPanelTouchController.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f222676a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<InputMethodManager> f222677b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f222678c;

    /* renamed from: d, reason: collision with root package name */
    protected f f222679d;

    /* renamed from: e, reason: collision with root package name */
    protected c f222680e;

    /* renamed from: f, reason: collision with root package name */
    protected int f222681f;

    /* renamed from: g, reason: collision with root package name */
    private int f222682g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f222683h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f222684i;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    interface a {
        View a(Context context, c cVar);
    }

    public d(@NonNull Context context) {
        this(context, new c());
    }

    private int f() {
        int count = this.f222679d.c().getAdapter().getCount() * this.f222680e.f222654a.f222662a;
        c.b bVar = this.f222680e.f222654a;
        return count + bVar.f222663b + bVar.f222665d;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.GuildAtPanelTouchController.a
    public boolean a(int i3) {
        if (this.f222679d.c() != null) {
            return !r0.canScrollVertically(i3);
        }
        return false;
    }

    public int b(View view, int i3) {
        int f16 = f();
        c.b bVar = this.f222680e.f222654a;
        int i16 = (i3 - bVar.f222663b) - bVar.f222664c;
        QLog.d("GuildPartPanelUIHelper", 1, "calculateStatus|maxListHeight=" + i16 + " windowHeight=" + i3 + " listHeight=" + f16);
        if (f16 < i16) {
            return 1;
        }
        return 2;
    }

    public int c(boolean z16, int i3, int i16) {
        if (z16) {
            return i16 - i3;
        }
        return this.f222680e.f222654a.f222664c;
    }

    public int d(boolean z16, int i3) {
        if (this.f222676a) {
            if (z16) {
                int f16 = f();
                this.f222681f = Math.min(i3 - this.f222680e.f222654a.f222672k, f16);
                QLog.i("GuildPartPanelUIHelper", 1, "visualHeight: " + this.f222681f + ", usableWindowHeight: " + i3 + ", listHeight: " + f16);
                if (i3 != -1) {
                    this.f222681f = Math.min(i3, this.f222681f);
                }
            } else {
                this.f222681f = this.f222679d.c().getHeight();
            }
        }
        return this.f222681f;
    }

    public int e(boolean z16) {
        if (this.f222676a) {
            if (z16) {
                this.f222682g = bv.a(this.f222678c);
            } else {
                this.f222682g = -1;
            }
        }
        return this.f222682g;
    }

    public a g() {
        return this.f222679d;
    }

    public c h() {
        return this.f222680e;
    }

    public View i() {
        return this.f222679d.d();
    }

    @NonNull
    public Rect j(@NonNull View view) {
        view.getLocationInWindow(this.f222683h);
        int[] iArr = this.f222683h;
        int i3 = iArr[0];
        int i16 = iArr[1];
        if (AppSetting.t(view.getContext())) {
            this.f222684i.set(i3, 0, view.getWidth() + i3, i16);
        } else {
            this.f222684i.set(0, 0, view.getWidth(), i16);
        }
        return this.f222684i;
    }

    public void k() {
        InputMethodManager inputMethodManager;
        WeakReference<InputMethodManager> weakReference = this.f222677b;
        if (weakReference != null && weakReference.get() != null) {
            inputMethodManager = this.f222677b.get();
        } else {
            inputMethodManager = (InputMethodManager) this.f222678c.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            this.f222677b = new WeakReference<>(inputMethodManager);
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(i().getWindowToken(), 0);
        }
    }

    public void l(boolean z16) {
        this.f222676a = z16 | this.f222676a;
    }

    d(@NonNull Context context, @NonNull c cVar) {
        this.f222676a = true;
        this.f222681f = -1;
        this.f222682g = 0;
        this.f222683h = new int[2];
        this.f222684i = new Rect();
        this.f222679d = new f();
        this.f222678c = context;
        this.f222680e = cVar;
    }
}
