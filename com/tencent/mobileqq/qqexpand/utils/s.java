package com.tencent.mobileqq.qqexpand.utils;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f264111a = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            return BaseImageUtil.getCicrlColorBitmap(BaseImageUtil.getRoundFaceBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight()), -1, ViewUtils.dpToPx(1.0f));
        }
    }
}
