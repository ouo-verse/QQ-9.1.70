package cooperation.vip.manager;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_PAIR.sweet_pair_byebye_req;
import SWEET_NEW_PAIR.sweet_pair_byebye_rsp;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friends.intimate.IntimateDisbandLoveRelationResponseEvent;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.util.ProtocolUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c extends CommonRequestManager {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends QzoneExternalRequest {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Intent f391284d;

        a(Intent intent) {
            this.f391284d = intent;
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public String getCmdString() {
            return "SweetQzoneService.sweet_pair_byebye";
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public JceStruct getReq() {
            sweet_pair_byebye_req sweet_pair_byebye_reqVar = new sweet_pair_byebye_req();
            Intent intent = this.f391284d;
            if (intent != null) {
                long longExtra = intent.getLongExtra(PanoramaConfig.KEY_CURRENT_UIN, -1L);
                long longExtra2 = this.f391284d.getLongExtra("friendUin", -1L);
                sweet_req_comm sweet_req_commVar = new sweet_req_comm();
                sweet_req_commVar.opuin = longExtra;
                sweet_req_commVar.uin = longExtra;
                sweet_req_commVar.loveuin = longExtra2;
                sweet_req_commVar.qua = QUA.getQUA3();
                sweet_req_commVar.f25098pf = 1;
                sweet_req_commVar.src = 3;
                sweet_pair_byebye_reqVar.req_comm = sweet_req_commVar;
            }
            return sweet_pair_byebye_reqVar;
        }

        @Override // cooperation.qzone.QzoneExternalRequest
        public String uniKey() {
            return "sweet_pair_byebye";
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

    public void e(long j3, long j16) {
        Intent intent = new Intent();
        intent.putExtra(PanoramaConfig.KEY_CURRENT_UIN, j3);
        intent.putExtra("friendUin", j16);
        c(intent);
    }

    public void f(long j3, long j16) {
        Intent intent = new Intent();
        intent.putExtra(PanoramaConfig.KEY_CURRENT_UIN, j3);
        intent.putExtra("friendUin", j16);
        intent.putExtra("need_dispatch_response_event", true);
        c(intent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IntimateInfoHandler intimateInfoHandler;
        int i3;
        QQAppInterface d16 = d();
        if (d16 == null) {
            intimateInfoHandler = null;
        } else {
            intimateInfoHandler = (IntimateInfoHandler) d16.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
        }
        boolean booleanExtra = intent.getBooleanExtra("need_dispatch_response_event", false);
        if (intimateInfoHandler != null || booleanExtra) {
            String valueOf = String.valueOf(intent.getLongExtra("friendUin", -1L));
            if (fromServiceMsg != null) {
                i3 = fromServiceMsg.getResultCode();
            } else {
                i3 = -1;
            }
            if (i3 == 1000) {
                sweet_pair_byebye_rsp sweet_pair_byebye_rspVar = (sweet_pair_byebye_rsp) ProtocolUtils.decode(fromServiceMsg.getWupBuffer(), "sweet_pair_byebye");
                if (sweet_pair_byebye_rspVar != null) {
                    sweet_rsp_comm sweet_rsp_commVar = sweet_pair_byebye_rspVar.rsp_comm;
                    int i16 = sweet_rsp_commVar.retcode;
                    if (i16 == 0) {
                        if (intimateInfoHandler != null) {
                            intimateInfoHandler.L2(true, i16, sweet_rsp_commVar.errmsg, valueOf);
                        }
                        if (booleanExtra) {
                            SimpleEventBus.getInstance().dispatchEvent(new IntimateDisbandLoveRelationResponseEvent(true, sweet_rsp_commVar.retcode, sweet_rsp_commVar.errmsg, valueOf));
                            return;
                        }
                        return;
                    }
                    if (intimateInfoHandler != null) {
                        intimateInfoHandler.L2(false, i16, sweet_rsp_commVar.errmsg, valueOf);
                    }
                    if (booleanExtra) {
                        SimpleEventBus.getInstance().dispatchEvent(new IntimateDisbandLoveRelationResponseEvent(false, sweet_rsp_commVar.retcode, sweet_rsp_commVar.errmsg, valueOf));
                        return;
                    }
                    return;
                }
                return;
            }
            if (intimateInfoHandler != null) {
                intimateInfoHandler.L2(false, -1, null, null);
            }
            if (booleanExtra) {
                SimpleEventBus.getInstance().dispatchEvent(new IntimateDisbandLoveRelationResponseEvent(false, -1, null, null));
            }
        }
    }
}
