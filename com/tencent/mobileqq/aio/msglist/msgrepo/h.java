package com.tencent.mobileqq.aio.msglist.msgrepo;

import android.text.TextUtils;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.BaseMsgRepo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002R\"\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/msgrepo/h;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileTransNotifyInfo", "", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "fileInfo", "", "b", "c", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "msgRepoWr", "msgRepo", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<BaseMsgRepo> msgRepoWr;

    public h(@NotNull BaseMsgRepo msgRepo) {
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRepo);
        } else {
            this.msgRepoWr = new WeakReference<>(msgRepo);
        }
    }

    private final void a(FileTransNotifyInfo fileTransNotifyInfo) {
        if (fileTransNotifyInfo.fileErrCode == 2006045) {
            QLog.i("AIOMsgRepo RichMediaAbility", 1, "Kernel CreateFileDir Fail path: " + fileTransNotifyInfo.filePath + ", msgId: " + fileTransNotifyInfo.msgId);
            if (!TextUtils.isEmpty(fileTransNotifyInfo.filePath)) {
                try {
                    File createDirectory = FileUtils.createDirectory(fileTransNotifyInfo.filePath);
                    QLog.i("AIOMsgRepo RichMediaAbility", 1, "Test CreateFileDir path: " + fileTransNotifyInfo.filePath + ", msgId: " + fileTransNotifyInfo.msgId + ", exist: " + createDirectory.exists() + ", canRead: " + createDirectory.canRead() + ", canWrite: " + createDirectory.canWrite());
                } catch (Exception e16) {
                    QLog.i("AIOMsgRepo RichMediaAbility", 1, "createDirectory exception: " + e16.getMessage() + ", msgId: " + fileTransNotifyInfo.msgId);
                }
            }
        }
    }

    private final boolean b(AIOMsgItem msgItem, FileTransNotifyInfo fileInfo) {
        if (com.tencent.mobileqq.aio.utils.d.b0(msgItem)) {
            ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgElement) it.next()).elementId == fileInfo.msgElementId) {
                    return true;
                }
            }
            return false;
        }
        if (msgItem.getMsgId() == fileInfo.msgId) {
            return true;
        }
        return false;
    }

    public final void c(@NotNull FileTransNotifyInfo fileInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        BaseMsgRepo baseMsgRepo = this.msgRepoWr.get();
        if (baseMsgRepo == null) {
            QLog.i("AIOMsgRepo RichMediaAbility", 1, "[NotifyChangeTask]: msgRepo is null");
            return;
        }
        MsgList M = baseMsgRepo.M();
        boolean z16 = false;
        int i3 = 0;
        for (com.tencent.aio.data.msglist.a aVar : M) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a aVar2 = aVar;
            if (aVar2 instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar2;
                if (b(aIOMsgItem, fileInfo)) {
                    AIOMsgItem cloneNewInstance = aIOMsgItem.cloneNewInstance();
                    QLog.d("AIOMsgRepo RichMediaAbility", 1, "handleRichMedia oldFileTransInfo: " + cloneNewInstance.getFileTransNotifyInfo());
                    a(cloneNewInstance.getFileTransNotifyInfo());
                    cloneNewInstance.setFileTransNotifyInfo(fileInfo);
                    Unit unit = Unit.INSTANCE;
                    M.set(i3, (com.tencent.aio.data.msglist.a) cloneNewInstance);
                    z16 = true;
                }
            }
            i3 = i16;
        }
        if (z16) {
            BaseMsgRepo.o0(baseMsgRepo, M, "rich_media", null, null, 12, null);
        }
    }
}
