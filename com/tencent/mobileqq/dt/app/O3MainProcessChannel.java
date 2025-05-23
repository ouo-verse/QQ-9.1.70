package com.tencent.mobileqq.dt.app;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.channel.ChannelManager;
import com.tencent.mobileqq.channel.ChannelProxy;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.time.DurationKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class O3MainProcessChannel {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f203707a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicLong f203708b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<Long, Long> f203709c;

    /* loaded from: classes5.dex */
    public static class a extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ long d(a aVar) {
            throw null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26148);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f203707a = "FEKit_MainProcessChannelProxy";
        f203708b = new AtomicLong(DurationKt.MAX_MILLIS);
        f203709c = new HashMap<>(32);
    }

    public static void d() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Context applicationContext = peekAppRuntime.getApplicationContext();
            byte[] c16 = com.tencent.mobileqq.guid.c.f213821a.c();
            if (c16 != null && c16.length > 0) {
                str = HexUtil.bytes2HexStr(c16);
            } else {
                str = "";
            }
            FEKit.getInstance().initM(applicationContext, peekAppRuntime.getCurrentUin(), str, o.c(), ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion(), new ChannelProxy() { // from class: com.tencent.mobileqq.dt.app.O3MainProcessChannel.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.channel.ChannelProxy
                public void sendMessage(String str2, byte[] bArr, long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, str2, bArr, Long.valueOf(j3));
                        return;
                    }
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface == null) {
                        QLog.e(O3MainProcessChannel.f203707a, 1, "sendRequest but AppInterface is null");
                        return;
                    }
                    O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) appInterface.getBusinessHandler(O3BusinessHandler.class.getName());
                    if (o3BusinessHandler != null && bArr != null && str2 != null) {
                        QLog.e(O3MainProcessChannel.f203707a, 1, "sendRequest O3MainProcessChannelBusinessObserver,cmd:" + str2 + "callbackid:" + j3 + ",data len:" + bArr.length);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            String str3 = new String(Base64.encode(bArr, 0));
                            jSONObject.put("cmd", str2);
                            jSONObject.put("send_data", str3);
                            long incrementAndGet = O3MainProcessChannel.f203708b.incrementAndGet();
                            O3MainProcessChannel.f203709c.put(Long.valueOf(incrementAndGet), Long.valueOf(j3));
                            jSONObject.put("j_callbackid", incrementAndGet);
                            o3BusinessHandler.D2("sendRequestPBJava", jSONObject.toString(), new com.tencent.mobileqq.dt.web.a() { // from class: com.tencent.mobileqq.dt.app.O3MainProcessChannel.2.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                    }
                                }

                                @Override // com.tencent.mobileqq.dt.web.a
                                public void b(int i3, @NonNull byte[] bArr2) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                        try {
                                            QLog.e(O3MainProcessChannel.f203707a, 1, "sendRequest O3MainProcessChannelBusinessObserver response code:" + i3);
                                            JSONObject jSONObject2 = new JSONObject(new String(bArr2, StandardCharsets.UTF_8));
                                            String optString = jSONObject2.optString("receive_data", "");
                                            String optString2 = jSONObject2.optString("cmd", "");
                                            long optLong = jSONObject2.optLong("j_callbackid", -1L);
                                            byte[] decode = Base64.decode(optString, 0);
                                            if (O3MainProcessChannel.f203709c.containsKey(Long.valueOf(optLong))) {
                                                Long l3 = (Long) O3MainProcessChannel.f203709c.get(Long.valueOf(optLong));
                                                QLog.e(O3MainProcessChannel.f203707a, 1, "receive cmd:" + optString2 + ",callbackid:" + optLong + ",receivePbData len:" + decode.length);
                                                if (l3 != null) {
                                                    ThreadManagerV2.excute(new Runnable(optString2, decode, i3, l3.longValue()) { // from class: com.tencent.mobileqq.dt.app.O3MainProcessChannel.2.1.1
                                                        static IPatchRedirector $redirector_;

                                                        /* renamed from: d, reason: collision with root package name */
                                                        final /* synthetic */ String f203711d;

                                                        /* renamed from: e, reason: collision with root package name */
                                                        final /* synthetic */ byte[] f203712e;

                                                        /* renamed from: f, reason: collision with root package name */
                                                        final /* synthetic */ int f203713f;

                                                        /* renamed from: h, reason: collision with root package name */
                                                        final /* synthetic */ long f203714h;

                                                        {
                                                            this.f203711d = optString2;
                                                            this.f203712e = decode;
                                                            this.f203713f = i3;
                                                            this.f203714h = r9;
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, optString2, decode, Integer.valueOf(i3), Long.valueOf(r9));
                                                            }
                                                        }

                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            boolean z16;
                                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                                return;
                                                            }
                                                            ChannelManager channelManager = ChannelManager.getInstance();
                                                            String str4 = this.f203711d;
                                                            byte[] bArr3 = this.f203712e;
                                                            int i16 = this.f203713f;
                                                            if (i16 == 1000) {
                                                                z16 = true;
                                                            } else {
                                                                z16 = false;
                                                            }
                                                            channelManager.onNativeReceive(str4, bArr3, z16, i16, this.f203714h);
                                                        }
                                                    }, 16, null, false);
                                                    return;
                                                }
                                                return;
                                            }
                                            QLog.e(O3MainProcessChannel.f203707a, 1, "no callback find!");
                                            return;
                                        } catch (Throwable th5) {
                                            QLog.e(O3MainProcessChannel.f203707a, 1, "receive JSONException e:" + th5);
                                            return;
                                        }
                                    }
                                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) bArr2);
                                }
                            });
                            return;
                        } catch (JSONException e16) {
                            QLog.e(O3MainProcessChannel.f203707a, 1, "send json exception:" + e16.getMessage());
                            return;
                        }
                    }
                    QLog.e(O3MainProcessChannel.f203707a, 1, "sendRequest but handler is null");
                }
            });
        }
    }

    public static void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.dt.app.O3MainProcessChannel.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    O3MainProcessChannel.d();
                }
            }
        }, 16, null, false);
    }
}
