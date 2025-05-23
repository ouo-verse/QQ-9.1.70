package com.tencent.mobileqq.guild;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/n;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lmqq/app/AppRuntime;", "appRuntime", "", "b", "c", "Landroid/content/Context;", "context", "a", "", "guildId", "", "d", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class n extends com.tencent.qqnt.chats.data.converter.g {
    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context) {
        boolean z16;
        item.v().k("");
        item.v().j(null);
        if (item.s().guildContactInfo != null) {
            String str = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                g.e v3 = item.v();
                String str2 = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
                Intrinsics.checkNotNullExpressionValue(str2, "item.originData.guildCon\u2026CntInfo.relatedToMeString");
                v3.k(str2);
                if (item.s().guildContactInfo.highAbstractColorType == 2) {
                    g.e v16 = item.v();
                    ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
                    BaseApplication context2 = BaseApplication.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
                    v16.j(Integer.valueOf(chatsColorCache.g(context2).getDefaultColor()));
                    return;
                }
                item.v().j(Integer.valueOf(context.getResources().getColor(R.color.qui_common_feedback_error)));
            }
        }
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, AppRuntime appRuntime) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        long j3;
        uh2.c gProGuildMsgService;
        boolean z16;
        g.e v3 = item.v();
        g.c cVar = new g.c(0L, null, 3, null);
        cVar.f(d(ex3.a.f(item.s())));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        uh2.c cVar2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        } else {
            iRuntimeService = null;
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        if (iGProSession != null && (gProGuildMsgService = iGProSession.getGProGuildMsgService()) != null) {
            boolean z17 = false;
            if (item.x().c() == 1 && item.x().b() >= 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!Boolean.valueOf(z16).booleanValue()) {
                gProGuildMsgService = null;
            }
            if (gProGuildMsgService != null) {
                if (item.s().guildContactInfo.grayAbstractType.mainType == 4) {
                    z17 = true;
                }
                if (Boolean.valueOf(z17).booleanValue()) {
                    cVar2 = gProGuildMsgService;
                }
                if (cVar2 != null) {
                    j3 = Long.valueOf(ex3.a.j(item.s())).longValue();
                    cVar.d(j3);
                    f fVar = f.f217908a;
                    RecentContactInfo s16 = item.s();
                    String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
                    Intrinsics.checkNotNullExpressionValue(selfTinyId, "appRuntime.getRuntimeSer\u2026             ).selfTinyId");
                    cVar.e(new QQText(fVar.a(s16, selfTinyId).getMsgContent(), 7, 15));
                    v3.i(cVar);
                }
            }
        }
        j3 = 0;
        cVar.d(j3);
        f fVar2 = f.f217908a;
        RecentContactInfo s162 = item.s();
        String selfTinyId2 = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        Intrinsics.checkNotNullExpressionValue(selfTinyId2, "appRuntime.getRuntimeSer\u2026             ).selfTinyId");
        cVar.e(new QQText(fVar2.a(s162, selfTinyId2).getMsgContent(), 7, 15));
        v3.i(cVar);
    }

    private final void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        uh2.c gProGuildMsgService;
        boolean z16;
        g.e v3 = item.v();
        g.c cVar = new g.c(0L, null, 3, null);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        } else {
            iRuntimeService = null;
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        int i3 = 0;
        if (iGProSession != null && (gProGuildMsgService = iGProSession.getGProGuildMsgService()) != null) {
            if (item.s().guildContactInfo.grayAbstractType.mainType == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!Boolean.valueOf(z16).booleanValue()) {
                gProGuildMsgService = null;
            }
            if (gProGuildMsgService != null) {
                i3 = Integer.valueOf(ex3.a.j(item.s())).intValue();
            }
        }
        cVar.d(i3);
        cVar.e(new QQText(f.b(f.f217908a, item.s(), null, 2, null).getMsgContent(), 3, 15));
        v3.i(cVar);
    }

    private final int d(String guildId) {
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime;
        GuildChatUtils guildChatUtils = GuildChatUtils.f213838a;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        IGProGuildInfo iGProGuildInfo = null;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProGuildInfo = iGPSService.getGuildInfo(guildId);
        }
        if (iGProGuildInfo == null) {
            return 4;
        }
        if (iGProGuildInfo.getUserType() == 2) {
            return 1;
        }
        if (iGProGuildInfo.getUserType() == 1) {
            return 2;
        }
        return 3;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull com.tencent.qqnt.chats.data.converter.f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof com.tencent.qqnt.chats.data.converter.i;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (GuildChatUtils.f213838a.a(item)) {
            try {
                c(item);
                a(item, params.b());
                return;
            } catch (Exception e16) {
                QLog.e("GuildSummaryConvertProcessor", 1, "update fromLocal e:" + e16);
                return;
            }
        }
        b(item, params.a());
        a(item, params.b());
    }
}
