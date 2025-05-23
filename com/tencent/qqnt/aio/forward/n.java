package com.tencent.qqnt.aio.forward;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/forward/n;", "Lcom/tencent/qqnt/aio/forward/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/aio/data/AIOContact;", "contact", "Landroid/content/Intent;", "intent", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class n implements c {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.forward.c
    public boolean a(@NotNull AIOMsgItem msgItem, @NotNull AIOContact contact, @NotNull Intent intent) {
        VideoElement videoElement;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, msgItem, contact, intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("forward_type", 21);
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(5);
        if (firstTypeElement == null || (videoElement = firstTypeElement.videoElement) == null) {
            return false;
        }
        String e16 = aj.e(videoElement);
        if (TextUtils.isEmpty(e16)) {
            return false;
        }
        String f16 = aj.f(videoElement);
        String str2 = "";
        if (f16 == null) {
            f16 = "";
        }
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, f16);
        if (e16 == null) {
            str = "";
        } else {
            str = e16;
        }
        intent.putExtra("file_send_path", str);
        String str3 = videoElement.videoMd5;
        if (str3 != null) {
            Intrinsics.checkNotNullExpressionValue(str3, "videoElement.videoMd5 ?: \"\"");
            str2 = str3;
        }
        intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, str2);
        intent.putExtra("k_dataline", true);
        intent.putExtra(AppConstants.Key.FORWARD_EXTRA, e16);
        return true;
    }
}
