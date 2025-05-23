package com.tencent.qqnt.aio.menu.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.widget.BubblePopupWindow;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QQCustomMenuNoIconLayout extends LinearLayout implements com.tencent.qqnt.aio.menu.ui.a {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    protected int E;
    private boolean F;
    private Integer G;

    /* renamed from: d, reason: collision with root package name */
    private BubblePopupWindow f351543d;

    /* renamed from: e, reason: collision with root package name */
    private c f351544e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f351545f;

    /* renamed from: h, reason: collision with root package name */
    private Context f351546h;

    /* renamed from: i, reason: collision with root package name */
    private int f351547i;

    /* renamed from: m, reason: collision with root package name */
    private int f351548m;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements BubblePopupWindow.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQCustomMenuNoIconLayout.this);
            }
        }

        @Override // com.tencent.qqnt.aio.widget.BubblePopupWindow.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QQCustomMenuNoIconLayout.e(QQCustomMenuNoIconLayout.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface b {
    }

    public QQCustomMenuNoIconLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f351547i = 0;
        this.D = e.f351563b;
        this.E = ViewUtils.dip2px(8.0f);
        this.F = false;
        this.G = null;
        this.f351546h = context;
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.f351548m = ViewUtils.dip2px(62.0f);
        this.C = ViewUtils.dip2px(40.0f);
    }

    static /* bridge */ /* synthetic */ b e(QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout) {
        qQCustomMenuNoIconLayout.getClass();
        return null;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public Integer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Integer) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.G;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f351544e.d() >= this.D) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.F;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.a
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.f351543d;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.w();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.removeAllViews();
        }
    }

    public void setContainerBottom(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) num);
        } else {
            this.G = num;
        }
    }

    public void setIgnoreTouchLocation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    public void setMenu(c cVar, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) view);
            return;
        }
        this.f351544e = cVar.c();
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomMenuNoIconLayout", 4, "[menu] setMenu MENU:" + this.f351544e.toString());
        }
    }

    public void setMenuCreateOrClickCallback(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        }
    }

    public void setMenuIconClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onClickListener);
        } else {
            this.f351545f = onClickListener;
        }
    }

    public void setPopupWindow(BubblePopupWindow bubblePopupWindow, BubblePopupWindow.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bubblePopupWindow, (Object) fVar);
            return;
        }
        this.f351543d = bubblePopupWindow;
        bubblePopupWindow.r(new a());
        this.f351543d.O(fVar);
    }

    public void setTopContainer(@Nullable ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) viewGroup);
        }
    }
}
