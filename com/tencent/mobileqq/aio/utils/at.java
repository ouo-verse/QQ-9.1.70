package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/at;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "", "fileSize", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "elementType", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class at {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final at f194116a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f194116a = new at();
        }
    }

    at() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int a(FileTransNotifyInfo fileInfo, long fileSize) {
        int coerceAtMost;
        if (fileSize != 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) ((fileInfo.fileProgress * 100) / fileSize), 100);
            return coerceAtMost;
        }
        return 100;
    }

    public final int b(@NotNull MsgElement msgElement, int elementType, @NotNull FileTransNotifyInfo fileInfo) {
        VideoElement videoElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, msgElement, Integer.valueOf(elementType), fileInfo)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        if (elementType != 2) {
            if (elementType != 3) {
                if (elementType == 5 && (videoElement = msgElement.videoElement) != null) {
                    return f194116a.a(fileInfo, videoElement.fileSize);
                }
            } else {
                FileElement fileElement = msgElement.fileElement;
                if (fileElement != null) {
                    return f194116a.a(fileInfo, fileElement.fileSize);
                }
            }
        } else {
            PicElement picElement = msgElement.picElement;
            if (picElement != null) {
                return f194116a.a(fileInfo, picElement.fileSize);
            }
        }
        return 0;
    }
}
