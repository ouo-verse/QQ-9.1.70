package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$DoubtInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SysSuspiciousMsg extends Entity implements Serializable {
    public int age;
    public long commFrdNum;
    public String entity_category;
    public String entity_name;
    public String entity_url;
    public long groupCode;

    /* renamed from: msg, reason: collision with root package name */
    public String f203119msg;
    public String nameMore;
    public String nick;
    public String reason;
    public byte[] session_key;
    public int sex;
    public String source;
    public int sourceflag;
    public long time;

    @unique
    public long uin;

    public static SysSuspiciousMsg covertFrom(oidb_cmd0xd69$DoubtInfo oidb_cmd0xd69_doubtinfo) {
        String str;
        int i3;
        int i16;
        String str2;
        String str3;
        String str4;
        String str5;
        byte[] bArr;
        String str6;
        String str7;
        SysSuspiciousMsg sysSuspiciousMsg = new SysSuspiciousMsg();
        if (oidb_cmd0xd69_doubtinfo != null) {
            sysSuspiciousMsg.uin = oidb_cmd0xd69_doubtinfo.uint64_uin.get();
            String str8 = null;
            if (oidb_cmd0xd69_doubtinfo.bytes_nick.has()) {
                str = oidb_cmd0xd69_doubtinfo.bytes_nick.get().toStringUtf8();
            } else {
                str = null;
            }
            sysSuspiciousMsg.nick = str;
            int i17 = 0;
            if (oidb_cmd0xd69_doubtinfo.uint32_age.has()) {
                i3 = oidb_cmd0xd69_doubtinfo.uint32_age.get();
            } else {
                i3 = 0;
            }
            sysSuspiciousMsg.age = i3;
            if (oidb_cmd0xd69_doubtinfo.uint32_sex.has()) {
                i16 = oidb_cmd0xd69_doubtinfo.uint32_sex.get();
            } else {
                i16 = -1;
            }
            sysSuspiciousMsg.sex = i16;
            if (oidb_cmd0xd69_doubtinfo.bytes_msg.has()) {
                str2 = oidb_cmd0xd69_doubtinfo.bytes_msg.get().toStringUtf8();
            } else {
                str2 = null;
            }
            sysSuspiciousMsg.f203119msg = str2;
            if (oidb_cmd0xd69_doubtinfo.bytes_source.has()) {
                str3 = oidb_cmd0xd69_doubtinfo.bytes_source.get().toStringUtf8();
            } else {
                str3 = null;
            }
            sysSuspiciousMsg.source = str3;
            if (oidb_cmd0xd69_doubtinfo.bytes_reason.has()) {
                str4 = oidb_cmd0xd69_doubtinfo.bytes_reason.get().toStringUtf8();
            } else {
                str4 = null;
            }
            sysSuspiciousMsg.reason = str4;
            sysSuspiciousMsg.time = oidb_cmd0xd69_doubtinfo.uint32_time.get();
            sysSuspiciousMsg.groupCode = oidb_cmd0xd69_doubtinfo.uint64_group.get();
            sysSuspiciousMsg.commFrdNum = oidb_cmd0xd69_doubtinfo.uint32_comm_frd_num.get();
            if (oidb_cmd0xd69_doubtinfo.bytes_name_more.has()) {
                str5 = oidb_cmd0xd69_doubtinfo.bytes_name_more.get().toStringUtf8();
            } else {
                str5 = null;
            }
            sysSuspiciousMsg.nameMore = str5;
            if (oidb_cmd0xd69_doubtinfo.bytes_session_key.has()) {
                bArr = oidb_cmd0xd69_doubtinfo.bytes_session_key.get().toByteArray();
            } else {
                bArr = null;
            }
            sysSuspiciousMsg.session_key = bArr;
            if (oidb_cmd0xd69_doubtinfo.str_entity_category.has()) {
                str6 = oidb_cmd0xd69_doubtinfo.str_entity_category.get();
            } else {
                str6 = null;
            }
            sysSuspiciousMsg.entity_category = str6;
            if (oidb_cmd0xd69_doubtinfo.str_entity_name.has()) {
                str7 = oidb_cmd0xd69_doubtinfo.str_entity_name.get();
            } else {
                str7 = null;
            }
            sysSuspiciousMsg.entity_name = str7;
            if (oidb_cmd0xd69_doubtinfo.str_entity_url.has()) {
                str8 = oidb_cmd0xd69_doubtinfo.str_entity_url.get();
            }
            sysSuspiciousMsg.entity_url = str8;
            if (oidb_cmd0xd69_doubtinfo.uint32_source_flag.has()) {
                i17 = oidb_cmd0xd69_doubtinfo.uint32_source_flag.get();
            }
            sysSuspiciousMsg.sourceflag = i17;
        }
        return sysSuspiciousMsg;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SysSuspiciousMsg{uin=");
        sb5.append(this.uin);
        sb5.append(", nick='");
        sb5.append(this.nick);
        sb5.append(", age='");
        sb5.append(this.age);
        sb5.append(", sex='");
        sb5.append(this.sex);
        sb5.append(", msg='");
        sb5.append(this.f203119msg);
        sb5.append(", source='");
        sb5.append(this.source);
        sb5.append(", reason='");
        sb5.append(this.reason);
        sb5.append(", time='");
        sb5.append(this.time);
        sb5.append(", groupCode='");
        sb5.append(this.groupCode);
        sb5.append(", commFrdNum='");
        sb5.append(this.commFrdNum);
        sb5.append(", nameMore='");
        sb5.append(this.nameMore);
        sb5.append(", session_key='");
        if (this.session_key == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", entity_category='");
        sb5.append(this.entity_category);
        sb5.append(", entity_name='");
        sb5.append(this.entity_name);
        sb5.append(", entity_url='");
        sb5.append(this.entity_url);
        sb5.append(", sourceflag='");
        sb5.append(this.sourceflag);
        sb5.append('}');
        return sb5.toString();
    }
}
