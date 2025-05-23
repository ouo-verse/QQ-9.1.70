package cooperation.qzone.font;

/* compiled from: P */
/* loaded from: classes38.dex */
public class FontInfo {
    public String fTypePath;
    public int fontId;
    public String fontUrl;
    public String tTypePath;

    public FontInfo() {
    }

    public String getFullTypeFont() {
        return this.fTypePath;
    }

    public String getTrueTypeFont() {
        return this.tTypePath;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[id=");
        stringBuffer.append(this.fontId);
        stringBuffer.append(",fTypePath=");
        stringBuffer.append(this.fTypePath);
        stringBuffer.append(", tTYpePath=");
        stringBuffer.append(this.tTypePath);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public FontInfo(int i3) {
        this.fontId = i3;
        this.fTypePath = "";
        this.tTypePath = "";
    }
}
