package cooperation.vip.manager;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneExternalRequest;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class CommonRequestManager extends MSFServlet {
    public abstract QzoneExternalRequest a(Intent intent);

    protected long b() {
        return 10000L;
    }

    public void c(final Intent intent) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.vip.manager.CommonRequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                VasLogReporter.getQzoneVip().reportLow("send request");
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), CommonRequestManager.this.getClass());
                newIntent.putExtras(intent);
                runtime.startServlet(newIntent);
            }
        });
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QzoneExternalRequest a16 = a(intent);
        if (a16 == null) {
            QLog.i("CommonRequestManager", 1, " onSend request = null");
            return;
        }
        byte[] encode = a16.encode();
        if (encode == null) {
            QLog.e("CommonRequestManager", 1, "onSend request encode result is null.cmd=" + a16.uniKey());
            encode = new byte[4];
        }
        packet.setTimeout(b());
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + a16.uniKey());
        packet.putSendData(encode);
    }
}
