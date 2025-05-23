package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "Success", "FailCompress", "VideoTooLarge", "CancelCompress", "FailUpload", "CancelUpload", "FailSendMsg", "TaskIsNull", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class VideoErrorCode {
    private static final /* synthetic */ VideoErrorCode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final VideoErrorCode CancelCompress;
    public static final VideoErrorCode CancelUpload;
    public static final VideoErrorCode FailCompress;
    public static final VideoErrorCode FailSendMsg;
    public static final VideoErrorCode FailUpload;
    public static final VideoErrorCode Success;
    public static final VideoErrorCode TaskIsNull;
    public static final VideoErrorCode VideoTooLarge;
    private final int value;

    private static final /* synthetic */ VideoErrorCode[] $values() {
        return new VideoErrorCode[]{Success, FailCompress, VideoTooLarge, CancelCompress, FailUpload, CancelUpload, FailSendMsg, TaskIsNull};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        Success = new VideoErrorCode("Success", 0, 0);
        FailCompress = new VideoErrorCode("FailCompress", 1, 1);
        VideoTooLarge = new VideoErrorCode("VideoTooLarge", 2, 2);
        CancelCompress = new VideoErrorCode("CancelCompress", 3, 3);
        FailUpload = new VideoErrorCode("FailUpload", 4, 4);
        CancelUpload = new VideoErrorCode("CancelUpload", 5, 5);
        FailSendMsg = new VideoErrorCode("FailSendMsg", 6, 6);
        TaskIsNull = new VideoErrorCode("TaskIsNull", 7, 7);
        $VALUES = $values();
    }

    VideoErrorCode(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.value = i16;
        }
    }

    public static VideoErrorCode valueOf(String str) {
        return (VideoErrorCode) Enum.valueOf(VideoErrorCode.class, str);
    }

    public static VideoErrorCode[] values() {
        return (VideoErrorCode[]) $VALUES.clone();
    }

    public final int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.value;
    }
}
