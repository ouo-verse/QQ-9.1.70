package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.IRelyClassCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkFileImportHandlerImpl extends BusinessHandler implements Handler.Callback, ITeamWorkFileImportHandler {
    public static final int MSG_FILE_CHECK_ERROR = 8005;
    public static final int MSG_FILE_CHECK_SUCCESS = 8004;
    public static final int MSG_FILE_IMPORTING = 8003;
    public static final int MSG_FILE_IMPORT_ERROR = 8002;
    public static final int MSG_FILE_IMPORT_SUCCESS = 8001;
    public static final int OBSERVER_FILE_IMPORT_FAILED = 2;
    public static final int OBSERVER_FILE_IMPORT_GET_DOT = 3;
    public static final int OBSERVER_FILE_IMPORT_IS_NEW_TENCENT_DOC = 5;
    public static final int OBSERVER_FILE_IMPORT_STARTED = 4;
    public static final int OBSERVER_FILE_IMPORT_SUCCESS = 1;
    public static final int OBSERVER_FILE_IS_IMPORTED = 6;
    public static final int OBSERVER_FILE_IS_NO_CACHE = 7;
    public static final int RETCODE_CGI_NOT_RETURN = -1000;
    public static final int RETCODE_CGI_NO_PUBLIC_CACHE = 20003;
    public static final int RETCODE_CGI_NO_USER_CACHE = 20004;
    public static final int RETCODE_CGI_NO_USER_CACHE_FOR_DISCUSS = 20005;
    public static final String TAG = "TeamWorkFileImportHandlerImpl";
    private AppInterface app;
    private volatile boolean isNeedToast;
    private volatile boolean isWorderRunning;
    private ConcurrentHashMap<String, String> mFileConvertedMap;
    private ConcurrentHashMap<String, String> mFileConvertedMapForDiscuss;
    private ConcurrentLinkedQueue<com.tencent.mobileqq.teamwork.api.a> mFileImportInfoWorker;
    private ConcurrentHashMap<String, TeamWorkFileImportInfo> mFileImportingInfoMap;
    private ConcurrentHashMap<String, TeamWorkFileImportInfo> mFileImportingInfoMapForDiscuss;
    private Handler mUIHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$10, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass10 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291691d;

        AnonymousClass10(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f291691d = teamWorkFileImportInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, long j3, Object obj) {
            boolean z16;
            String str;
            int i3;
            long currentTimeMillis = System.currentTimeMillis();
            int i16 = 1;
            if (obj instanceof String) {
                z16 = TeamWorkFileImportHandlerImpl.this.parseFileImportResultForH5((String) obj, teamWorkFileImportInfo);
                try {
                    str = new JSONObject((String) obj).getString("url");
                } catch (Exception e16) {
                    QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e16.toString());
                }
                String qqStr = HardCodeUtil.qqStr(R.string.u1g);
                i3 = teamWorkFileImportInfo.R;
                if (i3 != 3) {
                    qqStr = "word";
                } else if (i3 == 6) {
                    qqStr = "excel";
                } else if (i3 == 7) {
                    qqStr = FileReaderHelper.PPT_EXT;
                } else if (i3 == 9) {
                    qqStr = FileReaderHelper.PDF_EXT;
                }
                String str2 = qqStr;
                AppInterface appInterface = TeamWorkFileImportHandlerImpl.this.app;
                if (!z16) {
                    i16 = 2;
                }
                ReportController.o(appInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i16, (currentTimeMillis - j3) + "", "", str2, str);
                if (z16 && TeamWorkFileImportHandlerImpl.this.mUIHandler != null) {
                    Message obtainMessage = TeamWorkFileImportHandlerImpl.this.mUIHandler.obtainMessage(8002);
                    obtainMessage.obj = teamWorkFileImportInfo;
                    TeamWorkFileImportHandlerImpl.this.mUIHandler.sendMessage(obtainMessage);
                    return;
                }
            }
            z16 = false;
            str = "";
            String qqStr2 = HardCodeUtil.qqStr(R.string.u1g);
            i3 = teamWorkFileImportInfo.R;
            if (i3 != 3) {
            }
            String str22 = qqStr2;
            AppInterface appInterface2 = TeamWorkFileImportHandlerImpl.this.app;
            if (!z16) {
            }
            ReportController.o(appInterface2, "dc00898", "", "", "0X8009958", "0X8009958", 0, i16, (currentTimeMillis - j3) + "", "", str22, str);
            if (z16) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            TeamWorkFileImportInfo teamWorkFileImportInfo;
            if (TeamWorkFileImportHandlerImpl.this.app != null && (teamWorkFileImportInfo = this.f291691d) != null && !TextUtils.isEmpty(teamWorkFileImportInfo.f292077h)) {
                final long currentTimeMillis = System.currentTimeMillis();
                ITeamWorkHttpUtils iTeamWorkHttpUtils = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
                TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f291691d;
                String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
                final TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f291691d;
                iTeamWorkHttpUtils.uploadFileForH5(teamWorkFileImportInfo2, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.x
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        TeamWorkFileImportHandlerImpl.AnonymousClass10.this.b(teamWorkFileImportInfo3, currentTimeMillis, obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$11, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass11 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291692d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f291693e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f291694f;

        AnonymousClass11(TeamWorkFileImportInfo teamWorkFileImportInfo, JSONObject jSONObject, int i3) {
            this.f291692d = teamWorkFileImportInfo;
            this.f291693e = jSONObject;
            this.f291694f = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, int i3, long j3, Object obj) {
            String str;
            boolean z16;
            int i16;
            long currentTimeMillis = System.currentTimeMillis();
            if (teamWorkFileImportInfo.f292082k0 != i3) {
                QLog.w(TeamWorkFileImportHandlerImpl.TAG, 2, "this job has dropped " + i3);
                return;
            }
            if (!(obj instanceof String)) {
                str = "";
                z16 = false;
            } else {
                z16 = TeamWorkFileImportHandlerImpl.this.parseFileImportResultForH5((String) obj, teamWorkFileImportInfo);
                try {
                    str = new JSONObject((String) obj).getString("url");
                } catch (Exception e16) {
                    QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e16.toString());
                    str = "";
                }
            }
            String qqStr = HardCodeUtil.qqStr(R.string.u1g);
            int i17 = teamWorkFileImportInfo.R;
            if (i17 == 3) {
                qqStr = "word";
            } else if (i17 == 6) {
                qqStr = "excel";
            } else if (i17 == 7) {
                qqStr = FileReaderHelper.PPT_EXT;
            } else if (i17 == 9) {
                qqStr = FileReaderHelper.PDF_EXT;
            }
            String str2 = qqStr;
            long j16 = currentTimeMillis - j3;
            AppInterface appInterface = TeamWorkFileImportHandlerImpl.this.app;
            if (z16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ReportController.o(appInterface, "dc00898", "", "", "0X8009958", "0X8009958", 0, i16, j16 + "", "", str2, str);
            lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "http duration", String.valueOf(j16), teamWorkFileImportInfo.X);
            if (!z16) {
                if (com.tencent.mobileqq.filemanager.util.q.f(teamWorkFileImportInfo.f292077h)) {
                    TeamWorkFileImportHandlerImpl.this.removeFileImporting(teamWorkFileImportInfo);
                    teamWorkFileImportInfo.I = false;
                    TeamWorkFileImportHandlerImpl.this.addFileImportJob(teamWorkFileImportInfo);
                } else if (TeamWorkFileImportHandlerImpl.this.mUIHandler != null) {
                    Message obtainMessage = TeamWorkFileImportHandlerImpl.this.mUIHandler.obtainMessage(8002);
                    obtainMessage.obj = teamWorkFileImportInfo;
                    TeamWorkFileImportHandlerImpl.this.mUIHandler.sendMessage(obtainMessage);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app != null && this.f291692d != null) {
                final long currentTimeMillis = System.currentTimeMillis();
                ITeamWorkHttpUtils iTeamWorkHttpUtils = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
                JSONObject jSONObject = this.f291693e;
                TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291692d;
                String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
                final TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f291692d;
                final int i3 = this.f291694f;
                iTeamWorkHttpUtils.uploadFileInfoForH5(jSONObject, teamWorkFileImportInfo, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.y
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        TeamWorkFileImportHandlerImpl.AnonymousClass11.this.b(teamWorkFileImportInfo2, i3, currentTimeMillis, obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$12, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass12 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291695d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ITeamWorkFileImportHandler.a f291696e;

        AnonymousClass12(TeamWorkFileImportInfo teamWorkFileImportInfo, ITeamWorkFileImportHandler.a aVar) {
            this.f291695d = teamWorkFileImportInfo;
            this.f291696e = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, AppRuntime appRuntime, long j3, ITeamWorkFileImportHandler.a aVar, Object obj) {
            boolean z16;
            String str;
            JSONObject jSONObject;
            int i3;
            JSONObject jSONObject2;
            String str2;
            long currentTimeMillis = System.currentTimeMillis();
            int i16 = 1;
            if (obj instanceof String) {
                z16 = TeamWorkFileImportHandlerImpl.this.parseFileImportResult((String) obj, teamWorkFileImportInfo);
                try {
                    jSONObject2 = new JSONObject((String) obj);
                    try {
                        teamWorkFileImportInfo.T = jSONObject2.getInt("ret");
                        str2 = jSONObject2.getString("url");
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                TeamWorkFileImportHandlerImpl.this.addToConvertedMap(teamWorkFileImportInfo, str2);
                            }
                        } catch (Exception e16) {
                            e = e16;
                            teamWorkFileImportInfo.T = -1000;
                            QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e.toString());
                            str = str2;
                            jSONObject = jSONObject2;
                            String qqStr = HardCodeUtil.qqStr(R.string.u1g);
                            i3 = teamWorkFileImportInfo.R;
                            if (i3 == 3) {
                            }
                            String str3 = qqStr;
                            int i17 = teamWorkFileImportInfo.J;
                            if (!z16) {
                            }
                            ReportController.o(appRuntime, "dc00898", "", "", "0X8009955", "0X8009955", i17, i16, (currentTimeMillis - j3) + "", "", str3, str);
                            if (aVar != null) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str2 = "";
                        teamWorkFileImportInfo.T = -1000;
                        QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e.toString());
                        str = str2;
                        jSONObject = jSONObject2;
                        String qqStr2 = HardCodeUtil.qqStr(R.string.u1g);
                        i3 = teamWorkFileImportInfo.R;
                        if (i3 == 3) {
                        }
                        String str32 = qqStr2;
                        int i172 = teamWorkFileImportInfo.J;
                        if (!z16) {
                        }
                        ReportController.o(appRuntime, "dc00898", "", "", "0X8009955", "0X8009955", i172, i16, (currentTimeMillis - j3) + "", "", str32, str);
                        if (aVar != null) {
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    jSONObject2 = null;
                }
                str = str2;
                jSONObject = jSONObject2;
            } else {
                teamWorkFileImportInfo.T = -1000;
                lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "local file network fail", teamWorkFileImportInfo.X);
                z16 = false;
                str = "";
                jSONObject = null;
            }
            String qqStr22 = HardCodeUtil.qqStr(R.string.u1g);
            i3 = teamWorkFileImportInfo.R;
            if (i3 == 3) {
                qqStr22 = "word";
            } else if (i3 == 6) {
                qqStr22 = "excel";
            } else if (i3 == 7) {
                qqStr22 = FileReaderHelper.PPT_EXT;
            } else if (i3 == 9) {
                qqStr22 = FileReaderHelper.PDF_EXT;
            }
            String str322 = qqStr22;
            int i1722 = teamWorkFileImportInfo.J;
            if (!z16) {
                i16 = 2;
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X8009955", "0X8009955", i1722, i16, (currentTimeMillis - j3) + "", "", str322, str);
            if (aVar != null) {
                aVar.a(teamWorkFileImportInfo.T, "", jSONObject);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            String str;
            this.f291695d.Y = 1;
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            boolean b16 = this.f291695d.b();
            boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(this.f291695d.f292077h);
            if (fileExistsAndNotEmpty) {
                ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
                Map<String, Long> a16 = TencentDocPreviewConfigProcessor.c().a();
                TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291695d;
                if (iTeamWorkUtils.supportTencentDoc(a16, teamWorkFileImportInfo.f292077h, teamWorkFileImportInfo.f292074f, teamWorkFileImportInfo.f292078h0)) {
                    z16 = true;
                    if (b16 && (peekAppRuntime == null || !fileExistsAndNotEmpty || !z16)) {
                        lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "filePath is null or app is null", this.f291695d.X);
                        if (this.f291696e != null) {
                            if (!fileExistsAndNotEmpty) {
                                str = BaseApplication.getContext().getString(R.string.hy_);
                            } else if (!z16) {
                                BaseApplication.getContext();
                                str = BaseApplication.getContext().getString(R.string.f173198hy3);
                            } else {
                                str = "";
                            }
                            this.f291696e.a(-1, str, null);
                            return;
                        }
                        return;
                    }
                    if (peekAppRuntime != null) {
                        QLog.i(TeamWorkFileImportHandlerImpl.TAG, 1, "[getLocalFileImportInfo] app is null");
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    ITeamWorkHttpUtils iTeamWorkHttpUtils = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
                    TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f291695d;
                    String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
                    final TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f291695d;
                    final ITeamWorkFileImportHandler.a aVar = this.f291696e;
                    iTeamWorkHttpUtils.uploadFile(teamWorkFileImportInfo2, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.z
                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                        public final void a(Object obj) {
                            TeamWorkFileImportHandlerImpl.AnonymousClass12.this.b(teamWorkFileImportInfo3, peekAppRuntime, currentTimeMillis, aVar, obj);
                        }
                    });
                    return;
                }
            }
            z16 = false;
            if (b16) {
            }
            if (peekAppRuntime != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291697d;

        AnonymousClass2(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f291697d = teamWorkFileImportInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, long j3, Object obj) {
            boolean z16;
            String str;
            int i3;
            long currentTimeMillis = System.currentTimeMillis();
            int i16 = 1;
            if (obj instanceof String) {
                z16 = TeamWorkFileImportHandlerImpl.this.parseFileImportResult((String) obj, teamWorkFileImportInfo);
                try {
                    str = new JSONObject((String) obj).getString("url");
                } catch (Exception e16) {
                    QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e16.toString());
                }
                String qqStr = HardCodeUtil.qqStr(R.string.u1g);
                i3 = teamWorkFileImportInfo.R;
                if (i3 != 3) {
                    qqStr = "word";
                } else if (i3 == 6) {
                    qqStr = "excel";
                } else if (i3 == 7) {
                    qqStr = FileReaderHelper.PPT_EXT;
                } else if (i3 == 9) {
                    qqStr = FileReaderHelper.PDF_EXT;
                }
                String str2 = qqStr;
                AppInterface appInterface = TeamWorkFileImportHandlerImpl.this.app;
                int i17 = teamWorkFileImportInfo.J;
                if (!z16) {
                    i16 = 2;
                }
                ReportController.o(appInterface, "dc00898", "", "", "0X8009955", "0X8009955", i17, i16, (currentTimeMillis - j3) + "", "", str2, str);
                if (z16 && TeamWorkFileImportHandlerImpl.this.mUIHandler != null) {
                    Message obtainMessage = TeamWorkFileImportHandlerImpl.this.mUIHandler.obtainMessage(8002);
                    obtainMessage.obj = teamWorkFileImportInfo;
                    TeamWorkFileImportHandlerImpl.this.mUIHandler.sendMessage(obtainMessage);
                    return;
                }
            }
            teamWorkFileImportInfo.T = -1000;
            lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "local file network fail", teamWorkFileImportInfo.X);
            z16 = false;
            str = "";
            String qqStr2 = HardCodeUtil.qqStr(R.string.u1g);
            i3 = teamWorkFileImportInfo.R;
            if (i3 != 3) {
            }
            String str22 = qqStr2;
            AppInterface appInterface2 = TeamWorkFileImportHandlerImpl.this.app;
            int i172 = teamWorkFileImportInfo.J;
            if (!z16) {
            }
            ReportController.o(appInterface2, "dc00898", "", "", "0X8009955", "0X8009955", i172, i16, (currentTimeMillis - j3) + "", "", str22, str);
            if (z16) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            boolean b16 = this.f291697d.b();
            boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(this.f291697d.f292077h);
            if (fileExistsAndNotEmpty) {
                ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
                Map<String, Long> a16 = TencentDocPreviewConfigProcessor.c().a();
                TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291697d;
                if (iTeamWorkUtils.supportTencentDoc(a16, teamWorkFileImportInfo.f292077h, teamWorkFileImportInfo.f292074f, teamWorkFileImportInfo.f292078h0)) {
                    z16 = true;
                    if ((b16 && (!fileExistsAndNotEmpty || !z16)) || TeamWorkFileImportHandlerImpl.this.app == null) {
                        lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "filePath is null or app is null", this.f291697d.X);
                        if (TeamWorkFileImportHandlerImpl.this.mUIHandler != null) {
                            Message obtainMessage = TeamWorkFileImportHandlerImpl.this.mUIHandler.obtainMessage(8002);
                            TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f291697d;
                            obtainMessage.obj = teamWorkFileImportInfo2;
                            if (!fileExistsAndNotEmpty) {
                                teamWorkFileImportInfo2.U = BaseApplication.getContext().getString(R.string.hy_);
                            } else if (!z16) {
                                teamWorkFileImportInfo2.U = BaseApplication.getContext().getString(R.string.f173198hy3);
                            }
                            TeamWorkFileImportHandlerImpl.this.mUIHandler.sendMessage(obtainMessage);
                            return;
                        }
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    ITeamWorkHttpUtils iTeamWorkHttpUtils = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
                    TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f291697d;
                    String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
                    final TeamWorkFileImportInfo teamWorkFileImportInfo4 = this.f291697d;
                    iTeamWorkHttpUtils.uploadFile(teamWorkFileImportInfo3, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.aa
                        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                        public final void a(Object obj) {
                            TeamWorkFileImportHandlerImpl.AnonymousClass2.this.b(teamWorkFileImportInfo4, currentTimeMillis, obj);
                        }
                    });
                }
            }
            z16 = false;
            if (b16) {
            }
            final long currentTimeMillis2 = System.currentTimeMillis();
            ITeamWorkHttpUtils iTeamWorkHttpUtils2 = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
            TeamWorkFileImportInfo teamWorkFileImportInfo32 = this.f291697d;
            String currentAccountUin2 = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
            final TeamWorkFileImportInfo teamWorkFileImportInfo42 = this.f291697d;
            iTeamWorkHttpUtils2.uploadFile(teamWorkFileImportInfo32, currentAccountUin2, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.aa
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkFileImportHandlerImpl.AnonymousClass2.this.b(teamWorkFileImportInfo42, currentTimeMillis2, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291698d;

        AnonymousClass3(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f291698d = teamWorkFileImportInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, Object obj) {
            boolean z16;
            if (obj instanceof String) {
                z16 = TeamWorkFileImportHandlerImpl.this.parseFileImportResult((String) obj, teamWorkFileImportInfo);
                if (z16) {
                    ReportController.o(TeamWorkFileImportHandlerImpl.this.app, "dc00898", "", "", "0X80098F9", "0X80098F9", 0, 0, "", "", "", "");
                }
            } else {
                lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "local file dataLine parse no result string", teamWorkFileImportInfo.X);
                z16 = false;
            }
            if (!z16 && TeamWorkFileImportHandlerImpl.this.mUIHandler != null) {
                Message obtainMessage = TeamWorkFileImportHandlerImpl.this.mUIHandler.obtainMessage(8002);
                obtainMessage.obj = teamWorkFileImportInfo;
                TeamWorkFileImportHandlerImpl.this.mUIHandler.sendMessage(obtainMessage);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app != null && !TextUtils.isEmpty(this.f291698d.f292077h)) {
                ITeamWorkHttpUtils iTeamWorkHttpUtils = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
                TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291698d;
                String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
                final TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f291698d;
                iTeamWorkHttpUtils.uploadFile(teamWorkFileImportInfo, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ab
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        TeamWorkFileImportHandlerImpl.AnonymousClass3.this.b(teamWorkFileImportInfo2, obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$4, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f291699d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291700e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f291701f;

        AnonymousClass4(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, int i3) {
            this.f291699d = jSONObject;
            this.f291700e = teamWorkFileImportInfo;
            this.f291701f = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, int i3, long j3, Object obj) {
            String str;
            boolean z16;
            int i16;
            int i17;
            long currentTimeMillis = System.currentTimeMillis();
            if (teamWorkFileImportInfo.f292082k0 != i3) {
                QLog.w(TeamWorkFileImportHandlerImpl.TAG, 2, "this job has dropped " + i3);
                return;
            }
            if (obj instanceof String) {
                z16 = TeamWorkFileImportHandlerImpl.this.parseFileImportResult((String) obj, teamWorkFileImportInfo);
                try {
                    str = new JSONObject((String) obj).getString("url");
                } catch (Exception e16) {
                    QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e16.toString());
                    str = "";
                }
            } else {
                lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "url import no result string", teamWorkFileImportInfo.X);
                str = "";
                z16 = false;
            }
            String qqStr = HardCodeUtil.qqStr(R.string.u1g);
            int i18 = teamWorkFileImportInfo.R;
            if (i18 == 3) {
                qqStr = "word";
            } else if (i18 == 6) {
                qqStr = "excel";
            } else if (i18 == 7) {
                qqStr = FileReaderHelper.PPT_EXT;
            } else if (i18 == 9) {
                qqStr = FileReaderHelper.PDF_EXT;
            }
            String str2 = qqStr;
            long j16 = currentTimeMillis - j3;
            AppInterface appInterface = TeamWorkFileImportHandlerImpl.this.app;
            int i19 = teamWorkFileImportInfo.J;
            if (z16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ReportController.o(appInterface, "dc00898", "", "", "0X8009955", "0X8009955", i19, i16, j16 + "", "", str2, str);
            lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "http duration", String.valueOf(j16), teamWorkFileImportInfo.X);
            if (!z16) {
                if (!teamWorkFileImportInfo.b() && com.tencent.mobileqq.filemanager.util.q.f(teamWorkFileImportInfo.f292077h)) {
                    lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "url import fail, try local file import", teamWorkFileImportInfo.X);
                    TeamWorkFileImportHandlerImpl.this.removeFileImporting(teamWorkFileImportInfo);
                    try {
                    } catch (JSONException e17) {
                        QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e17.toString());
                    }
                    if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                        i17 = new JSONObject((String) obj).getInt("ret");
                        if (i17 == 20003 && i17 != 20005) {
                            teamWorkFileImportInfo.I = false;
                            TeamWorkFileImportHandlerImpl.this.addFileImportJob(teamWorkFileImportInfo);
                            return;
                        }
                        return;
                    }
                    i17 = 0;
                    if (i17 == 20003) {
                        return;
                    } else {
                        return;
                    }
                }
                if (TeamWorkFileImportHandlerImpl.this.mUIHandler != null) {
                    Message obtainMessage = TeamWorkFileImportHandlerImpl.this.mUIHandler.obtainMessage(8002);
                    obtainMessage.obj = teamWorkFileImportInfo;
                    TeamWorkFileImportHandlerImpl.this.mUIHandler.sendMessage(obtainMessage);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app == null) {
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (this.f291699d != null && this.f291700e.b() && !this.f291700e.Q) {
                try {
                    this.f291699d.put("cacheKeyType", 1);
                } catch (JSONException unused) {
                }
            }
            ITeamWorkHttpUtils iTeamWorkHttpUtils = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
            JSONObject jSONObject = this.f291699d;
            String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
            AppInterface appInterface = TeamWorkFileImportHandlerImpl.this.app;
            final TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291700e;
            final int i3 = this.f291701f;
            iTeamWorkHttpUtils.uploadFileInfo(jSONObject, currentAccountUin, appInterface, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ac
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkFileImportHandlerImpl.AnonymousClass4.this.b(teamWorkFileImportInfo, i3, currentTimeMillis, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$5, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f291702d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291703e;

        AnonymousClass5(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f291702d = jSONObject;
            this.f291703e = teamWorkFileImportInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, Object obj) {
            String str;
            if (obj instanceof JSONObject) {
                ir2.a a16 = ir2.a.a((JSONObject) obj);
                if (a16 != null && (str = a16.f408426a) != null && a16.f408432g) {
                    teamWorkFileImportInfo.f292083l0 = a16.f408431f;
                    TeamWorkFileImportHandlerImpl.this.notifyUI(6, true, new Object[]{str, a16.f408430e, teamWorkFileImportInfo});
                    return;
                } else {
                    TeamWorkFileImportHandlerImpl.this.notifyUI(7, false, new Object[]{teamWorkFileImportInfo});
                    return;
                }
            }
            TeamWorkFileImportHandlerImpl.this.notifyUIError(teamWorkFileImportInfo);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app == null) {
                return;
            }
            IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
            JSONObject jSONObject = this.f291702d;
            String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
            final TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291703e;
            iGetExternalInterface.checkFormCache(jSONObject, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ad
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkFileImportHandlerImpl.AnonymousClass5.this.b(teamWorkFileImportInfo, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$6, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f291704d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291705e;

        AnonymousClass6(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f291704d = jSONObject;
            this.f291705e = teamWorkFileImportInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, Object obj) {
            if (obj instanceof JSONObject) {
                TeamWorkFileImportHandlerImpl.this.parseFormResult((JSONObject) obj, teamWorkFileImportInfo);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app == null) {
                return;
            }
            IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
            JSONObject jSONObject = this.f291704d;
            String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
            final TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291705e;
            iGetExternalInterface.importFormWithUrl(jSONObject, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ae
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkFileImportHandlerImpl.AnonymousClass6.this.b(teamWorkFileImportInfo, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$7, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f291706d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291707e;

        AnonymousClass7(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f291706d = jSONObject;
            this.f291707e = teamWorkFileImportInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, Object obj) {
            if (obj instanceof JSONObject) {
                TeamWorkFileImportHandlerImpl.this.parseFormResult((JSONObject) obj, teamWorkFileImportInfo);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app == null) {
                return;
            }
            IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
            JSONObject jSONObject = this.f291706d;
            String str = this.f291707e.f292077h;
            String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
            final TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291707e;
            iGetExternalInterface.importFormWithLocalFile(jSONObject, str, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.af
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkFileImportHandlerImpl.AnonymousClass7.this.b(teamWorkFileImportInfo, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$8, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamWorkFileImportInfo f291708d;

        AnonymousClass8(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            this.f291708d = teamWorkFileImportInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(TeamWorkFileImportInfo teamWorkFileImportInfo, Object obj) {
            boolean z16;
            if (obj instanceof String) {
                z16 = TeamWorkFileImportHandlerImpl.this.parseUrl2DocResult((String) obj, teamWorkFileImportInfo);
            } else {
                teamWorkFileImportInfo.T = -1000;
                lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "url2doc network fail", teamWorkFileImportInfo.X);
                z16 = false;
            }
            if (!z16 && TeamWorkFileImportHandlerImpl.this.mUIHandler != null) {
                Message obtainMessage = TeamWorkFileImportHandlerImpl.this.mUIHandler.obtainMessage(8002);
                obtainMessage.obj = teamWorkFileImportInfo;
                TeamWorkFileImportHandlerImpl.this.mUIHandler.sendMessage(obtainMessage);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app != null && !TextUtils.isEmpty(this.f291708d.G)) {
                ITeamWorkHttpUtils iTeamWorkHttpUtils = (ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class);
                TeamWorkFileImportInfo teamWorkFileImportInfo = this.f291708d;
                String currentAccountUin = TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin();
                final TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f291708d;
                iTeamWorkHttpUtils.url2Doc(teamWorkFileImportInfo, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ag
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        TeamWorkFileImportHandlerImpl.AnonymousClass8.this.b(teamWorkFileImportInfo2, obj);
                    }
                });
                return;
            }
            lr2.a.m(TeamWorkFileImportHandlerImpl.TAG, "import fail", "srcUrl is null or app is null", this.f291708d.X);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl$9, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass9 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f291709d;

        AnonymousClass9(String str) {
            this.f291709d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Object obj) {
            int i3;
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                try {
                    JSONObject jSONObject = new JSONObject((String) obj);
                    if (jSONObject.has("TotalUnreadNum")) {
                        i3 = jSONObject.getInt("TotalUnreadNum");
                    } else {
                        i3 = 0;
                    }
                    TeamWorkFileImportHandlerImpl.this.notifyUI(3, true, new Object[]{Integer.valueOf(i3)});
                } catch (JSONException e16) {
                    QLog.e(TeamWorkFileImportHandlerImpl.TAG, 1, e16.toString());
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TeamWorkFileImportHandlerImpl.this.app == null) {
                return;
            }
            ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).getTencentDocReddot(this.f291709d, TeamWorkFileImportHandlerImpl.this.app.getCurrentAccountUin(), new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ah
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkFileImportHandlerImpl.AnonymousClass9.this.b(obj);
                }
            });
        }
    }

    public TeamWorkFileImportHandlerImpl(AppInterface appInterface) {
        super(appInterface);
        this.mUIHandler = new Handler(Looper.getMainLooper(), this);
        this.mFileImportInfoWorker = new ConcurrentLinkedQueue<>();
        this.mFileImportingInfoMap = new ConcurrentHashMap<>();
        this.mFileConvertedMap = new ConcurrentHashMap<>();
        this.mFileImportingInfoMapForDiscuss = new ConcurrentHashMap<>();
        this.mFileConvertedMapForDiscuss = new ConcurrentHashMap<>();
        this.isWorderRunning = false;
        this.isNeedToast = false;
        this.app = appInterface;
    }

    private void addTeamWorkFileImportJob(com.tencent.mobileqq.teamwork.api.a aVar) {
        ConcurrentLinkedQueue<com.tencent.mobileqq.teamwork.api.a> concurrentLinkedQueue = this.mFileImportInfoWorker;
        if (concurrentLinkedQueue != null && aVar != null) {
            concurrentLinkedQueue.add(aVar);
        }
    }

    private void doRequestAfterGetTicket(final Runnable runnable) {
        if (this.app == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.v
            @Override // java.lang.Runnable
            public final void run() {
                TeamWorkFileImportHandlerImpl.lambda$doRequestAfterGetTicket$2(runnable);
            }
        }, 16, null, true);
    }

    public static String getClassName() {
        return TeamWorkFileImportHandlerImpl.class.getName();
    }

    private String getTeamWorkFileImportInfoKey(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo.e()) {
            String h16 = com.tencent.mobileqq.teamwork.u.h(teamWorkFileImportInfo);
            String str = teamWorkFileImportInfo.f292077h;
            String str2 = teamWorkFileImportInfo.f292071d0;
            if (!TextUtils.isEmpty(h16)) {
                return h16;
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if ((str + this.app) == null) {
                return "";
            }
            return this.app.getCurrentAccountUin();
        }
        int i3 = teamWorkFileImportInfo.f292070d;
        if (i3 == 1) {
            return teamWorkFileImportInfo.f292072e + "_" + teamWorkFileImportInfo.C;
        }
        if (i3 != 3000 && i3 != 0) {
            if (!TextUtils.isEmpty(teamWorkFileImportInfo.f292077h)) {
                return teamWorkFileImportInfo.f292077h;
            }
            if (TextUtils.isEmpty(teamWorkFileImportInfo.G)) {
                return "";
            }
            return teamWorkFileImportInfo.G;
        }
        return teamWorkFileImportInfo.f292072e + "_" + teamWorkFileImportInfo.f292079i + "_" + teamWorkFileImportInfo.f292084m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkIfHasBeenConverted$0(TeamWorkFileImportInfo teamWorkFileImportInfo, IGetExternalInterface.d dVar, Object obj) {
        String str;
        boolean z16;
        if (obj instanceof String) {
            str = parseCheckResult((String) obj, teamWorkFileImportInfo);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            addToConvertedMap(teamWorkFileImportInfo, str);
            z16 = true;
        } else {
            z16 = false;
        }
        dVar.a(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doRequestAfterGetTicket$1(Runnable runnable, String str) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.executeOnNetWorkThread(runnable);
        } else {
            QLog.i(TAG, 1, "pskey async is empty, domain: docs.qq.com");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doRequestAfterGetTicket$2(final Runnable runnable) {
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.api.impl.u
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
            public final void a(String str) {
                TeamWorkFileImportHandlerImpl.lambda$doRequestAfterGetTicket$1(runnable, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:(12:6|7|(2:197|198)|9|10|11|12|13|14|15|16|17)|(6:(15:19|(8:21|(2:23|(2:25|(1:27)))(2:55|(19:61|(1:63)(1:112)|64|(4:66|(3:68|(1:70)|(1:73)(2:74|(1:76)(1:(1:80))))(1:81)|71|(0)(0))|82|(1:84)|85|(4:89|(1:91)|92|(1:94))|95|(1:97)|98|99|(1:106)|107|108|31|(4:43|44|45|46)(4:33|34|35|36)|37|39))|29|30|31|(0)(0)|37|39)|113|(1:130)(1:117)|118|(1:129)(1:122)|123|(1:127)|128|29|30|31|(0)(0)|37|39)|(2:161|(1:(1:(1:170)(12:171|172|173|174|175|153|154|30|31|(0)(0)|37|39)))(1:(1:165)(1:166)))(2:(1:149)(1:160)|(1:151)(1:159))|31|(0)(0)|37|39)|131|(1:133)(1:186)|134|135|(1:137)(1:185)|138|(1:140)(1:184)|141|(1:143)(1:183)|144|145|152|153|154|30) */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0671, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0672, code lost:
    
        r2 = "import_type=";
        r6 = "err=";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0604 A[Catch: Exception -> 0x066d, TRY_LEAVE, TryCatch #1 {Exception -> 0x066d, blocks: (B:46:0x05e1, B:33:0x0604), top: B:31:0x05ce }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x05d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a7 A[Catch: Exception -> 0x0115, TryCatch #9 {Exception -> 0x0115, blocks: (B:28:0x00d3, B:52:0x0100, B:53:0x011a, B:54:0x012d, B:55:0x0140, B:57:0x0148, B:59:0x014e, B:61:0x0152, B:63:0x015b, B:64:0x0164, B:66:0x018b, B:71:0x019d, B:73:0x01a7, B:76:0x01b7, B:78:0x01bd, B:80:0x01c5, B:82:0x01e7, B:84:0x01f0, B:85:0x01f7, B:87:0x01fd, B:89:0x0202, B:91:0x0208, B:92:0x020b, B:94:0x0211, B:95:0x021e, B:97:0x0223, B:113:0x02a3, B:115:0x02a9, B:117:0x02b3, B:118:0x02ba, B:120:0x02c0, B:122:0x02ca, B:123:0x02d1, B:125:0x02d7, B:127:0x02e1, B:128:0x02e5, B:133:0x0341, B:137:0x034f, B:140:0x035e, B:143:0x0370, B:149:0x03af, B:151:0x0432, B:159:0x0472, B:160:0x03eb, B:165:0x04bd, B:166:0x04f5, B:170:0x053a), top: B:17:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b4  */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl] */
    /* JADX WARN: Type inference failed for: r5v25, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseFileImportResult(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str2;
        Object obj;
        String str3;
        boolean z16;
        ?? r26;
        boolean z17;
        JSONObject jSONObject;
        int i3;
        String string;
        int i16;
        int i17;
        int i18;
        int i19;
        String excelColIndexToStr;
        String excelColIndexToStr2;
        StringBuilder sb5;
        String str4;
        boolean z18;
        String str5;
        String str6;
        ?? r27;
        int i26;
        int i27;
        long b16 = lr2.a.b(teamWorkFileImportInfo.X);
        lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9A", String.valueOf(b16), "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y, "");
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
                i3 = jSONObject.getInt("ret");
                if (jSONObject.has("msg")) {
                    try {
                        jSONObject.getString("msg");
                    } catch (Exception e16) {
                        e = e16;
                        str2 = "parse import file json fail";
                        r26 = "import_type=";
                        str3 = "err=";
                        z17 = false;
                        QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                        ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                        lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                        lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                        lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                        AppInterface appInterface = this.app;
                        String str7 = teamWorkFileImportInfo.X;
                        String str8 = str3 + e.getMessage();
                        ?? sb6 = new StringBuilder();
                        sb6.append(r26);
                        sb6.append(teamWorkFileImportInfo.f292070d);
                        sb6.append(teamWorkFileImportInfo.J);
                        sb6.append(teamWorkFileImportInfo.Y);
                        lr2.a.i(appInterface, str7, "0X8009E9B", "fail", str8, sb6.toString());
                        return z17;
                    }
                }
                string = jSONObject.getString("error");
                StringBuilder sb7 = new StringBuilder();
                str2 = "parse import file json fail";
                try {
                    sb7.append("addFileImportJob end:");
                    sb7.append(teamWorkFileImportInfo.f292074f);
                    try {
                        lr2.a.m(TAG, sb7.toString(), String.valueOf(System.currentTimeMillis()), teamWorkFileImportInfo.X);
                        try {
                        } catch (Exception e17) {
                            e = e17;
                            r26 = "import_type=";
                            str3 = "err=";
                            z17 = false;
                            QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                            ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                            lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                            lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                            lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                            AppInterface appInterface2 = this.app;
                            String str72 = teamWorkFileImportInfo.X;
                            String str82 = str3 + e.getMessage();
                            ?? sb62 = new StringBuilder();
                            sb62.append(r26);
                            sb62.append(teamWorkFileImportInfo.f292070d);
                            sb62.append(teamWorkFileImportInfo.J);
                            sb62.append(teamWorkFileImportInfo.Y);
                            lr2.a.i(appInterface2, str72, "0X8009E9B", "fail", str82, sb62.toString());
                            return z17;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        obj = "import_type=";
                        str3 = "err=";
                        z16 = false;
                        r26 = obj;
                        z17 = z16;
                        QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                        ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                        lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                        lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                        lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                        AppInterface appInterface22 = this.app;
                        String str722 = teamWorkFileImportInfo.X;
                        String str822 = str3 + e.getMessage();
                        ?? sb622 = new StringBuilder();
                        sb622.append(r26);
                        sb622.append(teamWorkFileImportInfo.f292070d);
                        sb622.append(teamWorkFileImportInfo.J);
                        sb622.append(teamWorkFileImportInfo.Y);
                        lr2.a.i(appInterface22, str722, "0X8009E9B", "fail", str822, sb622.toString());
                        return z17;
                    }
                } catch (Exception e19) {
                    e = e19;
                    obj = "import_type=";
                    str3 = "err=";
                    z16 = false;
                    r26 = obj;
                    z17 = z16;
                    QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                    ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                    lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                    lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                    lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                    AppInterface appInterface222 = this.app;
                    String str7222 = teamWorkFileImportInfo.X;
                    String str8222 = str3 + e.getMessage();
                    ?? sb6222 = new StringBuilder();
                    sb6222.append(r26);
                    sb6222.append(teamWorkFileImportInfo.f292070d);
                    sb6222.append(teamWorkFileImportInfo.J);
                    sb6222.append(teamWorkFileImportInfo.Y);
                    lr2.a.i(appInterface222, str7222, "0X8009E9B", "fail", str8222, sb6222.toString());
                    return z17;
                }
            } catch (Exception e26) {
                e = e26;
                str2 = "parse import file json fail";
            }
            try {
                if (i3 != -116) {
                    String str9 = "";
                    if (i3 != -115) {
                        r27 = 7;
                        r27 = 7;
                        r27 = 7;
                        r26 = 7;
                        r27 = 7;
                        r27 = 7;
                        if (i3 != 0) {
                            if (i3 != 115) {
                                if (i3 != 116) {
                                    switch (i3) {
                                        case 20003:
                                            QLog.i(TAG, 1, " parseFileImportTendoc: RETCODE_CGI_NO_PUBLIC_CACHE");
                                            notifyUI(7, false, new Object[]{teamWorkFileImportInfo});
                                            teamWorkFileImportInfo.Z = 0;
                                            break;
                                        case 20004:
                                            QLog.i(TAG, 1, " parseFileImportTendoc: RETCODE_CGI_NO_USER_CACHE");
                                            notifyUI(7, false, new Object[]{teamWorkFileImportInfo});
                                            teamWorkFileImportInfo.Z = 0;
                                            break;
                                        case 20005:
                                            removeFileImporting(teamWorkFileImportInfo);
                                            removeFromConvertedMap(teamWorkFileImportInfo);
                                            r27 = 1;
                                            notifyUI(5, true, new Object[]{1});
                                            break;
                                        default:
                                            teamWorkFileImportInfo.T = i3;
                                            teamWorkFileImportInfo.U = string;
                                            QLog.e(TAG, 1, "--- parseFileImportResult server ret: " + i3 + ",error: " + teamWorkFileImportInfo.U);
                                            String teamWorkFileImportInfo2 = teamWorkFileImportInfo.toString();
                                            lr2.a.m(TAG, "import file job fail, import info", teamWorkFileImportInfo2, teamWorkFileImportInfo.X);
                                            r27 = teamWorkFileImportInfo2;
                                            break;
                                    }
                                }
                            }
                        } else {
                            String string2 = jSONObject.getString("url");
                            if (this.mUIHandler != null && !TextUtils.isEmpty(string2) && this.app != null) {
                                if (jSONObject.has("urlType")) {
                                    i26 = jSONObject.getInt("urlType");
                                } else {
                                    i26 = 0;
                                }
                                int i28 = teamWorkFileImportInfo.Y;
                                QLog.e(TAG, 1, " parseFileImportResult: " + i26 + ",importOption: " + i28);
                                if (teamWorkFileImportInfo.c()) {
                                    string2 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocWithReadOnlyParam(string2);
                                    if (i26 != 1) {
                                        i27 = 2;
                                        if (i26 == 2) {
                                        }
                                        if (i26 != i27) {
                                            r27 = 1;
                                            QLog.w(TAG, 1, "online preview has edited cache, import again");
                                            teamWorkFileImportInfo.Z = i26;
                                            teamWorkFileImportInfo.f292081j0 = string2;
                                        } else if (i26 == 1) {
                                            teamWorkFileImportInfo.f292081j0 = null;
                                        } else if (i26 == 0 && !TextUtils.isEmpty(teamWorkFileImportInfo.f292081j0)) {
                                            string2 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocWithEditedUrl(string2, teamWorkFileImportInfo.f292081j0);
                                            QLog.w(TAG, 1, "append edited url: " + string2);
                                        }
                                    } else {
                                        i27 = 2;
                                    }
                                    lr2.a.j(this.app, "0X8009ECF");
                                    if (i26 != i27) {
                                    }
                                }
                                if (jSONObject.has("doc_id")) {
                                    str9 = jSONObject.getString("doc_id");
                                }
                                String str10 = str9;
                                if (teamWorkFileImportInfo.Y == 7 && teamWorkFileImportInfo.f292070d == 1) {
                                    if (!TextUtils.isEmpty(str10)) {
                                        getTencentDocReddot(str10);
                                    }
                                    if (!TextUtils.isEmpty(string2)) {
                                        notifyUI(5, true, new Object[]{0});
                                    }
                                }
                                if (teamWorkFileImportInfo.Y == 1) {
                                    notifyUI(6, true, new Object[]{string2, str10, teamWorkFileImportInfo});
                                }
                                try {
                                    teamWorkFileImportInfo.Z = i26;
                                    teamWorkFileImportInfo.f292069c0 = str10;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("url", string2);
                                    bundle.putParcelable("fileInfo", teamWorkFileImportInfo);
                                    Message obtainMessage = this.mUIHandler.obtainMessage(8001);
                                    obtainMessage.setData(bundle);
                                    this.mUIHandler.sendMessage(obtainMessage);
                                    addToConvertedMap(teamWorkFileImportInfo, string2);
                                    if (i28 != 1 && i28 != 7 && !teamWorkFileImportInfo.a() && !teamWorkFileImportInfo.b()) {
                                        createGrayTips(teamWorkFileImportInfo, string2);
                                    }
                                    ReportController.o(this.app, "dc00898", "", "", "0X8009066", "0X8009066", 0, 0, "", "", "", "");
                                    str4 = string;
                                    z17 = true;
                                    if (i3 != 0) {
                                        r26 = "import_type=";
                                        AppInterface appInterface3 = this.app;
                                        String str11 = teamWorkFileImportInfo.X;
                                        StringBuilder sb8 = new StringBuilder();
                                        str3 = "err=";
                                        try {
                                            sb8.append(str3);
                                            sb8.append(i3);
                                            sb8.append(str4);
                                            String sb9 = sb8.toString();
                                            ?? sb10 = new StringBuilder();
                                            sb10.append(r26);
                                            sb10.append(teamWorkFileImportInfo.f292070d);
                                            sb10.append(teamWorkFileImportInfo.J);
                                            sb10.append(teamWorkFileImportInfo.Y);
                                            lr2.a.i(appInterface3, str11, "0X8009E9B", "fail", sb9, sb10.toString());
                                            r26 = r26;
                                        } catch (Exception e27) {
                                            e = e27;
                                            QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                                            ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                                            lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                                            lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                                            lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                                            AppInterface appInterface2222 = this.app;
                                            String str72222 = teamWorkFileImportInfo.X;
                                            String str82222 = str3 + e.getMessage();
                                            ?? sb62222 = new StringBuilder();
                                            sb62222.append(r26);
                                            sb62222.append(teamWorkFileImportInfo.f292070d);
                                            sb62222.append(teamWorkFileImportInfo.J);
                                            sb62222.append(teamWorkFileImportInfo.Y);
                                            lr2.a.i(appInterface2222, str72222, "0X8009E9B", "fail", str82222, sb62222.toString());
                                            return z17;
                                        }
                                    } else {
                                        try {
                                            AppInterface appInterface4 = this.app;
                                            String str12 = teamWorkFileImportInfo.X;
                                            StringBuilder sb11 = new StringBuilder();
                                            String str13 = "import_type=";
                                            sb11.append(str13);
                                            sb11.append(teamWorkFileImportInfo.f292070d);
                                            sb11.append(teamWorkFileImportInfo.J);
                                            sb11.append(teamWorkFileImportInfo.Y);
                                            lr2.a.i(appInterface4, str12, "0X8009E9B", "success", sb11.toString(), "");
                                            str3 = "err=";
                                            r26 = str13;
                                        } catch (Exception e28) {
                                            e = e28;
                                            r26 = "import_type=";
                                            str3 = "err=";
                                            QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                                            ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                                            lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                                            lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                                            lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                                            AppInterface appInterface22222 = this.app;
                                            String str722222 = teamWorkFileImportInfo.X;
                                            String str822222 = str3 + e.getMessage();
                                            ?? sb622222 = new StringBuilder();
                                            sb622222.append(r26);
                                            sb622222.append(teamWorkFileImportInfo.f292070d);
                                            sb622222.append(teamWorkFileImportInfo.J);
                                            sb622222.append(teamWorkFileImportInfo.Y);
                                            lr2.a.i(appInterface22222, str722222, "0X8009E9B", "fail", str822222, sb622222.toString());
                                            return z17;
                                        }
                                    }
                                    lr2.a.m(TAG, "import result", teamWorkFileImportInfo.T + " " + teamWorkFileImportInfo.U, teamWorkFileImportInfo.X);
                                    return z17;
                                } catch (Exception e29) {
                                    e = e29;
                                    r26 = "import_type=";
                                    str3 = "err=";
                                    z17 = true;
                                    QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                                    ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                                    lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                                    lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                                    lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                                    AppInterface appInterface222222 = this.app;
                                    String str7222222 = teamWorkFileImportInfo.X;
                                    String str8222222 = str3 + e.getMessage();
                                    ?? sb6222222 = new StringBuilder();
                                    sb6222222.append(r26);
                                    sb6222222.append(teamWorkFileImportInfo.f292070d);
                                    sb6222222.append(teamWorkFileImportInfo.J);
                                    sb6222222.append(teamWorkFileImportInfo.Y);
                                    lr2.a.i(appInterface222222, str7222222, "0X8009E9B", "fail", str8222222, sb6222222.toString());
                                    return z17;
                                }
                            }
                        }
                        str4 = string;
                        z16 = false;
                        z18 = r27;
                        z17 = z16;
                        r26 = z18;
                        if (i3 != 0) {
                        }
                        lr2.a.m(TAG, "import result", teamWorkFileImportInfo.T + " " + teamWorkFileImportInfo.U, teamWorkFileImportInfo.X);
                        return z17;
                    }
                    if (!jSONObject.has("filePath") || TextUtils.isEmpty(jSONObject.getString("filePath"))) {
                        str5 = "";
                    } else {
                        str5 = jSONObject.getString("filePath");
                    }
                    if (!jSONObject.has("md5") || TextUtils.isEmpty(jSONObject.getString("md5"))) {
                        str6 = "";
                    } else {
                        str6 = jSONObject.getString("md5");
                    }
                    if (jSONObject.has(WadlProxyConsts.PARAM_FILENAME) && !TextUtils.isEmpty(jSONObject.getString(WadlProxyConsts.PARAM_FILENAME))) {
                        str9 = jSONObject.getString(WadlProxyConsts.PARAM_FILENAME);
                    }
                    teamWorkFileImportInfo.V = String.format(com.tencent.mobileqq.teamwork.t.f292412q, URLEncoder.encode(teamWorkFileImportInfo.S, "UTF-8"), URLEncoder.encode(str6, "UTF-8"), URLEncoder.encode(str9, "UTF-8"), URLEncoder.encode(str5, "UTF-8"), "preview");
                    teamWorkFileImportInfo.T = i3;
                    teamWorkFileImportInfo.U = string;
                    r27 = 1;
                    QLog.e(TAG, 1, "--- parseFileImportResult server ret: " + i3 + ",error: " + teamWorkFileImportInfo.U);
                    str4 = string;
                    z16 = false;
                    z18 = r27;
                    z17 = z16;
                    r26 = z18;
                    if (i3 != 0) {
                    }
                    lr2.a.m(TAG, "import result", teamWorkFileImportInfo.T + " " + teamWorkFileImportInfo.U, teamWorkFileImportInfo.X);
                    return z17;
                }
                if (i16 != 0 && i18 != 0) {
                    if (i16 == i17) {
                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                        sb5.append("1");
                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173197hy2), Integer.valueOf(i16)));
                        str4 = string;
                    } else {
                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                        sb5.append("1");
                        str4 = string;
                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.hxz), Integer.valueOf(i16), Integer.valueOf(i17)));
                    }
                    if (i18 == i19) {
                        sb5.append("\n");
                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                        sb5.append("2");
                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173196hy1), excelColIndexToStr));
                    } else {
                        sb5.append("\n");
                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                        sb5.append("2");
                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.hxy), excelColIndexToStr, excelColIndexToStr2));
                    }
                } else {
                    str4 = string;
                    if (i16 != 0 && i18 == 0) {
                        if (i16 == i17) {
                            sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                            sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173197hy2), Integer.valueOf(i16)));
                        } else {
                            sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                            sb5.append(String.format(this.app.getApp().getResources().getString(R.string.hxz), Integer.valueOf(i16), Integer.valueOf(i17)));
                        }
                    } else if (i16 == 0 && i18 != 0) {
                        if (i18 == i19) {
                            sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                            sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173196hy1), excelColIndexToStr));
                        } else {
                            try {
                                sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                String string3 = this.app.getApp().getResources().getString(R.string.hxy);
                                Object[] objArr = new Object[2];
                                z16 = false;
                                try {
                                    objArr[0] = excelColIndexToStr;
                                    objArr[1] = excelColIndexToStr2;
                                    sb5.append(String.format(string3, objArr));
                                    teamWorkFileImportInfo.T = i3;
                                    teamWorkFileImportInfo.U = sb5.toString();
                                    z18 = true;
                                    QLog.e(TAG, 1, "--- parseFileImportResult server ret: " + i3 + ",error: " + teamWorkFileImportInfo.U);
                                    z17 = z16;
                                    r26 = z18;
                                    if (i3 != 0) {
                                    }
                                    lr2.a.m(TAG, "import result", teamWorkFileImportInfo.T + " " + teamWorkFileImportInfo.U, teamWorkFileImportInfo.X);
                                    return z17;
                                } catch (Exception e36) {
                                    e = e36;
                                    z17 = z16;
                                    r26 = "import_type=";
                                    str3 = "err=";
                                    QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                                    ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                                    lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                                    lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                                    lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                                    AppInterface appInterface2222222 = this.app;
                                    String str72222222 = teamWorkFileImportInfo.X;
                                    String str82222222 = str3 + e.getMessage();
                                    ?? sb62222222 = new StringBuilder();
                                    sb62222222.append(r26);
                                    sb62222222.append(teamWorkFileImportInfo.f292070d);
                                    sb62222222.append(teamWorkFileImportInfo.J);
                                    sb62222222.append(teamWorkFileImportInfo.Y);
                                    lr2.a.i(appInterface2222222, str72222222, "0X8009E9B", "fail", str82222222, sb62222222.toString());
                                    return z17;
                                }
                            } catch (Exception e37) {
                                e = e37;
                                z16 = false;
                            }
                        }
                    }
                }
                if (i3 != 0) {
                }
                lr2.a.m(TAG, "import result", teamWorkFileImportInfo.T + " " + teamWorkFileImportInfo.U, teamWorkFileImportInfo.X);
                return z17;
            } catch (Exception e38) {
                e = e38;
                str3 = "err=";
                QLog.e(TAG, 1, " --- parseFileImportResult JSONException: " + e.toString());
                ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                lr2.a.m(TAG, str2, e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                AppInterface appInterface22222222 = this.app;
                String str722222222 = teamWorkFileImportInfo.X;
                String str822222222 = str3 + e.getMessage();
                ?? sb622222222 = new StringBuilder();
                sb622222222.append(r26);
                sb622222222.append(teamWorkFileImportInfo.f292070d);
                sb622222222.append(teamWorkFileImportInfo.J);
                sb622222222.append(teamWorkFileImportInfo.Y);
                lr2.a.i(appInterface22222222, str722222222, "0X8009E9B", "fail", str822222222, sb622222222.toString());
                return z17;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.has("startRow")) {
                i16 = jSONObject2.getInt("startRow");
            } else {
                i16 = 0;
            }
            if (jSONObject2.has("endRow")) {
                i17 = jSONObject2.getInt("endRow");
            } else {
                i17 = 0;
            }
            if (jSONObject2.has("startCol")) {
                i18 = jSONObject2.getInt("startCol");
            } else {
                i18 = 0;
            }
            if (jSONObject2.has("endCol")) {
                i19 = jSONObject2.getInt("endCol");
            } else {
                i19 = 0;
            }
            excelColIndexToStr = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).excelColIndexToStr(i18);
            excelColIndexToStr2 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).excelColIndexToStr(i19);
            sb5 = new StringBuilder();
            sb5.append(this.app.getApp().getResources().getString(R.string.f173195hy0));
            z16 = false;
            teamWorkFileImportInfo.T = i3;
            teamWorkFileImportInfo.U = sb5.toString();
            z18 = true;
            QLog.e(TAG, 1, "--- parseFileImportResult server ret: " + i3 + ",error: " + teamWorkFileImportInfo.U);
            z17 = z16;
            r26 = z18;
        } else {
            lr2.a.m(TAG, "parse import file json fail", "no result string", teamWorkFileImportInfo.X);
            lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseFormResult(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        ir2.a a16 = ir2.a.a(jSONObject);
        if (a16 != null && a16.f408426a != null) {
            if (this.mUIHandler != null) {
                teamWorkFileImportInfo.f292083l0 = a16.f408431f;
                teamWorkFileImportInfo.f292085m0 = a16.f408430e;
                Bundle bundle = new Bundle();
                bundle.putString("url", a16.f408426a);
                bundle.putParcelable("fileInfo", teamWorkFileImportInfo);
                Message obtainMessage = this.mUIHandler.obtainMessage(8001);
                obtainMessage.setData(bundle);
                this.mUIHandler.sendMessage(obtainMessage);
                return;
            }
            return;
        }
        if (this.mUIHandler != null) {
            teamWorkFileImportInfo.T = jSONObject.optInt("retcode", -1);
            Message obtainMessage2 = this.mUIHandler.obtainMessage(8002);
            obtainMessage2.obj = teamWorkFileImportInfo;
            this.mUIHandler.sendMessage(obtainMessage2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0126 A[Catch: Exception -> 0x01b7, TRY_ENTER, TryCatch #2 {Exception -> 0x01b7, blocks: (B:17:0x0126, B:18:0x0194, B:21:0x0156), top: B:15:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0156 A[Catch: Exception -> 0x01b7, TryCatch #2 {Exception -> 0x01b7, blocks: (B:17:0x0126, B:18:0x0194, B:21:0x0156), top: B:15:0x0124 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseUrl2DocResult(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        boolean z16;
        String str2;
        int i3;
        long b16 = lr2.a.b(teamWorkFileImportInfo.X);
        lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9A", String.valueOf(b16), "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y, "");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i16 = jSONObject.getInt("retcode");
                String str3 = "";
                if (!jSONObject.has("msg")) {
                    str2 = "";
                } else {
                    str2 = jSONObject.getString("msg");
                }
                lr2.a.m(TAG, "addFileImportJob end:" + teamWorkFileImportInfo.f292074f, String.valueOf(System.currentTimeMillis()), teamWorkFileImportInfo.X);
                try {
                    if (i16 != 0) {
                        teamWorkFileImportInfo.T = i16;
                        teamWorkFileImportInfo.U = str2;
                        QLog.e(TAG, 1, "--- parseUrl2DocResult server ret: " + i16 + ",error: " + teamWorkFileImportInfo.U);
                        lr2.a.m(TAG, "import file job fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                    } else {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        String string = jSONObject2.getString("docUrl");
                        if (this.mUIHandler != null && !TextUtils.isEmpty(string) && this.app != null) {
                            if (jSONObject2.has("urlType")) {
                                i3 = jSONObject2.getInt("urlType");
                            } else {
                                i3 = 0;
                            }
                            if (jSONObject2.has("docId")) {
                                str3 = jSONObject2.getString("docId");
                            }
                            try {
                                teamWorkFileImportInfo.Z = i3;
                                teamWorkFileImportInfo.f292069c0 = str3;
                                Bundle bundle = new Bundle();
                                bundle.putString("url", string);
                                bundle.putParcelable("fileInfo", teamWorkFileImportInfo);
                                Message obtainMessage = this.mUIHandler.obtainMessage(8001);
                                obtainMessage.setData(bundle);
                                this.mUIHandler.sendMessage(obtainMessage);
                                addToConvertedMap(teamWorkFileImportInfo, string);
                                z16 = true;
                                if (i16 != 0) {
                                    lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "success", "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y, "");
                                } else {
                                    lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", "err=" + i16 + str2, "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                                }
                                lr2.a.m(TAG, "import result", teamWorkFileImportInfo.T + " " + teamWorkFileImportInfo.U, teamWorkFileImportInfo.X);
                                return z16;
                            } catch (Exception e16) {
                                e = e16;
                                z16 = true;
                                QLog.e(TAG, 1, " --- parseUrl2DocResult JSONException: " + e.toString());
                                lr2.a.m(TAG, "parse import file json fail", e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                                lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                                lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                                lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", "err=" + e.getMessage(), "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                                return z16;
                            }
                        }
                    }
                    if (i16 != 0) {
                    }
                    lr2.a.m(TAG, "import result", teamWorkFileImportInfo.T + " " + teamWorkFileImportInfo.U, teamWorkFileImportInfo.X);
                    return z16;
                } catch (Exception e17) {
                    e = e17;
                    QLog.e(TAG, 1, " --- parseUrl2DocResult JSONException: " + e.toString());
                    lr2.a.m(TAG, "parse import file json fail", e.getLocalizedMessage(), teamWorkFileImportInfo.X);
                    lr2.a.m(TAG, "parse import file json fail, param", str, teamWorkFileImportInfo.X);
                    lr2.a.m(TAG, "parse import file json fail, import info", teamWorkFileImportInfo.toString(), teamWorkFileImportInfo.X);
                    lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", "err=" + e.getMessage(), "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                    return z16;
                }
                z16 = false;
            } catch (Exception e18) {
                e = e18;
                z16 = false;
            }
        } else {
            lr2.a.m(TAG, "parse import file json fail", "no result string", teamWorkFileImportInfo.X);
            lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
            return false;
        }
    }

    private void runWoker() {
        final com.tencent.mobileqq.teamwork.z zVar;
        if (this.isWorderRunning) {
            return;
        }
        this.isWorderRunning = true;
        if (this.mFileImportInfoWorker != null) {
            while (!this.mFileImportInfoWorker.isEmpty()) {
                com.tencent.mobileqq.teamwork.api.a poll = this.mFileImportInfoWorker.poll();
                if ((poll instanceof com.tencent.mobileqq.teamwork.z) && (zVar = (com.tencent.mobileqq.teamwork.z) poll) != null) {
                    TeamWorkFileImportInfo teamWorkFileImportInfo = zVar.f292445a;
                    if (teamWorkFileImportInfo != null) {
                        teamWorkFileImportInfo.f292082k0 = zVar.hashCode();
                        QLog.d(TAG, 2, "current job hashcode: " + zVar.f292445a.f292082k0);
                    }
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            zVar.b(TeamWorkFileImportHandlerImpl.this.app);
                            TeamWorkFileImportHandlerImpl.this.app.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    TeamWorkFileImportHandlerImpl.this.notifyUI(4, false, zVar.f292445a);
                                }
                            });
                        }
                    }, 128, null, true);
                }
            }
        }
        this.isWorderRunning = false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void addFileImportJob(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (this.mFileImportInfoWorker != null && teamWorkFileImportInfo != null) {
            lr2.a.p(teamWorkFileImportInfo);
            int i3 = teamWorkFileImportInfo.J;
            if (i3 == 10) {
                addTeamWorkFileImportJob(((IRelyClassCreator) QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportForH5(teamWorkFileImportInfo, this.app));
            } else if (i3 == 6) {
                this.mFileImportInfoWorker.add(new com.tencent.mobileqq.teamwork.ab(teamWorkFileImportInfo, this.app));
            } else if (i3 == 13) {
                this.mFileImportInfoWorker.add(new com.tencent.mobileqq.teamwork.ad(teamWorkFileImportInfo, this.app));
            } else {
                int i16 = teamWorkFileImportInfo.f292070d;
                if (i16 == 1) {
                    addTeamWorkFileImportJob(((IRelyClassCreator) QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportJobForGroup(teamWorkFileImportInfo, this.app));
                } else if (i16 == 3000) {
                    addTeamWorkFileImportJob(((IRelyClassCreator) QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportJobForDisc(teamWorkFileImportInfo, this.app));
                } else if (i16 != 6000 && i16 != 6003) {
                    if (i3 == 12) {
                        this.mFileImportInfoWorker.add(new com.tencent.mobileqq.teamwork.af(teamWorkFileImportInfo, this.app));
                    } else {
                        addTeamWorkFileImportJob(((IRelyClassCreator) QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportJobForC2C(teamWorkFileImportInfo, this.app));
                    }
                } else {
                    this.mFileImportInfoWorker.add(new com.tencent.mobileqq.teamwork.ab(teamWorkFileImportInfo, this.app));
                }
            }
            runWoker();
            lr2.a.k(teamWorkFileImportInfo.X);
            lr2.a.m(TAG, "addFileImportJob start:" + teamWorkFileImportInfo.f292074f, String.valueOf(System.currentTimeMillis()), teamWorkFileImportInfo.X);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void addToConvertedMap(TeamWorkFileImportInfo teamWorkFileImportInfo, String str) {
        if (str != null && teamWorkFileImportInfo != null) {
            String teamWorkFileImportInfoKey = getTeamWorkFileImportInfoKey(teamWorkFileImportInfo);
            if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo)) {
                this.mFileConvertedMapForDiscuss.put(teamWorkFileImportInfoKey, lr2.a.q(lr2.a.a(str), teamWorkFileImportInfo.X));
            } else {
                this.mFileConvertedMap.put(teamWorkFileImportInfoKey, lr2.a.q(str, teamWorkFileImportInfo.X));
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void addToFileImportingMap(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo != null) {
            if (teamWorkFileImportInfo.I) {
                if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo)) {
                    this.mFileImportingInfoMapForDiscuss.put(getTeamWorkFileImportInfoKey(teamWorkFileImportInfo), teamWorkFileImportInfo);
                    return;
                } else {
                    this.mFileImportingInfoMap.put(getTeamWorkFileImportInfoKey(teamWorkFileImportInfo), teamWorkFileImportInfo);
                    return;
                }
            }
            if (!TextUtils.isEmpty(teamWorkFileImportInfo.f292077h)) {
                if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo)) {
                    this.mFileImportingInfoMapForDiscuss.put(teamWorkFileImportInfo.f292077h, teamWorkFileImportInfo);
                } else {
                    this.mFileImportingInfoMap.put(teamWorkFileImportInfo.f292077h, teamWorkFileImportInfo);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void checkFormCache(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        doRequestAfterGetTicket(new AnonymousClass5(jSONObject, teamWorkFileImportInfo));
    }

    public void checkIfHasBeenConverted(String str, final TeamWorkFileImportInfo teamWorkFileImportInfo, final IGetExternalInterface.d dVar) {
        if (this.app != null && !TextUtils.isEmpty(str)) {
            ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).checkIfExist(str, this.app.getCurrentAccountUin(), new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.w
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkFileImportHandlerImpl.this.lambda$checkIfHasBeenConverted$0(teamWorkFileImportInfo, dVar, obj);
                }
            });
        } else {
            dVar.a(Boolean.FALSE);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void createGrayTips(TeamWorkFileImportInfo teamWorkFileImportInfo, String str) {
        String format;
        if (teamWorkFileImportInfo != null && !TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, " --- createGrayTips ");
            boolean p16 = TencentDocConvertConfigProcessor.a().p();
            if ((teamWorkFileImportInfo.K || teamWorkFileImportInfo.c()) && p16) {
                if (teamWorkFileImportInfo.c()) {
                    format = String.format(this.app.getApp().getString(R.string.hyj), "\"" + com.tencent.mobileqq.teamwork.b.c(teamWorkFileImportInfo.f292074f) + "\"");
                } else {
                    format = String.format(this.app.getApp().getString(R.string.hyi), "\"" + com.tencent.mobileqq.teamwork.b.c(teamWorkFileImportInfo.f292074f) + "\"");
                }
                MessageRecord createMsgRecordByMsgType = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).createMsgRecordByMsgType(MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS);
                long K0 = com.tencent.mobileqq.service.message.e.K0();
                String currentAccountUin = this.app.getCurrentAccountUin();
                String str2 = teamWorkFileImportInfo.f292072e;
                createMsgRecordByMsgType.init(currentAccountUin, str2, str2, format, K0, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS, teamWorkFileImportInfo.f292070d, K0);
                createMsgRecordByMsgType.isread = true;
                createMsgRecordByMsgType.saveExtInfoToExtStr(AppConstants.KEY_TEAM_WORK_EXT_INFO_NEW_URL, str);
                createMsgRecordByMsgType.saveExtInfoToExtStr("team_work_is_message_convert", Boolean.toString(teamWorkFileImportInfo.P));
                IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
                AppInterface appInterface = this.app;
                iGetExternalInterface.addMessage(appInterface, createMsgRecordByMsgType, appInterface.getCurrentAccountUin());
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void fileImportFromLocalFile(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        doRequestAfterGetTicket(new AnonymousClass2(teamWorkFileImportInfo));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void fileImportFromLocalFileForDataLine(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        doRequestAfterGetTicket(new AnonymousClass3(teamWorkFileImportInfo));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void fileImportFromLocalFileForH5(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        doRequestAfterGetTicket(new AnonymousClass10(teamWorkFileImportInfo));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void fileImportFromUrl(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, int i3) {
        if (this.app == null) {
            return;
        }
        doRequestAfterGetTicket(new AnonymousClass4(jSONObject, teamWorkFileImportInfo, i3));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void fileImportFromUrl2Doc(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        doRequestAfterGetTicket(new AnonymousClass8(teamWorkFileImportInfo));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void fileImportFromUrlForH5(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, int i3) {
        if (this.app == null) {
            return;
        }
        doRequestAfterGetTicket(new AnonymousClass11(teamWorkFileImportInfo, jSONObject, i3));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void getLocalFileImportInfo(TeamWorkFileImportInfo teamWorkFileImportInfo, ITeamWorkFileImportHandler.a aVar) {
        doRequestAfterGetTicket(new AnonymousClass12(teamWorkFileImportInfo, aVar));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void getTencentDocReddot(String str) {
        if (this.app != null && !TextUtils.isEmpty(str)) {
            doRequestAfterGetTicket(new AnonymousClass9(str));
        }
    }

    public Handler getUIHandler() {
        return this.mUIHandler;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public String getUrlFromConvertedMap(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str;
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (teamWorkFileImportInfo == null) {
            return null;
        }
        int i3 = teamWorkFileImportInfo.f292070d;
        if (i3 == 1) {
            str = teamWorkFileImportInfo.f292072e + "_" + teamWorkFileImportInfo.C;
        } else if (i3 != 3000 && i3 != 0) {
            if (!TextUtils.isEmpty(teamWorkFileImportInfo.f292077h)) {
                str = teamWorkFileImportInfo.f292077h;
            } else if (!TextUtils.isEmpty(teamWorkFileImportInfo.G)) {
                str = teamWorkFileImportInfo.G;
            } else if (!TextUtils.isEmpty(teamWorkFileImportInfo.f292081j0)) {
                str = teamWorkFileImportInfo.G;
            } else {
                str = "";
            }
        } else {
            str = teamWorkFileImportInfo.f292072e + "_" + teamWorkFileImportInfo.f292079i + "_" + teamWorkFileImportInfo.f292084m;
        }
        if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo)) {
            concurrentHashMap = this.mFileConvertedMapForDiscuss;
        } else {
            concurrentHashMap = this.mFileConvertedMap;
        }
        return concurrentHashMap.get(str);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 8001) {
            if (i3 == 8002) {
                TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) message.obj;
                removeFileImporting(teamWorkFileImportInfo);
                notifyUI(2, true, teamWorkFileImportInfo);
                if (QLog.isDevelopLevel()) {
                    QLog.e(TAG, 1, "MSG_FILE_IMPORT_ERROR:" + teamWorkFileImportInfo.f292074f);
                }
            }
        } else {
            Bundle data = message.getData();
            TeamWorkFileImportInfo teamWorkFileImportInfo2 = (TeamWorkFileImportInfo) data.getParcelable("fileInfo");
            String string = data.getString("url");
            removeFileImporting(teamWorkFileImportInfo2);
            if (QLog.isDevelopLevel()) {
                QLog.e(TAG, 1, "MSG_FILE_IMPORT_SUCCESS:" + string);
            }
            if (teamWorkFileImportInfo2 != null) {
                string = lr2.a.q(string, teamWorkFileImportInfo2.X);
                if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo2)) {
                    string = lr2.a.a(string);
                }
            }
            notifyUI(1, true, new Object[]{string, teamWorkFileImportInfo2});
            ReportController.o(this.app, "CliOper", "", "", "0X8008FB6", "0X8008FB6", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.i("teamConvert", 2, "convert finish time [" + (System.currentTimeMillis() / 1000) + "]");
            }
            if (this.isNeedToast) {
                QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getString(R.string.hy7), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void importFormWithLocalFile(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        doRequestAfterGetTicket(new AnonymousClass7(jSONObject, teamWorkFileImportInfo));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void importFormWithUrl(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        doRequestAfterGetTicket(new AnonymousClass6(jSONObject, teamWorkFileImportInfo));
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public boolean isFileImporting(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo == null) {
            return false;
        }
        if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo)) {
            if (TextUtils.isEmpty(teamWorkFileImportInfo.f292077h) || !this.mFileImportingInfoMapForDiscuss.containsKey(teamWorkFileImportInfo.f292077h)) {
                return this.mFileImportingInfoMapForDiscuss.containsKey(getTeamWorkFileImportInfoKey(teamWorkFileImportInfo));
            }
        } else if (TextUtils.isEmpty(teamWorkFileImportInfo.f292077h) || !this.mFileImportingInfoMap.containsKey(teamWorkFileImportInfo.f292077h)) {
            if (!this.mFileImportingInfoMap.containsKey(getTeamWorkFileImportInfoKey(teamWorkFileImportInfo))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void notifyUIError(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        Handler handler = this.mUIHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(8002);
            obtainMessage.obj = teamWorkFileImportInfo;
            this.mUIHandler.sendMessage(obtainMessage);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.mobileqq.teamwork.ag.class;
    }

    String parseCheckResult(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("ret");
            if (!jSONObject.has("msg")) {
                str2 = "";
            } else {
                str2 = jSONObject.getString("msg");
            }
            if (i3 == 0) {
                String string = jSONObject.getString("url");
                try {
                    if (this.mUIHandler != null && !TextUtils.isEmpty(string) && this.app != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("url", string);
                        bundle.putParcelable("fileInfo", teamWorkFileImportInfo);
                        Message obtainMessage = this.mUIHandler.obtainMessage(8001);
                        obtainMessage.setData(bundle);
                        this.mUIHandler.sendMessage(obtainMessage);
                        boolean p16 = TencentDocConvertConfigProcessor.a().p();
                        if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.K && p16) {
                            int fileType = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getFileType(teamWorkFileImportInfo.f292074f);
                            if (fileType == 3) {
                                HardCodeUtil.qqStr(R.string.u06);
                            } else if (fileType == 6) {
                                HardCodeUtil.qqStr(R.string.f172761u10);
                            }
                            String format = String.format(this.app.getApp().getString(R.string.hy6), "\"" + teamWorkFileImportInfo.f292074f + "\"");
                            MessageRecord createMsgRecordByMsgType = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).createMsgRecordByMsgType(MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS);
                            long K0 = com.tencent.mobileqq.service.message.e.K0();
                            String currentAccountUin = this.app.getCurrentAccountUin();
                            String str4 = teamWorkFileImportInfo.f292072e;
                            createMsgRecordByMsgType.init(currentAccountUin, str4, str4, format, K0, MessageRecord.MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS, teamWorkFileImportInfo.f292070d, K0);
                            createMsgRecordByMsgType.isread = true;
                            createMsgRecordByMsgType.saveExtInfoToExtStr(AppConstants.KEY_TEAM_WORK_EXT_INFO_NEW_URL, ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(string, ITeamWorkUtils.TD_SOURCE_QQ_AIO_GREY));
                            IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
                            AppInterface appInterface = this.app;
                            iGetExternalInterface.addMessage(appInterface, createMsgRecordByMsgType, appInterface.getCurrentAccountUin());
                        }
                    }
                    return string;
                } catch (JSONException e16) {
                    e = e16;
                    str3 = string;
                    ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                    QLog.e(TAG, 1, " --- parseCheckResult JSONException: " + e.toString());
                    return str3;
                }
            }
            ReportController.o(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, i3 + "", "", "", "");
            QLog.e(TAG, 1, "--- parseCheckResult server ret: " + i3 + ",error: " + str2);
            return null;
        } catch (JSONException e17) {
            e = e17;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x046e A[Catch: Exception -> 0x04b4, TRY_LEAVE, TryCatch #7 {Exception -> 0x04b4, blocks: (B:35:0x044c, B:21:0x046e), top: B:19:0x0439 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x043b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseFileImportResultForH5(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String str2;
        boolean z16;
        String str3;
        String str4;
        String str5;
        int i3;
        int i16;
        int i17;
        int i18;
        String str6;
        String str7 = WadlProxyConsts.PARAM_FILENAME;
        String str8 = "md5";
        long b16 = lr2.a.b(teamWorkFileImportInfo.X);
        lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9A", String.valueOf(b16), "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y, "");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i19 = jSONObject.getInt("ret");
                if (jSONObject.has("msg")) {
                    try {
                        jSONObject.getString("msg");
                    } catch (Exception e16) {
                        e = e16;
                        str2 = "err=";
                        str7 = "import_type=";
                        z16 = 0;
                        QLog.e(TAG, 1, " --- parseFileImportResultForH5 JSONException: " + e.toString());
                        lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", str2 + e.getMessage(), str7 + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                        return z16;
                    }
                }
                String string = jSONObject.getString("error");
                try {
                    if (i19 != 0) {
                        str7 = "--- parseFileImportResultForH5 server ret: ";
                        if (i19 != 115) {
                            if (i19 != 116) {
                                teamWorkFileImportInfo.T = i19;
                                teamWorkFileImportInfo.U = string;
                                QLog.e(TAG, 1, "--- parseFileImportResultForH5 server ret: " + i19 + ",error: " + teamWorkFileImportInfo.U);
                                str3 = string;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(string);
                                if (jSONObject2.has("startRow")) {
                                    i3 = jSONObject2.getInt("startRow");
                                } else {
                                    i3 = 0;
                                }
                                if (jSONObject2.has("endRow")) {
                                    i16 = jSONObject2.getInt("endRow");
                                } else {
                                    i16 = 0;
                                }
                                if (jSONObject2.has("startCol")) {
                                    i17 = jSONObject2.getInt("startCol");
                                } else {
                                    i17 = 0;
                                }
                                if (jSONObject2.has("endCol")) {
                                    i18 = jSONObject2.getInt("endCol");
                                } else {
                                    i18 = 0;
                                }
                                String excelColIndexToStr = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).excelColIndexToStr(i17);
                                String excelColIndexToStr2 = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).excelColIndexToStr(i18);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(this.app.getApp().getResources().getString(R.string.f173195hy0));
                                if (i3 != 0 && i17 != 0) {
                                    if (i3 == i16) {
                                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                        sb5.append("1");
                                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173197hy2), Integer.valueOf(i3)));
                                        str6 = string;
                                    } else {
                                        str6 = string;
                                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                        sb5.append("1");
                                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.hxz), Integer.valueOf(i3), Integer.valueOf(i16)));
                                    }
                                    if (i17 == i18) {
                                        sb5.append("\n");
                                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                        sb5.append("2");
                                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173196hy1), excelColIndexToStr));
                                    } else {
                                        sb5.append("\n");
                                        sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                        sb5.append("2");
                                        sb5.append(String.format(this.app.getApp().getResources().getString(R.string.hxy), excelColIndexToStr, excelColIndexToStr2));
                                    }
                                } else {
                                    str6 = string;
                                    if (i3 != 0 && i17 == 0) {
                                        if (i3 == i16) {
                                            sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                            sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173197hy2), Integer.valueOf(i3)));
                                        } else {
                                            sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                            sb5.append(String.format(this.app.getApp().getResources().getString(R.string.hxz), Integer.valueOf(i3), Integer.valueOf(i16)));
                                        }
                                    } else if (i3 == 0 && i17 != 0) {
                                        if (i17 == i18) {
                                            sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                            sb5.append(String.format(this.app.getApp().getResources().getString(R.string.f173196hy1), excelColIndexToStr));
                                        } else {
                                            sb5.append(this.app.getApp().getResources().getString(R.string.hxw));
                                            sb5.append(String.format(this.app.getApp().getResources().getString(R.string.hxy), excelColIndexToStr, excelColIndexToStr2));
                                        }
                                    }
                                }
                                teamWorkFileImportInfo.T = i19;
                                teamWorkFileImportInfo.U = sb5.toString();
                                QLog.e(TAG, 1, "--- parseFileImportResultForH5 server ret: " + i19 + ",error: " + teamWorkFileImportInfo.U);
                                str3 = str6;
                            }
                            str8 = null;
                            z16 = str8;
                            try {
                                if (i19 == 0) {
                                    str7 = "import_type=";
                                    AppInterface appInterface = this.app;
                                    String str9 = teamWorkFileImportInfo.X;
                                    StringBuilder sb6 = new StringBuilder();
                                    str2 = "err=";
                                    try {
                                        sb6.append(str2);
                                        sb6.append(i19);
                                        sb6.append(str3);
                                        lr2.a.i(appInterface, str9, "0X8009E9B", "fail", sb6.toString(), str7 + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                                    } catch (Exception e17) {
                                        e = e17;
                                        QLog.e(TAG, 1, " --- parseFileImportResultForH5 JSONException: " + e.toString());
                                        lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", str2 + e.getMessage(), str7 + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                                        return z16;
                                    }
                                } else {
                                    try {
                                        AppInterface appInterface2 = this.app;
                                        String str10 = teamWorkFileImportInfo.X;
                                        StringBuilder sb7 = new StringBuilder();
                                        str7 = "import_type=";
                                        sb7.append(str7);
                                        sb7.append(teamWorkFileImportInfo.f292070d);
                                        sb7.append(teamWorkFileImportInfo.J);
                                        sb7.append(teamWorkFileImportInfo.Y);
                                        lr2.a.i(appInterface2, str10, "0X8009E9B", "success", sb7.toString(), "");
                                    } catch (Exception e18) {
                                        e = e18;
                                        str7 = "import_type=";
                                        str2 = "err=";
                                        QLog.e(TAG, 1, " --- parseFileImportResultForH5 JSONException: " + e.toString());
                                        lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", str2 + e.getMessage(), str7 + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                                        return z16;
                                    }
                                }
                                return z16;
                            } catch (Exception e19) {
                                e = e19;
                            }
                        } else {
                            try {
                                String str11 = "";
                                if (!jSONObject.has("filePath") || TextUtils.isEmpty(jSONObject.getString("filePath"))) {
                                    str4 = "";
                                } else {
                                    str4 = jSONObject.getString("filePath");
                                }
                                if (!jSONObject.has("md5") || TextUtils.isEmpty(jSONObject.getString("md5"))) {
                                    str5 = "";
                                } else {
                                    str5 = jSONObject.getString("md5");
                                }
                                if (jSONObject.has(WadlProxyConsts.PARAM_FILENAME) && !TextUtils.isEmpty(jSONObject.getString(WadlProxyConsts.PARAM_FILENAME))) {
                                    str11 = jSONObject.getString(WadlProxyConsts.PARAM_FILENAME);
                                }
                                String str12 = teamWorkFileImportInfo.S;
                                String str13 = com.tencent.mobileqq.teamwork.t.f292412q;
                                Object[] objArr = new Object[5];
                                str8 = null;
                                objArr[0] = URLEncoder.encode(str12, "UTF-8");
                                objArr[1] = URLEncoder.encode(str5, "UTF-8");
                                objArr[2] = URLEncoder.encode(str11, "UTF-8");
                                objArr[3] = URLEncoder.encode(str4, "UTF-8");
                                objArr[4] = "import";
                                teamWorkFileImportInfo.V = String.format(str13, objArr);
                                teamWorkFileImportInfo.T = i19;
                                str3 = string;
                                teamWorkFileImportInfo.U = str3;
                                QLog.e(TAG, 1, "--- parseFileImportResultForH5 server ret: " + i19 + ",error: " + teamWorkFileImportInfo.U);
                                z16 = str8;
                                if (i19 == 0) {
                                }
                                return z16;
                            } catch (Exception e26) {
                                e = e26;
                                str8 = null;
                                z16 = str8;
                                str2 = "err=";
                                str7 = "import_type=";
                                QLog.e(TAG, 1, " --- parseFileImportResultForH5 JSONException: " + e.toString());
                                lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", str2 + e.getMessage(), str7 + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                                return z16;
                            }
                        }
                    } else {
                        str3 = string;
                        str8 = null;
                        try {
                            String string2 = jSONObject.getString("url");
                            if (this.mUIHandler != null) {
                                if (!TextUtils.isEmpty(string2) && this.app != null) {
                                    try {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("url", string2);
                                        bundle.putParcelable("fileInfo", teamWorkFileImportInfo);
                                        Message obtainMessage = this.mUIHandler.obtainMessage(8001);
                                        obtainMessage.setData(bundle);
                                        this.mUIHandler.sendMessage(obtainMessage);
                                        addToConvertedMap(teamWorkFileImportInfo, string2);
                                        z16 = 1;
                                        if (i19 == 0) {
                                        }
                                        return z16;
                                    } catch (Exception e27) {
                                        e = e27;
                                        str2 = "err=";
                                        str7 = "import_type=";
                                        z16 = 1;
                                        QLog.e(TAG, 1, " --- parseFileImportResultForH5 JSONException: " + e.toString());
                                        lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", str2 + e.getMessage(), str7 + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                                        return z16;
                                    }
                                }
                            }
                            z16 = str8;
                            if (i19 == 0) {
                            }
                            return z16;
                        } catch (Exception e28) {
                            e = e28;
                            str2 = "err=";
                            str7 = "import_type=";
                            z16 = str8;
                            QLog.e(TAG, 1, " --- parseFileImportResultForH5 JSONException: " + e.toString());
                            lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", str2 + e.getMessage(), str7 + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
                            return z16;
                        }
                    }
                } catch (Exception e29) {
                    e = e29;
                }
            } catch (Exception e36) {
                e = e36;
                str2 = "err=";
                str7 = "import_type=";
                str8 = null;
            }
        } else {
            lr2.a.i(this.app, teamWorkFileImportInfo.X, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + teamWorkFileImportInfo.f292070d + teamWorkFileImportInfo.J + teamWorkFileImportInfo.Y);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void removeFileImporting(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        String teamWorkFileImportInfoKey;
        String teamWorkFileImportInfoKey2;
        if (teamWorkFileImportInfo == null) {
            return;
        }
        if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo)) {
            if (!TextUtils.isEmpty(teamWorkFileImportInfo.f292077h) && this.mFileImportingInfoMapForDiscuss.containsKey(teamWorkFileImportInfo.f292077h)) {
                teamWorkFileImportInfoKey2 = teamWorkFileImportInfo.f292077h;
            } else {
                teamWorkFileImportInfoKey2 = getTeamWorkFileImportInfoKey(teamWorkFileImportInfo);
            }
            if (!TextUtils.isEmpty(teamWorkFileImportInfoKey2)) {
                this.mFileImportingInfoMapForDiscuss.remove(teamWorkFileImportInfoKey2);
            }
        } else {
            if (!TextUtils.isEmpty(teamWorkFileImportInfo.f292077h) && this.mFileImportingInfoMap.containsKey(teamWorkFileImportInfo.f292077h)) {
                teamWorkFileImportInfoKey = teamWorkFileImportInfo.f292077h;
            } else {
                teamWorkFileImportInfoKey = getTeamWorkFileImportInfoKey(teamWorkFileImportInfo);
            }
            if (!TextUtils.isEmpty(teamWorkFileImportInfoKey)) {
                this.mFileImportingInfoMap.remove(teamWorkFileImportInfoKey);
            }
        }
        teamWorkFileImportInfo.f292082k0 = 0;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void removeFromConvertedMap(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo == null) {
            return;
        }
        String teamWorkFileImportInfoKey = getTeamWorkFileImportInfoKey(teamWorkFileImportInfo);
        if (com.tencent.mobileqq.teamwork.u.m(teamWorkFileImportInfo)) {
            this.mFileConvertedMapForDiscuss.remove(teamWorkFileImportInfoKey);
        } else {
            this.mFileConvertedMap.remove(teamWorkFileImportInfoKey);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public void setIsNeedToast(boolean z16) {
        this.isNeedToast = z16;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler
    public boolean updateFileImporting(TeamWorkFileImportInfo teamWorkFileImportInfo, boolean z16) {
        if (teamWorkFileImportInfo == null) {
            return false;
        }
        if (TextUtils.isEmpty(teamWorkFileImportInfo.f292077h) || !this.mFileImportingInfoMap.containsKey(teamWorkFileImportInfo.f292077h)) {
            TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.mFileImportingInfoMap.get(getTeamWorkFileImportInfoKey(teamWorkFileImportInfo));
            if (teamWorkFileImportInfo2 == null) {
                return false;
            }
            teamWorkFileImportInfo2.M = z16;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
