package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.Reporting;

/* loaded from: classes32.dex */
public class PAReportInfo extends Entity implements Cloneable {
    public String actionName;
    public int count;
    public int fromType;
    public String mainAction;
    public String msgIds;

    /* renamed from: r2, reason: collision with root package name */
    public String f80162r2;

    /* renamed from: r3, reason: collision with root package name */
    public String f80163r3;

    /* renamed from: r4, reason: collision with root package name */
    public String f80164r4;
    public int result;
    public String subAction;
    public String tag;
    public String toUin;

    public PAReportInfo() {
    }

    public PAReportInfo(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        this.actionName = str5;
        this.count = i16;
        this.fromType = i3;
        this.mainAction = str2;
        this.f80162r2 = str6;
        this.f80163r3 = str7;
        this.f80164r4 = str8;
        this.msgIds = str9;
        this.result = i17;
        this.subAction = str4;
        this.tag = str;
        this.toUin = str3;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Reporting m100clone() {
        try {
            return (Reporting) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
