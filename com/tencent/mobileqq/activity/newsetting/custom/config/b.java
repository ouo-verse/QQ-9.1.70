package com.tencent.mobileqq.activity.newsetting.custom.config;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b;
import com.tencent.mobileqq.widget.listitem.x.c;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b<L extends x.b, R extends x.c> extends x {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name */
    public QUISingleLineListItem f183649q;

    /* renamed from: r, reason: collision with root package name */
    private WeakReference<QUIListItemAdapter> f183650r;

    /* renamed from: s, reason: collision with root package name */
    private String f183651s;

    /* renamed from: t, reason: collision with root package name */
    private QUIListItemBackgroundType f183652t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f183653u;

    /* renamed from: v, reason: collision with root package name */
    private String f183654v;

    public b(@NonNull x.b bVar, @NonNull x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
        super(bVar, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, cVar, qUIListItemAdapter);
        } else {
            this.f183653u = true;
            this.f183650r = new WeakReference<>(qUIListItemAdapter);
        }
    }

    private void Z() {
        if (this.f183650r.get() == null) {
            return;
        }
        this.f183650r.get().l0(this);
    }

    private void i0() {
        if (AppSetting.f99565y && this.f183649q != null && !TextUtils.isEmpty(this.f183654v)) {
            AccessibilityUtil.c(this.f183649q, this.f183651s, this.f183654v);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x
    /* renamed from: P */
    public void F(@NonNull QUISingleLineListItem qUISingleLineListItem, int i3, @NonNull List list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qUISingleLineListItem, Integer.valueOf(i3), list);
            return;
        }
        super.F(qUISingleLineListItem, i3, list);
        qUISingleLineListItem.setContentDescription(this.f183651s);
        QUIListItemBackgroundType qUIListItemBackgroundType = this.f183652t;
        if (qUIListItemBackgroundType != null) {
            qUISingleLineListItem.setBackgroundType(qUIListItemBackgroundType);
        }
        i0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    @NonNull
    /* renamed from: Q */
    public QUISingleLineListItem H(@NonNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUISingleLineListItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        }
        QUISingleLineListItem H = super.H(viewGroup);
        this.f183649q = H;
        return H;
    }

    public String V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (O() instanceof x.c.g) {
            return ((x.c.g) O()).getText().toString();
        }
        return "";
    }

    public boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (O() instanceof x.c.f) {
            return ((x.c.f) O()).getIsChecked();
        }
        return false;
    }

    public boolean X(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) view)).booleanValue();
        }
        if (this.f183649q == view) {
            return true;
        }
        return false;
    }

    public boolean Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f183653u;
    }

    public void a0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else if (O() instanceof x.c.f) {
            ((x.c.f) O()).f(z16);
            Z();
        }
    }

    public void b0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            if (!AppSetting.f99565y) {
                return;
            }
            this.f183654v = str;
            i0();
        }
    }

    public void c0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (!AppSetting.f99565y) {
            return;
        }
        QUISingleLineListItem qUISingleLineListItem = this.f183649q;
        if (qUISingleLineListItem != null) {
            qUISingleLineListItem.setContentDescription(str);
        }
        this.f183651s = str;
        i0();
    }

    public void d0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if (K() instanceof x.b.d) {
            ((x.b.d) K()).b(str);
            Z();
        }
    }

    public void e0(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onCheckedChangeListener);
        } else if (O() instanceof x.c.f) {
            ((x.c.f) O()).h(onCheckedChangeListener);
            Z();
        }
    }

    public void f0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else if (O() instanceof x.c.g) {
            ((x.c.g) O()).h(str);
            Z();
        }
    }

    public void g0(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onClickListener);
        } else {
            x(onClickListener);
            Z();
        }
    }

    public void h0(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        if (this.f183650r.get() == null) {
            return;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f183653u = z16;
        this.f183650r.get().m0(this, this.f183653u);
    }
}
