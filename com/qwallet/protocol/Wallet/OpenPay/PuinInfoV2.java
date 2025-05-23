package com.qwallet.protocol.Wallet.OpenPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class PuinInfoV2 extends JceStruct {
    static ArrayList<bargainor> cache_bargainorList = new ArrayList<>();
    public long uin = 0;
    public String logo = "";
    public String attentionTips = "";
    public ArrayList<bargainor> bargainorList = null;
    public String name = "";
    public String newAttentionTips = "";

    static {
        cache_bargainorList.add(new bargainor());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, false);
        this.logo = jceInputStream.readString(1, false);
        this.attentionTips = jceInputStream.readString(2, false);
        this.bargainorList = (ArrayList) jceInputStream.read((JceInputStream) cache_bargainorList, 3, false);
        this.name = jceInputStream.readString(4, false);
        this.newAttentionTips = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        String str = this.logo;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.attentionTips;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<bargainor> arrayList = this.bargainorList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str3 = this.name;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.newAttentionTips;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
    }
}
