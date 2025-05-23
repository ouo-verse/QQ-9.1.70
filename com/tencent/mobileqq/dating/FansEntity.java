package com.tencent.mobileqq.dating;

import appoint.define.appoint_define$CommonLabel;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4$UdcUinData;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FansEntity extends Entity {
    static IPatchRedirector $redirector_;
    public int age;
    public int career;
    public boolean charmIcon;
    public int charmLevel;

    /* renamed from: common, reason: collision with root package name */
    public String f203365common;
    public int commonId;
    public int constellation;
    public int gender;
    public int single;

    @unique
    public long uin;
    public int vip;

    public FansEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void init(cmd0x9e4$UdcUinData cmd0x9e4_udcuindata) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cmd0x9e4_udcuindata);
            return;
        }
        if (cmd0x9e4_udcuindata.uint64_uin.has()) {
            this.uin = cmd0x9e4_udcuindata.uint64_uin.get();
        }
        if (cmd0x9e4_udcuindata.uint32_gender.has()) {
            this.gender = cmd0x9e4_udcuindata.uint32_gender.get();
        }
        if (cmd0x9e4_udcuindata.uint32_age.has()) {
            this.age = cmd0x9e4_udcuindata.uint32_age.get();
        }
        if (cmd0x9e4_udcuindata.uint32_love_status.has()) {
            this.single = cmd0x9e4_udcuindata.uint32_love_status.get();
        }
        if (cmd0x9e4_udcuindata.uint32_profession.has()) {
            this.career = cmd0x9e4_udcuindata.uint32_profession.get();
        }
        if (cmd0x9e4_udcuindata.uint32_constellation.has()) {
            this.constellation = cmd0x9e4_udcuindata.uint32_constellation.get();
        }
        if (cmd0x9e4_udcuindata.uint32_vip_flag.has()) {
            this.vip = cmd0x9e4_udcuindata.uint32_vip_flag.get();
        }
        int i3 = 0;
        if (cmd0x9e4_udcuindata.uint32_charm_shown.has()) {
            boolean z16 = true;
            if (cmd0x9e4_udcuindata.uint32_charm_shown.get() != 1) {
                z16 = false;
            }
            this.charmIcon = z16;
        }
        if (cmd0x9e4_udcuindata.uint32_charm_level.has()) {
            this.charmLevel = cmd0x9e4_udcuindata.uint32_charm_level.get();
        }
        if (cmd0x9e4_udcuindata.msg_common_label.has()) {
            appoint_define$CommonLabel appoint_define_commonlabel = cmd0x9e4_udcuindata.msg_common_label.get();
            if (appoint_define_commonlabel.uint32_lable_id.has()) {
                i3 = appoint_define_commonlabel.uint32_lable_id.get();
            }
            this.commonId = i3;
            String str2 = "";
            if (!appoint_define_commonlabel.bytes_lable_msg_pre.has()) {
                str = "";
            } else {
                str = new String(appoint_define_commonlabel.bytes_lable_msg_pre.get().toByteArray());
            }
            if (appoint_define_commonlabel.bytes_lable_msg_pre.has()) {
                str2 = new String(appoint_define_commonlabel.bytes_lable_msg_last.get().toByteArray());
            }
            this.f203365common = str + str2;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("");
        sb5.append("uin:" + this.uin);
        sb5.append(",gender:" + this.gender);
        sb5.append(",age:" + this.age);
        sb5.append(",single:" + this.single);
        sb5.append(",career:" + this.career);
        sb5.append(",constellation:" + this.constellation);
        sb5.append(",charmIcon:" + this.charmIcon);
        sb5.append(",vip:" + this.vip);
        sb5.append(",charmLevel:" + this.charmLevel);
        sb5.append(",commonId:" + this.commonId);
        sb5.append(",common:" + this.f203365common);
        return sb5.toString();
    }
}
