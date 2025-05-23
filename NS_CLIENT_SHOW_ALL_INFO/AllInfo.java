package NS_CLIENT_SHOW_ALL_INFO;

import NS_COMM_VIP_GROWTH.SearchClientShowInfoRsp;
import SWEET_NEW_COMM_SVR.guest_mainpage_rsp;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AllInfo extends JceStruct {
    static byte[] cache_DynamicNickModuleRsp;
    static byte[] cache_vecQQBigVipInfo;
    static byte[] cache_vecSweetStyleInfo;
    public byte[] DynamicNickModuleRsp;
    public guest_mainpage_rsp stGuestMainpageRsp;
    public SearchClientShowInfoRsp stYellowVipInfo;
    public byte[] vecQQBigVipInfo;
    public byte[] vecSweetStyleInfo;
    static SearchClientShowInfoRsp cache_stYellowVipInfo = new SearchClientShowInfoRsp();
    static guest_mainpage_rsp cache_stGuestMainpageRsp = new guest_mainpage_rsp();

    static {
        cache_vecQQBigVipInfo = r1;
        byte[] bArr = {0};
        cache_vecSweetStyleInfo = r1;
        byte[] bArr2 = {0};
        cache_DynamicNickModuleRsp = r0;
        byte[] bArr3 = {0};
    }

    public AllInfo() {
        this.vecQQBigVipInfo = null;
        this.stYellowVipInfo = null;
        this.stGuestMainpageRsp = null;
        this.vecSweetStyleInfo = null;
        this.DynamicNickModuleRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecQQBigVipInfo = jceInputStream.read(cache_vecQQBigVipInfo, 0, false);
        this.stYellowVipInfo = (SearchClientShowInfoRsp) jceInputStream.read((JceStruct) cache_stYellowVipInfo, 1, false);
        this.stGuestMainpageRsp = (guest_mainpage_rsp) jceInputStream.read((JceStruct) cache_stGuestMainpageRsp, 2, false);
        this.vecSweetStyleInfo = jceInputStream.read(cache_vecSweetStyleInfo, 3, false);
        this.DynamicNickModuleRsp = jceInputStream.read(cache_DynamicNickModuleRsp, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vecQQBigVipInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        SearchClientShowInfoRsp searchClientShowInfoRsp = this.stYellowVipInfo;
        if (searchClientShowInfoRsp != null) {
            jceOutputStream.write((JceStruct) searchClientShowInfoRsp, 1);
        }
        guest_mainpage_rsp guest_mainpage_rspVar = this.stGuestMainpageRsp;
        if (guest_mainpage_rspVar != null) {
            jceOutputStream.write((JceStruct) guest_mainpage_rspVar, 2);
        }
        byte[] bArr2 = this.vecSweetStyleInfo;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 3);
        }
        byte[] bArr3 = this.DynamicNickModuleRsp;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 4);
        }
    }

    public AllInfo(byte[] bArr, SearchClientShowInfoRsp searchClientShowInfoRsp, guest_mainpage_rsp guest_mainpage_rspVar, byte[] bArr2, byte[] bArr3) {
        this.vecQQBigVipInfo = bArr;
        this.stYellowVipInfo = searchClientShowInfoRsp;
        this.stGuestMainpageRsp = guest_mainpage_rspVar;
        this.vecSweetStyleInfo = bArr2;
        this.DynamicNickModuleRsp = bArr3;
    }
}
