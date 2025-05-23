package ih2;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b>\u0010?J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J?\u0010\u001b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J5\u0010\u001f\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010 \u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J5\u0010!\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\"\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010#\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J?\u0010$\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0012\u0010'\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010(\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)H\u0002JG\u0010.\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\u001e\u00104\u001a\u00020\t2\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020)01j\b\u0012\u0004\u0012\u00020)`2J\u000e\u00105\u001a\u00020\t2\u0006\u0010*\u001a\u00020)J\b\u00106\u001a\u00020\tH\u0016R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lih2/d;", "Li01/e;", "", "jsonParams", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "o", "params", "d", BdhLogUtil.LogTag.Tag_Conn, "G", "p", HippyTKDListViewAdapter.X, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "y", "u", "dataJson", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "B", "v", "H", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "i", "l", "c", "E", UserInfo.SEX_FEMALE, "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "I", "retCode", "retMsg", "a", "method", "call", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "wadlResults", "r", "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lih2/c;", "Lih2/c;", "wadlHostInterface", "Lcom/tencent/mobileqq/qqgamepub/hippy/module/e;", "e", "Lcom/tencent/mobileqq/qqgamepub/hippy/module/e;", "qqWadlWrapper", "<init>", "()V", "f", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c wadlHostInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqgamepub.hippy.module.e qqWadlWrapper;

    public d() {
        c cVar = new c(this);
        this.wadlHostInterface = cVar;
        this.qqWadlWrapper = new com.tencent.mobileqq.qqgamepub.hippy.module.e(cVar);
    }

    private final String A(Object params) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            return String.valueOf(this.qqWadlWrapper.u(str));
        }
        return "0";
    }

    private final int B(Object params) {
        return this.qqWadlWrapper.t();
    }

    private final void C() {
        this.qqWadlWrapper.v();
    }

    private final void D(String dataJson, Function1<Object, Unit> callback) {
        this.qqWadlWrapper.w(dataJson);
        a(0, null, callback);
    }

    private final int E(Object params) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            this.qqWadlWrapper.x(str);
            return 0;
        }
        return -1;
    }

    private final int F(Object params) {
        Object orNull;
        Integer num;
        int i3;
        Object orNull2;
        int i16;
        if (params instanceof Object[]) {
            Object[] objArr = (Object[]) params;
            orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
            Integer num2 = null;
            if (orNull instanceof Integer) {
                num = (Integer) orNull;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            orNull2 = ArraysKt___ArraysKt.getOrNull(objArr, 1);
            if (orNull2 instanceof Integer) {
                num2 = (Integer) orNull2;
            }
            if (num2 != null) {
                i16 = num2.intValue();
            } else {
                i16 = 0;
            }
            this.qqWadlWrapper.y(i16, i3);
            return 0;
        }
        return -1;
    }

    private final void G() {
        this.qqWadlWrapper.z();
    }

    private final int H(Object params) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            return this.qqWadlWrapper.A(str);
        }
        return -1;
    }

    private final String I(WadlResult wadlResult) {
        if (wadlResult != null) {
            try {
                if (wadlResult.wadlParams != null) {
                    JSONObject jSONObject = new JSONObject();
                    WadlParams wadlParams = wadlResult.wadlParams;
                    jSONObject.put("appid", wadlParams.appId);
                    jSONObject.put("downloadType", wadlParams.downloadType);
                    jSONObject.put("state", GameCenterUtil.convertRemoteStatusToLocal(wadlResult.taskStatus));
                    jSONObject.put("speed", wadlResult.speed);
                    jSONObject.put(WadlResult.WEB_KEY_PROGRESS, wadlResult.progress);
                    jSONObject.put(WadlResult.WEB_KEY_F_PROGRESS, wadlResult.floatProgress);
                    jSONObject.put("versionCode", wadlParams.versionCode);
                    jSONObject.put("packagename", wadlParams.packageName);
                    jSONObject.put("via", wadlParams.via);
                    jSONObject.put("mieActId", wadlParams.mieActId);
                    jSONObject.put(WadlResult.WEB_KEY_WRITE_CODE_STATE, 0);
                    jSONObject.put("extraInfo", wadlParams.extraData);
                    jSONObject.put(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK, wadlParams.getFlagEnable(1));
                    jSONObject.put(WadlResult.WEB_KEY_IS_RES, wadlParams.isRes);
                    int wadlErrCode = GameCenterUtil.getWadlErrCode(wadlResult.errCode);
                    jSONObject.put("errorCode", wadlErrCode);
                    jSONObject.put("errorMsg", GameCenterUtil.getWadlErrMsg(wadlErrCode));
                    jSONObject.put("appName", wadlParams.appName);
                    jSONObject.put("iconUrl", wadlParams.iconUrl);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "root.toString()");
                    return jSONObject2;
                }
            } catch (JSONException e16) {
                QLog.e("QQKuiklyWadlModule", 1, "wadlResultToJSON e:", e16);
            }
        }
        return "";
    }

    private final void a(int retCode, String retMsg, Function1<Object, Unit> callback) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", retCode);
            jSONObject.put("retMsg", retMsg);
            if (callback != null) {
                callback.invoke(jSONObject.toString());
            }
        } catch (JSONException e16) {
            QLog.e("QQKuiklyWadlModule", 1, "callbackResult e:", e16);
        }
    }

    private final int c() {
        return this.qqWadlWrapper.b();
    }

    private final void d(Object params) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            this.qqWadlWrapper.c(str);
        }
    }

    private final void g(String jsonParams, Function1<Object, Unit> callback) {
        this.qqWadlWrapper.e(jsonParams);
        a(0, null, callback);
    }

    private final void i(String jsonParams, Function1<Object, Unit> callback) {
        this.qqWadlWrapper.f(jsonParams);
        a(0, null, callback);
    }

    private final String j() {
        return String.valueOf(this.qqWadlWrapper.g());
    }

    private final int l() {
        return this.qqWadlWrapper.h();
    }

    private final String m(Object params) {
        Object orNull;
        String str;
        Object orNull2;
        if (params instanceof Object[]) {
            try {
                orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
                String str2 = null;
                if (orNull instanceof String) {
                    str = (String) orNull;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                orNull2 = ArraysKt___ArraysKt.getOrNull((Object[]) params, 1);
                if (orNull2 instanceof String) {
                    str2 = (String) orNull2;
                }
                if (str2 == null) {
                    str2 = "";
                }
                HashMap<String, Object> i3 = this.qqWadlWrapper.i(str, str2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("r", i3.get("r"));
                jSONObject.put("guid", i3.get("guid"));
                if (i3.containsKey("data")) {
                    jSONObject.put("data", (String) i3.get("data"));
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
                return jSONObject2;
            } catch (JSONException e16) {
                QLog.e("QQKuiklyWadlModule", 1, "getInstalledAppVersionCode e:", e16);
                return "";
            }
        }
        return "";
    }

    private final float o() {
        return this.qqWadlWrapper.j();
    }

    private final void p(String jsonParams) {
        this.qqWadlWrapper.k(jsonParams);
    }

    private final boolean q() {
        return this.qqWadlWrapper.l();
    }

    private final void u(Object params, Function1<Object, Unit> callback) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            a(this.qqWadlWrapper.n(str), null, callback);
        }
    }

    private final void v(Function1<Object, Unit> callback) {
        a(this.qqWadlWrapper.o(), null, callback);
    }

    private final void w(Function1<Object, Unit> callback) {
        a(this.qqWadlWrapper.p(), null, callback);
    }

    private final void x() {
        this.qqWadlWrapper.q();
    }

    private final int y(Object params) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (!this.qqWadlWrapper.r(str)) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    private final int z() {
        return this.qqWadlWrapper.s() ? 1 : 0;
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2133888880:
                if (method.equals("getQueryDownloadAction")) {
                    p((String) params);
                    return Unit.INSTANCE;
                }
                break;
            case -1909484334:
                if (method.equals("setDualSwitch")) {
                    return Integer.valueOf(E(params));
                }
                break;
            case -1558288064:
                if (method.equals("getMobileDownloadRate")) {
                    return Float.valueOf(o());
                }
                break;
            case -1163315937:
                if (method.equals("openInstallSetting")) {
                    w(callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1115567727:
                if (method.equals("checkMobileFlowAvailable")) {
                    return Boolean.valueOf(q());
                }
                break;
            case -1037975280:
                if (method.equals("unregisterListener")) {
                    G();
                    return Unit.INSTANCE;
                }
                break;
            case -625158317:
                if (method.equals("deleteDownload")) {
                    d(params);
                    return Unit.INSTANCE;
                }
                break;
            case -589241748:
                if (method.equals("updateLastTime")) {
                    return Integer.valueOf(H(params));
                }
                break;
            case -567462327:
                if (method.equals(WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION)) {
                    g((String) params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -396360603:
                if (method.equals("doDualDownloadAction")) {
                    i((String) params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -344781475:
                if (method.equals("queryFloatingPermission")) {
                    return Integer.valueOf(y(params));
                }
                break;
            case 353327032:
                if (method.equals("readModeState")) {
                    return Integer.valueOf(B(params));
                }
                break;
            case 417375076:
                if (method.equals("requestFloatingPermission")) {
                    D((String) params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 560832448:
                if (method.equals("openFloatingSetting")) {
                    u(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 583536676:
                if (method.equals("openHuaWeiPureModeSetting")) {
                    v(callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1102061544:
                if (method.equals("getInstalledAppVersionCode")) {
                    return m(params);
                }
                break;
            case 1115161719:
                if (method.equals("registerListener")) {
                    C();
                    return Unit.INSTANCE;
                }
                break;
            case 1388504633:
                if (method.equals("readLastTime")) {
                    return A(params);
                }
                break;
            case 1394111471:
                if (method.equals(GameCenterAPIJavaScript.SET_AUTO_DUAL_SWITCH)) {
                    return Integer.valueOf(F(params));
                }
                break;
            case 1508329606:
                if (method.equals("queryAllDownloadTask")) {
                    x();
                    return Unit.INSTANCE;
                }
                break;
            case 1586349332:
                if (method.equals("canDualDownload")) {
                    return Integer.valueOf(c());
                }
                break;
            case 1611351750:
                if (method.equals("getDualSwitch")) {
                    return Integer.valueOf(l());
                }
                break;
            case 1859424738:
                if (method.equals("queryInstallPermission")) {
                    return Integer.valueOf(z());
                }
                break;
            case 1922394136:
                if (method.equals("getAvailableBytes")) {
                    return j();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        this.qqWadlWrapper.d();
        this.wadlHostInterface.c();
    }

    public final void r(@NotNull ArrayList<WadlResult> wadlResults) {
        com.tencent.kuikly.core.render.android.d O0;
        Intrinsics.checkNotNullParameter(wadlResults, "wadlResults");
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<WadlResult> it = wadlResults.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(I(it.next()));
            }
            HashMap hashMap = new HashMap();
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "array.toString()");
            hashMap.put("result", jSONArray2);
            com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
            if (aVar != null && (O0 = aVar.O0()) != null) {
                O0.d("onQueryCallback", hashMap);
            }
        } catch (JSONException e16) {
            QLog.e("QQKuiklyWadlModule", 1, "onQueryResult e:", e16);
        }
    }

    public final void t(@NotNull WadlResult wadlResult) {
        com.tencent.kuikly.core.render.android.d O0;
        Intrinsics.checkNotNullParameter(wadlResult, "wadlResult");
        HashMap hashMap = new HashMap();
        hashMap.put("result", I(wadlResult));
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null) {
            O0.d("onWadlTaskStatusChanged", hashMap);
        }
    }
}
