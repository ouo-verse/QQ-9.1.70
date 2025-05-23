package com.tencent.ads.data;

import com.tencent.ads.utility.Utils;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdItem implements Serializable {
    private static final long serialVersionUID = -6140006143413875299L;

    /* renamed from: a, reason: collision with root package name */
    private transient String f61609a;

    /* renamed from: b, reason: collision with root package name */
    private String f61610b;

    /* renamed from: c, reason: collision with root package name */
    private String f61611c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f61612d;

    /* renamed from: e, reason: collision with root package name */
    private transient int f61613e;

    /* renamed from: f, reason: collision with root package name */
    private transient int f61614f;

    /* renamed from: g, reason: collision with root package name */
    private String f61615g;

    /* renamed from: h, reason: collision with root package name */
    private long f61616h;

    /* renamed from: i, reason: collision with root package name */
    private int f61617i;

    /* renamed from: j, reason: collision with root package name */
    private ReportItem f61618j;

    /* renamed from: k, reason: collision with root package name */
    private ReportItem[] f61619k;

    /* renamed from: l, reason: collision with root package name */
    private ReportItem[] f61620l;

    /* renamed from: m, reason: collision with root package name */
    private ReportClickItem[] f61621m;

    /* renamed from: n, reason: collision with root package name */
    private transient String f61622n;

    /* renamed from: o, reason: collision with root package name */
    private transient String f61623o;

    /* renamed from: p, reason: collision with root package name */
    private transient int f61624p;

    /* renamed from: q, reason: collision with root package name */
    private transient String f61625q;

    /* renamed from: r, reason: collision with root package name */
    private transient String f61626r;

    /* renamed from: s, reason: collision with root package name */
    private transient boolean f61627s;

    /* renamed from: t, reason: collision with root package name */
    private transient ArrayList f61628t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f61629u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList f61630v;

    /* renamed from: w, reason: collision with root package name */
    private int f61631w;

    public void addTimeList(long j3) {
        if (this.f61630v == null) {
            this.f61630v = new ArrayList();
        }
        this.f61630v.add(Long.valueOf(j3));
    }

    public void addUrl(String str) {
        if (this.f61628t == null) {
            this.f61628t = new ArrayList();
        }
        this.f61628t.add(str);
    }

    public String getClickTextDesc() {
        return this.f61626r;
    }

    public String getClickUrl() {
        return this.f61609a;
    }

    public String getControlParams() {
        return this.f61623o;
    }

    public int getDuration() {
        return this.f61617i;
    }

    public long getFileSize() {
        return this.f61616h;
    }

    public int getHeight() {
        return this.f61614f;
    }

    public int getLcount() {
        return this.f61624p;
    }

    public String getMd5() {
        return this.f61615g;
    }

    public String getOid() {
        return this.f61611c;
    }

    public String getOpenUrlType() {
        return this.f61625q;
    }

    public ReportClickItem[] getReportClickItems() {
        return this.f61621m;
    }

    public ReportItem getReportItem() {
        return this.f61618j;
    }

    public ReportItem[] getReportSdkItem() {
        return this.f61620l;
    }

    public ReportItem[] getReportUrlOther() {
        return this.f61619k;
    }

    public String getType() {
        return this.f61612d;
    }

    public ArrayList getUrlList() {
        return this.f61628t;
    }

    public String getVid() {
        return this.f61610b;
    }

    public int getWeight() {
        return this.f61631w;
    }

    public int getWidth() {
        return this.f61613e;
    }

    public boolean isClicked() {
        String str = this.f61622n;
        return str == null || !str.equalsIgnoreCase("Y");
    }

    public boolean isFullScreenClickable() {
        return this.f61627s;
    }

    public boolean isToday() {
        if (this.f61630v == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (i16 >= this.f61630v.size()) {
                return false;
            }
            if (currentTimeMillis >= ((Long) this.f61630v.get(i3)).longValue() && currentTimeMillis < ((Long) this.f61630v.get(i16)).longValue()) {
                return true;
            }
            i3 += 2;
        }
    }

    public boolean isTrueview() {
        return this.f61629u;
    }

    public void resetPingState() {
        ReportItem reportItem = this.f61618j;
        if (reportItem != null) {
            reportItem.a(false);
        }
        if (!Utils.isEmpty(this.f61619k)) {
            for (ReportItem reportItem2 : this.f61619k) {
                if (reportItem2 != null) {
                    reportItem2.a(false);
                }
            }
        }
        if (Utils.isEmpty(this.f61620l)) {
            return;
        }
        for (ReportItem reportItem3 : this.f61620l) {
            if (reportItem3 != null) {
                reportItem3.a(false);
            }
        }
    }

    public void setClickTextDesc(String str) {
        this.f61626r = str;
    }

    public void setClickUrl(String str) {
        this.f61609a = str;
    }

    public void setControlParams(String str) {
        this.f61623o = str;
    }

    public void setDuration(int i3) {
        this.f61617i = i3;
    }

    public void setFileSize(long j3) {
        this.f61616h = j3;
    }

    public void setFullScreenClickable(boolean z16) {
        this.f61627s = z16;
    }

    public void setHeight(int i3) {
        this.f61614f = i3;
    }

    public void setLcount(int i3) {
        this.f61624p = i3;
    }

    public void setMd5(String str) {
        this.f61615g = str;
    }

    public void setNoClick(String str) {
        this.f61622n = str;
    }

    public void setOid(String str) {
        this.f61611c = str;
    }

    public void setOpenUrlType(String str) {
        this.f61625q = str;
    }

    public void setReportClickItems(ReportClickItem[] reportClickItemArr) {
        this.f61621m = reportClickItemArr;
    }

    public void setReportItem(ReportItem reportItem) {
        this.f61618j = reportItem;
    }

    public void setReportSdkItem(ReportItem[] reportItemArr) {
        this.f61620l = reportItemArr;
    }

    public void setReportUrlOther(ReportItem[] reportItemArr) {
        this.f61619k = reportItemArr;
    }

    public void setTrueview(boolean z16) {
        this.f61629u = z16;
    }

    public void setType(String str) {
        this.f61612d = str;
    }

    public void setUrlList(ArrayList arrayList) {
        this.f61628t = arrayList;
    }

    public void setVid(String str) {
        this.f61610b = str;
    }

    public void setWeight(int i3) {
        this.f61631w = i3;
    }

    public void setWidth(int i3) {
        this.f61613e = i3;
    }
}
