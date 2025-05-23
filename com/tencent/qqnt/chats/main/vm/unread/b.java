package com.tencent.qqnt.chats.main.vm.unread;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.biz.guild.g;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.m;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.main.vm.datasource.filter.ChatsFilterUtil;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J+\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/unread/b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "aioPeerUid", "", "aioChatType", "", "f", "Lmqq/app/AppRuntime;", "app", "d", "(Lmqq/app/AppRuntime;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/b;", "platformDateFilterList", "g", "Ljava/lang/StringBuilder;", "log", "e", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f355436a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f355436a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, String str) {
        QLog.i("ChatsUnreadUtil", 1, "setAllC2CAndGroupMsgRead err: " + i3 + ", msg: " + str);
        if (i3 != 0) {
            ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.w(m.f354604a));
        }
    }

    private final boolean f(RecentContactInfo info, String aioPeerUid, int aioChatType) {
        if (Intrinsics.areEqual(info.peerUid, aioPeerUid) && info.chatType == aioChatType) {
            return true;
        }
        return false;
    }

    public final void b(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        w msgService = ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            return;
        }
        msgService.setAllC2CAndGroupMsgRead(new IOperateCallback() { // from class: com.tencent.qqnt.chats.main.vm.unread.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                b.c(i3, str);
            }
        });
    }

    @Nullable
    public final Object d(@NotNull AppRuntime appRuntime, @NotNull String str, int i3, @NotNull Continuation<? super Integer> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, appRuntime, str, Integer.valueOf(i3), continuation);
        }
        aa recentContactService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            return Boxing.boxInt(0);
        }
        List<RecentContactInfo> a16 = recentContactService.a();
        if (a16 == null) {
            return Boxing.boxInt(0);
        }
        List<com.tencent.qqnt.chats.main.vm.datasource.filter.b> d16 = ChatsFilterUtil.f355413a.d();
        StringBuilder sb5 = new StringBuilder("getAIOShowUnreadCount,");
        for (RecentContactInfo recentContactInfo : a16) {
            b bVar = f355436a;
            if (bVar.g(recentContactInfo, d16) && !bVar.f(recentContactInfo, str, i3)) {
                i16 += bVar.e(recentContactInfo, sb5);
            }
        }
        sb5.append(",totalUnreadCount=");
        sb5.append(i16);
        sb5.append(";");
        QLog.i("ChatsUnreadUtil", 1, sb5.toString());
        return Boxing.boxInt(i16);
    }

    public final int e(@NotNull RecentContactInfo info, @Nullable StringBuilder log) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) info, (Object) log)).intValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        int i3 = info.chatType;
        if (i3 == 16) {
            int c16 = g.f354280a.c(info);
            if (log != null) {
                log.append(info.peerUid);
                log.append(Marker.ANY_NON_NULL_MARKER);
                log.append(info.chatType);
                log.append(ContainerUtils.KEY_VALUE_DELIMITER);
                log.append(c16);
                log.append(";");
            }
            return c16;
        }
        if (i3 == 4) {
            int a16 = g.f354280a.a(info);
            if (log != null) {
                GuildContactInfo guildContactInfo = info.guildContactInfo;
                if (guildContactInfo != null) {
                    str = guildContactInfo.channelId;
                } else {
                    str = null;
                }
                log.append(str);
                log.append(Marker.ANY_NON_NULL_MARKER);
                log.append(info.chatType);
                log.append(ContainerUtils.KEY_VALUE_DELIMITER);
                log.append(a16);
                log.append(";");
            }
            return a16;
        }
        if (info.unreadCnt > 0 && !info.isMsgDisturb) {
            long j3 = info.shieldFlag;
            if (((int) j3) != 2 && ((int) j3) != 4 && ((int) j3) != 3 && ((int) info.unreadFlag) != 1) {
                if (log != null) {
                    log.append(info.peerUid);
                    log.append(Marker.ANY_NON_NULL_MARKER);
                    log.append(info.chatType);
                    log.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    log.append(info.unreadCnt);
                    log.append(";");
                }
                return (int) info.unreadCnt;
            }
        }
        return 0;
    }

    public final boolean g(@NotNull RecentContactInfo info, @NotNull List<? extends com.tencent.qqnt.chats.main.vm.datasource.filter.b> platformDateFilterList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) info, (Object) platformDateFilterList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(platformDateFilterList, "platformDateFilterList");
        Iterator<T> it = platformDateFilterList.iterator();
        while (it.hasNext()) {
            if (((com.tencent.qqnt.chats.main.vm.datasource.filter.b) it.next()).a(info)) {
                return false;
            }
        }
        return true;
    }
}
