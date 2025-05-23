package com.tencent.mobileqq.qqlive.room.prepare;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends RecyclerView.Adapter<Object> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f271920m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    return BaseImageUtil.getRoundedCornerBitmap3(bitmap, 20.0f, iArr[0], iArr[1]);
                }
            }
            return BaseImageUtil.getClipCenterRectBitmap(bitmap, 50, 50);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56387);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f271920m = new a();
        }
    }
}
