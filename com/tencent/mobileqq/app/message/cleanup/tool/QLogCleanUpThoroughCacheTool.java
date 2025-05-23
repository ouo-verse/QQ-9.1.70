package com.tencent.mobileqq.app.message.cleanup.tool;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/QLogCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", "getClearSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QLogCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_;

    public QLogCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        for (File file : QLog.getOutOfCurHourLogs()) {
            if (file.exists()) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.getName()");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "android_qlog_use_xlog_enable", false, 2, (Object) null);
                if (!contains$default) {
                    QLog.d("QLogCleanUpThoroughCacheTool", 1, "clearCache delete file: " + file.getAbsolutePath());
                    file.delete();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        long j3 = 0;
        for (File file : QLog.getOutOfCurHourLogs()) {
            if (file.exists()) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.getName()");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "android_qlog_use_xlog_enable", false, 2, (Object) null);
                if (!contains$default) {
                    j3 += file.length();
                }
            }
        }
        QLog.d("QLogCleanUpThoroughCacheTool", 1, "getClearSize : " + j3);
        return j3;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(d.f195978a.d() + "/files/tencent/msflogs");
        return arrayListOf;
    }
}
