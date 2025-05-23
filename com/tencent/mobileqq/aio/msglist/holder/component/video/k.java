package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaFilePathInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aJ\u0014\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/k;", "", "", "srcPath", "destPath", "", "tryMoveFile", "e", "path", "", tl.h.F, "i", "newThumbPath", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "p", "j", "videoPath", "g", "f", "Lkotlin/Function0;", "task", DomainData.DOMAIN_NAME, "l", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f192240a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f192240a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e(String srcPath, String destPath, boolean tryMoveFile) {
        if (cq.n(destPath)) {
            return true;
        }
        if (!com.tencent.qqnt.aio.utils.m.f352305a.c(destPath)) {
            QLog.w("AIOVideoSendUtility", 1, "[copyFile] failed to create directory, path is " + destPath);
            return false;
        }
        if (tryMoveFile) {
            if (new File(srcPath).renameTo(new File(destPath))) {
                return true;
            }
            QLog.w("AIOVideoSendUtility", 1, "[copyFile] failed to rename " + srcPath + " to " + destPath);
        }
        if (com.tencent.qqnt.util.file.a.c(srcPath, destPath, true)) {
            return true;
        }
        QLog.w("AIOVideoSendUtility", 1, "[copyFile] failed to copy from " + srcPath + " to " + destPath + "  freeSpace=" + i(srcPath) + " MB");
        return false;
    }

    private final long h(String path) {
        try {
            StatFs statFs = new StatFs(path);
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e16) {
            QLog.w("AIOVideoSendUtility", 1, "[getFreeDiskSpace] fail, exc=" + e16);
            return -1L;
        }
    }

    private final String i(String path) {
        long h16 = h(path);
        if (h16 == -1) {
            return "(unknown)";
        }
        return String.valueOf(h16 / 1048576);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MsgRecord msgRecord, int i3, String str) {
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        if (i3 != 0) {
            QLog.i("AIOVideoSendUtility", 1, "failed to resend msg, msgId=" + msgRecord.msgId + ", result=" + i3 + ", msg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MsgRecord msgRecord, int i3, String str) {
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        if (i3 == 0) {
            com.tencent.qqnt.aio.utils.q.a("AIOVideoSendUtility", "send video message, msgId=" + msgRecord.msgId);
            return;
        }
        com.tencent.qqnt.aio.utils.q.e("AIOVideoSendUtility", "failed to send video message, msg=" + msgRecord + ", result=" + i3 + ", error=" + str);
    }

    private final void r(String newThumbPath, MsgElement msgElement) {
        HashMap<Integer, String> hashMapOf;
        VideoElement videoElement = msgElement.videoElement;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair(0, newThumbPath));
        videoElement.thumbPath = hashMapOf;
        videoElement.thumbMd5 = cq.r(newThumbPath);
        videoElement.thumbSize = (int) cq.v(newThumbPath);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(newThumbPath, options);
        videoElement.thumbWidth = options.outWidth;
        videoElement.thumbHeight = options.outHeight;
    }

    @Nullable
    public final String f(@NotNull MsgElement msgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgElement);
        }
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        if (msgElement.elementType == 5) {
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            String str = null;
            if (e16 != null) {
                VideoElement videoElement = msgElement.videoElement;
                String richMediaFilePathForMobileQQSend = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(5, 0, videoElement.videoMd5, com.tencent.qqnt.aio.utils.m.f352305a.g(videoElement.fileName), 2, 0, null, "", true));
                if (richMediaFilePathForMobileQQSend != null) {
                    HashMap<Integer, String> hashMap = msgElement.videoElement.thumbPath;
                    if (hashMap != null) {
                        str = hashMap.get(0);
                    }
                    if (!cq.n(richMediaFilePathForMobileQQSend) && cq.n(str)) {
                        Intrinsics.checkNotNull(str);
                        e(str, richMediaFilePathForMobileQQSend, true);
                    }
                    r(richMediaFilePathForMobileQQSend, msgElement);
                    return richMediaFilePathForMobileQQSend;
                }
            }
            return null;
        }
        throw new RuntimeException("not video element");
    }

    public final boolean g(@NotNull MsgElement msgElement, @NotNull String videoPath, boolean tryMoveFile) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, msgElement, videoPath, Boolean.valueOf(tryMoveFile))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        if (msgElement.elementType == 5) {
            String r16 = cq.r(videoPath);
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                str = e16.getRichMediaFilePathForMobileQQSend(new RichMediaFilePathInfo(5, 0, r16, com.tencent.qqnt.aio.utils.m.f352305a.g(videoPath), 1, 0, null, "", true));
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.w("AIOVideoSendUtility", 1, "[copyVideoToNTDIR] path is empty, elementId=" + msgElement.elementId + " path:" + videoPath + " md5:" + r16);
                return false;
            }
            if (!e(videoPath, str, tryMoveFile)) {
                return false;
            }
            VideoElement videoElement = msgElement.videoElement;
            videoElement.filePath = str;
            videoElement.fileSize = cq.v(str);
            videoElement.fileName = com.tencent.qqnt.aio.utils.m.f352305a.g(str);
            videoElement.videoMd5 = r16;
            int b16 = (int) (o.f192253a.b(str) / 1000);
            videoElement.fileTime = b16;
            videoElement.fileFormat = 2;
            QLog.i("AIOVideoSendUtility", 1, "[copyVideoToNTDIR] elementId=" + msgElement.elementId + " name=" + videoElement.fileName + " size=" + videoElement.fileSize + " time=" + b16 + " path=" + videoElement.filePath + " md5=" + r16);
            return true;
        }
        throw new RuntimeException("not video element");
    }

    public final void j(@NotNull final MsgRecord msgRecord, @NotNull Contact contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord, (Object) contact);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (QLog.isColorLevel()) {
            QLog.i("AIOVideoSendUtility", 2, "handleResendVideoMsg, msgId = " + msgRecord.msgId);
        }
        ((IMsgService) QRoute.api(IMsgService.class)).resendMsg(contact, msgRecord.msgId, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.j
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                k.k(MsgRecord.this, i3, str);
            }
        });
    }

    public final void l(@NotNull final Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            task.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.h
                @Override // java.lang.Runnable
                public final void run() {
                    k.m(Function0.this);
                }
            });
        }
    }

    public final void n(@NotNull final Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            task.invoke();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.g
                @Override // java.lang.Runnable
                public final void run() {
                    k.o(Function0.this);
                }
            }, 16, null, false);
        }
    }

    public final void p(@NotNull final MsgRecord msgRecord, @NotNull Contact contact) {
        VideoCodecFormatType videoCodecFormatType;
        VideoElement videoElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord, (Object) contact);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (QLog.isColorLevel()) {
            long j3 = msgRecord.msgId;
            MsgElement i3 = MsgExtKt.i(msgRecord, 5);
            if (i3 != null && (videoElement = i3.videoElement) != null) {
                videoCodecFormatType = videoElement.sourceVideoCodecFormat;
            } else {
                videoCodecFormatType = null;
            }
            QLog.d("AIOVideoSendUtility", 2, "handle sendVideo msg , msgId = " + j3 + " sourceVideoCodecFormat=" + videoCodecFormatType);
        }
        if (msgRecord.elements.isEmpty()) {
            QLog.i("AIOVideoSendUtility", 1, "handle sendVideo msg, elements is empty, msgId = " + msgRecord.msgId);
            return;
        }
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        long j16 = msgRecord.msgId;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        iMsgService.sendMsg(contact, j16, arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                k.q(MsgRecord.this, i16, str);
            }
        });
    }
}
