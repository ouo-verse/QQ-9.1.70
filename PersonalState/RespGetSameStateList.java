package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetSameStateList extends JceStruct {
    static BusiRespHead cache_oHead;
    static byte[] cache_vCookie;
    static ArrayList<UserProfile> cache_vUserInfos;
    public BusiRespHead oHead;
    public byte[] vCookie;
    public ArrayList<UserProfile> vUserInfos;

    public RespGetSameStateList() {
        this.oHead = null;
        this.vCookie = null;
        this.vUserInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_oHead == null) {
            cache_oHead = new BusiRespHead();
        }
        this.oHead = (BusiRespHead) jceInputStream.read((JceStruct) cache_oHead, 0, true);
        if (cache_vCookie == null) {
            cache_vCookie = r0;
            byte[] bArr = {0};
        }
        this.vCookie = jceInputStream.read(cache_vCookie, 1, true);
        if (cache_vUserInfos == null) {
            cache_vUserInfos = new ArrayList<>();
            cache_vUserInfos.add(new UserProfile());
        }
        this.vUserInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vUserInfos, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.oHead, 0);
        jceOutputStream.write(this.vCookie, 1);
        ArrayList<UserProfile> arrayList = this.vUserInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public RespGetSameStateList(BusiRespHead busiRespHead, byte[] bArr, ArrayList<UserProfile> arrayList) {
        this.oHead = busiRespHead;
        this.vCookie = bArr;
        this.vUserInfos = arrayList;
    }
}
