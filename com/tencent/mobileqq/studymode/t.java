package com.tencent.mobileqq.studymode;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DarkModeManager.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ModeChoiceViewContainer.k f291029a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f291030b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f291031c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f291032d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f291033e;

        a(ModeChoiceViewContainer.k kVar, int i3, int i16, QQAppInterface qQAppInterface, Activity activity) {
            this.f291029a = kVar;
            this.f291030b = i3;
            this.f291031c = i16;
            this.f291032d = qQAppInterface;
            this.f291033e = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, kVar, Integer.valueOf(i3), Integer.valueOf(i16), qQAppInterface, activity);
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                t.b(this.f291030b, this.f291031c, this.f291032d, this.f291033e);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ModeChoiceViewContainer.k kVar = this.f291029a;
            if (kVar != null) {
                kVar.u1();
            }
            t.b(this.f291030b, this.f291031c, this.f291032d, this.f291033e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i3, int i16, QQAppInterface qQAppInterface, Activity activity) {
        c(i3, i16, true, false, qQAppInterface, activity);
    }

    private static void c(int i3, int i16, boolean z16, boolean z17, QQAppInterface qQAppInterface, Activity activity) {
        l lVar = (l) qQAppInterface.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        boolean o16 = lVar.o();
        l.b f16 = lVar.f(activity, i3, i16, z16);
        if (f16.c()) {
            QLog.d("StudyModeHelper", 1, "changeMode switchingStatus.isSwitching : true , mode : " + f16.b());
            if (o16) {
                QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173120hi3, 0).show();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StudyModeHelper", 2, "changeMode switchingStatus.isSwitching : false , mode : " + f16.a());
        }
    }

    public static void d(int i3, QQAppInterface qQAppInterface, Activity activity, ModeChoiceViewContainer.k kVar) {
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        int e16 = r.e(qQAppInterface, z16);
        if (z16) {
            if (!DarkModeManager.w(activity, SimpleUIUtil.getThemeId(e16), new a(kVar, i3, e16, qQAppInterface, activity))) {
                b(i3, e16, qQAppInterface, activity);
                return;
            }
            return;
        }
        b(i3, e16, qQAppInterface, activity);
    }
}
