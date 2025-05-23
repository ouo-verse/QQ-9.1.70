package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    d f293441a = null;

    /* renamed from: b, reason: collision with root package name */
    d f293442b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        if (this.f293441a == null) {
            this.f293441a = new d();
        }
        this.f293441a.f293443a = (RelativeLayout) view.findViewById(R.id.yha);
        this.f293441a.f293444b = (RoundRectView) view.findViewById(R.id.f166038yh0);
        this.f293441a.f293445c = (TextView) view.findViewById(R.id.e7z);
        this.f293441a.f293446d = (TextView) view.findViewById(R.id.yhh);
        this.f293441a.f293447e = (RoundRectUrlImageView) view.findViewById(R.id.yh_);
        this.f293441a.f293448f = (RelativeLayout) view.findViewById(R.id.yh7);
        this.f293441a.f293449g = new a();
        if (this.f293441a.f293449g.e() != null) {
            this.f293441a.f293448f.removeAllViews();
            d dVar = this.f293441a;
            dVar.f293448f.addView(dVar.f293449g.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view) {
        if (view == null) {
            return;
        }
        if (this.f293442b == null) {
            this.f293442b = new d();
        }
        this.f293442b.f293443a = (RelativeLayout) view.findViewById(R.id.iag);
        this.f293442b.f293444b = (RoundRectView) view.findViewById(R.id.f74533wi);
        this.f293442b.f293445c = (TextView) view.findViewById(R.id.iaf);
        this.f293442b.f293446d = (TextView) view.findViewById(R.id.f74843xc);
        this.f293442b.f293447e = (RoundRectUrlImageView) view.findViewById(R.id.f74693wy);
        this.f293442b.f293448f = (RelativeLayout) view.findViewById(R.id.f74673ww);
        this.f293442b.f293449g = new a();
        if (this.f293442b.f293449g.e() != null) {
            this.f293442b.f293448f.removeAllViews();
            d dVar = this.f293442b;
            dVar.f293448f.addView(dVar.f293449g.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(tr2.c cVar, View.OnClickListener onClickListener, Context context) {
        if (cVar != null && onClickListener != null && context != null) {
            this.f293441a.f293444b.setAllRadius(ViewUtils.dpToPx(12.0f));
            this.f293441a.f293444b.setBgColor(cVar.f437181e);
            this.f293441a.f293444b.setTag(cVar);
            this.f293441a.f293444b.setOnClickListener(onClickListener);
            if (AppSetting.f99565y) {
                this.f293441a.f293444b.setContentDescription(cVar.f437179c);
            }
            this.f293441a.f293445c.setText(cVar.f437179c);
            if (cVar.f437184h) {
                this.f293441a.f293448f.setVisibility(0);
                this.f293441a.f293449g.h(cVar.f437186j);
            } else {
                this.f293441a.f293448f.setVisibility(8);
            }
            this.f293441a.f293446d.setText(cVar.c());
            this.f293441a.f293447e.setAllRadius(ViewUtils.dpToPx(12.0f));
            if (!TextUtils.isEmpty(cVar.f437182f)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = tr2.c.b(context, cVar);
                obtain.mFailedDrawable = tr2.c.b(context, cVar);
                this.f293441a.f293447e.setImageDrawable(URLDrawable.getDrawable(cVar.f437182f, obtain));
                return;
            }
            this.f293441a.f293447e.setImageResource(cVar.f437183g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(tr2.c cVar, View.OnClickListener onClickListener, Context context) {
        if (cVar != null && onClickListener != null && context != null) {
            this.f293442b.f293444b.setAllRadius(ViewUtils.dpToPx(12.0f));
            this.f293442b.f293444b.setBgColor(cVar.f437181e);
            this.f293442b.f293444b.setTag(cVar);
            this.f293442b.f293444b.setOnClickListener(onClickListener);
            if (AppSetting.f99565y) {
                this.f293442b.f293444b.setContentDescription(cVar.f437179c);
            }
            this.f293442b.f293445c.setText(cVar.f437179c);
            if (cVar.f437184h) {
                this.f293442b.f293448f.setVisibility(0);
                this.f293442b.f293449g.h(cVar.f437186j);
            } else {
                this.f293442b.f293448f.setVisibility(8);
            }
            this.f293442b.f293446d.setText(cVar.c());
            this.f293442b.f293447e.setAllRadius(ViewUtils.dpToPx(12.0f));
            if (!TextUtils.isEmpty(cVar.f437182f)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = tr2.c.b(context, cVar);
                obtain.mFailedDrawable = tr2.c.b(context, cVar);
                this.f293442b.f293447e.setImageDrawable(URLDrawable.getDrawable(cVar.f437182f, obtain));
                return;
            }
            this.f293442b.f293447e.setImageResource(cVar.f437183g);
        }
    }
}
