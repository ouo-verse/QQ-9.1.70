package cooperation.vip.ad.license;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.base.TianShuBaseRequest;
import java.util.List;
import tianshu.TianShuQuantityLimit$AdStatus;
import tianshu.TianShuQuantityLimit$GetAdLicenseReq;
import tianshu.TianShuQuantityLimit$GetAdLicenseRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TianShuAdLicenseRequest extends TianShuBaseRequest {
    private TianShuQuantityLimit$GetAdLicenseReq mLicenseReq;

    public TianShuAdLicenseRequest(List<TianShuQuantityLimit$AdStatus> list) {
        TianShuQuantityLimit$GetAdLicenseReq tianShuQuantityLimit$GetAdLicenseReq = new TianShuQuantityLimit$GetAdLicenseReq();
        this.mLicenseReq = tianShuQuantityLimit$GetAdLicenseReq;
        tianShuQuantityLimit$GetAdLicenseReq.stComminfo.set(c.a(BaseRequest.generateTraceId()));
        overrideTraceId(this.mLicenseReq.stComminfo.traceId.get());
        if (list != null) {
            this.mLicenseReq.adList.set(list);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "trpc.tianshu.quantity_limit.Limit.SsoAcquire";
    }

    public TianShuQuantityLimit$GetAdLicenseReq getLicenseReq() {
        return this.mLicenseReq;
    }

    @Override // cooperation.vip.tianshu.base.TianShuBaseRequest
    protected String getLogTag() {
        return "QSplash@-TSL-TianShuAdLicenseRequest";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mLicenseReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    public Object[] parseResponseHeadInfo(byte[] bArr) {
        Object[] objArr = new Object[3];
        TianShuQuantityLimit$GetAdLicenseRsp tianShuQuantityLimit$GetAdLicenseRsp = new TianShuQuantityLimit$GetAdLicenseRsp();
        try {
            tianShuQuantityLimit$GetAdLicenseRsp.mergeFrom(fh.a(bArr));
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QSplash@-TSL-TianShuAdLicenseRequest", 1, "parseResponseHeadInfo e = " + e16);
        }
        objArr[0] = Long.valueOf(tianShuQuantityLimit$GetAdLicenseRsp.code.get());
        objArr[1] = tianShuQuantityLimit$GetAdLicenseRsp.errmsg.get();
        objArr[2] = tianShuQuantityLimit$GetAdLicenseRsp.toByteArray();
        return objArr;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        TianShuQuantityLimit$GetAdLicenseRsp tianShuQuantityLimit$GetAdLicenseRsp = new TianShuQuantityLimit$GetAdLicenseRsp();
        try {
            tianShuQuantityLimit$GetAdLicenseRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QSplash@-TSL-TianShuAdLicenseRequest", 1, "decode e = " + e16);
        }
        return tianShuQuantityLimit$GetAdLicenseRsp;
    }
}
