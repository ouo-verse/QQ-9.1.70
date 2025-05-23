package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class LbsReportInfo extends Entity {
    public float accuracy;
    public double alt;
    public String businessTag;
    public String city;
    public String content;
    public String district;
    public double lat;
    public double lng;
    public String nation;
    public long operTime;
    public String province;

    public static ArrayList<String> convert2StrList(ArrayList<LbsReportInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<LbsReportInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                LbsReportInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.content)) {
                    arrayList2.add(next.content);
                }
            }
            return arrayList2;
        }
        return null;
    }

    public void compatible() {
        if (TextUtils.isEmpty(this.businessTag)) {
            if (QLog.isColorLevel()) {
                QLog.d("LbsReportInfo", 2, "\u5f00\u59cb\u8d70\u65e7\u7248LBS\u6570\u636e\u517c\u5bb9\u903b\u8f91");
            }
            if (!TextUtils.isEmpty(this.content)) {
                String[] split = this.content.split("\\|");
                if (split.length == 7) {
                    try {
                        this.operTime = Long.parseLong(split[0]);
                        this.lat = Double.parseDouble(split[1]);
                        this.lng = Double.parseDouble(split[2]);
                        this.alt = Double.parseDouble(split[3]);
                        this.accuracy = Float.parseFloat(split[4]);
                        this.businessTag = split[5];
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("LbsReportInfo", 2, e16, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    public void createContent() {
        this.content = this.operTime + "|" + this.lat + "|" + this.lng + "|" + this.alt + "|" + this.accuracy + "|" + this.businessTag + "|android";
    }
}
