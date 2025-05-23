package com.tencent.mobileqq.channel.node;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.channel.node.summary.RecentChannelSummaryAdapter;
import com.tencent.mobileqq.guild.GuildChatUtils;
import com.tencent.mobileqq.guild.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.ui.api.IQQTextApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.summary.highlight.core.b;
import com.tencent.qqnt.chats.biz.summary.msg.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.c;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.i;
import com.tencent.qqnt.kernelpublic.nativeinterface.ChannelStateElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u001a\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/channel/node/ChannelSummaryConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/g;", "", "msgSummary", "", "getMsgSummaryLog", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/ChannelStateElement;", "it", "getChannelHighlightInfo", "", "getChannelState", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "buildMsgSummary", "buildMsgSummaryLocal", "Lcom/tencent/qqnt/chats/biz/summary/msg/a;", "", "buildAudioSummary", "selfTinyId", "buildPrefix", "", "isGrayTipContent", "buildMsgContent", "buildSendMsgState", "buildDraftContent", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/b;", "buildSummaryHighLight", "buildSummaryState", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "matchPayload", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "<init>", "()V", "Companion", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChannelSummaryConvertProcessor extends g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ChannelSummaryConvertProcessor";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/channel/node/ChannelSummaryConvertProcessor$Companion;", "", "()V", "TAG", "", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChannelSummaryConvertProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void buildAudioSummary(Context context, com.tencent.qqnt.chats.core.adapter.itemdata.g item, a msgSummary) {
        String string;
        ChannelStateElement channelStateElement = ChannelNodeExtKt.getChannelStateElement(item);
        if (channelStateElement == null) {
            msgSummary.f354410d = context.getResources().getString(R.string.f146810v7);
            return;
        }
        int i3 = channelStateElement.memberCount;
        String str = channelStateElement.firstMemberDisplayName;
        if (str == null) {
            str = "";
        }
        if (i3 == 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = context.getResources().getString(R.string.f146820v8);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026ecent_audio_summary_wait)");
            string = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
        } else if (i3 > 1) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string3 = context.getResources().getString(R.string.f146800v6);
            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026ecent_audio_summary_chat)");
            string = String.format(string3, Arrays.copyOf(new Object[]{str, Integer.valueOf(i3)}, 2));
            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
        } else {
            string = context.getResources().getString(R.string.f146810v7);
        }
        msgSummary.f354410d = string;
    }

    private final CharSequence buildDraftContent(com.tencent.qqnt.chats.core.adapter.itemdata.g item, String selfTinyId) {
        return RecentChannelSummaryAdapter.INSTANCE.decode(item.s(), item.s().draft, selfTinyId);
    }

    private final CharSequence buildMsgContent(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context, String selfTinyId) {
        if (item.s().guildContactInfo.msgSeq <= 0) {
            return context.getString(R.string.zix) + item.s().guildContactInfo.channelName;
        }
        return RecentChannelSummaryAdapter.INSTANCE.decode(item.s(), item.s().abstractContent, selfTinyId);
    }

    private final CharSequence buildMsgSummary(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context, AppRuntime appRuntime) {
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        a aVar = new a();
        if (ChannelNodeExtKt.isAudioChannel(item)) {
            buildAudioSummary(context, item, aVar);
        } else {
            Intrinsics.checkNotNullExpressionValue(selfTinyId, "selfTinyId");
            aVar.f354407a = buildPrefix(item, selfTinyId);
            aVar.f354410d = buildMsgContent(item, context, selfTinyId);
            aVar.f354411e = "";
            aVar.f354408b = buildSendMsgState(item);
            aVar.f354412f = item.F();
            aVar.f354413g = buildDraftContent(item, selfTinyId);
        }
        CharSequence d16 = aVar.d(context);
        Intrinsics.checkNotNullExpressionValue(d16, "MsgSummary().apply {\n   \u2026      }.parseMsg(context)");
        return d16;
    }

    private final CharSequence buildMsgSummaryLocal(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context) {
        a aVar = new a();
        if (ChannelNodeExtKt.isAudioChannel(item)) {
            buildAudioSummary(context, item, aVar);
        } else {
            aVar.f354407a = buildPrefix(item, "");
            aVar.f354410d = buildMsgContent(item, context, "");
            aVar.f354411e = "";
            aVar.f354408b = buildSendMsgState(item);
            aVar.f354412f = item.F();
            aVar.f354413g = buildDraftContent(item, "");
        }
        CharSequence d16 = aVar.d(context);
        Intrinsics.checkNotNullExpressionValue(d16, "MsgSummary().apply {\n   \u2026      }.parseMsg(context)");
        return d16;
    }

    private final CharSequence buildPrefix(com.tencent.qqnt.chats.core.adapter.itemdata.g item, String selfTinyId) {
        boolean z16;
        if (Intrinsics.areEqual(item.s().senderUid.toString(), selfTinyId) || isGrayTipContent(item)) {
            return "";
        }
        String str = item.s().sendMemberName;
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str2 = item.s().sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            item.origi\u2026.sendMemberName\n        }");
            return str2;
        }
        String str3 = item.s().sendNickName;
        if (str3 == null || str3.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return "";
        }
        String str4 = item.s().sendNickName;
        Intrinsics.checkNotNullExpressionValue(str4, "{\n            item.origi\u2026ta.sendNickName\n        }");
        return str4;
    }

    private final int buildSendMsgState(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        int i3 = item.s().sendStatus;
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            return 0;
        }
        return 2;
    }

    private final b buildSummaryHighLight(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context) {
        boolean z16;
        if (item.s().guildContactInfo != null) {
            String str = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return new b();
            }
        }
        b bVar = new b();
        String str2 = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
        Intrinsics.checkNotNullExpressionValue(str2, "item.originData.guildCon\u2026CntInfo.relatedToMeString");
        bVar.e(str2);
        bVar.d(Integer.valueOf(context.getResources().getColor(R.color.qui_common_feedback_error)));
        return bVar;
    }

    private final int buildSummaryState(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        if (item.F()) {
            return 4;
        }
        return 0;
    }

    private final String getChannelHighlightInfo(ChannelStateElement it) {
        if (it == null) {
            return "";
        }
        return e.f217857a.b(it.guildId, it.channelId, it.channStateList, it.channelStateReq);
    }

    private final int getChannelState(ChannelStateElement it) {
        if (it == null) {
            return 0;
        }
        return e.f217857a.c(it.channStateList);
    }

    private final String getMsgSummaryLog(CharSequence msgSummary) {
        boolean z16;
        if (msgSummary.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "msgSummary:" + msgSummary.length() + "-" + msgSummary.charAt(0);
        }
        return "msgSummary:null";
    }

    private final boolean isGrayTipContent(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        boolean z16;
        ArrayList<MsgAbstractElement> arrayList = item.s().abstractContent;
        if (arrayList != null) {
            for (MsgAbstractElement msgAbstractElement : arrayList) {
                if (msgAbstractElement != null && msgAbstractElement.elementType == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) payload)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof i;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (GuildChatUtils.f213838a.a(item)) {
            try {
                CharSequence buildMsgSummaryLocal = buildMsgSummaryLocal(item, params.b());
                g.e v3 = item.v();
                CharSequence buildQQText = ((IQQTextApi) QRoute.api(IQQTextApi.class)).buildQQText(buildMsgSummaryLocal);
                Intrinsics.checkNotNullExpressionValue(buildQQText, "api(IQQTextApi::class.java).buildQQText(it)");
                v3.o(buildQQText);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "update from local exception = " + e16.getMessage());
            }
        } else {
            CharSequence buildMsgSummary = buildMsgSummary(item, params.b(), params.a());
            g.e v16 = item.v();
            CharSequence buildQQText2 = ((IQQTextApi) QRoute.api(IQQTextApi.class)).buildQQText(buildMsgSummary);
            Intrinsics.checkNotNullExpressionValue(buildQQText2, "api(IQQTextApi::class.java).buildQQText(it)");
            v16.o(buildQQText2);
        }
        b buildSummaryHighLight = buildSummaryHighLight(item, params.b());
        if (!ChannelNodeExtKt.isLiveChannel(item) && !ChannelNodeExtKt.isAudioChannel(item)) {
            item.v().k(buildSummaryHighLight.b());
            item.v().j(buildSummaryHighLight.a());
        } else {
            item.v().k(getChannelHighlightInfo(ChannelNodeExtKt.getChannelStateElement(item)));
        }
        if (!ChannelNodeExtKt.isLiveChannel(item) && !ChannelNodeExtKt.isAudioChannel(item)) {
            item.v().n(buildSummaryState(item));
        } else {
            item.v().n(getChannelState(ChannelNodeExtKt.getChannelStateElement(item)));
        }
        QLog.i(TAG, 1, "update channelId:" + ex3.a.b(item.s()) + " " + getMsgSummaryLog(item.v().f()) + " highLightInfo:" + item.v().e() + ", state:" + item.v().h());
    }
}
