package com.tencent.mobileqq.guild;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.message.api.IGuildPullSummaryApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import st1.f;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i implements s {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<com.tencent.qqnt.chats.biz.main.part.c> f226096a;

    /* renamed from: b, reason: collision with root package name */
    AtomicBoolean f226097b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final Handler f226098c = new a(ThreadManagerV2.getUIHandlerV2().getLooper());

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 10) {
                if (!i.this.f226097b.get()) {
                    return;
                }
                if (!hasMessages(10)) {
                    sendEmptyMessageDelayed(10, 5000L);
                }
                i.this.e();
                return;
            }
            super.handleMessage(message);
        }
    }

    public i(com.tencent.qqnt.chats.biz.main.part.c cVar) {
        this.f226096a = null;
        this.f226096a = new WeakReference<>(cVar);
    }

    private ArrayList<f.PullParam> b() {
        WeakReference<com.tencent.qqnt.chats.biz.main.part.c> weakReference;
        ArrayList<f.PullParam> arrayList = new ArrayList<>();
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && (weakReference = this.f226096a) != null) {
            com.tencent.qqnt.chats.biz.main.part.c cVar = weakReference.get();
            if (cVar == null) {
                QLog.e("GuildPullSummary_Conversation", 1, "getRecentUserPullInfos chatsListPart is null");
                return arrayList;
            }
            List<com.tencent.qqnt.chats.core.adapter.itemdata.g> aa5 = cVar.aa(5);
            if (aa5.isEmpty()) {
                return arrayList;
            }
            for (com.tencent.qqnt.chats.core.adapter.itemdata.g gVar : aa5) {
                if (gVar.n() == 4) {
                    arrayList.add(new f.PullParam(ex3.a.f(gVar.s()), ex3.a.b(gVar.s())));
                }
            }
            return arrayList;
        }
        QLog.e("GuildPullSummary_Conversation", 1, "getRecentUserPullInfos appRuntime or chatsListPartWeak is null");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ArrayList arrayList) {
        ((IGuildPullSummaryApi) QRoute.api(IGuildPullSummaryApi.class)).getGuildPullSummaryAdapter().a(arrayList, true);
    }

    private boolean d() {
        IGuildUserService iGuildUserService = (IGuildUserService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGuildUserService.class, "");
        if (iGuildUserService.isGuildUserCached() && iGuildUserService.guildMode() != GuildMsgAbFlag.KSIMPLEMODEL) {
            return false;
        }
        return true;
    }

    void e() {
        if (d()) {
            return;
        }
        final ArrayList<f.PullParam> b16 = b();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.h
            @Override // java.lang.Runnable
            public final void run() {
                i.c(b16);
            }
        }, 128, null, false);
    }
}
