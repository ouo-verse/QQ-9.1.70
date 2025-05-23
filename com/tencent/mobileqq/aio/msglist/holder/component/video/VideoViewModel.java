package com.tencent.mobileqq.aio.msglist.holder.component.video;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoViewModel;", "", "(Ljava/lang/String;I)V", "Normal", "Shot", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class VideoViewModel {
    private static final /* synthetic */ VideoViewModel[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final VideoViewModel Normal;
    public static final VideoViewModel Shot;

    private static final /* synthetic */ VideoViewModel[] $values() {
        return new VideoViewModel[]{Normal, Shot};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64036);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Normal = new VideoViewModel("Normal", 0);
        Shot = new VideoViewModel("Shot", 1);
        $VALUES = $values();
    }

    VideoViewModel(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static VideoViewModel valueOf(String str) {
        return (VideoViewModel) Enum.valueOf(VideoViewModel.class, str);
    }

    public static VideoViewModel[] values() {
        return (VideoViewModel[]) $VALUES.clone();
    }
}
