package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class template_gift_item extends JceStruct {
    static text_region cache_textRegion;
    public String backgroundImg;
    public boolean canDIY;
    public String defaultImg;
    public int disableVoice;
    public String fontColor;
    public int fontSize;

    /* renamed from: id, reason: collision with root package name */
    public long f25048id;
    public int lineSpace;
    public String name;
    public String previewImg;
    public String remark;
    public text_region textRegion;

    public template_gift_item() {
        this.name = "";
        this.remark = "";
        this.previewImg = "";
        this.defaultImg = "";
        this.backgroundImg = "";
        this.canDIY = true;
        this.fontColor = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f25048id = jceInputStream.read(this.f25048id, 0, true);
        this.name = jceInputStream.readString(1, true);
        this.remark = jceInputStream.readString(2, true);
        this.previewImg = jceInputStream.readString(3, true);
        this.defaultImg = jceInputStream.readString(4, true);
        this.backgroundImg = jceInputStream.readString(5, true);
        if (cache_textRegion == null) {
            cache_textRegion = new text_region();
        }
        this.textRegion = (text_region) jceInputStream.read((JceStruct) cache_textRegion, 6, true);
        this.canDIY = jceInputStream.read(this.canDIY, 7, true);
        this.lineSpace = jceInputStream.read(this.lineSpace, 8, true);
        this.fontSize = jceInputStream.read(this.fontSize, 9, true);
        this.fontColor = jceInputStream.readString(10, true);
        this.disableVoice = jceInputStream.read(this.disableVoice, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f25048id, 0);
        jceOutputStream.write(this.name, 1);
        jceOutputStream.write(this.remark, 2);
        jceOutputStream.write(this.previewImg, 3);
        jceOutputStream.write(this.defaultImg, 4);
        jceOutputStream.write(this.backgroundImg, 5);
        jceOutputStream.write((JceStruct) this.textRegion, 6);
        jceOutputStream.write(this.canDIY, 7);
        jceOutputStream.write(this.lineSpace, 8);
        jceOutputStream.write(this.fontSize, 9);
        jceOutputStream.write(this.fontColor, 10);
        jceOutputStream.write(this.disableVoice, 11);
    }

    public template_gift_item(long j3, String str, String str2, String str3, String str4, String str5, text_region text_regionVar, boolean z16, int i3, int i16, String str6, int i17) {
        this.f25048id = j3;
        this.name = str;
        this.remark = str2;
        this.previewImg = str3;
        this.defaultImg = str4;
        this.backgroundImg = str5;
        this.textRegion = text_regionVar;
        this.canDIY = z16;
        this.lineSpace = i3;
        this.fontSize = i16;
        this.fontColor = str6;
        this.disableVoice = i17;
    }
}
