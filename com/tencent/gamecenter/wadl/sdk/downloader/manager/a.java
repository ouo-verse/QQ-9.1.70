package com.tencent.gamecenter.wadl.sdk.downloader.manager;

import com.tencent.gamecenter.wadl.sdk.common.DownloaderException;
import com.tencent.gamecenter.wadl.sdk.downloader.Downloader;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskCategory;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskStatus;
import com.tencent.gamecenter.wadl.sdk.downloader.HistoryTask;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements Downloader {

    /* renamed from: a, reason: collision with root package name */
    private static a f107411a = new a();

    a() {
        TaskManager.getInstance();
    }

    public static a a() {
        return f107411a;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void deleteAllTask(boolean z16) {
        TaskManager.getInstance().deleteAllTask(z16);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void deleteHistoryTask(HistoryTask historyTask, boolean z16) {
        TaskManager.getInstance().deleteHistoryTask(historyTask, z16);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void deleteTask(DownloaderTask downloaderTask, boolean z16) {
        TaskManager.getInstance().deleteTask(downloaderTask, z16);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v2 ??, still in use, count: 1, list:
          (r7v2 ?? I:com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask) from 0x0032: INVOKE 
          (r7v2 ?? I:com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask)
          (r11v0 ?? I:com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr)
         INTERFACE call: com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask.setAttribute(com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr):void A[MD:(com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr):void (m)] (LINE:51)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask genDownloadTask(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v2 ??, still in use, count: 1, list:
          (r7v2 ?? I:com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask) from 0x0032: INVOKE 
          (r7v2 ?? I:com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask)
          (r11v0 ?? I:com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr)
         INTERFACE call: com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask.setAttribute(com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr):void A[MD:(com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr):void (m)] (LINE:51)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public List<DownloaderTask> getAllTasks() {
        return TaskManager.getInstance().getAllTasks();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public List<HistoryTask> getHistoryTasks() {
        return TaskManager.getInstance().getHistoryTasks();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public String getVersion() {
        return com.tencent.gamecenter.wadl.sdk.common.a.h();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void pauseTasks(boolean z16, boolean z17) {
        TaskManager.getInstance().pauseTasks(true, true, z16, z17);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void resumeTasks(boolean z16, boolean z17) {
        TaskManager.getInstance().resumeTasks(true, true, z16, z17);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setDetectedSpeedTime(long j3) {
        c.a().b(j3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setDualDownloadSwitch(boolean z16) {
        b.c().a(z16);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setEnhanceThreadNums(int i3) {
        MultiThreadManager.getInstance().setEnhanceThreadNums(i3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setMultiTheadDownOpen(boolean z16) {
        MultiThreadManager.getInstance().setMultiTheadDownOpen(z16);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setMultiThreadDownFileSize(long j3) {
        MultiThreadManager.getInstance().setMultiThreadDownFileSize(j3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setNotNetworkWaitMillis(int i3) {
        com.tencent.gamecenter.wadl.sdk.downloader.a.a.a(i3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setPhoneGuid(String str) {
        com.tencent.gamecenter.wadl.sdk.downloader.a.a.e(str);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setProgressInterval(int i3) {
        com.tencent.gamecenter.wadl.sdk.downloader.a.a.b(i3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setQua1(String str) {
        com.tencent.gamecenter.wadl.sdk.downloader.a.a.c(str);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setQua2(String str) {
        com.tencent.gamecenter.wadl.sdk.downloader.a.a.d(str);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setSaveHistoryTasks(boolean z16) {
        TaskManager.getInstance().setSaveHistoryTasks(z16);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setTempFileSubfix(String str) {
        com.tencent.gamecenter.wadl.sdk.downloader.a.a.f(str);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void startDownload(DownloaderTask downloaderTask) {
        if (downloaderTask != null) {
            DownloaderTaskStatus status = downloaderTask.getStatus();
            if (status != DownloaderTaskStatus.FAILED && status != DownloaderTaskStatus.PAUSED && status != DownloaderTaskStatus.COMPLETE) {
                if (status == DownloaderTaskStatus.NONE || status == DownloaderTaskStatus.PENDING) {
                    if (TaskManager.getInstance().optAddTask(downloaderTask)) {
                        downloaderTask.start();
                        return;
                    }
                } else {
                    return;
                }
            }
            downloaderTask.resume();
            return;
        }
        throw new DownloaderException("downloaderTask is null.");
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void updateGlobalSpeedBuffer(int i3) {
        c.a().a(i3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.Downloader
    public void setTaskNumForCategory(DownloaderTaskCategory downloaderTaskCategory, int i3) {
    }
}
