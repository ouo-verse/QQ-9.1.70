package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetSuixintieSigFontRsp extends JceStruct {
    static CommonRsp cache_stRet = new CommonRsp();
    static ArrayList<UniBusiSimpleItemDetail> cache_vItems = new ArrayList<>();
    public int isEnd;
    public CommonRsp stRet;
    public String strAttachInfo;
    public ArrayList<UniBusiSimpleItemDetail> vItems;

    static {
        cache_vItems.add(new UniBusiSimpleItemDetail());
    }

    public GetSuixintieSigFontRsp() {
        this.stRet = null;
        this.vItems = null;
        this.strAttachInfo = "";
        this.isEnd = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stRet = (CommonRsp) jceInputStream.read((JceStruct) cache_stRet, 0, false);
        this.vItems = (ArrayList) jceInputStream.read((JceInputStream) cache_vItems, 1, false);
        this.strAttachInfo = jceInputStream.readString(2, false);
        this.isEnd = jceInputStream.read(this.isEnd, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonRsp commonRsp = this.stRet;
        if (commonRsp != null) {
            jceOutputStream.write((JceStruct) commonRsp, 0);
        }
        ArrayList<UniBusiSimpleItemDetail> arrayList = this.vItems;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.strAttachInfo;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.isEnd, 3);
    }

    public GetSuixintieSigFontRsp(CommonRsp commonRsp, ArrayList<UniBusiSimpleItemDetail> arrayList, String str, int i3) {
        this.stRet = commonRsp;
        this.vItems = arrayList;
        this.strAttachInfo = str;
        this.isEnd = i3;
    }
}
