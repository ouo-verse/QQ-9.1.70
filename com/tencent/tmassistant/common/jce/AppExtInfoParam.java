package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes26.dex */
public final class AppExtInfoParam extends JceStruct {
    static ArrayList<String> cache_targetFileNameList;
    public int flag;
    public String oftenUsedPath;
    public ArrayList<String> targetFileNameList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_targetFileNameList = arrayList;
        arrayList.add("");
    }

    public AppExtInfoParam() {
        this.flag = 0;
        this.oftenUsedPath = "";
        this.targetFileNameList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.flag = jceInputStream.read(this.flag, 0, false);
        this.oftenUsedPath = jceInputStream.readString(1, false);
        this.targetFileNameList = (ArrayList) jceInputStream.read((JceInputStream) cache_targetFileNameList, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.flag, 0);
        String str = this.oftenUsedPath;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<String> arrayList = this.targetFileNameList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public AppExtInfoParam(int i3, String str, ArrayList<String> arrayList) {
        this.flag = i3;
        this.oftenUsedPath = str;
        this.targetFileNameList = arrayList;
    }
}
