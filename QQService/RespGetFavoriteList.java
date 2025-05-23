package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetFavoriteList extends JceStruct {
    static RespHead cache_stHeader;
    static UserCntlData cache_stUserData;
    static ArrayList<UserProfile> cache_vFavoriteInfos;
    static byte[] cache_vNotice;
    public long RespTime;
    public RespHead stHeader;
    public UserCntlData stUserData;
    public ArrayList<UserProfile> vFavoriteInfos;
    public byte[] vNotice;

    public RespGetFavoriteList() {
        this.stHeader = null;
        this.RespTime = 0L;
        this.vFavoriteInfos = null;
        this.stUserData = null;
        this.vNotice = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.RespTime = jceInputStream.read(this.RespTime, 1, true);
        if (cache_vFavoriteInfos == null) {
            cache_vFavoriteInfos = new ArrayList<>();
            cache_vFavoriteInfos.add(new UserProfile());
        }
        this.vFavoriteInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vFavoriteInfos, 2, false);
        if (cache_stUserData == null) {
            cache_stUserData = new UserCntlData();
        }
        this.stUserData = (UserCntlData) jceInputStream.read((JceStruct) cache_stUserData, 3, false);
        if (cache_vNotice == null) {
            cache_vNotice = r0;
            byte[] bArr = {0};
        }
        this.vNotice = jceInputStream.read(cache_vNotice, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.RespTime, 1);
        ArrayList<UserProfile> arrayList = this.vFavoriteInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        UserCntlData userCntlData = this.stUserData;
        if (userCntlData != null) {
            jceOutputStream.write((JceStruct) userCntlData, 3);
        }
        byte[] bArr = this.vNotice;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
    }

    public RespGetFavoriteList(RespHead respHead, long j3, ArrayList<UserProfile> arrayList, UserCntlData userCntlData, byte[] bArr) {
        this.stHeader = respHead;
        this.RespTime = j3;
        this.vFavoriteInfos = arrayList;
        this.stUserData = userCntlData;
        this.vNotice = bArr;
    }
}
