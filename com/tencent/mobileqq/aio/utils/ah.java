package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/ah;", "", "", "content", "", "b", "", "emoServerId", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ah {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f194109a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65295);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f194109a = new ah();
        }
    }

    ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(int emoServerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, emoServerId)).booleanValue();
        }
        int convertToLocal = QQSysFaceUtil.convertToLocal(emoServerId);
        boolean isBigStickerById = QQSysFaceUtil.isBigStickerById(convertToLocal);
        if (QLog.isDevelopLevel()) {
            QLog.i("LottieCheckUtil", 4, "LottieLocalResValid emoServerId=" + emoServerId + " localId=" + convertToLocal + " isResValid=" + isBigStickerById);
        }
        return isBigStickerById;
    }

    public final boolean b(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) content)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(content, "content");
        int length = content.length();
        int i3 = -1;
        int i16 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (i17 > i3) {
                if (!y.f194180a.f(content, i17)) {
                    return false;
                }
                QRouteApi api = QRoute.api(IEmojiSpanService.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api;
                if (!iEmojiSpanService.isValidEmojiFaceId(content, i17)) {
                    QLog.i("LottieCheckUtil", 1, "is Valid EmojiFaceId");
                    return false;
                }
                if (!a(iEmojiSpanService.convertEmoCodeToServerId(content, i17)) || (i16 = i16 + 1) > 1) {
                    return false;
                }
                i3 = i17 + 1;
            }
        }
        if (i16 != 1) {
            return false;
        }
        return true;
    }
}
