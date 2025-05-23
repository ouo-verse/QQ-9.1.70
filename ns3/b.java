package ns3;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.minigame.api.IArkShareForMiniBoxApi;
import com.tencent.mobileqq.minigame.api.ShareAppInfo;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.util.URLUtil;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J \u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006\u001e"}, d2 = {"Lns3/b;", "", "", QZoneDTLoginReporter.SCHEMA, "c", "Lorg/json/JSONObject;", "arkJson", "", "schemeMap", "f", "d", "e", ZPlanPublishSource.FROM_SCHEME, "i", "encode", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "params", "", "g", PushClientConstants.TAG_PKG_NAME, "originalSchema", "Lcom/tencent/mobileqq/minigame/api/ShareAppInfo;", "shareAppInfo", "Lcom/tencent/mobileqq/mini/share/MiniArkShareModel;", "b", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f421246a = new b();

    b() {
    }

    private final String c(String schema) {
        int indexOf$default;
        String str;
        Map<String, String> argumentsFromURL;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) schema, "mqqapi://hippy/open?", 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return null;
        }
        String substring = schema.substring(indexOf$default + 20 + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        Map<String, String> arguments = URLUtil.getArguments(URLUtil.decodeUrl(substring));
        if (arguments != null) {
            str = arguments.get("url");
        } else {
            str = null;
        }
        if (str == null || (argumentsFromURL = URLUtil.getArgumentsFromURL(URLUtil.decodeUrl(str))) == null) {
            return null;
        }
        return argumentsFromURL.get("gamedata");
    }

    private final String d(JSONObject arkJson, Map<String, String> schemeMap) {
        String str;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (arkJson != null && (optJSONObject = arkJson.optJSONObject(PublicAccountMessageUtilImpl.META_NAME)) != null && (optJSONObject2 = optJSONObject.optJSONObject("shareData")) != null) {
            str = optJSONObject2.optString("desc");
        } else {
            str = null;
        }
        if (str == null) {
            String j3 = j(schemeMap.get("description"));
            if (j3 == null) {
                return "";
            }
            return j3;
        }
        return str;
    }

    private final String e(JSONObject arkJson, Map<String, String> schemeMap) {
        String str;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (arkJson != null && (optJSONObject = arkJson.optJSONObject(PublicAccountMessageUtilImpl.META_NAME)) != null && (optJSONObject2 = optJSONObject.optJSONObject("shareData")) != null) {
            str = optJSONObject2.optString("image");
        } else {
            str = null;
        }
        if (str == null) {
            String j3 = j(schemeMap.get("image_url"));
            if (j3 == null) {
                return "";
            }
            return j3;
        }
        return str;
    }

    private final String f(JSONObject arkJson, Map<String, String> schemeMap) {
        String str;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (arkJson != null && (optJSONObject = arkJson.optJSONObject(PublicAccountMessageUtilImpl.META_NAME)) != null && (optJSONObject2 = optJSONObject.optJSONObject("shareData")) != null) {
            str = optJSONObject2.optString("title");
        } else {
            str = null;
        }
        if (str == null) {
            String j3 = j(schemeMap.get("title"));
            if (j3 == null) {
                return "";
            }
            return j3;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Activity activity, EIPCResult eIPCResult) {
        JSONObject jSONObject;
        MiniArkShareModel miniArkShareModel;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QLog.i("MetaDreamShareIntercept", 1, "handleShare result:" + eIPCResult.code);
        Bundle bundle = eIPCResult.data;
        if (bundle != null) {
            int i3 = bundle.getInt("KEY_SHARE_ARK_SHARE_TYPE");
            String string = bundle.getString("KEY_SHARE_ARK_RET_JSON");
            try {
                if (string != null) {
                    jSONObject = new JSONObject(string);
                } else {
                    jSONObject = new JSONObject();
                }
            } catch (Exception e16) {
                QLog.e("MetaDreamShareIntercept", 1, e16, new Object[0]);
                jSONObject = new JSONObject();
            }
            Serializable serializable = bundle.getSerializable("KEY_SHARE_ARK_PREPARED_MODEL");
            QLog.i("MetaDreamShareIntercept", 1, "shareModel:" + serializable + " ret:" + string + " shareType:" + i3);
            if (serializable instanceof MiniArkShareModel) {
                miniArkShareModel = (MiniArkShareModel) serializable;
            } else {
                miniArkShareModel = null;
            }
            if (miniArkShareModel != null) {
                ((IArkShareForMiniBoxApi) QRoute.api(IArkShareForMiniBoxApi.class)).shareQQArk(activity, (MiniArkShareModel) serializable, jSONObject, i3);
            }
        }
    }

    private final Map<String, String> i(String scheme) {
        List split$default;
        List split$default2;
        HashMap hashMap = new HashMap();
        split$default = StringsKt__StringsKt.split$default((CharSequence) scheme, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Iterator it = split$default2.iterator();
            while (it.hasNext()) {
                String[] split = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER).split((String) it.next(), 2);
                if (split.length == 2) {
                    String str = split[0];
                    Intrinsics.checkNotNullExpressionValue(str, "keyValue[0]");
                    String str2 = split[1];
                    Intrinsics.checkNotNullExpressionValue(str2, "keyValue[1]");
                    hashMap.put(str, str2);
                }
            }
        }
        return hashMap;
    }

    private final String j(String encode) {
        boolean z16;
        if (encode == null || Intrinsics.areEqual("", encode)) {
            return "";
        }
        if (encode.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(encode, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(encode, Base64Util.DEFAULT)");
        return new String(decode, Charsets.UTF_8);
    }

    @Nullable
    public final MiniArkShareModel b(@NotNull String pkgName, @NotNull String originalSchema, @NotNull ShareAppInfo shareAppInfo) {
        String str;
        String str2;
        int indexOf$default;
        String str3;
        boolean contains$default;
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(originalSchema, "originalSchema");
        Intrinsics.checkNotNullParameter(shareAppInfo, "shareAppInfo");
        if (TextUtils.isEmpty(pkgName)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Map<String, String> i3 = i(originalSchema);
        try {
            if (i3.containsKey("share_to_qq_ark_info")) {
                jSONObject = new JSONObject(j(i3.get("share_to_qq_ark_info")));
            }
        } catch (Exception e16) {
            QLog.e("MetaDreamShareIntercept", 1, e16, new Object[0]);
        }
        String e17 = e(jSONObject, i3);
        if (TextUtils.isEmpty(e17)) {
            return null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("shareData")) != null) {
            str = optJSONObject.optString("imageJumpUrl");
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            String c16 = c(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(e17);
            String str5 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) e17, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
            if (contains$default) {
                str5 = ContainerUtils.FIELD_DELIMITER;
            }
            sb5.append(str5);
            e17 = sb5.toString() + "cd_extendInfo=" + c16 + "&gamedata=" + c16;
        }
        String str6 = e17;
        String f16 = f(jSONObject, i3);
        String d16 = d(jSONObject, i3);
        try {
            String deleteParameter = URLUtil.deleteParameter(str6, "cd_extendInfo");
            Intrinsics.checkNotNullExpressionValue(deleteParameter, "deleteParameter(picUrl, GAME_DATA_EXTEND)");
            str3 = URLUtil.deleteParameter(deleteParameter, "gamedata");
            Intrinsics.checkNotNullExpressionValue(str3, "deleteParameter(shortUrl, URL_PARAM_KEY_GAME_DATA)");
            str2 = f16;
        } catch (Exception e18) {
            QLog.e("MetaDreamShareIntercept", 1, "createFromSchema ", e18);
            str2 = f16;
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str6, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
            if (indexOf$default > 0) {
                str3 = str6.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                str3 = str6;
            }
        }
        MiniArkShareModelBuilder versionId = new MiniArkShareModelBuilder().setAppId(shareAppInfo.miniGameAppId).setTitle(str2).setDescription(d16).setShareScene(0).setShareTemplateType(1).setShareBusinessType(shareAppInfo.reportType).setPicUrl(str3).setVidUrl(null).setJumpUrl(str6).setVersionType(shareAppInfo.versionType).setVersionId(shareAppInfo.versionId);
        String str7 = i3.get("url");
        if (str7 != null) {
            str4 = str7;
        }
        return versionId.setWebURL(str4).setShareTarget(0).setWithShareTicket(false).setIconUrl(shareAppInfo.iconUrl).createMiniArkShareModel();
    }

    public final boolean g(@NotNull final Activity activity, @NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        String string = params.getString("minibox_msdk_share_orignal_pkg");
        String string2 = params.getString("minibox_msdk_share_original_schema");
        if (!Intrinsics.areEqual("com.tencent.letsgo", string)) {
            QLog.i("MetaDreamShareIntercept", 1, "handleShare originalPkg:" + string);
            return false;
        }
        if (TextUtils.isEmpty(string2)) {
            return false;
        }
        QLog.d("MetaDreamShareIntercept", 2, "msdkQQShare originalPkg:" + string + " originalSchema:" + string2);
        JSONObject jSONObject = new JSONObject();
        Intrinsics.checkNotNull(string2);
        Map<String, String> i3 = i(string2);
        try {
            if (i3.containsKey("share_to_qq_ark_info")) {
                jSONObject = new JSONObject(j(i3.get("share_to_qq_ark_info")));
            }
        } catch (Exception e16) {
            QLog.e("MetaDreamShareIntercept", 1, e16, new Object[0]);
        }
        if (TextUtils.isEmpty(e(jSONObject, i3))) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KEY_SHARE_ARK_ORIGIN_SCHEMA", string2);
        bundle.putString("KEY_SHARE_ARK_ORIGIN_PKG", string);
        QIPCClientHelper.getInstance().callServer("minibox_qipc_module", "CLIENT_ACTION_SHARE_ARK", bundle, new EIPCResultCallback() { // from class: ns3.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                b.h(activity, eIPCResult);
            }
        });
        return true;
    }
}
