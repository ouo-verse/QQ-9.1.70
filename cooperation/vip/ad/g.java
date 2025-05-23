package cooperation.vip.ad;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f391164d = false;

    /* renamed from: e, reason: collision with root package name */
    private static g f391165e;

    public g() {
        super("TianshuAdQIPCModule");
    }

    public static g b() {
        if (f391165e == null) {
            synchronized (g.class) {
                if (f391165e == null) {
                    f391165e = new g();
                }
            }
        }
        return f391165e;
    }

    public void c() {
        if (f391164d) {
            QIPCServerHelper.getInstance().getServer().unRegisterModule(f391165e);
            f391164d = false;
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        i.h((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), BaseApplication.getContext(), (String) bundle.get(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK), 4009);
        return null;
    }

    public void register() {
        if (!f391164d) {
            QLog.d("TianshuAdQIPCModule", 1, "init tianshuAdQIPCModule");
            QIPCServerHelper.getInstance().register(f391165e);
            f391164d = true;
        }
    }
}
