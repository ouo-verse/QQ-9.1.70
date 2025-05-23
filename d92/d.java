package d92;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J2\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0003J\u001a\u0010\r\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0003J\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0003J\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0003\u00a8\u0006\u0012"}, d2 = {"Ld92/d;", "", "", "appId", "extInfo", "extendData", "firstPath", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "a", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "", "b", "extraParam", "c", "d", "e", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f393226a = new d();

    d() {
    }

    @JvmStatic
    private static final void c(String extraParam, OpenHippyInfo hippyInfo) {
        if (extraParam == null || extraParam.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(extraParam);
            hippyInfo.from = jSONObject.optString("from");
            hippyInfo.isStatusBarDarkFont = jSONObject.optBoolean(OpenHippyInfo.EXTRA_KEY_IS_STATUSBAR_DARKFONT);
            hippyInfo.updateJsBundleType = jSONObject.optInt(OpenHippyInfo.EXTRA_KEY_UPDATE_JS_BUNDLE_TYPE);
            hippyInfo.ssrBundleUrl = jSONObject.optString("ssrBundleUrl");
            hippyInfo.ssrBundleData = jSONObject.optString("ssrBundleData");
            hippyInfo.minJsBundleVersion = jSONObject.optInt(OpenHippyInfo.EXTRA_KEY_MIN_JS_BUNDLE_VERSION);
            hippyInfo.minSSRCommonVersion = jSONObject.optInt(OpenHippyInfo.EXTRA_KEY_MIN_SSR_COMMON_VERSION);
        } catch (Exception e16) {
            QLog.e("MiniHippyParam", 1, "parseExtParam: failed.", e16);
        }
    }

    @JvmStatic
    public static final OpenHippyInfo a(String appId, String extInfo, String extendData, String firstPath) {
        if (extInfo == null || extInfo.length() == 0) {
            if (extendData == null || extendData.length() == 0) {
                QLog.e("MiniHippyParam", 1, "extInfo and extendData is null. appInfo=" + appId + " extInfo:" + extInfo + " extendData:" + extendData + " firstPath:" + firstPath);
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniHippyParam", 2, "extInfo=" + extInfo + ", extendData=" + extendData);
        }
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        b(extInfo, openHippyInfo);
        d(extendData, openHippyInfo);
        e(firstPath, openHippyInfo);
        return openHippyInfo;
    }

    @JvmStatic
    private static final void b(String extInfo, OpenHippyInfo hippyInfo) {
        if (extInfo == null || extInfo.length() == 0) {
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(extInfo).optJSONArray(ThirdPartyMiniApiImpl.KEY_MAP_INFO);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("key");
                        String optString2 = optJSONObject.optString("value");
                        if (optString != null) {
                            switch (optString.hashCode()) {
                                case -1042857336:
                                    if (optString.equals(ThirdPartyMiniPageProxy.KEY_HIPPY_URL)) {
                                        hippyInfo.url = optString2;
                                        break;
                                    } else {
                                        break;
                                    }
                                case -245169112:
                                    if (optString.equals("bundle_name")) {
                                        hippyInfo.bundleName = optString2;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1400967889:
                                    if (optString.equals("game_extra_param")) {
                                        c(optString2, hippyInfo);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1541182731:
                                    if (optString.equals(ThirdPartyMiniPageProxy.KEY_HIPPY_DOMAIN)) {
                                        hippyInfo.domain = optString2;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("MiniHippyParam", 1, "openHippyInfo: failed.", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:10:0x0011, B:12:0x002d, B:17:0x0039, B:19:0x003d, B:24:0x0049, B:26:0x004d, B:29:0x0056), top: B:9:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049 A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:10:0x0011, B:12:0x002d, B:17:0x0039, B:19:0x003d, B:24:0x0049, B:26:0x004d, B:29:0x0056), top: B:9:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d A[Catch: Exception -> 0x0059, TryCatch #0 {Exception -> 0x0059, blocks: (B:10:0x0011, B:12:0x002d, B:17:0x0039, B:19:0x003d, B:24:0x0049, B:26:0x004d, B:29:0x0056), top: B:9:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056 A[Catch: Exception -> 0x0059, TRY_LEAVE, TryCatch #0 {Exception -> 0x0059, blocks: (B:10:0x0011, B:12:0x002d, B:17:0x0039, B:19:0x003d, B:24:0x0049, B:26:0x004d, B:29:0x0056), top: B:9:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void d(String extendData, OpenHippyInfo hippyInfo) {
        boolean z16;
        boolean z17;
        if (extendData == null || extendData.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(extendData);
            String optString = jSONObject.optString("bundleName");
            String optString2 = jSONObject.optString("url");
            String optString3 = jSONObject.optString("domain");
            if (optString != null && optString.length() != 0) {
                z16 = false;
                if (!z16) {
                    hippyInfo.bundleName = optString;
                }
                if (optString2 != null && optString2.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        hippyInfo.url = optString2;
                    }
                    if (optString3 != null || optString3.length() == 0) {
                        hippyInfo.domain = optString3;
                        return;
                    }
                    return;
                }
                z17 = true;
                if (!z17) {
                }
                if (optString3 != null || optString3.length() == 0) {
                }
            }
            z16 = true;
            if (!z16) {
            }
            if (optString2 != null) {
                z17 = false;
                if (!z17) {
                }
                if (optString3 != null || optString3.length() == 0) {
                }
            }
            z17 = true;
            if (!z17) {
            }
            if (optString3 != null || optString3.length() == 0) {
            }
        } catch (Exception e16) {
            QLog.e("MiniHippyParam", 1, "parseExtendData: failed, extendData=" + extendData, e16);
        }
    }

    @JvmStatic
    private static final void e(String firstPath, OpenHippyInfo hippyInfo) {
        boolean contains$default;
        String str;
        boolean z16 = true;
        if (firstPath == null || firstPath.length() == 0) {
            return;
        }
        String str2 = hippyInfo.url;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        String str3 = hippyInfo.url;
        Intrinsics.checkNotNullExpressionValue(str3, "hippyInfo.url");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str = ContainerUtils.FIELD_DELIMITER + firstPath;
        } else {
            str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + firstPath;
        }
        hippyInfo.url = str3 + str;
    }
}
