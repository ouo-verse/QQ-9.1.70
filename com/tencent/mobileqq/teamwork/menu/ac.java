package com.tencent.mobileqq.teamwork.menu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.api.IRelyClassCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.menu.MenuConfigImpl;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.teamwork.menu.ac;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac implements MenuTabViewBase.a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f292202a;

    /* renamed from: b, reason: collision with root package name */
    private TeamWorkFileImportInfo f292203b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<INativeEngineFileBrowserWrapper> f292204c;

    /* renamed from: d, reason: collision with root package name */
    private ak f292205d;

    /* renamed from: e, reason: collision with root package name */
    private QQProgressDialog f292206e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ITeamWorkFileImportHandler.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppInterface f292207a;

        a(AppInterface appInterface) {
            this.f292207a = appInterface;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void d(AppInterface appInterface) {
            com.tencent.mobileqq.teamwork.u.g(appInterface, (Context) ac.this.f292202a.get(), "DocMenuClickPresenter", ac.this.f292203b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i3, final AppInterface appInterface) {
            if (i3 != 0) {
                ac.this.F0(MenuConfigImpl.f292183e, new g() { // from class: com.tencent.mobileqq.teamwork.menu.ab
                    @Override // com.tencent.mobileqq.teamwork.menu.ac.g
                    public final void onConfirm() {
                        ac.a.this.d(appInterface);
                    }
                });
            } else {
                ac.this.T();
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler.a
        public void a(final int i3, String str, Object obj) {
            QLog.e("DocMenuClickPresenter", 1, "getLocalFileImportInfo ret=", Integer.valueOf(i3), " errMsg=", str);
            final AppInterface appInterface = this.f292207a;
            appInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ac.a.this.e(i3, appInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends f {
        b(ac acVar) {
            super(acVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3, String str, ir2.b bVar) {
            ac acVar = this.f292213a.get();
            if (acVar != null) {
                acVar.P(i3, str, bVar);
            } else {
                QLog.e("DocMenuClickPresenter", 1, "presenter is null");
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.b
        public void a(final int i3, final String str, final ir2.b bVar) {
            QLog.i("DocMenuClickPresenter", 1, "online upload result retCode=" + i3 + " msg=" + str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ac.b.this.c(i3, str, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends f {
        c(ac acVar) {
            super(acVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3, String str, ir2.b bVar) {
            ac acVar = this.f292213a.get();
            if (acVar != null) {
                acVar.O(i3, str, bVar);
            } else {
                QLog.e("DocMenuClickPresenter", 1, "presenter is null");
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.b
        public void a(final int i3, final String str, final ir2.b bVar) {
            QLog.i("DocMenuClickPresenter", 1, "resume import result retCode=" + i3 + " msg=" + str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.ae
                @Override // java.lang.Runnable
                public final void run() {
                    ac.c.this.c(i3, str, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends f {
        d(ac acVar) {
            super(acVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3, String str, ir2.b bVar) {
            ac acVar = this.f292213a.get();
            if (acVar != null) {
                acVar.Q(i3, str, bVar);
            } else {
                QLog.e("DocMenuClickPresenter", 1, "presenter is null");
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.b
        public void a(final int i3, final String str, final ir2.b bVar) {
            QLog.i("DocMenuClickPresenter", 1, "pdf convert result retCode=" + i3 + " msg=" + str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.af
                @Override // java.lang.Runnable
                public final void run() {
                    ac.d.this.c(i3, str, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends f {
        e(ac acVar) {
            super(acVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3, String str, ir2.b bVar) {
            ac acVar = this.f292213a.get();
            if (acVar != null) {
                acVar.R(i3, str, bVar);
            } else {
                QLog.e("DocMenuClickPresenter", 1, "presenter is null");
            }
        }

        @Override // com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper.b
        public void a(final int i3, final String str, final ir2.b bVar) {
            QLog.i("DocMenuClickPresenter", 1, "online upload result retCode=" + i3 + " msg=" + i3);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.ag
                @Override // java.lang.Runnable
                public final void run() {
                    ac.e.this.c(i3, str, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public abstract class f implements INativeEngineFileBrowserWrapper.b {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ac> f292213a;

        public f(ac acVar) {
            this.f292213a = new WeakReference<>(acVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface g {
        void onConfirm();
    }

    public ac(Activity activity, TeamWorkFileImportInfo teamWorkFileImportInfo, INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper, ak akVar) {
        this.f292202a = new WeakReference<>(activity);
        this.f292203b = teamWorkFileImportInfo;
        this.f292204c = new WeakReference<>(iNativeEngineFileBrowserWrapper);
        this.f292205d = akVar;
    }

    public static void D0(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("isShowAd", false);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    private void E0() {
        final INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            G0(activity, "\u6587\u4ef6\u4e0a\u4f20\u4e2d");
            kr2.b.b(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.menu.i
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    ac.this.q0(iNativeEngineFileBrowserWrapper, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(final MenuConfigImpl.a aVar, final g gVar) {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        final Activity activity = this.f292202a.get();
        if (appInterface != null && activity != null && gVar != null && aVar != null) {
            appInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.g
                @Override // java.lang.Runnable
                public final void run() {
                    ac.t0(activity, aVar, gVar);
                }
            });
        }
    }

    private void G0(Context context, String str) {
        if (this.f292206e == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(context);
            this.f292206e = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
        }
        this.f292206e.setMessage(str);
        this.f292206e.show();
    }

    private void I() {
        QQProgressDialog qQProgressDialog = this.f292206e;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.f292206e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void h0() {
        final INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            G0(activity, "PDF\u6587\u6863\u5bfc\u51fa\u4e2d");
            kr2.b.b(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.menu.h
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    ac.this.U(iNativeEngineFileBrowserWrapper, obj);
                }
            });
        }
    }

    private String K(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = "";
        }
        return teamWorkFileImportInfo.f292067a0 + "_" + teamWorkFileImportInfo.f292074f + "exportPdf_" + str;
    }

    private String L(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = "";
        }
        return teamWorkFileImportInfo.f292067a0 + "_" + teamWorkFileImportInfo.f292074f + "_saveToDrive_" + str;
    }

    private String M(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = "";
        }
        return teamWorkFileImportInfo.f292067a0 + "_" + teamWorkFileImportInfo.f292074f + "_saveToDriveCopy_guide_" + str;
    }

    private String N(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = "";
        }
        return teamWorkFileImportInfo.f292067a0 + "_" + teamWorkFileImportInfo.f292074f + "_saveToDrive_guide_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i3, String str, ir2.b bVar) {
        I();
        Activity activity = this.f292202a.get();
        if (activity == null) {
            QLog.e("DocMenuClickPresenter", 1, "context is null");
            return;
        }
        if (i3 != 0) {
            S(activity, i3, str);
            return;
        }
        QLog.i("DocMenuClickPresenter", 1, "resume import result docId=" + bVar.f408435c + " localPadId=" + bVar.f408434b + " title=" + bVar.f408437e);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("https://docs.qq.com/resume/import?file_id=");
        sb5.append(bVar.f408434b);
        ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(activity, sb5.toString(), ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i3, String str, ir2.b bVar) {
        I();
        Activity activity = this.f292202a.get();
        if (activity == null) {
            return;
        }
        if (i3 == 0 && !TextUtils.isEmpty(bVar.f408439g)) {
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(activity, bVar.f408439g + "?convert_type=image", ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG);
            return;
        }
        S(activity, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3, String str, ir2.b bVar) {
        I();
        Activity activity = this.f292202a.get();
        if (activity == null) {
            QLog.e("DocMenuClickPresenter", 1, "context is null");
        } else if (i3 == 0 && !TextUtils.isEmpty(bVar.f408439g)) {
            PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(K(this.f292203b), bVar.f408439g).commit();
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(activity, bVar.f408439g, ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG);
        } else {
            S(activity, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i3, String str, ir2.b bVar) {
        I();
        Activity activity = this.f292202a.get();
        if (activity == null) {
            QLog.e("DocMenuClickPresenter", 1, "context is null");
        } else if (i3 == 0 && !TextUtils.isEmpty(bVar.f408439g)) {
            PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(L(this.f292203b), bVar.f408439g).commit();
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(activity, bVar.f408439g, ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG);
        } else {
            S(activity, i3, str);
        }
    }

    private void S(final Context context, int i3, String str) {
        if (i3 == 320124) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, "\u4e0a\u4f20\u5931\u8d25", "\u4f1a\u5458\u4ec5\u652f\u6301\u4e0a\u4f202GB\u5185\u7684\u6587\u4ef6", "\u786e\u5b9a", (String) null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    ac.V(dialogInterface, i16);
                }
            }, (DialogInterface.OnClickListener) null);
            createCustomDialog.setCancelable(true);
            createCustomDialog.show();
        } else if (i3 == 320125) {
            QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(context, 230, "\u4e0a\u4f20\u5931\u8d25", "\u975e\u4f1a\u5458\u4ec5\u652f\u6301\u4e0a\u4f2010M\u5185\u7684\u6587\u4ef6\uff0c\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u53ef\u4e0a\u4f2020GB\u8d85\u5927\u6587\u4ef6\uff0c\u64cd\u4f5c\u9700\u8981\u524d\u5f80\u817e\u8baf\u6587\u6863\u8fdb\u884c", "\u53d6\u6d88", "\u7acb\u5373\u5f00\u901a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    ac.D0(context, "https://docs.qq.com/vip/h5-pay?aid=txdocs_an_qq_qqlocalbar_backup_overlimit_doc");
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    ac.X(dialogInterface, i16);
                }
            });
            createCustomDialog2.setCancelable(true);
            createCustomDialog2.show();
        } else {
            if (i3 == 106) {
                if (TextUtils.isEmpty(str)) {
                    str = "\u975e\u4f1a\u5458\u4ec5\u652f\u6301\u4e0a\u4f2010M\u5185\u7684\u6587\u4ef6\uff0c\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u53ef\u4e0a\u4f2020GB\u8d85\u5927\u6587\u4ef6\uff0c\u64cd\u4f5c\u9700\u8981\u524d\u5f80\u817e\u8baf\u6587\u6863\u8fdb\u884c";
                }
                QQCustomDialog createCustomDialog3 = DialogUtil.createCustomDialog(context, 230, "\u4e0a\u4f20\u5931\u8d25", str, "\u53d6\u6d88", "\u5f00\u901a\u4f1a\u5458", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.q
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        ac.D0(context, "https://docs.qq.com/vip/h5-pay?aid=txdocs_an_qq_qqlocalbar_backup_overlimit_doc");
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.r
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        ac.Z(dialogInterface, i16);
                    }
                });
                createCustomDialog3.setCancelable(true);
                createCustomDialog3.show();
                return;
            }
            QQToast.makeText(context, 0, "\u6587\u4ef6\u4e0a\u4f20\u5931\u8d25", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper, Object obj) {
        if (!(obj instanceof INativeEngineFileBrowserWrapper.a)) {
            return;
        }
        iNativeEngineFileBrowserWrapper.g(6, (INativeEngineFileBrowserWrapper.a) obj, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(QQCustomDialog qQCustomDialog, AppInterface appInterface, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        qQCustomDialog.dismiss();
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292203b;
        teamWorkFileImportInfo.Y = 2;
        com.tencent.mobileqq.teamwork.u.o(appInterface, teamWorkFileImportInfo, context);
        if (this.f292203b.c()) {
            lr2.a.j(appInterface, "0X8009ED1");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(QQCustomDialog qQCustomDialog, AppInterface appInterface, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        qQCustomDialog.dismiss();
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292203b;
        teamWorkFileImportInfo.Y = 1;
        com.tencent.mobileqq.teamwork.u.g(appInterface, context, "DocMenuClickPresenter", teamWorkFileImportInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(QQCustomDialog qQCustomDialog, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        qQCustomDialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(final Context context, final AppInterface appInterface) {
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230);
        createCustomDialog.setCancelable(true);
        View inflate = LayoutInflater.from(context).inflate(R.layout.g6p, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        createCustomDialog.addView(inflate, layoutParams);
        ((TextView) inflate.findViewById(R.id.content)).setText("\u4f60\u66fe\u7ecf\u5c06\u6b64\u6587\u6863\u8f6c\u4e3a\u5728\u7ebf\u6587\u6863\uff0c\u662f\u5426\u76f4\u63a5\u6253\u5f00\uff1f");
        TextView textView = (TextView) inflate.findViewById(R.id.tce);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tcf);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tcg);
        textView.setText("\u76f4\u63a5\u6253\u5f00");
        textView2.setText("\u91cd\u65b0\u751f\u6210");
        textView3.setText("\u53d6\u6d88");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.this.a0(createCustomDialog, appInterface, context, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.this.b0(createCustomDialog, appInterface, context, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.c0(QQCustomDialog.this, view);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper, int i3, Object obj) {
        if (!(obj instanceof INativeEngineFileBrowserWrapper.a)) {
            return;
        }
        iNativeEngineFileBrowserWrapper.g(i3, (INativeEngineFileBrowserWrapper.a) obj, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Context context, final INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper) {
        final int i3;
        G0(context, "\u6587\u4ef6\u4e0a\u4f20\u4e2d");
        int i16 = this.f292203b.R;
        if (i16 == 3) {
            i3 = 0;
        } else if (i16 == 9) {
            i3 = 6;
        } else if (i16 == 6) {
            i3 = 1;
        } else {
            i3 = 10;
        }
        kr2.b.b(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.menu.m
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                ac.this.e0(iNativeEngineFileBrowserWrapper, i3, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper, Object obj) {
        if (!(obj instanceof INativeEngineFileBrowserWrapper.a)) {
            return;
        }
        iNativeEngineFileBrowserWrapper.g(10, (INativeEngineFileBrowserWrapper.a) obj, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().putBoolean(str, true).commit();
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().putBoolean(str, true).commit();
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper, Object obj) {
        if (!(obj instanceof INativeEngineFileBrowserWrapper.a)) {
            return;
        }
        iNativeEngineFileBrowserWrapper.f((INativeEngineFileBrowserWrapper.a) obj, new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0(ActionSheet actionSheet, g gVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        actionSheet.dismiss();
        gVar.onConfirm();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t0(Context context, MenuConfigImpl.a aVar, final g gVar) {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(context, null);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.g6v, (ViewGroup) null);
        actionSheet.addView(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f166149eh4);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        View findViewById = inflate.findViewById(R.id.xdi);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ugb);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ugc);
        TextView textView4 = (TextView) inflate.findViewById(R.id.ugd);
        TextView textView5 = (TextView) inflate.findViewById(R.id.adg);
        Button button = (Button) inflate.findViewById(R.id.aek);
        imageView.setImageResource(aVar.f292186a);
        textView.setText(aVar.f292187b);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.r0(ActionSheet.this, view);
            }
        });
        textView2.setText(aVar.f292188c);
        textView3.setText(aVar.f292189d);
        textView4.setText(aVar.f292190e);
        button.setText(aVar.f292191f);
        textView5.setText(aVar.f292192g);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.s0(ActionSheet.this, gVar, view);
            }
        });
        actionSheet.show();
    }

    protected void A0(au auVar) {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            boolean z16 = !auVar.f292250e;
            auVar.f292250e = z16;
            if (z16) {
                iNativeEngineFileBrowserWrapper.e(1);
            } else {
                iNativeEngineFileBrowserWrapper.e(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void k0() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        Activity activity = this.f292202a.get();
        if (appInterface != null && activity != null) {
            final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
            final String M = M(this.f292203b);
            if (!defaultSharedPreferences.getBoolean(M, false)) {
                F0(MenuConfigImpl.f292182d, new g() { // from class: com.tencent.mobileqq.teamwork.menu.y
                    @Override // com.tencent.mobileqq.teamwork.menu.ac.g
                    public final void onConfirm() {
                        ac.this.o0(defaultSharedPreferences, M);
                    }
                });
                return;
            } else {
                E0();
                return;
            }
        }
        QLog.e("DocMenuClickPresenter", 1, "peekAppRuntime or context is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public void j0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
            final String N = N(this.f292203b);
            if (!defaultSharedPreferences.getBoolean(N, false)) {
                F0(MenuConfigImpl.f292182d, new g() { // from class: com.tencent.mobileqq.teamwork.menu.b
                    @Override // com.tencent.mobileqq.teamwork.menu.ac.g
                    public final void onConfirm() {
                        ac.this.p0(defaultSharedPreferences, N);
                    }
                });
            } else {
                E0();
            }
        }
    }

    public void T() {
        final AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        final Activity activity = this.f292202a.get();
        if (appInterface == null) {
            QLog.e("DocMenuClickPresenter", 1, "peekAppRuntime or activity is null");
        } else {
            appInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.w
                @Override // java.lang.Runnable
                public final void run() {
                    ac.this.d0(activity, appInterface);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase.a
    public boolean a(au auVar) {
        int i3 = auVar.f292246a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 6) {
                        if (i3 != 14) {
                            if (i3 != 10) {
                                if (i3 != 11) {
                                    if (i3 != 16) {
                                        if (i3 != 17) {
                                            return false;
                                        }
                                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.v
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                ac.this.n0();
                                            }
                                        }, 128, null, false);
                                        return true;
                                    }
                                    z0();
                                    return true;
                                }
                                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.s
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ac.this.k0();
                                    }
                                }, 128, null, false);
                                return true;
                            }
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.t
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ac.this.l0();
                                }
                            }, 128, null, false);
                            return true;
                        }
                        y0();
                        return true;
                    }
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            ac.this.m0();
                        }
                    }, 128, null, false);
                    return false;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ac.this.j0();
                    }
                }, 128, null, false);
                return true;
            }
            A0(auVar);
            return true;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.a
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.i0();
            }
        }, 128, null, false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void n0() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        final INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        final Activity activity = this.f292202a.get();
        if (appInterface != null && activity != null && iNativeEngineFileBrowserWrapper != null) {
            F0(MenuConfigImpl.f292185g, new g() { // from class: com.tencent.mobileqq.teamwork.menu.z
                @Override // com.tencent.mobileqq.teamwork.menu.ac.g
                public final void onConfirm() {
                    ac.this.f0(activity, iNativeEngineFileBrowserWrapper);
                }
            });
        } else {
            QLog.e("DocMenuClickPresenter", 1, "peekAppRuntime or context is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void i0() {
        TeamWorkFileImportInfo teamWorkFileImportInfo;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.e("DocMenuClickPresenter", 1, "peekAppRuntime null");
            return;
        }
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName());
        if (iTeamWorkFileImportHandler != null && (teamWorkFileImportInfo = this.f292203b) != null) {
            if (TextUtils.isEmpty(teamWorkFileImportInfo.f292067a0)) {
                JSONObject queryFileEntityInfo = ((IRelyClassCreator) QRoute.api(IRelyClassCreator.class)).queryFileEntityInfo(this.f292203b, appInterface);
                if (queryFileEntityInfo != null) {
                    this.f292203b.f292067a0 = queryFileEntityInfo.optString(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, "");
                    this.f292203b.f292068b0 = queryFileEntityInfo.optInt("filetype", 0);
                } else {
                    QLog.e("DocMenuClickPresenter", 1, "queryFileEntityInfo null!");
                }
            }
            if (!TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(this.f292203b))) {
                T();
            } else {
                iTeamWorkFileImportHandler.getLocalFileImportInfo(this.f292203b, new a(appInterface));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void m0() {
        final INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            G0(activity, "\u6587\u4ef6\u4e0a\u4f20\u4e2d");
            kr2.b.b(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.menu.x
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    ac.this.g0(iNativeEngineFileBrowserWrapper, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void l0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            if (TextUtils.isEmpty(PreferenceManager.getDefaultSharedPreferences(activity).getString(K(this.f292203b), ""))) {
                F0(MenuConfigImpl.f292184f, new g() { // from class: com.tencent.mobileqq.teamwork.menu.c
                    @Override // com.tencent.mobileqq.teamwork.menu.ac.g
                    public final void onConfirm() {
                        ac.this.h0();
                    }
                });
            } else {
                h0();
            }
        }
    }

    protected void y0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            iNativeEngineFileBrowserWrapper.b(false);
        }
    }

    protected void z0() {
        INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper = this.f292204c.get();
        Activity activity = this.f292202a.get();
        if (iNativeEngineFileBrowserWrapper != null && activity != null) {
            iNativeEngineFileBrowserWrapper.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(DialogInterface dialogInterface, int i3) {
    }
}
