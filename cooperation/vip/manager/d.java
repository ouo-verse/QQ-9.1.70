package cooperation.vip.manager;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_req;
import SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_rsp;
import SWEET_NEW_COMM_SVR.sweet_comm_cfg_item;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.util.ProtocolUtils;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d extends CommonRequestManager {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends QzoneExternalRequest {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f391286d;

        a(Intent intent) {
            this.f391286d = intent;
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public String getCmdString() {
            return "SweetQzoneService.GetCommCfg";
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public JceStruct getReq() {
            sweet_comm_cfg_get_req sweet_comm_cfg_get_reqVar = new sweet_comm_cfg_get_req();
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            sweet_comm_cfg_get_reqVar.vec_cfg = arrayList;
            Intent intent = this.f391286d;
            if (intent != null) {
                long longExtra = intent.getLongExtra(PanoramaConfig.KEY_CURRENT_UIN, -1L);
                sweet_req_comm sweet_req_commVar = new sweet_req_comm();
                sweet_req_commVar.opuin = longExtra;
                sweet_req_commVar.uin = longExtra;
                sweet_req_commVar.loveuin = 0L;
                sweet_req_commVar.qua = QUA.getQUA3();
                sweet_req_commVar.f25098pf = 1;
                sweet_req_commVar.src = 3;
                sweet_comm_cfg_get_reqVar.req_comm = sweet_req_commVar;
            }
            return sweet_comm_cfg_get_reqVar;
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public String uniKey() {
            return "GetCommCfg";
        }
    }

    private void e(boolean z16, Object obj) {
        IntimateInfoHandler intimateInfoHandler;
        IntimateInfoHandler intimateInfoHandler2;
        if (z16 && (obj instanceof sweet_comm_cfg_item)) {
            sweet_comm_cfg_item sweet_comm_cfg_itemVar = (sweet_comm_cfg_item) obj;
            if (d() != null && (intimateInfoHandler2 = (IntimateInfoHandler) d().getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)) != null) {
                intimateInfoHandler2.N2(true, sweet_comm_cfg_itemVar.wording, sweet_comm_cfg_itemVar.dynamic_value, sweet_comm_cfg_itemVar.url);
                return;
            }
            return;
        }
        if (d() != null && (intimateInfoHandler = (IntimateInfoHandler) d().getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)) != null) {
            intimateInfoHandler.N2(false, null, null, null);
        }
    }

    @Override // cooperation.vip.manager.CommonRequestManager
    public QzoneExternalRequest a(Intent intent) {
        return new a(intent);
    }

    public QQAppInterface d() {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return null;
    }

    public void f(long j3) {
        Intent intent = new Intent();
        intent.putExtra(PanoramaConfig.KEY_CURRENT_UIN, j3);
        c(intent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        Map<Long, sweet_comm_cfg_item> map;
        if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        } else {
            i3 = -1;
        }
        boolean z16 = false;
        if (i3 == 1000) {
            sweet_comm_cfg_get_rsp sweet_comm_cfg_get_rspVar = (sweet_comm_cfg_get_rsp) ProtocolUtils.decode(fromServiceMsg.getWupBuffer(), "GetCommCfg");
            if (sweet_comm_cfg_get_rspVar != null && (map = sweet_comm_cfg_get_rspVar.m_cfg_res) != null) {
                sweet_comm_cfg_item sweet_comm_cfg_itemVar = map.get(new Long(1L));
                if (sweet_comm_cfg_itemVar != null) {
                    z16 = true;
                }
                e(z16, sweet_comm_cfg_itemVar);
                return;
            }
            return;
        }
        e(false, null);
    }
}
