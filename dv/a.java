package dv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends av.a implements Handler.Callback {

    /* renamed from: h, reason: collision with root package name */
    private final Handler f395001h;

    /* renamed from: i, reason: collision with root package name */
    private final Messenger f395002i;

    public a() {
        super("OppoAuthPolicy");
        Handler handler = new Handler(gv.a.a().c(), this);
        this.f395001h = handler;
        this.f395002i = new Messenger(handler);
    }

    private void l(Context context, Messenger messenger, String str) {
        QLog.d("OppoAuthPolicy", 1, "authInternal");
        Bundle bundle = new Bundle();
        bundle.putBinder("callback", messenger.getBinder());
        try {
            context.getContentResolver().call(Uri.parse("content://com.oplus.ocs.out.OpenCapabilityThirdProvider/oplus"), WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, str, bundle);
        } catch (RuntimeException e16) {
            QLog.d("OppoAuthPolicy", 1, "auth fail", e16);
        }
    }

    @Override // av.a
    public long c() {
        return 72000000L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16 = message.getData().getInt("result_code") == 1001;
        k(z16);
        QLog.d("OppoAuthPolicy", 1, "auth result:=" + z16);
        return true;
    }

    @Override // av.a
    public void j() {
        l(BaseApplication.getContext(), this.f395002i, "OLK_CLIENT");
    }
}
