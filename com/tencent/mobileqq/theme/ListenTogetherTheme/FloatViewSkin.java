package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.apollo.handler.b;
import com.tencent.mobileqq.apollo.handler.c;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.f;
import com.tencent.mobileqq.theme.ListenTogetherTheme.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FloatViewSkin extends com.tencent.mobileqq.theme.ListenTogetherTheme.a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private static FloatViewSkin f292800n;

    /* renamed from: g, reason: collision with root package name */
    private String f292801g;

    /* renamed from: h, reason: collision with root package name */
    private int f292802h;

    /* renamed from: i, reason: collision with root package name */
    private View f292803i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f292804j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f292805k;

    /* renamed from: l, reason: collision with root package name */
    f f292806l;

    /* renamed from: m, reason: collision with root package name */
    BusinessObserver f292807m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatViewSkin.this);
            }
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void e(boolean z16, boolean z17, boolean z18, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
            } else if (FloatViewSkin.this.f292803i != null) {
                FloatViewSkin floatViewSkin = FloatViewSkin.this;
                floatViewSkin.s(floatViewSkin.f292803i);
            }
        }
    }

    public FloatViewSkin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f292801g = "";
        this.f292802h = 0;
        this.f292804j = false;
        this.f292805k = 0;
        this.f292806l = new a();
        this.f292807m = new c() { // from class: com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatViewSkin.this);
                }
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 36 && (obj instanceof Integer)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FloatViewSkin", 2, "mMusicBusinessObserver: isSuccess" + z16 + "  music player id:" + obj);
                    }
                    FloatViewSkin.this.f292805k = ((Integer) obj).intValue();
                    FloatViewSkin.this.t(false);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                FloatViewSkin floatViewSkin = FloatViewSkin.this;
                                floatViewSkin.s(floatViewSkin.f292803i);
                            }
                        }
                    });
                }
            }
        };
    }

    public static FloatViewSkin o() {
        if (f292800n == null) {
            synchronized (FloatViewSkin.class) {
                if (f292800n == null) {
                    f292800n = new FloatViewSkin();
                    ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).addObserver(f292800n.f292807m);
                    ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).addObserver(f292800n.f292806l);
                }
            }
        }
        return f292800n;
    }

    private void r() {
        a.InterfaceC8646a interfaceC8646a;
        WeakReference<a.InterfaceC8646a> weakReference = this.f292816f;
        if (weakReference == null) {
            interfaceC8646a = null;
        } else {
            interfaceC8646a = weakReference.get();
        }
        if (interfaceC8646a != null) {
            interfaceC8646a.c();
        }
    }

    @Override // com.tencent.mobileqq.theme.ListenTogetherTheme.a
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f292812b && this.f292813c && this.f292805k != 0) {
            return true;
        }
        return false;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        b bVar = (b) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (bVar != null) {
            bVar.W();
        }
    }

    public void n(View view, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, str, Integer.valueOf(i3));
            return;
        }
        if (view != null && !SimpleUIUtil.getSimpleUISwitch()) {
            m();
            this.f292803i = view;
            this.f292802h = i3;
            this.f292801g = str;
            if (this.f292812b) {
                s(view);
            }
            if (QLog.isColorLevel()) {
                QLog.i("FloatViewSkin", 2, "enter uin:" + this.f292801g + "  type:" + this.f292802h + " mIsUserSkin:" + this.f292812b);
            }
        }
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f292805k > 0) {
            return true;
        }
        return false;
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        View view = this.f292803i;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatViewSkin.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        FloatViewSkin floatViewSkin = FloatViewSkin.this;
                        floatViewSkin.s(floatViewSkin.f292803i);
                    }
                }
            });
        }
        this.f292803i = null;
        if (QLog.isColorLevel()) {
            QLog.i("FloatViewSkin", 2, "leave uin:" + this.f292801g + "  type:" + this.f292802h);
        }
    }

    public void s(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FloatViewSkin", 2, "setMusicBarSkin uin:" + this.f292801g + "  type:" + this.f292802h + " mIsUserSkin:" + this.f292812b);
        }
        QLog.i("FloatViewSkin", 1, "setMusicBarSkin mIsShowSkin:" + this.f292804j + "  mIsUserSkin:" + this.f292812b);
        if (view != null && this.f292804j) {
            if (SimpleUIUtil.getSimpleUISwitch()) {
                t(false);
            } else {
                t(true);
            }
            View rootView = view.getRootView();
            g(rootView, R.id.lwo, R.drawable.qq_aio_listentogether_lyrics_music_point, "qq_aio_listentogether_lyrics_music_point@3x.png");
            h(rootView, R.id.lwi, R.drawable.qq_aio_listentogether_lyrics_music_bg, "qq_aio_listentogether_lyrics_music_bg@3x.png");
            h(rootView, R.id.lws, R.drawable.qq_aio_listentogether_lyrics_music_dot, "qq_aio_listentogether_lyrics_music_dot@3x.png");
            h(rootView, R.id.azb, R.drawable.qq_aio_listentogether_lyrics_music_close, "qq_aio_listentogether_lyrics_music_close@3x.png");
        }
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else if (this.f292812b != z16) {
            this.f292812b = z16;
            r();
        }
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.f292805k = 0;
        t(false);
        j(null);
        if (this.f292803i != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FloatViewSkin.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        FloatViewSkin floatViewSkin = FloatViewSkin.this;
                        floatViewSkin.s(floatViewSkin.f292803i);
                    }
                }
            });
        }
    }

    public void v(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.f292803i = view;
        }
    }
}
