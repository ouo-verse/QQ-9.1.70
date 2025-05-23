package com.tencent.mobileqq.qqlive.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ipc.IQQLiveIPCServerApi;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/utils/k;", "", "", "tag", "Lcom/tencent/mobileqq/qqlive/sail/room/h;", "player", "", "needMute", "", "c", "<init>", "()V", "qq-live-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f273458a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21345);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f273458a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void d(k kVar, String str, com.tencent.mobileqq.qqlive.sail.room.h hVar, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        kVar.c(str, hVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String tag, final boolean z16, final com.tencent.mobileqq.qqlive.sail.room.h player) {
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(player, "$player");
        Integer num = null;
        final EIPCResult callSync = ((IQQLiveIPCServerApi) QRoute.api(IQQLiveIPCServerApi.class)).callSync(QQLiveIPCConstants.Action.ACTION_ROOM_IS_AUDIO_CHATTING, null);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("resume ipcResult code:");
        if (callSync != null) {
            num = Integer.valueOf(callSync.code);
        }
        sb5.append(num);
        QLog.d(tag, 4, sb5.toString());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.utils.j
            @Override // java.lang.Runnable
            public final void run() {
                k.f(EIPCResult.this, z16, player);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(EIPCResult eIPCResult, boolean z16, com.tencent.mobileqq.qqlive.sail.room.h player) {
        boolean z17;
        Intrinsics.checkNotNullParameter(player, "$player");
        if (eIPCResult != null && eIPCResult.code == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (z16) {
                player.y(true);
                return;
            }
            return;
        }
        player.y(false);
    }

    public final void c(@NotNull final String tag, @NotNull final com.tencent.mobileqq.qqlive.sail.room.h player, final boolean needMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tag, player, Boolean.valueOf(needMute));
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(player, "player");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqlive.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                k.e(tag, needMute, player);
            }
        }, 16, null, true);
    }
}
