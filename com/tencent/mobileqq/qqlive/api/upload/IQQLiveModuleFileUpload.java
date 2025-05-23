package com.tencent.mobileqq.qqlive.api.upload;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQLiveModuleFileUpload extends IQQLiveModule {
    void uploadBitmap(Bitmap bitmap, QQLiveUploadBitmapParams qQLiveUploadBitmapParams, IQQLiveUploadBitmapCallback iQQLiveUploadBitmapCallback);
}
