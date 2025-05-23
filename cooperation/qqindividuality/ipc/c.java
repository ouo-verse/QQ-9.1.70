package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.da;
import com.tencent.mobileqq.app.h;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.m;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.ipc.b;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c implements b.a {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends UniPayHandler.a {
        a() {
        }

        @Override // com.tencent.mobileqq.app.UniPayHandler.a
        public void a() {
            QQIndividualityPluginProxyService.c().c("qqindividuality_signature", 2, new Bundle());
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b extends h {
        b() {
        }

        @Override // com.tencent.mobileqq.app.h
        protected void n(boolean z16, int i3) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSuccess", z16);
            bundle.putInt("result", i3);
            QQIndividualityPluginProxyService.c().c("qqindividuality_signature", 3, bundle);
        }
    }

    /* compiled from: P */
    /* renamed from: cooperation.qqindividuality.ipc.c$c, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C10119c extends da {
        C10119c() {
        }

        @Override // com.tencent.mobileqq.app.da
        protected void g(boolean z16, Object obj) {
            if (z16) {
                Bundle bundle = (Bundle) obj;
                bundle.putInt("which_method", 0);
                QQIndividualityPluginProxyService.c().c("qqindividuality_signature", 4, bundle);
            }
        }

        @Override // com.tencent.mobileqq.app.da
        protected void i(boolean z16, Object obj) {
            if (z16) {
                Bundle bundle = (Bundle) obj;
                bundle.putInt("which_method", 1);
                QQIndividualityPluginProxyService.c().c("qqindividuality_signature", 4, bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class d extends m {
        d() {
        }

        @Override // com.tencent.mobileqq.richstatus.m
        protected void d(boolean z16, int i3, int i16, boolean z17, ArrayList<RichStatus> arrayList, boolean z18) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSuccess", z16);
            bundle.putInt("start", i3);
            bundle.putInt("end", i16);
            bundle.putBoolean("over", z17);
            bundle.putSerializable("data", arrayList);
            bundle.putBoolean("isAddFromCard", z18);
            bundle.putInt("which_method", 0);
            QQIndividualityPluginProxyService.c().c("qqindividuality_signature", 5, bundle);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0140, code lost:
    
        return true;
     */
    @Override // cooperation.qqindividuality.ipc.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(int i3, Bundle bundle) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        switch (i3) {
            case 5:
                ClubContentUpdateHandler.E2(qQAppInterface);
                break;
            case 6:
                UniPayHandler uniPayHandler = (UniPayHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNI_PAY_HANDLER);
                uniPayHandler.E2(new a());
                uniPayHandler.F2("");
                break;
            case 7:
                ConfigHandler configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
                configHandler.y3(null, configHandler.N2());
                break;
            case 8:
                qQAppInterface.addObserver(new b());
                break;
            case 9:
                ((LBSHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).S2(bundle.getBoolean(NodeProps.VISIBLE));
                break;
            case 10:
                int i16 = bundle.getInt("iFaceType");
                String string = bundle.getString("uinOrMobileNum");
                byte b16 = bundle.getByte("faceFileType");
                int i17 = bundle.getInt("idType");
                IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) qQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
                if (i16 != 1) {
                    if (i16 != 4) {
                        if (i16 != 11) {
                            if (i16 != 16) {
                                if (i16 == 32) {
                                    iQQAvatarHandlerService.getStrangerHead(string, i17, (byte) 1, b16);
                                    break;
                                }
                            } else {
                                iQQAvatarHandlerService.getQCallHead(string, i17, (byte) 1, b16);
                                break;
                            }
                        } else {
                            iQQAvatarHandlerService.getMobileQQHead(string, b16);
                            break;
                        }
                    } else {
                        iQQAvatarHandlerService.getTroopHead(string, b16);
                        break;
                    }
                } else {
                    iQQAvatarHandlerService.getCustomHead(string, (byte) 0, b16);
                    break;
                }
                break;
            case 11:
                String string2 = bundle.getString("mUin");
                String string3 = bundle.getString("feedsId");
                int i18 = bundle.getInt("action");
                QLog.d("IndividualityRemoteCommandHandler", 1, "QQREMOTECMD_SIGNATURE_LIKE");
                SignatureHandler signatureHandler = (SignatureHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
                if (signatureHandler != null) {
                    signatureHandler.d3(string2, string3, 255, i18);
                    break;
                }
                break;
            case 12:
                qQAppInterface.addObserver(new C10119c());
                break;
            case 13:
                qQAppInterface.registObserver(new d());
                break;
            case 14:
                SignatureHandler signatureHandler2 = (SignatureHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
                if (signatureHandler2 != null) {
                    signatureHandler2.M2();
                    break;
                }
                break;
            case 15:
                ((SignatureHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)).P2(bundle.getString("uin"), bundle.getString("feedsId"), 255, true);
                break;
            case 16:
                String y16 = ac.y(qQAppInterface, qQAppInterface.getCurrentAccountUin());
                Bundle bundle2 = new Bundle();
                bundle2.putString("name", y16);
                QQIndividualityPluginProxyService.c().c("qqindividuality_signature", 6, bundle2);
                break;
            case 17:
                if (bundle != null) {
                    qQAppInterface.sendToService((ToServiceMsg) bundle.getParcelable("msg"));
                    break;
                }
                break;
        }
    }
}
