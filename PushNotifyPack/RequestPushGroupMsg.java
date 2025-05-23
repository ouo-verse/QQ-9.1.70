package PushNotifyPack;

import QQService.shareData;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RequestPushGroupMsg extends JceStruct {
    static GroupMsgHead cache_stGroupMsgHead;
    static shareData cache_stShareData;
    static byte[] cache_vAppShareCookie;
    static ArrayList<GPicInfo> cache_vGPicInfo;
    static ArrayList<MarketFaceInfo> cache_vMarketFace;
    static byte[] cache_vMsg;
    public byte cGroupType;
    public byte cType;
    public long lFromInstId;
    public long lGroupCode;
    public long lInfoSeq;
    public long lSendUin;
    public long lUin;
    public long lsMsgSeq;
    public short shMsgLen;
    public GroupMsgHead stGroupMsgHead;
    public shareData stShareData;
    public String strCmd;
    public String strGroupCard;
    public String strService;
    public long uAppShareID;
    public int uMsgTime;
    public long uSuperQQBubbleId;
    public byte[] vAppShareCookie;
    public ArrayList<GPicInfo> vGPicInfo;
    public ArrayList<MarketFaceInfo> vMarketFace;
    public byte[] vMsg;
    public int wUserActive;

    public RequestPushGroupMsg() {
        this.lUin = 0L;
        this.cType = (byte) 0;
        this.strService = "";
        this.strCmd = "";
        this.lGroupCode = 0L;
        this.cGroupType = (byte) 0;
        this.lSendUin = 0L;
        this.lsMsgSeq = 0L;
        this.uMsgTime = 0;
        this.lInfoSeq = 0L;
        this.shMsgLen = (short) 0;
        this.vMsg = null;
        this.strGroupCard = "";
        this.uAppShareID = 0L;
        this.vGPicInfo = null;
        this.vAppShareCookie = null;
        this.stShareData = null;
        this.lFromInstId = 0L;
        this.stGroupMsgHead = null;
        this.wUserActive = 0;
        this.vMarketFace = null;
        this.uSuperQQBubbleId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.cType = jceInputStream.read(this.cType, 1, true);
        this.strService = jceInputStream.readString(2, true);
        this.strCmd = jceInputStream.readString(3, true);
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 4, true);
        this.cGroupType = jceInputStream.read(this.cGroupType, 5, true);
        this.lSendUin = jceInputStream.read(this.lSendUin, 6, true);
        this.lsMsgSeq = jceInputStream.read(this.lsMsgSeq, 7, true);
        this.uMsgTime = jceInputStream.read(this.uMsgTime, 8, true);
        this.lInfoSeq = jceInputStream.read(this.lInfoSeq, 9, true);
        this.shMsgLen = jceInputStream.read(this.shMsgLen, 10, true);
        if (cache_vMsg == null) {
            cache_vMsg = r0;
            byte[] bArr = {0};
        }
        this.vMsg = jceInputStream.read(cache_vMsg, 11, true);
        this.strGroupCard = jceInputStream.readString(12, false);
        this.uAppShareID = jceInputStream.read(this.uAppShareID, 13, false);
        if (cache_vGPicInfo == null) {
            cache_vGPicInfo = new ArrayList<>();
            cache_vGPicInfo.add(new GPicInfo());
        }
        this.vGPicInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vGPicInfo, 14, false);
        if (cache_vAppShareCookie == null) {
            cache_vAppShareCookie = r0;
            byte[] bArr2 = {0};
        }
        this.vAppShareCookie = jceInputStream.read(cache_vAppShareCookie, 15, false);
        if (cache_stShareData == null) {
            cache_stShareData = new shareData();
        }
        this.stShareData = (shareData) jceInputStream.read((JceStruct) cache_stShareData, 16, false);
        this.lFromInstId = jceInputStream.read(this.lFromInstId, 17, false);
        if (cache_stGroupMsgHead == null) {
            cache_stGroupMsgHead = new GroupMsgHead();
        }
        this.stGroupMsgHead = (GroupMsgHead) jceInputStream.read((JceStruct) cache_stGroupMsgHead, 18, false);
        this.wUserActive = jceInputStream.read(this.wUserActive, 19, false);
        if (cache_vMarketFace == null) {
            cache_vMarketFace = new ArrayList<>();
            cache_vMarketFace.add(new MarketFaceInfo());
        }
        this.vMarketFace = (ArrayList) jceInputStream.read((JceInputStream) cache_vMarketFace, 20, false);
        this.uSuperQQBubbleId = jceInputStream.read(this.uSuperQQBubbleId, 21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.cType, 1);
        jceOutputStream.write(this.strService, 2);
        jceOutputStream.write(this.strCmd, 3);
        jceOutputStream.write(this.lGroupCode, 4);
        jceOutputStream.write(this.cGroupType, 5);
        jceOutputStream.write(this.lSendUin, 6);
        jceOutputStream.write(this.lsMsgSeq, 7);
        jceOutputStream.write(this.uMsgTime, 8);
        jceOutputStream.write(this.lInfoSeq, 9);
        jceOutputStream.write(this.shMsgLen, 10);
        jceOutputStream.write(this.vMsg, 11);
        String str = this.strGroupCard;
        if (str != null) {
            jceOutputStream.write(str, 12);
        }
        jceOutputStream.write(this.uAppShareID, 13);
        ArrayList<GPicInfo> arrayList = this.vGPicInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 14);
        }
        byte[] bArr = this.vAppShareCookie;
        if (bArr != null) {
            jceOutputStream.write(bArr, 15);
        }
        shareData sharedata = this.stShareData;
        if (sharedata != null) {
            jceOutputStream.write((JceStruct) sharedata, 16);
        }
        jceOutputStream.write(this.lFromInstId, 17);
        GroupMsgHead groupMsgHead = this.stGroupMsgHead;
        if (groupMsgHead != null) {
            jceOutputStream.write((JceStruct) groupMsgHead, 18);
        }
        jceOutputStream.write(this.wUserActive, 19);
        ArrayList<MarketFaceInfo> arrayList2 = this.vMarketFace;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 20);
        }
        jceOutputStream.write(this.uSuperQQBubbleId, 21);
    }

    public RequestPushGroupMsg(long j3, byte b16, String str, String str2, long j16, byte b17, long j17, long j18, int i3, long j19, short s16, byte[] bArr, String str3, long j26, ArrayList<GPicInfo> arrayList, byte[] bArr2, shareData sharedata, long j27, GroupMsgHead groupMsgHead, int i16, ArrayList<MarketFaceInfo> arrayList2, long j28) {
        this.lUin = j3;
        this.cType = b16;
        this.strService = str;
        this.strCmd = str2;
        this.lGroupCode = j16;
        this.cGroupType = b17;
        this.lSendUin = j17;
        this.lsMsgSeq = j18;
        this.uMsgTime = i3;
        this.lInfoSeq = j19;
        this.shMsgLen = s16;
        this.vMsg = bArr;
        this.strGroupCard = str3;
        this.uAppShareID = j26;
        this.vGPicInfo = arrayList;
        this.vAppShareCookie = bArr2;
        this.stShareData = sharedata;
        this.lFromInstId = j27;
        this.stGroupMsgHead = groupMsgHead;
        this.wUserActive = i16;
        this.vMarketFace = arrayList2;
        this.uSuperQQBubbleId = j28;
    }
}
