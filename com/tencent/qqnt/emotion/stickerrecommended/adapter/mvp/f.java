package com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/adapter/mvp/f;", "", "", "from", "Lcom/tencent/qqnt/emotion/stickerrecommended/adapter/mvp/StickerRecKeywordFrom;", "a", "<init>", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f356488a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f356488a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final StickerRecKeywordFrom a(int from) {
        StickerRecKeywordFrom stickerRecKeywordFrom = StickerRecKeywordFrom.INPUT;
        if (from != stickerRecKeywordFrom.ordinal()) {
            StickerRecKeywordFrom stickerRecKeywordFrom2 = StickerRecKeywordFrom.LITE_ACTION;
            if (from != stickerRecKeywordFrom2.ordinal()) {
                stickerRecKeywordFrom2 = StickerRecKeywordFrom.QZONE;
                if (from != stickerRecKeywordFrom2.ordinal()) {
                    return stickerRecKeywordFrom;
                }
            }
            return stickerRecKeywordFrom2;
        }
        return stickerRecKeywordFrom;
    }
}
