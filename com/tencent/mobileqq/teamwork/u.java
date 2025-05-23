package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUrl2DocConfigProcessor;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f292413d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f292414e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppInterface f292415f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f292416h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f292417i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ e f292418m;

        a(TeamWorkFileImportInfo teamWorkFileImportInfo, ActionSheet actionSheet, AppInterface appInterface, Context context, String str, e eVar) {
            this.f292413d = teamWorkFileImportInfo;
            this.f292414e = actionSheet;
            this.f292415f = appInterface;
            this.f292416h = context;
            this.f292417i = str;
            this.f292418m = eVar;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.f292413d.Y = 0;
                    ((ITeamWorkFileImportHandler) this.f292415f.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).removeFromConvertedMap(this.f292413d);
                    this.f292414e.dismiss();
                    AppInterface appInterface = this.f292415f;
                    TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292413d;
                    Context context = this.f292416h;
                    QQProgressDialog s16 = u.s(appInterface, teamWorkFileImportInfo, context, this.f292417i, context.getString(R.string.hyg), true);
                    e eVar = this.f292418m;
                    if (eVar != null) {
                        eVar.a(s16);
                    }
                    if (this.f292413d.c()) {
                        lr2.a.j(this.f292415f, "0X8009ED2");
                        return;
                    }
                    return;
                }
                return;
            }
            this.f292413d.Y = 2;
            this.f292414e.dismiss();
            AppInterface appInterface2 = this.f292415f;
            TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f292413d;
            Context context2 = this.f292416h;
            QQProgressDialog s17 = u.s(appInterface2, teamWorkFileImportInfo2, context2, this.f292417i, context2.getString(R.string.hyg), true);
            e eVar2 = this.f292418m;
            if (eVar2 != null) {
                eVar2.a(s17);
            }
            if (this.f292413d.c()) {
                lr2.a.j(this.f292415f, "0X8009ED1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f292419d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f292420e;

        b(Context context, String str) {
            this.f292419d = context;
            this.f292420e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).fileManagerUtilOpenUrl(this.f292419d, TencentDocConvertConfigProcessor.a().a());
            } catch (Exception e16) {
                QLog.i(this.f292420e, 1, e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f292421d;

        c(QQCustomDialog qQCustomDialog) {
            this.f292421d = qQCustomDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (this.f292421d.isShowing()) {
                this.f292421d.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(TeamWorkFileImportInfo teamWorkFileImportInfo);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void a(QQProgressDialog qQProgressDialog);
    }

    public static boolean a(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            return true;
        }
        return false;
    }

    public static boolean b(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(CoverDBCacheData.URLS);
        if (optJSONArray == null) {
            optString = null;
        } else {
            optString = optJSONArray.optString(0);
        }
        return a(optString, jSONObject.optString("filename"), jSONObject.optString("cookie"), jSONObject.optString("filetype"), jSONObject.optString(QCircleSchemeAttr.Detail.FEED_VIDEO_ID));
    }

    public static void c(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        AppInterface appInterface;
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null || (iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())) == null) {
            return;
        }
        teamWorkFileImportInfo.Y = 1;
        iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
    }

    public static boolean d(FileManagerEntity fileManagerEntity, Context context, AppInterface appInterface, int i3, int i16) {
        if (fileManagerEntity == null) {
            return false;
        }
        TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
        teamWorkFileImportInfo.f292077h = fileManagerEntity.getFilePath();
        teamWorkFileImportInfo.f292074f = fileManagerEntity.fileName;
        teamWorkFileImportInfo.R = fileManagerEntity.nFileType;
        teamWorkFileImportInfo.K = true;
        teamWorkFileImportInfo.J = i3;
        teamWorkFileImportInfo.f292078h0 = fileManagerEntity.fileSize;
        teamWorkFileImportInfo.E = i16;
        if (i3 == 6) {
            teamWorkFileImportInfo.K = false;
            teamWorkFileImportInfo.L = true;
        }
        teamWorkFileImportInfo.f292070d = fileManagerEntity.peerType;
        teamWorkFileImportInfo.f292072e = fileManagerEntity.peerUin;
        teamWorkFileImportInfo.F = String.valueOf(fileManagerEntity.TroopUin);
        teamWorkFileImportInfo.D = fileManagerEntity.busId;
        teamWorkFileImportInfo.C = fileManagerEntity.strTroopFilePath;
        teamWorkFileImportInfo.f292079i = fileManagerEntity.uniseq;
        if (fileManagerEntity.status != 16) {
            teamWorkFileImportInfo.I = true;
        }
        return e(teamWorkFileImportInfo, context, appInterface, i3);
    }

    public static boolean e(TeamWorkFileImportInfo teamWorkFileImportInfo, Context context, AppInterface appInterface, int i3) {
        String str;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.u0s), 1).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return false;
        }
        if (i3 == 9) {
            teamWorkFileImportInfo.J = i3;
        }
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (!TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo))) {
            str = iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo);
        } else {
            str = null;
        }
        if (!iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo)) {
            iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
        }
        if (!teamWorkFileImportInfo.a()) {
            i(context, teamWorkFileImportInfo, str);
        }
        return true;
    }

    public static boolean f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
        if (str2 == null) {
            str2 = "";
        }
        teamWorkFileImportInfo.f292074f = str2;
        teamWorkFileImportInfo.G = str;
        teamWorkFileImportInfo.H = SystemClock.elapsedRealtime();
        teamWorkFileImportInfo.I = true;
        teamWorkFileImportInfo.J = 12;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            e(teamWorkFileImportInfo, BaseApplication.getContext(), (AppInterface) peekAppRuntime, teamWorkFileImportInfo.J);
        } else {
            Bundle bundle = new Bundle();
            bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).sendServiceIpcReq(bundle);
        }
        return true;
    }

    public static void g(AppInterface appInterface, Context context, String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        teamWorkFileImportInfo.Y = 0;
        ((ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).removeFromConvertedMap(teamWorkFileImportInfo);
        s(appInterface, teamWorkFileImportInfo, context, str, context.getString(R.string.hyg), true);
    }

    public static String h(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo.f292070d == 1) {
            return teamWorkFileImportInfo.C;
        }
        return teamWorkFileImportInfo.f292073e0;
    }

    public static void i(Context context, TeamWorkFileImportInfo teamWorkFileImportInfo, String str) {
        int i3;
        Map<Integer, String> map;
        Intent classIntent = ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).getClassIntent(context);
        if (classIntent == null) {
            return;
        }
        classIntent.putExtra(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
        boolean z16 = true;
        classIntent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
        classIntent.putExtra(ITeamWorkDocEditBrowserProxy.KEY_TEMP_SHOW_LOADING, true);
        boolean z17 = false;
        if (teamWorkFileImportInfo != null) {
            int i16 = teamWorkFileImportInfo.J;
            if (i16 == 1) {
                classIntent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_AIO_EDIT);
            } else {
                if (i16 == 5) {
                    classIntent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_FILE_SHARE_EDIT);
                } else if (teamWorkFileImportInfo.c()) {
                    classIntent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_ONLINE_PREVIEW);
                } else {
                    classIntent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT);
                }
                map = ITeamWorkUtils.ENTRANCE_TO_AD_TAG_MAP;
                if (map != null && map.containsKey(Integer.valueOf(teamWorkFileImportInfo.J))) {
                    classIntent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, map.get(Integer.valueOf(teamWorkFileImportInfo.J)));
                }
                z17 = z16;
            }
            z16 = false;
            map = ITeamWorkUtils.ENTRANCE_TO_AD_TAG_MAP;
            if (map != null) {
                classIntent.putExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, map.get(Integer.valueOf(teamWorkFileImportInfo.J)));
            }
            z17 = z16;
        }
        ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).getOpenTeamWorkIntent(classIntent, null, context);
        boolean z18 = context instanceof Activity;
        if (z18) {
            i3 = 536870912;
        } else {
            i3 = 268435456;
        }
        classIntent.addFlags(i3);
        if (z18 && z17 && l(classIntent.getStringExtra(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG))) {
            ((Activity) context).startActivityForResult(classIntent, ITeamWorkDocEditBrowserProxy.REQUEST_CODE_OPEN_TEAM_WORK_MINI_PROGRAM);
        } else {
            context.startActivity(classIntent);
        }
    }

    public static QQProgressDialog j(AppInterface appInterface, Context context, String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (context != null && iTeamWorkFileImportHandler != null && teamWorkFileImportInfo != null && teamWorkFileImportInfo.f292070d == 1) {
            teamWorkFileImportInfo.Y = 6;
            return t(appInterface, teamWorkFileImportInfo, context, str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(AppInterface appInterface, TeamWorkFileImportInfo teamWorkFileImportInfo, Context context, String str, String str2, boolean z16) {
        boolean z17;
        int parseInt;
        String string;
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (iTeamWorkFileImportHandler != null && teamWorkFileImportInfo != null && !TextUtils.isEmpty(str2)) {
            String format = String.format(context.getString(R.string.hz9), str2);
            int f16 = TencentDocConvertConfigProcessor.a().f();
            int m3 = TencentDocConvertConfigProcessor.a().m();
            if (!PackageUtil.verifyInstalledApp(appInterface.getApp(), AppConstants.TIM_PACKAGE_NAME, AppConstants.TIM_SIG_MD5)) {
                format = String.format(context.getString(R.string.hz9), str2);
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "jumpTimLogin tim not install ");
                }
            } else {
                String checkAppInstalled = PackageUtil.checkAppInstalled(appInterface.getApp(), AppConstants.TIM_PACKAGE_NAME);
                if (QLog.isColorLevel()) {
                    QLog.d(str, 2, "jumpTimLogin tim timVersion=" + checkAppInstalled);
                }
                try {
                    parseInt = Integer.parseInt(checkAppInstalled.replace(".", ""));
                } catch (Exception e16) {
                    QLog.w(str, 1, e16.toString());
                }
                if (parseInt == 0) {
                    string = String.format(context.getString(R.string.hz9), str2);
                } else {
                    if (parseInt < m3) {
                        string = context.getString(R.string.i0v);
                    }
                    z17 = true;
                    if (!z17) {
                        Bundle bundle = new Bundle();
                        if (!z16) {
                            if (f16 == -1) {
                                QLog.i(str, 1, "tim entry not defined");
                            }
                            bundle.putBoolean("isOpenTeamWork", false);
                            bundle.putInt("timEntry", f16);
                        } else {
                            bundle.putBoolean("isOpenTeamWork", true);
                        }
                        bundle.putString("teamworkUrl", iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo));
                        bundle.putInt("peerType", teamWorkFileImportInfo.f292070d);
                        bundle.putString("peerUin", teamWorkFileImportInfo.f292072e);
                        bundle.putInt("busId", teamWorkFileImportInfo.D);
                        bundle.putLong("uniSeq", teamWorkFileImportInfo.f292079i);
                        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).jumpTimLogin(bundle, appInterface);
                        return;
                    }
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0);
                    createCustomDialog.setMessage(format);
                    createCustomDialog.setPositiveButton(context.getString(R.string.f170862av0), new b(context, str));
                    createCustomDialog.setNegativeButton(context.getString(R.string.bsc), new c(createCustomDialog));
                    try {
                        if (!createCustomDialog.isShowing()) {
                            createCustomDialog.show();
                            return;
                        }
                        return;
                    } catch (Exception e17) {
                        QLog.e(str, 1, "mDialog.show() exception" + e17.toString());
                        return;
                    }
                }
                format = string;
            }
            z17 = false;
            if (!z17) {
            }
        }
    }

    private static boolean l(String str) {
        String str2;
        com.tencent.mobileqq.config.business.bf bfVar;
        com.tencent.mobileqq.config.business.bg bgVar;
        if (TextUtils.isEmpty(str) || (str2 = ITeamWorkUtils.MINIAPP_CONFIG_TYPE_MAP.get(str)) == null || (bfVar = (com.tencent.mobileqq.config.business.bf) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_mini_app_config")) == null || (bgVar = bfVar.a().get(str2)) == null) {
            return false;
        }
        return bgVar.d();
    }

    public static boolean m(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo != null) {
            int i3 = teamWorkFileImportInfo.Y;
            if ((i3 == 6 || i3 == 7) && teamWorkFileImportInfo.f292070d == 1) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean n(String str) {
        if (!TextUtils.isEmpty(str) && TencentDocUrl2DocConfigProcessor.b(Uri.parse(str).getHost())) {
            return true;
        }
        return false;
    }

    public static void o(AppInterface appInterface, TeamWorkFileImportInfo teamWorkFileImportInfo, Context context) {
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (iTeamWorkFileImportHandler != null && teamWorkFileImportInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo));
            bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
            bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
            if (teamWorkFileImportInfo.c()) {
                bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_ONLINE_PREVIEW);
            } else {
                bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT);
            }
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(context, bundle, false);
        }
    }

    private static boolean p(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo == null || teamWorkFileImportInfo.c()) {
            return false;
        }
        int i3 = teamWorkFileImportInfo.Z;
        if (i3 != 2 && i3 != 1) {
            return false;
        }
        return true;
    }

    public static void q(int i3, int i16) {
        String str;
        if (i3 == 0) {
            str = "0X800A750";
        } else if (i3 == 1) {
            str = "0X800A751";
        } else {
            return;
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, i16, 0, "", "", "", "");
    }

    public static void r(AppInterface appInterface, Context context, String str, TeamWorkFileImportInfo teamWorkFileImportInfo, e eVar) {
        String string;
        String string2;
        String string3;
        if (context == null) {
            QLog.w(str, 1, "no context to show dialog");
            return;
        }
        if (!p(teamWorkFileImportInfo)) {
            w(appInterface, teamWorkFileImportInfo);
            x(teamWorkFileImportInfo);
            QQProgressDialog s16 = s(appInterface, teamWorkFileImportInfo, context, str, context.getString(R.string.hyg), true);
            if (eVar != null) {
                eVar.a(s16);
                return;
            }
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).actionSheetHelperCreateDialog(context, null);
        if (teamWorkFileImportInfo.c()) {
            string = context.getString(R.string.awe);
            string2 = context.getString(R.string.awa);
            string3 = context.getString(R.string.awc);
        } else {
            string = context.getString(R.string.awd);
            string2 = context.getString(R.string.aw9);
            string3 = context.getString(R.string.awb);
        }
        actionSheet.setMainTitle(context.getString(R.string.awf) + "\uff0c" + string);
        actionSheet.addButton(string2, 5);
        actionSheet.addButton(string3, 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new a(teamWorkFileImportInfo, actionSheet, appInterface, context, str, eVar));
        actionSheet.show();
        if (teamWorkFileImportInfo.c()) {
            lr2.a.j(appInterface, "0X8009ED0");
        }
    }

    public static QQProgressDialog s(AppInterface appInterface, TeamWorkFileImportInfo teamWorkFileImportInfo, Context context, String str, String str2, boolean z16) {
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (iTeamWorkFileImportHandler != null && teamWorkFileImportInfo != null && !TextUtils.isEmpty(str2)) {
            teamWorkFileImportInfo.N = true;
            if (str2.equals(context.getString(R.string.hyg))) {
                teamWorkFileImportInfo.M = true;
            } else {
                teamWorkFileImportInfo.M = false;
            }
            iTeamWorkFileImportHandler.updateFileImporting(teamWorkFileImportInfo, z16);
            if (!iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo) && TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo)) && teamWorkFileImportInfo.M) {
                iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
                i(context, teamWorkFileImportInfo, null);
            } else if (iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo) && teamWorkFileImportInfo.M) {
                i(context, teamWorkFileImportInfo, null);
            } else if (!TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo)) && teamWorkFileImportInfo.M) {
                Bundle bundle = new Bundle();
                bundle.putString("url", iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo));
                bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
                bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
                if (teamWorkFileImportInfo.c()) {
                    bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_ONLINE_PREVIEW);
                } else {
                    bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT);
                }
                ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(context, bundle, false);
            } else if (!teamWorkFileImportInfo.M) {
                k(appInterface, teamWorkFileImportInfo, context, str, str2, z16);
            }
        }
        return null;
    }

    public static QQProgressDialog t(AppInterface appInterface, TeamWorkFileImportInfo teamWorkFileImportInfo, Context context, String str) {
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (iTeamWorkFileImportHandler != null && teamWorkFileImportInfo != null && m(teamWorkFileImportInfo)) {
            teamWorkFileImportInfo.N = true;
            teamWorkFileImportInfo.M = true;
            if (!iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo) && TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo)) && teamWorkFileImportInfo.M) {
                iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
                i(context, teamWorkFileImportInfo, null);
            } else if (iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo) && teamWorkFileImportInfo.M) {
                i(context, teamWorkFileImportInfo, null);
            } else if (!TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo)) && teamWorkFileImportInfo.M) {
                Bundle bundle = new Bundle();
                bundle.putString("url", iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo));
                bundle.putBoolean(ITeamWorkDocEditBrowserProxy.KEY_TEMP_PREVIEW_FROM_QQ, true);
                bundle.putParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO, teamWorkFileImportInfo);
                if (teamWorkFileImportInfo.c()) {
                    bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_ONLINE_PREVIEW);
                } else {
                    bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT);
                }
                ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(context, bundle, false);
            }
        }
        return null;
    }

    public static void u(TeamWorkFileImportInfo teamWorkFileImportInfo, String str) {
        if (teamWorkFileImportInfo == null) {
            return;
        }
        QLog.d(str, 2, "try pre import");
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (!iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo) && TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo))) {
            QLog.i(str, 1, " parseFileImportTendoc: no cache");
            teamWorkFileImportInfo.Y = 1;
            iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
        } else {
            if (teamWorkFileImportInfo.c()) {
                QLog.i(str, 1, " parseFileImportTendoc: has cache, but online preview, drop it");
                iTeamWorkFileImportHandler.removeFileImporting(teamWorkFileImportInfo);
                iTeamWorkFileImportHandler.removeFromConvertedMap(teamWorkFileImportInfo);
                teamWorkFileImportInfo.Y = 1;
                iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
                return;
            }
            QLog.i(str, 1, " parseFileImportTendoc: has cache");
            teamWorkFileImportInfo.Y = 2;
            teamWorkFileImportInfo.Z = 1;
            if (teamWorkFileImportInfo.c()) {
                lr2.a.j(appInterface, "0X8009ECF");
            }
        }
    }

    public static void v(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        AppInterface appInterface;
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler;
        if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.f292070d == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null || (iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())) == null) {
                return;
            }
            teamWorkFileImportInfo.Y = 7;
            iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
        }
    }

    private static void w(AppInterface appInterface, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler;
        if (appInterface != null && teamWorkFileImportInfo != null && (iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())) != null && iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo)) {
            int i3 = teamWorkFileImportInfo.Y;
            if (i3 == 1 || i3 == 2) {
                iTeamWorkFileImportHandler.removeFileImporting(teamWorkFileImportInfo);
            }
        }
    }

    private static void x(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        int i3;
        if (teamWorkFileImportInfo != null && (i3 = teamWorkFileImportInfo.Y) != 0 && i3 != 4) {
            teamWorkFileImportInfo.Y = 0;
        }
    }
}
