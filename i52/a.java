package i52;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.txc.log.api.ITxcActiveReportLogApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends av {

    /* renamed from: a, reason: collision with root package name */
    static String f407249a = "%E9%97%AE%E9%A2%98QQ%E5%8F%B7";

    /* renamed from: b, reason: collision with root package name */
    static String f407250b = "%E4%B8%8A%E4%BC%A0%E9%97%AE%E9%A2%98%E6%97%A5%E5%BF%97";

    /* compiled from: P */
    /* renamed from: i52.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10506a extends ax {
        private JumpParserResult Q;

        protected C10506a(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult) {
            super(baseQQAppInterface, context);
            this.Q = jumpParserResult;
        }

        private void F(AppRuntime appRuntime, String str, boolean z16, long j3, long j16, String str2) {
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), BuiltInServlet.class);
            newIntent.putExtra("action", Constants.Action.ACTION_ACTIVE_LOG_REPORT);
            newIntent.putExtra("uin", str);
            newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_PSKEY, str2);
            newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_WITHOUTLOGIN, !z16);
            newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_STARTTIME, j16);
            newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_ENDTIME, j3);
            newIntent.runNow = true;
            newIntent.withouLogin = true;
            appRuntime.startServlet(newIntent);
        }

        @Override // com.tencent.mobileqq.utils.ax
        public boolean b() {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d("TxcJumpParser", 1, "app==null return");
                return true;
            }
            boolean isLogin = peekAppRuntime.isLogin();
            String account = isLogin ? peekAppRuntime.getAccount() : null;
            if (!StringUtil.isValideUin(account)) {
                Iterator<String> it = this.Q.getParamMap().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (next.contains(a.f407249a)) {
                        account = this.Q.getParamMap().get(next);
                        break;
                    }
                }
            }
            String str = account;
            if (StringUtil.isValideUin(str) && "1".equals(this.Q.getParamMap().get(a.f407250b))) {
                QLog.d("TxcJumpParser", 1, "logReport uin=" + str + ", isLogin=" + isLogin);
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = currentTimeMillis - 3600000;
                if (QLog.isColorLevel()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(j3);
                    QLog.i("JumpAction", 2, String.format("logReport start time: %1$tA %1$tb %1$td %1$tY at %1$tI:%1$tM %1$Tp", calendar));
                }
                if (isLogin) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString(ITxcActiveReportLogApi.TXC_PARAM_UIN, str);
                        bundle.putLong(ITxcActiveReportLogApi.TXC_PARAM_START_TIME, j3);
                        bundle.putLong(ITxcActiveReportLogApi.TXC_PARAM_END_TIME, currentTimeMillis);
                        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), ITxcActiveReportLogApi.NAME, ITxcActiveReportLogApi.TXC_ACTION_ACTIVE_REPORT_LOG, bundle);
                    } catch (Exception e16) {
                        QLog.e("JumpAction", 1, "txc QIPC error", e16);
                    }
                } else {
                    F(peekAppRuntime, str, isLogin, currentTimeMillis, j3, "");
                }
            }
            return true;
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str, JumpParserResult jumpParserResult) {
        return new C10506a(baseQQAppInterface, context, jumpParserResult);
    }
}
