package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseSignViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    QQAppInterface f282410g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f282411h0;

    /* renamed from: i0, reason: collision with root package name */
    public RichStatus f282412i0;

    /* renamed from: j0, reason: collision with root package name */
    public CheckBox f282413j0;

    /* renamed from: k0, reason: collision with root package name */
    public CommentsView f282414k0;

    /* renamed from: l0, reason: collision with root package name */
    public LikesView f282415l0;

    public a(Context context, AppInterface appInterface, View view, String str) {
        super(context, appInterface, view, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, view, str);
        } else {
            this.f282410g0 = (QQAppInterface) appInterface;
            this.I = 1;
        }
    }

    @Override // com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
    protected boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
    public View c(RichStatus richStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) richStatus);
        }
        return super.c(richStatus);
    }

    @Override // com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return BaseSignViewHolder.f282380f0[12];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.l();
            this.f282386e.setMinimumHeight(0);
        }
    }

    @Override // com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
    protected void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
    public void s(boolean z16) {
        int i3;
        int i16;
        Drawable drawable;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        super.s(z16);
        CommentsView commentsView = this.f282414k0;
        if (commentsView != null) {
            if (z16) {
                i17 = BaseSignViewHolder.f282380f0[14];
            } else {
                i17 = BaseSignViewHolder.f282380f0[16];
            }
            commentsView.setNormalTextColor(i17);
            CommentsView commentsView2 = this.f282414k0;
            if (z16) {
                i18 = BaseSignViewHolder.f282380f0[13];
            } else {
                i18 = BaseSignViewHolder.f282380f0[15];
            }
            commentsView2.setItemColor(i18);
        }
        LikesView likesView = this.f282415l0;
        if (likesView != null) {
            if (z16) {
                i3 = BaseSignViewHolder.f282380f0[14];
            } else {
                i3 = BaseSignViewHolder.f282380f0[15];
            }
            likesView.setNormalTextColor(i3);
            LikesView likesView2 = this.f282415l0;
            if (z16) {
                i16 = BaseSignViewHolder.f282380f0[13];
            } else {
                i16 = BaseSignViewHolder.f282380f0[15];
            }
            likesView2.setItemColor(i16);
            Drawable b16 = this.f282415l0.b();
            Context context = this.J;
            if (context != null && b16 != null) {
                LikesView likesView3 = this.f282415l0;
                if (z16) {
                    drawable = context.getResources().getDrawable(R.drawable.bho);
                } else {
                    drawable = context.getResources().getDrawable(R.drawable.d5m);
                }
                likesView3.setLikSpanDrawable(drawable);
            }
        }
    }

    @Override // com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder
    protected boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
