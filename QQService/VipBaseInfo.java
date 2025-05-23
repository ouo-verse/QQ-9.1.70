package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.qroute.utils.b;
import com.tencent.mobileqq.vip.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VipBaseInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static Map<Integer, VipOpenInfo> cache_mOpenInfo;
    public static boolean isEnableUtf8Bugfix;

    @QAutoInject(configPath = "AutoInjectYml/Foundation/IMCore/Inject_Utf8Bugfix.yml", version = 1)
    static a sFeature;
    private static ArrayList sFeature_AutoGenClazzList_QAutoInjectTransform;
    public int iGrayNameplateFlag;
    public int iNameplateVipType;
    public Map<Integer, VipOpenInfo> mOpenInfo;
    public String strExtendNameplateId;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        boolean isEnable();
    }

    static {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        sFeature_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(q.class);
        isEnableUtf8Bugfix = false;
        try {
            initQAutoInject();
            a aVar = sFeature;
            if (aVar != null && aVar.isEnable()) {
                z16 = true;
            } else {
                z16 = false;
            }
            isEnableUtf8Bugfix = z16;
        } catch (Throwable unused) {
        }
        cache_mOpenInfo = new HashMap();
        cache_mOpenInfo.put(0, new VipOpenInfo());
    }

    public VipBaseInfo() {
        this.mOpenInfo = null;
        this.iNameplateVipType = 0;
        this.iGrayNameplateFlag = 0;
        this.strExtendNameplateId = "";
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sFeature = (a) b.a(sFeature_AutoGenClazzList_QAutoInjectTransform);
    }

    public String className() {
        return "QQService.VipBaseInfo";
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
        jceDisplayer.display((Map) this.mOpenInfo, "mOpenInfo");
        jceDisplayer.display(this.iNameplateVipType, "iNameplateVipType");
        jceDisplayer.display(this.iGrayNameplateFlag, "iGrayNameplateFlag");
        jceDisplayer.display(this.strExtendNameplateId, "strExtendNameplateId");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple((Map) this.mOpenInfo, true);
        jceDisplayer.displaySimple(this.iNameplateVipType, true);
        jceDisplayer.displaySimple(this.iGrayNameplateFlag, false);
        jceDisplayer.displaySimple(this.strExtendNameplateId, true);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        VipBaseInfo vipBaseInfo = (VipBaseInfo) obj;
        if (!JceUtil.equals(this.mOpenInfo, vipBaseInfo.mOpenInfo) || !JceUtil.equals(this.iNameplateVipType, vipBaseInfo.iNameplateVipType) || !JceUtil.equals(this.iGrayNameplateFlag, vipBaseInfo.iGrayNameplateFlag)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.VipBaseInfo";
    }

    public int getIGrayNameplateFlag() {
        return this.iGrayNameplateFlag;
    }

    public int getINameplateVipType() {
        return this.iNameplateVipType;
    }

    public Map<Integer, VipOpenInfo> getMOpenInfo() {
        return this.mOpenInfo;
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
        this.mOpenInfo = (Map) jceInputStream.read((JceInputStream) cache_mOpenInfo, 0, true);
        this.iNameplateVipType = jceInputStream.read(this.iNameplateVipType, 1, false);
        this.iGrayNameplateFlag = jceInputStream.read(this.iGrayNameplateFlag, 2, false);
        try {
            if (isEnableUtf8Bugfix) {
                jceInputStream.setServerEncoding(Charsets.ISO_8859_1.toString());
            }
            this.strExtendNameplateId = jceInputStream.readString(3, false);
            if (isEnableUtf8Bugfix) {
                jceInputStream.setServerEncoding(Charsets.UTF_8.toString());
            }
        } catch (Exception unused) {
        }
    }

    public void setIGrayNameplateFlag(int i3) {
        this.iGrayNameplateFlag = i3;
    }

    public void setINameplateVipType(int i3) {
        this.iNameplateVipType = i3;
    }

    public void setMOpenInfo(Map<Integer, VipOpenInfo> map) {
        this.mOpenInfo = map;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Map) this.mOpenInfo, 0);
        jceOutputStream.write(this.iNameplateVipType, 1);
        jceOutputStream.write(this.iGrayNameplateFlag, 2);
        String str = this.strExtendNameplateId;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public VipBaseInfo(Map<Integer, VipOpenInfo> map, int i3, int i16, String str) {
        this.mOpenInfo = map;
        this.iNameplateVipType = i3;
        this.iGrayNameplateFlag = i16;
        this.strExtendNameplateId = str;
    }
}
