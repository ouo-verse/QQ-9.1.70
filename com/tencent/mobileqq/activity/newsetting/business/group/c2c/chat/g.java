package com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private b f183532e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends b {
        static IPatchRedirector $redirector_;

        a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, g.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> {
        static IPatchRedirector $redirector_;

        /* renamed from: w, reason: collision with root package name */
        private ImageView f183533w;

        /* renamed from: x, reason: collision with root package name */
        private Drawable f183534x;

        /* renamed from: y, reason: collision with root package name */
        private String f183535y;

        /* renamed from: z, reason: collision with root package name */
        private boolean f183536z;

        public b(@NonNull x.b bVar, @NonNull x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, cVar, qUIListItemAdapter);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.b, com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
        @NonNull
        /* renamed from: Q */
        public QUISingleLineListItem H(@NonNull ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QUISingleLineListItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
            }
            QUISingleLineListItem H = super.H(viewGroup);
            ImageView imageView = new ImageView(viewGroup.getContext());
            this.f183533w = imageView;
            H.f(imageView);
            Drawable drawable = this.f183534x;
            if (drawable != null) {
                l0(drawable, this.f183535y);
            }
            return H;
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.b
        public void h0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                if (this.f183536z) {
                    return;
                }
                super.h0(i3);
            }
        }

        public String j0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f183535y;
        }

        public void k0(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.f183536z = z16;
            }
        }

        public void l0(Drawable drawable, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) str);
                return;
            }
            ImageView imageView = this.f183533w;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            this.f183534x = drawable;
            this.f183535y = str;
        }
    }

    public g(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    public Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f183532e = new a(new x.b.d(g(R.string.f172976g92)), new x.c.g(g(R.string.hbd), true, false), f());
        return new Group(this.f183532e);
    }

    public b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183532e;
    }
}
