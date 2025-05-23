package com.tencent.qne.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qne/model/PreloadStatusCode;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "DownloadSuccess", "NotNeedDownload", "DownloadOrCheckFail", "CreateDirFail", "UnzipFail", "OtherFail", "CheckNetworkFail", "qne_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class PreloadStatusCode {
    private static final /* synthetic */ PreloadStatusCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final PreloadStatusCode CheckNetworkFail;
    public static final PreloadStatusCode CreateDirFail;
    public static final PreloadStatusCode DownloadOrCheckFail;
    public static final PreloadStatusCode DownloadSuccess;
    public static final PreloadStatusCode NotNeedDownload;
    public static final PreloadStatusCode OtherFail;
    public static final PreloadStatusCode UnzipFail;
    private final int value;

    private static final /* synthetic */ PreloadStatusCode[] $values() {
        return new PreloadStatusCode[]{DownloadSuccess, NotNeedDownload, DownloadOrCheckFail, CreateDirFail, UnzipFail, OtherFail, CheckNetworkFail};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15189);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        DownloadSuccess = new PreloadStatusCode("DownloadSuccess", 0, 0);
        NotNeedDownload = new PreloadStatusCode("NotNeedDownload", 1, 1);
        DownloadOrCheckFail = new PreloadStatusCode("DownloadOrCheckFail", 2, 2);
        CreateDirFail = new PreloadStatusCode("CreateDirFail", 3, 3);
        UnzipFail = new PreloadStatusCode("UnzipFail", 4, 4);
        OtherFail = new PreloadStatusCode("OtherFail", 5, 5);
        CheckNetworkFail = new PreloadStatusCode("CheckNetworkFail", 6, 6);
        $VALUES = $values();
    }

    PreloadStatusCode(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static PreloadStatusCode valueOf(String str) {
        return (PreloadStatusCode) Enum.valueOf(PreloadStatusCode.class, str);
    }

    public static PreloadStatusCode[] values() {
        return (PreloadStatusCode[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
