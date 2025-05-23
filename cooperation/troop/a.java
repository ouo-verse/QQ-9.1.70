package cooperation.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.aj;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends RemoteCommand {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f390896a;

    public a(QQAppInterface qQAppInterface) {
        super("troop.manage.get_app_interface_data");
        this.f390896a = qQAppInterface;
    }

    protected Bundle a(Bundle bundle, int i3) {
        String str = null;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        if (i3 == 6) {
            str = ac.f(this.f390896a, bundle.getString("memUin"));
        }
        bundle2.putString("param_rsp_nick", str);
        return bundle2;
    }

    protected Bundle b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("param_rsp_troop_owmer_field", ((aj) this.f390896a.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).c(bundle.getString("req_troop_uin")));
        return bundle2;
    }

    protected Bundle c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("rep_unique_title_flag", ((TroopManager) this.f390896a.getManager(QQManagerFactory.TROOP_MANAGER)).I());
        return bundle2;
    }

    protected Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putString("param_rsp_upgrade_troop_url", IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_UP_GROUP_LIMIT));
        return bundle;
    }

    protected Bundle e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i3 = bundle.getInt("set_unique_title_flag");
        Bundle bundle2 = new Bundle();
        ((TroopManager) this.f390896a.getManager(QQManagerFactory.TROOP_MANAGER)).A0(i3);
        return bundle2;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
        if (bundle != null && this.f390896a != null) {
            try {
                Bundle bundle2 = new Bundle();
                int i3 = bundle.getInt("req_sub_cmd", 0);
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5 && i3 != 6) {
                                if (i3 == 7) {
                                    return d();
                                }
                                return bundle2;
                            }
                            return a(bundle, i3);
                        }
                        return b(bundle);
                    }
                    return e(bundle);
                }
                return c(bundle);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopManageCmd", 2, "invoke Exception hanppend! ExceptionClass = + " + e16.getClass().getName() + "msg = " + e16.getMessage());
                }
                ReportController.o(this.f390896a, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "plugin_cmd_exp", 0, 0, e16.getClass().getName(), null, null, null);
            }
        }
        return null;
    }
}
