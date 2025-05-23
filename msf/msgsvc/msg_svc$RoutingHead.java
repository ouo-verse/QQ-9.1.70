package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x1a.SubMsgType0x1a$MsgBody;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$RoutingHead extends MessageMicro<msg_svc$RoutingHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178}, new String[]{"c2c", "grp", "grp_tmp", "dis", "dis_tmp", "wpa_tmp", "secret_file", "public_plat", "trans_msg", "address_list", "rich_status_tmp", "trans_cmd", "accost_tmp", "pub_group_tmp", "trans_0x211", "business_wpa_tmp", "auth_tmp", "bsns_tmp", "qq_querybusiness_tmp", "nearby_dating_tmp", "nearby_assistant_tmp", "comm_tmp"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, msg_svc$RoutingHead.class);
    public msg_svc$C2C c2c = new msg_svc$C2C();
    public msg_svc$Grp grp = new msg_svc$Grp();
    public msg_svc$GrpTmp grp_tmp = new msg_svc$GrpTmp();
    public msg_svc$Dis dis = new msg_svc$Dis();
    public msg_svc$DisTmp dis_tmp = new msg_svc$DisTmp();
    public msg_svc$WPATmp wpa_tmp = new msg_svc$WPATmp();
    public msg_svc$SecretFileHead secret_file = new MessageMicro<msg_svc$SecretFileHead>() { // from class: msf.msgsvc.msg_svc$SecretFileHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"secret_file_msg", "secret_file_status"}, new Object[]{null, null}, msg_svc$SecretFileHead.class);
        public SubMsgType0xc1$MsgBody secret_file_msg = new MessageMicro<SubMsgType0xc1$MsgBody>() { // from class: tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1$MsgBody
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_encrypt_key;
            public final PBBytesField bytes_file_key;
            public SubMsgType0xc1$NotOnlineImage not_online_image;
            public final PBUInt32Field uint32_encrypt_prehead_length;
            public final PBUInt32Field uint32_encrypt_type;
            public final PBUInt32Field uint32_left_time;
            public final PBUInt32Field uint32_read_times;
            public final PBUInt32Field uint32_status;
            public final PBUInt32Field uint32_ttl;
            public final PBUInt32Field uint32_type;
            public final PBUInt64Field uint64_from_uin;
            public final PBUInt64Field uint64_to_uin;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98}, new String[]{"bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image"}, new Object[]{byteStringMicro, 0L, 0L, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, null}, SubMsgType0xc1$MsgBody.class);
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1$NotOnlineImage] */
            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_file_key = PBField.initBytes(byteStringMicro);
                this.uint64_from_uin = PBField.initUInt64(0L);
                this.uint64_to_uin = PBField.initUInt64(0L);
                this.uint32_status = PBField.initUInt32(0);
                this.uint32_ttl = PBField.initUInt32(0);
                this.uint32_type = PBField.initUInt32(0);
                this.uint32_encrypt_prehead_length = PBField.initUInt32(0);
                this.uint32_encrypt_type = PBField.initUInt32(0);
                this.bytes_encrypt_key = PBField.initBytes(byteStringMicro);
                this.uint32_read_times = PBField.initUInt32(0);
                this.uint32_left_time = PBField.initUInt32(0);
                this.not_online_image = new MessageMicro<SubMsgType0xc1$NotOnlineImage>() { // from class: tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1$NotOnlineImage
                    static final MessageMicro.FieldMap __fieldMap__;
                    public final PBBytesField download_path;
                    public final PBUInt32Field file_len;
                    public final PBBytesField file_path;
                    public final PBBytesField flag;
                    public final PBUInt32Field img_type;
                    public final PBBytesField old_ver_send_file;
                    public final PBUInt32Field original;
                    public final PBUInt32Field pic_height;
                    public final PBBytesField pic_md5;
                    public final PBUInt32Field pic_width;
                    public final PBBytesField previews_image;
                    public final PBBytesField res_id;
                    public final PBStringField str_download_url;

                    static {
                        String[] strArr = {"file_path", "file_len", QQWinkConstants.EDITOR_LOCAL_TEMPLATE_PATH, "old_ver_send_file", "img_type", "previews_image", "pic_md5", "pic_height", "pic_width", IPreloadServiceProxy.KEY_RESID, "flag", "str_download_url", "original"};
                        ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 58, 64, 72, 82, 90, 98, 104}, strArr, new Object[]{byteStringMicro2, 0, byteStringMicro2, byteStringMicro2, 0, byteStringMicro2, byteStringMicro2, 0, 0, byteStringMicro2, byteStringMicro2, "", 0}, SubMsgType0xc1$NotOnlineImage.class);
                    }

                    {
                        ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                        this.file_path = PBField.initBytes(byteStringMicro2);
                        this.file_len = PBField.initUInt32(0);
                        this.download_path = PBField.initBytes(byteStringMicro2);
                        this.old_ver_send_file = PBField.initBytes(byteStringMicro2);
                        this.img_type = PBField.initUInt32(0);
                        this.previews_image = PBField.initBytes(byteStringMicro2);
                        this.pic_md5 = PBField.initBytes(byteStringMicro2);
                        this.pic_height = PBField.initUInt32(0);
                        this.pic_width = PBField.initUInt32(0);
                        this.res_id = PBField.initBytes(byteStringMicro2);
                        this.flag = PBField.initBytes(byteStringMicro2);
                        this.str_download_url = PBField.initString("");
                        this.original = PBField.initUInt32(0);
                    }
                };
            }
        };
        public SubMsgType0x1a$MsgBody secret_file_status = new MessageMicro<SubMsgType0x1a$MsgBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x1a.SubMsgType0x1a$MsgBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 72, 80}, new String[]{"bytes_file_key", "uint32_from_uin", "uint32_to_uin", "uint32_status", "uint32_ttl", "string_desc", "uint32_type", "uint32_capture_times", "uint64_from_uin", "uint64_to_uin"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0, 0, "", 0, 0, 0L, 0L}, SubMsgType0x1a$MsgBody.class);
            public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_from_uin = PBField.initUInt32(0);
            public final PBUInt32Field uint32_to_uin = PBField.initUInt32(0);
            public final PBUInt32Field uint32_status = PBField.initUInt32(0);
            public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
            public final PBStringField string_desc = PBField.initString("");
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_capture_times = PBField.initUInt32(0);
            public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
        };
    };
    public msg_svc$PublicPlat public_plat = new msg_svc$PublicPlat();
    public msg_svc$TransMsg trans_msg = new msg_svc$TransMsg();
    public msg_svc$AddressListTmp address_list = new msg_svc$AddressListTmp();
    public msg_svc$RichStatusTmp rich_status_tmp = new msg_svc$RichStatusTmp();
    public msg_svc$TransCmd trans_cmd = new MessageMicro<msg_svc$TransCmd>() { // from class: msf.msgsvc.msg_svc$TransCmd
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"to_uin", QQHealthReportApiImpl.MSG_TYPE_KEY}, new Object[]{0L, 0}, msg_svc$TransCmd.class);
        public final PBUInt64Field to_uin = PBField.initUInt64(0);
        public final PBUInt32Field msg_type = PBField.initUInt32(0);
    };
    public msg_svc$AccostTmp accost_tmp = new msg_svc$AccostTmp();
    public msg_svc$PubGroupTmp pub_group_tmp = new msg_svc$PubGroupTmp();
    public msg_svc$Trans0x211 trans_0x211 = new msg_svc$Trans0x211();
    public msg_svc$BusinessWPATmp business_wpa_tmp = new msg_svc$BusinessWPATmp();
    public msg_svc$AuthTmp auth_tmp = new msg_svc$AuthTmp();
    public msg_svc$BsnsTmp bsns_tmp = new msg_svc$BsnsTmp();
    public msg_svc$QQQueryBusinessTmp qq_querybusiness_tmp = new msg_svc$QQQueryBusinessTmp();
    public msg_svc$NearByDatingTmp nearby_dating_tmp = new msg_svc$NearByDatingTmp();
    public msg_svc$NearByAssistantTmp nearby_assistant_tmp = new msg_svc$NearByAssistantTmp();
    public msg_svc$CommTmp comm_tmp = new msg_svc$CommTmp();
}
