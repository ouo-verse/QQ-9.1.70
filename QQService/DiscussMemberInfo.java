package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DiscussMemberInfo extends JceStruct {
    static Map<Integer, MemberAttrInfo> cache_Attr;
    static InteRemarkInfo cache_StInteRemark;
    public Map<Integer, MemberAttrInfo> Attr;
    public byte Flag;
    public InteRemarkInfo StInteRemark;
    public long Uin;

    public DiscussMemberInfo() {
        this.Uin = 0L;
        this.Flag = (byte) 0;
        this.Attr = null;
        this.StInteRemark = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Uin = jceInputStream.read(this.Uin, 0, true);
        this.Flag = jceInputStream.read(this.Flag, 1, true);
        if (cache_Attr == null) {
            cache_Attr = new HashMap();
            cache_Attr.put(0, new MemberAttrInfo());
        }
        this.Attr = (Map) jceInputStream.read((JceInputStream) cache_Attr, 2, false);
        if (cache_StInteRemark == null) {
            cache_StInteRemark = new InteRemarkInfo();
        }
        this.StInteRemark = (InteRemarkInfo) jceInputStream.read((JceStruct) cache_StInteRemark, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Uin, 0);
        jceOutputStream.write(this.Flag, 1);
        Map<Integer, MemberAttrInfo> map = this.Attr;
        if (map != null) {
            jceOutputStream.write((Map) map, 2);
        }
        InteRemarkInfo inteRemarkInfo = this.StInteRemark;
        if (inteRemarkInfo != null) {
            jceOutputStream.write((JceStruct) inteRemarkInfo, 3);
        }
    }

    public DiscussMemberInfo(long j3, byte b16, Map<Integer, MemberAttrInfo> map, InteRemarkInfo inteRemarkInfo) {
        this.Uin = j3;
        this.Flag = b16;
        this.Attr = map;
        this.StInteRemark = inteRemarkInfo;
    }
}
