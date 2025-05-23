package com.tencent.mobileqq.fragment.overview;

import android.os.SystemClock;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.overview.e;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IDataImportTableNamesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J:\u0010\u0017\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000f\u0010\u001a\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/fragment/overview/e;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/api/w;", "msgService", "", tl.h.F, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tableNames", "g", "table", "Lcom/tencent/mobileqq/persistence/EntityManager;", "em", "", "totalCount", "deleteCountPerTimes", "Ljava/io/File;", "dbFile", "", "isSlowTable", "f", "Lcom/tencent/mobileqq/persistence/g;", "i", "d", "()V", "b", "Z", "isCleaning", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f211451a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isCleaning;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/fragment/overview/e$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IDataImportTableNamesCallback;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tableNames", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements IDataImportTableNamesCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f211453a;

        a(AppRuntime appRuntime) {
            this.f211453a = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(AppRuntime app, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(app, "$app");
            try {
                e.f211451a.g(app, arrayList);
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IDataImportTableNamesCallback
        public void onResult(int result, @Nullable String errMsg, @Nullable final ArrayList<String> tableNames) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, tableNames);
                return;
            }
            if (result != 0) {
                e.isCleaning = false;
                QLog.d("MainDBCleanUtils", 1, "findDeleteTable result:" + result + ", errMsg:" + errMsg);
                return;
            }
            if (tableNames != null && !tableNames.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                e.isCleaning = false;
                QLog.d("MainDBCleanUtils", 1, "findDeleteTable tableNames empty");
            } else {
                final AppRuntime appRuntime = this.f211453a;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.overview.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.b(AppRuntime.this, tableNames);
                    }
                }, 32, null, true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58301);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f211451a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AppRuntime app, com.tencent.qqnt.kernel.api.w msgService, int i3, String str) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(msgService, "$msgService");
        if (i3 != 0) {
            isCleaning = false;
            QLog.d("MainDBCleanUtils", 1, "clearUnusedMsg isMqqDataImportFinished result: " + i3 + ", errMsg: " + str);
            return;
        }
        f211451a.h(app, msgService);
    }

    private final void f(String table, EntityManager em5, int totalCount, int deleteCountPerTimes, File dbFile, boolean isSlowTable) {
        String str = table;
        boolean z16 = false;
        int i3 = 1;
        if (em5 != null && em5.tabbleIsExist(str)) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        long length = dbFile.length();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i16 = totalCount / deleteCountPerTimes;
        if (1 <= i16) {
            int i17 = 1;
            while (true) {
                long length2 = dbFile.length();
                long uptimeMillis2 = SystemClock.uptimeMillis();
                DBMethodProxy.execSQL(em5, "DELETE FROM " + str + " WHERE shmsgseq in (SELECT shmsgseq FROM " + str + " ORDER by shmsgseq ASC LIMIT " + deleteCountPerTimes + ")");
                long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis2;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("deleteTable delete msg count: ");
                sb5.append(deleteCountPerTimes);
                sb5.append(", cost: ");
                sb5.append(uptimeMillis3);
                QLog.d("MainDBCleanUtils", i3, sb5.toString());
                int i18 = i16;
                int i19 = i17;
                StorageReport.k().w(deleteCountPerTimes, length2 - dbFile.length(), uptimeMillis3, QQPermissionConstants.Permission.AUIDO_GROUP, isSlowTable, length2, dbFile.length());
                if (i19 == i18) {
                    break;
                }
                i17 = i19 + 1;
                str = table;
                i16 = i18;
                i3 = 1;
            }
        }
        long length3 = dbFile.length();
        long uptimeMillis4 = SystemClock.uptimeMillis();
        em5.drop(table);
        StorageReport.k().w(totalCount % deleteCountPerTimes, length3 - dbFile.length(), SystemClock.uptimeMillis() - uptimeMillis4, QQPermissionConstants.Permission.AUIDO_GROUP, isSlowTable, length3, dbFile.length());
        StorageReport.k().w(totalCount, length - dbFile.length(), SystemClock.uptimeMillis() - uptimeMillis, "table", isSlowTable, length, dbFile.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(AppRuntime app, ArrayList<String> tableNames) {
        int i3;
        com.tencent.mobileqq.fragment.overview.config.a aVar = (com.tencent.mobileqq.fragment.overview.config.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("clean_main_db_msg");
        if (aVar != null) {
            i3 = aVar.a();
        } else {
            i3 = 20000;
        }
        File dbFile = MobileQQ.sMobileQQ.getDatabasePath(app.getCurrentAccountUin() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        File slowDBFile = MobileQQ.sMobileQQ.getDatabasePath("slowtable_" + app.getCurrentAccountUin() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        QLog.d("MainDBCleanUtils", 1, "doClearMsg dbSize before drop table dbSize: " + dbFile.length() + ", slowDBSize: " + slowDBFile.length());
        IRuntimeService runtimeService = app.getRuntimeService(IMessageFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IMessageFacade iMessageFacade = (IMessageFacade) runtimeService;
        EntityManager createEntityManager = app.getEntityManagerFactory().createEntityManager();
        com.tencent.mobileqq.persistence.g i16 = i(app);
        long length = dbFile.length();
        long length2 = slowDBFile.length();
        int i17 = 0;
        int i18 = 0;
        long j3 = 0;
        long j16 = 0;
        for (String str : tableNames) {
            int quickDBMsgCount = iMessageFacade.getQuickDBMsgCount(str, -1L, -1L, false);
            i17 += quickDBMsgCount;
            long uptimeMillis = SystemClock.uptimeMillis();
            e eVar = f211451a;
            Intrinsics.checkNotNullExpressionValue(dbFile, "dbFile");
            int i19 = i3;
            eVar.f(str, createEntityManager, quickDBMsgCount, i19, dbFile, false);
            j3 += SystemClock.uptimeMillis() - uptimeMillis;
            QLog.d("MainDBCleanUtils", 1, "doClearMsg quick db drop " + str + " complete");
            int slowDBMsgCount = iMessageFacade.getSlowDBMsgCount(str, -1L, -1L, false);
            i18 += slowDBMsgCount;
            long uptimeMillis2 = SystemClock.uptimeMillis();
            Intrinsics.checkNotNullExpressionValue(slowDBFile, "slowDBFile");
            eVar.f(str, i16, slowDBMsgCount, i19, slowDBFile, true);
            j16 += SystemClock.uptimeMillis() - uptimeMillis2;
            QLog.d("MainDBCleanUtils", 1, "doClearMsg slow db drop " + str + " complete");
            i3 = i3;
        }
        StorageReport.k().w(i17, length - dbFile.length(), j3, "total", false, length, dbFile.length());
        StorageReport.k().w(i18, length2 - slowDBFile.length(), j16, "total", true, length2, slowDBFile.length());
        QLog.d("MainDBCleanUtils", 1, "doClearMsg dbSize after drop table dbSize: " + dbFile.length() + ", slowDBSize: " + slowDBFile.length());
    }

    private final void h(AppRuntime app, com.tencent.qqnt.kernel.api.w msgService) {
        msgService.getMqqDataImportTableNames(new a(app));
    }

    private final com.tencent.mobileqq.persistence.g i(AppRuntime app) {
        QSlowTableManager qSlowTableManager;
        Manager manager = app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
        if (manager instanceof QSlowTableManager) {
            qSlowTableManager = (QSlowTableManager) manager;
        } else {
            qSlowTableManager = null;
        }
        if (qSlowTableManager == null) {
            QLog.d("MainDBCleanUtils", 1, "getSlowEM qstMgr null");
            return null;
        }
        if (!qSlowTableManager.c().isOpen()) {
            QLog.d("MainDBCleanUtils", 1, "getSlowEM qstMgr close");
            return null;
        }
        return qSlowTableManager.e();
    }

    public final void d() {
        final AppRuntime peekAppRuntime;
        final com.tencent.qqnt.kernel.api.w msgService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (isCleaning || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("clean_main_db_msg", false) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        File databasePath = MobileQQ.sMobileQQ.getDatabasePath(peekAppRuntime.getCurrentAccountUin() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        if (FileUtils.getAvailableInnernalMemorySize() < (databasePath.length() + mobileQQ.getDatabasePath("slowtable_" + currentAccountUin + DBBackupServiceImpl.DB_FILE_SUFFIX).length()) * 1.7d || (msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService()) == null) {
            return;
        }
        isCleaning = true;
        msgService.isMqqDataImportFinished(new IOperateCallback() { // from class: com.tencent.mobileqq.fragment.overview.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                e.e(AppRuntime.this, msgService, i3, str);
            }
        });
    }
}
