package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_like_rsp extends JceStruct {
    static cmshow_active_result cache_cmshow_act_result = new cmshow_active_result();
    public cmshow_active_result cmshow_act_result;

    /* renamed from: msg, reason: collision with root package name */
    public String f25017msg;
    public int ret;

    public operation_like_rsp() {
        this.ret = 0;
        this.f25017msg = "";
        this.cmshow_act_result = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25017msg = jceInputStream.readString(1, false);
        this.cmshow_act_result = (cmshow_active_result) jceInputStream.read((JceStruct) cache_cmshow_act_result, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25017msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        cmshow_active_result cmshow_active_resultVar = this.cmshow_act_result;
        if (cmshow_active_resultVar != null) {
            jceOutputStream.write((JceStruct) cmshow_active_resultVar, 2);
        }
    }

    public operation_like_rsp(int i3, String str, cmshow_active_result cmshow_active_resultVar) {
        this.ret = i3;
        this.f25017msg = str;
        this.cmshow_act_result = cmshow_active_resultVar;
    }
}
