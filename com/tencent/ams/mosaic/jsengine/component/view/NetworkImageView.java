package com.tencent.ams.mosaic.jsengine.component.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class NetworkImageView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private f.c f71415d;

    /* renamed from: e, reason: collision with root package name */
    private String f71416e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f71417a;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetworkImageView.this, (Object) str);
            } else {
                this.f71417a = str;
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            if (!TextUtils.equals(this.f71417a, NetworkImageView.this.f71416e)) {
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("NetworkImageView", "onLoadFinish: " + this.f71417a + ", object: " + obj);
            if (obj instanceof Bitmap) {
                NetworkImageView.this.h((Bitmap) obj);
                return;
            }
            if (obj instanceof Drawable) {
                NetworkImageView.this.i((Drawable) obj);
            } else if (obj instanceof com.tencent.ams.mosaic.jsengine.component.image.drawable.a) {
                NetworkImageView.this.i(((com.tencent.ams.mosaic.jsengine.component.image.drawable.a) obj).getDrawable());
            } else {
                com.tencent.ams.mosaic.utils.f.h("NetworkImageView", "onLoadFinish: not an image, please check, object: " + obj);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("NetworkImageView", "onLoadStart: " + this.f71417a);
        }
    }

    public NetworkImageView(Context context) {
        this(context, f.k().j());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Bitmap bitmap) {
        if (bitmap != null) {
            setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Drawable drawable) {
        setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final Bitmap bitmap) {
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.view.a
            @Override // java.lang.Runnable
            public final void run() {
                NetworkImageView.this.f(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final Drawable drawable) {
        if (drawable != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkImageView.this.g(drawable);
                }
            });
        }
    }

    public void setImageLoader(@NonNull f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f71415d = cVar;
        }
    }

    public void setSrc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f71416e = str;
            this.f71415d.loadImage(str, new a(str));
        }
    }

    public NetworkImageView(Context context, @NonNull f.c cVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f71415d = cVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) cVar);
        }
    }
}
