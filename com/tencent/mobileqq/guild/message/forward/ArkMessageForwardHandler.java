package com.tencent.mobileqq.guild.message.forward;

import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildProtocolsReportApi;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.message.forward.ArkMessageForwardHandler;
import com.tencent.mobileqq.guild.message.serversendarkmsg.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eu1.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa$ArkJsonMessage;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa$ArkMessage;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa$GuildInfo;
import tencent.im.group_pro_proto.oidb0xffa.oidb0xffa$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J$\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J<\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001d\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0014J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/message/forward/ArkMessageForwardHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Leu1/a;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "data", "", "F2", "", "isSuccess", Constants.MMCCID, "", ark.ARKMETADATA_JSON, "Ltencent/im/group_pro_proto/oidb0xffa/oidb0xffa$ArkMessage;", "E2", "Leu1/a$a;", "target", "", "shareType", "arkMessage", "leaveMessage", "Leu1/a$b;", "source", "Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;", "attaIdReportData", "o1", "onReceive", "Ljava/lang/Class;", "Ldu1/b;", "observerClass", "", "getCommandList", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ArkMessageForwardHandler extends BusinessHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Set<String> f230574e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0004*\u00020\u0003H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/message/forward/ArkMessageForwardHandler$a;", "", "", "Leu1/a$b;", "Ltencent/im/group_pro_proto/oidb0xffa/oidb0xffa$GuildInfo;", "d", "c", "", "COMMENT_SHARE_COMMAND", "Ljava/lang/String;", "TAG", "", "commandLists", "Ljava/util/Set;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.message.forward.ArkMessageForwardHandler$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final oidb0xffa$GuildInfo c(a.b bVar) {
            oidb0xffa$GuildInfo oidb0xffa_guildinfo = new oidb0xffa$GuildInfo();
            PBUInt64Field pBUInt64Field = oidb0xffa_guildinfo.guild_id;
            String guildId = bVar.f397136a;
            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
            pBUInt64Field.set(MiscKt.l(guildId));
            PBUInt64Field pBUInt64Field2 = oidb0xffa_guildinfo.channel_id;
            String channelId = bVar.f397137b;
            Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
            pBUInt64Field2.set(MiscKt.l(channelId));
            return oidb0xffa_guildinfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<oidb0xffa$GuildInfo> d(List<? extends a.b> list) {
            int collectionSizeOrDefault;
            List<? extends a.b> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(ArkMessageForwardHandler.INSTANCE.c((a.b) it.next()));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    static {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf("OidbSvcTrpcTcp.0xffa_3");
        f230574e = mutableSetOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArkMessageForwardHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    private final oidb0xffa$ArkMessage E2(String json) {
        oidb0xffa$ArkMessage oidb0xffa_arkmessage = new oidb0xffa$ArkMessage();
        oidb0xffa$ArkJsonMessage oidb0xffa_arkjsonmessage = oidb0xffa_arkmessage.ark_json_message;
        oidb0xffa$ArkJsonMessage oidb0xffa_arkjsonmessage2 = new oidb0xffa$ArkJsonMessage();
        oidb0xffa_arkjsonmessage2.ark_json.set(json);
        oidb0xffa_arkmessage.ark_message_type.set(2);
        oidb0xffa_arkjsonmessage.set(oidb0xffa_arkjsonmessage2);
        return oidb0xffa_arkmessage;
    }

    private final void F2(ToServiceMsg request, FromServiceMsg response, Object data) {
        boolean z16;
        b.a();
        if (response.getResultCode() == 1000 && data != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) data);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "{\n                pkg.me\u2026 ByteArray)\n            }");
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = mergeFrom;
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                String str = oidb_sso_oidbssopkg.str_error_msg.get();
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                G2(z16);
                if (z16) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.share.ArkMessageForwardHandler.0xffa", 2, "handleSendGuildCommentArkMsgRes resCode: " + i3 + " resMsg: " + str);
                    }
                } else {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str2 = "handleSendGuildCommentArkMsgRes resCode: " + i3 + " resMsg: " + str;
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.share.ArkMessageForwardHandler.0xffa", 1, (String) it.next(), null);
                    }
                }
                ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).endGuildMsgProtocolReport(8, request, response, Integer.valueOf(i3), str);
            } catch (Exception e16) {
                Logger logger3 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str3 = "handleSendGuildCommentArkMsgRes oidb_sso parseFrom byte " + e16;
                if (str3 instanceof String) {
                    bVar2.a().add(str3);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.share.ArkMessageForwardHandler.0xffa", 1, (String) it5.next(), null);
                }
                e16.printStackTrace();
            }
        }
    }

    private final void G2(final boolean isSuccess) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: du1.a
            @Override // java.lang.Runnable
            public final void run() {
                ArkMessageForwardHandler.H2(ArkMessageForwardHandler.this, isSuccess);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(ArkMessageForwardHandler this$0, boolean z16) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context applicationContext = this$0.appRuntime.getApplicationContext();
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (z16) {
            i16 = R.string.f156691kw;
        } else {
            i16 = R.string.f156681kv;
        }
        QQToast.makeText(applicationContext, i3, i16, 0).show();
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        return f230574e;
    }

    @Override // eu1.a
    public void o1(@NotNull a.C10265a target, int shareType, @NotNull String arkMessage, @NotNull String leaveMessage, @Nullable a.b source, @Nullable AttaIdReportData attaIdReportData) {
        byte[] bArr;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(arkMessage, "arkMessage");
        Intrinsics.checkNotNullParameter(leaveMessage, "leaveMessage");
        if (target.f397134b.isEmpty() && target.f397135c.isEmpty() && target.f397133a.isEmpty()) {
            throw new IllegalArgumentException("there is no target to forward");
        }
        if (attaIdReportData != null) {
            attaIdReportData.g("");
        }
        if (attaIdReportData != null) {
            attaIdReportData.j("");
        }
        if (attaIdReportData != null) {
            attaIdReportData.k(new ArrayList<>());
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.share.ArkMessageForwardHandler.0xffa", 2, "forwardArkMessage: target = " + target + ", source = " + source + ", ark = " + arkMessage);
        }
        logger.d().d("Guild.share.ArkMessageForwardHandler.0xffa", 1, "[forwardArkMessage] try to report atta data " + attaIdReportData);
        boolean z16 = false;
        if (attaIdReportData == null || (bArr = IGProDataApi.INSTANCE.a().encodeShareAttaData(attaIdReportData.c())) == null) {
            bArr = new byte[]{0};
        }
        oidb0xffa$ReqBody oidb0xffa_reqbody = new oidb0xffa$ReqBody();
        PBRepeatMessageField<oidb0xffa$GuildInfo> pBRepeatMessageField = oidb0xffa_reqbody.guild_info;
        Companion companion = INSTANCE;
        List<a.b> list = target.f397133a;
        Intrinsics.checkNotNullExpressionValue(list, "target.channelList");
        pBRepeatMessageField.addAll(companion.d(list));
        PBRepeatField<Long> pBRepeatField = oidb0xffa_reqbody.uins;
        List<String> list2 = target.f397134b;
        Intrinsics.checkNotNullExpressionValue(list2, "target.friendUinList");
        List<String> list3 = list2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(MiscKt.l((String) it.next())));
        }
        pBRepeatField.addAll(arrayList);
        PBRepeatField<Long> pBRepeatField2 = oidb0xffa_reqbody.group_codes;
        List<String> list4 = target.f397135c;
        Intrinsics.checkNotNullExpressionValue(list4, "target.groupUinList");
        List<String> list5 = list4;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list5.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Long.valueOf(MiscKt.l((String) it5.next())));
        }
        pBRepeatField2.addAll(arrayList2);
        oidb0xffa_reqbody.ark_message.set(E2(arkMessage));
        oidb0xffa_reqbody.leave_message.set(leaveMessage);
        oidb0xffa_reqbody.share_type.set(shareType);
        if (source != null) {
            oidb0xffa_reqbody.from_guild_infos.set(INSTANCE.c(source));
        }
        if (bArr.length == 0) {
            z16 = true;
        }
        if (!z16) {
            oidb0xffa_reqbody.share_atta_data.set(ByteStringMicro.copyFrom(bArr));
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(FriendListHandler.OIDB_0X5D1_CONST_IS_BLACK);
        oidb_sso_oidbssopkg.uint32_service_type.set(3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb0xffa_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTrpcTcp.0xffa_3");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        ((IGuildProtocolsReportApi) QRoute.api(IGuildProtocolsReportApi.class)).startGuildMsgProtocolReport(createToServiceMsg);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<du1.b> observerClass() {
        return du1.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg request, @Nullable FromServiceMsg response, @Nullable Object data) {
        if (request != null && response != null) {
            String serviceCmd = response.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.share.ArkMessageForwardHandler.0xffa", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual("OidbSvcTrpcTcp.0xffa_3", serviceCmd)) {
                F2(request, response, data);
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.share.ArkMessageForwardHandler.0xffa", 2, "onReceive,res == null or req == null");
        }
    }
}
