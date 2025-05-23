package com.tencent.mobileqq.activity.newsetting.custom.group;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f183655a;

    /* renamed from: b, reason: collision with root package name */
    private QUIListItemAdapter f183656b;

    /* renamed from: c, reason: collision with root package name */
    private Group f183657c;

    /* renamed from: d, reason: collision with root package name */
    private Group.b f183658d;

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f183655a = context;
        }
    }

    protected abstract Group c();

    public Group d(QUIListItemAdapter qUIListItemAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Group) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qUIListItemAdapter);
        }
        this.f183656b = qUIListItemAdapter;
        Group c16 = c();
        this.f183657c = c16;
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Context) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f183655a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QUIListItemAdapter f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f183656b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return this.f183655a.getResources().getString(i3);
    }

    public void h(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence);
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            QLog.e("AbsCustomSettingBaseGroup", 1, "[updateBottomDescription] description is empty, action return.");
            return;
        }
        Group group = this.f183657c;
        if (group == null) {
            QLog.e("AbsCustomSettingBaseGroup", 1, "[updateBottomDescription] group is null, action return.");
            return;
        }
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> a16 = group.a();
        boolean contains = a16.contains(this.f183658d);
        int size = a16.size();
        int i3 = size - 1;
        String cls = a16.get(i3).getClass().toString();
        String cls2 = Group.b.class.toString();
        if (size > 1 && cls.equals(cls2)) {
            this.f183658d = (Group.b) a16.get(a16.size() - 1);
            contains = false;
        }
        if (this.f183658d == null) {
            this.f183658d = new Group.b(charSequence, false);
        }
        if (!contains) {
            a16.add(i3, this.f183658d);
        }
        this.f183658d.F(charSequence);
        this.f183656b.n0(this.f183657c, true);
        this.f183656b.l0(this.f183658d);
    }

    public void i(boolean z16) {
        Group.b bVar;
        Group.b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        Group group = this.f183657c;
        if (group == null) {
            QLog.e("AbsCustomSettingBaseGroup", 1, "[setBottomDescriptionVisible] group is null, action return.");
            return;
        }
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> a16 = group.a();
        if (z16 && (bVar2 = this.f183658d) != null && a16.contains(bVar2)) {
            a16.remove(this.f183658d);
        } else if (!z16 && (bVar = this.f183658d) != null && a16.contains(bVar)) {
            a16.add(this.f183658d);
        }
        this.f183656b.n0(this.f183657c, true);
    }
}
