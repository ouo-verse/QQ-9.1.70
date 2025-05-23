package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.api.IGuildTextForwardApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildTextForwardApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildTextForwardApi;", "", "guildId", "channelId", "content", "", SmsPlugin.API_SEND_SMS, "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildTextForwardApiImpl implements IGuildTextForwardApi {

    @NotNull
    private static final String TAG = "GuildTextForwardApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMsg$lambda$3(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Logger.f235387a.d().i(TAG, 1, "[sendMsg] result=" + i3 + " errMsg=" + errMsg);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r2 != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    @Override // com.tencent.mobileqq.guild.api.IGuildTextForwardApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sendMsg(@Nullable String guildId, @Nullable String channelId, @NotNull String content) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(content, "content");
        boolean z17 = false;
        if (guildId != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(guildId);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (channelId != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(channelId);
                    }
                    z17 = true;
                    if (!z17) {
                        if (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptKeyword(guildId, channelId, content)) {
                            Logger.f235387a.d().w(TAG, 1, "[sendMsg] Fail. isNeedInterceptKeyword = true");
                            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptKeywordSendToast();
                            return;
                        } else {
                            ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(new Contact(4, channelId, guildId), com.tencent.guild.api.msg.service.l.f112634a.a(com.tencent.guild.aio.util.e.g(com.tencent.guild.aio.util.e.f112380a, content, 0, 0L, 0L, null, 30, null)), new IOperateCallback() { // from class: com.tencent.mobileqq.guild.api.impl.w
                                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                                public final void onResult(int i3, String str) {
                                    GuildTextForwardApiImpl.sendMsg$lambda$3(i3, str);
                                }
                            });
                            return;
                        }
                    }
                }
                Logger.f235387a.d().w(TAG, 1, "[sendMsg] error params " + guildId + " " + channelId);
            }
        }
        z16 = true;
        if (!z16) {
        }
        Logger.f235387a.d().w(TAG, 1, "[sendMsg] error params " + guildId + " " + channelId);
    }
}
