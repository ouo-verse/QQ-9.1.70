package com.tencent.mobileqq.studymode;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ab extends s {
    static IPatchRedirector $redirector_;

    public ab(QQAppInterface qQAppInterface, QBaseActivity qBaseActivity) {
        super(qQAppInterface, qBaseActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) qBaseActivity);
        }
    }

    public static boolean p(AppRuntime appRuntime) {
        if (n.f291004a.a() || !StudyModeManager.h(appRuntime)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.studymode.s, com.tencent.mobileqq.studymode.l.a
    public void Aa(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.Aa(i3, i16);
        QLog.d("StudySwitchItem", 1, "mode change start, oldType: " + i16 + " --> targetType: " + i3);
    }

    @Override // com.tencent.mobileqq.studymode.s, com.tencent.mobileqq.studymode.l.a
    public void C6(boolean z16, @NonNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), obj);
            return;
        }
        QLog.d("StudySwitchItem", 1, "onIReqGetSimpleUISwitch, isSuc: " + z16 + ", param: " + obj);
        super.C6(z16, obj);
    }

    @Override // com.tencent.mobileqq.studymode.s, com.tencent.mobileqq.studymode.l.a
    public void W1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("StudySwitchItem", 1, "mode change recover, oldType: " + i16 + " --> targetType: " + i3);
        super.W1(i3, i16);
        f(R.string.hhx, 1);
    }

    @Override // com.tencent.mobileqq.studymode.s
    protected View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(this.f291023e);
        qUISingleLineListItem.setId(R.id.f642635r);
        return qUISingleLineListItem;
    }

    @Override // com.tencent.mobileqq.studymode.s, com.tencent.mobileqq.studymode.l.a
    public void ed(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("StudySwitchItem", 1, "mode change switching, oldType: " + i16 + " --> targetType: " + i3);
        super.ed(i3, i16);
    }

    @Override // com.tencent.mobileqq.studymode.s
    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.h();
        }
    }

    @Override // com.tencent.mobileqq.studymode.s, com.tencent.mobileqq.studymode.l.a
    public void j7(boolean z16, int i3, int i16, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        QLog.d("StudySwitchItem", 1, "mode change complete, oldType: " + i16 + " --> targetType: " + i3 + ", suc: " + z16 + ", message: " + str);
        super.j7(z16, i3, i16, str);
        if (!TextUtils.isEmpty(str)) {
            if (!z16) {
                i17 = 1;
            }
            g(str, i17);
        }
        ElderModeManager.m(z16, i3, i16, this.f291023e);
    }

    public void n() {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        int a16 = g.a();
        int i16 = 0;
        if (a16 == 2) {
            int n3 = StudyModeManager.n();
            if (n3 != -1) {
                i16 = n3;
            }
            i3 = i16;
            z16 = true;
        } else {
            z16 = false;
            i3 = 2;
        }
        JumpKidModeMgr.b().i(i3, a16, this.f291023e, 1, 1, z16);
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.studymode.s
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    public void q() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        View view = this.f291024f;
        if (view != null && view.getVisibility() == 0 && (this.f291024f instanceof QUISingleLineListItem)) {
            QBaseActivity qBaseActivity = this.f291023e;
            if (g.a() == 2) {
                i3 = R.string.f20493549;
            } else {
                i3 = R.string.f20525554;
            }
            ((QUISingleLineListItem) this.f291024f).setConfig(new x.b.C8996b(this.f291023e.getString(R.string.f170988wk0), R.drawable.qui_teenager), new x.c.g(qBaseActivity.getString(i3), true, false));
        }
    }

    @Override // com.tencent.mobileqq.studymode.s, com.tencent.mobileqq.studymode.l.a
    public void wa(boolean z16, boolean z17, boolean z18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
            return;
        }
        QLog.d("StudySwitchItem", 1, "onIReqGetSimpleUISwitch, isSuc: " + z16 + ", bChangeTheme: " + z17 + ", bSwitchElsePref: " + z18 + ", statusCode:" + i3);
        super.wa(z16, z17, z18, i3);
    }
}
