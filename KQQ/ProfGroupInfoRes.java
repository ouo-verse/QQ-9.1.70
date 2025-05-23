package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class ProfGroupInfoRes extends JceStruct {
    static ArrayList<GroupMemberFlag> cache_vAdministrator;
    static ArrayList<String> cache_vsUrl;
    public byte cAlbumResult;
    public byte cInviteSwitchOpen;
    public byte cResult;
    public long dwFlagExt;
    public long dwTimeStamp;
    public String sAuthGrpInfo;
    public String sFingerGroupMemo;
    public String sGroupLocation;
    public String sGroupMemo;
    public String sGroupName;
    public long uGroupCode;
    public long uGroupOwnerUin;
    public long uGroupUin;
    public ArrayList<GroupMemberFlag> vAdministrator;
    public ArrayList<String> vsUrl;
    public short wGroupFace;

    public ProfGroupInfoRes() {
        this.cResult = (byte) 0;
        this.uGroupUin = 0L;
        this.uGroupCode = 0L;
        this.uGroupOwnerUin = 0L;
        this.sGroupName = "";
        this.wGroupFace = (short) 0;
        this.sGroupMemo = "";
        this.sFingerGroupMemo = "";
        this.vAdministrator = null;
        this.cAlbumResult = (byte) -1;
        this.dwTimeStamp = 0L;
        this.vsUrl = null;
        this.sGroupLocation = "";
        this.cInviteSwitchOpen = (byte) 0;
        this.dwFlagExt = 0L;
        this.sAuthGrpInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cResult = jceInputStream.read(this.cResult, 0, true);
        this.uGroupUin = jceInputStream.read(this.uGroupUin, 1, true);
        this.uGroupCode = jceInputStream.read(this.uGroupCode, 2, true);
        this.uGroupOwnerUin = jceInputStream.read(this.uGroupOwnerUin, 3, true);
        this.sGroupName = jceInputStream.readString(4, true);
        this.wGroupFace = jceInputStream.read(this.wGroupFace, 5, true);
        this.sGroupMemo = jceInputStream.readString(6, true);
        this.sFingerGroupMemo = jceInputStream.readString(7, true);
        if (cache_vAdministrator == null) {
            cache_vAdministrator = new ArrayList<>();
            cache_vAdministrator.add(new GroupMemberFlag());
        }
        this.vAdministrator = (ArrayList) jceInputStream.read((JceInputStream) cache_vAdministrator, 8, false);
        this.cAlbumResult = jceInputStream.read(this.cAlbumResult, 9, false);
        this.dwTimeStamp = jceInputStream.read(this.dwTimeStamp, 10, false);
        if (cache_vsUrl == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vsUrl = arrayList;
            arrayList.add("");
        }
        this.vsUrl = (ArrayList) jceInputStream.read((JceInputStream) cache_vsUrl, 11, false);
        this.sGroupLocation = jceInputStream.readString(12, false);
        this.cInviteSwitchOpen = jceInputStream.read(this.cInviteSwitchOpen, 13, false);
        this.dwFlagExt = jceInputStream.read(this.dwFlagExt, 14, false);
        this.sAuthGrpInfo = jceInputStream.readString(15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cResult, 0);
        jceOutputStream.write(this.uGroupUin, 1);
        jceOutputStream.write(this.uGroupCode, 2);
        jceOutputStream.write(this.uGroupOwnerUin, 3);
        jceOutputStream.write(this.sGroupName, 4);
        jceOutputStream.write(this.wGroupFace, 5);
        jceOutputStream.write(this.sGroupMemo, 6);
        jceOutputStream.write(this.sFingerGroupMemo, 7);
        ArrayList<GroupMemberFlag> arrayList = this.vAdministrator;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 8);
        }
        jceOutputStream.write(this.cAlbumResult, 9);
        jceOutputStream.write(this.dwTimeStamp, 10);
        ArrayList<String> arrayList2 = this.vsUrl;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 11);
        }
        String str = this.sGroupLocation;
        if (str != null) {
            jceOutputStream.write(str, 12);
        }
        jceOutputStream.write(this.cInviteSwitchOpen, 13);
        jceOutputStream.write(this.dwFlagExt, 14);
        String str2 = this.sAuthGrpInfo;
        if (str2 != null) {
            jceOutputStream.write(str2, 15);
        }
    }

    public ProfGroupInfoRes(byte b16, long j3, long j16, long j17, String str, short s16, String str2, String str3, ArrayList<GroupMemberFlag> arrayList, byte b17, long j18, ArrayList<String> arrayList2, String str4, byte b18, long j19, String str5) {
        this.cResult = b16;
        this.uGroupUin = j3;
        this.uGroupCode = j16;
        this.uGroupOwnerUin = j17;
        this.sGroupName = str;
        this.wGroupFace = s16;
        this.sGroupMemo = str2;
        this.sFingerGroupMemo = str3;
        this.vAdministrator = arrayList;
        this.cAlbumResult = b17;
        this.dwTimeStamp = j18;
        this.vsUrl = arrayList2;
        this.sGroupLocation = str4;
        this.cInviteSwitchOpen = b18;
        this.dwFlagExt = j19;
        this.sAuthGrpInfo = str5;
    }
}
