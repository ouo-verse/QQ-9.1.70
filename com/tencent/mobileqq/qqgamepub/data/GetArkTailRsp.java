package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class GetArkTailRsp extends JceStruct {
    static ArrayList<String> cache_icon_list;
    public int style = 0;
    public int type = 0;
    public int subType = 0;
    public String icon = "";
    public String title = "";
    public int num = 0;
    public int value = 0;
    public ArrayList<String> iconList = null;
    public String desc = "";
    public String jumpUrl = "";

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_icon_list = arrayList;
        arrayList.add("");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.style = jceInputStream.read(this.style, 0, false);
        this.type = jceInputStream.read(this.type, 1, false);
        this.subType = jceInputStream.read(this.subType, 2, false);
        this.icon = jceInputStream.readString(3, false);
        this.title = jceInputStream.readString(4, false);
        this.num = jceInputStream.read(this.num, 5, false);
        this.value = jceInputStream.read(this.value, 6, false);
        this.iconList = (ArrayList) jceInputStream.read((JceInputStream) cache_icon_list, 7, false);
        this.desc = jceInputStream.readString(8, false);
        this.jumpUrl = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.style, 0);
        jceOutputStream.write(this.type, 1);
        jceOutputStream.write(this.subType, 2);
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.num, 5);
        jceOutputStream.write(this.value, 6);
        ArrayList<String> arrayList = this.iconList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 7);
        }
        String str3 = this.desc;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.jumpUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
    }
}
