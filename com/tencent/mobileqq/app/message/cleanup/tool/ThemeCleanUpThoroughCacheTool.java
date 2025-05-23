package com.tencent.mobileqq.app.message.cleanup.tool;

import android.content.SharedPreferences;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.nativefilescan.DirSizeData;
import com.tencent.mobileqq.nativefilescan.FileScanCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.ThemeCleaner;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/ThemeCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "", "clearCustomBackground", "moveAIOBg", "moveThemeBg", "Ljava/io/File;", "dstFile", "originFile", "", "startCopyFile", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", "getClearSize", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "needReport", "Z", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ThemeCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ThemeCleanUpThoroughCacheTool";
    private final boolean needReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/ThemeCleanUpThoroughCacheTool$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.message.cleanup.tool.ThemeCleanUpThoroughCacheTool$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ThemeCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.needReport = VasNormalToggle.BUG_CLEANER_REPORT.isEnable(true);
        }
    }

    private final void clearCustomBackground() {
        int i3;
        moveAIOBg();
        moveThemeBg();
        ArrayList arrayList = new ArrayList();
        Regex regex = new Regex("custom_background/\\d+\\.jpg");
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        Intrinsics.checkNotNullExpressionValue(allAccounts, "sMobileQQ.allAccounts");
        Iterator<T> it = allAccounts.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SimpleAccount simpleAccount = (SimpleAccount) it.next();
            Iterator<T> it5 = ChatBackgroundUtil.getMMKVData(BaseApplication.getContext(), simpleAccount.getUin()).getAll().entrySet().iterator();
            while (it5.hasNext()) {
                Object value = ((Map.Entry) it5.next()).getValue();
                if ((value instanceof String) && regex.containsMatchIn((CharSequence) value)) {
                    arrayList.add(value);
                }
            }
            Iterator<T> it6 = ThemeBackground.getSharedPreferences(BaseApplication.getContext(), simpleAccount.getUin(), 0).getAll().entrySet().iterator();
            while (it6.hasNext()) {
                Object value2 = ((Map.Entry) it6.next()).getValue();
                if ((value2 instanceof String) && regex.containsMatchIn((CharSequence) value2)) {
                    arrayList.add(value2);
                }
            }
        }
        StringBuilder sb5 = new StringBuilder("\u9700\u8981\u4fdd\u7559\u7684\u8def\u5f84\uff1a\n");
        Iterator it7 = arrayList.iterator();
        while (it7.hasNext()) {
            sb5.append((String) it7.next());
            sb5.append("\n");
        }
        QLog.i("ThemeCleanUpThoroughCacheTool", 1, sb5.toString());
        d dVar = d.f195978a;
        FileUtils.deleteDirectory(dVar.a() + "/custom_background");
        FileUtils.deleteDirectory(dVar.d() + "/Tencent/MobileQQ/custom_background");
        File file = new File(VasConstant.INTERNAL_CUSTOM_BG_DIR);
        if (file.exists()) {
            StringBuilder sb6 = new StringBuilder("\u9700\u8981\u5220\u9664\u7684\u6587\u4ef6\uff1a\n");
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
                for (File file2 : listFiles) {
                    String path = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(path, "path");
                    if (!regex.containsMatchIn(path)) {
                        FileUtils.deleteFile(file2);
                        sb6.append(path);
                        sb6.append("\n");
                    } else if (!arrayList.contains(path)) {
                        FileUtils.deleteFile(file2);
                        sb6.append(path);
                        sb6.append("\n");
                    }
                }
            }
            QLog.i("ThemeCleanUpThoroughCacheTool", 1, sb6.toString());
        }
    }

    private final void moveAIOBg() {
        long j3;
        Regex regex = new Regex("custom_background/\\d+/.+");
        HashMap hashMap = new HashMap();
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        Intrinsics.checkNotNullExpressionValue(allAccounts, "sMobileQQ.allAccounts");
        Iterator<T> it = allAccounts.iterator();
        boolean z16 = true;
        boolean z17 = false;
        while (it.hasNext()) {
            SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(BaseApplication.getContext(), ((SimpleAccount) it.next()).getUin());
            SharedPreferences.Editor edit = mMKVData.edit();
            Iterator<T> it5 = mMKVData.getAll().entrySet().iterator();
            while (it5.hasNext()) {
                Map.Entry entry = (Map.Entry) it5.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (QLog.isDebugVersion()) {
                    QLog.i("ThemeCleanUpThoroughCacheTool", 1, "check " + str + " :: " + value);
                }
                if ((value instanceof String) && regex.containsMatchIn((CharSequence) value)) {
                    if (!z17) {
                        z17 = true;
                    }
                    File file = new File(ThemeDiyStyleLogic.getDiyVFSPath((String) value));
                    if (file.exists()) {
                        File file2 = new File(ThemeDiyStyleLogic.getNewCustomBackgroundPath());
                        if (startCopyFile(file2, file)) {
                            String dstPath = file2.getAbsolutePath();
                            QLog.i("ThemeCleanUpThoroughCacheTool", 1, "update " + str + " :: " + dstPath);
                            edit.putString(str, dstPath);
                            String absolutePath = file.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                            Intrinsics.checkNotNullExpressionValue(dstPath, "dstPath");
                            hashMap.put(absolutePath, dstPath);
                        } else {
                            z16 = false;
                        }
                    } else {
                        String str2 = (String) hashMap.get(file.getAbsolutePath());
                        if (str2 != null) {
                            QLog.i("ThemeCleanUpThoroughCacheTool", 1, "update[cache] " + str + " :: " + str2);
                            edit.putString(str, str2);
                        }
                    }
                }
            }
            if (z17) {
                edit.apply();
            }
        }
        if (z17) {
            ReportInfo value2 = VasCommonReporter.getHistoryFeature("custom_background").setValue2("aio");
            if (z16) {
                j3 = 0;
            } else {
                j3 = 1;
            }
            value2.setNum1(j3).report(false);
        }
    }

    private final void moveThemeBg() {
        long j3;
        Regex regex = new Regex("custom_background/\\d+/org/.+");
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        Intrinsics.checkNotNullExpressionValue(allAccounts, "sMobileQQ.allAccounts");
        Iterator<T> it = allAccounts.iterator();
        boolean z16 = false;
        boolean z17 = true;
        while (it.hasNext()) {
            SharedPreferences sharedPreferences = ThemeBackground.getSharedPreferences(BaseApplication.getContext(), ((SimpleAccount) it.next()).getUin(), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator<T> it5 = sharedPreferences.getAll().entrySet().iterator();
            while (it5.hasNext()) {
                Map.Entry entry = (Map.Entry) it5.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if ((value instanceof String) && regex.containsMatchIn((CharSequence) value)) {
                    if (!z16) {
                        z16 = true;
                    }
                    File file = new File(ThemeDiyStyleLogic.getDiyVFSPath((String) value));
                    if (file.exists()) {
                        File file2 = new File(ThemeDiyStyleLogic.getNewCustomBackgroundPath());
                        if (startCopyFile(file2, file)) {
                            edit.putString(str, file2.getAbsolutePath());
                        } else {
                            z17 = false;
                        }
                    }
                }
            }
            if (z16) {
                edit.apply();
            }
        }
        if (z16) {
            ReportInfo value2 = VasCommonReporter.getHistoryFeature("custom_background").setValue2("theme");
            if (z17) {
                j3 = 0;
            } else {
                j3 = 1;
            }
            value2.setNum1(j3).report(false);
        }
    }

    private final boolean startCopyFile(File dstFile, File originFile) {
        try {
            if (dstFile.exists()) {
                dstFile.delete();
            }
            File parentFile = dstFile.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (originFile.renameTo(dstFile)) {
                QLog.i("ThemeCleanUpThoroughCacheTool", 1, "mv success old: " + originFile + " , new: " + dstFile);
                return true;
            }
        } catch (Exception e16) {
            QLog.e("ThemeCleanUpThoroughCacheTool", 1, e16, new Object[0]);
        }
        if (FileUtil.copyFile(originFile, dstFile)) {
            QLog.i("ThemeCleanUpThoroughCacheTool", 1, "copy success old: " + originFile + " , new: " + dstFile);
            return true;
        }
        QLog.w("ThemeCleanUpThoroughCacheTool", 1, "copy fail old: " + originFile + " , new: " + dstFile);
        return false;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        long totalSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        FileScanCore b16 = FileScanCore.Companion.b(FileScanCore.INSTANCE, null, 1, null);
        HashMap hashMap = new HashMap();
        boolean z16 = false;
        if (this.needReport) {
            long j3 = 0;
            for (String str : getWhiteList()) {
                DirSizeData dirSizeData = new DirSizeData(0L, 0, 0, 7, null);
                b16.d(str, false, true, dirSizeData, null);
                VasCommonReporter.getHotFeature("cleaner").setValue2(new File(str).getName()).setValue3("before").setNum1(dirSizeData.getTotalSize()).setNum2(100L).report(false);
                hashMap.put(str, Long.valueOf(dirSizeData.getTotalSize()));
                j3 += dirSizeData.getTotalSize();
            }
            VasCommonReporter.getHotFeature("cleaner").setValue2("theme").setValue3("before").setNum1(j3).report(false);
        }
        ThemeCleaner.cleanUnusedTheme();
        if (ThemeDiyStyleLogic.isNewCustomBackground) {
            clearCustomBackground();
        }
        if (this.needReport) {
            long j16 = 0;
            for (String str2 : getWhiteList()) {
                DirSizeData dirSizeData2 = new DirSizeData(0L, 0, 0, 7, null);
                b16.d(str2, false, true, dirSizeData2, null);
                Long l3 = (Long) hashMap.get(str2);
                if (l3 == null) {
                    l3 = 0L;
                }
                Intrinsics.checkNotNullExpressionValue(l3, "tempData[it] ?: 0L");
                long longValue = l3.longValue();
                ReportInfo num1 = VasCommonReporter.getHotFeature("cleaner").setValue2(new File(str2).getName()).setValue3("after").setNum1(dirSizeData2.getTotalSize());
                if (longValue == 0) {
                    totalSize = 0;
                } else {
                    totalSize = (((float) dirSizeData2.getTotalSize()) / ((float) longValue)) * 100;
                }
                num1.setNum2(totalSize).report(false);
                hashMap.put(str2, Long.valueOf(dirSizeData2.getTotalSize()));
                j16 += dirSizeData2.getTotalSize();
                z16 = false;
            }
            VasCommonReporter.getHotFeature("cleaner").setValue2("theme").setValue3("after").setNum1(j16).report(z16);
        }
        y.a.a(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar = d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.a() + "/app_theme_810", dVar.a() + "/custom_background", dVar.a() + "/files/custom_background", dVar.d() + "/Tencent/MobileQQ/custom_background", dVar.a() + "/theme.2920", dVar.a() + "/theme.2921", dVar.a() + "/theme_move");
        return arrayListOf;
    }
}
