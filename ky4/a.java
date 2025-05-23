package ky4;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import ox0.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ky4.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public class C10692a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f413436d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Class f413437e;

        C10692a(c cVar, Class cls) {
            this.f413436d = cVar;
            this.f413437e = cls;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00bb  */
        @Override // mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            MessageMicro messageMicro;
            g.h("ICGameNetCore", "onReceive type:" + i3 + ",isSuccess:" + z16);
            if (this.f413436d != null) {
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
                        messageMicro = ((MessageMicro) this.f413437e.newInstance()).mergeFrom(byteArray);
                    } catch (Exception e16) {
                        g.e("ICGameNetCore", i16 + " - parse rsp body Exception", e16);
                    }
                    MessageMicro messageMicro2 = messageMicro;
                    if (z16) {
                        a.b(this.f413436d, z17, i17, i18, i19, string, string2, messageMicro2, fromServiceMsg);
                        return;
                    } else {
                        this.f413436d.a(messageMicro2, fromServiceMsg);
                        return;
                    }
                }
                if (z16) {
                    g.d("ICGameNetCore", i16 + "- success, but parse rsp body empty! " + byteArray);
                }
                messageMicro = null;
                MessageMicro messageMicro22 = messageMicro;
                if (z16) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(c cVar, boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable MessageMicro messageMicro, @Nullable FromServiceMsg fromServiceMsg) {
        if (cVar != null) {
            cVar.b(z16, i3, i16, i17, str, str2, messageMicro, fromServiceMsg);
        }
    }

    public static void c(AppRuntime appRuntime, NewIntent newIntent, Class<? extends MessageMicro> cls, c cVar) {
        g.h("ICGameNetCore", "sendRequest appRuntime:" + appRuntime);
        if (newIntent == null) {
            g.e("ICGameNetCore", "sendRequest but NewIntent is null! " + newIntent + " - " + cls, new Exception());
            b(cVar, false, -11, -1, 0, "", "NewIntent is null", null, null);
            return;
        }
        if (appRuntime == null) {
            appRuntime = bu0.a.a();
        }
        if (appRuntime == null) {
            g.e("ICGameNetCore", "sendRequest but runtime is null! " + newIntent + " - " + cls, new Exception());
            b(cVar, false, -22, -1, 0, "", "AppRunTime is null", null, null);
            return;
        }
        newIntent.setObserver(new C10692a(cVar, cls));
        appRuntime.startServlet(newIntent);
        g.h("ICGameNetCore", "startServlet appRuntime:" + appRuntime);
    }
}
