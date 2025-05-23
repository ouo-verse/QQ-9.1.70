package com.qwallet.protocol.Wallet.OpenPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class RespGetPuinInfo extends JceStruct {
    static ArrayList<PuinInfo> cache_vPuinInfo = new ArrayList<>();
    static ArrayList<PuinInfoV2> cache_vPuinInfoV2;
    public int ret = 0;
    public String errMsg = "";

    /* renamed from: st, reason: collision with root package name */
    public long f41685st = 0;
    public ArrayList<PuinInfo> vPuinInfo = null;
    public ArrayList<PuinInfoV2> vPuinInfoV2 = null;

    static {
        cache_vPuinInfo.add(new PuinInfo());
        cache_vPuinInfoV2 = new ArrayList<>();
        cache_vPuinInfoV2.add(new PuinInfoV2());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.errMsg = jceInputStream.readString(1, false);
        this.f41685st = jceInputStream.read(this.f41685st, 2, false);
        this.vPuinInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vPuinInfo, 3, false);
        this.vPuinInfoV2 = (ArrayList) jceInputStream.read((JceInputStream) cache_vPuinInfoV2, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.errMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.f41685st, 2);
        ArrayList<PuinInfo> arrayList = this.vPuinInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<PuinInfoV2> arrayList2 = this.vPuinInfoV2;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }
}
