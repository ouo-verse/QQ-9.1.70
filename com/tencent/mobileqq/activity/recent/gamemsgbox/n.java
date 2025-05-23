package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/n;", "", "", "peerUid", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f185548a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f185548a = new n();
        }
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String peerUid) {
        List split$default;
        List split$default2;
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        split$default = StringsKt__StringsKt.split$default((CharSequence) peerUid, new String[]{PeerUid.BIDIRECTION_TINY_ID_PERFIX}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{"_"}, false, 0, 6, (Object) null);
            if (split$default2.size() != 2) {
                return "";
            }
            try {
                return ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createConvertUinFromTinyId(Long.parseLong((String) split$default2.get(0)), Long.parseLong((String) split$default2.get(1)));
            } catch (NumberFormatException e16) {
                QLog.e("GameBoxNtHelper", 1, e16.getMessage(), e16);
                return "";
            }
        }
        return "";
    }
}
