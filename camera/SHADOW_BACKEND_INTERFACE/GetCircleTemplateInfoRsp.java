package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCircleTemplateInfoRsp extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static CircleTemplateInfo cache_TemplateInfo = new CircleTemplateInfo();
    public int Code;
    public String Msg;
    public CircleTemplateInfo TemplateInfo;

    public GetCircleTemplateInfoRsp() {
        this.Code = 0;
        this.Msg = "";
        this.TemplateInfo = null;
    }

    public String className() {
        return "SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoRsp";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.Code, "Code");
        jceDisplayer.display(this.Msg, "Msg");
        jceDisplayer.display((JceStruct) this.TemplateInfo, "TemplateInfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.Code, true);
        jceDisplayer.displaySimple(this.Msg, true);
        jceDisplayer.displaySimple((JceStruct) this.TemplateInfo, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        GetCircleTemplateInfoRsp getCircleTemplateInfoRsp = (GetCircleTemplateInfoRsp) obj;
        if (!JceUtil.equals(this.Code, getCircleTemplateInfoRsp.Code) || !JceUtil.equals(this.Msg, getCircleTemplateInfoRsp.Msg) || !JceUtil.equals(this.TemplateInfo, getCircleTemplateInfoRsp.TemplateInfo)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "camera.SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoRsp";
    }

    public int getCode() {
        return this.Code;
    }

    public String getMsg() {
        return this.Msg;
    }

    public CircleTemplateInfo getTemplateInfo() {
        return this.TemplateInfo;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Msg = jceInputStream.readString(1, false);
        this.TemplateInfo = (CircleTemplateInfo) jceInputStream.read((JceStruct) cache_TemplateInfo, 2, false);
    }

    public void setCode(int i3) {
        this.Code = i3;
    }

    public void setMsg(String str) {
        this.Msg = str;
    }

    public void setTemplateInfo(CircleTemplateInfo circleTemplateInfo) {
        this.TemplateInfo = circleTemplateInfo;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        String str = this.Msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        CircleTemplateInfo circleTemplateInfo = this.TemplateInfo;
        if (circleTemplateInfo != null) {
            jceOutputStream.write((JceStruct) circleTemplateInfo, 2);
        }
    }

    public GetCircleTemplateInfoRsp(int i3, String str, CircleTemplateInfo circleTemplateInfo) {
        this.Code = i3;
        this.Msg = str;
        this.TemplateInfo = circleTemplateInfo;
    }
}
