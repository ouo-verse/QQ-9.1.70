package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/util/cy;", "", "", "outWidth", "outHeight", "", "c", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "b", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "d", "()Lcom/tencent/image/DownloadParams$DecodeHandler;", "ROUND_FACE_DECODER", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class cy {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cy f306749a = new cy();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DownloadParams.DecodeHandler ROUND_FACE_DECODER = new DownloadParams.DecodeHandler() { // from class: com.tencent.mobileqq.util.cx
        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            Bitmap b16;
            b16 = cy.b(downloadParams, bitmap);
            return b16;
        }
    };

    cy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap b(DownloadParams downloadParams, Bitmap bitmap) {
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
                float q16 = com.tencent.mobileqq.utils.ah.q();
                if (q16 < 0.01f) {
                    q16 = 1.0f;
                }
                int i3 = (int) (iArr[0] / q16);
                iArr[0] = i3;
                int i16 = (int) (iArr[1] / q16);
                iArr[1] = i16;
                return BaseImageUtil.getRoundFaceBitmap(bitmap, i3, i16);
            }
        }
        return BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
    }

    @NotNull
    public final int[] c(int outWidth, int outHeight) {
        return new int[]{outWidth, outHeight};
    }

    @NotNull
    public final DownloadParams.DecodeHandler d() {
        return ROUND_FACE_DECODER;
    }
}
