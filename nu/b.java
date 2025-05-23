package nu;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.utils.m;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.light.LightVersionInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a {
    private boolean g(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetCatMatTreeReq getCatMatTreeReq = new GetCatMatTreeReq();
        getCatMatTreeReq.ServiceId = toServiceMsg.extraData.getString("ServiceId");
        getCatMatTreeReq.GroupId = toServiceMsg.extraData.getString("GroupId");
        getCatMatTreeReq.ETag = m.a(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTree" + getCatMatTreeReq.ServiceId);
        QLog.i("EffectMaterialJCECoder", 2, "request etag: " + getCatMatTreeReq.ETag);
        getCatMatTreeReq.SdkInfos = e();
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName("ShadowBackendSvc.GetCatMatTree");
        uniPacket.put("ShadowBackendSvc.GetCatMatTree", getCatMatTreeReq);
        return true;
    }

    @Override // nu.a
    public Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if ("ShadowBackendSvc.GetCatMatTree".equals(toServiceMsg.getServiceCmd())) {
            return f(fromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetCatMatTree", new GetCatMatTreeRsp());
        }
        return super.a(toServiceMsg, fromServiceMsg);
    }

    @Override // nu.a
    public boolean b(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if ("ShadowBackendSvc.GetCatMatTree".equals(toServiceMsg.getServiceCmd())) {
            return g(toServiceMsg, uniPacket);
        }
        return super.b(toServiceMsg, uniPacket);
    }

    @Override // nu.a
    public List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ShadowBackendSvc.GetCatMatTree");
        return arrayList;
    }

    protected ArrayList<MetaSdkInfo> e() {
        ArrayList<MetaSdkInfo> arrayList = new ArrayList<>();
        MetaSdkInfo metaSdkInfo = new MetaSdkInfo();
        metaSdkInfo.sdk = 0;
        metaSdkInfo.sdkVersion = "2.0.0";
        String str = LightVersionInfo.VERSION_NAME;
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            String[] split = LightVersionInfo.VERSION_NAME.split("\\.");
            if (split.length > 3) {
                str = split[0] + "." + split[1] + "." + split[2];
            }
            metaSdkInfo.sdkVersion = str;
        }
        arrayList.add(metaSdkInfo);
        return arrayList;
    }

    public final <T> T f(byte[] bArr, String str, T t16) {
        com.tencent.av.business.servlet.b bVar = new com.tencent.av.business.servlet.b(true);
        try {
            bVar.setEncodeName("utf-8");
            bVar.decode(bArr);
            return (T) bVar.getByClass(str, t16);
        } catch (Exception unused) {
            return null;
        }
    }
}
