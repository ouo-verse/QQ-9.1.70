package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.home.parts.MigrationTipType;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import mqq.app.MobileQQ;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class NtMsgMigrationBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.activity.home.parts.a f185238d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnClickListener f185239e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f185240d;

        a(QBaseActivity qBaseActivity) {
            this.f185240d = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NtMsgMigrationBannerProcessor.this, (Object) qBaseActivity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                PublicFragmentActivity.start(this.f185240d, new Intent(), ChatHistorySettingFragment.class);
                NTMsgMigrationManager.X().Y0("0X800C50F");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NtMsgMigrationBannerProcessor.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NTMsgMigrationManager.X().b1();
                NTMsgMigrationManager.X().Y0("0X800C50A");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f185243a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69220);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MigrationTipType.values().length];
            f185243a = iArr;
            try {
                iArr[MigrationTipType.LowMem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f185243a[MigrationTipType.Fail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f185243a[MigrationTipType.Progress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f185243a[MigrationTipType.ProgressWithSpeedTip.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public NtMsgMigrationBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185239e = new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NtMsgMigrationBannerProcessor.this.j(view);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f185238d != null) {
            NTMsgMigrationManager.X().L0(this.f185238d);
            BannerManager.l().O(com.tencent.mobileqq.banner.d.B, 0, null);
            m();
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C4D5", "0X800C4D5", NTMsgMigrationManager.X().h0(), 0, "", "", "", "");
            int i3 = c.f185243a[this.f185238d.b().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    NTMsgMigrationManager.X().Y0("0X800C508");
                }
            } else {
                NTMsgMigrationManager.X().Y0("0X800C50D");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f185238d == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NtMsgMigrationBannerProcessor", 2, "setOnLinkTextClickListener null == tipData");
            }
        } else {
            QBaseActivity baseActivity = getBaseActivity();
            if (baseActivity != null) {
                int i3 = c.f185243a[this.f185238d.b().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 4) {
                            NTMsgMigrationManager.X().j0(baseActivity);
                            NTMsgMigrationManager.X().Y0("0X800C511");
                        }
                    } else {
                        NTMsgMigrationManager.X().c1();
                        NTMsgMigrationManager.X().Y0("0X800C507");
                    }
                } else {
                    BannerManager.l().O(com.tencent.mobileqq.banner.d.B, 0, null);
                    NTMsgMigrationManager.X().i0(baseActivity, baseActivity.getAppRuntime());
                    NTMsgMigrationManager.X().Y0("0X800C50C");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(DialogInterface dialogInterface, int i3) {
        NTMsgMigrationManager.X().Y0("0X800C50E");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(DialogInterface dialogInterface, int i3) {
        NTMsgMigrationManager.X().Y0("0X800C509");
    }

    private void m() {
        if (this.f185238d == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NtMsgMigrationBannerProcessor", 2, "null == tipData");
                return;
            }
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        int i3 = c.f185243a[this.f185238d.b().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                QQCustomDialog e16 = com.tencent.mobileqq.guild.util.qqui.c.e(baseActivity, baseActivity.getString(R.string.f171922p2), R.string.hsi, R.string.hc7, new b(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.aa
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        NtMsgMigrationBannerProcessor.l(dialogInterface, i16);
                    }
                });
                if (!e16.isShowing()) {
                    e16.show();
                    return;
                }
                return;
            }
            return;
        }
        QQCustomDialog e17 = com.tencent.mobileqq.guild.util.qqui.c.e(baseActivity, baseActivity.getString(R.string.f171912p1), R.string.hsi, R.string.f171832ot, new a(baseActivity), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                NtMsgMigrationBannerProcessor.k(dialogInterface, i16);
            }
        });
        if (!e17.isShowing()) {
            e17.show();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.banner.d.B;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        return QUINoticeBarManager.l().h(baseActivity).e(R.string.f171852ov).k(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NtMsgMigrationBannerProcessor.this.i(view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (message != null && (message.obj instanceof com.tencent.mobileqq.activity.home.parts.a) && aVar.f200243c != null) {
            com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.l().d(aVar.f200243c);
            if (d16 == null) {
                return;
            }
            com.tencent.mobileqq.activity.home.parts.a aVar2 = (com.tencent.mobileqq.activity.home.parts.a) message.obj;
            this.f185238d = aVar2;
            int i3 = c.f185243a[aVar2.b().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 || i3 == 4) {
                        String string = MobileQQ.sMobileQQ.getString(R.string.f171852ov);
                        float a16 = this.f185238d.a();
                        if (a16 != 0.0f) {
                            string = string + NTMsgMigrationManager.X().d0(a16);
                        }
                        d16.setMsg(string);
                        if (this.f185238d.b() == MigrationTipType.Progress) {
                            d16.b(null, this.f185239e);
                            return;
                        } else {
                            d16.f(R.string.f13826093, this.f185239e);
                            NTMsgMigrationManager.X().Y0("0X800C510");
                            return;
                        }
                    }
                    return;
                }
                d16.f(R.string.f172062pf, this.f185239e).e(R.string.f171962p6);
                NTMsgMigrationManager.X().Y0("0X800C506");
                return;
            }
            d16.f(R.string.f171822os, this.f185239e).e(R.string.f171932p3);
            NTMsgMigrationManager.X().Y0("0X800C50B");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NtMsgMigrationBannerProcessor", 2, "msg == null || (!(msg.obj instanceof NtMsgMigrationBannerProcessor))");
        }
    }
}
