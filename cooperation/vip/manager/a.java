package cooperation.vip.manager;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_PAIR.sweet_pair_check_req;
import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LoveZoneInfoHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.util.ProtocolUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends CommonRequestManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f391280d = false;

    /* compiled from: P */
    /* renamed from: cooperation.vip.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C10127a extends QzoneExternalRequest {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f391281d;

        C10127a(Intent intent) {
            this.f391281d = intent;
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public String getCmdString() {
            return "SweetQzoneService.getPairState";
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public JceStruct getReq() {
            sweet_pair_check_req sweet_pair_check_reqVar = new sweet_pair_check_req();
            Intent intent = this.f391281d;
            if (intent != null) {
                long longExtra = intent.getLongExtra(PanoramaConfig.KEY_CURRENT_UIN, -1L);
                sweet_req_comm sweet_req_commVar = new sweet_req_comm();
                sweet_req_commVar.opuin = longExtra;
                sweet_req_commVar.uin = longExtra;
                sweet_req_commVar.loveuin = 0L;
                sweet_req_commVar.qua = QUA.getQUA3();
                sweet_req_commVar.f25098pf = 1;
                sweet_req_commVar.src = 3;
                sweet_pair_check_reqVar.req_comm = sweet_req_commVar;
            }
            return sweet_pair_check_reqVar;
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public String uniKey() {
            return "getPairState";
        }
    }

    @Override // cooperation.vip.manager.CommonRequestManager
    public QzoneExternalRequest a(Intent intent) {
        return new C10127a(intent);
    }

    public void d(long j3) {
        Intent intent = new Intent();
        intent.putExtra(PanoramaConfig.KEY_CURRENT_UIN, j3);
        c(intent);
    }

    public QQAppInterface e() {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return null;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str) || str.equals("0") || f391280d) {
            return;
        }
        f391280d = true;
        try {
            d(Long.parseLong(str));
        } catch (Exception unused) {
            VasLogReporter.getQzoneVip().reportLow("error uin = " + str);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        LoveZoneInfoHandler loveZoneInfoHandler;
        int i3;
        sweet_pair_check_rsp sweet_pair_check_rspVar;
        sweet_rsp_comm sweet_rsp_commVar;
        QQAppInterface e16 = e();
        if (e16 != null && (loveZoneInfoHandler = (LoveZoneInfoHandler) e16.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER)) != null) {
            if (fromServiceMsg != null) {
                i3 = fromServiceMsg.getResultCode();
            } else {
                i3 = -1;
            }
            VasLogReporter.getQzoneVip().reportLow("receive code=" + i3);
            boolean z16 = false;
            if (i3 == 1000 && (sweet_pair_check_rspVar = (sweet_pair_check_rsp) ProtocolUtils.decode(fromServiceMsg.getWupBuffer(), "getPairState")) != null && (sweet_rsp_commVar = sweet_pair_check_rspVar.rsp_comm) != null) {
                if (sweet_rsp_commVar.retcode == 0) {
                    z16 = true;
                }
                loveZoneInfoHandler.D2(z16, sweet_pair_check_rspVar);
                return;
            }
            loveZoneInfoHandler.D2(false, null);
        }
    }
}
