package OnlinePushPack;

import QQService.shareData;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgInfo extends JceStruct implements Cloneable {
    static TempMsgHead cache_stC2CTmpMsgHead;
    static shareData cache_stShareData;
    static byte[] cache_vAppShareCookie;
    static ArrayList<CPicInfo> cache_vCPicInfo;
    static byte[] cache_vMsg;
    static byte[] cache_vMsgCookies;
    static ArrayList<String> cache_vNickName;
    static byte[] cache_vRemarkOfSender;
    public long lFromInstId;
    public long lFromUin;
    public long lLastChangeTime;
    public long lMsgUid;
    public short shMsgSeq;
    public short shMsgType;
    public TempMsgHead stC2CTmpMsgHead;
    public shareData stShareData;
    public String strFromMobile;
    public String strFromName;
    public String strMsg;
    public long uAppShareID;
    public long uMsgTime;
    public int uRealMsgTime;
    public byte[] vAppShareCookie;
    public ArrayList<CPicInfo> vCPicInfo;
    public byte[] vMsg;
    public byte[] vMsgCookies;
    public ArrayList<String> vNickName;
    public byte[] vRemarkOfSender;

    public MsgInfo() {
        this.lFromUin = 0L;
        this.uMsgTime = 0L;
        this.shMsgType = (short) 0;
        this.shMsgSeq = (short) 0;
        this.strMsg = "";
        this.uRealMsgTime = 0;
        this.vMsg = null;
        this.uAppShareID = 0L;
        this.vMsgCookies = null;
        this.vAppShareCookie = null;
        this.lMsgUid = 0L;
        this.lLastChangeTime = 1L;
        this.vCPicInfo = null;
        this.stShareData = null;
        this.lFromInstId = 0L;
        this.vRemarkOfSender = null;
        this.strFromMobile = "";
        this.strFromName = "";
        this.vNickName = null;
        this.stC2CTmpMsgHead = null;
    }

    public String className() {
        return "OnlinePushPack.MsgInfo";
    }

    public String fullClassName() {
        return "OnlinePushPack.MsgInfo";
    }

    public long getLFromInstId() {
        return this.lFromInstId;
    }

    public long getLFromUin() {
        return this.lFromUin;
    }

    public long getLLastChangeTime() {
        return this.lLastChangeTime;
    }

    public long getLMsgUid() {
        return this.lMsgUid;
    }

    public short getShMsgSeq() {
        return this.shMsgSeq;
    }

    public short getShMsgType() {
        return this.shMsgType;
    }

    public shareData getStShareData() {
        return this.stShareData;
    }

    public String getStrFromMobile() {
        return this.strFromMobile;
    }

    public String getStrFromName() {
        return this.strFromName;
    }

    public String getStrMsg() {
        return this.strMsg;
    }

    public long getUAppShareID() {
        return this.uAppShareID;
    }

    public long getUMsgTime() {
        return this.uMsgTime;
    }

    public int getURealMsgTime() {
        return this.uRealMsgTime;
    }

    public byte[] getVAppShareCookie() {
        return this.vAppShareCookie;
    }

    public ArrayList<CPicInfo> getVCPicInfo() {
        return this.vCPicInfo;
    }

    public byte[] getVMsg() {
        return this.vMsg;
    }

    public byte[] getVMsgCookies() {
        return this.vMsgCookies;
    }

    public ArrayList<String> getVNickName() {
        return this.vNickName;
    }

    public byte[] getVRemarkOfSender() {
        return this.vRemarkOfSender;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromUin = jceInputStream.read(this.lFromUin, 0, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 1, true);
        this.shMsgType = jceInputStream.read(this.shMsgType, 2, true);
        this.shMsgSeq = jceInputStream.read(this.shMsgSeq, 3, true);
        this.strMsg = jceInputStream.readString(4, true);
        this.uRealMsgTime = jceInputStream.read(this.uRealMsgTime, 5, false);
        if (cache_vMsg == null) {
            cache_vMsg = r0;
            byte[] bArr = {0};
        }
        this.vMsg = jceInputStream.read(cache_vMsg, 6, false);
        this.uAppShareID = jceInputStream.read(this.uAppShareID, 7, false);
        if (cache_vMsgCookies == null) {
            cache_vMsgCookies = r0;
            byte[] bArr2 = {0};
        }
        this.vMsgCookies = jceInputStream.read(cache_vMsgCookies, 8, false);
        if (cache_vAppShareCookie == null) {
            cache_vAppShareCookie = r0;
            byte[] bArr3 = {0};
        }
        this.vAppShareCookie = jceInputStream.read(cache_vAppShareCookie, 9, false);
        this.lMsgUid = jceInputStream.read(this.lMsgUid, 10, false);
        this.lLastChangeTime = jceInputStream.read(this.lLastChangeTime, 11, false);
        if (cache_vCPicInfo == null) {
            cache_vCPicInfo = new ArrayList<>();
            cache_vCPicInfo.add(new CPicInfo());
        }
        this.vCPicInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vCPicInfo, 12, false);
        if (cache_stShareData == null) {
            cache_stShareData = new shareData();
        }
        this.stShareData = (shareData) jceInputStream.read((JceStruct) cache_stShareData, 13, false);
        this.lFromInstId = jceInputStream.read(this.lFromInstId, 14, false);
        if (cache_vRemarkOfSender == null) {
            cache_vRemarkOfSender = r0;
            byte[] bArr4 = {0};
        }
        this.vRemarkOfSender = jceInputStream.read(cache_vRemarkOfSender, 15, false);
        this.strFromMobile = jceInputStream.readString(16, false);
        this.strFromName = jceInputStream.readString(17, false);
        if (cache_vNickName == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vNickName = arrayList;
            arrayList.add("");
        }
        this.vNickName = (ArrayList) jceInputStream.read((JceInputStream) cache_vNickName, 18, false);
        if (cache_stC2CTmpMsgHead == null) {
            cache_stC2CTmpMsgHead = new TempMsgHead();
        }
        this.stC2CTmpMsgHead = (TempMsgHead) jceInputStream.read((JceStruct) cache_stC2CTmpMsgHead, 19, false);
    }

    public void setLFromInstId(long j3) {
        this.lFromInstId = j3;
    }

    public void setLFromUin(long j3) {
        this.lFromUin = j3;
    }

    public void setLLastChangeTime(long j3) {
        this.lLastChangeTime = j3;
    }

    public void setLMsgUid(long j3) {
        this.lMsgUid = j3;
    }

    public void setShMsgSeq(short s16) {
        this.shMsgSeq = s16;
    }

    public void setShMsgType(short s16) {
        this.shMsgType = s16;
    }

    public void setStShareData(shareData sharedata) {
        this.stShareData = sharedata;
    }

    public void setStrFromMobile(String str) {
        this.strFromMobile = str;
    }

    public void setStrFromName(String str) {
        this.strFromName = str;
    }

    public void setStrMsg(String str) {
        this.strMsg = str;
    }

    public void setUAppShareID(long j3) {
        this.uAppShareID = j3;
    }

    public void setUMsgTime(long j3) {
        this.uMsgTime = j3;
    }

    public void setURealMsgTime(int i3) {
        this.uRealMsgTime = i3;
    }

    public void setVAppShareCookie(byte[] bArr) {
        this.vAppShareCookie = bArr;
    }

    public void setVCPicInfo(ArrayList<CPicInfo> arrayList) {
        this.vCPicInfo = arrayList;
    }

    public void setVMsg(byte[] bArr) {
        this.vMsg = bArr;
    }

    public void setVMsgCookies(byte[] bArr) {
        this.vMsgCookies = bArr;
    }

    public void setVNickName(ArrayList<String> arrayList) {
        this.vNickName = arrayList;
    }

    public void setVRemarkOfSender(byte[] bArr) {
        this.vRemarkOfSender = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromUin, 0);
        jceOutputStream.write(this.uMsgTime, 1);
        jceOutputStream.write(this.shMsgType, 2);
        jceOutputStream.write(this.shMsgSeq, 3);
        jceOutputStream.write(this.strMsg, 4);
        jceOutputStream.write(this.uRealMsgTime, 5);
        byte[] bArr = this.vMsg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        jceOutputStream.write(this.uAppShareID, 7);
        byte[] bArr2 = this.vMsgCookies;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 8);
        }
        byte[] bArr3 = this.vAppShareCookie;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 9);
        }
        jceOutputStream.write(this.lMsgUid, 10);
        jceOutputStream.write(this.lLastChangeTime, 11);
        ArrayList<CPicInfo> arrayList = this.vCPicInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 12);
        }
        shareData sharedata = this.stShareData;
        if (sharedata != null) {
            jceOutputStream.write((JceStruct) sharedata, 13);
        }
        jceOutputStream.write(this.lFromInstId, 14);
        byte[] bArr4 = this.vRemarkOfSender;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 15);
        }
        String str = this.strFromMobile;
        if (str != null) {
            jceOutputStream.write(str, 16);
        }
        String str2 = this.strFromName;
        if (str2 != null) {
            jceOutputStream.write(str2, 17);
        }
        ArrayList<String> arrayList2 = this.vNickName;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 18);
        }
        TempMsgHead tempMsgHead = this.stC2CTmpMsgHead;
        if (tempMsgHead != null) {
            jceOutputStream.write((JceStruct) tempMsgHead, 19);
        }
    }

    public MsgInfo(long j3, long j16, short s16, short s17, String str, int i3, byte[] bArr, long j17, byte[] bArr2, byte[] bArr3, long j18, long j19, ArrayList<CPicInfo> arrayList, shareData sharedata, long j26, byte[] bArr4, String str2, String str3, ArrayList<String> arrayList2, TempMsgHead tempMsgHead) {
        this.lFromUin = j3;
        this.uMsgTime = j16;
        this.shMsgType = s16;
        this.shMsgSeq = s17;
        this.strMsg = str;
        this.uRealMsgTime = i3;
        this.vMsg = bArr;
        this.uAppShareID = j17;
        this.vMsgCookies = bArr2;
        this.vAppShareCookie = bArr3;
        this.lMsgUid = j18;
        this.lLastChangeTime = j19;
        this.vCPicInfo = arrayList;
        this.stShareData = sharedata;
        this.lFromInstId = j26;
        this.vRemarkOfSender = bArr4;
        this.strFromMobile = str2;
        this.strFromName = str3;
        this.vNickName = arrayList2;
        this.stC2CTmpMsgHead = tempMsgHead;
    }
}
