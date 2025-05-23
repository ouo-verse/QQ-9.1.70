package com.tencent.mobileqq.startup.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.io.File;
import java.io.FileFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.ISecurityFileHelper;
import mqq.app.MobileQQ;
import mqq.manager.impl.SecurityFileFrameworkServiceImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/startup/update/h;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "b", "id", "Lmqq/app/ISecurityFileHelper;", "helper", "", "d", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "Landroid/support/v4/util/SparseArrayCompat;", "Landroid/support/v4/util/SparseArrayCompat;", "helpers", "<init>", "()V", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String[] f289875f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArrayCompat<ISecurityFileHelper> helpers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/startup/update/h$a;", "", "", "", "BusinessFileNames", "[Ljava/lang/String;", "", "ID_QQComic", "I", "ID_QQFavorite", "ID_QQREADER", "ID_QQTheme", "MIGRATION_FAIL_NOT_EXTERNAL_CACHE_DIR", "MIGRATION_FAIL_NO_RENAME_FILE_NOT_EXIST", "MIGRATION_FAIL_ORIGINAL_FILE_NOT_EXIST", "MIGRATION_SUCCESS", "SP_KEY_MIGRATION_TO_PRIVATE_FILES", "Ljava/lang/String;", "SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.update.h$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f289875f = new String[]{"ReaderZone", DiySecureFileHelper.FILENAME, "QQComicOffline"};
        }
    }

    public h() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.helpers = new SparseArrayCompat<>();
        d(0, new w05.a());
        d(1, new DiySecureFileHelper.QQFavoriteSecurityFileHelper());
        d(2, new DiySecureFileHelper.CustomBackground());
        ISecurityFileHelper comicSecurityFileHelper = ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).getComicSecurityFileHelper();
        Intrinsics.checkNotNullExpressionValue(comicSecurityFileHelper, "api(IQQComicUtil::class.\u2026).comicSecurityFileHelper");
        d(3, comicSecurityFileHelper);
    }

    private final int b() {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/";
        File externalCacheDir = BaseApplicationImpl.getApplication().getExternalCacheDir();
        if (externalCacheDir != null) {
            String str2 = externalCacheDir.getParentFile().getAbsolutePath() + "/Tencent/MobileQQ/";
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists()) {
                return 3;
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.mobileqq.startup.update.g
                @Override // java.io.FileFilter
                public final boolean accept(File file3) {
                    boolean c16;
                    c16 = h.c(file3);
                    return c16;
                }
            });
            if (listFiles == null) {
                return 4;
            }
            for (File file3 : listFiles) {
                FileUtils.quickMove(file3.getAbsolutePath(), file2.getAbsolutePath() + File.separator + file3.getName());
            }
            return 1;
        }
        QLog.d("UpdateSecureFileStrategy", 1, "externalCacheDir is null");
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(File file) {
        boolean startsWith$default;
        if (!file.isDirectory()) {
            return false;
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "pathname.name");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, SecurityFileFrameworkServiceImpl.FILE_KEY_PREFIX, false, 2, null);
        if (!startsWith$default) {
            return false;
        }
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "pathname.name");
        String replace = new Regex(SecurityFileFrameworkServiceImpl.FILE_KEY_PREFIX).replace(name2, "");
        if (replace.length() != 9) {
            return false;
        }
        char charAt = replace.charAt(0);
        String substring = replace.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        if (charAt != SecurityFileFrameworkServiceImpl.generateVerifyChar(substring)) {
            return false;
        }
        return true;
    }

    private final void d(int id5, ISecurityFileHelper helper) {
        this.helpers.put(id5, helper);
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        char c16;
        char c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        char c18 = 4;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(SecurityFileFrameworkServiceImpl.TAG, 4);
        boolean z16 = sharedPreferences.getBoolean("SP_KEY_MIGRATION_TO_PRIVATE_FILES", false);
        char c19 = 3;
        if (!z16) {
            if (MobileQQ.isHasStoragePermission(BaseApplicationImpl.getApplication())) {
                QLog.d("UpdateSecureFileStrategy", 1, "doMigration, result=", Integer.valueOf(b()));
            } else if (QLog.isColorLevel()) {
                QLog.d("UpdateSecureFileStrategy", 2, "hasMigration=", Boolean.valueOf(z16), " StoragePermission=false");
            }
            sharedPreferences.edit().putBoolean("SP_KEY_MIGRATION_TO_PRIVATE_FILES", true).apply();
        }
        File rootFile = SecurityFileFrameworkServiceImpl.getRootFile();
        if (QLog.isColorLevel()) {
            QLog.d("UpdateSecureFileStrategy", 2, "rootFile Path=", rootFile.getAbsolutePath());
        }
        StringBuilder sb5 = new StringBuilder();
        int size = this.helpers.size();
        int i3 = 0;
        while (i3 < size) {
            sb5.append(this.helpers.get(i3).declareBusinessFileName());
            sb5.append("#");
            if (this.helpers.get(i3).needMigration()) {
                String[] reportHistoryFileInfo = this.helpers.get(i3).reportHistoryFileInfo();
                Intrinsics.checkNotNullExpressionValue(reportHistoryFileInfo, "helpers.get(i).reportHistoryFileInfo()");
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[6];
                    objArr[0] = "BusinessName= ";
                    objArr[1] = this.helpers.get(i3).declareBusinessFileName();
                    objArr[2] = " File Size=";
                    objArr[c19] = reportHistoryFileInfo[0];
                    objArr[4] = " File Amount=";
                    objArr[5] = reportHistoryFileInfo[1];
                    QLog.d("UpdateSecureFileStrategy", 2, objArr);
                }
                boolean doMigrate = this.helpers.get(i3).doMigrate(rootFile);
                sharedPreferences.edit().putBoolean(this.helpers.get(i3).declareBusinessFileName(), doMigrate).apply();
                if (QLog.isColorLevel()) {
                    c17 = 4;
                    c16 = 3;
                    QLog.d("UpdateSecureFileStrategy", 2, "BusinessName= ", this.helpers.get(i3).declareBusinessFileName(), " Success=", Boolean.valueOf(doMigrate));
                } else {
                    c17 = 4;
                    c16 = 3;
                }
                sb5.append(true);
                sb5.append("#");
                sb5.append(reportHistoryFileInfo[0]);
                sb5.append("#");
                sb5.append(reportHistoryFileInfo[1]);
                sb5.append("#");
                sb5.append(doMigrate);
            } else {
                c16 = c19;
                c17 = c18;
                sb5.append(false);
            }
            sb5.append("|");
            i3++;
            c18 = c17;
            c19 = c16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpdateSecureFileStrategy", 2, "SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", sb5.toString());
        }
        sharedPreferences.edit().putString("SP_KEY_UPDATE_SECURE_FILE_STRATEGY_REPORT", sb5.toString()).apply();
    }
}
