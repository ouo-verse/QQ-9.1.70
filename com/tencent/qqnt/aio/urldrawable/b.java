package com.tencent.qqnt.aio.urldrawable;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/image/DownloadParams$DecodeHandler;", "a", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "c", "()Lcom/tencent/image/DownloadParams$DecodeHandler;", "CIRCLE_COLOR_DECODER", "aio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final DownloadParams.DecodeHandler f352234a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47908);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f352234a = new DownloadParams.DecodeHandler() { // from class: com.tencent.qqnt.aio.urldrawable.a
                @Override // com.tencent.image.DownloadParams.DecodeHandler
                public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                    Bitmap b16;
                    b16 = b.b(downloadParams, bitmap);
                    return b16;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap b(DownloadParams downloadParams, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Object obj = downloadParams.tag;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr.length == 2) {
                return BaseImageUtil.getCicrlColorBitmap(bitmap, iArr[0], iArr[1]);
            }
        }
        return bitmap;
    }

    @NotNull
    public static final DownloadParams.DecodeHandler c() {
        return f352234a;
    }
}
