package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.widget.PopupMenuDialog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.vip.manager.FileBannerTianshuManger;
import cooperation.weiyun.AlbumBackupProxyActivity;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import ta1.m;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f implements qb1.b {

    /* renamed from: a, reason: collision with root package name */
    private PopupMenuDialog f206833a;

    /* renamed from: b, reason: collision with root package name */
    private FileBannerTianshuManger f206834b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f206835c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.observer.a f206836d = new a();

    /* renamed from: e, reason: collision with root package name */
    private PermissionPageUtil f206837e;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.observer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.observer.a, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QLog.i("FileAssistantExt", 1, " fileRedTouch get push GameCenterObserver ");
            f.this.f206835c.sendMessage(f.this.f206835c.obtainMessage(1));
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements PopupMenuDialog.OnClickActionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f206839a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f206840b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseQQAppInterface f206841c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f206842d;

        b(boolean z16, Activity activity, BaseQQAppInterface baseQQAppInterface, BusinessInfoCheckUpdate.AppInfo appInfo) {
            this.f206839a = z16;
            this.f206840b = activity;
            this.f206841c = baseQQAppInterface;
            this.f206842d = appInfo;
        }

        @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
        public void onClickAction(PopupMenuDialog.MenuItem menuItem) {
            int i3 = menuItem.f384641id;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                FileManagerReporter.addData("0X8005532");
                                QQAppInterface qQAppInterface = (QQAppInterface) this.f206841c;
                                Activity activity = this.f206840b;
                                FileManagerUtil.addShortcut(qQAppInterface, activity, "_is_from_qfile_shortcut", activity.getString(R.string.b6a), R.drawable.e_n);
                                f.this.y(this.f206840b);
                                return;
                            }
                            return;
                        }
                        FileManagerReporter.addData("0X800A15F");
                        Bundle bundle = new Bundle();
                        bundle.putString("url", ITeamWorkHttpUtils.DEFAULT_TENCENT_DOC_TEMPLATES_URL);
                        bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_MENU_CREATE);
                        TeamWorkDocEditBrowserActivity.openTeamWorkDocEditBrowserActivity(this.f206840b, bundle, false);
                        return;
                    }
                    if (this.f206839a) {
                        FileManagerReporter.addData("0X8005536");
                    } else {
                        FileManagerReporter.addData("0X800681C");
                    }
                    f.this.z(this.f206840b, this.f206841c, this.f206842d);
                    return;
                }
                if (this.f206839a) {
                    FileManagerReporter.addData("0X8005535");
                } else {
                    FileManagerReporter.addData("0X800681B");
                }
                f.this.A(this.f206841c, this.f206840b);
                return;
            }
            if (this.f206839a) {
                FileManagerReporter.addData("0X8005534");
            } else {
                FileManagerReporter.addData("0X800681A");
            }
            if (h.o()) {
                h.s(this.f206840b);
                return;
            }
            try {
                IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
                Activity activity2 = this.f206840b;
                iAIOStarterApi.navigateToAIOActivity(activity2, 8, PeerUid.DATALINE_PC_UID, activity2.getResources().getString(R.string.c5f), 0L, new Bundle());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 4) {
                f.this.f206833a.dismiss();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(BaseQQAppInterface baseQQAppInterface, Activity activity) {
        ((QQAppInterface) baseQQAppInterface).getQQProxyForQlink().B("0X800474E", 1);
        QQProxyForQlink.P(activity, 2, null);
    }

    private SpannableString p(String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203164zg), "https://www.weiyun.com/mobile/xy.html"));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203004z1), "https://docs.qq.com/doc/p/fc25bcaaaf19c8a4326213ad4a851bd22d74956c?dver=2.1.27262305&from=app"));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f238717ki), "https://docs.qq.com/doc/p/1113424a0a7c7b78133263e0a098a15b812eca9b?dver=2.1.27237808&from=app"));
        arrayList.add(new RichTextHelper.RichTextData(context.getString(R.string.f203044z5), "https://privacy.qq.com/policy/kids-privacypolicy"));
        return RichTextHelper.buildSpannable(str, context, false, arrayList);
    }

    private void q(AppRuntime appRuntime, BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        QLog.i("FileAssistantExt", 1, " fileRedTouch deleteRedTouch path = " + str);
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "");
        if (appInfo == null) {
            iRedTouchManager.onRedTouchItemClick(str);
        } else {
            iRedTouchManager.onRedTouchItemClick(appInfo, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Activity activity, DialogInterface dialogInterface, int i3) {
        boolean z16 = true;
        if (i3 == 1) {
            z16 = false;
        }
        x(activity, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Activity activity, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        if (this.f206837e == null) {
            this.f206837e = new PermissionPageUtil(activity, activity.getPackageName());
        }
        this.f206837e.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(MMKVOptionEntity mMKVOptionEntity, Activity activity, BaseQQAppInterface baseQQAppInterface, BusinessInfoCheckUpdate.AppInfo appInfo, DialogInterface dialogInterface, int i3) {
        mMKVOptionEntity.encodeBool("weiyun_is_agree_privacy", true);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        AlbumBackupProxyActivity.G2(activity, baseQQAppInterface.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        q(baseQQAppInterface, appInfo, "100160.100162");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final Activity activity, final BaseQQAppInterface baseQQAppInterface, final BusinessInfoCheckUpdate.AppInfo appInfo) {
        final MMKVOptionEntity from = QMMKV.from(activity, "common_mmkv_configurations");
        if (from.decodeBool("weiyun_is_agree_privacy", false)) {
            AlbumBackupProxyActivity.G2(activity, baseQQAppInterface.getCurrentAccountUin(), "source_qfile_assistant", 10001);
            q(baseQQAppInterface, appInfo, "100160.100162");
            return;
        }
        SpannableString p16 = p(activity.getString(R.string.f238707kh), activity);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 0, activity.getString(R.string.f238727kj), p16.toString(), R.string.fpf, R.string.fpd, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.api.impl.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.this.v(from, activity, baseQQAppInterface, appInfo, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.api.impl.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.w(dialogInterface, i3);
            }
        });
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.setCancelable(true);
        TextView textView = (TextView) createCustomDialog.findViewById(R.id.dialogText);
        textView.setText(p16);
        textView.setTextSize(1, 13.0f);
        textView.setHighlightColor(0);
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
        ((TextView) createCustomDialog.findViewById(R.id.dialogRightBtn)).setTextColor(Color.parseColor("#40A0FF"));
        createCustomDialog.show();
    }

    @Override // qb1.b
    public void a(Activity activity, BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, BaseQQAppInterface baseQQAppInterface, int[] iArr, int[] iArr2) {
        m c16;
        if (this.f206833a != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] != R.string.f4g || QQProxyForQlink.t()) {
                PopupMenuDialog.MenuItem menuItem = new PopupMenuDialog.MenuItem();
                menuItem.f384641id = i3;
                String string = activity.getString(iArr[i3]);
                menuItem.title = string;
                menuItem.contentDescription = string;
                if (i3 == 3 && (c16 = TencentDocMyFileNameProcessor.c()) != null && !TextUtils.isEmpty(c16.f435717h)) {
                    String str = c16.f435717h;
                    menuItem.title = str;
                    menuItem.contentDescription = str;
                }
                menuItem.iconId = iArr2[i3];
                arrayList.add(menuItem);
            }
        }
        PopupMenuDialog build = PopupMenuDialog.build(activity, arrayList, new b(z16, activity, baseQQAppInterface, appInfo), null, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(210, activity.getResources()));
        this.f206833a = build;
        build.setTouchInterceptor(new c());
    }

    @Override // qb1.b
    public void b(AppRuntime appRuntime) {
        appRuntime.unRegistObserver(this.f206836d);
    }

    @Override // qb1.b
    public void c(View view, int i3, int i16) {
        this.f206833a.showAsDropDown(view, i3, i16);
    }

    @Override // qb1.b
    public void d(Activity activity, View view) {
        FileBannerTianshuManger fileBannerTianshuManger = new FileBannerTianshuManger(activity, view, 1);
        this.f206834b = fileBannerTianshuManger;
        fileBannerTianshuManger.h();
    }

    @Override // qb1.b
    public int e() {
        return this.f206833a.getWidth();
    }

    @Override // qb1.b
    public void f(AppRuntime appRuntime, Handler handler) {
        this.f206835c = handler;
        appRuntime.registObserver(this.f206836d);
    }

    boolean r(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("key_qfile_add_shortcut_hint_enabled", true);
    }

    void x(Context context, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("key_qfile_add_shortcut_hint_enabled", z16);
        edit.apply();
    }

    void y(final Activity activity) {
        if (!r(activity)) {
            com.tencent.mobileqq.filemanager.util.d.g(R.string.b76);
        } else {
            DialogUtil.createDialogWithCheckBox(activity, 230, activity.getString(R.string.f186723s2), activity.getString(R.string.f186683ry), activity.getString(R.string.f186703s0), false, activity.getString(R.string.f186713s1), activity.getString(R.string.f186693rz), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.api.impl.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    f.this.s(activity, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.api.impl.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    f.this.t(activity, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.api.impl.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }
}
