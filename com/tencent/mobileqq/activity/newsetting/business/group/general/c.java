package com.tencent.mobileqq.activity.newsetting.business.group.general;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mobileqq.widget.listitem.x;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private a f183612e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183613f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends v {
        static IPatchRedirector $redirector_;

        /* renamed from: l, reason: collision with root package name */
        private ModeChoiceViewContainer f183614l;

        public a(int i3, QQAppInterface qQAppInterface, QBaseActivity qBaseActivity, c cVar) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), qQAppInterface, qBaseActivity, cVar);
            } else {
                this.f183614l = new ModeChoiceViewContainer(qQAppInterface, qBaseActivity, cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.v, com.tencent.mobileqq.widget.listitem.w
        @NonNull
        public View H(@NonNull ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
            }
            View v3 = this.f183614l.v();
            v3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return v3;
        }

        public ModeChoiceViewContainer J() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ModeChoiceViewContainer) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f183614l;
        }
    }

    public c(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private QQAppInterface j() {
        AppRuntime appRuntime = k().getAppRuntime();
        if (!(appRuntime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) appRuntime;
    }

    private QBaseActivity k() {
        Context e16 = e();
        if (!(e16 instanceof QBaseActivity)) {
            return null;
        }
        return (QBaseActivity) e16;
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    protected Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        this.f183613f = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.f171054wm2), R.drawable.qui_teenager), new x.c.g("", true, false), f());
        if (!ModeChoiceViewContainer.I(j())) {
            a aVar = new a(0, j(), k(), this);
            this.f183612e = aVar;
            arrayList.add(aVar);
        }
        arrayList.add(this.f183613f);
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return new Group(aVarArr);
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183613f;
    }

    public a m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183612e;
    }
}
