package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class offlinepush {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class C2CMsgReadedNotify extends MessageMicro<C2CMsgReadedNotify> {
        public static final int LLASTREADTIME_FIELD_NUMBER = 2;
        public static final int LPEERUIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"lPeerUin", "lLastReadTime"}, new Object[]{0L, 0L}, C2CMsgReadedNotify.class);
        public final PBUInt64Field lPeerUin = PBField.initUInt64(0);
        public final PBUInt64Field lLastReadTime = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class C2CTmpOffMsgHead extends MessageMicro<C2CTmpOffMsgHead> {
        public static final int C2C_TYPE_FIELD_NUMBER = 1;
        public static final int DISCUSS_REMARK_FIELD_NUMBER = 12;
        public static final int DIS_NAME_FIELD_NUMBER = 13;
        public static final int FROM_PHONE_FIELD_NUMBER = 7;
        public static final int GROUP_CARD_FIELD_NUMBER = 10;
        public static final int GROUP_CODE_FIELD_NUMBER = 4;
        public static final int GROUP_NAME_FIELD_NUMBER = 11;
        public static final int GROUP_UIN_FIELD_NUMBER = 3;
        public static final int LOCK_DISPLAY_FIELD_NUMBER = 9;
        public static final int SERVICE_TYPE_FIELD_NUMBER = 2;
        public static final int SIG_FIELD_NUMBER = 5;
        public static final int SIG_TYPE_FIELD_NUMBER = 6;
        public static final int TO_PHONE_FIELD_NUMBER = 8;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField dis_name;
        public final PBBytesField discuss_remark;
        public final PBStringField from_phone;
        public final PBBytesField group_card;
        public final PBBytesField group_name;
        public final PBUInt32Field lock_display;
        public final PBBytesField sig;
        public final PBUInt32Field sig_type;
        public final PBStringField to_phone;
        public final PBUInt32Field c2c_type = PBField.initUInt32(0);
        public final PBUInt32Field service_type = PBField.initUInt32(0);
        public final PBUInt64Field group_uin = PBField.initUInt64(0);
        public final PBUInt64Field group_code = PBField.initUInt64(0);

        static {
            String[] strArr = {"c2c_type", "service_type", "group_uin", "group_code", PreloadTRTCPlayerParams.KEY_SIG, "sig_type", "from_phone", "to_phone", "lock_display", "group_card", "group_name", "discuss_remark", "dis_name"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 82, 90, 98, 106}, strArr, new Object[]{0, 0, 0L, 0L, byteStringMicro, 0, "", "", 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, C2CTmpOffMsgHead.class);
        }

        public C2CTmpOffMsgHead() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.sig = PBField.initBytes(byteStringMicro);
            this.sig_type = PBField.initUInt32(0);
            this.from_phone = PBField.initString("");
            this.to_phone = PBField.initString("");
            this.lock_display = PBField.initUInt32(0);
            this.group_card = PBField.initBytes(byteStringMicro);
            this.group_name = PBField.initBytes(byteStringMicro);
            this.discuss_remark = PBField.initBytes(byteStringMicro);
            this.dis_name = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class DisMsgReadedNotify extends MessageMicro<DisMsgReadedNotify> {
        public static final int LDISMSGSEQ_FIELD_NUMBER = 4;
        public static final int LDISUIN_FIELD_NUMBER = 1;
        public static final int LMEMBERSEQ_FIELD_NUMBER = 3;
        public static final int LOPTYPE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"lDisUin", "lOpType", "lMemberSeq", "lDisMsgSeq"}, new Object[]{0L, 0L, 0L, 0L}, DisMsgReadedNotify.class);
        public final PBUInt64Field lDisUin = PBField.initUInt64(0);
        public final PBUInt64Field lOpType = PBField.initUInt64(0);
        public final PBUInt64Field lMemberSeq = PBField.initUInt64(0);
        public final PBUInt64Field lDisMsgSeq = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class DiscussOffInfo extends MessageMicro<DiscussOffInfo> {
        public static final int DISCUSS_INFO_SEQ_FIELD_NUMBER = 3;
        public static final int DISCUSS_REMARK_FIELD_NUMBER = 4;
        public static final int DISCUSS_TYPE_FIELD_NUMBER = 2;
        public static final int DISCUSS_UIN_FIELD_NUMBER = 1;
        public static final int DIS_NAME_FIELD_NUMBER = 5;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField dis_name;
        public final PBBytesField discuss_remark;
        public final PBUInt64Field discuss_uin = PBField.initUInt64(0);
        public final PBUInt32Field discuss_type = PBField.initUInt32(0);
        public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"discuss_uin", "discuss_type", "discuss_info_seq", "discuss_remark", "dis_name"}, new Object[]{0L, 0, 0L, byteStringMicro, byteStringMicro}, DiscussOffInfo.class);
        }

        public DiscussOffInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.discuss_remark = PBField.initBytes(byteStringMicro);
            this.dis_name = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class GroupMsgReadedNotify extends MessageMicro<GroupMsgReadedNotify> {
        public static final int LGROUPCODE_FIELD_NUMBER = 1;
        public static final int LGROUPMSGSEQ_FIELD_NUMBER = 4;
        public static final int LMEMBERSEQ_FIELD_NUMBER = 3;
        public static final int LOPTYPE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"lGroupCode", "lOpType", "lMemberSeq", "lGroupMsgSeq"}, new Object[]{0L, 0L, 0L, 0L}, GroupMsgReadedNotify.class);
        public final PBUInt64Field lGroupCode = PBField.initUInt64(0);
        public final PBUInt64Field lOpType = PBField.initUInt64(0);
        public final PBUInt64Field lMemberSeq = PBField.initUInt64(0);
        public final PBUInt64Field lGroupMsgSeq = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class GroupOffInfo extends MessageMicro<GroupOffInfo> {
        public static final int GROUP_CARD_FIELD_NUMBER = 4;
        public static final int GROUP_CODE_FIELD_NUMBER = 1;
        public static final int GROUP_INFO_SEQ_FIELD_NUMBER = 3;
        public static final int GROUP_NAME_FIELD_NUMBER = 5;
        public static final int GROUP_TYPE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField group_card;
        public final PBBytesField group_name;
        public final PBUInt64Field group_code = PBField.initUInt64(0);
        public final PBUInt32Field group_type = PBField.initUInt32(0);
        public final PBUInt64Field group_info_seq = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"group_code", "group_type", "group_info_seq", "group_card", "group_name"}, new Object[]{0L, 0, 0L, byteStringMicro, byteStringMicro}, GroupOffInfo.class);
        }

        public GroupOffInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.group_card = PBField.initBytes(byteStringMicro);
            this.group_name = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class PbPushOffMsg extends MessageMicro<PbPushOffMsg> {
        public static final int C2C_TMP_MSG_HEAD_FIELD_NUMBER = 8;
        public static final int DISCUSS_INFO_FIELD_NUMBER = 7;
        public static final int DWVIEDOTYPE_FIELD_NUMBER = 11;
        public static final int FROM_NICK_FIELD_NUMBER = 4;
        public static final int FROM_UIN_FIELD_NUMBER = 1;
        public static final int GROUP_INFO_FIELD_NUMBER = 6;
        public static final int MSG_FLAG_FIELD_NUMBER = 10;
        public static final int MSG_STR_FIELD_NUMBER = 5;
        public static final int MSG_TYPE_FIELD_NUMBER = 3;
        public static final int SVR_IP_FIELD_NUMBER = 9;
        public static final int TO_UIN_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__;
        public C2CTmpOffMsgHead c2c_tmp_msg_head;
        public DiscussOffInfo discuss_info;
        public final PBUInt32Field dwViedoType;
        public final PBBytesField from_nick;
        public GroupOffInfo group_info;
        public final PBUInt32Field msg_flag;
        public final PBBytesField msg_str;
        public final PBUInt32Field svr_ip;
        public final PBUInt64Field from_uin = PBField.initUInt64(0);
        public final PBUInt64Field to_uin = PBField.initUInt64(0);
        public final PBUInt32Field msg_type = PBField.initUInt32(0);

        static {
            String[] strArr = {ShortVideoConstants.FROM_UIN, "to_uin", QQHealthReportApiImpl.MSG_TYPE_KEY, "from_nick", "msg_str", "group_info", "discuss_info", "c2c_tmp_msg_head", "svr_ip", "msg_flag", "dwViedoType"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 88}, strArr, new Object[]{0L, 0L, 0, byteStringMicro, byteStringMicro, null, null, null, 0, 0, 0}, PbPushOffMsg.class);
        }

        public PbPushOffMsg() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.from_nick = PBField.initBytes(byteStringMicro);
            this.msg_str = PBField.initBytes(byteStringMicro);
            this.group_info = new GroupOffInfo();
            this.discuss_info = new DiscussOffInfo();
            this.c2c_tmp_msg_head = new C2CTmpOffMsgHead();
            this.svr_ip = PBField.initUInt32(0);
            this.msg_flag = PBField.initUInt32(0);
            this.dwViedoType = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class PbPushOffReadedNotify extends MessageMicro<PbPushOffReadedNotify> {
        public static final int CNOTIFYTYPE_FIELD_NUMBER = 1;
        public static final int SVR_IP_FIELD_NUMBER = 5;
        public static final int VC2CREADEDNOTIFY_FIELD_NUMBER = 2;
        public static final int VDISREADEDNOTIFY_FIELD_NUMBER = 4;
        public static final int VGROUPREADEDNOTIFY_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"cNotifyType", "vC2CReadedNotify", "vGroupReadedNotify", "vDisReadedNotify", "svr_ip"}, new Object[]{0, null, null, null, 0}, PbPushOffReadedNotify.class);
        public final PBUInt32Field cNotifyType = PBField.initUInt32(0);
        public final PBRepeatMessageField<C2CMsgReadedNotify> vC2CReadedNotify = PBField.initRepeatMessage(C2CMsgReadedNotify.class);
        public final PBRepeatMessageField<GroupMsgReadedNotify> vGroupReadedNotify = PBField.initRepeatMessage(GroupMsgReadedNotify.class);
        public final PBRepeatMessageField<DisMsgReadedNotify> vDisReadedNotify = PBField.initRepeatMessage(DisMsgReadedNotify.class);
        public final PBUInt32Field svr_ip = PBField.initUInt32(0);
    }

    offlinepush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
