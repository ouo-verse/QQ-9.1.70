package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.au;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.util.PermissionUtil;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f208180d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f208181e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208182f;

        b(Activity activity, Bundle bundle, FileManagerEntity fileManagerEntity) {
            this.f208180d = activity;
            this.f208181e = bundle;
            this.f208182f = fileManagerEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.u(this.f208180d, this.f208181e, this.f208182f);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.c$c, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class ViewOnClickListenerC7562c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f208183d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208184e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f208185f;

        ViewOnClickListenerC7562c(Activity activity, FileManagerEntity fileManagerEntity, String str) {
            this.f208183d = activity;
            this.f208184e = fileManagerEntity;
            this.f208185f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f208183d != null) {
                LinkByWeiyunFragment.th(this.f208183d, ForwardFileOption.U(this.f208184e), this.f208185f, false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f208186d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208187e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f208188f;

        d(Activity activity, FileManagerEntity fileManagerEntity, String str) {
            this.f208186d = activity;
            this.f208187e = fileManagerEntity;
            this.f208188f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f208186d != null) {
                LinkByWeiyunFragment.th(this.f208186d, ForwardFileOption.U(this.f208187e), this.f208188f, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f208192d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f208193e;

        f(Activity activity, String str) {
            this.f208192d = activity;
            this.f208193e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList(this.f208192d, this.f208193e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208194d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.g f208195e;

        g(FileManagerEntity fileManagerEntity, com.tencent.mobileqq.filemanager.fileviewer.g gVar) {
            this.f208194d = fileManagerEntity;
            this.f208195e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                FileManagerEngine fileManagerEngine = qQAppInterface.getFileManagerEngine();
                FileManagerEntity fileManagerEntity = this.f208194d;
                fileManagerEngine.v0(fileManagerEntity, fileManagerEntity.peerUin);
                com.tencent.mobileqq.filemanager.util.d.d(QBaseActivity.sTopActivity.getString(R.string.f170978be3));
                com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208195e;
                if (gVar != null && gVar.N()) {
                    FileManagerUtil.processAIOTimGraytips(qQAppInterface, this.f208194d.nSessionId);
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f208196a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f208197b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f208198c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f208199d;

        h(Activity activity, String str, String str2, long j3) {
            this.f208196a = activity;
            this.f208197b = str;
            this.f208198c = str2;
            this.f208199d = j3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            au.g().r(this.f208196a, this.f208197b, this.f208198c, this.f208199d);
            QLog.d("FileOperaterUtils", 1, "requestStoreReadAndWritePermission allow!");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            QQToast.makeText(this.f208196a, R.string.f13534017, 1).show();
            QLog.d("FileOperaterUtils", 1, "requestStoreReadAndWritePermission reject!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208200d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f208201e;

        i(FileManagerEntity fileManagerEntity, Activity activity) {
            this.f208200d = fileManagerEntity;
            this.f208201e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                FileManagerReporter.a aVar = new FileManagerReporter.a();
                aVar.f209157b = "file_forward";
                aVar.f209158c = 71;
                FileManagerEntity fileManagerEntity = this.f208200d;
                aVar.f209160e = fileManagerEntity.fileSize;
                aVar.f209159d = q.j(fileManagerEntity.fileName);
                aVar.f209162g = FileManagerUtil.reportSrcType(this.f208200d.getCloudType(), this.f208200d.peerType);
                FileManagerReporter.addData(qQAppInterface.getCurrentAccountUin(), aVar);
                QFileUtils.y(qQAppInterface, this.f208201e, this.f208200d);
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208202d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.g f208203e;

        j(FileManagerEntity fileManagerEntity, com.tencent.mobileqq.filemanager.fileviewer.g gVar) {
            this.f208202d = fileManagerEntity;
            this.f208203e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QQAppInterface qQAppInterface;
            int fileSrcCloudType;
            Context context;
            com.tencent.mobileqq.filemanager.fileviewer.g gVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                fileSrcCloudType = FileManagerUtil.getFileSrcCloudType(this.f208202d);
                Context context2 = QBaseActivity.sTopActivity;
                if (context2 == null) {
                    if (view != null) {
                        context2 = view.getContext();
                    } else {
                        context2 = BaseApplication.getContext();
                    }
                }
                context = context2;
            } catch (Exception unused) {
            }
            if (fileSrcCloudType != 1 && fileSrcCloudType != 2 && fileSrcCloudType != 4) {
                FileManagerEntity fileManagerEntity = this.f208202d;
                if (fileManagerEntity.nFileType == 0 && q.f(fileManagerEntity.getFilePath())) {
                    QfavBuilder.e0(this.f208202d.getFilePath()).C(qQAppInterface).j(context, qQAppInterface.getAccount());
                    cooperation.qqfav.d.e(qQAppInterface, 7, 3);
                } else if (fileSrcCloudType == 3 && this.f208202d.nFileType == 2) {
                    new QfavBuilder(3).u(qQAppInterface, context, this.f208202d, null, false);
                } else if (fileSrcCloudType == 16 && this.f208202d.nFileType == 2) {
                    QfavBuilder qfavBuilder = new QfavBuilder(3);
                    FileManagerEntity fileManagerEntity2 = this.f208202d;
                    qfavBuilder.v(qQAppInterface, context, fileManagerEntity2, null, false, fileManagerEntity2.strFilePath, true, true);
                } else if (QLog.isColorLevel()) {
                    QLog.i("FileOperaterUtils", 2, "FileVideoMediaPlayHelperthis is a local file, but favorite fail. [Uuid] = " + this.f208202d.Uuid + " [status] = " + this.f208202d.status + " [fileType] = " + this.f208202d.nFileType);
                }
                gVar = this.f208203e;
                if (gVar != null && gVar.N()) {
                    FileManagerUtil.processAIOTimGraytips(qQAppInterface, this.f208202d.nSessionId);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
            new QfavBuilder(3).u(qQAppInterface, context, this.f208202d, null, false);
            gVar = this.f208203e;
            if (gVar != null) {
                FileManagerUtil.processAIOTimGraytips(qQAppInterface, this.f208202d.nSessionId);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class k implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f208204d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f208205e;

        k(Activity activity, String str) {
            this.f208204d = activity;
            this.f208205e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Activity activity = this.f208204d;
            if (activity instanceof BasePluginActivity) {
                FileManagerUtil.openWithOtherApp(((BasePluginActivity) activity).getOutActivity(), this.f208205e);
            } else {
                FileManagerUtil.openWithOtherApp(activity, this.f208205e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.g f208206d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208207e;

        l(com.tencent.mobileqq.filemanager.fileviewer.g gVar, FileManagerEntity fileManagerEntity) {
            this.f208206d = gVar;
            this.f208207e = fileManagerEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                FileManagerReporter.a aVar = new FileManagerReporter.a();
                aVar.f209157b = "file_forward";
                aVar.f209158c = 9;
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (qQAppInterface != null) {
                    FileManagerReporter.addData(qQAppInterface.getCurrentAccountUin(), aVar);
                }
                QFileUtils.A(qQAppInterface, this.f208206d.getActivity(), this.f208207e);
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class m implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.g f208208d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208209e;

        m(com.tencent.mobileqq.filemanager.fileviewer.g gVar, FileManagerEntity fileManagerEntity) {
            this.f208208d = gVar;
            this.f208209e = fileManagerEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.y(this.f208208d.getActivity(), this.f208209e, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208210d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f208211e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f208212f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ u.d f208213h;

        n(FileManagerEntity fileManagerEntity, Activity activity, boolean z16, u.d dVar) {
            this.f208210d = fileManagerEntity;
            this.f208211e = activity;
            this.f208212f = z16;
            this.f208213h = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            boolean z17;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f208210d != null && this.f208211e != null) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                if (this.f208212f) {
                    lr2.a.j(null, "0X800A21D");
                } else {
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009063", "0X8009063", 0, 0, "", "", "", "");
                }
                TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
                teamWorkFileImportInfo.f292077h = this.f208210d.getFilePath();
                FileManagerEntity fileManagerEntity = this.f208210d;
                teamWorkFileImportInfo.f292074f = fileManagerEntity.fileName;
                teamWorkFileImportInfo.R = fileManagerEntity.nFileType;
                if (this.f208212f) {
                    teamWorkFileImportInfo.J = 8;
                } else {
                    teamWorkFileImportInfo.J = 5;
                }
                teamWorkFileImportInfo.f292078h0 = fileManagerEntity.fileSize;
                Activity activity = this.f208211e;
                if (activity instanceof FileBrowserActivity) {
                    z16 = ((FileBrowserActivity) activity).c3();
                    if (((FileBrowserActivity) this.f208211e).N() && !z16) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    teamWorkFileImportInfo.K = z17;
                } else {
                    z16 = false;
                }
                if (z16 && !FileUtils.fileExistsAndNotEmpty(this.f208210d.getFilePath())) {
                    QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(R.string.hy_), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                } else {
                    if (!TextUtils.isEmpty(this.f208210d.peerUin)) {
                        FileManagerEntity fileManagerEntity2 = this.f208210d;
                        teamWorkFileImportInfo.f292070d = fileManagerEntity2.peerType;
                        teamWorkFileImportInfo.f292072e = fileManagerEntity2.peerUin;
                        teamWorkFileImportInfo.F = String.valueOf(fileManagerEntity2.TroopUin);
                        FileManagerEntity fileManagerEntity3 = this.f208210d;
                        teamWorkFileImportInfo.C = fileManagerEntity3.strTroopFilePath;
                        teamWorkFileImportInfo.D = fileManagerEntity3.busId;
                        teamWorkFileImportInfo.f292079i = fileManagerEntity3.uniseq;
                        if (fileManagerEntity3.status != 16) {
                            teamWorkFileImportInfo.I = true;
                        }
                    }
                    u.e(teamWorkFileImportInfo, this.f208211e, qQAppInterface, teamWorkFileImportInfo.J);
                    u.d dVar = this.f208213h;
                    if (dVar != null) {
                        dVar.a(teamWorkFileImportInfo);
                    }
                }
            } else {
                QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(R.string.hy5), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static Intent b(Intent intent) {
        return BaseAIOUtils.m(intent, null);
    }

    public static View.OnClickListener c(com.tencent.mobileqq.filemanager.fileviewer.g gVar, FileManagerEntity fileManagerEntity) {
        return new j(fileManagerEntity, gVar);
    }

    public static View.OnClickListener d(com.tencent.mobileqq.filemanager.fileviewer.g gVar, FileManagerEntity fileManagerEntity, Activity activity) {
        return new i(fileManagerEntity, activity);
    }

    public static View.OnClickListener e(FileManagerEntity fileManagerEntity, Activity activity) {
        return f(fileManagerEntity, activity, false, null);
    }

    public static View.OnClickListener f(FileManagerEntity fileManagerEntity, Activity activity, boolean z16, u.d dVar) {
        return new n(fileManagerEntity, activity, z16, dVar);
    }

    public static View.OnClickListener g(Activity activity, Bundle bundle, FileManagerEntity fileManagerEntity) {
        return new b(activity, bundle, fileManagerEntity);
    }

    public static View.OnClickListener h(long j3, com.tencent.mobileqq.filemanager.fileviewer.g gVar, String str) {
        return new a(str, gVar, j3);
    }

    public static MessageRecord i(long j3, String str, int i3, String str2) {
        MessageRecord messageRecord;
        QQAppInterface l3 = l();
        if (j3 != 0) {
            messageRecord = m(l3).w0(str, i3, j3);
        } else {
            messageRecord = null;
        }
        if (messageRecord == null && str2 != null) {
            if (i3 == 1) {
                MessageRecord w3 = w(m(l3), str, i3, str2);
                if (w3 == null) {
                    if (str2.contains("/")) {
                        str2 = str2.substring(1);
                    } else {
                        str2 = "/" + str2;
                    }
                    messageRecord = w(m(l3), str, i3, str2);
                } else {
                    messageRecord = w3;
                }
            } else {
                messageRecord = x(l3, str, i3, str2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FileOperaterUtils", 2, "8.4.10-FileLocation --- [strFilePath]= " + str2 + " [uniseq]= " + j3);
            if (messageRecord == null) {
                QLog.d("FileOperaterUtils", 2, "8.4.10-FileLocation --- MessageRecord is Null");
            } else {
                QLog.d("FileOperaterUtils", 2, "8.4.10-FileLocation --- \uff1b\u3010shmsgseq\u3011" + messageRecord.shmsgseq + "\uff1b [time] = " + messageRecord.time);
            }
        }
        return messageRecord;
    }

    public static View.OnClickListener j(com.tencent.mobileqq.filemanager.fileviewer.g gVar, FileManagerEntity fileManagerEntity) {
        return new g(fileManagerEntity, gVar);
    }

    public static View.OnClickListener k(Activity activity, String str) {
        return new f(activity, str);
    }

    public static QQAppInterface l() {
        return (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
    }

    public static QQMessageFacade m(QQAppInterface qQAppInterface) {
        return qQAppInterface.getMessageFacade();
    }

    public static View.OnClickListener n(final Activity activity, final String str, final long j3, final String str2) {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.v(activity, j3, str2, str, view);
            }
        };
    }

    public static View.OnClickListener o(Activity activity, String str) {
        return new e(activity, str);
    }

    public static View.OnClickListener p(Activity activity, FileManagerEntity fileManagerEntity, String str) {
        return new ViewOnClickListenerC7562c(activity, fileManagerEntity, str);
    }

    public static View.OnClickListener q(Activity activity, FileManagerEntity fileManagerEntity, String str) {
        return new d(activity, fileManagerEntity, str);
    }

    public static View.OnClickListener r(com.tencent.mobileqq.filemanager.fileviewer.g gVar, FileManagerEntity fileManagerEntity) {
        return new l(gVar, fileManagerEntity);
    }

    public static View.OnClickListener s(com.tencent.mobileqq.filemanager.fileviewer.g gVar, FileManagerEntity fileManagerEntity) {
        return new m(gVar, fileManagerEntity);
    }

    public static View.OnClickListener t(Activity activity, String str) {
        return new k(activity, str);
    }

    public static void u(Activity activity, Bundle bundle, FileManagerEntity fileManagerEntity) {
        int i3;
        String str;
        String str2;
        String str3 = fileManagerEntity.peerUin;
        if (fileManagerEntity.TroopUin != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            str = fileManagerEntity.strTroopFilePath;
        } else {
            str = fileManagerEntity.strFilePath;
        }
        long j3 = fileManagerEntity.uniseq;
        if (j3 == -1 && fileManagerEntity.fileName == null && fileManagerEntity.fileSize == 0) {
            QQToast.makeText(activity, 1, R.string.f187373tt, 0).show();
            return;
        }
        MessageRecord i16 = i(j3, str3, i3, str);
        if (i16 == null) {
            if (str == null) {
                QQToast.makeText(activity, 1, R.string.f187373tt, 0).show();
                return;
            } else {
                QQToast.makeText(activity, 1, R.string.f187363ts, 0).show();
                return;
            }
        }
        int i17 = bundle.getInt("file_location_pos_entrance_type", 0);
        ReportController.o(null, "dc00898", "", "", "0X800B451", "0X800B451", i17, 0, "", "", "", "");
        if (i17 == 3) {
            return;
        }
        bundle.putBoolean("need_jump_to_msg", true);
        long j16 = i16.shmsgseq;
        if (i17 == 1) {
            j16 = i16.time;
        }
        bundle.putLong(AppConstants.Key.KEY_SEARCHED_TIMEORSEQ, j16);
        bundle.putLong(AppConstants.Key.KEY_SEARCHED_TIME, i16.time);
        bundle.putBoolean(AppConstants.Key.KEY_SEARCHED_UPDATE_SESSION, true);
        bundle.putBoolean("jump_from_shmsgseq", true);
        Intent intent = new Intent();
        if (i17 != 1 && i17 != 4) {
            intent.putExtras(bundle);
            activity.setResult(-1, intent);
            activity.finish();
            return;
        }
        if (i3 != 0) {
            str2 = String.valueOf(fileManagerEntity.TroopUin);
        } else {
            str2 = str3;
        }
        intent.setComponent(SplashActivity.getAliasComponent(activity));
        Intent b16 = b(intent);
        b16.putExtras(bundle);
        b16.putExtra("uin", str3);
        b16.putExtra("uintype", i3);
        b16.putExtra("troop_uin", str2);
        b16.putExtra("file_location_pos_chatpie_sign", 0);
        b16.addFlags(603979776);
        b16.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
        activity.startActivity(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Activity activity, long j3, String str, String str2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (activity == null) {
            QLog.e("FileOperaterUtils", 1, "activity is null!");
        } else if (!SdCardUtil.sdCardExists()) {
            QLog.e("FileOperaterUtils", 1, "sdcard is not exist!");
        } else if (SdCardUtil.getAvailableInternalMemorySize() < j3) {
            QQToast.makeText(activity, R.string.f1353701_, 1).show();
            QLog.e("FileOperaterUtils", 1, "sdcard available size is not enough!");
        } else if (!cq.n(str)) {
            QLog.e("FileOperaterUtils", 1, "path file is not exist!");
        } else if (PermissionUtil.isHasStorageReadAndWritePermission(activity)) {
            au.g().r(activity, str2, str, j3);
            QLog.d("FileOperaterUtils", 1, "has storage permission!");
        } else {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FILE, QQPermissionConstants.Business.SCENE.QQ_FILE_MY_FILE_SAVE)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new h(activity, str2, str, j3));
            QLog.d("FileOperaterUtils", 1, "is not storage permission!");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static MessageRecord w(QQMessageFacade qQMessageFacade, String str, int i3, String str2) {
        List<MessageRecord> Q;
        if (str2 == null || str == null || str.length() == 0 || (Q = qQMessageFacade.Q(str, i3)) == null) {
            return null;
        }
        for (MessageRecord messageRecord : Q) {
            if ((messageRecord instanceof MessageForTroopFile) && str2.equals(((MessageForTroopFile) messageRecord).url)) {
                return messageRecord;
            }
        }
        return null;
    }

    public static MessageRecord x(QQAppInterface qQAppInterface, String str, int i3, String str2) {
        List<MessageRecord> Q = m(qQAppInterface).Q(str, i3);
        if (Q != null) {
            for (MessageRecord messageRecord : Q) {
                if (!TextUtils.isEmpty(messageRecord.f203106msg) && messageRecord.f203106msg.contains("|")) {
                    String str3 = messageRecord.f203106msg;
                    if (str2.equals(str3.substring(0, str3.indexOf("|")).trim())) {
                        return messageRecord;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static void y(Activity activity, FileManagerEntity fileManagerEntity, TroopFileTransferManager.c cVar) {
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            t n3 = TroopFileUtils.n(qQAppInterface, fileManagerEntity);
            if (n3.f294985s == null) {
                return;
            }
            if (NetworkUtil.getSystemNetwork(activity) == 0) {
                TroopFileError.k(activity, activity.getString(R.string.ers));
            } else {
                TroopFileError.l(activity, activity.getString(R.string.f170978be3), 0);
                TroopFileTransferManager.O(qQAppInterface, fileManagerEntity.TroopUin).w0(n3.f294985s, n3.f294987u, n3.f294976j, n3.f294988v, cVar);
            }
        } catch (Exception unused) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f208176d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.g f208177e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f208178f;

        a(String str, com.tencent.mobileqq.filemanager.fileviewer.g gVar, long j3) {
            this.f208176d = str;
            this.f208177e = gVar;
            this.f208178f = j3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            try {
                C7561a c7561a = new C7561a();
                kc1.b d16 = kc1.a.d(this.f208176d);
                if (d16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.f208176d + "]");
                    }
                } else if (d16.c(false)) {
                    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
                        com.tencent.mobileqq.filemanager.util.d.e(R.string.bqf);
                    } else {
                        FMDialogUtil.a(this.f208177e.getActivity(), R.string.b_v, R.string.b_y, c7561a);
                    }
                } else {
                    c7561a.b();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7561a implements FMDialogUtil.c {
            C7561a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                qQAppInterface.getFileManagerEngine().F0(a.this.f208176d, null, qQAppInterface.getAccount(), "", 0, false);
                FileManagerUtil.getFileName(a.this.f208176d);
                com.tencent.mobileqq.filemanager.util.d.d(QBaseActivity.sTopActivity.getString(R.string.f170978be3));
                com.tencent.mobileqq.filemanager.fileviewer.g gVar = a.this.f208177e;
                if (gVar != null && gVar.N()) {
                    FileManagerUtil.processAIOTimGraytips(qQAppInterface, a.this.f208178f);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f208189d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f208190e;

        e(Activity activity, String str) {
            this.f208189d = activity;
            this.f208190e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(null, "dc00898", "", "", "0X800AEE0", "0X800AEE0", 0, 0, "", "", "", "");
            if (this.f208189d != null) {
                long m3 = q.m(this.f208190e);
                WXShareHelper b06 = WXShareHelper.b0();
                if (m3 <= 10485760) {
                    b06.t0(this.f208190e, BitmapFactory.decodeResource(this.f208189d.getResources(), FileManagerUtil.getFileIconResId(this.f208190e)));
                    ReportController.o(null, "dc00898", "", "", "0X800AEE1", "0X800AEE1", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X800AEE2", "0X800AEE2", 0, 0, "", "", "", "");
                    if (((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).isFlashTransferFile(this.f208190e)) {
                        QQToast.makeText(this.f208189d, 1, ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getShareWeChatOverSizeResId(this.f208190e), 0).show();
                    } else {
                        FMDialogUtil.b(this.f208189d, "", R.string.f187243tg, new a());
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                ReportController.o(null, "dc00898", "", "", "0X800AEE3", "0X800AEE3", 0, 0, "", "", "", "");
                e eVar = e.this;
                LinkByWeiyunFragment.th(eVar.f208189d, null, eVar.f208190e, false);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }
}
