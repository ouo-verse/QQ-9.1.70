package com.tencent.comic.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import mqq.app.ISecurityFileHelper;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g implements ISecurityFileHelper {

    /* renamed from: a, reason: collision with root package name */
    private Pattern f99486a = Pattern.compile("\\d{5,}");

    /* renamed from: b, reason: collision with root package name */
    private FilenameFilter f99487b = new a();

    @Override // mqq.app.ISecurityFileHelper
    public String declareBusinessFileName() {
        return "QQComicOffline";
    }

    @Override // mqq.app.ISecurityFileHelper
    public boolean doMigrate(File file) {
        File file2 = new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/");
        String[] list = file2.list(this.f99487b);
        if (list != null && list.length != 0) {
            for (String str : list) {
                File file3 = new File(file2, str);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(file.getAbsolutePath());
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(str);
                sb5.append(str2);
                sb5.append(declareBusinessFileName());
                File file4 = new File(sb5.toString());
                int quickMove = FileUtils.quickMove(file3.getAbsolutePath(), file4.getAbsolutePath());
                QLog.d("VipComicSecurityFileHelper", 2, "doMigrate\uff1a" + declareBusinessFileName() + " result = " + quickMove + " fromFile = " + file3.getAbsolutePath() + " targetFile = " + file4.getAbsolutePath());
                if (quickMove != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // mqq.app.ISecurityFileHelper
    public boolean needMigration() {
        Object obj;
        String[] list = new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/").list(this.f99487b);
        boolean z16 = list != null && list.length > 0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("needMigration: uinDirs.len=");
        if (list == null) {
            obj = 0;
        } else {
            obj = list.length + " needMigration=" + z16;
        }
        sb5.append(obj);
        QLog.i("VipComicSecurityFileHelper", 2, sb5.toString());
        return z16;
    }

    @Override // mqq.app.ISecurityFileHelper
    public File oldBusinessDir(String str) {
        return new File(new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/"), str);
    }

    @Override // mqq.app.ISecurityFileHelper
    public boolean oldBusinessDirExist(String str) {
        File oldBusinessDir = oldBusinessDir(str);
        return oldBusinessDir.isDirectory() && oldBusinessDir.exists();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return file != null && file.isDirectory() && g.this.f99486a.matcher(str).matches();
        }
    }

    @Override // mqq.app.ISecurityFileHelper
    public String[] reportHistoryFileInfo() {
        String[] strArr = new String[2];
        File file = new File(AppConstants.SDCARD_ROOT, "/tencent/MobileQQ/qqcomic/offline/");
        String[] list = file.list(this.f99487b);
        if (list != null && list.length > 0) {
            long j3 = 0;
            long j16 = 0;
            for (String str : list) {
                j3 += FileUtils.getFileOrFolderSize(new File(file, str).getAbsolutePath());
                j16 += FileUtils.getFileAmount(new File(file, str).getAbsolutePath());
            }
            strArr[0] = Long.toString(j3);
            strArr[1] = Long.toString(j16);
            QLog.d("VipComicSecurityFileHelper", 2, "reportHistoryFileInfo:" + declareBusinessFileName() + " fileAmount = " + j16 + " fileSize = " + j3);
        }
        return strArr;
    }
}
