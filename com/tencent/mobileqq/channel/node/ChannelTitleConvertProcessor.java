package com.tencent.mobileqq.channel.node;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.c;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.k;
import com.tencent.qqnt.kernelpublic.nativeinterface.ChannelStateElement;
import ex3.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/channel/node/ChannelTitleConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/g;", "", "channelType", "channelSubType", "getChannelIconResId", "getTextChannelTypeIcon", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "channelName", "getLiveChannelTitle", "getAudioChannelTitleRightExtend", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "Lcom/tencent/mobileqq/guild/api/IGuildInfoUtilsApi;", "guildUtilsApi$delegate", "Lkotlin/Lazy;", "getGuildUtilsApi", "()Lcom/tencent/mobileqq/guild/api/IGuildInfoUtilsApi;", "guildUtilsApi", "<init>", "()V", "Companion", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChannelTitleConvertProcessor extends g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ChannelTitleConvertProcessor";

    /* renamed from: guildUtilsApi$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildUtilsApi;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/channel/node/ChannelTitleConvertProcessor$Companion;", "", "()V", "TAG", "", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChannelTitleConvertProcessor() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildInfoUtilsApi>() { // from class: com.tencent.mobileqq.channel.node.ChannelTitleConvertProcessor$guildUtilsApi$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final IGuildInfoUtilsApi invoke() {
                    return (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
                }
            });
            this.guildUtilsApi = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String getAudioChannelTitleRightExtend(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        ChannelStateElement channelStateElement;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16 = false;
        if (!item.q().getBoolean("is_local_cache_data", false) && (channelStateElement = ChannelNodeExtKt.getChannelStateElement(item)) != null && channelStateElement.memberMax != 0 && channelStateElement.memberCount != 0) {
            try {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                IGProChannelInfo iGProChannelInfo = null;
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface != null) {
                    iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                } else {
                    iRuntimeService = null;
                }
                IGPSService iGPSService = (IGPSService) iRuntimeService;
                if (iGPSService != null) {
                    iGProChannelInfo = iGPSService.getChannelInfo(a.b(item.s()));
                }
                if (iGProChannelInfo != null && iGProChannelInfo.getNoMemberMaxLimited() == 0) {
                    z16 = true;
                }
                if (z16) {
                    int i3 = channelStateElement.memberCount;
                    int i16 = channelStateElement.memberMax;
                    if (i16 > 0 && i3 > 0) {
                        return "(" + getGuildUtilsApi().getOnlineUIDataToShow(i3, i16) + ")";
                    }
                }
            } catch (Exception e16) {
                QLog.i(TAG, 1, "[getAudioChannelTitleRightExtend] e:" + e16);
            }
        }
        return "";
    }

    private final int getChannelIconResId(int channelType, int channelSubType) {
        if (channelType != 1) {
            if (channelType != 2) {
                if (channelType != 5) {
                    if (channelType != 7) {
                        return R.drawable.qui_recent_channel_text_icon_selector;
                    }
                    return R.drawable.qui_recent_channel_feed_icon_selector;
                }
                return R.drawable.qui_recent_channel_live_icon_selector;
            }
            return R.drawable.qui_recent_channel_voice_icon_selector;
        }
        return getTextChannelTypeIcon(channelSubType);
    }

    private final IGuildInfoUtilsApi getGuildUtilsApi() {
        return (IGuildInfoUtilsApi) this.guildUtilsApi.getValue();
    }

    private final String getLiveChannelTitle(com.tencent.qqnt.chats.core.adapter.itemdata.g item, String channelName) {
        ChannelStateElement channelStateElement = ChannelNodeExtKt.getChannelStateElement(item);
        if (channelStateElement != null) {
            String str = channelStateElement.roomTitle;
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNullExpressionValue(str, "{\n                liveRoomName\n            }");
                return str;
            }
            return channelName;
        }
        return channelName;
    }

    private final int getTextChannelTypeIcon(int channelSubType) {
        if (channelSubType == 1) {
            return R.drawable.qui_recent_channel_text_notice_icon_selector;
        }
        return R.drawable.qui_recent_channel_text_icon_selector;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) payload)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof k;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        int e16 = a.e(item.s());
        int d16 = a.d(item.s());
        String c16 = a.c(item.s());
        g.f w3 = item.w();
        if (e16 == 5) {
            str = getLiveChannelTitle(item, c16);
        } else {
            str = c16;
        }
        w3.i(str);
        item.w().g(Integer.valueOf(getChannelIconResId(e16, d16)));
        g.f w16 = item.w();
        if (e16 == 2) {
            str2 = getAudioChannelTitleRightExtend(item);
        } else {
            str2 = "";
        }
        w16.f(str2);
        QLog.i(TAG, 1, "[update] channelId: " + a.b(item.s()) + " channelType: " + e16 + " channelName: " + c16 + " extraInfo:" + item.w().b());
    }
}
