package com.tencent.mobileqq.activity.newsetting.business.group.c2c.special;

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
public class d extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private b f183573e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends b {
        static IPatchRedirector $redirector_;

        a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.C8997c> {
        static IPatchRedirector $redirector_;

        /* renamed from: w, reason: collision with root package name */
        private ImageView f183575w;

        /* renamed from: x, reason: collision with root package name */
        private Drawable f183576x;

        public b(@NonNull x.b bVar, @NonNull x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, bVar, cVar, qUIListItemAdapter);
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
            this.f183575w = imageView;
            H.f(imageView);
            Drawable drawable = this.f183576x;
            if (drawable != null) {
                j0(drawable);
            }
            return H;
        }

        public void j0(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
                return;
            }
            ImageView imageView = this.f183575w;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            this.f183576x = drawable;
        }
    }

    public d(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    protected Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f183573e = new a(new x.b.d(g(R.string.g97)), new x.c.g("", true, false), f());
        return new Group(this.f183573e);
    }

    public b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183573e;
    }
}
