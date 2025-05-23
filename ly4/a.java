package ly4;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.l;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import pl4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ly4.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public class C10754a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f415794d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Class f415795e;

        C10754a(d dVar, Class cls) {
            this.f415794d = dVar;
            this.f415795e = cls;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00bb  */
        @Override // mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            MessageMicro messageMicro;
            l.i("NetCore", "onReceive type:" + i3 + ",isSuccess:" + z16);
            if (this.f415794d != null) {
                int i16 = bundle.getInt("req_cmd", 0);
                FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("msf_data");
                boolean z17 = bundle.getBoolean("msf_success", false);
                int i17 = bundle.getInt("msf_code", -1000);
                byte[] byteArray = bundle.getByteArray("timi_data");
                int i18 = bundle.getInt("timi_code", -1);
                String string = bundle.getString("timi_errmsg", "");
                String string2 = bundle.getString("timi_displaymsg", "");
                int i19 = bundle.getInt("timi_subcode", -1);
                if (byteArray != null && byteArray.length > 0) {
                    try {
                        messageMicro = ((MessageMicro) this.f415795e.newInstance()).mergeFrom(byteArray);
                    } catch (Exception e16) {
                        l.f("NetCore", i16 + " - parse rsp body Exception", e16);
                    }
                    MessageMicro messageMicro2 = messageMicro;
                    if (z16) {
                        a.b(this.f415794d, z17, i17, i18, i19, string, string2, messageMicro2, fromServiceMsg);
                        return;
                    } else {
                        this.f415794d.a(messageMicro2, fromServiceMsg);
                        return;
                    }
                }
                if (z16) {
                    l.e("NetCore", i16 + "- success, but parse rsp body empty! " + byteArray);
                }
                messageMicro = null;
                MessageMicro messageMicro22 = messageMicro;
                if (z16) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(d dVar, boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable MessageMicro messageMicro, @Nullable FromServiceMsg fromServiceMsg) {
        if (dVar != null) {
            dVar.b(z16, i3, i16, i17, str, str2, messageMicro, fromServiceMsg);
        }
    }

    public static void c(AppRuntime appRuntime, NewIntent newIntent, Class<? extends MessageMicro> cls, d dVar) {
        l.i("NetCore", "sendRequest appRuntime:" + appRuntime);
        if (newIntent == null) {
            l.f("NetCore", "sendRequest but NewIntent is null! " + newIntent + " - " + cls, new Exception());
            b(dVar, false, -11, -1, 0, "", "NewIntent is null", null, null);
            return;
        }
        if (appRuntime == null) {
            appRuntime = vf4.a.a();
        }
        if (appRuntime == null) {
            l.f("NetCore", "sendRequest but runtime is null! " + newIntent + " - " + cls, new Exception());
            b(dVar, false, -22, -1, 0, "", "AppRunTime is null", null, null);
            return;
        }
        newIntent.setObserver(new C10754a(dVar, cls));
        appRuntime.startServlet(newIntent);
        l.i("NetCore", "startServlet appRuntime:" + appRuntime);
    }
}
