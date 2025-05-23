package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class WeChatOCRResultLine {
    public ArrayList<WeChatOCRResultChar> charBox;

    /* renamed from: pt1, reason: collision with root package name */
    public OCRPoint f359239pt1;

    /* renamed from: pt2, reason: collision with root package name */
    public OCRPoint f359240pt2;

    /* renamed from: pt3, reason: collision with root package name */
    public OCRPoint f359241pt3;

    /* renamed from: pt4, reason: collision with root package name */
    public OCRPoint f359242pt4;
    public String score;
    public String text;

    public WeChatOCRResultLine() {
        this.text = "";
        this.f359239pt1 = new OCRPoint();
        this.f359240pt2 = new OCRPoint();
        this.f359241pt3 = new OCRPoint();
        this.f359242pt4 = new OCRPoint();
        this.charBox = new ArrayList<>();
        this.score = "";
    }

    public ArrayList<WeChatOCRResultChar> getCharBox() {
        return this.charBox;
    }

    public OCRPoint getPt1() {
        return this.f359239pt1;
    }

    public OCRPoint getPt2() {
        return this.f359240pt2;
    }

    public OCRPoint getPt3() {
        return this.f359241pt3;
    }

    public OCRPoint getPt4() {
        return this.f359242pt4;
    }

    public String getScore() {
        return this.score;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "WeChatOCRResultLine{text=" + this.text + ",pt1=" + this.f359239pt1 + ",pt2=" + this.f359240pt2 + ",pt3=" + this.f359241pt3 + ",pt4=" + this.f359242pt4 + ",charBox=" + this.charBox + ",score=" + this.score + ",}";
    }

    public WeChatOCRResultLine(String str, OCRPoint oCRPoint, OCRPoint oCRPoint2, OCRPoint oCRPoint3, OCRPoint oCRPoint4, ArrayList<WeChatOCRResultChar> arrayList, String str2) {
        this.text = "";
        this.f359239pt1 = new OCRPoint();
        this.f359240pt2 = new OCRPoint();
        this.f359241pt3 = new OCRPoint();
        this.f359242pt4 = new OCRPoint();
        new ArrayList();
        this.text = str;
        this.f359239pt1 = oCRPoint;
        this.f359240pt2 = oCRPoint2;
        this.f359241pt3 = oCRPoint3;
        this.f359242pt4 = oCRPoint4;
        this.charBox = arrayList;
        this.score = str2;
    }
}
