package camera.SHADOW_BACKEND_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.app.AppConstants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetCircleTemplateInfoReq extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String Uid;

    public GetCircleTemplateInfoReq() {
        this.Uid = "";
    }

    public String className() {
        return "SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoReq";
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
        new JceDisplayer(sb5, i3).display(this.Uid, AppConstants.Key.UID);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        new JceDisplayer(sb5, i3).displaySimple(this.Uid, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return JceUtil.equals(this.Uid, ((GetCircleTemplateInfoReq) obj).Uid);
    }

    public String fullClassName() {
        return "camera.SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoReq";
    }

    public String getUid() {
        return this.Uid;
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
        this.Uid = jceInputStream.readString(0, true);
    }

    public void setUid(String str) {
        this.Uid = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Uid, 0);
    }

    public GetCircleTemplateInfoReq(String str) {
        this.Uid = str;
    }
}
