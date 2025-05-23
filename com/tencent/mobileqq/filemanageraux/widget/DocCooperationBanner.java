package com.tencent.mobileqq.filemanageraux.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import mqq.app.MobileQQ;
import ta1.l;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DocCooperationBanner implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public static final DownloadParams.DecodeHandler F;
    private RelativeLayout C;
    private ObjectAnimator D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    public View f209681d;

    /* renamed from: e, reason: collision with root package name */
    l f209682e;

    /* renamed from: f, reason: collision with root package name */
    TeamWorkFileImportInfo f209683f;

    /* renamed from: h, reason: collision with root package name */
    String f209684h;

    /* renamed from: i, reason: collision with root package name */
    private final Activity f209685i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f209686m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner$3, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f209687d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f209688e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f209689f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f209690h;

        AnonymousClass3(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, boolean z16, String str2) {
            this.f209687d = teamWorkFileImportInfo;
            this.f209688e = str;
            this.f209689f = z16;
            this.f209690h = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DocCooperationBanner.this, teamWorkFileImportInfo, str, Boolean.valueOf(z16), str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Object obj) {
            if (obj != null) {
                QLog.i("DocCooperationBanner", 2, obj.toString());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TeamWorkFileImportInfo teamWorkFileImportInfo = this.f209687d;
            if (teamWorkFileImportInfo.f292070d == 0) {
                str2 = teamWorkFileImportInfo.f292072e;
                str = "";
            } else {
                str = teamWorkFileImportInfo.f292072e;
                str2 = "";
            }
            String str3 = teamWorkFileImportInfo.f292074f;
            String str4 = this.f209688e;
            if (!this.f209689f) {
                i3 = 1;
            }
            TeamWorkHandlerUtils.p(str3, str4, i3, str, str2, this.f209690h, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.filemanageraux.widget.b
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    DocCooperationBanner.AnonymousClass3.b(obj);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "mRoundCornerDecoder---------------");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return BaseImageUtil.getRoundedCornerBitmap2(bitmap, iArr[2], iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocCooperationBanner.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                DocCooperationBanner.this.f209681d.setVisibility(8);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            F = new a();
        }
    }

    void a() {
        if (this.f209683f == null) {
            return;
        }
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (!iTeamWorkFileImportHandler.isFileImporting(this.f209683f)) {
            lr2.a.k(this.f209683f.X + "-" + this.f209683f.J);
            TeamWorkFileImportInfo teamWorkFileImportInfo = this.f209683f;
            teamWorkFileImportInfo.Y = 0;
            iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (z16) {
            if (this.E) {
                ObjectAnimator objectAnimator = this.D;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                this.E = false;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f209681d, "translationY", r4.getHeight());
                this.D = ofFloat;
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                this.D.addListener(new b());
                this.D.setDuration(180L);
                this.D.start();
                return;
            }
            return;
        }
        this.E = false;
        this.f209681d.setVisibility(8);
    }

    public void c(String str, TeamWorkFileImportInfo teamWorkFileImportInfo, boolean z16, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, teamWorkFileImportInfo, Boolean.valueOf(z16), str2);
            return;
        }
        if (!TextUtils.isEmpty(str) && teamWorkFileImportInfo != null) {
            new StringBuilder(str);
            if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
                str3 = str + "&adtag=s_qq_file_inviteedit";
            } else {
                str3 = str + "?adtag=s_qq_file_inviteedit";
            }
            if (z16) {
                f(str3, teamWorkFileImportInfo, str2);
            }
            lr2.a.j(null, "0X800A637");
            Bundle bundle = new Bundle();
            bundle.putString("url", str3);
            bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
            bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(this.f209685i, bundle, false);
        }
    }

    void d(boolean z16, int i3) {
        String str;
        l c16 = TencentDocLocalCooperationProcessor.c();
        if (z16) {
            str = c16.f435705h;
        } else {
            str = c16.f435707m;
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            int i16 = 1;
            if (i3 != 1 && i3 != 3000) {
                i16 = i3 == 0 ? 0 : 3;
            }
            ReportController.o(null, "dc00898", "", "", str2, str2, i16, 0, "", "", "", "");
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (this.f209682e != null && this.f209683f != null) {
            if (z16) {
                if (!this.E) {
                    ObjectAnimator objectAnimator = this.D;
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                    }
                    this.E = true;
                    this.f209681d.setVisibility(0);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f209681d, "translationY", 0.0f);
                    this.D = ofFloat;
                    ofFloat.setDuration(180L);
                    this.D.setInterpolator(new AccelerateDecelerateInterpolator());
                    this.D.start();
                    return;
                }
                return;
            }
            this.E = true;
            this.f209681d.setVisibility(0);
        }
    }

    void f(String str, TeamWorkFileImportInfo teamWorkFileImportInfo, String str2) {
        boolean b16 = TencentDocLocalCooperationProcessor.c().b(teamWorkFileImportInfo.f292074f);
        StringBuilder sb5 = new StringBuilder(this.f209685i.getString(R.string.zsp));
        int i3 = teamWorkFileImportInfo.f292070d;
        if (i3 != 1 && i3 != 3000) {
            if (i3 == 0) {
                sb5.append(this.f209685i.getString(R.string.zzf));
            }
        } else {
            sb5.append(this.f209685i.getString(R.string.zzj));
        }
        if (b16) {
            sb5.append(this.f209685i.getString(R.string.zzi));
        } else {
            sb5.append(this.f209685i.getString(R.string.zzo));
        }
        QQToast.makeText(this.f209685i, 2, sb5.toString(), 1).show();
        ThreadManagerV2.excute(new AnonymousClass3(teamWorkFileImportInfo, str, b16, str2), 128, null, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            boolean z16 = false;
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                Activity activity = this.f209685i;
                QQToast.makeText(activity, activity.getString(R.string.zst), 0).show();
            } else {
                if (this.f209686m.getVisibility() == 0) {
                    a();
                    z16 = true;
                } else if (this.C.getVisibility() == 0) {
                    c(this.f209684h, this.f209683f, false, "");
                }
                TeamWorkFileImportInfo teamWorkFileImportInfo = this.f209683f;
                if (teamWorkFileImportInfo != null) {
                    d(z16, teamWorkFileImportInfo.f292070d);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
