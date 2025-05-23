package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorStatus;", "", "(Ljava/lang/String;I)V", "Expired", "Failed", "NotSupport", "Other", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class VideoErrorStatus {
    private static final /* synthetic */ VideoErrorStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final VideoErrorStatus Expired;
    public static final VideoErrorStatus Failed;
    public static final VideoErrorStatus NotSupport;
    public static final VideoErrorStatus Other;

    private static final /* synthetic */ VideoErrorStatus[] $values() {
        return new VideoErrorStatus[]{Expired, Failed, NotSupport, Other};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Expired = new VideoErrorStatus("Expired", 0);
        Failed = new VideoErrorStatus("Failed", 1);
        NotSupport = new VideoErrorStatus("NotSupport", 2);
        Other = new VideoErrorStatus("Other", 3);
        $VALUES = $values();
    }

    VideoErrorStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static VideoErrorStatus valueOf(String str) {
        return (VideoErrorStatus) Enum.valueOf(VideoErrorStatus.class, str);
    }

    public static VideoErrorStatus[] values() {
        return (VideoErrorStatus[]) $VALUES.clone();
    }
}
