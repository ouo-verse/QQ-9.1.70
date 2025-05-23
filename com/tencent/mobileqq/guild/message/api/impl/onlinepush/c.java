package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildLocalFocusService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.impl.onlinepush.e;
import com.tencent.mobileqq.guild.message.s;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import f12.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.common.common$ContentHead;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.common.common$RoutingHead;
import tencent.im.group_pro_proto.msgpush.msgpush$MsgOnlinePush;
import tencent.im.group_pro_proto.msgpush.msgpush$PressMsg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    GuildMessagePushHandler f230228a;

    /* renamed from: b, reason: collision with root package name */
    private bc f230229b;

    /* renamed from: c, reason: collision with root package name */
    private st1.d f230230c;

    /* renamed from: d, reason: collision with root package name */
    private IGuildFocusChannelService f230231d;

    /* renamed from: e, reason: collision with root package name */
    private IGPSService f230232e;

    /* renamed from: f, reason: collision with root package name */
    private IGuildUnreadCntService f230233f;

    /* renamed from: g, reason: collision with root package name */
    private IGuildLocalFocusService f230234g;

    /* renamed from: h, reason: collision with root package name */
    private f f230235h = new f(5000);

    public c(GuildMessagePushHandler guildMessagePushHandler) {
        this.f230228a = guildMessagePushHandler;
    }

    private void d(common$Msg common_msg, HashSet<String> hashSet, HashSet<String> hashSet2) {
        if (common_msg.head.has() && common_msg.head.routing_head.has() && common_msg.head.content_head.has() && common_msg.head.content_head.msg_type.get() == 3840) {
            hashSet.add(String.valueOf(common_msg.head.routing_head.guild_id.get()));
            hashSet2.add(String.valueOf(common_msg.head.routing_head.channel_id.get()));
        }
    }

    private void e(@NonNull msgpush$MsgOnlinePush msgpush_msgonlinepush, List<common$Msg> list) {
        boolean z16;
        if (msgpush_msgonlinepush.huge_flag.has() && msgpush_msgonlinepush.huge_flag.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.f230235h.a("decodeFocusChanelList")) {
            QLog.i("GuildMsgPushProducer", 1, "decodeFocusChanelList, isHuge = true");
        }
        v(list, h(), z16);
        if (!z16) {
            return;
        }
        u(msgpush_msgonlinepush, h());
    }

    private List<common$Msg> f(@NonNull msgpush$MsgOnlinePush msgpush_msgonlinepush) {
        if (msgpush_msgonlinepush.compress_flag.get() == 1) {
            if (!msgpush_msgonlinepush.compress_msg.has()) {
                return null;
            }
            byte[] lz4DecompressBuf = g().lz4DecompressBuf(msgpush_msgonlinepush.compress_msg.get().toByteArray());
            msgpush$PressMsg msgpush_pressmsg = new msgpush$PressMsg();
            try {
                msgpush_pressmsg.mergeFrom(lz4DecompressBuf);
                return msgpush_pressmsg.msgs.get();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("GuildMsgPushProducer", 2, "decodeMsgList e: " + e16);
                return null;
            } catch (NullPointerException e17) {
                QLog.d("GuildMsgPushProducer", 2, "decodeMsgList e: " + e17);
                return null;
            }
        }
        return msgpush_msgonlinepush.msgs.get();
    }

    private IGPSService g() {
        if (this.f230232e == null) {
            this.f230232e = (IGPSService) this.f230228a.f230205d.getRuntimeService(IGPSService.class, "");
        }
        return this.f230232e;
    }

    private IGuildFocusChannelService h() {
        if (this.f230231d == null) {
            this.f230231d = (IGuildFocusChannelService) this.f230228a.f230205d.getRuntimeService(IGuildFocusChannelService.class, "");
        }
        return this.f230231d;
    }

    private st1.d i() {
        if (this.f230230c == null) {
            this.f230230c = ((IGuildMsgFactory) this.f230228a.f230205d.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache();
        }
        return this.f230230c;
    }

    private IGuildUnreadCntService j() {
        if (this.f230233f == null) {
            this.f230233f = (IGuildUnreadCntService) this.f230228a.f230205d.getRuntimeService(IGuildUnreadCntService.class, "");
        }
        return this.f230233f;
    }

    private long k(@NonNull common$Msg common_msg) {
        List<im_msg_body$Elem> list;
        if (common_msg.head.content_head.msg_type.get() != 3841 && common_msg.body.has() && common_msg.body.rich_text.has() && (list = common_msg.body.rich_text.elems.get()) != null && list.size() >= 0) {
            String selfTinyId = g().getSelfTinyId();
            for (im_msg_body$Elem im_msg_body_elem : list) {
                if (((IGuildMessageTempUtilsApi) QRoute.api(IGuildMessageTempUtilsApi.class)).isMyAtMsg(im_msg_body_elem, selfTinyId)) {
                    return 1L;
                }
                if (((IGuildMessageTempUtilsApi) QRoute.api(IGuildMessageTempUtilsApi.class)).isWalletMsg(im_msg_body_elem)) {
                    return 2L;
                }
                if (((IGuildMessageTempUtilsApi) QRoute.api(IGuildMessageTempUtilsApi.class)).isMyGuildGiftMsg(this.f230228a.f230205d, im_msg_body_elem)) {
                    return 3L;
                }
            }
        }
        return 0L;
    }

    private IGuildLocalFocusService l() {
        if (this.f230234g == null) {
            this.f230234g = (IGuildLocalFocusService) this.f230228a.f230205d.getRuntimeService(IGuildLocalFocusService.class, "");
        }
        return this.f230234g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(FromServiceMsg fromServiceMsg, Object obj) {
        msgpush$MsgOnlinePush msgpush_msgonlinepush = new msgpush$MsgOnlinePush();
        try {
            msgpush_msgonlinepush.mergeFrom((byte[]) obj);
            if (!msgpush_msgonlinepush.msgs.has() && !msgpush_msgonlinepush.compress_msg.has()) {
                if (QLog.isColorLevel() && this.f230235h.a("handleOnlinePushInner")) {
                    QLog.d("GuildMsgPushProducer", 2, "handleOnlinePushInner: pushMsg is null or doesn't has msg.");
                    return;
                }
                return;
            }
            this.f230228a.H2(true);
            t(fromServiceMsg, msgpush_msgonlinepush);
            n(obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GuildMsgPushProducer", 2, "handleOnlinePushInner: exception occurs while parsing the pb bytes.", e16);
            }
        }
    }

    private void n(Object obj) {
        if (obj instanceof byte[]) {
            m.f397667a.e(((byte[]) obj).length);
        }
    }

    private boolean o(long j3, long j16, e.h hVar) {
        if (hVar.f230305a == 3841 || hVar.f230306b != 0) {
            return true;
        }
        int selTab = l().getSelTab();
        if (selTab == 1) {
            if (l().getActiveGuildId() == j3 && l().getAppOnForeground()) {
                return true;
            }
            return false;
        }
        if (selTab == 2 && this.f230228a.K2().h(j16, j3) && l().getAppOnForeground()) {
            return true;
        }
        return false;
    }

    private boolean p(long j3, long j16) {
        if (this.f230228a.K2().h(j16, j3)) {
            return false;
        }
        IGuildUnreadCntService.b bVar = new IGuildUnreadCntService.b();
        if (bVar.f230841e == 1 && bVar.f230840d > 99) {
            return true;
        }
        IGProChannelInfo channelInfo = g().getChannelInfo(String.valueOf(j16));
        if (channelInfo == null || ((channelInfo.getFinalMsgNotify() != 2 && channelInfo.getFinalMsgNotify() != 3) || j().getChannelUnreadCnt(String.valueOf(j16), 1).f230840d <= 0)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(FromServiceMsg fromServiceMsg, Object obj) {
        if (!s.J()) {
            if (QLog.isColorLevel() && this.f230235h.a("noNeedProcessPushNow1")) {
                QLog.d("GuildMsgPushProducer", 2, "noNeedProcessPushNow : isNeedToProcessMsg = false");
                return true;
            }
            return true;
        }
        return false;
    }

    private void t(FromServiceMsg fromServiceMsg, msgpush$MsgOnlinePush msgpush_msgonlinepush) {
        String uin;
        if (this.f230228a.I2()) {
            return;
        }
        if (!msgpush_msgonlinepush.msgs.has() && !msgpush_msgonlinepush.compress_msg.has()) {
            return;
        }
        if (fromServiceMsg.getUin() == null) {
            uin = this.f230228a.f230205d.getCurrentAccountUin();
        } else {
            uin = fromServiceMsg.getUin();
        }
        if (!TextUtils.isEmpty(uin) && uin.equals(this.f230228a.f230205d.getCurrentAccountUin())) {
            this.f230228a.K2().s().o(1);
            List<common$Msg> f16 = f(msgpush_msgonlinepush);
            e(msgpush_msgonlinepush, f16);
            List<byte[]> w3 = w(f16);
            if (w3.size() > 0) {
                if (!s.K(this.f230228a.f230205d)) {
                    i().b(w3);
                    if (this.f230235h.a("processPush2")) {
                        QLog.i("GuildMsgPushProducer", 1, "processPush : isSyncNormalMsgFinish = false");
                        return;
                    }
                    return;
                }
                this.f230228a.L2(w3);
                return;
            }
            return;
        }
        if (this.f230235h.a("processPush1")) {
            QLog.i("GuildMsgPushProducer", 1, "processPush, not current account, selfUin = " + uin + ", curUin = " + this.f230228a.f230205d.getCurrentAccountUin());
        }
    }

    private void u(@NonNull msgpush$MsgOnlinePush msgpush_msgonlinepush, IGuildFocusChannelService iGuildFocusChannelService) {
        int i3;
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        if (!msgpush_msgonlinepush.focus_info.has()) {
            iGuildFocusChannelService.updateFocusChannel(new com.tencent.mobileqq.guild.message.f());
            return;
        }
        if (msgpush_msgonlinepush.focus_info.uint64_channel_id_list.has() && msgpush_msgonlinepush.focus_info.uint64_channel_id_list.size() > 0) {
            Iterator<Long> it = msgpush_msgonlinepush.focus_info.uint64_channel_id_list.get().iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                if (longValue != 0) {
                    hashSet.add(String.valueOf(longValue));
                }
            }
        }
        if (msgpush_msgonlinepush.focus_info.uint64_guild_id.has() && msgpush_msgonlinepush.focus_info.uint64_guild_id.size() > 0) {
            Iterator<Long> it5 = msgpush_msgonlinepush.focus_info.uint64_guild_id.get().iterator();
            while (it5.hasNext()) {
                long longValue2 = it5.next().longValue();
                if (longValue2 != 0) {
                    hashSet2.add(String.valueOf(longValue2));
                }
            }
        }
        int i16 = 0;
        if (msgpush_msgonlinepush.focus_info.is_msg_tab_focus.has()) {
            i3 = msgpush_msgonlinepush.focus_info.is_msg_tab_focus.get();
        } else {
            i3 = 0;
        }
        if (msgpush_msgonlinepush.focus_info.active_status.has()) {
            i16 = msgpush_msgonlinepush.focus_info.active_status.get();
        }
        iGuildFocusChannelService.updateFocusChannel(new com.tencent.mobileqq.guild.message.f().c(hashSet2).b(hashSet).i(i3).a(i16));
    }

    private void v(List<common$Msg> list, IGuildFocusChannelService iGuildFocusChannelService, boolean z16) {
        if (list != null) {
            HashSet<String> hashSet = new HashSet<>();
            HashSet<String> hashSet2 = new HashSet<>();
            for (common$Msg common_msg : list) {
                if (common_msg.msg_core.has()) {
                    hashSet.add(String.valueOf(common_msg.msg_core.guild_id.get()));
                    hashSet2.add(String.valueOf(common_msg.msg_core.channel_id.get()));
                } else {
                    d(common_msg, hashSet, hashSet2);
                }
            }
            if (z16) {
                iGuildFocusChannelService.addHugeGuild(hashSet);
                iGuildFocusChannelService.addHugeChannel(hashSet2);
            } else {
                iGuildFocusChannelService.removeHugeGuild(hashSet);
                iGuildFocusChannelService.removeHugeChannel(hashSet2);
            }
        }
    }

    public void r() {
        bc bcVar = this.f230229b;
        if (bcVar != null) {
            bcVar.removeAll();
            this.f230229b = null;
        }
    }

    public void s() {
        List<Object> g16 = i().g();
        if (g16.size() > 0) {
            QLog.i("GuildMsgPushProducer", 1, "onlinePushAfterSyncMsg cacheMsgs.size():" + g16.size());
            Iterator<Object> it = g16.iterator();
            while (it.hasNext()) {
                this.f230228a.L2((List) it.next());
            }
        }
    }

    protected List<byte[]> w(List<common$Msg> list) {
        boolean z16;
        HashSet hashSet;
        HashSet hashSet2;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            HashSet hashSet5 = new HashSet();
            long uptimeMillis = SystemClock.uptimeMillis();
            Iterator<common$Msg> it = list.iterator();
            while (it.hasNext()) {
                common$Msg next = it.next();
                if (next.msg_core.has()) {
                    arrayList.add(next.toByteArray());
                } else if (next.head.has() && next.head.content_head.has()) {
                    common$ContentHead common_contenthead = next.head.content_head.get();
                    common$RoutingHead common_routinghead = next.head.routing_head.get();
                    if (common_routinghead.direct_message_flag.get() == 1) {
                        arrayList.add(next.toByteArray());
                    } else if (common_contenthead.msg_type.get() == 3842) {
                        arrayList.add(next.toByteArray());
                    } else {
                        long j3 = common_routinghead.guild_id.get();
                        long j16 = common_routinghead.channel_id.get();
                        e.g gVar = new e.g(j3, j16);
                        Iterator<common$Msg> it5 = it;
                        e.h hVar = new e.h();
                        ArrayList arrayList2 = arrayList;
                        HashSet hashSet6 = hashSet4;
                        HashSet hashSet7 = hashSet5;
                        hVar.f230305a = common_contenthead.msg_type.get();
                        hVar.f230306b = k(next);
                        hVar.f230307c = common_contenthead.msg_seq.get();
                        if (next.ext_info.offline_flag.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        hVar.f230308d = z16;
                        hVar.f230309e = uptimeMillis;
                        hVar.f230310f = next.toByteArray();
                        if (hashMap.containsKey(Long.valueOf(j16))) {
                            ((e.i) hashMap.get(Long.valueOf(j16))).f230311a.add(hVar);
                        } else {
                            e.i iVar = new e.i();
                            iVar.f230311a.add(hVar);
                            hashMap.put(Long.valueOf(j16), iVar);
                        }
                        long j17 = uptimeMillis;
                        if (o(j3, j16, hVar)) {
                            hashSet3.add(gVar);
                            hashSet = hashSet6;
                        } else if (!p(j3, j16)) {
                            hashSet = hashSet6;
                            hashSet.add(gVar);
                        } else {
                            hashSet = hashSet6;
                            hashSet2 = hashSet7;
                            hashSet2.add(gVar);
                            hashSet4 = hashSet;
                            hashSet5 = hashSet2;
                            it = it5;
                            arrayList = arrayList2;
                            uptimeMillis = j17;
                        }
                        hashSet2 = hashSet7;
                        hashSet4 = hashSet;
                        hashSet5 = hashSet2;
                        it = it5;
                        arrayList = arrayList2;
                        uptimeMillis = j17;
                    }
                }
            }
            ArrayList arrayList3 = arrayList;
            this.f230228a.K2().V(hashMap, hashSet3, hashSet4, hashSet5);
            this.f230228a.K2().s().q(this.f230228a.J2().a());
            return arrayList3;
        }
        return arrayList;
    }
}
