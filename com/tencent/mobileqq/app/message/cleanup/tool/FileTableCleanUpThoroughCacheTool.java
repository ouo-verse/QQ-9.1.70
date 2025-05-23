package com.tencent.mobileqq.app.message.cleanup.tool;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/FileTableCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "", "getClearSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class FileTableCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_;

    public FileTableCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            d dVar = d.f195978a;
            new File(dVar.a() + "/databases/" + peekAppRuntime.getCurrentUin() + "_msg_file_info_since_890.db").delete();
            new File(dVar.a() + "/databases/" + peekAppRuntime.getCurrentUin() + "_msg_file_info.db").delete();
            QLog.d("FileTableCleanUpThoroughCacheTool", 1, "delete file table");
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        long j3 = 0;
        if (peekAppRuntime != null) {
            d dVar = d.f195978a;
            j3 = new File(dVar.a() + "/databases/" + peekAppRuntime.getCurrentUin() + "_msg_file_info_since_890.db").length() + 0 + new File(dVar.a() + "/databases/" + peekAppRuntime.getCurrentUin() + "_msg_file_info.db").length();
        }
        QLog.d("FileTableCleanUpThoroughCacheTool", 1, "getClearSize : " + j3);
        return j3;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return y.a.c(this);
    }
}
