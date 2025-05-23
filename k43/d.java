package k43;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ads.data.AdParam;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.mobileqq.vashealth.hippy.HealthModule;
import com.tencent.mobileqq.vashealth.honorstep.g;
import com.tencent.mobileqq.vashealth.huawei.HuaWeiStepAuthManager;
import com.tencent.mobileqq.vashealth.huaweistep.HuaweiStepHelper;
import com.tencent.mobileqq.vashealth.m;
import com.tencent.mobileqq.vashealth.step.k;
import com.tencent.mobileqq.vashealth.step.l;
import com.tencent.mobileqq.vashealth.t;
import com.tencent.mobileqq.vashealth.u;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerReq;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import i01.e;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 \u001d2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bL\u0010MJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\r\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\u000e\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\u000f\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\u0010\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J9\u0010\u0013\u001a\u00020\t2'\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J5\u0010\u0014\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\u0015\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J9\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162'\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\nH\u0002JA\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162'\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001a\u0010\"\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010'\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020\tH\u0002J\u001c\u0010,\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u00162\b\u0010+\u001a\u0004\u0018\u00010\u0016H\u0002J=\u0010.\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010-\u001a\u00020#H\u0002J\n\u00100\u001a\u0004\u0018\u00010/H\u0002J5\u00101\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u00102\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016R2\u00109\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!05j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!`68\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R2\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!05j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!`68\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R2\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!05j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!`68\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00108R$\u0010D\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR$\u0010K\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010?\u001a\u0004\bI\u0010A\"\u0004\bJ\u0010C\u00a8\u0006O"}, d2 = {"Lk43/d;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "L", "D", "y", "I", "o", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "l", "w", "G", "Lorg/json/JSONObject;", "reportJson", "J", "dataJson", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", BdhLogUtil.LogTag.Tag_Conn, "cmd", "Lcom/tencent/mobileqq/vashealth/websso/WebSSOAgent$UniSsoServerRsp;", "response", "", "j", "", "msfResultCode", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "svrCostTime", "B", UserInfo.SEX_FEMALE, "target", "source", "E", "retCode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/common/app/AppInterface;", "v", "t", "u", "method", "call", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "mPkgSizeMap", "e", "mLastRequestTimeMap", "f", "mIntervalTimeMap", h.F, "Ljava/lang/String;", "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "model", "i", "getImei", "setImei", "imei", "getZone", "setZone", "zone", "<init>", "()V", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, Long> mPkgSizeMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, Long> mLastRequestTimeMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, Long> mIntervalTimeMap = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String model;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String imei;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String zone;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"k43/d$b", "Lcom/tencent/mobileqq/vashealth/huawei/b;", "", "a", "b", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.mobileqq.vashealth.huawei.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f411703a;

        b(Function1<Object, Unit> function1) {
            this.f411703a = function1;
        }

        @Override // com.tencent.mobileqq.vashealth.huawei.b
        public void a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", 0);
            this.f411703a.invoke(jSONObject);
            QLog.d("QQKuiklyHealthModule", 1, "kuikly callback cancelSuccess");
        }

        @Override // com.tencent.mobileqq.vashealth.huawei.b
        public void b() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", -1);
            this.f411703a.invoke(jSONObject);
            QLog.d("QQKuiklyHealthModule", 1, "kuikly callback cancelFailed");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"k43/d$c", "Lcom/tencent/mobileqq/vashealth/t;", "", "b", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements t {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f411705b;

        c(Function1<Object, Unit> function1) {
            this.f411705b = function1;
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void a() {
            d.this.l(this.f411705b, false);
            QLog.d("QQKuiklyHealthModule", 1, "kuikly callback permissionDenied");
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void b() {
            d.this.l(this.f411705b, true);
            StepCounterPermissionUtils.q();
            QLog.d("QQKuiklyHealthModule", 1, "kuikly callback permissionAllowed");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"k43/d$d", "Lcom/tencent/mobileqq/vashealth/m$a;", "", "isSuccess", "", "b", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k43.d$d, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C10633d implements m.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f411707b;

        C10633d(Function1<Object, Unit> function1) {
            this.f411707b = function1;
        }

        @Override // com.tencent.mobileqq.vashealth.m.a
        public /* bridge */ /* synthetic */ void a(Boolean bool) {
            b(bool.booleanValue());
        }

        public void b(boolean isSuccess) {
            int i3;
            d dVar = d.this;
            Function1<Object, Unit> function1 = this.f411707b;
            if (isSuccess) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            dVar.m(function1, i3);
        }
    }

    private final JSONObject A(WebSSOAgent$UniSsoServerRsp response) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", 0);
        if (response.ret.has()) {
            jSONObject.put("retCode", (int) response.ret.get());
        } else {
            jSONObject.put("retCode", 0);
        }
        if (response.errmsg.has()) {
            jSONObject.put("msg", response.errmsg.get());
        } else {
            jSONObject.put("msg", "SSO\u53d1\u9001\u6210\u529f");
        }
        if (response.rspdata.has()) {
            jSONObject.put("data", response.rspdata.get());
        }
        return jSONObject;
    }

    private final JSONObject B(long svrCostTime) {
        com.tencent.mobileqq.vashealth.websso.a.f312357h = System.currentTimeMillis();
        long j3 = com.tencent.mobileqq.vashealth.websso.a.f312355e - com.tencent.mobileqq.vashealth.websso.a.f312354d;
        long j16 = com.tencent.mobileqq.vashealth.websso.a.f312356f - com.tencent.mobileqq.vashealth.websso.a.f312355e;
        long j17 = com.tencent.mobileqq.vashealth.websso.a.f312357h - com.tencent.mobileqq.vashealth.websso.a.f312356f;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packTime", j3);
        jSONObject.put("SSONetworkTime", j16);
        jSONObject.put("unpackTime", j17);
        jSONObject.put("serverProcessTime", svrCostTime);
        return jSONObject;
    }

    private final String C(JSONObject reportJson) {
        int optInt = reportJson.optInt("step", 0);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 1);
        jSONObject.put("time", NetConnInfoCenter.getServerTime());
        jSONObject.put("steps", optInt);
        reportJson.put(AdParam.CONSUMERID, 1002);
        reportJson.put("data", new JSONArray().mo162put(jSONObject));
        reportJson.put("version", AppSetting.f99551k);
        if (TextUtils.isEmpty(this.model)) {
            this.model = URLEncoder.encode(DeviceInfoMonitor.getModel(), "utf-8");
        }
        reportJson.put("model", this.model);
        if (TextUtils.isEmpty(this.zone)) {
            TimeZone timeZone = TimeZone.getDefault();
            this.zone = timeZone.getDisplayName(false, 0) + " " + timeZone.getID();
        }
        reportJson.put("zone", String.valueOf(this.zone));
        if (TextUtils.isEmpty(this.imei)) {
            this.imei = QQDeviceInfo.getQIMEI();
        }
        reportJson.put("imei", String.valueOf(this.imei));
        if (QLog.isColorLevel()) {
            QLog.i("QQKuiklyHealthModule", 2, "report parameters is:" + reportJson);
        }
        String jSONObject2 = reportJson.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "reportJson.toString()");
        return jSONObject2;
    }

    private final void D(Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyHealthModule", 1, "kuikly call getStepCounterPermission");
        if (callback == null) {
            QLog.e("QQKuiklyHealthModule", 1, "getStepCounterPermission error: callback is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, StepCounterPermissionUtils.f());
            if (StepCounterPermissionUtils.m()) {
                jSONObject.put("systemPermission", StepCounterPermissionUtils.c());
            }
            callback.invoke(jSONObject);
            StepCounterPermissionUtils.q();
        } catch (Exception e16) {
            callback.invoke(e16.toString());
            QLog.e("QQKuiklyHealthModule", 1, e16, new Object[0]);
        }
    }

    private final void E(JSONObject target, JSONObject source) {
        if (target != null && source != null) {
            Iterator keys = source.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object opt = source.opt(str);
                if (!target.has(str)) {
                    try {
                        target.putOpt(str, opt);
                    } catch (JSONException e16) {
                        QLog.e("QQKuiklyHealthModule", 1, "mergeJson error:", e16);
                    }
                }
            }
        }
    }

    private final void F() {
        if (getActivity() != null && v() != null) {
            try {
                NewIntent newIntent = new NewIntent(getActivity(), u.class);
                newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_UPDATE_LAST_REPORT_TIME);
                newIntent.putExtra("last_report_time", NetConnInfoCenter.getServerTimeMillis());
                AppInterface v3 = v();
                if (v3 != null) {
                    v3.startServlet(newIntent);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQKuiklyHealthModule", 2, "Exception:" + e16);
                }
            }
        }
    }

    private final void G(final Function1<Object, Unit> callback) {
        Object obj;
        Context applicationContext;
        QLog.d("QQKuiklyHealthModule", 1, "kuikly call readHKData");
        if (callback == null) {
            QLog.e("QQKuiklyHealthModule", 1, "readHKData error: callback is null");
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("step", 0);
        try {
            Activity activity = getActivity();
            MobileQQ mobileQQ = null;
            if (activity != null && (applicationContext = activity.getApplicationContext()) != null) {
                obj = applicationContext.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.hardware.SensorManager");
            if (SensorMonitor.getDefaultSensor((SensorManager) obj, 19) == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", 255);
                jSONObject2.put("retCode", -1);
                jSONObject2.put("msg", HardCodeUtil.qqStr(R.string.n7r));
                callback.invoke(jSONObject2);
                return;
            }
            k kVar = k.f312340a;
            if (kVar.j()) {
                jSONObject.put("result", 0);
                jSONObject.put("retCode", kVar.q());
                callback.invoke(jSONObject);
                return;
            }
            AppInterface v3 = v();
            if (v3 != null) {
                mobileQQ = v3.getApplication();
            }
            NewIntent newIntent = new NewIntent(mobileQQ, u.class);
            newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
            newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
            newIntent.setObserver(new BusinessObserver() { // from class: k43.a
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    d.H(JSONObject.this, this, callback, i3, z16, bundle);
                }
            });
            AppInterface v16 = v();
            if (v16 != null) {
                v16.startServlet(newIntent);
            }
        } catch (JSONException e16) {
            QLog.e("QQKuiklyHealthModule", 1, "receive stepInfoJson failed exception is:" + e16);
            callback.invoke(e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(JSONObject stepResult, d this$0, Function1 function1, int i3, boolean z16, Bundle bundle) {
        Map map;
        Intrinsics.checkNotNullParameter(stepResult, "$stepResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            try {
                try {
                    Serializable serializable = bundle.getSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY);
                    if (serializable instanceof Map) {
                        map = (Map) serializable;
                    } else {
                        map = null;
                    }
                    long d16 = SSOHttpUtils.d() / 1000;
                    boolean z17 = false;
                    if (map != null && map.containsKey(Long.valueOf(d16))) {
                        z17 = true;
                    }
                    if (z17) {
                        stepResult.put("step", map.get(Long.valueOf(d16)));
                        QLog.e("QQKuiklyHealthModule", 1, "stepHistory step:" + map.get(Long.valueOf(d16)));
                    }
                    int[] e16 = SSOHttpUtils.e();
                    int i16 = e16[1];
                    if (i16 > 0) {
                        QLog.e("QQKuiklyHealthModule", 1, "use device step:" + i16);
                        stepResult.put("step", e16[1]);
                    }
                    stepResult.put("isStepCounterEnable", bundle.getBoolean(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE, true));
                } catch (JSONException e17) {
                    QLog.e("QQKuiklyHealthModule", 1, "receive stepInfoJson failed exception is:" + e17);
                }
            } finally {
                this$0.J(stepResult, function1);
            }
        }
    }

    private final void I(Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyHealthModule", 1, "kuikly call requestStepCounterPermission");
        if (callback == null) {
            QLog.e("QQKuiklyHealthModule", 1, "requestStepCounterPermission error: callback is null");
        } else {
            StepCounterPermissionUtils.x(new c(callback));
        }
    }

    private final void J(JSONObject reportJson, final Function1<Object, Unit> callback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", 255);
        jSONObject.put("retCode", -1);
        jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7u));
        if (p(reportJson, callback, jSONObject)) {
            return;
        }
        try {
            if (!NetworkUtil.isNetworkAvailable(getActivity())) {
                jSONObject.put("result", 103);
                jSONObject.put("msg", "MSF\u672a\u8fde\u63a5");
                callback.invoke(jSONObject);
                return;
            }
            if (q(reportJson)) {
                jSONObject.put("result", 101);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7m));
                callback.invoke(jSONObject);
                return;
            }
            if (r()) {
                jSONObject.put("result", 102);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7l));
                callback.invoke(jSONObject);
                return;
            }
            this.mLastRequestTimeMap.put(HealthModule.REPORT_STEP_CMD, Long.valueOf(System.currentTimeMillis()));
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            webSSOAgent$UniSsoServerReq.reqdata.set(C(reportJson));
            BusinessObserver businessObserver = new BusinessObserver() { // from class: k43.c
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    d.K(d.this, callback, i3, z16, bundle);
                }
            };
            if (v() != null) {
                NewIntent newIntent = new NewIntent(getActivity(), com.tencent.mobileqq.vashealth.websso.a.class);
                newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, HealthModule.REPORT_STEP_CMD);
                newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
                newIntent.setObserver(businessObserver);
                AppInterface v3 = v();
                if (v3 != null) {
                    v3.startServlet(newIntent);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQKuiklyHealthModule", 2, "Exception:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(d this$0, Function1 callback, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            JSONObject jSONObject = new JSONObject();
            long j3 = -1;
            if (z16) {
                byte[] byteArray = bundle.getByteArray("extra_data");
                if (byteArray != null) {
                    WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                    webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                    j3 = this$0.j(bundle.getString(WadlProxyConsts.EXTRA_CMD), webSSOAgent$UniSsoServerRsp);
                    jSONObject = this$0.A(webSSOAgent$UniSsoServerRsp);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.w("QQKuiklyHealthModule", 2, "uniAgent, onReceive, ret success but no data");
                    }
                    jSONObject.put("result", 255);
                    jSONObject.put("retCode", -1);
                    jSONObject.put("msg", "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                }
                this$0.F();
            } else {
                jSONObject = this$0.z(bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE));
            }
            QLog.i("QQKuiklyHealthModule", 1, "get report result is:" + jSONObject);
            this$0.E(jSONObject, this$0.B(j3));
            callback.invoke(jSONObject);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQKuiklyHealthModule", 2, "uniAgent, onReceive, Exception: " + e16);
            }
        }
    }

    private final void L(String params, Function1<Object, Unit> callback) {
        if (!TextUtils.isEmpty(params) && callback != null) {
            try {
                String optString = new JSONObject(params).optString(EditPicActivity.IMAGE_PATH);
                Intrinsics.checkNotNullExpressionValue(optString, "paramsJson.optString(\"image_path\")");
                if (TextUtils.isEmpty(optString)) {
                    QLog.e("QQKuiklyHealthModule", 1, "shareSnapshotToGuild image src is empty");
                    m(callback, -1);
                    return;
                } else {
                    m.f(optString, getActivity(), new C10633d(callback));
                    return;
                }
            } catch (Exception e16) {
                QLog.e("QQKuiklyHealthModule", 1, "shareSnapshotToGuild params parse error:" + e16);
                m(callback, -1);
                return;
            }
        }
        QLog.e("QQKuiklyHealthModule", 1, "shareSnapshotToGuild params error");
        m(callback, -1);
    }

    private final long j(String cmd, WebSSOAgent$UniSsoServerRsp response) {
        if (!TextUtils.isEmpty(cmd) && cmd != null) {
            if (response.comm.delayms.has()) {
                this.mIntervalTimeMap.put(cmd, Long.valueOf(response.comm.delayms.get()));
            }
            if (response.comm.packagesize.has()) {
                this.mPkgSizeMap.put(cmd, Long.valueOf(response.comm.packagesize.get()));
            }
            if (response.comm.proctime.has()) {
                return response.comm.proctime.get();
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Function1<Object, Unit> callback, boolean permission) {
        StepCounterPermissionUtils.z(permission);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, StepCounterPermissionUtils.f());
            if (StepCounterPermissionUtils.m()) {
                jSONObject.put("systemPermission", StepCounterPermissionUtils.c());
            }
            callback.invoke(jSONObject);
        } catch (Throwable th5) {
            QLog.e("QQKuiklyHealthModule", 1, "requestStepCounterPermission callBackPermission:" + permission + " JSONObject put fail:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Function1<Object, Unit> callback, int retCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret_code", retCode);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    private final void o(Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyHealthModule", 1, "kuikly call cancelHuaweiPermission");
        if (callback == null) {
            QLog.e("QQKuiklyHealthModule", 1, "cancelHuaweiPermission error: callback is null");
            return;
        }
        int m3 = g.f312292a.m();
        b bVar = new b(callback);
        if (m3 != 1) {
            if (m3 != 2) {
                if (m3 == 3) {
                    m43.b.f416141a.e(bVar);
                    return;
                }
                return;
            }
            HuaWeiStepAuthManager.h(getContext()).f(bVar);
            return;
        }
        com.tencent.mobileqq.vashealth.honorstep.e.f312286a.g(bVar);
    }

    private final boolean p(JSONObject reportJson, Function1<Object, Unit> callback, JSONObject dataJson) {
        if (reportJson.length() <= 0) {
            callback.invoke(dataJson);
            return true;
        }
        if (reportJson.optInt("step", 0) == 0) {
            dataJson.put("retCode", 1);
            callback.invoke(dataJson);
            return true;
        }
        if (getActivity() == null) {
            callback.invoke(dataJson);
            return true;
        }
        if (reportJson.optBoolean("isStepCounterEnable", true)) {
            return false;
        }
        dataJson.put("retCode", 2);
        callback.invoke(dataJson);
        return true;
    }

    private final boolean q(JSONObject reportJson) {
        long j3;
        Long l3;
        if (this.mPkgSizeMap.containsKey(HealthModule.REPORT_STEP_CMD) && (l3 = this.mPkgSizeMap.get(HealthModule.REPORT_STEP_CMD)) != null) {
            j3 = l3.longValue();
        } else {
            j3 = 10240;
        }
        if (j3 > 0) {
            String jSONObject = reportJson.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "reportJson.toString()");
            Intrinsics.checkNotNullExpressionValue(jSONObject.getBytes(Charsets.UTF_8), "this as java.lang.String).getBytes(charset)");
            if (r5.length > j3) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean r() {
        long j3;
        long j16;
        Long l3;
        if (!this.mLastRequestTimeMap.containsKey(HealthModule.REPORT_STEP_CMD)) {
            return false;
        }
        Long l16 = this.mLastRequestTimeMap.get(HealthModule.REPORT_STEP_CMD);
        if (l16 != null) {
            j3 = l16.longValue();
        } else {
            j3 = 0;
        }
        if (this.mIntervalTimeMap.containsKey(HealthModule.REPORT_STEP_CMD) && (l3 = this.mIntervalTimeMap.get(HealthModule.REPORT_STEP_CMD)) != null) {
            j16 = l3.longValue();
        } else {
            j16 = 1000;
        }
        if (j16 <= 0 || System.currentTimeMillis() - j3 >= j16) {
            return false;
        }
        this.mLastRequestTimeMap.put(HealthModule.REPORT_STEP_CMD, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    private final void t(Function1<Object, Unit> callback) {
        QQPermission.enterModule("biz_src_qqsport");
    }

    private final void u(Function1<Object, Unit> callback) {
        QQPermission.exitModule("biz_src_qqsport");
    }

    private final AppInterface v() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void w(final Function1<Object, Unit> callback) {
        Application application;
        QLog.d("QQKuiklyHealthModule", 1, "kuikly call getCurrentStep");
        if (callback == null) {
            QLog.e("QQKuiklyHealthModule", 1, "getCurrentStep error: callback is null");
            return;
        }
        try {
            Activity activity = getActivity();
            if (activity != null) {
                application = activity.getApplication();
            } else {
                application = null;
            }
            NewIntent newIntent = new NewIntent(application, u.class);
            newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
            newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", -1);
            jSONObject.put("step", 0);
            k kVar = k.f312340a;
            if (kVar.j()) {
                int b16 = com.tencent.mobileqq.vashealth.step.e.f312337a.b(String.valueOf(l.f312344a.a(0)));
                jSONObject.put("retCode", kVar.q());
                int[] e16 = SSOHttpUtils.e();
                int i3 = e16[1];
                if (i3 > 0) {
                    QLog.e("QQKuiklyHealthModule", 1, "use device step:" + i3);
                    jSONObject.put("step", e16[1]);
                } else {
                    jSONObject.put("step", 0);
                }
                QLog.d("QQKuiklyHealthModule", 2, " current step: " + b16);
                callback.invoke(jSONObject);
                return;
            }
            newIntent.setObserver(new BusinessObserver() { // from class: k43.b
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i16, boolean z16, Bundle bundle) {
                    d.x(JSONObject.this, callback, i16, z16, bundle);
                }
            });
            AppInterface v3 = v();
            if (v3 != null) {
                v3.startServlet(newIntent);
            }
        } catch (Exception e17) {
            callback.invoke(e17.toString());
            QLog.e("QQKuiklyHealthModule", 1, e17, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(JSONObject stepResult, Function1 function1, int i3, boolean z16, Bundle bundle) {
        HashMap hashMap;
        boolean z17;
        String obj;
        Intrinsics.checkNotNullParameter(stepResult, "$stepResult");
        if (z16) {
            QLog.i("QQKuiklyHealthModule", 1, "QQKuiklyHealthModule receive stepInfoJson: " + bundle.getString("StepInfoJSON"));
            try {
                try {
                    stepResult.put("retCode", 0);
                    stepResult.put("step", 0);
                    Serializable serializable = bundle.getSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY);
                    if (serializable instanceof HashMap) {
                        hashMap = (HashMap) serializable;
                    } else {
                        hashMap = null;
                    }
                    long d16 = SSOHttpUtils.d() / 1000;
                    if (hashMap != null && hashMap.containsKey(Long.valueOf(d16))) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        Object obj2 = hashMap.get(Long.valueOf(d16));
                        if (obj2 != null && (obj = obj2.toString()) != null) {
                            Integer.parseInt(obj);
                            int[] e16 = SSOHttpUtils.e();
                            int i16 = e16[1];
                            if (i16 > 0) {
                                QLog.e("QQKuiklyHealthModule", 1, "use device step:" + i16);
                                stepResult.put("step", e16[1]);
                            } else {
                                stepResult.put("step", 0);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQKuiklyHealthModule", 2, " day key is: " + d16 + ", current step: " + obj2);
                        }
                    }
                } catch (JSONException e17) {
                    QLog.e("QQKuiklyHealthModule", 1, "receive stepInfoJson failed exception is:" + e17);
                    function1.invoke(e17.toString());
                }
            } finally {
                function1.invoke(stepResult);
            }
        }
    }

    private final void y(Function1<Object, Unit> callback) {
        int i3;
        QLog.d("QQKuiklyHealthModule", 1, "kuikly call getHuaWeiStepPermission");
        if (callback == null) {
            QLog.e("QQKuiklyHealthModule", 1, "getHuaWeiStepPermission error: callback is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (HuaweiStepHelper.isInHuaWeiSystemWhiteList()) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            if (StepCounterPermissionUtils.e()) {
                i3 = 1;
            }
            if (g.f312292a.n()) {
                i3 = 0;
            }
            if (StepCounterPermissionUtils.d()) {
                i3 = 1;
            }
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, i3);
            callback.invoke(jSONObject);
        } catch (Exception e16) {
            callback.invoke(e16.toString());
            QLog.e("QQKuiklyHealthModule", 1, e16, new Object[0]);
        }
    }

    private final JSONObject z(int msfResultCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", -1);
        if (msfResultCode != 1001) {
            if (msfResultCode != 1002 && msfResultCode != 1013) {
                jSONObject.put("result", 255);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7k));
            } else {
                jSONObject.put("result", 202);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7p));
            }
        } else {
            jSONObject.put("result", 201);
            jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7t));
        }
        return jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2138869209:
                if (method.equals("getDeviceStepPermission")) {
                    y(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -2037621259:
                if (method.equals("shareSnapshotToGuild")) {
                    L(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1722832439:
                if (method.equals("getStepCounterPermission")) {
                    D(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1369588472:
                if (method.equals("enterSportModule")) {
                    t(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -988498896:
                if (method.equals("requestStepCounterPermission")) {
                    I(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -854358941:
                if (method.equals("readHKData")) {
                    G(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -671022334:
                if (method.equals("exitSportModule")) {
                    u(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -39052625:
                if (method.equals("getCurrentStep")) {
                    w(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 150542155:
                if (method.equals("cancelDeviceStepPermission")) {
                    o(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
