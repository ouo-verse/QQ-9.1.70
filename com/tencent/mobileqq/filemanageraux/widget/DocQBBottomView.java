package com.tencent.mobileqq.filemanageraux.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import ta1.l;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DocQBBottomView extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private boolean C;
    private String D;
    private boolean E;
    private boolean F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    a f209692d;

    /* renamed from: e, reason: collision with root package name */
    TeamWorkFileImportInfo f209693e;

    /* renamed from: f, reason: collision with root package name */
    private int f209694f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f209695h;

    /* renamed from: i, reason: collision with root package name */
    private URLImageView f209696i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f209697m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a();

        void b(String str);
    }

    public DocQBBottomView(Context context) {
        super(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f209694f = 0;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f168652g73, (ViewGroup) this, true);
        g();
    }

    private Drawable d() {
        Drawable drawable = getResources().getDrawable(R.drawable.f161606nc3);
        Drawable maskDrawableByColor = ThemeUtil.maskDrawableByColor(drawable, 2368548);
        if (maskDrawableByColor != null) {
            maskDrawableByColor.setAlpha(127);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, drawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, maskDrawableByColor);
        return stateListDrawable;
    }

    private String e() {
        if (this.f209693e.b()) {
            l.a a16 = TencentDocLocalCooperationProcessor.c().a(this.f209693e.f292074f);
            if (a16 != null && !TextUtils.isEmpty(a16.f435709b)) {
                return a16.f435709b;
            }
            return HardCodeUtil.qqStr(R.string.zzi);
        }
        return HardCodeUtil.qqStr(R.string.f187153t8);
    }

    private void g() {
        setOnClickListener(this);
        this.f209695h = (ImageView) findViewById(R.id.f30460oe);
        this.f209696i = (URLImageView) findViewById(R.id.f30450od);
        this.f209697m = (TextView) findViewById(R.id.f30470of);
        this.f209695h.setImageDrawable(d());
    }

    private void m() {
        this.f209695h.setVisibility(0);
        this.f209696i.setVisibility(8);
    }

    private void n() {
        a aVar = this.f209692d;
        if (aVar != null) {
            aVar.b(getContext().getString(R.string.zz_) + e());
        }
    }

    void a() {
        if (this.f209693e == null) {
            return;
        }
        ITeamWorkFileImportHandler c16 = c();
        if (!c16.isFileImporting(this.f209693e)) {
            lr2.a.k(this.f209693e.X + "-" + this.f209693e.J);
            TeamWorkFileImportInfo teamWorkFileImportInfo = this.f209693e;
            teamWorkFileImportInfo.Y = 0;
            c16.addFileImportJob(teamWorkFileImportInfo);
        }
    }

    Drawable b(int i3, String str) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface)) {
            return null;
        }
        AppInterface appInterface = (AppInterface) waitAppRuntime;
        if (i3 == 0) {
            return FaceDrawable.getFaceDrawable(appInterface, 1, str);
        }
        if (i3 == 1) {
            return FaceDrawable.getFaceDrawable(appInterface, 4, str);
        }
        if (i3 != 3000) {
            return null;
        }
        return FaceDrawable.getFaceDrawable(appInterface, 101, str);
    }

    ITeamWorkFileImportHandler c() {
        return (ITeamWorkFileImportHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
    }

    void f(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo == null) {
            return;
        }
        ITeamWorkFileImportHandler c16 = c();
        if (!c16.isFileImporting(teamWorkFileImportInfo)) {
            teamWorkFileImportInfo.Y = 0;
            c16.addFileImportJob(teamWorkFileImportInfo);
        }
        lr2.a.j(null, "0X800ABA6");
        u.i(getContext(), teamWorkFileImportInfo, null);
    }

    boolean h() {
        return NetworkUtil.isNetSupport(BaseApplication.getContext());
    }

    public void i(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) teamWorkFileImportInfo);
            return;
        }
        if (!TextUtils.isEmpty(str) && teamWorkFileImportInfo != null) {
            if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
                str2 = str + "&adtag=s_qq_file_inviteedit";
            } else {
                str2 = str + "?adtag=s_qq_file_inviteedit";
            }
            lr2.a.j(null, "0X800A637");
            Bundle bundle = new Bundle();
            bundle.putString("url", str2);
            bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
            bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(getContext(), bundle, false);
        }
    }

    void j() {
        if (!TextUtils.isEmpty(this.D) && this.f209693e != null) {
            if (this.E) {
                if (this.D.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
                    this.D += "&converFrom=qqFile";
                } else {
                    this.D += "?converFrom=qqFile";
                }
            }
            if (this.E) {
                lr2.a.j(null, "0X800ABAB");
            } else {
                lr2.a.j(null, "0X800ABAC");
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", this.D);
            bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
            bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, this.f209693e);
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(getContext(), bundle, false);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    void l(boolean z16, int i3) {
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

    void o() {
        a aVar = this.f209692d;
        if (aVar != null) {
            aVar.a();
        }
        if (this.F) {
            QQToast.makeText(getContext(), 1, e() + getContext().getString(R.string.i0t), 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                view2.performClick();
            }
            ReportController.o(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 2, 0, "", "", "", "");
            boolean z16 = false;
            if (!h()) {
                QQToast.makeText(getContext(), getContext().getString(R.string.zst), 0).show();
            } else {
                TeamWorkFileImportInfo teamWorkFileImportInfo = this.f209693e;
                if (teamWorkFileImportInfo != null) {
                    int i3 = this.f209694f;
                    if (i3 == 4) {
                        this.G = true;
                    } else if (i3 != 1 && i3 != 2) {
                        if (i3 == 3) {
                            this.F = true;
                            n();
                            u.c(this.f209693e);
                        } else if (i3 == 5) {
                            if (teamWorkFileImportInfo.b()) {
                                if (this.C) {
                                    i(this.D, this.f209693e);
                                } else {
                                    if (TencentDocLocalCooperationProcessor.c().c(this.f209693e.f292074f)) {
                                        f(this.f209693e);
                                    } else {
                                        a();
                                    }
                                    z16 = true;
                                }
                                l(z16, this.f209693e.f292070d);
                            } else if (this.f209693e.e()) {
                                if (this.C) {
                                    j();
                                } else {
                                    f(this.f209693e);
                                }
                            }
                        }
                    } else {
                        this.f209694f = 2;
                        this.F = true;
                        n();
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    void p() {
        if (this.f209693e.b() && TencentDocLocalCooperationProcessor.c().c(this.f209693e.f292074f)) {
            m();
            return;
        }
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f209693e;
        Drawable b16 = b(teamWorkFileImportInfo.f292070d, teamWorkFileImportInfo.f292072e);
        if (b16 != null) {
            this.f209695h.setVisibility(8);
            this.f209696i.setVisibility(0);
            this.f209696i.setImageDrawable(b16);
            return;
        }
        m();
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        int i16 = this.f209694f;
        if (i16 == 4) {
            if (i3 == 3) {
                this.f209694f = 5;
                if (this.G) {
                    this.G = false;
                    onClick(this);
                    a aVar = this.f209692d;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i16 == 2) {
            this.f209694f = i3;
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        onClick(this);
                        a aVar2 = this.f209692d;
                        if (aVar2 != null) {
                            aVar2.a();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.G = true;
                return;
            }
            o();
            return;
        }
        if (i3 == 3) {
            o();
        }
        this.f209694f = i3;
    }

    public void r(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, obj);
            return;
        }
        this.C = true;
        this.D = str;
        if (obj == null) {
            return;
        }
        if (obj instanceof String) {
            if (obj.equals("open")) {
                onClick(this);
            }
        } else if (obj instanceof Boolean) {
            this.E = ((Boolean) obj).booleanValue();
        }
    }

    public void setTeamWorkFileImportInfo(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamWorkFileImportInfo);
            return;
        }
        this.f209693e = teamWorkFileImportInfo;
        this.f209697m.setText(e());
        p();
    }

    public DocQBBottomView(Context context, a aVar) {
        this(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f209692d = aVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        }
    }

    public DocQBBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f209694f = 0;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f168652g73, (ViewGroup) this, true);
        g();
    }
}
