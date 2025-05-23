package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniSetRsp extends JceStruct {
    static ExtraActAidInfo cache_extraAid;
    static UiExtraAppInfo cache_extraappinfo;
    static UiExtraGameInfo cache_extragameinfo;
    static HamletCheck cache_stHamletItem = new HamletCheck();
    static ArrayList<Hamlet> cache_stHamletItemList = new ArrayList<>();
    public String errmsg;
    public ExtraActAidInfo extraAid;
    public UiExtraAppInfo extraappinfo;
    public UiExtraGameInfo extragameinfo;
    public int feetype;
    public int ret;
    public HamletCheck stHamletItem;
    public ArrayList<Hamlet> stHamletItemList;
    public String url;
    public int validDay;

    static {
        cache_stHamletItemList.add(new Hamlet());
        cache_extraAid = new ExtraActAidInfo();
        cache_extraappinfo = new UiExtraAppInfo();
        cache_extragameinfo = new UiExtraGameInfo();
    }

    public UniSetRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.stHamletItem = null;
        this.url = "";
        this.stHamletItemList = null;
        this.feetype = 0;
        this.validDay = 0;
        this.extraAid = null;
        this.extraappinfo = null;
        this.extragameinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.stHamletItem = (HamletCheck) jceInputStream.read((JceStruct) cache_stHamletItem, 2, false);
        this.url = jceInputStream.readString(3, false);
        this.stHamletItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_stHamletItemList, 4, false);
        this.feetype = jceInputStream.read(this.feetype, 5, false);
        this.validDay = jceInputStream.read(this.validDay, 6, false);
        this.extraAid = (ExtraActAidInfo) jceInputStream.read((JceStruct) cache_extraAid, 7, false);
        this.extraappinfo = (UiExtraAppInfo) jceInputStream.read((JceStruct) cache_extraappinfo, 8, false);
        this.extragameinfo = (UiExtraGameInfo) jceInputStream.read((JceStruct) cache_extragameinfo, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        HamletCheck hamletCheck = this.stHamletItem;
        if (hamletCheck != null) {
            jceOutputStream.write((JceStruct) hamletCheck, 2);
        }
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        ArrayList<Hamlet> arrayList = this.stHamletItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.feetype, 5);
        jceOutputStream.write(this.validDay, 6);
        ExtraActAidInfo extraActAidInfo = this.extraAid;
        if (extraActAidInfo != null) {
            jceOutputStream.write((JceStruct) extraActAidInfo, 7);
        }
        UiExtraAppInfo uiExtraAppInfo = this.extraappinfo;
        if (uiExtraAppInfo != null) {
            jceOutputStream.write((JceStruct) uiExtraAppInfo, 8);
        }
        UiExtraGameInfo uiExtraGameInfo = this.extragameinfo;
        if (uiExtraGameInfo != null) {
            jceOutputStream.write((JceStruct) uiExtraGameInfo, 9);
        }
    }

    public UniSetRsp(int i3, String str, HamletCheck hamletCheck, String str2, ArrayList<Hamlet> arrayList, int i16, int i17, ExtraActAidInfo extraActAidInfo, UiExtraAppInfo uiExtraAppInfo, UiExtraGameInfo uiExtraGameInfo) {
        this.ret = i3;
        this.errmsg = str;
        this.stHamletItem = hamletCheck;
        this.url = str2;
        this.stHamletItemList = arrayList;
        this.feetype = i16;
        this.validDay = i17;
        this.extraAid = extraActAidInfo;
        this.extraappinfo = uiExtraAppInfo;
        this.extragameinfo = uiExtraGameInfo;
    }
}
