package com.tencent.mobileqq.werewolves;

import KQQ.ProfSmpInfoRes;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tencent.view.FilterEnum;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.oidb.cmd0x857.TroopTips0x857$WereWolfPush;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd$MsgBody;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WerewolvesHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    protected static HashMap<String, WeakReference<TextView>> f315328m;

    /* renamed from: d, reason: collision with root package name */
    protected LruCache<String, String> f315329d;

    /* renamed from: e, reason: collision with root package name */
    protected b f315330e;

    /* renamed from: f, reason: collision with root package name */
    public String f315331f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f315332h;

    /* renamed from: i, reason: collision with root package name */
    protected BroadcastReceiver f315333i;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WerewolvesHandler.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            long longExtra = intent.getLongExtra("groupId", 0L);
            long[] longArrayExtra = intent.getLongArrayExtra(SquareJSConst.Params.PARAMS_UIN_LIST);
            boolean booleanExtra = intent.getBooleanExtra("isSpeaking", false);
            if (longArrayExtra != null) {
                for (long j3 : longArrayExtra) {
                    WerewolvesHandler.this.notifyUI(2, true, new Object[]{Long.valueOf(longExtra), Long.valueOf(j3), Boolean.valueOf(booleanExtra)});
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    protected static class b extends Handler {
        static IPatchRedirector $redirector_;

        public b() {
            super(Looper.getMainLooper());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String[] strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            String[] strArr2 = (String[]) message.obj;
            String str = strArr2[0];
            String str2 = strArr2[1];
            WeakReference<TextView> remove = WerewolvesHandler.f315328m.remove(str);
            if (remove != null && remove.get() != null) {
                if (remove.get().getTag() instanceof String[]) {
                    strArr = (String[]) remove.get().getTag();
                } else {
                    strArr = null;
                }
                if (strArr != null && strArr.length == 2 && strArr[0].equals(str)) {
                    try {
                        remove.get().setText(String.format(strArr[1], str2));
                    } catch (Exception unused) {
                        remove.get().setText(str2);
                    }
                }
                remove.get().setText(str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77400);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            f315328m = new HashMap<>();
        }
    }

    public WerewolvesHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f315329d = new LruCache<>(100);
        this.f315330e = new b();
        this.f315331f = null;
        this.f315333i = new a();
        this.f315332h = qQAppInterface;
        this.f315331f = qQAppInterface.getApp().getSharedPreferences("werewolves_sp", 0).getString("judgeUin", "");
        qQAppInterface.getApplication().registerReceiver(this.f315333i, new IntentFilter("tencent.video.v2q.memberSpeaking"));
    }

    public void D2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) bArr);
            return;
        }
        MessageMicro<submsgtype0xdd$MsgBody> messageMicro = new MessageMicro<submsgtype0xdd$MsgBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd$MsgBody
            public static final int MSG_TYPE_ENTER_ROOM = 2;
            public static final int MSG_TYPE_FRESH = 1;
            public static final int MSG_TYPE_KICK = 3;
            public static final int MSG_TYPE_UNREADY = 4;
            public static final int STATE_READY = 1;
            public static final int STATE_UNREADY = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint32_msg_type", "rpt_uint64_invite_uin", "uint64_invite_leader", "msg_poi_info", "rpt_msg_player_state"}, new Object[]{0, 0L, 0L, null, null}, submsgtype0xdd$MsgBody.class);
            public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
            public final PBRepeatField<Long> rpt_uint64_invite_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
            public final PBUInt64Field uint64_invite_leader = PBField.initUInt64(0);
            public WifiPOIInfo msg_poi_info = new WifiPOIInfo();
            public final PBRepeatMessageField<PlayerState> rpt_msg_player_state = PBField.initRepeatMessage(PlayerState.class);

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class PlayerState extends MessageMicro<PlayerState> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint32_state"}, new Object[]{0L, 0}, PlayerState.class);
                public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
                public final PBUInt32Field uint32_state = PBField.initUInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class SeatsInfo extends MessageMicro<SeatsInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_seat_flag", "uint64_guest_uin", "uint32_seat_id", "uint32_seat_seq"}, new Object[]{0, 0L, 0, 0}, SeatsInfo.class);
                public final PBUInt32Field uint32_seat_flag = PBField.initUInt32(0);
                public final PBUInt64Field uint64_guest_uin = PBField.initUInt64(0);
                public final PBUInt32Field uint32_seat_id = PBField.initUInt32(0);
                public final PBUInt32Field uint32_seat_seq = PBField.initUInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class WifiPOIInfo extends MessageMicro<WifiPOIInfo> {
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_name;
                public final PBBytesField bytes_sig;
                public final PBBytesField bytes_uid;
                public final PBInt32Field int32_latitude;
                public final PBInt32Field int32_longitude;
                public final PBRepeatMessageField<SeatsInfo> rpt_msg_seats_info;
                public final PBStringField string_banner_url;
                public final PBStringField string_face_url;
                public final PBStringField string_join_group_url;
                public final PBStringField string_smemo;
                public final PBUInt32Field uint32_audit_flag;
                public final PBUInt32Field uint32_creater_city_id;
                public final PBUInt32Field uint32_distance;
                public final PBUInt32Field uint32_face_id;
                public final PBUInt32Field uint32_favorites_expired;
                public final PBUInt32Field uint32_group_code;
                public final PBUInt32Field uint32_group_id;
                public final PBUInt32Field uint32_group_is_not_exist;
                public final PBUInt32Field uint32_group_type_flag;
                public final PBUInt32Field uint32_group_uin;
                public final PBUInt32Field uint32_guest_num;
                public final PBUInt32Field uint32_high_quality_flag;
                public final PBUInt32Field uint32_hot_theme_group_flag;
                public final PBUInt32Field uint32_is_admin;
                public final PBUInt32Field uint32_is_all_country;
                public final PBUInt32Field uint32_is_member;
                public final PBUInt32Field uint32_is_user_create;
                public final PBUInt32Field uint32_msg_tab_switch_off;
                public final PBUInt32Field uint32_special_flag;
                public final PBUInt32Field uint32_sub_type;
                public final PBUInt32Field uint32_total_num_limit;
                public final PBUInt32Field uint32_tv_pk_flag;
                public final PBUInt32Field uint32_visitor_num;
                public final PBUInt32Field uint32_wifi_poi_type;
                public final PBUInt64Field uint64_exit_group_code;
                public final PBUInt64Field uint64_favorites_time;
                public final PBUInt64Field uint64_flower_num;
                public final PBUInt64Field uint64_flower_point;
                public final PBUInt64Field uint64_get_praise_gap_time;
                public final PBUInt64Field uint64_last_msg_seq;
                public final PBUInt64Field uint64_owner_uin;
                public final PBUInt64Field uint64_praise_nums;
                public final PBUInt64Field uint64_report_praise_gap_frequency;
                public final PBUInt64Field uint64_report_praise_gap_time;
                public final PBUInt64Field uint64_vistor_join_group_time;

                static {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 98, 104, 114, 120, 128, 136, 146, 152, 160, 168, 176, 184, 192, 200, 208, 218, 224, 232, 248, 256, 264, 272, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288, 296, 304, 312, 320, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 336, a.CTRL_INDEX, g.CTRL_INDEX, 362, 368}, new String[]{"bytes_uid", "bytes_name", "uint32_face_id", "bytes_sig", "uint32_group_code", "uint32_group_uin", "uint32_visitor_num", "uint32_wifi_poi_type", "uint32_is_member", "uint32_distance", "uint32_msg_tab_switch_off", "string_face_url", "uint32_hot_theme_group_flag", "string_banner_url", "uint32_special_flag", "uint32_total_num_limit", "uint32_is_admin", "string_join_group_url", "uint32_group_type_flag", "uint32_creater_city_id", "uint32_is_user_create", "uint64_owner_uin", "uint32_audit_flag", "uint32_tv_pk_flag", "uint32_sub_type", "uint64_last_msg_seq", "rpt_msg_seats_info", "uint64_flower_num", "uint64_flower_point", "uint64_favorites_time", "uint32_favorites_expired", "uint32_group_id", "uint64_praise_nums", "uint64_report_praise_gap_time", "uint64_report_praise_gap_frequency", "uint64_get_praise_gap_time", "uint64_vistor_join_group_time", "uint32_group_is_not_exist", "uint32_guest_num", "uint32_high_quality_flag", "uint64_exit_group_code", "int32_latitude", "int32_longitude", "string_smemo", "uint32_is_all_country"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, "", 0, "", 0, 0, 0, "", 0, 0, 0, 0L, 0, 0, 0, 0L, null, 0L, 0L, 0L, 0, 0, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, 0L, 0, 0, "", 0}, WifiPOIInfo.class);
                }

                public WifiPOIInfo() {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    this.bytes_uid = PBField.initBytes(byteStringMicro);
                    this.bytes_name = PBField.initBytes(byteStringMicro);
                    this.uint32_face_id = PBField.initUInt32(0);
                    this.bytes_sig = PBField.initBytes(byteStringMicro);
                    this.uint32_group_code = PBField.initUInt32(0);
                    this.uint32_group_uin = PBField.initUInt32(0);
                    this.uint32_visitor_num = PBField.initUInt32(0);
                    this.uint32_wifi_poi_type = PBField.initUInt32(0);
                    this.uint32_is_member = PBField.initUInt32(0);
                    this.uint32_distance = PBField.initUInt32(0);
                    this.uint32_msg_tab_switch_off = PBField.initUInt32(0);
                    this.string_face_url = PBField.initString("");
                    this.uint32_hot_theme_group_flag = PBField.initUInt32(0);
                    this.string_banner_url = PBField.initString("");
                    this.uint32_special_flag = PBField.initUInt32(0);
                    this.uint32_total_num_limit = PBField.initUInt32(0);
                    this.uint32_is_admin = PBField.initUInt32(0);
                    this.string_join_group_url = PBField.initString("");
                    this.uint32_group_type_flag = PBField.initUInt32(0);
                    this.uint32_creater_city_id = PBField.initUInt32(0);
                    this.uint32_is_user_create = PBField.initUInt32(0);
                    this.uint64_owner_uin = PBField.initUInt64(0L);
                    this.uint32_audit_flag = PBField.initUInt32(0);
                    this.uint32_tv_pk_flag = PBField.initUInt32(0);
                    this.uint32_sub_type = PBField.initUInt32(0);
                    this.uint64_last_msg_seq = PBField.initUInt64(0L);
                    this.rpt_msg_seats_info = PBField.initRepeatMessage(SeatsInfo.class);
                    this.uint64_flower_num = PBField.initUInt64(0L);
                    this.uint64_flower_point = PBField.initUInt64(0L);
                    this.uint64_favorites_time = PBField.initUInt64(0L);
                    this.uint32_favorites_expired = PBField.initUInt32(0);
                    this.uint32_group_id = PBField.initUInt32(0);
                    this.uint64_praise_nums = PBField.initUInt64(0L);
                    this.uint64_report_praise_gap_time = PBField.initUInt64(0L);
                    this.uint64_report_praise_gap_frequency = PBField.initUInt64(0L);
                    this.uint64_get_praise_gap_time = PBField.initUInt64(0L);
                    this.uint64_vistor_join_group_time = PBField.initUInt64(0L);
                    this.uint32_group_is_not_exist = PBField.initUInt32(0);
                    this.uint32_guest_num = PBField.initUInt32(0);
                    this.uint32_high_quality_flag = PBField.initUInt32(0);
                    this.uint64_exit_group_code = PBField.initUInt64(0L);
                    this.int32_latitude = PBField.initInt32(0);
                    this.int32_longitude = PBField.initInt32(0);
                    this.string_smemo = PBField.initString("");
                    this.uint32_is_all_country = PBField.initUInt32(0);
                }
            }
        };
        try {
            messageMicro.mergeFrom(bArr);
            notifyUI(1, true, messageMicro);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("WerewolvesHandler", 2, QLog.getStackTraceString(e16));
            }
        }
    }

    public void E2(TroopTips0x857$WereWolfPush troopTips0x857$WereWolfPush, byte[] bArr) {
        MessageRecord messageRecord;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopTips0x857$WereWolfPush, (Object) bArr);
            return;
        }
        if (troopTips0x857$WereWolfPush != null && troopTips0x857$WereWolfPush.uint64_game_room.has() && troopTips0x857$WereWolfPush.bytes_judge_words.has() && troopTips0x857$WereWolfPush.uint64_judge_uin.has()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(troopTips0x857$WereWolfPush.uint64_game_room.get());
            String str2 = "";
            sb5.append("");
            String sb6 = sb5.toString();
            long K0 = e.K0();
            String stringUtf8 = troopTips0x857$WereWolfPush.bytes_judge_words.get().toStringUtf8();
            if (TextUtils.isEmpty(stringUtf8)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.werewolf.WereWolfPush", 2, "uint64_game_room:" + sb6 + ", msg is empty");
                    return;
                }
                return;
            }
            com.tencent.imcore.message.Message lastMessage = this.f315332h.getMessageFacade().getLastMessage(sb6, 1);
            MessageRecord d16 = q.d(-1000);
            d16.init(this.f315332h.getCurrentAccountUin(), sb6, this.f315332h.getCurrentAccountUin(), stringUtf8, K0, -1000, 1, K0);
            if (lastMessage != null) {
                messageRecord = d16;
                messageRecord.shmsgseq = lastMessage.shmsgseq;
            } else {
                messageRecord = d16;
            }
            String str3 = troopTips0x857$WereWolfPush.uint64_judge_uin.get() + "";
            messageRecord.senderuin = str3;
            this.f315331f = str3;
            if (!troopTips0x857$WereWolfPush.bytes_judge_nickname.has()) {
                str = "";
            } else {
                str = troopTips0x857$WereWolfPush.bytes_judge_nickname.get().toStringUtf8();
            }
            messageRecord.isread = true;
            messageRecord.issend = 0;
            messageRecord.saveExtInfoToExtStr("isJudgeMsg", "true");
            this.f315332h.getMessageFacade().c(messageRecord, this.f315332h.getCurrentAccountUin());
            RecentUserProxy m3 = this.f315332h.getProxyManager().m();
            m3.delRecentUser(m3.findRecentUserByUin(sb6, 1));
            if (QLog.isColorLevel()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("uint64_game_room:");
                sb7.append(sb6);
                sb7.append("|judge_nickname:");
                sb7.append(str);
                sb7.append("|msg:");
                if (!TextUtils.isEmpty(stringUtf8)) {
                    str2 = stringUtf8.substring(0, 1) + "***" + stringUtf8.substring(stringUtf8.length() - 1) + "|msg len:" + stringUtf8.length();
                }
                sb7.append(str2);
                QLog.d("Q.werewolf.WereWolfPush", 2, sb7.toString());
            }
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return com.tencent.mobileqq.werewolves.a.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.f315332h.getApplication().unregisterReceiver(this.f315333i);
        if (!TextUtils.isEmpty(this.f315331f)) {
            this.f315332h.getApp().getSharedPreferences("werewolves_sp", 0).edit().putString("judgeUin", this.f315331f).commit();
        }
        this.f315330e.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_STORY_PROTOCOL, 2, "WereWolevsHandler onReceive. cmd=" + serviceCmd);
        }
        if (ProfileContants.CMD_GETSIMPLEINFO.equals(serviceCmd)) {
            ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
            if (fromServiceMsg.isSuccess() && (arrayList = (ArrayList) obj) != null && stringArrayList != null && arrayList.size() > 0 && stringArrayList.size() > 0) {
                String str = stringArrayList.get(0);
                String str2 = ((ProfSmpInfoRes) arrayList.get(0)).sDateNick;
                if (TextUtils.isEmpty(str2)) {
                    str2 = ((ProfSmpInfoRes) arrayList.get(0)).strNick;
                }
                Message message = new Message();
                message.obj = new String[]{str, str2};
                this.f315330e.sendMessage(message);
            }
        }
    }
}
