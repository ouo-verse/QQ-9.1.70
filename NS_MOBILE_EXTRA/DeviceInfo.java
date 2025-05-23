package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DeviceInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int iChooseTag;
    public int iEditTag;
    public int iOpMask;
    public String strDeviceIcon;
    public String strDeviceTail;
    public String strDiyMemo;
    public String strIdentifySqua;

    public DeviceInfo() {
        this.strDeviceTail = "";
        this.strDeviceIcon = "";
        this.strIdentifySqua = "";
        this.strDiyMemo = "";
    }

    public String className() {
        return "NS_MOBILE_EXTRA.DeviceInfo";
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
        jceDisplayer.display(this.strDeviceTail, "strDeviceTail");
        jceDisplayer.display(this.strDeviceIcon, "strDeviceIcon");
        jceDisplayer.display(this.iOpMask, "iOpMask");
        jceDisplayer.display(this.strIdentifySqua, "strIdentifySqua");
        jceDisplayer.display(this.strDiyMemo, "strDiyMemo");
        jceDisplayer.display(this.iChooseTag, "iChooseTag");
        jceDisplayer.display(this.iEditTag, "iEditTag");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.strDeviceTail, true);
        jceDisplayer.displaySimple(this.strDeviceIcon, true);
        jceDisplayer.displaySimple(this.iOpMask, true);
        jceDisplayer.displaySimple(this.strIdentifySqua, true);
        jceDisplayer.displaySimple(this.strDiyMemo, true);
        jceDisplayer.displaySimple(this.iChooseTag, true);
        jceDisplayer.displaySimple(this.iEditTag, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (!JceUtil.equals(this.strDeviceTail, deviceInfo.strDeviceTail) || !JceUtil.equals(this.strDeviceIcon, deviceInfo.strDeviceIcon) || !JceUtil.equals(this.iOpMask, deviceInfo.iOpMask) || !JceUtil.equals(this.strIdentifySqua, deviceInfo.strIdentifySqua) || !JceUtil.equals(this.strDiyMemo, deviceInfo.strDiyMemo) || !JceUtil.equals(this.iChooseTag, deviceInfo.iChooseTag) || !JceUtil.equals(this.iEditTag, deviceInfo.iEditTag)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_MOBILE_EXTRA.DeviceInfo";
    }

    public int getIChooseTag() {
        return this.iChooseTag;
    }

    public int getIEditTag() {
        return this.iEditTag;
    }

    public int getIOpMask() {
        return this.iOpMask;
    }

    public String getStrDeviceIcon() {
        return this.strDeviceIcon;
    }

    public String getStrDeviceTail() {
        return this.strDeviceTail;
    }

    public String getStrDiyMemo() {
        return this.strDiyMemo;
    }

    public String getStrIdentifySqua() {
        return this.strIdentifySqua;
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
        this.strDeviceTail = jceInputStream.readString(0, true);
        this.strDeviceIcon = jceInputStream.readString(1, true);
        this.iOpMask = jceInputStream.read(this.iOpMask, 2, false);
        this.strIdentifySqua = jceInputStream.readString(3, false);
        this.strDiyMemo = jceInputStream.readString(4, false);
        this.iChooseTag = jceInputStream.read(this.iChooseTag, 5, false);
        this.iEditTag = jceInputStream.read(this.iEditTag, 6, false);
    }

    public void setIChooseTag(int i3) {
        this.iChooseTag = i3;
    }

    public void setIEditTag(int i3) {
        this.iEditTag = i3;
    }

    public void setIOpMask(int i3) {
        this.iOpMask = i3;
    }

    public void setStrDeviceIcon(String str) {
        this.strDeviceIcon = str;
    }

    public void setStrDeviceTail(String str) {
        this.strDeviceTail = str;
    }

    public void setStrDiyMemo(String str) {
        this.strDiyMemo = str;
    }

    public void setStrIdentifySqua(String str) {
        this.strIdentifySqua = str;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("strDiyMemo", this.strDiyMemo);
            jSONObject.put("strDeviceTail", this.strDeviceTail);
            jSONObject.put("iOpMask", this.iOpMask);
            jSONObject.put("strIdentifySqua", this.strIdentifySqua);
            jSONObject.put("strDeviceIcon", this.strDeviceIcon);
            jSONObject.put("iChooseTag", this.iChooseTag);
            jSONObject.put("iDeviceType", this.iEditTag);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strDeviceTail, 0);
        jceOutputStream.write(this.strDeviceIcon, 1);
        jceOutputStream.write(this.iOpMask, 2);
        String str = this.strIdentifySqua;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strDiyMemo;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.iChooseTag, 5);
        jceOutputStream.write(this.iEditTag, 6);
    }

    public DeviceInfo(String str, String str2, int i3, String str3, String str4, int i16, int i17) {
        this.strDeviceTail = str;
        this.strDeviceIcon = str2;
        this.iOpMask = i3;
        this.strIdentifySqua = str3;
        this.strDiyMemo = str4;
        this.iChooseTag = i16;
        this.iEditTag = i17;
    }
}
