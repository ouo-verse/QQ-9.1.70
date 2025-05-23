package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class WeChatOcrBox {

    /* renamed from: pt1, reason: collision with root package name */
    public OCRPoint f359243pt1;

    /* renamed from: pt2, reason: collision with root package name */
    public OCRPoint f359244pt2;

    /* renamed from: pt3, reason: collision with root package name */
    public OCRPoint f359245pt3;

    /* renamed from: pt4, reason: collision with root package name */
    public OCRPoint f359246pt4;

    public WeChatOcrBox() {
        this.f359243pt1 = new OCRPoint();
        this.f359244pt2 = new OCRPoint();
        this.f359245pt3 = new OCRPoint();
        this.f359246pt4 = new OCRPoint();
    }

    public OCRPoint getPt1() {
        return this.f359243pt1;
    }

    public OCRPoint getPt2() {
        return this.f359244pt2;
    }

    public OCRPoint getPt3() {
        return this.f359245pt3;
    }

    public OCRPoint getPt4() {
        return this.f359246pt4;
    }

    public String toString() {
        return "WeChatOcrBox{pt1=" + this.f359243pt1 + ",pt2=" + this.f359244pt2 + ",pt3=" + this.f359245pt3 + ",pt4=" + this.f359246pt4 + ",}";
    }

    public WeChatOcrBox(OCRPoint oCRPoint, OCRPoint oCRPoint2, OCRPoint oCRPoint3, OCRPoint oCRPoint4) {
        this.f359243pt1 = new OCRPoint();
        this.f359244pt2 = new OCRPoint();
        this.f359245pt3 = new OCRPoint();
        new OCRPoint();
        this.f359243pt1 = oCRPoint;
        this.f359244pt2 = oCRPoint2;
        this.f359245pt3 = oCRPoint3;
        this.f359246pt4 = oCRPoint4;
    }
}
