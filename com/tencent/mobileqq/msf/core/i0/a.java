package com.tencent.mobileqq.msf.core.i0;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static final String f248457e = "WeakNetConfigManager";

    /* renamed from: f, reason: collision with root package name */
    private static final String f248458f = "mobileQQ";

    /* renamed from: g, reason: collision with root package name */
    private static final String f248459g = "msf_weaket_switcher";

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f248460a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f248461b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f248462c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f248463d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f248464a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11085);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f248464a = new a(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ a(C8082a c8082a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8082a);
    }

    public static a v() {
        return b.f248464a;
    }

    public void a(@NonNull ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object obj = toServiceMsg.getAttributes().get(BaseConstants.KEY_MSF_WEAK_NET_CONFIG_ALL);
        if (obj instanceof String) {
            String str = (String) obj;
            try {
                JSONObject jSONObject = new JSONObject(str);
                AtomicInteger atomicInteger = this.f248461b;
                atomicInteger.set(jSONObject.optInt(BaseConstants.KEY_WEAK_NET_STRATEGY, atomicInteger.get()));
                AtomicBoolean atomicBoolean = this.f248462c;
                atomicBoolean.set(jSONObject.optBoolean(BaseConstants.KEY_IS_USE_NEW_WEAK_NET_DETECTOR, atomicBoolean.get()));
                this.f248463d.putAll(MsfSdkUtils.convertJsonToMap(jSONObject.optString(BaseConstants.KEY_WEAK_NET_CONFIG, "")));
                MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 0).edit().putString(BaseConstants.KEY_MSF_WEAK_NET_CONFIG_ALL, str).apply();
                QLog.d(f248457e, 1, "[onUpdateConfig], weakNetStrategy: " + this.f248461b.get() + ", isUseNewWeakNetDetector: " + this.f248462c.get() + ", config: " + this.f248463d);
            } catch (JSONException e16) {
                QLog.d(f248457e, 2, "onUpdateConfig with exception !", e16);
            }
        }
    }

    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null || BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            return;
        }
        Object attribute = toServiceMsg.getAttribute(BaseConstants.KEY_WEAK_NET_DEBUG_FLOAT_SWITCH);
        if (attribute instanceof Boolean) {
            this.f248460a.set(((Boolean) attribute).booleanValue());
            MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).edit().putBoolean(BaseConstants.KEY_WEAK_NET_DEBUG_FLOAT_SWITCH, this.f248460a.get()).apply();
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getCountBC error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_COUNT_BC, 2);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_COUNT_BC)) {
            String str = this.f248463d.get(BaseConstants.KEY_COUNT_BC);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 2;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getCountBN error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_COUNT_BN, 2);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_COUNT_BN)) {
            String str = this.f248463d.get(BaseConstants.KEY_COUNT_BN);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 2;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getMaxHeartBeatCost error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_MAX_HEART_BEAT_COST, 3000);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_MAX_HEART_BEAT_COST)) {
            String str = this.f248463d.get(BaseConstants.KEY_MAX_HEART_BEAT_COST);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 3000;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getMinHeartBeatCost error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_MIN_HEART_BEAT_COST, 500);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_MIN_HEART_BEAT_COST)) {
            String str = this.f248463d.get(BaseConstants.KEY_MIN_HEART_BEAT_COST);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 500;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getPingCost error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_PING_COST, 3000);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_PING_COST)) {
            String str = this.f248463d.get(BaseConstants.KEY_PING_COST);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 3000;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getQuickSendCheck error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getBoolean(BaseConstants.KEY_IS_QUICK_SEND_CHECK, true);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_IS_QUICK_SEND_CHECK)) {
            String str = this.f248463d.get(BaseConstants.KEY_IS_QUICK_SEND_CHECK);
            Objects.requireNonNull(str);
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public float i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Float) iPatchRedirector.redirect((short) 26, (Object) this)).floatValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getRttDownBoundFactor error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getFloat(BaseConstants.KEY_RTT_LOW_BOUND_FACTOR, 2.0f);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_RTT_LOW_BOUND_FACTOR)) {
            String str = this.f248463d.get(BaseConstants.KEY_RTT_LOW_BOUND_FACTOR);
            Objects.requireNonNull(str);
            return Float.parseFloat(str);
        }
        return 2.0f;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getRttLowBound error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_RTT_LOW_BOUND, 500);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_RTT_LOW_BOUND)) {
            String str = this.f248463d.get(BaseConstants.KEY_RTT_LOW_BOUND);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 500;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getRttUpBound error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_RTT_UP_BOUND, 3000);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_RTT_UP_BOUND)) {
            String str = this.f248463d.get(BaseConstants.KEY_RTT_UP_BOUND);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 3000;
    }

    public float l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, (Object) this)).floatValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getRttUpBoundFactor error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getFloat(BaseConstants.KEY_RTT_UP_BOUND_FACTOR, 3.0f);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_RTT_UP_BOUND_FACTOR)) {
            String str = this.f248463d.get(BaseConstants.KEY_RTT_UP_BOUND_FACTOR);
            Objects.requireNonNull(str);
            return Float.parseFloat(str);
        }
        return 3.0f;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getScreenOffCheck error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getBoolean(BaseConstants.KEY_IS_SCREEN_OFF_CHECK, true);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_IS_SCREEN_OFF_CHECK)) {
            String str = this.f248463d.get(BaseConstants.KEY_IS_SCREEN_OFF_CHECK);
            Objects.requireNonNull(str);
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getTimeoutBNBC error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_TIMEOUT_BNBC, 2000);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_TIMEOUT_BNBC)) {
            String str = this.f248463d.get(BaseConstants.KEY_TIMEOUT_BNBC);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 2000;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getBoolean(BaseConstants.KEY_IS_NEW_WEAK_NET_ENABLE, true);
        }
        return this.f248462c.get();
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getUseSSORouteCost error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getBoolean(BaseConstants.KEY_IS_USE_SSO_ROUTE_COST, true);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_IS_USE_SSO_ROUTE_COST)) {
            String str = this.f248463d.get(BaseConstants.KEY_IS_USE_SSO_ROUTE_COST);
            Objects.requireNonNull(str);
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getWaitTimeQuickSend error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_TIME_WAIT_QUICK_SEND, 2000);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_TIME_WAIT_QUICK_SEND)) {
            String str = this.f248463d.get(BaseConstants.KEY_TIME_WAIT_QUICK_SEND);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 2000;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f248460a.get();
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getWeakNetEnable error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getBoolean(BaseConstants.KEY_IS_WEAK_NET_ENABLE, true);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_IS_WEAK_NET_ENABLE)) {
            String str = this.f248463d.get(BaseConstants.KEY_IS_WEAK_NET_ENABLE);
            Objects.requireNonNull(str);
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f248461b.get();
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "MSFWeakNetConfig:{ weakNetStrategy: " + this.f248461b.get() + ", isUseNewWeakNetDetector: " + this.f248462c.get() + ", config: " + this.f248463d + "}";
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getWifiSignal error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_WIFI_SIGNAL, 20);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_WIFI_SIGNAL)) {
            String str = this.f248463d.get(BaseConstants.KEY_WIFI_SIGNAL);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 20;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            return BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean(f248459g, true);
        }
        return v().s();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f248460a = atomicBoolean;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.f248461b = atomicInteger;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        this.f248462c = atomicBoolean2;
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.f248463d = concurrentHashMap;
        SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4);
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            atomicBoolean.set(sharedPreferences.getBoolean(BaseConstants.KEY_WEAK_NET_DEBUG_FLOAT_SWITCH, atomicBoolean.get()));
        }
        String string = sharedPreferences.getString(BaseConstants.KEY_MSF_WEAK_NET_CONFIG_ALL, "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            atomicInteger.set(jSONObject.optInt(BaseConstants.KEY_WEAK_NET_STRATEGY, atomicInteger.get()));
            atomicBoolean2.set(jSONObject.optBoolean(BaseConstants.KEY_IS_USE_NEW_WEAK_NET_DETECTOR, atomicBoolean2.get()));
            concurrentHashMap.putAll(MsfSdkUtils.convertJsonToMap(jSONObject.optString(BaseConstants.KEY_WEAK_NET_CONFIG, "")));
            QLog.d(f248457e, 1, "[init], weakNetStrategy: " + atomicInteger.get() + ", isUseNewWeakNetDetector: " + atomicBoolean2.get() + ", config: " + concurrentHashMap);
        } catch (JSONException e16) {
            QLog.d(f248457e, 2, "init with exception !", e16);
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getConnCost error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_CONN_COST, 3000);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_CONN_COST)) {
            String str = this.f248463d.get(BaseConstants.KEY_CONN_COST);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 3000;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        try {
        } catch (Exception e16) {
            QLog.d(f248457e, 1, "getBnBcStrategy error", e16);
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && this.f248460a.get()) {
            return MsfService.getCore().getSharedPreferences(BaseConstants.MSF_WEAK_NET_SP_NAME, 4).getInt(BaseConstants.KEY_BNBC_STRATEGY, 1);
        }
        if (this.f248463d.containsKey(BaseConstants.KEY_BNBC_STRATEGY)) {
            String str = this.f248463d.get(BaseConstants.KEY_BNBC_STRATEGY);
            Objects.requireNonNull(str);
            return Integer.parseInt(str);
        }
        return 1;
    }
}
