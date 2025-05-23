package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniBusiGetUserInfoRsp extends JceStruct {
    static ArrayList<UniBusiItemDetail> cache_uniBusiHistoryItemList;
    public String errmsg;
    public UniBusiItemDetail globalUsingItem;
    public int ret;
    public ArrayList<UniBusiItemDetail> uniBusiHistoryItemList;
    public ArrayList<UniBusiUsingItem> uniBusiUsingItemList;
    static UniBusiItemDetail cache_globalUsingItem = new UniBusiItemDetail();
    static ArrayList<UniBusiUsingItem> cache_uniBusiUsingItemList = new ArrayList<>();

    static {
        cache_uniBusiUsingItemList.add(new UniBusiUsingItem());
        cache_uniBusiHistoryItemList = new ArrayList<>();
        cache_uniBusiHistoryItemList.add(new UniBusiItemDetail());
    }

    public UniBusiGetUserInfoRsp() {
        this.ret = 0;
        this.errmsg = "";
        this.globalUsingItem = null;
        this.uniBusiUsingItemList = null;
        this.uniBusiHistoryItemList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errmsg = jceInputStream.readString(1, false);
        this.globalUsingItem = (UniBusiItemDetail) jceInputStream.read((JceStruct) cache_globalUsingItem, 2, false);
        this.uniBusiUsingItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_uniBusiUsingItemList, 3, false);
        this.uniBusiHistoryItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_uniBusiHistoryItemList, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errmsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        UniBusiItemDetail uniBusiItemDetail = this.globalUsingItem;
        if (uniBusiItemDetail != null) {
            jceOutputStream.write((JceStruct) uniBusiItemDetail, 2);
        }
        ArrayList<UniBusiUsingItem> arrayList = this.uniBusiUsingItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<UniBusiItemDetail> arrayList2 = this.uniBusiHistoryItemList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }

    public UniBusiGetUserInfoRsp(int i3, String str, UniBusiItemDetail uniBusiItemDetail, ArrayList<UniBusiUsingItem> arrayList, ArrayList<UniBusiItemDetail> arrayList2) {
        this.ret = i3;
        this.errmsg = str;
        this.globalUsingItem = uniBusiItemDetail;
        this.uniBusiUsingItemList = arrayList;
        this.uniBusiHistoryItemList = arrayList2;
    }
}
