package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/UploadOrDownloadState;", "", "Ljava/io/Serializable;", "(Ljava/lang/String;I)V", "IDLE", "UPLOADING", "UPLOAD_SUC", "UPLOAD_ERR", "DOWNLOADING", "DOWNLOAD_SUC", "DOWNLOAD_ERR", "COMPRESSING", "COMPRESS_SUC", "COMPRESS_ERR", "IMG_INVALID_SIZE", "VIDEO_INVALID_SIZE", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class UploadOrDownloadState implements Serializable {
    private static final /* synthetic */ UploadOrDownloadState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final UploadOrDownloadState COMPRESSING;
    public static final UploadOrDownloadState COMPRESS_ERR;
    public static final UploadOrDownloadState COMPRESS_SUC;
    public static final UploadOrDownloadState DOWNLOADING;
    public static final UploadOrDownloadState DOWNLOAD_ERR;
    public static final UploadOrDownloadState DOWNLOAD_SUC;
    public static final UploadOrDownloadState IDLE;
    public static final UploadOrDownloadState IMG_INVALID_SIZE;
    public static final UploadOrDownloadState UPLOADING;
    public static final UploadOrDownloadState UPLOAD_ERR;
    public static final UploadOrDownloadState UPLOAD_SUC;
    public static final UploadOrDownloadState VIDEO_INVALID_SIZE;

    private static final /* synthetic */ UploadOrDownloadState[] $values() {
        return new UploadOrDownloadState[]{IDLE, UPLOADING, UPLOAD_SUC, UPLOAD_ERR, DOWNLOADING, DOWNLOAD_SUC, DOWNLOAD_ERR, COMPRESSING, COMPRESS_SUC, COMPRESS_ERR, IMG_INVALID_SIZE, VIDEO_INVALID_SIZE};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        IDLE = new UploadOrDownloadState("IDLE", 0);
        UPLOADING = new UploadOrDownloadState("UPLOADING", 1);
        UPLOAD_SUC = new UploadOrDownloadState("UPLOAD_SUC", 2);
        UPLOAD_ERR = new UploadOrDownloadState("UPLOAD_ERR", 3);
        DOWNLOADING = new UploadOrDownloadState("DOWNLOADING", 4);
        DOWNLOAD_SUC = new UploadOrDownloadState("DOWNLOAD_SUC", 5);
        DOWNLOAD_ERR = new UploadOrDownloadState("DOWNLOAD_ERR", 6);
        COMPRESSING = new UploadOrDownloadState("COMPRESSING", 7);
        COMPRESS_SUC = new UploadOrDownloadState("COMPRESS_SUC", 8);
        COMPRESS_ERR = new UploadOrDownloadState("COMPRESS_ERR", 9);
        IMG_INVALID_SIZE = new UploadOrDownloadState("IMG_INVALID_SIZE", 10);
        VIDEO_INVALID_SIZE = new UploadOrDownloadState("VIDEO_INVALID_SIZE", 11);
        $VALUES = $values();
    }

    UploadOrDownloadState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static UploadOrDownloadState valueOf(String str) {
        return (UploadOrDownloadState) Enum.valueOf(UploadOrDownloadState.class, str);
    }

    public static UploadOrDownloadState[] values() {
        return (UploadOrDownloadState[]) $VALUES.clone();
    }
}
