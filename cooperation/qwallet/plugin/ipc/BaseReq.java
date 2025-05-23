package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class BaseReq extends BaseIpc {
    private static final String TAG = "BaseReq";
    public ResultReceiver fromReceiver;

    public static BaseReq getReq(Bundle bundle) {
        Class<?> loadClass;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("_qwallet_ipc_class");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            ClassLoader classLoader = BaseIpc.class.getClassLoader();
            if (classLoader == null || (loadClass = classLoader.loadClass(string)) == null) {
                return null;
            }
            BaseReq baseReq = (BaseReq) loadClass.newInstance();
            baseReq.fromBundle(bundle);
            return baseReq;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
            return null;
        }
    }

    public final boolean doCallback(Bundle bundle) {
        ResultReceiver resultReceiver;
        if (bundle == null || (resultReceiver = this.fromReceiver) == null) {
            return false;
        }
        resultReceiver.send(0, bundle);
        return true;
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseIpc
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.fromReceiver = (ResultReceiver) bundle.getParcelable("_qwallet_ipc_req_fromreceiver");
    }

    public abstract void onReceive();

    @Override // cooperation.qwallet.plugin.ipc.BaseIpc
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        if (this.fromReceiver != null) {
            Parcel obtain = Parcel.obtain();
            this.fromReceiver.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            bundle.putParcelable("_qwallet_ipc_req_fromreceiver", resultReceiver);
        }
    }
}
