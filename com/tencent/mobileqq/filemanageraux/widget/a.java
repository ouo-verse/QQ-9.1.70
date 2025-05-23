package com.tencent.mobileqq.filemanageraux.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ObjectAnimator C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f209701d;

    /* renamed from: e, reason: collision with root package name */
    public View f209702e;

    /* renamed from: f, reason: collision with root package name */
    TeamWorkFileImportInfo f209703f;

    /* renamed from: h, reason: collision with root package name */
    String f209704h;

    /* renamed from: i, reason: collision with root package name */
    boolean f209705i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f209706m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanageraux.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7596a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f209707d;

        C7596a(View view) {
            this.f209707d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                this.f209707d.setVisibility(8);
            }
        }
    }

    void a(View view) {
        ObjectAnimator objectAnimator = this.C;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f);
        this.C = ofFloat;
        ofFloat.setDuration(180L);
        this.C.setInterpolator(new AccelerateDecelerateInterpolator());
        this.C.start();
    }

    void b(View view) {
        ObjectAnimator objectAnimator = this.C;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getHeight());
        this.C = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.C.addListener(new C7596a(view));
        this.C.setDuration(180L);
        this.C.start();
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (z16) {
            if (this.D) {
                this.D = false;
                b(this.f209702e);
                return;
            }
            return;
        }
        this.D = false;
        this.f209702e.setVisibility(8);
    }

    boolean d() {
        return NetworkUtil.isNetSupport(BaseApplication.getContext());
    }

    void e() {
        if (this.f209703f == null) {
            return;
        }
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (!iTeamWorkFileImportHandler.isFileImporting(this.f209703f)) {
            TeamWorkFileImportInfo teamWorkFileImportInfo = this.f209703f;
            teamWorkFileImportInfo.Y = 0;
            iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
        }
        lr2.a.j(null, "0X800ABA6");
        u.i(this.f209701d, this.f209703f, null);
    }

    void f() {
        if (!TextUtils.isEmpty(this.f209704h) && this.f209703f != null) {
            if (this.f209705i) {
                if (this.f209704h.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
                    this.f209704h += "&converFrom=qqFile";
                } else {
                    this.f209704h += "?converFrom=qqFile";
                }
            }
            if (this.f209705i) {
                lr2.a.j(null, "0X800ABAB");
            } else {
                lr2.a.j(null, "0X800ABAC");
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", this.f209704h);
            bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
            bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, this.f209703f);
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(this.f209701d, bundle, false);
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (this.f209703f == null) {
            return;
        }
        if (z16) {
            if (!this.D) {
                this.D = true;
                this.f209702e.setVisibility(0);
                a(this.f209702e);
                return;
            }
            return;
        }
        this.D = true;
        this.f209702e.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (!d()) {
            QQToast.makeText(this.f209701d, BaseApplication.getContext().getString(R.string.zst), 0).show();
        } else if (this.f209706m) {
            f();
        } else {
            e();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
