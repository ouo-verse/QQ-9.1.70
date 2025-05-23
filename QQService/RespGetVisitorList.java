package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetVisitorList extends JceStruct {
    static RespHead cache_stHeader;
    static UserCntlData cache_stUserData;
    static ArrayList<UserProfile> cache_vEncounterInfos;
    public long RespTime;
    public RespHead stHeader;
    public UserCntlData stUserData;
    public ArrayList<UserProfile> vEncounterInfos;

    public RespGetVisitorList() {
        this.stHeader = null;
        this.RespTime = 0L;
        this.vEncounterInfos = null;
        this.stUserData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.RespTime = jceInputStream.read(this.RespTime, 1, true);
        if (cache_vEncounterInfos == null) {
            cache_vEncounterInfos = new ArrayList<>();
            cache_vEncounterInfos.add(new UserProfile());
        }
        this.vEncounterInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vEncounterInfos, 2, false);
        if (cache_stUserData == null) {
            cache_stUserData = new UserCntlData();
        }
        this.stUserData = (UserCntlData) jceInputStream.read((JceStruct) cache_stUserData, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.RespTime, 1);
        ArrayList<UserProfile> arrayList = this.vEncounterInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        UserCntlData userCntlData = this.stUserData;
        if (userCntlData != null) {
            jceOutputStream.write((JceStruct) userCntlData, 3);
        }
    }

    public RespGetVisitorList(RespHead respHead, long j3, ArrayList<UserProfile> arrayList, UserCntlData userCntlData) {
        this.stHeader = respHead;
        this.RespTime = j3;
        this.vEncounterInfos = arrayList;
        this.stUserData = userCntlData;
    }
}
