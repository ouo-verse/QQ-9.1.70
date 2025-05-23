package com.tencent.could.component.common.ai.clipphoto;

import android.net.Uri;

/* loaded from: classes5.dex */
public interface ClipPhotoEventListener {
    void doStartCompressImage();

    void getSelectPhotoUri(Uri uri);

    void sendBitmapWithBase64(String str);

    void sendClipPhotoError(String str);
}
