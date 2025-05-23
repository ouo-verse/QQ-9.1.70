package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AddFriendReq extends JceStruct {
    static int cache_adduinsetting;
    static byte[] cache_ext_info;
    static byte[] cache_friend_src_desc;
    static MacQQInfo cache_macqqInfo = new MacQQInfo();
    static byte[] cache_name;
    static byte[] cache_name1;
    static byte[] cache_permission_info;
    static byte[] cache_remark;
    static byte[] cache_secSign;
    static byte[] cache_sig;
    static int cache_sourceID;
    static int cache_sourceSubID;
    static byte[] cache_src_description;
    static byte[] cache_token;
    static byte[] cache_verify;
    public long adduin;
    public int adduinsetting;
    public byte autoSend;
    public boolean bSupportAddRelief;
    public boolean bSupportSecureTips;
    public boolean contact_bothway_friend;
    public byte[] ext_info;
    public byte[] friend_src_desc;
    public MacQQInfo macqqInfo;

    /* renamed from: msg, reason: collision with root package name */
    public String f400383msg;
    public byte msgLen;
    public byte myAllowFlag;
    public byte myfriendgroupid;
    public byte[] name;
    public byte[] name1;
    public byte[] permission_info;
    public byte[] remark;
    public byte[] secSign;
    public byte showMyCard;
    public byte[] sig;
    public int sourceID;
    public int sourceSubID;
    public byte srcFlag;
    public byte[] src_description;
    public byte[] token;
    public long uin;
    public byte[] verify;

    static {
        cache_sig = r1;
        byte[] bArr = {0};
        cache_name = r1;
        byte[] bArr2 = {0};
        cache_src_description = r1;
        byte[] bArr3 = {0};
        cache_friend_src_desc = r1;
        byte[] bArr4 = {0};
        cache_remark = r1;
        byte[] bArr5 = {0};
        cache_name1 = r1;
        byte[] bArr6 = {0};
        cache_token = r1;
        byte[] bArr7 = {0};
        cache_verify = r1;
        byte[] bArr8 = {0};
        cache_ext_info = r1;
        byte[] bArr9 = {0};
        cache_secSign = r1;
        byte[] bArr10 = {0};
        cache_permission_info = r0;
        byte[] bArr11 = {0};
    }

    public AddFriendReq() {
        this.uin = 0L;
        this.adduin = 0L;
        this.adduinsetting = 0;
        this.myAllowFlag = (byte) 0;
        this.myfriendgroupid = (byte) 0;
        this.msgLen = (byte) 0;
        this.f400383msg = "";
        this.srcFlag = (byte) 0;
        this.autoSend = (byte) 1;
        this.sig = null;
        this.sourceID = BuddySource.DEFAULT;
        this.sourceSubID = 0;
        this.name = null;
        this.src_description = null;
        this.friend_src_desc = null;
        this.contact_bothway_friend = false;
        this.remark = null;
        this.name1 = null;
        this.showMyCard = (byte) 0;
        this.token = null;
        this.verify = null;
        this.macqqInfo = null;
        this.bSupportSecureTips = false;
        this.bSupportAddRelief = false;
        this.ext_info = null;
        this.secSign = null;
        this.permission_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.adduin = jceInputStream.read(this.adduin, 1, true);
        this.adduinsetting = jceInputStream.read(this.adduinsetting, 2, true);
        this.myAllowFlag = jceInputStream.read(this.myAllowFlag, 3, true);
        this.myfriendgroupid = jceInputStream.read(this.myfriendgroupid, 4, true);
        this.msgLen = jceInputStream.read(this.msgLen, 5, false);
        this.f400383msg = jceInputStream.readString(6, false);
        this.srcFlag = jceInputStream.read(this.srcFlag, 7, false);
        this.autoSend = jceInputStream.read(this.autoSend, 8, false);
        this.sig = jceInputStream.read(cache_sig, 9, false);
        this.sourceID = jceInputStream.read(this.sourceID, 10, false);
        this.sourceSubID = jceInputStream.read(this.sourceSubID, 11, false);
        this.name = jceInputStream.read(cache_name, 12, false);
        this.src_description = jceInputStream.read(cache_src_description, 13, false);
        this.friend_src_desc = jceInputStream.read(cache_friend_src_desc, 14, false);
        this.contact_bothway_friend = jceInputStream.read(this.contact_bothway_friend, 15, false);
        this.remark = jceInputStream.read(cache_remark, 16, false);
        this.name1 = jceInputStream.read(cache_name1, 17, false);
        this.showMyCard = jceInputStream.read(this.showMyCard, 18, false);
        this.token = jceInputStream.read(cache_token, 19, false);
        this.verify = jceInputStream.read(cache_verify, 20, false);
        this.macqqInfo = (MacQQInfo) jceInputStream.read((JceStruct) cache_macqqInfo, 21, false);
        this.bSupportSecureTips = jceInputStream.read(this.bSupportSecureTips, 22, false);
        this.bSupportAddRelief = jceInputStream.read(this.bSupportAddRelief, 23, false);
        this.ext_info = jceInputStream.read(cache_ext_info, 24, false);
        this.secSign = jceInputStream.read(cache_secSign, 25, false);
        this.permission_info = jceInputStream.read(cache_permission_info, 26, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.adduin, 1);
        jceOutputStream.write(this.adduinsetting, 2);
        jceOutputStream.write(this.myAllowFlag, 3);
        jceOutputStream.write(this.myfriendgroupid, 4);
        jceOutputStream.write(this.msgLen, 5);
        String str = this.f400383msg;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        jceOutputStream.write(this.srcFlag, 7);
        jceOutputStream.write(this.autoSend, 8);
        byte[] bArr = this.sig;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
        jceOutputStream.write(this.sourceID, 10);
        jceOutputStream.write(this.sourceSubID, 11);
        byte[] bArr2 = this.name;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 12);
        }
        byte[] bArr3 = this.src_description;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 13);
        }
        byte[] bArr4 = this.friend_src_desc;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 14);
        }
        jceOutputStream.write(this.contact_bothway_friend, 15);
        byte[] bArr5 = this.remark;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 16);
        }
        byte[] bArr6 = this.name1;
        if (bArr6 != null) {
            jceOutputStream.write(bArr6, 17);
        }
        jceOutputStream.write(this.showMyCard, 18);
        byte[] bArr7 = this.token;
        if (bArr7 != null) {
            jceOutputStream.write(bArr7, 19);
        }
        byte[] bArr8 = this.verify;
        if (bArr8 != null) {
            jceOutputStream.write(bArr8, 20);
        }
        MacQQInfo macQQInfo = this.macqqInfo;
        if (macQQInfo != null) {
            jceOutputStream.write((JceStruct) macQQInfo, 21);
        }
        jceOutputStream.write(this.bSupportSecureTips, 22);
        jceOutputStream.write(this.bSupportAddRelief, 23);
        byte[] bArr9 = this.ext_info;
        if (bArr9 != null) {
            jceOutputStream.write(bArr9, 24);
        }
        byte[] bArr10 = this.secSign;
        if (bArr10 != null) {
            jceOutputStream.write(bArr10, 25);
        }
        byte[] bArr11 = this.permission_info;
        if (bArr11 != null) {
            jceOutputStream.write(bArr11, 26);
        }
    }

    public AddFriendReq(long j3, long j16, int i3, byte b16, byte b17, byte b18, String str, byte b19, byte b26, byte[] bArr, int i16, int i17, byte[] bArr2, byte[] bArr3, byte[] bArr4, boolean z16, byte[] bArr5, byte[] bArr6, byte b27, byte[] bArr7, byte[] bArr8, MacQQInfo macQQInfo, boolean z17, boolean z18, byte[] bArr9, byte[] bArr10, byte[] bArr11) {
        this.uin = j3;
        this.adduin = j16;
        this.adduinsetting = i3;
        this.myAllowFlag = b16;
        this.myfriendgroupid = b17;
        this.msgLen = b18;
        this.f400383msg = str;
        this.srcFlag = b19;
        this.autoSend = b26;
        this.sig = bArr;
        this.sourceID = i16;
        this.sourceSubID = i17;
        this.name = bArr2;
        this.src_description = bArr3;
        this.friend_src_desc = bArr4;
        this.contact_bothway_friend = z16;
        this.remark = bArr5;
        this.name1 = bArr6;
        this.showMyCard = b27;
        this.token = bArr7;
        this.verify = bArr8;
        this.macqqInfo = macQQInfo;
        this.bSupportSecureTips = z17;
        this.bSupportAddRelief = z18;
        this.ext_info = bArr9;
        this.secSign = bArr10;
        this.permission_info = bArr11;
    }
}
