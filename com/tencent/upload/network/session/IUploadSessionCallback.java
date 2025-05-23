package com.tencent.upload.network.session;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadSessionCallback {
    void onOpenFailed(IUploadSession iUploadSession, int i3, String str);

    void onOpenSucceed(IUploadSession iUploadSession);

    void onSessionClosed(IUploadSession iUploadSession);

    void onSessionError(IUploadSession iUploadSession, int i3, String str);
}
