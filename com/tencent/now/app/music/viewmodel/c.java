package com.tencent.now.app.music.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import cm3.a;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.view.MusicSettingView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements ThreadCenter.HandlerKeyable {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f338081d;

    /* renamed from: e, reason: collision with root package name */
    bm3.b f338082e;

    /* renamed from: f, reason: collision with root package name */
    MusicItem f338083f;

    /* renamed from: h, reason: collision with root package name */
    private MusicSettingView f338084h;

    /* renamed from: i, reason: collision with root package name */
    private int f338085i = 0;

    public c(Context context, MusicSettingView musicSettingView) {
        this.f338084h = musicSettingView;
    }

    private static ApngOptions b(int i3) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(i3);
        apngOptions.setUseCache(true);
        return apngOptions;
    }

    private void e(int i3) {
        this.f338084h.f338064e.setPadding(0, 0, 0, 0);
        if (i3 == 0) {
            this.f338084h.f338064e.setImageResource(R.drawable.mof);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(DialogInterface dialogInterface) {
        this.f338082e = null;
    }

    private void j(boolean z16) {
        if (z16) {
            this.f338084h.f338064e.setVisibility(8);
            this.f338084h.f338065f.setVisibility(0);
            this.f338084h.f338066h.setVisibility(8);
            return;
        }
        if (this.f338081d.b() != 1) {
            this.f338084h.f338064e.setVisibility(0);
        }
        this.f338084h.f338065f.setVisibility(8);
        bm3.b bVar = this.f338082e;
        if (bVar != null) {
            bVar.dismiss();
            this.f338082e = null;
        }
    }

    public void c() {
        Log.i("MusicSettingViewModel", "controlVisibleClick");
        bm3.b f16 = bm3.b.f();
        this.f338082e = f16;
        if (f16 != null) {
            f16.a(new a.InterfaceC0204a() { // from class: com.tencent.now.app.music.viewmodel.b
                @Override // cm3.a.InterfaceC0204a
                public final void onDismiss(DialogInterface dialogInterface) {
                    c.this.f(dialogInterface);
                }
            });
        }
    }

    public void d() {
        bm3.b bVar = this.f338082e;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void g() {
        j(true);
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(c.class.getName(), "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLBGU74PzYgSS2diauatEyw7ydmmOk6N66XLS3n6VHnz51A/", b(-1));
        this.f338084h.f338065f.setBackground(new ColorDrawable(0));
        this.f338084h.f338065f.setImageDrawable(apngURLDrawable);
    }

    public void h(int i3) {
        this.f338085i = i3;
        bm3.b bVar = this.f338082e;
        if (bVar != null) {
            bVar.b().e(i3);
        }
        e(i3);
    }

    public void i(com.tencent.now.app.music.controller.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f338081d = bVar;
        bm3.b bVar2 = this.f338082e;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
        e(this.f338081d.b());
    }

    public void k() {
        j(false);
    }

    public void l() {
        ThreadCenter.clear(this);
    }

    public void m(float f16) {
        if (f16 < 1.0f) {
            k();
            this.f338084h.f338066h.setVisibility(0);
            this.f338084h.f338066h.b(f16);
            d();
            return;
        }
        this.f338084h.f338066h.setVisibility(8);
    }

    public void n(MusicItem musicItem) {
        if (musicItem == null) {
            return;
        }
        this.f338083f = musicItem;
        bm3.b bVar = this.f338082e;
        if (bVar != null) {
            bVar.g(musicItem);
        }
    }
}
