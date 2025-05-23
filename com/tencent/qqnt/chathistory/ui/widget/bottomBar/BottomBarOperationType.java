package com.tencent.qqnt.chathistory.ui.widget.bottomBar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "", "(Ljava/lang/String;I)V", "FORWARD", "DOWNLOAD", "FAVORITE", "WEIYUN", "DELETE", "GROUPALBUM", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class BottomBarOperationType {
    private static final /* synthetic */ BottomBarOperationType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final BottomBarOperationType DELETE;
    public static final BottomBarOperationType DOWNLOAD;
    public static final BottomBarOperationType FAVORITE;
    public static final BottomBarOperationType FORWARD;
    public static final BottomBarOperationType GROUPALBUM;
    public static final BottomBarOperationType WEIYUN;

    private static final /* synthetic */ BottomBarOperationType[] $values() {
        return new BottomBarOperationType[]{FORWARD, DOWNLOAD, FAVORITE, WEIYUN, DELETE, GROUPALBUM};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FORWARD = new BottomBarOperationType("FORWARD", 0);
        DOWNLOAD = new BottomBarOperationType("DOWNLOAD", 1);
        FAVORITE = new BottomBarOperationType("FAVORITE", 2);
        WEIYUN = new BottomBarOperationType("WEIYUN", 3);
        DELETE = new BottomBarOperationType("DELETE", 4);
        GROUPALBUM = new BottomBarOperationType("GROUPALBUM", 5);
        $VALUES = $values();
    }

    BottomBarOperationType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static BottomBarOperationType valueOf(String str) {
        return (BottomBarOperationType) Enum.valueOf(BottomBarOperationType.class, str);
    }

    public static BottomBarOperationType[] values() {
        return (BottomBarOperationType[]) $VALUES.clone();
    }
}
