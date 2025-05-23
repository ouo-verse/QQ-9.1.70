package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoSendStatus;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "StartCompressing", "Compressing", "FinishCompressing", "Uploading", "SendingMsg", "Failed", "Success", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class VideoSendStatus {
    private static final /* synthetic */ VideoSendStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final VideoSendStatus Compressing;
    public static final VideoSendStatus Failed;
    public static final VideoSendStatus FinishCompressing;
    public static final VideoSendStatus Init;
    public static final VideoSendStatus SendingMsg;
    public static final VideoSendStatus StartCompressing;
    public static final VideoSendStatus Success;
    public static final VideoSendStatus Uploading;
    private final int value;

    private static final /* synthetic */ VideoSendStatus[] $values() {
        return new VideoSendStatus[]{Init, StartCompressing, Compressing, FinishCompressing, Uploading, SendingMsg, Failed, Success};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        Init = new VideoSendStatus(QZoneCoverStoreJsPlugin.INIT_PLUGIN, 0, 0);
        StartCompressing = new VideoSendStatus("StartCompressing", 1, 1);
        Compressing = new VideoSendStatus("Compressing", 2, 2);
        FinishCompressing = new VideoSendStatus("FinishCompressing", 3, 3);
        Uploading = new VideoSendStatus("Uploading", 4, 4);
        SendingMsg = new VideoSendStatus("SendingMsg", 5, 5);
        Failed = new VideoSendStatus("Failed", 6, 100);
        Success = new VideoSendStatus("Success", 7, 101);
        $VALUES = $values();
    }

    VideoSendStatus(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static VideoSendStatus valueOf(String str) {
        return (VideoSendStatus) Enum.valueOf(VideoSendStatus.class, str);
    }

    public static VideoSendStatus[] values() {
        return (VideoSendStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
