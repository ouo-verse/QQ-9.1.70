package com.tencent.ams.xsad.rewarded.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.xsad.rewarded.loader.c;
import com.tencent.ams.xsad.rewarded.utils.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NetworkImageView extends RoundCornerImageView implements c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private c f71868e;

    /* renamed from: f, reason: collision with root package name */
    private c.b f71869f;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.xsad.rewarded.view.NetworkImageView$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f71870d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f71871e;

        AnonymousClass1(b bVar, File file) {
            this.f71870d = bVar;
            this.f71871e = file;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NetworkImageView.this, bVar, file);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f71870d.a(this.f71871e, new b.a() { // from class: com.tencent.ams.xsad.rewarded.view.NetworkImageView.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // com.tencent.ams.xsad.rewarded.view.NetworkImageView.b.a
                    public void a(Drawable drawable) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) drawable);
                        } else {
                            DynamicUtils.runOnUiThread(new Runnable(drawable) { // from class: com.tencent.ams.xsad.rewarded.view.NetworkImageView.1.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Drawable f71873d;

                                {
                                    this.f71873d = drawable;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) C07051.this, (Object) drawable);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    Drawable drawable2 = this.f71873d;
                                    if (drawable2 != null) {
                                        NetworkImageView.this.setImageDrawable(drawable2);
                                    } else {
                                        NetworkImageView.this.setVisibility(8);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements b {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.view.NetworkImageView.b
        public void a(File file, b.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) aVar);
                return;
            }
            BitmapDrawable bitmapDrawable = null;
            if (file != null && file.exists() && file.isFile()) {
                try {
                    bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeFile(file.getAbsolutePath()));
                } catch (Throwable th5) {
                    com.tencent.ams.xsad.rewarded.utils.c.b("NetworkImageView", "decode bitmap error.", th5);
                }
                if (aVar != null) {
                    aVar.a(bitmapDrawable);
                    return;
                }
                return;
            }
            if (aVar != null) {
                aVar.a(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        public interface a {
            void a(Drawable drawable);
        }

        void a(File file, a aVar);
    }

    public NetworkImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            e(context);
        }
    }

    private void e(Context context) {
        this.f71868e = com.tencent.ams.xsad.rewarded.c.f().d();
        com.tencent.ams.xsad.rewarded.loader.b.g().h(context);
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.c.a
    public void a(c.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            com.tencent.ams.xsad.rewarded.utils.c.a("NetworkImageView", "onRequestStart");
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.c.a
    public void b(c.b bVar, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar, (Object) file);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.a("NetworkImageView", "onRequestFinish");
        b e16 = com.tencent.ams.xsad.rewarded.c.f().e();
        if (file != null && e16 != null) {
            h.a().c().execute(new AnonymousClass1(e16, file));
        } else {
            com.tencent.ams.xsad.rewarded.utils.c.e("NetworkImageView", "onRequestFinish - resFile is null");
            setVisibility(8);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.c.a
    public void c(c.b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar, (Object) str);
        } else {
            com.tencent.ams.xsad.rewarded.utils.c.a("NetworkImageView", "onRequestFailed");
            setVisibility(8);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c cVar = this.f71868e;
        if (cVar != null) {
            cVar.b(this.f71869f, this);
        }
        super.onDetachedFromWindow();
    }

    public void setImageUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.a("NetworkImageView", "setImageUrl: " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            c cVar = this.f71868e;
            if (cVar == null) {
                com.tencent.ams.xsad.rewarded.utils.c.e("NetworkImageView", "setImageUrl - mLoader is null");
                return;
            }
            c.b bVar = this.f71869f;
            if (bVar != null) {
                cVar.b(bVar, this);
            }
            c.b a16 = c.b.a(str);
            this.f71869f = a16;
            this.f71868e.a(a16, this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.e("NetworkImageView", "setImageUrl - invalid url: " + str);
    }
}
