package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class material_get_my_item_rsp extends JceStruct {
    static MaterialUserInfo cache_stUserItemInfo = new MaterialUserInfo();
    public int iCode;
    public MaterialUserInfo stUserItemInfo;
    public String strErrMsg;

    public material_get_my_item_rsp() {
        this.iCode = 0;
        this.stUserItemInfo = null;
        this.strErrMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, true);
        this.stUserItemInfo = (MaterialUserInfo) jceInputStream.read((JceStruct) cache_stUserItemInfo, 1, true);
        this.strErrMsg = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        jceOutputStream.write((JceStruct) this.stUserItemInfo, 1);
        String str = this.strErrMsg;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
    }

    public material_get_my_item_rsp(int i3, MaterialUserInfo materialUserInfo, String str) {
        this.iCode = i3;
        this.stUserItemInfo = materialUserInfo;
        this.strErrMsg = str;
    }
}
