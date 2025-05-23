package com.tencent.could.component.common.ai.eventreport.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.could.component.common.ai.eventreport.utils.DeviceInfoUtil;
import com.tencent.could.component.common.ai.eventreport.utils.a;
import com.tencent.could.component.common.ai.eventreport.utils.b;
import com.tencent.could.component.common.ai.eventreport.utils.c;
import com.tencent.could.component.common.ai.eventreport.utils.e;
import com.tencent.could.component.common.ai.net.HttpMethod;
import com.tencent.could.component.common.ai.net.TXCHttp;
import com.tencent.could.component.common.ai.utils.ThreadPoolUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EventReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static String f99942d;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f99943a;

    /* renamed from: b, reason: collision with root package name */
    public EventReportConfig f99944b;

    /* renamed from: c, reason: collision with root package name */
    public String f99945c;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class EventReporterHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final EventReporter f99946a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13788);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f99946a = new EventReporter();
            }
        }

        public EventReporterHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14263);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99942d = EventReportConfig.STRING_INIT;
        }
    }

    public EventReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99945c = EventReportConfig.STRING_INIT;
        }
    }

    public static EventReporter getInstance() {
        return EventReporterHolder.f99946a;
    }

    public void doReportDeviceInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        String a16 = e.a(getInstance().getEventReportConfig().getDeviceInfoUrl(), str);
        String createDeviceInfo = DeviceInfoUtil.createDeviceInfo();
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(a16).setGzip(true).setHttpMethod(HttpMethod.POST).setRequestData(createDeviceInfo).setRequestHeaders(null).createNetWorkParam(), new a());
    }

    public void doReportErrorInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3);
        } else {
            ThreadPoolUtil.getInstance().addWork(new c(str, str2, str3));
        }
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        WeakReference<Context> weakReference = this.f99943a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getDeviceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f99945c;
    }

    public String getDeviceModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return f99942d;
    }

    public EventReportConfig getEventReportConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EventReportConfig) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        EventReportConfig eventReportConfig = this.f99944b;
        if (eventReportConfig == null) {
            return EventReportConfig.builder().create();
        }
        return eventReportConfig;
    }

    public void initEventReporter(Context context, EventReportConfig eventReportConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) eventReportConfig);
        } else {
            this.f99943a = new WeakReference<>(context);
            this.f99944b = eventReportConfig;
        }
    }

    public void setDeviceId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.f99945c = str;
        }
    }

    public void setDeviceModel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            f99942d = str;
        }
    }

    public void doReportDeviceInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        String a16 = e.a(getInstance().getEventReportConfig().getDeviceInfoUrl(), str);
        String createDeviceInfo = DeviceInfoUtil.createDeviceInfo();
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String str3 = "";
        if (!TextUtils.isEmpty(createDeviceInfo) && !TextUtils.isEmpty(str2)) {
            String substring = str2.substring(1, Integer.parseInt(str2.substring(0, 1)) + 1);
            byte[] bytes = createDeviceInfo.getBytes();
            byte[] bytes2 = substring.getBytes();
            if (bytes == null) {
                bytes = bytes2;
            } else if (bytes2 != null) {
                byte[] bArr = new byte[bytes.length + bytes2.length];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
                bytes = bArr;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                StringBuilder sb5 = new StringBuilder();
                if (digest != null && digest.length > 0) {
                    for (byte b16 : digest) {
                        String hexString = Integer.toHexString(b16 & 255);
                        if (hexString.length() < 2) {
                            sb5.append(0);
                        }
                        sb5.append(hexString);
                    }
                    str3 = sb5.toString().toLowerCase();
                }
            } catch (NoSuchAlgorithmException e16) {
                Log.e(CommonUtils.TAG, "md5 error: " + e16.getLocalizedMessage());
            }
        }
        hashMap.put("summary", str3);
        TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(a16).setGzip(true).setHttpMethod(HttpMethod.POST).setRequestData(createDeviceInfo).setRequestHeaders(hashMap).createNetWorkParam(), new b());
    }
}
